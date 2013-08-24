package net.anei.cadpage.parsers.WV;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Morgan County, WV

Contact: Active911
Agency name: Morgan County EMS
Location: Berkeley Springs, WV, United States
Sender: MORGANCO911@FRONTIER.COM

(6BREPR>BREATHING PROBLEMS) 11:MORGANCO911@FRONTIER.COM:456 AUTUMN ACRES RD Apt: 213B Bldg XS: EDMINSTEN LN BERKELEY Map:2828 Grids:, Cad: 2013-0000001168
(114VD >VERBAL DOMESTIC) 3:MORGANCO911@FRONTIER.COM:1046 CLONE RUN RD XS: NORTHWOODS DR HEDGESVIL Map:2139 Grids:, Cad: 2013-0000001159
(17GLFA>GROUND LEVEL FALL) 10:MORGANCO911@FRONTIER.COM:3628 CHERRY RUN RD XS: CAMP HILL RD HEDGESVIL Map:70 Grids:, Cad: 2013-0000001158
(17GLFA>GROUND LEVEL FALL) 9:MORGANCO911@FRONTIER.COM:232 WINCHESTER ST Apt: H Bldg A PAW PAW Map:1854 Grids:, Cad: 2013-0000001146
(26SICK>SICK PERSON) 8:MORGANCO911@FRONTIER.COM:200 TITMOUSE LN XS: MICHAEL'S CHAPEL RD BERKELEY Map:751 Grids:, Cad: 2013-0000001137
(6BREPR>BREATHING PROBLEMS) 7:MORGANCO911@FRONTIER.COM:769 HARRISON AVE XS: JACOB ST BERKELEY Map:1008 Grids:, Cad: 2013-0000001134
(31UNCP>UNCONSCIOUS PERSON) 6:MORGANCO911@FRONTIER.COM:264 DUSTY LN XS: FULTON RD HEDGESVIL Map:2169 Grids:, Cad: 2013-0000001128
(Return Phone) 5:MORGANCO911@FRONTIER.COM:3042580305 ATTENTION MEMBERS OF COMPANY 7 THIS IS A TEST OF THE CAD PAGE SYSTEM. OPS 7 OR CHIEF 7 CONTACT MORGAN @ 304-258-0305
(291VA >1 VEHICLE ACCIDENT W/ INJURY) 2:MORGANCO911@FRONTIER.COM:496 SUGAR HOLLOW RD\nXS: ROBINWOOD LN\nBERKELEY\nMap:223 Grids:,\nCad: 2013-0000000900
(291VA >1 VEHICLE ACCIDENT W/ INJURY) 2:MORGANCO911@FRONTIER.COM:496 SUGAR HOLLOW RD XS: ROBINWOOD LN BERKELEY Map:223 Grids:, Cad: 2013-0000000900
(17GLFA>GROUND LEVEL FALL) 4:MORGANCO911@FRONTIER.COM:88 TRI-LAKE CT XS: SKYTOP LN BERKELEY Cad: 2013-0000000898
(71VEHC>VEHICLE FIRE) 3:MORGANCO911@FRONTIER.COM:TIMBER RIDGE RD&SALEM VIEW LN XS: SALEM VIEW LN BERKELEY Cad: 2013-0000000896
(10CHPN>CHEST PAIN) 2:MORGANCO911@FRONTIER.COM:320 BISER ST BERKELEY Map:639 Grids:, Cad: 2013-0000000887

Contact: Active911
Agency name: Morgan County EMS
Location: Berkeley Springs, WV, United States
Sender: MORGANCO911@FRONTIER.COM

