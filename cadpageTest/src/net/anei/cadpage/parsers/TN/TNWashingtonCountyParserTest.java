package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class TNWashingtonCountyParserTest extends BaseParserTest {
  
  public static class TestA extends TNWashingtonCountyAParserTest {
    public TestA() {
      setParser(new TNWashingtonCountyParser());
    }
  }
  
  public static class TestB extends TNWashingtonCountyBParserTest {
    public TestB() {
      setParser(new TNWashingtonCountyParser());
    }
  }
}