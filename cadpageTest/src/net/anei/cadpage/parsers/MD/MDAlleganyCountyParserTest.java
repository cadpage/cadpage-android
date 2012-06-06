package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDAlleganyCountyParser;

import org.junit.Test;


public class MDAlleganyCountyParserTest extends BaseParserTest {
  
  public MDAlleganyCountyParserTest() {
    setParser(new MDAlleganyCountyParser(), "ALLEGANY COUNTY", "MD");
  }
  
  @Test
  public void testParser1() {

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
  
  @Test
  public void testParser2() {

    doTest("T1",
        "S:CAD M:15:31 #058516 BEHAVORIAL EMERGENCY 20960 MARYLAND HW  BOX:F3601 DUE:CO36 A351 M512\n\n",
        "TIME:15:31",
        "ID:058516",
        "CALL:BEHAVORIAL EMERGENCY",
        "ADDR:20960 MARYLAND HW",
        "MADDR:20960 MARYLAND HWY",
        "BOX:F3601",
        "UNIT:CO36 A351 M512");

  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "S:CAD M:03:16 #024484 BREATHING DIFFICULTY 12030 IRIS AVE SW  BOX:F0801 DUE:A396\n\n",
        "TIME:03:16",
        "ID:024484",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:12030 IRIS AVE SW",
        "BOX:F0801",
        "UNIT:A396");

  }
  
  public static void main(String[] args) {
    new MDAlleganyCountyParserTest().generateTests("T1");
  }
}