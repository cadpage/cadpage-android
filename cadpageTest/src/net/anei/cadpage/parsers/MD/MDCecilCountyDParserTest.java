package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*    
Cecil County, MD
Contact: "bradfordsnyder@verizon.net" <bradfordsnyder@verizon.net>
Sender: waterwitch73@zoominternet.net

ABDOMINAL PAIN\r\n01A01 (ABDOMINAL PAIN )\r\n35 N MAIN ST\r\nCENTER ST\r\nVANNORT DR\r\nPD\r\n12010817\r\n20:20:03\r\nMB 700  EMS OPS\r\n@A07 @PM1\r\n[P ABD PAIN ;22 YEAR OLD,
DIABETIC\n254 N MAIN ST\nVANNORT DR\nGRANITE AVE\nPD\n08:00:00\n[P DIABETIC ;81 YEAR OLD, FEMALE, CONSCIOUS, BREATHING.  DIABETICPROBLEMS.\n11021185\nEMS OPS
FALL\r\n\n17A01 (FALL )\r\n\n31 HEATHER LN @PILOT TRAVEL CENTER\r\n\nPV\r\n\n12010495\r\n\n04:47:10\r\n\nEMS OPS 0602\r\n\n@A06 P1 @A07\r\n\n[P MALE THAT FELL-POSSIBLE FX WRIST ;39 YEAR O
CHILD LOCKED IN AUTO\r\n\nCHILD (CHILD LOCKED IN AUTO)\r\n\n848 JACOB TOME MEMORIAL HWY\r\n\nWAIBEL RD\r\n\nDOWNIN LN\r\n\nPD\r\n\n12010532\r\n\n17:22:53\r\n\nOPS 6   704\r\n\n@E07 @A07\r\n\nBABY
[Update]\r\n\nOVERDOSE\r\n\n23C01 (OVERDOSE )\r\n\n11 LAGOON DR\r\n\nPD\r\n\n12010560\r\n\n12:18:18\r\n\nEMS     MB 701\r\n\n@A07 P1 @E07\r\n\n[P CARDIAC ARREST ;21 YEAR OLD, MALE, UNCONSCIOU
OVERDOSE\r\n\n23C01 (OVERDOSE )\r\n\n11 LAGOON DR\r\n\nPD\r\n\n12010560\r\n\n12:18:18\r\n\nEMS     MB 701\r\n\n@A07 @PM1\r\n\n[P CARDIAC ARREST ;21 YEAR OLD, MALE, UNCONSCIOUS, NOT BREATH
OVERDOSE\r\n\n23D01 (OVERDOSE )\r\n\n39 MAPLE HILL DR\r\n\nBUTTONWOOD LN\r\n\nBIRCH CT\r\n\nPD\r\n\n12010568\r\n\n17:54:55\r\n\nEMS OPS 701\r\n\n@A07 @PM1\r\n
GAS LEAK OUTSIDE\r\n\nGASOUT (GAS LEAK OUTSIDE )\r\n\nCONOWINGO RD / RT 222 - ROCK SPRING\r\n\nCONO\r\n\n12010571\r\n\n18:31:19\r\n\nFB 705  OPS 6\r\n\n@E07\r\n\nRT 1 RT 222 INTERSECTION 
HOUSE FIRE\r\n\nHOUSE (HOUSE FIRE )\r\n\n161 WILLARD DR\r\n\nSTITES LN\r\n\nLONGACRE DR\r\n\nNE\r\n\n12010825\r\n\n22:43:45\r\n\nFB 402  OPS 6\r\n\n@R04 @T04 @E04 @E04 @L04 @A04 @T08 @E05 @E0
FALL\r\n\n17D01 (FALL )\r\n\n188 SKYLINE DR\r\n\nCONO\r\n\n12010787\r\n\n10:10:41\r\n\nEMS OPS MB705\r\n\n@A07 @PM1\r\n\n[P MAN FELL OFF THE ROOF ;40 YEAR OLD, MALE, UNCONSCIOUS, BREATHIN
CHEST PAIN\n\n10D04 (CHEST PAIN )\n\n52 CRAIG CT\n\nCONO\n\n12005115\n\n21:13:22\n\nEMS OSP 0703\n\n@A07 @PM1\n\n443 655 0295 CEL[P HUSB HAVING CHEST PAINS ;51 YEAR OLD, MA

Contact: Firerich73 <firerich73@zoominternet.net>
Sender: waterwitch71@atlanticbbn.net
1 of 2\nFRM:waterwitch71@atlanticbbn.net\nMSG:RESPIRATORY DISTRESS\n429 CRAIGTOWN RD\nFUNK RD\nBARTON RD\nPD\n66 Y/O /RESP DISTRESS[P 66 Y/O M\n(Con't) 2 of 2\nRESP DIS ;66 YEAR OLD, MALE\n08:28:12\n12016804\nEMS OPS MB 704\n@A07 @PM1(End)

 */

public class MDCecilCountyDParserTest extends BaseParserTest {
  
  public MDCecilCountyDParserTest() {
    setParser(new MDCecilCountyDParser(), "CECIL COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "ABDOMINAL PAIN\r\n" +
        "01A01 (ABDOMINAL PAIN )\r\n" +
        "35 N MAIN ST\r\n" +
        "CENTER ST\r\n" +
        "VANNORT DR\r\n" +
        "PD\r\n" +
        "12010817\r\n" +
        "20:20:03\r\n" +
        "MB 700  EMS OPS\r\n" +
        "@A07 @PM1\r\n" +
        "[P ABD PAIN ;22 YEAR OLD,",

        "CALL:ABDOMINAL PAIN",
        "CODE:01A01",
        "ADDR:35 N MAIN ST",
        "X:CENTER ST & VANNORT DR",
        "CITY:PORT DEPOSIT",
        "ID:12010817",
        "TIME:20:20:03",
        "INFO:P ABD PAIN ;22 YEAR OLD,",
        "UNIT:A07 PM1",
        "CH:MB 700 EMS OPS");

    doTest("T2",
        "DIABETIC\n" +
        "254 N MAIN ST\n" +
        "VANNORT DR\n" +
        "GRANITE AVE\n" +
        "PD\n" +
        "08:00:00\n" +
        "[P DIABETIC ;81 YEAR OLD, FEMALE, CONSCIOUS, BREATHING.  DIABETICPROBLEMS.\n" +
        "11021185\n" +
        "EMS OPS",

        "CALL:DIABETIC",
        "ADDR:254 N MAIN ST",
        "X:VANNORT DR & GRANITE AVE",
        "CITY:PORT DEPOSIT",
        "ID:11021185",
        "TIME:08:00:00",
        "INFO:P DIABETIC ;81 YEAR OLD, FEMALE, CONSCIOUS, BREATHING. DIABETICPROBLEMS.",
        "CH:EMS OPS");

    doTest("T3",
        "FALL\r\n\n" +
        "17A01 (FALL )\r\n\n" +
        "31 HEATHER LN @PILOT TRAVEL CENTER\r\n\n" +
        "PV\r\n\n" +
        "12010495\r\n\n" +
        "04:47:10\r\n\n" +
        "EMS OPS 0602\r\n\n" +
        "@A06 P1 @A07\r\n\n" +
        "[P MALE THAT FELL-POSSIBLE FX WRIST ;39 YEAR O",

        "CALL:FALL",
        "CODE:17A01",
        "ADDR:31 HEATHER LN",
        "PLACE:PILOT TRAVEL CENTER",
        "CITY:PERRYVILLE",
        "ID:12010495",
        "TIME:04:47:10",
        "INFO:P MALE THAT FELL-POSSIBLE FX WRIST ;39 YEAR O",
        "UNIT:A06 P1 A07",
        "CH:EMS OPS 0602");

    doTest("T4",
        "CHILD LOCKED IN AUTO\r\n\n" +
        "CHILD (CHILD LOCKED IN AUTO)\r\n\n" +
        "848 JACOB TOME MEMORIAL HWY\r\n\n" +
        "WAIBEL RD\r\n\n" +
        "DOWNIN LN\r\n\n" +
        "PD\r\n\n" +
        "12010532\r\n\n" +
        "17:22:53\r\n\n" +
        "OPS 6   704\r\n\n" +
        "@E07 @A07\r\n\n" +
        "BABY",

        "CALL:CHILD LOCKED IN AUTO",
        "CODE:CHILD",
        "ADDR:848 JACOB TOME MEMORIAL HWY",  // JACOB TOME HWY
        "X:WAIBEL RD & DOWNIN LN",
        "CITY:PORT DEPOSIT",
        "ID:12010532",
        "TIME:17:22:53",
        "INFO:BABY",
        "UNIT:E07 A07",
        "CH:OPS 6 704");

    doTest("T5",
        "[Update]\r\n\n" +
        "OVERDOSE\r\n\n" +
        "23C01 (OVERDOSE )\r\n\n" +
        "11 LAGOON DR\r\n\n" +
        "PD\r\n\n" +
        "12010560\r\n\n" +
        "12:18:18\r\n\n" +
        "EMS     MB 701\r\n\n" +
        "@A07 P1 @E07\r\n\n" +
        "[P CARDIAC ARREST ;21 YEAR OLD, MALE, UNCONSCIOU",

        "CALL:OVERDOSE",
        "CODE:23C01",
        "ADDR:11 LAGOON DR",
        "CITY:PORT DEPOSIT",
        "ID:12010560",
        "TIME:12:18:18",
        "INFO:EMS MB 701 / P CARDIAC ARREST ;21 YEAR OLD, MALE, UNCONSCIOU",
        "UNIT:A07 P1 E07");

    doTest("T6",
        "OVERDOSE\r\n\n" +
        "23C01 (OVERDOSE )\r\n\n" +
        "11 LAGOON DR\r\n\n" +
        "PD\r\n\n" +
        "12010560\r\n\n" +
        "12:18:18\r\n\n" +
        "EMS     MB 701\r\n\n" +
        "@A07 @PM1\r\n\n" +
        "[P CARDIAC ARREST ;21 YEAR OLD, MALE, UNCONSCIOUS, NOT BREATH",

        "CALL:OVERDOSE",
        "CODE:23C01",
        "ADDR:11 LAGOON DR",
        "CITY:PORT DEPOSIT",
        "ID:12010560",
        "TIME:12:18:18",
        "INFO:EMS MB 701 / P CARDIAC ARREST ;21 YEAR OLD, MALE, UNCONSCIOUS, NOT BREATH",
        "UNIT:A07 PM1");

    doTest("T7",
        "OVERDOSE\r\n\n23D01 (OVERDOSE )\r\n\n39 MAPLE HILL DR\r\n\nBUTTONWOOD LN\r\n\nBIRCH CT\r\n\nPD\r\n\n12010568\r\n\n17:54:55\r\n\nEMS OPS 701\r\n\n@A07 @PM1\r\n",
        "CALL:OVERDOSE",
        "CODE:23D01",
        "ADDR:39 MAPLE HILL DR",
        "X:BUTTONWOOD LN & BIRCH CT",
        "CITY:PORT DEPOSIT",
        "ID:12010568",
        "TIME:17:54:55",
        "UNIT:A07 PM1",
        "CH:EMS OPS 701");

    doTest("T8",
        "GAS LEAK OUTSIDE\r\n\n" +
        "GASOUT (GAS LEAK OUTSIDE )\r\n\n" +
        "CONOWINGO RD / RT 222 - ROCK SPRING\r\n\n" +
        "CONO\r\n\n" +
        "12010571\r\n\n" +
        "18:31:19\r\n\n" +
        "FB 705  OPS 6\r\n\n" +
        "@E07\r\n\n" +
        "RT 1 RT 222 INTERSECTION ",

        "CALL:GAS LEAK OUTSIDE",
        "CODE:GASOUT",
        "ADDR:CONOWINGO RD & RT 222 - ROCK SPRING",
        "CITY:CONOWINGO",
        "ID:12010571",
        "TIME:18:31:19",
        "INFO:RT 1 RT 222 INTERSECTION",
        "UNIT:E07",
        "CH:FB 705 OPS 6");

    doTest("T9",
        "HOUSE FIRE\r\n\n" +
        "HOUSE (HOUSE FIRE )\r\n\n" +
        "161 WILLARD DR\r\n\n" +
        "STITES LN\r\n\n" +
        "LONGACRE DR\r\n\n" +
        "NE\r\n\n" +
        "12010825\r\n\n" +
        "22:43:45\r\n\n" +
        "FB 402  OPS 6\r\n\n" +
        "@R04 @T04 @E04 @E04 @L04 @A04 @T08 @E05 @E0",

        "CALL:HOUSE FIRE",
        "CODE:HOUSE",
        "ADDR:161 WILLARD DR",
        "X:STITES LN & LONGACRE DR",
        "CITY:NORTH EAST",
        "ID:12010825",
        "TIME:22:43:45",
        "UNIT:R04 T04 E04 E04 L04 A04 T08 E05 E0",
        "CH:FB 402 OPS 6");

    doTest("T10",
        "FALL\r\n\n" +
        "17D01 (FALL )\r\n\n" +
        "188 SKYLINE DR\r\n\n" +
        "CONO\r\n\n" +
        "12010787\r\n\n" +
        "10:10:41\r\n\n" +
        "EMS OPS MB705\r\n\n" +
        "@A07 @PM1\r\n\n" +
        "[P MAN FELL OFF THE ROOF ;40 YEAR OLD, MALE, UNCONSCIOUS, BREATHIN",

        "CALL:FALL",
        "CODE:17D01",
        "ADDR:188 SKYLINE DR",
        "CITY:CONOWINGO",
        "ID:12010787",
        "TIME:10:10:41",
        "INFO:P MAN FELL OFF THE ROOF ;40 YEAR OLD, MALE, UNCONSCIOUS, BREATHIN",
        "UNIT:A07 PM1",
        "CH:EMS OPS MB705");

    doTest("T11",
        "CHEST PAIN\n\n" +
        "10D04 (CHEST PAIN )\n\n" +
        "52 CRAIG CT\n\n" +
        "CONO\n\n" +
        "12005115\n\n" +
        "21:13:22\n\n" +
        "EMS OSP 0703\n\n" +
        "@A07 @PM1\n\n" +
        "443 655 0295 CEL[P HUSB HAVING CHEST PAINS ;51 YEAR OLD, MA",

        "CALL:CHEST PAIN",
        "CODE:10D04",
        "ADDR:52 CRAIG CT",
        "CITY:CONOWINGO",
        "ID:12005115",
        "TIME:21:13:22",
        "INFO:EMS OSP 0703 / 443 655 0295 CEL[P HUSB HAVING CHEST PAINS ;51 YEAR OLD, MA",
        "UNIT:A07 PM1");

  }
  
  @Test
  public void testFirerich73() {

    doTest("T1",
        "1 of 2\n" +
        "FRM:waterwitch71@atlanticbbn.net\n" +
        "MSG:RESPIRATORY DISTRESS\n" +
        "429 CRAIGTOWN RD\n" +
        "FUNK RD\n" +
        "BARTON RD\n" +
        "PD\n" +
        "66 Y/O /RESP DISTRESS[P 66 Y/O M\n" +
        "(Con't) 2 of 2\n" +
        "RESP DIS ;66 YEAR OLD, MALE\n" +
        "08:28:12\n" +
        "12016804\n" +
        "EMS OPS MB 704\n" +
        "@A07 @PM1(End)",

        "CALL:RESPIRATORY DISTRESS",
        "ADDR:429 CRAIGTOWN RD",
        "X:FUNK RD & BARTON RD",
        "CITY:PORT DEPOSIT",
        "ID:12016804",
        "INFO:66 Y/O /RESP DISTRESS[P 66 Y/O M RESP DIS ;66 YEAR OLD, MALE",
        "UNIT:A07 PM1",
        "CH:EMS OPS MB 704",
        "TIME:08:28:12");

  }
  
  public static void main(String[] args) {
    new MDCecilCountyDParserTest().generateTests("T1");
  }
}