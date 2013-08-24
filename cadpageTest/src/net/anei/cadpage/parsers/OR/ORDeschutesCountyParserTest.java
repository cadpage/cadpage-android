package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.OR.ORDeschutesCountyParser;

import org.junit.Test;

/*
Deschutes County, OR
Contact:joanne day <frankday12@gmail.com>
Sender: 911@deschutes.org

Chest Pain Breathing normally => 35   -C-STA500-9395 SW SCOUT CAMP TRL-Map 131208-11:38:0
Sick Person Vomiting   -A-STA500-13852 SW CANYON DR-Map 131216-18:47:56
DEAD BODY/DEATH R3-R3-STA500-14537 SW STALLION DR-Map 131223-10:23:46
Falls Unk status Ground-B-STA500-13345 SW CINDER DR-Map 131215-00:30:04
Traffic Accidents HIGH MECH - Rollover-D2-STA500-SW BADGER RD/SW CHINOOK DR--13:11:56
Sick Person Abnormal breathing -C-512,571-8431 SW BASALT DR-Map 131216-10:46:05
Sick Person Vomiting   -A-STA500-13812 SW CANYON DR-Map 131216-18:47:56

Contact: Dustin Miller <ff3650dm@gmail.com>
STRUCTURE FIRE-SF-422,412,421,471,531,431,447,510,4PC-1995 NW LOWER BRIDGE WAY-Map 1413NW-19:04:36 
BRUSH FIRE HIGH RISK RESPONSE-BH-441,412,447,531,543,481,E640,448,541,442,544,4PC-NW 43RD ST/NW LOWER BRIDGE WAY-Map 1413NW-17:13:24

Contact: JASON ZOE ARNOLD <jzarnold@msn.com>
Stroke Abnormal breathing -C-271,221- 2 ROGUE LN 17692 ROGUE LN -Map 191129-08:11:41
Uncons / Fainting Not alert\3s-D-271,221- 10 HUMMINGBIRD LN 17553 HUMMINGBIRD LN -Map 191130-08:45:45
CHEST PAIN-C-271,221- 6 WALLOWA LOOP 57720 WALLOWA LOOP -Map 191128-06:54:45
 
Contact: "jaredjeffcott@yahoo.com" <jaredjeffcott@yahoo.com>
Sender: 911@deschutes.org
Stroke Vision Problems -C-271,221- 8 GROUSE LN 17887 GROUSE LN -Map 191132-17:56:37

Contact: : "fastflat255@yahoo.com" <fastflat255@yahoo.com>
Sender: 911@deschutes.org
BACK PAIN-A-571- 8562 SW SUNDOWN CANYON RD -Map 131216-23:38:04

Contact: Active911
Agency name: Redmond Fire Rescue
Location: Redmond, OR, United States
Sender: 911@deschutes.org

FALL-A-471- 3720 SW GENE SARAZAN DR -Map 151329-06:11:36
CHEST PAIN-C-471,421- 777 SW DESCHUTES AVE REDMOND POLICE DEPT -Map 151316-02:54:12
BRUSH FIRE LOW RISK RESPONSE-BL-412,444,424,442- 3648 NW LOWER BRIDGE WAY -Map 1413NW-00:34:45
FIRE ASSIST-SE-424,412- 3460 SW RESERVOIR DR -Map 151320-22:06:39
FIRE ASSIST-SE-424- 7376 SW MCVEY AVE -Map 1612NE-21:41:27
Hemorrhage / Lacerations Abnormal breathing   -D-474,421- 3420 SW NEWBERRY AVE -Map 151317-21:12:17
SICK PERSON-A-474- 3420 SW NEWBERRY AVE -Map 151317-21:09:52
Breathing Prob DIFF SPEAKING BETWEEN BREATHS   -D-571,451,470- 7777 S HWY 97 #70 GREEN ACRES MARKET & MOBILE PARK -Map 1612NE-18:21:51
STRUCTURE FIRE-SF-424,421,412,471,431,417,410,4PC- 7236 SW MCVEY AVE -Map 1612NE-16:55:25
FALL-A-472- 2618 NE SEDGEWICK AVE -Map 1413NE-15:39:35
BRUSH FIRE LOW RISK RESPONSE-BL-444- 139 SE VETERANS WAY JUNIPER GOLF CLUB (OLD) -Map 151322-15:14:12
FIRE ALARM-A1-4FM,412,424,ARFF1- 2522 SE JESSE BUTLER CIR #17 REDMOND AIRPORT ROBERTS FIELD -Map 151322-14:54:10
Breathing Prob Abnormal breathing   -C-471,421- 3550 SW CANAL BLVD BROOKSIDE HOUSE -Map 151329-14:45:25
SICK PERSON-A-471- 3550 SW CANAL BLVD BROOKSIDE HOUSE -Map 151329-14:43:47
NON-EMERGENCY TRANSFER OUT OF DISTRICT-BS2-472- 1253 NW CANAL BLVD ST CHARLES MEDICAL CENTER REDMOND -Map 151309-13:09:27
OVERDOSE/INGESTIONS/POISON-A-472- 1498 B AVE -Map 141316-11:02:23
BLEEDING/LACERATIONS-A-472- 10100 NE CROOKED RIVER DR #25 SMITH ROCK MOBILE ESTATES -Map 1413NE-07:29:44
NON-EMERGENCY TRANSFER OUT OF DISTRICT-BS2-472- 1253 NW CANAL BLVD ST CHARLES MEDICAL CENTER REDMOND -Map 151309-21:29:05
BRUSH FIRE LOW RISK RESPONSE-BL-444,412- 200 NW 95TH ST -Map 1512NE-19:54:13
SICK PERSON-A-474- 2212 SW 29TH ST -Map 151320-16:40:52
NON-EMERGENCY TRANSFER OUT OF DISTRICT-BS2-472- 1253 NW CANAL BLVD ST CHARLES MEDICAL CENTER REDMOND -Map 151309-16:08:51
Sick Person ALTERED LEVEL OF CONSCIOUSNESS   -C-471,412- 676 NE NEGUS WAY BEST CARE DETOX REDMOND -Map 151310-13:24:01
UNCONSCIOUS/UNKNOWN-A-472,421- 300 NW OAK TREE LN WALMART SUPERCENTER REDMOND -Map 151304-13:23:34
SICK PERSON-A-471- 676 NE NEGUS WAY BEST CARE DETOX REDMOND -Map 151310-13:20:46
BRUSH FIRE LOW RISK RESPONSE-BL-442,412- NW 43RD ST/NW POVEY AVE -Map 1413NW-10:42:44
FALL-A-474- 2464 SW 34TH DR -Map 151320-06:06:43
Hemorrhage / Lacerations DANGEROUS hemorrhage-D-471,421- 340 SW RIMROCK WAY #78 THE BLUFFS APARTMENTS -Map 151317-23:04:29
SICK PERSON-A-471- 340 SW RIMROCK WAY #78 THE BLUFFS APARTMENTS -Map 151317-23:03:33
ABDOMINAL PAIN-A-474- 2881 SW 32ND ST -Map 151320-20:26:28
Falls Not alert   -D-474,421- 3717 NW 25TH ST DEER HAVEN FOSTER HOME -Map 141332-15:47:43
FALL-A-474- 3717 NW 25TH ST DEER HAVEN FOSTER HOME -Map 141332-15:45:59
SMOKE INVESTIGATION-SEU-412,422- NE 33RD ST/NE SMITH ROCK WAY -Map 1413SE-15:41:36
Uncons / Fainting Alert w/ abnormal breathing   -C-471,424- 8053 PONY FALLS DR -Map 151214-11:25:28
UNCONSCIOUS/UNKNOWN-A-471- 8053 PONY FALLS DR -Map 151214-11:24:18
Unknown Problem Medical Alarm Alert notifications no pt info   -B-471- 2051 NE UINTAH CT -Map 151303-06:53:36
Uncons / Fainting Not alert   -D-471,421- 2118 SW PUMICE AVE -Map 151320-05:47:09
UNCONSCIOUS/UNKNOWN-A-471- 2118 SW PUMICE AVE -Map 151320-05:46:28
CHEST PAIN-C-471,421- 4496 SW BRIAR LN -Map 1514SE-01:13:07
SICK PERSON-A-474- 5170 SW WICKIUP AVE -Map 151325-20:45:54
INJURIES-A-471- 17037 SW ALFALFA RD -Map 161434-19:48:00
NON-EMERGENCY TRANSFER IN DISTRICT-BS1-471- 1253 NW CANAL BLVD ST CHARLES MEDICAL CENTER REDMOND -Map 151309-18:34:58

*/

