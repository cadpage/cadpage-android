package net.anei.cadpage.parsers.WA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/**
Pierce County, WA (variant B)
Contact: swampjeep01 <swampjeep01@gmail.com>
Sender: 41411

FIRE911\n\n31D3 @ 16:57:29\nDLOC\n6505 CLIFF AV KS,16\nMap=300,RD=16- 400\nto: F16\n\nPowered by m.textmarks.com\n\n*Psoriasis treatment option http://4in.fo/gP_Gbw
FIRE911\n\n26C1 @ 02:48:37\nALTERED LOC\n2627 200TH AV KS,16\nMap=195,RD=16- 320\nto: F16\n\nPowered by m.textmarks.com
FIRE911\n\n19C7 @ 11:23:01\nHEART PROB\n19515 28TH ST KS,16\nMap=195,RD=16- 320\nto: F16\n\nPowered by m.textmarks.com
FIRE911\n\n26B1 @ 14:42:53\nWELFARE CHECK\n14201 134TH ST KN,16\nMap=18,RD=16- 500\nto: F16\n\nPowered by m.textmarks.com

Contact: Vance Mettlen <fireeater73@gmail.com>
Sender: 41411

UNCON1 @ 14:56:01\r\nWOMAN ILL\r\n7308 142ND AV E #A, 22\r\nMap=322,RD=22- 134\r\nto: F22
SICK2 @ 13:06:02\r\nWOMAN ILL\r\n26408 112TH ST E, 22\r\nMap=452,RD=22- 162\r\nto: F22
CHEST1 @ 13:25:10\r\nMAN ILL\r\n13349 PRAIRIE RIDGE DR E, 22\r\nMap=503,RD=22- 121\r\nto: F22
SICK2 @ 13:06:02\r\nUnknown Medical\r\n26408 112TH ST E, 22\r\nMap=452,RD=22- 162\r\nto: F22
67D3 @ 12:35:32\r\nLRG OUTSIDE FIRE\r\n2017 217TH AVCT E, 22\r\nMap=226,RD=22- 151\r\nto: F22
CVA ¡ 12:30:27\nPOSS CVA\n5625 159TH AVCT E, 22\nMap=291,RD=22- 133\nto: F22
SZR1 ¡         \nSeizure\n\nMap=,RD=22- 181\nto: F22

Contact: rmbylin@yahoo.com <rmbylin@yahoo.com>
Sender: 41411
CVA @ 13:50:38\nCVA\n15519 62ND STCT E #215, 22\nMap=290,RD=22- 133\nto: F22
 
 */

public class WAPierceCountyBParserTest extends BaseParserTest {
  
  public WAPierceCountyBParserTest() {
    setParser(new WAPierceCountyBParser(), "PIERCE COUNTY", "WA");
  }
  
  @Test
  public void testSwampJeep() {

    doTest("T1",
        "FIRE911\n\n" +
        "31D3 @ 16:57:29\n" +
        "DLOC\n" +
        "6505 CLIFF AV KS,16\n" +
        "Map=300,RD=16- 400\n" +
        "to: F16\n\n" +
        "Powered by m.textmarks.com\n\n" +
        "*Psoriasis treatment option http://4in.fo/gP_Gbw",

        "CODE:31D3",
        "TIME:16:57:29",
        "CALL:DLOC",
        "ADDR:6505 CLIFF AV KS",
        "MADDR:6505 CLIFF AVE KP S",
        "MAP:Map=300,RD=16- 400",
        "UNIT:F16");

    doTest("T2",
        "FIRE911\n\n26C1 @ 02:48:37\nALTERED LOC\n2627 200TH AV KS,16\nMap=195,RD=16- 320\nto: F16\n\nPowered by m.textmarks.com",
        "CODE:26C1",
        "TIME:02:48:37",
        "CALL:ALTERED LOC",
        "ADDR:2627 200TH AV KS",
        "MADDR:2627 200TH AVE KP S",
        "MAP:Map=195,RD=16- 320",
        "UNIT:F16");

    doTest("T3",
        "FIRE911\n\n19C7 @ 11:23:01\nHEART PROB\n19515 28TH ST KS,16\nMap=195,RD=16- 320\nto: F16\n\nPowered by m.textmarks.com",
        "CODE:19C7",
        "TIME:11:23:01",
        "CALL:HEART PROB",
        "ADDR:19515 28TH ST KS",
        "MADDR:19515 28TH ST KP S",
        "MAP:Map=195,RD=16- 320",
        "UNIT:F16");

    doTest("T4",
        "FIRE911\n\n26B1 @ 14:42:53\nWELFARE CHECK\n14201 134TH ST KN,16\nMap=18,RD=16- 500\nto: F16\n\nPowered by m.textmarks.com",
        "CODE:26B1",
        "TIME:14:42:53",
        "CALL:WELFARE CHECK",
        "ADDR:14201 134TH ST KN",
        "MADDR:14201 134TH ST KP N",
        "MAP:Map=18,RD=16- 500",
        "UNIT:F16");

  }
  
