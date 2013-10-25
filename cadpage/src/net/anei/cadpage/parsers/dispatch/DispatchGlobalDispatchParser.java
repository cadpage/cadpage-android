package net.anei.cadpage.parsers.dispatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchGlobalDispatchParser extends FieldProgramParser {
  
  // Station and unit codes lead the call/address field
  public static final int LEAD_SRC_UNIT_ADDR = 1;
  
  // Station and unit codes follow the call/address field
  public static final int TRAIL_SRC_UNIT_ADDR = 2;
  
  // Call description follows the address
  public static final int CALL_FOLLOWS_ADDR = 4;
  
  // Place name occurs between address and city name
  public static final int PLACE_FOLLOWS_ADDR = 8;
  
  private static final Pattern CALL_NUMBER_PTN = Pattern.compile("^Call Number: *(\\d+) +");
  private static final Pattern KEYWORD_PTN = Pattern.compile("(?:MapRegions|Description|CrossStreets|Description|Dispatch|Primary_Incident|):");
  private static final Pattern DELIM_PTN = Pattern.compile("\n| (?=CrossStreets:|Dispatch:)");
  
  private Pattern stationPtn;
  private Pattern unitPtn;
  private boolean leadStuff;
  private boolean trailStuff;
  
  private String select;
  
  public DispatchGlobalDispatchParser(String defCity, String defState) {
    this(null, defCity, defState, 0, null, null);
  }
  
  public DispatchGlobalDispatchParser(String[] cityList, String defCity, String defState) {
    this(cityList, defCity, defState, 0, null, null);
  }
  
  public DispatchGlobalDispatchParser(String defCity, String defState, int flags) {
    this(null, defCity, defState, flags, null, null);
  }
  
  public DispatchGlobalDispatchParser(String[] cityList, String defCity, String defState, int flags) {
    this(cityList, defCity, defState, flags, null, null);
  }
  
  public DispatchGlobalDispatchParser(String[] cityList, String defCity, String defState,
                                       int flags, Pattern stationPtn, Pattern unitPtn) {
    super(cityList, defCity, defState,
          calcAddressTerm(flags, cityList != null) +
          " Call_Received_Time:DATE_TIME_CITY MapRegions:MAP Description:INFO INFO+ CrossStreets:X PLACE Description:INFO INFO+ Dispatch:DATETIME Primary_Incident:ID Call_Number:ID Description:INFO INFO+ ReferenceText:INFO Dispatch:SKIP");
    this.stationPtn = stationPtn;
    this.unitPtn = unitPtn;
    leadStuff = (flags & LEAD_SRC_UNIT_ADDR) != 0;
    trailStuff = (flags & TRAIL_SRC_UNIT_ADDR) != 0;
  }
  
  private static final String calcAddressTerm(int flags, boolean inclCity) {
    StringBuilder sb = new StringBuilder("( SELECT/NEW ");
    if ((flags & LEAD_SRC_UNIT_ADDR) != 0) sb.append("UNIT ");
    if ((flags & CALL_FOLLOWS_ADDR) == 0) sb.append("CALL! ");
    sb.append("ADDR! ");
    if (inclCity) sb.append("CITY? ");
    if ((flags & CALL_FOLLOWS_ADDR) != 0) sb.append("( CALL! Primary_Incident:ID! | PLACE CALL! ) ");
    if ((flags & TRAIL_SRC_UNIT_ADDR) != 0) sb.append("UNIT ");
    sb.append(" | ADDR2/S");
    sb.append((flags & CALL_FOLLOWS_ADDR) != 0 ? "XC" : "CX");
    if ((flags & PLACE_FOLLOWS_ADDR) != 0) sb.append('P');
    sb.append("! )");
    return sb.toString();
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = CALL_NUMBER_PTN.matcher(body);
    if (match.find()) {
      data.strCallId = match.group(1);
      body = body.substring(match.end());
    }
    
    // See if this is the new fangled line break separated format
    // Beware of false positives, occasionally an old format will
    // have enough newlines to trigger the old logic
    match = KEYWORD_PTN.matcher(body);
    int pt = (match.find() ? match.start() : body.length());
    if (body.substring(0,pt).contains("\n")) {
      select = "NEW";
      if (!parseFields(DELIM_PTN.split(body), data)) return false;
      if (data.strMap.length() > 0 || data.strSupp.length() > 0 || 
          data.strCross.length() > 0 || data.strTime.length() > 0) return true;
      
      // Still questionable.  If there is a unit field and pattern, see if
      // they match
      if (data.strUnit.length() > 0 && unitPtn != null) {
        boolean good = true;
        for (String unit : data.strUnit.split(" +")) {
          if (!unitPtn.matcher(unit).matches()) {
            good = false;
            break;
          }
        }
        if (good) return true;
      }
      return false;
    }
    
    // Otherwise use the standard line break format
    select = "OLD";
    if (! super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) return false;
    if (data.strCity.length() == 0 && data.strUnit.length() == 0 && data.strCross.length() == 0 && !body.contains(" Description:")) return false;
    return true;
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  
  @Override
  protected String getSelectValue() {
    return select;
  }

  protected class BaseAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      field = field.replaceAll(",", "");
      super.parse(field, data);
    }
  }


  protected class BaseAddress2Field extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      field = field.replaceAll(",", "");
      
      // If we have station or unit patterns, these need to be stripped off 
      // the front and back of the address field
      if (leadStuff || trailStuff) {
        
        // Start by splitting field into list of words, and identifying
        // each word as station, unit or neither
        String[] words = field.split(" +");
        int[] types = new int[words.length];
        int stReg = 0;
        if (leadStuff) {
          for (stReg = 0; stReg<words.length; stReg++) {
            String word = words[stReg];
            types[stReg] = (stationPtn != null && stationPtn.matcher(word).matches() ? 1 :
                            unitPtn != null && unitPtn.matcher(word).matches() ? 2 : 0);
            if (types[stReg] == 0) break;
          }
        }
        int endReg = words.length-1;
        if (stReg < words.length) {
          if (trailStuff) {
            for ( ; endReg > stReg; endReg--) {
              String word = words[endReg];
              types[endReg] = (stationPtn != null && stationPtn.matcher(word).matches() ? 1 :
                              unitPtn != null && unitPtn.matcher(word).matches() ? 2 : 0);
              if (types[endReg] == 0) break;
            }
          }
          for (int ii = stReg+1; ii < endReg; ii++) types[ii] = 0;
        }
        
        // Construct three Stringbuilders with all of the regular, station, and unit words
        StringBuilder[] sba = new StringBuilder[3];
        for (int ii = 0; ii < 3; ii++) sba[ii] = new StringBuilder();
        for (int ii = 0; ii<words.length; ii++) {
          StringBuilder sb = sba[types[ii]];
          if (sb.length() > 0) sb.append(' ');
          sb.append(words[ii]);
        }
        
        // And finally convert the StringBuilders back to the appropriate fields
        field = sba[0].toString();
        data.strSource = sba[1].toString();
        data.strUnit = sba[2].toString();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "SRC UNIT " + super.getFieldNames();
    }
  }
  
  private class BaseDateTimeCityField extends Field {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strDate = p.get(' ');
      data.strTime = p.get(' ');
      data.strCity = p.get();
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME CITY";
    }
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\[(\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d) \\d+\\]");
  protected class BaseInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (match.find()) {
        data.strDate = match.group(1);
        data.strTime = match.group(2);
        field = match.replaceAll(" / ").trim();
        if (field.startsWith("/ ")) field = field.substring(2).trim(); 
      }
      field = field.replaceAll("\\s{2,}", " ");
      data.strSupp = append(data.strSupp, ". ", field);
    }
  }

  private class BaseIdField extends IdField {
    @Override
    public void parse(String field, Data data) {
      data.strCallId = append(data.strCallId, "/", field);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new BaseAddressField();
    if (name.equals("ADDR2")) return new BaseAddress2Field();
    if (name.equals("DATE_TIME_CITY")) return new BaseDateTimeCityField();
    if (name.equals("INFO")) return new BaseInfoField();
    if (name.equals("ID")) return new BaseIdField();
    return super.getField(name);
  }
}
