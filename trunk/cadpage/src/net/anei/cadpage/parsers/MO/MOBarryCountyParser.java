package net.anei.cadpage.parsers.MO;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class MOBarryCountyParser extends DispatchB2Parser {
  
  private static final Pattern FARM_ROAD_PTN = Pattern.compile("\\bFARM ROAD\\b");
  private static final Pattern FR_PTN = Pattern.compile("\\bFR\\b");
 
  public MOBarryCountyParser() {
    super("BC911:", CITY_LIST, "BARRY COUNTY", "MO");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_KEEP_STATE_HIGHWAY | MAP_FLG_SUPPR_CR;
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    String save = body;
    body = FARM_ROAD_PTN.matcher(body).replaceAll("FR");
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equalsIgnoreCase("BARRY COUNTY")) data.strCity = "";
    
    if (save.length() != body.length()) {
      data.strAddress = FR_PTN.matcher(data.strAddress).replaceAll("FARM ROAD");
      data.strCross = FR_PTN.matcher(data.strCross).replaceAll("FARM ROAD");
    }
    return true;
  }
  
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
    
    // Worth County
    "DENVER"
  };
}