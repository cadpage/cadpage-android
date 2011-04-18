package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYNassauCountyBParserTest extends BaseParserTest {
  
  public NYNassauCountyBParserTest() {
    setParser(new NYNassauCountyBParser(), "NASSAU COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FireCom:  3 HUDSON ST E (GENERAL-AUTO) FIRE ALARM RINGING",
        "ADDR:3 HUDSON ST E",
        "CALL:GENERAL-AUTO",
        "INFO:FIRE ALARM RINGING");

    doTest("T2",
        "FireCom:  31 MUNSON PL (SIG 9-AMBU) 20F ABDOMINAL PAINS",
        "ADDR:31 MUNSON PL",
        "CALL:SIG 9-AMBU",
        "INFO:20F ABDOMINAL PAINS");

    doTest("T3",
        "FireCom: THE FISHERY 1 MAIN ST (SIG 9-AMBU) MALE FELL-FX WRIST",
        "ADDR:THE FISHERY 1 MAIN ST",
        "CALL:SIG 9-AMBU",
        "INFO:MALE FELL-FX WRIST");

    doTest("T4",
        "FireCom:  528 ATLANTIC AVE (SIG 9-AMBU) BACK DOOR DIFF BREATHING",
        "ADDR:528 ATLANTIC AVE",
        "CALL:SIG 9-AMBU",
        "INFO:BACK DOOR DIFF BREATHING");

    doTest("T5",
        "FireCom:  RHAME AVE (DISTRIC-HAZM) SW CORNER/SEWER-ILLEGALE DUMPING",
        "ADDR:RHAME AVE",
        "CALL:DISTRIC-HAZM",
        "INFO:SW CORNER/SEWER-ILLEGALE DUMPING");

    doTest("T6",
        "FireCom:  22 RIVERSIDE ROAD (SIG 9-AMBU) DEHYDRATED MA",
        "ADDR:22 RIVERSIDE ROAD",
        "CALL:SIG 9-AMBU",
        "INFO:DEHYDRATED MA");

    doTest("T7",
        "FireCom:  65 EMMET AVE (GENERAL-AUTO) ESTRIN RES/40A024",
        "ADDR:65 EMMET AVE",
        "CALL:GENERAL-AUTO",
        "INFO:ESTRIN RES/40A024");

    doTest("T8",
        "FRM:paging@alpinesoftware.com\nMSG:\nRedAlert: 528 MERRICK ROAD (SIG 9A-AMBU) SICK MALE",
        "ADDR:528 MERRICK ROAD",
        "CALL:SIG 9A-AMBU",
        "INFO:SICK MALE");
  }
  
  public static void main(String[] args) {
    new NYNassauCountyBParserTest().generateTests("T1", "ADDR CALL INFO");
  }
}