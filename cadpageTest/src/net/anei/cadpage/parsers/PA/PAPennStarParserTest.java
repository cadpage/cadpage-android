package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Agency name: PennSTAR Flight
Contact: Active911
Location: Philadelphia, PA, United States
Sender: mail@ghds.net

23-13-31515: PennSTAR CCT 1, Bryn Mawr Hospital, 23-13-31515
23-13-31515: (STANDBY) PennSTAR CCT 1, Bryn Mawr Hospital, 23-13-31515
23-13-31512: PennSTAR 5, N40 49.10 W75 54.70, 6.763 nm /286.473 deg. Miners Memorial Hospital PHCOA
23-13-31512: PennSTAR 3, N40 49.10 W75 54.70, 26.797 nm /292.737 deg. Miners Memorial Hospital PHCOA
23-13-31510: PennSTAR 3, N40 29.69 W74 27.05, 42.935 nm /121.75 deg. Robert Wood Johnson Univ Hosp NHRWJ
23-13-31510: (STANDBY) PennSTAR 3, N40 29.69 W74 27.05, 42.935 nm /121.75 deg. Robert Wood Johnson Univ Hosp NHRWJ
23-13-31509: PennSTAR 5, N40 49.10 W75 54.70, 6.862 nm /286.493 deg. Miners Memorial Hospital PHCOA
23-13-31508: PennSTAR CCT 1, Mercy Philadelphia, 23-13-31508
23-13-31507: PennSTAR 2, N39 05.26 W74 49.01, 24.834 nm /218.707 deg. Cape Regional Medical Center NHBTM
27-13-4624: PennSTAR 6, OUTGOING, N40 07.12 W75 07.27, 11.197 nm /186.91 deg. Abington Memorial Hospital PHABM
23-13-31504: Patient is in PCU room #321 - Exceptional ambulance should be on scene.  Use 123.025 for any critical radio traffic
23-13-31506: PennSTAR 4, N39 05.26 W74 49.01, 93.448 nm /157.061 deg. Cape Regional Medical Center NHBTM
23-13-31504: PennSTAR 3, N39 50.80 W74 55.60, 56.698 nm /172.678 deg. Virtua Health System Voorhees NHWJE
23-13-31506: PennSTAR 4, N39 05.26 W74 49.01, 93.448 nm /157.061 deg. Cape Regional Medical Center 
23-13-31504: PennSTAR 3, N39 50.80 W74 55.60, 56.698 nm /172.678 deg. Virtua Health System Voorhees NHWJE
23-13-31505: PennSTAR 1, N39 51.41 W75 22.13, 9.951 nm /248.842 deg. Crozer Chester Medical Center PHCRC
23-13-31503: PennSTAR 1, N39 57.47 W75 12.02, 11.093 nm /176.155 deg. PPMC - Penn Presbyterian MC 
23-13-31502: PennSTAR CCT 1, Our Lady of Lourdes - Camden, 23-13-31502
23-13-31501: PennSTAR 1, N39 55.36 W75 05.52, 15.092 nm /159.899 deg. Our Lady of Lourdes - Camden NHOLL
23-13-31499: PennSTAR CCT 1, Nazareth Hospital, 23-13-31499
23-13-31498: PennSTAR 1, N40 03.34 W75 02.36, 11.549 nm /126.825 deg. Nazareth Hospital PHNAZ
23-13-31498: (STANDBY) PennSTAR 1, N40 03.34 W75 02.36, 11.549 nm /126.825 deg. Nazareth Hospital PHNAZ
23-13-31494: No final/arrive RHMC radio calls - have you on deck 9:32 per security
23-13-31494: PennSTAR 4, N40 25.36 W76 13.13, 12.051 nm /297.479 deg. Berks - 115 BC115
23-13-31494: (STANDBY) PennSTAR 4, N40 25.36 W76 13.13, 12.051 nm /297.479 deg. Berks - 115 BC115
23-13-31493: PennSTAR CCT 1, Mercy Suburban Hospital, 23-13-31493
23-13-31493: (STANDBY) PennSTAR CCT 1, Mercy Suburban Hospital, 23-13-31493
23-13-31490: PennSTAR 5, N40 48.124 W75 57.089, 8.668 nm /279.103 deg. Scene - Schuylkill County Grd Cnt: LZ65 Freq: 46.58 
23-13-31490: (STANDBY) PennSTAR 5, N40 48.124 W75 57.089, 8.668 nm /279.103 deg. Scene - Schuylkill County Grd Cnt: LZ65 Freq: 46.58 
27-13-4623: PennSTAR 6, OUTGOING, N39 56.91 W75 09.17, 21.36 nm /193.233 deg. Thomas Jefferson Univ  Level 1 PHJEF
23-13-31489: PennSTAR 4, N39 49.30 W75 53.30, 33.038 nm /185.838 deg. Jennersville Regional Hospital PHSCC
23-13-31486: PennSTAR CCT 1, Einstein Medical Center - Philadelphia, 23-13-31486
23-13-31486: PennSTAR CCT 1, Einstein Medical Center - Philadelphia, 23-13-31486
23-13-31486: (STANDBY) PennSTAR CCT 1, Einstein Medical Center - Philadelphia, 23-13-31486
27-13-4621: PennSTAR 6, N40 06.30 W74 52.10, 16.125 nm /66.216 deg. Lower Bucks Hospital PHLBH
23-13-31484: (STANDBY) PennSTAR 3, N40 49.20 W75 14.26, 6.54 nm /54.033 deg. Scene - Northampton County 
27-13-4620: PennSTAR 6, OUTGOING, N39 56.91 W75 09.17, 21.36 nm /193.233 deg. Thomas Jefferson Univ  Level 1 PHJEF
27-13-4620: (STANDBY) PennSTAR 6, OUTGOING, N39 56.91 W75 09.17, 21.36 nm /193.233 deg. Thomas Jefferson Univ  Level 1 PHJEF
23-13-31481: PennSTAR 1, N39 56.50 W75 11.46, 12.196 nm /175.348 deg. Childrens Hospital of Philadelphia PHCHP
23-13-31476: PennSTAR 2, N39 05.26 W74 49.01, 24.834 nm /218.707 deg. Cape Regional Medical Center NHBTM
27-13-4619: PennSTAR 6, OUTGOING, N40 14.11 W74 45.02, 18.503 nm /114.938 deg. Capital Health Regional Medical Center NHHEL
27-13-4619: PennSTAR 6, OUTGOING, N40 16.60 W74 48.81, 15.214 nm /108.254 deg. Trenton Mercer TTN
23-13-31474: PennSTAR 2, N40 12.35 W74 02.22, 51.337 nm /40.833 deg. Jersey Shore University Medical Center NHJSM
23-13-31474: (STANDBY) PennSTAR 2, N40 12.35 W74 02.22, 51.337 nm /40.833 deg. Jersey Shore University Medical Center NHJSM
23-13-31472: PennSTAR 3, N39 54.80 W75 26.00, 49.589 nm /197.304 deg. Riddle Memorial Hospital PHRMH
23-13-31473: PennSTAR 4, N39 58.14 W75 36.12, 29.257 nm /157.152 deg. Chester County Hospital PHCCH
23-13-31473: (STANDBY) PennSTAR 4, N39 58.14 W75 36.12, 29.257 nm /157.152 deg. Chester County Hospital PHCCH
23-13-31470: (STANDBY) PennSTAR 1, N40 08.50 W75 18.85, 2.192 nm /290.169 deg. Mercy Suburban Hospital PHSGHFreq: PSCL 1 
23-13-31468: (STANDBY) PennSTAR 4, N40 18.47 W75 59.63, 3.922 nm /211.415 deg. Berks - 193 BC193
23-13-31464: PennSTAR 1, N0 00.00 W0 00.00, 4730.228 nm /111.621 deg. Scene - Montgomery County 
23-13-31463: PennSTAR CCT 1, Einstein Medical Center - Philadelphia, 23-13-31463
23-13-31459: PennSTAR CCT 1, Chester County Hospital, 23-13-31459
23-13-31455: PennSTAR CCT 1, Pennsylvania Hospital, 23-13-31455
23-13-31454: PennSTAR 2, N39 09.28 W75 31.46, 47.707 nm /259.839 deg. Kent General Hospital DHKGH
23-13-31454: PennSTAR 2, N39 09.28 W75 31.46, 47.707 nm /259.839 deg. Kent General Hospital DHKGH
27-13-4618: 40 00.429\n75 07.578
23-13-31453: PennSTAR CCT 1, Va Med Ctr Philadelphia, 23-13-31453
27-13-4618: PennSTAR 6, N40 16.58 W75 13.074, 3.843 nm /255.697 deg. Scene - Bucks County Grd Cnt: Deputy 34 Freq: FGND 1 
27-13-4618: PennSTAR 6, N40 17.016 W75 13.367, 3.882 nm /262.968 deg. Scene - Bucks County 
27-13-4618: (STANDBY) PennSTAR 6, N40 17.016 W75 13.367, 3.882 nm /262.968 deg. Scene - Bucks County 
23-13-31451: PennSTAR 5, N40 47.367 W75 39.814, 4.71 nm /116.812 deg. Scene - Carbon County 
23-13-31450: PennSTAR 3, N40 43.342 W75 38.309, 13.61 nm /278.132 deg. Scene - Lehigh County Grd Cnt: 904 
23-13-31450: PennSTAR 3, N40 43.962 W75 37.606, 13.372 nm /281.029 deg. Scene - Lehigh County 
23-13-31450: PennSTAR 3, N40 43.999 W75 38.613, 14.136 nm /281.243 deg. Scene - Lehigh County 
23-13-31449: PennSTAR CCT 1, Mercy Philadelphia, 23-13-31449
23-13-31448: PennSTAR 5, N40 49.10 W75 54.70, 6.862 nm /286.493 deg. Miners Memorial Hospital PHCOA
23-13-31448: (STANDBY) PennSTAR 5, N40 49.10 W75 54.70, 6.862 nm /286.493 deg. Miners Memorial Hospital PHCOA
23-13-31447: PennSTAR 1, N40 08.50 W75 18.85, 2.192 nm /290.169 deg. Mercy Suburban Hospital PHSGH
27-13-4616: 175 lbs
27-13-4616: PennSTAR 6, N40 04.00 W74 58.60, 16.187 nm /163.872 deg. Aria Health - Torresdale PHFHT
23-13-31444: PennSTAR CCT 1, HUP - Hosp of Univ of Penn, 23-13-31444
23-13-31442: PennSTAR CCT 1, HUP - Hosp of Univ of Penn, 23-13-31442
23-13-31441: PennSTAR 1, N40 16.052 W75 21.881, 10.987 nm /334.653 deg. Scene - Montgomery County 
23-13-31440: PennSTAR 3, N40 03.34 W75 02.36, 43.015 nm /173.689 deg. Nazareth Hospital PHNAZ
23-13-31439: (STANDBY) PennSTAR 1, N39 43.10 W74 16.70, 44.25 nm /119.865 deg. Southern Ocean County Hospital NHSOC
27-13-4615: 67F
27-13-4615: PennSTAR 6, N40 00.61 W75 46.73, 34.458 nm /250.658 deg. Brandywine Hospital PHBRD
27-13-4615: (STANDBY) PennSTAR 6, N40 00.61 W75 46.73, 34.458 nm /250.658 deg. Brandywine Hospital PHBRD
23-13-31438: PennSTAR 1, N40 04.00 W74 58.60, 14.008 nm /119.362 deg. Aria Health -Torresdale PHFHT
27-13-4614: PennSTAR 6, N40 18.54 W75 13.01, 2.558 nm /320.523 deg. Scene - Bucks County Grd Cnt: Chief 34 Freq: FGND 1 
27-13-4614: PennSTAR 6, N40 18.54 W75 13.01, 2.558 nm /320.523 deg. Scene - Bucks County Grd Cnt: Deputy 34 
23-13-31437: PennSTAR 2, N39 18.70 W74 35.50, 8.779 nm /196.394 deg. Shore Memorial Hospital NHSMM
23-13-31431: PennSTAR 1, N40 06.71 W75 04.55, 6.445 nm /86.949 deg. Holy Redeemer Hospital PHHRH
23-13-31431: PennSTAR 1, N40 06.71 W75 04.55, 6.445 nm /86.949 deg. Holy Redeemer Hospital PHHRH
23-13-31429: PennSTAR 1, N40 07.12 W75 07.27, 6.797 nm /111.039 deg. Abington Memorial Hospital PHABM
23-13-31428: PennSTAR 2, N38 54.30 W75 25.40, 51.248 nm /242.751 deg. Milford Memorial Hospital DHMMH
23-13-31428: (STANDBY) PennSTAR 2, N38 54.30 W75 25.40, 51.248 nm /242.751 deg. Milford Memorial Hospital DHMMH
23-13-31426: PennSTAR 4, N40 36.50 W75 23.60, 29.847 nm /73.047 deg. SLH - Saint Lukes Hospital PHSLH
23-13-31421: PennSTAR 1, N40 08.50 W75 18.85, 2.235 nm /291.156 deg. Mercy Suburban Hospital PHSGH
23-13-31421: PennSTAR 1, N40 08.50 W75 18.85, 2.235 nm /291.156 deg. Mercy Suburban Hospital PHSGH
27-13-4613: PennSTAR 6, OUTGOING, N40 00.10 W75 08.60, 18.168 nm /192.072 deg. Temple Univ Hospital - Level 1 PHTUH
23-13-31418: 46F Seizures no drip no vent ICU->NEURO ICU 55kg 106/60 99%RA 19 70
23-13-31418: PennSTAR CCT 1, Holy Redeemer Hospital, 23-13-31418
23-13-31416: PennSTAR 4, N40 07.40 W75 30.95, 25.385 nm /137.514 deg. Phoenixville Hospital PHPVH
23-13-31416: (STANDBY) PennSTAR 4, N40 07.40 W75 30.95, 25.385 nm /137.514 deg. Phoenixville Hospital PHPVH
23-13-31416: (STANDBY) PennSTAR 4, N40 07.40 W75 30.95, 25.385 nm /137.514 deg. Phoenixville Hospital PHPVH
23-13-31415: PennSTAR CCT 1, HUP - Hosp of Univ of Penn, 23-13-31415
23-13-31414: PennSTAR 5, N40 49.10 W75 54.70, 6.862 nm /286.493 deg. Miners Memorial Hospital PHCOA
23-13-31412: PennSTAR 2, N40 29.60 W74 26.70, 62.394 nm /17.543 deg. St Peters Medical Center NHSPM
23-13-31409: (STANDBY) PennSTAR CCT 1, PPMC - Penn Presbyterian MC, 23-13-31409

