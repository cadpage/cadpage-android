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
        "MADDR:METRO NORTH MECHANICAL SHOP,PROSPECT HILL RD",
        "SRC:11",
        "INFO:GENERAL");
    
    doTest("T4",
        "TRAFFIC/TRANSPORTATION ACCIDEN||I 684  N STA 11 XS I-84  E|NARR MVA W/ INJURIES- FEMALE SUBJECT COMPLAINING OF NECK AND BACK PAIN",
        "CALL:TRAFFIC/TRANSPORTATION ACCIDEN",
        "ADDR:I 684  N",
        "MADDR:I 684  N & I 84  E",
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

    doTest("T8",
        ".... (17 Lake Carmel) BREATHING PROBLEMS||78 DREW RD  STA 17 XS  |NARR PROQA SUMMARY:CHARLIE 06C01 BREATHING PROBLEMS PATIENT WITH BREATHING PROBLEMS.  93-YEAR-OLD MALE, CONSCIOUS AND BREATHING.",
        "CALL:BREATHING PROBLEMS",
        "ADDR:78 DREW RD",
        "SRC:17",
        "INFO:PROQA SUMMARY:CHARLIE 06C01 BREATHING PROBLEMS PATIENT WITH BREATHING PROBLEMS.  93-YEAR-OLD MALE, CONSCIOUS AND BREATHING.");

    doTest("T9",
        ".... (17 Lake Carmel) UNCONSCIOUS/FAINTING (NEAR)||18 STANLEY CT  STA 17 XS DEAD END /MINELLO DR|NARR PROQA SUMMARY:ALPHA 31A01 FALLS PATIENT IS UNCONSCIOUS (OR HAS FAINTED). THE PATIENT  IS A 71-YEAR-OLD MALE, CONSCIOUS AND BREATHING.",
        "CALL:UNCONSCIOUS/FAINTING (NEAR)",
        "ADDR:18 STANLEY CT",
        "SRC:17",
        "X:DEAD END /MINELLO DR",
        "INFO:PROQA SUMMARY:ALPHA 31A01 FALLS PATIENT IS UNCONSCIOUS (OR HAS FAINTED). THE PATIENT  IS A 71-YEAR-OLD MALE, CONSCIOUS AND BREATHING.");

    doTest("T10",
        ".... (31 Carmel VAC) TRANSFER/INTERFACILITY|PHC| 670 STONELEIGH AV,CARMEL |STA 12 XS VISTA ON THE LAKE /ALEXANDRA CT",
        "CALL:TRANSFER/INTERFACILITY",
        "PLACE:PHC",
        "ADDR:670 STONELEIGH AV",
        "MADDR:670 STONELEIGH AVE",
        "CITY:CARMEL",
        "SRC:12",
        "X:VISTA ON THE LAKE /ALEXANDRA CT");

    doTest("T11",
        "(11 Brewster) PSYCHIATRIC/ABNORMAL BEHAVIOR|PUTNAM AVENUE APARTMENTS| 34 PUTNAM AV,BREWSTER |APT C2 |STA 11 XS EAGLES RIDGE  RD/PUTNAM TERR|NARR WPH1-NE",
        "CALL:PSYCHIATRIC/ABNORMAL BEHAVIOR",
        "PLACE:PUTNAM AVENUE APARTMENTS",
        "ADDR:34 PUTNAM AV",
        "MADDR:34 PUTNAM AVE",
        "CITY:BREWSTER",
        "APT:C2",
        "SRC:11",
        "X:EAGLES RIDGE  RD/PUTNAM TERR",
        "INFO:WPH1-NE");

    doTest("T12",
        " 1 of 2\n" +
        "FRM:messaging@iamresponding.com\n" +
        "SUBJ:23 Putnam Lake\n" +
        "MSG:DRILL|| 112 OLD ROUTE 6,CARMEL |STA 12 XS ROUTE 6 /HUGHSON RD|NARR CHILD SAFEYT\n" +
        "(Con' 2 of 2\n" +
        "EXPO PERSON: (COMPLAINANT) (FMLS)   BUREAU OF EMERGENCY SERVICES\r\n" +
        "(End)",

        "CALL:DRILL",
        "ADDR:112 OLD ROUTE 6",
        "CITY:CARMEL",
        "SRC:12",
        "X:ROUTE 6 /HUGHSON RD",
        "INFO:CHILD SAFEYT EXPO PERSON: (COMPLAINANT) (FMLS)   BUREAU OF EMERGENCY SERVICES");

    doTest("T13",
        "Subject:17 Lake Carmel\n" +
        "SMOKE INVESTIGATION|| 17 EMERSON RD,KENT |STA 17 XS TICONDEROGA  RD/BALDWIN RD|NARR SMOKE INVESTIGATION/CALL\r",

        "CALL:SMOKE INVESTIGATION",
        "ADDR:17 EMERSON RD",
        "CITY:KENT",
        "SRC:17",
        "X:TICONDEROGA  RD/BALDWIN RD",
        "INFO:SMOKE INVESTIGATION/CALL");
 
  }
  
  public static void main(String[] args) {
    new NYPutnamCountyParserTest().generateTests("T1", "CALL PLACE ADDR CITY SRC X INFO");
  }
}