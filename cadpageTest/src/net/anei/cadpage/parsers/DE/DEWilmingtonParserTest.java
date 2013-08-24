package net.anei.cadpage.parsers.DE;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/* 
 * Wilmington, DE
 */


@RunWith(Enclosed.class)
public class DEWilmingtonParserTest {
  
  public static class TestA extends DEWilmingtonAParserTest {
    public TestA() {
      setParser(new DEWilmingtonParser());
    }
  }
  
  public static class TestB extends DEWilmingtonBParserTest {
    public TestB() {
      setParser(new DEWilmingtonParser());
    }
  }
  
}