Notes:  It is a mystery to me why these people want to use Cadpage.  They are an arial transport agency, they 
their own navigation aids to get where they need to know and sure as heck better not be counting on something
Google maps to show them how to get there.

Payout: $100
Basically a lot of index searchs and pattern matches.
23-13-31409 -> strCallId
(STANDBY) -> append to end of strCall
PennSTART CCT 1 -> unit
N40 29.60 W74 26.70, 62.394 nm /17.543 deg. -> strAddress
Miners Memorial Hospital -> strCall
PHCOA -> strCode
Freq: -> strChannel
Grd Cnt: -> keep label and put in strSupp

If you can't parse anything except the initial call ID, put the rest of the text in strPlace
and set strCall to "GENERAL ALERT"

*/

public class PAPennStarParserTest extends BaseParserTest {
  
  public PAPennStarParserTest() {
    setParser(new PAPennStarParser(), "", "");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "23-13-31515: PennSTAR CCT 1, Bryn Mawr Hospital, 23-13-31515",
        "ID:23-13-31515",
        "UNIT:PennSTAR CCT 1",
        "CALL:Bryn Mawr Hospital",
        "CODE:31515");

    doTest("T2",
        "23-13-31515: (STANDBY) PennSTAR CCT 1, Bryn Mawr Hospital, 23-13-31515",
        "ID:23-13-31515",
        "UNIT:PennSTAR CCT 1",
        "CALL:(STANDBY) Bryn Mawr Hospital",
        "CODE:31515");

