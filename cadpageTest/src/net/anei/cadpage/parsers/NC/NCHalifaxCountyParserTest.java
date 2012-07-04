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
  
  @Test
  public void testTreyEvans() {

    doTest("T1",
        "HalifaxCoE911:* 1159 BACON RD* * * LITTLETON* * * * * ARSON* * * * 122,FI21* * * * *",
        "ADDR:1159 BACON RD",
        "CITY:LITTLETON",
        "CALL:ARSON",
        "UNIT:122,FI21");

    doTest("T2",
        "HalifaxCoE911:* ODELL LITTLETON RD // NEAR PANCEA SPRINGS* * * LITTLETON* * * * FIRE-BRUSH* * * * FI21* * * * *",
        "ADDR:ODELL LITTLETON RD",
        "MADDR:NEAR PANCEA SPRINGS,ODELL LITTLETON RD",
        "CITY:LITTLETON",
        "PLACE:NEAR PANCEA SPRINGS",
        "INFO:FIRE-BRUSH",
        "UNIT:FI21");

    doTest("T3",
        "HalifaxCoE911:* 110 WOODLAWN CT* * * LITTLETON* * * * * ALARM-FIRE* * * * FI21* * * * *",
        "ADDR:110 WOODLAWN CT",
        "CITY:LITTLETON",
        "CALL:ALARM-FIRE",
        "UNIT:FI21");

    doTest("T4",
        "HalifaxCoE911:* FAUCETTE STORE RD // 158* * * LITTLETON* * * * * WRECK UNKPI* * * * FI21,MED1,R154,SHP1* * * *",
        "ADDR:FAUCETTE STORE RD",
        "MADDR:158,FAUCETTE STORE RD",
        "CITY:LITTLETON",
        "PLACE:158",
        "CALL:WRECK UNKPI",
        "UNIT:FI21,MED1,R154,SHP1");

    doTest("T5",
        "HalifaxCoE911:* 105 SMOKETREE CT* * * LITTLETON* * * * * FIRE-CHECK* * * * FI21* * * * *",
        "ADDR:105 SMOKETREE CT",
        "CITY:LITTLETON",
        "CALL:FIRE-CHECK",
        "UNIT:FI21");

    doTest("T6",
        "HalifaxCoE911:* 130 EAST END AVE* * * LITTLETON* * * * * FIRE-SMOKE* * * * FI21* * * * *",
        "ADDR:130 EAST END AVE",
        "CITY:LITTLETON",
        "CALL:FIRE-SMOKE",
        "UNIT:FI21");

    doTest("T7",
        "HalifaxCoE911:* 863 ODELL LITTLETON RD* * * LITTLETON* * * * * WRECK UNKPI* * * EMS1,FI21,MED1* * * * *",
        "ADDR:863 ODELL LITTLETON RD",
        "CITY:LITTLETON",
        "CALL:WRECK UNKPI",
        "UNIT:EMS1,FI21,MED1");

    doTest("T8",
        "HalifaxCoE911:* 1515 GOLF COURSE RD* * * LITTLETON* * * * * FIRE-BRUSH* * * FI21* * * * *",
        "ADDR:1515 GOLF COURSE RD",
        "CITY:LITTLETON",
        "CALL:FIRE-BRUSH",
        "UNIT:FI21");

    doTest("T9",
        "HalifaxCoE911:* BIG REID RD* * * LITTLETON* * * * * FIRE-BRUSH* * * * F2101,FI21* * * * *",
        "ADDR:BIG REID RD",
        "CITY:LITTLETON",
        "CALL:FIRE-BRUSH",
        "UNIT:F2101,FI21");

    doTest("T10",
        "HalifaxCoE911:* HWY 903 // FLEMING DAIR RD* * * LITTLETON* * * * * FIRE-ELEC* * * * FI21* * * * *",
        "ADDR:HWY 903 & FLEMING DAIR RD",
        "CITY:LITTLETON",
        "CALL:FIRE-ELEC",
        "UNIT:FI21");
  }

  public static void main(String[] args) {
    new NCHalifaxCountyParserTest().generateTests("T1");
  }
}
