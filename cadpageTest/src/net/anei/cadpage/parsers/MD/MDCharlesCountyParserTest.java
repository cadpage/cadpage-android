package net.anei.cadpage.parsers.MD;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



@RunWith(Enclosed.class)
public class MDCharlesCountyParserTest {
  
  public static class TestA extends MDCharlesCountyAParserTest {
    public TestA() {
      setParser(new MDCharlesCountyParser());
    }
  }
  
  public static class TestB extends MDCharlesCountyBParserTest {
    public TestB() {
      setParser(new MDCharlesCountyParser());
    }
  }
}