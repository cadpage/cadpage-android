package net.anei.cadpage.parsers.CT;

import java.util.regex.Pattern;


public class CTTollandCountyBParser extends CTNewHavenCountyBParser {
  
  public CTTollandCountyBParser() {
    super(CITY_LIST, "MANSFIELD", "CT");
  }
  
  @Override
  public String getFilter() {
    return "paging@easthavenfire.com,pubsafetypaging@uconn.edu";
  }
  
  @Override
  public String adjustMapAddress(String address) {
    address = GILBERT_EXT.matcher(address).replaceAll("GILBERT RD EXT");
    return super.adjustMapAddress(address);
  }
  private static final Pattern GILBERT_EXT = Pattern.compile("\\bGILBERT EXT\\b", Pattern.CASE_INSENSITIVE);
  
  private static final String[] CITY_LIST = new String[]{
    "COVENTRY",
    "MANSFIELD",
    "STORRS",
    "WILLINGTON"
  };
}
