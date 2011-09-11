package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.IL.ILMedstarParser;

import org.junit.Test;


public class ILMedstarParserTest extends BaseParserTest {
  
  public ILMedstarParserTest() {
    setParser(new ILMedstarParser(), "", "IL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[- part 1 of 1]  RC:Run# 34870/64 WEST BOUND//across from weight station/////male subj white car hit by a truck isp en route/<PROQA_DET>",
        "ID:34870",
        "ADDR:64 WEST BOUND",
        "CALL:across from weight station / male subj white car hit by a truck isp en route");
    
    doTest("T2",
        "[- part 1 of 1]  RC:Run# 34859/505 LEMANS WAY///SCC PG 15/FAIRVIEW HEIGHTS///55yof unc diff b possible overdose on pills - adavan tramadol/<PROQA_DET>",
        "ID:34859",
        "ADDR:505 LEMANS WAY",
        "MAP:15",
        "CITY:FAIRVIEW HEIGHTS",
        "CALL:55yof unc diff b possible overdose on pills - adavan tramadol");
    
    doTest("T3",
        "[- part 1 of 1]  RC:Run# 34577/20 KINDER ST//cah/SCC PG 11/EAST SAINT LOUIS///31f c/b chest and back px cardiac hx  ProQA comments: chest px/10D04",
        "ID:34577",
        "ADDR:20 KINDER ST",
        "MAP:11",
        "CITY:EAST SAINT LOUIS",
        "CALL:31f c / b chest and back px cardiac hx");
    
    doTest("T4",
        "[- part 1 of 1]  RC:Run# 34384/1308 CORLISS//westinghouse and n greenmount//SHILO///38m c/b rapid heart rate/<PROQA_DET>",
        "ID:34384",
        "ADDR:1308 CORLISS",
        "X:westinghouse and n greenmount",
        "CITY:SHILO",
        "CALL:38m c / b rapid heart rate");
    
    doTest("T5",
        "[- part 1 of 1]  RC:Run# 34620/13 LOISEL DR///SCC PG 14/EAST SAINT LOUIS///70 M C/B CONFUSED ProQA comments: UNK/31D03",
        "ID:34620",
        "ADDR:13 LOISEL DR",
        "MAP:14",
        "CITY:EAST SAINT LOUIS",
        "CALL:70 M C / B CONFUSED");
    
    doTest("T6",
        "(- part 1 of 1) RC:Run# 35456/STATE HWY 157 & STATE HWY 15//Centerville/SCC PG 13/EAST SAINT LOUIS///pedestian struck/<PROQA_DET>",
        "ID:35456",
        "ADDR:STATE HWY 157 & STATE HWY 15",
        "X:Centerville",
        "MAP:13",
        "CITY:EAST SAINT LOUIS",
        "CALL:pedestian struck");

    doTest("T7",
        "1 of 2\nFRM:emsdispatch@medstarems.net\nSUBJ:- part 1 of 1\nMSG:RC:Run# 17158/St Elizabeths B'vll/IN PATIENT/347-2/SCC PG26/BELLEVILLE/429 S MAIN\n(Con't) 2 of 2\nST//CONFUSED POSS COMBATIVE NSE PCS AND FACESHEET REQ ***MEDICARE****\n(End)",
        "ID:17158",
        "ADDR:St Elizabeths B'vll",
        "CITY:IN PATIENT",
        "CALL:347-2 / SCC PG26 / BELLEVILLE / 429 S MAIN ST / CONFUSED POSS COMBATIVE NSE PCS AND FACESHEET REQ ***MEDICARE****");

    doTest("T8",
        "RC:Run# 17411/451 3RD ST////BECKEMEYER///ST ANTHONY'S CHURCH  75YOM UNC/BREATHING NURSE ON SCENE ProQA comme",
        "ID:17411",
        "ADDR:451 3RD ST",
        "CITY:BECKEMEYER",
        "CALL:ST ANTHONY'S CHURCH  75YOM UNC / BREATHING NURSE ON SCENE ProQA comme");
   
  }
  
  public static void main(String[] args) {
    new ILMedstarParserTest().generateTests("T8", "ID ADDR X MAP CITY CALL");
  }
}