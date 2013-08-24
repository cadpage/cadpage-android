package net.anei.cadpage.parsers.VA;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class VAPrinceWilliamCountyParserTest {
  
  public static class TestA extends VAPrinceWilliamCountyAParserTest {
    public TestA() {
      setParser(new VAPrinceWilliamCountyParser());
    }
  }
  
  public static class TestB extends VAPrinceWilliamCountyBParserTest {
    public TestB() {
      setParser(new VAPrinceWilliamCountyParser());
    }
  }
}