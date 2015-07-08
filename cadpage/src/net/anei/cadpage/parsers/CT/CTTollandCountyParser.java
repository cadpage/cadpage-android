package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.GroupBestParser;


public class CTTollandCountyParser extends GroupBestParser {
  
  public CTTollandCountyParser() {
    super(new CTTollandCountyAParser(), new CTTollandCountyBParser());
  }
  
  static final String[] CITY_LIST = new String[]{
    "ANDOVER",
    "BOLTON",
    "COLUMBIA",
    "COVENTRY",
    "ELLINGTON",
    "HEBRON",
    "MANSFIELD",
    "SOMERS",
    "STAFFORD",
    "TOLLAND",
    "UNION",
    "VERNON",
    "WILLINGTON",

    "COVENTRY LAKE",
    "SOUTH COVENTRY",
    "CRYSTAL LAKE",
    "STAFFORD SPRINGS",
    "STORRS",
    "CENTRAL SOMERS",
    "ROCKVILLE",
    "MASHAPAUG",
    
    "WAREHOUSE POINT",

    "UCONN",
    
    // Windham county
    "ASHFORD",
    "EASTFORD",
    "WILLIMANTIC",
    "WINDHAM",
    
    // Hartford County
    "BROAD BROOK"
  };
}
