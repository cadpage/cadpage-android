package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Harris County ESD #1, TX
Contact: glenn chisholm <glenn1736@gmail.com>
Sender: varies
System: Tritech

67B01U / GRASS/WOODS FIRE / 2418 LILY LN / APT: / BLD: / KM: 460T / XSTRTS: OLEANDER ST/WISTERIA WAY / Box #: 1705
Unknown Problem / 916 Jones Rd / APT: / BLD: / KM: 460S / XSTRTS: MIZELL ST/STEELE RD / Box #: 1704
29D02p / /Trans Incidents F/O / E Wallisville Rd / Thompson Rd / APT: / BLD: / KM: 460P / XSTRTS: / Box #: 1705
/ 10C01 / Pain (Non-Traumatic) / 9600 N MAIN ST / APT: / BLD: / KM: 461L / XSTRTS: E WALLISVILLE RD/FM 1942 / Box #: 1706
/ Unknown Problem / 916 Jones Rd / APT: / BLD: / KM: 460S / XSTRTS: MIZELL ST/STEELE RD / Box #: 1704
/ 28C09X / Stroke (CVA) / 2726 Waco / APT: / BLD: / KM: 460Y / XSTRTS: DALLAS ST/EAST ST / Box #: 1703
/ 31D03 /Fainting F/O / 409 W Wallisville Rd / APT: / BLD: / KM: 459Q / XSTRTS: N 5TH ST/N 4TH ST / Box #: 1705
/ 60B01 / /ODOR (NAT/LP GASES) / 617 Golden Bend Dr / APT: / BLD: / KM: 459M / XSTRTS: RED HAVEN DR/Dead End / Box #: 1701

Contact: Nathan Mathews <nbmathews807@gmail.com>
/11-05-15429 / 52C03S / 52O1 ALARMS / 16102 E Ih 10 / APT: / BLD: OLD RIVER TERRANCE M / KM: 498G / XSTRTS:IH 10 EAST BAYOU RAMP/IH 10 SH/ Box #:2002


Call times, should not be accepted
/ ID#:11-05-15563/ UNIT:E12 / DISP: 18:56:24 / ER: 18:57:10 / OUT: 19:03:05 / AIR: 19:11:31
ID#:11-06-20658/ UNIT:L32 / DISP: 08:23:43 / ER: 08:23:44 / OUT: / AIR: 08:27:16

Contact: Nathan Mathews <nbmathews807@gmail.com>
Sender: cadnoreply@proxy.hcec.com
22D05A / INDUSTRIAL ACCIDENT / S SHELDON/JACINTO PORT BLVD /APT: / BLD: / KM: 498U / XSTRTS: / CODE: / Box #: Nature:
29B04 / Traffic/Trans Incide / East Fwy/dell Dale /APT: / BLD: / KM: 497M / XSTRTS: / CODE: / Box #: Nature:

*/

public class TXHarrisCountyESD1AParserTest extends BaseParserTest {
  
  public TXHarrisCountyESD1AParserTest() {
    setParser(new TXHarrisCountyESD1AParser(), "HARRIS COUNTY", "TX");
  }
  
  @Test
  public void testBadMsg() {
    doBadTest("/ ID#:11-05-15563/ UNIT:E12 / DISP: 18:56:24 / ER: 18:57:10 / OUT: 19:03:05 / AIR: 19:11:31");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "67B01U / GRASS/WOODS FIRE / 2418 LILY LN / APT: / BLD: / KM: 460T / XSTRTS: OLEANDER ST/WISTERIA WAY / Box #: 1705",
        "CODE:67B01U",
        "CALL:GRASS/WOODS FIRE",
        "ADDR:2418 LILY LN",
        "MAP:460T",
        "X:OLEANDER ST/WISTERIA WAY",
        "BOX:1705");

    doTest("T2",
        "Unknown Problem / 916 Jones Rd / APT: / BLD: / KM: 460S / XSTRTS: MIZELL ST/STEELE RD / Box #: 1704",
        "CALL:Unknown Problem",
        "ADDR:916 Jones Rd",
        "MAP:460S",
        "X:MIZELL ST/STEELE RD",
        "BOX:1704");

