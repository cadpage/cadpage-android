package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.GroupBestParser;
import net.anei.cadpage.parsers.MsgParser;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



@RunWith(Enclosed.class)
public class NYLewisAndStLawrenceCountyParserTest {
  
  private static MsgParser testParser = new GroupBestParser(new NYLewisCountyParser(), new NYStLawrenceCountyParser());
  
  public static class TestLewisCounty extends NYLewisCountyParserTest {
    public TestLewisCounty() {
      setParser(testParser);
    }
  }
  
  public static class TestStLawrenceCounty extends NYStLawrenceCountyParserTest {
    public TestStLawrenceCounty() {
      setParser(testParser);
    }
  }
}