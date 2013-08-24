package net.anei.cadpage.parsers.WA;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class WAKingCountyParserTest {
  
  public static class TestA extends WAKingCountyAParserTest {
    public TestA() {
      setParser(new WAKingCountyParser());
    }
  }
  
  public static class TestB extends WAKingCountyBParserTest {
    public TestB() {
      setParser(new WAKingCountyParser());
    }
  }
}