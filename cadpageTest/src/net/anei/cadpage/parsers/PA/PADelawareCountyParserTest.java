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
  
  public static class TestD extends PADelawareCountyDParserTest {
    public TestD() {
      setParser(new PADelawareCountyParser());
    }
  }
  
  public static class TestE extends PADelawareCountyEParserTest {
    public TestE() {
      setParser(new PADelawareCountyParser());
    }
  }
  
  public static class TestF extends PADelawareCountyFParserTest {
    public TestF() {
      setParser(new PADelawareCountyParser());
    }
  }
}