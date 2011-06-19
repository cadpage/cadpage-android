package net.anei.cadpage.parsers.FL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class FLLakeCountyParserTest extends BaseParserTest {
  
  public FLLakeCountyParserTest() {
    setParser(new FLLakeCountyParser(), "LAKE COUNTY", "FL");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "CAD:ST56* Unconscious / Fainting* 805 PLUMOSA AVENUE* FRUITLAND PARK*",
        "SRC:ST56",
        "CALL:Unconscious / Fainting",
        "ADDR:805 PLUMOSA AVENUE",
        "NAME:FRUITLAND PARK*");

    doTest("T2",
        "CAD:ST56* Miscellaneous* 303 URICK STREET* FRUITLAND ACRES* APT 4F* FRUITLAND PARK*",
        "SRC:ST56",
        "CALL:Miscellaneous",
        "ADDR:303 URICK STREET",
        "NAME:FRUITLAND PARK*",
        "APT:4F");

    doTest("T3",
        "CAD:ST56* Traffic / Transportation Accident* 305 CR 466A* CENTRAL FLORIDA NURSERY* FRUITLAND PARK*",
        "SRC:ST56",
        "CALL:Traffic / Transportation Accident",
        "ADDR:305 CR 466A",
        "NAME:FRUITLAND PARK*");

    doTest("T4",
        "CAD:ST56* Sick Person* 500 WEST FOUNTAIN STREET* FRUITLAND PARK*",
        "SRC:ST56",
        "CALL:Sick Person",
        "ADDR:500 WEST FOUNTAIN STREET",
        "NAME:FRUITLAND PARK*");

    doTest("T5",
        "CAD:PS4* ST56* Sick Person* 201 EAST LAVISTA STREET* NEW LIFE PRESBYTERIAN CHURCH* FRUITLAND PARK*",
        "CH:PS4",
        "SRC:ST56",
        "CALL:Sick Person",
        "ADDR:201 EAST LAVISTA STREET",
        "NAME:FRUITLAND PARK*");

    doTest("T6",
        "CAD:ST95* Unknown / Man Down* UNKNOWN* 1018 OSPREY CIRCLE GROVELAND*",
        "SRC:ST95",
        "CALL:Unknown / Man Down",
        "ADDR:1018 OSPREY CIRCLE GROVELAND*");
  }
  
  public static void main(String[] args) {
    new FLLakeCountyParserTest().generateTests("T7");
  }
}