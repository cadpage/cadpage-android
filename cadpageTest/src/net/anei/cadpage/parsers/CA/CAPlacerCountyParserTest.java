package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Placer County, CA
Contact: Active911
Agency name: Auburn City Fire
Location: Auburn, CA, United States
Sender: NEUCAD@FIRE.CA.GOV

(CAD Page) : R/A J26: PA, PERSON: 250 PINE ST ,AUBURN1 : ACDIA ELDER CARE: Inc# 018206: Remarks LIFT ASST
(CAD Page) : R/A J26: MEDICAL: 1202 GRANITE LN ,AUBURN1 : : Inc# 018201: Remarks Dispatch  18C04  \nYou are responding to 
(CAD Page) : R/A J26: FIRE, COMMERCIAL ALARM: 1125 LINCOLN WY ,AUBURN1 : ATT: Inc# 018172: Remarks GENERAL FIRE ALARM
(CAD Page) : R/A J25B: MEDICAL: RAILHEAD PARK @ 100 PACIFIC AV ,AUBURN1 : SOCCER: Inc# 018115: Remarks Dispatch  30B01  \nYou are responding to 
(CAD Page) : R/A J26: MEDICAL: 243 GARFIELD ST ,AUBURN1 : : Inc# 018066: Remarks Dispatch  12C04  \nYou are responding to 
(CAD Page) : R/A J25B: MEDICAL: 146 RIVERVIEW DR ,AUBURN1 : : Inc# 018032: Remarks Dispatch  02C01  \nYou are responding to 
(CAD Page) : R/A J26: MED, CODE 2 MEDICAL: 750 AUBURN RAVINE RD ,AUBURN1 (AUBURN RAVINE TERRACE APT): SKILLED NURSING: Inc# 018028: Remarks Dispatch  17A01  \nYou are responding to 
(CAD Page) : R/A J26: MED, VEHICLE ACCIDENT: 291 PLACER ST ,AUBURN1 : : Inc# 018027: Remarks VEH VS. PED\nDispatch  29D02  \nYou are re
(CAD Page) : R/A J26: MED, VEHICLE ACCIDENT: SB 500 HWY 49 / 200 PALM AV ,AUBURN1 : BTWN PALM AND NEVADA: Inc# 018022: Remarks NO DETAILS VEH ACCIDENT
(CAD Page) : R/A J26: MEDICAL: 338 ELM AV ,AUBURN1 : WELLS FARGO BANK: Inc# 017996: Remarks Dispatch  17B01  \nYou are responding to 
(CAD Page) : R/A J25C: MEDICAL: 13025 LINCOLN WY #98 ,AUBURN1 : AUBURN WOODS: Inc# 017954: Remarks Dispatch  01D01  \nYou are responding to 
(CAD Page) : R/A J26: PA, PERSON: 750 AUBURN RAVINE RD #423 ,AUBURN1 (AUBURN RAVINE TERRACE APT): : Inc# 017943: Remarks LIFT ASSIST
(CAD Page) : R/A J25: PA, PERSON: 1238 GRIZZLY FLAT CT ,AUBURN1 : : Inc# 017939: Remarks LIFT ASSIST - NON INJURY FALL; DECLINING
(CAD Page) : R/A J26: MEDICAL: 296 CALIFORNIA ST ,AUBURN1 : : Inc# 017932: Remarks Dispatch  12C04  \nYou are responding to 
(CAD Page) : R/A J26: MEDICAL: 1591 LINCOLN WY ,AUBURN1 : CAFEALICIOUS: Inc# 017898: Remarks Dispatch  28C01  \nYou are responding to 
(CAD Page) : R/A J25: MEDICAL: 801 SAGE WY ,AUBURN1 : : Inc# 017893: Remarks Dispatch  19C04  \nYou are responding to 
(CAD Page) : R/A J25: MEDICAL: 260 RACETRACK ST #OUTSID ,AUBURN1 : ROCK CREEK CARE CENTER: Inc# 017838: Remarks Dispatch  17B01  \nYou are responding to 
(CAD Page) : R/A J26: MED, CODE 2 MEDICAL: 120 HWY 49 ,AUBURN1 : HOLIDAY INN AUBURN---: Inc# 017811: Remarks Dispatch  17A01  \nYou are responding to 
(CAD Page) : R/A J25: PA, PERSON: 12050 HERDAL DR ,AUBURN1 : : Inc# 017800: Remarks LIFT ASSIST
(CAD Page) : R/A J8: FIRE, RESIDENTIAL: 831 COLE RD ,PLACER_HILLS_FPD : : Inc# 017795: Remarks ATTIC FIRE // REQ ST 10 // ST 30 // BC /
(CAD Page) : R/A J26: MEDICAL: 159 EASY WY #A ,AUBURN1 : : Inc# 017782: Remarks Dispatch  26D01  \nYou are responding to 
(CAD Page) : R/A J26: MED, CODE 2 MEDICAL: 120 HWY 49 ,AUBURN1 : HOLIDAY INN: Inc# 017770: Remarks CHECK OUT OF TRANSIEIT
(CAD Page) : R/A J26: MED, CODE 2 MEDICAL: 1580 LINCOLN WY ,AUBURN1 : CALIFORINA CLUB: Inc# 017766: Remarks MED CHECK OUT FROM AN ASSULT
(CAD Page) : R/A J26: MED, STAGING REQUIRED: 781 MIKKELSEN DR #4 ,AUBURN1 : : Inc# 017751: Remarks 54 YOF ATTEMTED SUIIED OVER DOSE AND CUT
(CAD Page) : R/A J25: MEDICAL: 4035 EAGLES NEST ,AUBURN1 : : Inc# 017749: Remarks Dispatch  17B01  \nYou are responding to 
(CAD Page) : R/A J26: PA, PERSON: 750 AUBURN RAVINE RD #216 ,AUBURN1 (AUBURN RAVINE TERRACE APT): : Inc# 017627: Remarks EXT 48\nLIFT ASSIST
(CAD Page) : R/A J39: FIRE, RESIDENTIAL: 4880 AUBURN FOLSOM RD ,LOOMIS_FD : : Inc# 017608: Remarks FOR WT 1293
(CAD Page) : R/A J25C: MED, VEHICLE ACCIDENT: 152 HWY 49 / 8 JORDAN LN ,AUBURN1 : 1/ 4 MILE DOWN THE CANYON: Inc# 017601: Remarks WHITE VAN INTO THE HILLSIDE
(CAD Page) : R/A J26: PA, AGENCY: 200 AUBURN FOLSOM RD ,AUBURN1 : : Inc# 017562: Remarks OUT ASSISTING AUBURN CITY PD WITH TRAFFI
(CAD Page) : R/A J26: MEDICAL: 1338 LINCOLN WY ,AUBURN1 : PIONEER METHODIST CHURCH: Inc# 017559: Remarks Dispatch  26C01  \nYou are responding to 

 */

