package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Mobile Medical Response, MI (Claire, Isabella, and Gratiot Counties)
Contact: Sean Duffy <emt210@gmail.com>, 2315981587@messaging.sprintpcs.com
Sender: mailghost@mobilemedical.org
System: ProQA

Subject:<CAD> - part 1 of 1\nRC:Run# 17656/11775 N ISABELLA RD/P-2 Emergency No Lights//Chest Pain (Non-Traumatic)/herrick and pere marquette
Subject:<CAD> - part 1 of 1\nRC:Run# 17612/7800 LUDINGTON DR/P-3 Downgrade  (No Lts/Sirens)//Falls/x gibson and lake station ave on 
Subject:<CAD> - part 1 of 1\nRC:Run# 16888/7181 N CLARE/P-1 Life Threatening Emergency//Cardiac or Respiratory Arrest/Death/x forres
Subject:<CAD> - part 1 of 1\nRC:Run# 17723/600 SE 4TH ST/P-1 Life Threatening Emergency/nurses station/Sick Person (Specific Diagnos
Subject:<CAD> - part 1 of 1\nRC:Run# 17923/10197 S CLARE AVE/P-2 Emergency No Lights//Chest Pain (Non-Traumatic)/dept corrections bu
Subject:<CAD> - part 1 of 1\nRC:Run# 17874/521 S SCOTT DR/P-1 Life Threatening Emergency//Breathing Problems/was in ER Saturday/ dx 
Subject:<CAD> - part 1 of 1\nRC:Run# 17991/391 MILL ST/P-2 Emergency No Lights/D/Sick Person (Specific Diagnosis)/pt had knee replac
Subject:<CAD> - part 1 of 1\nRC:Run# 17893/235 GATEWAY DR/P-1 Life Threatening Emergency/105/Breathing Problems//ALS/CLARE///<Unknow
Subject:<CAD> - part 1 of 1\nRC:Run# 17970/602 BEECH ST/P-5 Local Transport/2ND FLOOR 205-A MED SURG/Int-Sick Person-Specify in Comm

prvs=10834168ba=mailghost@mobilemedical.org (<CAD> - part 1 of 1) RC:Run# 24453/5186 FENTON/P-3 Downgrade  (No Lts/Sirens)//Overdose / Poisoning (Ingestion)/mundy twp // at kroger

Contact: "jenmdawson@yahoo.com" <jenmdawson@yahoo.co>
Sender: 6573
<CAD> - part 1 of 1/ RC:Run# 34376/3300 PAULAN DR/P-1 Life Threatening Emergency//Chest Pain (Non-Traumatic)/72/F/ALS/BAY CITY///<Unknown>/20:04\n\n
<CAD> - part 1 of 1/ RC:Run# 34848/3375 BOY SCOUT RD/P-1 Life Threatening Emergency//Convulsions/Seizures/x Sherwood & Euclid // 35 F/ALS/BAY CITY///<Unkno
<CAD> - part 1 of 1/ Run# 0/ 800 S WASHINGTON AVE/ P-7 Long Distance/ 1/ Int-Overdose/Poisoning (Ingestion)/ EXTRAS: NONE... DECONDITIONING.../PT READY / PCS RE

Contact: "chrisgrzegorczyk@hotmail.com" <chrisgrzegorczyk@hotmail.com>
(<CAD> - part 1 of 1) Run# 55683/ 508 N MONROE ST/ P-3 Downgrade (No Lts/Sirens)/ Sick Person (Specific Diagnosis)/ 19/f/ ALS/ BAY CITY/ 1900 COLUMBUS A

Contact: Tim Young <tdyoung2578@gmail.com>
--<CAD> - part 1 of 1 --RC:Run# 64549/1227 JANES AVE/P-1 Life Threatening Emergency//Breathing Problems/26/F .... IFO STOP-N-SHOP/ALS/SAGINAW///<Unknown>/02:02

Contact: Nicholas Funk <nfunk01@gmail.com>
(<CAD> - part 1 of 1) RC:Run# 9980/4116 W COOK RD/P-1 Life Threatening Emergency//Heart Problems / A.I.C.D./88 f  stier 1   Stat 91/ALS/GRAND BLANC///<Un

Contact: Andy Wall <agwemt@gmail.com>
Sender: mailghost@mobilemedical.org
Subject:<CAD> - part 1 of 1\nRC:Run# 14534/805 W CEDAR ST/P-7 Long Distance/ACUTE CARE 25 -B/Int-Sick Person-Specify in Comments/NON

