package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Mercer County, PA
"Kane, Thomas J." <KANETJ1@gcc.edu>
Sender: 9-1-1"@mcc.co.mercer.pa.us
"9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: N BROAD ST/LINCOLN AVE GROV EID: 2360315 TYPE CODE: MVU CALLER NAME: LARRY GRACE CALLER ADDR: 522 E MAIN ST E
"9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 666 FLOWER ST GROV EID: 2363268 TYPE CODE: COM CALLER NAME:  CALLER ADDR: 109 GEORGE JUNIOR RD PINE TIME: 20:
"9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 597 CLARKSVILLE RD COOL: alias 597 RT 258 0 COOL EID: 2366343 TYPE CODE: HF CALLER NAME: 
"9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 129 E PINE ST GROV: @PENN GROVE HOTEL EID: 2368267 TYPE CODE: FALM CALLER NAME: VECTOR-42
"9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: FOREST DR/LINCOLN AVE GROV EID: 2368281 TYPE CODE: TREE CALLER NAME: LUKE SPEARS CALLER A
"9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: N CENTER ST/W CHESTNUT ST GROV EID: 2370662 TYPE CODE: MVF CALLER NAME: TAMMY OCONNER CAL
"9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 209 W MERCER ST EID: 2351183 TYPE CODE: MUT CALLER NAME: BUTLER CALLER ADDR:  TIM
"9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 55 FRANKLIN ST STON EID: 2351363 TYPE CODE: CHIM CALLER NAME: BARTHOLOMEW, BRENDA
"9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 150 LATONKA DR JACK EID: 2353811 TYPE CODE: HF CALLER NAME: MARKS, KATHLEEN CALLE
"9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 819 SUNSET AVE GROV EID: 2354410 TYPE CODE: ELO CALLER NAME: MONTGOMERY BEVERLY C
"9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 201 ERIE ST GROV: @ALLIED NEWS / THE HERALD EID: 2354451 TYPE CODE: ELI CALLER NA
"9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 123 W MAIN ST GROV: @GROVE CITY BOROUGH EID: 2354882 TYPE CODE: BRU CALLER NAME: C
"mercer 9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 160 GEORGE JUNIOR RD GROV: @GROVE CITY ARMORY EID: 2374687 TYPE CODE: SERV CALLER NAME: ERIC MERSHIMER CALLER
"Mercer 9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 12 STAFFORDSHIRE DR PINE EID: 2377509 TYPE CODE: HF CALLER NAME: MICHELLE GAIMFLEY CALLER ADDR: 109 GEORGE JU
"Mercer 9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 1237 WALNUT ST STON EID: 2377268 TYPE CODE: STR CALLER NAME: KIM ALLEN CALLER ADDR: 527 FREDONIA RD LAKE TIME
"Mercer 9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: TERRACE AVE/FRANKLIN PL GROV EID: 2398277 TYPE CODE: UTL CALLER NAME: ALLAN KIRK CALLER ADDR: 109 GEORGE JUNI
"Mercer 9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 51 E LACOCK ST SLAK EID: 2404345 TYPE CODE: HF CALLER NAME: KELLY SUNDAY CALLER ADDR: 147 DOYLE RD LAKE TIME:
"Mercer 9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 146 N BROAD ST GROV: @GROVE CITY FIRE STATION 1 FD EID: 2410257 TYPE CODE: AF CALLER NAME: CHF95 CALLER ADDR:
"Mercer 9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 251 PINCHALONG RD PINE EID: 2411723 TYPE CODE: BARN CALLER NAME: T5ROOPER CALLAHAN CALLER ADDR:  TIME: 22:01:
"Mercer 9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 311 W MAIN ST GROV EID: 2406357 TYPE CODE: CMD CALLER NAME: BECK, WAYNE CALLER ADDR: 311 W MAIN ST GROVE CITY
"Mercer 9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 1402 W MAIN STREET EXT GROV EID: 2424459 TYPE CODE: HAZ CALLER NAME: TRINA STEWART CALLER ADDR: 1402 W MAIN S
"Mercer 9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: PENN GRV/PARK AVE GROV EID: 2426263 TYPE CODE: SERV CALLER NAME: ROXANNE STUDABAKER CALLER ADDR: 145 PINE ST
"Mercer 9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 391 GEORGE JUNIOR RD PINE EID: 2426268 TYPE CODE: GARF CALLER NAME: JOSH ENRINGER CALLER ADDR: 764 CLINTONVIL
"Mercer 9-1-1"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 207 PENNSY RD SPRG EID: 2449811 TYPE CODE: MHF CALLER NAME: TRISTIN SHREVEES CALLER ADDR:\2sTIME: 12:28:24