    doTest("T3",
        "23-13-31512: PennSTAR 5, N40 49.10 W75 54.70, 6.763 nm /286.473 deg. Miners Memorial Hospital PHCOA",
        "ID:23-13-31512",
        "UNIT:PennSTAR 5",
        "ADDR:N40 49.10 W75 54.70, 6.763 nm /286.473 deg.",
        "MADDR:+40.818333,-75.911667",
        "GPS:+40.818333,-75.911667",
        "CALL:Miners Memorial Hospital",
        "CODE:PHCOA");

    doTest("T4",
        "23-13-31512: PennSTAR 3, N40 49.10 W75 54.70, 26.797 nm /292.737 deg. Miners Memorial Hospital PHCOA",
        "ID:23-13-31512",
        "UNIT:PennSTAR 3",
        "ADDR:N40 49.10 W75 54.70, 26.797 nm /292.737 deg.",
        "MADDR:+40.818333,-75.911667",
        "GPS:+40.818333,-75.911667",
        "CALL:Miners Memorial Hospital",
        "CODE:PHCOA");

    doTest("T5",
        "23-13-31510: PennSTAR 3, N40 29.69 W74 27.05, 42.935 nm /121.75 deg. Robert Wood Johnson Univ Hosp NHRWJ",
        "ID:23-13-31510",
        "UNIT:PennSTAR 3",
        "ADDR:N40 29.69 W74 27.05, 42.935 nm /121.75 deg.",
        "MADDR:+40.494833,-74.450833",
        "GPS:+40.494833,-74.450833",
        "CALL:Robert Wood Johnson Univ Hosp",
        "CODE:NHRWJ");

    doTest("T6",
        "23-13-31510: (STANDBY) PennSTAR 3, N40 29.69 W74 27.05, 42.935 nm /121.75 deg. Robert Wood Johnson Univ Hosp NHRWJ",
        "ID:23-13-31510",
        "UNIT:PennSTAR 3",
        "ADDR:N40 29.69 W74 27.05, 42.935 nm /121.75 deg.",
        "MADDR:+40.494833,-74.450833",
        "GPS:+40.494833,-74.450833",
        "CALL:(STANDBY) Robert Wood Johnson Univ Hosp",
        "CODE:NHRWJ");

    doTest("T7",
        "23-13-31509: PennSTAR 5, N40 49.10 W75 54.70, 6.862 nm /286.493 deg. Miners Memorial Hospital PHCOA",
        "ID:23-13-31509",
        "UNIT:PennSTAR 5",
        "ADDR:N40 49.10 W75 54.70, 6.862 nm /286.493 deg.",
        "MADDR:+40.818333,-75.911667",
        "GPS:+40.818333,-75.911667",
        "CALL:Miners Memorial Hospital",
        "CODE:PHCOA");

    doTest("T8",
        "23-13-31508: PennSTAR CCT 1, Mercy Philadelphia, 23-13-31508",
        "ID:23-13-31508",
        "UNIT:PennSTAR CCT 1",
        "CALL:Mercy Philadelphia",
        "CODE:31508");

    doTest("T9",
        "23-13-31507: PennSTAR 2, N39 05.26 W74 49.01, 24.834 nm /218.707 deg. Cape Regional Medical Center NHBTM",
        "ID:23-13-31507",
        "UNIT:PennSTAR 2",
        "ADDR:N39 05.26 W74 49.01, 24.834 nm /218.707 deg.",
        "MADDR:+39.087667,-74.816833",
        "GPS:+39.087667,-74.816833",
        "CALL:Cape Regional Medical Center",
        "CODE:NHBTM");

    doTest("T10",
        "27-13-4624: PennSTAR 6, OUTGOING, N40 07.12 W75 07.27, 11.197 nm /186.91 deg. Abington Memorial Hospital PHABM",
        "ID:27-13-4624",
        "UNIT:PennSTAR 6",
        "ADDR:N40 07.12 W75 07.27, 11.197 nm /186.91 deg.",
        "MADDR:+40.118667,-75.121167",
        "GPS:+40.118667,-75.121167",
        "CALL:OUTGOING - Abington Memorial Hospital",
        "CODE:PHABM");

    doTest("T11",
        "23-13-31504: Patient is in PCU room #321 - Exceptional ambulance should be on scene.  Use 123.025 for any critical radio traffic",
        "CALL:GENERAL ALERT",
        "ID:23-13-31504",
        "PLACE:Patient is in PCU room #321 - Exceptional ambulance should be on scene.  Use 123.025 for any critical radio traffic");

    doTest("T12",
        "23-13-31506: PennSTAR 4, N39 05.26 W74 49.01, 93.448 nm /157.061 deg. Cape Regional Medical Center NHBTM",
        "ID:23-13-31506",
        "UNIT:PennSTAR 4",
        "ADDR:N39 05.26 W74 49.01, 93.448 nm /157.061 deg.",
        "MADDR:+39.087667,-74.816833",
        "GPS:+39.087667,-74.816833",
        "CALL:Cape Regional Medical Center",
        "CODE:NHBTM");

    doTest("T13",
        "23-13-31504: PennSTAR 3, N39 50.80 W74 55.60, 56.698 nm /172.678 deg. Virtua Health System Voorhees NHWJE",
        "ID:23-13-31504",
        "UNIT:PennSTAR 3",
        "ADDR:N39 50.80 W74 55.60, 56.698 nm /172.678 deg.",
        "MADDR:+39.846667,-74.926667",
        "GPS:+39.846667,-74.926667",
        "CALL:Virtua Health System Voorhees",
        "CODE:NHWJE");

    doTest("T14",
        "23-13-31506: PennSTAR 4, N39 05.26 W74 49.01, 93.448 nm /157.061 deg. Cape Regional Medical Center ",
        "ID:23-13-31506",
        "UNIT:PennSTAR 4",
        "ADDR:N39 05.26 W74 49.01, 93.448 nm /157.061 deg.",
        "MADDR:+39.087667,-74.816833",
        "GPS:+39.087667,-74.816833",
        "CALL:Cape Regional Medical Center");

    doTest("T15",
        "23-13-31504: PennSTAR 3, N39 50.80 W74 55.60, 56.698 nm /172.678 deg. Virtua Health System Voorhees NHWJE",
        "ID:23-13-31504",
        "UNIT:PennSTAR 3",
        "ADDR:N39 50.80 W74 55.60, 56.698 nm /172.678 deg.",
        "MADDR:+39.846667,-74.926667",
        "GPS:+39.846667,-74.926667",
        "CALL:Virtua Health System Voorhees",
        "CODE:NHWJE");

    doTest("T16",
        "23-13-31505: PennSTAR 1, N39 51.41 W75 22.13, 9.951 nm /248.842 deg. Crozer Chester Medical Center PHCRC",
        "ID:23-13-31505",
        "UNIT:PennSTAR 1",
        "ADDR:N39 51.41 W75 22.13, 9.951 nm /248.842 deg.",
        "MADDR:+39.856833,-75.368833",
        "GPS:+39.856833,-75.368833",
        "CALL:Crozer Chester Medical Center",
        "CODE:PHCRC");

    doTest("T17",
        "23-13-31503: PennSTAR 1, N39 57.47 W75 12.02, 11.093 nm /176.155 deg. PPMC - Penn Presbyterian MC ",
        "ID:23-13-31503",
        "UNIT:PennSTAR 1",
        "ADDR:N39 57.47 W75 12.02, 11.093 nm /176.155 deg.",
        "MADDR:+39.957833,-75.200333",
        "GPS:+39.957833,-75.200333",
        "CALL:PPMC - Penn Presbyterian MC");

