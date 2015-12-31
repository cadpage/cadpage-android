package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchA18Parser;


public class TXDallasCountyBParser extends DispatchA18Parser {
  
  public TXDallasCountyBParser() {
    super(CITY_LIST, "DALLAS COUNTY","TX");
  }
 
  @Override
  public String getFilter() {
    return "wilmerfd@cityofwilmer.net";
  }

  private static String[] CITY_LIST = new String[]{

      //cities
      
      "BALCH SPRINGS",
      "CEDAR HILL",
      "CARROLLTON",
      "COCKRELL HILL",
      "COMBINE",
      "COPPELL",
      "DALLAS",
      "DESOTO",
      "DUNCANVILLE",
      "FARMERS BRANCH",
      "FERRIS",
      "GARLAND",
      "GLENN HEIGHTS",
      "GRAND PRAIRIE",
      "GRAPEVINE",
      "HUTCHINS",
      "IRVING",
      "LANCASTER",
      "LEWISVILLE",
      "MESQUITE",
      "OVILLA",
      "RICHARDSON",
      "ROWLETT",
      "SACHSE",
      "SEAGOVILLE",
      "UNIVERSITY PARK",
      "WILMER",
      "WYLIE",

      //towns
      
      "ADDISON",
      "HIGHLAND PARK",
      "SUNNYVALE",

  //Unincorporated community

      "SAND BRANCH"

  };
}
