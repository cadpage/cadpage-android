package net.anei.cadpage.parsers.OK;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Pontonoc County, OK
Contact: Active911
Agency name: Ada Fire Department
Location: Ada, OK, United States
Sender: paging@adaok.com

(DispatchAlert) MEDICAL CALL \n231 W MAIN
(DispatchAlert) ALARM/FIRE \n200 S BROADWAY
(DispatchAlert) SMOKE INVESTIGATION \n1921 STONECIPHER BLVD
(DispatchAlert) CONTROLLED BURN \n11136 CR 3560
(DispatchAlert) CONTROLLED BURN \n1111 N OAK
(DispatchAlert) STABBING \n2530 OAKHURST, Apt. A
(DispatchAlert) ALARM/FIRE \n200 S BROADWAY
(DispatchAlert) ALARM/FIRE \n1307 CHICKASAW  PL
(DispatchAlert) CONTROLLED BURN \n17145 CR 99 DR
(DispatchAlert) ACCIDENT/UNKNOWN INJURY \nSH19 AND SH3W
(DispatchAlert) FIRE/STRUCTURE \n403 ORANGE
(DispatchAlert) CONTROLLED BURN \n17145 CR 99 DR
(DispatchAlert) ALARM/FIRE \n200 S BROADWAY
(DispatchAlert) CONTROLLED BURN \n13651 CR 1560
(DispatchAlert) BREATHING PROBLEMS \n1131 JACK JOHN CIR
(DispatchAlert) FIRE/CHIMNEY \n21106 CR 3 DR
(DispatchAlert) SMOKE INVESTIGATION \nE OF RAM JACK CR 1570 E OF TRACKS
(DispatchAlert) CONTROLLED BURN \n1111 N OAK
(DispatchAlert) ALARM/FIRE \n1100 E 14TH
(DispatchAlert) GAS LEAK \nHICKORY & 3RD
(DispatchAlert) MOTOR ASSIST \nSH 3 E
(DispatchAlert) FIRE/BRUSH \n619 W 14TH
(DispatchAlert) FIRE/VEHICLE \n408 W 7TH
(DispatchAlert) WATER LEAK \n2009 E 11TH
(DispatchAlert) FIRE/STRUCTURE \n902 GILMORE
(DispatchAlert) GAS LEAK \n815 ARLINGTON
(DispatchAlert) FIRE/GRASS \nCR 1520
(DispatchAlert) GAS LEAK \n630 W 5TH, Apt. 1/2
(DispatchAlert) ACCIDENT/MINOR \nBROADWAY AND TOWER
(DispatchAlert) FIRE/GRASS \n15730 CR 1510
(DispatchAlert) MEDICAL CALL \n1920 HAMPTON WAY
(DispatchAlert) ACCIDENT/INJURY \nCR 3470 2 AND HALF MILES S OF FARMERS MARKET
(DispatchAlert) UNRESPONSIVE SUBJECT \n931 N COUNTRY CLUB
(DispatchAlert) FIRE/GRASS \n1 S 99S
(DispatchAlert) GAS LEAK \n815 W 13TH
(DispatchAlert) FIRE/CHIMNEY \n19725 CR 1546
(DispatchAlert) ALARM/FIRE \n200 S BROADWAY
(DispatchAlert) ALARM/FIRE \n626 W 15TH
(DispatchAlert) ACCIDENT/UNKNOWN INJURY \n31210 SH 99S, Apt. FITTSTOWN
(DispatchAlert) FIRE/STRUCTURE \n130 N ROLAND
(DispatchAlert) ALARM/RES \n200 S BROADWAY
(DispatchAlert) FIRE/GRASS \nARLINGTON JUST PAST ARLINGTON BLVD
(DispatchAlert) FIRE/MISC. \n129 W 14TH
(DispatchAlert) FIRE/STRUCTURE \n13340 CR 3630
(DispatchAlert) UNATTENDED DEATH \n1NEAR DENNY CEMETARY 495
(DispatchAlert) DOWN POWER LINE \n1024 BELLMONT
(DispatchAlert) DOWN POWER LINE \n329 W 14TH
(DispatchAlert) FIRE/MISC. \nBROADWAY AND KINGS
(DispatchAlert) ODOR INVESTIGATION \n14TH AND CONSTANT
(DispatchAlert) ACCIDENT/UNKNOWN INJURY \nARLINGTON AND COUNTRY CLUB
(DispatchAlert) MEDICAL CALL \n9837 CR 1545

