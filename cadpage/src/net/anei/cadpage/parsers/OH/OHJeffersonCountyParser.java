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
    "BRUSH CREEK",
    "CROSS CREEK",
    "DILLONVALE",
    "EMPIRE",
    "IRONDALE",
    "ISLAND CREEK",
    "KNOX",
    "MINGO JUNCTION",
    "MOUNT PLEASANT",
    "NEW ALEXANDRIA",
    "RAYLAND",
    "RICHMOND",
    "ROSS",
    "SALEM",
    "SALINE",
    "SMITHFIELD",
    "SPRINGFIELD",
    "STEUBENVILLE",
    "STRATTON",
    "TILTONSVILLE",
    "TORONTO",
    "WARREN",
    "WAYNE",
    "WELLS",
    "WINTERSVILLE",
    "YORKVILLE"
  };
  
}
