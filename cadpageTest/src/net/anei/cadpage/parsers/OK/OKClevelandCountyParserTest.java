package net.anei.cadpage.parsers.OK;

import org.junit.Test;

import net.anei.cadpage.parsers.BaseParserTest;

/*
Cleveland County, OK
Contact: Active911
Agency name: Little Axe Fire Department
Location: Little Axe, OK, United States
Sender: dispatch.info@normanok.gov

(CAD) FIRE GRASS RED OAK LN & E FRANKLIN RD ESN: 92
(CAD) FIRE RESIDENTIAL 6305 CROOKED OAK DR ESN: 267
(CAD) SMOKE INVESTIGATION E FRANKLIN RD & 192ND AVE NE ESN: 92
(CAD) FIRE GRASS VALLEY VIEW RD & ROLLING MEADOWS ESN: 38
(CAD) FIRE GRASS 18150 BIXLER CT ESN: 230
(CAD) FIRE GRASS 105 LISA LN ESN: 38
(CAD) FIRE GRASS 18000 E FRANKLIN RD ESN: 92
(CAD) FIRE GRASS E FRANKLIN RD & 192ND AVE NE ESN: 92
(CAD) FIRE GRASS LISA LN & 192ND AVE NE ESN: 38
(CAD) SMOKE INVESTIGATION 180TH AVE NE & E TECUMSEH RD ESN: 136
(CAD) FIRE RESIDENTIAL 16650 192ND AVE NE ESN: 38
(CAD) SMOKE INVESTIGATION 18401 PECAN CREEK DR ESN: 38
(CAD) FIRE MUTUAL AIDE WAUNETT OKLAHOMA ESN:
(CAD) SMOKE INVESTIGATION 375 WILKINSON DR ESN:
(CAD) FIRE RESIDENTIAL 18240 311 RD ESN: 277
(CAD) FIRE ALARM RESIDENTIAL 18901 RED OAK LN ESN: 92
(CAD) FIRE CONTROL BURN 18801 E SH9 ESN: 182
(CAD) FIRE RESIDENTIAL 192ND AVE NE & PECAN CREEK DR ESN: 38
(CAD) FIRE GRASS 17205 SYCAMORE LN ESN: 37
(CAD) SMOKE INVESTIGATION 18750 ROLLING OAK RD ESN: 38
(CAD) FIRE GRASS 19145 S HARRAH RD ESN:
(CAD) PUBLIC ASSIST 451 192ND AVE SE ESN: 230
(CAD) FIRE CONTROL BURN 20300 E ALAMEDA ST ESN: 231
(CAD) FIRE RESIDENTIAL 132ND AVE SE & E IMHOFF RD ESN: 309
(CAD) FIRE MUTUAL AIDE 22634 SHADY CREEK LN ESN:
(CAD) FIRE GRASS SKYRIDGE RD & WOODRIDGE DR ESN: 92
(CAD) FIRE MUTUAL AIDE MOOSEVILLE & 192 ESN:
(CAD) PUBLIC ASSIST 18718 E INDIAN HILLS RD ESN: 62
(CAD) FIRE GRASS 19200 E SH9 HWY ESN:
(CAD) FIRE RESIDENTIAL 156TH AVE & STELLA RD ESN: 16
(CAD) SMOKE INVESTIGATION 18150 ESCORT CIR ESN: 276

 */

public class OKClevelandCountyParserTest extends BaseParserTest {
  
