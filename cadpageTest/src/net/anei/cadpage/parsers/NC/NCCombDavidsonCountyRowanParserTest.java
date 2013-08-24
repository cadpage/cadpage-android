package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.GroupBestParser;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

// Davidson County, NC and Rowan County, NC have extremely similar text page
// formats and are easily confused, so we have a special test class to make
// sure that someone using both parsers gets everything right.

@RunWith(Enclosed.class)
public class NCCombDavidsonCountyRowanParserTest {
  
  public static class TestDavidsonCounty extends NCDavidsonCountyAParserTest {
    public TestDavidsonCounty() {
      setParser(new TestParser());
    }
  }
  
  public static class TestRowanCounty extends NCRowanCountyParserTest {
    public TestRowanCounty() {
      setParser(new TestParser());
    }
  }
  
  private static class TestParser extends GroupBestParser {
    public TestParser() {
      super(new NCDavidsonCountyAParser(),
             new NCRowanCountyParser());
    }
  }
}