package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYOnondagaCountyParserTest extends BaseParserTest {
  
  public NYOnondagaCountyParserTest() {
    setParser(new NYOnondagaCountyParser(), "ONONDAGA COUNTY", "NY");
  }
  
  @Test
  public void testParser() {
  }
  
  public static void main(String[] args) {
    new NYOnondagaCountyParserTest().generateTests("T1");
  }
}