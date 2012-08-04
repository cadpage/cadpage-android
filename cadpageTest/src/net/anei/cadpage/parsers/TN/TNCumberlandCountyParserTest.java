package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TNCumberlandCountyParserTest extends BaseParserTest {
  
  public TNCumberlandCountyParserTest() {
    setParser(new TNCumberlandCountyParser(), "CUMBERLAND COUNTY", "TN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(E911) FIRE ALARM/10-72A\r\n115 HUNTINGTON DR\r\nKEY PAD ALARM",
        "CALL:FIRE ALARM/10-72A",
        "ADDR:115 HUNTINGTON DR",
        "INFO:KEY PAD ALARM");

    doTest("T2",
        "(E911) FIRE ALARM/10-72A\r\nSTONEHENGE DR\r\nGENERAL/COMMERCIAL BUILDING SYSTEMS/800-877-3624",
        "CALL:FIRE ALARM/10-72A",
        "ADDR:STONEHENGE DR",
        "INFO:GENERAL/COMMERCIAL BUILDING SYSTEMS/800-877-3624");

    doTest("T3",
        "(E911) MVA-INJ/10-46\r\nPEAVINE RD BY ACE HARDWARE\r\nJUV COMPLAINING OF CHEST PAINS , 2 VEHS",
        "CALL:MVA-INJ/10-46",
        "ADDR:PEAVINE RD BY ACE HARDWARE",
        "INFO:JUV COMPLAINING OF CHEST PAINS , 2 VEHS");

  }
  

  public static void main(String[] args) {
    new TNCumberlandCountyParserTest().generateTests("T1");
  }
}
