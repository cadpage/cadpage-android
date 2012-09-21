package net.anei.cadpage.parsers.PA;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class PABucksCountyParserTest {
  
  public static class TestA extends PABucksCountyAParserTest {
    public TestA() {
      setParser(new PABucksCountyParser());
    }
  }
  
  public static class TestB extends PABucksCountyBParserTest {
    public TestB() {
      setParser(new PABucksCountyParser());
    }
  }
}