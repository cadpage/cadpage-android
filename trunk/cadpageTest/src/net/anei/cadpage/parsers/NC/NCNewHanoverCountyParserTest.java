package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCNewHanoverCountyParserTest extends BaseParserTest {
  
  public NCNewHanoverCountyParserTest() {
    setParser(new NCNewHanoverCountyParser(), "NEW HANOVER COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Station 21) CAD:ST21;RESIDENTIAL SINGLE ALARM;1107 CANAL DR;****TAC3*****;resd altrm... kitchen heat [04/11/12 14:19:37 LLA] *****tac3***** [04/11/12 1",
        "SRC:ST21",
        "CALL:RESIDENTIAL SINGLE ALARM",
        "ADDR:1107 CANAL DR",
        "CH:TAC3",
        "INFO:resd altrm... kitchen heat / *tac3*",
        "DATE:04/11/12",
        "TIME:14:19:37");

    doTest("T2",
        "CAD:ST21;ELEVATOR MALFUN OCCUPANTS IN;1109 BOWFIN LN;2522580313;stoke in elevator [05/10/12 05:59:33 ANL] [Fire Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Elevator / Escalator Rescue. Elevator malfunction -- occupants inside",
        "SRC:ST21",
        "CALL:ELEVATOR MALFUN OCCUPANTS IN",
        "ADDR:1109 BOWFIN LN",
        "ID:2522580313",
        "INFO:stoke in elevator / Elevator / Escalator Rescue. Elevator malfunction -- occupants inside",
        "DATE:05/10/12",
        "TIME:05:59:33");

    doTest("T3",
        "CAD:ST21;WATER PROBLEM;501 S DOW RD;DOG PARK;broken water pipe gushing water [05/07/12 20:21:48 LAM] PRE ALERT GIVEN [05/07/12 20:22:42 KDN] [Fire Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Citizen Assist / Service Call. Water probl;M",
        "SRC:ST21",
        "CALL:WATER PROBLEM",
        "ADDR:501 S DOW RD",
        "PLACE:DOG PARK",
        "INFO:broken water pipe gushing water / PRE ALERT GIVEN / Citizen Assist / Service Call. Water probl / M",
        "DATE:05/07/12",
        "TIME:20:21:48");

    doTest("T4",
        "CAD:ST21;HAZMAT UNCONTAINED;78 MYRTLE AVE;****TAC2****;sewage problem [05/05/12 11:24:02 MLM] [Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: HAZMAT. UNCONTAINED HAZMAT (Biological). 1.The caller is on scene (1st party).",
        "SRC:ST21",
        "CALL:HAZMAT UNCONTAINED",
        "ADDR:78 MYRTLE AVE",
        "CH:TAC2",
        "INFO:sewage problem / HAZMAT. UNCONTAINED HAZMAT (Biological). 1.The caller is on scene (1st party).",
        "DATE:05/05/12",
        "TIME:11:24:02");

    doTest("T5",
        "CAD:ST21;LARGE OUTSIDE FIRE;100 FREEMAN PARK;NORTH END;caller adv she is at the north end on carolina beach...a large group has a bonfire going..... [05/04/12 23:15:17 EEB] *******PRE ALRET*******OUTSIDE FIRE [05/04/12 23:15:59 EEB]",
        "SRC:ST21",
        "CALL:LARGE OUTSIDE FIRE",
        "ADDR:100 FREEMAN PARK",  // Not mapping
        "PLACE:NORTH END",
        "INFO:caller adv she is at the north end on carolina beach...a large group has a bonfire going..... / *PRE ALRET*OUTSIDE FIRE",
        "DATE:05/04/12",
        "TIME:23:15:17");

    doTest("T6",
        "CAD:ST21;RESIDENTIAL SINGLE STRUCTURE;1300 CANAL DR;fire under the house [05/04/12 19:46:14 MJL] [Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Residential (single). 1.The caller is on scene (1st party). 2.Smoke is v",
        "SRC:ST21",
        "CALL:RESIDENTIAL SINGLE STRUCTURE",
        "ADDR:1300 CANAL DR",
        "INFO:fire under the house / Structure Fire. Residential (single). 1.The caller is on scene (1st party). 2.Smoke is v",
        "DATE:05/04/12",
        "TIME:19:46:14");
  }

  public static void main(String[] args) {
    new NCNewHanoverCountyParserTest().generateTests("T1");
  }
}
