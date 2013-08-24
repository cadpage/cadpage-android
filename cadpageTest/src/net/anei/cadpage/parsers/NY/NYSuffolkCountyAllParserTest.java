package net.anei.cadpage.parsers.NY;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NYSuffolkCountyAllParserTest {
  
  public static class TestA extends NYSuffolkCountyAParserTest {
    public TestA() {
      setParser(new NYSuffolkCountyAllParser());
    }
  }
  
  public static class TestB extends NYSuffolkCountyBParserTest {
    public TestB() {
      setParser(new NYSuffolkCountyAllParser());
    }
  }
  
  public static class TestC extends NYSuffolkCountyCParserTest {
    public TestC() {
      setParser(new NYSuffolkCountyAllParser());
    }
  }
  
  public static class TestD extends NYSuffolkCountyDParserTest {
    public TestD() {
      setParser(new NYSuffolkCountyAllParser());
    }
  }
  
  public static class TestE extends NYSuffolkCountyEParserTest {
    public TestE() {
      setParser(new NYSuffolkCountyAllParser());
    }
  }
  
  public static class TestF extends NYSuffolkCountyFParserTest {
    public TestF() {
      setParser(new NYSuffolkCountyAllParser());
    }
  }
  
  public static class TestG extends NYSuffolkCountyGParserTest {
    public TestG() {
      setParser(new NYSuffolkCountyAllParser());
    }
  }
  
  public static class TestH extends NYSuffolkCountyHParserTest {
    public TestH() {
      setParser(new NYSuffolkCountyAllParser());
    }
  }
  
  public static class TestFiretracker extends NYSuffolkCountyFiretrackerParserTest {
    public TestFiretracker() {
      setParser(new NYSuffolkCountyAllParser());
    }
  }
  
  public static class TestDixHills extends NYDixHillsParserTest {
    public TestDixHills() {
      setParser(new NYSuffolkCountyAllParser());
    }
  }
  
}