package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Nassau County, NY (Massepequa)
Contact: Rob Foley <efd6012@gmail.com>
Sender: paging@rednmxcad.com

Rescue: 100 VETERANS BLVD, Town: MASS, Cross: HICKSVILLE RD, Map: C-5, Block#: 160-NORTH, Time: 10:07:10
Washdown/spill: 21 LARCH LN, Town: MPK, Cross: WHITEWOOD DR, Map: E-8, Block#: 878-WEST, Time: 09:30:27
Vehicle Accident: 21 LARCH LN, Town: MPK, Cross: WHITEWOOD DR, Map: E-8, Block#: 878-WEST, Time: 09:28:13
Automatic Alarm: 5500 SUNRISE HWY, Town: MASS, Cross: UNQUA RD, Map: G-5, Block#: 487 SOUTH, Time: 04:19:08
Rescue: 217 EASTLAKE AVE, Town: MPK, Cross: MASSACHUSETTS AVE, Map: F-4, Block#: 262-EAST, Time: 03:35:56
Rescue: 66 HARBOR LN, Town: MPK, Cross: NASSAU ST, Map: D-8, Block#: 820-WEST, Time: 15:31:32

Contact: Active911
Agency name: Massapequa Fire Dept.
Location: Massapequa, NY, United States
Sender: massapequafd@rednmxcad.com

(MFD Dispatched Call (no subject)) Rescue: 68 CHARLES AVE, Town: MPK, Cross: CLARK AVE, Map: E-5, Block#: 189-WEST, Time: 20:51:58\n\nMASSAPEQUA FD CALL DISPATCH
(MFD Dispatched Call (no subject)) Rescue: 2413 SH, Town: , Cross: , Map: , Block#: , Time: 19:45:51\n\nMASSAPEQUA FD CALL DISPATCH
(MFD Dispatched Call (no subject)) Carbon Monoxide Alarm: 2413 SHEA BLVD, Town: MASS, Cross: BUCKNELL DR, Map: H-4, Block#: 438, Time: 19:45:15\n\nMASSAPEQUA FD CALL DISPATCH
(MFD Dispatched Call (no subject)) Rescue: 68 AVOCA AVE, Town: MPK, Cross: NEW YORK AVE, Map: D-6, Block#: 617-SOUTH, Time: 18:58:51\n\nMASSAPEQUA FD CALL DISPATCH
(MFD Dispatched Call (no subject)) Rescue: 500 VILLA DR, Town: E/M, Cross: MERRICK RD, Map: H-6, Block#: 480N, Time: 16:20:05\n\nMASSAPEQUA FD CALL DISPATCH
(MFD Dispatched Call (no subject)) Rescue: 2 CROYDEN DR, Town: MASS, Cross: ARLYN DR WEST, Map: E-7, Block#: 557-EAST, Time: 12:29:48\n\nMASSAPEQUA FD CALL DISPATCH
(MFD Dispatched Call (no subject)) Carbon Monoxide Alarm: 46 CHICAGO AVE, Town: MASS, Cross: FOREST AVE, Map: B-5, Block#: 113-SOUTH, Time: 11:53:29\n\nMASSAPEQUA FD CALL DISPATCH
(MFD Dispatched Call (no subject)) Investigation: 1 SOUTHAMPTON DR, Town: MASS, Cross: WARWICK DR, Map: H-4, Block#: 438, Time: 11:04:56\n\nMASSAPEQUA FD CALL DISPATCH
(MFD Dispatched Call (no subject)) Rescue: 515 HICKSVILLE RD, Town: MASS, Cross: BROOKLYN AVE, Map: B-5, Block#: 156-WEST, Time: 08:49:00\n\nMASSAPEQUA FD CALL DISPATCH
(MFD Dispatched Call (no subject)) Rescue: 329 OCEAN AVE, Town: MPK, Cross: PITTSBURGH AVE, Map: F-3, Block#: 302-EAST, Time: 07:26:54\n\nMASSAPEQUA FD CALL DISPATCH
(MFD Dispatched Call (no subject)) Rescue: 41 RIPPLEWATER AVE, Town: MASS, Cross: SOUTH BAY DRIVE, Map: G-9, Block#: 1026-WEST, Time: 20:58:22\n\nMASSAPEQUA FD CALL DISPATCH
(MFD Dispatched Call (no subject)) Automatic Alarm: 5204 SUNRISE HWY, Town: MPK, Cross: UNQUA RD, Map: F-5, Block#: 528B-SOUTH, Time: 18:30:00\n\nMASSAPEQUA FD CALL DISPATCH
(MFD Dispatched Call (no subject)) Rescue: 323 BRENDAN AVE, Town: MASS, Cross: ARLYN DR WEST, Map: F-6, Block#: 544-SOUTH, Time: 17:39:41\n\nMASSAPEQUA FD CALL DISPATCH
(MFD Dispatched Call (no subject)) Rescue: 85 PHILADELPHIA AVE, Town: MPK, Cross: PENNSYLVANIA AVE, Map: F-5, Block#: 227-EAST, Time: 15:13:20\n\nMASSAPEQUA FD CALL DISPATCH
(MFD Dispatched Call (no subject)) House Fire: 122 BEVERLY RD, Town: MASS, Cross: CABOT RD WEST, Map: C-9, Block#: 783-EAST, Time: 15:00:43\n\nMASSAPEQUA FD CALL DISPATCH
Special Call: 200 WESTFIELD MALL, Town: MASS, Cross: SUNRISE HWY, Map: G-5, Block#: 439-NORTH, Time: 17:42:51

