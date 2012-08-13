package net.anei.cadpage.parsers.PA;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class PAMontgomeryCountyParserTest {
  
  public static class TestA extends PAMontgomeryCountyAParserTest {
    public TestA() {
      setParser(new PAMontgomeryCountyParser());
    }
  }
  
  public static class TestB extends PAMontgomeryCountyBParserTest {
    public TestB() {
      setParser(new PAMontgomeryCountyParser());
    }
  }
  
  public static class TestC extends PAMontgomeryCountyCParserTest {
    public TestC() {
      setParser(new PAMontgomeryCountyParser());
    }
  }
  
  public static class TestD extends PAMontgomeryCountyDParserTest {
    public TestD() {
      setParser(new PAMontgomeryCountyParser());
    }
  }
}