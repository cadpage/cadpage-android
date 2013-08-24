package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;
import org.junit.Test;
/* 
Jefferson County, CO (Variant B)
Contact: Sheena Tamburlin <sheenatamb@hotmail.com>
Sender: @jeffco.us

(30517 SUNSET TRL) RP SEES SMOKE SAYS SOMETHING EXPLODED HER FURNACE // POSS LIGHTNING STRIKE
(26132 vosler st) info only  recreational burn  from now until 1800 on permit #12-024rf
(256 wisp creek dr) 86 YOM fall victim, hit head-cons & breathing

*/

public class COJeffersonCountyBParserTest extends BaseParserTest {
  
  public COJeffersonCountyBParserTest() {
    setParser(new COJeffersonCountyBParser(), "JEFFERSON COUNTY", "CO");
  }
  
  @Test
  public void testParser() {


    doTest("T1",
        "(30517 SUNSET TRL) RP SEES SMOKE SAYS SOMETHING EXPLODED HER FURNACE // POSS LIGHTNING STRIKE",
        "ADDR:30517 SUNSET TRL",
        "INFO:RP SEES SMOKE SAYS SOMETHING EXPLODED HER FURNACE // POSS LIGHTNING STRIKE");

    doTest("T2",
        "(26132 vosler st) info only  recreational burn  from now until 1800 on permit #12-024rf",
        "ADDR:26132 vosler st",
        "INFO:info only  recreational burn  from now until 1800 on permit #12-024rf");

    doTest("T3",
        "(256 wisp creek dr) 86 YOM fall victim, hit head-cons & breathing",
        "ADDR:256 wisp creek dr",
        "INFO:86 YOM fall victim, hit head-cons & breathing");
}
  
  public static void main(String[] args) {
    new COJeffersonCountyBParserTest().generateTests("T1");
  }
}
  