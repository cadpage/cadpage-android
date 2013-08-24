package net.anei.cadpage.parsers.ZCAAB;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*


*/

public class ZCAABLongviewParserTest extends BaseParserTest {
  
  public ZCAABLongviewParserTest() {
    setParser(new DummyParser(), "LONGVIEW", "AB");
  }
  
  @Test
  public void testParser() {
   
  }
  
  public static void main(String[] args) {
    new ZCAABLongviewParserTest().generateTests("T1");
  }
}