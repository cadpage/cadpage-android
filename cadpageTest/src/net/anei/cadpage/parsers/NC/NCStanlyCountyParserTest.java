package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Stanly County, NC
Contact: "D. E. Gerald" <trafficfuzz@yahoo.com>
Sender:CAD@sclg.gov

CAD:E6-BREATHING PROBLEMS/533 BARRINGER CHAPEL RD/NOR/WIL-KRIS DR/FORK RD/[Medical Priority Info] PROBLEM: cant breathe # PATS: 1 AGE: 24 Years SE
CAD:E12-SEIZURES/CONVULSION/5761 DOVE LN/NOR/LOOP RD/[Medical Priority Info] PROBLEM: # PATS: 1 AGE: 49 Years SEX: Male CONSCIOUS: No BREATHING: Y
CAD:E6-BREATHING PROBLEMS/533 BARRINGER CHAPEL RD/NOR/WIL-KRIS DR/FORK RD/[Medical Priority Info] PROBLEM: cant breathe # PATS: 1 AGE: 24 Years SE
CAD:80-DWELLING ALARM/8947 WHITLEY RD/NOR/W WHITLEY ST﻿
CAD:80-STRUCTURE ALARM/9029 COTTONVILLE RD/NOR/HINSON RD/S STANLY SCHOOL RD/3 KEYPAD FIRE ALARM, 2 BURGLAR, AND HOLD UP ALARM [03/03/11 19:12:48 C﻿
CAD:E10-CHEST PAINS/231 PRICE ST/NOR/CARVER ST/WIL-KRIS DR/[Medical Priority Info] PROBLEM: CHEST PAIINS.VOMITTING # PATS: 1 AGE: 66 Years SEX: Ma
CAD:80-STRUCTURE ALARM/OLD CHARLOTTE RD/HARWOOD ST/ALB/SMOKE COMING FROM BARN ON OLD CHARLOTTE [04/03/11 17:44:15 BWHITLEY] B/T HARWOOD AND COBLE [04/03/11 17:
CAD:80-STRUCTURE ALARM/1700 WOODHURST LN/ALB/BIRD RD/ANDERSON RD/manual activation [04/03/11 17:54:08 DSHAVER]
CAD:80-DWELLING ALARM/601 EAST ST/ALB/N SEVENTH ST/N EIGHTH ST

Contact: Chris Allan <nlcap2405@gmail.com>
CAD:E13-DIABETIC PROBLEMS/40206 US 52 HWY N/NEW/AUSTIN RD/[Medical Priority Info] PROBLEM: diab prob # PATS: 1 AGE: 83 Years SEX: Male

Contact: Roger Stamper <capt3607@gmail.com>
CAD:E26-SICK PERSON/28345 ROWLAND RD/MTP/[Medical Priority Info] PROBLEM: HIGH FEVER, SINUS INFECTION, VOMITING # PATS: 1 AGE: 15 Years SEX: Female CONSCIOUS: Yes BREATHIN

Contact: Brian Shie <bshue4637@gmail.com>
CAD:E17-FALL WITH INJURY/614 NC HWY 200 S/SFD/COYLE RD/NC 200 HWY/[Medical Priority Info] PROBLEM: FELL POSS SEIZURE RELATED # PATS: 1 AGE: 50 Yea
CAD:80-BRUSH ALARM/ROCK HOLE RD/NC 200 HWY/SFD/WHEAT FIELD CUT BUT ON FIRE / APPX 1 ACRE [07/02/11 18:42:57 TSMITH] ONTO ROCK HOLE ON LEFT [07/02/

Contact: "inque74@hotmail.com" <inque74@hotmail.com>
CAD:E29-10-50 PI/249 DEESE ST/RFD/GOLD BRANCH RD/N CEMETERY ST/[Medical Priority Info] PROBLEM: car flipped # PATS: 1 AGE: 16 Years SEX: Female CONSCIOUS: Yes BREATHIN

Contact: Daniel Isenhour <d.isenhour8799@gmail.com>
Sender: CAD@sclg.gov
CAD:E4-ASSAULT/RAPE/5558 WAGONER RD/GLH/US 52 HWY N/[PROQA] RESPONSE: Bravo Questions: 89-year-old, Male, Conscious, Breathing. Assault / Sexual Assault Code: 4-B-3-A:

*/

public class NCStanlyCountyParserTest extends BaseParserTest {
  
  public NCStanlyCountyParserTest() {
    setParser(new NCStanlyCountyParser(), "STANLY COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:E6-BREATHING PROBLEMS/533 BARRINGER CHAPEL RD/NOR/WIL-KRIS DR/FORK RD/[Medical Priority Info] PROBLEM: cant breathe # PATS: 1 AGE: 24 Years SE",
        "CALL:E6-BREATHING PROBLEMS",
        "ADDR:533 BARRINGER CHAPEL RD",
        "CITY:NORWOOD",
        "X:WIL-KRIS DR & FORK RD",
        "INFO:cant breathe # PATS: 1 AGE: 24 Years SE");

    doTest("T2",
        "CAD:E12-SEIZURES/CONVULSION/5761 DOVE LN/NOR/LOOP RD/[Medical Priority Info] PROBLEM: # PATS: 1 AGE: 49 Years SEX: Male CONSCIOUS: No BREATHING: Y",
        "CALL:E12-SEIZURES/CONVULSION",
        "ADDR:5761 DOVE LN",
        "CITY:NORWOOD",
        "X:LOOP RD",
        "INFO:# PATS: 1 AGE: 49 Years SEX: Male CONSCIOUS: No BREATHING: Y");

    doTest("T3",
        "CAD:E6-BREATHING PROBLEMS/533 BARRINGER CHAPEL RD/NOR/WIL-KRIS DR/FORK RD/[Medical Priority Info] PROBLEM: cant breathe # PATS: 1 AGE: 24 Years SE",
        "CALL:E6-BREATHING PROBLEMS",
        "ADDR:533 BARRINGER CHAPEL RD",
        "CITY:NORWOOD",
        "X:WIL-KRIS DR & FORK RD",
        "INFO:cant breathe # PATS: 1 AGE: 24 Years SE");

    doTest("T4",
        "CAD:80-DWELLING ALARM/8947 WHITLEY RD/NOR/W WHITLEY ST",
        "CALL:80-DWELLING ALARM",
        "ADDR:8947 WHITLEY RD",
        "CITY:NORWOOD",
        "X:W WHITLEY ST");

    doTest("T5",
        "CAD:80-STRUCTURE ALARM/9029 COTTONVILLE RD/NOR/HINSON RD/S STANLY SCHOOL RD/3 KEYPAD FIRE ALARM, 2 BURGLAR, AND HOLD UP ALARM [03/03/11 19:12:48 C﻿",
        "CALL:80-STRUCTURE ALARM",
        "ADDR:9029 COTTONVILLE RD",
        "CITY:NORWOOD",
        "X:HINSON RD & S STANLY SCHOOL RD",
        "INFO:3 KEYPAD FIRE ALARM, 2 BURGLAR, AND HOLD UP ALARM",
        "DATE:03/03/11",
        "TIME:19:12:48");

    doTest("T6",
        "CAD:E10-CHEST PAINS/231 PRICE ST/NOR/CARVER ST/WIL-KRIS DR/[Medical Priority Info] PROBLEM: CHEST PAIINS.VOMITTING # PATS: 1 AGE: 66 Years SEX: Ma",
        "CALL:E10-CHEST PAINS",
        "ADDR:231 PRICE ST",
        "CITY:NORWOOD",
        "X:CARVER ST & WIL-KRIS DR",
        "INFO:CHEST PAIINS.VOMITTING # PATS: 1 AGE: 66 Years SEX: Ma");

    doTest("T7",
        "CAD:80-STRUCTURE ALARM/OLD CHARLOTTE RD/HARWOOD ST/ALB/SMOKE COMING FROM BARN ON OLD CHARLOTTE [04/03/11 17:44:15 BWHITLEY] B/T HARWOOD AND COBLE [04/03/11 17:",
        "CALL:80-STRUCTURE ALARM",
        "ADDR:OLD CHARLOTTE RD & HARWOOD ST",
        "CITY:ALBEMARLE",
        "INFO:SMOKE COMING FROM BARN ON OLD CHARLOTTE / B / T HARWOOD AND COBLE",
        "DATE:04/03/11",
        "TIME:17:44:15");

    doTest("T8",
        "CAD:80-STRUCTURE ALARM/1700 WOODHURST LN/ALB/BIRD RD/ANDERSON RD/manual activation [04/03/11 17:54:08 DSHAVER]",
        "CALL:80-STRUCTURE ALARM",
        "ADDR:1700 WOODHURST LN",
        "CITY:ALBEMARLE",
        "X:BIRD RD & ANDERSON RD",
        "INFO:manual activation",
        "DATE:04/03/11",
        "TIME:17:54:08");

    doTest("T9",
        "CAD:80-DWELLING ALARM/601 EAST ST/ALB/N SEVENTH ST/N EIGHTH ST",
        "CALL:80-DWELLING ALARM",
        "ADDR:601 EAST ST",
        "CITY:ALBEMARLE",
        "X:N SEVENTH ST & N EIGHTH ST");

    doTest("T10",
        "CAD:E13-DIABETIC PROBLEMS/40206 US 52 HWY N/NEW/AUSTIN RD/[Medical Priority Info] PROBLEM: diab prob # PATS: 1 AGE: 83 Years SEX: Male",
        "CALL:E13-DIABETIC PROBLEMS",
        "ADDR:40206 US 52 HWY N",
        "MADDR:40206 US 52 N",
        "CITY:NEW LONDON",
        "X:AUSTIN RD",
        "INFO:diab prob # PATS: 1 AGE: 83 Years SEX: Male");

    doTest("T11",
        "CAD:E26-SICK PERSON/28345 ROWLAND RD/MTP/[Medical Priority Info] PROBLEM: HIGH FEVER, SINUS INFECTION, VOMITING # PATS: 1 AGE: 15 Years SEX: Female CONSCIOUS: Yes BREATHIN",
        "CALL:E26-SICK PERSON",
        "ADDR:28345 ROWLAND RD",
        "CITY:MT PLEASANT",
        "INFO:HIGH FEVER, SINUS INFECTION, VOMITING # PATS: 1 AGE: 15 Years SEX: Female CONSCIOUS: Yes BREATHIN");

    doTest("T12",
        "CAD:E17-FALL WITH INJURY/614 NC HWY 200 S/SFD/COYLE RD/NC 200 HWY/[Medical Priority Info] PROBLEM: FELL POSS SEIZURE RELATED # PATS: 1 AGE: 50 Yea",
        "CALL:E17-FALL WITH INJURY",
        "ADDR:614 NC HWY 200 S",
        "MADDR:614 STATE 200 S",
        "CITY:STANFIELD",
        "X:COYLE RD & NC 200 HWY",
        "INFO:FELL POSS SEIZURE RELATED # PATS: 1 AGE: 50 Yea");

    doTest("T13",
        "CAD:80-BRUSH ALARM/ROCK HOLE RD/NC 200 HWY/SFD/WHEAT FIELD CUT BUT ON FIRE / APPX 1 ACRE [07/02/11 18:42:57 TSMITH] ONTO ROCK HOLE ON LEFT [07/02/",
        "CALL:80-BRUSH ALARM",
        "ADDR:ROCK HOLE RD & NC 200 HWY",
        "MADDR:ROCK HOLE RD & STATE 200",
        "CITY:STANFIELD",
        "INFO:WHEAT FIELD CUT BUT ON FIRE / APPX 1 ACRE / ONTO ROCK HOLE ON LEFT",
        "DATE:07/02/11",
        "TIME:18:42:57");

    doTest("T14",
        "CAD:E29-10-50 PI/249 DEESE ST/RFD/GOLD BRANCH RD/N CEMETERY ST/[Medical Priority Info] PROBLEM: car flipped # PATS: 1 AGE: 16 Years SEX: Female CONSCIOUS: Yes BREATHIN",
        "CALL:E29-10-50 PI",
        "ADDR:249 DEESE ST",
        "CITY:RICHFIELD",
        "X:GOLD BRANCH RD & N CEMETERY ST",
        "INFO:car flipped # PATS: 1 AGE: 16 Years SEX: Female CONSCIOUS: Yes BREATHIN");
  }

  @Test
  public void testDanielIsenhour() {

    doTest("T1",
        "CAD:E4-ASSAULT/RAPE/5558 WAGONER RD/GLH/US 52 HWY N/[PROQA] RESPONSE: Bravo Questions: 89-year-old, Male, Conscious, Breathing. Assault / Sexual Assault Code: 4-B-3-A:",
        "CALL:E4-ASSAULT/RAPE",
        "ADDR:5558 WAGONER RD",
        "CITY:GOLD HILL",
        "X:US 52 HWY N",
        "INFO:RESPONSE: Bravo Questions: 89-year-old, Male, Conscious, Breathing. Assault / Sexual Assault Code: 4-B-3-A:");

  }

  public static void main(String[] args) {
    new NCStanlyCountyParserTest().generateTests("T1");
  }
}
