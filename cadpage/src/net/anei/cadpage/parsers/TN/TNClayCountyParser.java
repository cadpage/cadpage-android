package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;


public class TNClayCountyParser extends DispatchB2Parser {

  public TNClayCountyParser() {
    super(CITY_LIST, "CLAY COUNTY", "TN");
    setupCallList(CALL_LIST);
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "1006",      "BUSY",
      "1043",      "WANT OFFICER",
      "1045",      "VEHICLE ACCIDENT-PD",
      "1046",      "VEHICLE ACCIDENT-INJURY", 
      "1047",      "AMBULANCE NEEDED",
      "1049",      "DRIVING WHILE DRUNK",
      "1055B",     "RAPE",
      "1056",      "PROWLER",
      "1057",      "ALARM",
      "1058",      "PUBLIC DRUNK",
      "1082",      "SERVING WARRANT",
      "1083",      "DOMESTIC VIOLENCE",
      "1086A",     "DOMESTIC W/WEAPONS",
      "1096",      "LARCENY",
      "4-WHEE",    "4-WHEELER/MOTORCYCLE/ATV",
      "ANIMAL",    "ANIMAL",
      "CHESTP",    "CHEST PAIN",
      "DEBRIS",    "DEBRIS",
      "DIABET",    "DIABETIC", 
      "FALLEN",    "FALL",
      "HEART",     "HEART ATTACK",
      "MOTAST",    "MOTORIST ASSIST",
      "RECKLE",    "RECKLESS DRIVER",
      "SEIZUR",    "SEIZURES",
      "SICK",      "SICKNESS (GENERAL)",
      "SOB",       "SHORT OF BREATH",
      "STROKE",    "STROKE",
      "SUSVEH",    "SUSPICIOUS VEHICLE",
      "TEST",      "TEST CALL",
      "UNLOCK",    "UNLOCK CAR DOOR",
      "WATER",     "WATER OUTAGE",
      "WELFAR",    "WELFARE CHECK"
  );

  private static final String[] CITY_LIST = new String[]{
    "ARCOT",
    "BEECH BETHANY",
    "BRIMSTONE",
    "BUTLER'S LANDING",
    "CELINA",
    "DENTON CROSSROADS",
    "FREE HILL",
    "HAMILTON BRANCH",
    "HERMITAGE SPRINGS",
    "HILHAM",
    "LILY DALE",
    "MAPLE GROVE",
    "MCLERRAN",
    "MOSS",
    "NEELY CROSSROADS",
    "OAK GROVE",
    "RED BOILING SPRINGS",
    "PEA RIDGE",
    "SHANKY BRANCH", 
    "WHITLEYVILLE"
  };
}
