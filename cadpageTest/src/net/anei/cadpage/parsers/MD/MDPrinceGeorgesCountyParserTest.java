package net.anei.cadpage.parsers.MD;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



@RunWith(Enclosed.class)
public class MDPrinceGeorgesCountyParserTest {
  
  public static class TestFireBiz extends MDPrinceGeorgesCountyFireBizParserTest {
    public TestFireBiz() {
      setParser(new MDPrinceGeorgesCountyFireBizParser());
    }
  }
  
  public static class TestB extends MDPrinceGeorgesCountyBParserTest {
    public TestB() {
      setParser(new MDPrinceGeorgesCountyBParser());
    }
  }
  
}