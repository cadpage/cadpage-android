package net.anei.cadpage.parsers.DE;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



@RunWith(Enclosed.class)
public class DENewCastleCountyParserTest {
  
  public static class TestA extends DENewCastleCountyAParserTest {
    public TestA() {
      setParser(new DENewCastleCountyParser());
    }
  }
  
  public static class TestB extends DENewCastleCountyBParserTest {
    public TestB() {
      setParser(new DENewCastleCountyParser());
    }
  }
  
  public static class TestC extends DENewCastleCountyCParserTest {
    public TestC() {
      setParser(new DENewCastleCountyParser());
    }
  }
  
}