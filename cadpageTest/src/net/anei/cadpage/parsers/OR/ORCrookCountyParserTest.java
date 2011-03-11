package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.OR.ORCrookCountyParser;

import org.junit.Test;


public class ORCrookCountyParserTest extends BaseParserTest {
  
  public ORCrookCountyParserTest() {
    setParser(new ORCrookCountyParser(), "CROOK COUNTY", "OR");
  }
  
  @Test
  public void testParser() {
  }
  
  public static void main(String[] args) {
    new ORCrookCountyParserTest().generateTests("T1");
  }
}