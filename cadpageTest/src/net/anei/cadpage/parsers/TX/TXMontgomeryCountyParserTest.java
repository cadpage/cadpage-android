package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class TXMontgomeryCountyParserTest extends BaseParserTest {
  
  public static class TestA extends TXMontgomeryCountyAParserTest {
    public TestA() {
      setParser(new TXMontgomeryCountyParser());
    }
  }
  
  public static class TestB extends TXMontgomeryCountyBParserTest {
    public TestB() {
      setParser(new TXMontgomeryCountyParser());
    }
  }
  
  public static class TestC extends TXMontgomeryCountyCParserTest {
    public TestC() {
      setParser(new TXMontgomeryCountyParser());
    }
  }
}