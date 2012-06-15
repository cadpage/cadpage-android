package net.anei.cadpage.parsers.MD;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



@RunWith(Enclosed.class)
public class MDPrinceGeorgesCountyParserTest {
  
  public static class TestFireBiz extends MDPrinceGeorgesCountyFireBizParserTest {
    public TestFireBiz() {
      setParser(new MDPrinceGeorgesCountyParser());
    }
  }
  
  public static class TestC extends MDPrinceGeorgesCountyCParserTest {
    public TestC() {
      setParser(new MDPrinceGeorgesCountyParser());
    }
  }
  
  public static class TestD extends MDPrinceGeorgesCountyDParserTest {
    public TestD() {
      setParser(new MDPrinceGeorgesCountyParser());
    }
  }
  
  public static class TestE extends MDPrinceGeorgesCountyEParserTest {
    public TestE() {
      setParser(new MDPrinceGeorgesCountyParser());
    }
  }
  
}