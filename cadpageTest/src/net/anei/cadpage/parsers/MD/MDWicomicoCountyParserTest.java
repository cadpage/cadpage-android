package net.anei.cadpage.parsers.MD;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/*
Wicomico County, MD
*/


@RunWith(Enclosed.class)
public class MDWicomicoCountyParserTest {
  
  public static class TestA extends MDWicomicoCountyAParserTest {
    public TestA() {
      setParser(new MDWicomicoCountyParser());
    }
  }
  
  public static class TestB extends MDWicomicoCountyBParserTest {
    public TestB() {
      setParser(new MDWicomicoCountyParser());
    }
  }
  
}