public class ORDeschutesCountyParserTest extends BaseParserTest {
  
  public ORDeschutesCountyParserTest() {
    setParser(new ORDeschutesCountyParser(), "DESCHUTES COUNTY", "OR");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "Chest Pain Breathing normally => 35   -C-STA500-9395 SW SCOUT CAMP TRL-Map 131208-11:38:0",
        "CALL:Chest Pain Breathing normally => 35",
        "PRI:C",
        "SRC:STA500",
        "ADDR:9395 SW SCOUT CAMP TRL",
        "MAP:131208",
        "TIME:11:38:0");
    
    doTest("T2",
        "Sick Person Vomiting   -A-STA500-13852 SW CANYON DR-Map 131216-18:47:56",
        "CALL:Sick Person Vomiting",
        "PRI:A",
        "SRC:STA500",
        "ADDR:13852 SW CANYON DR",
        "MAP:131216",
        "TIME:18:47:56");
    
    doTest("T3",
        "DEAD BODY/DEATH R3-R3-STA500-14537 SW STALLION DR-Map 131223-10:23:46",
        "CALL:DEAD BODY/DEATH R3",
        "PRI:R3",
        "SRC:STA500",
        "ADDR:14537 SW STALLION DR",
        "MAP:131223",
        "TIME:10:23:46");
    