Contact: Scott Kowalczyk <skow275@gmail.com>
Sender: mailghost@mobilemedical.org
Subject:<CAD> - part 1 of 1\nRC:Run# 86486/4234 HARBORTOWNE DR/P-2 Emergency No Lights/3/Unconscious/Fainting (Near)/Waterside Apts/\r

Contact: Doug Lobsinger <dlobsinger@mobilemedical.org>
<CAD> - part 1 of 1\bRC:Run# 31253/4005 ORCHARD DR/P-7 Long Distance/intensive imaging-2208/Int-Sick Person-Specify in Comments/No extras // Going for new dialysis port placement // PCS req'd / go through er // stay on 2nd floor // they will be directed to invasive imaging/ cath lab ///BLS/MIDLAND/1524 PORTABELLA RD//SCOTT/ ROBERT/18:09

Contact: Active911
Agency name: Mobile Medical Response
Location: Saginaw, MI, United States
Sender: mailghost@mobilemedical.org

(<CAD> - part 1 of 1) RC:Job# 0189-A/ Run# 83948/ was Canceled: Patient Refused Service/17:24/17:24/17:24/17:28/17:45\r\n\r\n
(<CAD> - part 1 of 1) RC:Run# 83948/M L KING AVE & W STEWART AVE/P-2 Emergency No Lights//Traffic/Transportation/Accidents/TIER 1 // MLK & STEWART/ALS/FLINT///<Unknown>/17:24\r\n\r\n
(<CAD> - part 1 of 1) RC:0111-A/Run#83846/11:31/11:31/11:32/11:37/11:47/11:56/12:36/12:36/ODOM ATS:1.4/ODOM ATD:3.6/MILES:       2.2/PUZIP:48504\r\n\r\n
(<CAD> - part 1 of 1) RC:Run# 83846/1106 W HAMILTON AVE/P-1 Life Threatening Emergency//Sick Person (Specific Diagnosis)/83F/ was choking on Oatmeal --- no DIB and not choking -- just wants to be checked out // tier 1 for MLK/ALS/FLINT///<Unknown>/11:31\r\n\r\n
(<CAD> - part 1 of 1) RC:0099-A/Run#83831/10:25/10:26/10:26/10:28/10:38/10:43/11:06/11:06/ODOM ATS:0.6/ODOM ATD:2.7/MILES:       2.1/PUZIP:48504\r\n\r\n
(<CAD> - part 1 of 1) RC:Run# 83831/3606 RACE ST/P-1 Life Threatening Emergency//Chest Pain (Non-Traumatic)/45f hx heart mlk/ALS/FLINT///<Unknown>/10:25\r\n\r\n
(<CAD> - part 1 of 1) Run# 83820/ W STEWART AVE & M L KING AVE/ P-1 Life Threatening Emergency/ Traffic/Transportation/Accidents/ alt LOC / tier 1 for MLK base/ ALS/ FLINT/ <Unknown>/ 09:13\r\n\r\n
(<CAD> - part 1 of 1) RC:Run# 83820/W STEWART AVE & KEYS ST/P-1 Life Threatening Emergency//Traffic/Transportation/Accidents/alt LOC // tier 1 for MLK base/ALS/FLINT///<Unknown>/09:13\r\n\r\n
(<CAD> - part 1 of 1) RC:0237-A/Run#83699/18:57/18:57/18:57/19:08/19:18/19:22/19:35/19:36/ODOM ATS:0.0/ODOM ATD:2.2/MILES:       2.2/PUZIP:48602\r\n\r\n
(<CAD> - part 1 of 1) RC:Run# 83699/2001 BROCKWAY RD/P-2 Emergency No Lights//Sick Person (Specific Diagnosis)/71m // dizzy/ALS/SAGINAW///<Unknown>/18:57\r\n\r\n
(<CAD> - part 1 of 1) RC:Job# 0189-A/ Run# 83649/ was Canceled: Cancelled PTA/16:01/16:02/16:02/16:09\r\n\r\n
(<CAD> - part 1 of 1) RC:Run# 83653/5570 STATE ST/P-3 Downgrade  (No Lts/Sirens)/1/Unconscious/Fainting (Near)/60/m syncope awake & breathing req nonemergency/ALS/SAGINAW///<Unknown>/16:09\r\n\r\n
(<CAD> - part 1 of 1) RC:Run# 83649/3020 BOARDWALK DR/P-1 Life Threatening Emergency/in the lobby/Unconscious/Fainting (Near)/22/f/ALS/SAGINAW///<Unknown>/15:42\r\n\r\n
(<CAD> - part 1 of 1) RC:Run# 83621/4370 LAKESIDE CIR/P-2 Emergency No Lights/APT 138/Headache//ALS/SAGINAW///<Unknown>/14:16\r\n\r\n
(<CAD> - part 1 of 1) RC:Run# 83586/1447 N HARRISON ST/P-7 Long Distance/820-B/Int-Sick Person-Specify in Comments/LUNG CA/ COPD/ 02/ DEBILITY/ WEAKNESS/ SHORTNESS OF BREATH/ALS/SAGINAW/6700 WESTSIDE SAGINAW RD//VALERIO/ ALBERT/12:15\r\n\r\n
(<CAD> - part 1 of 1) RC:Run# 83587/4800 E MCLEOD DR/P-2 Emergency No Lights//Heart Problems / A.I.C.D./24/f dialysis pt/ elevated heart rate & BP/ALS/SAGINAW///<Unknown>/12:02\r\n\r\n
(<CAD> - part 1 of 1) RC:Run# 83586/1447 N HARRISON ST/P-7 Long Distance/820-B/Int-Sick Person-Specify in Comments/LUNG CA/ COPD/ 02/ DEBILITY/ WEAKNESS/ SHORTNESS OF BREATH/ALS/SAGINAW/6700 WESTSIDE SAGINAW RD//VALERIO/ ALBERT/12:15\r\n\r\n
(<CAD> - part 1 of 1) RC:Run# 83569/5935 SHATTUCK RD/P-2 Emergency No Lights/18/Sick Person (Specific Diagnosis)/male pt/ alt loc/ALS/SAGINAW///<Unknown>/11:04\r\n\r\n
(<CAD> - part 1 of 1) RC:Run# 83553/1447 N HARRISON ST/P-5 Local Transport/813-B/Int-Sick Person-Specify in Comments/ADVANCED DEMENTIA/ PNEUM./ PE/ DEBILITY/ DECOND/ NO EXTRAS/ALS/SAGINAW/3340 HOSPITAL RD//BORENSTEIN/ ELFRIEDE/10:30\r\n\r\n
(<CAD> - part 1 of 1) RC:Run# 83543/121 PERRY ST/P-2 Emergency No Lights/fulerton tool/Chest Pain (Non-Traumatic)/40f //DIB ///ALS/SAGINAW///<Unknown>/09:14\r\n\r\n
(<CAD> - part 1 of 1) Run# 83480/ 2225 TITTABAWASSEE RD/ P-1 Life Threatening Emergency/ Psychiatric/ Abnormal Behavior/Suicide Attempt/ at the ihop tittabawsee /red g6 in the back parking lot/ ALS/ SAGINAW/ 700 COOPER AVE/ <Unknown>/ 00:22\r\n\r\n

 */

