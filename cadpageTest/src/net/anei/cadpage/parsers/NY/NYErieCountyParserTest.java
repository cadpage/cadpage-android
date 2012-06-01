package net.anei.cadpage.parsers.NY;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NYErieCountyParserTest {
  
  public static class TestA extends NYErieCountyAParserTest {
    public TestA() {
      setParser(new NYErieCountyParser());
    }
  }
  
  public static class TestB extends NYErieCountyBParserTest {
    public TestB() {
      setParser(new NYErieCountyParser());
    }
  }
  
  public static class TestC extends NYErieCountyCParserTest {
    public TestC() {
      setParser(new NYErieCountyParser());
    }
  }
  
  public static class TestRedAlert extends NYErieCountyRedAlertParserTest {
    public TestRedAlert() {
      setParser(new NYErieCountyParser());
    }
  }
}