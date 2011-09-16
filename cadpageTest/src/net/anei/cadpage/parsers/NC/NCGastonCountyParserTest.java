package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCGastonCountyParserTest extends BaseParserTest {
  
  public NCGastonCountyParserTest() {
    setParser(new NCGastonCountyParser(), "GASTON COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(*CAD*) [CAD]   29D2P ~RIVERSIDE~DR/~HICKORY GROVE~RD  X-ST: Phone:~(704) 905-8283 - Station:~Station 40 Station 40 08/25/2011 15:48:11 7\nLD400, EN403, C161, RSU,",
        "CODE:29D2P",
        "ADDR:RIVERSIDE DR & HICKORY GROVE RD",
        "PHONE:(704) 905-8283",
        "SRC:40",
        "UNIT:LD400, EN403, C161, RSU,");

    doTest("T2",
        "(*CAD*) [CAD]   29D2L ~WESLEYAN~DR/~MAIN~ST  X-ST: Phone:~(704) 460-7016 - Station:~Station 40 Station 40 08/29/2011 16:49:18 1\nEN403  WRECK.",
        "CODE:29D2L",
        "ADDR:WESLEYAN DR & MAIN ST",
        "PHONE:(704) 460-7016",
        "SRC:40",
        "UNIT:EN403  WRECK.");

    doTest("T3",
        "(*CAD*) [CAD]   Tree In Roadway 124~CHURCH~ST~  X-ST: ROBINETTE LN - Phone:~(704) 634-0269 Station 40 08/30/2011 05:13:05 1\n",
        "CALL:Tree In Roadway",
        "ADDR:124 CHURCH ST",
        "X:ROBINETTE LN",
        "PHONE:(704) 634-0269",
        "SRC:40");
    

    doTest("T4",
        "(*CAD*) [CAD]   Alarm-Fire (High Risk) 250~BEATTY~DR~  X-ST: UNKNOWN - Station:~Station 34 Station 34 09/07/2011 21:00:32 3\nLD400, LD34, EN33",
        "CALL:Alarm-Fire (High Risk)",
        "ADDR:250 BEATTY DR",
        "X:UNKNOWN",
        "SRC:34",
        "UNIT:LD400, LD34, EN33");

    doTest("T5",
        "(*CAD*) [CAD]   29D4 S ~I~85/~S ~EXIT 23 MCADENVILLE  X-ST: Station:~Station 40 - Quadrant:~40D Station 40 08/30/2011 07:01:38 7\nLD400, EN403, SP172, RSU, E33P, E3",
        "CODE:29D4",
        "ADDR:S I 85 & S EXIT 23 MCADENVILLE",
        "SRC:40",
        "MAP:40D",
        "UNIT:LD400, EN403, SP172, RSU, E33P, E3");

    doTest("T6",
        "(*CAD*) [CAD]   Tree In Roadway 124~CHURCH~ST~  X-ST: ROBINETTE LN - Phone:~(704) 634-0269 Station 40 08/30/2011 05:13:05 1\nEN403",
        "CALL:Tree In Roadway",
        "ADDR:124 CHURCH ST",
        "X:ROBINETTE LN",
        "PHONE:(704) 634-0269",
        "SRC:40",
        "UNIT:EN403");

    doTest("T7",
        "(*CAD*) [CAD]   29D2L ~WESLEYAN~DR/~MAIN~ST  X-ST: Phone:~(704) 460-7016 - Station:~Station 40 Station 40 08/29/2011 16:49:18 1\nEN403  WRECK.",
        "CODE:29D2L",
        "ADDR:WESLEYAN DR & MAIN ST",
        "PHONE:(704) 460-7016",
        "SRC:40",
        "UNIT:EN403  WRECK.");
  }
  

  public static void main(String[] args) {
    new NCGastonCountyParserTest().generateTests("T1");
  }
}
