package net.anei.cadpage.parsers.MD;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



@RunWith(Enclosed.class)
public class MDWorcesterCountyParserTest {
  
  public static class TestA extends MDWorcesterCountyAParserTest {
    public TestA() {
      setParser(new MDWorcesterCountyParser());
    }
  }
  
  public static class TestB extends MDWorcesterCountyBParserTest {
    public TestB() {
      setParser(new MDWorcesterCountyParser());
    }
  }
  
}