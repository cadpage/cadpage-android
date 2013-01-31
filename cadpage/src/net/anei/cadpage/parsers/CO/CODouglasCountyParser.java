package net.anei.cadpage.parsers.CO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class CODouglasCountyParser extends FieldProgramParser {
  
  private static final Pattern TRAIL_ID_PTN = Pattern.compile(" +(\\d{4}-\\d{8})$");
  private static final Pattern MISSING_BLANK_PTN = Pattern.compile("(?<! )(?=Time:)");

  public CODouglasCountyParser() {
    this("DOUGLAS COUNTY", "CO");
  }
  
  protected CODouglasCountyParser(String defCity, String defState) {
    super(CITY_LIST, defCity, defState,
           "( Call:CALL! Location:ADDRCH! Map:MAP Units:UNIT! Common_Name:PLACE Time:DATETIME Narrative:INFO? Nature_Of_Call:INFO | " +
              "Call_Type:CALLID! Common_Name:PLACE! Location:ADDR/SXXx! Call_Time:DATETIME! Narrative:INFO Nature_Of_Call:INFO )");
  }
  
  @Override
  public String getAliasCode() {
    return "CODouglasCounty";
  }
  
  @Override
  public String getFilter() {
    return "@notifyall.com,@notifyatonce.com,dcso@douglas.co.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Dispatch")) return false;
    Matcher match = TRAIL_ID_PTN.matcher(body);
    if (match.find()) {
      data.strCallId = match.group(1);
      body = body.substring(0,match.start());
    }
    body = MISSING_BLANK_PTN.matcher(body).replaceAll(" ");
    if (!super.parseMsg(body, data)) return false;
    
    if (data.strCross.equals("No Cross Streets Found")) data.strCross = "";
    
    // Intersections are (sometimes) saved as cross roads :(
    if (data.strAddress.length() == 0 && data.strCross.length() > 0) {
      for (String addr : data.strCross.split(",")) {
        if (addr.contains("/")) {
          parseAddress(addr.trim(), data);
          break;
        }
      }
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " ID";
  }
  
  // Address field should strip  trailing slash characters
  // and a trailing operations channel
  private static final Pattern OPS_PTN = Pattern.compile("\\bEOPS\\d$");
  private class MyAddressChannelField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Matcher match = OPS_PTN.matcher(field);
      if (match.find()) {
        data.strChannel = match.group();
        field = field.substring(0,match.start()).trim();
      }
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CH";
    }
  }
  
  // Unit field also contains cross field
  private class MyUnitField extends UnitField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      super.parse(p.get("  "), data);
      data.strCross = p.get();
      if (data.strCross.length() == 0 && 
          (data.strUnit.equals("No Cross Streets Found") || data.strUnit.contains("/"))) {
        data.strCross = data.strUnit;
        data.strUnit = "";
      }
    }
    
    @Override
    public String getFieldNames() {
      return "UNIT X";
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(data.strAddress)) {
        field = field.substring(0,field.length()-data.strAddress.length()).trim();
      }
      super.parse(field, data);
    }
  }
  
  private class MyDateTimeField extends DateTimeField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 14) super.parse(field, data);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("E911 Info - ", "");
      if (data.strChannel.length() > 0 && field.startsWith(data.strChannel)) {
        field = field.substring(data.strChannel.length()).trim();
      }
      super.parse(field, data);
    }
  }
  
  private class MyCallIdField extends CallField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = TRAIL_ID_PTN.matcher(field);
      if (!match.find()) abort();
      data.strCall = field.substring(0,match.start());
      data.strCallId = match.group(1);
    }
  }
  
  
  @Override
  public Field getField(String  name) {
    if (name.equals("ADDRCH")) return new MyAddressChannelField();
    if (name.equals("UNIT")) return new MyUnitField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("CALLID")) return new MyCallIdField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Douglas County
    "AURORA",
    "CASTLE PINES NORTH",
    "CASTLE ROCK",
    "LARKSPUR",
    "LITTLETON",
    "LONE TREE",
    "PARKER",
    "ACRES GREEN",
    "CARRIAGE CLUB",
    "CASTLE PINES",
    "COTTONWOOD",
    "FRANKTOWN",
    "GRAND VIEW ESTATES",
    "HERITAGE HILLS",
    "HIGHLANDS RANCH",
    "LOUVIERS",
    "MERIDIAN",
    "PERRY PARK",
    "ROXBOROUGH PARK",
    "SEDALIA",
    "STONEGATE",
    "THE PINERY",
    "WESTCREEK",
    "CASTLE PINES VILLAGE",
    "DAKAN",
    "DECKERS",
    "GREENLAND",

    
    // Elbert County
    "AGATE",
    "ELIZABETH",
    "ELBERT",
    "FONDIS",
    "KIOWA",
    "MATHESON",
    "PONDEROSA PARK",
    "SIMLA",
    "ACRES GREEN",
    "CARRIAGE CLUB",
    "CASTLE PINES",
    "COTTONWOOD",
    "FRANKTOWN",
    "GRAND VIEW ESTATES",
    "HERITAGE HILLS",
    "HIGHLANDS RANCH",
    "LOUVIERS",
    "MERIDIAN",
    "PERRY PARK",
    "ROXBOROUGH PARK",
    "SEDALIA",
    "STONEGATE",
    "THE PINERY",
    "WESTCREEK",
    "CASTLE PINES VILLAGE",
    "DAKAN",
    "DECKERS",
    "GREENLAND"
  };
}
