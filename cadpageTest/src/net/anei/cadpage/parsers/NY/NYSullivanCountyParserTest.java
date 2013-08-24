package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Sullivan County, NY
Contact: Daniel Buschmann <wr63hiway@gmail.com>, la41hiway@yahoo.com, 631-484-5655
Sender: 911@co.sullivan.ny.us <From%3A911@co.sullivan.ny.us>

(911 Page) 09:33 Type: E-26A Sick Person Loc: 25 CARRIER X: No Cross Streets Found V: V/Liberty CN:
(911 Page) 06:53 Type: E-13A Diabetic Problem Loc: 159 N MAIN X: No Cross Streets Found V: V/Liberty CN:
(911 Page) 09;17 Type: E-29B MVA Loc:STHY 52 X: HYSANA RD V: LIBERTY CN:
(911 Page) 13:25 Type: E-6D Breathing Problem Loc: 124 Hunter Lake Dr X: Dead End/ Lily Pond Rd, Hunter Lake Rd V: Rockland CN:
(911 Page) 10:20 Type: E-17A Fall Victim Loc: 27 ACADEMY ST X: CHESTNUT ST / ST PAULS PL V: V/Liberty CN:
(911 Page) 10:03 Type: E-33C Transfer/Interfacility Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:
(911 Page) 09:31 Type: E-33A Transfer/Interfacility Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:
(911 Page) 09:18 Type: E-33C Transfer/Interfacility Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:
(911 Page) 13:49 Type: E-10D Chest Pain Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:
(911 Page) 13:38 Type: E-21B Hemorrhage/Laceration Loc: 36 S MAIN ST X: JOHN ST / DARBEE LN, N MAIN ST, CHESTNUT ST V: V/Liberty CN:
(911 Page) 12:35 Type: E- 6D Breathing Problem Loc: 256 SUNSET LAKE RD X: COMMUNITY LN / AIRPORT RD V: Liberty CN:
(911 Page) 10:20 Type: E-17A Fall Victim Loc: 27 ACADEMY ST X: CHESTNUT ST / ST PAULS PL V: V/Liberty CN:
(911 Page) 03:34 Type: E-33C Transfer/Interfacility Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:
(911 Page) 22:55 Type: E-33C Transfer/Interfacility Loc: 256 SUNSET LAKE RD X: COMMUNITY LN / AIRPORT RD V: Liberty CN:
(911 Page) 20:27 Type: E- 1C Abdominal Pain Loc: 358 E BROADWAY X: RICHARDSON AV / SPRING ST V: V/Monticello CN:

Contact: Crystal Bianucci <darktree84@gmail.com> 
(911 Page) 19:24 Type: F-Activated Alarm Loc: 22 SAINT JOHN ST X: No Cross Streets Found V: V/Monticello CN:

Contact: rkachelreiss <rkachelreiss@yahoo.com>
Sender: messaging@iamresponding.com
FRM:messaging@iamresponding.com\nSUBJ:Station 20\nMSG:04:21 Type: F-Activated Alarm Loc: 409 LARRYS WAY X: No Cross Streets Found V: Fallsburg CN:

*/

public class NYSullivanCountyParserTest extends BaseParserTest {
  
