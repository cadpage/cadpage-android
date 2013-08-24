package net.anei.cadpage.parsers.NC;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/* 
Davidson County, NC
*/

@RunWith(Enclosed.class)
public class NCDavidsonCountyParserTest {
  
  public static class TestA extends NCDavidsonCountyAParserTest {
    public TestA() {
      setParser(new NCDavidsonCountyParser());
    }
  }
  
  public static class TestB extends NCDavidsonCountyBParserTest {
    public TestB() {
      setParser(new NCDavidsonCountyParser());
    }
  }
}