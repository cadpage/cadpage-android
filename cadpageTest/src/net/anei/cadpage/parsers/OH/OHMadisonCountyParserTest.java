package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Madison County, OH
Contact: Brian Bennington <centralchief1@gmail.com>
Sender: mcsocad@madisonsheriff.org
[Alert: FIRE STRUCTURE RESIDENTIAL]  ALRM LVL: 1\r\nLOC:\r\n4665 LILLY CHAPEL-OPOSSUM RUN SE RD\r\nFAIRFIELD TWP\r\nBTWN: WEST JEFFERSON-KIOUSVILLE RD & SR 665\r\n\r
[Alert: VEHICLE CRASH INJURY]  ALRM LVL: 1\r\nLOC:\r\n6905 GREGG MILL SE RD\r\nOAK RUN TWP\r\nBTWN: BIG PLAIN-CIRCLEVILLE RD & SR 56\r\n\r\nRCVD AS Phone 7-Digit\r\n\r\nC
(Alert: FIRE INVESTIGATION) ALRM LVL: 1\r\nLOC:\r\nDEER RUN SE LN/SPRING VALLEY SE RD\r\nDEER CREEK TWP\r\nBTWN: N/A & N/A\r\n\r\nRCVD AS 911 Call\r\n\r\nCOM:\r\nON DEER RUN LN
(Alert: VEHICLE CRASH INJURY) ALRM LVL: 1\r\nLOC:\r\n7385 SR 56 SE\r\nOAK RUN TWP\r\nBTWN: GREGG MILL RD & MOORMAN RD\r\n\r\nRCVD AS 911 Call\r\n\r\nCOM:\r\n2 VEH / 4 PEOP
(Alert: VEHICLE CRASH INJURY) ALRM LVL: 1\r\nLOC:\r\nUS 40 NE/LAFAYETTE-PLAIN CITY RD\r\nDEER CREEK TWP\r\nBTWN: N/A & N/A\r\n\r\nRCVD AS Phone 7-Digit\r\n\r\nCOM:\r\nON 4

*/

public class OHMadisonCountyParserTest extends BaseParserTest {
  
  public OHMadisonCountyParserTest() {
    setParser(new OHMadisonCountyParser(), "MADISON COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[Alert: FIRE STRUCTURE RESIDENTIAL]  ALRM LVL: 1\r\n" +
        "LOC:\r\n" +
        "4665 LILLY CHAPEL-OPOSSUM RUN SE RD\r\n" +
        "FAIRFIELD TWP\r\n" +
        "BTWN: WEST JEFFERSON-KIOUSVILLE RD & SR 665\r\n" +
        "\r",

        "CALL:FIRE STRUCTURE RESIDENTIAL",
        "PRI:1",
        "ADDR:4665 LILLY CHAPEL-OPOSSUM RUN SE RD",
        "CITY:FAIRFIELD TWP",
        "X:WEST JEFFERSON-KIOUSVILLE RD & SR 665");

    doTest("T2",
        "[Alert: VEHICLE CRASH INJURY]  ALRM LVL: 1\r\n" +
        "LOC:\r\n" +
        "6905 GREGG MILL SE RD\r\n" +
        "OAK RUN TWP\r\n" +
        "BTWN: BIG PLAIN-CIRCLEVILLE RD & SR 56\r\n" +
        "\r\n" +
        "RCVD AS Phone 7-Digit\r\n" +
        "\r\n" +
        "C",

        "CALL:VEHICLE CRASH INJURY",
        "PRI:1",
        "ADDR:6905 GREGG MILL SE RD",
        "CITY:OAK RUN TWP",
        "X:BIG PLAIN-CIRCLEVILLE RD & SR 56");

    doTest("T3",
        "(Alert: FIRE INVESTIGATION) ALRM LVL: 1\r\n" +
        "LOC:\r\n" +
        "DEER RUN SE LN/SPRING VALLEY SE RD\r\n" +
        "DEER CREEK TWP\r\n" +
        "BTWN: N/A & N/A\r\n" +
        "\r\n" +
        "RCVD AS 911 Call\r\n" +
        "\r\n" +
        "COM:\r\n" +
        "ON DEER RUN LN",

        "CALL:FIRE INVESTIGATION",
        "PRI:1",
        "ADDR:DEER RUN SE LN & SPRING VALLEY SE RD",
        "CITY:DEER CREEK TWP",
        "X:N/A & N/A",
        "INFO:ON DEER RUN LN");

    doTest("T4",
        "(Alert: VEHICLE CRASH INJURY) ALRM LVL: 1\r\n" +
        "LOC:\r\n" +
        "7385 SR 56 SE\r\n" +
        "OAK RUN TWP\r\n" +
        "BTWN: GREGG MILL RD & MOORMAN RD\r\n" +
        "\r\n" +
        "RCVD AS 911 Call\r\n" +
        "\r\n" +
        "COM:\r\n" +
        "2 VEH / 4 PEOP",

        "CALL:VEHICLE CRASH INJURY",
        "PRI:1",
        "ADDR:7385 SR 56 SE",
        "MADDR:7385 OH 56 SE",
        "CITY:OAK RUN TWP",
        "X:GREGG MILL RD & MOORMAN RD",
        "INFO:2 VEH / 4 PEOP");

    doTest("T5",
        "(Alert: VEHICLE CRASH INJURY) ALRM LVL: 1\r\n" +
        "LOC:\r\n" +
        "US 40 NE/LAFAYETTE-PLAIN CITY RD\r\n" +
        "DEER CREEK TWP\r\n" +
        "BTWN: N/A & N/A\r\n" +
        "\r\n" +
        "RCVD AS Phone 7-Digit\r\n" +
        "\r\n" +
        "COM:\r\n" +
        "ON 4",

        "CALL:VEHICLE CRASH INJURY",
        "PRI:1",
        "ADDR:US 40 NE & LAFAYETTE-PLAIN CITY RD",  // Google can't find US 40
        "CITY:DEER CREEK TWP",
        "X:N/A & N/A",
        "INFO:ON 4");

  }
  
  public static void main(String[] args) {
    new OHMadisonCountyParserTest().generateTests("T1");
  }
}