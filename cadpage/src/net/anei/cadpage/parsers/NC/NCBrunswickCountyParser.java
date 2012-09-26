package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;
/**
 * Brunswick County, NC
 */
public class NCBrunswickCountyParser extends DispatchSouthernParser {
  
  
  public NCBrunswickCountyParser() {
    super(CITY_LIST, "BRUNSWICK COUNTY", "NC", DSFLAG_OPT_DISPATCH_ID | DSFLAG_LEAD_PLACE);
  }
  
  @Override
  public String getFilter() {
    return "pagegate@brunswickes.com,vtext.com@returns.groups.yahoo.com";
  }
  
  private static final String[] CITY_LIST = new String[]{
    "LOCKWOODS FOLLY",
    "NORTHWEST",
    "SHALLOTTE",
    "SMITHVILLE",
    "TOWN CREEK",
    "WACCAMAW",

    "BALD HEAD ISLAND",
    "BELVILLE",
    "BOILING SPRING LAKES           ",
    "BOLIVIA",
    "CALABASH",
    "CAROLINA SHORES",
    "CASWELL BEACH",
    "HOLDEN BEACH",
    "LELAND",
    "NAVASSA",
    "NORTHWEST",
    "OAK ISLAND",
    "OCEAN ISLE BEACH",
    "SANDY CREEK",
    "SHALLOTTE",
    "SOUTHPORT",
    "ST. JAMES",
    "SUNSET BEACH",
    "VARNAMTOWN",

    "ANTIOCH",
    "ASH",
    "BATARORA",
    "BELL SWAMP",
    "BISHOP",
    "BIVEN",
    "BONAPARTE LANDING",
    "BOONES NECK",
    "BOWENSVILLE",
    "BRUNSWICK STATION",
    "CAMP BRANCH",
    "CEDAR GROVE",
    "CEDAR HILL",
    "CIVIETOWN",
    "CLAIRMONT",
    "CLARENDON",
    "COOLVALE",
    "DOE CREEK",
    "EASTBROOK",
    "EASY HILL",
    "PINEY GROVE",
    "SUPPLY",
    "SUNSET HARBOR",
    "WINNABOW",
  };

}
