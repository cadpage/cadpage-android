package net.anei.cadpage.parsers.SD;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class SDUnionCountyParserTest {
  
  public static class TestA extends SDUnionCountyAParserTest {
    public TestA() {
      setParser(new SDUnionCountyParser());
    }
  }
  
  public static class TestB extends SDUnionCountyBParserTest {
    public TestB() {
      setParser(new SDUnionCountyParser());
    }
  }
}