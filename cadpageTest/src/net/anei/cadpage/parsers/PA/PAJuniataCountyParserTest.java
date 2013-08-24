package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PAJuniataCountyParserTest;

import org.junit.Test;

/*
Juniata County, PA
Contact: Wendy Varner <wendy.s.varner@gmail.com>
Sender: UNIATA911@Juniata.PA

FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:EATMNT>ALTERED MENTAL STATUS 3931 WILLIAM PENN HWY FERMANAGH ANITA Map: Grids:, Cad: 2012-0000000151
FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:EATMNT>ALTERED MENTAL STATUS 3931 WILLIAM PENN HWY FERMANAGH ANITA Map: Grids:, Cad: 2012-0000000151
FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:ECPA >CHEST PAIN 21 WALLEYE DR FERMANAGH HALEY FOLK Map: Grids:, Cad: 2012-0000000131
FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:EILLB >ILL PERSON 68 LEXI ST FERMANAGH BERRY'S PERSONAL /ELIZABETH Map: Grids:, Cad: 2012-0000000126
FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:EILLB >ILL PERSON 69 COTTAGE RD MILFORD LOCUST GROVE RETIREMENT VILLAG Map: Grids:, Cad: 2012-00

Contact: Adam Waite <ffemt@nmax.net>
Company 4 - Fayette Fire Co, McAlisterville, pa , 17049
FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:FFSTR >FIRE RESIDENTIAL 2364 DUNN VALLEY RD FAYETTE HANES Map: Grids:, Cad: 2012-0000000162
FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:EUNREA>UNRESPONSIVE / SYNCOPE ALS 289 SWAILES RD FAYETTE ZEIGLER, JOHN T Cad: 2012-0000000153
FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:FFI >FIRE INDUSTRIAL 1341 TROYER RD FAYETTE MARTIN WEAVER Map: Grids:, Cad: 2012-0000000070
FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:FACCVI>ACCIDENT MVA WITH INJURIES 29979 RT 35 N FAYETTE KAILEY FIKE Map: Grids:, Cad: 2011-0000004725

Company 1 EMS, Port Royal EMS. Port royal, pa 17082
FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:EMDALM>MEDICAL ALARM 1652 DOE RUN RD WALKER LIFE LINE Map: Grids:, Cad: 2012-0000000160
FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:ECARPR>CARDIAC PROBLEMS RT 75 S TUSCARORA AMB 225-1 Map: Grids:, Cad: 2012-0000000130
FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:EFALLB>FALLS/ACCIDENTS BLS 807 MARKET ST PORT ROYAL CINDY BIDDING Map: Grids:, Cad: 2012-0000000112
FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:ECPA >CHEST PAIN 419 TUSCARORA ST PORT ROYAL MIKE KAUFFMAN Map: Grids:, Cad: 2012-0000000089
FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:FACCVI>ACCIDENT MVA WITH INJURIES 13911 RT 75 S TUSCARORA JESE WILMAN Map: Grids:, Cad: 2012-0000000013
FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:FACCVI>ACCIDENT MVA WITH INJURIES 3108 RT 322 E FERMANAGH TERRY STONER Cad: 2011-0000004761

Contact: Active911
Agency name: Thompsontown Vol. Fire Co.
Location: Thompsontown, PA, United States
Sender: JUNIATA911@Juniata.PA

JUNIATA911:EFALLB>FALLS/ACCIDENTS BLS 99 NORTH RIDGE DR XS: OFF MOUNTAIN RD FAYETTE ROBIN Map: Grids:, Cad: 2013-0000002458
JUNIATA911:EILLB >ILL PERSON 76 MARY LN XS: OFF FAIRVIEW RD FAYETTE EHRENZELLER, RITA Map: Grids:, Cad: 2013-0000002447
JUNIATA911:ESTROA>STROKE 9 CONARD LN XS: OFF BLUEBIRD LN WALKER GRAYBILL, DONALD C JR Map: Grids:, Cad: 2013-0000002441
JUNIATA911:EUNREA>UNRESPONSIVE / SYNCOPE ALS 541 WEST MAIN ST THOMPSONTOWN COX RES Map: Grids:, Cad: 2013-0000002439
JUNIATA911:FACCVI>ACCIDENT MVA WITH INJURIES 99 NORTH RIDGE DR XS: OFF MOUNTAIN RD FAYETTE NANCY PERKINS Map: Grids:, Cad: 2013-0000002417
JUNIATA911:FFAG >FIRE AGRICULTURE 1221 RIDGE RD XS: HEISTER VALLEY RD TO BUCKWHEAT VALLEY RD WEST PERRY MIKE MARTIN Map: Grids:, Cad: 2013-0000002413
JUNIATA911:ESOBA >BREATHING DIFFICULTY 391 MOUNTAIN RD GREENWOOD MGGALLIN Cad: 2013-0000002381
JUNIATA911:FFWIL >FIRE WILD 259 DUWARD STATION LN XS: RT 333 AND COPPERHEAD LN DELAWARE CHRIS SHAWVER Map: Grids:, Cad: 2013-0000002377
JUNIATA911:EATMNT>ALTERED MENTAL STATUS 7523 RT 235 XS: BLACK DOG RD TO CEMETARY RD DELAWARE DUNN, JACK E Map: Grids:, Cad: 2013-0000002376
JUNIATA911:LSUICT>SUICIDE THREAT 411 OAKHURST LN XS: OFF EAST MAIN ST DELAWARE KATHY SWARTZ Map: Grids:, Cad: 2013-0000002372
JUNIATA911:EABB >ABDOMINAL / BACK PAIN BLS 1628 BURNS RD XS: JONESTOWN RD TO COLYER ST DELAWARE GABEL, STANLEY J Map: Grids:, Cad: 2013-0000002371
JUNIATA911:EFALLB>FALLS/ACCIDENTS BLS 12 EAST MAIN ST XS: N MILL ST TO DELAWARE ST THOMPSONTOWN BONNIE MCNEMAR Map: Grids:, Cad: 2013-0000002365
JUNIATA911:EUNREB>UNRESPONSIVE / SYNCOPE BLS 12393 WILLIAM PENN HWY DELAWARE KRAMER Map: Grids:, Cad: 2013-0000002351
JUNIATA911:EDIABA>DIABETIC ALS 217 EAST MAIN ST XS: N MILL ST TO DELAWARE ST THOMPSONTOWN THOMPSONTOWN CORNER DELI Map: Grids:, Cad: 2013-0000002340
JUNIATA911:FFSTR >FIRE RESIDENTIAL 5366 RT 75 S XS: OLD MILL LN AND PUMPING STATION RD LACK CLAYTON Map: Grids:, Cad: 2013-0000002335
JUNIATA911:EILLB >ILL PERSON 2326 GOODVILLE RD XS: RT 333 TO COCOLAMUS CREEK RD DELAWARE DUNN, HOYLE Map: Grids:, Cad: 2013-0000002325
JUNIATA911:EILLB >ILL PERSON 2326 GOODVILLE RD XS: RT 333 TO COCOLAMUS CREEK RD DELAWARE DUNN, HOYLE Map: Grids:, Cad: 2013-0000002325
JUNIATA911:EMDALM>MEDICAL ALARM 58 HONAMAN HOUSE DR Apt: 213 Bldg XS: OFF EAST MAIN ST THOMPSONTOWN HONAMAN HOUSE AMCEST ALARM Map: Grids:, Cad: 2013-0000002319
JUNIATA911:EFALLB>FALLS/ACCIDENTS BLS 700 PFOUTZ VALLEY RD XS: PERRY COUNTY LINE TO WILLIAMPENN HWY DELAWARE BRODISH RESIDENCE Map: Grids:, Cad: 2013-0000002318
JUNIATA911:EABB >ABDOMINAL / BACK PAIN BLS 12393 WILLIAM PENN HWY DELAWARE MIKE LOVE Map: Grids:, Cad: 2013-0000002316
JUNIATA911:ECPA >CHEST PAIN 319 MILL RD XS: OFF RT 333 DELAWARE JAMES GARMAN Map: Grids:, Cad: 2013-0000002314
JUNIATA911:EILLB >ILL PERSON 151 TEXS PARK DR DELAWARE CAMERON, A J Map: Grids:, Cad: 2013-0000002300
JUNIATA911:ECPA >CHEST PAIN 372 EAST SALEM RD Apt: 5 Bldg XS: RT 333 TO RT 235 DELAWARE ELIZABETH Map: Grids:, Cad: 2013-0000002294
JUNIATA911:FFAG >FIRE AGRICULTURE 62 BAIR LN XS: TOWN RIDGE RD AND SWALES RD FAYETTE BAIR, WADE & KIM Map: Grids:, Cad: 2013-0000002286
JUNIATA911:FFSTR >FIRE RESIDENTIAL 2301 BERRY RIDGE RD XS: CAMPBELL HOLLOW RD AND PUMPING STATION RD LACK PAULA / SHEAFFER RES Map: Grids:, Cad: 2013-0000002282

*/

