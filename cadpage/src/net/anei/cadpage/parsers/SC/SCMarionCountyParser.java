package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;


public class SCMarionCountyParser extends DispatchB2Parser {

  public SCMarionCountyParser() {
    super("E911CENTRALMARIONCOUNTY:", CITY_LIST, "MARION COUNTY", "SC");
    setupCallList(CALL_LIST);
  }
  
  @Override
  public String getFilter() {
    return "tcooper@marionsc.gov";
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "MEDALA",      "MEDICAL ALARM",
      "BRUFIR",      "BRUSH FIRE",
      "RESPDI",      "RESPIRATORY DISTRESS",
      "MVA",         "MOTOR VEHICLE ACCIDENT",
      "FIRALC",      "FIRE ALARM COMMERCIAL",
      "CARARR",      "CARDIAC ARREST",
      "PAIN",        "PAIN",
      "FIRALR",      "FIRE ALARM RESIDENTIAL",
      "STRUC",       "STRUCTURE FIRE",
      "INVEST",      "INVESTIGATION",
      "UNCONC",      "UNCONSCIOUS-UNREPONSIVE",
      "STRFCO",      "STRUCTURE FIRE (COMMERCIAL)"
  );

  private static final String[] CITY_LIST = new String[]{
    "ARIEL CROSSROAD",
    "BRITTONS NECK",
    "CENTENARY",
    "FRIENDSHIP",
    "GRESHAM",
    "MARION",
    "MULLINS",
    "NICHOLS",
    "RAINS",
    "SELLERS",
    "TEMPERANCE HILL"
  };
}
