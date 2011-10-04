package net.anei.cadpage.parsers.NY;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



@RunWith(Enclosed.class)
public class NYMonroeCountyParserTest {
  
  public static class TestRuralMetro extends NYMonroeCountyRuralMetroParserTest {
    public TestRuralMetro() {
      setParser(new NYMonroeCountyParser());
    }
  }
  
  public static class TestWebster extends NYMonroeCountyWebsterParserTest {
    public TestWebster() {
      setParser(new NYMonroeCountyParser());
    }
  }
  
}