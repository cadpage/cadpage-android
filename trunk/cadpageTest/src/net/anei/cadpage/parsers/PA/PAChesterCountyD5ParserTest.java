package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAChesterCountyD5ParserTest extends BaseParserTest {
  
  public PAChesterCountyD5ParserTest() {
    setParser(new PAChesterCountyD5Parser(), "CHESTER COUNTY", "PA");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(MFC) GSHF ** 01:19 ** RESPIRATORY DIFFICULTY - ALS * ** 317 DEVON WY ,53 ** - ** DEVON LA & DEVON WY ** 5684 ** EGOSHN ** 60/F - HAVING ANXIETY, SOB\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:01:19",
        "CALL:RESPIRATORY DIFFICULTY - ALS",
        "ADDR:317 DEVON WY",
        "CITY:EAST GOSHEN TWP",
        "X:DEVON LA & DEVON WY",
        "BOX:5684",
        "INFO:60/F - HAVING ANXIETY, SOB");

    doTest("T2",
        "(MFC) MALF ** 08:24 ** CVA/STROKE - ALS * ** 414 PAOLI PK ,54 ** 2ND FLR, M ** FOX RIDGE DR & HOSPITAL D ** 0484 ** WILLIS ** 85 YOA/F - LEFT SIDED WEAKNESS\n\n" +
        "DETAILS TO FOLLOW\n" +
        " ** \n" +
        "From: messaging@emergencysmc.com",

        "SRC:MFC",
        "TIME:08:24",
        "CALL:CVA/STROKE - ALS",
        "ADDR:414 PAOLI PK",
        "MADDR:414 PAOLI PIKE",
        "CITY:WILLISTOWN TWP",
        "PLACE:2ND FLR, M",
        "X:FOX RIDGE DR & HOSPITAL D",
        "BOX:0484",
        "INFO:85 YOA/F - LEFT SIDED WEAKNESS");

    doTest("T3",
        "(MFC) EWHF ** 11:00 ** ABDOMINAL PAIN - ALS * ** 477 LANCASTER AV ,42 ** SLEEPY'S- ** ASPEN LA & CHARLES ST ** 0501 ** EWHITE ** 46/M--PAIN IN STOMACH--HAVING RESPDIF\n\n" +
        "DETAILS TO ** ",

        "SRC:MFC",
        "TIME:11:00",
        "CALL:ABDOMINAL PAIN - ALS",
        "ADDR:477 LANCASTER AV",
        "MADDR:477 LANCASTER AVE",
        "CITY:EAST WHITELAND TWP",
        "PLACE:SLEEPY'S-",
        "X:ASPEN LA & CHARLES ST",
        "BOX:0501",
        "INFO:46/M--PAIN IN STOMACH--HAVING RESPDIF");

    doTest("T4",
        "(MFC) PLIF ** 11:27 ** RESPIRATORY DIFFICULTY - ALS * ** 2 INDUSTRIAL BL ,54 ** SUITE 110, ** W CENTRAL AV & INDUSTRIAL ** 0314 ** WILLIS ** COME IN ENTRANCE 'C\" FOR BEST ACCESS. 80 YOA/F\n\n" +
        "/ ** ",

        "SRC:MFC",
        "TIME:11:27",
        "CALL:RESPIRATORY DIFFICULTY - ALS",
        "ADDR:2 INDUSTRIAL BL",
        "APT:110,",
        "CITY:WILLISTOWN TWP",
        "X:W CENTRAL AV & INDUSTRIAL",
        "BOX:0314",
        "INFO:COME IN ENTRANCE 'C\" FOR BEST ACCESS. 80 YOA/F");

    doTest("T5",
        "(MFC) PLIF ** 11:50 ** HYPO TENSION - ALS * ** 600 PAOLI POINTE DR ,43 ** ROOM 105-H ** DEAD END & E CENTRAL AV ** 0303 ** TREDYF ** 92/F 90/56\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:11:50",
        "CALL:HYPO TENSION - ALS",
        "ADDR:600 PAOLI POINTE DR",
        "APT:105-H",
        "CITY:TREDYFFRIN TWP",
        "X:DEAD END & E CENTRAL AV",
        "BOX:0303",
        "INFO:92/F 90/56");

    doTest("T6",
        "(MFC) BERF ** 12:04 ** SEIZURES - ALS * ** 200 W SWEDESFORD RD ,43 ** INSIDE BIG ** N VALLEY FORGE RD & CONTE ** 0271 ** TREDYF ** 40'S/M\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:12:04",
        "CALL:SEIZURES - ALS",
        "ADDR:200 W SWEDESFORD RD",
        "CITY:TREDYFFRIN TWP",
        "PLACE:INSIDE BIG",
        "X:N VALLEY FORGE RD & CONTE",
        "BOX:0271",
        "INFO:40'S/M");

    doTest("T7",
        "(MFC) MALF ** 14:01 ** CVA/STROKE - ALS * ** 414 PAOLI PK ,54 ** RM 320--OA ** FOX RIDGE DR & HOSPITAL D ** 0484 ** WILLIS ** 84/M\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:14:01",
        "CALL:CVA/STROKE - ALS",
        "ADDR:414 PAOLI PK",
        "MADDR:414 PAOLI PIKE",
        "APT:320--OA",
        "CITY:WILLISTOWN TWP",
        "X:FOX RIDGE DR & HOSPITAL D",
        "BOX:0484",
        "INFO:84/M");

    doTest("T8",
        "(MFC) EWHF ** 17:53 ** RESPIRATORY DIFFICULTY - ALS * ** 1145 KING RD ,42 ** -CAMILLA H ** GILLET DR & IMMACULATA DR ** 0599 ** EWHITE ** 17/F--\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:17:53",
        "CALL:RESPIRATORY DIFFICULTY - ALS",
        "ADDR:1145 KING RD",
        "CITY:EAST WHITELAND TWP",
        "PLACE:-CAMILLA H",
        "X:GILLET DR & IMMACULATA DR",
        "BOX:0599",
        "INFO:17/F--");

    doTest("T9",
        "(MFC) MALF ** 21:28 ** INJURED PERSON - BLS * ** 131 PROSPECT AV ,02 ** - ** MONUMENT AV & W FIRST AV ** 0401 ** MALVRN ** 67/F--INJ TOE\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:21:28",
        "CALL:INJURED PERSON - BLS",
        "ADDR:131 PROSPECT AV",
        "MADDR:131 PROSPECT AVE",
        "CITY:MALVERN",
        "X:MONUMENT AV & W FIRST AV",
        "BOX:0401",
        "INFO:67/F--INJ TOE");

    doTest("T10",
        "(MFC) PLIF ** 21:49 ** CVA/STROKE - ALS * ** 139 SPRUCE LA ,54 ** - ** PINE TREE RD & DEVON RD ** 0305 ** WILLIS ** 50S/M POSS STROKE, DROOPING MOUTH ON ONE SIDE\n\n" +
        "DET ** ",

        "SRC:MFC",
        "TIME:21:49",
        "CALL:CVA/STROKE - ALS",
        "ADDR:139 SPRUCE LA",
        "MADDR:139 SPRUCE LN",
        "CITY:WILLISTOWN TWP",
        "X:PINE TREE RD & DEVON RD",
        "BOX:0305",
        "INFO:50S/M POSS STROKE, DROOPING MOUTH ON ONE SIDE");

    doTest("T11",
        "(MFC) GSHF ** 22:08 ** HEMORRHAGING - ALS * ** 1361 BOOT RD ,53 ** RM 237-WEL ** CARRIAGE DR & JACLYN DR ** 5684 ** EGOSHN ** 87/M\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:22:08",
        "CALL:HEMORRHAGING - ALS",
        "ADDR:1361 BOOT RD",
        "APT:237-WEL",
        "CITY:EAST GOSHEN TWP",
        "X:CARRIAGE DR & JACLYN DR",
        "BOX:5684",
        "INFO:87/M");

    doTest("T12",
        "(MFC) MALF ** 23:22 ** FALLS - BLS / LIFT ASSIST * ** 324 LANCASTER AV ,54 ** REMENISCEN ** WOODVIEW WY & E LANCASTER ** 0483 ** WILLIS ** 94/M\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:23:22",
        "CALL:FALLS - BLS / LIFT ASSIST",
        "ADDR:324 LANCASTER AV",
        "MADDR:324 LANCASTER AVE",
        "CITY:WILLISTOWN TWP",
        "PLACE:REMENISCEN",
        "X:WOODVIEW WY & E LANCASTER",
        "BOX:0483",
        "INFO:94/M");

    doTest("T13",
        "(MFC) MALF ** 23:54 ** EMOTIONAL DISORDER - BLS * ** 940 KING RD ,53 ** RM 109-MAL ** MUNICIPAL BOUNDARY & MADE ** 0488 ** EGOSHN ** 48/F SUICIDAL THOUGHTS\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:23:54",
        "CALL:EMOTIONAL DISORDER - BLS",
        "ADDR:940 KING RD",
        "APT:109-MAL",
        "CITY:EAST GOSHEN TWP",
        "X:MUNICIPAL BOUNDARY & MADE",
        "BOX:0488",
        "INFO:48/F SUICIDAL THOUGHTS");

    doTest("T14",
        "(MFC) EWHF ** 08:30 ** SYNCOPE/FAINTING - ALS * ** 1 TANGLEWOOD LA ,42 ** USE FRT DO ** SUMMIT RD & DEAD END ** 0503 ** EWHITE ** 71/F\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:08:30",
        "CALL:SYNCOPE/FAINTING - ALS",
        "ADDR:1 TANGLEWOOD LA",
        "MADDR:1 TANGLEWOOD LN",
        "CITY:EAST WHITELAND TWP",
        "PLACE:USE FRT DO",
        "X:SUMMIT RD & DEAD END",
        "BOX:0503",
        "INFO:71/F");

    doTest("T15",
        "(MFC) GSHF ** 09:02 ** HOUSE FIRE * ** 1000 HERSHEY MILL RD ,53 ** - ** MILLSTREAM DR & TANGLEWOO ** 5603 ** EGOSHN ** SIDE OF HOUSE ON FIRE FROM CIGARETTE BUTT\n\n" +
        "DETAILS ** ",

        "SRC:MFC",
        "TIME:09:02",
        "CALL:HOUSE FIRE",
        "ADDR:1000 HERSHEY MILL RD",
        "CITY:EAST GOSHEN TWP",
        "X:MILLSTREAM DR & TANGLEWOO",
        "BOX:5603",
        "INFO:SIDE OF HOUSE ON FIRE FROM CIGARETTE BUTT");

    doTest("T16",
        "(MFC) GSHF ** 09:36 ** FALLS - BLS / LIFT ASSIST * ** 1615 E BOOT RD ,53 ** AT REAR EN ** N CHESTER RD & APPLEBROOK ** 5655 ** EGOSHN ** PAIN IN SHOULDER, FROM STANDING, 90/M\n\n" +
        "DETAILS TO ** \n" +
        "From: messaging@emergencysmc.com",

        "SRC:MFC",
        "TIME:09:36",
        "CALL:FALLS - BLS / LIFT ASSIST",
        "ADDR:1615 E BOOT RD",
        "CITY:EAST GOSHEN TWP",
        "PLACE:AT REAR EN",
        "X:N CHESTER RD & APPLEBROOK",
        "BOX:5655",
        "INFO:PAIN IN SHOULDER, FROM STANDING, 90/M");

    doTest("T17",
        "(MFC) EWHF ** 18:26 ** RESPIRATORY DIFFICULTY - ALS * ** 6 WATERS RD ,42 ** - ** SUMMIT RD & DEAD END ** 0503 ** EWHITE ** 95F HI TEMP, RESP DIFF\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:18:26",
        "CALL:RESPIRATORY DIFFICULTY - ALS",
        "ADDR:6 WATERS RD",
        "CITY:EAST WHITELAND TWP",
        "X:SUMMIT RD & DEAD END",
        "BOX:0503",
        "INFO:95F HI TEMP, RESP DIFF");

    doTest("T18",
        "(MFC) MALF ** 19:03 ** BRUSH FIRE * ** 35 LANDMARK DR ,02 ** JUST PAST ** DEAD END & N SUGARTOWN RD ** 0401 ** MALVRN ** PINENEEDLES SET ON FIRE BY JUVS\n\n" +
        "DETAILS TO FOLLOW ** ",

        "SRC:MFC",
        "TIME:19:03",
        "CALL:BRUSH FIRE",
        "ADDR:35 LANDMARK DR",
        "CITY:MALVERN",
        "PLACE:JUST PAST",
        "X:DEAD END & N SUGARTOWN RD",
        "BOX:0401",
        "INFO:PINENEEDLES SET ON FIRE BY JUVS");

    doTest("T19",
        "(MFC) PLIF ** 19:26 ** FALLS - ALS * ** 18 COBBLESTONE DR ,54 ** - ** MUNICIPAL BOUNDARY & MUNI ** 0305 ** WILLIS ** 57/M FELL FROM 2 STORY ROOF\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:19:26",
        "CALL:FALLS - ALS",
        "ADDR:18 COBBLESTONE DR",
        "CITY:WILLISTOWN TWP",
        "X:MUNICIPAL BOUNDARY & MUNI",
        "BOX:0305",
        "INFO:57/M FELL FROM 2 STORY ROOF");

    doTest("T20",
        "(MFC) EWHF ** 00:57 ** FALLS - BLS / LIFT ASSIST * ** 4 OAK HILL CI ,42 ** - ** SUMMIT RD & FOREST WY ** 0503 ** EWHITE ** **LIFT ASSIST ONLY***90/M\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:00:57",
        "CALL:FALLS - BLS / LIFT ASSIST",
        "ADDR:4 OAK HILL CI",
        "MADDR:4 OAK HILL CIR",
        "CITY:EAST WHITELAND TWP",
        "X:SUMMIT RD & FOREST WY",
        "BOX:0503",
        "INFO:LIFT ASSIST ONLY / *90/M");

    doTest("T21",
        "(MFC) MALF ** 06:59 ** UNRESPONSIVE PERSON - ALS * ** 308 CHARLESTON GREENE ,02 ** - ** DEAD END & W KING ST ** 0481 ** MALVRN ** 70/M\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:06:59",
        "CALL:UNRESPONSIVE PERSON - ALS",
        "ADDR:308 CHARLESTON GREENE",
        "CITY:MALVERN",
        "X:DEAD END & W KING ST",
        "BOX:0481",
        "INFO:70/M");

    doTest("T22",
        "(MFC) EWHF ** 14:16 ** UNCONSCIOUS PERSON - ALS * ** 235 LANCASTER AV ,42 ** QVC STORE- ** MALIN RD & MAPLE LINDEN L ** 0505 ** EWHITE ** 18 MONTH/F -\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:14:16",
        "CALL:UNCONSCIOUS PERSON - ALS",
        "ADDR:235 LANCASTER AV",
        "MADDR:235 LANCASTER AVE",
        "CITY:EAST WHITELAND TWP",
        "PLACE:QVC STORE-",
        "X:MALIN RD & MAPLE LINDEN L",
        "BOX:0505",
        "INFO:18 MONTH/F -");

    doTest("T23",
        "(MFC) MALF ** 15:35 ** RESPIRATORY DIFFICULTY - ALS * ** 324 LANCASTER AV ,54 ** 1ST FLOOR ** WOODVIEW WY & E LANCASTER ** 0483 ** WILLIS ** 74/F\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:15:35",
        "CALL:RESPIRATORY DIFFICULTY - ALS",
        "ADDR:324 LANCASTER AV",
        "MADDR:324 LANCASTER AVE",
        "CITY:WILLISTOWN TWP",
        "PLACE:1ST FLOOR",
        "X:WOODVIEW WY & E LANCASTER",
        "BOX:0483",
        "INFO:74/F");

    doTest("T24",
        "(MFC) MALF ** 18:43 ** ALARM - FIRE * ** 105 MOUNTAIN LAUREL LA ,02 ** SIEGEL RES ** OLD LINCOLN HW & DEAD END ** 0401 ** MALVRN ** AFA--FIRST FLOOR AND BASEMENT SMOKE DETECTOR--\n\n" +
        "AT ** ",

        "SRC:MFC",
        "TIME:18:43",
        "CALL:ALARM - FIRE",
        "ADDR:105 MOUNTAIN LAUREL LA",
        "MADDR:105 MOUNTAIN LAUREL LN",
        "CITY:MALVERN",
        "PLACE:SIEGEL RES",
        "X:OLD LINCOLN HW & DEAD END",
        "BOX:0401",
        "INFO:AFA--FIRST FLOOR AND BASEMENT SMOKE DETECTOR--");

    doTest("T25",
        "(MFC) MALF ** 02:21 ** HEART PROBLEMS - ALS * ** 414 PAOLI PK ,54 ** ROOM 103 B ** FOX RIDGE DR & HOSPITAL D ** 0484 ** WILLIS ** 80/F, AFIB AND ABDOMINAL PAIN\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:02:21",
        "CALL:HEART PROBLEMS - ALS",
        "ADDR:414 PAOLI PK",
        "MADDR:414 PAOLI PIKE",
        "APT:103 B",
        "CITY:WILLISTOWN TWP",
        "X:FOX RIDGE DR & HOSPITAL D",
        "BOX:0484",
        "INFO:80/F, AFIB AND ABDOMINAL PAIN");

    doTest("T26",
        "(MFC) EWHF ** 14:36 ** CVA/STROKE - ALS * ** SB RT 202 NO RT 29 ,42   (V) ** 3RD EMERGE **  ** 0519 ** EWHITE ** PT IS IN A RED CHEVY MALABU--3RD PARTY INFO 25\n\n" +
        " Y ** ",

        "SRC:MFC",
        "TIME:14:36",
        "CALL:CVA/STROKE - ALS",
        "ADDR:SB RT 202 NO RT 29",
        "MADDR:RT 202 & RT 29",
        "CITY:EAST WHITELAND TWP",
        "PLACE:3RD EMERGE",
        "BOX:0519",
        "INFO:PT IS IN A RED CHEVY MALABU--3RD PARTY INFO 25");

    doTest("T27",
        "(MFC) GSHF ** 16:12 ** HEMORRHAGING - ALS * ** 1650 YARDLEY DR ,53 ** - ** CHANDLER DR & YARDLEY CT ** 5684 ** EGOSHN ** 87/F - NOSEBLEED FOR 10 MINS\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        "T ** ",

        "SRC:MFC",
        "TIME:16:12",
        "CALL:HEMORRHAGING - ALS",
        "ADDR:1650 YARDLEY DR",
        "CITY:EAST GOSHEN TWP",
        "X:CHANDLER DR & YARDLEY CT",
        "BOX:5684",
        "INFO:87/F - NOSEBLEED FOR 10 MINS");

    doTest("T28",
        "(MFC) EWHF ** 07:55 ** FALLS - ALS * ** 1145 KING RD ,42 ** 3RD WEST - ** GILLET DR & IMMACULATA DR ** 0599 ** EWHITE ** 96 YO F- POSS FRAC FEMUR OR HIP FROM FALL = HX\n\n" +
        ": ** ",

        "SRC:MFC",
        "TIME:07:55",
        "CALL:FALLS - ALS",
        "ADDR:1145 KING RD",
        "CITY:EAST WHITELAND TWP",
        "PLACE:3RD WEST -",
        "X:GILLET DR & IMMACULATA DR",
        "BOX:0599",
        "INFO:96 YO F- POSS FRAC FEMUR OR HIP FROM FALL = HX");

    doTest("T29",
        "(MFC) EWHF ** 07:59 ** FALLS - BLS / LIFT ASSIST * ** 4 FORGE DR ,42 ** - ** WILBURDALE RD & DALE LA ** 0508 ** EWHITE ** 81 Y/O F--FALL FROM STANDING POSITION\n\n" +
        "DETAILS TO ** ",

        "SRC:MFC",
        "TIME:07:59",
        "CALL:FALLS - BLS / LIFT ASSIST",
        "ADDR:4 FORGE DR",
        "CITY:EAST WHITELAND TWP",
        "X:WILBURDALE RD & DALE LA",
        "BOX:0508",
        "INFO:81 Y/O F--FALL FROM STANDING POSITION");

    doTest("T30",
        "(MFC) EWHF ** 09:08 ** POLES,WIRES,TRANSFORMER FIRE * ** 333 WARREN AV ,42 ** IFO- ** SPRING RD & OLD LANCASTER ** 0504 ** EWHITE ** TREE LIMB TOUCHING WIRE SMOKING\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:09:08",
        "CALL:POLES,WIRES,TRANSFORMER FIRE",
        "ADDR:333 WARREN AV",
        "MADDR:333 WARREN AVE",
        "CITY:EAST WHITELAND TWP",
        "PLACE:IFO-",
        "X:SPRING RD & OLD LANCASTER",
        "BOX:0504",
        "INFO:TREE LIMB TOUCHING WIRE SMOKING");

    doTest("T31",
        "(MFC) MALF ** 10:08 ** CHEST PAINS - ALS * ** 2 SECOND AV ,54 ** - ** DUFFRYN AV & GRUBB RD ** 0403 ** WILLIS ** 79/F-CHEST DISCOMFORT-TOOK NITROSTAT FEW MINS \n\n" +
        "AG ** ",

        "SRC:MFC",
        "TIME:10:08",
        "CALL:CHEST PAINS - ALS",
        "ADDR:2 SECOND AV",
        "MADDR:2 SECOND AVE",
        "CITY:WILLISTOWN TWP",
        "X:DUFFRYN AV & GRUBB RD",
        "BOX:0403",
        "INFO:79/F-CHEST DISCOMFORT-TOOK NITROSTAT FEW MINS");

    doTest("T32",
        "(MFC) MALF ** 16:07 ** SICK PERSON - BLS * ** 324 LANCASTER AV ,54 ** 1ST FLR RE ** WOODVIEW WY & E LANCASTER ** 0483 ** WILLIS ** 70/MALE-DIZZY\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:16:07",
        "CALL:SICK PERSON - BLS",
        "ADDR:324 LANCASTER AV",
        "MADDR:324 LANCASTER AVE",
        "CITY:WILLISTOWN TWP",
        "PLACE:1ST FLR RE",
        "X:WOODVIEW WY & E LANCASTER",
        "BOX:0483",
        "INFO:70/MALE-DIZZY");

    doTest("T33",
        "(MFC) EWHF ** 16:46 ** HEART PROBLEMS - ALS * ** 50 FOUNDRY WY ,42 ** NEXT TO PU ** WYETH DR & CHESTER VALLEY ** 0566 ** EWHITE ** 33/F - FEELING FAINT - RAPID HEART BEAT\n\n" +
        "DETAILS T ** ",

        "SRC:MFC",
        "TIME:16:46",
        "CALL:HEART PROBLEMS - ALS",
        "ADDR:50 FOUNDRY WY",
        "CITY:EAST WHITELAND TWP",
        "PLACE:NEXT TO PU",
        "X:WYETH DR & CHESTER VALLEY",
        "BOX:0566",
        "INFO:33/F - FEELING FAINT - RAPID HEART BEAT");

    doTest("T34",
        "(MFC) MALF ** 21:08 ** FALLS - BLS / LIFT ASSIST * ** 324 LANCASTER AV ,54 ** ROOM 128-S ** WOODVIEW WY & E LANCASTER ** 0483 ** WILLIS **  ** ",
        "SRC:MFC",
        "TIME:21:08",
        "CALL:FALLS - BLS / LIFT ASSIST",
        "ADDR:324 LANCASTER AV",
        "MADDR:324 LANCASTER AVE",
        "APT:128-S",
        "CITY:WILLISTOWN TWP",
        "X:WOODVIEW WY & E LANCASTER",
        "BOX:0483");

    doTest("T35",
        "(MFC) NWTF ** 22:58 ** INJURED PERSON - BLS * ** GOSHEN RD/MARLBOROUGH RD ,54    (V) ** - **  ** 0041 **  **  ** ",
        "SRC:MFC",
        "TIME:22:58",
        "CALL:INJURED PERSON - BLS",
        "ADDR:GOSHEN RD & MARLBOROUGH RD",
        "BOX:0041");

    doTest("T36",
        "(MFC) MALF ** 03:15 ** ALARM - FIRE * ** 414 PAOLI PK ,54 ** BUS--484-5 ** FOX RIDGE DR & HOSPITAL D ** 0484 ** WILLIS ** AFA, ZONE 1 GENERAL, ATN\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:03:15",
        "CALL:ALARM - FIRE",
        "ADDR:414 PAOLI PK",
        "MADDR:414 PAOLI PIKE",
        "CITY:WILLISTOWN TWP",
        "PLACE:BUS--484-5",
        "X:FOX RIDGE DR & HOSPITAL D",
        "BOX:0484",
        "INFO:AFA, ZONE 1 GENERAL, ATN");

    doTest("T37",
        "(MFC) MALF ** 05:11 ** RESPIRATORY DIFFICULTY - ALS * ** 414 PAOLI PK ,54 ** MAPLE UNIT ** FOX RIDGE DR & HOSPITAL D ** 0484 ** WILLIS ** VOMITING, 45/M\n\n" +
        "DETAILS TO FOLLOW\n\n" +
        " ** ",

        "SRC:MFC",
        "TIME:05:11",
        "CALL:RESPIRATORY DIFFICULTY - ALS",
        "ADDR:414 PAOLI PK",
        "MADDR:414 PAOLI PIKE",
        "CITY:WILLISTOWN TWP",
        "PLACE:MAPLE UNIT",
        "X:FOX RIDGE DR & HOSPITAL D",
        "BOX:0484",
        "INFO:VOMITING, 45/M");

    doTest("T38",
        "(MFC) EWHF ** 06:30 ** FALLS - BLS / LIFT ASSIST * ** 62 SPRING RD ,42 ** VIRGINIA H ** QUAKER LA & WATCH HILL LA ** 0504 ** EWHITE ** PENDANT, MADE VOICE CONTACT--UNK AGE/F, FELL A\n\n" +
        "ND ** ",

        "SRC:MFC",
        "TIME:06:30",
        "CALL:FALLS - BLS / LIFT ASSIST",
        "ADDR:62 SPRING RD",
        "CITY:EAST WHITELAND TWP",
        "PLACE:VIRGINIA H",
        "X:QUAKER LA & WATCH HILL LA",
        "BOX:0504",
        "INFO:PENDANT, MADE VOICE CONTACT--UNK AGE/F, FELL A");

    doTest("T39",
        "(MFC) EWHF ** 12:09 ** POLES,WIRES,TRANSFORMER FIRE * ** MOORES RD/RT 401 ,42    (V) ** - **  ** 0509 **  ** WIRES HANGING DOWN LOW ON ROAD, SPARKING\n\n" +
        "DETAILS ** ",

        "SRC:MFC",
        "TIME:12:09",
        "CALL:POLES,WIRES,TRANSFORMER FIRE",
        "ADDR:MOORES RD & RT 401",
        "BOX:0509",
        "INFO:WIRES HANGING DOWN LOW ON ROAD, SPARKING");

    doTest("T40",
        "(MFC) EWHF ** 13:12 ** ABDOMINAL PAIN - ALS * ** 9 LEE BL ,42 ** ESSEX GRAI ** SIDLEY RD & SPRING MILL D ** 0508 ** EWHITE ** 50S/M - SOB AND ABDOMINAL/BACK PAIN\n\n" +
        "DETAILS TO FO ** ",

        "SRC:MFC",
        "TIME:13:12",
        "CALL:ABDOMINAL PAIN - ALS",
        "ADDR:9 LEE BL",
        "CITY:EAST WHITELAND TWP",
        "PLACE:ESSEX GRAI",
        "X:SIDLEY RD & SPRING MILL D",
        "BOX:0508",
        "INFO:50S/M - SOB AND ABDOMINAL/BACK PAIN");

    doTest("T41",
        "(MFC) PLIF ** 14:40 ** ALLERGC/MED REACTION - ALS * ** 1000 CEDAR HOLLOW RD ,43 ** RADIATE ME ** RT 202 & W SWEDESFORD RD ** 0301 ** TREDYF ** 40/F -- TOUNGE IS SWELLING -- UNK WHAT IS CAUS\n\n" +
        "IN ** ",

        "SRC:MFC",
        "TIME:14:40",
        "CALL:ALLERGC/MED REACTION - ALS",
        "ADDR:1000 CEDAR HOLLOW RD",
        "CITY:TREDYFFRIN TWP",
        "PLACE:RADIATE ME",
        "X:RT 202 & W SWEDESFORD RD",
        "BOX:0301",
        "INFO:40/F -- TOUNGE IS SWELLING -- UNK WHAT IS CAUS");

  }
  
  public static void main(String[] args) {
    new PAChesterCountyD5ParserTest().generateTests("T1");
  }
}
