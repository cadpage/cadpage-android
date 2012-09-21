package net.anei.cadpage.parsers.WA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


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
  
  public static void main(String[] args) {
    new WAYakimaCountyParserTest().generateTests("T1", "TIME DATE CALL ADDR PLACE SRC UNIT INFO");
  }
}