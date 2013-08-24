package net.anei.cadpage.parsers.OH;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class OHSummitCountyParserTest {
  
  public static class TestA extends OHSummitCountyAParserTest {
    public TestA() {
      setParser(new OHSummitCountyParser());
    }
  }
  
  public static class TestB extends OHSummitCountyBParserTest {
    public TestB() {
      setParser(new OHSummitCountyParser());
    }
  }
  
  public static class TestC extends OHSummitCountyCParserTest {
    public TestC() {
      setParser(new OHSummitCountyParser());
    }
  }
  
  public static class TestD extends OHSummitCountyDParserTest {
    public TestD() {
      setParser(new OHSummitCountyParser());
    }
  }
}