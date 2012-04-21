package net.anei.cadpage.parsers.OH;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class OHStarkCountyParserTest {
  
  public static class TestCencomm extends OHStarkCountyCencommParserTest {
    public TestCencomm() {
      setParser(new OHStarkCountyParser());
    }
  }
  
  public static class TestRedcent extends OHStarkCountyRedcentParserTest {
    public TestRedcent() {
      setParser(new OHStarkCountyParser());
    }
  }
}