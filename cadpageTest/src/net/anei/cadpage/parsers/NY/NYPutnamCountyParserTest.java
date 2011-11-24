package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYPutnamCountyParser;

import org.junit.Test;


public class NYPutnamCountyParserTest extends BaseParserTest {
  
  public NYPutnamCountyParserTest() {
    setParser(new NYPutnamCountyParser(), "PUTNAM COUNTY", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "STRUCTURE FIRE/RESIDENTIAL||34 MOUNTAIN BROOK DR  STA 11 XS MEMORIAL DR/LEONA DR|NARR WPH1-E",
        "CALL:STRUCTURE FIRE/RESIDENTIAL",
        "ADDR:34 MOUNTAIN BROOK DR",
        "SRC:11",
        "X:MEMORIAL DR/LEONA DR",
        "INFO:WPH1-E");
    
    doTest("T2",
        "CHEST PAIN||35 OAK ST  STA 11 XS HOYT  ST/MERRITT ST|NARR PROQA SUMMARY:DELTA 10D01 CHEST PAIN PATIENT WITH CHEST PAIN. 55-YEAR-OLD  FEMALE, CONSCIOUS",
        "CALL:CHEST PAIN",
        "ADDR:35 OAK ST",
        "SRC:11",
        "X:HOYT  ST/MERRITT ST",
        "INFO:PROQA SUMMARY:DELTA 10D01 CHEST PAIN PATIENT WITH CHEST PAIN. 55-YEAR-OLD  FEMALE, CONSCIOUS");
    
    doTest("T3",
        "AUTOMATIC FIRE ALARM|METRO NORTH MECHANICAL SHOP|PROSPECT HILL RD  STA 11 XS  |NARR GENERAL",
        "CALL:AUTOMATIC FIRE ALARM",
        "PLACE:METRO NORTH MECHANICAL SHOP",
        "ADDR:PROSPECT HILL RD",
        "SRC:11",
        "INFO:GENERAL");
    
    doTest("T4",
        "TRAFFIC/TRANSPORTATION ACCIDEN||I 684  N STA 11 XS I-84  E|NARR MVA W/ INJURIES- FEMALE SUBJECT COMPLAINING OF NECK AND BACK PAIN",
        "CALL:TRAFFIC/TRANSPORTATION ACCIDEN",
        "ADDR:I 684  N",
        "SRC:11",
        "X:I-84  E",
        "INFO:MVA W/ INJURIES- FEMALE SUBJECT COMPLAINING OF NECK AND BACK PAIN");
    
    doTest("T5",
        "TRAFFIC/TRANSPORTATION ACCIDEN||92 FOGGINTOWN RD  STA 11 XS FARM TO MARKET RD/HAWKS LN|NARR 1 CAR PIAA/UNK INJ PERSON: (COMPLAINANT) (FMLS) CHRISTINE",
        "CALL:TRAFFIC/TRANSPORTATION ACCIDEN",
        "ADDR:92 FOGGINTOWN RD",
        "SRC:11",
        "X:FARM TO MARKET RD/HAWKS LN",
        "INFO:1 CAR PIAA/UNK INJ PERSON: (COMPLAINANT) (FMLS) CHRISTINE");
    
    doTest("T6",
        ".... (11 Brewster) MEDIC ALERT||4100 STONECREST DR  STA 11 XS",
        "CALL:MEDIC ALERT",
        "ADDR:4100 STONECREST DR",
        "SRC:11");

    doTest("T7",
        ".... (18 Mahopac) PSYCHIATRIC/ABNORMAL BEHAVIOR||151 W SHORE DR  STA 18 XS FARVIEW  RD/STEBBINS RD|NARR MALE EDP, SCENE SECURE..",
        "CALL:PSYCHIATRIC/ABNORMAL BEHAVIOR",
        "ADDR:151 W SHORE DR",
        "SRC:18",
        "X:FARVIEW  RD/STEBBINS RD",
        "INFO:MALE EDP, SCENE SECURE..");
   
  }
  
  public static void main(String[] args) {
    new NYPutnamCountyParserTest().generateTests("T1", "CALL ADDR SRC X INFO");
  }
}