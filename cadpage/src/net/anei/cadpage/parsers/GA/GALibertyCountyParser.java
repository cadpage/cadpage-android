package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;


public class GALibertyCountyParser extends DispatchB2Parser {

  public GALibertyCountyParser() {
    super("911COMMUNICATIONS:", CITY_LIST,"LIBERTY COUNTY", "GA");
  }
  
  
  private static final String[] CITY_LIST = new String[]{
    "ALLENHURST",
    "FLEMINGTON",
    "FORT STEWART",
    "GUMBRANCH",
    "HINESVILLE",
    "MIDWAY",
    "SUNBURY",
    "RICEBORO",
    "WALTHOURVILLE"
  };
  
  @Override
  protected CodeSet buildCallList() {
    return new CodeSet(
        "APPLIANCE FIRE",
        "BRUSH FIRE",
        "DIABETIC EMERGENCY",
        "DOMESTIC DISPUTE IN PROGRESS",
        "DOWNED WIRES",
        "DWELLING FIRE(SFH)",
        "FAILURE TO STOP",
        "FALL VICTIM",
        "FAPL APPLIANCE FIRE",
        "FDWL DWELLING FIRE(SFH)",
        "FIRE TEST CALL",
        "GAS LEAK/OUTSIDE",
        "GASL GAS LEAK/OUTSIDE",
        "HAZMAT INCIDENT",
        "HAZMAT INCIDENT INTERSTATE",
        "HAZMAT HAZMAT INCIDENT",
        "HAZMAT HAZMAT INCIDENT INTERSTATE",
        "JUVENILE DELIQUENCY",
        "MISPER MISSING PERSON",
        "MISSING PERSON",
        "RESPIRATORY DISTRESS",
        "SEIZURE",
        "STORM DAMAGE",
        "SYNCOPAL EPISODE",
        "TRAFFIC ACCIDENT NO INJURY",
        "TRAFFIC ACCIDENT WITH INJURIES",
        "TRAFFIC STOP"

    );
  }
  
}
