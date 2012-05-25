package net.anei.cadpage.parsers.NY;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NYOnondagaCountyParserTest {
  
  public static class TestA extends NYOnondagaCountyAParserTest {
    public TestA() {
      setParser(new NYOnondagaCountyParser());
    }
  }
  
  public static class TestB extends NYOnondagaCountyBParserTest {
    public TestB() {
      setParser(new NYOnondagaCountyParser());
    }
  }
}