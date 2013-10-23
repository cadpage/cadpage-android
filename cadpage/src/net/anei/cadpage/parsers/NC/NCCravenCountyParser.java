package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;
/**
 * Craven County, NC
 */
public class NCCravenCountyParser extends FieldProgramParser {
  
  public NCCravenCountyParser() {
    super(CITY_LIST, "CRAVEN COUNTY", "NC", 
          "Location:ADDR/S6XC! Call_Time:DATETIME! Narrative:INFO!");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@cravencountync.gov";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CC911")) return false;
    if (!super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) {
      data.strCall = data.strAddress;
      data.strAddress = "";
    }
    return true;
  }
  
  private static final Pattern INFO_GPS_PTN = Pattern.compile("\\s*(?:E911 Info .*)?(?:(3[45]\\.\\d{4,} +-7[67]\\.\\d{4,})|-361 +-361)$");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_GPS_PTN.matcher(field);
      if (match.find()) {
        setGPSLoc(getOptGroup(match.group(1)), data);
        field = field.substring(0,match.start());
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO GPS";
    }
  }
  
  
  @Override
  public Field getField(String name) {
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BRICES CREEK",
    "BRIDGETON",
    "COVE CITY",
    "DOVER",
    "FAIRFIELD HARBOUR",
    "HAVELOCK",
    "JAMES CITY",
    "NEUSE FOREST",
    "NEW BERN",
    "RIVER BEND",
    "TRENT WOODS",
    "VANCEBORO",
    "EMUL",
    "HARLOWE",
    "CHERRY POINT",
    "CHERRY BRANCH",
    "ADAMS CREEK",
    "FORT BARNWELL"
  };

}
