package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import org.junit.Test;


public class MDCecilCountyCParserTest extends BaseParserTest {
  
  public MDCecilCountyCParserTest() {
    setParser(new MDCecilCountyCParser(), "CECIL COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[pCAD] TYPE: 17A01 FALL LOC: 33 CENTER ST BOX: 700 TIME: 162632",
        "CALL:17A01 FALL",
        "ADDR:33 CENTER ST",
        "BOX:700",
        "TIME:162632");

    doTest("T2",
        "[pCAD] TYPE: 06D01 RESPIRATORY DISTRESS LOC: 32 OWENS CT BOX: 600 TIME: 034305",
        "CALL:06D01 RESPIRATORY DISTRESS",
        "ADDR:32 OWENS CT",
        "BOX:600",
        "TIME:034305");

    doTest("T3",
        "[pCAD] TYPE: MVA MOTOR VEHICLE ACC LOC: PERRYLAWN DR / TURNPIKE DR BOX: 602 TIME: 072112",
        "CALL:MVA MOTOR VEHICLE ACC",
        "ADDR:PERRYLAWN DR & TURNPIKE DR",
        "BOX:602",
        "TIME:072112");

    doTest("T4",
        "[pCAD] TYPE: 33A03 TRANS/PALLIATIVE LOC: BOX: 1100 TIME: 184230",
        "CALL:33A03 TRANS/PALLIATIVE",
        "BOX:1100",
        "TIME:184230");

    doTest("T5",
        "[pCAD] TYPE: 06D01 RESPIRATORY DISTRESS LOC: 300 CARTER CT APT D BOX: 601 TIME: 092448",
        "CALL:06D01 RESPIRATORY DISTRESS",
        "ADDR:300 CARTER CT",
        "APT:D",
        "BOX:601",
        "TIME:092448");

    doTest("T6",
        "[pCAD] TYPE: 30A01 INJURED PERSON LOC: 1201 CHESAPEAKE OVERLOOK PKWY @CASINO BOX: 602D TIME: 174554",
        "CALL:30A01 INJURED PERSON",
        "PLACE:1201 CHESAPEAKE OVERLOOK PKWY",
        "ADDR:CASINO",
        "MADDR:1201 CHESAPEAKE OVERLOOK PKWY,CASINO",
        "BOX:602D",
        "TIME:174554");

    doTest("T7",
        "[pCAD] TYPE: 26A10 SICK PERSON LOC: 108 CONCORD DR @CONCORD APARTMENTS BOX: 600 TIME: 194041",
        "CALL:26A10 SICK PERSON",
        "PLACE:108 CONCORD DR",
        "ADDR:CONCORD APARTMENTS",
        "MADDR:108 CONCORD DR,CONCORD APARTMENTS",
        "BOX:600",
        "TIME:194041");

    doTest("T8",
        "[pCAD] TYPE: 31D03 UNCON/SYNCOPAL LOC: 33 RESERVOIR RD BOX: 602 TIME: 084642",
        "CALL:31D03 UNCON/SYNCOPAL",
        "ADDR:33 RESERVOIR RD",
        "BOX:602",
        "TIME:084642");

    doTest("T9",
        "[pCAD] TYPE: AMBO AMBO CALL LOC: PERRYLAWN DR / DIAMOND JIM RD BOX: 606 TIME: 092817",
        "CALL:AMBO AMBO CALL",
        "ADDR:PERRYLAWN DR & DIAMOND JIM RD",
        "BOX:606",
        "TIME:092817");

    doTest("T10",
        "[pCAD] TYPE: AMBO AMBO CALL LOC: 330 OTSEGO ST BOX: 600 TIME: 172824",
        "CALL:AMBO AMBO CALL",
        "ADDR:330 OTSEGO ST",
        "BOX:600",
        "TIME:172824");

    doTest("T11",
        "[pCAD] TYPE: AMBO AMBO CALL LOC: 701 RUSTIC CT BOX: 601 TIME: 184244",
        "CALL:AMBO AMBO CALL",
        "ADDR:701 RUSTIC CT",
        "BOX:601",
        "TIME:184244");

    doTest("T12",
        "[pCAD] TYPE: AMBO AMBO CALL LOC: CASINO @1201 CHESAPEAKE OVERLOOK PKWY BOX: 602D TIME: 111634",
        "CALL:AMBO AMBO CALL",
        "PLACE:CASINO",
        "ADDR:1201 CHESAPEAKE OVERLOOK PKWY",
        "BOX:602D",
        "TIME:111634");

    doTest("T13",
        "[pCAD] TYPE: HOUSE HOUSE FIRE LOC: 751 AIKEN AVE BOX: 600 TIME: 144557",
        "CALL:HOUSE HOUSE FIRE",
        "ADDR:751 AIKEN AVE",
        "BOX:600",
        "TIME:144557");

    doTest("T14",
        "[pCAD] TYPE: 02C02 ALLERGIC REACTION LOC: 469 SUMPTER DR BOX: 601 TIME: 153301",
        "CALL:02C02 ALLERGIC REACTION",
        "ADDR:469 SUMPTER DR",
        "BOX:601",
        "TIME:153301");

    doTest("T15",
        "[pCAD] TYPE: HAZMAT HAZARDOUS MATERIALS LOC: CECIL COUNTY LANDFIL @758 E OLD PHILADELPHIA RD BOX: 401 TIME: 132727",
        "CALL:HAZMAT HAZARDOUS MATERIALS",
        "PLACE:CECIL COUNTY LANDFIL",
        "ADDR:758 E OLD PHILADELPHIA RD",
        "BOX:401",
        "TIME:132727");

    doTest("T16",
        "[pCAD] TYPE: HOUSE HOUSE FIRE LOC: 751 AIKEN AVE BOX: 600 TIME: 012030",
        "CALL:HOUSE HOUSE FIRE",
        "ADDR:751 AIKEN AVE",
        "BOX:600",
        "TIME:012030");

    doTest("T17",
        "[pCAD] TYPE: MVA MOTOR VEHICLE ACC LOC: PERRYLAWN DR / RT 222 - PERRYVILLE BOX: 602 TIME: 091057",
        "CALL:MVA MOTOR VEHICLE ACC",
        "ADDR:PERRYLAWN DR & RT 222 - PERRYVILLE",
        "BOX:602",
        "TIME:091057");
  }
  
  public static void main(String[] args) {
    new MDCecilCountyCParserTest().generateTests("T1");
  }
}