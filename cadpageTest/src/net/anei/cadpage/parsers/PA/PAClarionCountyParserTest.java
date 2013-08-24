package net.anei.cadpage.parsers.PA;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class PAClarionCountyParserTest {
  
  public static class TestA extends PAClarionCountyAParserTest {
    public TestA() {
      setParser(new PAClarionCountyParser());
    }
  }
  
  public static class TestB extends PAClarionCountyBParserTest {
    public TestB() {
      setParser(new PAClarionCountyParser());
    }
  }
}