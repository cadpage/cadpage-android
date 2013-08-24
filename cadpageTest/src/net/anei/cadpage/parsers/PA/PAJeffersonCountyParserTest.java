package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
 Jefferson County, PA
 Contact: "Rhed, Tony" <trhed@crossettinc.com>  (historical)
 Sender: Dispatch@jeffersoncountypa.com
 prvs=0482c7782c=dispatch@jeffersoncountypa.com (Incident) MVA -29-D Entrapment N 4TH ST HILL ST Reynoldsville Narrative:  10 YEAR OLD BOY HIT BY A CAR.
 prvs=0483bf5710=dispatch@jeffersoncountypa.com (Incident) Structure Fire CRICKET RD & VO TECH RD Winslow Narrative:  612 TO STATION  634 TO STATION UNKNOWN INJURIES  POSSIBLE  ENTRAPMENT. BOX 6-F
 prvs=0484c9755a=dispatch@jeffersoncountypa.com (Incident) Fire - Alarm. 3823 ROUTE 310 HIMES HILL RD / CHIPS RD Winslow.    Narrative:  basement smoke detector-  6-C Fire Tower

 Contact: Chris Smith <ffsmith20@gmail.com>
 Sender: dispatch@jeffersoncountypa.com
 prvs=0518956c10=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Fire - Alarm 251 S PENN STREET EXT Punxsutawney DEAD END / CLIFF ST 20-A Snyder Hill
 prvs=0518956c10=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Structure Fire 251 S PENN ST Punxsutawney
 prvs=0516eca2ae=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) MVA ROUTE 119 / ROUTE 436 Young Narrative:
 prvs=0514f9c90b=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) MVA 3637 ROUTE 36 SPRING RD / HOLLIS LN Oliver SMITH HAULINGNarrative: 5-A Coolspring
 prvs=0512e03127=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Structure Fire 106 FOUNDRY ST CRISSMAN ALY / W MAHONING ST Punxsutawney Narrative: 40-A Snyder Hill
 prvs=05312311d9=dispatch@jeffersoncountypa.com (Incident) Tree Down GASKILL AVE ALTMAN AVE Punxsutawney 20-A Snyder Hill
 prvs=054676518f=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Misc. Fire S20 MED50  313 WOODLAND AVE Punxsutawney BLAIR ST / CAMBRIA ST 20-A Snyder Hill
 prvs=054477bfa6=dispatch@jeffersoncountypa.com (Incident) Structure Fire E30 E20 E40 TK40 SQ30 R20 R40 T20 T40 MED50  143 WOODDALE DR Bell ALBION RD / ACORN LN 30-B Snyder Hill
 prvs=054676518f=dispatch@jeffersoncountypa.com (Incident) Structure Fire E30 E20 E40 TK40 T20 T40 MED50  118 CLARK ST Punxsutawney HAMPTON AVE, RIDGE AVE / N PENN ST 30-A Snyder Hi
 prvs=0555093757=dispatch@jeffersoncountypa.com (Incident) Tree Down S20  558 ROBINSON ST Bell HALL ST / DEAD END 20-B Snyder Hill
 prvs=05703e571d=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Structure Fire E20 R20 T20 E30 SQ30 E40 TK40 R40 MED50  105 WOODLAND AVE Punxsutawney SPRING ST / E MAHONING ST, CLEARFIEL
 prvs=0585990ef8=dispatch@jeffersoncountypa.com (Incident) MVA -29-D Entrapment S40 S20 S30 MED50  754 S MAIN STREET EXT Young FEMCO MACHINE COMPANYUNIVERSAL DR, CALVARY LN / ALLIAN
 prvs=0678992d8c=dispatch@jeffersoncountypa.com (Incident) MVA -29-D Entrapment S20  40.874|-79.0204 DEAD END / KACHMAR RD, SWARTZ ACRES RD 12-I Snyder Hill
 prvs=0678992d8c=dispatch@jeffersoncountypa.com (Incident) Structure Fire HH E20 R20 T20 E30 SQ30 E40 TK40 R16 MED50  238 E MAHONING ST Punxsutawney N PENN ST / N JEFFERSON ST, S JE
 prvs=0595a29521=dispatch@jeffersoncountypa.com (Incident) MVA S20 MED50  ELDERBERRY HILL RD, RT 36 / RT 36, OLD ROUTE 36 20-B Snyder Hill
 prvs=05894d5a85=dispatch@jeffersoncountypa.com (Incident) Vehicle Fire S20 MED50  201 HAMPTON AVE Punxsutawney COUNTY MARKET, FEZELLSTORRENCE ST / CLARK ST, RIDGE AVE 20-A Snyder H
 prvs=0588e3a5a6=dispatch@jeffersoncountypa.com (Incident) MVA S20 MED50  108 CLIFF ST Punxsutawney WEBER AVE / S PENN STREET EXT 20-A Snyder Hill
 prvs=0588e3a5a6=dispatch@jeffersoncountypa.com (Incident) MVA S20 MED50  301 W MAHONING ST Punxsutawney FIRST UNITED METHODIST CHURCH, PUNXSUTAWNEYCHURCH ST / MORRISON AVE 20-A Sny
 (Incident) MVA -29-D Entrapment S20 S30 S40 MED50  306 INDIANA ST Punxsutawney JOES DRIVE INNGILPIN STREET EXT / RT 119, MAPLE AVE 20

 */

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
        "CALL:Fire - Alarm.",
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
        "CALL:Misc. Fire",
        "UNIT:S20 MED50",
        "ADDR:313 WOODLAND AVE",
        "CITY:Punxsutawney",
        "X:BLAIR ST / CAMBRIA ST",
        "BOX:20-A",
        "CH:Snyder Hill");

    doTest("T8",
        "prvs=054477bfa6=dispatch@jeffersoncountypa.com (Incident) Structure Fire E30 E20 E40 TK40 SQ30 R20 R40 T20 T40 MED50  143 WOODDALE DR Bell ALBION RD / ACORN LN 30-B Snyder Hill",
        "CALL:Structure Fire",
        "UNIT:E30 E20 E40 TK40 SQ30 R20 R40 T20 T40 MED50",
        "ADDR:143 WOODDALE DR",
        "X:ALBION RD / ACORN LN",
        "CITY:Bell",
        "BOX:30-B",
        "CH:Snyder Hill");

    doTest("T9",
        "prvs=054676518f=dispatch@jeffersoncountypa.com (Incident) Structure Fire E30 E20 E40 TK40 T20 T40 MED50  118 CLARK ST Punxsutawney HAMPTON AVE, RIDGE AVE / N PENN ST 30-A Snyder Hi",
        "CALL:Structure Fire",
        "UNIT:E30 E20 E40 TK40 T20 T40 MED50",
        "ADDR:118 CLARK ST",
        "X:HAMPTON AVE, RIDGE AVE / N PENN ST",
        "CITY:Punxsutawney",
        "BOX:30-A",
        "CH:Snyder Hi");

    doTest("T10",
        "prvs=0555093757=dispatch@jeffersoncountypa.com (Incident) Tree Down S20  558 ROBINSON ST Bell HALL ST / DEAD END 20-B Snyder Hill",
        "CALL:Tree Down",
        "UNIT:S20",
        "ADDR:558 ROBINSON ST",
        "X:HALL ST / DEAD END",
        "CITY:Bell",
        "BOX:20-B",
        "CH:Snyder Hill");

    doTest("T12",
        "prvs=05703e571d=dispatch@ <dispatch@jeffersoncountypa.com> jeffersoncountypa.com <dispatch@jeffersoncountypa.com> (Incident) Structure Fire E20 R20 T20 E30 SQ30 E40 TK40 R40 MED50  105 WOODLAND AVE Punxsutawney SPRING ST / E MAHONING ST, CLEARFIEL",
        "CALL:Structure Fire",
        "UNIT:E20 R20 T20 E30 SQ30 E40 TK40 R40 MED50",
        "ADDR:105 WOODLAND AVE",
        "X:SPRING ST / E MAHONING ST",
        "CITY:Punxsutawney",
        "PLACE:CLEARFIEL");

    doTest("T13",
        "prvs=0585990ef8=dispatch@jeffersoncountypa.com (Incident) MVA -29-D Entrapment S40 S20 S30 MED50  754 S MAIN STREET EXT Young FEMCO MACHINE COMPANYUNIVERSAL DR, CALVARY LN / ALLIAN",
        "CALL:MVA -29-D Entrapment",
        "UNIT:S40 S20 S30 MED50",
        "ADDR:754 S MAIN STREET EXT",
        "MADDR:754 S MAIN STREET",
        "X:FEMCO MACHINE COMPANYUNIVERSAL DR, CALVARY LN",
        "CITY:Young",
        "PLACE:/ ALLIAN");

    doTest("T14",
        "prvs=0678992d8c=dispatch@jeffersoncountypa.com (Incident) MVA -29-D Entrapment S20  40.874|-79.0204 DEAD END / KACHMAR RD, SWARTZ ACRES RD 12-I Snyder Hill",
        "CALL:MVA -29-D Entrapment",
        "UNIT:S20",
        "ADDR:40.874,-79.0204",
        "MADDR:+40.874000,-79.020400",  // This is a test artifact
        "X:DEAD END / KACHMAR RD, SWARTZ ACRES RD",
        "BOX:12-I",
        "CH:Snyder Hill");

    doTest("T15",
        "prvs=0678992d8c=dispatch@jeffersoncountypa.com (Incident) Structure Fire HH E20 R20 T20 E30 SQ30 E40 TK40 R16 MED50  238 E MAHONING ST Punxsutawney N PENN ST / N JEFFERSON ST, S JE",
        "CALL:Structure Fire",
        "UNIT:HH E20 R20 T20 E30 SQ30 E40 TK40 R16 MED50",
        "ADDR:238 E MAHONING ST",
        "X:N PENN ST / N JEFFERSON ST",
        "CITY:Punxsutawney",
        "PLACE:S JE");

    doTest("T16",
        "prvs=0595a29521=dispatch@jeffersoncountypa.com (Incident) MVA S20 MED50  ELDERBERRY HILL RD, RT 36 / RT 36, OLD ROUTE 36 20-B Snyder Hill",
        "CALL:MVA",
        "UNIT:S20 MED50",
        "ADDR:ELDERBERRY HILL RD",
        "MADDR:ELDERBERRY HILL RD & RT 36",
        "X:RT 36 / RT 36, OLD ROUTE 36",
        "BOX:20-B",
        "CH:Snyder Hill");

    doTest("T17",
        "prvs=05894d5a85=dispatch@jeffersoncountypa.com (Incident) Vehicle Fire S20 MED50  201 HAMPTON AVE Punxsutawney COUNTY MARKET, FEZELLSTORRENCE ST / CLARK ST, RIDGE AVE 20-A Snyder H",
        "CALL:Vehicle Fire",
        "UNIT:S20 MED50",
        "ADDR:201 HAMPTON AVE",
        "X:COUNTY MARKET, FEZELLSTORRENCE ST / CLARK ST, RIDGE AVE",
        "CITY:Punxsutawney",
        "BOX:20-A",
        "CH:Snyder H");

    doTest("T18",
        "prvs=0588e3a5a6=dispatch@jeffersoncountypa.com (Incident) MVA S20 MED50  108 CLIFF ST Punxsutawney WEBER AVE / S PENN STREET EXT 20-A Snyder Hill",
        "CALL:MVA",
        "UNIT:S20 MED50",
        "ADDR:108 CLIFF ST",
        "X:WEBER AVE / S PENN STREET EXT",
        "CITY:Punxsutawney",
        "BOX:20-A",
        "CH:Snyder Hill");

    doTest("T19",
        "prvs=0588e3a5a6=dispatch@jeffersoncountypa.com (Incident) MVA S20 MED50  301 W MAHONING ST Punxsutawney FIRST UNITED METHODIST CHURCH, PUNXSUTAWNEYCHURCH ST / MORRISON AVE 20-A Sny",
        "CALL:MVA",
        "UNIT:S20 MED50",
        "ADDR:301 W MAHONING ST",
        "X:FIRST UNITED METHODIST CHURCH, PUNXSUTAWNEYCHURCH ST / MORRISON AVE",
        "CITY:Punxsutawney",
        "BOX:20-A",
        "CH:Sny");

    doTest("T20",
        " (Incident) MVA -29-D Entrapment S20 S30 S40 MED50  306 INDIANA ST Punxsutawney JOES DRIVE INNGILPIN STREET EXT / RT 119, MAPLE AVE 20",
        "CALL:MVA -29-D Entrapment",
        "UNIT:S20 S30 S40 MED50",
        "ADDR:306 INDIANA ST",
        "X:INNGILPIN STREET EXT / RT 119, MAPLE AVE",
        "CITY:Punxsutawney",
        "PLACE:JOES DRIVE - 20");

  }
  
  public static void main(String[] args) {
    new PAJeffersonCountyParserTest().generateTests("T1");
  }
}
