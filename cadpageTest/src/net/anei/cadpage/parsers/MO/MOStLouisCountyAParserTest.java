package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
St Louis County, MO
Contact: Mikey Bowman <mikeyb4307@gmail.com>, 3144132049@vtext.com
Sender: nccfas@ncc911.org

IN AREA, 224 S HARVEY AV (RES) - - 3014,3025,4310,3615,4610,3016,3017 19:57
MONROE AV / OAKRIDGE DR (MISC) - WIRES DOWN - 4310 09:04
6721 THURSTON AV (MISC) - WIRES DOWN - 4310 00:22
BROTHERTON LN (RES) - HOUSE ON BROTHERTON - 3025,4310,4610,3615,4210,3016,3017 22:27
KIPD, 5990 MONROE AV (LIFE) - 21 YOF WITH CHEST PAINS - 4310,4617 11:03 
EVERGREEN BLVD / JANUARY AV (RES) - HSE FIRE ON CORNER - 3615,3620,3014,4310,3602 07:47
8006 COURTNEY AV (FALLS) - 69 year old, Female, Conscious, Breathing. Falls. Caller Statement: FALLEN. GARAGE DOOR CODE 6008 - 3717,4310 12:44
8026 WESLEY AV (DIF BREATH) - 65 year old, Female, Conscious, Breathing. Breathing Problems. Caller Statement: DIFF BREATHING. - 4310,3017 13:33

Contact: Active911
Agency name: Florissant Valley Fire District
Location: St. Louis, MO, United States
Sender: "North Central" <timparks@sbcglobal.net>

3060 SANTIAGO DR APT N (SICK) - 46-year-old, Female, Conscious, Breathing. Caller Statement: MS PATIENT FEELING SICK. - 4027 - 26D01 23:00
1085 GRENOBLE LN (CHESTPAIN) - 54-year-old, Male, Conscious, Breathing. Caller Statement: CHEST PAINS. - 4027 - 10D04 21:42
SHACKELFORD RD / CHARBONIER RD (ASSAULT) - - 4037 20:46
DUNN RD / WASHINGTON ST (SICK) - Caller Statement: PAIN ALL OVER. - 4027 15:06
MCCLUER HIGH SCHOOL, 1896 NEW FLORISSANT RD S (SEIZURES) - Caller Statement: m2 DOOR 17 SEIZURERS. - 4015,4017 12:15
1896 NEW FLORISSANT RD N (SEIZURES) - Caller Statement: m2 DOOR 17 SEIZURERS. - 4015,4017 12:05
1145 ESTES DR (MATERNITY) - 19-year-old, Female, Conscious, Breathing. Caller Statement: MATERNITY. - 4037 - 24D03 09:26
2910 SANTIAGO DR APT G (COM CO) - - 4024 08:27
1812 SUNS UP CT (EMS) - MEDICAL ALARM - 4037 07:00
FLORISSANT PD, 1700 N HWY 67 (DIF BREATH) - Caller Statement: prisoner, diff breathing. - 4017 00:46
1790 N HWY 67 (TRA INJ) - Caller Statement: ANKLE INJURY, OLYMPIC MOTORS. - 4017 23:44
100 ALBERT DR (RES ALRM) - HALLWAY SMOKE DETECTOR - 4034 20:41
480 WATERFORD DR (RES ALRM) - - 4024 20:16
1270 CARMONA DR (UNCONS) - 91-year-old, Female, Conscious, Breathing. Caller Statement: GRANDMOTHER HAD PASSED OUT. - 4027 - 31D03 19:47
1036 ARMADA CT (MISC) - CHEMICAL SPILL BY POOL - 4034,4002 18:48
1036 ARMADA CT (MISC) - CHEMICAL SPILL BY POOL - 4034,4002 18:48
1025 BOULDER DR (OBS) - 34-year-old, Male, Conscious, Breathing. Caller Statement: INTOXICATED - OBS-FEELING SUICIDAL. - 4037 - 25B03 15:59
100 N CASTELLO ST (EMS) - BRAIN BLEED/HAD MRI THIS AFTERNOON/68YOF - 4027 15:51
1535 ASCOT TERRACE (RES ALRM) - GENERAL FIRE ALRM - 4024 15:47
695 MARK TWAIN DR (MISC) - STOVE - 4034,4002 15:44
2365 INDIANCUP DR (STROKE) - 73-year-old, Male, Conscious, Breathing. Caller Statement: SEMIRESPONSIVE PT. - 4017 - 28C04X 15:17
11325 SUGAR PINE DR APT NONE (EMS) - MEDICAL ALRM - 4027 15:09
1681 BARKWOOD DR (MISC) - STOVE - 4034 13:40
145 ST AUGUSTA LN (EMS) - ASSIST INVALID - 4015 11:49
1855 NEW FLORISSANT RD N APT 1 (UNCONS) - 68-year-old, Female, Not Conscious, Breathing. Caller Statement: UNRESPONSIVE /BREATHING. - 4015,3027 11:10
GRACE APOSTOLIC CHURCH, 11770 SEVEN HILLS DR (INST ALRM) - FELLOWSHIP ROOM B SMOKE / DUCT - 3025 11:05
246 ANASTASIA DR (TRAPPED) - - 4024,4037 10:07
DUNN ROAD MANOR, 3399 DUNN RD APT 307 (DIF BREATH) - 76-year-old, Female, Conscious, Breathing. Caller Statement: DIFF BREATHING / SIDE PAIN. - 4027 - 06D02 09:17
2251 CENTRAL PKWY (ABD PAIN) - 56-year-old, Male, Conscious, Breathing. Caller Statement: STOMACH PAINS. - 4017 - 01A01 07:02
250 FRANCISCA DR (DIABETIC) - 63-year-old, Male, Conscious, Breathing. Caller Statement: DIABETIC LOW B/S. - 4037 - 13C01 06:51
1241 ASPEN DR (DIF BREATH) - 37-year-old, Female, Conscious, Breathing. Caller Statement: diff breathing. - 4037 - 06D02 04:39

