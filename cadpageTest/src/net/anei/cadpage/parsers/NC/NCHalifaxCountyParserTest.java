package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCHalifaxCountyParserTest extends BaseParserTest {
  
  public NCHalifaxCountyParserTest() {
    setParser(new NCHalifaxCountyParser(), "HALIFAX COUNTY", "NC");
  }
  
  @Test
  public void testParser() {


    doTest("T1",
        "HalifaxCoE911@HalifaxNC911.com S: M:HalifaxCoE911:* JACKSON ST // 7TH ST* * * ROANOKE RAPIDS* * * * * WRECK NOPI* * * * C181,C182,FI14* * * * *",
        "ADDR:JACKSON ST & 7TH ST",
        "CITY:ROANOKE RAPIDS",
        "CALL:WRECK NOPI",
        "UNIT:C181,C182,FI14");

    doTest("T2",
        "HalifaxCoE911@HalifaxNC911.com S: M:HalifaxCoE911:* HWY 158 // AVE* * * ROANOKE RAPIDS* * * * * WRECK NOPI* * * * EMS4,EMS6,FI14* * * * *",
        "ADDR:HWY 158",
        "MADDR:AVE,HWY 158",
        "CITY:ROANOKE RAPIDS",
        "PLACE:AVE",
        "CALL:WRECK NOPI",
        "UNIT:EMS4,EMS6,FI14");

    doTest("T3",
        "HalifaxCoE911@HalifaxNC911.com S: M:HalifaxCoE911:* 1403 EAST 10TH ST* * * ROANOKE RAPIDS* * * * * FIRE-ELEC* * * * FI14* * * * *",
        "ADDR:1403 EAST 10TH ST",
        "CITY:ROANOKE RAPIDS",
        "CALL:FIRE-ELEC",
        "UNIT:FI14");

    doTest("T4",
        "HalifaxCoE911@HalifaxNC911.com S: M:HalifaxCoE911:* PILAND ST* * * ROANOKE RAPIDS* * * * * SPECIAL ASSG* * * * F1402,FI14* * * * *",
        "ADDR:PILAND ST",
        "CITY:ROANOKE RAPIDS",
        "CALL:SPECIAL ASSG",
        "UNIT:F1402,FI14");

    doTest("T5",
        "HalifaxCoE911@HalifaxNC911.com S: M:HalifaxCoE911:* SUBWAY // JULLIAN R ALLSBROOK* * * ROANOKE RAPIDS* * * * * WRECK NOPI* * * * FI14* * * * *",
        "ADDR:SUBWAY & JULLIAN R ALLSBROOK",
        "CITY:ROANOKE RAPIDS",
        "CALL:WRECK NOPI",
        "UNIT:FI14");

    doTest("T6",
        "HalifaxCoE911@HalifaxNC911.com S: M:HalifaxCoE911:* 93 ROANOKE AVE* * * ROANOKE RAPIDS* * * * * FIRE-SMOKE* * * * FI14* * * * *",
        "ADDR:93 ROANOKE AVE",
        "CITY:ROANOKE RAPIDS",
        "CALL:FIRE-SMOKE",
        "UNIT:FI14");
  }

  public static void main(String[] args) {
    new NCHalifaxCountyParserTest().generateTests("T1");
  }
}
