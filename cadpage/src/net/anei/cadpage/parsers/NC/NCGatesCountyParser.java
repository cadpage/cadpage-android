package net.anei.cadpage.parsers.NC;


import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Gates County, NC
 */

public class NCGatesCountyParser extends DispatchSouthernParser {
  
  public NCGatesCountyParser() {
    super(CALL_LIST, CITY_LIST, "GATES COUNTY", "NC", DSFLAG_CROSS_NAME_PHONE | DSFLAG_FOLLOW_CROSS);
  }


  private static final String[] CITY_LIST = new String[] {
    //City
    "GATESVILLE",
    
    // Townships
    "GATESVILLE",
    "HALL",
    "REYNOLDSON",
    "HASLETT",
    "HOLLY GROVE",
    "HUNTERS MILL",
    "MINTONSVILLE",
    
    // County Districts
    "GATESVILLE",
    "EURE",
    "GATES",
    "SUNBURY",
    "HOBBSVILE"
  };
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "Breathing Problems",
      "Diabetic",
      "Fall",
      "Fire",
      "Medical",
      "MVC with Injury",
      "Non Emergency Transport",
      "Vehicle Fire"
  );
}
