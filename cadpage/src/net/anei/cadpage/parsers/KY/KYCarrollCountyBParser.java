package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class KYCarrollCountyBParser extends DispatchB2Parser {
  
  public KYCarrollCountyBParser() {
    super("CARROLLCOUNTY911:", CITY_LIST, "FULTON COUNTY", "KY", B2_FORCE_CALL_CODE);
    setupCallList(CALL_TABLE);
 
  }
  
  private static final String[] CITY_LIST = new String[]{

      "CARROLLTON",
      "ENGLISH",
      "GHENT",
      "PRESTONVILLE",
      "SANDERS",
      "WORTHVILLE"
    
  };
  
  private static final CodeSet CALL_TABLE = new CodeSet(
      "1012",  "VISITOR PRESENT",
      "1045",  "PROPERTY DAMAGE ACCIDENT",
      "BA",    "BURGLAR ALARM",
      "C115",  "RECKLESS DRIVING",
      "C2",    "FIGHT IN PROGRESS",
      "C3",    "TROUBLE CALL",
      "CI",    "CRIMINAL INVESTIGATION",
      "DOG",   "DOG COMPLAINT",
      "EMS",   "REQUEST AMBULANCE",
      "H",     "911 HANGUP CALLS",
      "I",     "INFORMATIONAL CALL",
      "MA",    "MOTORIST ASSIST",
      "RH",    "ROAD",
      "SCH",   "CALL AT SCHOOL",
      "T",     "THEFT REPORT",
      "TEST",  "TEST CALL"
        
   );   
}
