package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Prince Georges County, MD
Contact: Randy Kuenzli <chief9.rk@gmail.com>
Contact: Dewey Thomas <dewey@codemessaging.net>

[PG09] 9: OUTSIDE GAS LEAK  At: 04/12 10:12  Dispatch: E809  All: E809  To: BLADENSBURG ELEMENTARY
[PG09] 9: ROUTINE TRANSPORT  At: 04/13 07:23  Backup: A809  All: A809  To: PGGH - HOSPITAL  
[PG09] 13: MEDIC LOCAL\nAt: 04/12 20:34\nDispatch: A809\nAll: E807 MD830 A809\nTo: 5435 KENILWORTH AVE (KENNEDY ST and JEFFERSON ST)
[PG09] 13: PIA\nAt: 04/12 19:37\nDispatch: A809\nAll: A809 E807\nTo: EB RIVERDALE RD/EB NB KENILWORTH AVE OFRP EB EAST WEST HWY
[PG09] 8: INJURED/SICK\nAt: 04/12 18:46\nDispatch: A809\nAll: A809\nTo: 1 YOST PL (ALPACA PL and EAST CAPITOL ST)
[PG09] 9: ASSAULT\nAt: 04/12 12:04\nDispatch: A809\nAll: A809\nTo: 55TH AVE/EB LANDOVER RD
[PG09] 9: OUTSIDE GAS LEAK\nAt: 04/12 10:12\nDispatch: E809\nAll: E809\nTo: BLADENSBURG ELEMENTARY
[PG09] 9: MEDIC LOCAL\nAt: 04/12 10:02\nDispatch: A809\nAll: A809 MD830\nTo: PORT TOWNS ELEMENTARY
[PG09] 9: OUTSIDE GAS LEAK\nAt: 04/12 09:20\nDispatch: E809\nAll: E809\nTo: BLADENSBURG ELEMENTARY
[PG09] 9: INJURED/SICK\nAt: 04/12 04:42\nDispatch: A809\nAll: A809\nTo: 6001 LOGAN WAY #C10 (EMERSON ST and TOWNSEND WAY)
[PG09] 28: BUILDING FIRE\nAt: 04/12 00:12\nDispatch: TK809 BO882\nAll: E828 PE830 E833 E833B TW833 TK809 SQ806 BO882\nTo: 8500 ANNAPOLIS RD
[PG09] 13: STREET ALARM  At: 04/13 12:37  Dispatch: TK809 BO884  All: E807 TK809 E807B TK801 BO884  To: 5906 62ND AVE (GREENVALE PKY and 64TH AVE)  
(CAD)[PG09] 12: BUILDING FIRE  At: 07/17 20:50  Dispatch: E809 BO884  All: E812 TK812 E811 TK814 E807B TK801 E809 BO884  To: 5211 PAINT BRANCH PKY (52ND AVE and RIVERSIDE AVE)  
[CAD][PG09] 9: MEDIC LOCAL  At: 08/09 19:14  Dispatch: E809B  All: E809B MD830 A855  To: 5804 ANNAPOLIS RD #1014  
[PG09] 9: MEDIC LOCAL  At: 08/29 19:25  Dispatch: E809B  All: E809B MD812 A807  To: 4516 BUCHANAN ST (BALTIMORE AVE and END)  
(CAD) [PG09] 38: MEDIC LOCAL\r\nAt: 09/09 17:06\r\nDispatch: A809\r\nAll: E838 MD826 A809\r\nTo: EB JOHN HANSON HWY EB AT EB COLUMBIA PARK RD
[PG09] 9: PIA  At: 10/19 10:11  Dispatch: A809 E809C  All: A809 E809C  To: EB LANDOVER RD/NB BALTIMORE WASHINGTON PKY NB  

*/

public class MDPrinceGeorgesCountyDParserTest extends BaseParserTest {
  
  public MDPrinceGeorgesCountyDParserTest() {
    setParser(new MDPrinceGeorgesCountyDParser(), "PRINCE GEORGES COUNTY", "MD");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "[PG09] 9: OUTSIDE GAS LEAK  At: 04/12 10:12  Dispatch: E809  All: E809  To: BLADENSBURG ELEMENTARY",
        "SRC:PG09",
        "CALL:OUTSIDE GAS LEAK",
        "DATE:04/12",
        "TIME:10:12",
        "UNIT:E809",
        "ADDR:BLADENSBURG ELEMENTARY");

