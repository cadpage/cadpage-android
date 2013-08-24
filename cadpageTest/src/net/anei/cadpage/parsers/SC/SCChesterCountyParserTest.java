package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Chester County, SC

Contact: Active911
Agency name: Richburg Fire Rescue
Location: Richburg, SC, United States
Sender: CHESTER_911@Truvista.net

CHESTER_911:1070 >FIRE 3204 LANCASTER HWY RICHBURG WAFFLE HOUSE RICHBURG 8037895535 Map: Grids:0,0 Cad: 2012-0000051009\r\n
CHESTER_911:1052P1>EMS NEEDED PRIORITY 1 4576 WYLIES MILL RD XS: LANCASTER HWY EDGEMOOR PATRICA G MCINTOSH 8037895237 Map: Grids:0,0 Cad: 2012-0000050983\r\n
CHESTER_911:1070 >FIRE 4250 SLOAN RD XS: LANCASTER RD RICHBURG ALLIED WIRELESS 877.510.4357 8032095766 Map: Grids:0,0 Cad: 2012-0000050888\r\n
CHESTER_911:911HU >911 HANG UP 2925 LAKESHORE DR XS: LIZZIE MELTON CHESTER FREEMAN HEATH 8037897718 Map: Grids:0,0 Cad: 2012-0000050769\r\n
CHESTER_911:1052P1>EMS NEEDED PRIORITY 1 113 CIRCLE DR XS: W M STEVENSON RD RICHBURG ROBIN CROCKETT 8037895934 Map: Grids:0,0 Cad: 2012-0000050757\r\n
CHESTER_911:1052 >EMS NEEDED I77 NB MM 60 JANE HALL 8432405583 Cad: 2012-0000050725\r\n
CHESTER_911:1052P1>EMS NEEDED PRIORITY 1 RICHBURG RD XS: CATAWBA RIVER RD FORT LAWN AT&T MOBILITY 8034609375 Cad: 2012-0000050664\r\n
CHESTER_911:1052P1>EMS NEEDED PRIORITY 1 3104 COMMERCE DR XS: LANCASTER HWY RICHBURG S & M FOOD MART & B P 8037893789 Map: Grids:0,0 Cad: 2012-0000050445\r\n
CHESTER_911:1052P1>EMS NEEDED PRIORITY 1 198 SOUTH MAIN ST XS: NORTH MAIN ST // MTN GAP RD RICHBURG KATHY GLADDEN 8037897737 Map: Grids:0,0 Cad: 2012-0000050368\r\n
CHESTER_911:1070 >FIRE 4551 RICHBURG RD XS: LANCASTER HWY RICHBURG MARIE 8033790224 Map: Grids:0,0 Cad: 2012-0000050086\r\n
CHESTER_911:1070 >FIRE 1904 OLD MILL RD XS: MT GAPRD / BROWN RD RICHBURG ELIZABETH SHYTLE 8035812424 Map: Grids:0,0 Cad: 2012-0000049810\r\n
CHESTER_911:1070 >FIRE 1656 J BASS DR XS: CROWS NEST OFF SIMPSON EDGEMOOR FRANCISCO LOZANO 8035240312 Map: Grids:0,0 Cad: 2012-0000049731\r\n
CHESTER_911:1070 >FIRE 4006 LEWISVILLE HIGH SCH RD XS: LANCASTER HWY RICHBURG SCHOOLS PUBLIC/JOANN 8037895164 Map: Grids:0,0 Cad: 2012-0000049703\r\n
CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT I77 S MM68 JOHNNY CHAPMAN 3369770170 Cad: 2012-0000049371\r\n
CHESTER_911:1052P1>EMS NEEDED PRIORITY 1 124 WILLIAM STEVENSON RD XS: WEST LANCASTER ST RICHBURG AT&T MOBILITY 8033792886 Map: Grids:0,0 Cad: 2012-0000049258\r\n

Contact: Active911
Agency name: Chester County Rescue Squad
Location: Chester, SC, United States
Sender: CHESTER_911@Truvista.net

CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT 786 OLD YORK RD CHESTER Map: Grids:0,0 Cad: 2012-0000051326\r\n
CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT 707 SWEENEY ST XS: LEE ST // BEACHAM ST CHESTER ALLIED WIRELESS 877.510.4357 8036019096 Map: Grids:0,0 Cad: 2012-0000051180\r\n
CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT WESTBROOK RD@SIMPSON RD XS: EDGELAND TO CATAWBA RIVER RD EDGEMOOR JESSE LAND 8037895641 Cad: 2012-0000051176\r\n
CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT 4760 HARMONY CH RD XS: WYLIES MILL RD HWY 223 EDGEMOOR MYRA BRAGGS 8037893557 Map: Grids:0,0 Cad: 2012-0000051070\r\n
CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT MOFFITT CREEK RD XS: GREAT FALLS HWY / SHANNON RD BLACKSTOCK ALLIED WIRELESS 877.510.4357 8035196155 Map: Grids:0,0 Cad: 2012-0000050777\r\n
CHESTER_911:1052P2>EMS NEEDED PRIORITY 2 132 MARTIN LUTHER KING DR XS: STADIUM DR / HOPE ST CHESTER LATISHA EVANS 8035813557 Map: Grids:0,0 Cad: 2012-0000050497\r\n
CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT 72 NEAR MCCANDLESS RD AMY 8032095909 Cad: 2012-0000050438\r\n
CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT 3986 FAIRFIELD RD XS: WEST END RD CARLISLE REBECCA 8033747439 Map: Grids:0,0 Cad: 2012-0000050205\r\n
CHESTER_911:1048 >SUSPICIOUS VEHICLE STOP HENRY AT WEST END Cad: 2012-0000050151\r\n

*/

public class SCChesterCountyParserTest extends BaseParserTest {
  
  public SCChesterCountyParserTest() {
    setParser(new SCChesterCountyParser(), "CHESTER COUNTY", "SC");
  }
  