public class MIMobileMedicalResponseParserTest extends BaseParserTest {
  
  public MIMobileMedicalResponseParserTest() {
    setParser(new MIMobileMedicalResponseParser(), "", "MI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:<CAD> - part 1 of 1\nRC:Run# 17656/11775 N ISABELLA RD/P-2 Emergency No Lights//Chest Pain (Non-Traumatic)/herrick and pere marquette",
        "ID:17656",
        "ADDR:11775 N ISABELLA RD",
        "CALL:P-2 Emergency No Lights",
        "INFO:Chest Pain (Non-Traumatic) / herrick and pere marquette");

    doTest("T2",
        "Subject:<CAD> - part 1 of 1\nRC:Run# 17612/7800 LUDINGTON DR/P-3 Downgrade  (No Lts/Sirens)//Falls/x gibson and lake station ave on",
        "ID:17612",
        "ADDR:7800 LUDINGTON DR",
        "CALL:P-3 Downgrade  (No Lts/Sirens)",
        "INFO:Falls",
        "X:gibson and lake station ave on");

    doTest("T3",
        "Subject:<CAD> - part 1 of 1\nRC:Run# 16888/7181 N CLARE/P-1 Life Threatening Emergency//Cardiac or Respiratory Arrest/Death/x forres",
        "ID:16888",
        "ADDR:7181 N CLARE",
        "CALL:P-1 Life Threatening Emergency",
        "INFO:Cardiac or Respiratory Arrest / Death",
        "X:forres");

    doTest("T4",
        "Subject:<CAD> - part 1 of 1\nRC:Run# 17723/600 SE 4TH ST/P-1 Life Threatening Emergency/nurses station/Sick Person (Specific Diagnos",
        "ID:17723",
        "ADDR:600 SE 4TH ST",
        "CALL:P-1 Life Threatening Emergency",
        "INFO:nurses station / Sick Person (Specific Diagnos");

    doTest("T5",
        "Subject:<CAD> - part 1 of 1\nRC:Run# 17923/10197 S CLARE AVE/P-2 Emergency No Lights//Chest Pain (Non-Traumatic)/dept corrections bu",
        "ID:17923",
        "ADDR:10197 S CLARE AVE",
        "CALL:P-2 Emergency No Lights",
        "INFO:Chest Pain (Non-Traumatic) / dept corrections bu");

    doTest("T6",
        "Subject:<CAD> - part 1 of 1\nRC:Run# 17874/521 S SCOTT DR/P-1 Life Threatening Emergency//Breathing Problems/was in ER Saturday/ dx",
        "ID:17874",
        "ADDR:521 S SCOTT DR",
        "CALL:P-1 Life Threatening Emergency",
        "INFO:Breathing Problems / was in ER Saturday / dx");

    doTest("T7",
        "Subject:<CAD> - part 1 of 1\nRC:Run# 17991/391 MILL ST/P-2 Emergency No Lights/D/Sick Person (Specific Diagnosis)/pt had knee replac",
        "ID:17991",
        "ADDR:391 MILL ST",
        "CALL:P-2 Emergency No Lights",
        "APT:D",
        "INFO:Sick Person (Specific Diagnosis) / pt had knee replac");

    doTest("T8",
        "Subject:<CAD> - part 1 of 1\nRC:Run# 17893/235 GATEWAY DR/P-1 Life Threatening Emergency/105/Breathing Problems//ALS/CLARE///<Unknow",
        "ID:17893",
        "ADDR:235 GATEWAY DR",
        "CALL:P-1 Life Threatening Emergency",
        "APT:105",
        "INFO:Breathing Problems / ALS / CLARE / <Unknow");

    doTest("T9",
        "Subject:<CAD> - part 1 of 1\nRC:Run# 17970/602 BEECH ST/P-5 Local Transport/2ND FLOOR 205-A MED SURG/Int-Sick Person-Specify in Comm",
        "ID:17970",
        "ADDR:602 BEECH ST",
        "CALL:P-5 Local Transport",
        "INFO:2ND FLOOR 205-A MED SURG / Int-Sick Person-Specify in Comm");

    doTest("T10",
        "prvs=10834168ba=mailghost@mobilemedical.org (<CAD> - part 1 of 1) RC:Run# 24453/5186 FENTON/P-3 Downgrade  (No Lts/Sirens)//Overdose / Poisoning (Ingestion)/mundy twp // at kroger",
        "ID:24453",
        "ADDR:5186 FENTON",
        "CALL:P-3 Downgrade  (No Lts/Sirens)",
        "INFO:Overdose / Poisoning (Ingestion) / mundy twp / at kroger");

    doTest("T11",
        "<CAD> - part 1 of 1/ RC:Run# 34376/3300 PAULAN DR/P-1 Life Threatening Emergency//Chest Pain (Non-Traumatic)/72/F/ALS/BAY CITY///<Unknown>/20:04\n\n",
        "ID:34376",
        "ADDR:3300 PAULAN DR",
        "CALL:P-1 Life Threatening Emergency",
        "INFO:Chest Pain (Non-Traumatic) / 72 / F / ALS / BAY CITY / <Unknown> / 20:04");

    doTest("T12",
        "<CAD> - part 1 of 1/ RC:Run# 34848/3375 BOY SCOUT RD/P-1 Life Threatening Emergency//Convulsions/Seizures/x Sherwood & Euclid // 35 F/ALS/BAY CITY///<Unkno",
        "ID:34848",
        "ADDR:3375 BOY SCOUT RD",
        "CALL:P-1 Life Threatening Emergency",
        "INFO:Convulsions / Seizures / 35 F / ALS / BAY CITY / <Unkno",
        "X:Sherwood & Euclid");

    doTest("T13",
        "<CAD> - part 1 of 1/ Run# 0/ 800 S WASHINGTON AVE/ P-7 Long Distance/ 1/ Int-Overdose/Poisoning (Ingestion)/ EXTRAS: NONE... DECONDITIONING.../PT READY / PCS RE",
        "ID:0",
        "ADDR:800 S WASHINGTON AVE",
        "CALL:P-7 Long Distance",
        "APT:1",
        "INFO:Int-Overdose / Poisoning (Ingestion) / EXTRAS: NONE... DECONDITIONING... / PT READY / PCS RE");

    doTest("T14",
        "(<CAD> - part 1 of 1) Run# 55683/ 508 N MONROE ST/ P-3 Downgrade (No Lts/Sirens)/ Sick Person (Specific Diagnosis)/ 19/f/ ALS/ BAY CITY/ 1900 COLUMBUS A",
        "ID:55683",
        "ADDR:508 N MONROE ST",
        "CALL:P-3 Downgrade (No Lts/Sirens)",
        "INFO:Sick Person (Specific Diagnosis) / 19 / f / ALS / BAY CITY / 1900 COLUMBUS A");

    doTest("T15",
        "--<CAD> - part 1 of 1 --RC:Run# 64549/1227 JANES AVE/P-1 Life Threatening Emergency//Breathing Problems/26/F .... IFO STOP-N-SHOP/ALS/SAGINAW///<Unknown>/02:02",
        "ID:64549",
        "ADDR:1227 JANES AVE",
        "CALL:P-1 Life Threatening Emergency",
        "INFO:Breathing Problems / 26 / F .... IFO STOP-N-SHOP / ALS / SAGINAW / <Unknown> / 02:02");

    doTest("T16",
        "(<CAD> - part 1 of 1) RC:Run# 9980/4116 W COOK RD/P-1 Life Threatening Emergency//Heart Problems / A.I.C.D./88 f  stier 1   Stat 91/ALS/GRAND BLANC///<Un",
        "ID:9980",
        "ADDR:4116 W COOK RD",
        "CALL:P-1 Life Threatening Emergency",
        "INFO:Heart Problems / A.I.C.D. / 88 f  stier 1   Stat 91 / ALS / GRAND BLANC / <Un");

    doTest("T17",
        "Subject:<CAD> - part 1 of 1\n" +
        "RC:Run# 14534/805 W CEDAR ST/P-7 Long Distance/ACUTE CARE 25 -B/Int-Sick Person-Specify in Comments/NON",

        "ID:14534",
        "ADDR:805 W CEDAR ST",
        "CALL:P-7 Long Distance",
        "INFO:ACUTE CARE 25 -B / Int-Sick Person-Specify in Comments / NON");

    doTest("T18",
        "Subject:<CAD> - part 1 of 1\n" +
        "RC:Run# 86486/4234 HARBORTOWNE DR/P-2 Emergency No Lights/3/Unconscious/Fainting (Near)/Waterside Apts/\r",

        "ID:86486",
        "ADDR:4234 HARBORTOWNE DR",
        "APT:3",
        "CALL:P-2 Emergency No Lights",
        "INFO:Unconscious / Fainting (Near) / Waterside Apts");

  }
  
