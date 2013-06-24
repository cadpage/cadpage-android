package net.anei.cadpage.parsers.LA;

import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

public class LAStCharlesParishParser extends DispatchB2Parser {
		
  public LAStCharlesParishParser() {
    super("911:", CITY_LIST, "ST CHARLES PARISH", "LA");
  }
  
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }

  private static final String[] CITY_LIST = new String[] {
    "AMA", 
    "BAYOU GAUCHE",
    "BOUTTE",
    "DES ALLEMANDS",
    "DESTREHAN",
    "HAHNVILLE",
    "KILLONA",
    "LULING",
    "MONTZ",
    "NEW SARPY",
    "NORCO",
    "PARADIS",
    "ST ROSE",
    "TAFT"
  };

}
