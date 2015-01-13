package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;


public class GAForsythCountyParser extends DispatchB2Parser {

  public GAForsythCountyParser() {
    super(":", CITY_LIST, "FORSYTH COUNTY", "GA");
    setupCallList(CALL_LIST);

  }
 
  private static final String[] CITY_LIST = new String[]{

    "BROOKWOOD",
    "COAL MOUNTAIN",
    "CHESTATEE",
    "CUMMING",
    "SILVER CITY",
    "DAVES CREEK",
    "FRIENDSHIP",
    "OSCARVILLE",
    "BIG CREEK",
    "MIDWAY",
    "MATT",
    "DUCKTOWN"

  };
  
  private static final CodeSet CALL_LIST = new CodeSet(
     
  );
}