Contact: Active911
Agency name: Grove City Volunteer Fire Dept
Location: Grove City, PA, United States
Sender: "Mercer County 911" <"Mercer 9-1-1"@mcc.co.mercer.pa.us>

(IPS I/Page Notification) Location: 101 E WASHINGTON BLVD GROV EID: 2461666 TYPE CODE: CMDS CALLER NAME: CHRISTINE HOCKENBERRY CALLER ADDR: 101 E WASHINGTON BLVD GROVE CITY TIME: 15:06:55 
(IPS I/Page Notification) Location: 2048 PERRY HWY SPRG: @JONES GARAGE EID: 2460951 TYPE CODE: STR CALLER NAME: HALEE CORSON CALLER ADDR: 1831 PERRY HWY SPRINGFIELD TIME: 13:22:32 
(IPS I/Page Notification) Location: 211 JACKSON ST GROV EID: 2460839 TYPE CODE: ELO CALLER NAME: JAMIE GUTHRIE CALLER ADDR: 522 E MAIN ST EXT PINE TIME: 09:28:23 
(IPS I/Page Notification) Location: 3300 N MAIN ST SLAK EID: 2459761 TYPE CODE: CHIM CALLER NAME: JUSTIN BARR CALLER ADDR: 559 FREDONIA RD LAKE TIME: 22:22:36 
(IPS I/Page Notification) Location: 200 W MAIN ST GROV: @MCDONALDS EID: 2458869 TYPE CODE: ELO CALLER NAME: TEST XCALL CALLER ADDR: TEST CALL TIME: 11:27:36 
(IPS I/Page Notification) Location: 516 COLLEGE AVE GROV EID: 2458838 TYPE CODE: BRU CALLER NAME: TEST CALLER ADDR: TEST TIME: 09:24:46 
(IPS I/Page Notification) Location: 395 DAUGHERTY RD PINE EID: 2465255 TYPE CODE: ANML CALLER NAME: STACEY DIRECTICH CALLER ADDR: 764 CLINTONVILLE RD FINDLEY TIME: 10:21:50
(IPS I/Page Notification) Location: 117 N DIAMOND ST MERC: @SIDEBAR & GRILLE EID: 2489058 TYPE CODE: SMOI CALLER NAME: AMANDA KISH CALLER ADDR:  TIME: 11:34:43
(IPS I/Page Notification) EID: 2490320 TYPE CODE: ELO CALLER NAME: REBECCA CULP CALLER ADDR: 522 E MAIN ST EXT PINE TIME: 16:05:38 

 */

public class PAMercerCountyParserTest extends BaseParserTest {
  
