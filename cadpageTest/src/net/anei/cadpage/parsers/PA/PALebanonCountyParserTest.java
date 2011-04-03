package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PALebanonCountyParserTest extends BaseParserTest {
  
  public PALebanonCountyParserTest() {
    setParser(new PALebanonCountyParser(), "LEBANON COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

  }
  
  public static void main(String[] args) {
    new PALebanonCountyParserTest().generateTests("T1", "CITY ADDR APT PLACE CALL BOX UNIT");
  }
}
