package net.anei.cadpage.parsers.NY;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NYErieCountyParserTest {
  
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
  
  public static class TestD extends NYErieCountyDParserTest {
    public TestD() {
      setParser(new NYErieCountyParser());
    }
  }
  
  public static class TestE extends NYErieCountyEParserTest {
    public TestE() {
      setParser(new NYErieCountyParser());
    }
  }
  
  public static class TestRedAlert extends NYErieCountyRedAlertParserTest {
    public TestRedAlert() {
      setParser(new NYErieCountyParser());
    }
  }
}