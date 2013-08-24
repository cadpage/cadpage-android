package net.anei.cadpage.parsers.MD;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class MDCarrollCountyParserTest {
  
  public static class TestA extends MDCarrollCountyAParserTest {
    public TestA() {
      setParser(new MDCarrollCountyParser());
    }
  }
  
  public static class TestB extends MDCarrollCountyBParserTest {
    public TestB() {
      setParser(new MDCarrollCountyParser());
    }
  }
}