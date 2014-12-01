package net.anei.cadpage.parsers.dispatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.ReverseCodeSet;


public class DispatchA14Parser extends FieldProgramParser {

  private static final Pattern MARKER = Pattern.compile("(.*?)\\*{3,}([^\\*]+)\\*{3,}(.*)", Pattern.DOTALL);
  private static final Pattern MISSING_BLANK_PTN = Pattern.compile("([^ \\*])(CS:|ADTML:|CODE:|TOA:|TYPE:|LOC:|CROSS:|CODE:|TIME:)");
  private static final Pattern TIME_MARK_PTN = Pattern.compile(" TIME:\\d\\d:\\d\\d:\\d\\d$");
  private static final String[] PART2_KEYWORDS = new String[]{" TIME:", " CODE:", " CROSS:"};
  private static final Pattern ID_PTN = Pattern.compile("^(\\d{4}-\\d{6}) ");
  
  private ReverseCodeSet sourceSet;
  private ReverseCodeSet citySet = null;
  
  public DispatchA14Parser(String defCity, String defState) {
    this(null, null, defCity, defState);
  }
  
  public DispatchA14Parser(Properties cityCodes, ReverseCodeSet sourceSet, String defCity, String defState) {
    super(cityCodes, defCity, defState,
          "ADDR1! CS:X? ADTML:CODE? TOA:TIMEDATE TYPE:INFO LOC:ADDR2/S CROSS:X2 CODE:CODE TIME:TIME");
    this.sourceSet = sourceSet;
    
    // Build reverse code set with all of the full length city name values
    if (cityCodes != null) {
      citySet = new ReverseCodeSet();
      List<String> cityList = new ArrayList<String>();
      for (Object city : cityCodes.values()) cityList.add((String)city);
      citySet = new ReverseCodeSet(cityList.toArray(new String[cityList.size()]));
    }
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Rule out the similar NYNassauCountyA format
    if (body.contains(" c/s:")) return false;
    
    Matcher match = ID_PTN.matcher(body);
    if (match.find()) {
      data.strCallId = match.group(1);
      body = body.substring(match.end()).trim();
    }
    
    // Call description is in front of text bracketed by three asterisks
    match = MARKER.matcher(body);
    if (!match.matches()) return false;
    data.strCall = append(match.group(1).trim(), " - ", match.group(2).trim());
    body = match.group(3).trim();

    // Fill in missing blanks in front of known keywords
    body = MISSING_BLANK_PTN.matcher(body).replaceAll("$1 $2");
    
    // Some, but not all, calls contain two basically duplicated sets of 
    // information, The first part of the message contains a compressed
    // version taht has almost everything.  The second following part contains
    // a more detailed description of what was included in the first part.
    // The second part is more reliable and should be used when present.  But
    // some or all of it's data may be truncated because of SMS message limits.
    
    // So, the first thing we do is confirm that the second part is present
    // and remove any field that looks like it may be truncated
    int pt2 = body.indexOf(" LOC:");
    if (pt2 >= 0) {
      match = TIME_MARK_PTN.matcher(body);
      if (!match.find()) {
        for (String keyword : PART2_KEYWORDS) {
          int tmp = body.lastIndexOf(keyword);
          if (tmp >= 0) {
            pt2 = tmp;
            break;
          }
        }
        body = body.substring(0,pt2).trim();
      }
    }

    if (! super.parseMsg(body, data)) return false;
    return (data.strCross.length() > 0 || data.strTime.length() > 0);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR1")) return new MyAddressField1();
    if (name.equals("TIMEDATE")) return new MyTimeDateField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("ADDR2")) return new MyAddressField2();
    if (name.equals("X2")) return new MyCrossField2();
    return super.getField(name);
  }
    
  private static final Pattern PLACE_ADDR_PTN = Pattern.compile("(.*)[;\\*](.*)");
  private class MyAddressField1 extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      // See if we have a trailing place name
      StartType st = StartType.START_PLACE;
      int pt = field.indexOf('@');
      if (pt >= 0) {
        st = StartType.START_ADDR;
        data.strPlace = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
        field = stripFieldEnd(field, ":");
      }
      
      // If we have a city set, use it to strip a full city name from the
      // end of the field
      if (citySet != null) {
        String city = citySet.getCode(field);
        if (city != null) {
          data.strCity = city;
          field = field.substring(0,field.length()-city.length());
        }
      }
      
      // There are a couple different ways to split up the name and place
      // fields.  Look for the last     semicolon or asterisk
      if (st == StartType.START_PLACE){
        Matcher match = PLACE_ADDR_PTN.matcher(field);
        if (match.matches()) {
          st = StartType.START_ADDR;
          data.strPlace = match.group(1).trim();;
          field = match.group(2).trim();
        }
      }
      
      // And sometimes a place name is in parens
      if (field.startsWith("(")) {
        pt = field.lastIndexOf(')');
        if (pt > 0) {
          data.strPlace = append(data.strPlace, " ", field.substring(0,pt+1));
          field = field.substring(pt+1).trim();
        }
      }
      parseAddress(st, FLAG_START_FLD_NO_DELIM | FLAG_RECHECK_APT | FLAG_ANCHOR_END | FLAG_NO_CITY, field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY PLACE";
    }
  }

  private static final Pattern TIME_DATE = Pattern.compile("^(\\d\\d:\\d\\d)(?: (\\d\\d[-/]\\d\\d[-/]\\d\\d))?");
  private static final Pattern ANGLE_BKT_PTN = Pattern.compile("<[^<>]*>");
  private static final Pattern ID_PTN2 = Pattern.compile("20\\d{2}-\\d{6}(?=$|[^\\d])");
  private static final Pattern ID_PTN3 = Pattern.compile("(?<=^|[^\\d])(?:\\d{4}-\\d*|20\\d{0,2})$");
  private static final Pattern CODE_PTN = Pattern.compile("\\d{1,2}-[A-Z]-\\d{1,2}[A-Z]?");
  private class MyTimeDateField extends InfoField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = TIME_DATE.matcher(field);
      if (!match.find()) return;
      data.strTime = match.group(1);
      data.strDate = getOptGroup(match.group(2)).replaceAll("-", "/");
      field = field.substring(match.end()).trim();
      field = ANGLE_BKT_PTN.matcher(field).replaceAll("").trim();
      String extra = "";
      match = ID_PTN2.matcher(field);
      if (match.find()) {
        data.strCallId = match.group();
        extra = field.substring(match.end()).trim();
        field = field.substring(0,match.start()).trim();
      } else {
        match = ID_PTN3.matcher(field);
        if (match.find()) field = field.substring(0,match.start()).trim();
      }
      if (sourceSet != null) {
        String src = sourceSet.getCode(field);
        if (src != null) {
          data.strSource = src;
          field = field.substring(0,field.length()-src.length()).trim();
        }
      }
      if (CODE_PTN.matcher(field).matches()) {
        data.strCode = field;
        field = "";
      }
      field = append(field, " / ", extra);
      field = field.trim().replaceAll("  +", " ");
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "TIME DATE CODE SRC ID INFO";
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (data.strCall.length() <= 2) {
        data.strCall = append(data.strCall, " - ", field);
      } else {
        data.strSupp = field;
      }
    }
  }
  
  @Override
  public String getProgram() {
    return "ID CALL " + super.getProgram();
  }
  
  private class MyAddressField2 extends AddressField {
    @Override
    public void parse(String field, Data data) {
      data.strAddress = data.strApt = "";
      int pt = field.indexOf('@');
      if (pt >= 0) {
        data.strPlace = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
        field = stripFieldEnd(field, ":");
      }
      super.parse(field, data);
    }
  }
  
  private class MyCrossField2 extends CrossField {
    @Override
    public void parse(String field, Data data) {
      data.strCross = "";
      super.parse(field, data);
    }
  }
}


