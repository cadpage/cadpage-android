package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Albany County, NY
Contact: sturnermxz@aol.com
Sender: dispatch@edispatches.com
(elsmerefd_cad Sep15-15:30) TYPE:OUT F Outdoors  \r\nLOC:10 SNOWDEN AV  \r\nBTWN:DELAWARE AV/ELLSWORTH AV \r\nNATURE:FIRE / SMELLS AND HEAVY SMOKE /
[elsmerefd_cad Sep14-16:49]  TYPE:STR F Structure\nLOC:790 ROUTE 9W\nBTWN:WEMPLE RD/CHURCH RD\nNATURE:GENERAL FIRE
(elsmerefd_cad Sep18-13:42) TYPE:HAZC F HazCon  \r\nLOC:HUDSON AV  \r\nNATURE:NORTH ST  

*/

public class NYAlbanyCountyBParserTest extends BaseParserTest {
  
  public NYAlbanyCountyBParserTest() {
    setParser(new NYAlbanyCountyBParser(), "ALBANY COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(elsmerefd_cad Sep15-15:30) TYPE:OUT F Outdoors  \r\n" +
        "LOC:10 SNOWDEN AV  \r\n" +
        "BTWN:DELAWARE AV/ELLSWORTH AV \r\n" +
        "NATURE:FIRE / SMELLS AND HEAVY SMOKE /",

        "SRC:elsmerefd",
        "DATE:09/15",
        "TIME:15:30",
        "CALL:OUT F Outdoors",
        "ADDR:10 SNOWDEN AV",
        "MADDR:10 SNOWDEN AVE",
        "X:DELAWARE AV/ELLSWORTH AV",
        "INFO:FIRE / SMELLS AND HEAVY SMOKE /");

    doTest("T2",
        "[elsmerefd_cad Sep14-16:49]  TYPE:STR F Structure\nLOC:790 ROUTE 9W\nBTWN:WEMPLE RD/CHURCH RD\nNATURE:GENERAL FIRE",
        "SRC:elsmerefd",
        "DATE:09/14",
        "TIME:16:49",
        "CALL:STR F Structure",
        "ADDR:790 ROUTE 9W",
        "X:WEMPLE RD/CHURCH RD",
        "INFO:GENERAL FIRE");

    doTest("T3",
        "(elsmerefd_cad Sep18-13:42) TYPE:HAZC F HazCon  \r\nLOC:HUDSON AV  \r\nNATURE:NORTH ST  ",
        "SRC:elsmerefd",
        "DATE:09/18",
        "TIME:13:42",
        "CALL:HAZC F HazCon",
        "ADDR:HUDSON AV",
        "MADDR:HUDSON AVE & NORTH ST",
        "X:NORTH ST");

  }
  
  public static void main(String[] args) {
    new NYAlbanyCountyBParserTest().generateTests("T1");
  }
}