(291VA >1 VEHICLE ACCIDENT W/ INJURY) 121:MORGANCO911@FRONTIER.COM:13000 WINCHESTER GRADE RD XS: WILDERNESS WAY BERKELEY Map:519 Grids:, Cad: 2013-0000003020
(291VA >1 VEHICLE ACCIDENT W/ INJURY) 27:MORGANCO911@FRONTIER.COM:6700 MARTINSBURG RD BERKELEY Map:3146 Grids:, Cad: 2013-0000003016
(6BREPR>BREATHING PROBLEMS) 120:MORGANCO911@FRONTIER.COM:11381 WINCHESTER GRADE RD XS: SHANGHAI RD BERKELEY Map:1498 Grids:, Cad: 2013-0000003014
(291VA >1 VEHICLE ACCIDENT W/ INJURY) 26:MORGANCO911@FRONTIER.COM:6776 MARTINSBURG RD BERKELEY Map:3146 Grids:, Cad: 2013-0000003009
(292VA >2 VEHICLE ACCIDENT W/ INJURY) 119:MORGANCO911@FRONTIER.COM:10500 MARTINSBURG RD XS: PIMLICO LN HEDGESVIL Map:1352 Grids:, Cad: 2013-0000003005
(121PSY>PSYCHOLOGICAL PROBLEMS) 118:MORGANCO911@FRONTIER.COM:44 MCCUSKER LN XS: PIOUS RIDGE RD BERKELEY Map:741 Grids:, Cad: 2013-0000003001
(292VA >2 VEHICLE ACCIDENT W/ INJURY) 25:MORGANCO911@FRONTIER.COM:HANCOCK RD XS: SAND MINE RD BERKELEY Map:1374 Grids:, Cad: 2013-0000002998
(291VA >1 VEHICLE ACCIDENT W/ INJURY) 24:MORGANCO911@FRONTIER.COM:3694 MARTINSBURG RD XS: DEFENSE DR BERKELEY Map:2724 Grids:, Cad: 2013-0000002996
(6BREPR>BREATHING PROBLEMS) 117:MORGANCO911@FRONTIER.COM:456 AUTUMN ACRES RD XS: EDMINSTEN LN BERKELEY Map:2828 Grids:, Cad: 2013-0000002994
(6BREPR>BREATHING PROBLEMS) 116:MORGANCO911@FRONTIER.COM:456 AUTUMN ACRES RD XS: EDMINSTEN LN BERKELEY Map:2828 Grids:, Cad: 2013-0000002987

*/

public class WVMorganCountyParserTest extends BaseParserTest {
  
  public WVMorganCountyParserTest() {
    setParser(new WVMorganCountyParser(), "MORGAN COUNTY", "WV");
  }
  
