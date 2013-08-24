package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Scotty County, IA
Contact: David Liske <david.liskeusmc@gmail.com>
Sender: secc@scott.ia.us
(Incident) MCFD  106 N SALINA ST McCausland EMS or MVC-Solo  Call successfully transferred to peer Agency. [MedicEMS]  Peer CFS Number = 0045-A_2012-12-01 [MedicEM
(Incident) MCFD  21822 274TH ST Scott County EMS or MVC-Solo  GRANDAUGHTER  SEIZURE  E911 Info - Class of Service: RESD Special Response Info: PSAP=SECC SCOTT SD  
(Incident) MCFD  401 S SALINA ST McCausland EMS or MVC-Solo  DAUGHTER ILL.  VOMITING.  E911 Info - Class of Service: RESD Special Response Info: PSAP=SECC MCCAUSLA
(Incident) MCFD  210TH AVE 300TH ST Scott County EMS or MVC-Solo  Call Number 5550 was created from Call Number 5548(Dec 21 2012  4:51AM)  CALLER WAS NOT SURE IF A
(Incident) MCFD  210TH AVE 300TH ST Scott County <NEW CALL>  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=        Verify PD  Verify FD  Verify EM

 */

public class IAScottCountyParserTest extends BaseParserTest {
  
  public IAScottCountyParserTest() {
    setParser(new IAScottCountyParser(), "SCOTT COUNTY", "IA");
  }
  
  @Test
  public void testDavidLiske() {

    doTest("T1",
        "(Incident) MCFD  106 N SALINA ST McCausland EMS or MVC-Solo  Call successfully transferred to peer Agency. [MedicEMS]  Peer CFS Number = 0045-A_2012-12-01 [MedicEM",
        "SRC:MCFD",
        "ADDR:106 N SALINA ST",
        "CITY:McCausland",
        "CALL:EMS or MVC-Solo",
        "INFO:Call successfully transferred to peer Agency.");

    doTest("T2",
        "(Incident) MCFD  21822 274TH ST Scott County EMS or MVC-Solo  GRANDAUGHTER  SEIZURE  E911 Info - Class of Service: RESD Special Response Info: PSAP=SECC SCOTT SD  ",
        "SRC:MCFD",
        "ADDR:21822 274TH ST",
        "CALL:EMS or MVC-Solo",
        "INFO:GRANDAUGHTER  SEIZURE");

    doTest("T3",
        "(Incident) MCFD  401 S SALINA ST McCausland EMS or MVC-Solo  DAUGHTER ILL.  VOMITING.  E911 Info - Class of Service: RESD Special Response Info: PSAP=SECC MCCAUSLA",
        "SRC:MCFD",
        "ADDR:401 S SALINA ST",
        "CITY:McCausland",
        "CALL:EMS or MVC-Solo",
        "INFO:DAUGHTER ILL.  VOMITING.");

    doTest("T4",
        "(Incident) MCFD  210TH AVE 300TH ST Scott County EMS or MVC-Solo  Call Number 5550 was created from Call Number 5548(Dec 21 2012  4:51AM)  CALLER WAS NOT SURE IF A",
        "SRC:MCFD",
        "ADDR:210TH AVE & 300TH ST",
        "CALL:EMS or MVC-Solo",
        "INFO:Call Number 5550 was created from Call Number 5548(Dec 21 2012  4:51AM)  CALLER WAS NOT SURE IF A");

    doTest("T5",
        "(Incident) MCFD  210TH AVE 300TH ST Scott County <NEW CALL>  E911 Info - Class of Service: WPH2 Special Response Info: PSAP=        Verify PD  Verify FD  Verify EM",
        "SRC:MCFD",
        "ADDR:210TH AVE & 300TH ST",
        "CALL:<NEW CALL>");

  }
  
  public static void main(String[] args) {
    new IAScottCountyParserTest().generateTests("T1");
  }
}