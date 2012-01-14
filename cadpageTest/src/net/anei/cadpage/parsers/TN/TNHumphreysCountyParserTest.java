package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TNHumphreysCountyParserTest extends BaseParserTest {
  
  public TNHumphreysCountyParserTest() {
    setParser(new TNHumphreysCountyParser(), "HUMPHREYS COUNTY", "TN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(E911) PER F401 THERE IS A MANDATORY VKF TRAINING TONIGHT AT CITY HALL 7PM",
        "CALL:GENERAL ALERT",
        "PLACE:PER F401 THERE IS A MANDATORY VKF TRAINING TONIGHT AT CITY HALL 7PM");

    doTest("T2",
        "(E911) 850 BROADWAY AVE, THOMPSON LIQ, APPEARS TO BE A FIRE BEHIND THE STORE IN A FIELD",
        "CALL:THOMPSON LIQ",
        "ADDR:850 BROADWAY AVE",
        "INFO:APPEARS TO BE A FIRE BEHIND THE STORE IN A FIELD");

    doTest("T3",
        "(E911) AMBULANCE REQ FOR 35 TRIPP RD, 67 Y/O MALE PATIENT HAS FALLEN AND WEIGHS OVER 300LBS AND PROMED IS REQ MAN POWER",
        "CALL:AMBULANCE REQ FOR",
        "ADDR:35 TRIPP RD",
        "INFO:67 Y/O MALE PATIENT HAS FALLEN AND WEIGHS OVER 300LBS AND PROMED IS REQ MAN POWER");

    doTest("T4",
        "(E911) STRUCTURE FIRE----APPROX 1 MILE DOWN BOX HOLLOW RD VISIBLE FLAMES---- NO OTHER STRUCTURES IN DANGER JUST BRUSH AND WOODS",
        "CALL:STRUCTURE FIRE----APPROX 1 MILE DOWN BOX",
        "ADDR:HOLLOW RD",
        "INFO:VISIBLE FLAMES---- NO OTHER STRUCTURES IN DANGER JUST BRUSH AND WOODS");

    doTest("T5",
        "(E911) f-401 adv that meeting for tonight has been canceled",
        "CALL:GENERAL ALERT",
        "PLACE:f-401 adv that meeting for tonight has been canceled");

    doTest("T6",
        "(E911) PRO-MED 58 REQUESTING ASSISTANCE AT 392 JAMES RD 80 Y/O/F POSSIBLY HAVING A HEART ATTACK THEY ARE ER FROM TRACE CR IN MCEWEN",
        "CALL:PRO-MED 58 REQUESTING ASSISTANCE",
        "ADDR:392 JAMES RD",
        "INFO:80 Y / O / F POSSIBLY HAVING A HEART ATTACK THEY ARE ER FROM TRACE CR IN MCEWEN");

    doTest("T7",
        "(E911) RAIL CAR LEAKING AT JOHNSONVILLE RAIL YARD CONTAINS SODIUM HYDROXIDE CSX ADVISED THEY JUST FOUND IT ON ITS SIDE",
        "CALL:GENERAL ALERT",
        "PLACE:RAIL CAR LEAKING AT JOHNSONVILLE RAIL YARD CONTAINS SODIUM HYDROXIDE CSX ADVISED THEY JUST FOUND IT ON ITS SIDE");

    doTest("T8",
        "(E911) AMBULANCE REQ 1714 LONG ST 70 Y/O/M COPD PATIENT BADLY SWOLLEN AND WILL TAKE SEVERAL MEN TO PICK HIM UP",
        "CALL:AMBULANCE REQ",
        "ADDR:1714 LONG ST",
        "INFO:70 Y / O / M COPD PATIENT BADLY SWOLLEN AND WILL TAKE SEVERAL MEN TO PICK HIM UP");

    doTest("T9",
        "(E911) ANY FIRE PERSONELL NOT BUSY F401 IS REQUESTING ONE OF YOU GO TO THE HALL AND GET REPORT FOR 737 CHEROKEE DR 10/07/2011 SMOKE SCARE, OWNER",
        "CALL:ANY FIRE PERSONELL NOT BUSY F401 IS REQUESTING ONE OF YOU GO TO THE HALL AND GET REPORT FOR",
        "ADDR:737 CHEROKEE DR",
        "INFO:SMOKE SCARE, OWNER");
  }
  

  public static void main(String[] args) {
    new TNHumphreysCountyParserTest().generateTests("T1", "CALL ADDR PLACE INFO");
  }
}
