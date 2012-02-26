package net.anei.cadpage.parsers.PA;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class PAYorkCountyParserTest {
  
  public static class TestA extends PAYorkCountyAParserTest {
    public TestA() {
      setParser(new PAYorkCountyParser());
    }
  }
  
  public static class TestB extends PAYorkCountyBParserTest {
    public TestB() {
      setParser(new PAYorkCountyParser());
    }
  }
  
  public static class TestC extends PAYorkCountyCParserTest {
    public TestC() {
      setParser(new PAYorkCountyParser());
    }
  }
}