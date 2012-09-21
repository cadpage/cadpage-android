package net.anei.cadpage.parsers.MO;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class MOStLouisCountyParserTest {
  
  public static class TestA extends MOStLouisCountyAParserTest {
    public TestA() {
      setParser(new MOStLouisCountyParser());
    }
  }
  
  public static class TestB extends MOStLouisCountyBParserTest {
    public TestB() {
      setParser(new MOStLouisCountyParser());
    }
  }
}