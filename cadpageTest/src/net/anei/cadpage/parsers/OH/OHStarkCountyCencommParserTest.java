package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHStarkCountyCencommParserTest extends BaseParserTest {
  
  public OHStarkCountyCencommParserTest() {
    setParser(new OHStarkCountyCencommParser(), "STARK COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(FIRES CALLS) CFFD:2012:306\nDISPATCHED\nMEDALS\n80, THOMAS BL ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:306",
        "CALL:MEDALS",
        "ADDR:80 THOMAS BL",
        "CITY:LAWRENCE TWP");

    doTest("T2",
        "(FIRES CALLS) CFFD:2012:307\nDISPATCHED\nMEDALS\n1165, S LOCUST ST ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:307",
        "CALL:MEDALS",
        "ADDR:1165 S LOCUST ST",
        "CITY:CANAL FULTON");

    doTest("T3",
        "(FIRES CALLS) CFFD:2012:308\nDISPATCHED\nMEDALS\n581, BEVERLY AV ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:308",
        "CALL:MEDALS",
        "ADDR:581 BEVERLY AV",
        "MADDR:581 BEVERLY AVE",
        "CITY:CANAL FULTON");

    doTest("T4",
        "(FIRES CALLS) CFFD:2012:309\nDISPATCHED\nMEDALS\n8757, SPRING GROVE AV NW ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:309",
        "CALL:MEDALS",
        "ADDR:8757 SPRING GROVE AV NW",
        "MADDR:8757 SPRING GROVE AVE NW",
        "CITY:LAWRENCE TWP");

    doTest("T5",
        "(FIRES CALLS) CFFD:2012:329\nDISPATCHED\nMEDALS\n14602, ARCADIA ST NW ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:329",
        "CALL:MEDALS",
        "ADDR:14602 ARCADIA ST NW",
        "CITY:LAWRENCE TWP");

    doTest("T6",
        "(FIRES CALLS) CFFD:2012:324\nDISPATCHED\nMEDALS\n581, BEVERLY AV ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:324",
        "CALL:MEDALS",
        "ADDR:581 BEVERLY AV",
        "MADDR:581 BEVERLY AVE",
        "CITY:CANAL FULTON");

    doTest("T7",
        "(FIRES CALLS) CFFD:2012:325\nDISPATCHED\nODORRES\n808, DENSHIRE DR NW ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:325",
        "CALL:ODORRES",
        "ADDR:808 DENSHIRE DR NW",
        "CITY:CANAL FULTON");

    doTest("T8",
        "(FIRES CALLS) CFFD:2012:326\nDISPATCHED\nMEDALS\n10751, JOHNSTON ST NW ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:326",
        "CALL:MEDALS",
        "ADDR:10751 JOHNSTON ST NW",
        "CITY:LAWRENCE TWP");

    doTest("T9",
        "(FIRES CALLS) CFFD:2012:327\nDISPATCHED\nMEDALS\n5622, CUTTEN AV NW ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:327",
        "CALL:MEDALS",
        "ADDR:5622 CUTTEN AV NW",
        "MADDR:5622 CUTTEN AVE NW",
        "CITY:LAWRENCE TWP");

    doTest("T10",
        "(FIRES CALLS) CFFD:2012:315\nDISPATCHED\nMEDALS\n700, BEVERLY AV ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:315",
        "CALL:MEDALS",
        "ADDR:700 BEVERLY AV",
        "MADDR:700 BEVERLY AVE",
        "CITY:CANAL FULTON");

    doTest("T11",
        "(FIRES CALLS) CFFD:2012:322\nDISPATCHED\nMVAINJ\n3971, MANCHESTER AV NW ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:322",
        "CALL:MVAINJ",
        "ADDR:3971 MANCHESTER AV NW",
        "MADDR:3971 MANCHESTER AVE NW",
        "CITY:LAWRENCE TWP");

    doTest("T12",
        "(FIRES CALLS) CFFD:2012:323\nDISPATCHED\nMEDALS\n659, LAKEVIEW DR ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:323",
        "CALL:MEDALS",
        "ADDR:659 LAKEVIEW DR",
        "CITY:CANAL FULTON");

    doTest("T13",
        "(FIRES CALLS) CFFD:2012:318\nDISPATCHED\nRESFIRE\n3283, YOUNG AV NW ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:318",
        "CALL:RESFIRE",
        "ADDR:3283 YOUNG AV NW",
        "MADDR:3283 YOUNG AVE NW",
        "CITY:LAWRENCE TWP");

    doTest("T14",
        "(FIRES CALLS) CFFD:2012:314\nDISPATCHED\nMEDALS\n10405, STRAUSSER ST NW ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:314",
        "CALL:MEDALS",
        "ADDR:10405 STRAUSSER ST NW",
        "CITY:LAWRENCE TWP");

    doTest("T15",
        "(FIRES CALLS) CFFD:2012:314\nDISPATCHED\nMEDALS\n10405, STRAUSSER ST NW ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:314",
        "CALL:MEDALS",
        "ADDR:10405 STRAUSSER ST NW",
        "CITY:LAWRENCE TWP");

    doTest("T16",
        "(FIRES CALLS) CFFD:2012:306\nDISPATCHED\nMEDALS\n80, THOMAS BL ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:306",
        "CALL:MEDALS",
        "ADDR:80 THOMAS BL",
        "CITY:LAWRENCE TWP");

    doTest("T17",
        "(FIRES CALLS) CFFD:2012:313\nDISPATCHED\nMEDALS\n318, N CANAL ST ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:313",
        "CALL:MEDALS",
        "ADDR:318 N CANAL ST",
        "CITY:CANAL FULTON");

    doTest("T18",
        "(FIRES CALLS) CFFD:2012:317\nDISPATCHED\nMEDALS\n447, CHIPPEWA ST ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:317",
        "CALL:MEDALS",
        "ADDR:447 CHIPPEWA ST",
        "CITY:CANAL FULTON");

    doTest("T19",
        "(FIRES CALLS) CFFD:2012:311\nDISPATCHED\nMEDALS\n843, BASSWOOD AV ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:311",
        "CALL:MEDALS",
        "ADDR:843 BASSWOOD AV",
        "MADDR:843 BASSWOOD AVE",
        "CITY:CANAL FULTON");

    doTest("T20",
        "(FIRES CALLS) CFFD:2012:320\nDISPATCHED\nMEDALS\n13374, BLUFTON NW",
        "SRC:CFFD",
        "ID:2012:320",
        "CALL:MEDALS",
        "ADDR:13374 BLUFTON NW");

    doTest("T21",
        "(FIRES CALLS) CFFD:2012:321\nDISPATCHED\nMEDALS\n10388, STONEACRE ST NW ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:321",
        "CALL:MEDALS",
        "ADDR:10388 STONEACRE ST NW",
        "CITY:LAWRENCE TWP");

    doTest("T22",
        "(FIRES CALLS) CFFD:2012:320\nDISPATCHED\nMEDALS\n13374, BLUFTON NW",
        "SRC:CFFD",
        "ID:2012:320",
        "CALL:MEDALS",
        "ADDR:13374 BLUFTON NW");

    doTest("T23",
        "(FIRES CALLS) CFFD:2012:316\nDISPATCHED\nMEDALS\n8, MICHAEL CIR ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:316",
        "CALL:MEDALS",
        "ADDR:8 MICHAEL CIR",
        "CITY:LAWRENCE TWP");

    doTest("T24",
        "(FIRES CALLS) CFFD:2012:307\nDISPATCHED\nMEDALS\n1165, S LOCUST ST ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:307",
        "CALL:MEDALS",
        "ADDR:1165 S LOCUST ST",
        "CITY:CANAL FULTON");

    doTest("T25",
        "(FIRES CALLS) CFFD:2012:312\nDISPATCHED\nMEDALS\n8871, MANCHESTER AV NW ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:312",
        "CALL:MEDALS",
        "ADDR:8871 MANCHESTER AV NW",
        "MADDR:8871 MANCHESTER AVE NW",
        "CITY:LAWRENCE TWP");

    doTest("T26",
        "(FIRES CALLS) CFFD:2012:310\nDISPATCHED\nMEDALS\n714, BEVERLY AV ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:310",
        "CALL:MEDALS",
        "ADDR:714 BEVERLY AV",
        "MADDR:714 BEVERLY AVE",
        "CITY:CANAL FULTON");

    doTest("T27",
        "(FIRES CALLS) CFFD:2012:319\nDISPATCHED\nMEDALS\n10438, MAPLEVIEW ST NW ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:319",
        "CALL:MEDALS",
        "ADDR:10438 MAPLEVIEW ST NW",
        "CITY:LAWRENCE TWP");

    doTest("T28",
        "(FIRES CALLS) CFFD:2012:308\nDISPATCHED\nMEDALS\n581, BEVERLY AV ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:308",
        "CALL:MEDALS",
        "ADDR:581 BEVERLY AV",
        "MADDR:581 BEVERLY AVE",
        "CITY:CANAL FULTON");

    doTest("T29",
        "(FIRES CALLS) CFFD:2012:309\nDISPATCHED\nMEDALS\n8757, SPRING GROVE AV NW ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:309",
        "CALL:MEDALS",
        "ADDR:8757 SPRING GROVE AV NW",
        "MADDR:8757 SPRING GROVE AVE NW",
        "CITY:LAWRENCE TWP");

    doTest("T30",
        "(FIRES CALLS) CFFD:2012:330\nDISPATCHED\nMEDALS\n2042, REDWING DR ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:330",
        "CALL:MEDALS",
        "ADDR:2042 REDWING DR",
        "CITY:CANAL FULTON");

    doTest("T31",
        "(FIRES CALLS) CFFD:2012:331\nDISPATCHED\nMEDALS\n10382, STRAUSSER ST NW ;LAWRENCE TWP",
        "SRC:CFFD",
        "ID:2012:331",
        "CALL:MEDALS",
        "ADDR:10382 STRAUSSER ST NW",
        "CITY:LAWRENCE TWP");

    doTest("T32",
        "(FIRES CALLS) CFFD:2012:332\nDISPATCHED\nMEDALS\n585, BEVERLY AV ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:332",
        "CALL:MEDALS",
        "ADDR:585 BEVERLY AV",
        "MADDR:585 BEVERLY AVE",
        "CITY:CANAL FULTON");

    doTest("T33",
        "(FIRES CALLS) CFFD:2012:333\nDISPATCHED\nMEDALS\n490, COLONY RD ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:333",
        "CALL:MEDALS",
        "ADDR:490 COLONY RD",
        "CITY:CANAL FULTON");

    doTest("T34",
        "(FIRES CALLS) CFFD:2012:334\nDISPATCHED\nOPENBURN\n3806, GREENWOOD",
        "SRC:CFFD",
        "ID:2012:334",
        "CALL:OPENBURN",
        "ADDR:3806 GREENWOOD");

    doTest("T35",
        "(FIRES CALLS) CFFD:2012:335\nDISPATCHED\nMEDALS\n408, W MARKET ST ;CANAL FULTON",
        "SRC:CFFD",
        "ID:2012:335",
        "CALL:MEDALS",
        "ADDR:408 W MARKET ST",
        "CITY:CANAL FULTON");
  }
  
  public static void main(String[] args) {
    new OHStarkCountyCencommParserTest().generateTests("T1");
  }
}