    doTest("T2",
        "[PG09] 9: ROUTINE TRANSPORT  At: 04/13 07:23  Backup: A809  All: A809  To: PGGH - HOSPITAL  ",
        "SRC:PG09",
        "CALL:ROUTINE TRANSPORT",
        "DATE:04/13",
        "TIME:07:23",
        "UNIT:A809",
        "ADDR:PGGH - HOSPITAL");

    doTest("T3",
        "[PG09] 13: MEDIC LOCAL\nAt: 04/12 20:34\nDispatch: A809\nAll: E807 MD830 A809\nTo: 5435 KENILWORTH AVE (KENNEDY ST and JEFFERSON ST)",
        "SRC:PG09",
        "CALL:MEDIC LOCAL",
        "DATE:04/12",
        "TIME:20:34",
        "UNIT:E807 MD830 A809",
        "ADDR:5435 KENILWORTH AVE",
        "X:KENNEDY ST and JEFFERSON ST");

    doTest("T4",
        "[PG09] 13: PIA\nAt: 04/12 19:37\nDispatch: A809\nAll: A809 E807\nTo: EB RIVERDALE RD/EB NB KENILWORTH AVE OFRP EB EAST WEST HWY",
        "SRC:PG09",
        "CALL:PIA",
        "DATE:04/12",
        "TIME:19:37",
        "UNIT:A809 E807",
        "ADDR:EB RIVERDALE RD & EB NB KENILWORTH AVE OFRP EB EAST WEST HWY",
        "MADDR:RIVERDALE RD & KENILWORTH AVE");

    doTest("T5",
        "[PG09] 8: INJURED/SICK\nAt: 04/12 18:46\nDispatch: A809\nAll: A809\nTo: 1 YOST PL (ALPACA PL and EAST CAPITOL ST)",
        "SRC:PG09",
        "CALL:INJURED/SICK",
        "DATE:04/12",
        "TIME:18:46",
        "UNIT:A809",
        "ADDR:1 YOST PL",
        "X:ALPACA PL and EAST CAPITOL ST");

    doTest("T6",
        "[PG09] 9: ASSAULT\nAt: 04/12 12:04\nDispatch: A809\nAll: A809\nTo: 55TH AVE/EB LANDOVER RD",
        "SRC:PG09",
        "CALL:ASSAULT",
        "DATE:04/12",
        "TIME:12:04",
        "UNIT:A809",
        "ADDR:55TH AVE & EB LANDOVER RD",
        "MADDR:55TH AVE & LANDOVER RD");

    doTest("T7",
        "[PG09] 9: OUTSIDE GAS LEAK\nAt: 04/12 10:12\nDispatch: E809\nAll: E809\nTo: BLADENSBURG ELEMENTARY",
        "SRC:PG09",
        "CALL:OUTSIDE GAS LEAK",
        "DATE:04/12",
        "TIME:10:12",
        "UNIT:E809",
        "ADDR:BLADENSBURG ELEMENTARY");

    doTest("T8",
        "[PG09] 9: MEDIC LOCAL\nAt: 04/12 10:02\nDispatch: A809\nAll: A809 MD830\nTo: PORT TOWNS ELEMENTARY",
        "SRC:PG09",
        "CALL:MEDIC LOCAL",
        "DATE:04/12",
        "TIME:10:02",
        "UNIT:A809 MD830",
        "ADDR:PORT TOWNS ELEMENTARY");

    doTest("T9",
        "[PG09] 9: OUTSIDE GAS LEAK\nAt: 04/12 09:20\nDispatch: E809\nAll: E809\nTo: BLADENSBURG ELEMENTARY",
        "SRC:PG09",
        "CALL:OUTSIDE GAS LEAK",
        "DATE:04/12",
        "TIME:09:20",
        "UNIT:E809",
        "ADDR:BLADENSBURG ELEMENTARY");

    doTest("T10",
        "[PG09] 9: INJURED/SICK\nAt: 04/12 04:42\nDispatch: A809\nAll: A809\nTo: 6001 LOGAN WAY #C10 (EMERSON ST and TOWNSEND WAY)",
        "SRC:PG09",
        "CALL:INJURED/SICK",
        "DATE:04/12",
        "TIME:04:42",
        "UNIT:A809",
        "ADDR:6001 LOGAN WAY",
        "APT:C10",
        "X:EMERSON ST and TOWNSEND WAY");