*/

public class MOStLouisCountyAParserTest extends BaseParserTest {
  
  public MOStLouisCountyAParserTest() {
    setParser(new MOStLouisCountyAParser(), "ST LOUIS COUNTY", "MO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "IN AREA, 224 S HARVEY AV (RES) - - 3014,3025,4310,3615,4610,3016,3017 19:57",
        "PLACE:IN AREA",
        "ADDR:224 S HARVEY AV",
        "MADDR:224 S HARVEY AVE",
        "CALL:RES",
        "UNIT:3014,3025,4310,3615,4610,3016,3017",
        "TIME:19:57");

    doTest("T2",
        "MONROE AV / OAKRIDGE DR (MISC) - WIRES DOWN - 4310 09:04",
        "ADDR:MONROE AV & OAKRIDGE DR",
        "MADDR:MONROE AVE & OAKRIDGE DR",
        "CALL:MISC",
        "INFO:WIRES DOWN",
        "UNIT:4310",
        "TIME:09:04");

    doTest("T3",
        "6721 THURSTON AV (MISC) - WIRES DOWN - 4310 00:22",
        "ADDR:6721 THURSTON AV",
        "MADDR:6721 THURSTON AVE",
        "CALL:MISC",
        "INFO:WIRES DOWN",
        "UNIT:4310",
        "TIME:00:22");

    doTest("T4",
        "BROTHERTON LN (RES) - HOUSE ON BROTHERTON - 3025,4310,4610,3615,4210,3016,3017 22:27",
        "ADDR:BROTHERTON LN",
        "CALL:RES",
        "INFO:HOUSE ON BROTHERTON",
        "UNIT:3025,4310,4610,3615,4210,3016,3017",
        "TIME:22:27");

    doTest("T5",
        "KIPD, 5990 MONROE AV (LIFE) - 21 YOF WITH CHEST PAINS - 4310,4617 11:03",
        "PLACE:KIPD",
        "ADDR:5990 MONROE AV",
        "MADDR:5990 MONROE AVE",
        "CALL:LIFE",
        "INFO:21 YOF WITH CHEST PAINS",
        "UNIT:4310,4617",
        "TIME:11:03");

    doTest("T6",
        "EVERGREEN BLVD / JANUARY AV (RES) - HSE FIRE ON CORNER - 3615,3620,3014,4310,3602 07:47",
        "ADDR:EVERGREEN BLVD & JANUARY AV",
        "MADDR:EVERGREEN BLVD & JANUARY AVE",
        "CALL:RES",
        "INFO:HSE FIRE ON CORNER",
        "UNIT:3615,3620,3014,4310,3602",
        "TIME:07:47");

    doTest("T7",
        "8006 COURTNEY AV (FALLS) - 69 year old, Female, Conscious, Breathing. Falls. Caller Statement: FALLEN. GARAGE DOOR CODE 6008 - 3717,4310 12:44",
        "ADDR:8006 COURTNEY AV",
        "MADDR:8006 COURTNEY AVE",
        "CALL:FALLS",
        "INFO:69 year old, Female, Conscious, Breathing. Falls. Caller Statement: FALLEN. GARAGE DOOR CODE 6008",
        "UNIT:3717,4310",
        "TIME:12:44");

    doTest("T8",
        "8026 WESLEY AV (DIF BREATH) - 65 year old, Female, Conscious, Breathing. Breathing Problems. Caller Statement: DIFF BREATHING. - 4310,3017 13:33",
        "ADDR:8026 WESLEY AV",
        "MADDR:8026 WESLEY AVE",
        "CALL:DIF BREATH",
        "INFO:65 year old, Female, Conscious, Breathing. Breathing Problems. Caller Statement: DIFF BREATHING.",
        "UNIT:4310,3017",
        "TIME:13:33");
  }
  