  @Test
  public void testRichburgFire() {

    doTest("T1",
        "CHESTER_911:1070 >FIRE 3204 LANCASTER HWY RICHBURG WAFFLE HOUSE RICHBURG 8037895535 Map: Grids:0,0 Cad: 2012-0000051009\r\n",
        "CODE:1070",
        "CALL:FIRE",
        "ADDR:3204 LANCASTER HWY",
        "CITY:RICHBURG",
        "NAME:WAFFLE HOUSE RICHBURG",
        "PHONE:8037895535",
        "ID:2012-0000051009");

    doTest("T2",
        "CHESTER_911:1052P1>EMS NEEDED PRIORITY 1 4576 WYLIES MILL RD XS: LANCASTER HWY EDGEMOOR PATRICA G MCINTOSH 8037895237 Map: Grids:0,0 Cad: 2012-0000050983\r\n",
        "CODE:1052P1",
        "CALL:EMS NEEDED PRIORITY 1",
        "ADDR:4576 WYLIES MILL RD",
        "X:LANCASTER HWY",
        "CITY:EDGEMOOR",
        "NAME:PATRICA G MCINTOSH",
        "PHONE:8037895237",
        "ID:2012-0000050983");

    doTest("T3",
        "CHESTER_911:1070 >FIRE 4250 SLOAN RD XS: LANCASTER RD RICHBURG ALLIED WIRELESS 877.510.4357 8032095766 Map: Grids:0,0 Cad: 2012-0000050888\r\n",
        "CODE:1070",
        "CALL:FIRE",
        "ADDR:4250 SLOAN RD",
        "X:LANCASTER RD",
        "CITY:RICHBURG",
        "NAME:ALLIED WIRELESS 877.510.4357",
        "PHONE:8032095766",
        "ID:2012-0000050888");

    doTest("T4",
        "CHESTER_911:911HU >911 HANG UP 2925 LAKESHORE DR XS: LIZZIE MELTON CHESTER FREEMAN HEATH 8037897718 Map: Grids:0,0 Cad: 2012-0000050769\r\n",
        "CODE:911HU",
        "CALL:911 HANG UP",
        "ADDR:2925 LAKESHORE DR",
        "X:LIZZIE MELTON",
        "CITY:CHESTER",
        "NAME:FREEMAN HEATH",
        "PHONE:8037897718",
        "ID:2012-0000050769");

    doTest("T5",
        "CHESTER_911:1052P1>EMS NEEDED PRIORITY 1 113 CIRCLE DR XS: W M STEVENSON RD RICHBURG ROBIN CROCKETT 8037895934 Map: Grids:0,0 Cad: 2012-0000050757\r\n",
        "CODE:1052P1",
        "CALL:EMS NEEDED PRIORITY 1",
        "ADDR:113 CIRCLE DR",
        "X:W M STEVENSON RD",
        "CITY:RICHBURG",
        "NAME:ROBIN CROCKETT",
        "PHONE:8037895934",
        "ID:2012-0000050757");

    doTest("T6",
        "CHESTER_911:1052 >EMS NEEDED I77 NB MM 60 JANE HALL 8432405583 Cad: 2012-0000050725\r\n",
        "CODE:1052",
        "CALL:EMS NEEDED",
        "ADDR:I-77 NB",
        "MADDR:I 77",
        "NAME:MM 60 JANE HALL",
        "PHONE:8432405583",
        "ID:2012-0000050725");

    doTest("T7",
        "CHESTER_911:1052P1>EMS NEEDED PRIORITY 1 RICHBURG RD XS: CATAWBA RIVER RD FORT LAWN AT&T MOBILITY 8034609375 Cad: 2012-0000050664\r\n",
        "CODE:1052P1",
        "CALL:EMS NEEDED PRIORITY 1",
        "ADDR:RICHBURG RD",
        "MADDR:RICHBURG RD & CATAWBA RIVER RD",
        "X:CATAWBA RIVER RD",
        "CITY:FORT LAWN",
        "PHONE:8034609375",
        "ID:2012-0000050664");

    doTest("T8",
        "CHESTER_911:1052P1>EMS NEEDED PRIORITY 1 3104 COMMERCE DR XS: LANCASTER HWY RICHBURG S & M FOOD MART & B P 8037893789 Map: Grids:0,0 Cad: 2012-0000050445\r\n",
        "CODE:1052P1",
        "CALL:EMS NEEDED PRIORITY 1",
        "ADDR:3104 COMMERCE DR",
        "X:LANCASTER HWY",
        "CITY:RICHBURG",
        "NAME:S & M FOOD MART & B P",
        "PHONE:8037893789",
        "ID:2012-0000050445");

    doTest("T9",
        "CHESTER_911:1052P1>EMS NEEDED PRIORITY 1 198 SOUTH MAIN ST XS: NORTH MAIN ST // MTN GAP RD RICHBURG KATHY GLADDEN 8037897737 Map: Grids:0,0 Cad: 2012-0000050368\r\n",
        "CODE:1052P1",
        "CALL:EMS NEEDED PRIORITY 1",
        "ADDR:198 SOUTH MAIN ST",
        "X:NORTH MAIN ST / MTN GAP RD",
        "CITY:RICHBURG",
        "NAME:KATHY GLADDEN",
        "PHONE:8037897737",
        "ID:2012-0000050368");

    doTest("T10",
        "CHESTER_911:1070 >FIRE 4551 RICHBURG RD XS: LANCASTER HWY RICHBURG MARIE 8033790224 Map: Grids:0,0 Cad: 2012-0000050086\r\n",
        "CODE:1070",
        "CALL:FIRE",
        "ADDR:4551 RICHBURG RD",
        "X:LANCASTER HWY",
        "CITY:RICHBURG",
        "NAME:MARIE",
        "PHONE:8033790224",
        "ID:2012-0000050086");

    doTest("T11",
        "CHESTER_911:1070 >FIRE 1904 OLD MILL RD XS: MT GAPRD / BROWN RD RICHBURG ELIZABETH SHYTLE 8035812424 Map: Grids:0,0 Cad: 2012-0000049810\r\n",
        "CODE:1070",
        "CALL:FIRE",
        "ADDR:1904 OLD MILL RD",
        "X:MT GAPRD / BROWN RD",
        "CITY:RICHBURG",
        "NAME:ELIZABETH SHYTLE",
        "PHONE:8035812424",
        "ID:2012-0000049810");

    doTest("T12",
        "CHESTER_911:1070 >FIRE 1656 J BASS DR XS: CROWS NEST OFF SIMPSON EDGEMOOR FRANCISCO LOZANO 8035240312 Map: Grids:0,0 Cad: 2012-0000049731\r\n",
        "CODE:1070",
        "CALL:FIRE",
        "ADDR:1656 J BASS DR",
        "X:CROWS NEST OFF SIMPSON",
        "CITY:EDGEMOOR",
        "NAME:FRANCISCO LOZANO",
        "PHONE:8035240312",
        "ID:2012-0000049731");

    doTest("T13",
        "CHESTER_911:1070 >FIRE 4006 LEWISVILLE HIGH SCH RD XS: LANCASTER HWY RICHBURG SCHOOLS PUBLIC/JOANN 8037895164 Map: Grids:0,0 Cad: 2012-0000049703\r\n",
        "CODE:1070",
        "CALL:FIRE",
        "ADDR:4006 LEWISVILLE HIGH SCH RD",
        "X:LANCASTER HWY",
        "CITY:RICHBURG",
        "NAME:SCHOOLS PUBLIC/JOANN",
        "PHONE:8037895164",
        "ID:2012-0000049703");

    doTest("T14",
        "CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT I77 S MM68 JOHNNY CHAPMAN 3369770170 Cad: 2012-0000049371\r\n",
        "CODE:1050",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:I-77 S",
        "MADDR:I 77 S",
        "NAME:MM68 JOHNNY CHAPMAN",
        "PHONE:3369770170",
        "ID:2012-0000049371");

    doTest("T15",
        "CHESTER_911:1052P1>EMS NEEDED PRIORITY 1 124 WILLIAM STEVENSON RD XS: WEST LANCASTER ST RICHBURG AT&T MOBILITY 8033792886 Map: Grids:0,0 Cad: 2012-0000049258\r\n",
        "CODE:1052P1",
        "CALL:EMS NEEDED PRIORITY 1",
        "ADDR:124 WILLIAM STEVENSON RD",
        "X:WEST LANCASTER ST",
        "CITY:RICHBURG",
        "PHONE:8033792886",
        "ID:2012-0000049258");

  }
  
