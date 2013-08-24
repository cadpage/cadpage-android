package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Midland County, MI
Contact: "Drake, Matthew" <mdrake@mobilemedical.org>
Sender: dispatch@midland911.org
Sender: @midland911.org 
(CAD Page for CFS M101512-29) BUS : \nADDX: W BURNS RD and N CASTOR RD APT: \nCODE: TRAFFIC ACCIDENT\nhttp://maps.google.com/maps?q=+43.72719%20-84.48703
(CAD Page for CFS M101412-41) BUS : \nADDX: 8405 S EBERHART APT: \nCODE: HOUSE FIRE\nhttp://maps.google.com/maps?q=+-1.00000%20--1.00000
(CAD Page for CFS M101312-31 <10131231>) BUS :\nWB US10 MM 102\nADDX: 102 WEST US HWY 10 APT: \nCODE: PDA - UNKNOWN\nhttp://maps.google.com/maps?q=+43.76840%20-84.58168
(CAD Page for CFS M101112-117 <101112117>) BUS : \nADDX: 6990 N COLEMAN RD APT: \nCODE: CHIMMNEY FIRE\nhttp://maps.google.com/maps?q=+43.81458%20-84.58607
(CAD Page for CFS M101212-56 <10121256>) BUS : \nADDX: 3095 W PERE MARQUETTE RD APT: \nCODE: STROKE\nhttp://maps.google.com/maps?q=+43.71114%20-84.49158
[CAD Page for CFS M042313-110]  BUS :\nADDX: LOOMIS/N OF US10  APT:\nCODE: GRASS FIRE\nhttp://maps.google.com/maps?q

Contact: Justin Hess <justinmhess@gmail.com>
Sender: colemanpager+bncBCC5PIXTUUJBBYHW72FQKGQETEAJPCY@midland911.org
(CAD Page for CFS M043013-43) BUS : \nADDX: 9180 e battle APT: \nCODE: FIRE OTHER\nhttp://maps.google.com/maps?q=+-1.

*/

public class MIMidlandCountyParserTest extends BaseParserTest {
  
  public MIMidlandCountyParserTest() {
	  setParser(new MIMidlandCountyParser(), "MIDLAND COUNTY", "MI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(CAD Page for CFS M101512-29) BUS : \n" +
        "ADDX: W BURNS RD and N CASTOR RD APT: \n" +
        "CODE: TRAFFIC ACCIDENT\n" +
        "http://maps.google.com/maps?q=+43.72719%20-84.48703",

        "ID:M101512-29",
        "ADDR:W BURNS RD and N CASTOR RD",
        "MADDR:W BURNS RD & N CASTOR RD",
        "CALL:TRAFFIC ACCIDENT",
        "GPS:+43.727190,-84.487030");

    doTest("T2",
        "(CAD Page for CFS M101412-41) BUS : \n" +
        "ADDX: 8405 S EBERHART APT: \n" +
        "CODE: HOUSE FIRE\n" +
        "http://maps.google.com/maps?q=+-1.00000%20--1.00000",

        "ID:M101412-41",
        "ADDR:8405 S EBERHART", // Not mapping
        "CALL:HOUSE FIRE");

    doTest("T3",
        "(CAD Page for CFS M101312-31 <10131231>) BUS :\n" +
        "WB US10 MM 102\n" +
        "ADDX: 102 WEST US HWY 10 APT: \n" +
        "CODE: PDA - UNKNOWN\n" +
        "http://maps.google.com/maps?q=+43.76840%20-84.58168",

        "ID:M101312-31",
        "ADDR:102 WEST US HWY 10",
        "MADDR:102 WEST US 10",
        "CALL:PDA - UNKNOWN",
        "GPS:+43.768400,-84.581680");

    doTest("T4",
        "(CAD Page for CFS M101112-117 <101112117>) BUS : \n" +
        "ADDX: 6990 N COLEMAN RD APT: \n" +
        "CODE: CHIMMNEY FIRE\n" +
        "http://maps.google.com/maps?q=+43.81458%20-84.58607",

        "ID:M101112-117",
        "ADDR:6990 N COLEMAN RD",
        "CALL:CHIMMNEY FIRE",
        "GPS:+43.814580,-84.586070");

    doTest("T5",
        "(CAD Page for CFS M101212-56 <10121256>) BUS : \n" +
        "ADDX: 3095 W PERE MARQUETTE RD APT: \n" +
        "CODE: STROKE\n" +
        "http://maps.google.com/maps?q=+43.71114%20-84.49158",

        "ID:M101212-56",
        "ADDR:3095 W PERE MARQUETTE RD",
        "CALL:STROKE",
        "GPS:+43.711140,-84.491580");

    doTest("T6",
        "[CAD Page for CFS M042313-110]  BUS :\nADDX: LOOMIS/N OF US10  APT:\nCODE: GRASS FIRE\nhttp://maps.google.com/maps?q",
        "ID:M042313-110",
        "ADDR:LOOMIS & N OF US10",
        "MADDR:LOOMIS & US 10",
        "CALL:GRASS FIRE");

  }
  
  @Test
  public void testJustinHess() {

    doTest("T1",
        "(CAD Page for CFS M043013-43) BUS : \nADDX: 9180 e battle APT: \nCODE: FIRE OTHER\nhttp://maps.google.com/maps?q=+-1.",
        "ID:M043013-43",
        "ADDR:9180 e battle",
        "CALL:FIRE OTHER");
   
  }
  
  public static void main(String[] args) {
    new MIMidlandCountyParserTest().generateTests("T1");
  }
}
