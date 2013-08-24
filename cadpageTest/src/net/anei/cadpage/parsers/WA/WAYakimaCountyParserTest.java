package net.anei.cadpage.parsers.WA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Yakima County, WA
Contact: Ken Shipman <ken.shipman@ycfd5.org>
Sender: wwantla@ci.yakima.wa.us
System: Spillman

08.22.10 02/07/12 EMR RED 505 MADISON AVE; GARFIELD SCHOOL TPFD TP1 YM06 TP0 UNK TYPE OF INJ  / OUTSIDE IN PLAYGROUND / 8 YR BOY - NURSE ON SCENE RP TOLD TO CALL - NOT ON SCENE MAIN PLAYGROUND - WILL MEET UNITS TO DIRECT
13.25.55 02/08/12 EMR MEDIC 904 POWELL ST GVFD GV1 GV0 PR12 POSS INJURY FROM A FALL
11.51.01 02/08/12 EMR MEDIC 330 NORTH ST;BLUE SKY MARKET MBFD MB1 MB0 PR12 SYNCOPE 65 YOF PER RP PT
10.33.11 02/08/12 EMR MEDIC 1580 N OLDENWAY RD LVFD LV6 LV06 YM01 ASSAULT TRIBAL PD ADV SCENE SECURE
13.25.55 02/08/12 EMR MEDIC 904 POWELL ST GVFD GV1 GV1 GV2 GV0 POSS INJURY FROM A FALL   GV1 CANCELLED ALL UNITS
11.39.20 02/08/12 ACCIDENT INJURY S 14TH ST & E MEAD AVE UGFD UG1 E85 ALS3 MVA KIA SOPHIA/ GRY OLDER DODG RAM LE150 RED/ONG blocking eb lanes
16.10.16 02/06/12 ACCIDENT INJURY W 5TH AVE & S BEECH ST TPFD TP1 YM06 YM08 TP0 RP ADV HE IS NOT INJ-FEM DRIVER OF OTHER VEH SEEMS TO HAVE NEVK/BACK PAIN BURGANDY TOYO CAMRY

Contact: Active911
Agency name: Yakima County Fire Dist 1
Location: Yakima, WA, United States

(Spillman Page) 10.24.35 02/16/13 EMR MEDIC 1117 TIETON AVE AMR  HL2 YM08 HL00 HEART PROBS 68YOF BEATHING NORMALLY, CONC ALERT OXYGEN LEVEL DOWN 76
(Spillman Page) 19.25.38 02/15/13 EMR MEDIC 1010 CANAL AVE HLFD HL2 ALS5 HL3 HL00 diabetic issue 62yof  con/alert  breathing ok throwing a fit  out of control high sugar  reads over 500 pt has not been feeling well today pt twitching was complaining of charlie horses in h
(Spillman Page) 19.25.38 02/15/13 EMR RED 1010 CANAL AVE HLFD HL2 ALS5 HL00 diabetic issue 62yof  con/alert  breathing ok throwing a fit  out of control
(Spillman Page) 16.33.30 02/13/13 EMR RED MAHONEY RD & N PIONEER WAY HLFD HL1 ALS2 HL00 UNRESPONSIVE SUBJ IN A VEH...
(Spillman Page) 17.57.26 02/12/13 CITIZEN ASSIST 17500 SUMMITVIEW RD ALS  HL1 ALS3 HL00 T602 FIRE ADVSD OF FEMALE HAVING AN ASMAH ATTACK
(Spillman Page) 17.57.26 02/12/13 EMR ALARM MED 17500 SUMMITVIEW RD ALS  HL1 ALS3 HL00
(Spillman Page) 12.30.03 02/07/13 EMR MEDIC 2185 FRANKLIN RD HLFD HL2 ALS5 HL2 HL00 BACK PAIN 24 yof adv she has had pain since 9 am unk what happened, adv she fainted from the pain conc alert breathing ok, unable to move adv she has hist of bacl probs
(Spillman Page) 06.47.39 02/04/13 PAGED SUMMITVIEW RD & MARBLE CT WVFD WV7 WV11 ALS3 ALS5 WV2 HLS1 WV12 C57 C94 ACC UNK INJURY PHASE 2 DROP. RP ADV BEFORE GRAVEL PIT ON SUMMITVIEW RD 2 VEH AFTER CLENDON AV ****new caller RIGHT BEFORE GRAVEL PIT, POSS 3 VEHS, UNKNOWN INJUR
(Spillman Page) 20.04.21 02/03/13 PAGED 1605 SUMMITVIEW AVE YKFD YK2 ALS3 HLS1 YM03 ILL FEM 38yof unresponsive fem, concious rp adv fem shaking line term
(Spillman Page) 19.39.44 01/31/13 EMR RED 493 SHARP RD HLFD HL2 ALS5 HL00 nose bleed 5 yo cons/alert been bleeding for the last 30 mins
(Spillman Page) 12.51.24 01/28/13 FIRE AUTO ALM 2 251 COWICHE CITY RD; Cowiche Growers Inc HLFD HL1 WV31 HL1 NHS9 HL00 2 fire trips north engine room heat detector ph# 509-678-4168

