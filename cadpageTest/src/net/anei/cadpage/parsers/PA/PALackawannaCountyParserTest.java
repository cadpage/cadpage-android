package net.anei.cadpage.parsers.PA;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class PALackawannaCountyParserTest {
  
  public static class TestA extends PALackawannaCountyAParserTest {
    public TestA() {
      setParser(new PALackawannaCountyParser());
    }
  }
  
  public static class TestAmbulance extends PALackawannaCountyAmbulanceParserTest {
    public TestAmbulance() {
      setParser(new PALackawannaCountyParser());
    }
  }
}