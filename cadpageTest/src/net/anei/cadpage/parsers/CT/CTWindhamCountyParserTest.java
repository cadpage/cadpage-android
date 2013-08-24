package net.anei.cadpage.parsers.CT;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class CTWindhamCountyParserTest {
  
  public static class TestA extends CTWindhamCountyAParserTest {
    public TestA() {
      setParser(new CTWindhamCountyParser());
    }
  }
  
  public static class TestB extends CTWindhamCountyBParserTest {
    public TestB() {
      setParser(new CTWindhamCountyParser());
    }
  }
  
}