  @Test
  public void testVanceMettlen() {

    doTest("T1",
        "UNCON1 @ 14:56:01\r\nWOMAN ILL\r\n7308 142ND AV E #A, 22\r\nMap=322,RD=22- 134\r\nto: F22",
        "CODE:UNCON1",
        "TIME:14:56:01",
        "CALL:WOMAN ILL",
        "ADDR:7308 142ND AV E",
        "MADDR:7308 142ND AVE E",
        "APT:A",
        "MAP:Map=322,RD=22- 134",
        "UNIT:F22");

    doTest("T2",
        "SICK2 @ 13:06:02\r\nWOMAN ILL\r\n26408 112TH ST E, 22\r\nMap=452,RD=22- 162\r\nto: F22",
        "CODE:SICK2",
        "TIME:13:06:02",
        "CALL:WOMAN ILL",
        "ADDR:26408 112TH ST E",
        "MAP:Map=452,RD=22- 162",
        "UNIT:F22");

    doTest("T3",
        "CHEST1 @ 13:25:10\r\nMAN ILL\r\n13349 PRAIRIE RIDGE DR E, 22\r\nMap=503,RD=22- 121\r\nto: F22",
        "CODE:CHEST1",
        "TIME:13:25:10",
        "CALL:MAN ILL",
        "ADDR:13349 PRAIRIE RIDGE DR E",
        "MAP:Map=503,RD=22- 121",
        "UNIT:F22");

    doTest("T4",
        "SICK2 @ 13:06:02\r\nUnknown Medical\r\n26408 112TH ST E, 22\r\nMap=452,RD=22- 162\r\nto: F22",
        "CODE:SICK2",
        "TIME:13:06:02",
        "CALL:Unknown Medical",
        "ADDR:26408 112TH ST E",
        "MAP:Map=452,RD=22- 162",
        "UNIT:F22");

    doTest("T5",
        "67D3 @ 12:35:32\r\nLRG OUTSIDE FIRE\r\n2017 217TH AVCT E, 22\r\nMap=226,RD=22- 151\r\nto: F22",
        "CODE:67D3",
        "TIME:12:35:32",
        "CALL:LRG OUTSIDE FIRE",
        "ADDR:2017 217TH AVCT E",
        "MADDR:2017 217TH AVE CT E",
        "MAP:Map=226,RD=22- 151",
        "UNIT:F22");

    doTest("T6",
        "CVA ¡ 12:30:27\nPOSS CVA\n5625 159TH AVCT E, 22\nMap=291,RD=22- 133\nto: F22",
        "CODE:CVA",
        "TIME:12:30:27",
        "CALL:POSS CVA",
        "ADDR:5625 159TH AVCT E",
        "MADDR:5625 159TH AVE CT E",
        "MAP:Map=291,RD=22- 133",
        "UNIT:F22");

    doTest("T7",
        "SZR1 ¡         \nSeizure\n\nMap=,RD=22- 181\nto: F22",
        "CODE:SZR1",
        "CALL:Seizure",
        "MAP:Map=,RD=22- 181",
        "UNIT:F22");
 
  }
  
  @Test
  public void testMybrlin() {

    doTest("T1",
        "CVA @ 13:50:38\nCVA\n15519 62ND STCT E #215, 22\nMap=290,RD=22- 133\nto: F22",
        "CODE:CVA",
        "TIME:13:50:38",
        "CALL:CVA",
        "ADDR:15519 62ND STCT E",
        "APT:215",
        "MAP:Map=290,RD=22- 133",
        "UNIT:F22");
  
  }
  
  public static void main(String[] args) {
    new WAPierceCountyBParserTest().generateTests("T1");
  }
}