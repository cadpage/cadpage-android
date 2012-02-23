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
        "INFO:Geo Comment: KINDERTON DEV NBH: OFF 160 BLOCK YADKIN VALLEY RD / Medical: No / Hazards: No / NARR:02/23/2012 01:51:24 : pos2 : MCROWE Cross streets: BROOKSTONE DR//DEADEND Geo Comment: KINDERTON DEV NBH: OFF 160 BLOCK YADKIN VALLEY RD",
        "CALL:MED - MEDICAL CALL",
        "NAME:GAIL GODWIN",
        "PHONE:336-909-2667",
        "UNIT:24");

  }
  

  public static void main(String[] args) {
    new NCDavieCountyParserTest().generateTests("T1");
  }
}
