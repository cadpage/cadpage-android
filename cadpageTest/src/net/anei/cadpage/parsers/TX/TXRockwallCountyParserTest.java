package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class TXRockwallCountyParserTest extends BaseParserTest {
  
  public static class TestA extends TXRockwallCountyAParserTest {
    public TestA() {
      setParser(new TXRockwallCountyParser());
    }
  }
  
  public static class TestB extends TXRockwallCountyBParserTest {
    public TestB() {
      setParser(new TXRockwallCountyParser());
    }
  }
  
}