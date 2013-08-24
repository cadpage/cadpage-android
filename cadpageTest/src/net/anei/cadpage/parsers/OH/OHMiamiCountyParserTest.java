package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Miami County, OH
Contact: Jevon Monaghan <monaghan.jspfd@gmail.com>
Sender: 911dispatch@miamicounty911.com

(Message from 911) FLF\nFLAA\nSQUAD\nDISP\n98 S CHURCH ST,FLE\nSPEMD1\n56 YOM VERY LOW BLOOD PRESSURE /\nPT IS DIABETIC AND HAS HIS OF LOW BLOOD PRESSURE\nIS CONCIOUS AND BREATHING\n\n13SPE0038\nW 1 ST & W MAIN ST\n04/07/2013 18:09
(Message from 911) FLF\nFLCC\nSQUAD\nDISP\n7410 E SNODGRASS RD,BRO\nSPEMD1\n84 YOM HEART RATE 107 / BLOOD PRESSURE IS LOW 86/53 / HX OF AFIB / CONGESTIVE\nHEART FAILURE\nPT IS CONCIOUS AND BREATHING\n\n13SPE0041\nSTATE RT 589 & N ALCONY CONOVER RD\n04/22/2013 22:47
(Message from 911) FLF\nFLAA\nSQUAD\nDISP\n504 CHERRY LN,FLE\nSPEMD1\n72 YOM PASSED OUT /FELL/ CONSCIOUS AND BREATHING HX HEART PROBLEMS AND DIABETIC\nAND CONGESTIVE HEART FAILURE\nHAS A PACEMAKER ..IT WENT OFF\nRP IS HOLDING HIM UP AND CANT GET HIM UP\n\n13SPE0042\nE 5 ST\n04/28/2013 18

 */
public class OHMiamiCountyParserTest extends BaseParserTest {
  
  public OHMiamiCountyParserTest() {
    setParser(new OHMiamiCountyParser(), "MIAMI COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Message from 911) FLF\n" +
        "FLAA\n" +
        "SQUAD\n" +
        "DISP\n" +
        "98 S CHURCH ST,FLE\n" +
        "SPEMD1\n" +
        "56 YOM VERY LOW BLOOD PRESSURE /\n" +
        "PT IS DIABETIC AND HAS HIS OF LOW BLOOD PRESSURE\n" +
        "IS CONCIOUS AND BREATHING\n\n" +
        "13SPE0038\n" +
        "W 1 ST & W MAIN ST\n" +
        "04/07/2013 18:09",

        "UNIT:SQUAD",
        "ADDR:98 S CHURCH ST",
        "CITY:Fletcher Village",
        "SRC:SPEMD1",
        "INFO:56 YOM VERY LOW BLOOD PRESSURE / / PT IS DIABETIC AND HAS HIS OF LOW BLOOD PRESSURE / IS CONCIOUS AND BREATHING",
        "ID:13SPE0038",
        "X:W 1 ST & W MAIN ST",
        "DATE:04/07/2013",
        "TIME:18:09");

    doTest("T2",
        "(Message from 911) FLF\n" +
        "FLCC\n" +
        "SQUAD\n" +
        "DISP\n" +
        "7410 E SNODGRASS RD,BRO\n" +
        "SPEMD1\n" +
        "84 YOM HEART RATE 107 / BLOOD PRESSURE IS LOW 86/53 / HX OF AFIB / CONGESTIVE\n" +
        "HEART FAILURE\n" +
        "PT IS CONCIOUS AND BREATHING\n\n" +
        "13SPE0041\n" +
        "STATE RT 589 & N ALCONY CONOVER RD\n" +
        "04/22/2013 22:47",

        "UNIT:SQUAD",
        "ADDR:7410 E SNODGRASS RD",
        "CITY:Brown Twp",
        "SRC:SPEMD1",
        "INFO:84 YOM HEART RATE 107 / BLOOD PRESSURE IS LOW 86/53 / HX OF AFIB / CONGESTIVE / HEART FAILURE / PT IS CONCIOUS AND BREATHING",
        "ID:13SPE0041",
        "X:STATE RT 589 & N ALCONY CONOVER RD",
        "DATE:04/22/2013",
        "TIME:22:47");

    doTest("T3",
        "(Message from 911) FLF\n" +
        "FLAA\n" +
        "SQUAD\n" +
        "DISP\n" +
        "504 CHERRY LN,FLE\n" +
        "SPEMD1\n" +
        "72 YOM PASSED OUT /FELL/ CONSCIOUS AND BREATHING HX HEART PROBLEMS AND DIABETIC\n" +
        "AND CONGESTIVE HEART FAILURE\n" +
        "HAS A PACEMAKER ..IT WENT OFF\n" +
        "RP IS HOLDING HIM UP AND CANT GET HIM UP\n\n" +
        "13SPE0042\n" +
        "E 5 ST\n" +
        "04/28/2013 18",

        "UNIT:SQUAD",
        "ADDR:504 CHERRY LN",
        "CITY:Fletcher Village",
        "SRC:SPEMD1",
        "INFO:72 YOM PASSED OUT /FELL/ CONSCIOUS AND BREATHING HX HEART PROBLEMS AND DIABETIC / AND CONGESTIVE HEART FAILURE / HAS A PACEMAKER ..IT WENT OFF / RP IS HOLDING HIM UP AND CANT GET HIM UP",
        "ID:13SPE0042",
        "X:E 5 ST",
        "DATE:04/28/2013",
        "TIME:18");

  }
  
  public static void main(String[] args) {
    new OHMiamiCountyParserTest().generateTests("T1");
  }
}