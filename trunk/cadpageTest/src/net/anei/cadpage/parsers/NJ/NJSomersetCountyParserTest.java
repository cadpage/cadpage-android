package net.anei.cadpage.parsers.NJ;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NJSomersetCountyParserTest {
  
  public static class TestA extends NJSomersetCountyAParserTest {
    public TestA() {
      setParser(new NJSomersetCountyParser());
    }
  }
  
  public static class TestB extends NJSomersetCountyBParserTest {
    public TestB() {
      setParser(new NJSomersetCountyParser());
    }
  }
}