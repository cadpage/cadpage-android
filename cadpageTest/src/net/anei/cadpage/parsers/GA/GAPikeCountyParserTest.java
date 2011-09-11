package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class GAPikeCountyParserTest extends BaseParserTest {
  
  public GAPikeCountyParserTest() {
    setParser(new GAPikeCountyParser(), "PIKE COUNTY", "GA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "PIKE COUNTY E-911:10-52R EMS/ RESPONDER 11794 HIGHWAY 109 7705673249 ADAMS RD",
        "CALL:10-52R EMS/RESPONDER",
        "ADDR:11794 HIGHWAY 109",
        "PHONE:7705673249",
        "X:ADAMS RD");

    doTest("T2",
        "PIKE COUNTY E-911:10-50I ACCIDENT WITH INJURIES CONCORD RD AT BOTTOMS RD 7066013339",
        "CALL:10-50I ACCIDENT WITH INJURIES",
        "ADDR:CONCORD RD & BOTTOMS RD",
        "PHONE:7066013339");

    doTest("T3",
        "PIKE COUNTY E-911:FIRALM FIRE ALARM 1489 EPPINGER BRIDGE RD 8005441104 HARRIS ST",
        "CALL:FIRALM FIRE ALARM",
        "ADDR:1489 EPPINGER BRIDGE RD",
        "PHONE:8005441104",
        "X:HARRIS ST");

    doTest("T4",
        "PIKE COUNTY E-911:10-50I ACCIDENT WITH INJURIES CONCORD ST @ FRANKLIN ST 770",
        "CALL:10-50I ACCIDENT WITH INJURIES",
        "ADDR:CONCORD ST & FRANKLIN ST");

    doTest("T5",
        "PIKE COUNTY E-911:FIRSTR STRUCTURE FIRE INDUSTRIAL DRIVE/VERY END 770",
        "CALL:FIRSTR STRUCTURE FIRE",
        "ADDR:INDUSTRIAL DRIVE",
        "PLACE:VERY END");

    doTest("T6",
        "PIKE COUNTY E-911:FIRVEH VEHICLE FIRE 5277 BLANTON MILL RD 6785720068 BEEKS RD",
        "CALL:FIRVEH VEHICLE FIRE",
        "ADDR:5277 BLANTON MILL RD",
        "PHONE:6785720068",
        "X:BEEKS RD");

    doTest("T7",
        "PIKE COUNTY E-911:FIRE FIRE GENERIC (TYPE) HIGHWAY 362 AREA OF CONCORD RD 3345591717",
        "CALL:FIRE FIRE GENERIC (TYPE)",
        "ADDR:HIGHWAY 362",
        "PLACE:AREA OF CONCORD RD",
        "PHONE:3345591717");
    
  }
  
  public static void main(String[] args) {
    new GAPikeCountyParserTest().generateTests("T1", "CALL ADDR PLACE PHONE X");
  }
}
