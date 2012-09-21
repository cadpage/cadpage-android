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

    doTest("T2",
        "marshalltwpfire+caf_=2692824689=vtext.com@gmail.com PRI: 0 INC: F13120111000007 TYP: UNKNOWN ACCIDENT AD: MICHIGAN AVE&I69 SB CTY: MT CN: DENISE MATHERS CMT1: CALLER HEARD WHAT SOU",
        "PRI:0",
        "ID:F13120111000007",
        "CALL:UNKNOWN ACCIDENT",
        "ADDR:MICHIGAN AVE & I69 SB",
        "MADDR:MICHIGAN AVE & I 69",
        "CITY:MARSHALL TWP",
        "NAME:DENISE MATHERS",
        "INFO:CALLER HEARD WHAT SOU");
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "[] PRI: 1 INC: F07120614000534 TYP: BRUSH/GRASS FIRE AD: 321 SAWYER ST CTY: ET LOC: CALLBK=(517)962-1010 CN: DUSTIN NELSON CMT1: 10X10 FOOT BRUSH FIRE MOVING TWD THE WOODS, NOT THREAT TO STRUCTURES CMT2: Original Location : CALLBK=(517)962-101\n",
        "PRI:1",
        "ID:F07120614000534",
        "CALL:BRUSH/GRASS FIRE",
        "ADDR:321 SAWYER ST",
        "CITY:EMMETT TWP",
        "PHONE:(517)962-1010",
        "NAME:DUSTIN NELSON",
        "INFO:10X10 FOOT BRUSH FIRE MOVING TWD THE WOODS, NOT THREAT TO STRUCTURES / Original Location : CALLBK=(517)962-101");

    doTest("T2",
        "[] PRI: 1 INC: F07120614000534 TYP: BRUSH/GRASS FIRE AD: 321 SAWYER ST CTY: ET LOC: CALLBK=(517)962-1010 CN: DUSTIN NELSON CMT1: 10X10 FOOT BRUSH FIRE MOVING TWD THE WOODS, NOT THREAT TO STRUCTURES CMT2: Original Location : CALLBK=(517)962-101\n",
        "PRI:1",
        "ID:F07120614000534",
        "CALL:BRUSH/GRASS FIRE",
        "ADDR:321 SAWYER ST",
        "CITY:EMMETT TWP",
        "PHONE:(517)962-1010",
        "NAME:DUSTIN NELSON",
        "INFO:10X10 FOOT BRUSH FIRE MOVING TWD THE WOODS, NOT THREAT TO STRUCTURES / Original Location : CALLBK=(517)962-101");

    doTest("T3",
        "[] PRI: 1 INC: F07120615000535 TYP: P1 MEDICAL AD: 1275 E MICHIGAN AVE CTY: ET CN: AMBLER,LORI CMT1: CE: 87 YEAR OLD FEMALE CONSCIOUS BREATHING BREATHING PROBLEMS CALLER CMT2: STATEMENT: RESIDENT TRBL BREATHING TIME: 09:27 0707PAGE1 0707ONDTY \n",
        "PRI:1",
        "ID:F07120615000535",
        "CALL:P1 MEDICAL",
        "ADDR:1275 E MICHIGAN AVE",
        "CITY:EMMETT TWP",
        "NAME:AMBLER,LORI",
        "INFO:CE: 87 YEAR OLD FEMALE CONSCIOUS BREATHING BREATHING PROBLEMS CALLER / STATEMENT: RESIDENT TRBL BREATHING",
        "TIME:09:27",
        "UNIT:0707PAGE1 0707ONDTY");

    doTest("T4",
        "[] PRI: 1 INC: F07120615000536 TYP: P1 MEDICAL AD: 11177 MICHIGAN AVE CTY: ET LOC: FIREKEEPERS CASINO CN: FIREKEEPERS DEVELOPM CMT1: RESTROOM-USE BUS ENTR CMT2: CE: 25 YEAR OLD MALE UNCONSCIOUS BREATHING STATUS UNKNOWN CARDIAC OR TIME: 10:44 0\n",
        "PRI:1",
        "ID:F07120615000536",
        "CALL:P1 MEDICAL",
        "ADDR:11177 MICHIGAN AVE",
        "CITY:EMMETT TWP",
        "PLACE:FIREKEEPERS CASINO",
        "NAME:FIREKEEPERS DEVELOPM",
        "INFO:RESTROOM-USE BUS ENTR / CE: 25 YEAR OLD MALE UNCONSCIOUS BREATHING STATUS UNKNOWN CARDIAC OR",
        "TIME:10:44",
        "UNIT:0");

    doTest("T5",
        "[] PRI: 1 INC: F07120615000537 TYP: P1 MEDICAL AD: 11177 MICHIGAN AVE CTY: ET LOC: FIREKEEPERS CASINO CN: FIREKEEPERS DEVELOPM CMT1: REQUESTING MEDICAL P1. CMT2: SiblingInc LET120615003613 UPDATE PriUnt to ET/761 TIME: 13:46 0707PAGE1 070752 0\n",
        "PRI:1",
        "ID:F07120615000537",
        "CALL:P1 MEDICAL",
        "ADDR:11177 MICHIGAN AVE",
        "CITY:EMMETT TWP",
        "PLACE:FIREKEEPERS CASINO",
        "NAME:FIREKEEPERS DEVELOPM",
        "INFO:REQUESTING MEDICAL P1. / SiblingInc LET120615003613 UPDATE PriUnt to ET/761",
        "TIME:13:46",
        "UNIT:0707PAGE1 070752 0");

    doTest("T6",
        "[] PRI: 1 INC: F07120615000538 TYP: P1 MEDICAL AD: 142 JERICHO RD CTY: ET CN: AUTUMN HAWKINS CMT1: DAUGHTER IS NOT RESPONDING WELL CMT2: CE: 2 YEAR OLD FEMALE UNCONSCIOUS BREATHING UNCONSCIOUS / FAINTING (N TIME: 20:33 0707PAGE1 0707ONDTY 07EF\n",
        "PRI:1",
        "ID:F07120615000538",
        "CALL:P1 MEDICAL",
        "ADDR:142 JERICHO RD",
        "CITY:EMMETT TWP",
        "NAME:AUTUMN HAWKINS",
        "INFO:DAUGHTER IS NOT RESPONDING WELL / CE: 2 YEAR OLD FEMALE UNCONSCIOUS BREATHING UNCONSCIOUS / FAINTING (N",
        "TIME:20:33",
        "UNIT:0707PAGE1 0707ONDTY 07EF");

    doTest("T7",
        "[] PRI: 2 INC: F07120616000539 TYP: ODOR INSIDE APT: 1/2 AD: 560 WESTBROOK AVE CTY: ET CN: CHAD JUAREZ CMT1: VERY STRONG ODOR OF NATURAL GAS-CALLER DID HAVE A HEADACHE BUT AFTER OPEI CMT2: NG A COUPLE WINDOWS, HE AND HIS WIFE GOT OUT. HE WOULD\n",
        "PRI:2",
        "ID:F07120616000539",
        "CALL:ODOR INSIDE",
        "APT:1/2",
        "ADDR:560 WESTBROOK AVE",
        "CITY:EMMETT TWP",
        "NAME:CHAD JUAREZ",
        "INFO:VERY STRONG ODOR OF NATURAL GAS-CALLER DID HAVE A HEADACHE BUT AFTER OPEI / NG A COUPLE WINDOWS, HE AND HIS WIFE GOT OUT. HE WOULD");

  }
  
  public static void main(String[] args) {
    new MICalhounCountyParserTest().generateTests("T1");
  }
}
