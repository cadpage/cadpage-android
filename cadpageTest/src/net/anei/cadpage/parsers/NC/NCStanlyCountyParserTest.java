package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


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
        "CAD:80-DWELLING ALARM/8947 WHITLEY RD/NOR/W WHITLEY ST﻿",
        "CALL:80-DWELLING ALARM",
        "ADDR:8947 WHITLEY RD",
        "CITY:NORWOOD",
        "X:W WHITLEY ST﻿");

    doTest("T5",
        "CAD:80-STRUCTURE ALARM/9029 COTTONVILLE RD/NOR/HINSON RD/S STANLY SCHOOL RD/3 KEYPAD FIRE ALARM, 2 BURGLAR, AND HOLD UP ALARM [03/03/11 19:12:48 C﻿",
        "CALL:80-STRUCTURE ALARM",
        "ADDR:9029 COTTONVILLE RD",
        "CITY:NORWOOD",
        "X:HINSON RD & S STANLY SCHOOL RD",
        "INFO:3 KEYPAD FIRE ALARM, 2 BURGLAR, AND HOLD UP ALARM");

    doTest("T6",
        "CAD:E10-CHEST PAINS/231 PRICE ST/NOR/CARVER ST/WIL-KRIS DR/[Medical Priority Info] PROBLEM: CHEST PAIINS.VOMITTING # PATS: 1 AGE: 66 Years SEX: Ma",
        "CALL:E10-CHEST PAINS",
        "ADDR:231 PRICE ST",
        "CITY:NORWOOD",
        "X:CARVER ST & WIL-KRIS DR",
        "INFO:CHEST PAIINS.VOMITTING # PATS: 1 AGE: 66 Years SEX: Ma");
  }
  

  public static void main(String[] args) {
    new NCStanlyCountyParserTest().generateTests("T1");
  }
}
