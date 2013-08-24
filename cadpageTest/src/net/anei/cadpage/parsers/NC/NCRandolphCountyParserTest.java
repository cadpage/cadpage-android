package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Randolph County, NC
Contact: Frank Crotts <Crottsf@guil-randfire.com>

Randolph 911 - GRFD\nBREATHING\n5064 CROTTS DR\nSTA40\nSTA40\n10-15 JAMES KIRKMAN...BREATHING DIFF...TIGHTNESS IN CHEST...HANDS TINGLING...HEART RATE IS 45\n16:34:30 08/21/2011 - WATSON,A D\nProQA Medical Case Entry Finished\n16:35:13 08/2
Randolph 911 - GRFD\nABDOMINAL PAIN\n6242 CEDAR LN\nSTA41\nSTA41\n10-15 HOWARD PEELE..68 YO..SICKNESS AND TREMBLING...TESTICLE PAIN..ABDOMINAL\nPAIN..CONFUSED...26 D 1\n10:26:05 08/22/2011 - MCCORQUODALE, C\nPROQA WOULD NOT LAUNCH
Randolph 911 - GRFD\nFALL\n8374 HARLOW RD;UNIT 10\nSTA41\nSTA41\nCHILTON MHP...CAILY SKEEN...87 Y/O FEMALE...KEY BEHIND THE ELECTRICAL AT THE TELEPHONE POLE INSIDE THE BLK BOX AND THE KEY IS FOR A DEAD BOLT...ABLE TO VOICE CONTACT UNK INJ
Randolph 911 - GRFD\nHEMORRHAGE\n203 GREEN OAK DR; SUITE A\nSTA20\nSTA20\nREF ASSISTING GUILFORD COUNTY\n00:14:45 08/23/2011 - NELSON,A W\nProQA Medical Case 1258044 Aborted: ASSISTING GUILFORD COUNTY
Randolph 911 - GRFD\nABDOMINAL PAIN\n119 BARWOOD TER\nSTA20\nSTA20\n47YOF.. 1C4.. NEAR FAINTING.. ABOVE THE NAVEL.. \n12:44:15 08/20/2011 - WALTER,D S\nProQA Medical Case Entry Finished\n12:44:48 08/20/2011 - KING,J C\nARCHDALE RD ONTO DON

Contact: "Franklinville Fire" <franklinvillefd@triadbiz.rr.com>
Contact: Brandon Hurley<bhurley002@triad.rr.com>
Sender: RandolphWirelessOffice@co.randolph.nc.us

Randolph 911 - FRFD\nBREATHING\n7363 FERGUSON RD\nSTA08\nSTA08\nLOT 15...CPN 301-4908...10-15 40 YOA FM COPD\n15:42:31 09/20/2011 - WATSON,A D\nProQA Medical Recommended Dispatch Level = 06D02\n15:42:41 09/20/2011 - WATSON,A D\nProQA Medica
Randolph 911 - FRFD\nACCIDENT/PD\nUS HWY 64 E & FOXFIRE RD\nSTA08\nSTA08\nREF TO TRAFFIC CONTROL AT 10-50 PD AUTH OF 8B
Randolph 911 - FRFD\nUNCONSCIOUS\n125 MEADOW RD\nSTA08\nSTA08\n38 YOF UNCONSCIOUS\n14:01:59 09/20/2011 - FIELDS,K F\nProQA Medical Case Entry Finished\n14:02:25 09/20/2011 - FIELDS,K F\nProQA Medical Recommended Dispatch Level = 31D02
Randolph 911 - FRFD\nBACK PAIN\n3453 NC HWY 22 N\nSTA08\nSTA08\n10-15 TROY BULLINS 40YOM...C/O SEVERE BACK PAIN WITH DIFF BREATHING...REQ NO\nSIRENS...REQ TX TO CHATHAM\n19:50:01 09/19/2011 - RICHARDSON,A L\nProQA Medical Case Entry Finishe
Randolph 911 - FRFD\nFIRE (WOODS)\n840 BRADY ST EXT\nSTA08\nSTA08\nACROSS THE STREET FROM THIS ADDRESS, 10-70 WOODS BEHIND A BRICK RES\nCALLER LARRY BALDWIN 302-6467\nCALLBACK=??(336)430-5623 LAT=+035.755273 LON=-079.651050 UNC=00025\n

Contact: Active911
Agency name: Seagrove Fire Dept
Location: Seagrove, NC, United States

