package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class TNHamiltonCountyParserTest extends BaseParserTest {
  
  public static class TestA extends TNHamiltonCountyAParserTest {
    public TestA() {
      setParser(new TNHamiltonCountyParser());
    }
  }
  
  public static class TestB extends TNHamiltonCountyBParserTest {
    public TestB() {
      setParser(new TNHamiltonCountyParser());
    }
  }
}