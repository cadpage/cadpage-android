package net.anei.cadpage.parsers.PA;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class PALehighCountyParserTest {
  
  public static class TestA extends PALehighCountyAParserTest {
    public TestA() {
      setParser(new PALehighCountyParser());
    }
  }
  
  public static class TestB extends PALehighCountyBParserTest {
    public TestB() {
      setParser(new PALehighCountyParser());
    }
  }
}