Randolph 911 - SEFD\nSTA06\n130001078\nASSGN- 14.27.09 01/24/13\nATAC2- 14.27.14\nENRT - 14.29.15\nARRVD- 14.36.23\nS50  - 14.38.16\nRETRN- 15.04.25\nCMPLT- 15.14.45
Randolph 911 - SEFD\nFIRE (ELEC INV)\n5015 NEW HOPE CHURCH RD\nSTA06\nSTA06\nSMOKE COME ELECTRICAL PANEL IN THE RESIDENCE..
Randolph 911 - SEFD\nSTA06\n130001042\nASSGN- 20.50.47 01/23/13\nATAC2- 20.50.52\nENRT - 20.53.02\nARRVD- 20.56.19\nRETRN- 21.14.27\nCMPLT- 21.20.07
Randolph 911 - SEFD\nHEMORRHAGE\n492 BURNEY RD\nSTA06\nSTA06\n20:49:25 01/23/2013 - NELSON,A W\nProQA Medical Case Entry Finished\n20:50:13 01/23/2013 - NELSON,A W\nProQA Medical Recommended Dispatch Level = 21B02
Randolph 911 - SEFD\nSTA06\n130001008\nASSGN- 06.36.33 01/23/13\nATAC1- 06.36.53\nATAC2- 06.37.41\nENRT - 06.38.44\n14   - 06.41.26\nARRVD- 06.43.34\nRETRN- 07.05.55\nCMPLT- 07.10.23
Randolph 911 - SEFD\nSICKNESS\n184 BOONE ST\nSTA06\nSTA06\n10-15 79 YR OLD FEM NOT ALERT HAS GOUT IN FOOT\n06:35:17 01/23/2013 - STORY,K R\nProQA Medical Case Entry Finished\n06:35:24 01/23/2013 - STORY,K R\nProQA Medical Recommended Dispat
Randolph 911 - SEFD\nSTA06\n130000980\nASSGN- 10.19.51 01/22/13\nENRT - 10.20.38\nARRVD- 10.25.25\nS50  - 10.31.56\nRETRN- 10.48.42\nCMPLT- 10.53.24
Randolph 911 - SEFD\nSTROKE\n1436 CAGLE LOOP RD\nSTA06\nSTA06\nGLORIA RADON...66 YOF...CANCER PATIENT RELEASED FROM HOSPITAL YESTERDAY...\n10:18:24 01/22/2013 - MORRIS,D C\nProQA Medical Case Entry Finished\n10:18:31 01/22/2013 - MORRIS,D C
Randolph 911 - SEFD\nSTA06\n130000943\nASSGN- 13.32.56 01/21/13\nATAC2- 13.32.59\nENRT - 13.33.31\nARRVD- 13.41.40\nS50  - 13.51.02\nRETRN- 14.01.47\nCMPLT- 14.11.01
Randolph 911 - SEFD\nCHEST PAIN\n2645 BETHEL LUCAS RD\nSTA06\nSTA06\n52YO FEMALE...CONS/BREATHING...CHEST PAIN, TROUBLE BREATHING \n13:30:13 01/21/2013 - JONES,D M\nProQA Medical Case Entry Finished\n13:30:26 01/21/2013 - JONES,D M\nProQA M
Randolph 911 - SEFD\nSTA06\n130000866\nASSGN- 18.53.43 01/19/13\nENRT - 18.55.47\n14   - 18.56.08\nARRVD- 18.58.53\nRETRN- 19.25.06\nCMPLT- 19.28.24
Randolph 911 - SEFD\nFALL\n296 WESTWOOD DR\nSTA06\nSTA06\n10-15 CONIE MCNEILL/ FALL WITH HEAD INJURY/ ENTER AT CARPORT SIDE OF RESIDENCE /\nCPN 910-220-5969\n18:51:07 01/19/2013 - KING,J C\nProQA Medical Recommended Dispatch Level = 17B01
Randolph 911 - SEFD\nSTA06\n130000777\nASSGN- 23.01.00 01/17/13\nENRT - 23.01.26\nBTAC4- 23.01.48\nARRVD- 23.09.08\nRETRN- 23.31.13\nCMPLT- 23.34.04
Randolph 911 - SEFD\nBREATHING\n9245 US HWY 220 S\nSTA06\nSTA06\n10-15 16 YOF ASHTMA ATTACK ADV CANNOT FIND INHALER\n22:59:56 01/17/2013 - HOGAN,A J\nProQA Medical Recommended Dispatch Level = 06D02\n23:00:07 01/17/2013 - HOGAN,A J\nProQA M
Randolph 911 - SEFD\nSTA06\n130000615\nASSGN- 19.29.32 01/15/13\nATAC1- 19.29.39\nENRT - 19.30.36\nARRVD- 19.40.46\nS50  - 19.45.32\nRETRN- 19.55.41\nCMPLT- 20.02.42
Randolph 911 - SEFD\nSICKNESS\n4937 REEDER RD\nSTA06\nSTA06\n10-15 JOHNNY MILLS 61 YOM CON/ALERT...GEN WEAKNESS...UNABLE TO\nWALK...CPN#4654507...CALLER TERRY KING\n19:29:32 01/15/2013 - NELSON,A W\nProQA Medical Recommended Dispatch Level
Randolph 911 - SEFD\nSTA06\n130000595\nASSGN- 11.04.56 01/15/13\nENRT - 11.05.41\nARRVD- 11.10.47\nS50  - 11.15.58\nRETRN- 11.39.15\nCMPLT- 11.46.57
Randolph 911 - SEFD\nSICKNESS\n4980 RIDGE RD\nSTA06\nSTA06\n71 YOF...FEMALE IS CANCER PATIENT...HAD TREATMENT YESTERDAY...C/O GEN WEAKNESS\nAND DIARRHEA\n11:02:28 01/15/2013 - POE,J L\nProQA Medical Recommended Dispatch Level = 26A10\n11:02
Randolph 911 - SEFD\nSTA06\n130000566\nASSGN- 17.03.21 01/14/13\nENRT - 17.03.27\nARRVD- 17.05.04\nRETRN- 17.10.37\nCMPLT- 17.14.35
Randolph 911 - SEFD\nSERVICE CALL\n542 BURNEY RD\nSTA06\nSTA06
Randolph 911 - SEFD\nSTA06\n130000554\nASSGN- 13.54.51 01/14/13\nBTAC1- 13.55.01\nENRT - 13.55.29\nARRVD- 13.59.32\nRETRN- 14.18.19\nCMPLT- 14.23.35
Randolph 911 - SEFD\nBREATHING\n4881 REEDER RD\nSTA06\nSTA06\n68 YOA FEMALE..CON ALERT...DIFF BREATHING \n\n13:53:17 01/14/2013 - BAILEY,J B\nProQA Medical Recommended Dispatch Level = 06D02\n13:53:58 01/14/2013 - BAILEY,J B\nProQA Medical
Randolph 911 - SEFD\nSTA06\n130000553\nASSGN- 12.59.21 01/14/13\nATAC3- 12.59.27\nENRT - 12.59.45\nSTDBY- 13.03.54\nARRVD- 13.10.47\nS50  - 13.14.48\nRETRN- 13.22.54\nCMPLT- 13.26.33
Randolph 911 - SEFD\nHEMORRHAGE\n381 OAK VIEW LN\nSTA06\nSTA06\n10-15 LEVI PINNIX...16YOM...SLIT HIS WRIST...\n12:57:03 01/14/2013 - HALLIDAY,A M\nProQA Medical Case Entry Finished\n12:58:07 01/14/2013 - HALLIDAY,A M\nProQA Medical Recommen
Randolph 911 - SEFD\nSTA06\n130000490\nASSGN- 21.09.54 01/12/13\nENRT - 21.10.01\nARRVD- 21.17.58\nS50  - 21.32.48\nRETRN- 21.33.15\nCMPLT- 21.41.44
Randolph 911 - SEFD\nLOCKOUT\nBACHELOR CREEK RD\nSTA06\nSTA06\nSTA06 ADV LOCKOUT
Randolph 911 - SEFD\nSTA06\n130000472\nASSGN- 15.30.57 01/12/13\nENRT - 15.31.12\nATAC1- 15.31.18\nARRVD- 15.37.46\nS50  - 15.44.29\nRETRN- 16.00.23\nCMPLT- 16.11.25
Randolph 911 - SEFD\nFALL\n6687 NC HWY 134\nSTA06\nSTA06\n10-15 1 YO FELL ONTO THE CONCRETE..HEAD INJURY...HEMATOMA TO THE HEAD...BLEEDING\nFROM THE LIP AND NOSE SLIGHTLY...CHILD IS UPSET AND WANTING TO SLEEP HOWEVER HAS\nNOT HAD A NAP\n15:
Randolph 911 - SEFD\nSTA06\n130000388\nASSGN- 23.29.09 01/09/13\nATAC2- 23.29.12\nENRT - 23.33.10\nARRVD- 23.38.59\nRETRN- 23.55.54\nCMPLT- 00.14.10
Randolph 911 - SEFD\nSTB06\n130000389\nASSGN- 23.44.04 01/09/13\nATAC2- 23.44.42\nENRT - 23.48.10\nARRVD- 23.57.49\nS50  - 23.57.58\nRETRN- 00.02.25\nCMPLT- 00.14.07
Randolph 911 - SEFD\nBREATHING\n2330 WHITE PINES LN\nSTA06\nSTB06\n71M, DIFF BRTH, REQ 10-16 PRIOR TO 10-23\n23:43:15 01/09/2013 - WRIGHT,J R\nProQA Medical Recommended Dispatch Level = 06C01
Randolph 911 - SEFD\nSTROKE\n310 OLD PLANK RD\nSTA06\nSTA06\n10-15 LOUSILLE THOMPSON...70 YOF....3RD PARTY CALLER STATES HIS FATHER CALLED\nAND SAID HIS MOTHER COULD NOT WALK AND NEEDED AN AMBULANCE...NO FURTHER\n10-14...CALLER IS 10 MINS A
Randolph 911 - SEFD\nUNKNOWN MEDICAL\n310 OLD PLANK RD\nSTA06\nSTA06\n10-15 LOUSILLE THOMPSON...70 YOF....\n23:29:26 01/09/2013 - HALLIDAY,A M\nProQA Medical Recommended Dispatch Level = 32B03\n23:29:33 01/09/2013 - HALLIDAY,A M\nProQA Medi
Randolph 911 - SEFD\nSTROKE\n310 OLD PLANK RD\nSTA06\nSTA06\n10-15 LOUSILLE THOMPSON...70 YOF....
Randolph 911 - SEFD\nSTA06\n130000378\nASSGN- 20.09.23 01/09/13\nATAC2- 20.09.26\nENRT - 20.10.35\n32   - 20.13.05\nARRVD- 20.15.09\nS50  - 20.19.37\nRETRN- 20.32.15\nCMPLT- 20.36.13
Randolph 911 - SEFD\nUNCONSCIOUS\n727 OLD PLANK RD\nSTA06\nSTA06\n10-15 IS CLARA HOOVER...80 YO FEMALE...FAINTING EPISODES X2...NAUSEA AND\nVOMITING...\n20:06:36 01/09/2013 - MORRIS,D C\nProQA Medical Case Entry Finished\n20:07:59 01/09/201
Randolph 911 - SEFD\nSTA06\n130000373\nASSGN- 19.06.25 01/09/13\nENRT - 19.07.57\n32   - 19.09.43\nARRVD- 19.14.23\nATAC2- 19.18.18\nRETRN- 19.27.58\nCMPLT- 19.39.40
Randolph 911 - SEFD\nACCIDENT/PI\n5045 RIDGE RD\nSTA06\nSTA06\n1 VEH, UNK PI,  POSSIBLE 10-55
Randolph 911 - SEFD\nSTA06\n130000320\nASSGN- 14.53.27 01/08/13\nENRT - 14.53.31\nATAC3- 14.53.33\nARRVD- 14.55.57\nS50  - 15.02.55\nRETRN- 15.37.58\nCMPLT- 15.40.21
Randolph 911 - SEFD\nFIRE (OTHER)\n6966 US HWY 220 S\nSTA06\nSTA06

