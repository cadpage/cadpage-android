package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Susquehanna County, PA
Contact: Chad Sinnett <csinnett7@gmail.com>
Sender: @susqco.alertpa.org

MVA >MOTOR VEHICLE ACCIDENT 228 I81 S GREAT BEND TWP PHAN,ABDUL Map: Grids:0,0 Cad: 2012-0000006018 (HSF)
TREES >TREES DOWN 21907 SR 11 GREAT BEND Map: Grids:, Cad: 2012-0000006063 (HSF)
BRUSH >BRUSH FIRE HARMONY RD GREAT BEND GALLELLI,JOHN Map: Grids:, Cad: 2012-0000006113 (HSF)
WIRES >WIRES DOWN SR 11 GREAT BEND ANTHONY Map: Grids:, Cad: 2012-0000006114 (HSF)
17 >FALLS 1004 HARMONY RD GREAT BEND CST - LINK TO LIFE Map: Grids:, Cad: 2012-0000006142 (HSF)

*/

public class PASusquehannaCountyParser extends DispatchBParser {

  public PASusquehannaCountyParser() {
    super(CITY_LIST, "SUSQUEHANNA COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "@susqco.alertpa.org";
  }
  
  private static final String[] CITY_LIST = new String[]{
    "FOREST CITY",
    "FRIENDSVILLE",
    "GREAT BEND",
    "HALLSTEAD",
    "HOP BOTTOM",
    "LANESBORO",
    "LITTLE MEADOWS",
    "MONTROSE",
    "NEW MILFORD",
    "OAKLAND",
    "SUSQUEHANNA DEPOT",
    "THOMPSON",
    "UNION DALE",
    "[EDIT]TWPS",
    "APOLACON TWP",
    "ARARAT TWP",
    "AUBURN TWP",
    "BRIDGEWATER TWP",
    "BROOKLYN TWP",
    "CHOCONUT TWP",
    "CLIFFORD TWP",
    "DIMOCK TWP",
    "FOREST LAKE TWP",
    "FRANKLIN TWP",
    "GIBSON TWP",
    "GREAT BEND TWP",
    "HARFORD TWP",
    "HARMONY TWP",
    "HERRICK TWP",
    "JACKSON TWP",
    "JESSUP TWP",
    "LATHROP TWP",
    "LENOX TWP",
    "LIBERTY TWP",
    "MIDDLETOWN TWP",
    "NEW MILFORD TWP",
    "OAKLAND TWP",
    "RUSH TWP",
    "SILVER LAKE TWP",
    "SPRINGVILLE TWP",
    "THOMPSON TWP",
  };
}
