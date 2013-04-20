package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchGlobalDispatchParser;



public class MOPolkCountyParser extends DispatchGlobalDispatchParser {
  
  private static final Pattern UNIT_PTN = Pattern.compile("M\\d+|MSHP\\d|\\d{3}");
  private static final Pattern MAP_PTN = Pattern.compile("/ *(\\d{1,2}-[A-Z]-\\d{1,2})$");
  private static final Pattern CITY_PTN = Pattern.compile("[A-Z ]+", Pattern.CASE_INSENSITIVE);
  
  public MOPolkCountyParser() {
    super(CITY_TABLE, "POLK COUNTY", "MO", CALL_FOLLOWS_ADDR | TRAIL_SRC_UNIT_ADDR, null, UNIT_PTN);
  }
  
  @Override
  public String getFilter() {
    return "911paging@polkco911.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    body = body.replace(" Disp:", " Dispatch:");
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equals("POLK COUNTY")) data.strCity = "";
    Matcher match = MAP_PTN.matcher(data.strCall);
    if (match.find()) {
      data.strCode = match.group(1);
      data.strCall = data.strCall.substring(0,match.start()).trim();
    }
    if (CITY_PTN.matcher(data.strMap).matches()) {
      data.strCity = data.strMap;
      data.strMap = "";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace(" CALL ", " CALL CODE ");
  }
  
  private static final String[] CITY_TABLE = new String[]{
    "ALDRICH",
    "BOLIVAR",
    "BRIGHTON",
    "DUNNEGAN",
    "EUDORA",
    "FAIR PLAY",
    "FLEMINGTON",
    "GOODSON",
    "GOODNIGHT",
    "HALFWAY",
    "HUMANSVILLE",
    "MORRISVILLE",
    "PLEASANT HOPE",
    "POLK",
    "TIN TOWN",
    
    "POLK COUNTY"
  };
}
