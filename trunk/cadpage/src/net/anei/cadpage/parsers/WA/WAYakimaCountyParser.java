package net.anei.cadpage.parsers.WA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Yakima County, WA
Contact: Ken Shipman <ken.shipman@ycfd5.org>
Sender: wwantla@ci.yakima.wa.us
System: Spillman

08.22.10 02/07/12 EMR RED 505 MADISON AVE; GARFIELD SCHOOL TPFD TP1 YM06 TP0 UNK TYPE OF INJ  / OUTSIDE IN PLAYGROUND / 8 YR BOY - NURSE ON SCENE RP TOLD TO CALL - NOT ON SCENE MAIN PLAYGROUND - WILL MEET UNITS TO DIRECT
13.25.55 02/08/12 EMR MEDIC 904 POWELL ST GVFD GV1 GV0 PR12 POSS INJURY FROM A FALL
11.51.01 02/08/12 EMR MEDIC 330 NORTH ST;BLUE SKY MARKET MBFD MB1 MB0 PR12 SYNCOPE 65 YOF PER RP PT
10.33.11 02/08/12 EMR MEDIC 1580 N OLDENWAY RD LVFD LV6 LV06 YM01 ASSAULT TRIBAL PD ADV SCENE SECURE
13.25.55 02/08/12 EMR MEDIC 904 POWELL ST GVFD GV1 GV1 GV2 GV0 POSS INJURY FROM A FALL   GV1 CANCELLED ALL UNITS
11.39.20 02/08/12 ACCIDENT INJURY S 14TH ST & E MEAD AVE UGFD UG1 E85 ALS3 MVA KIA SOPHIA/ GRY OLDER DODG RAM LE150 RED/ONG blocking eb lanes
16.10.16 02/06/12 ACCIDENT INJURY W 5TH AVE & S BEECH ST TPFD TP1 YM06 YM08 TP0 RP ADV HE IS NOT INJ-FEM DRIVER OF OTHER VEH SEEMS TO HAVE NEVK/BACK PAIN BURGANDY TOYO CAMRY

*/


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