public class CAPlacerCountyParserTest extends BaseParserTest {
  
  public CAPlacerCountyParserTest() {
    setParser(new CAPlacerCountyParser(), "PLACER COUNTY", "CA");
  }
  
  @Test
  public void testAuburnCityFire() {

    doTest("T1",
        "(CAD Page) : R/A J26: PA, PERSON: 250 PINE ST ,AUBURN1 : ACDIA ELDER CARE: Inc# 018206: Remarks LIFT ASST",
        "UNIT:J26",
        "CALL:PA, PERSON",
        "ADDR:250 PINE ST",
        "SRC:AUBURN1",
        "PLACE:ACDIA ELDER CARE",
        "ID:018206",
        "INFO:LIFT ASST");

    doTest("T2",
        "(CAD Page) : R/A J26: MEDICAL: 1202 GRANITE LN ,AUBURN1 : : Inc# 018201: Remarks Dispatch  18C04  \nYou are responding to ",
        "UNIT:J26",
        "CALL:MEDICAL",
        "ADDR:1202 GRANITE LN",
        "SRC:AUBURN1",
        "ID:018201",
        "CODE:18C04");

    doTest("T3",
        "(CAD Page) : R/A J26: FIRE, COMMERCIAL ALARM: 1125 LINCOLN WY ,AUBURN1 : ATT: Inc# 018172: Remarks GENERAL FIRE ALARM",
        "UNIT:J26",
        "CALL:FIRE, COMMERCIAL ALARM",
        "ADDR:1125 LINCOLN WY",
        "SRC:AUBURN1",
        "PLACE:ATT",
        "ID:018172",
        "INFO:GENERAL FIRE ALARM");

    doTest("T4",
        "(CAD Page) : R/A J25B: MEDICAL: RAILHEAD PARK @ 100 PACIFIC AV ,AUBURN1 : SOCCER: Inc# 018115: Remarks Dispatch  30B01  \n" +
        "You are responding to ",

        "UNIT:J25B",
        "CALL:MEDICAL",
        "ADDR:100 PACIFIC AV",
        "MADDR:100 PACIFIC AVE",
        "SRC:AUBURN1",
        "PLACE:RAILHEAD PARK - SOCCER",
        "ID:018115",
        "CODE:30B01");

    doTest("T5",
        "(CAD Page) : R/A J26: MEDICAL: 243 GARFIELD ST ,AUBURN1 : : Inc# 018066: Remarks Dispatch  12C04  \nYou are responding to ",
        "UNIT:J26",
        "CALL:MEDICAL",
        "ADDR:243 GARFIELD ST",
        "SRC:AUBURN1",
        "ID:018066",
        "CODE:12C04");

    doTest("T6",
        "(CAD Page) : R/A J25B: MEDICAL: 146 RIVERVIEW DR ,AUBURN1 : : Inc# 018032: Remarks Dispatch  02C01  \nYou are responding to ",
        "UNIT:J25B",
        "CALL:MEDICAL",
        "ADDR:146 RIVERVIEW DR",
        "SRC:AUBURN1",
        "ID:018032",
        "CODE:02C01");

    doTest("T7",
        "(CAD Page) : R/A J26: MED, CODE 2 MEDICAL: 750 AUBURN RAVINE RD ,AUBURN1 (AUBURN RAVINE TERRACE APT): SKILLED NURSING: Inc# 018028: Remarks Dispatch  17A01  \n" +
        "You are responding to ",

        "UNIT:J26",
        "CALL:MED, CODE 2 MEDICAL",
        "ADDR:750 AUBURN RAVINE RD",
        "SRC:AUBURN1",
        "PLACE:AUBURN RAVINE TERRACE APT - SKILLED NURSING",
        "ID:018028",
        "CODE:17A01");

    doTest("T8",
        "(CAD Page) : R/A J26: MED, VEHICLE ACCIDENT: 291 PLACER ST ,AUBURN1 : : Inc# 018027: Remarks VEH VS. PED\n" +
        "Dispatch  29D02  \n" +
        "You are re",

        "UNIT:J26",
        "CALL:MED, VEHICLE ACCIDENT",
        "ADDR:291 PLACER ST",
        "SRC:AUBURN1",
        "ID:018027",
        "INFO:VEH VS. PED");

    doTest("T9",
        "(CAD Page) : R/A J26: MED, VEHICLE ACCIDENT: SB 500 HWY 49 / 200 PALM AV ,AUBURN1 : BTWN PALM AND NEVADA: Inc# 018022: Remarks NO DETAILS VEH ACCIDENT",
        "UNIT:J26",
        "CALL:MED, VEHICLE ACCIDENT",
        "ADDR:SB 500 HWY 49 & 200 PALM AV",
        "MADDR:500 HWY 49",
        "SRC:AUBURN1",
        "X:PALM AND NEVADA",
        "ID:018022",
        "INFO:NO DETAILS VEH ACCIDENT");

    doTest("T10",
        "(CAD Page) : R/A J26: MEDICAL: 338 ELM AV ,AUBURN1 : WELLS FARGO BANK: Inc# 017996: Remarks Dispatch  17B01  \n" +
        "You are responding to ",

        "UNIT:J26",
        "CALL:MEDICAL",
        "ADDR:338 ELM AV",
        "MADDR:338 ELM AVE",
        "SRC:AUBURN1",
        "PLACE:WELLS FARGO BANK",
        "ID:017996",
        "CODE:17B01");

    doTest("T11",
        "(CAD Page) : R/A J25C: MEDICAL: 13025 LINCOLN WY #98 ,AUBURN1 : AUBURN WOODS: Inc# 017954: Remarks Dispatch  01D01  \n" +
        "You are responding to ",

        "UNIT:J25C",
        "CALL:MEDICAL",
        "ADDR:13025 LINCOLN WY",
        "APT:98",
        "SRC:AUBURN1",
        "PLACE:AUBURN WOODS",
        "ID:017954",
        "CODE:01D01");

    doTest("T12",
        "(CAD Page) : R/A J26: PA, PERSON: 750 AUBURN RAVINE RD #423 ,AUBURN1 (AUBURN RAVINE TERRACE APT): : Inc# 017943: Remarks LIFT ASSIST",
        "UNIT:J26",
        "CALL:PA, PERSON",
        "ADDR:750 AUBURN RAVINE RD",
        "APT:423",
        "SRC:AUBURN1",
        "PLACE:AUBURN RAVINE TERRACE APT",
        "ID:017943",
        "INFO:LIFT ASSIST");

    doTest("T13",
        "(CAD Page) : R/A J25: PA, PERSON: 1238 GRIZZLY FLAT CT ,AUBURN1 : : Inc# 017939: Remarks LIFT ASSIST - NON INJURY FALL; DECLINING",
        "UNIT:J25",
        "CALL:PA, PERSON",
        "ADDR:1238 GRIZZLY FLAT CT",
        "SRC:AUBURN1",
        "ID:017939",
        "INFO:LIFT ASSIST - NON INJURY FALL; DECLINING");

    doTest("T14",
        "(CAD Page) : R/A J26: MEDICAL: 296 CALIFORNIA ST ,AUBURN1 : : Inc# 017932: Remarks Dispatch  12C04  \nYou are responding to ",
        "UNIT:J26",
        "CALL:MEDICAL",
        "ADDR:296 CALIFORNIA ST",
        "SRC:AUBURN1",
        "ID:017932",
        "CODE:12C04");

    doTest("T15",
        "(CAD Page) : R/A J26: MEDICAL: 1591 LINCOLN WY ,AUBURN1 : CAFEALICIOUS: Inc# 017898: Remarks Dispatch  28C01  \n" +
        "You are responding to ",

        "UNIT:J26",
        "CALL:MEDICAL",
        "ADDR:1591 LINCOLN WY",
        "SRC:AUBURN1",
        "PLACE:CAFEALICIOUS",
        "ID:017898",
        "CODE:28C01");

    doTest("T16",
        "(CAD Page) : R/A J25: MEDICAL: 801 SAGE WY ,AUBURN1 : : Inc# 017893: Remarks Dispatch  19C04  \nYou are responding to ",
        "UNIT:J25",
        "CALL:MEDICAL",
        "ADDR:801 SAGE WY",
        "SRC:AUBURN1",
        "ID:017893",
        "CODE:19C04");

    doTest("T17",
        "(CAD Page) : R/A J25: MEDICAL: 260 RACETRACK ST #OUTSID ,AUBURN1 : ROCK CREEK CARE CENTER: Inc# 017838: Remarks Dispatch  17B01  \n" +
        "You are responding to ",

        "UNIT:J25",
        "CALL:MEDICAL",
        "ADDR:260 RACETRACK ST",
        "APT:OUTSID",
        "SRC:AUBURN1",
        "PLACE:ROCK CREEK CARE CENTER",
        "ID:017838",
        "CODE:17B01");

    doTest("T18",
        "(CAD Page) : R/A J26: MED, CODE 2 MEDICAL: 120 HWY 49 ,AUBURN1 : HOLIDAY INN AUBURN---: Inc# 017811: Remarks Dispatch  17A01  \n" +
        "You are responding to ",

        "UNIT:J26",
        "CALL:MED, CODE 2 MEDICAL",
        "ADDR:120 HWY 49",
        "SRC:AUBURN1",
        "PLACE:HOLIDAY INN AUBURN---",
        "ID:017811",
        "CODE:17A01");

    doTest("T19",
        "(CAD Page) : R/A J25: PA, PERSON: 12050 HERDAL DR ,AUBURN1 : : Inc# 017800: Remarks LIFT ASSIST",
        "UNIT:J25",
        "CALL:PA, PERSON",
        "ADDR:12050 HERDAL DR",
        "SRC:AUBURN1",
        "ID:017800",
        "INFO:LIFT ASSIST");

    doTest("T20",
        "(CAD Page) : R/A J8: FIRE, RESIDENTIAL: 831 COLE RD ,PLACER_HILLS_FPD : : Inc# 017795: Remarks ATTIC FIRE // REQ ST 10 // ST 30 // BC /",
        "UNIT:J8",
        "CALL:FIRE, RESIDENTIAL",
        "ADDR:831 COLE RD",
        "SRC:PLACER_HILLS_FPD",
        "ID:017795",
        "INFO:ATTIC FIRE // REQ ST 10 // ST 30 // BC /");

    doTest("T21",
        "(CAD Page) : R/A J26: MEDICAL: 159 EASY WY #A ,AUBURN1 : : Inc# 017782: Remarks Dispatch  26D01  \nYou are responding to ",
        "UNIT:J26",
        "CALL:MEDICAL",
        "ADDR:159 EASY WY",
        "APT:A",
        "SRC:AUBURN1",
        "ID:017782",
        "CODE:26D01");

    doTest("T22",
        "(CAD Page) : R/A J26: MED, CODE 2 MEDICAL: 120 HWY 49 ,AUBURN1 : HOLIDAY INN: Inc# 017770: Remarks CHECK OUT OF TRANSIEIT",
        "UNIT:J26",
        "CALL:MED, CODE 2 MEDICAL",
        "ADDR:120 HWY 49",
        "SRC:AUBURN1",
        "PLACE:HOLIDAY INN",
        "ID:017770",
        "INFO:CHECK OUT OF TRANSIEIT");

    doTest("T23",
        "(CAD Page) : R/A J26: MED, CODE 2 MEDICAL: 1580 LINCOLN WY ,AUBURN1 : CALIFORINA CLUB: Inc# 017766: Remarks MED CHECK OUT FROM AN ASSULT",
        "UNIT:J26",
        "CALL:MED, CODE 2 MEDICAL",
        "ADDR:1580 LINCOLN WY",
        "SRC:AUBURN1",
        "PLACE:CALIFORINA CLUB",
        "ID:017766",
        "INFO:MED CHECK OUT FROM AN ASSULT");

    doTest("T24",
        "(CAD Page) : R/A J26: MED, STAGING REQUIRED: 781 MIKKELSEN DR #4 ,AUBURN1 : : Inc# 017751: Remarks 54 YOF ATTEMTED SUIIED OVER DOSE AND CUT",
        "UNIT:J26",
        "CALL:MED, STAGING REQUIRED",
        "ADDR:781 MIKKELSEN DR",
        "APT:4",
        "SRC:AUBURN1",
        "ID:017751",
        "INFO:54 YOF ATTEMTED SUIIED OVER DOSE AND CUT");

    doTest("T25",
        "(CAD Page) : R/A J25: MEDICAL: 4035 EAGLES NEST ,AUBURN1 : : Inc# 017749: Remarks Dispatch  17B01  \nYou are responding to ",
        "UNIT:J25",
        "CALL:MEDICAL",
        "ADDR:4035 EAGLES NEST",
        "SRC:AUBURN1",
        "ID:017749",
        "CODE:17B01");

    doTest("T26",
        "(CAD Page) : R/A J26: PA, PERSON: 750 AUBURN RAVINE RD #216 ,AUBURN1 (AUBURN RAVINE TERRACE APT): : Inc# 017627: Remarks EXT 48\n" +
        "LIFT ASSIST",

        "UNIT:J26",
        "CALL:PA, PERSON",
        "ADDR:750 AUBURN RAVINE RD",
        "APT:216",
        "SRC:AUBURN1",
        "PLACE:AUBURN RAVINE TERRACE APT",
        "ID:017627",
        "INFO:EXT 48");

    doTest("T27",
        "(CAD Page) : R/A J39: FIRE, RESIDENTIAL: 4880 AUBURN FOLSOM RD ,LOOMIS_FD : : Inc# 017608: Remarks FOR WT 1293",
        "UNIT:J39",
        "CALL:FIRE, RESIDENTIAL",
        "ADDR:4880 AUBURN FOLSOM RD",
        "SRC:LOOMIS_FD",
        "ID:017608",
        "INFO:FOR WT 1293");

    doTest("T28",
        "(CAD Page) : R/A J25C: MED, VEHICLE ACCIDENT: 152 HWY 49 / 8 JORDAN LN ,AUBURN1 : 1/ 4 MILE DOWN THE CANYON: Inc# 017601: Remarks WHITE VAN INTO THE HILLSIDE",
        "UNIT:J25C",
        "CALL:MED, VEHICLE ACCIDENT",
        "ADDR:152 HWY 49 & 8 JORDAN LN",
        "MADDR:152 HWY 49",
        "SRC:AUBURN1",
        "PLACE:1/ 4 MILE DOWN THE CANYON",
        "ID:017601",
        "INFO:WHITE VAN INTO THE HILLSIDE");

    doTest("T29",
        "(CAD Page) : R/A J26: PA, AGENCY: 200 AUBURN FOLSOM RD ,AUBURN1 : : Inc# 017562: Remarks OUT ASSISTING AUBURN CITY PD WITH TRAFFI",
        "UNIT:J26",
        "CALL:PA, AGENCY",
        "ADDR:200 AUBURN FOLSOM RD",
        "SRC:AUBURN1",
        "ID:017562",
        "INFO:OUT ASSISTING AUBURN CITY PD WITH TRAFFI");

    doTest("T30",
        "(CAD Page) : R/A J26: MEDICAL: 1338 LINCOLN WY ,AUBURN1 : PIONEER METHODIST CHURCH: Inc# 017559: Remarks Dispatch  26C01  \n" +
        "You are responding to ",

        "UNIT:J26",
        "CALL:MEDICAL",
        "ADDR:1338 LINCOLN WY",
        "SRC:AUBURN1",
        "PLACE:PIONEER METHODIST CHURCH",
        "ID:017559",
        "CODE:26C01");
 
  }
  
  public static void main(String[] args) {
    new CAPlacerCountyParserTest().generateTests("T1");
  }
}