package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchA10Parser;

/**
 * Clinton County, OH
 */
public class OHClintonCountyParser extends DispatchA10Parser {

  public OHClintonCountyParser() {
    super(CITY_LIST, "CLINTON COUNTY", "OH",
           "CALL ADDR/S PHONE? INFO X+");
  }
  
  @Override
  public String getFilter() {
    return "noreply@clintonsheriff.com";
  }
    
  
  @Override
  public Field getField(String name) {
    if (name.equals("PHONE")) return new PhoneField("\\d{7}");
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    // City
    "WILMINGTON",

    // Villages
    "BLANCHESTER",
    "CLARKSVILLE",
    "LYNCHBURG",
    "MARTINSVILLE",
    "MIDLAND",
    "NEW VIENNA",
    "PORT WILLIAM",
    "SABINA",

    // Townships
    "ADAMS",
    "CHESTER",
    "CLARK",
    "GREEN",
    "JEFFERSON",
    "LIBERTY",
    "MARION",
    "RICHLAND",
    "UNION",
    "VERNON",
    "WASHINGTON",
    "WAYNE",
    "WILSON",

    // Unicorporated villages
    "BLOOMINGTON",
    "BURTONVILLE",
    "CUBA",
    "FARMERS STATION",
    "GURNEYVILLE",
    "JONESBORO",
    "LEES CREEK",
    "LUMBERTON",
    "MCKAYS STATION",
    "MELVIN",
    "MEMPHIS",
    "MORRISVILLE",
    "NEW ANTIOCH",
    "NORTH KINGMAN",
    "OAKLAND",
    "OGDEN",
    "POWDER LICK",
    "REESVILLE",
    "SLIGO",
    "SOUTH KINGMAN",
    "WALLOPSBURG",
    "WESTBORO",
    
    // In Highland County
    "LEESBURG"

  };
}
