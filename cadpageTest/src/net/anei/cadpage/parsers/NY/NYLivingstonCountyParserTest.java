package net.anei.cadpage.parsers.NY;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



@RunWith(Enclosed.class)
public class NYLivingstonCountyParserTest {
  
  public static class TestA extends NYLivingstonCountyAParserTest {
    public TestA() {
      setParser(new NYLivingstonCountyParser());
    }
  }
  
  public static class TestB extends NYLivingstonCountyBParserTest {
    public TestB() {
      setParser(new NYLivingstonCountyParser());
    }
  }
}