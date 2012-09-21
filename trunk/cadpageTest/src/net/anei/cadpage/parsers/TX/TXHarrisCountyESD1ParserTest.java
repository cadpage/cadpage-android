package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;


@RunWith(Enclosed.class)
public class TXHarrisCountyESD1ParserTest extends BaseParserTest {
  
  public static class TestA extends TXHarrisCountyESD1AParserTest {
    public TestA() {
      setParser(new TXHarrisCountyESD1Parser());
    }
  }
  
  public static class TestB extends TXHarrisCountyESD1BParserTest {
    public TestB() {
      setParser(new TXHarrisCountyESD1Parser());
    }
  }
}