    doTest("T18",
        "23-13-31502: PennSTAR CCT 1, Our Lady of Lourdes - Camden, 23-13-31502",
        "ID:23-13-31502",
        "UNIT:PennSTAR CCT 1",
        "CALL:Our Lady of Lourdes - Camden",
        "CODE:31502");

    doTest("T19",
        "23-13-31501: PennSTAR 1, N39 55.36 W75 05.52, 15.092 nm /159.899 deg. Our Lady of Lourdes - Camden NHOLL",
        "ID:23-13-31501",
        "UNIT:PennSTAR 1",
        "ADDR:N39 55.36 W75 05.52, 15.092 nm /159.899 deg.",
        "MADDR:+39.922667,-75.092000",
        "GPS:+39.922667,-75.092000",
        "CALL:Our Lady of Lourdes - Camden",
        "CODE:NHOLL");

    doTest("T20",
        "23-13-31499: PennSTAR CCT 1, Nazareth Hospital, 23-13-31499",
        "ID:23-13-31499",
        "UNIT:PennSTAR CCT 1",
        "CALL:Nazareth Hospital",
        "CODE:31499");

    doTest("T21",
        "23-13-31498: PennSTAR 1, N40 03.34 W75 02.36, 11.549 nm /126.825 deg. Nazareth Hospital PHNAZ",
        "ID:23-13-31498",
        "UNIT:PennSTAR 1",
        "ADDR:N40 03.34 W75 02.36, 11.549 nm /126.825 deg.",
        "MADDR:+40.055667,-75.039333",
        "GPS:+40.055667,-75.039333",
        "CALL:Nazareth Hospital",
        "CODE:PHNAZ");

    doTest("T22",
        "23-13-31498: (STANDBY) PennSTAR 1, N40 03.34 W75 02.36, 11.549 nm /126.825 deg. Nazareth Hospital PHNAZ",
        "ID:23-13-31498",
        "UNIT:PennSTAR 1",
        "ADDR:N40 03.34 W75 02.36, 11.549 nm /126.825 deg.",
        "MADDR:+40.055667,-75.039333",
        "GPS:+40.055667,-75.039333",
        "CALL:(STANDBY) Nazareth Hospital",
        "CODE:PHNAZ");

    doTest("T23",
        "23-13-31494: No final/arrive RHMC radio calls - have you on deck 9:32 per security",
        "CALL:GENERAL ALERT",
        "ID:23-13-31494",
        "PLACE:No final/arrive RHMC radio calls - have you on deck 9:32 per security");

    doTest("T24",
        "23-13-31494: PennSTAR 4, N40 25.36 W76 13.13, 12.051 nm /297.479 deg. Berks - 115 BC115",
        "ID:23-13-31494",
        "UNIT:PennSTAR 4",
        "ADDR:N40 25.36 W76 13.13, 12.051 nm /297.479 deg.",
        "MADDR:+40.422667,-76.218833",
        "GPS:+40.422667,-76.218833",
        "CALL:Berks - 115",
        "CODE:BC115");

    doTest("T25",
        "23-13-31494: (STANDBY) PennSTAR 4, N40 25.36 W76 13.13, 12.051 nm /297.479 deg. Berks - 115 BC115",
        "ID:23-13-31494",
        "UNIT:PennSTAR 4",
        "ADDR:N40 25.36 W76 13.13, 12.051 nm /297.479 deg.",
        "MADDR:+40.422667,-76.218833",
        "GPS:+40.422667,-76.218833",
        "CALL:(STANDBY) Berks - 115",
        "CODE:BC115");

    doTest("T26",
        "23-13-31493: PennSTAR CCT 1, Mercy Suburban Hospital, 23-13-31493",
        "ID:23-13-31493",
        "UNIT:PennSTAR CCT 1",
        "CALL:Mercy Suburban Hospital",
        "CODE:31493");

    doTest("T27",
        "23-13-31493: (STANDBY) PennSTAR CCT 1, Mercy Suburban Hospital, 23-13-31493",
        "ID:23-13-31493",
        "UNIT:PennSTAR CCT 1",
        "CALL:(STANDBY) Mercy Suburban Hospital",
        "CODE:31493");

    doTest("T28",
        "23-13-31490: PennSTAR 5, N40 48.124 W75 57.089, 8.668 nm /279.103 deg. Scene - Schuylkill County Grd Cnt: LZ65 Freq: 46.58 ",
        "ID:23-13-31490",
        "UNIT:PennSTAR 5",
        "ADDR:N40 48.124 W75 57.089, 8.668 nm /279.103 deg.",
        "MADDR:+40.802067,-75.951483",
        "GPS:+40.802067,-75.951483",
        "CALL:Scene - Schuylkill County ",
        "INFO:Grd Cnt: LZ65",
        "CH:46.58");

    doTest("T29",
        "23-13-31490: (STANDBY) PennSTAR 5, N40 48.124 W75 57.089, 8.668 nm /279.103 deg. Scene - Schuylkill County Grd Cnt: LZ65 Freq: 46.58 ",
        "ID:23-13-31490",
        "UNIT:PennSTAR 5",
        "ADDR:N40 48.124 W75 57.089, 8.668 nm /279.103 deg.",
        "MADDR:+40.802067,-75.951483",
        "GPS:+40.802067,-75.951483",
        "CALL:(STANDBY) Scene - Schuylkill County ",
        "INFO:Grd Cnt: LZ65",
        "CH:46.58");

    doTest("T30",
        "27-13-4623: PennSTAR 6, OUTGOING, N39 56.91 W75 09.17, 21.36 nm /193.233 deg. Thomas Jefferson Univ  Level 1 PHJEF",
        "ID:27-13-4623",
        "UNIT:PennSTAR 6",
        "ADDR:N39 56.91 W75 09.17, 21.36 nm /193.233 deg.",
        "MADDR:+39.948500,-75.152833",
        "GPS:+39.948500,-75.152833",
        "CALL:OUTGOING - Thomas Jefferson Univ  Level 1",
        "CODE:PHJEF");

    doTest("T31",
        "23-13-31489: PennSTAR 4, N39 49.30 W75 53.30, 33.038 nm /185.838 deg. Jennersville Regional Hospital PHSCC",
        "ID:23-13-31489",
        "UNIT:PennSTAR 4",
        "ADDR:N39 49.30 W75 53.30, 33.038 nm /185.838 deg.",
        "MADDR:+39.821667,-75.888333",
        "GPS:+39.821667,-75.888333",
        "CALL:Jennersville Regional Hospital",
        "CODE:PHSCC");

    doTest("T32",
        "23-13-31486: PennSTAR CCT 1, Einstein Medical Center - Philadelphia, 23-13-31486",
        "ID:23-13-31486",
        "UNIT:PennSTAR CCT 1",
        "CALL:Einstein Medical Center - Philadelphia",
        "CODE:31486");

    doTest("T33",
        "23-13-31486: PennSTAR CCT 1, Einstein Medical Center - Philadelphia, 23-13-31486",
        "ID:23-13-31486",
        "UNIT:PennSTAR CCT 1",
        "CALL:Einstein Medical Center - Philadelphia",
        "CODE:31486");

    doTest("T34",
        "23-13-31486: (STANDBY) PennSTAR CCT 1, Einstein Medical Center - Philadelphia, 23-13-31486",
        "ID:23-13-31486",
        "UNIT:PennSTAR CCT 1",
        "CALL:(STANDBY) Einstein Medical Center - Philadelphia",
        "CODE:31486");

    doTest("T35",
        "27-13-4621: PennSTAR 6, N40 06.30 W74 52.10, 16.125 nm /66.216 deg. Lower Bucks Hospital PHLBH",
        "ID:27-13-4621",
        "UNIT:PennSTAR 6",
        "ADDR:N40 06.30 W74 52.10, 16.125 nm /66.216 deg.",
        "MADDR:+40.105000,-74.868333",
        "GPS:+40.105000,-74.868333",
        "CALL:Lower Bucks Hospital",
        "CODE:PHLBH");

