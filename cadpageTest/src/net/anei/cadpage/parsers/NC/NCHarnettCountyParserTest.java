package net.anei.cadpage.parsers.NC;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NCHarnettCountyParserTest {
  
  public static class TestA extends NCHarnettCountyAParserTest {
    public TestA() {
      setParser(new NCHarnettCountyParser());
    }
  }
  
  public static class TestB extends NCHarnettCountyBParserTest {
    public TestB() {
      setParser(new NCHarnettCountyParser());
    }
  }
}