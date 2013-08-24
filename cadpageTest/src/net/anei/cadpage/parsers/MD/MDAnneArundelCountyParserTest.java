package net.anei.cadpage.parsers.MD;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class MDAnneArundelCountyParserTest {
  
  public static class TestFire extends MDAnneArundelCountyFireParserTest {
    public TestFire() {
      setParser(new MDAnneArundelCountyParser());
    }
  }
  
  public static class TestEMS extends MDAnneArundelCountyEMSParserTest {
    public TestEMS() {
      setParser(new MDAnneArundelCountyParser());
    }
  }
  
  public static class TestAnnapolis extends MDAnneArundelCountyAnnapolisParserTest {
    public TestAnnapolis() {
      setParser(new MDAnneArundelCountyParser());
    }
  }
  
}