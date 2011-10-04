package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYMonroeCountyRuralMetroParserTest extends BaseParserTest {
  
  public NYMonroeCountyRuralMetroParserTest() {
    setParser(new NYMonroeCountyRuralMetroParser(), "MONROE COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "RC:Run# 24706/300 GENESEE ST/X=Frost Ave|Superior St&Superior St///Priority 4/1A1 - ABDOMINAL PAIN/LOCI: APT 508 ENTRY: 33 YOF STOMACH PAIN HER RIGHT SIDE XST: btwn SUPERIOR ST AND",
        "ID:24706",
        "ADDR:300 GENESEE ST",
        "X:Frost Ave|Superior St&Superior St",
        "PRI:4",
        "CALL:1A1 - ABDOMINAL PAIN",
        "PLACE:APT 508",
        "INFO:33 YOF STOMACH PAIN HER RIGHT SIDE");

    doTest("T2",
        "RC:Run# 23685/16 AUSTIN DR/X=Woodcrest Dr&Penfield Rd///Priority 4/17A3 - FALL - PUBLIC ASSIST/LOCI:  ENTRY: 75 YO FEM - FELL - FROM TOILET - SLIPPED - STILL ON FLOOR - NO INJ XST:",
        "ID:23685",
        "ADDR:16 AUSTIN DR",
        "X:Woodcrest Dr&Penfield Rd",
        "PRI:4",
        "CALL:17A3 - FALL - PUBLIC ASSIST",
        "INFO:75 YO FEM - FELL - FROM TOILET - SLIPPED - STILL ON FLOOR - NO INJ");

    doTest("T3",
        "RC:Run# 20459/50 UNION SQUARE BLVD///134/Priority 3/INJURY- NON ACUTE/93 YOF FELL AND CUT ABOVE EYE....HAS BLOOD IN EYE/<Unknown>////",
        "ID:20459",
        "ADDR:50 UNION SQUARE BLVD",
        "APT:134",
        "PRI:3",
        "CALL:INJURY- NON ACUTE",
        "INFO:93 YOF FELL AND CUT ABOVE EYE....HAS BLOOD IN EYE / <Unknown>");

    doTest("T4",
        "RC:Run# 20174/4 MITCHELL ST/X=Delamaine&Barberry///Priority 1/31D3 - UNCONSCIOUS/FAINTING - NOT ALERT/LOCI:  ENTRY: 29 YO MALE PASSED OUT -NOW AWAKE-NOT ALERT XST: btwn BARBERRY TE",
        "ID:20174",
        "ADDR:4 MITCHELL ST",
        "X:Delamaine&Barberry",
        "PRI:1",
        "CALL:31D3 - UNCONSCIOUS",
        "INFO:FAINTING - NOT ALERT / 29 YO MALE PASSED OUT -NOW AWAKE-NOT ALERT");

    doTest("T5",
        "RC:Run# 20413/535 LYELL AVE/X=Warner&Mart///Priority 4/26A2 - SICK PERSON - NO PRIORITY SYMPTOMS/LOCI: 535 1~2 LYELL ENTRY: 21 MONTH OLD M - 104.3 TEMP - XST: btwn MART PL AND RR",
        "ID:20413",
        "ADDR:535 LYELL AVE",
        "X:Warner&Mart",
        "PRI:4",
        "CALL:26A2 - SICK PERSON - NO PRIORITY SYMPTOMS",
        "PLACE:535 1~2 LYELL",
        "INFO:21 MONTH OLD M - 104.3 TEMP -");
  }
  
  public static void main(String[] args) {
    new NYMonroeCountyRuralMetroParserTest().generateTests("T1");
  }
}