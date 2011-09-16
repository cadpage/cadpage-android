package net.anei.cadpage.parsers.DE;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



@RunWith(Enclosed.class)
public class DESussexCountyParserTest {
  
  public static class TestA extends DESussexCountyAParserTest {
    public TestA() {
      setParser(new DESussexCountyParser());
    }
  }
  
  public static class TestB extends DESussexCountyBParserTest {
    public TestB() {
      setParser(new DESussexCountyParser());
    }
  }
  
}