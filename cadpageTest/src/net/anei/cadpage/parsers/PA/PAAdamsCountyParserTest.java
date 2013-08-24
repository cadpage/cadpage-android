package net.anei.cadpage.parsers.PA;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class PAAdamsCountyParserTest {
  
  public static class TestA extends PAAdamsCountyAParserTest {
    public TestA() {
      setParser(new PAAdamsCountyParser());
    }
  }
  
  public static class TestB extends PAAdamsCountyBParserTest {
    public TestB() {
      setParser(new PAAdamsCountyParser());
    }
  }
}