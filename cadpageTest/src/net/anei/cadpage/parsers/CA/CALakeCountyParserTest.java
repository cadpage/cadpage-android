package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CALakeCountyParserTest extends BaseParserTest {
  
  public CALakeCountyParserTest() {
    setParser(new CALakeCountyParser(), "LAKE COUNTY", "CA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "475 FOREST DR * * SUNSET DR/TERRACE DR * * LP * FDMA * * 8 YOF FALL W/ BLOODY NOSE, C/A/B",
        "ADDR:475 FOREST DR",
        "X:SUNSET DR/TERRACE DR",
        "CITY:Lakeport",
        "CALL:FDMA - Medical Aid",
        "INFO:8 YOF FALL W/ BLOODY NOSE, C/A/B");

    doTest("T2",
        "330 9TH * * N HIGH/N BRUSH * * LP * FDMA * * 19 YOM ASSLT VIC W/ HEAD LAC",
        "ADDR:330 9TH",
        "X:N HIGH/N BRUSH",
        "CITY:Lakeport",
        "CALL:FDMA - Medical Aid",
        "INFO:19 YOM ASSLT VIC W/ HEAD LAC");

    doTest("T3",
        "600 YELLOW HAMMER LN * * OSPREY CT * * LP * FDMA * * MED AID 17 YOM DIFF BREATH ETOH VOMITING POSS ALCOHOL POISONING",
        "ADDR:600 YELLOW HAMMER LN",  // Google says this is Yellow Hammer Land???
        "X:OSPREY CT",
        "CITY:Lakeport",
        "CALL:FDMA - Medical Aid",
        "INFO:MED AID 17 YOM DIFF BREATH ETOH VOMITING POSS ALCOHOL POISONING");

    doTest("T4",
        "644 MARTIN * * S ESTEP/S POLK * 3 * LP * FDMA * * MED AID 49 YOF ASSUALT VICT CODE 2 FACIAL LACERATION",
        "ADDR:644 MARTIN",
        "APT:3",
        "X:S ESTEP/S POLK",
        "CITY:Lakeport",
        "CALL:FDMA - Medical Aid",
        "INFO:MED AID 49 YOF ASSUALT VICT CODE 2 FACIAL LACERATION");

    doTest("T5",
        "301 S MAIN * EXPRESS MART * MARTIN/C * * LP * FDMA * * POSS STROKE...AT PUMPS",
        "ADDR:301 S MAIN",
        "PLACE:EXPRESS MART",
        "X:MARTIN/C",
        "CITY:Lakeport",
        "CALL:FDMA - Medical Aid",
        "INFO:POSS STROKE...AT PUMPS");

    doTest("T6",
        "SCOTTS VALLEY RANCHERIA/HARTLEY RD, Lakeport * * HARTLEY RD * * FDWF * * VEGITATION FIRE",
        "ADDR:SCOTTS VALLEY RANCHERIA & HARTLEY RD",
        "X:HARTLEY RD",
        "CITY:Lakeport",
        "CALL:FDWF - Wildland Fire",
        "INFO:VEGITATION FIRE");

    doTest("T7",
        "[Dispatched Call]  S STATE HWY 29/HIGHLAND SPRINGS RD, Lakeport *  * HIGHLAND SPRINGS RD *  * FDMA *  * BETWEEN ARGONAUT AND HIGHLAND SPRINGS IN",
        "ADDR:S STATE HWY 29 & HIGHLAND SPRINGS RD",
        "MADDR:S STATE 29 & HIGHLAND SPRINGS RD",
        "X:HIGHLAND SPRINGS RD",
        "CITY:Lakeport",
        "CALL:FDMA - Medical Aid",
        "INFO:BETWEEN ARGONAUT AND HIGHLAND SPRINGS IN");

    doTest("T8",
        "[Dispatched Call]  FINLEY EAST RD/THOMAS, Finley *  * THOMAS *  * FDOE *  * TARP WRAPPED INTO THE PG&E WIRES...RP IS CONCERNED THEY ARE GOING TO",
        "ADDR:FINLEY EAST RD & THOMAS",
        "X:THOMAS",
        "CITY:Finley",
        "CALL:FDOE - Other Event",
        "INFO:TARP WRAPPED INTO THE PG&E WIRES...RP IS CONCERNED THEY ARE GOING TO");

    doTest("T9",
        "2725 S MAIN, Lakeport * ROTTEN ROBBIE * STATE HWY 175 * * FDMA * * 15YOF FALL VIC WITH HEAD INJ C/A",
        "ADDR:2725 S MAIN",
        "PLACE:ROTTEN ROBBIE",
        "X:STATE HWY 175",
        "CITY:Lakeport",
        "CALL:FDMA - Medical Aid",
        "INFO:15YOF FALL VIC WITH HEAD INJ C/A");

  }
  
  public static void main(String[] args) {
    new CALakeCountyParserTest().generateTests("T1");
  }
}