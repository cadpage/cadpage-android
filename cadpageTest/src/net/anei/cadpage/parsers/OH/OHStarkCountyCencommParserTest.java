package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHStarkCountyCencommParserTest extends BaseParserTest {
  
  public OHStarkCountyCencommParserTest() {
    setParser(new OHStarkCountyCencommParser(), "STARK COUNTY", "OH");
  }
  
  @Test
  public void testActive911A() {

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
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "[LTFD] CFFD:2012:409\nDISPATCHED\nMEDALS\n8543, ELMFIELD AV NW ;LAWRENCE TWP\n",
        "SRC:CFFD",
        "ID:2012:409",
        "CALL:MEDALS",
        "ADDR:8543 ELMFIELD AV NW",
        "MADDR:8543 ELMFIELD AVE NW",
        "CITY:LAWRENCE TWP");

    doTest("T2",
        "[LTFD] CFFD:2012:410\nDISPATCHED\nMEDALS\n324, HIGH ST NE ;CANAL FULTON\n",
        "SRC:CFFD",
        "ID:2012:410",
        "CALL:MEDALS",
        "ADDR:324 HIGH ST NE",
        "CITY:CANAL FULTON");

    doTest("T3",
        "[LTFD] CFFD:2012:411\nDISPATCHED\nMEDALS\n6331, BOATMAN DR NW ;LAWRENCE TWP\n",
        "SRC:CFFD",
        "ID:2012:411",
        "CALL:MEDALS",
        "ADDR:6331 BOATMAN DR NW",
        "CITY:LAWRENCE TWP");

    doTest("T4",
        "[LTFD] CFFD:2012:414\nDISPATCHED\nMEDALS\n322, MILAN ST N ;CANAL FULTON\n",
        "SRC:CFFD",
        "ID:2012:414",
        "CALL:MEDALS",
        "ADDR:322 MILAN ST N",
        "CITY:CANAL FULTON");

    doTest("T5",
        "[LTFD] CFFD:2012:415\nDISPATCHED\nMEDALS\n11000, PORTAGE ST NW ;LAWRENCE TWP\n",
        "SRC:CFFD",
        "ID:2012:415",
        "CALL:MEDALS",
        "ADDR:11000 PORTAGE ST NW",
        "CITY:LAWRENCE TWP");

    doTest("T6",
        "[LTFD] CFFD:2012:416\nDISPATCHED\nMEDALS\n207, E CHERRY ST ;CANAL FULTON\n",
        "SRC:CFFD",
        "ID:2012:416",
        "CALL:MEDALS",
        "ADDR:207 E CHERRY ST",
        "CITY:CANAL FULTON");

    doTest("T7",
        "[LTFD] CFFD:2012:417\nDISPATCHED\nMEDALS\n772, BEVERLY AV ;CANAL FULTON\n",
        "SRC:CFFD",
        "ID:2012:417",
        "CALL:MEDALS",
        "ADDR:772 BEVERLY AV",
        "MADDR:772 BEVERLY AVE",
        "CITY:CANAL FULTON");

    doTest("T8",
        "[LTFD] CFFD:2012:418\nDISPATCHED\nOPENBURN\n8579, ELMFIELD AV NW ;LAWRENCE TWP\n",
        "SRC:CFFD",
        "ID:2012:418",
        "CALL:OPENBURN",
        "ADDR:8579 ELMFIELD AV NW",
        "MADDR:8579 ELMFIELD AVE NW",
        "CITY:LAWRENCE TWP");

    doTest("T9",
        "[LTFD] CFFD:2012:419\nDISPATCHED\nRESFIRE\n6596, IVYHILL DR NW ;LAWRENCE TWP\n",
        "SRC:CFFD",
        "ID:2012:419",
        "CALL:RESFIRE",
        "ADDR:6596 IVYHILL DR NW",
        "CITY:LAWRENCE TWP");

    doTest("T10",
        "[LTFD] CFFD:2012:420\nDISPATCHED\nMEDALS\n643, BEVERLY AV ;CANAL FULTON\n",
        "SRC:CFFD",
        "ID:2012:420",
        "CALL:MEDALS",
        "ADDR:643 BEVERLY AV",
        "MADDR:643 BEVERLY AVE",
        "CITY:CANAL FULTON");

    doTest("T11",
        "[LTFD] CFFD:2012:421\nDISPATCHED\nMEDALS\n559, S LOCUST ST ;CANAL FULTON\n",
        "SRC:CFFD",
        "ID:2012:421",
        "CALL:MEDALS",
        "ADDR:559 S LOCUST ST",
        "CITY:CANAL FULTON");

    doTest("T12",
        "[LTFD] CFFD:2012:422\nDISPATCHED\nMEDALS\n7375, STONEHILL ST NW ;LAWRENCE TWP\n",
        "SRC:CFFD",
        "ID:2012:422",
        "CALL:MEDALS",
        "ADDR:7375 STONEHILL ST NW",
        "CITY:LAWRENCE TWP");

    doTest("T13",
        "[LTFD] CFFD:2012:423\nDISPATCHED\nMEDALS\n856, BASSWOOD AV ;CANAL FULTON\n",
        "SRC:CFFD",
        "ID:2012:423",
        "CALL:MEDALS",
        "ADDR:856 BASSWOOD AV",
        "MADDR:856 BASSWOOD AVE",
        "CITY:CANAL FULTON");

    doTest("T14",
        "[LTFD] CFFD:2012:424\nDISPATCHED\nMVAINJ\nWEAVER AND HIGH\n",
        "SRC:CFFD",
        "ID:2012:424",
        "CALL:MVAINJ",
        "ADDR:WEAVER AND HIGH");

    doTest("T15",
        "[LTFD] CFFD:2012:425\nDISPATCHED\nMEDALS\n336, CHIPPEWA ST ;CANAL FULTON\n",
        "SRC:CFFD",
        "ID:2012:425",
        "CALL:MEDALS",
        "ADDR:336 CHIPPEWA ST",
        "CITY:CANAL FULTON");

    doTest("T16",
        "[LTFD] CFFD:2012:426\nDISPATCHED\nMEDALS\n632, BEVERLY AV ;CANAL FULTON\n",
        "SRC:CFFD",
        "ID:2012:426",
        "CALL:MEDALS",
        "ADDR:632 BEVERLY AV",
        "MADDR:632 BEVERLY AVE",
        "CITY:CANAL FULTON");

    doTest("T17",
        "[LTFD] CFFD:2012:427\nDISPATCHED\nMEDALS\n13190, PATTERSON ST NW ;LAWRENCE TWP\n",
        "SRC:CFFD",
        "ID:2012:427",
        "CALL:MEDALS",
        "ADDR:13190 PATTERSON ST NW",
        "CITY:LAWRENCE TWP");

    doTest("T18",
        "[LTFD] CFFD:2012:428\nDISPATCHED\nMEDALS\nCLAY'S PARK\n",
        "SRC:CFFD",
        "ID:2012:428",
        "CALL:MEDALS",
        "ADDR:CLAY'S PARK");

    doTest("T19",
        "[LTFD] CFFD:2012:429\nDISPATCHED\nMEDALS\nBUTTERBRIDGE/ RT 21 SB\n",
        "SRC:CFFD",
        "ID:2012:429",
        "CALL:MEDALS",
        "ADDR:BUTTERBRIDGE & RT 21 SB",
        "MADDR:BUTTERBRIDGE & RT 21");

    doTest("T20",
        "[LTFD] CFFD:2012:430\nDISPATCHED\nMEDALS\n13190, PATTERSON ST NW ;LAWRENCE TWP\n",
        "SRC:CFFD",
        "ID:2012:430",
        "CALL:MEDALS",
        "ADDR:13190 PATTERSON ST NW",
        "CITY:LAWRENCE TWP");

    doTest("T21",
        "[LTFD] CFFD:2012:431\nDISPATCHED\nMEDALS\n15644, MARSHALLVILLE ST NW ;LAWRENCE TWP\n",
        "SRC:CFFD",
        "ID:2012:431",
        "CALL:MEDALS",
        "ADDR:15644 MARSHALLVILLE ST NW",
        "CITY:LAWRENCE TWP");

    doTest("T22",
        "[LTFD] CFFD:2012:432\nDISPATCHED\nMEDALS\n12248, STRAUSSER ST NW ;CANAL FULTON\n",
        "SRC:CFFD",
        "ID:2012:432",
        "CALL:MEDALS",
        "ADDR:12248 STRAUSSER ST NW",
        "CITY:CANAL FULTON");

    doTest("T23",
        "[LTFD] CFFD:2012:434\nDISPATCHED\nWIRESDOWN\n4995, MANCHESTER AV NW ;LAWRENCE TWP\n",
        "SRC:CFFD",
        "ID:2012:434",
        "CALL:WIRESDOWN",
        "ADDR:4995 MANCHESTER AV NW",
        "MADDR:4995 MANCHESTER AVE NW",
        "CITY:LAWRENCE TWP");

    doTest("T24",
        "[LTFD] CFFD:2012:435\nDISPATCHED\nWIRESDOWN\n12027, STRAUSSER ST NW ;LAWRENCE TWP\n",
        "SRC:CFFD",
        "ID:2012:435",
        "CALL:WIRESDOWN",
        "ADDR:12027 STRAUSSER ST NW",
        "CITY:LAWRENCE TWP");

    doTest("T25",
        "[LTFD] CFFD:2012:436\nDISPATCHED\nMEDALS\n603, COLONY RD ;CANAL FULTON\n",
        "SRC:CFFD",
        "ID:2012:436",
        "CALL:MEDALS",
        "ADDR:603 COLONY RD",
        "CITY:CANAL FULTON");

    doTest("T26",
        "[LTFD] CFFD:2012:437\nDISPATCHED\nMEDALS\n614, BEVERLY AV ;CANAL FULTON\n",
        "SRC:CFFD",
        "ID:2012:437",
        "CALL:MEDALS",
        "ADDR:614 BEVERLY AV",
        "MADDR:614 BEVERLY AVE",
        "CITY:CANAL FULTON");

    doTest("T27",
        "[LTFD] CFFD:2012:438\nDISPATCHED\nMEDALS\n8543, ELMFIELD AV NW ;LAWRENCE TWP\n",
        "SRC:CFFD",
        "ID:2012:438",
        "CALL:MEDALS",
        "ADDR:8543 ELMFIELD AV NW",
        "MADDR:8543 ELMFIELD AVE NW",
        "CITY:LAWRENCE TWP");

    doTest("T28",
        "[LTFD] CFFD:2012:439\nDISPATCHED\nMEDALS\n764, BEVERLY AV ;CANAL FULTON\n",
        "SRC:CFFD",
        "ID:2012:439",
        "CALL:MEDALS",
        "ADDR:764 BEVERLY AV",
        "MADDR:764 BEVERLY AVE",
        "CITY:CANAL FULTON");

    doTest("T29",
        "[LTFD] CFFD:2012:440\nDISPATCHED\nMEDALS\n11866, PACKETS ST NW ;LAWRENCE TWP\n",
        "SRC:CFFD",
        "ID:2012:440",
        "CALL:MEDALS",
        "ADDR:11866 PACKETS ST NW",
        "CITY:LAWRENCE TWP");

  }
  
  public static void main(String[] args) {
    new OHStarkCountyCencommParserTest().generateTests("T1");
  }
}