  @Test
  public void testBobLobsinger() {

    doTest("T1",
        "<CAD> - part 1 of 1\\bRC:Run# 31253/4005 ORCHARD DR/P-7 Long Distance/intensive imaging-2208/Int-Sick Person-Specify in Comments/No extras // Going for new dialysis port placement // PCS req'd / go through er // stay on 2nd floor // they will be directed to invasive imaging/ cath lab ///BLS/MIDLAND/1524 PORTABELLA RD//SCOTT/ ROBERT/18:09",
        "ID:31253",
        "ADDR:4005 ORCHARD DR",
        "CALL:P-7 Long Distance",
        "INFO:intensive imaging-2208 / Int-Sick Person-Specify in Comments / No extras / Going for new dialysis port placement / PCS req'd / go through er / stay on 2nd floor / they will be directed to invasive imaging / cath lab / BLS / MIDLAND / 1524 PORTABELLA RD / SCOTT / ROBERT / 18:09");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(<CAD> - part 1 of 1) RC:Job# 0189-A/ Run# 83948/ was Canceled: Patient Refused Service/17:24/17:24/17:24/17:28/17:45\r\n\r\n",
        "ID:83948",
        "CALL:RUN REPORT",
        "PLACE:was Canceled: Patient Refused Service/17:24/17:24/17:24/17:28/17:45");

