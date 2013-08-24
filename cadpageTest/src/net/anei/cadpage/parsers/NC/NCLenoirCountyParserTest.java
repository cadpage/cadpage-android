package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Lenoir County, NC
Contact: marcusmcbynum201178, May 23 (2 days ago)
Sender: 3364058803

Structure 69 - Structure Fire 4243 Falling Creek RD La Grange X: BAYBERRY ST PEPPERTREE LN
OUTSIDE FI 67 - OUTSIDE FIRE GRIFTON HUGO ROAD GRIFTON
ALARMS 52 - FIRE ALARMS 3800 HWY 58 NORTH KINSTON X: C F HARVEY PKWY JOHN MEWBORNE RD
TRAFFIC AC 29 - TRAFFIC / TRANSPORTATION ACCIDENTS FERREL RD & HWY 11 NORTH GRIFTON
ALARMS 104 - ALARMS 3401 FERRELL RD KINSTON X: TILGHMAN MILL RD HAMILTON RD

*/

public class NCLenoirCountyParserTest extends BaseParserTest {
  
  public NCLenoirCountyParserTest() {
    setParser(new NCLenoirCountyParser(), "LENOIR COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Structure 69 - Structure Fire 4243 Falling Creek RD La Grange X: BAYBERRY ST PEPPERTREE LN",
        "CODE:69",
        "CALL:Structure Fire",
        "ADDR:4243 Falling Creek RD",
        "CITY:La Grange",
        "X:BAYBERRY ST / PEPPERTREE LN");

    doTest("T2",
        "OUTSIDE FI 67 - OUTSIDE FIRE GRIFTON HUGO ROAD GRIFTON",
        "CODE:67",
        "CALL:OUTSIDE FIRE",
        "ADDR:GRIFTON HUGO ROAD",
        "CITY:GRIFTON");

    doTest("T3",
        "ALARMS 52 - FIRE ALARMS 3800 HWY 58 NORTH KINSTON X: C F HARVEY PKWY JOHN MEWBORNE RD",
        "CODE:52",
        "CALL:FIRE ALARMS",
        "ADDR:3800 HWY 58",
        "CITY:NORTH KINSTON",
        "X:C F HARVEY PKWY / JOHN MEWBORNE RD");

    doTest("T4",
        "TRAFFIC AC 29 - TRAFFIC / TRANSPORTATION ACCIDENTS FERREL RD & HWY 11 NORTH GRIFTON",
        "CODE:29",
        "CALL:TRAFFIC / TRANSPORTATION ACCIDENTS",
        "ADDR:FERREL RD & HWY 11",  // Not mapping
        "CITY:NORTH GRIFTON");

    doTest("T5",
        "ALARMS 104 - ALARMS 3401 FERRELL RD KINSTON X: TILGHMAN MILL RD HAMILTON RD",
        "CODE:104",
        "CALL:ALARMS",
        "ADDR:3401 FERRELL RD",
        "CITY:KINSTON",
        "X:TILGHMAN MILL RD / HAMILTON RD");
 
  }

  public static void main(String[] args) {
    new NCLenoirCountyParserTest().generateTests("T1");
  }
}
