package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/**
 * Grayson County, VA
 */
public class VAGraysonCountyParser extends DispatchDAPROParser {
  
  public VAGraysonCountyParser() {
    super("GRAYSON COUNTY", "VA");  
    setupCallList(CALL_SET);
  }
  
  @Override
  public String getFilter() {
    return "MAILBOX@GalaxVa.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace('\n', ' ');
    return super.parseMsg(body, data);
  }

  private static final CodeSet CALL_SET = new CodeSet(
      
      "EMS - ABDOMINAL DISTRESS",
      "EMS - BLEEDING",
      "EMS - BLOOD PRESSURE",
      "EMS - BREATHING DIFFICULTY",
      "EMS - CARDIAC",
      "EMS - DIABETIC",
      "EMS - DISORIENTED",
      "EMS - FAINTING",
      "EMS - FAINTING / SYNCOPE",
      "EMS - FALL",
      "EMS - FEVER",
      "EMS - INTERFACILITY TRANSPORT",
      "EMS - NAUSEA / VOMITING",
      "EMS - NO INFORMATION ON PATIEN",
      "EMS - PAIN",
      "EMS - STROKE",
      "EMS - RETURN TRIP",
      "EMS - UNRESPONSIVE",
      "EMS - WEAKNESS",
      "MENTAL / EMOTIONAL/PSYC",
      "MOTOR VEHICLE CRASH"
 
  );
  
}