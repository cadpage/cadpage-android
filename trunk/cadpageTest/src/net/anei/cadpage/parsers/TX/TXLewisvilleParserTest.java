package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXLewisvilleParserTest extends BaseParserTest {
  
  public TXLewisvilleParserTest() {
    setParser(new TXLewisvilleParser(), "LEWISVILLE", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "*101 E CORPORATE DR*****MAJOR ACC****B160,CHIEF,E163,M163,T167*316****",
        "ADDR:101 E CORPORATE DR",
        "CALL:MAJOR ACC",
        "UNIT:B160,CHIEF,E163,M163,T167");

    doTest("T2",
        "*1725 SHUFORDS CT*****FIRE****B160,CHIEF,E164,E165,M163,Q163,T167*300****",
        "ADDR:1725 SHUFORDS CT",
        "CALL:FIRE",
        "UNIT:B160,CHIEF,E164,E165,M163,Q163,T167");

    doTest("T3",
        "*251 N I35E SBFR*****FIRE****B160,CHIEF,E161,E164,M161,Q162,T167*127****",
        "ADDR:251 N I35E SBFR",
        "MADDR:251 N I 35 FRONTAGE RD",
        "CALL:FIRE",
        "UNIT:B160,CHIEF,E161,E164,M161,Q162,T167");

    doTest("T4",
        "*4900 BLAIR OAKS DR*****MA FILL-IN****CHIEF,E166*947****",
        "ADDR:4900 BLAIR OAKS DR",
        "CALL:MA FILL-IN",
        "UNIT:CHIEF,E166");

    doTest("T5",
        "11072508*1077 N GARDEN RIDGE BLVD*****FIRE****B160,CHIEF,E163,E164,M163,Q162,T167",
        "ID:11072508",
        "ADDR:1077 N GARDEN RIDGE BLVD",
        "CALL:FIRE",
        "UNIT:B160,CHIEF,E163,E164,M163,Q162,T167");

  }
  
  public static void main(String[] args) {
    new TXLewisvilleParserTest().generateTests("T1");
  }
}
