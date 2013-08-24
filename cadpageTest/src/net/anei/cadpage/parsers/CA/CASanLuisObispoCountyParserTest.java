package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
San Luis Obispo County, CA
Contact: randall greenlee <randygreenlee@sbcglobal.net>
Sender: slucad@fire.ca.gov

RA: A-10; CAMP SLO @ =L(35.325251,-120.728507) #831 ,SLO_CO ;  ; FIRE, COMMERCIAL ALARM; ; Map: 633_B_5/633_B_5; Inc# 001150; B3416 E12 ECMC; GENERAL FIRE ALARM\n<a href="http://maps.google.com/?q=35.325251,-120.728507">Map</a>
RA: K10; CUESTA GRADE NB(TOP) @ =L(35.348795,-120.630637) ,SLO_CO ;  ; MED, WITH EXTRICATION; ; Map: 634/634; Inc# 001151; B3416 E12 ESMV R21 EMS1 ESLO; VEH VS SEMI <a href="http://maps.google.com/?q=35.348795,-120.630637">Map</a>
RA: R-5; 50 LADDY LN ,SLO_CO ;  DEAD-END; FIRE, STRUCTURE OTHER; ; Map: 493_F_2; Inc# 001097; E30 E36 B3409; NO TEXT <a href="http://maps.google.com/?q=35.703229,-120.694225">Map</a>
RA: T-10; 2435 RED FOX WAY ,SLO_CO ;  DEAD-END; PA, PUBLIC ASSIST; ; Map: 554; Inc# 001182; E30; LIFT ASSIST <a href="http://maps.google.com/?q=35.518815,-120.647585">Map</a>
RA: A-10; CAMP SLO @ =L(35.325251,-120.728507) #831 ,SLO_CO ;  ; FIRE, COMMERCIAL ALARM; ; Map: 633_B_5/633_B_5; Inc# 001150; B3416 E12 ECMC; GENERAL FIRE ALARM\r\n<a href="http://maps.google.com/?q=35.325251,-120.728507">Map</a>
Close: Inc# 001182; PA, PUBLIC ASSIST; 2435 RED FOX WAY ,SL; DSP: 2-14-15:36; ENR: 2-14-15:38; ONS: 2-14-15:54; AIQ: 2-14-15:59;
Close: Inc# 001097; FIRE, STRUCTURE OTHER; 50 LADDY LN ,SLO_CO ; DSP: 2-11-10:28; ENR: 2-11-10:31; ONS: 2-11-10:43; AIQ: 2-11-10:53;

 */


public class CASanLuisObispoCountyParserTest extends BaseParserTest {
  
