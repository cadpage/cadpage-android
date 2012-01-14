package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.general.GeneralParser;

/* 
Humphreys County, TN
Contact: dale allen <dallen422@gmail.com>
Sender: dispatch@911email.net

(E911) PER F401 THERE IS A MANDATORY VKF TRAINING TONIGHT AT CITY HALL 7PM
(E911) 850 BROADWAY AVE, THOMPSON LIQ, APPEARS TO BE A FIRE BEHIND THE STORE IN A FIELD
(E911) AMBULANCE REQ FOR 35 TRIPP RD, 67 Y/O MALE PATIENT HAS FALLEN AND WEIGHS OVER 300LBS AND PROMED IS REQ MAN POWER
(E911) STRUCTURE FIRE----APPROX 1 MILE DOWN BOX HOLLOW RD VISIBLE FLAMES---- NO OTHER STRUCTURES IN DANGER JUST BRUSH AND WOODS
(E911) f-401 adv that meeting for tonight has been canceled
(E911) PRO-MED 58 REQUESTING ASSISTANCE AT 392 JAMES RD 80 Y/O/F POSSIBLY HAVING A HEART ATTACK THEY ARE ER FROM TRACE CR IN MCEWEN
(E911) RAIL CAR LEAKING AT JOHNSONVILLE RAIL YARD CONTAINS SODIUM HYDROXIDE CSX ADVISED THEY JUST FOUND IT ON ITS SIDE
(E911) AMBULANCE REQ 1714 LONG ST 70 Y/O/M COPD PATIENT BADLY SWOLLEN AND WILL TAKE SEVERAL MEN TO PICK HIM UP
(E911) ANY FIRE PERSONELL NOT BUSY F401 IS REQUESTING ONE OF YOU GO TO THE HALL AND GET REPORT FOR 737 CHEROKEE DR 10/07/2011 SMOKE SCARE, OWNER

 */

public class TNHumphreysCountyParser extends GeneralParser {
  
  public TNHumphreysCountyParser() {
    super("HUMPHREYS COUNTY", "TN");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@911email.net";
  }

  @Override
  protected boolean isPageMsg(String subject, String body) {
    return true;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (! subject.equals("E911")) return false;
    if (super.parseMsg("", body, data)) return true;
    data.strCall = "GENERAL ALERT";
    data.strPlace = body;
    return true;
  }
}