    doTest("T4",
        "Falls Unk status Ground-B-STA500-13345 SW CINDER DR-Map 131215-00:30:04",
        "CALL:Falls Unk status Ground",
        "PRI:B",
        "SRC:STA500",
        "ADDR:13345 SW CINDER DR",
        "MAP:131215",
        "TIME:00:30:04");
    
    doTest("T5",
        "Traffic Accidents HIGH MECH - Rollover-D2-STA500-SW BADGER RD/SW CHINOOK DR--13:11:56",
        "CALL:Traffic Accidents HIGH MECH - Rollover",
        "PRI:D2",
        "SRC:STA500",
        "ADDR:SW BADGER RD & SW CHINOOK DR",
        "TIME:13:11:56");

    doTest("T6",
        "Sick Person Abnormal breathing -C-512,571-8431 SW BASALT DR-Map 131216-10:46:05",
        "CALL:Sick Person Abnormal breathing",
        "PRI:C",
        "UNIT:512,571",
        "ADDR:8431 SW BASALT DR",
        "MAP:131216",
        "TIME:10:46:05");
    
    doTest("T7",
        "Sick Person Vomiting   -A-STA500-13812 SW CANYON DR-Map 131216-18:47:56",
        "CALL:Sick Person Vomiting",
        "PRI:A",
        "SRC:STA500",
        "ADDR:13812 SW CANYON DR",
        "MAP:131216",
        "TIME:18:47:56");