*/

public class NYNassauCountyMassepequaParserTest extends BaseParserTest {
  
  public NYNassauCountyMassepequaParserTest() {
    setParser(new NYNassauCountyMassepequaParser(), "NASSAU COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Rescue: 100 VETERANS BLVD, Town: MASS, Cross: HICKSVILLE RD, Map: C-5, Block#: 160-NORTH, Time: 10:07:10",
        "CALL:Rescue",
        "ADDR:100 VETERANS BLVD",
        "CITY:MASSAPEQUA",
        "X:HICKSVILLE RD",
        "MAP:C-5",
        "INFO:160-NORTH");

    doTest("T2",
        "Washdown/spill: 21 LARCH LN, Town: MPK, Cross: WHITEWOOD DR, Map: E-8, Block#: 878-WEST, Time: 09:30:27",
        "CALL:Washdown/spill",
        "ADDR:21 LARCH LN",
        "CITY:MASSAPEQUA PARK",
        "X:WHITEWOOD DR",
        "MAP:E-8",
        "INFO:878-WEST");

    doTest("T3",
        "Vehicle Accident: 21 LARCH LN, Town: MPK, Cross: WHITEWOOD DR, Map: E-8, Block#: 878-WEST, Time: 09:28:13",
        "CALL:Vehicle Accident",
        "ADDR:21 LARCH LN",
        "CITY:MASSAPEQUA PARK",
        "X:WHITEWOOD DR",
        "MAP:E-8",
        "INFO:878-WEST");

    doTest("T4",
        "Automatic Alarm: 5500 SUNRISE HWY, Town: MASS, Cross: UNQUA RD, Map: G-5, Block#: 487 SOUTH, Time: 04:19:08",
        "CALL:Automatic Alarm",
        "ADDR:5500 SUNRISE HWY",
        "CITY:MASSAPEQUA",
        "X:UNQUA RD",
        "MAP:G-5",
        "INFO:487 SOUTH");

    doTest("T5",
        "Rescue: 217 EASTLAKE AVE, Town: MPK, Cross: MASSACHUSETTS AVE, Map: F-4, Block#: 262-EAST, Time: 03:35:56",
        "CALL:Rescue",
        "ADDR:217 EASTLAKE AVE",
        "CITY:MASSAPEQUA PARK",
        "X:MASSACHUSETTS AVE",
        "MAP:F-4",
        "INFO:262-EAST");

    doTest("T6",
        "Rescue: 66 HARBOR LN, Town: MPK, Cross: NASSAU ST, Map: D-8, Block#: 820-WEST, Time: 15:31:32",
        "CALL:Rescue",
        "ADDR:66 HARBOR LN",
        "CITY:MASSAPEQUA PARK",
        "X:NASSAU ST",
        "MAP:D-8",
        "INFO:820-WEST");

  }
  
