package net.anei.cadpage.parsers.NY;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



@RunWith(Enclosed.class)
public class NYAlbanyCountyParserTest {
  
  public static class TestA extends NYAlbanyCountyAParserTest {
    public TestA() {
      setParser(new NYAlbanyCountyParser());
    }
  }
  
  public static class TestB extends NYAlbanyCountyBParserTest {
    public TestB() {
      setParser(new NYAlbanyCountyParser());
    }
  }
}