    doTest("T2",
        "(<CAD> - part 1 of 1) RC:Run# 83948/M L KING AVE & W STEWART AVE/P-2 Emergency No Lights//Traffic/Transportation/Accidents/TIER 1 // MLK & STEWART/ALS/FLINT///<Unknown>/17:24\r\n" +
        "\r\n",

        "ID:83948",
        "ADDR:M L KING AVE & W STEWART AVE", // Not mapping
        "CALL:P-2 Emergency No Lights",
        "INFO:Traffic / Transportation / Accidents / TIER 1 / MLK & STEWART / ALS / FLINT / <Unknown> / 17:24");

    doTest("T3",
        "(<CAD> - part 1 of 1) RC:0111-A/Run#83846/11:31/11:31/11:32/11:37/11:47/11:56/12:36/12:36/ODOM ATS:1.4/ODOM ATD:3.6/MILES:       2.2/PUZIP:48504\r\n" +
        "\r\n",

        "ID:83846",
        "CALL:RUN REPORT",
        "PLACE:11:31/11:31/11:32/11:37/11:47/11:56/12:36/12:36/ODOM ATS:1.4/ODOM ATD:3.6/MILES:       2.2/PUZIP:48504");

    doTest("T4",
        "(<CAD> - part 1 of 1) RC:Run# 83846/1106 W HAMILTON AVE/P-1 Life Threatening Emergency//Sick Person (Specific Diagnosis)/83F/ was choking on Oatmeal --- no DIB and not choking -- just wants to be checked out // tier 1 for MLK/ALS/FLINT///<Unknown>/11:31\r\n" +
        "\r\n",

        "ID:83846",
        "ADDR:1106 W HAMILTON AVE",
        "CALL:P-1 Life Threatening Emergency",
        "INFO:Sick Person (Specific Diagnosis) / 83F / was choking on Oatmeal --- no DIB and not choking -- just wants to be checked out / tier 1 for MLK / ALS / FLINT / <Unknown> / 11:31");