  public PAMercerCountyParserTest() {
    setParser(new PAMercerCountyParser(), "MERCER COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "\"9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: N BROAD ST/LINCOLN AVE GROV EID: 2360315 TYPE CODE: MVU CALLER NAME: LARRY GRACE CALLER ADDR: 522 E MAIN ST E",
        "ADDR:N BROAD ST & LINCOLN AVE",
        "CITY:GROVE CITY",
        "ID:2360315",
        "CALL:Motor Vehicle Crash w/ unknown injuries",
        "NAME:LARRY GRACE");

    doTest("T2",
        "\"9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 666 FLOWER ST GROV EID: 2363268 TYPE CODE: COM CALLER NAME:  CALLER ADDR: 109 GEORGE JUNIOR RD PINE TIME: 20:",
        "ADDR:666 FLOWER ST",
        "CITY:GROVE CITY",
        "ID:2363268",
        "CALL:Commercial Fire",
        "TIME:20:");

    doTest("T3",
        "\"9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 597 CLARKSVILLE RD COOL: alias 597 RT 258 0 COOL EID: 2366343 TYPE CODE: HF CALLER NAME: ",
        "ADDR:597 CLARKSVILLE RD",
        "CITY:COOLSPRING TWP",
        "PLACE:597 RT 258 0",
        "ID:2366343",
        "CALL:House fire");

    doTest("T4",
        "\"9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 129 E PINE ST GROV: @PENN GROVE HOTEL EID: 2368267 TYPE CODE: FALM CALLER NAME: VECTOR-42",
        "ADDR:129 E PINE ST",
        "CITY:GROVE CITY",
        "PLACE:PENN GROVE HOTEL",
        "ID:2368267",
        "CALL:Fire alarm",
        "NAME:VECTOR-42");

    doTest("T5",
        "\"9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: FOREST DR/LINCOLN AVE GROV EID: 2368281 TYPE CODE: TREE CALLER NAME: LUKE SPEARS CALLER A",
        "ADDR:FOREST DR & LINCOLN AVE",
        "CITY:GROVE CITY",
        "ID:2368281",
        "CALL:Tree down",
        "NAME:LUKE SPEARS");

    doTest("T6",
        "\"9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: N CENTER ST/W CHESTNUT ST GROV EID: 2370662 TYPE CODE: MVF CALLER NAME: TAMMY OCONNER CAL",
        "ADDR:N CENTER ST & W CHESTNUT ST",
        "CITY:GROVE CITY",
        "ID:2370662",
        "CALL:MVF",
        "NAME:TAMMY OCONNER");

    doTest("T7",
        "\"9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 209 W MERCER ST EID: 2351183 TYPE CODE: MUT CALLER NAME: BUTLER CALLER ADDR:  TIM",
        "ADDR:209 W MERCER ST",
        "ID:2351183",
        "CALL:Mutual Aid",
        "NAME:BUTLER");

    doTest("T8",
        "\"9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 55 FRANKLIN ST STON EID: 2351363 TYPE CODE: CHIM CALLER NAME: BARTHOLOMEW, BRENDA",
        "ADDR:55 FRANKLIN ST",
        "CITY:STONEBORO",
        "ID:2351363",
        "CALL:Chimney Fire",
        "NAME:BARTHOLOMEW, BRENDA");

    doTest("T9",
        "\"9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 150 LATONKA DR JACK EID: 2353811 TYPE CODE: HF CALLER NAME: MARKS, KATHLEEN CALLE",
        "ADDR:150 LATONKA DR",
        "CITY:JACKSON TWP",
        "ID:2353811",
        "CALL:House fire",
        "NAME:MARKS, KATHLEEN");

    doTest("T10",
        "\"9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 819 SUNSET AVE GROV EID: 2354410 TYPE CODE: ELO CALLER NAME: MONTGOMERY BEVERLY C",
        "ADDR:819 SUNSET AVE",
        "CITY:GROVE CITY",
        "ID:2354410",
        "CALL:Electric Lines down",
        "NAME:MONTGOMERY BEVERLY");

    doTest("T11",
        "\"9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 201 ERIE ST GROV: @ALLIED NEWS / THE HERALD EID: 2354451 TYPE CODE: ELI CALLER NA",
        "ADDR:201 ERIE ST",
        "CITY:GROVE CITY",
        "PLACE:ALLIED NEWS / THE HERALD",
        "ID:2354451",
        "CALL:Electric Fire");

    doTest("T12",
        "\"9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 123 W MAIN ST GROV: @GROVE CITY BOROUGH EID: 2354882 TYPE CODE: BRU CALLER NAME: C",
        "ADDR:123 W MAIN ST",
        "CITY:GROVE CITY",
        "PLACE:GROVE CITY BOROUGH",
        "ID:2354882",
        "CALL:Brush Fire");

    doTest("T13",
        "\"mercer 9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 160 GEORGE JUNIOR RD GROV: @GROVE CITY ARMORY EID: 2374687 TYPE CODE: SERV CALLER NAME: ERIC MERSHIMER CALLER",
        "ADDR:160 GEORGE JUNIOR RD",
        "CITY:GROVE CITY",
        "PLACE:GROVE CITY ARMORY",
        "ID:2374687",
        "CALL:Service Call",
        "NAME:ERIC MERSHIMER");

    doTest("T14",
        "\"Mercer 9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 12 STAFFORDSHIRE DR PINE EID: 2377509 TYPE CODE: HF CALLER NAME: MICHELLE GAIMFLEY CALLER ADDR: 109 GEORGE JU",
        "ADDR:12 STAFFORDSHIRE DR",
        "CITY:PINE",
        "ID:2377509",
        "CALL:House fire",
        "NAME:MICHELLE GAIMFLEY");

    doTest("T15",
        "\"Mercer 9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 1237 WALNUT ST STON EID: 2377268 TYPE CODE: STR CALLER NAME: KIM ALLEN CALLER ADDR: 527 FREDONIA RD LAKE TIME",
        "ADDR:1237 WALNUT ST",
        "CITY:STONEBORO",
        "ID:2377268",
        "CALL:Structure Fire",
        "NAME:KIM ALLEN");

    doTest("T16",
        "\"Mercer 9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: TERRACE AVE/FRANKLIN PL GROV EID: 2398277 TYPE CODE: UTL CALLER NAME: ALLAN KIRK CALLER ADDR: 109 GEORGE JUNI",
        "ADDR:TERRACE AVE & FRANKLIN PL",
        "CITY:GROVE CITY",
        "ID:2398277",
        "CALL:Utility Lines Down",
        "NAME:ALLAN KIRK");

    doTest("T17",
        "\"Mercer 9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 51 E LACOCK ST SLAK EID: 2404345 TYPE CODE: HF CALLER NAME: KELLY SUNDAY CALLER ADDR: 147 DOYLE RD LAKE TIME:",
        "ADDR:51 E LACOCK ST",
        "CITY:SANDY LAKE",
        "ID:2404345",
        "CALL:House fire",
        "NAME:KELLY SUNDAY");

    doTest("T18",
        "\"Mercer 9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 146 N BROAD ST GROV: @GROVE CITY FIRE STATION 1 FD EID: 2410257 TYPE CODE: AF CALLER NAME: CHF95 CALLER ADDR:",
        "ADDR:146 N BROAD ST",
        "CITY:GROVE CITY",
        "PLACE:GROVE CITY FIRE STATION 1 FD",
        "ID:2410257",
        "CALL:Fire-Admin Activity",
        "NAME:CHF95");

    doTest("T19",
        "\"Mercer 9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 251 PINCHALONG RD PINE EID: 2411723 TYPE CODE: BARN CALLER NAME: T5ROOPER CALLAHAN CALLER ADDR:  TIME: 22:01:",
        "ADDR:251 PINCHALONG RD",
        "CITY:PINE",
        "ID:2411723",
        "CALL:Barn Fire",
        "NAME:T5ROOPER CALLAHAN",
        "TIME:22:01:");

    doTest("T20",
        "\"Mercer 9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 311 W MAIN ST GROV EID: 2406357 TYPE CODE: CMD CALLER NAME: BECK, WAYNE CALLER ADDR: 311 W MAIN ST GROVE CITY",
        "ADDR:311 W MAIN ST",
        "CITY:GROVE CITY",
        "ID:2406357",
        "CALL:Carbon Monoxide Detector",
        "NAME:BECK, WAYNE");

    doTest("T30",
        "\"Mercer 9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 1402 W MAIN STREET EXT GROV EID: 2424459 TYPE CODE: HAZ CALLER NAME: TRINA STEWART CALLER ADDR: 1402 W MAIN S",
        "ADDR:1402 W MAIN STREET EXT",
        "MADDR:1402 W MAIN STREET",
        "CITY:GROVE CITY",
        "ID:2424459",
        "CALL:Hazmat",
        "NAME:TRINA STEWART");

    doTest("T31",
        "\"Mercer 9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: PENN GRV/PARK AVE GROV EID: 2426263 TYPE CODE: SERV CALLER NAME: ROXANNE STUDABAKER CALLER ADDR: 145 PINE ST",
        "ADDR:PENN GRV & PARK AVE",
        "CITY:GROVE CITY",
        "ID:2426263",
        "CALL:Service Call",
        "NAME:ROXANNE STUDABAKER");

    doTest("T32",
        "\"Mercer 9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 391 GEORGE JUNIOR RD PINE EID: 2426268 TYPE CODE: GARF CALLER NAME: JOSH ENRINGER CALLER ADDR: 764 CLINTONVIL",
        "ADDR:391 GEORGE JUNIOR RD",
        "CITY:PINE",
        "ID:2426268",
        "CALL:Garbage Fire",
        "NAME:JOSH ENRINGER");

    doTest("T33",
        "\"Mercer 9-1-1\"@mcc.co.mercer.pa.us (IPS I/Page Notification) Location: 207 PENNSY RD SPRG EID: 2449811 TYPE CODE: MHF CALLER NAME: TRISTIN SHREVEES CALLER ADDR:\\2sTIME: 12:28:24",
        "ADDR:207 PENNSY RD",
        "CITY:SPRINGFIELD",
        "ID:2449811",
        "CALL:Mobile Home Fire",
        "NAME:TRISTIN SHREVEES");
  }
  
