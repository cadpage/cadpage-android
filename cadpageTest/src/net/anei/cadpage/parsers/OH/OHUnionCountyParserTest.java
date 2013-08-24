package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Union County, OH
Contact: "Daniel Boone Sr." <daniel.boonesr@gmail.com>
Sender: idnetworks@co.union.oh.us

FIRE, 121 E BLAGROVE ST 1/2 RICHWOOD, BEATTY AVE,RICHWOOD//N CLINTON ST,RICHWOOD,\n
HEART PROBLEMS, 10535 MAPLE DELL RD MARYSVILLE, STATE ROUTE 37,MARYSVILLE//, 53 YOF POSS HEART\n
FALL/BACK INJURY, 85 ROSE ST MAGNETIC SPRINGS, W CATHERINE ST,MAGNETIC SPRINGS//W MAGNETIC ST,MAGNETIC SPRINGS, DALE FAGG FELL AND HI
DIFFICULTY BREATHING, 14936 MILLER RD RICHWOOD, MCMILLEN RD,RICHWOOD//SNARE RD,RICHWOOD, 74 YO DB\n

 */

public class OHUnionCountyParserTest extends BaseParserTest {
  
  public OHUnionCountyParserTest() {
    setParser(new OHUnionCountyParser(), "UNION COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FIRE, 121 E BLAGROVE ST 1/2 RICHWOOD, BEATTY AVE,RICHWOOD//N CLINTON ST,RICHWOOD,\n",
        "CALL:FIRE",
        "ADDR:121 E BLAGROVE ST 1/2",
        "CITY:RICHWOOD",
        "X:BEATTY AVE & N CLINTON ST");

    doTest("T2",
        "HEART PROBLEMS, 10535 MAPLE DELL RD MARYSVILLE, STATE ROUTE 37,MARYSVILLE//, 53 YOF POSS HEART\n",
        "CALL:HEART PROBLEMS",
        "ADDR:10535 MAPLE DELL RD",
        "CITY:MARYSVILLE",
        "X:STATE ROUTE 37",
        "INFO:53 YOF POSS HEART");

    doTest("T3",
        "FALL/BACK INJURY, 85 ROSE ST MAGNETIC SPRINGS, W CATHERINE ST,MAGNETIC SPRINGS//W MAGNETIC ST,MAGNETIC SPRINGS, DALE FAGG FELL AND HI",
        "CALL:FALL/BACK INJURY",
        "ADDR:85 ROSE ST",
        "CITY:MAGNETIC SPRINGS",
        "X:W CATHERINE ST & W MAGNETIC ST",
        "INFO:DALE FAGG FELL AND HI");

    doTest("T4",
        "DIFFICULTY BREATHING, 14936 MILLER RD RICHWOOD, MCMILLEN RD,RICHWOOD//SNARE RD,RICHWOOD, 74 YO DB\n",
        "CALL:DIFFICULTY BREATHING",
        "ADDR:14936 MILLER RD",
        "CITY:RICHWOOD",
        "X:MCMILLEN RD & SNARE RD",
        "INFO:74 YO DB");
      
  }
  
  public static void main(String[] args) {
    new OHUnionCountyParserTest().generateTests("T1");
  }
}