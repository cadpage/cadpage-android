package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCGuilfordCountyParserTest extends BaseParserTest {
  
  public NCGuilfordCountyParserTest() {
    setParser(new NCGuilfordCountyParser(), "GUILFORD COUNTY", "NC");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "[summerfieldfiredist Jan24-10:01]  CAD:SMFD;ST09;1;52C03C;FIRAL;7607 BLUE SAGE CT",
        "INFO:SMFD / ST09 / 1",
        "CODE:52C03C",
        "CALL:FIRAL",
        "ADDR:7607 BLUE SAGE CT");

    doTest("T2",
        "[summerfieldfiredist Jan19-18:15]  CAD:SMFD;ST29;1;50PI;SCALESVILLE RD/LAKE BRANDT RD",
        "INFO:SMFD / ST29 / 1",
        "CALL:50PI",
        "ADDR:SCALESVILLE RD & LAKE BRANDT RD");

    setDefaults("","NC");
    doTest("T3",
        "[summerfieldfiredist Jan18-19:08]  CAD:1;MUTUAL;150 WAYNOR DR;GALLENT RD;STRUCTURE FIRE",
        "CALL:MUTUAL",
        "ADDR:150 WAYNOR DR",
        "X:GALLENT RD & STRUCTURE FIRE");
    setDefaults("GUILFORD COUNTY", "NC");

    doTest("T4",
        "(summerfieldfiredist Jan18-17:00) CAD:SMFD;ST29;1;25D01;PSYCH;8579 HUDSON JAMES RD;WRIGHTS FARM LN",
        "INFO:SMFD / ST29 / 1",
        "CODE:25D01",
        "CALL:PSYCH",
        "ADDR:8579 HUDSON JAMES RD",
        "X:WRIGHTS FARM LN");

    doTest("T5",
        "[summerfieldfiredist Jan18-03:16]  CAD:SMFD;ST39;1;29B01;50PI;PLAINFIELD RD/LAKE BRANDT RD;BETWEEN LAKE BRANDT AND CHURCH ST",
        "INFO:SMFD / ST39 / 1",
        "CODE:29B01",
        "CALL:50PI",
        "ADDR:PLAINFIELD RD & LAKE BRANDT RD",
        "X:BETWEEN LAKE BRANDT AND CHURCH ST");

    doTest("T6",
        "(summerfieldfiredist Jan21-03:25) CAD:SMFD;ST09;1;67B01;OSFIR;2523 PLEASANT RIDGE RD;SADDLEWOOD DR;DIST: 35.58 FT",
        "INFO:SMFD / ST09 / 1",
        "CODE:67B01",
        "CALL:OSFIR",
        "ADDR:2523 PLEASANT RIDGE RD",
        "X:SADDLEWOOD DR & DIST: 35.58 FT");

    doTest("T7",
        "(summerfieldfiredist Jan23-06:49) CAD:SMFD;ST39;1;17B03;FALL;6251 LAKE BRANDT RD;HI-LO LN",
        "INFO:SMFD / ST39 / 1",
        "CODE:17B03",
        "CALL:FALL",
        "ADDR:6251 LAKE BRANDT RD",
        "X:HI-LO LN");

    doTest("T8",
        "[summerfieldfiredist Jan23-19:20]  CAD:OKRD;ST51;1;69D11;STRUC;4529 PEEPLES RD;RIDING TRAIL CT",
        "INFO:OKRD / ST51 / 1",
        "CODE:69D11",
        "CALL:STRUC",
        "ADDR:4529 PEEPLES RD",
        "X:RIDING TRAIL CT");

    doTest("T9",
        "[summerfieldfiredist Jan23-19:18]  CAD:OKRD;ST51;1;STRUC;4529 PEEPLES RD;RIDING TRAIL CT",
        "INFO:OKRD / ST51 / 1",
        "CALL:STRUC",
        "ADDR:4529 PEEPLES RD",
        "X:RIDING TRAIL CT");

    doTest("T10",
        "[summerfieldfiredist Jan23-20:23]  CAD:OKRD;ST51;1;69D06;STRUC;5371 NORTHWEST SCHOOL RD;TRAIL PIEDMONT GREENWAY",
        "INFO:OKRD / ST51 / 1",
        "CODE:69D06",
        "CALL:STRUC",
        "ADDR:5371 NORTHWEST SCHOOL RD",
        "X:TRAIL PIEDMONT GREENWAY");

    doTest("T11",
        "(summerfieldfiredist Jan24-10:31) CAD:UNDER CONTROL;7607 BLUE SAGE CT; SU",
        "CALL:UNDER CONTROL",
        "ADDR:7607 BLUE SAGE CT",
        "X:SU");

    doTest("T12",
        "(summerfieldfiredist Jan23-11:25) CAD:UNDER CONTROL;6308 PEPPERMILL DR; OAK",
        "CALL:UNDER CONTROL",
        "ADDR:6308 PEPPERMILL DR",
        "X:OAK");

    doTest("T13",
        "(summerfieldfiredist Jan23-19:48) CAD:UNDER CONTROL;4529 PEEPLES RD; OAK",
        "CALL:UNDER CONTROL",
        "ADDR:4529 PEEPLES RD",
        "X:OAK");

  }
  

  public static void main(String[] args) {
    new NCGuilfordCountyParserTest().generateTests("T1");
  }
}
