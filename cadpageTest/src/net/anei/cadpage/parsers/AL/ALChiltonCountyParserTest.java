package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.AL.ALChiltonCountyParserTest;

import org.junit.Test;


public class ALChiltonCountyParserTest extends BaseParserTest {
  
  public ALChiltonCountyParserTest() {
    setParser(new ALChiltonCountyParser(), "CHILTON COUNTY", "AL");
  }
  
  @Test
  public void testParser() {

 

  }
  
  public static void main(String[] args) {
    new ALChiltonCountyParserTest().generateTests("T1", "ADDR CITY ID CALL INFO");
  }
}