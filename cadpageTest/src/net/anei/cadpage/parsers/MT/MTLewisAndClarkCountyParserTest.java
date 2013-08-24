package net.anei.cadpage.parsers.MT;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/*
Lewis and Clark County, MT

*/

@RunWith(Enclosed.class)
public class MTLewisAndClarkCountyParserTest {

  public static class TestA extends MTLewisAndClarkCountyAParserTest {
    public TestA() {
      setParser(new MTLewisAndClarkCountyParser());
    }
  }

  public static class TestB extends MTLewisAndClarkCountyBParserTest {
    public TestB() {
      setParser(new MTLewisAndClarkCountyParser());
    }
  }
}