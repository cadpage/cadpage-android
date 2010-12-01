package net.anei.cadpage.parsers;

import org.junit.Test;


public class MDCarolineCountyParserTest extends BaseParserTest {
  
  public MDCarolineCountyParserTest() {
    setParser(new MDCarolineCountyParser(), "CAROLINE COUNTY", "MD");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "(Chief ALT) [PM13] 26 A-Sick Person -- 520 Kerr Ave Denton - XSts: Dead End / Daffin Ln",
        "CALL:26 A-Sick Person",
        "ADDR:520 Kerr Ave",
        "CITY:Denton",
        "X:Dead End / Daffin Ln");
    
    doTest("T2",
        "(Chief ALT) [200 Fire] Wires Down -- 22542 Dover Bridge Rd Preston - XSts: Poplar Neck Rd, Tanyard Rd / Bethlehem Rd",
        "CALL:Wires Down",
        "ADDR:22542 Dover Bridge Rd",
        "CITY:Preston",
        "X:Poplar Neck Rd, Tanyard Rd / Bethlehem Rd");
  }
}