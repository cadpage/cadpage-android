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
        "CITY:MOCKSVILLE",
        "CALL:YEL - CARDIAC PROBLEM",
        "NAME:HOHFF, EARL V",
        "PHONE:336-492-3017",
        "UNIT:17",
        "INFO:Medical: No");

    doTest("T6",
        "911:Call #110627-3974* Address:NC HWY 801 N // BONKIN LAKE RD* * * City:MOCKSVILLE* * Type:GWB* GRASS/WOODS/BRUSH FIRE* PAUL TONY* PH#:336-575-4524* Units:17,23*",
        "ID:110627-3974",
        "ADDR:NC HWY 801 N &  & BONKIN LAKE RD",
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
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "911@[70.60.255.70] 911:Call #110713-6266* Address:154 CRESTVIEW DR* * * City:MOCKSVILLE* NBH: OFF 499 EAST LAKE DR* Type:26A2-11* SICK PERSON (SPECIFIC DIAGNOSIS)* linda packett* P",
        "ID:110713-6266",
        "ADDR:154 CRESTVIEW DR",
        "CITY:MOCKSVILLE",
        "INFO:NBH: OFF 499 EAST LAKE DR",
        "CALL:26A2-11 - SICK PERSON (SPECIFIC DIAGNOSIS)",
        "NAME:linda packett");

  }
  

  public static void main(String[] args) {
    new NCDavieCountyParserTest().generateTests("T1");
  }
}
