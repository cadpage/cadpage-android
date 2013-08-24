package net.anei.cadpage.parsers.OR;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class ORWashingtonCountyParserTest {
  
  public static class TestA extends ORWashingtonCountyAParserTest {
    public TestA() {
      setParser(new ORWashingtonCountyParser());
    }
  }
  
  public static class TestB extends ORWashingtonCountyBParserTest {
    public TestB() {
      setParser(new ORWashingtonCountyParser());
    }
  }
}