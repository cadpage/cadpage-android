package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHXenaTownshipParserTest extends BaseParserTest {
  
  public OHXenaTownshipParserTest() {
    setParser(new OHXenaTownshipParser(), "XENA", "OH");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "MBLS-MEDICAL Location: 160 RICHARD DR DAYTON XENIA RD / ROBERT LN XENIA TWP Time: 17:31 Units: M51  Common",
        "CALL:MBLS-MEDICAL",
        "ADDR:160 RICHARD DR DAYTON XENIA RD / ROBERT LN XENIA",
        "UNIT:M51  Common");
  }
  
//  public static void main(String[] args) {
//    new OHXenaTownshipParserTest().generateTests("T1");
//  }
}