public class PAJuniataCountyParserTest extends BaseParserTest {
  
  public PAJuniataCountyParserTest() {
    setParser(new PAJuniataCountyParser(), "JUNIATA COUNTY", "PA");
  }

 
  
  @Test
  public void testFermanagh() {

    doTest("T1",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:EATMNT>ALTERED MENTAL STATUS 3931 WILLIAM PENN HWY FERMANAGH ANITA Map: Grids:, Cad: 2012-0000000151",
        "CODE:EATMNT",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:3931 WILLIAM PENN HWY",
        "CITY:FERMANAGH",
        "NAME:ANITA",
        "ID:2012-0000000151");

    doTest("T2",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:EATMNT>ALTERED MENTAL STATUS 3931 WILLIAM PENN HWY FERMANAGH ANITA Map: Grids:, Cad: 2012-0000000151",
        "CODE:EATMNT",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:3931 WILLIAM PENN HWY",
        "CITY:FERMANAGH",
        "NAME:ANITA",
        "ID:2012-0000000151");

    doTest("T3",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:ECPA >CHEST PAIN 21 WALLEYE DR FERMANAGH HALEY FOLK Map: Grids:, Cad: 2012-0000000131",
        "CODE:ECPA",
        "CALL:CHEST PAIN",
        "ADDR:21 WALLEYE DR",
        "CITY:FERMANAGH",
        "NAME:HALEY FOLK",
        "ID:2012-0000000131");

    doTest("T4",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:EILLB >ILL PERSON 68 LEXI ST FERMANAGH BERRY'S PERSONAL /ELIZABETH Map: Grids:, Cad: 2012-0000000126",
        "CODE:EILLB",
        "CALL:ILL PERSON",
        "ADDR:68 LEXI ST",
        "CITY:FERMANAGH",
        "NAME:BERRY'S PERSONAL /ELIZABETH",
        "ID:2012-0000000126");

    doTest("T5",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:EILLB >ILL PERSON 69 COTTAGE RD MILFORD LOCUST GROVE RETIREMENT VILLAG Map: Grids:, Cad: 2012-00",
        "CODE:EILLB",
        "CALL:ILL PERSON",
        "ADDR:69 COTTAGE RD",
        "CITY:MILFORD",
        "NAME:LOCUST GROVE RETIREMENT VILLAG",
        "ID:2012-00");
  }
  
