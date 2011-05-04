package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCRutherfordCountyParserTest extends BaseParserTest {
  
  public NCRutherfordCountyParserTest() {
    setParser(new NCRutherfordCountyParser(), "RUTHERFORD COUNTY", "NC");
  }
  
  @Test
  public void testParser() {
    
    
  }

public static void main(String[] args) {
    new NCRutherfordCountyParserTest().generateTests("T1");
  }

}