package net.anei.cadpage.parsers;

import org.junit.Test;


public class VARockinghamCountyParserTest extends BaseParserTest {
  
  public VARockinghamCountyParserTest() {
    setParser(new VARockinghamCountyParser(), "ROCKINGHAM COUNTY", "VA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "R40 EMS-CARDIAC CONDITION 1751 MAIN AVE HAR CFS# 2010-082726 CROSS: GARBERS CHURCH RD/S HIGH ST",
        "CALL:EMS-CARDIAC CONDITION",
        "ADDR:1751 MAIN AVE",
        "CITY:HARRISONBURG",
        "ID:2010-082726",
        "X:GARBERS CHURCH RD/S HIGH ST");

    doTest("T2",
        "R40 EMS-MENTAL PROBLEM 445 N MAIN ST 44 HAR CFS# 2010-082451 CROSS: WOLFE ST/ROCK ST",
        "CALL:EMS-MENTAL PROBLEM",
        "ADDR:445 N MAIN ST 44",
        "CITY:HARRISONBURG",
        "ID:2010-082451",
        "X:WOLFE ST/ROCK ST");
    
    doTest("T3",
        "R40 EMS-ABDOMINAL PAIN 1737 MORELAND DR HAR CFS# 2010-083119 CROSS: PHEASANT RUN CIR/ASHFORD CT",
        "CALL:EMS-ABDOMINAL PAIN",
        "ADDR:1737 MORELAND DR",
        "CITY:HARRISONBURG",
        "ID:2010-083119",
        "X:PHEASANT RUN CIR/ASHFORD CT");
    
    doTest("T4",
        "R40 EMS-CHEST PAIN 235 LAYMAN ST 101 HAR CFS# 2010-083046 CROSS: N MAIN ST/LONGVIEW DR",
        "CALL:EMS-CHEST PAIN",
        "ADDR:235 LAYMAN ST 101",
        "CITY:HARRISONBURG",
        "ID:2010-083046",
        "X:N MAIN ST/LONGVIEW DR");
    
    doTest("T5",
        "R40 TRAFFIC CRASH 300 BOYERS RD BLK HAR CFS# 2010-082984 CROSS: MYSTIC WOODS LN/CULLISON CT",
        "CALL:TRAFFIC CRASH",
        "ADDR:300 BOYERS RD",
        "CITY:HARRISONBURG",
        "ID:2010-082984",
        "X:MYSTIC WOODS LN/CULLISON CT");
        
    doTest("T6",
        "R40 TRAFFIC CRASH RESERVOIR ST & CANTRELL AV HAR CFS# 2010-082327",
        "CALL:TRAFFIC CRASH",
        "ADDR:RESERVOIR ST & CANTRELL AV",
        "CITY:HARRISONBURG",
        "ID:2010-082327");
  }
}