    doTest("T8",
        "STRUCTURE FIRE-SF-422,412,421,471,531,431,447,510,4PC-1995 NW LOWER BRIDGE WAY-Map 1413NW-19:04:36",
        "CALL:STRUCTURE FIRE",
        "PRI:SF",
        "UNIT:422,412,421,471,531,431,447,510,4PC",
        "ADDR:1995 NW LOWER BRIDGE WAY",
        "MAP:1413NW",
        "TIME:19:04:36");

    doTest("T9",
        "BRUSH FIRE HIGH RISK RESPONSE-BH-441,412,447,531,543,481,E640,448,541,442,544,4PC-NW 43RD ST/NW LOWER BRIDGE WAY-Map 1413NW-17:13:24",
        "CALL:BRUSH FIRE HIGH RISK RESPONSE",
        "PRI:BH",
        "UNIT:441,412,447,531,543,481,E640,448,541,442,544,4PC",
        "ADDR:NW 43RD ST & NW LOWER BRIDGE WAY",
        "MAP:1413NW",
        "TIME:17:13:24");

    doTest("T10",
        "Stroke Abnormal breathing -C-271,221- 2 ROGUE LN 17692 ROGUE LN -Map 191129-08:11:41",
        "CALL:Stroke Abnormal breathing",
        "PRI:C",
        "UNIT:271,221",
        "ADDR:2 ROGUE LN",
        "MAP:191129",
        "TIME:08:11:41");

    doTest("T11",
        "Uncons / Fainting Not alert\\3s-D-271,221- 10 HUMMINGBIRD LN 17553 HUMMINGBIRD LN -Map 191130-08:45:45",
        "CALL:Uncons / Fainting Not alert\\3s",
        "PRI:D",
        "UNIT:271,221",
        "ADDR:10 HUMMINGBIRD LN",
        "MAP:191130",
        "TIME:08:45:45");

    doTest("T12",
        "CHEST PAIN-C-271,221- 6 WALLOWA LOOP 57720 WALLOWA LOOP -Map 191128-06:54:45",
        "CALL:CHEST PAIN",
        "PRI:C",
        "UNIT:271,221",
        "ADDR:6 WALLOWA LOOP",
        "MAP:191128",
        "TIME:06:54:45");

    doTest("T13",
        "Stroke Vision Problems -C-271,221- 8 GROUSE LN 17887 GROUSE LN -Map 191132-17:56:37",
        "CALL:Stroke Vision Problems",
        "PRI:C",
        "UNIT:271,221",
        "ADDR:8 GROUSE LN",
        "MAP:191132",
        "TIME:17:56:37");

