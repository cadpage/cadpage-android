package net.anei.cadpage.parsers.NC;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCTransylvaniaCountyParser extends DispatchSouthernParser {
  
  public NCTransylvaniaCountyParser() {
    super(CITY_LIST, "TRANSYLVANIA COUNTY", "NC", DSFLAG_OPT_DISPATCH_ID);
    setupProtectedNames("SEE OFF MOUNTAIN");
  }
  
  @Override
  public String adjustMapCity(String city) {
    return convertCodes(city, MAP_CITY_TABLE);
  }
  
  private static Properties MAP_CITY_TABLE = buildCodeTable(new String[]{
      "CONNESTEE",                "BREVARD",
      "CONNESTEE FALLS",          "BREVARD",
      "NORTH TRANSYLVANIA",       "TRANSYLVANIA COUNTY",
      "PISGAH NATIONAL FOREST",   "PISGAH FOREST",
      "SHERWOOD FOREST",          "BREVARD"
  });
  
  private static final String[] CITY_LIST = new String[]{
    "CASHIERS",
    "CONNESTEE",
    "CONNESTEE FALLS",
    "BALSAM GROVE",
    "BREVARD",
    "BREVARD CITY",
    "ETOWAH",
    "LAKE TOXAWAY",
    "LITTLE RIVER",
    "MILLS RIVER",
    "NORTH TRANSYLVANIA",
    "PENROSE",
    "PISGAH FOREST",
    "PISGAH NATIONAL FOREST",
    "ROSMAN",
    "SAPPHIRE",
    "SHERWOOD FOREST",
    
    "JACKSON COUNTY"
  };

}