*/

public class WAYakimaCountyParserTest extends BaseParserTest {
  
  public WAYakimaCountyParserTest() {
    setParser(new WAYakimaCountyParser(), "YAKIMA COUNTY", "WA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "08.22.10 02/07/12 EMR RED 505 MADISON AVE; GARFIELD SCHOOL TPFD TP1 YM06 TP0 UNK TYPE OF INJ  / OUTSIDE IN PLAYGROUND / 8 YR BOY - NURSE ON SCENE RP TOLD TO CALL - NOT ON SCENE MAIN PLAYGROUND - WILL MEET UNITS TO DIRECT",
        "TIME:08:22:10",
        "DATE:02/07/12",
        "CALL:EMR RED",
        "ADDR:505 MADISON AVE",
        "PLACE:GARFIELD SCHOOL",
        "SRC:TPFD",
        "UNIT:TP1 YM06 TP0",
        "INFO:UNK TYPE OF INJ  / OUTSIDE IN PLAYGROUND / 8 YR BOY - NURSE ON SCENE RP TOLD TO CALL - NOT ON SCENE MAIN PLAYGROUND - WILL MEET UNITS TO DIRECT");

    doTest("T2",
        "13.25.55 02/08/12 EMR MEDIC 904 POWELL ST GVFD GV1 GV0 PR12 POSS INJURY FROM A FALL",
        "TIME:13:25:55",
        "DATE:02/08/12",
        "CALL:EMR MEDIC",
        "ADDR:904 POWELL ST",
        "SRC:GVFD",
        "UNIT:GV1 GV0 PR12",
        "INFO:POSS INJURY FROM A FALL");

    doTest("T3",
        "11.51.01 02/08/12 EMR MEDIC 330 NORTH ST;BLUE SKY MARKET MBFD MB1 MB0 PR12 SYNCOPE 65 YOF PER RP PT",
        "TIME:11:51:01",
        "DATE:02/08/12",
        "CALL:EMR MEDIC",
        "ADDR:330 NORTH ST",
        "PLACE:BLUE SKY MARKET",
        "SRC:MBFD",
        "UNIT:MB1 MB0 PR12",
        "INFO:SYNCOPE 65 YOF PER RP PT");

    doTest("T4",
        "10.33.11 02/08/12 EMR MEDIC 1580 N OLDENWAY RD LVFD LV6 LV06 YM01 ASSAULT TRIBAL PD ADV SCENE SECURE",
        "TIME:10:33:11",
        "DATE:02/08/12",
        "CALL:EMR MEDIC",
        "ADDR:1580 N OLDENWAY RD",
        "SRC:LVFD",
        "UNIT:LV6 LV06 YM01",
        "INFO:ASSAULT TRIBAL PD ADV SCENE SECURE");

    doTest("T5",
        "13.25.55 02/08/12 EMR MEDIC 904 POWELL ST GVFD GV1 GV1 GV2 GV0 POSS INJURY FROM A FALL   GV1 CANCELLED ALL UNITS",
        "TIME:13:25:55",
        "DATE:02/08/12",
        "CALL:EMR MEDIC",
        "ADDR:904 POWELL ST",
        "SRC:GVFD",
        "UNIT:GV1 GV1 GV2 GV0",
        "INFO:POSS INJURY FROM A FALL   GV1 CANCELLED ALL UNITS");

    doTest("T6",
        "11.39.20 02/08/12 ACCIDENT INJURY S 14TH ST & E MEAD AVE UGFD UG1 E85 ALS3 MVA KIA SOPHIA/ GRY OLDER DODG RAM LE150 RED/ONG blocking eb lanes",
        "TIME:11:39:20",
        "DATE:02/08/12",
        "CALL:ACCIDENT INJURY",
        "ADDR:S 14TH ST & E MEAD AVE",
        "SRC:UGFD",
        "UNIT:UG1 E85 ALS3",
        "INFO:MVA KIA SOPHIA/ GRY OLDER DODG RAM LE150 RED/ONG blocking eb lanes");

    doTest("T7",
        "16.10.16 02/06/12 ACCIDENT INJURY W 5TH AVE & S BEECH ST TPFD TP1 YM06 YM08 TP0 RP ADV HE IS NOT INJ-FEM DRIVER OF OTHER VEH SEEMS TO HAVE NEVK/BACK PAIN BURGANDY TOYO CAMRY",
        "TIME:16:10:16",
        "DATE:02/06/12",
        "CALL:ACCIDENT INJURY",
        "ADDR:W 5TH AVE & S BEECH ST",
        "SRC:TPFD",
        "UNIT:TP1 YM06 YM08 TP0",
        "INFO:RP ADV HE IS NOT INJ-FEM DRIVER OF OTHER VEH SEEMS TO HAVE NEVK/BACK PAIN BURGANDY TOYO CAMRY");
  }
  
