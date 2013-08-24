package net.anei.cadpage.parsers.CT;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/*
New Haven County, CT

*/


@RunWith(Enclosed.class)
public class CTNewHavenCountyParserTest {
  
  public static class TestA extends CTNewHavenCountyAParserTest {
    public TestA() {
      setParser(new CTNewHavenCountyParser());
    }
  }
  
  public static class TestB extends CTNewHavenCountyBParserTest {
    public TestB() {
      setParser(new CTNewHavenCountyParser());
    }
  }
  
}