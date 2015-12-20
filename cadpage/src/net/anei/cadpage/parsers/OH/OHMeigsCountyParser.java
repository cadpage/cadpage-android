package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class OHMeigsCountyParser extends DispatchEmergitechParser {
  
  public OHMeigsCountyParser() {
    super(0, CITY_LIST, "MEIGS COUNTY", "OH");
  }

  private static final String[] CITY_LIST = new String[]{
    
      //Villages

      "MIDDLEPORT",
      "POMEROY",
      "RACINE",
      "RUTLAND",
      "SYRACUSE",

      //Townships

      "BEDFORD",
      "CHESTER",
      "COLUMBIA",
      "LEBANON",
      "LETART",
      "OLIVE",
      "ORANGE",
      "RUTLAND",
      "SALEM",
      "SALISBURY",
      "SCIPIO",
      "SUTTON",

      //Unincorporated communities

      "APPLE GROVE",
      "CHESTER",
      "DARWIN",
      "LANGSVILLE",
      "LONG BOTTOM",
      "PORTLAND",
      "REEDSVILLE",
      "TUPPERS PLAINS"
  };
}
