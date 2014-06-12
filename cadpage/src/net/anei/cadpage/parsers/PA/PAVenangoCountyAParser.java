package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.dispatch.DispatchBParser;


public class PAVenangoCountyAParser extends DispatchBParser {

  public PAVenangoCountyAParser() {
    super(CITY_LIST, "VENANGO COUNTY", "PA");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("VENANGO 911:");
  }
  
  private static final String[] CITY_LIST = new String[]{
    "FRANKLIN",
    "OIL CITY",

    "BARKEYVILLE",
    "CLINTONVILLE",
    "COOPERSTOWN",
    "EMLENTON",
    "PLEASANTVILLE",
    "POLK",
    "ROUSEVILLE",
    "SUGARCREEK",
    "UTICA",

    "ALLEGHENY",
    "CANAL",
    "CHERRYTREE",
    "CLINTON",
    "CORNPLANTER",
    "CRANBERRY",
    "FRENCHCREEK",
    "IRWIN",
    "JACKSON",
    "MINERAL",
    "OAKLAND",
    "OIL CREEK TOWNSHIP",
    "PINEGROVE",
    "PLUM",
    "PRESIDENT",
    "RICHLAND",
    "ROCKLAND",
    "SANDYCREEK",
    "SCRUBGRASS",
    "VICTORY"
  };
}
