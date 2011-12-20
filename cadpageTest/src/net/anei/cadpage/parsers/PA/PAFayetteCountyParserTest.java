package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAFayetteCountyParserTest extends BaseParserTest {
  
  public PAFayetteCountyParserTest() {
    setParser(new PAFayetteCountyParser(), "FAYETTE COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T9",
        "FAYETTE-911:FACINJ>F-ACCIDENT W/ INJURIES VANCES MILL RD NORTH UNION WILSON PAUL 7249637757 Map: Grids:, Cad: 2011-0000029638",
        "CALL:F-ACCIDENT W/INJURIES VANCES",
        "ADDR:MILL RD",
        "CITY:NORTH UNION TWP",
        "NAME:WILSON PAUL",
        "PHONE:7249637757",
        "ID:2011-0000029638");

    doTest("T10",
        "FAYETTE-911:ESCK_A>E SICK/UNKNOWN ALS 570 FLATWOODS RD XS: TOWN COUNTRY RD FRANKLIN ADAMS, J 7243980234 Map: Grids:, Cad: 2011-0000031363",
        "CALL:E SICK/UNKNOWN ALS",
        "ADDR:570 FLATWOODS RD",
        "CITY:FRANKLIN TWP",
        "X:TOWN COUNTRY RD",
        "NAME:ADAMS, J",
        "PHONE:7243980234",
        "ID:2011-0000031363");

    doTest("T11",
        "FAYETTE-911:FACCNO>F_ACCIDENT NO INJURIES 1829 PITTSBURGH RD XS: RESERVOIR RD FRANKLIN HARPER, FRAN 4126910370 Map: Grids:, Cad: 2011-0000029521",
        "CALL:F_ACCIDENT NO INJURIES",
        "ADDR:1829 PITTSBURGH RD",
        "CITY:FRANKLIN TWP",
        "X:RESERVOIR RD",
        "NAME:HARPER, FRAN",
        "PHONE:4126910370",
        "ID:2011-0000029521");

    doTest("T13",
        "FAYETTE-911:FACINJ>F-ACCIDENT W/ INJURIES 2418 PITTSBURGH RD XS: RESERVOIR RD & BRADY LN FRANKLIN CHRIS 3046855898 Map: Grids:, Cad: 2011-0000029569",
        "CALL:F-ACCIDENT W/INJURIES",
        "ADDR:2418 PITTSBURGH RD",
        "CITY:FRANKLIN TWP",
        "X:RESERVOIR RD & BRADY LN",
        "NAME:CHRIS",
        "PHONE:3046855898",
        "ID:2011-0000029569");

    doTest("T14",
        "FAYETTE-911:EBRT_A>E_BREATHING ALS 1829 PITTSBURGH RD XS: RESERVOIR RD FRANKLIN DELBRIDGE JOY 7247106364 Map: Grids:, Cad: 2011-0000030505",
        "CALL:E_BREATHING ALS",
        "ADDR:1829 PITTSBURGH RD",
        "CITY:FRANKLIN TWP",
        "X:RESERVOIR RD",
        "NAME:DELBRIDGE JOY",
        "PHONE:7247106364",
        "ID:2011-0000030505");

    doTest("T15",
        "FAYETTE-911:FACINJ>F-ACCIDENT W/ INJURIES BOLDEN RD XS: COOPER RD & PITTSBURGH RD FRANKLIN HIGGNS ERENST 7245526428 Cad: 2011-0000030796",
        "CALL:F-ACCIDENT W/INJURIES",
        "ADDR:BOLDEN RD",
        "MADDR:BOLDEN RD & COOPER RD",
        "X:COOPER RD & PITTSBURGH RD",
        "CITY:FRANKLIN TWP",
        "NAME:HIGGNS ERENST",
        "PHONE:7245526428",
        "ID:2011-0000030796");

    doTest("T16",
        "FAYETTE-911:EBRT_A>E_BREATHING ALS 2527 PITTSBURGH RD FRANKLIN JOHNSON JULIE 7244157363 Map: Grids:, Cad: 2011-0000030936",
        "CALL:E_BREATHING ALS",
        "ADDR:2527 PITTSBURGH RD",
        "CITY:FRANKLIN TWP",
        "NAME:JOHNSON JULIE",
        "PHONE:7244157363",
        "ID:2011-0000030936");

    doTest("T17",
        "FAYETTE-911:FTREE >F_TREE DOWN BUENA VISTA RD XS: FLATWOODS RD FRANKLIN THOMPSON KAREN 7248800052 Map: Grids:, Cad: 2011-0000031144",
        "CALL:F_TREE DOWN BUENA",
        "ADDR:VISTA RD",
        "MADDR:VISTA RD & FLATWOODS RD",
        "CITY:FRANKLIN TWP",
        "X:FLATWOODS RD",
        "NAME:THOMPSON KAREN",
        "PHONE:7248800052",
        "ID:2011-0000031144");

    doTest("T18",
        "FAYETTE-911:FTREE >F_TREE DOWN BITNER RD XS: VANCES MILL RD & ROUND BARN RD FRANKLIN VERIZON WIRELESS 7248808596 Map: Grids:, Cad: 2011-0000031156",
        "CALL:F_TREE DOWN",
        "ADDR:BITNER RD",
        "MADDR:BITNER RD & VANCES MILL RD",
        "X:VANCES MILL RD & ROUND BARN RD",
        "CITY:FRANKLIN TWP",
        "NAME:VERIZON WIRELESS",
        "PHONE:7248808596",
        "ID:2011-0000031156");
  
  }
  
  public static void main(String[] args) {
    new PAFayetteCountyParserTest().generateTests("T9", "CALL ADDR CITY X PLACE NAME PHONE MAP ID");
  }
}
