package net.anei.cadpage.parsers.OH;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class OHWayneCountyParserTest {
  
  public static class TestA extends OHWayneCountyAParserTest {
    public TestA() {
      setParser(new OHWayneCountyParser());
    }
  }
  
  public static class TestB extends OHWayneCountyBParserTest {
    public TestB() {
      setParser(new OHWayneCountyParser());
    }
  }
}