    doTest("T36",
        "23-13-31484: (STANDBY) PennSTAR 3, N40 49.20 W75 14.26, 6.54 nm /54.033 deg. Scene - Northampton County ",
        "ID:23-13-31484",
        "UNIT:PennSTAR 3",
        "ADDR:N40 49.20 W75 14.26, 6.54 nm /54.033 deg.",
        "MADDR:+40.820000,-75.237667",
        "GPS:+40.820000,-75.237667",
        "CALL:(STANDBY) Scene - Northampton County");

    doTest("T37",
        "27-13-4620: PennSTAR 6, OUTGOING, N39 56.91 W75 09.17, 21.36 nm /193.233 deg. Thomas Jefferson Univ  Level 1 PHJEF",
        "ID:27-13-4620",
        "UNIT:PennSTAR 6",
        "ADDR:N39 56.91 W75 09.17, 21.36 nm /193.233 deg.",
        "MADDR:+39.948500,-75.152833",
        "GPS:+39.948500,-75.152833",
        "CALL:OUTGOING - Thomas Jefferson Univ  Level 1",
        "CODE:PHJEF");

    doTest("T38",
        "27-13-4620: (STANDBY) PennSTAR 6, OUTGOING, N39 56.91 W75 09.17, 21.36 nm /193.233 deg. Thomas Jefferson Univ  Level 1 PHJEF",
        "ID:27-13-4620",
        "UNIT:PennSTAR 6",
        "ADDR:N39 56.91 W75 09.17, 21.36 nm /193.233 deg.",
        "MADDR:+39.948500,-75.152833",
        "GPS:+39.948500,-75.152833",
        "CALL:OUTGOING - Thomas Jefferson Univ  Level 1",
        "CODE:PHJEF");

    doTest("T39",
        "23-13-31481: PennSTAR 1, N39 56.50 W75 11.46, 12.196 nm /175.348 deg. Childrens Hospital of Philadelphia PHCHP",
        "ID:23-13-31481",
        "UNIT:PennSTAR 1",
        "ADDR:N39 56.50 W75 11.46, 12.196 nm /175.348 deg.",
        "MADDR:+39.941667,-75.191000",
        "GPS:+39.941667,-75.191000",
        "CALL:Childrens Hospital of Philadelphia",
        "CODE:PHCHP");

    doTest("T40",
        "23-13-31476: PennSTAR 2, N39 05.26 W74 49.01, 24.834 nm /218.707 deg. Cape Regional Medical Center NHBTM",
        "ID:23-13-31476",
        "UNIT:PennSTAR 2",
        "ADDR:N39 05.26 W74 49.01, 24.834 nm /218.707 deg.",
        "MADDR:+39.087667,-74.816833",
        "GPS:+39.087667,-74.816833",
        "CALL:Cape Regional Medical Center",
        "CODE:NHBTM");

    doTest("T41",
        "27-13-4619: PennSTAR 6, OUTGOING, N40 14.11 W74 45.02, 18.503 nm /114.938 deg. Capital Health Regional Medical Center NHHEL",
        "ID:27-13-4619",
        "UNIT:PennSTAR 6",
        "ADDR:N40 14.11 W74 45.02, 18.503 nm /114.938 deg.",
        "MADDR:+40.235167,-74.750333",
        "GPS:+40.235167,-74.750333",
        "CALL:OUTGOING - Capital Health Regional Medical Center",
        "CODE:NHHEL");

    doTest("T42",
        "27-13-4619: PennSTAR 6, OUTGOING, N40 16.60 W74 48.81, 15.214 nm /108.254 deg. Trenton Mercer TTN",
        "ID:27-13-4619",
        "UNIT:PennSTAR 6",
        "ADDR:N40 16.60 W74 48.81, 15.214 nm /108.254 deg.",
        "MADDR:+40.276667,-74.813500",
        "GPS:+40.276667,-74.813500",
        "CALL:OUTGOING - Trenton Mercer TTN");

    doTest("T43",
        "23-13-31474: PennSTAR 2, N40 12.35 W74 02.22, 51.337 nm /40.833 deg. Jersey Shore University Medical Center NHJSM",
        "ID:23-13-31474",
        "UNIT:PennSTAR 2",
        "ADDR:N40 12.35 W74 02.22, 51.337 nm /40.833 deg.",
        "MADDR:+40.205833,-74.037000",
        "GPS:+40.205833,-74.037000",
        "CALL:Jersey Shore University Medical Center",
        "CODE:NHJSM");

    doTest("T44",
        "23-13-31474: (STANDBY) PennSTAR 2, N40 12.35 W74 02.22, 51.337 nm /40.833 deg. Jersey Shore University Medical Center NHJSM",
        "ID:23-13-31474",
        "UNIT:PennSTAR 2",
        "ADDR:N40 12.35 W74 02.22, 51.337 nm /40.833 deg.",
        "MADDR:+40.205833,-74.037000",
        "GPS:+40.205833,-74.037000",
        "CALL:(STANDBY) Jersey Shore University Medical Center",
        "CODE:NHJSM");

    doTest("T45",
        "23-13-31472: PennSTAR 3, N39 54.80 W75 26.00, 49.589 nm /197.304 deg. Riddle Memorial Hospital PHRMH",
        "ID:23-13-31472",
        "UNIT:PennSTAR 3",
        "ADDR:N39 54.80 W75 26.00, 49.589 nm /197.304 deg.",
        "MADDR:+39.913333,-75.433333",
        "GPS:+39.913333,-75.433333",
        "CALL:Riddle Memorial Hospital",
        "CODE:PHRMH");

    doTest("T46",
        "23-13-31473: PennSTAR 4, N39 58.14 W75 36.12, 29.257 nm /157.152 deg. Chester County Hospital PHCCH",
        "ID:23-13-31473",
        "UNIT:PennSTAR 4",
        "ADDR:N39 58.14 W75 36.12, 29.257 nm /157.152 deg.",
        "MADDR:+39.969000,-75.602000",
        "GPS:+39.969000,-75.602000",
        "CALL:Chester County Hospital",
        "CODE:PHCCH");

    doTest("T47",
        "23-13-31473: (STANDBY) PennSTAR 4, N39 58.14 W75 36.12, 29.257 nm /157.152 deg. Chester County Hospital PHCCH",
        "ID:23-13-31473",
        "UNIT:PennSTAR 4",
        "ADDR:N39 58.14 W75 36.12, 29.257 nm /157.152 deg.",
        "MADDR:+39.969000,-75.602000",
        "GPS:+39.969000,-75.602000",
        "CALL:(STANDBY) Chester County Hospital",
        "CODE:PHCCH");

    doTest("T48",
        "23-13-31470: (STANDBY) PennSTAR 1, N40 08.50 W75 18.85, 2.192 nm /290.169 deg. Mercy Suburban Hospital PHSGHFreq: PSCL 1 ",
        "ID:23-13-31470",
        "UNIT:PennSTAR 1",
        "ADDR:N40 08.50 W75 18.85, 2.192 nm /290.169 deg.",
        "MADDR:+40.141667,-75.314167",
        "GPS:+40.141667,-75.314167",
        "CALL:(STANDBY) Mercy Suburban Hospital",
        "CODE:PHSGH",
        "CH:PSCL 1");

    doTest("T49",
        "23-13-31468: (STANDBY) PennSTAR 4, N40 18.47 W75 59.63, 3.922 nm /211.415 deg. Berks - 193 BC193",
        "ID:23-13-31468",
        "UNIT:PennSTAR 4",
        "ADDR:N40 18.47 W75 59.63, 3.922 nm /211.415 deg.",
        "MADDR:+40.307833,-75.993833",
        "GPS:+40.307833,-75.993833",
        "CALL:(STANDBY) Berks - 193",
        "CODE:BC193");

