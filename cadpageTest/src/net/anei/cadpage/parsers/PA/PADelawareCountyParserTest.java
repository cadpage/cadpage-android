package net.anei.cadpage.parsers.PA;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class PADelawareCountyParserTest {
  
  public static class TestA extends PADelawareCountyAParserTest {
    public TestA() {
      setParser(new PADelawareCountyParser());
    }
  }
  
  public static class TestB extends PADelawareCountyBParserTest {
    public TestB() {
      setParser(new PADelawareCountyParser());
    }
  }
  
  public static class TestC extends PADelawareCountyCParserTest {
    public TestC() {
      setParser(new PADelawareCountyParser());
    }
  }
}