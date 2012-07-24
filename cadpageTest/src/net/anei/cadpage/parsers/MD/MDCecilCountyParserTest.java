package net.anei.cadpage.parsers.MD;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



@RunWith(Enclosed.class)
public class MDCecilCountyParserTest {
  
  public static class TestA extends MDCecilCountyAParserTest {
    public TestA() {
      setParser(new MDCecilCountyParser());
    }
  }
  
  public static class TestB extends MDCecilCountyBParserTest {
    public TestB() {
      setParser(new MDCecilCountyParser());
    }
  }
  
  public static class TestC extends MDCecilCountyCParserTest {
    public TestC() {
      setParser(new MDCecilCountyParser());
    }
  }
  
}