*/

public class NCRandolphCountyParserTest extends BaseParserTest {
  
  public NCRandolphCountyParserTest() {
    setParser(new NCRandolphCountyParser(), "RANDOLPH COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Randolph 911 - GRFD\nBREATHING\n5064 CROTTS DR\nSTA40\nSTA40\n10-15 JAMES KIRKMAN...BREATHING DIFF...TIGHTNESS IN CHEST...HANDS TINGLING...HEART RATE IS 45\n16:34:30 08/21/2011 - WATSON,A D\nProQA Medical Case Entry Finished\n16:35:13 08/2",
        "SRC:GRFD",
        "CALL:BREATHING",
        "ADDR:5064 CROTTS DR",
        "UNIT:STA40",
        "INFO:10-15 JAMES KIRKMAN...BREATHING DIFF...TIGHTNESS IN CHEST...HANDS TINGLING...HEART RATE IS 45");

    doTest("T2",
        "Randolph 911 - GRFD\nABDOMINAL PAIN\n6242 CEDAR LN\nSTA41\nSTA41\n10-15 HOWARD PEELE..68 YO..SICKNESS AND TREMBLING...TESTICLE PAIN..ABDOMINAL\nPAIN..CONFUSED...26 D 1\n10:26:05 08/22/2011 - MCCORQUODALE, C\nPROQA WOULD NOT LAUNCH",
        "SRC:GRFD",
        "CALL:ABDOMINAL PAIN",
        "ADDR:6242 CEDAR LN",
        "UNIT:STA41",
        "INFO:10-15 HOWARD PEELE..68 YO..SICKNESS AND TREMBLING...TESTICLE PAIN..ABDOMINAL / PAIN..CONFUSED...26 D 1");

    doTest("T3",
        "Randolph 911 - GRFD\nFALL\n8374 HARLOW RD;UNIT 10\nSTA41\nSTA41\nCHILTON MHP...CAILY SKEEN...87 Y/O FEMALE...KEY BEHIND THE ELECTRICAL AT THE TELEPHONE POLE INSIDE THE BLK BOX AND THE KEY IS FOR A DEAD BOLT...ABLE TO VOICE CONTACT UNK INJ",
        "SRC:GRFD",
        "CALL:FALL",
        "ADDR:8374 HARLOW RD",
        "APT:UNIT 10",
        "UNIT:STA41",
        "INFO:CHILTON MHP...CAILY SKEEN...87 Y/O FEMALE...KEY BEHIND THE ELECTRICAL AT THE TELEPHONE POLE INSIDE THE BLK BOX AND THE KEY IS FOR A DEAD BOLT...ABLE TO VOICE CONTACT UNK INJ");

    doTest("T4",
        "Randolph 911 - GRFD\nHEMORRHAGE\n203 GREEN OAK DR; SUITE A\nSTA20\nSTA20\nREF ASSISTING GUILFORD COUNTY\n00:14:45 08/23/2011 - NELSON,A W\nProQA Medical Case 1258044 Aborted: ASSISTING GUILFORD COUNTY",
        "SRC:GRFD",
        "CALL:HEMORRHAGE",
        "ADDR:203 GREEN OAK DR",
        "APT:SUITE A",
        "UNIT:STA20",
        "INFO:REF ASSISTING GUILFORD COUNTY");

    doTest("T5",
        "Randolph 911 - GRFD\nABDOMINAL PAIN\n119 BARWOOD TER\nSTA20\nSTA20\n47YOF.. 1C4.. NEAR FAINTING.. ABOVE THE NAVEL.. \n12:44:15 08/20/2011 - WALTER,D S\nProQA Medical Case Entry Finished\n12:44:48 08/20/2011 - KING,J C\nARCHDALE RD ONTO DON",
        "SRC:GRFD",
        "CALL:ABDOMINAL PAIN",
        "ADDR:119 BARWOOD TER",
        "UNIT:STA20",
        "INFO:47YOF.. 1C4.. NEAR FAINTING.. ABOVE THE NAVEL.. / ARCHDALE RD ONTO DON");
 }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "Randolph 911 - FRFD\nBREATHING\n7363 FERGUSON RD\nSTA08\nSTA08\nLOT 15...CPN 301-4908...10-15 40 YOA FM COPD\n15:42:31 09/20/2011 - WATSON,A D\nProQA Medical Recommended Dispatch Level = 06D02\n15:42:41 09/20/2011 - WATSON,A D\nProQA Medica",
        "SRC:FRFD",
        "CALL:BREATHING",
        "ADDR:7363 FERGUSON RD",
        "UNIT:STA08",
        "INFO:LOT 15...CPN 301-4908...10-15 40 YOA FM COPD");

    doTest("T2",
        "Randolph 911 - FRFD\nACCIDENT/PD\nUS HWY 64 E & FOXFIRE RD\nSTA08\nSTA08\nREF TO TRAFFIC CONTROL AT 10-50 PD AUTH OF 8B",
        "SRC:FRFD",
        "CALL:ACCIDENT/PD",
        "ADDR:US HWY 64 E & FOXFIRE RD",
        "MADDR:US 64 E & FOXFIRE RD",
        "UNIT:STA08",
        "INFO:REF TO TRAFFIC CONTROL AT 10-50 PD AUTH OF 8B");

    doTest("T3",
        "Randolph 911 - FRFD\nUNCONSCIOUS\n125 MEADOW RD\nSTA08\nSTA08\n38 YOF UNCONSCIOUS\n14:01:59 09/20/2011 - FIELDS,K F\nProQA Medical Case Entry Finished\n14:02:25 09/20/2011 - FIELDS,K F\nProQA Medical Recommended Dispatch Level = 31D02",
        "SRC:FRFD",
        "CALL:UNCONSCIOUS",
        "ADDR:125 MEADOW RD",
        "UNIT:STA08",
        "INFO:38 YOF UNCONSCIOUS");

    doTest("T4",
        "Randolph 911 - FRFD\nBACK PAIN\n3453 NC HWY 22 N\nSTA08\nSTA08\n10-15 TROY BULLINS 40YOM...C/O SEVERE BACK PAIN WITH DIFF BREATHING...REQ NO\nSIRENS...REQ TX TO CHATHAM\n19:50:01 09/19/2011 - RICHARDSON,A L\nProQA Medical Case Entry Finishe",
        "SRC:FRFD",
        "CALL:BACK PAIN",
        "ADDR:3453 NC HWY 22 N",
        "MADDR:3453 STATE 22 N",
        "UNIT:STA08",
        "INFO:10-15 TROY BULLINS 40YOM...C/O SEVERE BACK PAIN WITH DIFF BREATHING...REQ NO / SIRENS...REQ TX TO CHATHAM");

    doTest("T5",
        "Randolph 911 - FRFD\nFIRE (WOODS)\n840 BRADY ST EXT\nSTA08\nSTA08\nACROSS THE STREET FROM THIS ADDRESS, 10-70 WOODS BEHIND A BRICK RES\nCALLER LARRY BALDWIN 302-6467\nCALLBACK=??(336)430-5623 LAT=+035.755273 LON=-079.651050 UNC=00025\n",
        "SRC:FRFD",
        "CALL:FIRE (WOODS)",
        "ADDR:840 BRADY ST EXT",
        "UNIT:STA08",
        "INFO:ACROSS THE STREET FROM THIS ADDRESS, 10-70 WOODS BEHIND A BRICK RES / CALLER LARRY BALDWIN 302-6467 / CALLBACK=??(336)430-5623 LAT=+035.755273 LON=-079.651050 UNC=00025");
    
  }
  
  @Test
  public void testSeagroveFire() {

    doTest("T1",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130001078\n" +
        "ASSGN- 14.27.09 01/24/13\n" +
        "ATAC2- 14.27.14\n" +
        "ENRT - 14.29.15\n" +
        "ARRVD- 14.36.23\n" +
        "S50  - 14.38.16\n" +
        "RETRN- 15.04.25\n" +
        "CMPLT- 15.14.45",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130001078",
        "PLACE:ASSGN- 14.27.09 01/24/13\nATAC2- 14.27.14\nENRT - 14.29.15\nARRVD- 14.36.23\nS50  - 14.38.16\nRETRN- 15.04.25\nCMPLT- 15.14.45",
        "CALL:RUN REPORT");

    doTest("T2",
        "Randolph 911 - SEFD\nFIRE (ELEC INV)\n5015 NEW HOPE CHURCH RD\nSTA06\nSTA06\nSMOKE COME ELECTRICAL PANEL IN THE RESIDENCE..",
        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:FIRE (ELEC INV)",
        "ADDR:5015 NEW HOPE CHURCH RD",
        "INFO:SMOKE COME ELECTRICAL PANEL IN THE RESIDENCE..");

    doTest("T3",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130001042\n" +
        "ASSGN- 20.50.47 01/23/13\n" +
        "ATAC2- 20.50.52\n" +
        "ENRT - 20.53.02\n" +
        "ARRVD- 20.56.19\n" +
        "RETRN- 21.14.27\n" +
        "CMPLT- 21.20.07",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130001042",
        "PLACE:ASSGN- 20.50.47 01/23/13\nATAC2- 20.50.52\nENRT - 20.53.02\nARRVD- 20.56.19\nRETRN- 21.14.27\nCMPLT- 21.20.07",
        "CALL:RUN REPORT");

    doTest("T4",
        "Randolph 911 - SEFD\n" +
        "HEMORRHAGE\n" +
        "492 BURNEY RD\n" +
        "STA06\n" +
        "STA06\n" +
        "20:49:25 01/23/2013 - NELSON,A W\n" +
        "ProQA Medical Case Entry Finished\n" +
        "20:50:13 01/23/2013 - NELSON,A W\n" +
        "ProQA Medical Recommended Dispatch Level = 21B02",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:HEMORRHAGE",
        "ADDR:492 BURNEY RD");

    doTest("T5",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130001008\n" +
        "ASSGN- 06.36.33 01/23/13\n" +
        "ATAC1- 06.36.53\n" +
        "ATAC2- 06.37.41\n" +
        "ENRT - 06.38.44\n" +
        "14   - 06.41.26\n" +
        "ARRVD- 06.43.34\n" +
        "RETRN- 07.05.55\n" +
        "CMPLT- 07.10.23",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130001008",
        "PLACE:ASSGN- 06.36.33 01/23/13\nATAC1- 06.36.53\nATAC2- 06.37.41\nENRT - 06.38.44\n14   - 06.41.26\nARRVD- 06.43.34\nRETRN- 07.05.55\nCMPLT- 07.10.23",
        "CALL:RUN REPORT");

    doTest("T6",
        "Randolph 911 - SEFD\n" +
        "SICKNESS\n" +
        "184 BOONE ST\n" +
        "STA06\n" +
        "STA06\n" +
        "10-15 79 YR OLD FEM NOT ALERT HAS GOUT IN FOOT\n" +
        "06:35:17 01/23/2013 - STORY,K R\n" +
        "ProQA Medical Case Entry Finished\n" +
        "06:35:24 01/23/2013 - STORY,K R\n" +
        "ProQA Medical Recommended Dispat",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:SICKNESS",
        "ADDR:184 BOONE ST",
        "INFO:10-15 79 YR OLD FEM NOT ALERT HAS GOUT IN FOOT");

    doTest("T7",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130000980\n" +
        "ASSGN- 10.19.51 01/22/13\n" +
        "ENRT - 10.20.38\n" +
        "ARRVD- 10.25.25\n" +
        "S50  - 10.31.56\n" +
        "RETRN- 10.48.42\n" +
        "CMPLT- 10.53.24",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000980",
        "PLACE:ASSGN- 10.19.51 01/22/13\nENRT - 10.20.38\nARRVD- 10.25.25\nS50  - 10.31.56\nRETRN- 10.48.42\nCMPLT- 10.53.24",
        "CALL:RUN REPORT");

    doTest("T8",
        "Randolph 911 - SEFD\n" +
        "STROKE\n" +
        "1436 CAGLE LOOP RD\n" +
        "STA06\n" +
        "STA06\n" +
        "GLORIA RADON...66 YOF...CANCER PATIENT RELEASED FROM HOSPITAL YESTERDAY...\n" +
        "10:18:24 01/22/2013 - MORRIS,D C\n" +
        "ProQA Medical Case Entry Finished\n" +
        "10:18:31 01/22/2013 - MORRIS,D C",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:STROKE",
        "ADDR:1436 CAGLE LOOP RD",
        "INFO:GLORIA RADON...66 YOF...CANCER PATIENT RELEASED FROM HOSPITAL YESTERDAY...");

    doTest("T9",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130000943\n" +
        "ASSGN- 13.32.56 01/21/13\n" +
        "ATAC2- 13.32.59\n" +
        "ENRT - 13.33.31\n" +
        "ARRVD- 13.41.40\n" +
        "S50  - 13.51.02\n" +
        "RETRN- 14.01.47\n" +
        "CMPLT- 14.11.01",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000943",
        "PLACE:ASSGN- 13.32.56 01/21/13\nATAC2- 13.32.59\nENRT - 13.33.31\nARRVD- 13.41.40\nS50  - 13.51.02\nRETRN- 14.01.47\nCMPLT- 14.11.01",
        "CALL:RUN REPORT");

    doTest("T10",
        "Randolph 911 - SEFD\n" +
        "CHEST PAIN\n" +
        "2645 BETHEL LUCAS RD\n" +
        "STA06\n" +
        "STA06\n" +
        "52YO FEMALE...CONS/BREATHING...CHEST PAIN, TROUBLE BREATHING \n" +
        "13:30:13 01/21/2013 - JONES,D M\n" +
        "ProQA Medical Case Entry Finished\n" +
        "13:30:26 01/21/2013 - JONES,D M\n" +
        "ProQA M",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:CHEST PAIN",
        "ADDR:2645 BETHEL LUCAS RD",
        "INFO:52YO FEMALE...CONS/BREATHING...CHEST PAIN, TROUBLE BREATHING");

    doTest("T11",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130000866\n" +
        "ASSGN- 18.53.43 01/19/13\n" +
        "ENRT - 18.55.47\n" +
        "14   - 18.56.08\n" +
        "ARRVD- 18.58.53\n" +
        "RETRN- 19.25.06\n" +
        "CMPLT- 19.28.24",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000866",
        "PLACE:ASSGN- 18.53.43 01/19/13\nENRT - 18.55.47\n14   - 18.56.08\nARRVD- 18.58.53\nRETRN- 19.25.06\nCMPLT- 19.28.24",
        "CALL:RUN REPORT");

    doTest("T12",
        "Randolph 911 - SEFD\n" +
        "FALL\n" +
        "296 WESTWOOD DR\n" +
        "STA06\n" +
        "STA06\n" +
        "10-15 CONIE MCNEILL/ FALL WITH HEAD INJURY/ ENTER AT CARPORT SIDE OF RESIDENCE /\n" +
        "CPN 910-220-5969\n" +
        "18:51:07 01/19/2013 - KING,J C\n" +
        "ProQA Medical Recommended Dispatch Level = 17B01",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:FALL",
        "ADDR:296 WESTWOOD DR",
        "INFO:10-15 CONIE MCNEILL/ FALL WITH HEAD INJURY/ ENTER AT CARPORT SIDE OF RESIDENCE / / CPN 910-220-5969");

    doTest("T13",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130000777\n" +
        "ASSGN- 23.01.00 01/17/13\n" +
        "ENRT - 23.01.26\n" +
        "BTAC4- 23.01.48\n" +
        "ARRVD- 23.09.08\n" +
        "RETRN- 23.31.13\n" +
        "CMPLT- 23.34.04",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000777",
        "PLACE:ASSGN- 23.01.00 01/17/13\nENRT - 23.01.26\nBTAC4- 23.01.48\nARRVD- 23.09.08\nRETRN- 23.31.13\nCMPLT- 23.34.04",
        "CALL:RUN REPORT");

    doTest("T14",
        "Randolph 911 - SEFD\n" +
        "BREATHING\n" +
        "9245 US HWY 220 S\n" +
        "STA06\n" +
        "STA06\n" +
        "10-15 16 YOF ASHTMA ATTACK ADV CANNOT FIND INHALER\n" +
        "22:59:56 01/17/2013 - HOGAN,A J\n" +
        "ProQA Medical Recommended Dispatch Level = 06D02\n" +
        "23:00:07 01/17/2013 - HOGAN,A J\n" +
        "ProQA M",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:BREATHING",
        "ADDR:9245 US HWY 220 S",
        "MADDR:9245 US 220 S",
        "INFO:10-15 16 YOF ASHTMA ATTACK ADV CANNOT FIND INHALER");

    doTest("T15",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130000615\n" +
        "ASSGN- 19.29.32 01/15/13\n" +
        "ATAC1- 19.29.39\n" +
        "ENRT - 19.30.36\n" +
        "ARRVD- 19.40.46\n" +
        "S50  - 19.45.32\n" +
        "RETRN- 19.55.41\n" +
        "CMPLT- 20.02.42",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000615",
        "PLACE:ASSGN- 19.29.32 01/15/13\nATAC1- 19.29.39\nENRT - 19.30.36\nARRVD- 19.40.46\nS50  - 19.45.32\nRETRN- 19.55.41\nCMPLT- 20.02.42",
        "CALL:RUN REPORT");

    doTest("T16",
        "Randolph 911 - SEFD\n" +
        "SICKNESS\n" +
        "4937 REEDER RD\n" +
        "STA06\n" +
        "STA06\n" +
        "10-15 JOHNNY MILLS 61 YOM CON/ALERT...GEN WEAKNESS...UNABLE TO\n" +
        "WALK...CPN#4654507...CALLER TERRY KING\n" +
        "19:29:32 01/15/2013 - NELSON,A W\n" +
        "ProQA Medical Recommended Dispatch Level",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:SICKNESS",
        "ADDR:4937 REEDER RD",
        "INFO:10-15 JOHNNY MILLS 61 YOM CON/ALERT...GEN WEAKNESS...UNABLE TO / WALK...CPN#4654507...CALLER TERRY KING");

    doTest("T17",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130000595\n" +
        "ASSGN- 11.04.56 01/15/13\n" +
        "ENRT - 11.05.41\n" +
        "ARRVD- 11.10.47\n" +
        "S50  - 11.15.58\n" +
        "RETRN- 11.39.15\n" +
        "CMPLT- 11.46.57",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000595",
        "PLACE:ASSGN- 11.04.56 01/15/13\nENRT - 11.05.41\nARRVD- 11.10.47\nS50  - 11.15.58\nRETRN- 11.39.15\nCMPLT- 11.46.57",
        "CALL:RUN REPORT");

    doTest("T18",
        "Randolph 911 - SEFD\n" +
        "SICKNESS\n" +
        "4980 RIDGE RD\n" +
        "STA06\n" +
        "STA06\n" +
        "71 YOF...FEMALE IS CANCER PATIENT...HAD TREATMENT YESTERDAY...C/O GEN WEAKNESS\n" +
        "AND DIARRHEA\n" +
        "11:02:28 01/15/2013 - POE,J L\n" +
        "ProQA Medical Recommended Dispatch Level = 26A10\n" +
        "11:02",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:SICKNESS",
        "ADDR:4980 RIDGE RD",
        "INFO:71 YOF...FEMALE IS CANCER PATIENT...HAD TREATMENT YESTERDAY...C/O GEN WEAKNESS / AND DIARRHEA");

    doTest("T19",
        "Randolph 911 - SEFD\nSTA06\n130000566\nASSGN- 17.03.21 01/14/13\nENRT - 17.03.27\nARRVD- 17.05.04\nRETRN- 17.10.37\nCMPLT- 17.14.35",
        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000566",
        "PLACE:ASSGN- 17.03.21 01/14/13\nENRT - 17.03.27\nARRVD- 17.05.04\nRETRN- 17.10.37\nCMPLT- 17.14.35",
        "CALL:RUN REPORT");

    doTest("T20",
        "Randolph 911 - SEFD\nSERVICE CALL\n542 BURNEY RD\nSTA06\nSTA06",
        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:SERVICE CALL",
        "ADDR:542 BURNEY RD");

    doTest("T21",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130000554\n" +
        "ASSGN- 13.54.51 01/14/13\n" +
        "BTAC1- 13.55.01\n" +
        "ENRT - 13.55.29\n" +
        "ARRVD- 13.59.32\n" +
        "RETRN- 14.18.19\n" +
        "CMPLT- 14.23.35",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000554",
        "PLACE:ASSGN- 13.54.51 01/14/13\nBTAC1- 13.55.01\nENRT - 13.55.29\nARRVD- 13.59.32\nRETRN- 14.18.19\nCMPLT- 14.23.35",
        "CALL:RUN REPORT");

    doTest("T22",
        "Randolph 911 - SEFD\n" +
        "BREATHING\n" +
        "4881 REEDER RD\n" +
        "STA06\n" +
        "STA06\n" +
        "68 YOA FEMALE..CON ALERT...DIFF BREATHING \n\n" +
        "13:53:17 01/14/2013 - BAILEY,J B\n" +
        "ProQA Medical Recommended Dispatch Level = 06D02\n" +
        "13:53:58 01/14/2013 - BAILEY,J B\n" +
        "ProQA Medical",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:BREATHING",
        "ADDR:4881 REEDER RD",
        "INFO:68 YOA FEMALE..CON ALERT...DIFF BREATHING");

    doTest("T23",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130000553\n" +
        "ASSGN- 12.59.21 01/14/13\n" +
        "ATAC3- 12.59.27\n" +
        "ENRT - 12.59.45\n" +
        "STDBY- 13.03.54\n" +
        "ARRVD- 13.10.47\n" +
        "S50  - 13.14.48\n" +
        "RETRN- 13.22.54\n" +
        "CMPLT- 13.26.33",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000553",
        "PLACE:ASSGN- 12.59.21 01/14/13\nATAC3- 12.59.27\nENRT - 12.59.45\nSTDBY- 13.03.54\nARRVD- 13.10.47\nS50  - 13.14.48\nRETRN- 13.22.54\nCMPLT- 13.26.33",
        "CALL:RUN REPORT");

    doTest("T24",
        "Randolph 911 - SEFD\n" +
        "HEMORRHAGE\n" +
        "381 OAK VIEW LN\n" +
        "STA06\n" +
        "STA06\n" +
        "10-15 LEVI PINNIX...16YOM...SLIT HIS WRIST...\n" +
        "12:57:03 01/14/2013 - HALLIDAY,A M\n" +
        "ProQA Medical Case Entry Finished\n" +
        "12:58:07 01/14/2013 - HALLIDAY,A M\n" +
        "ProQA Medical Recommen",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:HEMORRHAGE",
        "ADDR:381 OAK VIEW LN",
        "INFO:10-15 LEVI PINNIX...16YOM...SLIT HIS WRIST...");

    doTest("T25",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130000490\n" +
        "ASSGN- 21.09.54 01/12/13\n" +
        "ENRT - 21.10.01\n" +
        "ARRVD- 21.17.58\n" +
        "S50  - 21.32.48\n" +
        "RETRN- 21.33.15\n" +
        "CMPLT- 21.41.44",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000490",
        "PLACE:ASSGN- 21.09.54 01/12/13\nENRT - 21.10.01\nARRVD- 21.17.58\nS50  - 21.32.48\nRETRN- 21.33.15\nCMPLT- 21.41.44",
        "CALL:RUN REPORT");

    doTest("T26",
        "Randolph 911 - SEFD\nLOCKOUT\nBACHELOR CREEK RD\nSTA06\nSTA06\nSTA06 ADV LOCKOUT",
        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:LOCKOUT",
        "ADDR:BACHELOR CREEK RD",
        "INFO:STA06 ADV LOCKOUT");

    doTest("T27",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130000472\n" +
        "ASSGN- 15.30.57 01/12/13\n" +
        "ENRT - 15.31.12\n" +
        "ATAC1- 15.31.18\n" +
        "ARRVD- 15.37.46\n" +
        "S50  - 15.44.29\n" +
        "RETRN- 16.00.23\n" +
        "CMPLT- 16.11.25",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000472",
        "PLACE:ASSGN- 15.30.57 01/12/13\nENRT - 15.31.12\nATAC1- 15.31.18\nARRVD- 15.37.46\nS50  - 15.44.29\nRETRN- 16.00.23\nCMPLT- 16.11.25",
        "CALL:RUN REPORT");

    doTest("T28",
        "Randolph 911 - SEFD\n" +
        "FALL\n" +
        "6687 NC HWY 134\n" +
        "STA06\n" +
        "STA06\n" +
        "10-15 1 YO FELL ONTO THE CONCRETE..HEAD INJURY...HEMATOMA TO THE HEAD...BLEEDING\n" +
        "FROM THE LIP AND NOSE SLIGHTLY...CHILD IS UPSET AND WANTING TO SLEEP HOWEVER HAS\n" +
        "NOT HAD A NAP\n" +
        "15:",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:FALL",
        "ADDR:6687 NC HWY 134",
        "MADDR:6687 STATE 134",
        "INFO:10-15 1 YO FELL ONTO THE CONCRETE..HEAD INJURY...HEMATOMA TO THE HEAD...BLEEDING / FROM THE LIP AND NOSE SLIGHTLY...CHILD IS UPSET AND WANTING TO SLEEP HOWEVER HAS / NOT HAD A NAP");

    doTest("T29",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130000388\n" +
        "ASSGN- 23.29.09 01/09/13\n" +
        "ATAC2- 23.29.12\n" +
        "ENRT - 23.33.10\n" +
        "ARRVD- 23.38.59\n" +
        "RETRN- 23.55.54\n" +
        "CMPLT- 00.14.10",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000388",
        "PLACE:ASSGN- 23.29.09 01/09/13\nATAC2- 23.29.12\nENRT - 23.33.10\nARRVD- 23.38.59\nRETRN- 23.55.54\nCMPLT- 00.14.10",
        "CALL:RUN REPORT");

    doTest("T30",
        "Randolph 911 - SEFD\n" +
        "STB06\n" +
        "130000389\n" +
        "ASSGN- 23.44.04 01/09/13\n" +
        "ATAC2- 23.44.42\n" +
        "ENRT - 23.48.10\n" +
        "ARRVD- 23.57.49\n" +
        "S50  - 23.57.58\n" +
        "RETRN- 00.02.25\n" +
        "CMPLT- 00.14.07",

        "SRC:SEFD",
        "UNIT:STB06",
        "ID:130000389",
        "PLACE:ASSGN- 23.44.04 01/09/13\nATAC2- 23.44.42\nENRT - 23.48.10\nARRVD- 23.57.49\nS50  - 23.57.58\nRETRN- 00.02.25\nCMPLT- 00.14.07",
        "CALL:RUN REPORT");

    doTest("T31",
        "Randolph 911 - SEFD\n" +
        "BREATHING\n" +
        "2330 WHITE PINES LN\n" +
        "STA06\n" +
        "STB06\n" +
        "71M, DIFF BRTH, REQ 10-16 PRIOR TO 10-23\n" +
        "23:43:15 01/09/2013 - WRIGHT,J R\n" +
        "ProQA Medical Recommended Dispatch Level = 06C01",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:BREATHING",
        "ADDR:2330 WHITE PINES LN",
        "INFO:71M, DIFF BRTH, REQ 10-16 PRIOR TO 10-23");

    doTest("T32",
        "Randolph 911 - SEFD\n" +
        "STROKE\n" +
        "310 OLD PLANK RD\n" +
        "STA06\n" +
        "STA06\n" +
        "10-15 LOUSILLE THOMPSON...70 YOF....3RD PARTY CALLER STATES HIS FATHER CALLED\n" +
        "AND SAID HIS MOTHER COULD NOT WALK AND NEEDED AN AMBULANCE...NO FURTHER\n" +
        "10-14...CALLER IS 10 MINS A",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:STROKE",
        "ADDR:310 OLD PLANK RD",
        "INFO:10-15 LOUSILLE THOMPSON...70 YOF....3RD PARTY CALLER STATES HIS FATHER CALLED / AND SAID HIS MOTHER COULD NOT WALK AND NEEDED AN AMBULANCE...NO FURTHER / 10-14...CALLER IS 10 MINS A");

    doTest("T33",
        "Randolph 911 - SEFD\n" +
        "UNKNOWN MEDICAL\n" +
        "310 OLD PLANK RD\n" +
        "STA06\n" +
        "STA06\n" +
        "10-15 LOUSILLE THOMPSON...70 YOF....\n" +
        "23:29:26 01/09/2013 - HALLIDAY,A M\n" +
        "ProQA Medical Recommended Dispatch Level = 32B03\n" +
        "23:29:33 01/09/2013 - HALLIDAY,A M\n" +
        "ProQA Medi",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:UNKNOWN MEDICAL",
        "ADDR:310 OLD PLANK RD",
        "INFO:10-15 LOUSILLE THOMPSON...70 YOF....");

    doTest("T34",
        "Randolph 911 - SEFD\nSTROKE\n310 OLD PLANK RD\nSTA06\nSTA06\n10-15 LOUSILLE THOMPSON...70 YOF....",
        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:STROKE",
        "ADDR:310 OLD PLANK RD",
        "INFO:10-15 LOUSILLE THOMPSON...70 YOF....");

    doTest("T35",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130000378\n" +
        "ASSGN- 20.09.23 01/09/13\n" +
        "ATAC2- 20.09.26\n" +
        "ENRT - 20.10.35\n" +
        "32   - 20.13.05\n" +
        "ARRVD- 20.15.09\n" +
        "S50  - 20.19.37\n" +
        "RETRN- 20.32.15\n" +
        "CMPLT- 20.36.13",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000378",
        "PLACE:ASSGN- 20.09.23 01/09/13\nATAC2- 20.09.26\nENRT - 20.10.35\n32   - 20.13.05\nARRVD- 20.15.09\nS50  - 20.19.37\nRETRN- 20.32.15\nCMPLT- 20.36.13",
        "CALL:RUN REPORT");

    doTest("T36",
        "Randolph 911 - SEFD\n" +
        "UNCONSCIOUS\n" +
        "727 OLD PLANK RD\n" +
        "STA06\n" +
        "STA06\n" +
        "10-15 IS CLARA HOOVER...80 YO FEMALE...FAINTING EPISODES X2...NAUSEA AND\n" +
        "VOMITING...\n" +
        "20:06:36 01/09/2013 - MORRIS,D C\n" +
        "ProQA Medical Case Entry Finished\n" +
        "20:07:59 01/09/201",

        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:UNCONSCIOUS",
        "ADDR:727 OLD PLANK RD",
        "INFO:10-15 IS CLARA HOOVER...80 YO FEMALE...FAINTING EPISODES X2...NAUSEA AND / VOMITING...");

    doTest("T37",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130000373\n" +
        "ASSGN- 19.06.25 01/09/13\n" +
        "ENRT - 19.07.57\n" +
        "32   - 19.09.43\n" +
        "ARRVD- 19.14.23\n" +
        "ATAC2- 19.18.18\n" +
        "RETRN- 19.27.58\n" +
        "CMPLT- 19.39.40",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000373",
        "PLACE:ASSGN- 19.06.25 01/09/13\nENRT - 19.07.57\n32   - 19.09.43\nARRVD- 19.14.23\nATAC2- 19.18.18\nRETRN- 19.27.58\nCMPLT- 19.39.40",
        "CALL:RUN REPORT");

    doTest("T38",
        "Randolph 911 - SEFD\nACCIDENT/PI\n5045 RIDGE RD\nSTA06\nSTA06\n1 VEH, UNK PI,  POSSIBLE 10-55",
        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:ACCIDENT/PI",
        "ADDR:5045 RIDGE RD",
        "INFO:1 VEH, UNK PI,  POSSIBLE 10-55");

    doTest("T39",
        "Randolph 911 - SEFD\n" +
        "STA06\n" +
        "130000320\n" +
        "ASSGN- 14.53.27 01/08/13\n" +
        "ENRT - 14.53.31\n" +
        "ATAC3- 14.53.33\n" +
        "ARRVD- 14.55.57\n" +
        "S50  - 15.02.55\n" +
        "RETRN- 15.37.58\n" +
        "CMPLT- 15.40.21",

        "SRC:SEFD",
        "UNIT:STA06",
        "ID:130000320",
        "PLACE:ASSGN- 14.53.27 01/08/13\nENRT - 14.53.31\nATAC3- 14.53.33\nARRVD- 14.55.57\nS50  - 15.02.55\nRETRN- 15.37.58\nCMPLT- 15.40.21",
        "CALL:RUN REPORT");

    doTest("T40",
        "Randolph 911 - SEFD\nFIRE (OTHER)\n6966 US HWY 220 S\nSTA06\nSTA06",
        "SRC:SEFD",
        "UNIT:STA06",
        "CALL:FIRE (OTHER)",
        "ADDR:6966 US HWY 220 S",
        "MADDR:6966 US 220 S");
   
  }

  public static void main(String[] args) {
    new NCRandolphCountyParserTest().generateTests("T1");
  }
}
