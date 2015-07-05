package net.anei.cadpage.parsers.KY;


import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

public class KYMetcalfeCountyParser extends DispatchB2Parser {
  
  public KYMetcalfeCountyParser() {
    super("911-CENTER:",CITY_LIST, "METCALFE COUNTY", "KY");
    setupCallList(CALL_LIST);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BEAUMONT",
    "CENTER",
    "EDMONTON",
    "KNOB LICK",
    "RANDOLPH",
    "SAVOYARD",
    "SULPHUR WELL",
    "SUMMER SHADE",
    "WISDOM"
    
  };
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "ANIMAL COMPLT UNSPECIFED ANIMA",
      "ANY ALARM CALL",
      "ASSIST AMBULANCE SERVICE",
      "FIRE - HOUSE",
      "MEDICAL ASSIST",
      "MVA NON INJURY",
      "MVA WITH INJURIES",
      "SPECIAL DETAIL",
      "TEST CALL",
      "TREE DOWN",
      "UNDEFINED TYPE OF FIRE"
     
  );
}
