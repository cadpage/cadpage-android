package net.anei.cadpage.parsers.NJ;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NJSussexCountyParserTest {
  
  public static class TestA extends NJSussexCountyAParserTest {
    public TestA() {
      setParser(new NJSussexCountyParser());
    }
  }
  
  public static class TestB extends NJSussexCountyBParserTest {
    public TestB() {
      setParser(new NJSussexCountyParser());
    }
  }
}