package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Ventura County, CA
Contact: Chase Morgan <chasemorgan43@gmail.com>
Contact: "chasemorgan@ymail.com" <chasemorgan@ymail.com>
Sender: FCC-DO-NOT-REPLY@ventura.org
System: InfoRad

(FCC Page) Incident Dispatch:T30   STRUCTURE 905 Falmouth St               526-J7 38/3912-0058915
(FCC Page) Incident Dispatch:T30   TC        796 Paseo De Leon             555-E3 38/3912-0058883
(FCC Page) Incident Dispatch:T30   SICK PERSO12 Conejo Blvd                556-F1 38/3912-0058846
(FCC Page) Incident Dispatch:T30   UNCONSCIOU190 E Hillcrest Dr            556-F1 38/3912-0059237
(FCC Page) Incident Dispatch:T30   FALLS NON 3557 Campus Dr                526-E2 38/3912-0059231
(FCC Page) Incident Dispatch:T30   INVESTIGATS Moorpark Rd / Rolling Oaks D556-F2 38/3912-0058857
(FCC Page) Incident Dispatch:T30   HEMORRHAGE760 Warwick Ave               526-F7 38/3912-0058807
(FCC Page) Incident Dispatch:E30   PUBLIC SERN Lynn Rd / W Janss Rd        526-E5 38/3912-0058155

Contact: "Raidernation.fm" <raidernation.fm@gmail.com>
Sender: FCC-DO-NOT-REPLY@ventura.org
FCC Page / Incident Dispatch:Q72   SICK PERSO1587 E Sequan Ct              524-D2 36/3712-0059676\n

Contact: Dustin Lazenby <captlaz82@gmail.com>
Sender: FCC-DO-NOT-REPLY@ventura.org
(FCC Page) Incident Dispatch:  E81    BREATHING  100-block N 4th St             464-A6  5 / 6  13-0013620

Contact: Kevin Aviator <kevgordo13@gmail.com>
Sender: FCC-Page@ventura.org
(FCC Page) Incident Dispatch:ME43  BACK PAIN 2275 Rohner Ct                499-C1 8 /9 13-0047246

 */

public class CAVenturaCountyParserTest extends BaseParserTest {
  
  public CAVenturaCountyParserTest() {
    setParser(new CAVenturaCountyParser(), "VENTURA COUNTY", "CA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(FCC Page) Incident Dispatch:T30   STRUCTURE 905 Falmouth St               526-J7 38/3912-0058915",
        "UNIT:T30",
        "CALL:STRUCTURE",
        "ADDR:905 Falmouth St",
        "MAP:526-J7",
        "CH:38/39",
        "ID:12-0058915");

    doTest("T2",
        "(FCC Page) Incident Dispatch:T30   TC        796 Paseo De Leon             555-E3 38/3912-0058883",
        "UNIT:T30",
        "CALL:TC",
        "ADDR:796 Paseo De Leon",
        "MAP:555-E3",
        "CH:38/39",
        "ID:12-0058883");

    doTest("T3",
        "(FCC Page) Incident Dispatch:T30   SICK PERSO12 Conejo Blvd                556-F1 38/3912-0058846",
        "UNIT:T30",
        "CALL:SICK PERSO",
        "ADDR:12 Conejo Blvd",
        "MAP:556-F1",
        "CH:38/39",
        "ID:12-0058846");

    doTest("T4",
        "(FCC Page) Incident Dispatch:T30   UNCONSCIOU190 E Hillcrest Dr            556-F1 38/3912-0059237",
        "UNIT:T30",
        "CALL:UNCONSCIOU",
        "ADDR:190 E Hillcrest Dr",
        "MAP:556-F1",
        "CH:38/39",
        "ID:12-0059237");

    doTest("T5",
        "(FCC Page) Incident Dispatch:T30   FALLS NON 3557 Campus Dr                526-E2 38/3912-0059231",
        "UNIT:T30",
        "CALL:FALLS NON",
        "ADDR:3557 Campus Dr",
        "MAP:526-E2",
        "CH:38/39",
        "ID:12-0059231");

    doTest("T6",
        "(FCC Page) Incident Dispatch:T30   INVESTIGATS Moorpark Rd / Rolling Oaks D556-F2 38/3912-0058857",
        "UNIT:T30",
        "CALL:INVESTIGAT",
        "ADDR:S Moorpark Rd & Rolling Oaks D",
        "MAP:556-F2",
        "CH:38/39",
        "ID:12-0058857");

    doTest("T7",
        "(FCC Page) Incident Dispatch:T30   HEMORRHAGE760 Warwick Ave               526-F7 38/3912-0058807",
        "UNIT:T30",
        "CALL:HEMORRHAGE",
        "ADDR:760 Warwick Ave",
        "MAP:526-F7",
        "CH:38/39",
        "ID:12-0058807");

    doTest("T8",
        "(FCC Page) Incident Dispatch:E30   PUBLIC SERN Lynn Rd / W Janss Rd        526-E5 38/3912-0058155",
        "UNIT:E30",
        "CALL:PUBLIC SER",
        "ADDR:N Lynn Rd & W Janss Rd",
        "MAP:526-E5",
        "CH:38/39",
        "ID:12-0058155");
    
  }
  
  @Test
  public void testRaidernation() {

    doTest("T1",
        "FCC Page / Incident Dispatch:Q72   SICK PERSO1587 E Sequan Ct              524-D2 36/3712-0059676\n",
        "UNIT:Q72",
        "CALL:SICK PERSO",
        "ADDR:1587 E Sequan Ct",
        "MAP:524-D2",
        "CH:36/37",
        "ID:12-0059676");

  }
  
  @Test
  public void testDustinLazenby() {

    doTest("T1",
        "(FCC Page) Incident Dispatch:  E81    BREATHING  100-block N 4th St             464-A6  5 / 6  13-0013620",
        "UNIT:E81",
        "CALL:BREATHING",
        "ADDR:100-block N 4th St",
        "MADDR:100 N 4th St",
        "MAP:464-A6",
        "CH:5/6",
        "ID:13-0013620");
   
  }
  
  @Test
  public void testKevinAviator() {

    doTest("T1",
        "(FCC Page) Incident Dispatch:ME43  BACK PAIN 2275 Rohner Ct                499-C1 8 /9 13-0047246",
        "UNIT:ME43",
        "CALL:BACK PAIN",
        "ADDR:2275 Rohner Ct",
        "MAP:499-C1",
        "CH:8/9",
        "ID:13-0047246");

  }
  
  public static void main(String[] args) {
    new CAVenturaCountyParserTest().generateTests("T1");
  }
}