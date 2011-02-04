package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDCarolineCountyParser;

import org.junit.Test;


public class MDCarolineCountyParserTest extends BaseParserTest {
  
  public MDCarolineCountyParserTest() {
    setParser(new MDCarolineCountyParser(), "CAROLINE COUNTY", "MD");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "(Chief ALT) [PM13] 26 A-Sick Person -- 520 Kerr Ave Denton - XSts: Dead End / Daffin Ln",
        "SRC:PM13",
        "CALL:26 A-Sick Person",
        "ADDR:520 Kerr Ave",
        "CITY:Denton",
        "X:Dead End / Daffin Ln");
    
    doTest("T2",
        "(Chief ALT) [200 Fire] Wires Down -- 22542 Dover Bridge Rd Preston - XSts: Poplar Neck Rd, Tanyard Rd / Bethlehem Rd",
        "SRC:200 Fire",
        "CALL:Wires Down",
        "ADDR:22542 Dover Bridge Rd",
        "CITY:Preston",
        "X:Poplar Neck Rd, Tanyard Rd / Bethlehem Rd");
    
    doTest("T3",
        "(Chief ALT) [200 Fire] 17 A-Falls -- 21182 Marsh Creek Rd Preston - XSts: Frazier Neck Rd / Bethlehem Rd",
        "SRC:200 Fire",
        "CALL:17 A-Falls",
        "ADDR:21182 Marsh Creek Rd",
        "CITY:Preston",
        "X:Frazier Neck Rd / Bethlehem Rd");
  }
}