  @Test
  public void testFayette() {

    doTest("T1",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:FFSTR >FIRE RESIDENTIAL 2364 DUNN VALLEY RD FAYETTE HANES Map: Grids:, Cad: 2012-0000000162",
        "CODE:FFSTR",
        "CALL:FIRE RESIDENTIAL",
        "ADDR:2364 DUNN VALLEY RD",
        "CITY:FAYETTE",
        "NAME:HANES",
        "ID:2012-0000000162");

    doTest("T2",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:EUNREA>UNRESPONSIVE / SYNCOPE ALS 289 SWAILES RD FAYETTE ZEIGLER, JOHN T Cad: 2012-0000000153",
        "CODE:EUNREA",
        "CALL:UNRESPONSIVE / SYNCOPE ALS",
        "ADDR:289 SWAILES RD",
        "CITY:FAYETTE",
        "NAME:ZEIGLER, JOHN T",
        "ID:2012-0000000153");

    doTest("T3",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:FFI >FIRE INDUSTRIAL 1341 TROYER RD FAYETTE MARTIN WEAVER Map: Grids:, Cad: 2012-0000000070",
        "CODE:FFI",
        "CALL:FIRE INDUSTRIAL",
        "ADDR:1341 TROYER RD",
        "CITY:FAYETTE",
        "NAME:MARTIN WEAVER",
        "ID:2012-0000000070");

    doTest("T4",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:FACCVI>ACCIDENT MVA WITH INJURIES 29979 RT 35 N FAYETTE KAILEY FIKE Map: Grids:, Cad: 2011-0000004725",
        "CODE:FACCVI",
        "CALL:ACCIDENT MVA WITH INJURIES",
        "ADDR:29979 RT 35 N",
        "CITY:FAYETTE",
        "NAME:KAILEY FIKE",
        "ID:2011-0000004725");
  }
  