  public OKClevelandCountyParserTest() {
    setParser(new OKClevelandCountyParser(), "CLEVELAND COUNTY", "OK");
  }
 
  
  @Test
  public void testLittleAxeFireDepartment() {

    doTest("T1",
        "(CAD) FIRE GRASS RED OAK LN & E FRANKLIN RD ESN: 92",
        "CALL:FIRE GRASS",
        "ADDR:RED OAK LN & E FRANKLIN RD",  // According to google, these to no intersect
        "ID:92");

    doTest("T2",
        "(CAD) FIRE RESIDENTIAL 6305 CROOKED OAK DR ESN: 267",
        "CALL:FIRE RESIDENTIAL",
        "ADDR:6305 CROOKED OAK DR",
        "ID:267");

    doTest("T3",
        "(CAD) SMOKE INVESTIGATION E FRANKLIN RD & 192ND AVE NE ESN: 92",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:E FRANKLIN RD & 192ND AVE NE",
        "ID:92");

    doTest("T4",
        "(CAD) FIRE GRASS VALLEY VIEW RD & ROLLING MEADOWS ESN: 38",
        "CALL:FIRE GRASS",
        "ADDR:VALLEY VIEW RD & ROLLING MEADOWS",
        "ID:38");

    doTest("T5",
        "(CAD) FIRE GRASS 18150 BIXLER CT ESN: 230",
        "CALL:FIRE GRASS",
        "ADDR:18150 BIXLER CT",
        "ID:230");

    doTest("T6",
        "(CAD) FIRE GRASS 105 LISA LN ESN: 38",
        "CALL:FIRE GRASS",
        "ADDR:105 LISA LN",
        "ID:38");

    doTest("T7",
        "(CAD) FIRE GRASS 18000 E FRANKLIN RD ESN: 92",
        "CALL:FIRE GRASS",
        "ADDR:18000 E FRANKLIN RD",
        "ID:92");

    doTest("T8",
        "(CAD) FIRE GRASS E FRANKLIN RD & 192ND AVE NE ESN: 92",
        "CALL:FIRE GRASS",
        "ADDR:E FRANKLIN RD & 192ND AVE NE",
        "ID:92");

    doTest("T9",
        "(CAD) FIRE GRASS LISA LN & 192ND AVE NE ESN: 38",
        "CALL:FIRE GRASS",
        "ADDR:LISA LN & 192ND AVE NE",
        "ID:38");

    doTest("T10",
        "(CAD) SMOKE INVESTIGATION 180TH AVE NE & E TECUMSEH RD ESN: 136",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:180TH AVE NE & E TECUMSEH RD",
        "ID:136");

    doTest("T11",
        "(CAD) FIRE RESIDENTIAL 16650 192ND AVE NE ESN: 38",
        "CALL:FIRE RESIDENTIAL",
        "ADDR:16650 192ND AVE NE",
        "ID:38");

    doTest("T12",
        "(CAD) SMOKE INVESTIGATION 18401 PECAN CREEK DR ESN: 38",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:18401 PECAN CREEK DR",
        "ID:38");

    doTest("T13",
        "(CAD) FIRE MUTUAL AIDE WAUNETT OKLAHOMA ESN:",
        "CALL:FIRE MUTUAL AIDE",
        "ADDR:WAUNETT OKLAHOMA");

    doTest("T14",
        "(CAD) SMOKE INVESTIGATION 375 WILKINSON DR ESN:",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:375 WILKINSON DR");

    doTest("T15",
        "(CAD) FIRE RESIDENTIAL 18240 311 RD ESN: 277",
        "CALL:FIRE RESIDENTIAL",
        "ADDR:18240 311 RD",
        "ID:277");

    doTest("T16",
        "(CAD) FIRE ALARM RESIDENTIAL 18901 RED OAK LN ESN: 92",
        "CALL:FIRE ALARM RESIDENTIAL",
        "ADDR:18901 RED OAK LN",
        "ID:92");

    doTest("T17",
        "(CAD) FIRE CONTROL BURN 18801 E SH9 ESN: 182",
        "CALL:FIRE CONTROL BURN",
        "ADDR:18801 E SH9",
        "MADDR:18801 E OK 9",
        "ID:182");

    doTest("T18",
        "(CAD) FIRE RESIDENTIAL 192ND AVE NE & PECAN CREEK DR ESN: 38",
        "CALL:FIRE RESIDENTIAL",
        "ADDR:192ND AVE NE & PECAN CREEK DR",
        "ID:38");

    doTest("T19",
        "(CAD) FIRE GRASS 17205 SYCAMORE LN ESN: 37",
        "CALL:FIRE GRASS",
        "ADDR:17205 SYCAMORE LN",
        "ID:37");

    doTest("T20",
        "(CAD) SMOKE INVESTIGATION 18750 ROLLING OAK RD ESN: 38",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:18750 ROLLING OAK RD",
        "ID:38");

    doTest("T21",
        "(CAD) FIRE GRASS 19145 S HARRAH RD ESN:",
        "CALL:FIRE GRASS",
        "ADDR:19145 S HARRAH RD");

    doTest("T22",
        "(CAD) PUBLIC ASSIST 451 192ND AVE SE ESN: 230",
        "CALL:PUBLIC ASSIST",
        "ADDR:451 192ND AVE SE",
        "ID:230");

    doTest("T23",
        "(CAD) FIRE CONTROL BURN 20300 E ALAMEDA ST ESN: 231",
        "CALL:FIRE CONTROL BURN",
        "ADDR:20300 E ALAMEDA ST",
        "ID:231");

    doTest("T24",
        "(CAD) FIRE RESIDENTIAL 132ND AVE SE & E IMHOFF RD ESN: 309",
        "CALL:FIRE RESIDENTIAL",
        "ADDR:132ND AVE SE & E IMHOFF RD",
        "ID:309");

    doTest("T25",
        "(CAD) FIRE MUTUAL AIDE 22634 SHADY CREEK LN ESN:",
        "CALL:FIRE MUTUAL AIDE",
        "ADDR:22634 SHADY CREEK LN");

    doTest("T26",
        "(CAD) FIRE GRASS SKYRIDGE RD & WOODRIDGE DR ESN: 92",
        "CALL:FIRE GRASS",
        "ADDR:SKYRIDGE RD & WOODRIDGE DR",
        "ID:92");

    doTest("T27",
        "(CAD) FIRE MUTUAL AIDE MOOSEVILLE & 192 ESN:",
        "CALL:FIRE MUTUAL AIDE",
        "ADDR:MOOSEVILLE & 192");

    doTest("T28",
        "(CAD) PUBLIC ASSIST 18718 E INDIAN HILLS RD ESN: 62",
        "CALL:PUBLIC ASSIST",
        "ADDR:18718 E INDIAN HILLS RD",
        "ID:62");

    doTest("T29",
        "(CAD) FIRE GRASS 19200 E SH9 HWY ESN:",
        "CALL:FIRE GRASS",
        "ADDR:19200 E SH9 HWY",
        "MADDR:19200 E OK 9");

    doTest("T30",
        "(CAD) FIRE RESIDENTIAL 156TH AVE & STELLA RD ESN: 16",
        "CALL:FIRE RESIDENTIAL",
        "ADDR:156TH AVE & STELLA RD",
        "ID:16");

    doTest("T31",
        "(CAD) SMOKE INVESTIGATION 18150 ESCORT CIR ESN: 276",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:18150 ESCORT CIR",  // Google finds ESCORT DR
        "ID:276");
   
  }


  public static void main(String[] args) {
    new OKClevelandCountyParserTest().generateTests("T1");
  }
}