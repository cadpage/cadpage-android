package net.anei.cadpage.parsers.NC;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class NCMecklenburgCountyParserTest {
  
  public static class TestA extends NCMecklenburgCountyAParserTest {
    public TestA() {
      setParser(new NCMecklenburgCountyParser());
    }
  }
  
  public static class TestB extends NCMecklenburgCountyBParserTest {
    public TestB() {
      setParser(new NCMecklenburgCountyParser());
    }
  }
}