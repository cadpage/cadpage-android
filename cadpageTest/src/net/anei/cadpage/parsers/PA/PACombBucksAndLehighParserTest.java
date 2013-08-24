package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.GroupBestParser;
import net.anei.cadpage.parsers.general.GeneralParser;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

// Written to investigate peculiar problem with a combination of General
// PABucksCOunty, and PALehighCounty parsers

@RunWith(Enclosed.class)
public class PACombBucksAndLehighParserTest {
  
  public static class TestBucksCounty extends PABucksCountyAParserTest {
    public TestBucksCounty() {
      setParser(new TestParser());
    }
  }
  
  public static class TestLehighCounty extends PALehighCountyAParserTest {
    public TestLehighCounty() {
      setParser(new TestParser());
    }
  }
  
  private static class TestParser extends GroupBestParser {
    public TestParser() {
      super(new GeneralParser(),
             new PABucksCountyParser(),
             new PALehighCountyAParser());
    }
  }
}