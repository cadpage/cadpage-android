package net.anei.cadpage.parsers.GA;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/* 
 * Camden County, GA
 */


@RunWith(Enclosed.class)
public class GACamdenCountyParserTest {
  
  public static class TestA extends GACamdenCountyAParserTest {
    public TestA() {
      setParser(new GACamdenCountyParser());
    }
  }
  
  public static class TestB extends GACamdenCountyBParserTest {
    public TestB() {
      setParser(new GACamdenCountyParser());
    }
  }
  
}