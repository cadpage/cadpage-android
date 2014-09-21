package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.GroupBestParser;


public class MOBarryCountyParser extends GroupBestParser {

  public MOBarryCountyParser() {
    super(new MOBarryCountyAParser(), new MOBarryCountyBParser());
  }
  
  static final String[] CITY_LIST = new String[]{
    "COUNTY",
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
    
    // Worth County
    "DENVER"
  };
}
