package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCDavieCountyParserTest extends BaseParserTest {
  
  public NCDavieCountyParserTest() {
    setParser(new NCDavieCountyParser(), "DAVIE COUNTY", "NC");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "911:Call #110619-2932* Address:866 ANGELL RD* * * City:MOCKSVILLE* * Type:HC* HAZARDOUS CONDITION* HILL JOEL* PH#:336-940-2303* Units:17* IRA:* Medical: No* Haza.",
        "ID:110619-2932",
        "ADDR:866 ANGELL RD",
        "CITY:MOCKSVILLE",
        "CALL:HC - HAZARDOUS CONDITION",
        "NAME:HILL JOEL",
        "PHONE:336-940-2303",
        "UNIT:17",
        "INFO:Medical: No / Haza.");

    doTest("T2",
        "911:Call #110622-3347* Address:2388 LIBERTY CHURCH RD* * * City:MOCKSVILLE* * Type:19D4* HEART PROBLEMS* HALL GENE* PH#:336-492-5114* Units:17,34,ST4,YC24* IRA:*",
        "ID:110622-3347",
        "ADDR:2388 LIBERTY CHURCH RD",
        "CITY:MOCKSVILLE",
        "CALL:19D4 - HEART PROBLEMS",
        "NAME:HALL GENE",
        "PHONE:336-492-5114",
        "UNIT:17,34,ST4,YC24");

    doTest("T3",
        "911:Call #110622-3355* Address:389 LIBERTY CHURCH RD* * * City:MOCKSVILLE* * Type:MED* MEDICAL CALL* CULLER C O* PH#:336-492-7249* Units:17* IRA:* Medical: No* H",
        "ID:110622-3355",
        "ADDR:389 LIBERTY CHURCH RD",
        "CITY:MOCKSVILLE",
        "CALL:MED - MEDICAL CALL",
        "NAME:CULLER C O",
        "PHONE:336-492-7249",
        "UNIT:17",
        "INFO:Medical: No / H");

    doTest("T4",
        "911:Call #110623-3420* Address:261 COOPER CREEK DR* * * City:MOCKSVILLE* Geo Comment: BUSINESSES IN CITY LIMITS NBH: OFF 1734 US HWY 601 N Landmark Comment: KNOX",
        "ID:110623-3420",
        "ADDR:261 COOPER CREEK DR",
        "CITY:MOCKSVILLE",
        "INFO:Geo Comment: BUSINESSES IN CITY LIMITS NBH: OFF 1734 US HWY 601 N Landmark Comment: KNOX");

    doTest("T5",
        "911:Call #110624-3510* Address:3868 US HWY 601 N* * * City:MOCKSVILLE* * Type:YEL* CARDIAC PROBLEM* HOHFF, EARL V* PH#:336-492-3017* Units:17* IRA:* Medical: No*",
        "ID:110624-3510",
        "ADDR:3868 US HWY 601 N",
        "MADDR:3868 US 601 N",
        "CITY:MOCKSVILLE",
        "CALL:YEL - CARDIAC PROBLEM",
        "NAME:HOHFF, EARL V",
        "PHONE:336-492-3017",
        "UNIT:17",
        "INFO:Medical: No");

    doTest("T6",
        "911:Call #110627-3974* Address:NC HWY 801 N // BONKIN LAKE RD* * * City:MOCKSVILLE* * Type:GWB* GRASS/WOODS/BRUSH FIRE* PAUL TONY* PH#:336-575-4524* Units:17,23*",
        "ID:110627-3974",
        "ADDR:NC HWY 801 N & BONKIN LAKE RD",
        "MADDR:NC 801 N & BONKIN LAKE RD",
        "CITY:MOCKSVILLE",
        "CALL:GWB - GRASS/WOODS/BRUSH FIRE",
        "NAME:PAUL TONY",
        "PHONE:336-575-4524",
        "UNIT:17,23");

    doTest("T7",
        "911:Call #110630-4406* Address:284 BRANGUS WAY* * * City:MOCKSVILLE* NBH: OFF 2386 CANA RD* Type:VF* VEHICLE FIRE* MEADER CORTLAND J* PH#:336-940-2666* Units:17",
        "ID:110630-4406",
        "ADDR:284 BRANGUS WAY",
        "CITY:MOCKSVILLE",
        "INFO:NBH: OFF 2386 CANA RD",
        "CALL:VF - VEHICLE FIRE",
        "NAME:MEADER CORTLAND J",
        "PHONE:336-940-2666",
        "UNIT:17");

    doTest("T8",
        "911:Call #110628-4171* Address:700 RICHIE RD* * * City:MOCKSVILLE* NBH: FROM 444 EATONS CHURCH RD TO 3558 US HWY 601 N NBH: I40 TO FARMSTEAD LN* Type:HC* HAZARDO",
        "ID:110628-4171",
        "ADDR:700 RICHIE RD",
        "CITY:MOCKSVILLE",
        "INFO:NBH: FROM 444 EATONS CHURCH RD TO 3558 US HWY 601 N NBH: I40 TO FARMSTEAD LN",
        "CALL:HC - HAZARDO");

    doTest("T9",
        "911@[70.60.255.70] 911:Call #110713-6266* Address:154 CRESTVIEW DR* * * City:MOCKSVILLE* NBH: OFF 499 EAST LAKE DR* Type:26A2-11* SICK PERSON (SPECIFIC DIAGNOSIS)* linda packett* P",
        "ID:110713-6266",
        "ADDR:154 CRESTVIEW DR",
        "CITY:MOCKSVILLE",
        "INFO:NBH: OFF 499 EAST LAKE DR",
        "CALL:26A2-11 - SICK PERSON (SPECIFIC DIAGNOSIS)",
        "NAME:linda packett");

    doTest("T10",
        "911:Call #111107-2492* Address:100 SUN BURST LN* * * City:MOCKSVILLE* NBH: OFF 1627 JUNCTION RD NEAR NOLLEY RD* Type:HC* HAZARDOUS CONDITION* *",
        "ID:111107-2492",
        "ADDR:100 SUN BURST LN",
        "CITY:MOCKSVILLE",
        "INFO:NBH: OFF 1627 JUNCTION RD NEAR NOLLEY RD",
        "CALL:HC - HAZARDOUS CONDITION");

    doTest("T11",
        "911:Call #111108-2718* Address:255 NEELY RD* * * City:COOLEEMEE* * Type:SF* STRUCTURE FIRE* FOWLER ANSLO* PH#:336-284-4275* Units:14* IRA:* Me",
        "ID:111108-2718",
        "ADDR:255 NEELY RD",
        "CITY:COOLEEMEE",
        "INFO:Me",
        "CALL:SF - STRUCTURE FIRE",
        "NAME:FOWLER ANSLO",
        "PHONE:336-284-4275",
        "UNIT:14");

    doTest("T12",
        "911:Call #120201-4100* Address:1407 JUNCTION RD* * * City:MOCKSVILLE* * Type:50PD* ACCIDENT/DAMAGE* INNES* PH#:704-640-5463* Units:14* IRA:*",
        "ID:120201-4100",
        "ADDR:1407 JUNCTION RD",
        "CITY:MOCKSVILLE",
        "CALL:50PD - ACCIDENT/DAMAGE",
        "NAME:INNES",
        "PHONE:704-640-5463",
        "UNIT:14");
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "911:Call #120223-6774* Address:277 OLD TOWNE DR* * * City:ADVANCE* Geo Comment: KINDERTON DEV NBH: OFF 160 BLOCK YADKIN VALLEY RD* Type:MED* MEDICAL CALL* GAIL GODWIN* PH#:336-909-2667* Units:24* IRA:* Medical: No* Hazards: No* NARR:02/23/2012 01:51:24 : pos2 : MCROWE Cross streets: BROOKSTONE DR//DEADEND Geo Comment: KINDERTON DEV NBH: OFF 160 BLOCK YADKIN VALLEY RD*",
        "ID:120223-6774",
        "ADDR:277 OLD TOWNE DR",
        "CITY:ADVANCE",
        "INFO:Geo Comment: KINDERTON DEV NBH: OFF 160 BLOCK YADKIN VALLEY RD / Medical: No / Hazards: No / KINDERTON DEV / NBH: OFF 160 BLOCK YADKIN VALLEY RD",
        "CALL:MED - MEDICAL CALL",
        "NAME:GAIL GODWIN",
        "PHONE:336-909-2667",
        "UNIT:24",
        "DATE:02/23/2012",
        "TIME:01:51:24",
        "CH:pos2",
        "X:BROOKSTONE DR / DEADEND");

    doTest("T2",
        "[] 911:Call #120422-4536* Address:162 TINSLEY DR* * * City:MOCKSVILLE* * Type:MED* MEDICAL CALL* IREDELL* PH#:336- -* Units:18* IRA:* Medical: No* Hazards: No* NARR:04/22/2012 23:10:06 : pos2 : RPIERCE OFF CARTNER RD NO RADIO TRAFFIC FROM IREDELL*\n",
        "ID:120422-4536",
        "ADDR:162 TINSLEY DR",  // Not mapping - Google says this is in Farmington
        "CITY:MOCKSVILLE",
        "INFO:Medical: No / Hazards: No / OFF CARTNER RD NO RADIO TRAFFIC FROM IREDELL",
        "CALL:MED - MEDICAL CALL",
        "NAME:IREDELL",
        "PHONE:336- -",
        "UNIT:18",
        "DATE:04/22/2012",
        "TIME:23:10:06",
        "CH:pos2");

    doTest("T3",
        "[] 911:Call #120423-4601* Address:127 FLORA LN* * * City:MOCKSVILLE* * Type:SF* STRUCTURE FIRE* IREDELL* PH#:336- -* Units:18* IRA:* Medical: No* Hazards: No* NARR:04/23/2012 13:40:34 : pos2 : jbyerly COME IN OFF OF RIMROCK, MT BETHEL CLOSED AT BRIDGE*\n",
        "ID:120423-4601",
        "ADDR:127 FLORA LN",  // Google puts this in Harmony in Iredell County
        "CITY:MOCKSVILLE",
        "INFO:Medical: No / Hazards: No / COME IN OFF OF RIMROCK, MT BETHEL CLOSED AT BRIDGE",
        "CALL:SF - STRUCTURE FIRE",
        "NAME:IREDELL",
        "PHONE:336- -",
        "UNIT:18",
        "DATE:04/23/2012",
        "TIME:13:40:34",
        "CH:pos2");

    doTest("T4",
        "[] 911:Call #120426-4952* Address:1342 RIDGE RD* * * City:MOCKSVILLE* * Type:MED* MEDICAL CALL* LACKEY, BEATRICE* PH#:336-492-6052* Units:18* IRA:* Medical: No* Hazards: No* NARR:04/26/2012 05:04:19 : pos2 : GGUSA Cross streets: SMITH RD//VILLAGE RD female on oxygen ... high temp ... resp distress*\n",
        "ID:120426-4952",
        "ADDR:1342 RIDGE RD",
        "CITY:MOCKSVILLE",
        "INFO:Medical: No / Hazards: No / female on oxygen high temp resp distress",
        "CALL:MED - MEDICAL CALL",
        "NAME:LACKEY, BEATRICE",
        "PHONE:336-492-6052",
        "UNIT:18",
        "DATE:04/26/2012",
        "TIME:05:04:19",
        "CH:pos2",
        "X:SMITH RD / VILLAGE RD");

    doTest("T5",
        "[] 911:Call #120427-5175* Address:1707 DAVIE ACADEMY RD* * * City:MOCKSVILLE* * Type:MED* MEDICAL CALL* CARTNER JOHN CLIFFORD* PH#:336-492-6447* Units:18* IRA:* Medical: No* Hazards: No* NARR:04/27/2012 17:17:57 : pos2 : CDWIGGINS Cross streets: SHADY KNOLL LN//ST MATTHEWS RD*\n",
        "ID:120427-5175",
        "ADDR:1707 DAVIE ACADEMY RD",
        "CITY:MOCKSVILLE",
        "INFO:Medical: No / Hazards: No",
        "CALL:MED - MEDICAL CALL",
        "NAME:CARTNER JOHN CLIFFORD",
        "PHONE:336-492-6447",
        "UNIT:18",
        "DATE:04/27/2012",
        "TIME:17:17:57",
        "CH:pos2",
        "X:SHADY KNOLL LN / ST MATTHEWS RD");

    doTest("T6",
        "[] 911:Call #120427-5202* Address:171 LOGAN WAY RD* * * City:STATESVILLE* * Type:HEM* HEMORHAGE* * PH#:336- -* Units:18* IRA:* Medical: No* Hazards: No* NARR:04/27/2012 20:51:58 : pos2 : SPHILLIPS *\n",
        "ID:120427-5202",
        "ADDR:171 LOGAN WAY RD",   // Google can't find
        "CITY:STATESVILLE",
        "INFO:Medical: No / Hazards: No",
        "CALL:HEM - HEMORHAGE",
        "PHONE:336- -",
        "UNIT:18",
        "DATE:04/27/2012",
        "TIME:20:51:58",
        "CH:pos2");

    doTest("T7",
        "[] 911:Call #120428-5297* Address:336 WHISPERING OAKS LN* * * City:MOCKSVILLE* NBH: off 200 blk oak meadow ln off 550 blk ratledge rd* Type:FA* FIRE ALARM* TAMMY* PH#:336-766-7698* Units:14,18,RC73* IRA:* Medical: No* Hazards: No* NARR:04/28/2012 13:09:01 : pos2 : JALLGOOD Cross streets: OAK MEADOW LN//DEADEND NBH: off 200 blk oak meadow ln off 550 blk ratledge rd STORAGE ROOM AGE LEE STALLARD*\n",
        "ID:120428-5297",
        "ADDR:336 WHISPERING OAKS LN",
        "CITY:MOCKSVILLE",
        "INFO:NBH: off 200 blk oak meadow ln off 550 blk ratledge rd / Medical: No / Hazards: No / NBH: off 200 blk oak meadow ln off 550 blk ratledge rd STORAGE ROOM AGE LEE STALLARD",
        "CALL:FA - FIRE ALARM",
        "NAME:TAMMY",
        "PHONE:336-766-7698",
        "UNIT:14,18,RC73",
        "DATE:04/28/2012",
        "TIME:13:09:01",
        "CH:pos2",
        "X:OAK MEADOW LN / DEADEND");

    doTest("T8",
        "[] 911:Call #120429-5402* Address:161 I40 WB* * * City:MOCKSVILLE* * Type:DB* DIABETIC CRISIS* IREDELL* PH#:336- -* Units:18* IRA:* Medical: No* Hazards: No* NARR:04/29/2012 15:41:23 : pos2 : JALLGOOD *\n",
        "ID:120429-5402",
        "ADDR:161 I40 WB",
        "MADDR:161 I 40",
        "CITY:MOCKSVILLE",
        "INFO:Medical: No / Hazards: No",
        "CALL:DB - DIABETIC CRISIS",
        "NAME:IREDELL",
        "PHONE:336- -",
        "UNIT:18",
        "DATE:04/29/2012",
        "TIME:15:41:23",
        "CH:pos2");

    doTest("T9",
        "[] 911:Call #120501-5661* Address:1819 RIDGE RD* * * City:MOCKSVILLE* NBH: OFF 4408 US HWY 64 W* Type:STBY* STAND BY* * PH#:336-492-7236* Units:18* IRA:* Medical: No* Hazards: No* NARR:05/01/2012 12:33:35 : pos1 : STHOMPKINS Cross streets: MATTIE LN//US HWY 64 W Landmark: COUNTY LINE FIRE DEPT NBH: OFF 4408 US HWY 64 W*\n",
        "ID:120501-5661",
        "ADDR:1819 RIDGE RD",
        "CITY:MOCKSVILLE",
        "INFO:NBH: OFF 4408 US HWY 64 W / Medical: No / Hazards: No / NBH: OFF 4408 US HWY 64 W",
        "CALL:STBY - STAND BY",
        "PHONE:336-492-7236",
        "UNIT:18",
        "DATE:05/01/2012",
        "TIME:12:33:35",
        "CH:pos1",
        "X:MATTIE LN / US HWY 64 W",
        "PLACE:COUNTY LINE FIRE DEPT");

    doTest("T10",
        "[] 911:Call #120503-5901* Address:149 MOZIER HILL LN* * * City:HARMONY* * Type:SIC* SICK CALL* IRC* PH#:336- -* Units:18* IRA:* Medical: No* Hazards: No* NARR:05/03/2012 07:40:48 : pos2 : AHANES IREDELL CANCELLED--SUBJECT POV`ING 05/03/2012 07:40:32 : pos2 : AHANES *\n",
        "ID:120503-5901",
        "ADDR:149 MOZIER HILL LN", // Google can't find anywhere
        "CITY:HARMONY",
        "INFO:Medical: No / Hazards: No / IREDELL CANCELLED--SUBJECT POV`ING",
        "CALL:SIC - SICK CALL",
        "NAME:IRC",
        "PHONE:336- -",
        "UNIT:18",
        "DATE:05/03/2012",
        "TIME:07:40:48",
        "CH:pos2");

    doTest("T11",
        "[] 911:Call #120503-5933* Address:162 I40* * * City:MOCKSVILLE* * Type:50PI* ACCIDENT/INJURY* * PH#:* Units:18* IRA:* Medical: No* Hazards: No* NARR:05/03/2012 11:50:57 : pos4 : JMARTIN TRACTOR TRAILER VS TRUCK PT UNCI*\n",
        "ID:120503-5933",
        "ADDR:162 I40",
        "MADDR:162 I 40",
        "CITY:MOCKSVILLE",
        "INFO:Medical: No / Hazards: No / TRACTOR TRAILER VS TRUCK PT UNCI",
        "CALL:50PI - ACCIDENT/INJURY",
        "UNIT:18",
        "DATE:05/03/2012",
        "TIME:11:50:57",
        "CH:pos4");

    doTest("T12",
        "[] 911:Call #120506-6432* Address:168 I40 EB* * * City:MOCKSVILLE* * Type:50PI* ACCIDENT/INJURY* VERIZON* PH#:336-451-5508* Units:18* IRA:* Medical: No* Hazards: No* NARR:05/06/2012 19:14:03 : pos2 : ABURTON Cross streets: IREDELL COUNTY LINE//64 WEST AT CENTER Cross streets: DAVIE FARMS TR//WOOD VALE DR 2 VEHICLE CAR OVERTURNED*\n",
        "ID:120506-6432",
        "ADDR:168 I40 EB",
        "MADDR:168 I 40",
        "CITY:MOCKSVILLE",
        "INFO:Medical: No / Hazards: No / 2 VEHICLE CAR OVERTURNED",
        "CALL:50PI - ACCIDENT/INJURY",
        "NAME:VERIZON",
        "PHONE:336-451-5508",
        "UNIT:18",
        "DATE:05/06/2012",
        "TIME:19:14:03",
        "CH:pos2",
        "X:IREDELL COUNTY LINE / 64 WEST AT CENTER");

    doTest("T13",
        "[] 911:Call #120506-6457* Address:164 I40 WB* * * City:MOCKSVILLE* * Type:50PI* ACCIDENT/INJURY* VERIZON* PH#:828-545-9082* Units:13,18,31,ST4* IRA:* Medical: No* Hazards: No* NARR:05/06/2012 22:15:51 : pos1 : RPIERCE Cross streets: IREDELL COUNTY LINE//64 W AT CENTER Cross streets: DAVIE FARMS TR//WOOD VALE DR SMALL HONDA CAR DROVE UP EMBANKMENT,*\n",
        "ID:120506-6457",
        "ADDR:164 I40 WB",
        "MADDR:164 I 40",
        "CITY:MOCKSVILLE",
        "INFO:Medical: No / Hazards: No / SMALL HONDA CAR DROVE UP EMBANKMENT,",
        "CALL:50PI - ACCIDENT/INJURY",
        "NAME:VERIZON",
        "PHONE:828-545-9082",
        "UNIT:13,18,31,ST4",
        "DATE:05/06/2012",
        "TIME:22:15:51",
        "CH:pos1",
        "X:IREDELL COUNTY LINE / 64 W AT CENTER");

    doTest("T14",
        "[] 911:Call #120510-6909* Address:1969 MOCKSVILLE HWY* * * City:MOCKSVILLE* * Type:FA* FIRE ALARM* iredell* PH#:336- -* Units:18* IRA:* Medical: No* Hazards: No* NARR:05/10/2012 10:51:13 : pos1 : STHOMPKINS co line.. cool springs school..*\n",
        "ID:120510-6909",
        "ADDR:1969 MOCKSVILLE HWY",  // Google finds this in Cleveland
        "CITY:MOCKSVILLE",
        "INFO:Medical: No / Hazards: No / co line.. cool springs school..",
        "CALL:FA - FIRE ALARM",
        "NAME:iredell",
        "PHONE:336- -",
        "UNIT:18",
        "DATE:05/10/2012",
        "TIME:10:51:13",
        "CH:pos1");

    doTest("T15",
        "[] 911:Call #120516-7704* Address:290 FRED LANIER RD* * * City:MOCKSVILLE* NBH: OFF 2876 US HWY 64 W* Type:UTIL* UTILITY PROBLEM* RENEE SMITH* PH#:704-235-8044* Units:13,18* IRA:* Medical: No* Hazards: No* NARR:05/16/2012 09:38:52 : pos1 : SFRYE Cross streets: US HWY 64 W//CASTLE LN NBH: OFF 2876 US HWY 64 W TREE ON THE UTILITY LINES FG-1 ENERGRY UNITED*\n",
        "ID:120516-7704",
        "ADDR:290 FRED LANIER RD",
        "CITY:MOCKSVILLE",
        "INFO:NBH: OFF 2876 US HWY 64 W / Medical: No / Hazards: No / NBH: OFF 2876 US HWY 64 W TREE ON THE UTILITY LINES FG-1 ENERGRY UNITED",
        "CALL:UTIL - UTILITY PROBLEM",
        "NAME:RENEE SMITH",
        "PHONE:704-235-8044",
        "UNIT:13,18",
        "DATE:05/16/2012",
        "TIME:09:38:52",
        "CH:pos1",
        "X:US HWY 64 W / CASTLE LN");
  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "[] 911:Call #120731-9241* Address:2229 NC HWY 801 S* * * City:ADVANCE* * Type:FA* FIRE ALARM* KANDICE BOGER* PH#:336-940-6957* Units:12* IRA:* Medical: No* Hazards: No* NARR:07/31/2012 19:49:01 : pos1 : MCROWE Cross streets: SAM COPE RD//DEER HOLLOW LN*\r\n\n",
        "ID:120731-9241",
        "ADDR:2229 NC HWY 801 S",
        "MADDR:2229 NC 801 S",
        "CITY:ADVANCE",
        "INFO:Medical: No / Hazards: No",
        "CALL:FA - FIRE ALARM",
        "NAME:KANDICE BOGER",
        "PHONE:336-940-6957",
        "UNIT:12",
        "DATE:07/31/2012",
        "TIME:19:49:01",
        "CH:pos1",
        "X:SAM COPE RD / DEER HOLLOW LN");

    doTest("T2",
        "[] 911:Call #120802-9449* Address:645 NC HWY 801 S* * * City:ADVANCE* * Type:50PI* ACCIDENT/INJURY* REYNOLDS WAYNE* PH#:336-998-2845* Units:12* IRA:* Medical: No* Hazards: No* NARR:08/02/2012 09:07:33 : pos2 : STHOMPKINS Cross streets: BOWDEN RD//UNDERPASS RD 08/02/2012 09:07:04 : pos2 : STHOMPKINS 3 cars*\r\n\n",
        "ID:120802-9449",
        "ADDR:645 NC HWY 801 S",
        "MADDR:645 NC 801 S",
        "CITY:ADVANCE",
        "INFO:Medical: No / Hazards: No / 3 cars",
        "CALL:50PI - ACCIDENT/INJURY",
        "NAME:REYNOLDS WAYNE",
        "PHONE:336-998-2845",
        "UNIT:12",
        "DATE:08/02/2012",
        "TIME:09:07:33",
        "CH:pos2",
        "X:BOWDEN RD / UNDERPASS RD");

    doTest("T3",
        "[] 911:Call #120802-9475* Address:142 NC HWY 801 N* * * City:ADVANCE* * Type:SF* STRUCTURE FIRE* BARRY* PH#:336-817-2358* Units:12,24* IRA:* Medical: No* Hazards: No* NARR:08/02/2012 11:40:07 : pos4 : ABURTON Cross streets: US HWY 158//I40 EB 08/02/2012 11:39:55 : pos4 : ABURTON Cross streets: PEACHTREE LN//CARTER RD Cross streets: US HWY 158//DEADEND NBH: OFF 4900 BLOCK US HWY 158 GEN AND BUILDING*\r\n\n",
        "ID:120802-9475",
        "ADDR:142 NC HWY 801 N",
        "MADDR:142 NC 801 N",
        "CITY:ADVANCE",
        "INFO:Medical: No / Hazards: No / NBH: OFF 4900 BLOCK US HWY 158 GEN AND BUILDING",
        "CALL:SF - STRUCTURE FIRE",
        "NAME:BARRY",
        "PHONE:336-817-2358",
        "UNIT:12,24",
        "DATE:08/02/2012",
        "TIME:11:40:07",
        "CH:pos4",
        "X:US HWY 158 / I-40 EB");

  }
  

  public static void main(String[] args) {
    new NCDavieCountyParserTest().generateTests("T1");
  }
}
