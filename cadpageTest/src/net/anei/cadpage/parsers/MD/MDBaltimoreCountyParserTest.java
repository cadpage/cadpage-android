package net.anei.cadpage.parsers.MD;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/*    
Cecil County, MD

*/


@RunWith(Enclosed.class)
public class MDBaltimoreCountyParserTest {
  
  public static class TestA extends MDBaltimoreCountyAParserTest {
    public TestA() {
      setParser(new MDBaltimoreCountyParser());
    }
  }
  
  public static class TestB extends MDBaltimoreCountyBParserTest {
    public TestB() {
      setParser(new MDBaltimoreCountyParser());
    }
  }
}