package net.anei.cadpage.parsers.NJ;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NJSalemCountyParserTest {
  
  public static class TestA extends NJSalemCountyAParserTest {
    public TestA() {
      setParser(new NJSalemCountyParser());
    }
  }
  
  public static class TestB extends NJSalemCountyBParserTest {
    public TestB() {
      setParser(new NJSalemCountyParser());
    }
  }
}