  @Test
  public void testPortRoyale() {

    doTest("T1",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:EMDALM>MEDICAL ALARM 1652 DOE RUN RD WALKER LIFE LINE Map: Grids:, Cad: 2012-0000000160",
        "CODE:EMDALM",
        "CALL:MEDICAL ALARM",
        "ADDR:1652 DOE RUN RD",
        "CITY:WALKER",
        "NAME:LIFE LINE",
        "ID:2012-0000000160");

    doTest("T2",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:ECARPR>CARDIAC PROBLEMS RT 75 S TUSCARORA AMB 225-1 Map: Grids:, Cad: 2012-0000000130",
        "CODE:ECARPR",
        "CALL:CARDIAC PROBLEMS",
        "ADDR:RT 75 S",
        "CITY:TUSCARORA",
        "NAME:AMB 225-1",
        "ID:2012-0000000130");

    doTest("T3",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:EFALLB>FALLS/ACCIDENTS BLS 807 MARKET ST PORT ROYAL CINDY BIDDING Map: Grids:, Cad: 2012-0000000112",
        "CODE:EFALLB",
        "CALL:FALLS/ACCIDENTS BLS",
        "ADDR:807 MARKET ST",
        "CITY:PORT ROYAL",
        "NAME:CINDY BIDDING",
        "ID:2012-0000000112");

    doTest("T4",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:ECPA >CHEST PAIN 419 TUSCARORA ST PORT ROYAL MIKE KAUFFMAN Map: Grids:, Cad: 2012-0000000089",
        "CODE:ECPA",
        "CALL:CHEST PAIN",
        "ADDR:419 TUSCARORA ST",
        "CITY:PORT ROYAL",
        "NAME:MIKE KAUFFMAN",
        "ID:2012-0000000089");

    doTest("T5",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:FACCVI>ACCIDENT MVA WITH INJURIES 13911 RT 75 S TUSCARORA JESE WILMAN Map: Grids:, Cad: 2012-0000000013",
        "CODE:FACCVI",
        "CALL:ACCIDENT MVA WITH INJURIES",
        "ADDR:13911 RT 75 S",
        "CITY:TUSCARORA",
        "NAME:JESE WILMAN",
        "ID:2012-0000000013");

    doTest("T6",
        "FRM:JUNIATA911@Juniata.PA\nMSG:JUNIATA911:FACCVI>ACCIDENT MVA WITH INJURIES 3108 RT 322 E FERMANAGH TERRY STONER Cad: 2011-0000004761",
        "CODE:FACCVI",
        "CALL:ACCIDENT MVA WITH INJURIES",
        "ADDR:3108 RT 322 E",
        "CITY:FERMANAGH",
        "NAME:TERRY STONER",
        "ID:2011-0000004761");

  }
  
