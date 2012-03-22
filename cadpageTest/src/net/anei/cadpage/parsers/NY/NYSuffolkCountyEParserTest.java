package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYSuffolkCountyEParserTest extends BaseParserTest {
  
  public NYSuffolkCountyEParserTest() {
    setParser(new NYSuffolkCountyEParser(), "SUFFOLK COUNTY", "NY");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "(FROM RELAY) 33 BAY RUN OFF OF HERRICKS LN JAMESPORT\nELDERLY MALE SICK",
        "ADDR:33 BAY RUN",
        "X:HERRICKS LN",
        "CITY:JAMESPORT",
        "INFO:ELDERLY MALE SICK");

    doTest("T2",
        "(FROM RELAY) 415 OSTRANDER AVE, INJURY FROM A FALL",
        "ADDR:415 OSTRANDER AVE",
        "INFO:INJURY FROM A FALL");

    doTest("T3",
        "(FROM RELAY) 95 OSTRANDER AVE, DIFFICULTY BREATHING",
        "ADDR:95 OSTRANDER AVE",
        "INFO:DIFFICULTY BREATHING");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "(FROM RELAY) 236 MAIN RD AQUEBOGUE; DIRECTLY ACROSS FROM FEDUN REALITY 92 Y/O FEMALE \nCHEST PAINS",
        "ADDR:236 MAIN RD",
        "CITY:AQUEBOGUE",
        "INFO:DIRECTLY ACROSS FROM FEDUN REALITY 92 Y / O FEMALE CHEST PAINS");

    doTest("T2",
        "(FROM RELAY) 2185 SPLISH SPLASH DRIVE FEMALE POSSIBLE STROKE",
        "ADDR:2185 SPLISH SPLASH DRIVE",
        "INFO:FEMALE POSSIBLE STROKE");

    doTest("T3",
        "(FROM RELAY) 178  PECONIC BAY BLVD IN AQUEBOGUE   AT THE  REEVE RESIDENCE SUBJECT \nSEIZURES",
        "ADDR:178 PECONIC BAY BLVD",
        "CITY:AQUEBOGUE",
        "INFO:AT THE REEVE RESIDENCE SUBJECT SEIZURES");

    doTest("T4",
        "(FROM RELAY) 1053 OLD COUNTRY RD PEARLE VISION CENTER  FEMALE HEAD INJURY FROM A FALL",
        "ADDR:1053 OLD COUNTRY RD",
        "INFO:PEARLE VISION CENTER FEMALE HEAD INJURY FROM A FALL");

    doTest("T5",
        "(FROM RELAY) 70 SCHULTZ RD MALE HEAD INJURY FROM A FALL ,, ACROSS FROM THE SPORTSMAN \nKENNEL IN MANORVILLE",
        "ADDR:70 SCHULTZ RD",
        "INFO:MALE HEAD INJURY FROM A FALL ACROSS FROM THE SPORTSMAN KENNEL IN MANORVILLE");

    doTest("T6",
        "(FROM RELAY) 1272 EAST MAIN ST  DR. BROOK'S OFC  MALE  FAINTING EPISODES",
        "ADDR:1272 EAST MAIN ST",
        "INFO:DR BROOK'S OFC MALE FAINTING EPISODES");

    doTest("T7",
        "(MSG FROM RELAY) MICHAEL'S 1440 OLD COUNTRY RD. FEMALE. GENERAL WEAKNESS.",
        "PLACE:MICHAEL'S",
        "ADDR:1440 OLD COUNTRY RD",
        "INFO:FEMALE GENERAL WEAKNESS");
    
  }
  
  public static void main(String[] args) {
    new NYSuffolkCountyEParserTest().generateTests("T1", "PLACE ADDR APT CITY INFO");
  }

}