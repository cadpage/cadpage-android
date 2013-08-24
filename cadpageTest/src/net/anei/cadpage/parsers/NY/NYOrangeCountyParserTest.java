package net.anei.cadpage.parsers.NY;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NYOrangeCountyParserTest {
  
  public static class TestA extends NYOrangeCountyAParserTest {
    public TestA() {
      setParser(new NYOrangeCountyParser());
    }
  }
  
  public static class TestB extends NYOrangeCountyBParserTest {
    public TestB() {
      setParser(new NYOrangeCountyParser());
    }
  }
  
  public static class TestC extends NYOrangeCountyCParserTest {
    public TestC() {
      setParser(new NYOrangeCountyParser());
    }
  }
  
  public static class TestD extends NYOrangeCountyDParserTest {
    public TestD() {
      setParser(new NYOrangeCountyParser());
    }
  }
}