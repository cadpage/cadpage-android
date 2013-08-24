package net.anei.cadpage.parsers.KY;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class KYHardinCountyParserTest {
  
  public static class TestA extends KYHardinCountyAParserTest {
    public TestA() {
      setParser(new KYHardinCountyParser());
    }
  }
  
  public static class TestB extends KYHardinCountyBParserTest {
    public TestB() {
      setParser(new KYHardinCountyParser());
    }
  }
} 