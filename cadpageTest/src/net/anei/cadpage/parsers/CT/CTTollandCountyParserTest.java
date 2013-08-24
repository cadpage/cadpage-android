package net.anei.cadpage.parsers.CT;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class CTTollandCountyParserTest {
  
  public static class TestA extends CTTollandCountyAParserTest {
    public TestA() {
      setParser(new CTTollandCountyParser());
    }
  }
  
  public static class TestB extends CTTollandCountyBParserTest {
    public TestB() {
      setParser(new CTTollandCountyParser());
    }
  }
  
}