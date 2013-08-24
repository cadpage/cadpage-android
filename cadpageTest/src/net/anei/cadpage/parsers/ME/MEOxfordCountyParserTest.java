package net.anei.cadpage.parsers.ME;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Oxford County, ME
Contact: matthew winston <winniewinston2272@hotmail.com>
Sender: 2075151833,2075151834

273:Spillman:MEFD: - ALARM FIRE - 110 MAIN ST, MEX:
268:Spillman:MEFD: - CHIMNEY FIRE - 164 BELIVEAU RD, RUM: Rumford Fire adv d took in house call for a chimney fire req tone (SB
267:Spillman:MEFD: - ALARM FIRE - 377 RIVER RD, MEX: zone is second flr pull station hall by conference room. Attempting key holder. (BHS) 17 26 49 0303 2013 - Littlehale,
269:Spillman:MEFD: - CHIMNEY FIRE - 14 WOODLAND ST, MEX: Caller reporting that he has sparks coming from the Chimney awhile ago but nothing now he would
270:Spillman:MEFD: - ODOR INVEST - 3 SWETT AVE, MEX: 14 31 51 03 07 2013 - Bisbee, Tamara mexico engine 1 enrt 14 31 58 03 07 2013 - Bisbee, Tamara 
273:Spillman:MEFD: - ALARM FIRE - 110 MAIN ST, MEX:

*/

public class MEOxfordCountyParserTest extends BaseParserTest {
  
  public MEOxfordCountyParserTest() {
    setParser(new MEOxfordCountyParser(), "OXFORD COUNTY", "ME");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "273:Spillman:MEFD: - ALARM FIRE - 110 MAIN ST, MEX:",
        "ID:273",
        "SRC:MEFD",
        "CALL:ALARM FIRE",
        "ADDR:110 MAIN ST",
        "CITY:MEXICO");

    doTest("T2",
        "268:Spillman:MEFD: - CHIMNEY FIRE - 164 BELIVEAU RD, RUM: Rumford Fire adv d took in house call for a chimney fire req tone (SB",
        "ID:268",
        "SRC:MEFD",
        "CALL:CHIMNEY FIRE",
        "ADDR:164 BELIVEAU RD",
        "CITY:RUMFORD",
        "INFO:Rumford Fire adv d took in house call for a chimney fire req tone (SB");

    doTest("T3",
        "267:Spillman:MEFD: - ALARM FIRE - 377 RIVER RD, MEX: zone is second flr pull station hall by conference room. Attempting key holder. (BHS) 17 26 49 0303 2013 - Littlehale,",
        "ID:267",
        "SRC:MEFD",
        "CALL:ALARM FIRE",
        "ADDR:377 RIVER RD",
        "CITY:MEXICO",
        "INFO:zone is second flr pull station hall by conference room. Attempting key holder. (BHS) 17 26 49 0303 2013 - Littlehale,");

    doTest("T4",
        "269:Spillman:MEFD: - CHIMNEY FIRE - 14 WOODLAND ST, MEX: Caller reporting that he has sparks coming from the Chimney awhile ago but nothing now he would",
        "ID:269",
        "SRC:MEFD",
        "CALL:CHIMNEY FIRE",
        "ADDR:14 WOODLAND ST",
        "CITY:MEXICO",
        "INFO:Caller reporting that he has sparks coming from the Chimney awhile ago but nothing now he would");

    doTest("T5",
        "270:Spillman:MEFD: - ODOR INVEST - 3 SWETT AVE, MEX: 14 31 51 03 07 2013 - Bisbee, Tamara mexico engine 1 enrt 14 31 58 03 07 2013 - Bisbee, Tamara ",
        "ID:270",
        "SRC:MEFD",
        "CALL:ODOR INVEST",
        "ADDR:3 SWETT AVE",
        "CITY:MEXICO",
        "INFO:14 31 51 03 07 2013 - Bisbee, Tamara mexico engine 1 enrt 14 31 58 03 07 2013 - Bisbee, Tamara");

    doTest("T6",
        "273:Spillman:MEFD: - ALARM FIRE - 110 MAIN ST, MEX:",
        "ID:273",
        "SRC:MEFD",
        "CALL:ALARM FIRE",
        "ADDR:110 MAIN ST",
        "CITY:MEXICO");

  }
  
  public static void main(String[] args) {
    new MEOxfordCountyParserTest().generateTests("T1");
  }
}