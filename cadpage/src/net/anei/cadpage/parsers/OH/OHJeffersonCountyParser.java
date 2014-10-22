package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchA40Parser;

public class OHJeffersonCountyParser extends DispatchA40Parser {

  public OHJeffersonCountyParser() {
    super(CITY_LIST, "JEFFERSON COUNTY", "OH");
  }


  private static final String[] CITY_LIST = new String[] { 

    "ADENA",
    "AMSTERDAM",
    "BERGHOLZ",
    "BLOOMINGDALE",
    "BRUSH CREEK TWP",
    "CROSS CREEK TWP",
    "DILLONVALE",
    "EMPIRE",
    "IRONDALE",
    "ISLAND CREEK TWP",
    "KNOX TWP",
    "MINGO JUNCTION",
    "MOUNT PLEASANT TWP",
    "NEW ALEXANDRIA",
    "RAYLAND",
    "RICHMOND",
    "ROSS TWP",
    "SALEM TWP",
    "SALINE TWP",
    "SMITHFIELD TWP",
    "SPRINGFIELD TWP",
    "STEUBENVILLE TWP",
    "STRATTON",
    "TILTONSVILLE",
    "TORONTO",
    "WARREN TWP",
    "WAYNE TWP",
    "WELLS TWP",
    "WINTERSVILLE",
    "YORKVILLE", 
    
    "CARROLL CO",
  };
  
}