  @Test
  public void testMassapequaFire() {

    doTest("T1",
        "(MFD Dispatched Call (no subject)) Rescue: 68 CHARLES AVE, Town: MPK, Cross: CLARK AVE, Map: E-5, Block#: 189-WEST, Time: 20:51:58\n\n" +
        "MASSAPEQUA FD CALL DISPATCH",

        "CALL:Rescue",
        "ADDR:68 CHARLES AVE",
        "CITY:MASSAPEQUA PARK",
        "X:CLARK AVE",
        "MAP:E-5",
        "INFO:189-WEST");

    doTest("T2",
        "(MFD Dispatched Call (no subject)) Rescue: 2413 SH, Town: , Cross: , Map: , Block#: , Time: 19:45:51\n\nMASSAPEQUA FD CALL DISPATCH",
        "CALL:Rescue",
        "ADDR:2413 SH",
        "MADDR:2413 ST");

    doTest("T3",
        "(MFD Dispatched Call (no subject)) Carbon Monoxide Alarm: 2413 SHEA BLVD, Town: MASS, Cross: BUCKNELL DR, Map: H-4, Block#: 438, Time: 19:45:15\n\n" +
        "MASSAPEQUA FD CALL DISPATCH",

        "CALL:Carbon Monoxide Alarm",
        "ADDR:2413 SHEA BLVD",
        "CITY:MASSAPEQUA",
        "X:BUCKNELL DR",
        "MAP:H-4",
        "INFO:438");

    doTest("T4",
        "(MFD Dispatched Call (no subject)) Rescue: 68 AVOCA AVE, Town: MPK, Cross: NEW YORK AVE, Map: D-6, Block#: 617-SOUTH, Time: 18:58:51\n\n" +
        "MASSAPEQUA FD CALL DISPATCH",

        "CALL:Rescue",
        "ADDR:68 AVOCA AVE",
        "CITY:MASSAPEQUA PARK",
        "X:NEW YORK AVE",
        "MAP:D-6",
        "INFO:617-SOUTH");

    doTest("T5",
        "(MFD Dispatched Call (no subject)) Rescue: 500 VILLA DR, Town: E/M, Cross: MERRICK RD, Map: H-6, Block#: 480N, Time: 16:20:05\n\n" +
        "MASSAPEQUA FD CALL DISPATCH",

        "CALL:Rescue",
        "ADDR:500 VILLA DR",
        "CITY:EAST MASSAPEQUA",
        "X:MERRICK RD",
        "MAP:H-6",
        "INFO:480N");

    doTest("T6",
        "(MFD Dispatched Call (no subject)) Rescue: 2 CROYDEN DR, Town: MASS, Cross: ARLYN DR WEST, Map: E-7, Block#: 557-EAST, Time: 12:29:48\n\n" +
        "MASSAPEQUA FD CALL DISPATCH",

        "CALL:Rescue",
        "ADDR:2 CROYDEN DR",
        "CITY:MASSAPEQUA",
        "X:ARLYN DR WEST",
        "MAP:E-7",
        "INFO:557-EAST");

    doTest("T7",
        "(MFD Dispatched Call (no subject)) Carbon Monoxide Alarm: 46 CHICAGO AVE, Town: MASS, Cross: FOREST AVE, Map: B-5, Block#: 113-SOUTH, Time: 11:53:29\n\n" +
        "MASSAPEQUA FD CALL DISPATCH",

        "CALL:Carbon Monoxide Alarm",
        "ADDR:46 CHICAGO AVE",
        "CITY:MASSAPEQUA",
        "X:FOREST AVE",
        "MAP:B-5",
        "INFO:113-SOUTH");

    doTest("T8",
        "(MFD Dispatched Call (no subject)) Investigation: 1 SOUTHAMPTON DR, Town: MASS, Cross: WARWICK DR, Map: H-4, Block#: 438, Time: 11:04:56\n\n" +
        "MASSAPEQUA FD CALL DISPATCH",

        "CALL:Investigation",
        "ADDR:1 SOUTHAMPTON DR",
        "CITY:MASSAPEQUA",
        "X:WARWICK DR",
        "MAP:H-4",
        "INFO:438");

    doTest("T9",
        "(MFD Dispatched Call (no subject)) Rescue: 515 HICKSVILLE RD, Town: MASS, Cross: BROOKLYN AVE, Map: B-5, Block#: 156-WEST, Time: 08:49:00\n\n" +
        "MASSAPEQUA FD CALL DISPATCH",

        "CALL:Rescue",
        "ADDR:515 HICKSVILLE RD",
        "CITY:MASSAPEQUA",
        "X:BROOKLYN AVE",
        "MAP:B-5",
        "INFO:156-WEST");

    doTest("T10",
        "(MFD Dispatched Call (no subject)) Rescue: 329 OCEAN AVE, Town: MPK, Cross: PITTSBURGH AVE, Map: F-3, Block#: 302-EAST, Time: 07:26:54\n\n" +
        "MASSAPEQUA FD CALL DISPATCH",

        "CALL:Rescue",
        "ADDR:329 OCEAN AVE",
        "CITY:MASSAPEQUA PARK",
        "X:PITTSBURGH AVE",
        "MAP:F-3",
        "INFO:302-EAST");

    doTest("T11",
        "(MFD Dispatched Call (no subject)) Rescue: 41 RIPPLEWATER AVE, Town: MASS, Cross: SOUTH BAY DRIVE, Map: G-9, Block#: 1026-WEST, Time: 20:58:22\n\n" +
        "MASSAPEQUA FD CALL DISPATCH",

        "CALL:Rescue",
        "ADDR:41 RIPPLEWATER AVE",
        "CITY:MASSAPEQUA",
        "X:SOUTH BAY DRIVE",
        "MAP:G-9",
        "INFO:1026-WEST");

    doTest("T12",
        "(MFD Dispatched Call (no subject)) Automatic Alarm: 5204 SUNRISE HWY, Town: MPK, Cross: UNQUA RD, Map: F-5, Block#: 528B-SOUTH, Time: 18:30:00\n\n" +
        "MASSAPEQUA FD CALL DISPATCH",

        "CALL:Automatic Alarm",
        "ADDR:5204 SUNRISE HWY",
        "CITY:MASSAPEQUA PARK",
        "X:UNQUA RD",
        "MAP:F-5",
        "INFO:528B-SOUTH");

    doTest("T13",
        "(MFD Dispatched Call (no subject)) Rescue: 323 BRENDAN AVE, Town: MASS, Cross: ARLYN DR WEST, Map: F-6, Block#: 544-SOUTH, Time: 17:39:41\n\n" +
        "MASSAPEQUA FD CALL DISPATCH",

        "CALL:Rescue",
        "ADDR:323 BRENDAN AVE",
        "CITY:MASSAPEQUA",
        "X:ARLYN DR WEST",
        "MAP:F-6",
        "INFO:544-SOUTH");

    doTest("T14",
        "(MFD Dispatched Call (no subject)) Rescue: 85 PHILADELPHIA AVE, Town: MPK, Cross: PENNSYLVANIA AVE, Map: F-5, Block#: 227-EAST, Time: 15:13:20\n\n" +
        "MASSAPEQUA FD CALL DISPATCH",

        "CALL:Rescue",
        "ADDR:85 PHILADELPHIA AVE",
        "CITY:MASSAPEQUA PARK",
        "X:PENNSYLVANIA AVE",
        "MAP:F-5",
        "INFO:227-EAST");

    doTest("T15",
        "(MFD Dispatched Call (no subject)) House Fire: 122 BEVERLY RD, Town: MASS, Cross: CABOT RD WEST, Map: C-9, Block#: 783-EAST, Time: 15:00:43\n\n" +
        "MASSAPEQUA FD CALL DISPATCH",

        "CALL:House Fire",
        "ADDR:122 BEVERLY RD",
        "CITY:MASSAPEQUA",
        "X:CABOT RD WEST",
        "MAP:C-9",
        "INFO:783-EAST");

    doTest("T16",
        "Special Call: 200 WESTFIELD MALL, Town: MASS, Cross: SUNRISE HWY, Map: G-5, Block#: 439-NORTH, Time: 17:42:51",
        "CALL:Special Call",
        "ADDR:200 WESTFIELD MALL",
        "MADDR:1 WESTFIELD MALL",
        "CITY:MASSAPEQUA",
        "X:SUNRISE HWY",
        "MAP:G-5",
        "INFO:439-NORTH");
   
  }
  
  public static void main(String[] args) {
    new NYNassauCountyMassepequaParserTest().generateTests("T1");
  }
}