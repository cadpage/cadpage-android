package net.anei.cadpage.parsers.DE;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/*
Kent County, DE 

 */


@RunWith(Enclosed.class)
public class DEKentCountyParserTest {
  
  public static class TestA extends DEKentCountyAParserTest {
    public TestA() {
      setParser(new DEKentCountyParser());
    }
  }
  
  public static class TestB extends DEKentCountyBParserTest {
    public TestB() {
      setParser(new DEKentCountyParser());
    }
  }
  
  public static class TestC extends DEKentCountyCParserTest {
    public TestC() {
      setParser(new DEKentCountyParser());
    }
  }
  
  public static class TestD extends DEKentCountyDParserTest {
    public TestD() {
      setParser(new DEKentCountyParser());
    }
  }
  
}