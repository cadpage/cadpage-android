package net.anei.cadpage.parsers.OH;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class OHWarrenCountyParserTest {
  
  public static class TestA extends OHWarrenCountyAParserTest {
    public TestA() {
      setParser(new OHWarrenCountyParser());
    }
  }
  
  public static class TestB extends OHWarrenCountyBParserTest {
    public TestB() {
      setParser(new OHWarrenCountyParser());
    }
  }
  
 
}