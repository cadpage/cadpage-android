package net.anei.cadpage.parsers.IN;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/*
Hamilton County, IN

*/


@RunWith(Enclosed.class)
public class INHamiltonCountyParserTest {
  
  public static class TestA extends INHamiltonCountyAParserTest {
    public TestA() {
      setParser(new INHamiltonCountyParser());
    }
  }
  
  public static class TestB extends INHamiltonCountyBParserTest {
    public TestB() {
      setParser(new INHamiltonCountyParser());
    }
  }
  
}