package net.anei.cadpage.parsers.CT;


public class CTWindhamCountyBParser extends CTNewHavenCountyBParser {
  
  public CTWindhamCountyBParser() {
    super(CITY_LIST, "WINDHAM COUNTY", "CT");
  }
  
  @Override
  public String getFilter() {
    return "wpdpaging@gmail.com";
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ANDOVER",
    "ASHFORD",
    "COLUMBIA",
    "COVENTRY",
    "CHAPLIN",
    "EASTFORD",
    "FRANKLIN",
    "HAMPTON",
    "HEBRON",
    "LEBANON",
    "MANSFIELD",
    "SCOTLAND",
    "STORRS",
    "WILLIMANTIC",
    "WILLINGTON"
  };
}
