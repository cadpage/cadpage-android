package net.anei.cadpage.parsers.general;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class GeneralAlertParserTest extends BaseParserTest {
  
  public GeneralAlertParserTest() {
    setParser(new GeneralAlertParser(), "", "");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "  REMOVE EXTRANEOUS          BLANKS \nFROM ALERT MSG ",
        "CALL:GENERAL ALERT",
        "PLACE:REMOVE EXTRANEOUS   BLANKS\nFROM ALERT MSG");
    
    doTest("T2",
        "(TEST SUBJECT) LONG MESSAGE",
        "CALL:GENERAL ALERT",
        "PLACE:(TEST SUBJECT) LONG MESSAGE");

  }
}