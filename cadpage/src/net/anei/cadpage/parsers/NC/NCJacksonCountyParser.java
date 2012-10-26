package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCJacksonCountyParser extends DispatchSouthernParser {
  
  
  public NCJacksonCountyParser() {
    super(CITY_LIST, "JACKSON COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "Bill@mydomain.com";
  }
  

  private static final String[] CITY_LIST = new String[]{
    "BALSAM",
    "CASHIERS",
    "CULLOWHEE",
    "DILLSBORO",
    "FOREST HILLS",
    "GLENVILLE",
    "HIGHLANDS",
    "SAVANNAH",
    "SYLVA",
    "WEBSTER",
    "TUCKASEGEE"
    
  };

}
