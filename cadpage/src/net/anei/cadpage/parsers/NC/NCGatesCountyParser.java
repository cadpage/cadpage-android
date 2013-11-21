package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Gates County, NC
 */

public class NCGatesCountyParser extends DispatchSouthernParser {
  
  private static final Pattern UNIT_PRI_PTN = Pattern.compile(" +([A-Z0-9]+)-\\((\\d)\\) +");
  private static final Pattern LEAD_PRIORITY_PTN = Pattern.compile("^(0?\\d)\\b");
  private static final Pattern TRAIL_PRIORITY_PTN = Pattern.compile(" +(0?\\d)$");
  private static final Pattern INLINE_PRIORITY_PTN = Pattern.compile(" +(0?\\d) +");
  
  public NCGatesCountyParser() {
    super(CALL_LIST, CITY_LIST, "GATES COUNTY", "NC", DSFLAG_CROSS_NAME_PHONE | DSFLAG_FOLLOW_CROSS);
  }


  private static final String[] CITY_LIST = new String[] {
    //City
    "GATESVILLE",
    
// Townships
    "GATESVILLE",
    "HALL",
    "REYNOLDSON",
    "HASLETT",
    "HOLLY GROVE",
    "HUNTERS MILL",
    "MINTONSVILLE",
    
};
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "ABDOMINAL / BACK PAIN",
      "ALLERGIC REACTION",
      "ANIMAL / SNAKE BITE",
      "ASSAULT AGGRAVATED",
      "ASSAULT WITH INJURY",
      "BLEEDING (NON-TRAUMATIC)",
      "CARDIAC (WITH PREVIOUS HISTORY)",
      "CHEST PAINS",
      "DIABETIC ILLNESS",
      "DIFFICULTY BREATHING",
      "DISTURBANCE",
      "DIZZINESS, WEAKNESS",
      "F-EXPLOSION W-FIRE",
      "F-STRUCTURE FIRE",
      "FALL",
      "FALL - FRACTURE",
      "HEADACHE",
      "HIGH BLOOD PRESSURE",
      "MEDICAL ALARM",
      "MOTOR VEHICLE CRASH",
      "MOTOR VEHICL CRASH / PEDESTRIAN",
      "MOTOR VEHICLE CRASH W/INJURY",
      "OVERDOSE",
      "SICK / UNKNOWN",
      "SICK FLU LIKE SYMPTOMS",
      "STROKE",
      "SEIZURES",
      "SUSPICIOUS PERSON",
      "TRAUMA",
      "UNCONSCIOUS / UNRESPONSIVE SYNCOPE",
      "WELLBEING CHECK"
  );
}
