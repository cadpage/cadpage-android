package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.DE.DESussexCountyBParser;

import org.junit.Test;

public class DESussexCountyBParserTest extends BaseParserTest {
  
  public DESussexCountyBParserTest() {
    setParser(new DESussexCountyBParser(), "SUSEX COUNTY", "DE");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "(*CAD*) [CAD] Sta: 78AS3   Loc: 12319 Sussex Hwy   City: 19950   --- Sick Person(Specific Diag)-BLSPremise 12319 Sussex Hwy",
        "SRC:78AS3",
        "CALL:Sick Person(Specific Diag)-BLS",
        "ADDR:12319 Sussex Hwy",
        "CITY:GREENWOOD");

    doTest("T2",
        "(*CAD*) [CAD] Sta: 78AST   Loc: 7229 Seashore Hwy   --- Falls-BLS",
        "SRC:78AST",
        "CALL:Falls-BLS",
        "ADDR:7229 Seashore Hwy");

    doTest("T3",
        "(*CAD*) [CAD] Sta: 78AST   Loc: 14490 Broad Ave   City: 19950   --- Breathing Problems-ALS    Premise 14490 Broad Ave",
        "SRC:78AST",
        "CALL:Breathing Problems-ALS",
        "ADDR:14490 Broad Ave",
        "CITY:GREENWOOD");

    doTest("T4",
        "(*CAD*) [CAD] Sta: 78AST   Loc: 12404 Double Fork Rd   City: 19950   --- Medical Alert         Premise 12404 Double Fork Rd",
        "SRC:78AST",
        "CALL:Medical Alert",
        "ADDR:12404 Double Fork Rd",
        "CITY:GREENWOOD");

    doTest("T5",
        "(*CAD*) [CAD] Sta: 78AST   Loc: 16976 Sussex Hwy       Canterbury Apt   --- Chest Pain-ALS",
        "SRC:78AST",
        "CALL:Chest Pain-ALS",
        "ADDR:16976 Sussex Hwy",
        "PLACE:Canterbury Apt");

    doTest("T6",
        "(*CAD*) [CAD] Sta: 78AS3   Loc: 203 E Market St   City: 19950   --- Hemorrhage/Lacerations-BLS  Premise 203 E Market St",
        "SRC:78AS3",
        "CALL:Hemorrhage/Lacerations-BLS",
        "ADDR:203 E Market St",
        "CITY:GREENWOOD");

    doTest("T7",
        "(*CAD*) [CAD] Sta: 78AS1   Loc: 13757 Mile Stretch Rd   City: 19950   --- Stroke-ALS          Premise 13757 Mile Stretch Rd",
        "SRC:78AS1",
        "CALL:Stroke-ALS",
        "ADDR:13757 Mile Stretch Rd",
        "CITY:GREENWOOD");

    doTest("T8",
        "(*CAD*) [CAD] Sta: 78AST   Loc: 14490 Broad Ave   City: 19950   --- Breathing Problems-ALS    Premise 14490 Broad Ave",
        "SRC:78AST",
        "CALL:Breathing Problems-ALS",
        "ADDR:14490 Broad Ave",
        "CITY:GREENWOOD");

    doTest("T9",
        "(*CAD*) [CAD] Sta: 78AS2   Loc: 13757 Mile Stretch Rd   City: 19950   --- Stroke-ALS          Premise 13757 Mile Stretch Rd",
        "SRC:78AS2",
        "CALL:Stroke-ALS",
        "ADDR:13757 Mile Stretch Rd",
        "CITY:GREENWOOD");

    doTest("T10",
        "(*CAD*) [CAD] Sta: 78AST   Loc: 18029 Spellman Ln   City: 19941   --- Unknown Problem(Man Down)-BLS",
        "SRC:78AST",
        "CALL:Unknown Problem(Man Down)-BLS",
        "ADDR:18029 Spellman Ln",
        "CITY:ELLENDALE");

    doTest("T11",
        "Sta: 78AS2 Loc: 10725 Beach Hwy City: 19950 --- Traffic/TransportationAcdntALSPremise 10725 Beach Hwy",
        "SRC:78AS2",
        "CALL:Traffic/TransportationAcdntALS",
        "ADDR:10725 Beach Hwy",
        "CITY:GREENWOOD");
  
  }


public static void main(String[] args) {
  new DESussexCountyBParserTest().generateTests("T1", "SRC CALL ADDR CITY PLACE");
}
}
