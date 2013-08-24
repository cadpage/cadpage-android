package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class TXCollinCountyParserTest extends BaseParserTest {
  
  public static class TestA extends TXCollinCountyAParserTest {
    public TestA() {
      setParser(new TXCollinCountyParser());
    }
  }
  
  public static class TestB extends TXCollinCountyBParserTest {
    public TestB() {
      setParser(new TXCollinCountyParser());
    }
  }
  
 
}