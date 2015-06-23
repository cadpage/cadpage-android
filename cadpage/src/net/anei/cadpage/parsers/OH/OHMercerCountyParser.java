package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class OHMercerCountyParser extends DispatchEmergitechParser {
  
  public OHMercerCountyParser() {
    super(0, CITY_LIST, "MERCER COUNTY", "OH");
    setupMultiWordStreets("MRCR V WRT CO LN");
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = addr.replace("MRCR V WRT CO LN", "MERCER VANWERT COUNTY LINE");
    return addr;
  }
  
  private static final String[] CITY_LIST = new String[]{

    // Cities
    "CELINA",

    // Villages
    "BURKETTSVILLE",
    "CHICKASAW",
    "COLDWATER",
    "FORT RECOVERY",
    "MENDON",
    "MONTEZUMA",
    "ROCKFORD",
    "ST HENRY",

    // Townships
    "BLACK CREEK",
    "BUTLER",
    "CENTER",
    "DUBLIN",
    "FRANKLIN",
    "GIBSON",
    "GRANVILLE",
    "HOPEWELL",
    "JEFFERSON",
    "LIBERTY",
    "MARION",
    "RECOVERY",
    "UNION",
    "WASHINGTON",

    // Unincorporated communities
    "CARTHAGENA",
    "CASSELLA",
    "CHATTANOOGA",
    "CRANBERRY PRAIRIE",
    "DURBIN",
    "ERASTUS",
    "HINTON",
    "MACEDON",
    "MARIA STEIN",
    "MERCER",
    "NEPTUNE",
    "PADUA",
    "PHILOTHEA",
    "SEBASTIAN",
    "SHARPSBURG",
    "SHIVELY",
    "SKEELS CROSSING",
    "SKEELS CROSSROADS",
    "ST JOSEPH",
    "ST PETER",
    "ST ROSE",
    "TAMA",
    "WABASH",
    "WENDELIN"
  };
}
