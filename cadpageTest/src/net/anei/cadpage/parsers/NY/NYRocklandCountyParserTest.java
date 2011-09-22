package net.anei.cadpage.parsers.NY;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NYRocklandCountyParserTest {
  
  public static class TestA extends NYRocklandCountyAParserTest {
    public TestA() {
      setParser(new NYRocklandCountyParser());
    }
  }
  
  public static class TestB extends NYRocklandCountyBParserTest {
    public TestB() {
      setParser(new NYRocklandCountyParser());
    }
  }
  
  public static class TestC extends NYRocklandCountyCParserTest {
    public TestC() {
      setParser(new NYRocklandCountyParser());
    }
  }
}