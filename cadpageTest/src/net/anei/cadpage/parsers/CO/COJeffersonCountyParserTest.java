package net.anei.cadpage.parsers.CO;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/*
Jefferson County, CO
*/


@RunWith(Enclosed.class)
public class COJeffersonCountyParserTest {
  
  public static class TestA extends COJeffersonCountyAParserTest {
    public TestA() {
      setParser(new COJeffersonCountyParser());
    }
  }
  
  public static class TestB extends COJeffersonCountyBParserTest {
    public TestB() {
      setParser(new COJeffersonCountyParser());
    }
  }
  
}