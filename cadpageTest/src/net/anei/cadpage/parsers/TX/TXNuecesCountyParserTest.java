package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXNuecesCountyParserTest extends BaseParserTest {
  
  public TXNuecesCountyParserTest() {
    setParser(new TXNuecesCountyParser(), "NUECES COUNTY", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:MetroCom Notification\nMEDICAL - UNCON, ALRM: 0, PRI: 1, ESZ: 67 / 2141 TULOSO RD CC NUECS: @SUNTIDE FEDERAL CU- TULOSO RD",
        "CALL:MEDICAL - UNCON",
        "PRI:1",
        "UNIT:67",
        "ADDR:2141 TULOSO RD",
        "CITY:CORPUS CHRISTI",
        "PLACE:SUNTIDE FEDERAL CU- TULOSO RD");

    doTest("T2",
        "Subject:MetorCom Notifiction\nAlarm – COMM-SML, ALRM: 0, PRI: 2, ESZ: 107 / 16318 fm 624 NUECS: @RIVER HILLS BASPTIST CHURCH",
        "CALL:Alarm – COMM-SML",
        "PRI:2",
        "UNIT:107",
        "ADDR:16318 fm 624",
        "PLACE:RIVER HILLS BASPTIST CHURCH");

    doTest("T3",
        "Subject:MetorCom Notifiction\nMEDICAL – ALLERGY, ALRM: 0, PRI: 2, ESZ: 2009 / 11559 LEOPARD ST CC NUECS: @CALALLEN MINOR EMERGENCY CLINI",
        "CALL:MEDICAL – ALLERGY",
        "PRI:2",
        "UNIT:2009",
        "ADDR:11559 LEOPARD ST",
        "CITY:CORPUS CHRISTI",
        "PLACE:CALALLEN MINOR EMERGENCY CLINI");

    doTest("T4",
        "Subject:MetorCom Notifiction\nFIRE-OTHER – GRASS, ALRM: 0, PRI: 1, ESZ 107 / HWY 77 FWY SB/CR 48 NUECS",
        "CALL:FIRE-OTHER – GRASS",
        "PRI:1",
        "UNIT:107",
        "ADDR:HWY 77 FWY SB & CR 48");

    doTest("T5",
        "Subject:MetorCom Notifiction\nMEDICAL – CHEST, ALRM: 0, PRI: 1, 104 / FM 43/FM 763 NUECS",
        "CALL:MEDICAL – CHEST",
        "PRI:1",
        "UNIT:104",
        "ADDR:FM 43 & FM 763");
  }
  
  public static void main(String[] args) {
    new TXNuecesCountyParserTest().generateTests("T1", "CALL PRI UNIT ADDR CITY PLACE");
  }
}
