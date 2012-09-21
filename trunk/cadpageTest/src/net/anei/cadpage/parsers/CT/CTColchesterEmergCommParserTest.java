package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CTColchesterEmergCommParserTest extends BaseParserTest {
  
  public CTColchesterEmergCommParserTest() {
    setParser(new CTColchesterEmergCommParser(), "", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "COLCHESTER\\ 25 VILLAGE CT\\ \\@  AMSTON RD\\ FAINTING OR UNCONC. PERS\\ VOGEL,HERBERT H \\  ** 12-6474  \\ 11:42 ** MapIt:  25  VILLAGE CT, COLCHESTER , CT ( UNCONSCIOUS )",
        "CITY:COLCHESTER",
        "ADDR:25 VILLAGE CT", //*** NOT FOUND ***
        "X:AMSTON RD",
        "CALL:FAINTING OR UNCONC. PERS",
        "NAME:VOGEL,HERBERT H",
        "ID:12-6474",
        "TIME:11:42",
        "INFO:UNCONSCIOUS");

    doTest("T2",
        "COLCHESTER\\ 15 OLD HARTFORD RD\\ \\@  WALL ST\\ DIFFICULTY BREATHING\\ STATE POLICE TROOP K - LOBBY \\  ** 12-6456  \\ 05:21 ** MapIt:  15  OLD HARTFORD RD, COLCHESTER , CT",
        "CITY:COLCHESTER",
        "ADDR:15 OLD HARTFORD RD",
        "X:WALL ST",
        "CALL:DIFFICULTY BREATHING",
        "PLACE:STATE POLICE TROOP K - LOBBY",
        "ID:12-6456",
        "TIME:05:21");

    doTest("T3",
        "COLCHESTER\\  ROUTE 2 WEST \\ \\@  \\ M/V ACCIDENT\\ area of exit 18 \\  ** 12-6481  \\ 12:30 ** MapIt:    ROUTE 2 WEST , COLCHESTER , CT ( ROLLOVER. )",
        "CITY:COLCHESTER",
        "ADDR:ROUTE 2 WEST",
        "MADDR:area of exit 18,ROUTE 2 WEST",
        "CALL:M/V ACCIDENT",
        "PLACE:area of exit 18",
        "ID:12-6481",
        "TIME:12:30",
        "INFO:ROLLOVER.");

    doTest("T4",
        "COLCHESTER\\ 13 HUNTERS CT\\ \\@  MELANIE LN\\ DIFFICULTY BREATHING\\ FORTIN,V \\ ** 12-6400  \\ 23:17 ** MapIt:  13  HUNTERS CT, COLCHESTER , CT ( 40S MALE - ATTN G LAKE R2 MUTUAL AID )",
        "CITY:COLCHESTER",
        "ADDR:13 HUNTERS CT",
        "X:MELANIE LN",
        "CALL:DIFFICULTY BREATHING",
        "NAME:FORTIN,V",
        "ID:12-6400",
        "TIME:23:17",
        "INFO:40S MALE - ATTN G LAKE R2 MUTUAL AID");

    doTest("T5",
        "COLCHESTER\\ 27 VICKI LN\\ \\@  OLD HEBRON RD\\ ALLERG. REACT\\ CINCIRIPINO,JEFFREY \\  ** 12-6342  \\ 00:32 ** MapIt:  27  VICKI LN, COLCHESTER , CT ( 27 MALE REACTION TO MEDICATION )",
        "CITY:COLCHESTER",
        "ADDR:27 VICKI LN",
        "X:OLD HEBRON RD",
        "CALL:ALLERG. REACT",
        "NAME:CINCIRIPINO,JEFFREY",
        "ID:12-6342",
        "TIME:00:32",
        "INFO:27 MALE REACTION TO MEDICATION");

    doTest("T6",
        "COLCHESTER\\ 64 BALABAN RD\\ 505\\@  GILLETTES LN\\ SICK PERSON\\ STAPLES,ARTHUR J \\  ** 12-6360  \\ 10:13 ** MapIt:  64  BALABAN RD, COLCHESTER , CT",
        "CITY:COLCHESTER",
        "ADDR:64 BALABAN RD",
        "APT:505",
        "X:GILLETTES LN",
        "CALL:SICK PERSON",
        "NAME:STAPLES,ARTHUR J",
        "ID:12-6360",
        "TIME:10:13");
  }
  
  public static void main(String[] args) {
    new CTColchesterEmergCommParserTest().generateTests("T1");
  }
}