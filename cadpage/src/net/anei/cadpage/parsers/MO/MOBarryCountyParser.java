package net.anei.cadpage.parsers.MO;


import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;


/*
Barry County, MO
Contact: Ryan Joy <crazyrockj@gmail.com>

BC911:ALM >ALARMS 23544 FARM ROAD 2040 BARRY COUNTY JULIE KEENER 8775350563 Map: Grids:0,0 Cad: 2011-0000015066
BC911:MVAUNK>MOTOR VEH ACC UNKNOWN INJ STATE HIGHWAY 39 JENKINS VERIZON WIRELESS Cad: 2011-0000009418
BC911:FIRES >STRUCTURE FIRE 23270 STATE HIGHWAY TT BARRY COUNTY CAHD REAVIS 3350036 Map: Grids:0,0 Cad: 2011-0000015655

*/

public class MOBarryCountyParser extends DispatchBParser {
  
  private static final String[] CITY_LIST = new String[]{
    "BARRY COUNTY",

    "CASSVILLE",
    "EXETER",
    "MONETT",
    "PIERCE CITY",
    "PURDY",
    "SELIGMAN",
    "WASHBURN",
    "WHEATON",
    "[EDIT]VILLAGES",
    "ARROW POINT",
    "BUTTERFIELD",
    "CHAIN-O-LAKES",
    "EMERALD BEACH",

    "EAGLE ROCK",
    "GOLDEN",
    "JENKINS",
    "PULASKIFIELD",
    "PLEASANT RIDGE",
    "SCHOLTEN",
    "SHELL KNOB",
    "VIOLA",
    "WHEELERVILLE",
    "YONKERVILLE",

    "ASH TWP",
    "BUTTERFIELD TWP",
    "CAPPS CREEK TWP",
    "CORSICANA TWP",
    "CRANE CREEK TWP",
    "EXETER TWP",
    "FLAT CREEK TWP",
    "JENKINS TWP",
    "KINGS PRAIRIE TWP",
    "LIBERTY TWP",
    "MCDONALD TWP",
    "MCDOWELL TWP",
    "MINERAL TWP",
    "MONETT TWP",
    "MOUNTAIN TWP",
    "OZARK TWP",
    "PIONEER TWP",
    "PLEASANT RIDGE TWP",
    "PURDY TWP",
    "ROARING RIVER TWP",
    "SHELL KNOB TWP",
    "SUGAR CREEK TWP",
    "WASHBURN TWP",
    "WHEATON TWP",
    "WHITE RIVER TWP",
  };
 
  public MOBarryCountyParser() {
    super(CITY_LIST, "BARRY COUNTY", "MO");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("BC911:");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equalsIgnoreCase("BARRY COUNTY")) data.strCity = "";
    return true;
  }
}