  @Test
  public void testMorganCountyEMS() {

    doTest("T1",
        "(6BREPR>BREATHING PROBLEMS) 11:MORGANCO911@FRONTIER.COM:456 AUTUMN ACRES RD Apt: 213B Bldg XS: EDMINSTEN LN BERKELEY Map:2828 Grids:, Cad: 2013-0000001168",
        "CODE:6BREPR",
        "CALL:BREATHING PROBLEMS",
        "ADDR:456 AUTUMN ACRES RD",
        "APT:213B Bldg",
        "X:EDMINSTEN LN",
        "CITY:BERKELEY SPRINGS",
        "MAP:2828",
        "ID:2013-0000001168");

    doTest("T2",
        "(114VD >VERBAL DOMESTIC) 3:MORGANCO911@FRONTIER.COM:1046 CLONE RUN RD XS: NORTHWOODS DR HEDGESVIL Map:2139 Grids:, Cad: 2013-0000001159",
        "CODE:114VD",
        "CALL:VERBAL DOMESTIC",
        "ADDR:1046 CLONE RUN RD",
        "X:NORTHWOODS DR",
        "CITY:HEDGESVILLE",
        "MAP:2139",
        "ID:2013-0000001159");

    doTest("T3",
        "(17GLFA>GROUND LEVEL FALL) 10:MORGANCO911@FRONTIER.COM:3628 CHERRY RUN RD XS: CAMP HILL RD HEDGESVIL Map:70 Grids:, Cad: 2013-0000001158",
        "CODE:17GLFA",
        "CALL:GROUND LEVEL FALL",
        "ADDR:3628 CHERRY RUN RD",
        "X:CAMP HILL RD",
        "CITY:HEDGESVILLE",
        "MAP:70",
        "ID:2013-0000001158");

    doTest("T4",
        "(17GLFA>GROUND LEVEL FALL) 9:MORGANCO911@FRONTIER.COM:232 WINCHESTER ST Apt: H Bldg A PAW PAW Map:1854 Grids:, Cad: 2013-0000001146",
        "CODE:17GLFA",
        "CALL:GROUND LEVEL FALL",
        "ADDR:232 WINCHESTER ST",
        "APT:H Bldg A",
        "CITY:PAW PAW",
        "MAP:1854",
        "ID:2013-0000001146");

    doTest("T5",
        "(26SICK>SICK PERSON) 8:MORGANCO911@FRONTIER.COM:200 TITMOUSE LN XS: MICHAEL'S CHAPEL RD BERKELEY Map:751 Grids:, Cad: 2013-0000001137",
        "CODE:26SICK",
        "CALL:SICK PERSON",
        "ADDR:200 TITMOUSE LN",  // Not found in Berkeley springs
        "X:MICHAEL'S CHAPEL RD",
        "CITY:BERKELEY SPRINGS",
        "MAP:751",
        "ID:2013-0000001137");

    doTest("T6",
        "(6BREPR>BREATHING PROBLEMS) 7:MORGANCO911@FRONTIER.COM:769 HARRISON AVE XS: JACOB ST BERKELEY Map:1008 Grids:, Cad: 2013-0000001134",
        "CODE:6BREPR",
        "CALL:BREATHING PROBLEMS",
        "ADDR:769 HARRISON AVE",
        "X:JACOB ST",
        "CITY:BERKELEY SPRINGS",
        "MAP:1008",
        "ID:2013-0000001134");

    doTest("T7",
        "(31UNCP>UNCONSCIOUS PERSON) 6:MORGANCO911@FRONTIER.COM:264 DUSTY LN XS: FULTON RD HEDGESVIL Map:2169 Grids:, Cad: 2013-0000001128",
        "CODE:31UNCP",
        "CALL:UNCONSCIOUS PERSON",
        "ADDR:264 DUSTY LN",
        "X:FULTON RD",
        "CITY:HEDGESVILLE",
        "MAP:2169",
        "ID:2013-0000001128");

    doTest("T9",
        "(291VA >1 VEHICLE ACCIDENT W/ INJURY) 2:MORGANCO911@FRONTIER.COM:496 SUGAR HOLLOW RD\n" +
        "XS: ROBINWOOD LN\n" +
        "BERKELEY\n" +
        "Map:223 Grids:,\n" +
        "Cad: 2013-0000000900",

        "CODE:291VA",
        "CALL:1 VEHICLE ACCIDENT W/ INJURY",
        "ADDR:496 SUGAR HOLLOW RD",
        "X:ROBINWOOD LN",
        "CITY:BERKELEY SPRINGS",
        "MAP:223",
        "ID:2013-0000000900");

    doTest("T10",
        "(291VA >1 VEHICLE ACCIDENT W/ INJURY) 2:MORGANCO911@FRONTIER.COM:496 SUGAR HOLLOW RD XS: ROBINWOOD LN BERKELEY Map:223 Grids:, Cad: 2013-0000000900",
        "CODE:291VA",
        "CALL:1 VEHICLE ACCIDENT W/ INJURY",
        "ADDR:496 SUGAR HOLLOW RD",
        "X:ROBINWOOD LN",
        "CITY:BERKELEY SPRINGS",
        "MAP:223",
        "ID:2013-0000000900");

    doTest("T11",
        "(17GLFA>GROUND LEVEL FALL) 4:MORGANCO911@FRONTIER.COM:88 TRI-LAKE CT XS: SKYTOP LN BERKELEY Cad: 2013-0000000898",
        "CODE:17GLFA",
        "CALL:GROUND LEVEL FALL",
        "ADDR:88 TRI-LAKE CT",
        "X:SKYTOP LN",
        "CITY:BERKELEY SPRINGS",
        "ID:2013-0000000898");

    doTest("T12",
        "(71VEHC>VEHICLE FIRE) 3:MORGANCO911@FRONTIER.COM:TIMBER RIDGE RD&SALEM VIEW LN XS: SALEM VIEW LN BERKELEY Cad: 2013-0000000896",
        "CODE:71VEHC",
        "CALL:VEHICLE FIRE",
        "ADDR:TIMBER RIDGE RD & SALEM VIEW LN",  // Not in Berkeley Springs
        "X:SALEM VIEW LN",
        "CITY:BERKELEY SPRINGS",
        "ID:2013-0000000896");

    doTest("T13",
        "(10CHPN>CHEST PAIN) 2:MORGANCO911@FRONTIER.COM:320 BISER ST BERKELEY Map:639 Grids:, Cad: 2013-0000000887",
        "CODE:10CHPN",
        "CALL:CHEST PAIN",
        "ADDR:320 BISER ST",
        "CITY:BERKELEY SPRINGS",
        "MAP:639",
        "ID:2013-0000000887");
  
  }
  
