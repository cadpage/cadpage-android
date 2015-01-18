package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;


public class GAForsythCountyParser extends DispatchB2Parser {

  public GAForsythCountyParser() {
    super(":", CITY_LIST, "FORSYTH COUNTY", "GA");
    setupCallList(CALL_LIST);

  }
 
  private static final String[] CITY_LIST = new String[]{
    "ALPHARETTA",
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
      
      "AUTO ACCIDENT",
      "CARBON MONOXIDE ALARM",
      "FIRE ALARM",
      "FIRECOMMAND:",
      "FIRE - COMMERCIAL BUILDING",
      "FIRE - RESIDENTIAL",
      "GAS LEAK",
      "HIT & RUN JUST OCCURED",
      "INFORMATION FOR DEPUTY",
      "INVESTIGATE SMOKE OR SMELL",
      "MEDICAL ALARM",
      "MISSING PERSON/CRITICAL",
      "MVA - INJURIES & ENTRAPMENTS",
      "MVA WITH INJURIES",
      "MVA W/ UNKNOWN INJURIES",
      "PATIENT ASSIST",
      "PERSON DEAD FIRECOMMAND/MS/0847HRS/MEDICAL CALL",
      "PERSON DOWN MEDICAL EMERGENCY",
      "RECOVERY",
      "SOCOMMAND:",
      "SUICIDE ATTEMPT"
      
  );
}