    doTest("T14",
        "BACK PAIN-A-571- 8562 SW SUNDOWN CANYON RD -Map 131216-23:38:04",
        "CALL:BACK PAIN",
        "PRI:A",
        "UNIT:571",
        "ADDR:8562 SW SUNDOWN CANYON RD",
        "MAP:131216",
        "TIME:23:38:04");

  }
  
  @Test
  public void testRedmondFireRescue() {

    doTest("T1",
        "FALL-A-471- 3720 SW GENE SARAZAN DR -Map 151329-06:11:36",
        "CALL:FALL",
        "PRI:A",
        "UNIT:471",
        "ADDR:3720 SW GENE SARAZAN DR",
        "MAP:151329",
        "TIME:06:11:36");

    doTest("T2",
        "CHEST PAIN-C-471,421- 777 SW DESCHUTES AVE REDMOND POLICE DEPT -Map 151316-02:54:12",
        "CALL:CHEST PAIN",
        "PRI:C",
        "UNIT:471,421",
        "ADDR:777 SW DESCHUTES AVE",
        "MAP:151316",
        "TIME:02:54:12");

    doTest("T3",
        "BRUSH FIRE LOW RISK RESPONSE-BL-412,444,424,442- 3648 NW LOWER BRIDGE WAY -Map 1413NW-00:34:45",
        "CALL:BRUSH FIRE LOW RISK RESPONSE",
        "PRI:BL",
        "UNIT:412,444,424,442",
        "ADDR:3648 NW LOWER BRIDGE WAY",
        "MAP:1413NW",
        "TIME:00:34:45");

    doTest("T4",
        "FIRE ASSIST-SE-424,412- 3460 SW RESERVOIR DR -Map 151320-22:06:39",
        "CALL:FIRE ASSIST",
        "PRI:SE",
        "UNIT:424,412",
        "ADDR:3460 SW RESERVOIR DR",
        "MAP:151320",
        "TIME:22:06:39");

    doTest("T5",
        "FIRE ASSIST-SE-424- 7376 SW MCVEY AVE -Map 1612NE-21:41:27",
        "CALL:FIRE ASSIST",
        "PRI:SE",
        "UNIT:424",
        "ADDR:7376 SW MCVEY AVE",
        "MAP:1612NE",
        "TIME:21:41:27");

    doTest("T6",
        "Hemorrhage / Lacerations Abnormal breathing   -D-474,421- 3420 SW NEWBERRY AVE -Map 151317-21:12:17",
        "CALL:Hemorrhage / Lacerations Abnormal breathing",
        "PRI:D",
        "UNIT:474,421",
        "ADDR:3420 SW NEWBERRY AVE",
        "MAP:151317",
        "TIME:21:12:17");

    doTest("T7",
        "SICK PERSON-A-474- 3420 SW NEWBERRY AVE -Map 151317-21:09:52",
        "CALL:SICK PERSON",
        "PRI:A",
        "UNIT:474",
        "ADDR:3420 SW NEWBERRY AVE",
        "MAP:151317",
        "TIME:21:09:52");

    doTest("T8",
        "Breathing Prob DIFF SPEAKING BETWEEN BREATHS   -D-571,451,470- 7777 S HWY 97 #70 GREEN ACRES MARKET & MOBILE PARK -Map 1612NE-18:21:51",
        "CALL:Breathing Prob DIFF SPEAKING BETWEEN BREATHS",
        "PRI:D",
        "UNIT:571,451,470",
        "ADDR:7777 S HWY 97",
        "APT:70",
        "MAP:1612NE",
        "TIME:18:21:51");

    doTest("T9",
        "STRUCTURE FIRE-SF-424,421,412,471,431,417,410,4PC- 7236 SW MCVEY AVE -Map 1612NE-16:55:25",
        "CALL:STRUCTURE FIRE",
        "PRI:SF",
        "UNIT:424,421,412,471,431,417,410,4PC",
        "ADDR:7236 SW MCVEY AVE",
        "MAP:1612NE",
        "TIME:16:55:25");

    doTest("T10",
        "FALL-A-472- 2618 NE SEDGEWICK AVE -Map 1413NE-15:39:35",
        "CALL:FALL",
        "PRI:A",
        "UNIT:472",
        "ADDR:2618 NE SEDGEWICK AVE",
        "MAP:1413NE",
        "TIME:15:39:35");

    doTest("T11",
        "BRUSH FIRE LOW RISK RESPONSE-BL-444- 139 SE VETERANS WAY JUNIPER GOLF CLUB (OLD) -Map 151322-15:14:12",
        "CALL:BRUSH FIRE LOW RISK RESPONSE",
        "PRI:BL",
        "UNIT:444",
        "ADDR:139 SE VETERANS WAY",
        "MAP:151322",
        "TIME:15:14:12");

    doTest("T12",
        "FIRE ALARM-A1-4FM,412,424,ARFF1- 2522 SE JESSE BUTLER CIR #17 REDMOND AIRPORT ROBERTS FIELD -Map 151322-14:54:10",
        "CALL:FIRE ALARM",
        "PRI:A1",
        "UNIT:4FM,412,424,ARFF1",
        "ADDR:2522 SE JESSE BUTLER CIR",  // Not mapping
        "APT:17",
        "MAP:151322",
        "TIME:14:54:10");

    doTest("T13",
        "Breathing Prob Abnormal breathing   -C-471,421- 3550 SW CANAL BLVD BROOKSIDE HOUSE -Map 151329-14:45:25",
        "CALL:Breathing Prob Abnormal breathing",
        "PRI:C",
        "UNIT:471,421",
        "ADDR:3550 SW CANAL BLVD",
        "MAP:151329",
        "TIME:14:45:25");

    doTest("T14",
        "SICK PERSON-A-471- 3550 SW CANAL BLVD BROOKSIDE HOUSE -Map 151329-14:43:47",
        "CALL:SICK PERSON",
        "PRI:A",
        "UNIT:471",
        "ADDR:3550 SW CANAL BLVD",
        "MAP:151329",
        "TIME:14:43:47");

    doTest("T15",
        "NON-EMERGENCY TRANSFER OUT OF DISTRICT-BS2-472- 1253 NW CANAL BLVD ST CHARLES MEDICAL CENTER REDMOND -Map 151309-13:09:27",
        "CALL:NON-EMERGENCY TRANSFER OUT OF DISTRICT",
        "PRI:BS2",
        "UNIT:472",
        "ADDR:1253 NW CANAL BLVD",
        "MAP:151309",
        "TIME:13:09:27");

    doTest("T16",
        "OVERDOSE/INGESTIONS/POISON-A-472- 1498 B AVE -Map 141316-11:02:23",
        "CALL:OVERDOSE/INGESTIONS/POISON",
        "PRI:A",
        "UNIT:472",
        "ADDR:1498 B AVE",
        "MAP:141316",
        "TIME:11:02:23");

    doTest("T17",
        "BLEEDING/LACERATIONS-A-472- 10100 NE CROOKED RIVER DR #25 SMITH ROCK MOBILE ESTATES -Map 1413NE-07:29:44",
        "CALL:BLEEDING/LACERATIONS",
        "PRI:A",
        "UNIT:472",
        "ADDR:10100 NE CROOKED RIVER DR",
        "APT:25",
        "MAP:1413NE",
        "TIME:07:29:44");

    doTest("T18",
        "NON-EMERGENCY TRANSFER OUT OF DISTRICT-BS2-472- 1253 NW CANAL BLVD ST CHARLES MEDICAL CENTER REDMOND -Map 151309-21:29:05",
        "CALL:NON-EMERGENCY TRANSFER OUT OF DISTRICT",
        "PRI:BS2",
        "UNIT:472",
        "ADDR:1253 NW CANAL BLVD",
        "MAP:151309",
        "TIME:21:29:05");

    doTest("T19",
        "BRUSH FIRE LOW RISK RESPONSE-BL-444,412- 200 NW 95TH ST -Map 1512NE-19:54:13",
        "CALL:BRUSH FIRE LOW RISK RESPONSE",
        "PRI:BL",
        "UNIT:444,412",
        "ADDR:200 NW 95TH ST",
        "MAP:1512NE",
        "TIME:19:54:13");

    doTest("T20",
        "SICK PERSON-A-474- 2212 SW 29TH ST -Map 151320-16:40:52",
        "CALL:SICK PERSON",
        "PRI:A",
        "UNIT:474",
        "ADDR:2212 SW 29TH ST",
        "MAP:151320",
        "TIME:16:40:52");

    doTest("T21",
        "NON-EMERGENCY TRANSFER OUT OF DISTRICT-BS2-472- 1253 NW CANAL BLVD ST CHARLES MEDICAL CENTER REDMOND -Map 151309-16:08:51",
        "CALL:NON-EMERGENCY TRANSFER OUT OF DISTRICT",
        "PRI:BS2",
        "UNIT:472",
        "ADDR:1253 NW CANAL BLVD",
        "MAP:151309",
        "TIME:16:08:51");

    doTest("T22",
        "Sick Person ALTERED LEVEL OF CONSCIOUSNESS   -C-471,412- 676 NE NEGUS WAY BEST CARE DETOX REDMOND -Map 151310-13:24:01",
        "CALL:Sick Person ALTERED LEVEL OF CONSCIOUSNESS",
        "PRI:C",
        "UNIT:471,412",
        "ADDR:676 NE NEGUS WAY",
        "MAP:151310",
        "TIME:13:24:01");

    doTest("T23",
        "UNCONSCIOUS/UNKNOWN-A-472,421- 300 NW OAK TREE LN WALMART SUPERCENTER REDMOND -Map 151304-13:23:34",
        "CALL:UNCONSCIOUS/UNKNOWN",
        "PRI:A",
        "UNIT:472,421",
        "ADDR:300 NW OAK TREE LN",
        "MAP:151304",
        "TIME:13:23:34");

    doTest("T24",
        "SICK PERSON-A-471- 676 NE NEGUS WAY BEST CARE DETOX REDMOND -Map 151310-13:20:46",
        "CALL:SICK PERSON",
        "PRI:A",
        "UNIT:471",
        "ADDR:676 NE NEGUS WAY",
        "MAP:151310",
        "TIME:13:20:46");

    doTest("T25",
        "BRUSH FIRE LOW RISK RESPONSE-BL-442,412- NW 43RD ST/NW POVEY AVE -Map 1413NW-10:42:44",
        "CALL:BRUSH FIRE LOW RISK RESPONSE",
        "PRI:BL",
        "UNIT:442,412",
        "ADDR:NW 43RD ST & NW POVEY AVE",
        "MAP:1413NW",
        "TIME:10:42:44");

    doTest("T26",
        "FALL-A-474- 2464 SW 34TH DR -Map 151320-06:06:43",
        "CALL:FALL",
        "PRI:A",
        "UNIT:474",
        "ADDR:2464 SW 34TH DR",
        "MAP:151320",
        "TIME:06:06:43");

    doTest("T27",
        "Hemorrhage / Lacerations DANGEROUS hemorrhage-D-471,421- 340 SW RIMROCK WAY #78 THE BLUFFS APARTMENTS -Map 151317-23:04:29",
        "CALL:Hemorrhage / Lacerations DANGEROUS hemorrhage",
        "PRI:D",
        "UNIT:471,421",
        "ADDR:340 SW RIMROCK WAY",
        "APT:78",
        "MAP:151317",
        "TIME:23:04:29");

    doTest("T28",
        "SICK PERSON-A-471- 340 SW RIMROCK WAY #78 THE BLUFFS APARTMENTS -Map 151317-23:03:33",
        "CALL:SICK PERSON",
        "PRI:A",
        "UNIT:471",
        "ADDR:340 SW RIMROCK WAY",
        "APT:78",
        "MAP:151317",
        "TIME:23:03:33");

    doTest("T29",
        "ABDOMINAL PAIN-A-474- 2881 SW 32ND ST -Map 151320-20:26:28",
        "CALL:ABDOMINAL PAIN",
        "PRI:A",
        "UNIT:474",
        "ADDR:2881 SW 32ND ST",
        "MAP:151320",
        "TIME:20:26:28");

    doTest("T30",
        "Falls Not alert   -D-474,421- 3717 NW 25TH ST DEER HAVEN FOSTER HOME -Map 141332-15:47:43",
        "CALL:Falls Not alert",
        "PRI:D",
        "UNIT:474,421",
        "ADDR:3717 NW 25TH ST",
        "MAP:141332",
        "TIME:15:47:43");

    doTest("T31",
        "FALL-A-474- 3717 NW 25TH ST DEER HAVEN FOSTER HOME -Map 141332-15:45:59",
        "CALL:FALL",
        "PRI:A",
        "UNIT:474",
        "ADDR:3717 NW 25TH ST",
        "MAP:141332",
        "TIME:15:45:59");

    doTest("T32",
        "SMOKE INVESTIGATION-SEU-412,422- NE 33RD ST/NE SMITH ROCK WAY -Map 1413SE-15:41:36",
        "CALL:SMOKE INVESTIGATION",
        "PRI:SEU",
        "UNIT:412,422",
        "ADDR:NE 33RD ST & NE SMITH ROCK WAY",
        "MAP:1413SE",
        "TIME:15:41:36");

    doTest("T33",
        "Uncons / Fainting Alert w/ abnormal breathing   -C-471,424- 8053 PONY FALLS DR -Map 151214-11:25:28",
        "CALL:Uncons / Fainting Alert w/ abnormal breathing",
        "PRI:C",
        "UNIT:471,424",
        "ADDR:8053 PONY FALLS DR",
        "MAP:151214",
        "TIME:11:25:28");

    doTest("T34",
        "UNCONSCIOUS/UNKNOWN-A-471- 8053 PONY FALLS DR -Map 151214-11:24:18",
        "CALL:UNCONSCIOUS/UNKNOWN",
        "PRI:A",
        "UNIT:471",
        "ADDR:8053 PONY FALLS DR",
        "MAP:151214",
        "TIME:11:24:18");

    doTest("T35",
        "Unknown Problem Medical Alarm Alert notifications no pt info   -B-471- 2051 NE UINTAH CT -Map 151303-06:53:36",
        "CALL:Unknown Problem Medical Alarm Alert notifications no pt info",
        "PRI:B",
        "UNIT:471",
        "ADDR:2051 NE UINTAH CT",
        "MAP:151303",
        "TIME:06:53:36");

    doTest("T36",
        "Uncons / Fainting Not alert   -D-471,421- 2118 SW PUMICE AVE -Map 151320-05:47:09",
        "CALL:Uncons / Fainting Not alert",
        "PRI:D",
        "UNIT:471,421",
        "ADDR:2118 SW PUMICE AVE",
        "MAP:151320",
        "TIME:05:47:09");

    doTest("T37",
        "UNCONSCIOUS/UNKNOWN-A-471- 2118 SW PUMICE AVE -Map 151320-05:46:28",
        "CALL:UNCONSCIOUS/UNKNOWN",
        "PRI:A",
        "UNIT:471",
        "ADDR:2118 SW PUMICE AVE",
        "MAP:151320",
        "TIME:05:46:28");

    doTest("T38",
        "CHEST PAIN-C-471,421- 4496 SW BRIAR LN -Map 1514SE-01:13:07",
        "CALL:CHEST PAIN",
        "PRI:C",
        "UNIT:471,421",
        "ADDR:4496 SW BRIAR LN",
        "MAP:1514SE",
        "TIME:01:13:07");

    doTest("T39",
        "SICK PERSON-A-474- 5170 SW WICKIUP AVE -Map 151325-20:45:54",
        "CALL:SICK PERSON",
        "PRI:A",
        "UNIT:474",
        "ADDR:5170 SW WICKIUP AVE",
        "MAP:151325",
        "TIME:20:45:54");

    doTest("T40",
        "INJURIES-A-471- 17037 SW ALFALFA RD -Map 161434-19:48:00",
        "CALL:INJURIES",
        "PRI:A",
        "UNIT:471",
        "ADDR:17037 SW ALFALFA RD",
        "MAP:161434",
        "TIME:19:48:00");

    doTest("T41",
        "NON-EMERGENCY TRANSFER IN DISTRICT-BS1-471- 1253 NW CANAL BLVD ST CHARLES MEDICAL CENTER REDMOND -Map 151309-18:34:58",
        "CALL:NON-EMERGENCY TRANSFER IN DISTRICT",
        "PRI:BS1",
        "UNIT:471",
        "ADDR:1253 NW CANAL BLVD",
        "MAP:151309",
        "TIME:18:34:58");

  }
  
  public static void main(String args[]) {
    new ORDeschutesCountyParserTest().generateTests("T1");
  }
}