  @Test
  public void testChesterCountyRescue() {

    doTest("T1",
        "CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT 786 OLD YORK RD CHESTER Map: Grids:0,0 Cad: 2012-0000051326\r\n",
        "CODE:1050",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:786 OLD YORK RD",
        "CITY:CHESTER",
        "ID:2012-0000051326");

    doTest("T2",
        "CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT 707 SWEENEY ST XS: LEE ST // BEACHAM ST CHESTER ALLIED WIRELESS 877.510.4357 8036019096 Map: Grids:0,0 Cad: 2012-0000051180\r\n",
        "CODE:1050",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:707 SWEENEY ST",
        "X:LEE ST / BEACHAM ST",
        "CITY:CHESTER",
        "NAME:ALLIED WIRELESS 877.510.4357",
        "PHONE:8036019096",
        "ID:2012-0000051180");

    doTest("T3",
        "CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT WESTBROOK RD@SIMPSON RD XS: EDGELAND TO CATAWBA RIVER RD EDGEMOOR JESSE LAND 8037895641 Cad: 2012-0000051176\r\n",
        "CODE:1050",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:WESTBROOK RD & SIMPSON RD",
        "X:EDGELAND TO CATAWBA RIVER RD",
        "CITY:EDGEMOOR",
        "NAME:JESSE LAND",
        "PHONE:8037895641",
        "ID:2012-0000051176");

    doTest("T4",
        "CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT 4760 HARMONY CH RD XS: WYLIES MILL RD HWY 223 EDGEMOOR MYRA BRAGGS 8037893557 Map: Grids:0,0 Cad: 2012-0000051070\r\n",
        "CODE:1050",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:4760 HARMONY CH RD",
        "X:WYLIES MILL RD HWY 223",
        "CITY:EDGEMOOR",
        "NAME:MYRA BRAGGS",
        "PHONE:8037893557",
        "ID:2012-0000051070");

    doTest("T5",
        "CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT MOFFITT CREEK RD XS: GREAT FALLS HWY / SHANNON RD BLACKSTOCK ALLIED WIRELESS 877.510.4357 8035196155 Map: Grids:0,0 Cad: 2012-0000050777\r\n",
        "CODE:1050",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:MOFFITT CREEK RD",
        "MADDR:MOFFITT CREEK RD & GREAT FALLS HWY",
        "X:GREAT FALLS HWY / SHANNON RD",
        "CITY:BLACKSTOCK",
        "NAME:ALLIED WIRELESS 877.510.4357",
        "PHONE:8035196155",
        "ID:2012-0000050777");

    doTest("T6",
        "CHESTER_911:1052P2>EMS NEEDED PRIORITY 2 132 MARTIN LUTHER KING DR XS: STADIUM DR / HOPE ST CHESTER LATISHA EVANS 8035813557 Map: Grids:0,0 Cad: 2012-0000050497\r\n",
        "CODE:1052P2",
        "CALL:EMS NEEDED PRIORITY 2",
        "ADDR:132 MARTIN LUTHER KING DR",  // not mapping
        "X:STADIUM DR / HOPE ST",
        "CITY:CHESTER",
        "NAME:LATISHA EVANS",
        "PHONE:8035813557",
        "ID:2012-0000050497");

    doTest("T7",
        "CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT 72 NEAR MCCANDLESS RD AMY 8032095909 Cad: 2012-0000050438\r\n",
        "CODE:1050",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:72 NEAR MCCANDLESS RD",
        "MADDR:72 & MCCANDLESS RD",
        "NAME:AMY",
        "PHONE:8032095909",
        "ID:2012-0000050438");

    doTest("T8",
        "CHESTER_911:1050 >MOTOR VEHICLE ACCIDENT 3986 FAIRFIELD RD XS: WEST END RD CARLISLE REBECCA 8033747439 Map: Grids:0,0 Cad: 2012-0000050205\r\n",
        "CODE:1050",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:3986 FAIRFIELD RD",
        "X:WEST END RD",
        "NAME:CARLISLE REBECCA",
        "PHONE:8033747439",
        "ID:2012-0000050205");

    doTest("T9",
        "CHESTER_911:1048 >SUSPICIOUS VEHICLE STOP HENRY AT WEST END Cad: 2012-0000050151\r\n",
        "CODE:1048",
        "CALL:SUSPICIOUS VEHICLE STOP",
        "ADDR:HENRY AT WEST END",
        "ID:2012-0000050151");

  }
  
  public static void main(String[] args) {
    new SCChesterCountyParserTest().generateTests("T1");
  }
}