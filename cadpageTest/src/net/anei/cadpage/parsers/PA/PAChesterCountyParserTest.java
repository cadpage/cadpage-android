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
  
  public static class TestD1 extends PAChesterCountyD1ParserTest {
    public TestD1() {
      setParser(new PAChesterCountyParser());
    }
  }
  
  public static class TestD2 extends PAChesterCountyD2ParserTest {
    public TestD2() {
      setParser(new PAChesterCountyParser());
    }
  }
  
  public static class TestD3 extends PAChesterCountyD3ParserTest {
    public TestD3() {
      setParser(new PAChesterCountyParser());
    }
  }
  
  public static class TestD4 extends PAChesterCountyD4ParserTest {
    public TestD4() {
      setParser(new PAChesterCountyParser());
    }
  }
  
  public static class TestD5 extends PAChesterCountyD5ParserTest {
    public TestD5() {
      setParser(new PAChesterCountyParser());
    }
  }
  
  public static class TestE extends PAChesterCountyEParserTest {
    public TestE() {
      setParser(new PAChesterCountyParser());
    }
  }
  
  public static class TestF extends PAChesterCountyFParserTest {
    public TestF() {
      setParser(new PAChesterCountyParser());
    }
  }
  
  public static class TestG extends PAChesterCountyGParserTest {
    public TestG() {
      setParser(new PAChesterCountyParser());
    }
  }
  
}