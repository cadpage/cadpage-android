package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYMadisonCountyBParserTest extends BaseParserTest {
  
  public NYMadisonCountyBParserTest() {
    setParser(new NYMadisonCountyBParser(), "MADISON COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[911 Dispatch]  BRKFD:2011:173\nDispatched\nChest Pain\n1929 ACADEMY RD , BROOKFIELD ( / SPOONER RD)",
        "SRC:BRKFD",
        "ID:2011:173",
        "CALL:Chest Pain",
        "ADDR:1929 ACADEMY RD",
        "CITY:BROOKFIELD",
        "X:SPOONER RD");

    doTest("T2",
        "[911 Dispatch]  BRKFD:2011:172\nDispatched\nPsychiatric/Suicide Attempt\n11325 MILL , BROOKFIELD ( CENTER /)",
        "SRC:BRKFD",
        "ID:2011:172",
        "CALL:Psychiatric/Suicide Attempt",
        "ADDR:11325 MILL",
        "CITY:BROOKFIELD",
        "X:CENTER");

    doTest("T3",
        "[911 Dispatch]  BRKFD:2011:171\nDispatched\nBreathing Problem\n10825 HOXIE RD , BROOKFIELD ( COYOTE RUN /)",
        "SRC:BRKFD",
        "ID:2011:171",
        "CALL:Breathing Problem",
        "ADDR:10825 HOXIE RD",
        "CITY:BROOKFIELD",
        "X:COYOTE RUN");

    doTest("T4",
        "[911 Dispatch]  BRKFD:2011:170\nDispatched\nMVA - Personal Injury\n10215 SKANEATELES TRNPK , BROOKFIELD ( VIDLER RD / OULEOU",
        "SRC:BRKFD",
        "ID:2011:170",
        "CALL:MVA - Personal Injury",
        "ADDR:10215 SKANEATELES TRNPK",
        "CITY:BROOKFIELD",
        "X:VIDLER RD / OULEOU");

    doTest("T5",
        "[911 Dispatch]  BRKFD:2011:169\nDispatched\nAssault/Sexual Assault\n2118 FRIAR RD , BROOKFIELD ( / VIDLER RD)",
        "SRC:BRKFD",
        "ID:2011:169",
        "CALL:Assault/Sexual Assault",
        "ADDR:2118 FRIAR RD",
        "CITY:BROOKFIELD",
        "X:VIDLER RD");

    doTest("T6",
        "[911 Dispatch]  BRKFD:2011:167\nDispatched\nBreathing Problem\n10505 MAIN , BROOKFIELD",
        "SRC:BRKFD",
        "ID:2011:167",
        "CALL:Breathing Problem",
        "ADDR:10505 MAIN",
        "CITY:BROOKFIELD");

    doTest("T7",
        "[911 Dispatch]  BRKFD:2011:166\nDispatched\nMVA - Personal Injury\nBEAVER CREEK RD , BROOKFIELD",
        "SRC:BRKFD",
        "ID:2011:166",
        "CALL:MVA - Personal Injury",
        "ADDR:BEAVER CREEK RD",
        "CITY:BROOKFIELD");

    doTest("T8",
        "[911 Dispatch]  BRKFD:2011:165\nDispatched\nTraumatic Injuries\n@SCHOOL BOCES BROOKFIELD CENTRAL SCHOOL (1910 FAIRGROUND RD",
        "SRC:BRKFD",
        "ID:2011:165",
        "CALL:Traumatic Injuries",
        "PLACE:SCHOOL BOCES BROOKFIELD CENTRAL SCHOOL",
        "ADDR:1910 FAIRGROUND RD");

    doTest("T9",
        "[911 Dispatch]  BRKFD:2011:164\nDispatched\nSick Person\n10799 HOXIE RD , BROOKFIELD ( COYOTE RUN /)",
        "SRC:BRKFD",
        "ID:2011:164",
        "CALL:Sick Person",
        "ADDR:10799 HOXIE RD",
        "CITY:BROOKFIELD",
        "X:COYOTE RUN");

    doTest("T10",
        "[911 Dispatch]  BRKFD:2011:163\nDispatched\nTraumatic Injuries\n1910 FAIRGROUND RD , BROOKFIELD ( / ELM)\n",
        "SRC:BRKFD",
        "ID:2011:163",
        "CALL:Traumatic Injuries",
        "ADDR:1910 FAIRGROUND RD",
        "CITY:BROOKFIELD",
        "X:ELM");

    doTest("T11",
        " 1 of 2\n" +
        "FRM:e-911@co.madison.ny.us\n" +
        "SUBJ:[wampsvillefd] 911 Dispatch\n" +
        "MSG:WAMFD:2012:34\r\n" +
        "Dispatched\r\n" +
        "Chest Pain\r\n" +
        "@MADISON COUNTY VETERANS OFFICE\n" +
        "(Con't) 2 of 2\n" +
        "BUILDING (138 NORTH COURT ST (WAMPSVILLE VIL )(End)",

        "SRC:WAMFD",
        "ID:2012:34",
        "CALL:Chest Pain",
        "PLACE:MADISON COUNTY VETERANS OFFICE BUILDING",
        "ADDR:138 NORTH COURT ST",
        "CITY:WAMPSVILLE");

    doTest("T12",
        "FRM:e-911@co.madison.ny.us\n" +
        "SUBJ:[wampsvillefd] 911 Dispatch\n" +
        "MSG:WAMFD:2012:33\r\n" +
        "Dispatched\r\n" +
        "Structure Fire\r\n" +
        "6438 PERRYVILLE RD , SULLIVAN ( MADISON / OSBORNE RD)",

        "SRC:WAMFD",
        "ID:2012:33",
        "CALL:Structure Fire",
        "ADDR:6438 PERRYVILLE RD",
        "CITY:SULLIVAN",
        "X:MADISON / OSBORNE RD");

    doTest("T13",
        " 1 of 2\n" +
        "FRM:e-911@co.madison.ny.us\n" +
        "SUBJ:[wampsvillefd] 911 Dispatch\n" +
        "MSG:WAMFD:2012:30\r\n" +
        "Dispatched\r\n" +
        "Test Call\r\n" +
        "118 N COURT , WAMPSVILLE VILLAGE (\n" +
        "(Con't 2 of 2\n" +
        "DANIELS DR / MARKELL DR)(End)",

        "SRC:WAMFD",
        "ID:2012:30",
        "CALL:Test Call",
        "ADDR:118 N COURT",
        "CITY:WAMPSVILLE VILLAGE",
        "X:DANIELS DR / MARKELL DR");
 }
  
  public static void main(String[] args) {
    new NYMadisonCountyBParserTest().generateTests("T1");
  }
}