    doTest("T50",
        "23-13-31464: PennSTAR 1, N0 00.00 W0 00.00, 4730.228 nm /111.621 deg. Scene - Montgomery County ",
        "ID:23-13-31464",
        "UNIT:PennSTAR 1",
        "ADDR:N0 00.00 W0 00.00, 4730.228 nm /111.621 deg.",
        "CALL:Scene - Montgomery County");

    doTest("T51",
        "23-13-31463: PennSTAR CCT 1, Einstein Medical Center - Philadelphia, 23-13-31463",
        "ID:23-13-31463",
        "UNIT:PennSTAR CCT 1",
        "CALL:Einstein Medical Center - Philadelphia",
        "CODE:31463");

    doTest("T52",
        "23-13-31459: PennSTAR CCT 1, Chester County Hospital, 23-13-31459",
        "ID:23-13-31459",
        "UNIT:PennSTAR CCT 1",
        "CALL:Chester County Hospital",
        "CODE:31459");

    doTest("T53",
        "23-13-31455: PennSTAR CCT 1, Pennsylvania Hospital, 23-13-31455",
        "ID:23-13-31455",
        "UNIT:PennSTAR CCT 1",
        "CALL:Pennsylvania Hospital",
        "CODE:31455");

    doTest("T54",
        "23-13-31454: PennSTAR 2, N39 09.28 W75 31.46, 47.707 nm /259.839 deg. Kent General Hospital DHKGH",
        "ID:23-13-31454",
        "UNIT:PennSTAR 2",
        "ADDR:N39 09.28 W75 31.46, 47.707 nm /259.839 deg.",
        "MADDR:+39.154667,-75.524333",
        "GPS:+39.154667,-75.524333",
        "CALL:Kent General Hospital",
        "CODE:DHKGH");

    doTest("T55",
        "23-13-31454: PennSTAR 2, N39 09.28 W75 31.46, 47.707 nm /259.839 deg. Kent General Hospital DHKGH",
        "ID:23-13-31454",
        "UNIT:PennSTAR 2",
        "ADDR:N39 09.28 W75 31.46, 47.707 nm /259.839 deg.",
        "MADDR:+39.154667,-75.524333",
        "GPS:+39.154667,-75.524333",
        "CALL:Kent General Hospital",
        "CODE:DHKGH");

    doTest("T56",
        "27-13-4618: 40 00.429\n75 07.578",
        "CALL:GENERAL ALERT",
        "ID:27-13-4618",
        "PLACE:40 00.429\n75 07.578");

    doTest("T57",
        "23-13-31453: PennSTAR CCT 1, Va Med Ctr Philadelphia, 23-13-31453",
        "ID:23-13-31453",
        "UNIT:PennSTAR CCT 1",
        "CALL:Va Med Ctr Philadelphia",
        "CODE:31453");

    doTest("T58",
        "27-13-4618: PennSTAR 6, N40 16.58 W75 13.074, 3.843 nm /255.697 deg. Scene - Bucks County Grd Cnt: Deputy 34 Freq: FGND 1 ",
        "ID:27-13-4618",
        "UNIT:PennSTAR 6",
        "ADDR:N40 16.58 W75 13.074, 3.843 nm /255.697 deg.",
        "MADDR:+40.276333,-75.217900",
        "GPS:+40.276333,-75.217900",
        "CALL:Scene - Bucks County ",
        "INFO:Grd Cnt: Deputy 34",
        "CH:FGND 1");

    doTest("T59",
        "27-13-4618: PennSTAR 6, N40 17.016 W75 13.367, 3.882 nm /262.968 deg. Scene - Bucks County ",
        "ID:27-13-4618",
        "UNIT:PennSTAR 6",
        "ADDR:N40 17.016 W75 13.367, 3.882 nm /262.968 deg.",
        "MADDR:+40.283600,-75.222783",
        "GPS:+40.283600,-75.222783",
        "CALL:Scene - Bucks County");

    doTest("T60",
        "27-13-4618: (STANDBY) PennSTAR 6, N40 17.016 W75 13.367, 3.882 nm /262.968 deg. Scene - Bucks County ",
        "ID:27-13-4618",
        "UNIT:PennSTAR 6",
        "ADDR:N40 17.016 W75 13.367, 3.882 nm /262.968 deg.",
        "MADDR:+40.283600,-75.222783",
        "GPS:+40.283600,-75.222783",
        "CALL:(STANDBY) Scene - Bucks County");

    doTest("T61",
        "23-13-31451: PennSTAR 5, N40 47.367 W75 39.814, 4.71 nm /116.812 deg. Scene - Carbon County ",
        "ID:23-13-31451",
        "UNIT:PennSTAR 5",
        "ADDR:N40 47.367 W75 39.814, 4.71 nm /116.812 deg.",
        "MADDR:+40.789450,-75.663567",
        "GPS:+40.789450,-75.663567",
        "CALL:Scene - Carbon County");

    doTest("T62",
        "23-13-31450: PennSTAR 3, N40 43.342 W75 38.309, 13.61 nm /278.132 deg. Scene - Lehigh County Grd Cnt: 904 ",
        "ID:23-13-31450",
        "UNIT:PennSTAR 3",
        "ADDR:N40 43.342 W75 38.309, 13.61 nm /278.132 deg.",
        "MADDR:+40.722367,-75.638483",
        "GPS:+40.722367,-75.638483",
        "CALL:Scene - Lehigh County ",
        "INFO:Grd Cnt: 904");

    doTest("T63",
        "23-13-31450: PennSTAR 3, N40 43.962 W75 37.606, 13.372 nm /281.029 deg. Scene - Lehigh County ",
        "ID:23-13-31450",
        "UNIT:PennSTAR 3",
        "ADDR:N40 43.962 W75 37.606, 13.372 nm /281.029 deg.",
        "MADDR:+40.732700,-75.626767",
        "GPS:+40.732700,-75.626767",
        "CALL:Scene - Lehigh County");

    doTest("T64",
        "23-13-31450: PennSTAR 3, N40 43.999 W75 38.613, 14.136 nm /281.243 deg. Scene - Lehigh County ",
        "ID:23-13-31450",
        "UNIT:PennSTAR 3",
        "ADDR:N40 43.999 W75 38.613, 14.136 nm /281.243 deg.",
        "MADDR:+40.733317,-75.643550",
        "GPS:+40.733317,-75.643550",
        "CALL:Scene - Lehigh County");

    doTest("T65",
        "23-13-31449: PennSTAR CCT 1, Mercy Philadelphia, 23-13-31449",
        "ID:23-13-31449",
        "UNIT:PennSTAR CCT 1",
        "CALL:Mercy Philadelphia",
        "CODE:31449");

    doTest("T66",
        "23-13-31448: PennSTAR 5, N40 49.10 W75 54.70, 6.862 nm /286.493 deg. Miners Memorial Hospital PHCOA",
        "ID:23-13-31448",
        "UNIT:PennSTAR 5",
        "ADDR:N40 49.10 W75 54.70, 6.862 nm /286.493 deg.",
        "MADDR:+40.818333,-75.911667",
        "GPS:+40.818333,-75.911667",
        "CALL:Miners Memorial Hospital",
        "CODE:PHCOA");

    doTest("T67",
        "23-13-31448: (STANDBY) PennSTAR 5, N40 49.10 W75 54.70, 6.862 nm /286.493 deg. Miners Memorial Hospital PHCOA",
        "ID:23-13-31448",
        "UNIT:PennSTAR 5",
        "ADDR:N40 49.10 W75 54.70, 6.862 nm /286.493 deg.",
        "MADDR:+40.818333,-75.911667",
        "GPS:+40.818333,-75.911667",
        "CALL:(STANDBY) Miners Memorial Hospital",
        "CODE:PHCOA");