  @Test
  public void testMorganCountyEMS2() {

    doTest("T1",
        "(291VA >1 VEHICLE ACCIDENT W/ INJURY) 121:MORGANCO911@FRONTIER.COM:13000 WINCHESTER GRADE RD XS: WILDERNESS WAY BERKELEY Map:519 Grids:, Cad: 2013-0000003020",
        "CODE:291VA",
        "CALL:1 VEHICLE ACCIDENT W/ INJURY",
        "ADDR:13000 WINCHESTER GRADE RD",
        "X:WILDERNESS WAY",
        "CITY:BERKELEY SPRINGS",
        "MAP:519",
        "ID:2013-0000003020");

    doTest("T2",
        "(291VA >1 VEHICLE ACCIDENT W/ INJURY) 27:MORGANCO911@FRONTIER.COM:6700 MARTINSBURG RD BERKELEY Map:3146 Grids:, Cad: 2013-0000003016",
        "CODE:291VA",
        "CALL:1 VEHICLE ACCIDENT W/ INJURY",
        "ADDR:6700 MARTINSBURG RD",
        "CITY:BERKELEY SPRINGS",
        "MAP:3146",
        "ID:2013-0000003016");

    doTest("T3",
        "(6BREPR>BREATHING PROBLEMS) 120:MORGANCO911@FRONTIER.COM:11381 WINCHESTER GRADE RD XS: SHANGHAI RD BERKELEY Map:1498 Grids:, Cad: 2013-0000003014",
        "CODE:6BREPR",
        "CALL:BREATHING PROBLEMS",
        "ADDR:11381 WINCHESTER GRADE RD",
        "X:SHANGHAI RD",
        "CITY:BERKELEY SPRINGS",
        "MAP:1498",
        "ID:2013-0000003014");

    doTest("T4",
        "(291VA >1 VEHICLE ACCIDENT W/ INJURY) 26:MORGANCO911@FRONTIER.COM:6776 MARTINSBURG RD BERKELEY Map:3146 Grids:, Cad: 2013-0000003009",
        "CODE:291VA",
        "CALL:1 VEHICLE ACCIDENT W/ INJURY",
        "ADDR:6776 MARTINSBURG RD",
        "CITY:BERKELEY SPRINGS",
        "MAP:3146",
        "ID:2013-0000003009");

    doTest("T5",
        "(292VA >2 VEHICLE ACCIDENT W/ INJURY) 119:MORGANCO911@FRONTIER.COM:10500 MARTINSBURG RD XS: PIMLICO LN HEDGESVIL Map:1352 Grids:, Cad: 2013-0000003005",
        "CODE:292VA",
        "CALL:2 VEHICLE ACCIDENT W/ INJURY",
        "ADDR:10500 MARTINSBURG RD",
        "X:PIMLICO LN",
        "CITY:HEDGESVILLE",
        "MAP:1352",
        "ID:2013-0000003005");

    doTest("T6",
        "(121PSY>PSYCHOLOGICAL PROBLEMS) 118:MORGANCO911@FRONTIER.COM:44 MCCUSKER LN XS: PIOUS RIDGE RD BERKELEY Map:741 Grids:, Cad: 2013-0000003001",
        "CODE:121PSY",
        "CALL:PSYCHOLOGICAL PROBLEMS",
        "ADDR:44 MCCUSKER LN",
        "X:PIOUS RIDGE RD",
        "CITY:BERKELEY SPRINGS",
        "MAP:741",
        "ID:2013-0000003001");

    doTest("T7",
        "(292VA >2 VEHICLE ACCIDENT W/ INJURY) 25:MORGANCO911@FRONTIER.COM:HANCOCK RD XS: SAND MINE RD BERKELEY Map:1374 Grids:, Cad: 2013-0000002998",
        "CODE:292VA",
        "CALL:2 VEHICLE ACCIDENT W/ INJURY",
        "ADDR:HANCOCK RD",
        "MADDR:HANCOCK RD & SAND MINE RD",
        "X:SAND MINE RD",
        "CITY:BERKELEY SPRINGS",
        "MAP:1374",
        "ID:2013-0000002998");

    doTest("T8",
        "(291VA >1 VEHICLE ACCIDENT W/ INJURY) 24:MORGANCO911@FRONTIER.COM:3694 MARTINSBURG RD XS: DEFENSE DR BERKELEY Map:2724 Grids:, Cad: 2013-0000002996",
        "CODE:291VA",
        "CALL:1 VEHICLE ACCIDENT W/ INJURY",
        "ADDR:3694 MARTINSBURG RD",
        "X:DEFENSE DR",
        "CITY:BERKELEY SPRINGS",
        "MAP:2724",
        "ID:2013-0000002996");

    doTest("T9",
        "(6BREPR>BREATHING PROBLEMS) 117:MORGANCO911@FRONTIER.COM:456 AUTUMN ACRES RD XS: EDMINSTEN LN BERKELEY Map:2828 Grids:, Cad: 2013-0000002994",
        "CODE:6BREPR",
        "CALL:BREATHING PROBLEMS",
        "ADDR:456 AUTUMN ACRES RD",
        "X:EDMINSTEN LN",
        "CITY:BERKELEY SPRINGS",
        "MAP:2828",
        "ID:2013-0000002994");

    doTest("T10",
        "(6BREPR>BREATHING PROBLEMS) 116:MORGANCO911@FRONTIER.COM:456 AUTUMN ACRES RD XS: EDMINSTEN LN BERKELEY Map:2828 Grids:, Cad: 2013-0000002987",
        "CODE:6BREPR",
        "CALL:BREATHING PROBLEMS",
        "ADDR:456 AUTUMN ACRES RD",  // Google says this is not in Berkeley Springs
        "X:EDMINSTEN LN",
        "CITY:BERKELEY SPRINGS",
        "MAP:2828",
        "ID:2013-0000002987");
   
  }
  
  public static void main(String[] args) {
    new WVMorganCountyParserTest().generateTests("T1");
  }
}