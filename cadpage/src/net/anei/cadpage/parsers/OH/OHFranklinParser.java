package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.FieldProgramParser;

/*
Franklin, OH (in Clearmont County but dispatched separately)
Contact: Christopher Rauh <crauh@franklinohio.org>
Contact: Scott Rauh <srauh2290@yahoo.com>
Sender: rc.282@cmsg.net

(CAD) [!] F-STRUCTURE FIRE LOCATION: 818 UNION RD FRANKLIN TWP BETWEEN ROBERTS DR/SHAKER RD COMMENTS: X-084.304747 Y+039.552894 CF95 U ZUNCFIRE IN ATTIC EVERYONE EVACUATED
(CAD) [!] F-POLICE ASSIST LOCATION: 235 INDUSTRIAL DR FRANKLIN BETWEEN N SR RT 123/SHAKER RD COMMENTS: VEH STRUCK A POLE/ APPEARS THAT THE WIRES ARE ALL STILL CONNECTED REQ FFD
(CAD) [!] F-CARBON MONOXIDE INCIDENT LOCATION: 201 E 2ND ST FRANKLIN BETWEEN LOCUST ST / ALLEN ST COMMENTS: POSSIBLE CO LEAK BY STEPS SO POSSIBLY BASEMENT
(CAD) [!] F-UTILITY POLE-TRANSFORMER FIRE LOCATION: 850 N MAIN ST FRANKLIN BETWEEN KENNETH KOONS BLVD / PENNYROYAL RD COMMENTS; WIRE DOWN / LINE ARCHING
(CAD) [!] AUTO CRASH/SINGLE ENGINE LOCATION: 36 NB I-75 FRANKLIN BETWEEN SHAKER RD / SR 123 ST COMMENTS: X-084.284963 Y+039.562293 CFO U Z ZUNCSEMI TRUCK CRASHED DUMPING FUEL IN ROADWAY
(CAD) [!] F-HAZMAT LEAK SPILL NO FIRE LOCATION: 501 SHOTWELL DR FRANKLIN BETWEEN N SR RT 123 / DEAD END COMMENTS: X Y CF U Z ZUNCBOTTLE OF ACCETYLINE LEAKING HEAVILY INSIDE THE BACK OF BUILDING
(CAD) [!] F-OUTDOOR FIRE INVESTIGATION LOCATION: 324 PENNYROYAL RD FRANKLIN TWP BETWEEN CLEARCREEK FRANKLIN RD / HOMESTEAD DR COMMENTS: NEIGHBOR HAVING A VERY LARGE FIRE IN THEIR YARD/ REQ FFD COME CHECK IT
(CAD) [!] F-ANIMAL RESCUE LOCATION: 5709 S DIXIE HWY FRANKLIN COMMENTS: ANIMAL SANCTUARY PERSON IS AT PROPERTY REQ ANIMAL RESCUE FOR POT BELLY PIG 
(CAD) [!] F-FIRE ALARM LOCATION: 2301 COMMERCE CENTER DR FRANKLIN BETWEEN E 2ND ST / HERITAGE DR COMMENTS: SHOWING ZONE 47 / EMPLOYEE MANUAL PULL
(CAD) [!] F-GENERAL RECALL LOCATION: 45 E 4TH ST FRANKLIN BETWEEN RILEY ST / ANDERSON ST
(CAD) [!] AUTO CRASH WITH ENTRAPMENT LOCATION: 38 NB I-75 FRANKLIN BETWEEN SR 123 / SR 73 COMMENTS: X-084.261703 Y+039.568226 CF0 U Z ZUNC

 */


public class OHFranklinParser extends FieldProgramParser {
  
  public OHFranklinParser() {
    super(CITY_LIST, "FRANKLIN", "OH",
           "CALL! LOCATION:ADDR/S! BETWEEN:X? COMMENTS:INFO");
  }
  
  @Override
  public String getFilter() {
    return "@cmsg.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CAD|!")) return false;
    body = body.replace(" BETWEEN ", " BETWEEN: ");
    return super.parseMsg(body, data);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "FRANKLIN",
    "FRANKLIN TWP"
  };
}