  public CASanLuisObispoCountyParserTest() {
    setParser(new CASanLuisObispoCountyParser(), "SAN LUIS OBISPO COUNTY", "CA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "RA: A-10; CAMP SLO @ =L(35.325251,-120.728507) #831 ,SLO_CO ;  ; FIRE, COMMERCIAL ALARM; ; Map: 633_B_5/633_B_5; Inc# 001150; B3416 E12 ECMC; GENERAL FIRE ALARM\n" +
        "<a href=\"http://maps.google.com/?q=35.325251,-120.728507\">Map</a>",

        "PLACE:CAMP SLO",
        "ADDR:=L(35.325251,-120.728507)",
        "MADDR:+35.325251,-120.728507",
        "APT:831",
        "CALL:FIRE, COMMERCIAL ALARM",
        "MAP:633_B_5/633_B_5",
        "ID:001150",
        "UNIT:B3416 E12 ECMC",
        "INFO:GENERAL FIRE ALARM",
        "GPS:35.325251,-120.728507");

    doTest("T2",
        "RA: K10; CUESTA GRADE NB(TOP) @ =L(35.348795,-120.630637) ,SLO_CO ;  ; MED, WITH EXTRICATION; ; Map: 634/634; Inc# 001151; B3416 E12 ESMV R21 EMS1 ESLO; VEH VS SEMI <a href=\"http://maps.google.com/?q=35.348795,-120.630637\">Map</a>",
        "PLACE:CUESTA GRADE NB(TOP)",
        "ADDR:=L(35.348795,-120.630637)",
        "MADDR:+35.348795,-120.630637",
        "CALL:MED, WITH EXTRICATION",
        "MAP:634/634",
        "ID:001151",
        "UNIT:B3416 E12 ESMV R21 EMS1 ESLO",
        "INFO:VEH VS SEMI",
        "GPS:35.348795,-120.630637");

    doTest("T3",
        "RA: R-5; 50 LADDY LN ,SLO_CO ;  DEAD-END; FIRE, STRUCTURE OTHER; ; Map: 493_F_2; Inc# 001097; E30 E36 B3409; NO TEXT <a href=\"http://maps.google.com/?q=35.703229,-120.694225\">Map</a>",
        "ADDR:50 LADDY LN",
        "X:DEAD-END",
        "CALL:FIRE, STRUCTURE OTHER",
        "MAP:493_F_2",
        "ID:001097",
        "UNIT:E30 E36 B3409",
        "INFO:NO TEXT",
        "GPS:35.703229,-120.694225");

    doTest("T4",
        "RA: T-10; 2435 RED FOX WAY ,SLO_CO ;  DEAD-END; PA, PUBLIC ASSIST; ; Map: 554; Inc# 001182; E30; LIFT ASSIST <a href=\"http://maps.google.com/?q=35.518815,-120.647585\">Map</a>",
        "ADDR:2435 RED FOX WAY",
        "X:DEAD-END",
        "CALL:PA, PUBLIC ASSIST",
        "MAP:554",
        "ID:001182",
        "UNIT:E30",
        "INFO:LIFT ASSIST",
        "GPS:35.518815,-120.647585");

    doTest("T5",
        "RA: A-10; CAMP SLO @ =L(35.325251,-120.728507) #831 ,SLO_CO ;  ; FIRE, COMMERCIAL ALARM; ; Map: 633_B_5/633_B_5; Inc# 001150; B3416 E12 ECMC; GENERAL FIRE ALARM\r\n" +
        "<a href=\"http://maps.google.com/?q=35.325251,-120.728507\">Map</a>",

        "PLACE:CAMP SLO",
        "ADDR:=L(35.325251,-120.728507)",
        "MADDR:+35.325251,-120.728507",
        "APT:831",
        "CALL:FIRE, COMMERCIAL ALARM",
        "MAP:633_B_5/633_B_5",
        "ID:001150",
        "UNIT:B3416 E12 ECMC",
        "INFO:GENERAL FIRE ALARM",
        "GPS:35.325251,-120.728507");

    doTest("T6",
        "Close: Inc# 001182; PA, PUBLIC ASSIST; 2435 RED FOX WAY ,SL; DSP: 2-14-15:36; ENR: 2-14-15:38; ONS: 2-14-15:54; AIQ: 2-14-15:59;",
        "CALL:RUN REPORT",
        "PLACE:Close: Inc# 001182; PA, PUBLIC ASSIST; 2435 RED FOX WAY ,SL; DSP: 2-14-15:36; ENR: 2-14-15:38; ONS: 2-14-15:54; AIQ: 2-14-15:59;");

    doTest("T7",
        "Close: Inc# 001097; FIRE, STRUCTURE OTHER; 50 LADDY LN ,SLO_CO ; DSP: 2-11-10:28; ENR: 2-11-10:31; ONS: 2-11-10:43; AIQ: 2-11-10:53;",
        "CALL:RUN REPORT",
        "PLACE:Close: Inc# 001097; FIRE, STRUCTURE OTHER; 50 LADDY LN ,SLO_CO ; DSP: 2-11-10:28; ENR: 2-11-10:31; ONS: 2-11-10:43; AIQ: 2-11-10:53;");

  }
  
  public static void main(String[] args) {
    new CASanLuisObispoCountyParserTest().generateTests("T1");
  }
}