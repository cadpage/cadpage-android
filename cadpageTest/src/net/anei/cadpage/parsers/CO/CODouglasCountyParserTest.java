package net.anei.cadpage.parsers.CO;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/*
Douglas County, CO
*/


@RunWith(Enclosed.class)
public class CODouglasCountyParserTest {
  
  public static class TestA extends CODouglasCountyAParserTest {
    public TestA() {
      setParser(new CODouglasCountyParser());
    }
  }
  
  public static class TestB extends CODouglasCountyBParserTest {
    public TestB() {
      setParser(new CODouglasCountyParser());
    }
  }
  
}