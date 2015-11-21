package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/**
 * Franklin County, VA
 */
public class VAFluvannaCountyAParser extends DispatchDAPROParser {
  
  public VAFluvannaCountyAParser() {
    super("FLUVANNA COUNTY", "VA");  
    setupCallList(CALL_SET);
    setupMultiWordStreets(MWORD_STREET_LIST);
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net,cad2@acuecc.org";
  }
  
  private static final String[] MWORD_STREET_LIST = new String[]{
    "DEEP CREEK",
    "GRAVEL HILL",
    "HADEN MARTIN",
    "KIDDS DAIRY",
    "RISING SUN",
    "SCLATERS FORD",
    "SOUTH BOSTON",
    "THOMAS JEFFERSON",
    "UNION MILLS",
    "ZION STATION"
   
  };
  
  private static final CodeSet CALL_SET = new CodeSet(
    "BREATHING DIFFICULTY",
    "BRUSH FIRE",
    "CHEST PAIN (NO CARDIAC HISTORY",
    "DIABETIC ILLNESS/INSULIN REACT",
    "DIZZINESS/VERTIGO/WEAKNESS",
    "FIRE ALARM ACTIVATION",
    "HEMMORHAGE/BLEEDING",
    "LOG FOR RECORD",
    "MOTOR VEHICLE ACCIDENT",
    "OTHER - EXPLAIN IN REMARKS",
    "SMOKE/ODOR INV INSIDE STRUCTUR",
    "STROKE",
    "RUNAWAY",
    "TREE ON LINE/ROAD"
  );
}