  public NYSullivanCountyParserTest() {
    setParser(new NYSullivanCountyParser(), "SULLIVAN COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(911 Page) 09:33 Type: E-26A Sick Person Loc: 25 CARRIER X: No Cross Streets Found V: V/Liberty CN:",
        "CALL:E-26A Sick Person",
        "ADDR:25 CARRIER",
        "X:No Cross Streets Found",
        "CITY:Liberty");

    doTest("T2",
        "(911 Page) 06:53 Type: E-13A Diabetic Problem Loc: 159 N MAIN X: No Cross Streets Found V: V/Liberty CN:",
        "CALL:E-13A Diabetic Problem",
        "ADDR:159 N MAIN",
        "X:No Cross Streets Found",
        "CITY:Liberty");

    doTest("T3",
        "(911 Page) 09;17 Type: E-29B MVA Loc:STHY 52 X: HYSANA RD V: LIBERTY CN:",
        "CALL:E-29B MVA",
        "ADDR:STHY 52",
        "MADDR:NY 52 & HYSANA RD",
        "X:HYSANA RD",
        "CITY:LIBERTY");

    doTest("T4",
        "(911 Page) 13:25 Type: E-6D Breathing Problem Loc: 124 Hunter Lake Dr X: Dead End/ Lily Pond Rd, Hunter Lake Rd V: Rockland CN:",
        "CALL:E-6D Breathing Problem",
        "ADDR:124 Hunter Lake Dr",
        "X:Dead End/ Lily Pond Rd, Hunter Lake Rd",
        "CITY:Rockland");

    doTest("T5",
        "(911 Page) 10:20 Type: E-17A Fall Victim Loc: 27 ACADEMY ST X: CHESTNUT ST / ST PAULS PL V: V/Liberty CN:",
        "CALL:E-17A Fall Victim",
        "ADDR:27 ACADEMY ST",
        "X:CHESTNUT ST / ST PAULS PL",
        "CITY:Liberty");

    doTest("T6",
        "(911 Page) 10:03 Type: E-33C Transfer/Interfacility Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:",
        "CALL:E-33C Transfer/Interfacility",
        "ADDR:170 LAKE ST",
        "X:CARRIER ST / STHY 55, W LAKE ST",
        "CITY:Liberty");

    doTest("T7",
        "(911 Page) 09:31 Type: E-33A Transfer/Interfacility Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:",
        "CALL:E-33A Transfer/Interfacility",
        "ADDR:170 LAKE ST",
        "X:CARRIER ST / STHY 55, W LAKE ST",
        "CITY:Liberty");

    doTest("T8",
        "(911 Page) 09:18 Type: E-33C Transfer/Interfacility Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:",
        "CALL:E-33C Transfer/Interfacility",
        "ADDR:170 LAKE ST",
        "X:CARRIER ST / STHY 55, W LAKE ST",
        "CITY:Liberty");

    doTest("T9",
        "(911 Page) 13:49 Type: E-10D Chest Pain Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:",
        "CALL:E-10D Chest Pain",
        "ADDR:170 LAKE ST",
        "X:CARRIER ST / STHY 55, W LAKE ST",
        "CITY:Liberty");

    doTest("T10",
        "(911 Page) 13:38 Type: E-21B Hemorrhage/Laceration Loc: 36 S MAIN ST X: JOHN ST / DARBEE LN, N MAIN ST, CHESTNUT ST V: V/Liberty CN:",
        "CALL:E-21B Hemorrhage/Laceration",
        "ADDR:36 S MAIN ST",
        "X:JOHN ST / DARBEE LN, N MAIN ST, CHESTNUT ST",
        "CITY:Liberty");

    doTest("T11",
        "(911 Page) 12:35 Type: E- 6D Breathing Problem Loc: 256 SUNSET LAKE RD X: COMMUNITY LN / AIRPORT RD V: Liberty CN:",
        "CALL:E- 6D Breathing Problem",
        "ADDR:256 SUNSET LAKE RD",
        "X:COMMUNITY LN / AIRPORT RD",
        "CITY:Liberty");

    doTest("T12",
        "(911 Page) 10:20 Type: E-17A Fall Victim Loc: 27 ACADEMY ST X: CHESTNUT ST / ST PAULS PL V: V/Liberty CN:",
        "CALL:E-17A Fall Victim",
        "ADDR:27 ACADEMY ST",
        "X:CHESTNUT ST / ST PAULS PL",
        "CITY:Liberty");

    doTest("T13",
        "(911 Page) 03:34 Type: E-33C Transfer/Interfacility Loc: 170 LAKE ST X: CARRIER ST / STHY 55, W LAKE ST V: V/Liberty CN:",
        "CALL:E-33C Transfer/Interfacility",
        "ADDR:170 LAKE ST",
        "X:CARRIER ST / STHY 55, W LAKE ST",
        "CITY:Liberty");

    doTest("T14",
        "(911 Page) 22:55 Type: E-33C Transfer/Interfacility Loc: 256 SUNSET LAKE RD X: COMMUNITY LN / AIRPORT RD V: Liberty CN:",
        "CALL:E-33C Transfer/Interfacility",
        "ADDR:256 SUNSET LAKE RD",
        "X:COMMUNITY LN / AIRPORT RD",
        "CITY:Liberty");

    doTest("T15",
        "(911 Page) 20:27 Type: E- 1C Abdominal Pain Loc: 358 E BROADWAY X: RICHARDSON AV / SPRING ST V: V/Monticello CN:",
        "CALL:E- 1C Abdominal Pain",
        "ADDR:358 E BROADWAY",
        "X:RICHARDSON AV / SPRING ST",
        "CITY:Monticello");

    doTest("T16",
        "(911 Page) 19:24 Type: F-Activated Alarm Loc: 22 SAINT JOHN ST X: No Cross Streets Found V: V/Monticello CN:",
        "CALL:F-Activated Alarm",
        "ADDR:22 SAINT JOHN ST",
        "X:No Cross Streets Found",
        "CITY:Monticello");

  }
  
  @Test
  public void testCodeMessaging() {
    
    doTest("T1",
        "FRM:messaging@iamresponding.com\n" +
        "SUBJ:Station 20\n" +
        "MSG:04:21 Type: F-Activated Alarm Loc: 409 LARRYS WAY X: No Cross Streets Found V: Fallsburg CN:",

        "SRC:20",
        "CALL:F-Activated Alarm",
        "ADDR:409 LARRYS WAY",  // Not mapping
        "X:No Cross Streets Found",
        "CITY:Fallsburg");
    
  }

  
  public static void main(String[] args) {
    new NYSullivanCountyParserTest().generateTests("T1");
  }
}