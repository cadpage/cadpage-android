package net.anei.cadpage.parsers.NY;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



@RunWith(Enclosed.class)
public class NYNassauCountyParserTest {
  
  public static class TestA extends NYNassauCountyAParserTest {
    public TestA() {
      setParser(new NYNassauCountyParser());
    }
  }
  
  public static class TestB extends NYNassauCountyBParserTest {
    public TestB() {
      setParser(new NYNassauCountyParser());
    }
  }
  
  public static class TestC extends NYNassauCountyCParserTest {
    public TestC() {
      setParser(new NYNassauCountyParser());
    }
  }
  
  public static class TestD extends NYNassauCountyDParserTest {
    public TestD() {
      setParser(new NYNassauCountyParser());
    }
  }
  
  public static class TestF extends NYNassauCountyFParserTest {
    public TestF() {
      setParser(new NYNassauCountyParser());
    }
  }
  
  public static class TestRedAlert extends NYNassauCountyRedAlertParserTest {
    public TestRedAlert() {
      setParser(new NYNassauCountyParser());
    }
  }
  
  public static class TestFiretracker extends NYNassauCountyFiretrackerParserTest {
    public TestFiretracker() {
      setParser(new NYNassauCountyParser());
    }
  }
  
  public static class TestElmont extends NYNassauCountyElmontParserTest {
    public TestElmont() {
      setParser(new NYNassauCountyParser());
    }
  }
  
  public static class TestMassepequa extends NYNassauCountyMassepequaParserTest {
    public TestMassepequa() {
      setParser(new NYNassauCountyParser());
    }
  }
  
}