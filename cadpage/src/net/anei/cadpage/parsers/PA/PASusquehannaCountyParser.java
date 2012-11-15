package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.dispatch.DispatchBParser;


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
