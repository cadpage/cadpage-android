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

    doTest("T4",
        "(Chief ALT) [200 EMS] House Fire -- 22272 Havercamp Rd Preston - XSts: Prchal Rd / Poplar Neck Rd",
        "SRC:200 EMS",
        "CALL:House Fire",
        "ADDR:22272 Havercamp Rd",
        "CITY:Preston",
        "X:Prchal Rd / Poplar Neck Rd");

    doTest("T5",
        "(Chief ALT) [200 EMS] 23 B-Overdose / Poisoning -- 320 Park Ave Federalsburg - XSts: Railroad Ave / Academy Ave",
        "SRC:200 EMS",
        "CALL:23 B-Overdose / Poisoning",
        "ADDR:320 Park Ave",
        "CITY:Federalsburg",
        "X:Railroad Ave / Academy Ave");

    doTest("T6",
        "(Chief ALT) [200 EMS] 19 D-Heart Problems / A.i.c.d. -- 121 E Central Ave Federalsburg - XSts: Reliance Ave / N Main St, S Main St, W Central Ave",
        "SRC:200 EMS",
        "CALL:19 D-Heart Problems / A.i.c.d.",
        "ADDR:121 E Central Ave",
        "CITY:Federalsburg",
        "X:Reliance Ave / N Main St, S Main St, W Central Ave");

    doTest("T7",
        "(Chief ALT) [200 EMS] 23 D-Overdose / Poisoning -- 156 Main St Preston - XSts: Harmony Rd / Lednum Ave",
        "SRC:200 EMS",
        "CALL:23 D-Overdose / Poisoning",
        "ADDR:156 Main St",
        "CITY:Preston",
        "X:Harmony Rd / Lednum Ave");

    doTest("T8",
        "(Chief ALT) [200 EMS] 27 B-Stab/gsw/pen. Trauma -- 6181 Bethlehem Rd Preston - XSts: Harmony Rd, Gilpin Point Rd / Bell Creek Rd, Grove Rd",
        "SRC:200 EMS",
        "CALL:27 B-Stab/gsw/pen. Trauma",
        "ADDR:6181 Bethlehem Rd",
        "CITY:Preston",
        "X:Harmony Rd, Gilpin Point Rd / Bell Creek Rd, Grove Rd");

    doTest("T9",
        "(Chief ALT) [200 EMS] 04 B-Assault -- 305 Bloomingdale Ave Federalsburg - XSts: N University Ave / Hayman Dr",
        "SRC:200 EMS",
        "CALL:04 B-Assault",
        "ADDR:305 Bloomingdale Ave",
        "CITY:Federalsburg",
        "X:N University Ave / Hayman Dr");
  }
  
  public static void main(String[] args) {
    new MDCarolineCountyParserTest().generateTests("T6","SRC CALL ADDR CITY X");
  }
}