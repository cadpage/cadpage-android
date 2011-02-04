package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYJeffersonCountyParser;

import org.junit.Test;


public class NYJeffersonCountyParserTest extends BaseParserTest {
  
  public NYJeffersonCountyParserTest() {
    setParser(new NYJeffersonCountyParser(), "JEFFERSON COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "BREATHING PROBL|18077 REED POINT RD:ORLEANS(T)|77 YO MALE DIFF BREATHING",
        "CALL:BREATHING PROBL",
        "ADDR:18077 REED POINT RD",
        "CITY:ORLEANS",
        "INFO:77 YO MALE DIFF BREATHING");
    
    doTest("T2",
        "ABDOMINAL PAIN|18081 REED POINT RD:ORLEANS(T)|79F  :ProQA Medical Case Entry Finished You are responding to a patient with abdominal pain.  The patient is a  79-year-old female, who is conscious and breathing.  Abdominal Pain / Problems.  Caller Statement: ABDOMINAL PAIN.",
        "CALL:ABDOMINAL PAIN",
        "ADDR:18081 REED POINT RD",
        "CITY:ORLEANS",
        "INFO:79F  :ProQA Medical Case Entry Finished You are responding to a patient with abdominal pain.  The patient is a  79-year-old female, who is conscious and breathing.  Abdominal Pain / Problems.  Caller Statement: ABDOMINAL PAIN.");

    doTest("T3",
        "CHEST PAIN|622 JOHN ST:CLAYTON(V)|59 FEMALE/CARDIAC ISSUES",
        "CALL:CHEST PAIN",
        "ADDR:622 JOHN ST",
        "CITY:CLAYTON",
        "INFO:59 FEMALE/CARDIAC ISSUES");
    
  }
}