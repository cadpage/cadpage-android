package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Monmouth County, NJ (variant A)
Contact: Active911
Agency name: Colts Neck First Aid Squad
Location: Colts Neck, NJ, United States
Sender: MCSOCallComplete@MCSONJ.ORG
Sender: MCSOPageNotification@mcsonj.org

(Call Complete Notification         Incident #: 12CN1927)         Incident #: 12CN1927\r\n\r\n     CAD Call ID #: 1248418\r\n              Type: le\r\n         Date/Time: 19:05:01 10/23/12\r\n\r\n           Address: CR 537 / SR 34\r\n           Contact: 84169\r\n   Contact Address:\r\n     Contact Phone: (   )   -\r\n\r\n            Nature: MVA BLS\r\nNature Description: MVA - INJURY BLS ONLY\r\n       Determinant:\r\n  Determinant Desc:\r\n       Complainant:\r\n          Comments: 2 car mva - 1 inj\r\n19:27:42 10/23/2012 - Clayton, T\r\n8434:2 10-17 1 for impound\r\n19:34:59 10/23/2012 - Clayton, T\r\njacks ntfd\r\n19:46:16 10/23/2012 - Clayton, T\r\nper 8434 3 veh need to be towed-speedy dry for fuel leaking from veh\r\n19:46:26 10/23/2012 - Clayton, T\r\n1 veh needs to be moved out of roadway but doesn't need to be towed\r\n19:46:28 10/23/2012 - Clayton, T\r\njacks updated\r\n19:52:45 10/23/2012 - Frueh, D\r\n8434 clear scene resp to jsmc \r\n20:09:57 10/23/2012 - Frueh, D\r\n8434 out at jsmc \r\n20:35:44 10/23/2012 - Clayton, T\r\n8434 ARREST TIME 1952 HRS FOR 450 DRIVER\r\n\r\nReceiving and Responding Units:\r\nIncident  Receiving Unit    Responding Units\r\n---------------------------------------------------------------\r\n12CN1927  P690X4 Harris, D\r\nRU: E84A,8464,8462,8461\r\n\r\n\r\n======================================================================\r\nUnit RunTimes:\r\nUnit        Status    Time\r\n--------------------------------------------------------------------\r\n8461        ARRVD     19:34:14 10/23/12\r\n8461        JSMC      19:34:21 10/23/12\r\n8461        AH        19:48:09 10/23/12\r\n8461        C         20:20:12 10/23/12\r\n8462        ENRT      19:12:18 10/23/12\r\n8462        ARRVD     19:12:55 10/23/12\r\n8462        CSMC      19:28:23 10/23/12\r\n8462        AH        19:46:11 10/23/12\r\n8462        C         20:19:38 10/23/12\r\n8464        ENRT      19:12:08 10/23/12\r\n8464        ARRVD     19:13:02 10/23/12\r\n8464        CSMC      19:38:12 10/23/12\r\n8464        AH        19:53:40 10/23/12\r\n8464        C         21:12:17 10/23/12\r\nE84A        PAGED     19:05:41 10/23/12\r\nE84A        C         19:12:08 10/23/12\r\n
(Call Complete Notification         Incident #: 12CN1926)         Incident #: 12CN1926\r\n\r\n     CAD Call ID #: 1248310\r\n              Type: le\r\n         Date/Time: 17:25:21 10/23/12\r\n\r\n           Address: 88 HWY 537; STATION 84-1\r\n           Contact: SUSAN MOZRI/CELL\r\n   Contact Address: AT THE FIREHOUSE\r\n     Contact Phone: (732)239-7724\r\n\r\n            Nature: MV ACCIDENT\r\nNature Description: MOTOR VEHICLE CRASH/ACCIDENT\r\n       Determinant:\r\n  Determinant Desc:\r\n       Complainant:\r\n          Comments: across street from firehouse/3 vehs-blk sm/bronze suv/bronze civic/unk injs\r\n17:27:48 10/23/2012 - Spivack, D\r\ncaller advised units tied up at this time\r\n17:28:28 10/23/2012 - Russer, S\r\n84170-on scene, states 1 injury\r\n17:34:03 10/23/2012 - Spivack, D\r\nwrecker ntfd, eta 15min\r\n17:53:51 10/23/2012 - Spivack, D\r\nwrecker in traffic, as per 8455 wrecker able to pass/he has traffic stopped\r\n\r\nReceiving and Responding Units:\r\nIncident  Receiving Unit    Responding Units\r\n---------------------------------------------------------------\r\n12CN1926  P690G8 Aras, K\r\nRU: E84A,8454,8464\r\n\r\n\r\n======================================================================\r\nUnit RunTimes:\r\nUnit        Status    Time\r\n--------------------------------------------------------------------\r\n8454        PAGED     17:35:27 10/23/12\r\n8464        ARRVD     17:37:11 10/23/12\r\n8464        CSMC      18:00:13 10/23/12\r\n8464        AH        18:00:18 10/23/12\r\n8464        C         18:32:17 10/23/12\r\nE84A        PAGED     17:24:14 10/23/12\r\n
(Call Complete Notification         Incident #: 12CN1925)         Incident #: 12CN1925\r\n\r\n     CAD Call ID #: 1247852\r\n              Type: le\r\n         Date/Time: 11:14:59 10/23/12\r\n\r\n           Address: 6 WHITE OAK DR\r\n           Contact: NANCY REPETTO\r\n   Contact Address: 6 WHITE OAK DR\r\n     Contact Phone: (732)780-3230\r\n\r\n            Nature: MENTAL/SUICIDAL\r\nNature Description: MENTAL/EMOTIONAL/SUICIDAL\r\n       Determinant:\r\n  Determinant Desc:\r\n       Complainant:\r\n          Comments: paul repetto 52 m caller outside  / husband going back inside  no weapons\r\n11:16:42 10/23/2012 - O'Brien, K\r\nno weapons  under a lot of stress / attempted to choke wife / caller afraid he\r\nis going to hurt himself   no medication  \r\n11:18:35 10/23/2012 - O'Brien, K\r\n no injuries  feels ems should transport him as this is not like him\r\n11:37:29 10/23/2012 - Munson, K\r\n2nd alert\r\n11:51:01 10/23/2012 - Risden, M\r\nems xporting male pt to csmc\r\n11:51:07 10/23/2012 - Risden, M\r\n84056 following \r\n11:54:25 10/23/2012 - Russer, S\r\ncsmc security ntfd\r\n\r\nReceiving and Responding Units:\r\nIncident  Receiving Unit    Responding Units\r\n---------------------------------------------------------------\r\n12CN1925  P690B4 O'Brien, K\r\nRU: E84A,8461\r\n\r\n\r\n======================================================================\r\nUnit RunTimes:\r\nUnit        Status    Time\r\n--------------------------------------------------------------------\r\n8461        PAGED     11:42:12 10/23/12\r\n8461        ENRT      11:46:11 10/23/12\r\n8461        ARRVD     11:46:53 10/23/12\r\n8461        ARRVD     11:46:54 10/23/12\r\n8461        CSMC      11:54:07 10/23/12\r\n8461        AH        12:08:31 10/23/12\r\n8461        C         12:24:44 10/23/12\r\nE84A        PAGED     11:31:25 10/23/12\r\nE84A        C         11:46:11 10/23/12\r\n
(Call Complete Notification         Incident #: 12CN1923)         Incident #: 12CN1923\r\n\r\n     CAD Call ID #: 1247071\r\n              Type: le\r\n         Date/Time: 16:51:30 10/22/12\r\n\r\n           Address: SR 34 / SR 18\r\n           Contact: PAT TOWNSEND\r\n   Contact Address: X:-074.306502 Y:+040.374960 U:271\r\n     Contact Phone: (732)492-1039\r\n\r\n            Nature: EMS - BASIC\r\nNature Description: EMS BASIC LIFE SUPPORT\r\n       Determinant:\r\n  Determinant Desc:\r\n       Complainant:\r\n          Comments: near a closed amaco station sr 34 south in a ford ranger purple blue in color,\r\nsaid he needed an ambulance (call is coming thru old bridge 9-1-1) person he is\r\ncalling about is a co-worker  old american ford (paul)\r\n16:53:40 10/22/2012 - McCarthy, C\r\nPER P84038, MIGHT BE WALL TWP, THEY HAVE A CLOSED AMOCO STATION AS WELL\r\n16:53:47 10/22/2012 - McCarthy, C\r\nCALLING PD52 AS WELL\r\n16:55:02 10/22/2012 - McCarthy, C\r\nPD52: WILL CHECK ALL GAS STATIONS\r\n16:55:06 10/22/2012 - McCarthy, C\r\nNO AMOCO THAT THEY KNOW OF\r\n16:58:22 10/22/2012 - McCarthy, C - From: Savage, Morgan \r\nHAVE SQUAD STANDBY AT THEIR HQS UNTIL THEY LOCATE SUBJECT\r\n16:59:48 10/22/2012 - McCarthy, C - From: Mayer, Todd    \r\nCHECKED DOWN, SO FAR NOTHING\r\n17:00:31 10/22/2012 - Russer, S\r\n2nd alert\r\n17:02:04 10/22/2012 - McCarthy, C\r\nPER P84038: IN .52\r\n17:02:12 10/22/2012 - Russer, S\r\nacross from glass doctor, fox ripple\r\n17:02:31 10/22/2012 - McCarthy, C\r\nPER OLD BRIDGE CALLER ONLY COULD TELL THEM ON RT 34 OFF RT 18\r\n17:02:58 10/22/2012 - Russer, S\r\ncorrection-fox equipment\r\n17:03:21 10/22/2012 - McCarthy, C\r\nITS RT 33/RT 34 PER P84038\r\n\r\nReceiving and Responding Units:\r\nIncident  Receiving Unit    Responding Units\r\n---------------------------------------------------------------\r\n12CN1923  P69ZE1 Latshaw, D\r\nRU: E84A\r\n\r\n\r\n======================================================================\r\nUnit RunTimes:\r\nUnit        Status    Time\r\n--------------------------------------------------------------------\r\nE84A        PAGED     16:53:21 10/22/12\r\nE84A        C         17:03:40 10/22/12\r\n
(Call Complete Notification         Incident #: 12CN1923)         Incident #: 12CN1923\r\n\r\n     CAD Call ID #: 1247071\r\n              Type: le\r\n         Date/Time: 16:51:30 10/22/12\r\n\r\n           Address: SR 34 / SR 18\r\n           Contact: PAT TOWNSEND\r\n   Contact Address: X:-074.306502 Y:+040.374960 U:271\r\n     Contact Phone: (732)492-1039\r\n\r\n            Nature: EMS - BASIC\r\nNature Description: EMS BASIC LIFE SUPPORT\r\n       Determinant:\r\n  Determinant Desc:\r\n       Complainant:\r\n          Comments: near a closed amaco station sr 34 south in a ford ranger purple blue in color,\r\nsaid he needed an ambulance (call is coming thru old bridge 9-1-1) person he is\r\ncalling about is a co-worker  old american ford (paul)\r\n16:53:40 10/22/2012 - McCarthy, C\r\nPER P84038, MIGHT BE WALL TWP, THEY HAVE A CLOSED AMOCO STATION AS WELL\r\n16:53:47 10/22/2012 - McCarthy, C\r\nCALLING PD52 AS WELL\r\n16:55:02 10/22/2012 - McCarthy, C\r\nPD52: WILL CHECK ALL GAS STATIONS\r\n16:55:06 10/22/2012 - McCarthy, C\r\nNO AMOCO THAT THEY KNOW OF\r\n16:58:22 10/22/2012 - McCarthy, C - From: Savage, Morgan \r\nHAVE SQUAD STANDBY AT THEIR HQS UNTIL THEY LOCATE SUBJECT\r\n16:59:48 10/22/2012 - McCarthy, C - From: Mayer, Todd    \r\nCHECKED DOWN, SO FAR NOTHING\r\n17:00:31 10/22/2012 - Russer, S\r\n2nd alert\r\n17:02:04 10/22/2012 - McCarthy, C\r\nPER P84038: IN .52\r\n17:02:12 10/22/2012 - Russer, S\r\nacross from glass doctor, fox ripple\r\n17:02:31 10/22/2012 - McCarthy, C\r\nPER OLD BRIDGE CALLER ONLY COULD TELL THEM ON RT 34 OFF RT 18\r\n17:02:58 10/22/2012 - Russer, S\r\ncorrection-fox equipment\r\n17:03:21 10/22/2012 - McCarthy, C\r\nITS RT 33/RT 34 PER P84038\r\n\r\nReceiving and Responding Units:\r\nIncident  Receiving Unit    Responding Units\r\n---------------------------------------------------------------\r\n12CN1923  P69ZE1 Latshaw, D\r\nRU: E84A\r\n\r\n\r\n======================================================================\r\nUnit RunTimes:\r\nUnit        Status    Time\r\n--------------------------------------------------------------------\r\nE84A        PAGED     16:53:21 10/22/12\r\nE84A        C         17:03:40 10/22/12\r\n

(MCSO Page Notification) 8421\r\nMVA BLS\r\nPAGED\r\nCR 537 / SR 34,84\r\nE8421\r\nE84A\r\n2 car mva - 1 inj\r\n
(MCSO Page Notification) 8421\r\nMVA BLS\r\nPAGED\r\n88 HWY 537; STATION 84-1,84\r\nE8421\r\nE84A\r\n
(MCSO Page Notification) 8421\r\nMENTAL/SUICIDAL\r\nPAGED\r\n6 WHITE OAK DR,84\r\nE8421\r\nE84A\r\npaul repetto 52 m caller outside  / husband going back inside  no weapons\r\nno weapons  under a lot of stress / attempted to choke wife / caller afraid he\r\nis going to hurt himself   no medication\r\n
(MCSO Page Notification) 9421\r\nEMS - BASIC\r\nPAGED\r\n747 FOSTER CT,84\r\nE94\r\nE84A\r\nsevere back pains, has prior nack surgery; unable to sit down\r\npd94 ntfd\r\nthey will ntfy their own squad\r\n
(MCSO Page Notification) 8421\r\nEMS - BASIC\r\nPAGED\r\nSR 34 / SR 18,84\r\nE8421\r\nE84A\r\nnear a closed amaco station sr 34 south in a ford ranger purple blue in color,\r\nsaid he needed an ambulance (call is coming thru old bridge 9-1-1) person he is\r\ncalling about is a co-worker  old americ\r\n

Contact: CodeMessaging
Sender: MCSOPageNotification@mcsonj.org

(MCSO Page Notification) 26-2\nCO ALARM\nPAGED\n28 GEMINI LN,26\nF262M\nF262A\nCO2 alarm going off.\nCALLER INSTRUCTED TO TAKE HERSELF AND HER CHILD OUT OF THE HOME, AND AWAIT\nFOR\nFIRE DEPT TO CHECK THE SCENE.
(MCSO Page Notification) D32\nFIRE - ALARM\nPAGED\n5 ALGONQUIN TER,32\nF3225\nF32A\nres/gilbert///manual pull///will att to ntfy kh\nstate police ntfd
(MCSO Page Notification) D32\nFIRE - ALARM\nPAGED\n5 ALGONQUIN TER,32\nF3225\nF32A\nres/gilbert///manual pull///will att to ntfy kh\nstate police ntfd
(MCSO Page Notification) 26-1\nFIRE - ALARM\nPAGED\n285 GORDONS CORNER RD; GENIUS KIDS,26\nF2610\nF261A\nZONE  20, GENERAL, PREMISE #               732 977 1702      , KEYHOLDER  ATT TO NTFD\n07 28 41 10/22/2012 - Crotchfelt, A - From  Cascella, A
(MCSO Page Notification) 12-1\nFIRE - ALARM\nPAGED\n45 WILSON AVE; KNOWLES GROUP,26\nF121M\nF262A\nbasement smoke detector / kh to be ntfd\n04             00 34 10/20/2012       - Lonon, A - From  Hensly, J\ncode 3
(MCSO Page Notification) 26-2\nFIRE - ALARM\nPAGED\n106 BEAGLE DR,26\nF262M\nF262A\nsmoke alarm sounding. does not smell or see anything\nresidents out of the house
(MCSO Page Notification) 26-2\nEMS - ALS\nPAGED\n712 SUMMER DR,26\nF262M\nF262A\n81 YOM unresponsive, trach pt\nsubj is breathing\ninc began yesterday, has gotten worse since\npt hx  trache, currently attached to humidifier, cancer, brain tumor,\nmenignitis, NKDA\nMONOC NTFD\npt started
(MCSO Page Notification) 26-2\nFIRE - OTHER\nPAGED\n44 PALOMINO DR,\nF26-2\nF262A\nPROPANE TANK AT CLUB HOUSE  NOT ATTACHED TO BLDG ON THE SIDE OUTSIDE FLAMES

Contact: Mr Brown <brown1396@gmail.com>
Sender: GCM (CodeMessaging)
12-1  WIRE/POLE DOWN  PAGED  15 PARK AVE,12  F12-1  F12A  unk if arcing
26-2  FIRE - ALARM  PAGED  361 ST ANDREWS PL;LEGENDS OF KNOB HILL BUILDING 26,26  F26-2  F262A  zone fa11/7327929982/will att
26-2  FIRE - ALARM  PAGED  361 ST ANDREWS PL;LEGENDS OF KNOB HILL;BUILDING 26,26  F26-2  F262A  general fire/business/7327929982/will att
26-2  FIRE - ALARM  PAGED  2 VICTORIAN HILL,26  F262M  F262B  res  wendy silverbird prem# 732-863-6903 / gen fir / att to cont / will call bck  false alrm per a wendy on scene..she is changing the battery

*/

public class NJMonmouthCountyAParserTest extends BaseParserTest {
  
  public NJMonmouthCountyAParserTest() {
    setParser(new NJMonmouthCountyAParser(), "MONMOUTH COUNTY", "NJ");
  }
  
  @Test
  public void testRunReport() {

    doTest("T1",
        "(Call Complete Notification         Incident #: 12CN1927)         Incident #: 12CN1927\r\n" +
        "\r\n" +
        "     CAD Call ID #: 1248418\r\n" +
        "              Type: le\r\n" +
        "         Date/Time: 19:05:01 10/23/12\r\n" +
        "\r\n" +
        "           Address: CR 537 / SR 34\r\n" +
        "           Contact: 84169\r\n" +
        "   Contact Address:\r\n" +
        "     Contact Phone: (   )   -\r\n" +
        "\r\n" +
        "            Nature: MVA BLS\r\n" +
        "Nature Description: MVA - INJURY BLS ONLY\r\n" +
        "       Determinant:\r\n" +
        "  Determinant Desc:\r\n" +
        "       Complainant:\r\n" +
        "          Comments: 2 car mva - 1 inj\r\n" +
        "19:27:42 10/23/2012 - Clayton, T\r\n" +
        "8434:2 10-17 1 for impound\r\n" +
        "19:34:59 10/23/2012 - Clayton, T\r\n" +
        "jacks ntfd\r\n" +
        "19:46:16 10/23/2012 - Clayton, T\r\n" +
        "per 8434 3 veh need to be towed-speedy dry for fuel leaking from veh\r\n" +
        "19:46:26 10/23/2012 - Clayton, T\r\n" +
        "1 veh needs to be moved out of roadway but doesn't need to be towed\r\n" +
        "19:46:28 10/23/2012 - Clayton, T\r\n" +
        "jacks updated\r\n" +
        "19:52:45 10/23/2012 - Frueh, D\r\n" +
        "8434 clear scene resp to jsmc \r\n" +
        "20:09:57 10/23/2012 - Frueh, D\r\n" +
        "8434 out at jsmc \r\n" +
        "20:35:44 10/23/2012 - Clayton, T\r\n" +
        "8434 ARREST TIME 1952 HRS FOR 450 DRIVER\r\n" +
        "\r\n" +
        "Receiving and Responding Units:\r\n" +
        "Incident  Receiving Unit    Responding Units\r\n" +
        "---------------------------------------------------------------\r\n" +
        "12CN1927  P690X4 Harris, D\r\n" +
        "RU: E84A,8464,8462,8461\r\n" +
        "\r\n" +
        "\r\n" +
        "======================================================================\r\n" +
        "Unit RunTimes:\r\n" +
        "Unit        Status    Time\r\n" +
        "--------------------------------------------------------------------\r\n" +
        "8461        ARRVD     19:34:14 10/23/12\r\n" +
        "8461        JSMC      19:34:21 10/23/12\r\n" +
        "8461        AH        19:48:09 10/23/12\r\n" +
        "8461        C         20:20:12 10/23/12\r\n" +
        "8462        ENRT      19:12:18 10/23/12\r\n" +
        "8462        ARRVD     19:12:55 10/23/12\r\n" +
        "8462        CSMC      19:28:23 10/23/12\r\n" +
        "8462        AH        19:46:11 10/23/12\r\n" +
        "8462        C         20:19:38 10/23/12\r\n" +
        "8464        ENRT      19:12:08 10/23/12\r\n" +
        "8464        ARRVD     19:13:02 10/23/12\r\n" +
        "8464        CSMC      19:38:12 10/23/12\r\n" +
        "8464        AH        19:53:40 10/23/12\r\n" +
        "8464        C         21:12:17 10/23/12\r\n" +
        "E84A        PAGED     19:05:41 10/23/12\r\n" +
        "E84A        C         19:12:08 10/23/12\r\n",

        "CALL:RUN REPORT",
        "PLACE:Incident #: 12CN1927\n\n     CAD Call ID #: 1248418\n              Type: le\n         Date/Time: 19:05:01 10/23/12\n\n           Address: CR 537 / SR 34\n           Contact: 84169\n   Contact Address:\n     Contact Phone: (   )   -\n\n            Nature: MVA BLS\nNature Description: MVA - INJURY BLS ONLY\n       Determinant:\n  Determinant Desc:\n       Complainant:\n          Comments: 2 car mva - 1 inj\n19:27:42 10/23/2012 - Clayton, T\n8434:2 10-17 1 for impound\n19:34:59 10/23/2012 - Clayton, T\njacks ntfd\n19:46:16 10/23/2012 - Clayton, T\nper 8434 3 veh need to be towed-speedy dry for fuel leaking from veh\n19:46:26 10/23/2012 - Clayton, T\n1 veh needs to be moved out of roadway but doesn't need to be towed\n19:46:28 10/23/2012 - Clayton, T\njacks updated\n19:52:45 10/23/2012 - Frueh, D\n8434 clear scene resp to jsmc \n20:09:57 10/23/2012 - Frueh, D\n8434 out at jsmc \n20:35:44 10/23/2012 - Clayton, T\n8434 ARREST TIME 1952 HRS FOR 450 DRIVER\n\nReceiving and Responding Units:\nIncident  Receiving Unit    Responding Units\n---------------------------------------------------------------\n12CN1927  P690X4 Harris, D\nRU: E84A,8464,8462,8461\n\n\n======================================================================\nUnit RunTimes:\nUnit        Status    Time\n--------------------------------------------------------------------\n8461        ARRVD     19:34:14 10/23/12\n8461        JSMC      19:34:21 10/23/12\n8461        AH        19:48:09 10/23/12\n8461        C         20:20:12 10/23/12\n8462        ENRT      19:12:18 10/23/12\n8462        ARRVD     19:12:55 10/23/12\n8462        CSMC      19:28:23 10/23/12\n8462        AH        19:46:11 10/23/12\n8462        C         20:19:38 10/23/12\n8464        ENRT      19:12:08 10/23/12\n8464        ARRVD     19:13:02 10/23/12\n8464        CSMC      19:38:12 10/23/12\n8464        AH        19:53:40 10/23/12\n8464        C         21:12:17 10/23/12\nE84A        PAGED     19:05:41 10/23/12\nE84A        C         19:12:08 10/23/12");

    doTest("T2",
        "(Call Complete Notification         Incident #: 12CN1926)         Incident #: 12CN1926\r\n" +
        "\r\n" +
        "     CAD Call ID #: 1248310\r\n" +
        "              Type: le\r\n" +
        "         Date/Time: 17:25:21 10/23/12\r\n" +
        "\r\n" +
        "           Address: 88 HWY 537; STATION 84-1\r\n" +
        "           Contact: SUSAN MOZRI/CELL\r\n" +
        "   Contact Address: AT THE FIREHOUSE\r\n" +
        "     Contact Phone: (732)239-7724\r\n" +
        "\r\n" +
        "            Nature: MV ACCIDENT\r\n" +
        "Nature Description: MOTOR VEHICLE CRASH/ACCIDENT\r\n" +
        "       Determinant:\r\n" +
        "  Determinant Desc:\r\n" +
        "       Complainant:\r\n" +
        "          Comments: across street from firehouse/3 vehs-blk sm/bronze suv/bronze civic/unk injs\r\n" +
        "17:27:48 10/23/2012 - Spivack, D\r\n" +
        "caller advised units tied up at this time\r\n" +
        "17:28:28 10/23/2012 - Russer, S\r\n" +
        "84170-on scene, states 1 injury\r\n" +
        "17:34:03 10/23/2012 - Spivack, D\r\n" +
        "wrecker ntfd, eta 15min\r\n" +
        "17:53:51 10/23/2012 - Spivack, D\r\n" +
        "wrecker in traffic, as per 8455 wrecker able to pass/he has traffic stopped\r\n" +
        "\r\n" +
        "Receiving and Responding Units:\r\n" +
        "Incident  Receiving Unit    Responding Units\r\n" +
        "---------------------------------------------------------------\r\n" +
        "12CN1926  P690G8 Aras, K\r\n" +
        "RU: E84A,8454,8464\r\n" +
        "\r\n" +
        "\r\n" +
        "======================================================================\r\n" +
        "Unit RunTimes:\r\n" +
        "Unit        Status    Time\r\n" +
        "--------------------------------------------------------------------\r\n" +
        "8454        PAGED     17:35:27 10/23/12\r\n" +
        "8464        ARRVD     17:37:11 10/23/12\r\n" +
        "8464        CSMC      18:00:13 10/23/12\r\n" +
        "8464        AH        18:00:18 10/23/12\r\n" +
        "8464        C         18:32:17 10/23/12\r\n" +
        "E84A        PAGED     17:24:14 10/23/12\r\n",

        "CALL:RUN REPORT",
        "PLACE:Incident #: 12CN1926\n\n     CAD Call ID #: 1248310\n              Type: le\n         Date/Time: 17:25:21 10/23/12\n\n           Address: 88 HWY 537; STATION 84-1\n           Contact: SUSAN MOZRI/CELL\n   Contact Address: AT THE FIREHOUSE\n     Contact Phone: (732)239-7724\n\n            Nature: MV ACCIDENT\nNature Description: MOTOR VEHICLE CRASH/ACCIDENT\n       Determinant:\n  Determinant Desc:\n       Complainant:\n          Comments: across street from firehouse/3 vehs-blk sm/bronze suv/bronze civic/unk injs\n17:27:48 10/23/2012 - Spivack, D\ncaller advised units tied up at this time\n17:28:28 10/23/2012 - Russer, S\n84170-on scene, states 1 injury\n17:34:03 10/23/2012 - Spivack, D\nwrecker ntfd, eta 15min\n17:53:51 10/23/2012 - Spivack, D\nwrecker in traffic, as per 8455 wrecker able to pass/he has traffic stopped\n\nReceiving and Responding Units:\nIncident  Receiving Unit    Responding Units\n---------------------------------------------------------------\n12CN1926  P690G8 Aras, K\nRU: E84A,8454,8464\n\n\n======================================================================\nUnit RunTimes:\nUnit        Status    Time\n--------------------------------------------------------------------\n8454        PAGED     17:35:27 10/23/12\n8464        ARRVD     17:37:11 10/23/12\n8464        CSMC      18:00:13 10/23/12\n8464        AH        18:00:18 10/23/12\n8464        C         18:32:17 10/23/12\nE84A        PAGED     17:24:14 10/23/12");

    doTest("T3",
        "(Call Complete Notification         Incident #: 12CN1925)         Incident #: 12CN1925\r\n" +
        "\r\n" +
        "     CAD Call ID #: 1247852\r\n" +
        "              Type: le\r\n" +
        "         Date/Time: 11:14:59 10/23/12\r\n" +
        "\r\n" +
        "           Address: 6 WHITE OAK DR\r\n" +
        "           Contact: NANCY REPETTO\r\n" +
        "   Contact Address: 6 WHITE OAK DR\r\n" +
        "     Contact Phone: (732)780-3230\r\n" +
        "\r\n" +
        "            Nature: MENTAL/SUICIDAL\r\n" +
        "Nature Description: MENTAL/EMOTIONAL/SUICIDAL\r\n" +
        "       Determinant:\r\n" +
        "  Determinant Desc:\r\n" +
        "       Complainant:\r\n" +
        "          Comments: paul repetto 52 m caller outside  / husband going back inside  no weapons\r\n" +
        "11:16:42 10/23/2012 - O'Brien, K\r\n" +
        "no weapons  under a lot of stress / attempted to choke wife / caller afraid he\r\n" +
        "is going to hurt himself   no medication  \r\n" +
        "11:18:35 10/23/2012 - O'Brien, K\r\n" +
        " no injuries  feels ems should transport him as this is not like him\r\n" +
        "11:37:29 10/23/2012 - Munson, K\r\n" +
        "2nd alert\r\n" +
        "11:51:01 10/23/2012 - Risden, M\r\n" +
        "ems xporting male pt to csmc\r\n" +
        "11:51:07 10/23/2012 - Risden, M\r\n" +
        "84056 following \r\n" +
        "11:54:25 10/23/2012 - Russer, S\r\n" +
        "csmc security ntfd\r\n" +
        "\r\n" +
        "Receiving and Responding Units:\r\n" +
        "Incident  Receiving Unit    Responding Units\r\n" +
        "---------------------------------------------------------------\r\n" +
        "12CN1925  P690B4 O'Brien, K\r\n" +
        "RU: E84A,8461\r\n" +
        "\r\n" +
        "\r\n" +
        "======================================================================\r\n" +
        "Unit RunTimes:\r\n" +
        "Unit        Status    Time\r\n" +
        "--------------------------------------------------------------------\r\n" +
        "8461        PAGED     11:42:12 10/23/12\r\n" +
        "8461        ENRT      11:46:11 10/23/12\r\n" +
        "8461        ARRVD     11:46:53 10/23/12\r\n" +
        "8461        ARRVD     11:46:54 10/23/12\r\n" +
        "8461        CSMC      11:54:07 10/23/12\r\n" +
        "8461        AH        12:08:31 10/23/12\r\n" +
        "8461        C         12:24:44 10/23/12\r\n" +
        "E84A        PAGED     11:31:25 10/23/12\r\n" +
        "E84A        C         11:46:11 10/23/12\r\n",

        "CALL:RUN REPORT",
        "PLACE:Incident #: 12CN1925\n\n     CAD Call ID #: 1247852\n              Type: le\n         Date/Time: 11:14:59 10/23/12\n\n           Address: 6 WHITE OAK DR\n           Contact: NANCY REPETTO\n   Contact Address: 6 WHITE OAK DR\n     Contact Phone: (732)780-3230\n\n            Nature: MENTAL/SUICIDAL\nNature Description: MENTAL/EMOTIONAL/SUICIDAL\n       Determinant:\n  Determinant Desc:\n       Complainant:\n          Comments: paul repetto 52 m caller outside  / husband going back inside  no weapons\n11:16:42 10/23/2012 - O'Brien, K\nno weapons  under a lot of stress / attempted to choke wife / caller afraid he\nis going to hurt himself   no medication  \n11:18:35 10/23/2012 - O'Brien, K\n no injuries  feels ems should transport him as this is not like him\n11:37:29 10/23/2012 - Munson, K\n2nd alert\n11:51:01 10/23/2012 - Risden, M\nems xporting male pt to csmc\n11:51:07 10/23/2012 - Risden, M\n84056 following \n11:54:25 10/23/2012 - Russer, S\ncsmc security ntfd\n\nReceiving and Responding Units:\nIncident  Receiving Unit    Responding Units\n---------------------------------------------------------------\n12CN1925  P690B4 O'Brien, K\nRU: E84A,8461\n\n\n======================================================================\nUnit RunTimes:\nUnit        Status    Time\n--------------------------------------------------------------------\n8461        PAGED     11:42:12 10/23/12\n8461        ENRT      11:46:11 10/23/12\n8461        ARRVD     11:46:53 10/23/12\n8461        ARRVD     11:46:54 10/23/12\n8461        CSMC      11:54:07 10/23/12\n8461        AH        12:08:31 10/23/12\n8461        C         12:24:44 10/23/12\nE84A        PAGED     11:31:25 10/23/12\nE84A        C         11:46:11 10/23/12");

    doTest("T4",
        "(Call Complete Notification         Incident #: 12CN1923)         Incident #: 12CN1923\r\n" +
        "\r\n" +
        "     CAD Call ID #: 1247071\r\n" +
        "              Type: le\r\n" +
        "         Date/Time: 16:51:30 10/22/12\r\n" +
        "\r\n" +
        "           Address: SR 34 / SR 18\r\n" +
        "           Contact: PAT TOWNSEND\r\n" +
        "   Contact Address: X:-074.306502 Y:+040.374960 U:271\r\n" +
        "     Contact Phone: (732)492-1039\r\n" +
        "\r\n" +
        "            Nature: EMS - BASIC\r\n" +
        "Nature Description: EMS BASIC LIFE SUPPORT\r\n" +
        "       Determinant:\r\n" +
        "  Determinant Desc:\r\n" +
        "       Complainant:\r\n" +
        "          Comments: near a closed amaco station sr 34 south in a ford ranger purple blue in color,\r\n" +
        "said he needed an ambulance (call is coming thru old bridge 9-1-1) person he is\r\n" +
        "calling about is a co-worker  old american ford (paul)\r\n" +
        "16:53:40 10/22/2012 - McCarthy, C\r\n" +
        "PER P84038, MIGHT BE WALL TWP, THEY HAVE A CLOSED AMOCO STATION AS WELL\r\n" +
        "16:53:47 10/22/2012 - McCarthy, C\r\n" +
        "CALLING PD52 AS WELL\r\n" +
        "16:55:02 10/22/2012 - McCarthy, C\r\n" +
        "PD52: WILL CHECK ALL GAS STATIONS\r\n" +
        "16:55:06 10/22/2012 - McCarthy, C\r\n" +
        "NO AMOCO THAT THEY KNOW OF\r\n" +
        "16:58:22 10/22/2012 - McCarthy, C - From: Savage, Morgan \r\n" +
        "HAVE SQUAD STANDBY AT THEIR HQS UNTIL THEY LOCATE SUBJECT\r\n" +
        "16:59:48 10/22/2012 - McCarthy, C - From: Mayer, Todd    \r\n" +
        "CHECKED DOWN, SO FAR NOTHING\r\n" +
        "17:00:31 10/22/2012 - Russer, S\r\n" +
        "2nd alert\r\n" +
        "17:02:04 10/22/2012 - McCarthy, C\r\n" +
        "PER P84038: IN .52\r\n" +
        "17:02:12 10/22/2012 - Russer, S\r\n" +
        "across from glass doctor, fox ripple\r\n" +
        "17:02:31 10/22/2012 - McCarthy, C\r\n" +
        "PER OLD BRIDGE CALLER ONLY COULD TELL THEM ON RT 34 OFF RT 18\r\n" +
        "17:02:58 10/22/2012 - Russer, S\r\n" +
        "correction-fox equipment\r\n" +
        "17:03:21 10/22/2012 - McCarthy, C\r\n" +
        "ITS RT 33/RT 34 PER P84038\r\n" +
        "\r\n" +
        "Receiving and Responding Units:\r\n" +
        "Incident  Receiving Unit    Responding Units\r\n" +
        "---------------------------------------------------------------\r\n" +
        "12CN1923  P69ZE1 Latshaw, D\r\n" +
        "RU: E84A\r\n" +
        "\r\n" +
        "\r\n" +
        "======================================================================\r\n" +
        "Unit RunTimes:\r\n" +
        "Unit        Status    Time\r\n" +
        "--------------------------------------------------------------------\r\n" +
        "E84A        PAGED     16:53:21 10/22/12\r\n" +
        "E84A        C         17:03:40 10/22/12\r\n",

        "CALL:RUN REPORT",
        "PLACE:Incident #: 12CN1923\n\n     CAD Call ID #: 1247071\n              Type: le\n         Date/Time: 16:51:30 10/22/12\n\n           Address: SR 34 / SR 18\n           Contact: PAT TOWNSEND\n   Contact Address: X:-074.306502 Y:+040.374960 U:271\n     Contact Phone: (732)492-1039\n\n            Nature: EMS - BASIC\nNature Description: EMS BASIC LIFE SUPPORT\n       Determinant:\n  Determinant Desc:\n       Complainant:\n          Comments: near a closed amaco station sr 34 south in a ford ranger purple blue in color,\nsaid he needed an ambulance (call is coming thru old bridge 9-1-1) person he is\ncalling about is a co-worker  old american ford (paul)\n16:53:40 10/22/2012 - McCarthy, C\nPER P84038, MIGHT BE WALL TWP, THEY HAVE A CLOSED AMOCO STATION AS WELL\n16:53:47 10/22/2012 - McCarthy, C\nCALLING PD52 AS WELL\n16:55:02 10/22/2012 - McCarthy, C\nPD52: WILL CHECK ALL GAS STATIONS\n16:55:06 10/22/2012 - McCarthy, C\nNO AMOCO THAT THEY KNOW OF\n16:58:22 10/22/2012 - McCarthy, C - From: Savage, Morgan \nHAVE SQUAD STANDBY AT THEIR HQS UNTIL THEY LOCATE SUBJECT\n16:59:48 10/22/2012 - McCarthy, C - From: Mayer, Todd    \nCHECKED DOWN, SO FAR NOTHING\n17:00:31 10/22/2012 - Russer, S\n2nd alert\n17:02:04 10/22/2012 - McCarthy, C\nPER P84038: IN .52\n17:02:12 10/22/2012 - Russer, S\nacross from glass doctor, fox ripple\n17:02:31 10/22/2012 - McCarthy, C\nPER OLD BRIDGE CALLER ONLY COULD TELL THEM ON RT 34 OFF RT 18\n17:02:58 10/22/2012 - Russer, S\ncorrection-fox equipment\n17:03:21 10/22/2012 - McCarthy, C\nITS RT 33/RT 34 PER P84038\n\nReceiving and Responding Units:\nIncident  Receiving Unit    Responding Units\n---------------------------------------------------------------\n12CN1923  P69ZE1 Latshaw, D\nRU: E84A\n\n\n======================================================================\nUnit RunTimes:\nUnit        Status    Time\n--------------------------------------------------------------------\nE84A        PAGED     16:53:21 10/22/12\nE84A        C         17:03:40 10/22/12");

    doTest("T5",
        "(Call Complete Notification         Incident #: 12CN1923)         Incident #: 12CN1923\r\n" +
        "\r\n" +
        "     CAD Call ID #: 1247071\r\n" +
        "              Type: le\r\n" +
        "         Date/Time: 16:51:30 10/22/12\r\n" +
        "\r\n" +
        "           Address: SR 34 / SR 18\r\n" +
        "           Contact: PAT TOWNSEND\r\n" +
        "   Contact Address: X:-074.306502 Y:+040.374960 U:271\r\n" +
        "     Contact Phone: (732)492-1039\r\n" +
        "\r\n" +
        "            Nature: EMS - BASIC\r\n" +
        "Nature Description: EMS BASIC LIFE SUPPORT\r\n" +
        "       Determinant:\r\n" +
        "  Determinant Desc:\r\n" +
        "       Complainant:\r\n" +
        "          Comments: near a closed amaco station sr 34 south in a ford ranger purple blue in color,\r\n" +
        "said he needed an ambulance (call is coming thru old bridge 9-1-1) person he is\r\n" +
        "calling about is a co-worker  old american ford (paul)\r\n" +
        "16:53:40 10/22/2012 - McCarthy, C\r\n" +
        "PER P84038, MIGHT BE WALL TWP, THEY HAVE A CLOSED AMOCO STATION AS WELL\r\n" +
        "16:53:47 10/22/2012 - McCarthy, C\r\n" +
        "CALLING PD52 AS WELL\r\n" +
        "16:55:02 10/22/2012 - McCarthy, C\r\n" +
        "PD52: WILL CHECK ALL GAS STATIONS\r\n" +
        "16:55:06 10/22/2012 - McCarthy, C\r\n" +
        "NO AMOCO THAT THEY KNOW OF\r\n" +
        "16:58:22 10/22/2012 - McCarthy, C - From: Savage, Morgan \r\n" +
        "HAVE SQUAD STANDBY AT THEIR HQS UNTIL THEY LOCATE SUBJECT\r\n" +
        "16:59:48 10/22/2012 - McCarthy, C - From: Mayer, Todd    \r\n" +
        "CHECKED DOWN, SO FAR NOTHING\r\n" +
        "17:00:31 10/22/2012 - Russer, S\r\n" +
        "2nd alert\r\n" +
        "17:02:04 10/22/2012 - McCarthy, C\r\n" +
        "PER P84038: IN .52\r\n" +
        "17:02:12 10/22/2012 - Russer, S\r\n" +
        "across from glass doctor, fox ripple\r\n" +
        "17:02:31 10/22/2012 - McCarthy, C\r\n" +
        "PER OLD BRIDGE CALLER ONLY COULD TELL THEM ON RT 34 OFF RT 18\r\n" +
        "17:02:58 10/22/2012 - Russer, S\r\n" +
        "correction-fox equipment\r\n" +
        "17:03:21 10/22/2012 - McCarthy, C\r\n" +
        "ITS RT 33/RT 34 PER P84038\r\n" +
        "\r\n" +
        "Receiving and Responding Units:\r\n" +
        "Incident  Receiving Unit    Responding Units\r\n" +
        "---------------------------------------------------------------\r\n" +
        "12CN1923  P69ZE1 Latshaw, D\r\n" +
        "RU: E84A\r\n" +
        "\r\n" +
        "\r\n" +
        "======================================================================\r\n" +
        "Unit RunTimes:\r\n" +
        "Unit        Status    Time\r\n" +
        "--------------------------------------------------------------------\r\n" +
        "E84A        PAGED     16:53:21 10/22/12\r\n" +
        "E84A        C         17:03:40 10/22/12\r\n",

        "CALL:RUN REPORT",
        "PLACE:Incident #: 12CN1923\n\n     CAD Call ID #: 1247071\n              Type: le\n         Date/Time: 16:51:30 10/22/12\n\n           Address: SR 34 / SR 18\n           Contact: PAT TOWNSEND\n   Contact Address: X:-074.306502 Y:+040.374960 U:271\n     Contact Phone: (732)492-1039\n\n            Nature: EMS - BASIC\nNature Description: EMS BASIC LIFE SUPPORT\n       Determinant:\n  Determinant Desc:\n       Complainant:\n          Comments: near a closed amaco station sr 34 south in a ford ranger purple blue in color,\nsaid he needed an ambulance (call is coming thru old bridge 9-1-1) person he is\ncalling about is a co-worker  old american ford (paul)\n16:53:40 10/22/2012 - McCarthy, C\nPER P84038, MIGHT BE WALL TWP, THEY HAVE A CLOSED AMOCO STATION AS WELL\n16:53:47 10/22/2012 - McCarthy, C\nCALLING PD52 AS WELL\n16:55:02 10/22/2012 - McCarthy, C\nPD52: WILL CHECK ALL GAS STATIONS\n16:55:06 10/22/2012 - McCarthy, C\nNO AMOCO THAT THEY KNOW OF\n16:58:22 10/22/2012 - McCarthy, C - From: Savage, Morgan \nHAVE SQUAD STANDBY AT THEIR HQS UNTIL THEY LOCATE SUBJECT\n16:59:48 10/22/2012 - McCarthy, C - From: Mayer, Todd    \nCHECKED DOWN, SO FAR NOTHING\n17:00:31 10/22/2012 - Russer, S\n2nd alert\n17:02:04 10/22/2012 - McCarthy, C\nPER P84038: IN .52\n17:02:12 10/22/2012 - Russer, S\nacross from glass doctor, fox ripple\n17:02:31 10/22/2012 - McCarthy, C\nPER OLD BRIDGE CALLER ONLY COULD TELL THEM ON RT 34 OFF RT 18\n17:02:58 10/22/2012 - Russer, S\ncorrection-fox equipment\n17:03:21 10/22/2012 - McCarthy, C\nITS RT 33/RT 34 PER P84038\n\nReceiving and Responding Units:\nIncident  Receiving Unit    Responding Units\n---------------------------------------------------------------\n12CN1923  P69ZE1 Latshaw, D\nRU: E84A\n\n\n======================================================================\nUnit RunTimes:\nUnit        Status    Time\n--------------------------------------------------------------------\nE84A        PAGED     16:53:21 10/22/12\nE84A        C         17:03:40 10/22/12");

  }
  
  @Test
  public void testColtNeck() {

    doTest("T1",
        "(MCSO Page Notification) 8421\r\nMVA BLS\r\nPAGED\r\nCR 537 / SR 34,84\r\nE8421\r\nE84A\r\n2 car mva - 1 inj\r\n",
        "SRC:8421",
        "CALL:MVA BLS",
        "ADDR:CR 537 & SR 34",
        "MADDR:COUNTY ROAD 537 & NJ 34",
        "CITY:COLTS NECK",
        "UNIT:E8421 E84A",
        "INFO:2 car mva - 1 inj");

    doTest("T2",
        "(MCSO Page Notification) 8421\r\nMVA BLS\r\nPAGED\r\n88 HWY 537; STATION 84-1,84\r\nE8421\r\nE84A\r\n",
        "SRC:8421",
        "CALL:MVA BLS",
        "ADDR:88 HWY 537",   // Not mapping in COLTS NECK
        "PLACE:STATION 84-1",
        "CITY:COLTS NECK",
        "UNIT:E8421 E84A");

    doTest("T3",
        "(MCSO Page Notification) 8421\r\n" +
        "MENTAL/SUICIDAL\r\n" +
        "PAGED\r\n" +
        "6 WHITE OAK DR,84\r\n" +
        "E8421\r\n" +
        "E84A\r\n" +
        "paul repetto 52 m caller outside  / husband going back inside  no weapons\r\n" +
        "no weapons  under a lot of stress / attempted to choke wife / caller afraid he\r\n" +
        "is going to hurt himself   no medication\r\n",

        "SRC:8421",
        "CALL:MENTAL/SUICIDAL",
        "ADDR:6 WHITE OAK DR",
        "CITY:COLTS NECK",
        "UNIT:E8421 E84A",
        "INFO:paul repetto 52 m caller outside  / husband going back inside  no weapons / no weapons  under a lot of stress / attempted to choke wife / caller afraid he / is going to hurt himself   no medication");

    doTest("T4",
        "(MCSO Page Notification) 9421\r\n" +
        "EMS - BASIC\r\n" +
        "PAGED\r\n" +
        "747 FOSTER CT,84\r\n" +
        "E94\r\n" +
        "E84A\r\n" +
        "severe back pains, has prior nack surgery; unable to sit down\r\n" +
        "pd94 ntfd\r\n" +
        "they will ntfy their own squad\r\n",

        "SRC:9421",
        "CALL:EMS - BASIC",
        "ADDR:747 FOSTER CT",
        "CITY:COLTS NECK",
        "UNIT:E94 E84A",
        "INFO:severe back pains, has prior nack surgery; unable to sit down / pd94 ntfd / they will ntfy their own squad");

    doTest("T5",
        "(MCSO Page Notification) 8421\r\n" +
        "EMS - BASIC\r\n" +
        "PAGED\r\n" +
        "SR 34 / SR 18,84\r\n" +
        "E8421\r\n" +
        "E84A\r\n" +
        "near a closed amaco station sr 34 south in a ford ranger purple blue in color,\r\n" +
        "said he needed an ambulance (call is coming thru old bridge 9-1-1) person he is\r\n" +
        "calling about is a co-worker  old americ\r\n",

        "SRC:8421",
        "CALL:EMS - BASIC",
        "ADDR:SR 34 & SR 18",
        "MADDR:NJ 34 & NJ 18",
        "CITY:COLTS NECK",
        "UNIT:E8421 E84A",
        "INFO:near a closed amaco station sr 34 south in a ford ranger purple blue in color, / said he needed an ambulance (call is coming thru old bridge 9-1-1) person he is / calling about is a co-worker  old americ");

  }
  
  @Test
  public void testCodeMessaging() {

    doTest("T1",
        "(MCSO Page Notification) 26-2\n" +
        "CO ALARM\n" +
        "PAGED\n" +
        "28 GEMINI LN,26\n" +
        "F262M\n" +
        "F262A\n" +
        "CO2 alarm going off.\n" +
        "CALLER INSTRUCTED TO TAKE HERSELF AND HER CHILD OUT OF THE HOME, AND AWAIT\n" +
        "FOR\n" +
        "FIRE DEPT TO CHECK THE SCENE.",

        "SRC:26-2",
        "CALL:CO ALARM",
        "ADDR:28 GEMINI LN",
        "CITY:MANALAPAN",
        "UNIT:F262M F262A",
        "INFO:CO2 alarm going off. / CALLER INSTRUCTED TO TAKE HERSELF AND HER CHILD OUT OF THE HOME, AND AWAIT / FOR / FIRE DEPT TO CHECK THE SCENE.");

    doTest("T2",
        "(MCSO Page Notification) D32\n" +
        "FIRE - ALARM\n" +
        "PAGED\n" +
        "5 ALGONQUIN TER,32\n" +
        "F3225\n" +
        "F32A\n" +
        "res/gilbert///manual pull///will att to ntfy kh\n" +
        "state police ntfd",

        "SRC:D32",
        "CALL:FIRE - ALARM",
        "ADDR:5 ALGONQUIN TER",
        "CITY:MILLSTONE",
        "UNIT:F3225 F32A",
        "INFO:res/gilbert///manual pull///will att to ntfy kh / state police ntfd");

    doTest("T3",
        "(MCSO Page Notification) D32\n" +
        "FIRE - ALARM\n" +
        "PAGED\n" +
        "5 ALGONQUIN TER,32\n" +
        "F3225\n" +
        "F32A\n" +
        "res/gilbert///manual pull///will att to ntfy kh\n" +
        "state police ntfd",

        "SRC:D32",
        "CALL:FIRE - ALARM",
        "ADDR:5 ALGONQUIN TER",
        "CITY:MILLSTONE",
        "UNIT:F3225 F32A",
        "INFO:res/gilbert///manual pull///will att to ntfy kh / state police ntfd");

    doTest("T4",
        "(MCSO Page Notification) 26-1\n" +
        "FIRE - ALARM\n" +
        "PAGED\n" +
        "285 GORDONS CORNER RD; GENIUS KIDS,26\n" +
        "F2610\n" +
        "F261A\n" +
        "ZONE  20, GENERAL, PREMISE #               732 977 1702      , KEYHOLDER  ATT TO NTFD\n" +
        "07 28 41 10/22/2012 - Crotchfelt, A - From  Cascella, A",

        "SRC:26-1",
        "CALL:FIRE - ALARM",
        "ADDR:285 GORDONS CORNER RD",
        "PLACE:GENIUS KIDS",
        "CITY:MANALAPAN",
        "UNIT:F2610 F261A",
        "INFO:ZONE  20, GENERAL, PREMISE #               732 977 1702      , KEYHOLDER  ATT TO NTFD / 07 28 41 10/22/2012 - Crotchfelt, A - From  Cascella, A");

    doTest("T5",
        "(MCSO Page Notification) 12-1\n" +
        "FIRE - ALARM\n" +
        "PAGED\n" +
        "45 WILSON AVE; KNOWLES GROUP,26\n" +
        "F121M\n" +
        "F262A\n" +
        "basement smoke detector / kh to be ntfd\n" +
        "04             00 34 10/20/2012       - Lonon, A - From  Hensly, J\n" +
        "code 3",

        "SRC:12-1",
        "CALL:FIRE - ALARM",
        "ADDR:45 WILSON AVE",
        "PLACE:KNOWLES GROUP",
        "CITY:MANALAPAN",
        "UNIT:F121M F262A",
        "INFO:basement smoke detector / kh to be ntfd / 04             00 34 10/20/2012       - Lonon, A - From  Hensly, J / code 3");

    doTest("T6",
        "(MCSO Page Notification) 26-2\n" +
        "FIRE - ALARM\n" +
        "PAGED\n" +
        "106 BEAGLE DR,26\n" +
        "F262M\n" +
        "F262A\n" +
        "smoke alarm sounding. does not smell or see anything\n" +
        "residents out of the house",

        "SRC:26-2",
        "CALL:FIRE - ALARM",
        "ADDR:106 BEAGLE DR",
        "CITY:MANALAPAN",
        "UNIT:F262M F262A",
        "INFO:smoke alarm sounding. does not smell or see anything / residents out of the house");

    doTest("T7",
        "(MCSO Page Notification) 26-2\n" +
        "EMS - ALS\n" +
        "PAGED\n" +
        "712 SUMMER DR,26\n" +
        "F262M\n" +
        "F262A\n" +
        "81 YOM unresponsive, trach pt\n" +
        "subj is breathing\n" +
        "inc began yesterday, has gotten worse since\n" +
        "pt hx  trache, currently attached to humidifier, cancer, brain tumor,\n" +
        "menignitis, NKDA\n" +
        "MONOC NTFD\n" +
        "pt started",

        "SRC:26-2",
        "CALL:EMS - ALS",
        "ADDR:712 SUMMER DR",
        "CITY:MANALAPAN",
        "UNIT:F262M F262A",
        "INFO:81 YOM unresponsive, trach pt / subj is breathing / inc began yesterday, has gotten worse since / pt hx  trache, currently attached to humidifier, cancer, brain tumor, / menignitis, NKDA / MONOC NTFD / pt started");

    doTest("T8",
        "(MCSO Page Notification) 26-2\n" +
        "FIRE - OTHER\n" +
        "PAGED\n" +
        "44 PALOMINO DR,\n" +
        "F26-2\n" +
        "F262A\n" +
        "PROPANE TANK AT CLUB HOUSE  NOT ATTACHED TO BLDG ON THE SIDE OUTSIDE FLAMES",

        "SRC:26-2",
        "CALL:FIRE - OTHER",
        "ADDR:44 PALOMINO DR",
        "UNIT:F26-2 F262A",
        "INFO:PROPANE TANK AT CLUB HOUSE  NOT ATTACHED TO BLDG ON THE SIDE OUTSIDE FLAMES");

  }
  
  @Test
  public void testMrBrown() {

    doTest("T1",
        "12-1  WIRE/POLE DOWN  PAGED  15 PARK AVE,12  F12-1  F12A  unk if arcing",
        "SRC:12-1",
        "CALL:WIRE/POLE DOWN",
        "ADDR:15 PARK AVE",
        "CITY:07726",
        "UNIT:F12-1 F12A",
        "INFO:unk if arcing");

    doTest("T2",
        "26-2  FIRE - ALARM  PAGED  361 ST ANDREWS PL;LEGENDS OF KNOB HILL BUILDING 26,26  F26-2  F262A  zone fa11/7327929982/will att",
        "SRC:26-2",
        "CALL:FIRE - ALARM",
        "ADDR:361 ST ANDREWS PL",
        "PLACE:LEGENDS OF KNOB HILL BUILDING 26",
        "CITY:MANALAPAN",
        "UNIT:F26-2 F262A",
        "INFO:zone fa11/7327929982/will att");

    doTest("T3",
        "26-2  FIRE - ALARM  PAGED  361 ST ANDREWS PL;LEGENDS OF KNOB HILL;BUILDING 26,26  F26-2  F262A  general fire/business/7327929982/will att",
        "SRC:26-2",
        "CALL:FIRE - ALARM",
        "ADDR:361 ST ANDREWS PL",
        "PLACE:LEGENDS OF KNOB HILL",
        "APT:BUILDING 26",
        "CITY:MANALAPAN",
        "UNIT:F26-2 F262A",
        "INFO:general fire/business/7327929982/will att");

    doTest("T4",
        "26-2  FIRE - ALARM  PAGED  2 VICTORIAN HILL,26  F262M  F262B  res  wendy silverbird prem# 732-863-6903 / gen fir / att to cont / will call bck  false alrm per a wendy on scene..she is changing the battery",
        "SRC:26-2",
        "CALL:FIRE - ALARM",
        "ADDR:2 VICTORIAN HILL",
        "CITY:MANALAPAN",
        "UNIT:F262M F262B",
        "INFO:res / wendy silverbird prem# 732-863-6903 / gen fir / att to cont / will call bck / false alrm per a wendy on scene..she is changing the battery");
   
  }
  
  public static void main(String[] args) {
    new NJMonmouthCountyAParserTest().generateTests("T1");
  }
}