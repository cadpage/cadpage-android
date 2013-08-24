package net.anei.cadpage.parsers.ZAU;

import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/*
New South Wales, Australia
*/

@RunWith(Enclosed.class)
public class ZAUNewSouthWalesParserTest {
  
  public static class TestA extends ZAUNewSouthWalesAParserTest {
    public TestA() {
      setParser(new ZAUNewSouthWalesParser());
    }
  }
  
  public static class TestB extends ZAUNewSouthWalesBParserTest {
    public TestB() {
      setParser(new ZAUNewSouthWalesParser());
    }
  }
}