package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.AL.ALChiltonCountyParserTest;

import org.junit.Test;


public class ALChiltonCountyParserTest extends BaseParserTest {
  
  public ALChiltonCountyParserTest() {
    setParser(new ALChiltonCountyParser(), "CHILTON COUNTY", "AL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "120 COUNTY RD 377 BILLINGSLEY 2011040762 18:41:28 MENTAL PERSON/PATIENT CUTTING HIMSELF, ALTERED MENTAL STATUS",
        "ADDR:120 COUNTY RD 377",
        "CITY:BILLINGSLEY",
        "ID:2011040762",
        "CALL:MENTAL PERSON",
        "INFO:/PATIENT CUTTING HIMSELF, ALTERED MENTAL STATUS");

    doTest("T2",
        "COUNTY RD 57 \\ COUNTY RD 445 2011039172 06:20:45 WRECK-UNKNOWN INJURIES CALLER STATES ONE VEHICLE OVERTURNED.. ADV THAT THE SUBJECT IS OUT OF THE VEHICLE",
        "ADDR:COUNTY RD 57 & COUNTY RD 445",
        "ID:2011039172",
        "INFO:WRECK-UNKNOWN INJURIES CALLER STATES ONE VEHICLE OVERTURNED.. ADV THAT THE SUBJECT IS OUT OF THE VEHICLE");

    doTest("T3",
        "120 COUNTY RD 377 BILLINGSLEY 2011040762 18:41:28 MENTAL PERSON/PATIENT CUTTING HIMSELF, ALTERED MENTAL STATUS",
        "ADDR:120 COUNTY RD 377",
        "CITY:BILLINGSLEY",
        "ID:2011040762",
        "CALL:MENTAL PERSON",
        "INFO:/PATIENT CUTTING HIMSELF, ALTERED MENTAL STATUS");

    doTest("T4",
        "100 COUNTY RD 99 LOT 5 VERBENA 2011043298 18:37:55 SHORTNESS OF BREATH GRANDMOTHER ON CHEMO NOT DOING GOOD",
        "ADDR:100 COUNTY RD 99 LOT 5",
        "CITY:VERBENA",
        "ID:2011043298",
        "INFO:SHORTNESS OF BREATH GRANDMOTHER ON CHEMO NOT DOING GOOD");

    doTest("T5",
        "518 COUNTY RD 221 THORSBY 2011046746 06:20:05 DIABETIC RESIDENCE IS A BEIGE DOUBLE WIDE WITH MAROON SHUTTERS. RED TOYOTA AND BLACK DODGE IN THE BACK YARD",
        "ADDR:518 COUNTY RD 221",
        "CITY:THORSBY",
        "ID:2011046746",
        "INFO:DIABETIC RESIDENCE IS A BEIGE DOUBLE WIDE WITH MAROON SHUTTERS. RED TOYOTA AND BLACK DODGE IN THE BACK YARD");

  }
  
  public static void main(String[] args) {
    new ALChiltonCountyParserTest().generateTests("T1", "ADDR CITY ID CALL INFO");
  }
}