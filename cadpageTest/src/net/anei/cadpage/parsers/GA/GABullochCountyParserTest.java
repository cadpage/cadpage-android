package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class GABullochCountyParserTest extends BaseParserTest {
  
  public GABullochCountyParserTest() {
    setParser(new GABullochCountyParser(), "BULLOCH COUNTY", "GA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(STRUCTURE FIRE) STRUCTURE FIRE\nCLYDES #47\n513 BROOKLET EAST\nBURNING SMELL FROM FUSE BOX",
        "CALL:STRUCTURE FIRE",
        "ADDR:513 BROOKLET EAST",
        "APT:CLYDES #47",
        "INFO:BURNING SMELL FROM FUSE BOX");

    doTest("T2",
        "(STRUCTURE FIRE) EAST LEE STREET ACROSS FROM BROOKLET POLICE DEPARTMENT\nSTRUCTURE FIRE",
        "CALL:STRUCTURE FIRE",
        "ADDR:EAST LEE STREET",
        "INFO:ACROSS FROM BROOKLET POLICE DEPARTMENT");

    doTest("T3",
        "(361 METTS RD) 361 METTS RD\nSTRUCTURE FIRE\nSTOVE AREA",
        "CALL:STRUCTURE FIRE",
        "ADDR:361 METTS RD",
        "INFO:STOVE AREA");

    doTest("T4",
        "(STRUCUTRE FIRE) 715 CAMDEN CT DRYER ON FIRE  STATION 8 DIST",
        "CALL:STRUCUTRE FIRE",
        "ADDR:715 CAMDEN CT",
        "INFO:DRYER ON FIRE STATION 8 DIST");

    doTest("T5",
        "(WOODS FIRE) WOODS FIRE\nBEHIND OAK HILL TRLR PK\n25213 N HIGHWAY 301",
        "CALL:WOODS FIRE",
        "ADDR:25213 N HIGHWAY 301",
        "INFO:BEHIND OAK HILL TRLR PK");

    doTest("T6",
        "(SMOKE) HEAVY SMOKE AROUND LANE RD",
        "CALL:SMOKE",
        "ADDR:AROUND LANE RD",
        "INFO:HEAVY SMOKE");

    doTest("T7",
        "(STRUCTURE FIRE) 2 RED BREAST LN   OFF OF OLD RIVER RD NORTH UNFAMILIAR ON\nENTRAPMENT ALSO WOODS ON FIRE IN THE AREA OF SHUMAN RD",
        "CALL:STRUCTURE FIRE",
        "ADDR:2 RED BREAST LN",
        "INFO:OFF OF OLD RIVER RD NORTH UNFAMILIAR ON / ENTRAPMENT ALSO WOODS ON FIRE IN THE AREA OF SHUMAN RD");

    doTest("T8",
        "(WOODS FIRE) SHUMAN RD OFF OF OLD RIVER RD  NORTH",
        "CALL:WOODS FIRE",
        "ADDR:SHUMAN RD",
        "INFO:OFF OF OLD RIVER RD NORTH");
   
  }
  
  public static void main(String[] args) {
    new GABullochCountyParserTest().generateTests("T1", "CALL ADDR APT INFO");
  }
}
