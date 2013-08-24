package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Franklin County, PA
*/

public class PAFranklinCountyParserTest extends BaseParserTest {
  
  public PAFranklinCountyParserTest() {
    setParser(new PAFranklinCountyParser(), "FRANKLIN COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    
  }
  
  public static void main(String[] args) {
    new PAFranklinCountyParserTest().generateTests("T1");
  }
}
