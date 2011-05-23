package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJSomersetCountyParserTest extends BaseParserTest {
  
  public NJSomersetCountyParserTest() {
    setParser(new NJSomersetCountyParser(), "SOMERSET COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[CAD]  [CAD] EFD-FD:11051201:05/12/2011 15:44:57:FIRE ALARM: FRANKLI-CARING HOUSE PROJECTS / 18 BLOOMFIELD AVE",
        "SRC:EFD-FD",
        "ID:11051201",
        "CALL:FIRE ALARM:",
        "CITY:FRANKLIN TWP",
        "PLACE:CARING HOUSE PROJECTS",
        "ADDR:18 BLOOMFIELD AVE");

    doTest("T2",
        "[CAD]  [CAD] EFD-FD:11051982:05/14/2011 11:51:28:FIRE ALARM:GENERAL: FRANKLI-HAMPTON INN / 255 DAVIDSON AVE",
        "SRC:EFD-FD",
        "ID:11051982",
        "CALL:FIRE ALARM:GENERAL:",
        "CITY:FRANKLIN TWP",
        "PLACE:HAMPTON INN",
        "ADDR:255 DAVIDSON AVE");

    doTest("T3",
        "[CAD]  [CAD] EFD-FD:11052014:05/14/2011 13:35:40:FIRE ALARM:ZONE-2ND FL REAR HALL SMK: FRANKLI-1165 HAMILTON ST",
        "SRC:EFD-FD",
        "ID:11052014",
        "CALL:FIRE ALARM:ZONE-2ND FL REAR HALL SMK:",
        "CITY:FRANKLIN TWP",
        "ADDR:1165 HAMILTON ST");

    doTest("T4",
        "[CAD]  [CAD] EFD-FD:11052016:05/14/2011 13:40:22:FIRE ALARM:GENERAL ALARM: FRANKLI-449 SKILLMANS LANE (ODD)",
        "SRC:EFD-FD",
        "ID:11052016",
        "CALL:FIRE ALARM:GENERAL ALARM:",
        "CITY:FRANKLIN TWP",
        "ADDR:449 SKILLMANS LANE",
        "INFO:ODD");

    doTest("T5",
        "[CAD]  [CAD] EFD-FD:11052407:05/15/2011 14:41:50:CO ALARM:NO ILLNESS: FRANKLI-25 MAYNARD ROAD",
        "SRC:EFD-FD",
        "ID:11052407",
        "CALL:CO ALARM:NO ILLNESS:",
        "CITY:FRANKLIN TWP",
        "ADDR:25 MAYNARD ROAD");

    doTest("T6",
        "[CAD]  [CAD] EFD-FD:11052545:05/15/2011 21:22:21:MVC: FRANKLI-CASTLETON AVE & EASTON AVE",
        "SRC:EFD-FD",
        "ID:11052545",
        "CALL:MVC:",
        "CITY:FRANKLIN TWP",
        "ADDR:CASTLETON AVE & EASTON AVE");

    doTest("T7",
        "[CAD]  [CAD] EFD-FD:11052638:05/16/2011 04:39:12:FIRE ALARM:Z-GENERAL: FRANKLI-THE DEN / 700 HAMILTON ST",
        "SRC:EFD-FD",
        "ID:11052638",
        "CALL:FIRE ALARM:Z-GENERAL:",
        "CITY:FRANKLIN TWP",
        "PLACE:THE DEN",
        "ADDR:700 HAMILTON ST");

    doTest("T8",
        "[CAD]  [CAD] EFD-FD:11053024:05/16/2011 19:33:38:STRUCTURE FIRE: FRANKLI-12 NEWKIRK ROAD",
        "SRC:EFD-FD",
        "ID:11053024",
        "CALL:STRUCTURE FIRE:",
        "CITY:FRANKLIN TWP",
        "ADDR:12 NEWKIRK ROAD");

    doTest("T9",
        "[CAD]  [CAD] EFD-FD:11053250:05/17/2011 11:56:48:FIRE ALARM:Z/GEN: FRANKLI-RETA - RENAISSANCE EMPLOYMENT / 630 FRANKLIN BLVD",
        "SRC:EFD-FD",
        "ID:11053250",
        "CALL:FIRE ALARM:Z/GEN:",
        "CITY:FRANKLIN TWP",
        "PLACE:RETA - RENAISSANCE EMPLOYMENT",
        "ADDR:630 FRANKLIN BLVD");

    doTest("T10",
        "[CAD]  [CAD] EFD-FD:11053657:05/18/2011 13:30:59:STOVE/OVEN/FOOD: FRANKLI-138 ELLEN ST",
        "SRC:EFD-FD",
        "ID:11053657",
        "CALL:STOVE/OVEN/FOOD:",
        "CITY:FRANKLIN TWP",
        "ADDR:138 ELLEN ST");
 }
  
  public static void main(String[] args) {
    new NJSomersetCountyParserTest().generateTests("T1", "SRC ID CALL CITY PLACE ADDR");
  }
}