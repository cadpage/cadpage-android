package net.anei.cadpage.parsers.CT;


public class CTTollandCountyBParser extends CTNewHavenCountyBParser {
  
  public CTTollandCountyBParser() {
    super("MANSFIELD", "CT");
  }
  
  @Override
  public String getFilter() {
    return "paging@easthavenfire.com,pubsafetypaging@uconn.edu";
  }
}
