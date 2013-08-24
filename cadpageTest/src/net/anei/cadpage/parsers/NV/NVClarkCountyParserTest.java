package net.anei.cadpage.parsers.NV;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NVClarkCountyParserTest {
  
  public static class TestA extends NVClarkCountyAParserTest {
    public TestA() {
      setParser(new NVClarkCountyParser());
    }
  }
  
  public static class TestB extends NVClarkCountyBParserTest {
    public TestB() {
      setParser(new NVClarkCountyParser());
    }
  }
}