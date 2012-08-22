package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CTNewHavenCountyBParserTest extends BaseParserTest {
  
  public CTNewHavenCountyBParserTest() {
    setParser(new CTNewHavenCountyBParser(), "NORTH BRANFORD", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "1100008173 MEDICAL MEDA 00167  BRANFORD RD HUBBARD RD/TWIN LAKE RD  MED4 503 110910 11:50",
        "ID:1100008173",
        "CALL:MEDICAL MEDA",
        "ADDR:167 BRANFORD RD",
        "X:HUBBARD RD / TWIN LAKE RD",
        "UNIT:MED4 503",
        "DATE:09/10/11",
        "TIME:11:50");

    doTest("T2",
        "1100008148 MEDICAL MEDD 00009  SALEM ST CLINTONVILLE RD/VILLAGE ST  MED4 R2 110909 17:55",
        "ID:1100008148",
        "CALL:MEDICAL MEDD",
        "ADDR:9 SALEM ST",
        "X:CLINTONVILLE RD / VILLAGE ST",
        "UNIT:MED4 R2",
        "DATE:09/09/11",
        "TIME:17:55");

    doTest("T3",
        "1100008142 MUTUAL AID 00392  HOPE HILL RD WALLINGFORD    MED4 110909 15:38",
        "ID:1100008142",
        "CALL:MUTUAL AID",
        "ADDR:392 HOPE HILL RD",
        "X:WALLINGFORD",
        "UNIT:MED4",
        "DATE:09/09/11",
        "TIME:15:38");

    doTest("T4",
        "1100008130 AUTOMATIC FIRE ALARM 00051  CIRO RD FOXON RD/DEAD END  E1 ET11 ET22 T1 R11 515 110909 10:07",
        "ID:1100008130",
        "CALL:AUTOMATIC FIRE ALARM",
        "ADDR:51 CIRO RD",
        "X:FOXON RD / DEAD END",
        "UNIT:E1 ET11 ET22 T1 R11 515",
        "DATE:09/09/11",
        "TIME:10:07");

    doTest("T5",
        "1100008128 MEDICAL MEDB 00049  CAPUTO RD FOXON RD ROUTE 80/MILL RD  R1 MED4 515 110909 08:38",
        "ID:1100008128",
        "CALL:MEDICAL MEDB",
        "ADDR:49 CAPUTO RD",
        "X:FOXON RD ROUTE 80 / MILL RD",
        "UNIT:R1 MED4 515",
        "DATE:09/09/11",
        "TIME:08:38");

    doTest("T6",
        "1100007980 BRUSH FIRE TWIN LAKES RD/ LAKE RD   BR1 ET11 502 110904 12:22",
        "ID:1100007980",
        "CALL:BRUSH FIRE TWIN",
        "ADDR:LAKES RD & LAKE RD",
        "UNIT:BR1 ET11 502",
        "DATE:09/04/11",
        "TIME:12:22");
  }
  
  @Test
  public void testWLFDParser() {

    doTest("T1",
        "1100008057 MVA W/INJURIES N MAIN ST/RT68 WLFD A44 110906 17:05",
        "ID:1100008057",
        "CALL:MVA W/INJURIES",
        "ADDR:N MAIN ST & RT68",
        "MADDR:N MAIN ST & RT 68",
        "CITY:WALLINFORD",
        "UNIT:A44",
        "DATE:09/06/11",
        "TIME:17:05");

    doTest("T2",
        "1100007014 MUTUAL AID 00909  BEAVER HEAD RD , GUILFORD    MED4 110811 01:16",
        "ID:1100007014",
        "CALL:MUTUAL AID",
        "ADDR:909 BEAVER HEAD RD",
        "CITY:GUILFORD",
        "UNIT:MED4",
        "DATE:08/11/11",
        "TIME:01:16");
  
  }
  
  @Test
  public void testNorthBrandon() {

    doTest("T1",
        "1100010113 MEDICAL MEDC 00254  BRANFORD RD Prem Map -  HARRISON RD/FOXON RD  MED4 R1 111116 23:04\n",
        "ID:1100010113",
        "CALL:MEDICAL MEDC",
        "ADDR:254 BRANFORD RD",
        "X:HARRISON RD / FOXON RD",
        "UNIT:MED4 R1",
        "DATE:11/16/11",
        "TIME:23:04");

    doTest("T2",
        "1100011295 MEDICAL MEDD 01739 FOXON RD NORTH ST/SEA HILL RD  MED4 R1 111230 23:13\n",
        "ID:1100011295",
        "CALL:MEDICAL MEDD",
        "ADDR:1739 FOXON RD",
        "X:NORTH ST / SEA HILL RD",
        "UNIT:MED4 R1",
        "DATE:12/30/11",
        "TIME:23:13");

    doTest("T3",
        "1100011302 MUTUAL AID 00260 FOREST RD JERZ LN/OLD FOREST RD  MED4 111231 03:49\n",
        "ID:1100011302",
        "CALL:MUTUAL AID",
        "ADDR:260 FOREST RD",
        "X:JERZ LN / OLD FOREST RD",
        "UNIT:MED4",
        "DATE:12/31/11",
        "TIME:03:49");

    doTest("T4",
        "1100011303 MEDICAL MEDA 00043 WOODCHASE LN TOTOKET RD/MILL RD  515 MED4 111231 05:02\n",
        "ID:1100011303",
        "CALL:MEDICAL MEDA",
        "ADDR:43 WOODCHASE LN",
        "X:TOTOKET RD / MILL RD",
        "UNIT:515 MED4",
        "DATE:12/31/11",
        "TIME:05:02");
  
  }
  
  @Test
  public void testEastHaven() {

    doTest("T1",
        "1100005182 ALPHA MEDICAL 00055 THOMPSON ST  Prem Map -14 PP 65 FOXON RD/GAY ST  (Prem Map -14 PP 65)    S5 111120 15:40",
        "ID:1100005182",
        "CALL:ALPHA MEDICAL",
        "ADDR:55 THOMPSON ST",
        "MAP:14 PP 65",
        "X:FOXON RD / GAY ST",
        "UNIT:S5",
        "DATE:11/20/11",
        "TIME:15:40");

    doTest("T2",
        "1100004628 CHARLIE MEDICAL TF1 00057 MAIN ST Prem Map -5 PP 80 SALTONSTALL PKWY/DEBORAH LA (Prem Map -5 PP 80) R1 111017 09:16",
        "ID:1100004628",
        "CALL:CHARLIE MEDICAL TF1",
        "ADDR:57 MAIN ST",
        "MAP:5 PP 80",
        "X:SALTONSTALL PKWY / DEBORAH LA",
        "UNIT:R1",
        "DATE:10/17/11",
        "TIME:09:16");

    doTest("T3",
        "1100004627 CHARLIE MEDICAL TF3 00267 RUSSO AVE Map -13 BRENNAN ST/ANN ST S5 111017 03:25",
        "ID:1100004627",
        "CALL:CHARLIE MEDICAL TF3",
        "ADDR:267 RUSSO AVE",
        "MAP:13",
        "X:BRENNAN ST / ANN ST",
        "UNIT:S5",
        "DATE:10/17/11",
        "TIME:03:25");

    doTest("T4",
        "1100004626 MVA WITH INJURIES LAUREL ST/ NORTH HIGH ST E1 R1 C4 S2 111016 23:29",
        "ID:1100004626",
        "CALL:MVA WITH INJURIES",
        "ADDR:LAUREL ST & NORTH HIGH ST",
        "X:E1 R1 C4",
        "UNIT:S2",
        "DATE:10/16/11",
        "TIME:23:29");

    doTest("T5",
        "1100004625 CHARLIE MEDICAL TF4A 00038 TALMADGE AVE Prem Map -3 PP165 POND ST/DEAD END (Prem Map -3 PP165) R1 111016 22:00",
        "ID:1100004625",
        "CALL:CHARLIE MEDICAL TF4A",
        "ADDR:38 TALMADGE AVE",
        "MAP:3 PP165",
        "X:POND ST / DEAD END",
        "UNIT:R1",
        "DATE:10/16/11",
        "TIME:22:00");

    doTest("T6",
        "1100004612 ALPHA MEDICAL 01270 NORTH HIGH ST Prem Map -14 PP 63 CORBIN RD/MAPLE ST S5 111015 21:49",
        "ID:1100004612",
        "CALL:ALPHA MEDICAL",
        "ADDR:1270 NORTH HIGH ST",
        "MAP:14 PP 63",
        "X:CORBIN RD / MAPLE ST",
        "UNIT:S5",
        "DATE:10/15/11",
        "TIME:21:49");

    doTest("T7",
        "1100004608 DELTA MEDICAL TF1 00152 KIMBERLY AVE Map -7 PARDEE PL/KIMBERLY AVE R1 111015 19:03",
        "ID:1100004608",
        "CALL:DELTA MEDICAL TF1",
        "ADDR:152 KIMBERLY AVE",
        "MAP:7",
        "X:PARDEE PL / KIMBERLY AVE",
        "UNIT:R1",
        "DATE:10/15/11",
        "TIME:19:03");
  }
  
  @Test
  public void testRalphSpuduzzi() {

    doTest("T1",
        "1200003638 AFA NIGHT RESPONSE 00003 COSEY BEACH AVE  Prem Map -2 PP 88 FOUR BEACHES ENTRANCE/JAMACA CO  E4 E1 T3 E6 R1 R4 S2 C4 120820\r",
        "ID:1200003638",
        "CALL:AFA NIGHT RESPONSE",
        "ADDR:3 COSEY BEACH AVE",
        "MAP:2 PP 88",
        "X:FOUR BEACHES ENTRANCE / JAMACA CO",
        "UNIT:E4 E1 T3 E6 R1 R4 S2 C4");

  }
  
  public static void main(String[] args) {
    new CTNewHavenCountyBParserTest().generateTests("T1", "ID CALL ADDR CITY MAP X UNIT DATE TIME");
  }
}