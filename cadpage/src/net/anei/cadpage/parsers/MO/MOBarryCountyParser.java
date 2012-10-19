package net.anei.cadpage.parsers.MO;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;



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