    doTest("T11",
        "[PG09] 28: BUILDING FIRE\n" +
        "At: 04/12 00:12\n" +
        "Dispatch: TK809 BO882\n" +
        "All: E828 PE830 E833 E833B TW833 TK809 SQ806 BO882\n" +
        "To: 8500 ANNAPOLIS RD",

        "SRC:PG09",
        "CALL:BUILDING FIRE",
        "DATE:04/12",
        "TIME:00:12",
        "UNIT:E828 PE830 E833 E833B TW833 TK809 SQ806 BO882",
        "ADDR:8500 ANNAPOLIS RD");

    doTest("T12",
        "[PG09] 13: STREET ALARM  At: 04/13 12:37  Dispatch: TK809 BO884  All: E807 TK809 E807B TK801 BO884  To: 5906 62ND AVE (GREENVALE PKY and 64TH AVE)  ",
        "SRC:PG09",
        "CALL:STREET ALARM",
        "DATE:04/13",
        "TIME:12:37",
        "UNIT:E807 TK809 E807B TK801 BO884",
        "ADDR:5906 62ND AVE",
        "X:GREENVALE PKY and 64TH AVE");

    doTest("T13",
        "(CAD)[PG09] 12: BUILDING FIRE  At: 07/17 20:50  Dispatch: E809 BO884  All: E812 TK812 E811 TK814 E807B TK801 E809 BO884  To: 5211 PAINT BRANCH PKY (52ND AVE and RIVERSIDE AVE)  ",
        "SRC:PG09",
        "CALL:BUILDING FIRE",
        "DATE:07/17",
        "TIME:20:50",
        "UNIT:E812 TK812 E811 TK814 E807B TK801 E809 BO884",
        "ADDR:5211 PAINT BRANCH PKY",
        "MADDR:5211 PAINT BRANCH PKWY",
        "X:52ND AVE and RIVERSIDE AVE");

    doTest("T14",
        "[CAD][PG09] 9: MEDIC LOCAL  At: 08/09 19:14  Dispatch: E809B  All: E809B MD830 A855  To: 5804 ANNAPOLIS RD #1014  ",
        "SRC:PG09",
        "CALL:MEDIC LOCAL",
        "DATE:08/09",
        "TIME:19:14",
        "UNIT:E809B MD830 A855",
        "ADDR:5804 ANNAPOLIS RD",
        "APT:1014");

    doTest("T15",
        "[PG09] 9: MEDIC LOCAL  At: 08/29 19:25  Dispatch: E809B  All: E809B MD812 A807  To: 4516 BUCHANAN ST (BALTIMORE AVE and END)  ",
        "SRC:PG09",
        "CALL:MEDIC LOCAL",
        "DATE:08/29",
        "TIME:19:25",
        "UNIT:E809B MD812 A807",
        "ADDR:4516 BUCHANAN ST",
        "X:BALTIMORE AVE and END");

    doTest("T16",
        "(CAD) [PG09] 38: MEDIC LOCAL\r\n" +
        "At: 09/09 17:06\r\n" +
        "Dispatch: A809\r\n" +
        "All: E838 MD826 A809\r\n" +
        "To: EB JOHN HANSON HWY EB AT EB COLUMBIA PARK RD",

        "SRC:PG09",
        "CALL:MEDIC LOCAL",
        "DATE:09/09",
        "TIME:17:06",
        "UNIT:E838 MD826 A809",
        "ADDR:EB JOHN HANSON HWY EB AT EB COLUMBIA PARK RD",
        "MADDR:JOHN HANSON HWY AT COLUMBIA PARK RD");

    doTest("T17",
        "[PG09] 9: PIA  At: 10/19 10:11  Dispatch: A809 E809C  All: A809 E809C  To: EB LANDOVER RD/NB BALTIMORE WASHINGTON PKY NB  ",
        "SRC:PG09",
        "CALL:PIA",
        "DATE:10/19",
        "TIME:10:11",
        "UNIT:A809 E809C",
        "ADDR:EB LANDOVER RD & NB BALTIMORE WASHINGTON PKY NB",
        "MADDR:LANDOVER RD & BALTIMORE WASHINGTON PKWY");

 }
  
  public static void main(String[] args) {
    new MDPrinceGeorgesCountyDParserTest().generateTests("T1");
  }
}