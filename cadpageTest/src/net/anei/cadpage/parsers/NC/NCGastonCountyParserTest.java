package net.anei.cadpage.parsers.NC;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


/* 
Cabarrus County, NC
*/

@RunWith(Enclosed.class)
public class NCGastonCountyParserTest {
  
  public static class TestA extends NCGastonCountyAParserTest {
    public TestA() {
      setParser(new NCGastonCountyParser());
    }
  }
  
  public static class TestB extends NCGastonCountyBParserTest {
    public TestB() {
      setParser(new NCGastonCountyParser());
    }
  }
  
  public static class TestC extends NCGastonCountyCParserTest {
    public TestC() {
      setParser(new NCGastonCountyParser());
    }
  }
}