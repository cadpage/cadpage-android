package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDAlleganyCountyParser;

import org.junit.Test;


public class MDAlleganyCountyParserTest extends BaseParserTest {
  
  public MDAlleganyCountyParserTest() {
    setParser(new MDAlleganyCountyParser(), "ALLEGANY COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "S:CAD M:CT:BREATHING DIFFICULTY 100 BRADDOCK HTS APT 105  BOX:F1601 DUE:A355\n\n",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:100 BRADDOCK HTS",
        "APT:105",
        "BOX:F1601",
        "UNIT:A355");

    doTest("T2",
        "FRM:acgov_911_cad@allconet.org\nSUBJ:CAD\nMSG:CT:BREATHING DIFFICULTY 100 BRADDOCK HTS APT 105  BOX:F1601 DUE:A355",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:100 BRADDOCK HTS",
        "APT:105",
        "BOX:F1601",
        "UNIT:A355");

    doTest("T3",
        "FRM:acgov_911_cad@allconet.org\nSUBJ:CAD\nMSG:CT:CHEST PAINS, HEART FROSTBURG VILLAGE NURSING HOME  1 KAYLOR CIR  BOX:F1602 DUE:A364\n\n",
        "CALL:CHEST PAINS, HEART FROSTBURG VILLAGE NURSING HOME",
        "ADDR:1 KAYLOR CIR",
        "BOX:F1602",
        "UNIT:A364");
 }
  
  public static void main(String[] args) {
    new MDAlleganyCountyParserTest().generateTests("T1");
  }
}