package net.anei.cadpage.parsers.WA;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class WAPierceCountyParserTest {
  
  public static class TestA extends WAPierceCountyAParserTest {
    public TestA() {
      setParser(new WAPierceCountyParser());
    }
  }
  
  public static class TestB extends WAPierceCountyBParserTest {
    public TestB() {
      setParser(new WAPierceCountyParser());
    }
  }
}