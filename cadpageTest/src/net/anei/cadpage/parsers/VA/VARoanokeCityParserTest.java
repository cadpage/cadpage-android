package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Roanoke City, VA
Contact: Sandy Webb <sandywebb@gmail.com>
Sender: e911@roanokeva.gov

Working Fire at 1401 ORANGE AVE NW
Working Fire at 2802 COLONIAL AVE SWAPT 16
Working Fire at 5046 WILLIAMSON RD NW
Roanoke (city/county?), VA (alternate)

Contact: Zach Beckner <zach.beckner@gmail.com>
Sender: e911@roanokeva.gov

FIRE 1111 ORANGE AVE NW            CMT: APT IS ON FIRE// LOC INFO REVIEWED: BL
GSWI 101 ELM AVE SE                CMT: MALE SUBJ STATES THAT HE HAS BEEN SHOT Original Location : CHRV
FIRE 3447 HOLLINS RD NE            CMT: DOWN ON RAIL TRACKS - CALLER SEE FLAMES AND SMELLED SMOKE - PER CALLER IT IS CLOSE TO THE BUILDING - PER CALLER BUILDING
F-ALARM 35 CAMPBELL AVE SW            CMT: GEN SMOKE ALARM Original Location : HANCOCK BUILDING
F-ALARM 541 LUCK AVE SW               CMT: MANUAL ZONE 14 PULL ALARM Original Location : JEFFERSON CENTER
F-ALARM 320 HERSHBERGER RD NW         CMT: GENERAL FIRE   SEC CENTRAL 8002306975 Original Location : BUILD 2 SUITE B

*/

public class VARoanokeCityParserTest extends BaseParserTest {
  
  public VARoanokeCityParserTest() {
    setParser(new VARoanokeCityParser(), "ROANOKE CITY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Working Fire at 1401 ORANGE AVE NW",
        "CALL:Working Fire",
        "ADDR:1401 ORANGE AVE NW");

    doTest("T2",
        "Working Fire at 2802 COLONIAL AVE SWAPT 16",
        "CALL:Working Fire",
        "ADDR:2802 COLONIAL AVE SW",
        "APT:16");

    doTest("T3",
        "Working Fire at 5046 WILLIAMSON RD NW",
        "CALL:Working Fire",
        "ADDR:5046 WILLIAMSON RD NW");

  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "FIRE 1111 ORANGE AVE NW            CMT: APT IS ON FIRE// LOC INFO REVIEWED: BL",
        "CALL:STRUCTURE FIRE",
        "ADDR:1111 ORANGE AVE NW",
        "INFO:APT IS ON FIRE// LOC INFO REVIEWED: BL");

    doTest("T2",
        "GSWI 101 ELM AVE SE                CMT: MALE SUBJ STATES THAT HE HAS BEEN SHOT Original Location : CHRV",
        "CALL:GUN SHOT WOUND",
        "ADDR:101 ELM AVE SE",
        "INFO:MALE SUBJ STATES THAT HE HAS BEEN SHOT",
        "PLACE:CHRV");

    doTest("T3",
        "FIRE 3447 HOLLINS RD NE            CMT: DOWN ON RAIL TRACKS - CALLER SEE FLAMES AND SMELLED SMOKE - PER CALLER IT IS CLOSE TO THE BUILDING - PER CALLER BUILDING",
        "CALL:STRUCTURE FIRE",
        "ADDR:3447 HOLLINS RD NE",
        "INFO:DOWN ON RAIL TRACKS - CALLER SEE FLAMES AND SMELLED SMOKE - PER CALLER IT IS CLOSE TO THE BUILDING - PER CALLER BUILDING");

    doTest("T4",
        "F-ALARM 35 CAMPBELL AVE SW            CMT: GEN SMOKE ALARM Original Location : HANCOCK BUILDING",
        "CALL:FIRE ALARM",
        "ADDR:35 CAMPBELL AVE SW",
        "INFO:GEN SMOKE ALARM",
        "PLACE:HANCOCK BUILDING");

    doTest("T5",
        "F-ALARM 541 LUCK AVE SW               CMT: MANUAL ZONE 14 PULL ALARM Original Location : JEFFERSON CENTER",
        "CALL:FIRE ALARM",
        "ADDR:541 LUCK AVE SW",
        "INFO:MANUAL ZONE 14 PULL ALARM",
        "PLACE:JEFFERSON CENTER");

    doTest("T6",
        "F-ALARM 320 HERSHBERGER RD NW         CMT: GENERAL FIRE   SEC CENTRAL 8002306975 Original Location : BUILD 2 SUITE B",
        "CALL:FIRE ALARM",
        "ADDR:320 HERSHBERGER RD NW",
        "INFO:GENERAL FIRE   SEC CENTRAL 8002306975",
        "PLACE:BUILD 2 SUITE B");

  }
  
  public static void main(String[] args) {
    new VARoanokeCityParserTest().generateTests("T1");
  }
}