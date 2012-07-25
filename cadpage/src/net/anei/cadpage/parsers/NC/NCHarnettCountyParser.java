package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.GroupBestParser;

/* 
Harnett County, NC

*/

public class NCHarnettCountyParser extends GroupBestParser {
  
  public NCHarnettCountyParser() {
    super(new NCHarnettCountyAParser(), new NCHarnettCountyBParser());
  }
  
  static final String[] CITY_LIST = new String[]{
    
    // Townships
    "ANDERSON CREEK",
    "AVERASBORO",
    "BARBECUE",
    "BLACK RIVER",
    "BUCKHORN",
    "DUKE",
    "GROVE",
    "HECTORS CREEK",
    "JOHNSONVILLE",
    "LILLINGTON",
    "NEILLS CREEK",
    "STEWARTS CREEK",
    "UPPER LITTLE RIVER",
    
    // Cities and towns
    "CAMERON",
    "COATS",
    "DUNN",
    "ERWIN",
    "LILLINGTON",
    "SPRING LAKE",
    
    // Unincorporated Communities
    "ANDERSON CREEK",
    "BARBECUE",
    "BARCLAYSVILLE",
    "BUIES CREEK",
    "BUNNLEVEL",
    "CAPE FEAR",
    "CHALYBEATE SPRINGS",
    "COKESBURY",
    "DUNCAN",
    "JOHNSONVILLE",
    "HARNETT",
    "KIPLING",
    "LUART",
    "MAMERS",
    "OLIVIA",
    "OVERHILLS",
    "PINEVIEW",
    "RYES",
    "SEMINOLE",
    "SHAWTOWN",
    "SPOUT SPRINGS",
    "TURLINGTON",
    
    // Other
    "LINDEN",
    "ANGIER",
    "BENSON",
    "FUQUAY VARINA",
    "FUQUAY-VARINA",
    
    // Moore County
    "ABERDEEN",
    "SOUTHERN PINES"
  };
}