  @Test
  public void testFlorissantValleyFireDistrict() {

    doTest("T1",
        "3060 SANTIAGO DR APT N (SICK) - 46-year-old, Female, Conscious, Breathing. Caller Statement: MS PATIENT FEELING SICK. - 4027 - 26D01 23:00",
        "ADDR:3060 SANTIAGO DR",
        "APT:N",
        "CALL:SICK",
        "INFO:46-year-old, Female, Conscious, Breathing. Caller Statement: MS PATIENT FEELING SICK.",
        "UNIT:4027",
        "CODE:26D01",
        "TIME:23:00");

    doTest("T2",
        "1085 GRENOBLE LN (CHESTPAIN) - 54-year-old, Male, Conscious, Breathing. Caller Statement: CHEST PAINS. - 4027 - 10D04 21:42",
        "ADDR:1085 GRENOBLE LN",
        "CALL:CHESTPAIN",
        "INFO:54-year-old, Male, Conscious, Breathing. Caller Statement: CHEST PAINS.",
        "UNIT:4027",
        "CODE:10D04",
        "TIME:21:42");

    doTest("T3",
        "SHACKELFORD RD / CHARBONIER RD (ASSAULT) - - 4037 20:46",
        "ADDR:SHACKELFORD RD & CHARBONIER RD",
        "CALL:ASSAULT",
        "UNIT:4037",
        "TIME:20:46");

    doTest("T4",
        "DUNN RD / WASHINGTON ST (SICK) - Caller Statement: PAIN ALL OVER. - 4027 15:06",
        "ADDR:DUNN RD & WASHINGTON ST",
        "CALL:SICK",
        "INFO:Caller Statement: PAIN ALL OVER.",
        "UNIT:4027",
        "TIME:15:06");

    doTest("T5",
        "MCCLUER HIGH SCHOOL, 1896 NEW FLORISSANT RD S (SEIZURES) - Caller Statement: m2 DOOR 17 SEIZURERS. - 4015,4017 12:15",
        "PLACE:MCCLUER HIGH SCHOOL",
        "ADDR:1896 NEW FLORISSANT RD S",
        "CALL:SEIZURES",
        "INFO:Caller Statement: m2 DOOR 17 SEIZURERS.",
        "UNIT:4015,4017",
        "TIME:12:15");

    doTest("T6",
        "1896 NEW FLORISSANT RD N (SEIZURES) - Caller Statement: m2 DOOR 17 SEIZURERS. - 4015,4017 12:05",
        "ADDR:1896 NEW FLORISSANT RD N",
        "CALL:SEIZURES",
        "INFO:Caller Statement: m2 DOOR 17 SEIZURERS.",
        "UNIT:4015,4017",
        "TIME:12:05");

    doTest("T7",
        "1145 ESTES DR (MATERNITY) - 19-year-old, Female, Conscious, Breathing. Caller Statement: MATERNITY. - 4037 - 24D03 09:26",
        "ADDR:1145 ESTES DR",
        "CALL:MATERNITY",
        "INFO:19-year-old, Female, Conscious, Breathing. Caller Statement: MATERNITY.",
        "UNIT:4037",
        "CODE:24D03",
        "TIME:09:26");

    doTest("T8",
        "2910 SANTIAGO DR APT G (COM CO) - - 4024 08:27",
        "ADDR:2910 SANTIAGO DR",
        "APT:G",
        "CALL:COM CO",
        "UNIT:4024",
        "TIME:08:27");

    doTest("T9",
        "1812 SUNS UP CT (EMS) - MEDICAL ALARM - 4037 07:00",
        "ADDR:1812 SUNS UP CT",
        "CALL:EMS",
        "INFO:MEDICAL ALARM",
        "UNIT:4037",
        "TIME:07:00");

    doTest("T10",
        "FLORISSANT PD, 1700 N HWY 67 (DIF BREATH) - Caller Statement: prisoner, diff breathing. - 4017 00:46",
        "PLACE:FLORISSANT PD",
        "ADDR:1700 N HWY 67",
        "CALL:DIF BREATH",
        "INFO:Caller Statement: prisoner, diff breathing.",
        "UNIT:4017",
        "TIME:00:46");

    doTest("T11",
        "1790 N HWY 67 (TRA INJ) - Caller Statement: ANKLE INJURY, OLYMPIC MOTORS. - 4017 23:44",
        "ADDR:1790 N HWY 67",
        "CALL:TRA INJ",
        "INFO:Caller Statement: ANKLE INJURY, OLYMPIC MOTORS.",
        "UNIT:4017",
        "TIME:23:44");

    doTest("T12",
        "100 ALBERT DR (RES ALRM) - HALLWAY SMOKE DETECTOR - 4034 20:41",
        "ADDR:100 ALBERT DR",
        "CALL:RES ALRM",
        "INFO:HALLWAY SMOKE DETECTOR",
        "UNIT:4034",
        "TIME:20:41");

    doTest("T13",
        "480 WATERFORD DR (RES ALRM) - - 4024 20:16",
        "ADDR:480 WATERFORD DR",
        "CALL:RES ALRM",
        "UNIT:4024",
        "TIME:20:16");

    doTest("T14",
        "1270 CARMONA DR (UNCONS) - 91-year-old, Female, Conscious, Breathing. Caller Statement: GRANDMOTHER HAD PASSED OUT. - 4027 - 31D03 19:47",
        "ADDR:1270 CARMONA DR",
        "CALL:UNCONS",
        "INFO:91-year-old, Female, Conscious, Breathing. Caller Statement: GRANDMOTHER HAD PASSED OUT.",
        "UNIT:4027",
        "CODE:31D03",
        "TIME:19:47");

    doTest("T15",
        "1036 ARMADA CT (MISC) - CHEMICAL SPILL BY POOL - 4034,4002 18:48",
        "ADDR:1036 ARMADA CT",
        "CALL:MISC",
        "INFO:CHEMICAL SPILL BY POOL",
        "UNIT:4034,4002",
        "TIME:18:48");

    doTest("T16",
        "1036 ARMADA CT (MISC) - CHEMICAL SPILL BY POOL - 4034,4002 18:48",
        "ADDR:1036 ARMADA CT",
        "CALL:MISC",
        "INFO:CHEMICAL SPILL BY POOL",
        "UNIT:4034,4002",
        "TIME:18:48");

    doTest("T17",
        "1025 BOULDER DR (OBS) - 34-year-old, Male, Conscious, Breathing. Caller Statement: INTOXICATED - OBS-FEELING SUICIDAL. - 4037 - 25B03 15:59",
        "ADDR:1025 BOULDER DR",
        "CALL:OBS",
        "INFO:34-year-old, Male, Conscious, Breathing. Caller Statement: INTOXICATED",
        "UNIT:OBS-FEELING SUICIDAL.",
        "CODE:4037 - 25B03",
        "TIME:15:59");

    doTest("T18",
        "100 N CASTELLO ST (EMS) - BRAIN BLEED/HAD MRI THIS AFTERNOON/68YOF - 4027 15:51",
        "ADDR:100 N CASTELLO ST",
        "CALL:EMS",
        "INFO:BRAIN BLEED/HAD MRI THIS AFTERNOON/68YOF",
        "UNIT:4027",
        "TIME:15:51");

    doTest("T19",
        "1535 ASCOT TERRACE (RES ALRM) - GENERAL FIRE ALRM - 4024 15:47",
        "ADDR:1535 ASCOT TERRACE",
        "CALL:RES ALRM",
        "INFO:GENERAL FIRE ALRM",
        "UNIT:4024",
        "TIME:15:47");

    doTest("T20",
        "695 MARK TWAIN DR (MISC) - STOVE - 4034,4002 15:44",
        "ADDR:695 MARK TWAIN DR",
        "CALL:MISC",
        "INFO:STOVE",
        "UNIT:4034,4002",
        "TIME:15:44");

    doTest("T21",
        "2365 INDIANCUP DR (STROKE) - 73-year-old, Male, Conscious, Breathing. Caller Statement: SEMIRESPONSIVE PT. - 4017 - 28C04X 15:17",
        "ADDR:2365 INDIANCUP DR",
        "CALL:STROKE",
        "INFO:73-year-old, Male, Conscious, Breathing. Caller Statement: SEMIRESPONSIVE PT.",
        "UNIT:4017",
        "CODE:28C04X",
        "TIME:15:17");

    doTest("T22",
        "11325 SUGAR PINE DR APT NONE (EMS) - MEDICAL ALRM - 4027 15:09",
        "ADDR:11325 SUGAR PINE DR",
        "APT:NONE",
        "CALL:EMS",
        "INFO:MEDICAL ALRM",
        "UNIT:4027",
        "TIME:15:09");

    doTest("T23",
        "1681 BARKWOOD DR (MISC) - STOVE - 4034 13:40",
        "ADDR:1681 BARKWOOD DR",
        "CALL:MISC",
        "INFO:STOVE",
        "UNIT:4034",
        "TIME:13:40");

    doTest("T24",
        "145 ST AUGUSTA LN (EMS) - ASSIST INVALID - 4015 11:49",
        "ADDR:145 ST AUGUSTA LN",
        "CALL:EMS",
        "INFO:ASSIST INVALID",
        "UNIT:4015",
        "TIME:11:49");

    doTest("T25",
        "1855 NEW FLORISSANT RD N APT 1 (UNCONS) - 68-year-old, Female, Not Conscious, Breathing. Caller Statement: UNRESPONSIVE /BREATHING. - 4015,3027 11:10",
        "ADDR:1855 NEW FLORISSANT RD N",
        "APT:1",
        "CALL:UNCONS",
        "INFO:68-year-old, Female, Not Conscious, Breathing. Caller Statement: UNRESPONSIVE /BREATHING.",
        "UNIT:4015,3027",
        "TIME:11:10");

    doTest("T26",
        "GRACE APOSTOLIC CHURCH, 11770 SEVEN HILLS DR (INST ALRM) - FELLOWSHIP ROOM B SMOKE / DUCT - 3025 11:05",
        "PLACE:GRACE APOSTOLIC CHURCH",
        "ADDR:11770 SEVEN HILLS DR",
        "CALL:INST ALRM",
        "INFO:FELLOWSHIP ROOM B SMOKE / DUCT",
        "UNIT:3025",
        "TIME:11:05");

    doTest("T27",
        "246 ANASTASIA DR (TRAPPED) - - 4024,4037 10:07",
        "ADDR:246 ANASTASIA DR",
        "CALL:TRAPPED",
        "UNIT:4024,4037",
        "TIME:10:07");

    doTest("T28",
        "DUNN ROAD MANOR, 3399 DUNN RD APT 307 (DIF BREATH) - 76-year-old, Female, Conscious, Breathing. Caller Statement: DIFF BREATHING / SIDE PAIN. - 4027 - 06D02 09:17",
        "PLACE:DUNN ROAD MANOR",
        "ADDR:3399 DUNN RD",
        "APT:307",
        "CALL:DIF BREATH",
        "INFO:76-year-old, Female, Conscious, Breathing. Caller Statement: DIFF BREATHING / SIDE PAIN.",
        "UNIT:4027",
        "CODE:06D02",
        "TIME:09:17");

    doTest("T29",
        "2251 CENTRAL PKWY (ABD PAIN) - 56-year-old, Male, Conscious, Breathing. Caller Statement: STOMACH PAINS. - 4017 - 01A01 07:02",
        "ADDR:2251 CENTRAL PKWY",
        "CALL:ABD PAIN",
        "INFO:56-year-old, Male, Conscious, Breathing. Caller Statement: STOMACH PAINS.",
        "UNIT:4017",
        "CODE:01A01",
        "TIME:07:02");

    doTest("T30",
        "250 FRANCISCA DR (DIABETIC) - 63-year-old, Male, Conscious, Breathing. Caller Statement: DIABETIC LOW B/S. - 4037 - 13C01 06:51",
        "ADDR:250 FRANCISCA DR",
        "CALL:DIABETIC",
        "INFO:63-year-old, Male, Conscious, Breathing. Caller Statement: DIABETIC LOW B/S.",
        "UNIT:4037",
        "CODE:13C01",
        "TIME:06:51");

    doTest("T31",
        "1241 ASPEN DR (DIF BREATH) - 37-year-old, Female, Conscious, Breathing. Caller Statement: diff breathing. - 4037 - 06D02 04:39",
        "ADDR:1241 ASPEN DR",
        "CALL:DIF BREATH",
        "INFO:37-year-old, Female, Conscious, Breathing. Caller Statement: diff breathing.",
        "UNIT:4037",
        "CODE:06D02",
        "TIME:04:39");
  }
  
  public static void main(String[] args) {
    new MOStLouisCountyAParserTest().generateTests("T1");
  }
}
