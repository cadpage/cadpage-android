package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCIredellCountyParserTest extends BaseParserTest {
  
  public NCIredellCountyParserTest() {
    setParser(new NCIredellCountyParser(), "IREDELL COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FD20 C-5 FIRE ALARM, 347 JENNINGS RD",
        "SRC:FD20",
        "CALL:C-5 FIRE ALARM",
        "ADDR:347 JENNINGS RD");

    doTest("T2",
        "FR200 FALL, HAWKS RD",
        "SRC:FR200",
        "CALL:FALL",
        "ADDR:HAWKS RD");

    doTest("T3",
        "FD20 C-36 STAND BY AT BASE, 641 MOCKSVILLE HWY",
        "SRC:FD20",
        "CALL:C-36 STAND BY AT BASE",
        "ADDR:641 MOCKSVILLE HWY");

    doTest("T4",
        "FR200 MEDICAL ALARM, 142 NEW MEXICO DR",
        "SRC:FR200",
        "CALL:MEDICAL ALARM",
        "ADDR:142 NEW MEXICO DR");

    doTest("T5",
        "FD20 PUBLIC SERVICE, 106 KNOLLCREST LN",
        "SRC:FD20",
        "CALL:PUBLIC SERVICE",
        "ADDR:106 KNOLLCREST LN");

    doTest("T6",
        "FRM:CommtechMessenger (emergin)\"\nMSG:MFD 2ANAPHYLACTIC SHOCK, 161 NILE CIR",
        "SRC:MFD",
        "CALL:2ANAPHYLACTIC SHOCK",
        "ADDR:161 NILE CIR");

  }
  

  public static void main(String[] args) {
    new NCIredellCountyParserTest().generateTests("T1", "SRC CALL ADDR");
  }
}
