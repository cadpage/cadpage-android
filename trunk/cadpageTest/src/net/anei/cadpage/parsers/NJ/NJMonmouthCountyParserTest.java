package net.anei.cadpage.parsers.NJ;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NJMonmouthCountyParserTest {
  
  public static class TestA extends NJMonmouthCountyAParserTest {
    public TestA() {
      setParser(new NJMonmouthCountyParser());
    }
  }
  
  public static class TestB extends NJMonmouthCountyBParserTest {
    public TestB() {
      setParser(new NJMonmouthCountyParser());
    }
  }
}