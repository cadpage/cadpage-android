package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/* 
Jackson County, NC
Contact: Mark wike <para139@yahoo.com>
Sender: Bill@mydomain.com
Bill:9783 CHARLEYS CREEK RD TUCKASEGEE MDL 26A03 2011009480 22:20:01 SICK PERSON (SPECIFIC DIAGNOSIS) CALLER ADV SHE HAD HEART SURGERY A LITTLE WHILE AGO AND HER
Bill:1 CHARLEYS CREEK RD/NEDDY MTN 2011010597 08:40:01 10-50D ACCIDENT/PROPERTY DAMAGE ADVS SINGLE CAR 10-50, NO PI

*/

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
