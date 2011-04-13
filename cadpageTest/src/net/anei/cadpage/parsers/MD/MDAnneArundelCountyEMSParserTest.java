package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MDAnneArundelCountyEMSParserTest extends BaseParserTest {
  
  public MDAnneArundelCountyEMSParserTest() {
    setParser(new MDAnneArundelCountyEMSParser(), "ANNE ARUNDEL COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "*Medical Box 28-8 1496 ANNAPOLIS RD  [BLOCKBUSTER VIDEO] 12-F1 E281,MU29 MVC; 2306 [14/81]  /lm-33/",
        "BOX:28-8",
        "ADDR:1496 ANNAPOLIS RD",
        "PLACE:BLOCKBUSTER VIDEO",
        "MAP:12-F1",
        "UNIT:E281,MU29",
        "CALL:MVC");

    doTest("T2",
        "*MEDICAL Box 28-13 TELEGRAPH RD/JACKSON GROVE RD 6-K13 E283,MU4 FAINTING; 1328 [9/90]  14m-2",
        "BOX:28-13",
        "ADDR:TELEGRAPH RD & JACKSON GROVE RD",
        "MAP:6-K13",
        "UNIT:E283,MU4",
        "CALL:FAINTING");

    doTest("T3",
        "Medical Box 34-5 7390 BALTO ANNAP BLVD  [MTA LIGHT RAIL CROMWELL] 7-J1 TK33,MU21,A28 ABDOM PAIN; 1256 [8/89]",
        "BOX:34-5",
        "ADDR:7390 BALTO ANNAP BLVD",
        "PLACE:MTA LIGHT RAIL CROMWELL",
        "MAP:7-J1",
        "UNIT:TK33,MU21,A28",
        "CALL:ABDOM PAIN");

    doTest("T4",
        "*MEDICAL Box 5-22 1325 GREYSWOOD RD (CHAPELVIEW DR) 12-H6 E283,MU6 BREATHING PROB; 1145 [7/88]  22d-20",
        "BOX:5-22",
        "ADDR:1325 GREYSWOOD RD",
        "X:CHAPELVIEW DR",
        "MAP:12-H6",
        "UNIT:E283,MU6",
        "CALL:BREATHING PROB");

    doTest("T5",
        "*Medical Box 28-8 1496 ANNAPOLIS RD  [BLOCKBUSTER VIDEO] 12-F1 E281,MU29 MVC; 2306 [14/81]  lm-33",
        "BOX:28-8",
        "ADDR:1496 ANNAPOLIS RD",
        "PLACE:BLOCKBUSTER VIDEO",
        "MAP:12-F1",
        "UNIT:E281,MU29",
        "CALL:MVC");

    doTest("T6",
        "*Medical Box 28-27 PINEY ORCHARD PKWY/RIVERSCAPE RD 12-E7 E281,PM26 MVC; 1415 [6/91]  lm-8",
        "BOX:28-27",
        "ADDR:PINEY ORCHARD PKWY & RIVERSCAPE RD",
        "MAP:12-E7",
        "UNIT:E281,PM26",
        "CALL:MVC");

    doTest("T7",
        "MEDICAL Box 28-27 RIVERSCAPE RD/RUNNING WOLF TRL 12-F8 E283,MU21 CHEST PAIN; 2010 [13/78]",
        "BOX:28-27",
        "ADDR:RIVERSCAPE RD & RUNNING WOLF TRL",
        "MAP:12-F8",
        "UNIT:E283,MU21",
        "CALL:CHEST PAIN");

    doTest("T8",
        "Local Box 28-27 2615 LOTUSWOOD CT (RIVERSCAPE RD) 12-E7 E283 SERVICE CALL (COLD); 1740 [9/293]",
        "BOX:28-27",
        "ADDR:2615 LOTUSWOOD CT",
        "X:RIVERSCAPE RD",
        "MAP:12-E7",
        "UNIT:E283",
        "CALL:SERVICE CALL (COLD)");

    doTest("T9",
        "*MEDICAL Box 28-27 8718 THORNBROOK DR (RIVERSCAPE RD) 12-E7 E281,MU6 HEADACHE; BURNING INSIDE  2001 [15/297]  41m-1",
        "BOX:28-27",
        "ADDR:8718 THORNBROOK DR",
        "X:RIVERSCAPE RD",
        "MAP:12-E7",
        "UNIT:E281,MU6",
        "CALL:HEADACHE BURNING INSIDE");

    doTest("T10",
        "*MEDICAL Box 28-27 8700 NATURES TRAIL CT  [Unit 304] (RIVERSCAPE RD) 12-E8 A28,PM5 BREATHING PROB; 0524 [4/313]  6m-5",
        "BOX:28-27",
        "ADDR:8700 NATURES TRAIL CT",
        "PLACE:Unit 304",
        "X:RIVERSCAPE RD",
        "MAP:12-E8",
        "UNIT:A28,PM5",
        "CALL:BREATHING PROB");

    doTest("T11",
        "*Medical Box 28-6 2012 BEALMEAR MILL LN  [Unit 7208] (COWMAN CT) 12-G1 E281,MU29 BACK PAIN; 0539 [1/68]  25d-2",
        "BOX:28-6",
        "ADDR:2012 BEALMEAR MILL LN",
        "PLACE:Unit 7208",
        "X:COWMAN CT",
        "MAP:12-G1",
        "UNIT:E281,MU29",
        "CALL:BACK PAIN");
  }
  
  public static void main(String[] args) {
    new MDAnneArundelCountyEMSParserTest().generateTests("T1", "BOX ADDR PLACE X MAP UNIT CALL");
  }
}