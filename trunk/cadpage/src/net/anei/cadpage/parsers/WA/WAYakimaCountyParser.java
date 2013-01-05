package net.anei.cadpage.parsers.WA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class WAYakimaCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = 
    Pattern.compile("(\\d\\d\\.\\d\\d\\.\\d\\d) (\\d\\d/\\d\\d/\\d\\d) (.*?) ([A-Z]{2}FD)((?: [A-Z]+\\d+)+)( +.*)?");
  
  public WAYakimaCountyParser() {
    super("YAKIMA COUNTY", "WA");
    setup();
  }
  
  @Override
  public String getFilter() {
    return "wwantla@ci.yakima.wa.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strTime = match.group(1).replace('.', ':');
    data.strDate = match.group(2);
    String sAddr = match.group(3).trim();
    data.strSource = match.group(4);
    data.strUnit = match.group(5).trim();
    data.strSupp = getOptGroup(match.group(6));
    
    // Address section consists of a call, address, and possible semicolon separated place
    int pt = sAddr.lastIndexOf(';');
    if (pt >= 0) {
      data.strPlace = sAddr.substring(pt+1).trim();
      sAddr = sAddr.substring(0,pt).trim();
    }
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, sAddr, data);
    return true;
  }

  private void setup() {
    setupCallList(
      "ACCIDENT HITRUN",
      "ACCIDENT INJURY",
      "ACCIDENT NO INJ",
      "EMR ALARM MED",
      "EMR AMB",
      "EMR IFT",
      "EMR MEDIC",
      "EMR NURSE",
      "EMR RED",
      "EMR YELLOW",
      "FIRE O2QLTY",
      "FIRE AIR HEAVY",
      "FIRE AIR LIGHT",
      "FIRE AIR STANDB",
      "FIRE ALARM RES",
      "FIRE ALARM 2",
      "FIRE AUTO ALARM",
      "FIRE BRUSH GRAS",
      "FIRE CHIMNEY",
      "FIRE EWR",
      "FIRE FW",
      "FIRE HAYSTACK",
      "FIRE HAZMAT",
      "FIRE INVEST",
      "FIRE OTHER",
      "FIRE POWER PROB",
      "FIRE RESCUE",
      "FIRE SRVC CALL",
      "FIRE STRUC COMM",
      "FIRE STRUCTURE",
      "FIRE TRASH GARB",
      "FIRE VEHICLE"
    );
  }
}
