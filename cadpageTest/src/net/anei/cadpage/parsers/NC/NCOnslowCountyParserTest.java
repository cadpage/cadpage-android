package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCOnslowCountyParserTest extends BaseParserTest {
  
  public NCOnslowCountyParserTest() {
    setParser(new NCOnslowCountyParser(), "ONSLOW COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:100 VANCE LN/RIGGS RD;DIST: 158.12 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C\r",
        "ADDR:100 VANCE LN & RIGGS RD",
        "MADDR:100 VANCE LN",   // Not mapping - Problem reported
        "PLACE:DIST: 158.12 FT",
        "CALL:TRAFFIC TRANSPORTATION ACCIDT",
        "SRC:WOFD",
        "UNIT:20C");

    doTest("T2",
        "CAD:141 SHADY ST;STRUCTURE FIRE;PGFD;11B",
        "ADDR:141 SHADY ST",
        "CALL:STRUCTURE FIRE",
        "SRC:PGFD",
        "UNIT:11B");

    doTest("T3",
        "CAD:417 LITTLE CREEK CT;ELECTRICAL HAZARD;WOFD;20D",
        "ADDR:417 LITTLE CREEK CT",
        "CALL:ELECTRICAL HAZARD",
        "SRC:WOFD",
        "UNIT:20D");

    doTest("T4",
        "CAD:1061 RIGGS RD/SMITH RD;DIST: 16.79 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20B",
        "ADDR:1061 RIGGS RD & SMITH RD",
        "MADDR:1061 RIGGS RD",
        "PLACE:DIST: 16.79 FT",
        "CALL:TRAFFIC TRANSPORTATION ACCIDT",
        "SRC:WOFD",
        "UNIT:20B");

    doTest("T5",
        "CAD:1612 RIGGS RD;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C",
        "ADDR:1612 RIGGS RD",
        "CALL:TRAFFIC TRANSPORTATION ACCIDT",
        "SRC:WOFD",
        "UNIT:20C");

    doTest("T6",
        "CAD:100 VANCE LN/RIGGS RD;DIST: 158.12 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C",
        "ADDR:100 VANCE LN & RIGGS RD",
        "MADDR:100 VANCE LN",
        "PLACE:DIST: 158.12 FT",
        "CALL:TRAFFIC TRANSPORTATION ACCIDT",
        "SRC:WOFD",
        "UNIT:20C");

    doTest("T7",
        "CAD:485 OLD 30 RD;MORTON ELEMENTARY;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20D",
        "ADDR:485 OLD 30 RD",
        "PLACE:MORTON ELEMENTARY",
        "CALL:TRAFFIC TRANSPORTATION ACCIDT",
        "SRC:WOFD",
        "UNIT:20D");

    doTest("T8",
        "CAD:227 MIDDLE RIDGE DR;ALARMS;HFD;8D",
        "ADDR:227 MIDDLE RIDGE DR",
        "CALL:ALARMS",
        "SRC:HFD",
        "UNIT:8D");

    doTest("T9",
        "CAD:100 BELGRADE SWANSBORO RD/FREEDOM WAY;DIST: 235.62 FT;STRUCTURE FIRE;SFD;17A",
        "ADDR:100 BELGRADE SWANSBORO RD & FREEDOM WAY",
        "MADDR:100 BELGRADE SWANSBORO RD",
        "PLACE:DIST: 235.62 FT",
        "CALL:STRUCTURE FIRE",
        "SRC:SFD",
        "UNIT:17A");

    doTest("T10",
        "CAD:1000 YORKTOWN LN;LIBERTY POINTE APARTMENTS;STRUCTURE FIRE;PGFD;11B",
        "ADDR:1000 YORKTOWN LN",  // Piney Green Rd??
        "PLACE:LIBERTY POINTE APARTMENTS",
        "CALL:STRUCTURE FIRE",
        "SRC:PGFD",
        "UNIT:11B");
 }
  

  public static void main(String[] args) {
    new NCOnslowCountyParserTest().generateTests("T1");
  }
}
