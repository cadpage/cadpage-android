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
  
  private Pattern stationPtn;
  private Pattern unitPtn;
  private boolean leadStuff;
  private boolean trailStuff;
  
  public DispatchGlobalDispatchParser(String[] cityList, String defCity, String defState) {
    this(cityList, defCity, defState, 0, null, null);
  }
  
  public DispatchGlobalDispatchParser(String[] cityList, String defCity, String defState, int flags) {
    this(cityList, defCity, defState, flags, null, null);
  }
  
  public DispatchGlobalDispatchParser(String[] cityList, String defCity, String defState,
                                       int flags, Pattern stationPtn, Pattern unitPtn) {
    super(cityList, defCity, defState,
          calcAddressTerm(flags) +
          " MapRegions:MAP Description:INFO CrossStreets:X Description:INFO Dispatch:DATETIME Dispatch:SKIP");
    this.stationPtn = stationPtn;
    this.unitPtn = unitPtn;
    leadStuff = (flags & LEAD_SRC_UNIT_ADDR) != 0;
    trailStuff = (flags & TRAIL_SRC_UNIT_ADDR) != 0;
  }
  
  private static final String calcAddressTerm(int flags) {
    StringBuilder sb = new StringBuilder("ADDR/S");
    sb.append((flags & CALL_FOLLOWS_ADDR) != 0 ? "XC" : "CX");
    if ((flags & PLACE_FOLLOWS_ADDR) != 0) sb.append('P');
    sb.append('!');
    return sb.toString();
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = CALL_NUMBER_PTN.matcher(body);
    if (match.find()) {
      data.strCallId = match.group(1);
      body = body.substring(match.end());
    }
    if (! super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) return false;
    if (data.strCity.length() == 0 && data.strUnit.length() == 0 && data.strCross.length() == 0 && !body.contains(" Description:")) return false;
    return true;
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  protected class BaseAddressField extends AddressField {
    
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
      super.parse(field, data);
    }
  }
  
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new BaseInfoField();
    if (name.equals("ADDR")) return new BaseAddressField();
    return super.getField(name);
  }
}