  @Test
  public void testThompsonTownVolFireDept() {

    doTest("T1",
        "JUNIATA911:EFALLB>FALLS/ACCIDENTS BLS 99 NORTH RIDGE DR XS: OFF MOUNTAIN RD FAYETTE ROBIN Map: Grids:, Cad: 2013-0000002458",
        "CODE:EFALLB",
        "CALL:FALLS/ACCIDENTS BLS",
        "ADDR:99 NORTH RIDGE DR",
        "X:OFF MOUNTAIN RD",
        "CITY:FAYETTE",  // Googles says this is in McAllisterville
        "NAME:ROBIN",
        "ID:2013-0000002458");

    doTest("T2",
        "JUNIATA911:EILLB >ILL PERSON 76 MARY LN XS: OFF FAIRVIEW RD FAYETTE EHRENZELLER, RITA Map: Grids:, Cad: 2013-0000002447",
        "CODE:EILLB",
        "CALL:ILL PERSON",
        "ADDR:76 MARY LN",
        "X:OFF FAIRVIEW RD",
        "CITY:FAYETTE",
        "NAME:EHRENZELLER, RITA",
        "ID:2013-0000002447");

    doTest("T3",
        "JUNIATA911:ESTROA>STROKE 9 CONARD LN XS: OFF BLUEBIRD LN WALKER GRAYBILL, DONALD C JR Map: Grids:, Cad: 2013-0000002441",
        "CODE:ESTROA",
        "CALL:STROKE",
        "ADDR:9 CONARD LN",
        "X:OFF BLUEBIRD LN",
        "CITY:WALKER",
        "NAME:GRAYBILL, DONALD C JR",
        "ID:2013-0000002441");

    doTest("T4",
        "JUNIATA911:EUNREA>UNRESPONSIVE / SYNCOPE ALS 541 WEST MAIN ST THOMPSONTOWN COX RES Map: Grids:, Cad: 2013-0000002439",
        "CODE:EUNREA",
        "CALL:UNRESPONSIVE / SYNCOPE ALS",
        "ADDR:541 WEST MAIN ST",
        "CITY:THOMPSONTOWN",
        "NAME:COX RES",
        "ID:2013-0000002439");

    doTest("T5",
        "JUNIATA911:FACCVI>ACCIDENT MVA WITH INJURIES 99 NORTH RIDGE DR XS: OFF MOUNTAIN RD FAYETTE NANCY PERKINS Map: Grids:, Cad: 2013-0000002417",
        "CODE:FACCVI",
        "CALL:ACCIDENT MVA WITH INJURIES",
        "ADDR:99 NORTH RIDGE DR",
        "X:OFF MOUNTAIN RD",
        "CITY:FAYETTE",
        "NAME:NANCY PERKINS",
        "ID:2013-0000002417");

    doTest("T6",
        "JUNIATA911:FFAG >FIRE AGRICULTURE 1221 RIDGE RD XS: HEISTER VALLEY RD TO BUCKWHEAT VALLEY RD WEST PERRY MIKE MARTIN Map: Grids:, Cad: 2013-0000002413",
        "CODE:FFAG",
        "CALL:FIRE AGRICULTURE",
        "ADDR:1221 RIDGE RD",
        "X:HEISTER VALLEY RD",
        "NAME:TO BUCKWHEAT VALLEY RD WEST PERRY MIKE MARTIN",
        "ID:2013-0000002413");

    doTest("T7",
        "JUNIATA911:ESOBA >BREATHING DIFFICULTY 391 MOUNTAIN RD GREENWOOD MGGALLIN Cad: 2013-0000002381",
        "CODE:ESOBA",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:391 MOUNTAIN RD",
        "CITY:GREENWOOD",
        "NAME:MGGALLIN",
        "ID:2013-0000002381");

    doTest("T8",
        "JUNIATA911:FFWIL >FIRE WILD 259 DUWARD STATION LN XS: RT 333 AND COPPERHEAD LN DELAWARE CHRIS SHAWVER Map: Grids:, Cad: 2013-0000002377",
        "CODE:FFWIL",
        "CALL:FIRE WILD",
        "ADDR:259 DUWARD STATION LN",  // Not mapping
        "X:RT 333 AND COPPERHEAD LN",
        "CITY:DELAWARE",
        "NAME:CHRIS SHAWVER",
        "ID:2013-0000002377");

    doTest("T9",
        "JUNIATA911:EATMNT>ALTERED MENTAL STATUS 7523 RT 235 XS: BLACK DOG RD TO CEMETARY RD DELAWARE DUNN, JACK E Map: Grids:, Cad: 2013-0000002376",
        "CODE:EATMNT",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:7523 RT 235",
        "X:BLACK DOG RD TO CEMETARY RD",
        "CITY:DELAWARE",
        "NAME:DUNN, JACK E",
        "ID:2013-0000002376");

    doTest("T10",
        "JUNIATA911:LSUICT>SUICIDE THREAT 411 OAKHURST LN XS: OFF EAST MAIN ST DELAWARE KATHY SWARTZ Map: Grids:, Cad: 2013-0000002372",
        "CODE:LSUICT",
        "CALL:SUICIDE THREAT",
        "ADDR:411 OAKHURST LN", // Not maping
        "X:OFF EAST MAIN ST",
        "CITY:DELAWARE",
        "NAME:KATHY SWARTZ",
        "ID:2013-0000002372");

    doTest("T11",
        "JUNIATA911:EABB >ABDOMINAL / BACK PAIN BLS 1628 BURNS RD XS: JONESTOWN RD TO COLYER ST DELAWARE GABEL, STANLEY J Map: Grids:, Cad: 2013-0000002371",
        "CODE:EABB",
        "CALL:ABDOMINAL / BACK PAIN BLS",
        "ADDR:1628 BURNS RD",
        "X:JONESTOWN RD TO COLYER ST",
        "CITY:DELAWARE",
        "NAME:GABEL, STANLEY J",
        "ID:2013-0000002371");

    doTest("T12",
        "JUNIATA911:EFALLB>FALLS/ACCIDENTS BLS 12 EAST MAIN ST XS: N MILL ST TO DELAWARE ST THOMPSONTOWN BONNIE MCNEMAR Map: Grids:, Cad: 2013-0000002365",
        "CODE:EFALLB",
        "CALL:FALLS/ACCIDENTS BLS",
        "ADDR:12 EAST MAIN ST",
        "X:N MILL ST TO DELAWARE ST",
        "CITY:THOMPSONTOWN",
        "NAME:BONNIE MCNEMAR",
        "ID:2013-0000002365");

    doTest("T13",
        "JUNIATA911:EUNREB>UNRESPONSIVE / SYNCOPE BLS 12393 WILLIAM PENN HWY DELAWARE KRAMER Map: Grids:, Cad: 2013-0000002351",
        "CODE:EUNREB",
        "CALL:UNRESPONSIVE / SYNCOPE BLS",
        "ADDR:12393 WILLIAM PENN HWY",
        "CITY:DELAWARE",
        "NAME:KRAMER",
        "ID:2013-0000002351");

    doTest("T14",
        "JUNIATA911:EDIABA>DIABETIC ALS 217 EAST MAIN ST XS: N MILL ST TO DELAWARE ST THOMPSONTOWN THOMPSONTOWN CORNER DELI Map: Grids:, Cad: 2013-0000002340",
        "CODE:EDIABA",
        "CALL:DIABETIC ALS",
        "ADDR:217 EAST MAIN ST",
        "X:N MILL ST TO DELAWARE ST",
        "CITY:THOMPSONTOWN",
        "NAME:THOMPSONTOWN CORNER DELI",
        "ID:2013-0000002340");

    doTest("T15",
        "JUNIATA911:FFSTR >FIRE RESIDENTIAL 5366 RT 75 S XS: OLD MILL LN AND PUMPING STATION RD LACK CLAYTON Map: Grids:, Cad: 2013-0000002335",
        "CODE:FFSTR",
        "CALL:FIRE RESIDENTIAL",
        "ADDR:5366 RT 75 S",
        "X:OLD MILL LN AND PUMPING STATION RD",
        "CITY:LACK",
        "NAME:CLAYTON",
        "ID:2013-0000002335");

    doTest("T16",
        "JUNIATA911:EILLB >ILL PERSON 2326 GOODVILLE RD XS: RT 333 TO COCOLAMUS CREEK RD DELAWARE DUNN, HOYLE Map: Grids:, Cad: 2013-0000002325",
        "CODE:EILLB",
        "CALL:ILL PERSON",
        "ADDR:2326 GOODVILLE RD",
        "X:RT 333 TO COCOLAMUS CREEK RD",
        "CITY:DELAWARE",
        "NAME:DUNN, HOYLE",
        "ID:2013-0000002325");

    doTest("T17",
        "JUNIATA911:EILLB >ILL PERSON 2326 GOODVILLE RD XS: RT 333 TO COCOLAMUS CREEK RD DELAWARE DUNN, HOYLE Map: Grids:, Cad: 2013-0000002325",
        "CODE:EILLB",
        "CALL:ILL PERSON",
        "ADDR:2326 GOODVILLE RD",
        "X:RT 333 TO COCOLAMUS CREEK RD",
        "CITY:DELAWARE",
        "NAME:DUNN, HOYLE",
        "ID:2013-0000002325");

    doTest("T18",
        "JUNIATA911:EMDALM>MEDICAL ALARM 58 HONAMAN HOUSE DR Apt: 213 Bldg XS: OFF EAST MAIN ST THOMPSONTOWN HONAMAN HOUSE AMCEST ALARM Map: Grids:, Cad: 2013-0000002319",
        "CODE:EMDALM",
        "CALL:MEDICAL ALARM",
        "ADDR:58 HONAMAN HOUSE DR",  // Not mapping
        "APT:213 Bldg",
        "X:OFF EAST MAIN ST",
        "CITY:THOMPSONTOWN",
        "NAME:HONAMAN HOUSE AMCEST ALARM",
        "ID:2013-0000002319");

    doTest("T19",
        "JUNIATA911:EFALLB>FALLS/ACCIDENTS BLS 700 PFOUTZ VALLEY RD XS: PERRY COUNTY LINE TO WILLIAMPENN HWY DELAWARE BRODISH RESIDENCE Map: Grids:, Cad: 2013-0000002318",
        "CODE:EFALLB",
        "CALL:FALLS/ACCIDENTS BLS",
        "ADDR:700 PFOUTZ VALLEY RD",
        "X:PERRY COUNTY LINE TO WILLIAMPENN HWY",
        "CITY:DELAWARE",
        "NAME:BRODISH RESIDENCE",
        "ID:2013-0000002318");

    doTest("T20",
        "JUNIATA911:EABB >ABDOMINAL / BACK PAIN BLS 12393 WILLIAM PENN HWY DELAWARE MIKE LOVE Map: Grids:, Cad: 2013-0000002316",
        "CODE:EABB",
        "CALL:ABDOMINAL / BACK PAIN BLS",
        "ADDR:12393 WILLIAM PENN HWY",
        "CITY:DELAWARE",
        "NAME:MIKE LOVE",
        "ID:2013-0000002316");

    doTest("T21",
        "JUNIATA911:ECPA >CHEST PAIN 319 MILL RD XS: OFF RT 333 DELAWARE JAMES GARMAN Map: Grids:, Cad: 2013-0000002314",
        "CODE:ECPA",
        "CALL:CHEST PAIN",
        "ADDR:319 MILL RD",
        "X:OFF RT 333",
        "CITY:DELAWARE",
        "NAME:JAMES GARMAN",
        "ID:2013-0000002314");

    doTest("T22",
        "JUNIATA911:EILLB >ILL PERSON 151 TEXS PARK DR DELAWARE CAMERON, A J Map: Grids:, Cad: 2013-0000002300",
        "CODE:EILLB",
        "CALL:ILL PERSON",
        "ADDR:151 TEXS PARK DR",
        "CITY:DELAWARE",
        "NAME:CAMERON, A J",
        "ID:2013-0000002300");

    doTest("T23",
        "JUNIATA911:ECPA >CHEST PAIN 372 EAST SALEM RD Apt: 5 Bldg XS: RT 333 TO RT 235 DELAWARE ELIZABETH Map: Grids:, Cad: 2013-0000002294",
        "CODE:ECPA",
        "CALL:CHEST PAIN",
        "ADDR:372 EAST SALEM RD",
        "APT:5 Bldg",
        "X:RT 333 TO RT 235",
        "CITY:DELAWARE",
        "NAME:ELIZABETH",
        "ID:2013-0000002294");

    doTest("T24",
        "JUNIATA911:FFAG >FIRE AGRICULTURE 62 BAIR LN XS: TOWN RIDGE RD AND SWALES RD FAYETTE BAIR, WADE & KIM Map: Grids:, Cad: 2013-0000002286",
        "CODE:FFAG",
        "CALL:FIRE AGRICULTURE",
        "ADDR:62 BAIR LN",
        "X:TOWN RIDGE RD AND SWALES RD",
        "CITY:FAYETTE",
        "NAME:BAIR, WADE & KIM",
        "ID:2013-0000002286");

    doTest("T25",
        "JUNIATA911:FFSTR >FIRE RESIDENTIAL 2301 BERRY RIDGE RD XS: CAMPBELL HOLLOW RD AND PUMPING STATION RD LACK PAULA / SHEAFFER RES Map: Grids:, Cad: 2013-0000002282",
        "CODE:FFSTR",
        "CALL:FIRE RESIDENTIAL",
        "ADDR:2301 BERRY RIDGE RD", // Not mapping
        "X:CAMPBELL HOLLOW RD AND PUMPING STATION RD",
        "CITY:LACK",
        "NAME:PAULA / SHEAFFER RES",
        "ID:2013-0000002282");
   
  }
  
  public static void main(String[] args) {
    new PAJuniataCountyParserTest().generateTests("T1");
  }
}