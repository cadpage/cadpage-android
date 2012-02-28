package net.anei.cadpage.parsers.NJ;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NJCamdenCountyParserTest {
  
  public static class TestA extends NJCamdenCountyAParserTest {
    public TestA() {
      setParser(new NJCamdenCountyParser());
    }
  }
  
  public static class TestB extends NJCamdenCountyBParserTest {
    public TestB() {
      setParser(new NJCamdenCountyParser());
    }
  }
}