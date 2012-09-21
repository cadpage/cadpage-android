package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXHarrisCountyNWEMSParserTest extends BaseParserTest {
  
  public TXHarrisCountyNWEMSParserTest() {
    setParser(new TXHarrisCountyNWEMSParser(), "HARRIS COUNTY", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "  / * 13415 MEDICAL COMPLEX DR* 320* * * * 01C05* ABD PAIN -Males w/pain above navel* * * M-1* * * * *",
        "ADDR:13415 MEDICAL COMPLEX DR",
        "APT:320",
        "CODE:01C05",
        "CALL:ABD PAIN -Males w/pain above navel",
        "UNIT:M-1");

    doTest("T2",
        "  / * 28602 TOMBALL PKWY* * * * * 19D04* HEART PROBLEMS-Clammy* * * M-1* * * * *",
        "ADDR:28602 TOMBALL PKWY",
        "CODE:19D04",
        "CALL:HEART PROBLEMS-Clammy",
        "UNIT:M-1");

    doTest("T3",
        "  / * 502 JAMES ST* * * * * 17A01* FALL - Not Dangerous* * * M-1* * * * *",
        "ADDR:502 JAMES ST",
        "CODE:17A01",
        "CALL:FALL - Not Dangerous",
        "UNIT:M-1");

    doTest("T4",
        "  / * 605 HOLDERRIETH BLVD* 527* * * * 33A02* OUT OF DISTRICT TRANSFER* * * M-1* * * * *",
        "ADDR:605 HOLDERRIETH BLVD",
        "APT:527",
        "CODE:33A02",
        "CALL:OUT OF DISTRICT TRANSFER",
        "UNIT:M-1");

    doTest("T5",
        "  / * 1019 HICKORY POST CT* * * * * OVERDOSE* OVERDOGE/INGESTION* * * M-1* * * * *",
        "ADDR:1019 HICKORY POST CT",
        "CODE:OVERDOSE",
        "CALL:OVERDOGE/INGESTION",
        "UNIT:M-1");
   
  }

public static void main(String[] args) {
    new TXHarrisCountyNWEMSParserTest().generateTests("T1");
  }

}