    doTest("T68",
        "23-13-31447: PennSTAR 1, N40 08.50 W75 18.85, 2.192 nm /290.169 deg. Mercy Suburban Hospital PHSGH",
        "ID:23-13-31447",
        "UNIT:PennSTAR 1",
        "ADDR:N40 08.50 W75 18.85, 2.192 nm /290.169 deg.",
        "MADDR:+40.141667,-75.314167",
        "GPS:+40.141667,-75.314167",
        "CALL:Mercy Suburban Hospital",
        "CODE:PHSGH");

    doTest("T69",
        "27-13-4616: 175 lbs",
        "CALL:GENERAL ALERT",
        "ID:27-13-4616",
        "PLACE:175 lbs");

    doTest("T70",
        "27-13-4616: PennSTAR 6, N40 04.00 W74 58.60, 16.187 nm /163.872 deg. Aria Health - Torresdale PHFHT",
        "ID:27-13-4616",
        "UNIT:PennSTAR 6",
        "ADDR:N40 04.00 W74 58.60, 16.187 nm /163.872 deg.",
        "MADDR:+40.066667,-74.976667",
        "GPS:+40.066667,-74.976667",
        "CALL:Aria Health - Torresdale",
        "CODE:PHFHT");

    doTest("T71",
        "23-13-31444: PennSTAR CCT 1, HUP - Hosp of Univ of Penn, 23-13-31444",
        "ID:23-13-31444",
        "UNIT:PennSTAR CCT 1",
        "CALL:HUP - Hosp of Univ of Penn",
        "CODE:31444");

    doTest("T72",
        "23-13-31442: PennSTAR CCT 1, HUP - Hosp of Univ of Penn, 23-13-31442",
        "ID:23-13-31442",
        "UNIT:PennSTAR CCT 1",
        "CALL:HUP - Hosp of Univ of Penn",
        "CODE:31442");

    doTest("T73",
        "23-13-31441: PennSTAR 1, N40 16.052 W75 21.881, 10.987 nm /334.653 deg. Scene - Montgomery County ",
        "ID:23-13-31441",
        "UNIT:PennSTAR 1",
        "ADDR:N40 16.052 W75 21.881, 10.987 nm /334.653 deg.",
        "MADDR:+40.267533,-75.364683",
        "GPS:+40.267533,-75.364683",
        "CALL:Scene - Montgomery County");

    doTest("T74",
        "23-13-31440: PennSTAR 3, N40 03.34 W75 02.36, 43.015 nm /173.689 deg. Nazareth Hospital PHNAZ",
        "ID:23-13-31440",
        "UNIT:PennSTAR 3",
        "ADDR:N40 03.34 W75 02.36, 43.015 nm /173.689 deg.",
        "MADDR:+40.055667,-75.039333",
        "GPS:+40.055667,-75.039333",
        "CALL:Nazareth Hospital",
        "CODE:PHNAZ");

    doTest("T75",
        "23-13-31439: (STANDBY) PennSTAR 1, N39 43.10 W74 16.70, 44.25 nm /119.865 deg. Southern Ocean County Hospital NHSOC",
        "ID:23-13-31439",
        "UNIT:PennSTAR 1",
        "ADDR:N39 43.10 W74 16.70, 44.25 nm /119.865 deg.",
        "MADDR:+39.718333,-74.278333",
        "GPS:+39.718333,-74.278333",
        "CALL:(STANDBY) Southern Ocean County Hospital",
        "CODE:NHSOC");

    doTest("T76",
        "27-13-4615: 67F",
        "CALL:GENERAL ALERT",
        "ID:27-13-4615",
        "PLACE:67F");

    doTest("T77",
        "27-13-4615: PennSTAR 6, N40 00.61 W75 46.73, 34.458 nm /250.658 deg. Brandywine Hospital PHBRD",
        "ID:27-13-4615",
        "UNIT:PennSTAR 6",
        "ADDR:N40 00.61 W75 46.73, 34.458 nm /250.658 deg.",
        "MADDR:+40.010167,-75.778833",
        "GPS:+40.010167,-75.778833",
        "CALL:Brandywine Hospital",
        "CODE:PHBRD");

    doTest("T78",
        "27-13-4615: (STANDBY) PennSTAR 6, N40 00.61 W75 46.73, 34.458 nm /250.658 deg. Brandywine Hospital PHBRD",
        "ID:27-13-4615",
        "UNIT:PennSTAR 6",
        "ADDR:N40 00.61 W75 46.73, 34.458 nm /250.658 deg.",
        "MADDR:+40.010167,-75.778833",
        "GPS:+40.010167,-75.778833",
        "CALL:(STANDBY) Brandywine Hospital",
        "CODE:PHBRD");

    doTest("T79",
        "23-13-31438: PennSTAR 1, N40 04.00 W74 58.60, 14.008 nm /119.362 deg. Aria Health -Torresdale PHFHT",
        "ID:23-13-31438",
        "UNIT:PennSTAR 1",
        "ADDR:N40 04.00 W74 58.60, 14.008 nm /119.362 deg.",
        "MADDR:+40.066667,-74.976667",
        "GPS:+40.066667,-74.976667",
        "CALL:Aria Health -Torresdale",
        "CODE:PHFHT");

    doTest("T80",
        "27-13-4614: PennSTAR 6, N40 18.54 W75 13.01, 2.558 nm /320.523 deg. Scene - Bucks County Grd Cnt: Chief 34 Freq: FGND 1 ",
        "ID:27-13-4614",
        "UNIT:PennSTAR 6",
        "ADDR:N40 18.54 W75 13.01, 2.558 nm /320.523 deg.",
        "MADDR:+40.309000,-75.216833",
        "GPS:+40.309000,-75.216833",
        "CALL:Scene - Bucks County ",
        "INFO:Grd Cnt: Chief 34",
        "CH:FGND 1");

    doTest("T81",
        "27-13-4614: PennSTAR 6, N40 18.54 W75 13.01, 2.558 nm /320.523 deg. Scene - Bucks County Grd Cnt: Deputy 34 ",
        "ID:27-13-4614",
        "UNIT:PennSTAR 6",
        "ADDR:N40 18.54 W75 13.01, 2.558 nm /320.523 deg.",
        "MADDR:+40.309000,-75.216833",
        "GPS:+40.309000,-75.216833",
        "CALL:Scene - Bucks County ",
        "INFO:Grd Cnt: Deputy 34");

    doTest("T82",
        "23-13-31437: PennSTAR 2, N39 18.70 W74 35.50, 8.779 nm /196.394 deg. Shore Memorial Hospital NHSMM",
        "ID:23-13-31437",
        "UNIT:PennSTAR 2",
        "ADDR:N39 18.70 W74 35.50, 8.779 nm /196.394 deg.",
        "MADDR:+39.311667,-74.591667",
        "GPS:+39.311667,-74.591667",
        "CALL:Shore Memorial Hospital",
        "CODE:NHSMM");

    doTest("T83",
        "23-13-31431: PennSTAR 1, N40 06.71 W75 04.55, 6.445 nm /86.949 deg. Holy Redeemer Hospital PHHRH",
        "ID:23-13-31431",
        "UNIT:PennSTAR 1",
        "ADDR:N40 06.71 W75 04.55, 6.445 nm /86.949 deg.",
        "MADDR:+40.111833,-75.075833",
        "GPS:+40.111833,-75.075833",
        "CALL:Holy Redeemer Hospital",
        "CODE:PHHRH");

    doTest("T84",
        "23-13-31431: PennSTAR 1, N40 06.71 W75 04.55, 6.445 nm /86.949 deg. Holy Redeemer Hospital PHHRH",
        "ID:23-13-31431",
        "UNIT:PennSTAR 1",
        "ADDR:N40 06.71 W75 04.55, 6.445 nm /86.949 deg.",
        "MADDR:+40.111833,-75.075833",
        "GPS:+40.111833,-75.075833",
        "CALL:Holy Redeemer Hospital",
        "CODE:PHHRH");