  @Test
  public void testGroveCityFire() {

    doTest("T1",
        "(IPS I/Page Notification) Location: 101 E WASHINGTON BLVD GROV EID: 2461666 TYPE CODE: CMDS CALLER NAME: CHRISTINE HOCKENBERRY CALLER ADDR: 101 E WASHINGTON BLVD GROVE CITY TIME: 15:06:55 ",
        "ADDR:101 E WASHINGTON BLVD",
        "CITY:GROVE CITY",
        "ID:2461666",
        "CALL:Carbon Monoxide detector w/ symptoms",
        "NAME:CHRISTINE HOCKENBERRY",
        "TIME:15:06:55");

    doTest("T2",
        "(IPS I/Page Notification) Location: 2048 PERRY HWY SPRG: @JONES GARAGE EID: 2460951 TYPE CODE: STR CALLER NAME: HALEE CORSON CALLER ADDR: 1831 PERRY HWY SPRINGFIELD TIME: 13:22:32 ",
        "ADDR:2048 PERRY HWY",
        "CITY:SPRINGFIELD",
        "PLACE:JONES GARAGE",
        "ID:2460951",
        "CALL:Structure Fire",
        "NAME:HALEE CORSON",
        "TIME:13:22:32");

    doTest("T3",
        "(IPS I/Page Notification) Location: 211 JACKSON ST GROV EID: 2460839 TYPE CODE: ELO CALLER NAME: JAMIE GUTHRIE CALLER ADDR: 522 E MAIN ST EXT PINE TIME: 09:28:23 ",
        "ADDR:211 JACKSON ST",
        "CITY:GROVE CITY",
        "ID:2460839",
        "CALL:Electric Lines down",
        "NAME:JAMIE GUTHRIE",
        "TIME:09:28:23");

    doTest("T4",
        "(IPS I/Page Notification) Location: 3300 N MAIN ST SLAK EID: 2459761 TYPE CODE: CHIM CALLER NAME: JUSTIN BARR CALLER ADDR: 559 FREDONIA RD LAKE TIME: 22:22:36 ",
        "ADDR:3300 N MAIN ST",
        "CITY:SANDY LAKE",
        "ID:2459761",
        "CALL:Chimney Fire",
        "NAME:JUSTIN BARR",
        "TIME:22:22:36");

    doTest("T5",
        "(IPS I/Page Notification) Location: 200 W MAIN ST GROV: @MCDONALDS EID: 2458869 TYPE CODE: ELO CALLER NAME: TEST XCALL CALLER ADDR: TEST CALL TIME: 11:27:36 ",
        "ADDR:200 W MAIN ST",
        "CITY:GROVE CITY",
        "PLACE:MCDONALDS",
        "ID:2458869",
        "CALL:Electric Lines down",
        "NAME:TEST XCALL",
        "TIME:11:27:36");

    doTest("T6",
        "(IPS I/Page Notification) Location: 516 COLLEGE AVE GROV EID: 2458838 TYPE CODE: BRU CALLER NAME: TEST CALLER ADDR: TEST TIME: 09:24:46 ",
        "ADDR:516 COLLEGE AVE",
        "CITY:GROVE CITY",
        "ID:2458838",
        "CALL:Brush Fire",
        "NAME:TEST",
        "TIME:09:24:46");

    doTest("T7",
        "(IPS I/Page Notification) Location: 395 DAUGHERTY RD PINE EID: 2465255 TYPE CODE: ANML CALLER NAME: STACEY DIRECTICH CALLER ADDR: 764 CLINTONVILLE RD FINDLEY TIME: 10:21:50",
        "ADDR:395 DAUGHERTY RD",
        "CITY:PINE",
        "ID:2465255",
        "CALL:Animal Rescue",
        "NAME:STACEY DIRECTICH",
        "TIME:10:21:50");

    doTest("T8",
        "(IPS I/Page Notification) Location: 117 N DIAMOND ST MERC: @SIDEBAR & GRILLE EID: 2489058 TYPE CODE: SMOI CALLER NAME: AMANDA KISH CALLER ADDR:  TIME: 11:34:43",
        "ADDR:117 N DIAMOND ST",
        "CITY:MERCER",
        "PLACE:SIDEBAR & GRILLE",
        "ID:2489058",
        "CALL:Smoke in Structure",
        "NAME:AMANDA KISH",
        "TIME:11:34:43");

    doTest("T9",
        "(IPS I/Page Notification) EID: 2490320 TYPE CODE: ELO CALLER NAME: REBECCA CULP CALLER ADDR: 522 E MAIN ST EXT PINE TIME: 16:05:38 ",
        "ID:2490320",
        "CALL:Electric Lines down",
        "NAME:REBECCA CULP",
        "ADDR:522 E MAIN ST EXT",
        "CITY:PINE",
        "MADDR:522 E MAIN ST",
        "TIME:16:05:38");

  }
  
  public static void main(String[] args) {
    new PAMercerCountyParserTest().generateTests("T1");
  }
}