package net.anei.cadpage.parsers.NJ;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NJBurlingtonCountyParserTest {
  
  public static class TestA extends NJBurlingtonCountyAParserTest {
    public TestA() {
      setParser(new NJBurlingtonCountyParser());
    }
  }
  
  public static class TestB extends NJBurlingtonCountyBParserTest {
    public TestB() {
      setParser(new NJBurlingtonCountyParser());
    }
  }
}