    doTest("T85",
        "23-13-31429: PennSTAR 1, N40 07.12 W75 07.27, 6.797 nm /111.039 deg. Abington Memorial Hospital PHABM",
        "ID:23-13-31429",
        "UNIT:PennSTAR 1",
        "ADDR:N40 07.12 W75 07.27, 6.797 nm /111.039 deg.",
        "MADDR:+40.118667,-75.121167",
        "GPS:+40.118667,-75.121167",
        "CALL:Abington Memorial Hospital",
        "CODE:PHABM");

    doTest("T86",
        "23-13-31428: PennSTAR 2, N38 54.30 W75 25.40, 51.248 nm /242.751 deg. Milford Memorial Hospital DHMMH",
        "ID:23-13-31428",
        "UNIT:PennSTAR 2",
        "ADDR:N38 54.30 W75 25.40, 51.248 nm /242.751 deg.",
        "MADDR:+38.905000,-75.423333",
        "GPS:+38.905000,-75.423333",
        "CALL:Milford Memorial Hospital",
        "CODE:DHMMH");

    doTest("T87",
        "23-13-31428: (STANDBY) PennSTAR 2, N38 54.30 W75 25.40, 51.248 nm /242.751 deg. Milford Memorial Hospital DHMMH",
        "ID:23-13-31428",
        "UNIT:PennSTAR 2",
        "ADDR:N38 54.30 W75 25.40, 51.248 nm /242.751 deg.",
        "MADDR:+38.905000,-75.423333",
        "GPS:+38.905000,-75.423333",
        "CALL:(STANDBY) Milford Memorial Hospital",
        "CODE:DHMMH");

    doTest("T88",
        "23-13-31426: PennSTAR 4, N40 36.50 W75 23.60, 29.847 nm /73.047 deg. SLH - Saint Lukes Hospital PHSLH",
        "ID:23-13-31426",
        "UNIT:PennSTAR 4",
        "ADDR:N40 36.50 W75 23.60, 29.847 nm /73.047 deg.",
        "MADDR:+40.608333,-75.393333",
        "GPS:+40.608333,-75.393333",
        "CALL:SLH - Saint Lukes Hospital",
        "CODE:PHSLH");

    doTest("T89",
        "23-13-31421: PennSTAR 1, N40 08.50 W75 18.85, 2.235 nm /291.156 deg. Mercy Suburban Hospital PHSGH",
        "ID:23-13-31421",
        "UNIT:PennSTAR 1",
        "ADDR:N40 08.50 W75 18.85, 2.235 nm /291.156 deg.",
        "MADDR:+40.141667,-75.314167",
        "GPS:+40.141667,-75.314167",
        "CALL:Mercy Suburban Hospital",
        "CODE:PHSGH");

    doTest("T90",
        "23-13-31421: PennSTAR 1, N40 08.50 W75 18.85, 2.235 nm /291.156 deg. Mercy Suburban Hospital PHSGH",
        "ID:23-13-31421",
        "UNIT:PennSTAR 1",
        "ADDR:N40 08.50 W75 18.85, 2.235 nm /291.156 deg.",
        "MADDR:+40.141667,-75.314167",
        "GPS:+40.141667,-75.314167",
        "CALL:Mercy Suburban Hospital",
        "CODE:PHSGH");

    doTest("T91",
        "27-13-4613: PennSTAR 6, OUTGOING, N40 00.10 W75 08.60, 18.168 nm /192.072 deg. Temple Univ Hospital - Level 1 PHTUH",
        "ID:27-13-4613",
        "UNIT:PennSTAR 6",
        "ADDR:N40 00.10 W75 08.60, 18.168 nm /192.072 deg.",
        "MADDR:+40.001667,-75.143333",
        "GPS:+40.001667,-75.143333",
        "CALL:OUTGOING - Temple Univ Hospital - Level 1",
        "CODE:PHTUH");

    doTest("T92",
        "23-13-31418: 46F Seizures no drip no vent ICU->NEURO ICU 55kg 106/60 99%RA 19 70",
        "CALL:GENERAL ALERT",
        "ID:23-13-31418",
        "PLACE:46F Seizures no drip no vent ICU->NEURO ICU 55kg 106/60 99%RA 19 70");

    doTest("T93",
        "23-13-31418: PennSTAR CCT 1, Holy Redeemer Hospital, 23-13-31418",
        "ID:23-13-31418",
        "UNIT:PennSTAR CCT 1",
        "CALL:Holy Redeemer Hospital",
        "CODE:31418");

    doTest("T94",
        "23-13-31416: PennSTAR 4, N40 07.40 W75 30.95, 25.385 nm /137.514 deg. Phoenixville Hospital PHPVH",
        "ID:23-13-31416",
        "UNIT:PennSTAR 4",
        "ADDR:N40 07.40 W75 30.95, 25.385 nm /137.514 deg.",
        "MADDR:+40.123333,-75.515833",
        "GPS:+40.123333,-75.515833",
        "CALL:Phoenixville Hospital",
        "CODE:PHPVH");

    doTest("T95",
        "23-13-31416: (STANDBY) PennSTAR 4, N40 07.40 W75 30.95, 25.385 nm /137.514 deg. Phoenixville Hospital PHPVH",
        "ID:23-13-31416",
        "UNIT:PennSTAR 4",
        "ADDR:N40 07.40 W75 30.95, 25.385 nm /137.514 deg.",
        "MADDR:+40.123333,-75.515833",
        "GPS:+40.123333,-75.515833",
        "CALL:(STANDBY) Phoenixville Hospital",
        "CODE:PHPVH");

    doTest("T96",
        "23-13-31416: (STANDBY) PennSTAR 4, N40 07.40 W75 30.95, 25.385 nm /137.514 deg. Phoenixville Hospital PHPVH",
        "ID:23-13-31416",
        "UNIT:PennSTAR 4",
        "ADDR:N40 07.40 W75 30.95, 25.385 nm /137.514 deg.",
        "MADDR:+40.123333,-75.515833",
        "GPS:+40.123333,-75.515833",
        "CALL:(STANDBY) Phoenixville Hospital",
        "CODE:PHPVH");

    doTest("T97",
        "23-13-31415: PennSTAR CCT 1, HUP - Hosp of Univ of Penn, 23-13-31415",
        "ID:23-13-31415",
        "UNIT:PennSTAR CCT 1",
        "CALL:HUP - Hosp of Univ of Penn",
        "CODE:31415");

    doTest("T98",
        "23-13-31414: PennSTAR 5, N40 49.10 W75 54.70, 6.862 nm /286.493 deg. Miners Memorial Hospital PHCOA",
        "ID:23-13-31414",
        "UNIT:PennSTAR 5",
        "ADDR:N40 49.10 W75 54.70, 6.862 nm /286.493 deg.",
        "MADDR:+40.818333,-75.911667",
        "GPS:+40.818333,-75.911667",
        "CALL:Miners Memorial Hospital",
        "CODE:PHCOA");

    doTest("T99",
        "23-13-31412: PennSTAR 2, N40 29.60 W74 26.70, 62.394 nm /17.543 deg. St Peters Medical Center NHSPM",
        "ID:23-13-31412",
        "UNIT:PennSTAR 2",
        "ADDR:N40 29.60 W74 26.70, 62.394 nm /17.543 deg.",
        "MADDR:+40.493333,-74.445000",
        "GPS:+40.493333,-74.445000",
        "CALL:St Peters Medical Center",
        "CODE:NHSPM");

    doTest("T100",
        "23-13-31409: (STANDBY) PennSTAR CCT 1, PPMC - Penn Presbyterian MC, 23-13-31409",
        "ID:23-13-31409",
        "UNIT:PennSTAR CCT 1",
        "CALL:(STANDBY) PPMC - Penn Presbyterian MC",
        "CODE:31409");
  }
  
  public static void main(String[] args) {
    new PAPennStarParserTest().generateTests("T1");
  }
  
}
