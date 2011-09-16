package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHOxfordParserTest extends BaseParserTest {
  
  public OHOxfordParserTest() {
    setParser(new OHOxfordParser(), "OXFORD", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Ct:MED:ENTRAPMENT  Loc:11 S POPLAR ST               Apt:      XSt:HIGH ST WALNUT ST               Grid:1604 Units:NO19                                      Rmk:",
        "CALL:MED:ENTRAPMENT",
        "ADDR:11 S POPLAR ST",
        "X:HIGH ST WALNUT ST",
        "MAP:1604",
        "UNIT:NO19");

    doTest("T2",
        "Ct:FD: FIRE ALARM  Loc:5201 COLLEGE CORNER PKe      Apt:219   XSt:                                Grid:4300 Units:M11                                       Rmk:",
        "CALL:FD: FIRE ALARM",
        "ADDR:5201 COLLEGE CORNER PKe",
        "APT:219",
        "MAP:4300",
        "UNIT:M11");

    doTest("T3",
        "Ct:MED:EMERGENCY   Loc:CHESTNUT ST/MAIN ST          Apt:      XSt:                                Grid:3116 Units:E11   M11                                 Rmk:",
        "CALL:MED:EMERGENCY",
        "ADDR:CHESTNUT ST & MAIN ST",
        "MAP:3116",
        "UNIT:E11 M11");

    doTest("T4",
        "Ct:PD: INJ CRASH   Loc:CHURCH ST/COLLEGE AV         Apt:      XSt:                                Grid:2535 Units:LO49  LO57                                Rmk:",
        "CALL:PD: INJ CRASH",
        "ADDR:CHURCH ST & COLLEGE AV",
        "MAP:2535",
        "UNIT:LO49 LO57");

    doTest("T5",
        "Ct:FD: OTHER       Loc:5980 WILMINGTON PIKE         Apt:      XSt:CLYO RD         WILMINGTON PIKE Grid:6590 Units:C10                                       Rmk:",
        "CALL:FD: OTHER",
        "ADDR:5980 WILMINGTON PIKE",
        "X:CLYO RD & WILMINGTON PIKE",
        "MAP:6590",
        "UNIT:C10");
            
  }
  
  public static void main(String[] args) {
    new OHOxfordParserTest().generateTests("T1", "CALL ADDR APT X MAP UNIT");
  }
}
