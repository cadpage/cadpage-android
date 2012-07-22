package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAJeffersonCountyParserTest extends BaseParserTest {
  
  public PAJeffersonCountyParserTest() {
    setParser(new PAJeffersonCountyParser(), "JEFFERSON COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "prvs=0482c7782c=dispatch@jeffersoncountypa.com (Incident) MVA -29-D Entrapment N 4TH ST HILL ST Reynoldsville Narrative:  10 YEAR OLD BOY HIT BY A CAR.",
        "CALL:MVA -29-D Entrapment",
        "ADDR:N 4TH ST",
        "X:HILL ST",
        "MADDR:N 4TH ST & HILL ST",
        "CITY:Reynoldsville",
        "INFO:10 YEAR OLD BOY HIT BY A CAR.");

    doTest("T2",
        "prvs=0483bf5710=dispatch@jeffersoncountypa.com (Incident) Structure Fire CRICKET RD & VO TECH RD Winslow Narrative:  612 TO STATION  634 TO STATION UNKNOWN INJURIES  POSSIBLE  ENTRAPMENT. BOX 6-F",
        "CALL:Structure Fire",
        "ADDR:CRICKET RD & VO TECH RD",  // Not mapping
        "CITY:Winslow",
        "INFO:612 TO STATION  634 TO STATION UNKNOWN INJURIES  POSSIBLE  ENTRAPMENT.",
        "BOX:6-F");

    doTest("T3",
        "prvs=0484c9755a=dispatch@jeffersoncountypa.com (Incident) Fire - Alarm. 3823 ROUTE 310 HIMES HILL RD / CHIPS RD Winslow.    Narrative:  basement smoke detector-  6-C Fire Tower",
        "CALL:Fire - Alarm",
        "ADDR:3823 ROUTE 310",
        "X:HIMES HILL RD / CHIPS RD",
        "CITY:Winslow",
        "INFO:basement smoke detector",
        "BOX:6-C",
        "CH:Fire Tower");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "prvs=0518956c10=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Fire - Alarm 251 S PENN STREET EXT Punxsutawney DEAD END / CLIFF ST 20-A Snyder Hill",
        "CALL:Fire - Alarm",
        "ADDR:251 S PENN STREET EXT",
        "MADDR:251 S PENN STREET",
        "CITY:Punxsutawney",
        "X:DEAD END / CLIFF ST",
        "BOX:20-A",
        "CH:Snyder Hill");

    doTest("T2",
        "prvs=0518956c10=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Structure Fire 251 S PENN ST Punxsutawney",
        "CALL:Structure Fire",
        "ADDR:251 S PENN ST",
        "CITY:Punxsutawney");

    doTest("T3",
        "prvs=0516eca2ae=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) MVA ROUTE 119 / ROUTE 436 Young Narrative:",
        "CALL:MVA",
        "ADDR:ROUTE 119 & ROUTE 436",
        "CITY:Young");

    doTest("T4",
        "prvs=0514f9c90b=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) MVA 3637 ROUTE 36 SPRING RD / HOLLIS LN Oliver SMITH HAULINGNarrative: 5-A Coolspring",
        "CALL:MVA",
        "ADDR:3637 ROUTE 36",
        "X:SPRING RD / HOLLIS LN",
        "CITY:Oliver",
        "PLACE:SMITH HAULING",
        "BOX:5-A",
        "CH:Coolspring");

    doTest("T5",
        "prvs=0512e03127=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Structure Fire 106 FOUNDRY ST CRISSMAN ALY / W MAHONING ST Punxsutawney Narrative: 40-A Snyder Hill",
        "CALL:Structure Fire",
        "ADDR:106 FOUNDRY ST",
        "X:CRISSMAN ALY / W MAHONING ST",
        "CITY:Punxsutawney",
        "BOX:40-A",
        "CH:Snyder Hill");

    doTest("T6",
        "prvs=05312311d9=dispatch@jeffersoncountypa.com (Incident) Tree Down GASKILL AVE ALTMAN AVE Punxsutawney 20-A Snyder Hill",
        "CALL:Tree Down",
        "ADDR:GASKILL AVE",
        "MADDR:GASKILL AVE & ALTMAN AVE",
        "X:ALTMAN AVE",
        "CITY:Punxsutawney",
        "BOX:20-A",
        "CH:Snyder Hill");

    doTest("7",
        "prvs=054676518f=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Misc. Fire S20 MED50  313 WOODLAND AVE Punxsutawney BLAIR ST / CAMBRIA ST 20-A Snyder Hill",
        "CALL:Misc Fire S20 MED50",
        "ADDR:313 WOODLAND AVE",
        "CITY:Punxsutawney",
        "X:BLAIR ST / CAMBRIA ST",
        "BOX:20-A",
        "CH:Snyder Hill");

    doTest("T8",
        "prvs=054477bfa6=dispatch@jeffersoncountypa.com (Incident) Structure Fire E30 E20 E40 TK40 SQ30 R20 R40 T20 T40 MED50  143 WOODDALE DR Bell ALBION RD / ACORN LN 30-B Snyder Hill",
        "CALL:Structure Fire E30 E20 E40 TK40 SQ30 R20 R40 T20 T40 MED50",
        "ADDR:143 WOODDALE DR",
        "X:ALBION RD / ACORN LN",
        "CITY:Bell",
        "BOX:30-B",
        "CH:Snyder Hill");

    doTest("T9",
        "prvs=054676518f=dispatch@jeffersoncountypa.com (Incident) Structure Fire E30 E20 E40 TK40 T20 T40 MED50  118 CLARK ST Punxsutawney HAMPTON AVE, RIDGE AVE / N PENN ST 30-A Snyder Hi",
        "CALL:Structure Fire E30 E20 E40 TK40 T20 T40 MED50",
        "ADDR:118 CLARK ST",
        "X:HAMPTON AVE, RIDGE AVE / N PENN ST",
        "CITY:Punxsutawney",
        "BOX:30-A",
        "CH:Snyder Hi");
  }
  
  public static void main(String[] args) {
    new PAJeffersonCountyParserTest().generateTests("T1", "CALL ADDR APT X CITY PLACE INFO BOX CH");
  }
}
