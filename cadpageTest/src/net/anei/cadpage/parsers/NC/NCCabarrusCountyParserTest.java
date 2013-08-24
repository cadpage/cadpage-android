package net.anei.cadpage.parsers.NC;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/* 
Cabarrus County, NC
*/

@RunWith(Enclosed.class)
public class NCCabarrusCountyParserTest {
  
  public static class TestA extends NCCabarrusCountyAParserTest {
    public TestA() {
      setParser(new NCCabarrusCountyParser());
    }
  }
  
  public static class TestB extends NCCabarrusCountyBParserTest {
    public TestB() {
      setParser(new NCCabarrusCountyParser());
    }
  }
}