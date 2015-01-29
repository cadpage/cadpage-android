package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.dispatch.DispatchA48Parser;

public class GAWhitfieldCountyBParser extends DispatchA48Parser {
  
  public GAWhitfieldCountyBParser() {
    super(CITY_LIST, "WHITFIELD COUNTY", "GA", FieldType.NAME);
    setupCallList(CALL_LIST);
  }
  
  @Override
  public String getFilter() {
    return "PageGate@whitfieldcountyga.com";
  }
  
  private static final String[] CALL_LIST = new String[]{
    "BREATHING PROBLEMS",
    "M.V. ACCIDENT W/INJURIES",
    "M.V. ACCIDENT W/PEDESTRIAN",
    "SF-COMMERCIAL/INDUSTRIAL/SCHOO",
    "FIRE ALARM",
    "VEHICLE FIRE - CMV"
  };
  
  private static final String[] CITY_LIST = new String[]{
      "COHUTTA",
      "DALTON",
      "RESACA",
      "ROCKY FACE",
      "TUNNEL HILL",
      "VARNELL"
  };
}
