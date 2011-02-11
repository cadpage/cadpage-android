package net.anei.cadpage.parsers.MD;


import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PAArmstrongCountyParser;

import org.junit.Test;

public class MDCharlesCountyParserTest extends BaseParserTest {
  
  public MDCharlesCountyParserTest() {
    setParser(new PAArmstrongCountyParser(), "CHARLES COUNTY", "MD");
  }
  
  @Test
  public void testParser() {
  
  }
  
public static void main(String[] args) {
  new MDCharlesCountyParserTest().generateTests("T1", "CALL ADDR INFO");
}

}