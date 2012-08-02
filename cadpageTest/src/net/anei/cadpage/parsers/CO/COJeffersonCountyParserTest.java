package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;
import org.junit.Test;

public class COJeffersonCountyParserTest extends BaseParserTest {
  
  public COJeffersonCountyParserTest() {
    setParser(new COJeffersonCountyParser(), "Jefferson County", "CO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[WRCAD] Add:3745 Quail St Type: UNKM PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0708201205966-001385",
        "CALL:UNKM PgH-16",
        "ADDR:3745 Quail St",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0708201205966-001385");

  }
  
  public static void main(String[] args) {
    new COJeffersonCountyParserTest().generateTests("T1");
  }
}
  