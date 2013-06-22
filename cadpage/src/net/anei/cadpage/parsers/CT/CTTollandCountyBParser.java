package net.anei.cadpage.parsers.CT;


public class CTTollandCountyBParser extends CTNewHavenCountyBParser {
  
  public CTTollandCountyBParser() {
    super(CITY_LIST, "MANSFIELD", "CT");
  }
  
  @Override
  public String getFilter() {
    return "paging@easthavenfire.com,pubsafetypaging@uconn.edu";
  }
  
  private static final String[] CITY_LIST = new String[]{
    "COVENTRY",
    "MANSFIELD",
    "STORRS",
    "WILLINGTON"
  };
}