    doTest("T5",
        "(<CAD> - part 1 of 1) RC:0099-A/Run#83831/10:25/10:26/10:26/10:28/10:38/10:43/11:06/11:06/ODOM ATS:0.6/ODOM ATD:2.7/MILES:       2.1/PUZIP:48504\r\n" +
        "\r\n",

        "ID:83831",
        "CALL:RUN REPORT",
        "PLACE:10:25/10:26/10:26/10:28/10:38/10:43/11:06/11:06/ODOM ATS:0.6/ODOM ATD:2.7/MILES:       2.1/PUZIP:48504");

    doTest("T6",
        "(<CAD> - part 1 of 1) RC:Run# 83831/3606 RACE ST/P-1 Life Threatening Emergency//Chest Pain (Non-Traumatic)/45f hx heart mlk/ALS/FLINT///<Unknown>/10:25\r\n" +
        "\r\n",

        "ID:83831",
        "ADDR:3606 RACE ST",
        "CALL:P-1 Life Threatening Emergency",
        "INFO:Chest Pain (Non-Traumatic) / 45f hx heart mlk / ALS / FLINT / <Unknown> / 10:25");

    doTest("T7",
        "(<CAD> - part 1 of 1) Run# 83820/ W STEWART AVE & M L KING AVE/ P-1 Life Threatening Emergency/ Traffic/Transportation/Accidents/ alt LOC / tier 1 for MLK base/ ALS/ FLINT/ <Unknown>/ 09:13\r\n" +
        "\r\n",

        "ID:83820",
        "ADDR:W STEWART AVE & M L KING AVE",
        "CALL:P-1 Life Threatening Emergency",
        "INFO:Traffic / Transportation / Accidents / alt LOC / tier 1 for MLK base / ALS / FLINT / <Unknown> / 09:13");

    doTest("T8",
        "(<CAD> - part 1 of 1) RC:Run# 83820/W STEWART AVE & KEYS ST/P-1 Life Threatening Emergency//Traffic/Transportation/Accidents/alt LOC // tier 1 for MLK base/ALS/FLINT///<Unknown>/09:13\r\n" +
        "\r\n",

        "ID:83820",
        "ADDR:W STEWART AVE & KEYS ST",   // Google calls this KEYES ST
        "CALL:P-1 Life Threatening Emergency",
        "INFO:Traffic / Transportation / Accidents / alt LOC / tier 1 for MLK base / ALS / FLINT / <Unknown> / 09:13");

