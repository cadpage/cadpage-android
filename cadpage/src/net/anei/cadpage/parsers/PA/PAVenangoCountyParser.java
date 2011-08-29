package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Venango County, PA
Sender: 8145164169

VENANGO 911:FTREDN>FIRE TREE DOWN PETROLEUM CENTER RD XS: EAGLE ROCK RD CORNPLANTER Cad: 2011-0000017294
VENANGO 911:MEDD >MEDICAL DELTA 10 VO TECH DR XS: PROSPECT ST OIL CITY PRESBYTERIAN HOMES IN THE PRES Map: Grids:, Cad: 2011-0000017234
VENANGO 911:FTREDN>FIRE TREE DOWN STATE ROUTE 227 XS: GRANDVIEW RD CORNPLANTER JULIE PETERSON Cad: 2011-0000017275
VENANGO 911:FSMOIN>FIRE SMOKE INVESTIGATION 22 WOODSIDE AVE XS: FAIRVIEW AVE CORNPLANTER MORELLI ELIZABETH Map: Grids:, Cad: 2011-0000016964
VENANGO 911:ELIFEL>EMS LIFELINE CALL 122 PLUMMER ST XS: PEARL AVE OIL CITY DUNLAP ANGIE Map: Grids:, Cad: 2011-0000016903
VENANGO 911:MED >MEDICAL GENERIC 1435 RUSSELL CORNERS RD XS: WHITE CITY RD CORNPLANTER ENOS BYRON A Map: Grids:, Cad: 2011-0000017129

*/

public class PAVenangoCountyParser extends DispatchBParser {

  public PAVenangoCountyParser() {
    super(CITY_LIST, "TIOGA COUNTY", "PA");
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
