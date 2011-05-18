package net.anei.cadpage.parsers.PA;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class PAChesterCountyParserTest {
  
  public static class TestA extends PAChesterCountyAParserTest {
    public TestA() {
      setParser(new PAChesterCountyParser());
    }
  }
  
  public static class TestB extends PAChesterCountyBParserTest {
    public TestB() {
      setParser(new PAChesterCountyParser());
    }
  }
  
  public static class TestC extends PAChesterCountyCParserTest {
    public TestC() {
      setParser(new PAChesterCountyParser());
    }
  }
  
}