    doTest("T9",
        "(<CAD> - part 1 of 1) RC:0237-A/Run#83699/18:57/18:57/18:57/19:08/19:18/19:22/19:35/19:36/ODOM ATS:0.0/ODOM ATD:2.2/MILES:       2.2/PUZIP:48602\r\n" +
        "\r\n",

        "ID:83699",
        "CALL:RUN REPORT",
        "PLACE:18:57/18:57/18:57/19:08/19:18/19:22/19:35/19:36/ODOM ATS:0.0/ODOM ATD:2.2/MILES:       2.2/PUZIP:48602");

    doTest("T10",
        "(<CAD> - part 1 of 1) RC:Run# 83699/2001 BROCKWAY RD/P-2 Emergency No Lights//Sick Person (Specific Diagnosis)/71m // dizzy/ALS/SAGINAW///<Unknown>/18:57\r\n" +
        "\r\n",

        "ID:83699",
        "ADDR:2001 BROCKWAY RD",
        "CALL:P-2 Emergency No Lights",
        "INFO:Sick Person (Specific Diagnosis) / 71m / dizzy / ALS / SAGINAW / <Unknown> / 18:57");

    doTest("T11",
        "(<CAD> - part 1 of 1) RC:Job# 0189-A/ Run# 83649/ was Canceled: Cancelled PTA/16:01/16:02/16:02/16:09\r\n\r\n",
        "ID:83649",
        "CALL:RUN REPORT",
        "PLACE:was Canceled: Cancelled PTA/16:01/16:02/16:02/16:09");

    doTest("T12",
        "(<CAD> - part 1 of 1) RC:Run# 83653/5570 STATE ST/P-3 Downgrade  (No Lts/Sirens)/1/Unconscious/Fainting (Near)/60/m syncope awake & breathing req nonemergency/ALS/SAGINAW///<Unknown>/16:09\r\n" +
        "\r\n",

        "ID:83653",
        "ADDR:5570 STATE ST",
        "APT:1",
        "CALL:P-3 Downgrade  (No Lts/Sirens)",
        "INFO:Unconscious / Fainting (Near) / 60 / m syncope awake & breathing req nonemergency / ALS / SAGINAW / <Unknown> / 16:09");

    doTest("T13",
        "(<CAD> - part 1 of 1) RC:Run# 83649/3020 BOARDWALK DR/P-1 Life Threatening Emergency/in the lobby/Unconscious/Fainting (Near)/22/f/ALS/SAGINAW///<Unknown>/15:42\r\n" +
        "\r\n",

        "ID:83649",
        "ADDR:3020 BOARDWALK DR",
        "CALL:P-1 Life Threatening Emergency",
        "INFO:in the lobby / Unconscious / Fainting (Near) / 22 / f / ALS / SAGINAW / <Unknown> / 15:42");

    doTest("T14",
        "(<CAD> - part 1 of 1) RC:Run# 83621/4370 LAKESIDE CIR/P-2 Emergency No Lights/APT 138/Headache//ALS/SAGINAW///<Unknown>/14:16\r\n\r\n",
        "ID:83621",
        "ADDR:4370 LAKESIDE CIR",
        "APT:138",
        "CALL:P-2 Emergency No Lights",
        "INFO:Headache / ALS / SAGINAW / <Unknown> / 14:16");

    doTest("T15",
        "(<CAD> - part 1 of 1) RC:Run# 83586/1447 N HARRISON ST/P-7 Long Distance/820-B/Int-Sick Person-Specify in Comments/LUNG CA/ COPD/ 02/ DEBILITY/ WEAKNESS/ SHORTNESS OF BREATH/ALS/SAGINAW/6700 WESTSIDE SAGINAW RD//VALERIO/ ALBERT/12:15\r\n" +
        "\r\n",

        "ID:83586",
        "ADDR:1447 N HARRISON ST",
        "CALL:P-7 Long Distance",
        "INFO:820-B / Int-Sick Person-Specify in Comments / LUNG CA / COPD / 02 / DEBILITY / WEAKNESS / SHORTNESS OF BREATH / ALS / SAGINAW / 6700 WESTSIDE SAGINAW RD / VALERIO / ALBERT / 12:15");

