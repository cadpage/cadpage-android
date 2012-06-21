package net.anei.cadpage.parsers.NJ;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NJGloucesterCountyParserTest {
  
  public static class TestA extends NJGloucesterCountyAParserTest {
    public TestA() {
      setParser(new NJGloucesterCountyParser());
    }
  }
  
  public static class TestB extends NJGloucesterCountyBParserTest {
    public TestB() {
      setParser(new NJGloucesterCountyParser());
    }
  }
}