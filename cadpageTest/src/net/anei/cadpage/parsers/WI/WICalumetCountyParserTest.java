package net.anei.cadpage.parsers.WI;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class WICalumetCountyParserTest {
  
  public static class TestA extends WICalumetCountyAParserTest {
    public TestA() {
      setParser(new WICalumetCountyParser());
    }
  }
  
  public static class TestB extends WICalumetCountyBParserTest {
    public TestB() {
      setParser(new WICalumetCountyParser());
    }
  }
}