Contact: Active911
Agency name: Homer Fire Department
Location: Ada, OK, United States
Sender: paging@adaok.com

(DispatchAlert) CONTROLLED BURN \n19335 CR 1550
(DispatchAlert) FALL \n407 RICHARDSON LP
(DispatchAlert) CONTROLLED BURN \n20012 CR 1541
(DispatchAlert) CONTROLLED BURN \n13024 CR 3614
(DispatchAlert) MEDICAL CALL \n13546 CR 3600, Apt. 11
(DispatchAlert) SICK OR INJURED PERSON \n18402 CR 1520
(DispatchAlert) BREATHING PROBLEMS \n21941 CR 1553
(DispatchAlert) FALL \n19600 CR 1555
(DispatchAlert) MEDICAL CALL \n13546 CR 3600, Apt. 11
(DispatchAlert) FIRE/CHIMNEY \n19725 CR 1546
(DispatchAlert) FIRE/GRASS \n14554 CR 3605

 */

public class OKPontotocCountyParserTest extends BaseParserTest {
  
  public OKPontotocCountyParserTest() {
    setParser(new OKPontotocCountyParser(), "PONTOTOC COUNTY", "OK");
  }
  
  @Test
  public void testAdaFireDepartment() {

    doTest("T1",
        "(DispatchAlert) MEDICAL CALL \n231 W MAIN",
        "CALL:MEDICAL CALL",
        "ADDR:231 W MAIN");

    doTest("T2",
        "(DispatchAlert) ALARM/FIRE \n200 S BROADWAY",
        "CALL:ALARM/FIRE",
        "ADDR:200 S BROADWAY");

    doTest("T3",
        "(DispatchAlert) SMOKE INVESTIGATION \n1921 STONECIPHER BLVD",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:1921 STONECIPHER BLVD");

    doTest("T4",
        "(DispatchAlert) CONTROLLED BURN \n11136 CR 3560",
        "CALL:CONTROLLED BURN",
        "ADDR:11136 CR 3560",
        "MADDR:11136 COUNTY ROAD 3560");

    doTest("T5",
        "(DispatchAlert) CONTROLLED BURN \n1111 N OAK",
        "CALL:CONTROLLED BURN",
        "ADDR:1111 N OAK");

    doTest("T6",
        "(DispatchAlert) STABBING \n2530 OAKHURST, Apt. A",
        "CALL:STABBING",
        "ADDR:2530 OAKHURST",
        "APT:A");

    doTest("T7",
        "(DispatchAlert) ALARM/FIRE \n200 S BROADWAY",
        "CALL:ALARM/FIRE",
        "ADDR:200 S BROADWAY");

    doTest("T8",
        "(DispatchAlert) ALARM/FIRE \n1307 CHICKASAW  PL",
        "CALL:ALARM/FIRE",
        "ADDR:1307 CHICKASAW  PL");

    doTest("T9",
        "(DispatchAlert) CONTROLLED BURN \n17145 CR 99 DR",
        "CALL:CONTROLLED BURN",
        "ADDR:17145 CR 99 DR",   // Can't find this
        "MADDR:17145 COUNTY ROAD 99 DR");

    doTest("T10",
        "(DispatchAlert) ACCIDENT/UNKNOWN INJURY \nSH19 AND SH3W",
        "CALL:ACCIDENT/UNKNOWN INJURY",
        "ADDR:SH19 AND SH3W",  
        "MADDR:OK 19 & OK 3W");

    doTest("T11",
        "(DispatchAlert) FIRE/STRUCTURE \n403 ORANGE",
        "CALL:FIRE/STRUCTURE",
        "ADDR:403 ORANGE");

    doTest("T12",
        "(DispatchAlert) CONTROLLED BURN \n17145 CR 99 DR",
        "CALL:CONTROLLED BURN",
        "ADDR:17145 CR 99 DR",
        "MADDR:17145 COUNTY ROAD 99 DR");

    doTest("T13",
        "(DispatchAlert) ALARM/FIRE \n200 S BROADWAY",
        "CALL:ALARM/FIRE",
        "ADDR:200 S BROADWAY");

    doTest("T14",
        "(DispatchAlert) CONTROLLED BURN \n13651 CR 1560",
        "CALL:CONTROLLED BURN",
        "ADDR:13651 CR 1560",
        "MADDR:13651 COUNTY ROAD 1560");

    doTest("T15",
        "(DispatchAlert) BREATHING PROBLEMS \n1131 JACK JOHN CIR",
        "CALL:BREATHING PROBLEMS",
        "ADDR:1131 JACK JOHN CIR");

    doTest("T16",
        "(DispatchAlert) FIRE/CHIMNEY \n21106 CR 3 DR",
        "CALL:FIRE/CHIMNEY",
        "ADDR:21106 CR 3 DR",
        "MADDR:21106 COUNTY ROAD 3 DR");

    doTest("T17",
        "(DispatchAlert) SMOKE INVESTIGATION \nE OF RAM JACK CR 1570 E OF TRACKS",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:E OF RAM JACK CR 1570 E OF TRACKS",
        "MADDR:E OF RAM JACK COUNTY ROAD 1570 & TRACKS");

    doTest("T18",
        "(DispatchAlert) CONTROLLED BURN \n1111 N OAK",
        "CALL:CONTROLLED BURN",
        "ADDR:1111 N OAK");

    doTest("T19",
        "(DispatchAlert) ALARM/FIRE \n1100 E 14TH",
        "CALL:ALARM/FIRE",
        "ADDR:1100 E 14TH");

    doTest("T20",
        "(DispatchAlert) GAS LEAK \nHICKORY & 3RD",
        "CALL:GAS LEAK",
        "ADDR:HICKORY & 3RD");

    doTest("T21",
        "(DispatchAlert) MOTOR ASSIST \nSH 3 E",
        "CALL:MOTOR ASSIST",
        "ADDR:SH 3 E",
        "MADDR:OK 3 E");

    doTest("T22",
        "(DispatchAlert) FIRE/BRUSH \n619 W 14TH",
        "CALL:FIRE/BRUSH",
        "ADDR:619 W 14TH");

    doTest("T23",
        "(DispatchAlert) FIRE/VEHICLE \n408 W 7TH",
        "CALL:FIRE/VEHICLE",
        "ADDR:408 W 7TH");

    doTest("T24",
        "(DispatchAlert) WATER LEAK \n2009 E 11TH",
        "CALL:WATER LEAK",
        "ADDR:2009 E 11TH");

    doTest("T25",
        "(DispatchAlert) FIRE/STRUCTURE \n902 GILMORE",
        "CALL:FIRE/STRUCTURE",
        "ADDR:902 GILMORE");

    doTest("T26",
        "(DispatchAlert) GAS LEAK \n815 ARLINGTON",
        "CALL:GAS LEAK",
        "ADDR:815 ARLINGTON");

    doTest("T27",
        "(DispatchAlert) FIRE/GRASS \nCR 1520",
        "CALL:FIRE/GRASS",
        "ADDR:CR 1520",
        "MADDR:COUNTY ROAD 1520");

    doTest("T28",
        "(DispatchAlert) GAS LEAK \n630 W 5TH, Apt. 1/2",
        "CALL:GAS LEAK",
        "ADDR:630 W 5TH",
        "APT:1/2");

    doTest("T29",
        "(DispatchAlert) ACCIDENT/MINOR \nBROADWAY AND TOWER",
        "CALL:ACCIDENT/MINOR",
        "ADDR:BROADWAY AND TOWER",
        "MADDR:BROADWAY & TOWER");

    doTest("T30",
        "(DispatchAlert) FIRE/GRASS \n15730 CR 1510",
        "CALL:FIRE/GRASS",
        "ADDR:15730 CR 1510",
        "MADDR:15730 COUNTY ROAD 1510");

    doTest("T31",
        "(DispatchAlert) MEDICAL CALL \n1920 HAMPTON WAY",
        "CALL:MEDICAL CALL",
        "ADDR:1920 HAMPTON WAY");

    doTest("T32",
        "(DispatchAlert) ACCIDENT/INJURY \nCR 3470 2 AND HALF MILES S OF FARMERS MARKET",
        "CALL:ACCIDENT/INJURY",
        "ADDR:CR 3470 2 AND HALF MILES S OF FARMERS MARKET",
        "MADDR:COUNTY ROAD 3470 2 & HALF MILES & FARMERS MARKET");

    doTest("T33",
        "(DispatchAlert) UNRESPONSIVE SUBJECT \n931 N COUNTRY CLUB",
        "CALL:UNRESPONSIVE SUBJECT",
        "ADDR:931 N COUNTRY CLUB");

    doTest("T34",
        "(DispatchAlert) FIRE/GRASS \n1 S 99S",
        "CALL:FIRE/GRASS",
        "ADDR:1 S 99S");

    doTest("T35",
        "(DispatchAlert) GAS LEAK \n815 W 13TH",
        "CALL:GAS LEAK",
        "ADDR:815 W 13TH");

    doTest("T36",
        "(DispatchAlert) FIRE/CHIMNEY \n19725 CR 1546",
        "CALL:FIRE/CHIMNEY",
        "ADDR:19725 CR 1546",
        "MADDR:19725 COUNTY ROAD 1546");

    doTest("T37",
        "(DispatchAlert) ALARM/FIRE \n200 S BROADWAY",
        "CALL:ALARM/FIRE",
        "ADDR:200 S BROADWAY");

    doTest("T38",
        "(DispatchAlert) ALARM/FIRE \n626 W 15TH",
        "CALL:ALARM/FIRE",
        "ADDR:626 W 15TH");

    doTest("T39",
        "(DispatchAlert) ACCIDENT/UNKNOWN INJURY \n31210 SH 99S, Apt. FITTSTOWN",
        "CALL:ACCIDENT/UNKNOWN INJURY",
        "ADDR:31210 SH 99S",
        "MADDR:31210 OK 99S",
        "APT:FITTSTOWN");

    doTest("T40",
        "(DispatchAlert) FIRE/STRUCTURE \n130 N ROLAND",
        "CALL:FIRE/STRUCTURE",
        "ADDR:130 N ROLAND");

    doTest("T41",
        "(DispatchAlert) ALARM/RES \n200 S BROADWAY",
        "CALL:ALARM/RES",
        "ADDR:200 S BROADWAY");

    doTest("T42",
        "(DispatchAlert) FIRE/GRASS \nARLINGTON JUST PAST ARLINGTON BLVD",
        "CALL:FIRE/GRASS",
        "ADDR:ARLINGTON JUST PAST ARLINGTON BLVD");

    doTest("T43",
        "(DispatchAlert) FIRE/MISC. \n129 W 14TH",
        "CALL:FIRE/MISC.",
        "ADDR:129 W 14TH");

    doTest("T44",
        "(DispatchAlert) FIRE/STRUCTURE \n13340 CR 3630",
        "CALL:FIRE/STRUCTURE",
        "ADDR:13340 CR 3630",
        "MADDR:13340 COUNTY ROAD 3630");

    doTest("T45",
        "(DispatchAlert) UNATTENDED DEATH \n1NEAR DENNY CEMETARY 495",
        "CALL:UNATTENDED DEATH",
        "ADDR:1NEAR DENNY CEMETARY 495");

    doTest("T46",
        "(DispatchAlert) DOWN POWER LINE \n1024 BELLMONT",
        "CALL:DOWN POWER LINE",
        "ADDR:1024 BELLMONT");

    doTest("T47",
        "(DispatchAlert) DOWN POWER LINE \n329 W 14TH",
        "CALL:DOWN POWER LINE",
        "ADDR:329 W 14TH");

    doTest("T48",
        "(DispatchAlert) FIRE/MISC. \nBROADWAY AND KINGS",
        "CALL:FIRE/MISC.",
        "ADDR:BROADWAY AND KINGS",
        "MADDR:BROADWAY & KINGS");

    doTest("T49",
        "(DispatchAlert) ODOR INVESTIGATION \n14TH AND CONSTANT",
        "CALL:ODOR INVESTIGATION",
        "ADDR:14TH AND CONSTANT",
        "MADDR:14TH & CONSTANT");

    doTest("T50",
        "(DispatchAlert) ACCIDENT/UNKNOWN INJURY \nARLINGTON AND COUNTRY CLUB",
        "CALL:ACCIDENT/UNKNOWN INJURY",
        "ADDR:ARLINGTON AND COUNTRY CLUB",
        "MADDR:ARLINGTON & COUNTRY CLUB");

    doTest("T51",
        "(DispatchAlert) MEDICAL CALL \n9837 CR 1545",
        "CALL:MEDICAL CALL",
        "ADDR:9837 CR 1545",
        "MADDR:9837 COUNTY ROAD 1545");

  }
  
  @Test
  public void testHomerFireDepartment() {

    doTest("T1",
        "(DispatchAlert) CONTROLLED BURN \n19335 CR 1550",
        "CALL:CONTROLLED BURN",
        "ADDR:19335 CR 1550",
        "MADDR:19335 COUNTY ROAD 1550");

    doTest("T2",
        "(DispatchAlert) FALL \n407 RICHARDSON LP",
        "CALL:FALL",
        "ADDR:407 RICHARDSON LP");

    doTest("T3",
        "(DispatchAlert) CONTROLLED BURN \n20012 CR 1541",
        "CALL:CONTROLLED BURN",
        "ADDR:20012 CR 1541",
        "MADDR:20012 COUNTY ROAD 1541");

    doTest("T4",
        "(DispatchAlert) CONTROLLED BURN \n13024 CR 3614",
        "CALL:CONTROLLED BURN",
        "ADDR:13024 CR 3614",
        "MADDR:13024 COUNTY ROAD 3614");

    doTest("T5",
        "(DispatchAlert) MEDICAL CALL \n13546 CR 3600, Apt. 11",
        "CALL:MEDICAL CALL",
        "ADDR:13546 CR 3600",
        "MADDR:13546 COUNTY ROAD 3600",
        "APT:11");

    doTest("T6",
        "(DispatchAlert) SICK OR INJURED PERSON \n18402 CR 1520",
        "CALL:SICK OR INJURED PERSON",
        "ADDR:18402 CR 1520",
        "MADDR:18402 COUNTY ROAD 1520");

    doTest("T7",
        "(DispatchAlert) BREATHING PROBLEMS \n21941 CR 1553",
        "CALL:BREATHING PROBLEMS",
        "ADDR:21941 CR 1553",
        "MADDR:21941 COUNTY ROAD 1553");

    doTest("T8",
        "(DispatchAlert) FALL \n19600 CR 1555",
        "CALL:FALL",
        "ADDR:19600 CR 1555",
        "MADDR:19600 COUNTY ROAD 1555");

    doTest("T9",
        "(DispatchAlert) MEDICAL CALL \n13546 CR 3600, Apt. 11",
        "CALL:MEDICAL CALL",
        "ADDR:13546 CR 3600",
        "MADDR:13546 COUNTY ROAD 3600",
        "APT:11");

    doTest("T10",
        "(DispatchAlert) FIRE/CHIMNEY \n19725 CR 1546",
        "CALL:FIRE/CHIMNEY",
        "ADDR:19725 CR 1546",
        "MADDR:19725 COUNTY ROAD 1546");

    doTest("T11",
        "(DispatchAlert) FIRE/GRASS \n14554 CR 3605",
        "CALL:FIRE/GRASS",
        "ADDR:14554 CR 3605",
        "MADDR:14554 COUNTY ROAD 3605");

  }
  
  public static void main(String[] args) {
    new OKPontotocCountyParserTest().generateTests("T1");
  }
}