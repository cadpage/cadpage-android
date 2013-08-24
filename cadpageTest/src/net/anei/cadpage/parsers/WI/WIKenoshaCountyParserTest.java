package net.anei.cadpage.parsers.WI;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/*
Kenosha County, WI

*/


@RunWith(Enclosed.class)
public class WIKenoshaCountyParserTest {
  
  public static class TestA extends WIKenoshaCountyAParserTest {
    public TestA() {
      setParser(new WIKenoshaCountyParser());
    }
  }
  
  public static class TestB extends WIKenoshaCountyBParserTest {
    public TestB() {
      setParser(new WIKenoshaCountyParser());
    }
  }
  
  public static class TestC extends WIKenoshaCountyCParserTest {
    public TestC() {
      setParser(new WIKenoshaCountyParser());
    }
  }
}