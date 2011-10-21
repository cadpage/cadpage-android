package net.anei.cadpage.parsers.NY;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



@RunWith(Enclosed.class)
public class NYMadisonCountyParserTest {
  
  public static class TestA extends NYMadisonCountyAParserTest {
    public TestA() {
      setParser(new NYMadisonCountyParser());
    }
  }
  
  public static class TestB extends NYMadisonCountyBParserTest {
    public TestB() {
      setParser(new NYMadisonCountyParser());
    }
  }
}