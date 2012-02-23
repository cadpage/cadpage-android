package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class ORLaneCountyParserTest extends BaseParserTest {
  
  public ORLaneCountyParserTest() {
    setParser(new ORLaneCountyParser(), "LANE COUNTY", "OR");
  }
  
  @Test
  public void testParser() {

    doTest("T4",
        "FRM:ce911@ci.eugene.or.us\nMSG:LRF TYP: VEHICLE VS PED ACC AD: TORRINGTON AVE&LYNNBROOK DR CTY: EUGENE MAP: EF557 C TIME: 08:12",
        "SRC:LRF",
        "CALL:VEHICLE VS PED ACC",
        "ADDR:TORRINGTON AVE & LYNNBROOK DR",
        "CITY:EUGENE",
        "MAP:EF557 C",
        "TIME:08:12");

    doTest("T5",
        "FRM:ce911@ci.eugene.or.us\n" +
        "MSG:LRF TYP: TRAUMA B AD: 92609 TERRITORIAL HWY CTY: UNC JUN MAP: LR05331 LOC: SCH TERRITORIAL ELEM TIME: 11:20",

        "SRC:LRF",
        "CALL:TRAUMA B",
        "ADDR:92609 TERRITORIAL HWY",
        "CITY:JUNCTION CITY",
        "MAP:LR05331",
        "PLACE:SCH TERRITORIAL ELEM",
        "TIME:11:20");

    doTest("T6",
        "FRM:ce911@ci.eugene.or.us\nMSG:LDF TYP: MEDICAL EMERGENCY AD: N MODESTO DR&GIMPL HILL RD CTY: UNC EUG MAP: LF00013 TIME: 22:23",
        "SRC:LDF",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:N MODESTO DR & GIMPL HILL RD",
        "CITY:EUGENE",
        "MAP:LF00013",
        "TIME:22:23");

    doTest("T7",
        "FRM:ce911@ci.eugene.or.us\nMSG:LRF TYP: STRUCTURE FIRE AD: 18152 HWY 36 CTY: UNC BLA MAP: LK00021 LOC: 18152 HWY 36 TIME: 09:30",
        "SRC:LRF",
        "CALL:STRUCTURE FIRE",
        "ADDR:18152 HWY 36",
        "CITY:BLACHLY",
        "MAP:LK00021",
        "PLACE:18152 HWY 36",
        "TIME:09:30");

    doTest("T8",
        "FRM:ce911@ci.eugene.or.us\n" +
        "MSG:LDF TYP: BLEEDING D AD: 88267 TERRITORIAL RD CTY: VENETA MAP: LF00008 LOC: DON JUAN RESTAURANT TIME: 18:03",

        "SRC:LDF",
        "CALL:BLEEDING D",
        "ADDR:88267 TERRITORIAL RD",
        "CITY:VENETA",
        "MAP:LF00008",
        "PLACE:DON JUAN RESTAURANT",
        "TIME:18:03");

    doTest("T9",
        "FRM:ce911@ci.eugene.or.us\nMSG:LDF TYP: MVA AD: CANTRELL RD&CENTRAL RD CTY: UNC EUG MAP: LF00008 TIME: 15:41",
        "SRC:LDF",
        "CALL:MVA",
        "ADDR:CANTRELL RD & CENTRAL RD",
        "CITY:EUGENE",
        "MAP:LF00008",
        "TIME:15:41");

    doTest("T10",
        "FRM:ce911@ci.eugene.or.us\nMSG:LDF TYP: CHEST PAIN C AD: 29733 LUSK RD CTY: UNC EUG MAP: LF00015 TIME: 07:37",
        "SRC:LDF",
        "CALL:CHEST PAIN C",
        "ADDR:29733 LUSK RD",
        "CITY:EUGENE",
        "MAP:LF00015",
        "TIME:07:37");
    
  }
  
  public static void main(String args[]) {
    new ORLaneCountyParserTest().generateTests("T4", "SRC CALL ADDR APT CITY MAP PLACE TIME");
  }
}