package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDCentrevilleParser;

import org.junit.Test;


public class MDCentrevilleParserTest extends BaseParserTest {
  
  public MDCentrevilleParserTest() {
    setParser(new MDCentrevilleParser(), "CENTREVILLE", "MD");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "qac911:*D 4-2 COMMERCIAL BLDG FIRE DUNKIN DONUTS @500 CHURCH HILL RD COMMERCIAL BOX Q04",
        "CALL:4-2 COMMERCIAL BLDG FIRE DUNKIN DONUTS",
        "ADDR:500 CHURCH HILL RD",
        "INFO:COMMERCIAL BOX Q04");
    
    doTest("T2",
        "qac911:*D 4-5 MVC W/ENTRAPMENT RT301NB / RT304 RESCUE BOX Q04",
        "CALL:4-5 MVC W/ENTRAPMENT",
        "ADDR:RT301 & RT304",
        "INFO:RESCUE BOX Q04");

    doTest("T3",
        "qac911:*D 5-1 LG BRUSH/GRASS FIRE RT405 / WINDSWEPT FARM LN BRUSH BOX Q05",
        "CALL:5-1 LG BRUSH/GRASS FIRE",
        "ADDR:RT405 & WINDSWEPT FARM LN",
        "INFO:BRUSH BOX Q05");
    
    doTest("T4",
        "qac911:*D 4-5 UNCONSCIOUS/FAINTING RT301NB / ROLLING BRIDGE RD UNCONSCIOUS Q04",
        "CALL:4-5 UNCONSCIOUS/FAINTING",
        "ADDR:RT301 & ROLLING BRIDGE RD",
        "INFO:UNCONSCIOUS Q04");
    
    doTest("T5",
        "qac911:*D 5-2 MVC W/ROLLOVER RT301NB / HAYDEN RD RESCUE BOX Q05",
        "CALL:5-2 MVC W/ROLLOVER",
        "ADDR:RT301 & HAYDEN RD",
        "INFO:RESCUE BOX Q05");
    
    doTest("T6",
        "qac911:*D 4-7 MVC W/ROLLOVER 1627 RUTHSBURG RD RESCUE BOX Q04",
        "CALL:4-7 MVC W/ROLLOVER",
        "ADDR:1627 RUTHSBURG RD",
        "INFO:RESCUE BOX Q04");
    
    doTest("T7",
        "(text message) qac911:*D 4-2 CO ALARM 212 NORTHFIELD WAY LOCAL BOX Q04",
        "CALL:4-2 CO ALARM",
        "ADDR:212 NORTHFIELD WAY",
        "INFO:LOCAL BOX Q04");
    
    doTest("T8",
        "(Text Message) QA911com:*D 4-1 UNKNOWN PROBLEM 206 ORCHESTRA PL LIFE STATUS ? Q04",
        "CALL:4-1 UNKNOWN PROBLEM",
        "ADDR:206 ORCHESTRA PL",
        "INFO:LIFE STATUS ? Q04");

    doTest("T9",
        "(Text Message) QA911com:*D 1-14 FALLS 1401 CALVERT RD POSS DANG BODY AREA Q01",
        "CALL:1-14 FALLS",
        "ADDR:1401 CALVERT RD",
        "INFO:POSS DANG BODY AREA Q01");

  }
  
  public static void main(String[] args) {
    new MDCentrevilleParserTest().generateTests("T10", "CALL ADDR INFO");
  }
}
