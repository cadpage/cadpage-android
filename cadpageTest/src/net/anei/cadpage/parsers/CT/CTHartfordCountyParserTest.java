package net.anei.cadpage.parsers.CT;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/*
New Haven County, CT
*/
@RunWith(Enclosed.class)
public class CTHartfordCountyParserTest {
  
  public static class TestAvon extends CTHartfordCountyAvonParserTest {
    public TestAvon() {
      setParser(new CTHartfordCountyParser());
    }
  }
  
  public static class TestFarmington extends CTHartfordCountyFarmingtonParserTest {
    public TestFarmington() {
      setParser(new CTHartfordCountyParser());
    }
  }
}