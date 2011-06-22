package net.anei.cadpage.parsers.WI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class WIKenoshaCountyParserTest extends BaseParserTest {
  
  public WIKenoshaCountyParserTest() {
    setParser(new WIKenoshaCountyParser(), "KENOSHA COUNTY", "WI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "LMC213 #:002011070865 ILS MED at 7701 95TH ST Rem: 50 M ;HEART PROBLEM CONSCIOUS: YES ,BREATHING: YES",
        "ID:002011070865",
        "CALL:ILS MED",
        "ADDR:7701 95TH ST",
        "INFO:50 M ;HEART PROBLEM CONSCIOUS: YES ,BREATHING: YES");

    doTest("T2",
        "NLB260 #:002011071148 ALS MED at 4204 109TH ST Rem: 69 F ;CHEST PAIN CONSCIOUS: YES ,BREATHING: YES",
        "ID:002011071148",
        "CALL:ALS MED",
        "ADDR:4204 109TH ST",
        "INFO:69 F ;CHEST PAIN CONSCIOUS: YES ,BREATHING: YES");

    doTest("T3",
        "DMB193 #:002011072020 BLS MED at 10519 120TH AVE EAST TOURIST INFO CNTR Rem: CHEST PAIN",
        "ID:002011072020",
        "CALL:BLS MED",
        "ADDR:10519 120TH AVE",
        "PLACE:EAST TOURIST INFO CNTR",
        "INFO:CHEST PAIN");

    doTest("T4",
        "DMB193 #:002011072054 SUPERVISOR ALRM at 7887 94TH AVE HOLIDAY INN EXPRESS",
        "ID:002011072054",
        "CALL:SUPERVISOR ALRM",
        "ADDR:7887 94TH AVE",
        "PLACE:HOLIDAY INN EXPRESS");

    doTest("T5",
        "DMB193 #:002011072060 MVA at 80TH AVE and COOPER RD",
        "ID:002011072060",
        "CALL:MVA",
        "ADDR:80TH AVE and COOPER RD");

    doTest("T6",
        "From: CNT304 #:002011086007 ALS MED at 835 HICKORY RD Rem: 53 F ;SEIZURES CONSCIOUS: YES ,BREATHING: YES\37s",
        "ID:002011086007",
        "CALL:ALS MED",
        "ADDR:835 HICKORY RD",
        "INFO:53 F ;SEIZURES CONSCIOUS: YES ,BREATHING: YES\37s");
   
  }
  
  public static void main(String[] args) {
    new WIKenoshaCountyParserTest().generateTests("T6", "ID CALL ADDR PLACE INFO");
  }
}