    doTest("T3",
        "29D02p / /Trans Incidents F/O / E Wallisville Rd / Thompson Rd / APT: / BLD: / KM: 460P / XSTRTS: / Box #: 1705",
        "CODE:29D02p",
        "CALL:Trans Incidents F/O",
        "ADDR:E Wallisville Rd & Thompson Rd",
        "MAP:460P",
        "BOX:1705");

    doTest("T4",
        "/ 10C01 / Pain (Non-Traumatic) / 9600 N MAIN ST / APT: / BLD: / KM: 461L / XSTRTS: E WALLISVILLE RD/FM 1942 / Box #: 1706",
        "CODE:10C01",
        "CALL:Pain (Non-Traumatic)",
        "ADDR:9600 N MAIN ST",
        "MAP:461L",
        "X:E WALLISVILLE RD/FM 1942",
        "BOX:1706");

    doTest("T5",
        "/ Unknown Problem / 916 Jones Rd / APT: / BLD: / KM: 460S / XSTRTS: MIZELL ST/STEELE RD / Box #: 1704",
        "CALL:Unknown Problem",
        "ADDR:916 Jones Rd",
        "MAP:460S",
        "X:MIZELL ST/STEELE RD",
        "BOX:1704");

    doTest("T6",
        "/ 28C09X / Stroke (CVA) / 2726 Waco / APT: / BLD: / KM: 460Y / XSTRTS: DALLAS ST/EAST ST / Box #: 1703",
        "CODE:28C09X",
        "CALL:Stroke (CVA)",
        "ADDR:2726 Waco",
        "MAP:460Y",
        "X:DALLAS ST/EAST ST",
        "BOX:1703");

    doTest("T7",
        "/ 31D03 /Fainting F/O / 409 W Wallisville Rd / APT: / BLD: / KM: 459Q / XSTRTS: N 5TH ST/N 4TH ST / Box #: 1705",
        "CODE:31D03",
        "CALL:Fainting F/O",
        "ADDR:409 W Wallisville Rd",
        "MAP:459Q",
        "X:N 5TH ST/N 4TH ST",
        "BOX:1705");

    doTest("T8",
        "/ 60B01 / /ODOR (NAT/LP GASES) / 617 Golden Bend Dr / APT: / BLD: / KM: 459M / XSTRTS: RED HAVEN DR/Dead End / Box #: 1701",
        "CODE:60B01",
        "CALL:ODOR (NAT/LP GASES)",
        "ADDR:617 Golden Bend Dr",
        "MAP:459M",
        "X:RED HAVEN DR/Dead End",
        "BOX:1701");

    doTest("T9",
        "/11-05-15429 / 52C03S / 52O1 ALARMS / 16102 E Ih 10 / APT: / BLD: OLD RIVER TERRANCE M / KM: 498G / XSTRTS:IH 10 EAST BAYOU RAMP/IH 10 SH/ Box #:2002",
        "ID:11-05-15429",
        "CODE:52C03S",
        "CALL:52O1 ALARMS",
        "ADDR:16102 E Ih 10",
        "APT:OLD RIVER TERRANCE M",
        "MAP:498G",
        "X:IH 10 EAST BAYOU RAMP/IH 10 SH",
        "BOX:2002");

    doTest("T10",
        "22D05A / INDUSTRIAL ACCIDENT / S SHELDON/JACINTO PORT BLVD /APT: / BLD: / KM: 498U / XSTRTS: / CODE: / Box #: Nature:",
        "CODE:22D05A",
        "CALL:INDUSTRIAL ACCIDENT",
        "ADDR:S SHELDON & JACINTO PORT BLVD",
        "MAP:498U",
        "BOX:Nature:");

    doTest("T11",
        "29B04 / Traffic/Trans Incide / East Fwy/dell Dale /APT: / BLD: / KM: 497M / XSTRTS: / CODE: / Box #: Nature:",
        "CODE:29B04",
        "CALL:Traffic/Trans Incide",
        "ADDR:East Fwy & dell Dale",
        "MAP:497M",
        "BOX:Nature:");
   
  }

public static void main(String[] args) {
    new TXHarrisCountyESD1AParserTest().generateTests("T10");
  }

}