package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MICalhounCountyParserTest extends BaseParserTest {
  
  public MICalhounCountyParserTest() {
	  setParser(new MICalhounCountyParser(), "CALHOUN COUNTY", "MI");
  }
  
  @Test
  public void testParser() {

      doTest("T1",
          "PRI: 0 INC: F15111123000853 TYP: UNKN ROLLOVER ACC AD: 10921 BELLEVUE RD CTY: PT CN: GAW, LEWIS TIME: 07:30 151531 XST: 20199 11",
          "PRI:0",
          "ID:F15111123000853",
          "CALL:UNKN ROLLOVER ACC",
          "ADDR:10921 BELLEVUE RD",
          "CITY:PENNFIELD TWP",
          "NAME:GAW, LEWIS",
          "TIME:07:30",
          "UNIT:151531",
          "X:20199 11");

      doTest("T2",
          "PRI: 2 INC: F15111123000852 TYP: TREE/LIMB DOWN AD: CLEAR LAKE RD&WALKINSHAW RD CTY: PT CN: BILL BAMMER CMT1: TREE DOWN BLOCKING",
          "PRI:2",
          "ID:F15111123000852",
          "CALL:TREE/LIMB DOWN",
          "ADDR:CLEAR LAKE RD & WALKINSHAW RD",
          "CITY:PENNFIELD TWP",
          "NAME:BILL BAMMER",
          "INFO:TREE DOWN BLOCKING");

      doTest("T3",
          "PRI: 1 INC: F15111122000851 TYP: P1 MEDICAL APT: 19 AD: 1419 NE CAPITAL AVE CTY: PT LOC: PINES AT PENNFIELD CN: FEMALE CMT1: PIN",
          "PRI:1",
          "ID:F15111122000851",
          "CALL:P1 MEDICAL",
          "APT:19",
          "ADDR:1419 NE CAPITAL AVE",
          "CITY:PENNFIELD TWP",
          "PLACE:PINES AT PENNFIELD",
          "NAME:FEMALE",
          "INFO:PIN");

      doTest("T4",
          "PRI: 2 INC: F15111121000849 TYP: CITIZEN ASSIST AD: 1427 NE CAPITAL AVE CTY: PT LOC: PINES AT PENNFIELD CN: TAKESH WORTHEM CMT1:",
          "PRI:2",
          "ID:F15111121000849",
          "CALL:CITIZEN ASSIST",
          "ADDR:1427 NE CAPITAL AVE",
          "CITY:PENNFIELD TWP",
          "PLACE:PINES AT PENNFIELD",
          "NAME:TAKESH WORTHEM");

      doTest("T5",
          "PRI: 1 INC: F15111121000850 TYP: P1 MEDICAL AD: 23650 M78 CTY: PT LOC: MELVIN WHITING RESD CN: LIFEALERT CMT1: --89YOM--HEART BE",
          "PRI:1",
          "ID:F15111121000850",
          "CALL:P1 MEDICAL",
          "ADDR:23650 MI 78",
          "CITY:PENNFIELD TWP",
          "PLACE:MELVIN WHITING RESD",
          "NAME:LIFEALERT",
          "INFO:--89YOM--HEART BE");

      doTest("T6",
          "PRI: 2 INC: F15111121000849 TYP: CITIZEN ASSIST AD: 1427 NE CAPITAL AVE CTY: PT LOC: PINES AT PENNFIELD CN: TAKESH WORTHEM CMT1:",
          "PRI:2",
          "ID:F15111121000849",
          "CALL:CITIZEN ASSIST",
          "ADDR:1427 NE CAPITAL AVE",
          "CITY:PENNFIELD TWP",
          "PLACE:PINES AT PENNFIELD",
          "NAME:TAKESH WORTHEM");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "marshalltwpfire+caf_=2692824689=vtext.com@gmail.com PRI: 1 INC: F13120110000005 TYP: NO TYPE DESCRP AVAIL APT: 61 AD: 201 WEST DR N CTY: MT LOC: ASHGROVE APARTMENTS CN: BRIAN DARGI",
        "PRI:1",
        "ID:F13120110000005",
        "CALL:NO TYPE DESCRP AVAIL",
        "APT:61",
        "ADDR:201 WEST DR N",
        "CITY:MARSHALL TWP",
        "PLACE:ASHGROVE APARTMENTS",
        "NAME:BRIAN DARGI");
  }
  
  public static void main(String[] args) {
    new MICalhounCountyParserTest().generateTests("T1");
  }
}
