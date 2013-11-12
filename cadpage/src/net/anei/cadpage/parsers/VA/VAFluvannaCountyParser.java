package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/**
 * Franklin County, VA
 */
public class VAFluvannaCountyParser extends DispatchDAPROParser {
  
  public VAFluvannaCountyParser() {
    super("FLUVANNA COUNTY", "VA");  
    setupCallList(CALL_SET);
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net,MAILBOX@fluvannasheriff.com";
  }
  
  private static final CodeSet CALL_SET = new CodeSet(
      "BREATHING DIFFICULTY",
      "CHEST PAIN (NO CARDIAC HISTORY",
      "DIZZINESS/VERTIGO/WEAKNESS",
      "FIRE ALARM ACTIVATION",
      "HEMMORHAGE/BLEEDING",
      "LOG FOR RECORD",
      "MOTOR VEHICLE ACCIDENT",
      "OTHER - EXPLAIN IN REMARKS",
      "SMOKE/ODOR INV INSIDE STRUCTUR",
      "STROKE",
      "TREE ON LINE/ROAD"
  );
}