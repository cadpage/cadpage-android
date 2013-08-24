package net.anei.cadpage.parsers.NC;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/* 
Davie County, NC
*/

@RunWith(Enclosed.class)
public class NCDavieCountyParserTest {
  
  public static class TestA extends NCDavieCountyAParserTest {
    public TestA() {
      setParser(new NCDavieCountyParser());
    }
  }
  
  public static class TestB extends NCDavieCountyBParserTest {
    public TestB() {
      setParser(new NCDavieCountyParser());
    }
  }
}