  @Test
  public void testYakimaCountyFireDist1() {

    doTest("T1",
        "(Spillman Page) 10.24.35 02/16/13 EMR MEDIC 1117 TIETON AVE AMR  HL2 YM08 HL00 HEART PROBS 68YOF BEATHING NORMALLY, CONC ALERT OXYGEN LEVEL DOWN 76",
        "TIME:10:24:35",
        "DATE:02/16/13",
        "CALL:EMR MEDIC",
        "ADDR:1117 TIETON AVE",
        "SRC:AMR",
        "UNIT:HL2 YM08 HL00",
        "INFO:HEART PROBS 68YOF BEATHING NORMALLY, CONC ALERT OXYGEN LEVEL DOWN 76");

    doTest("T2",
        "(Spillman Page) 19.25.38 02/15/13 EMR MEDIC 1010 CANAL AVE HLFD HL2 ALS5 HL3 HL00 diabetic issue 62yof  con/alert  breathing ok throwing a fit  out of control high sugar  reads over 500 pt has not been feeling well today pt twitching was complaining of charlie horses in h",
        "TIME:19:25:38",
        "DATE:02/15/13",
        "CALL:EMR MEDIC",
        "ADDR:1010 CANAL AVE",
        "SRC:HLFD",
        "UNIT:HL2 ALS5 HL3 HL00",
        "INFO:diabetic issue 62yof  con/alert  breathing ok throwing a fit  out of control high sugar  reads over 500 pt has not been feeling well today pt twitching was complaining of charlie horses in h");

    doTest("T3",
        "(Spillman Page) 19.25.38 02/15/13 EMR RED 1010 CANAL AVE HLFD HL2 ALS5 HL00 diabetic issue 62yof  con/alert  breathing ok throwing a fit  out of control",
        "TIME:19:25:38",
        "DATE:02/15/13",
        "CALL:EMR RED",
        "ADDR:1010 CANAL AVE",
        "SRC:HLFD",
        "UNIT:HL2 ALS5 HL00",
        "INFO:diabetic issue 62yof  con/alert  breathing ok throwing a fit  out of control");

    doTest("T4",
        "(Spillman Page) 16.33.30 02/13/13 EMR RED MAHONEY RD & N PIONEER WAY HLFD HL1 ALS2 HL00 UNRESPONSIVE SUBJ IN A VEH...",
        "TIME:16:33:30",
        "DATE:02/13/13",
        "CALL:EMR RED",
        "ADDR:MAHONEY RD & N PIONEER WAY",
        "SRC:HLFD",
        "UNIT:HL1 ALS2 HL00",
        "INFO:UNRESPONSIVE SUBJ IN A VEH...");

    doTest("T5",
        "(Spillman Page) 17.57.26 02/12/13 CITIZEN ASSIST 17500 SUMMITVIEW RD ALS  HL1 ALS3 HL00 T602 FIRE ADVSD OF FEMALE HAVING AN ASMAH ATTACK",
        "TIME:17:57:26",
        "DATE:02/12/13",
        "CALL:CITIZEN ASSIST",
        "ADDR:17500 SUMMITVIEW RD",
        "SRC:ALS",
        "UNIT:HL1 ALS3 HL00 T602",
        "INFO:FIRE ADVSD OF FEMALE HAVING AN ASMAH ATTACK");

    doTest("T6",
        "(Spillman Page) 17.57.26 02/12/13 EMR ALARM MED 17500 SUMMITVIEW RD ALS  HL1 ALS3 HL00",
        "TIME:17:57:26",
        "DATE:02/12/13",
        "CALL:EMR ALARM MED",
        "ADDR:17500 SUMMITVIEW RD",
        "SRC:ALS",
        "UNIT:HL1 ALS3 HL00");

    doTest("T7",
        "(Spillman Page) 12.30.03 02/07/13 EMR MEDIC 2185 FRANKLIN RD HLFD HL2 ALS5 HL2 HL00 BACK PAIN 24 yof adv she has had pain since 9 am unk what happened, adv she fainted from the pain conc alert breathing ok, unable to move adv she has hist of bacl probs",
        "TIME:12:30:03",
        "DATE:02/07/13",
        "CALL:EMR MEDIC",
        "ADDR:2185 FRANKLIN RD",
        "SRC:HLFD",
        "UNIT:HL2 ALS5 HL2 HL00",
        "INFO:BACK PAIN 24 yof adv she has had pain since 9 am unk what happened, adv she fainted from the pain conc alert breathing ok, unable to move adv she has hist of bacl probs");

    doTest("T8",
        "(Spillman Page) 06.47.39 02/04/13 PAGED SUMMITVIEW RD & MARBLE CT WVFD WV7 WV11 ALS3 ALS5 WV2 HLS1 WV12 C57 C94 ACC UNK INJURY PHASE 2 DROP. RP ADV BEFORE GRAVEL PIT ON SUMMITVIEW RD 2 VEH AFTER CLENDON AV ****new caller RIGHT BEFORE GRAVEL PIT, POSS 3 VEHS, UNKNOWN INJUR",
        "TIME:06:47:39",
        "DATE:02/04/13",
        "CALL:PAGED",
        "ADDR:SUMMITVIEW RD & MARBLE CT",
        "SRC:WVFD",
        "UNIT:WV7 WV11 ALS3 ALS5 WV2 HLS1 WV12 C57 C94",
        "INFO:ACC UNK INJURY PHASE 2 DROP. RP ADV BEFORE GRAVEL PIT ON SUMMITVIEW RD 2 VEH AFTER CLENDON AV ****new caller RIGHT BEFORE GRAVEL PIT, POSS 3 VEHS, UNKNOWN INJUR");

    doTest("T9",
        "(Spillman Page) 20.04.21 02/03/13 PAGED 1605 SUMMITVIEW AVE YKFD YK2 ALS3 HLS1 YM03 ILL FEM 38yof unresponsive fem, concious rp adv fem shaking line term",
        "TIME:20:04:21",
        "DATE:02/03/13",
        "CALL:PAGED",
        "ADDR:1605 SUMMITVIEW AVE",
        "SRC:YKFD",
        "UNIT:YK2 ALS3 HLS1 YM03",
        "INFO:ILL FEM 38yof unresponsive fem, concious rp adv fem shaking line term");

    doTest("T10",
        "(Spillman Page) 19.39.44 01/31/13 EMR RED 493 SHARP RD HLFD HL2 ALS5 HL00 nose bleed 5 yo cons/alert been bleeding for the last 30 mins",
        "TIME:19:39:44",
        "DATE:01/31/13",
        "CALL:EMR RED",
        "ADDR:493 SHARP RD",
        "SRC:HLFD",
        "UNIT:HL2 ALS5 HL00",
        "INFO:nose bleed 5 yo cons/alert been bleeding for the last 30 mins");

    doTest("T11",
        "(Spillman Page) 12.51.24 01/28/13 FIRE AUTO ALM 2 251 COWICHE CITY RD; Cowiche Growers Inc HLFD HL1 WV31 HL1 NHS9 HL00 2 fire trips north engine room heat detector ph# 509-678-4168",
        "TIME:12:51:24",
        "DATE:01/28/13",
        "CALL:FIRE AUTO ALM 2",
        "ADDR:251 COWICHE CITY RD",
        "PLACE:Cowiche Growers Inc",
        "SRC:HLFD",
        "UNIT:HL1 WV31 HL1 NHS9 HL00",
        "INFO:2 fire trips north engine room heat detector ph# 509-678-4168");
 
  }
  
  public static void main(String[] args) {
    new WAYakimaCountyParserTest().generateTests("T1");
  }
}