package net.anei.cadpage.parsers;

import org.junit.Test;


public class MDSaintMarysCountyParserTest extends BaseParserTest {
  
  public MDSaintMarysCountyParserTest() {
    setParser(new MDSaintMarysCountyParser(), "SAINT MARYS COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "21:10:05*Personal Injury Accident*22607 THREE NOTCH RD INTERSECTN*MACARTHUR BL*LEXINGTON PARK*CO9 CO3 SQ3 CO39 CO79 A796*N/B LANES TWO VEHICLES AT LEAST ONE INJURY*",
        "CALL:Personal Injury Accident",
        "ADDR:22607 THREE NOTCH RD & MACARTHUR BL",
        "CITY:LEXINGTON PARK",
        "UNIT:CO9 CO3 SQ3 CO39 CO79 A796",
        "INFO:N/B LANES TWO VEHICLES AT LEAST ONE INJURY");
    
    doTest("T2",
        "14:41:22*Personal Injury Accident*21050 WILLOWS RD INTERSECTN*ABBERLY CREST LN*LEXINGTON PARK*CO3 CO39 CO6R*",
        "CALL:Personal Injury Accident",
        "ADDR:21050 WILLOWS RD & ABBERLY CREST LN",
        "CITY:LEXINGTON PARK",
        "UNIT:CO3 CO39 CO6R");
    
    doTest("T3",
        "15:24:31*Working House Fire*20242 POINT LOOKOUT RD*OLD GREAT MILLS RD*INDIAN BRIDGE RD*GREAT MILLS*CO3 CO9 CO6 CO1 CO5 CO39 CO6R*",
        "CALL:Working House Fire",
        "ADDR:20242 POINT LOOKOUT RD",
        "X:OLD GREAT MILLS RD / INDIAN BRIDGE RD",
        "CITY:GREAT MILLS",
        "UNIT:CO3 CO9 CO6 CO1 CO5 CO39 CO6R");

    doTest("T4",
        "21:11:30*Commercial Building Fire*46528 VALLEY CT APT3019*SPRING VALLEY DR*DEAD END*LEXINGTON PARK*CO3 CO13 CO9 TK3 CO7 TK7 CO39*Using ProQA re*",
        "CALL:Commercial Building Fire",
        "ADDR:46528 VALLEY CT",
        "APT:APT3019",
        "X:SPRING VALLEY DR / DEAD END",
        "CITY:LEXINGTON PARK",
        "UNIT:CO3 CO13 CO9 TK3 CO7 TK7 CO39",
        "INFO:Using ProQA re");
    
    doTest("T5",
        "23:14:28*Heart Problems*22521 IVERSON DR UNIT3*AMBER DR*CUL DE SAC*CALIFORNIA*CO9*55YOF C/A/B; RAPID HEART RATE AND WEAK; HX DIABETES;*",
        "CALL:Heart Problems",
        "ADDR:22521 IVERSON DR",
        "APT:UNIT3",
        "X:AMBER DR / CUL DE SAC",
        "CITY:CALIFORNIA",
        "UNIT:CO9",
        "INFO:55YOF C/A/B; RAPID HEART RATE AND WEAK; HX DIABETES;");
    
  }
}