    doTest("T16",
        "(<CAD> - part 1 of 1) RC:Run# 83587/4800 E MCLEOD DR/P-2 Emergency No Lights//Heart Problems / A.I.C.D./24/f dialysis pt/ elevated heart rate & BP/ALS/SAGINAW///<Unknown>/12:02\r\n" +
        "\r\n",

        "ID:83587",
        "ADDR:4800 E MCLEOD DR",
        "CALL:P-2 Emergency No Lights",
        "INFO:Heart Problems / A.I.C.D. / 24 / f dialysis pt / elevated heart rate & BP / ALS / SAGINAW / <Unknown> / 12:02");

    doTest("T17",
        "(<CAD> - part 1 of 1) RC:Run# 83586/1447 N HARRISON ST/P-7 Long Distance/820-B/Int-Sick Person-Specify in Comments/LUNG CA/ COPD/ 02/ DEBILITY/ WEAKNESS/ SHORTNESS OF BREATH/ALS/SAGINAW/6700 WESTSIDE SAGINAW RD//VALERIO/ ALBERT/12:15\r\n" +
        "\r\n",

        "ID:83586",
        "ADDR:1447 N HARRISON ST",
        "CALL:P-7 Long Distance",
        "INFO:820-B / Int-Sick Person-Specify in Comments / LUNG CA / COPD / 02 / DEBILITY / WEAKNESS / SHORTNESS OF BREATH / ALS / SAGINAW / 6700 WESTSIDE SAGINAW RD / VALERIO / ALBERT / 12:15");

    doTest("T18",
        "(<CAD> - part 1 of 1) RC:Run# 83569/5935 SHATTUCK RD/P-2 Emergency No Lights/18/Sick Person (Specific Diagnosis)/male pt/ alt loc/ALS/SAGINAW///<Unknown>/11:04\r\n" +
        "\r\n",

        "ID:83569",
        "ADDR:5935 SHATTUCK RD",
        "APT:18",
        "CALL:P-2 Emergency No Lights",
        "INFO:Sick Person (Specific Diagnosis) / male pt / alt loc / ALS / SAGINAW / <Unknown> / 11:04");

    doTest("T19",
        "(<CAD> - part 1 of 1) RC:Run# 83553/1447 N HARRISON ST/P-5 Local Transport/813-B/Int-Sick Person-Specify in Comments/ADVANCED DEMENTIA/ PNEUM./ PE/ DEBILITY/ DECOND/ NO EXTRAS/ALS/SAGINAW/3340 HOSPITAL RD//BORENSTEIN/ ELFRIEDE/10:30\r\n" +
        "\r\n",

        "ID:83553",
        "ADDR:1447 N HARRISON ST",
        "CALL:P-5 Local Transport",
        "INFO:813-B / Int-Sick Person-Specify in Comments / ADVANCED DEMENTIA / PNEUM. / PE / DEBILITY / DECOND / NO EXTRAS / ALS / SAGINAW / 3340 HOSPITAL RD / BORENSTEIN / ELFRIEDE / 10:30");

    doTest("T20",
        "(<CAD> - part 1 of 1) RC:Run# 83543/121 PERRY ST/P-2 Emergency No Lights/fulerton tool/Chest Pain (Non-Traumatic)/40f //DIB ///ALS/SAGINAW///<Unknown>/09:14\r\n" +
        "\r\n",

        "ID:83543",
        "ADDR:121 PERRY ST",
        "CALL:P-2 Emergency No Lights",
        "INFO:fulerton tool / Chest Pain (Non-Traumatic) / 40f / DIB / ALS / SAGINAW / <Unknown> / 09:14");

    doTest("T21",
        "(<CAD> - part 1 of 1) Run# 83480/ 2225 TITTABAWASSEE RD/ P-1 Life Threatening Emergency/ Psychiatric/ Abnormal Behavior/Suicide Attempt/ at the ihop tittabawsee /red g6 in the back parking lot/ ALS/ SAGINAW/ 700 COOPER AVE/ <Unknown>/ 00:22\r\n" +
        "\r\n",

        "ID:83480",
        "ADDR:2225 TITTABAWASSEE RD",
        "CALL:P-1 Life Threatening Emergency",
        "INFO:Psychiatric / Abnormal Behavior / Suicide Attempt / at the ihop tittabawsee / red g6 in the back parking lot / ALS / SAGINAW / 700 COOPER AVE / <Unknown> / 00:22");

  }
  
  public static void main(String[] args) {
    new MIMobileMedicalResponseParserTest().generateTests("T1");
  }
}
