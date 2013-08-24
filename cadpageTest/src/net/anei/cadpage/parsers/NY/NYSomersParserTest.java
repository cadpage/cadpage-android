package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Somers, NY (in Westchester County)
Contact: Patrick Jackson <patjackson52@gmail.com>
Conact: "David Luongo" <unleashedff248@gmail.com>

2011-000375 *** ALARM, CARBON MONOXIDE (Neg. Symptoms) *** RECINE, LUCIA 2 Corral Court SOMERS SOMERS TOA: 21:41 03/02/11 Somers FD Somers FD
2011-000382 *** Structure Fire (F.D.R. + Sirens) *** 13 GREENLAWN RD SOMERS SOMERS TOA: 00:16 03/04/11 Somers FD Somers FD HQ AMAWALK HOUSE
2011-000398 *** INSIDE ELECTRICAL HAZZARD (Pump Out/ Appliance Mal *** COHN, HENRIETTA 82 LAKE RD SOMERS SOMERS CS: RT 202 TOA: 21:51 03/06/11 Somers FD Som
2011-000397 *** Inside Smoke/Odor Investigation *** MELITO, ELIZABETH 112 WARREN ST SOMERS SOMERS TOA: 20:35 03/06/11 Somers FD Somers FD
2011-000496 *** Other Fire *** ANGLEBROOK GOLF CLUB L.P. 100 RT 202 SOMERS SOMERS CS: RT 139 C-3,4 TOA: 19:12 03/18/11 Somers FD Somers FD HQ GRANITE SPRING
2011-000493 *** Vehicle Fire *** 246 HERITAGE HILLS SOMERS SOMERS CS: RT 202 TOA: 12:18 03/18/11 Somers FD Somers FD AMAWALK HOUSE
2011-000514 *** P.I.A.A. / M.V.A (ALS) ***  MAHOPAC AVE SOMERS SOMERS CS: WATERGATE DR TOA: 21:15 03/23/11 Somers FD Somers FD HQ CAR INTO POLE
2011-000512 *** AUTOMATIC ALARM - RESIDENTIAL *** SALHA, FADY 62 HALLOCKS RUN SOMERS SOMERS CS: VORIS DR  / RT 202 TOA: 18:36 03/23/11 Somers FD Somers FD H
2011-000543 *** Stroke (C.V.A.) (ALS) *** 136 PRIMROSE LINCOLNDALE LINCOLNDALE TOA: 15:44 03/28/11 Somers FD Somers FD HQ 51 Y/O/F
2011-000550 *** Cardiac Arrest (ALS) *** SOMERS MANOR NURSING HOME 189 RT 100 KATONAH KATONAH CS: PLUMBROOK RD D-5 TOA: 06:10 03/29/11 Somers FD Somers FD H
2011-000467 *** Injuries from Fall (More than 10 ft) ALS *** COMMUNITY LIVING CORP 34 MOSEMAN AVE SOMERS SOMERS CS: ORCHARD RD  / SUN HILL RD TOA: 19:25 03/
2011-000507 *** Unknown Medical Emergency *** Lux, George ***MOS*** 61 JUNIPER DR LINCOLNDALE LINCOLNDALE TOA: 18:09 03/21/11 Somers FD Somers FD HQ SOMERS
2011-000504 *** Stand-by FIRE (In Quarters) *** 145 RT 118 SOMERS SOMERS TOA: 19:28 03/20/11 Somers FD Somers FD
2011-000503 *** Structure Fire (F.D.R. + Sirens) *** 112 HITCHING POST LN SOMERS SOMERS TOA: 19:23 03/20/11 Somers FD Somers FD HQ
2011-000502 *** Stand-by Fire (Other Agency's Quarters) *** 1916 COMMERCE ST SOMERS SOMERS TOA: 19:12 03/20/11 Somers FD Somers FD HQ
2011-000550 *** Cardiac Arrest (ALS) *** SOMERS MANOR NURSING HOME 189 RT 100 KATONAH KATONAH CS: PLUMBROOK RD D-5 TOA: 06:10 03/29/11 Somers FD Somers FD H
2011-000559 *** Injury, Leg *** 25 VALLEY POND RD SOMERS SOMERS TOA: 15:12 03/29/11 71 Y/O FEMALE 71 Y/O FEMALE Somers FD Somers FD HIP DISLOCATION
2011-000555 *** Stroke (C.V.A.) (ALS) *** HANSHAFT, RHONA 817 HERITAGE HILLS SOMERS SOMERS TOA: 11:10 03/29/11 Somers FD Somers FD 6696031

*/

public class NYSomersParserTest extends BaseParserTest {
  
  public NYSomersParserTest() {
    setParser(new NYSomersParser(), "SOMERS", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "2011-000375 *** ALARM, CARBON MONOXIDE (Neg. Symptoms) *** RECINE, LUCIA 2 Corral Court SOMERS SOMERS TOA: 21:41 03/02/11 Somers FD Somers FD",
        "ID:2011-000375",
        "CALL:ALARM, CARBON MONOXIDE (Neg. Symptoms)",
        "NAME:RECINE, LUCIA",
        "ADDR:2 Corral Court",
        "CITY:SOMERS");

    doTest("T2",
        "2011-000382 *** Structure Fire (F.D.R. + Sirens) *** 13 GREENLAWN RD SOMERS SOMERS TOA: 00:16 03/04/11 Somers FD Somers FD HQ AMAWALK HOUSE",
        "ID:2011-000382",
        "CALL:Structure Fire (F.D.R. + Sirens)",
        "ADDR:13 GREENLAWN RD",
        "CITY:SOMERS",
        "INFO:HQ AMAWALK HOUSE");

    doTest("T3",
        "2011-000398 *** INSIDE ELECTRICAL HAZZARD (Pump Out/ Appliance Mal *** COHN, HENRIETTA 82 LAKE RD SOMERS SOMERS CS: RT 202 TOA: 21:51 03/06/11 Somers FD Som",
        "ID:2011-000398",
        "CALL:INSIDE ELECTRICAL HAZZARD (Pump Out/ Appliance Mal",
        "NAME:COHN, HENRIETTA",
        "ADDR:82 LAKE RD",
        "CITY:SOMERS",
        "X:RT 202",
        "INFO:Som");

    doTest("T4",
        "2011-000397 *** Inside Smoke/Odor Investigation *** MELITO, ELIZABETH 112 WARREN ST SOMERS SOMERS TOA: 20:35 03/06/11 Somers FD Somers FD",
        "ID:2011-000397",
        "CALL:Inside Smoke/Odor Investigation",
        "NAME:MELITO, ELIZABETH",
        "ADDR:112 WARREN ST",
        "CITY:SOMERS");

    doTest("T5",
        "2011-000496 *** Other Fire *** ANGLEBROOK GOLF CLUB L.P. 100 RT 202 SOMERS SOMERS CS: RT 139 C-3,4 TOA: 19:12 03/18/11 Somers FD Somers FD HQ GRANITE SPRING",
        "ID:2011-000496",
        "CALL:Other Fire",
        "PLACE:ANGLEBROOK GOLF CLUB L.P.",
        "ADDR:100 RT 202",
        "CITY:SOMERS",
        "X:RT 139 C-3,4",
        "INFO:HQ GRANITE SPRING");

    doTest("T6",
        "2011-000493 *** Vehicle Fire *** 246 HERITAGE HILLS SOMERS SOMERS CS: RT 202 TOA: 12:18 03/18/11 Somers FD Somers FD AMAWALK HOUSE",
        "ID:2011-000493",
        "CALL:Vehicle Fire",
        "ADDR:246 HERITAGE HILLS",
        "CITY:SOMERS",
        "X:RT 202",
        "INFO:AMAWALK HOUSE");

    doTest("T7",
        "2011-000514 *** P.I.A.A. / M.V.A (ALS) ***  MAHOPAC AVE SOMERS SOMERS CS: WATERGATE DR TOA: 21:15 03/23/11 Somers FD Somers FD HQ CAR INTO POLE",
        "ID:2011-000514",
        "CALL:P.I.A.A. / M.V.A (ALS)",
        "ADDR:MAHOPAC AVE",
        "MADDR:MAHOPAC AVE & WATERGATE DR",
        "CITY:SOMERS",
        "X:WATERGATE DR",
        "INFO:HQ CAR INTO POLE");

    doTest("T8",
        "2011-000512 *** AUTOMATIC ALARM - RESIDENTIAL *** SALHA, FADY 62 HALLOCKS RUN SOMERS SOMERS CS: VORIS DR  / RT 202 TOA: 18:36 03/23/11 Somers FD Somers FD H",
        "ID:2011-000512",
        "CALL:AUTOMATIC ALARM - RESIDENTIAL",
        "NAME:SALHA, FADY",
        "ADDR:62 HALLOCKS RUN",
        "CITY:SOMERS",
        "X:VORIS DR  / RT 202",
        "INFO:H");

    doTest("T9",
        "2011-000543 *** Stroke (C.V.A.) (ALS) *** 136 PRIMROSE LINCOLNDALE LINCOLNDALE TOA: 15:44 03/28/11 Somers FD Somers FD HQ 51 Y/O/F",
        "ID:2011-000543",
        "CALL:Stroke (C.V.A.) (ALS)",
        "ADDR:136 PRIMROSE",
        "CITY:LINCOLNDALE",
        "INFO:HQ 51 Y/O/F");

    doTest("T10",
        "2011-000550 *** Cardiac Arrest (ALS) *** SOMERS MANOR NURSING HOME 189 RT 100 KATONAH KATONAH CS: PLUMBROOK RD D-5 TOA: 06:10 03/29/11 Somers FD Somers FD H",
        "ID:2011-000550",
        "CALL:Cardiac Arrest (ALS)",
        "PLACE:SOMERS MANOR NURSING HOME",
        "ADDR:189 RT 100",
        "CITY:KATONAH",
        "X:PLUMBROOK RD D-5",
        "INFO:H");

    doTest("T11",
        "2011-000467 *** Injuries from Fall (More than 10 ft) ALS *** COMMUNITY LIVING CORP 34 MOSEMAN AVE SOMERS SOMERS CS: ORCHARD RD  / SUN HILL RD TOA: 19:25 03/",
        "ID:2011-000467",
        "CALL:Injuries from Fall (More than 10 ft) ALS",
        "PLACE:COMMUNITY LIVING CORP",
        "ADDR:34 MOSEMAN AVE",
        "CITY:SOMERS",
        "X:ORCHARD RD  / SUN HILL RD",
        "INFO:19:25 03/");

    doTest("T12",
        "2011-000507 *** Unknown Medical Emergency *** Lux, George ***MOS*** 61 JUNIPER DR LINCOLNDALE LINCOLNDALE TOA: 18:09 03/21/11 Somers FD Somers FD HQ SOMERS",
        "ID:2011-000507",
        "CALL:Unknown Medical Emergency",
        "NAME:Lux, George",
        "ADDR:61 JUNIPER DR",
        "CITY:LINCOLNDALE",
        "INFO:HQ SOMERS");

    doTest("T13",
        "2011-000504 *** Stand-by FIRE (In Quarters) *** 145 RT 118 SOMERS SOMERS TOA: 19:28 03/20/11 Somers FD Somers FD",
        "ID:2011-000504",
        "CALL:Stand-by FIRE (In Quarters)",
        "ADDR:145 RT 118",
        "CITY:SOMERS");

    doTest("T14",
        "2011-000503 *** Structure Fire (F.D.R. + Sirens) *** 112 HITCHING POST LN SOMERS SOMERS TOA: 19:23 03/20/11 Somers FD Somers FD HQ",
        "ID:2011-000503",
        "CALL:Structure Fire (F.D.R. + Sirens)",
        "ADDR:112 HITCHING POST LN",
        "CITY:SOMERS",
        "INFO:HQ");

    doTest("T15",
        "2011-000502 *** Stand-by Fire (Other Agency's Quarters) *** 1916 COMMERCE ST SOMERS SOMERS TOA: 19:12 03/20/11 Somers FD Somers FD HQ",
        "ID:2011-000502",
        "CALL:Stand-by Fire (Other Agency's Quarters)",
        "ADDR:1916 COMMERCE ST",
        "CITY:SOMERS",
        "INFO:HQ");

    doTest("T16",
        "2011-000550 *** Cardiac Arrest (ALS) *** SOMERS MANOR NURSING HOME 189 RT 100 KATONAH KATONAH CS: PLUMBROOK RD D-5 TOA: 06:10 03/29/11 Somers FD Somers FD H",
        "ID:2011-000550",
        "CALL:Cardiac Arrest (ALS)",
        "PLACE:SOMERS MANOR NURSING HOME",
        "ADDR:189 RT 100",
        "CITY:KATONAH",
        "X:PLUMBROOK RD D-5",
        "INFO:H");

    doTest("T17",
        "2011-000559 *** Injury, Leg *** 25 VALLEY POND RD SOMERS SOMERS TOA: 15:12 03/29/11 71 Y/O FEMALE 71 Y/O FEMALE Somers FD Somers FD HIP DISLOCATION",
        "ID:2011-000559",
        "CALL:Injury, Leg",
        "ADDR:25 VALLEY POND RD",
        "CITY:SOMERS",
        "INFO:71 Y/O FEMALE 71 Y/O FEMALE HIP DISLOCATION");

    doTest("T18",
        "2011-000555 *** Stroke (C.V.A.) (ALS) *** HANSHAFT, RHONA 817 HERITAGE HILLS SOMERS SOMERS TOA: 11:10 03/29/11 Somers FD Somers FD 6696031",
        "ID:2011-000555",
        "CALL:Stroke (C.V.A.) (ALS)",
        "NAME:HANSHAFT, RHONA",
        "ADDR:817 HERITAGE HILLS",
        "CITY:SOMERS",
        "INFO:6696031");
  }
  
  public static void main(String[] args) {
    new NYSomersParserTest().generateTests("T1");
  }
}