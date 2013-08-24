package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*    
Lincoln City, OR
Contact: Andrew Cooper <andrew.cooper1@live.com>
Sender: Group_Page_Notification@usamobility.net

UNKMED1 NLF () Loc:1550 SE 14TH ST: 5 Rcvd: 12:10:54 Units: D1141 E12133366 Comments: 75 YO FEMALE SEVERE MIGRANE HEADAC
FIRES NLF () Loc:1543 NE 14TH ST Rcvd: 20:57:13 Units: C1161 E12129759 Comments: STRUCTURE FIRE HYDE PARK [75]
WATER1 NLF () Loc:NW LOGAN RD & ACCESS Rcvd: 13:51:1 Units: D1141 E12130984 Comments: 3 KIDS OUT SURFING 200 YARDS SOUT
FALL1 NLF () Loc:175 SILETZ HW Rcvd: 00:10:35 Units: Q1636 E12127387 Comments: MEDICS REQUESTING ASSIST WITH LIFT ASSIST
ACC1 NLF () Loc:NE 20TH PL & NE WEST DEVILS LAKE RD Rcvd: 12:40:26 Units: D1141 E12112828 Comments: SINGLE VEH MVA UNK INJURY LIGHT SMOKE FROM

*/

public class ORLincolnCityParserTest extends BaseParserTest {
  
  public ORLincolnCityParserTest() {
    setParser(new ORLincolnCityParser(), "LINCOLN CITY", "OR");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "UNKMED1 NLF () Loc:1550 SE 14TH ST: 5 Rcvd: 12:10:54 Units: D1141 E12133366 Comments: 75 YO FEMALE SEVERE MIGRANE HEADAC",
        "CALL:UNKMED1 NLF",
        "ADDR:1550 SE 14TH ST",
        "APT:5",
        "TIME:12:10:54",
        "UNIT:D1141",
        "ID:E12133366",
        "INFO:75 YO FEMALE SEVERE MIGRANE HEADAC");

    doTest("T2",
        "FIRES NLF () Loc:1543 NE 14TH ST Rcvd: 20:57:13 Units: C1161 E12129759 Comments: STRUCTURE FIRE HYDE PARK [75]",
        "CALL:FIRES NLF",
        "ADDR:1543 NE 14TH ST",
        "TIME:20:57:13",
        "UNIT:C1161",
        "ID:E12129759",
        "INFO:STRUCTURE FIRE HYDE PARK [75]");

    doTest("T3",
        "WATER1 NLF () Loc:NW LOGAN RD & ACCESS Rcvd: 13:51:1 Units: D1141 E12130984 Comments: 3 KIDS OUT SURFING 200 YARDS SOUT",
        "CALL:WATER1 NLF",
        "ADDR:NW LOGAN RD & ACCESS",  // Not mapping
        "TIME:13:51:1",
        "UNIT:D1141",
        "ID:E12130984",
        "INFO:3 KIDS OUT SURFING 200 YARDS SOUT");

    doTest("T4",
        "FALL1 NLF () Loc:175 SILETZ HW Rcvd: 00:10:35 Units: Q1636 E12127387 Comments: MEDICS REQUESTING ASSIST WITH LIFT ASSIST",
        "CALL:FALL1 NLF",
        "ADDR:175 SILETZ HW",
        "MADDR:175 SILETZ HWY",
        "TIME:00:10:35",
        "UNIT:Q1636",
        "ID:E12127387",
        "INFO:MEDICS REQUESTING ASSIST WITH LIFT ASSIST");

    doTest("T5",
        "ACC1 NLF () Loc:NE 20TH PL & NE WEST DEVILS LAKE RD Rcvd: 12:40:26 Units: D1141 E12112828 Comments: SINGLE VEH MVA UNK INJURY LIGHT SMOKE FROM",
        "CALL:ACC1 NLF",
        "ADDR:NE 20TH PL & NE WEST DEVILS LAKE RD",
        "TIME:12:40:26",
        "UNIT:D1141",
        "ID:E12112828",
        "INFO:SINGLE VEH MVA UNK INJURY LIGHT SMOKE FROM");

  }
  
  public static void main(String args[]) {
    new ORLincolnCityParserTest().generateTests("T1");
  }
}