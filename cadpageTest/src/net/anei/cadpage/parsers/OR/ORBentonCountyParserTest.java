package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.OR.ORBentonCountyParser;

import org.junit.Test;


public class ORBentonCountyParserTest extends BaseParserTest {
  
  public ORBentonCountyParserTest() {
    setParser(new ORBentonCountyParser(), "BENTON COUNTY", "OR");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "(Corvallis Alert) INC: CODE 1 MEDICAL\nADD:1740 MAIN ST\nAPT:\nCITY:PHILOMATH\nX:N 17TH ST * N 18TH ST\nMAP:540-365\nCFS:0907010-119\nDIS:PHILOMATH FIRE",
        "CALL:CODE 1 MEDICAL",
        "ADDR:1740 MAIN ST",
        "CITY:PHILOMATH",
        "X:N 17TH ST * N 18TH ST",
        "MAP:540-365",
        "ID:0907010-119");

    doTest("T2",
        "(Corvallis Alert) INC:COMM FIRE ALARM\nADD:421 S 19TH ST\nAPT:\nCITY:PHILOMATH\nX:ASH ST * CEDAR ST\nMAP:540-360\nCFS:100410-188\nDIS:PHILOMATH FIRE\nDIS:PHI",
        "CALL:COMM FIRE ALARM",
        "ADDR:421 S 19TH ST",
        "CITY:PHILOMATH",
        "X:ASH ST * CEDAR ST",
        "MAP:540-360",
        "ID:100410-188");
    
    doTest("T3",
        "(Corvallis Alert) INC:UNKNOWN MEDICAL\nADD:504 MELVILL CRESCENT AV [PHILOMATH]\nAPT:\nCITY:PHILOMATH\nX:SUNSHINE AV\nMAP:550-385\nCFS:101710-223\nDIS:PHILOM",
        "CALL:UNKNOWN MEDICAL",
        "ADDR:504 MELVILL CRESCENT",
        "CITY:PHILOMATH",
        "X:SUNSHINE AV",
        "MAP:550-385",
        "ID:101710-223");

    doTest("T4",
        "(Corvallis Alert) INC:BICYCLE ACCIDENT\nADD:DECKER RD and DECKER RIDGE RD\nAPT:\nCITY:PHILOMATH\nX:DECKER RD * BANKS LN\nMAP:480-420\nCFS:070611-52\nDIS:BEN",
        "CALL:BICYCLE ACCIDENT",
        "ADDR:DECKER RD and DECKER RIDGE RD",
        "MADDR:DECKER RD & DECKER RIDGE RD",
        "X:DECKER RD * BANKS LN",
        "MAP:480-420",
        "ID:070611-52");
    
  }
  
  public static void main(String args[]) {
    new ORBentonCountyParserTest().generateTests("T4", "CALL ADDR CITY X MAP ID");
  }
}