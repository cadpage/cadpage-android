package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXKellerParserTest extends BaseParserTest {
  
  public TXKellerParserTest() {
    setParser(new TXKellerParser(), "TARRANT COUNTY", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 7401 WINDSWEPT TRL, Colleyville\nBANDIT TRL//\n Fire Box = 2310",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:7401 WINDSWEPT TRL",
        "CITY:Colleyville",
        "X:BANDIT TRL",
        "BOX:2310");

    doTest("T2",
        "(MEDICAL EMERGENCY) \n" +
        "MEDICAL EMERGENCY\n" +
        "-Walgreens Glade Rd- 3830 Glade Rd,Box308 Colleyville\n" +
        "HERITAGE AVE//COPPERGLEN CIR\n" +
        " Fire Box = 2241",

        "CALL:MEDICAL EMERGENCY",
        "PLACE:Walgreens Glade Rd",
        "ADDR:3830 Glade Rd, Box 308",
        "MADDR:3830 Glade Rd",
        "CITY:Colleyville",
        "X:HERITAGE AVE/COPPERGLEN CIR",
        "BOX:2241");

    doTest("T3",
        "(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n--  HALL JOHNSON RD, Colleyville\nSYCAMORE DR//\n Fire Box = 2129",
        "CALL:MAJOR ACCIDENT",
        "ADDR:HALL JOHNSON RD",
        "MADDR:HALL JOHNSON RD & SYCAMORE DR",
        "CITY:Colleyville",
        "X:SYCAMORE DR",
        "BOX:2129");

    doTest("T4",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5101 BLUEBONNET DR, Colleyville\nRIVERWALK DR//\n Fire Box = 2137",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:5101 BLUEBONNET DR",
        "CITY:Colleyville",
        "X:RIVERWALK DR",
        "BOX:2137");

    doTest("T5",
        "(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n--  PLEASANT RUN, Colleyville\n//\n Fire Box = 2136",
        "CALL:MAJOR ACCIDENT",
        "ADDR:PLEASANT RUN",
        "CITY:Colleyville",
        "BOX:2136");

    doTest("T6",
        "(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n-- 921 SHADY LAKE DR - BEDFORD, Colleyville\n//\n Fire Box =",
        "CALL:MUTUAL AID - FIRE",
        "ADDR:921 SHADY LAKE DR",
        "CITY:BEDFORD");

    doTest("T7",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 3708 BRIARHAVEN LN, Colleyville\nGREENBRIAR LN//NULL\n Fire Box = 2153",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:3708 BRIARHAVEN LN",
        "CITY:Colleyville",
        "X:GREENBRIAR LN",
        "BOX:2153");

    doTest("T8",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4008 WINDVIEW DR, Colleyville\nCHEEK SPARGER RD//\n Fire Box = 2156",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4008 WINDVIEW DR",
        "CITY:Colleyville",
        "X:CHEEK SPARGER RD",
        "BOX:2156");

    doTest("T9",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4904 JIM MITCHELL TRL E, Colleyville\nGLADE RD//NULL\n Fire Box = 2249",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4904 JIM MITCHELL TRL E",
        "CITY:Colleyville",
        "X:GLADE RD",
        "BOX:2249");

    doTest("T10",
        "(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 4002 ELMWOOD CT, Colleyville\nPLANTATION DR S//NULL\n Fire Box = 2154",
        "CALL:FIRE ALARM - RESIDENTIAL",
        "ADDR:4002 ELMWOOD CT",
        "CITY:Colleyville",
        "X:PLANTATION DR S",
        "BOX:2154");

    doTest("T11",
        "(PUBLIC SERVICE) \nPUBLIC SERVICE\n-- 213 WHITE DR, Colleyville\nWESTCOAT DR//\n Fire Box = 2319",
        "CALL:PUBLIC SERVICE",
        "ADDR:213 WHITE DR",
        "CITY:Colleyville",
        "X:WESTCOAT DR",
        "BOX:2319");

    doTest("T12",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4608 JIM MITCHELL TRL W, Colleyville\nGLADE RD//NULL\n Fire Box = 2249",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4608 JIM MITCHELL TRL W",
        "CITY:Colleyville",
        "X:GLADE RD",
        "BOX:2249");

    doTest("T13",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 219 CHEEK SPARGER RD, Colleyville\nFELPS DR//STEEPLECHASE DR\n Fire Box = 2153",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:219 CHEEK SPARGER RD",
        "CITY:Colleyville",
        "X:FELPS DR/STEEPLECHASE DR",
        "BOX:2153");

    doTest("T14",
        "(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 7212 STILTON CT, Colleyville\nCOLLINS PATH//NULL\n Fire Box = 2114",
        "CALL:FIRE ALARM - RESIDENTIAL",
        "ADDR:7212 STILTON CT",
        "CITY:Colleyville",
        "X:COLLINS PATH",
        "BOX:2114");

    doTest("T15",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4801 SHADYCREEK LN, Colleyville\nMEADOWVIEW DR//\n Fire Box = 2249",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4801 SHADYCREEK LN",
        "CITY:Colleyville",
        "X:MEADOWVIEW DR",
        "BOX:2249");

    doTest("T16",
        "(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n-- 1912 Shenandoah Dr Gpv, Colleyville\n//\n Fire Box =",
        "CALL:MUTUAL AID - FIRE",
        "ADDR:1912 Shenandoah Dr Gpv",
        "CITY:Colleyville");

    doTest("T17",
        "(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n--  Merlot Grapevine, Colleyville\n//\n Fire Box =",
        "CALL:MUTUAL AID - FIRE",
        "ADDR:Merlot Grapevine",
        "CITY:Colleyville");

    doTest("T18",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n--  PLEASANT RUN RD, Colleyville\nMAIN ST//NULL\n Fire Box = 2128",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:PLEASANT RUN RD",
        "MADDR:PLEASANT RUN RD & MAIN ST",
        "CITY:Colleyville",
        "X:MAIN ST",
        "BOX:2128");

    doTest("T19",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5500 VALLEY VIEW DR W, Colleyville\nVALLEY VIEW DR S//NULL\n Fire Box = 2134",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:5500 VALLEY VIEW DR W",
        "CITY:Colleyville",
        "X:VALLEY VIEW DR S",
        "BOX:2134");

    doTest("T20",
        "(PUBLIC SERVICE) \nPUBLIC SERVICE\n-- 5500 VALLEY VIEW DR W, Colleyville\nVALLEY VIEW DR S//NULL\n Fire Box = 2134",
        "CALL:PUBLIC SERVICE",
        "ADDR:5500 VALLEY VIEW DR W",
        "CITY:Colleyville",
        "X:VALLEY VIEW DR S",
        "BOX:2134");

    doTest("T21",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 1221 CHURCH ST, Colleyville\nCOLLEYVILLE BLVD.//\n Fire Box = 2137",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:1221 CHURCH ST",
        "CITY:Colleyville",
        "X:COLLEYVILLE BLVD.",
        "BOX:2137");

    doTest("T22",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 200 CHEEK SPARGER RD, Colleyville\nFELPS DR//STEEPLECHASE DR\n Fire Box = 2153",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:200 CHEEK SPARGER RD",
        "CITY:Colleyville",
        "X:FELPS DR/STEEPLECHASE DR",
        "BOX:2153");

    doTest("T23",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 6216 CIMMARON TRL, Colleyville\nMCDONWELL SCH RD W//\n Fire Box = 2317",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:6216 CIMMARON TRL",
        "CITY:Colleyville",
        "X:MCDONWELL SCH RD W",
        "BOX:2317");

    doTest("T24",
        "(PUBLIC SERVICE) \nPUBLIC SERVICE\n-- 4309 MARTIN PKWY, Colleyville\nEATON CIR//\n Fire Box = 2250",
        "CALL:PUBLIC SERVICE",
        "ADDR:4309 MARTIN PKWY",
        "CITY:Colleyville",
        "X:EATON CIR",
        "BOX:2250");

    doTest("T25",
        "(GAS - ODOR INSIDE) \nGAS - ODOR INSIDE\n-- 5303 ROBERTS DR, Colleyville\n//\n Fire Box = 2241",
        "CALL:GAS - ODOR INSIDE",
        "ADDR:5303 ROBERTS DR",
        "CITY:Colleyville",
        "BOX:2241");

    doTest("T26",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4309 MARTIN PKWY, Colleyville\nEATON CIR//\n Fire Box = 2250",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4309 MARTIN PKWY",
        "CITY:Colleyville",
        "X:EATON CIR",
        "BOX:2250");

    doTest("T27",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 907 RODEO DR, Colleyville\nMOCKINGBIRD LN//\n Fire Box = 2154",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:907 RODEO DR",
        "CITY:Colleyville",
        "X:MOCKINGBIRD LN",
        "BOX:2154");

    doTest("T28",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 7990 PRECINCT LINE RD, Colleyville\nL D LOCKETT RD W//NULL\n Fire Box = 2324",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:7990 PRECINCT LINE RD",
        "CITY:Colleyville",
        "X:L D LOCKETT RD W",
        "BOX:2324");

    doTest("T29",
        "(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 4500 STAFFORD DR, Colleyville\nGLADE RD//NULL\n Fire Box = 2147",
        "CALL:FIRE - STRUCTURE",
        "ADDR:4500 STAFFORD DR",
        "CITY:Colleyville",
        "X:GLADE RD",
        "BOX:2147");

    doTest("T30",
        "(CARBON MONOXIDE) \nCARBON MONOXIDE\n-- 4419 MEANDERING WAY, Colleyville\nLAKESIDE DR//\n Fire Box = 2249",
        "CALL:CARBON MONOXIDE",
        "ADDR:4419 MEANDERING WAY",
        "CITY:Colleyville",
        "X:LAKESIDE DR",
        "BOX:2249");

    doTest("T31",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 1701 OAK KNOLL DR, Colleyville\nSTAFFORD DR//\n Fire Box = 2147",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:1701 OAK KNOLL DR",
        "CITY:Colleyville",
        "X:STAFFORD DR",
        "BOX:2147");

    doTest("T32",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 7007 SHEPHERDS GLEN, Colleyville\n//\n Fire Box = 2312",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:7007 SHEPHERDS GLEN",
        "CITY:Colleyville",
        "BOX:2312");

    doTest("T33",
        "(MEDICAL EMERGENCY) \n" +
        "MEDICAL EMERGENCY\n" +
        "-Gloria's Restaurant- 5611 Colleyville Blvd, Colleyville\n" +
        "HALL JOHNSON RD//\n" +
        " Fire Box = 2129",

        "CALL:MEDICAL EMERGENCY",
        "PLACE:Gloria's Restaurant",
        "ADDR:5611 Colleyville Blvd",
        "CITY:Colleyville",
        "X:HALL JOHNSON RD",
        "BOX:2129");

    doTest("T34",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4601 MILL WOOD DR, Colleyville\nMILL VIEW DR//\n Fire Box = 2145",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4601 MILL WOOD DR",
        "CITY:Colleyville",
        "X:MILL VIEW DR",
        "BOX:2145");

    doTest("T35",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 6413 LORRAINE PARK, Colleyville\n//\n Fire Box = 2317",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:6413 LORRAINE PARK",
        "CITY:Colleyville",
        "BOX:2317");

    doTest("T36",
        "(FIRE ALARM - COMMERCIAL) \n" +
        "FIRE ALARM - COMMERCIAL\n" +
        "-Heritage High School- 5401 Heritage Ave, Colleyville\n" +
        "CHEEK SPARGER RD//NULL\n" +
        " Fire Box = 2241",

        "CALL:FIRE ALARM - COMMERCIAL",
        "PLACE:Heritage High School",
        "ADDR:5401 Heritage Ave",
        "CITY:Colleyville",
        "X:CHEEK SPARGER RD",
        "BOX:2241");

    doTest("T37",
        "(FIRE - GRASS) \nFIRE - GRASS\n-- 805 COLLEYVILLE TER, Colleyville\nBRANSFORD RD//PLEASANT RUN RD\n Fire Box = 2128",
        "CALL:FIRE - GRASS",
        "ADDR:805 COLLEYVILLE TER",
        "CITY:Colleyville",
        "X:BRANSFORD RD/PLEASANT RUN RD",
        "BOX:2128");

    doTest("T38",
        "(MEDICAL EMERGENCY) \n" +
        "MEDICAL EMERGENCY\n" +
        "-Colleyville Cinema Grill- 5655 Colleyville Blvd, Colleyville\n" +
        "HALL JOHNSON RD//\n" +
        " Fire Box = 2129",

        "CALL:MEDICAL EMERGENCY",
        "PLACE:Colleyville Cinema Grill",
        "ADDR:5655 Colleyville Blvd",
        "CITY:Colleyville",
        "X:HALL JOHNSON RD",
        "BOX:2129");

    doTest("T39",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5700 OAK TOP DR, Colleyville\nOAK VALLEY DR W//\n Fire Box = 2327",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:5700 OAK TOP DR",
        "CITY:Colleyville",
        "X:OAK VALLEY DR W",
        "BOX:2327");

    doTest("T40",
        "(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n-- 300  Westover Dr-euless, Colleyville\n//\n Fire Box =",
        "CALL:MUTUAL AID - FIRE",
        "ADDR:300  Westover Dr",
        "CITY:euless");

    doTest("T41",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4200 SHADOW RIDGE DR, Colleyville\nSADDLEBROOK DR//NULL\n Fire Box = 2154",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4200 SHADOW RIDGE DR",
        "CITY:Colleyville",
        "X:SADDLEBROOK DR",
        "BOX:2154");

    doTest("T42",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 405 GLADE RD, Colleyville\nBRANSFORD DR//MILL CREEK DR\n Fire Box = 2145",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:405 GLADE RD",
        "CITY:Colleyville",
        "X:BRANSFORD DR/MILL CREEK DR",
        "BOX:2145");

    doTest("T43",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 304 VAN OAKS DR, Colleyville\nBETTINGER DR//NULL\n Fire Box = 2318",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:304 VAN OAKS DR",
        "CITY:Colleyville",
        "X:BETTINGER DR",
        "BOX:2318");

    doTest("T44",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 405 GLADE RD, Colleyville\nBRANSFORD DR//MILL CREEK DR\n Fire Box = 2145",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:405 GLADE RD",
        "CITY:Colleyville",
        "X:BRANSFORD DR/MILL CREEK DR",
        "BOX:2145");

    doTest("T45",
        "(CARBON MONOXIDE) \nCARBON MONOXIDE\n-- 4508 CRESTHAVEN DR, Colleyville\nMEANDERING WAY//\n Fire Box = 2249",
        "CALL:CARBON MONOXIDE",
        "ADDR:4508 CRESTHAVEN DR",
        "CITY:Colleyville",
        "X:MEANDERING WAY",
        "BOX:2249");

    doTest("T46",
        "(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 6106 LANSFORD LN, Colleyville\nBALLANTRAE DR//\n Fire Box = 2230",
        "CALL:FIRE ALARM - RESIDENTIAL",
        "ADDR:6106 LANSFORD LN",
        "CITY:Colleyville",
        "X:BALLANTRAE DR",
        "BOX:2230");

    doTest("T47",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 3604 BRIARBROOK CT, Colleyville\nWOODBRIAR LN//\n Fire Box = 2161",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:3604 BRIARBROOK CT",
        "CITY:Colleyville",
        "X:WOODBRIAR LN",
        "BOX:2161");

    doTest("T48",
        "(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 500 FIELD ST, Colleyville\nBRANSFORD RD//\n Fire Box = 2135",
        "CALL:FIRE ALARM - RESIDENTIAL",
        "ADDR:500 FIELD ST",
        "CITY:Colleyville",
        "X:BRANSFORD RD",
        "BOX:2135");

    doTest("T49",
        "(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n-- 3900 Jackson Rd, Colleyville\nCHEEK SPARGER RD//\n Fire Box = 2257",
        "CALL:MAJOR ACCIDENT",
        "ADDR:3900 Jackson Rd",
        "CITY:Colleyville",
        "X:CHEEK SPARGER RD",
        "BOX:2257");

    doTest("T50",
        "(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n-- 3900 Jackson Rd, Colleyville\nCHEEK SPARGER RD//\n Fire Box = 2257",
        "CALL:MAJOR ACCIDENT",
        "ADDR:3900 Jackson Rd",
        "CITY:Colleyville",
        "X:CHEEK SPARGER RD",
        "BOX:2257");

    doTest("T51",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 2404 ARBOR GATE LN, Colleyville\nAMADOR TRL//\n Fire Box = 2231",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:2404 ARBOR GATE LN",
        "CITY:Colleyville",
        "X:AMADOR TRL",
        "BOX:2231");

    doTest("T52",
        "(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n-- 5700 COLLEYVILLE BLVD, Colleyville\nHALL JOHNSON RD//\n Fire Box = 2129",
        "CALL:MAJOR ACCIDENT",
        "ADDR:5700 COLLEYVILLE BLVD",
        "CITY:Colleyville",
        "X:HALL JOHNSON RD",
        "BOX:2129");

    doTest("T53",
        "(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n-- 5700 COLLEYVILLE BLVD, Colleyville\nHALL JOHNSON RD//\n Fire Box = 2129",
        "CALL:MAJOR ACCIDENT",
        "ADDR:5700 COLLEYVILLE BLVD",
        "CITY:Colleyville",
        "X:HALL JOHNSON RD",
        "BOX:2129");

    doTest("T54",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Lifetime Fitness- 1221 Church St, Colleyville\nCOLLEYVILLE BLVD.//\n Fire Box = 2137",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:Lifetime Fitness",
        "ADDR:1221 Church St",
        "CITY:Colleyville",
        "X:COLLEYVILLE BLVD.",
        "BOX:2137");

    doTest("T55",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 1603 ROYAL LN, Colleyville\nBLUEBONNET DR//\n Fire Box = 2137",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:1603 ROYAL LN",
        "CITY:Colleyville",
        "X:BLUEBONNET DR",
        "BOX:2137");

    doTest("T56",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4700 MILL VIEW DR, Colleyville\nGLADE RD W//\n Fire Box = 2144",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4700 MILL VIEW DR",
        "CITY:Colleyville",
        "X:GLADE RD W",
        "BOX:2144");

    doTest("T57",
        "(MEDICAL EMERGENCY) \n" +
        "MEDICAL EMERGENCY\n" +
        "-EXXON STATION- 4405 Colleyville Blvd,Box406 Colleyville\n" +
        "BRANSFORD RD//MILL VALLEY DR E\n" +
        " Fire Box = 2145",

        "CALL:MEDICAL EMERGENCY",
        "PLACE:EXXON STATION",
        "ADDR:4405 Colleyville Blvd, Box 406",
        "MADDR:4405 Colleyville Blvd",
        "CITY:Colleyville",
        "X:BRANSFORD RD/MILL VALLEY DR E",
        "BOX:2145");

    doTest("T58",
        "(PUBLIC SERVICE) \nPUBLIC SERVICE\n-- 6701 MEADE DR, Colleyville\nFRANCES LN//\n Fire Box = 2122",
        "CALL:PUBLIC SERVICE",
        "ADDR:6701 MEADE DR",
        "CITY:Colleyville",
        "X:FRANCES LN",
        "BOX:2122");

    doTest("T59",
        "(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 1812 MAPLEWOOD TRL, Colleyville\nSHADOWOOD TRL//\n Fire Box = 2135",
        "CALL:FIRE - STRUCTURE",
        "ADDR:1812 MAPLEWOOD TRL",
        "CITY:Colleyville",
        "X:SHADOWOOD TRL",
        "BOX:2135");

    doTest("T60",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Colleyville Middle School- 1100 Bogart Dr, Colleyville\nPLEASANT RUN RD//\n Fire Box = 2128",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:Colleyville Middle School",
        "ADDR:1100 Bogart Dr",
        "CITY:Colleyville",
        "X:PLEASANT RUN RD",
        "BOX:2128");

    doTest("T61",
        "(MEDICAL EMERGENCY) \n" +
        "MEDICAL EMERGENCY\n" +
        "-Goody Goody Liquor- 4701 COLLEYVILLE BLVD,300 Colleyville\n" +
        "GLADE RD//CENTERPARK DR\n" +
        " Fire Box = 2146",

        "CALL:MEDICAL EMERGENCY",
        "PLACE:Goody Goody Liquor",
        "ADDR:4701 COLLEYVILLE BLVD",
        "CITY:300 Colleyville",
        "X:GLADE RD/CENTERPARK DR",
        "BOX:2146");

    doTest("T62",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 6110 HUNTER LN, Colleyville\nSHELTON DR//\n Fire Box = 2120",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:6110 HUNTER LN",
        "CITY:Colleyville",
        "X:SHELTON DR",
        "BOX:2120");

    doTest("T63",
        "(FIRE ALARM - COMMERCIAL) \nFIRE ALARM - COMMERCIAL\n-- 5800 COLLEYVILLE BLVD, Colleyville\n BOGART//TUSCANY DR\n Fire Box = 2129",
        "CALL:FIRE ALARM - COMMERCIAL",
        "ADDR:5800 COLLEYVILLE BLVD",
        "CITY:Colleyville",
        "X:BOGART/TUSCANY DR",
        "BOX:2129");

    doTest("T64",
        "(FIRE ALARM - COMMERCIAL) \nFIRE ALARM - COMMERCIAL\n-- 1909  FOUNTAIN PASS DR, Colleyville\nOAK POINTE DR//NULL\n Fire Box = 2121",
        "CALL:FIRE ALARM - COMMERCIAL",
        "ADDR:1909  FOUNTAIN PASS DR",
        "CITY:Colleyville",
        "X:OAK POINTE DR",
        "BOX:2121");

    doTest("T65",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5314 BRANSFORD RD,208 Colleyville\nWHITE DR//\n Fire Box = 2135",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:5314 BRANSFORD RD",
        "CITY:208 Colleyville",
        "X:WHITE DR",
        "BOX:2135");

    doTest("T66",
        "(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n-- 1300 HALL JOHNSON RD, Colleyville\n//\n Fire Box = 2129",
        "CALL:MAJOR ACCIDENT",
        "ADDR:1300 HALL JOHNSON RD",
        "CITY:Colleyville",
        "BOX:2129");

    doTest("T67",
        "(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 483 N MAIN ST, Keller\nKELLER HICKS RD//JOHNSON RD\n Fire Box = 52430701",
        "CALL:FIRE - STRUCTURE",
        "ADDR:483 N MAIN ST",
        "CITY:Keller",
        "X:KELLER HICKS RD/JOHNSON RD",
        "BOX:52430701");

    doTest("T68",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4601 MILL WOOD DR, Colleyville\nMILL VIEW DR//\n Fire Box = 2145",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4601 MILL WOOD DR",
        "CITY:Colleyville",
        "X:MILL VIEW DR",
        "BOX:2145");

    doTest("T69",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 1100 LAVACA TRL, Colleyville\nMUSTANG TRL//PRECINCT LINE RD\n Fire Box = 2317",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:1100 LAVACA TRL",
        "CITY:Colleyville",
        "X:MUSTANG TRL/PRECINCT LINE RD",
        "BOX:2317");

    doTest("T70",
        "(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-Keller Welding Mfg Inc- 604 Katy Rd, Keller\nKELLER HICKS RD//KATY RD\n Fire Box = 52430601",
        "CALL:FIRE - STRUCTURE",
        "PLACE:Keller Welding Mfg Inc",
        "ADDR:604 Katy Rd",
        "CITY:Keller",
        "X:KELLER HICKS RD/KATY RD",
        "BOX:52430601");

    doTest("T71",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5207 HERITAGE AVE, Colleyville\nCHEEK SPARGER RD//NULL\n Fire Box = 2241",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:5207 HERITAGE AVE",
        "CITY:Colleyville",
        "X:CHEEK SPARGER RD",
        "BOX:2241");

    doTest("T72",
        "(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 483 N MAIN ST, Keller\nKELLER HICKS RD//JOHNSON RD\n Fire Box = 52430701",
        "CALL:FIRE - STRUCTURE",
        "ADDR:483 N MAIN ST",
        "CITY:Keller",
        "X:KELLER HICKS RD/JOHNSON RD",
        "BOX:52430701");

    doTest("T73",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 6413 LORRAINE PARK, Colleyville\n//\n Fire Box = 2317",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:6413 LORRAINE PARK",
        "CITY:Colleyville",
        "BOX:2317");

    doTest("T74",
        "(FD INVESTIGATION) \nFD INVESTIGATION\n-- 1190 CHEEK SPARGER RD, Colleyville\nBEDFORD RD//TARA DR\n Fire Box = 2155",
        "CALL:FD INVESTIGATION",
        "ADDR:1190 CHEEK SPARGER RD",
        "CITY:Colleyville",
        "X:BEDFORD RD/TARA DR",
        "BOX:2155");

    doTest("T75",
        "(GAS - ODOR OUTSIDE) \nGAS - ODOR OUTSIDE\n-- 5008 COPPERGLEN CIR, Colleyville\nGLADE RD//\n Fire Box = 2241",
        "CALL:GAS - ODOR OUTSIDE",
        "ADDR:5008 COPPERGLEN CIR",
        "CITY:Colleyville",
        "X:GLADE RD",
        "BOX:2241");

    doTest("T76",
        "(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 1509 TINKER RD, Colleyville\nCOLLEYVILLE BLVD//NULL\n Fire Box = 2121",
        "CALL:FIRE - STRUCTURE",
        "ADDR:1509 TINKER RD",
        "CITY:Colleyville",
        "X:COLLEYVILLE BLVD",
        "BOX:2121");

    doTest("T77",
        "(CARBON MONOXIDE) \nCARBON MONOXIDE\n-- 7801 LEESBURG DR, Colleyville\nCHARLOTTESVILLE AVE//\n Fire Box = 2302",
        "CALL:CARBON MONOXIDE",
        "ADDR:7801 LEESBURG DR",
        "CITY:Colleyville",
        "X:CHARLOTTESVILLE AVE",
        "BOX:2302");

    doTest("T78",
        "(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n-- 407 Marseille - Hurst, Colleyville\n//\n Fire Box =",
        "CALL:MUTUAL AID - FIRE",
        "ADDR:407 Marseille",
        "CITY:Hurst");

    doTest("T79",
        "(MAJOR ACCIDENT) \nMAJOR ACCIDENT\n-- 5114 MONTCLAIR DR, Colleyville\nGLADE RD//NULL\n Fire Box = 2238",
        "CALL:MAJOR ACCIDENT",
        "ADDR:5114 MONTCLAIR DR",
        "CITY:Colleyville",
        "X:GLADE RD",
        "BOX:2238");

    doTest("T80",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 7026 PRIMROSE LN, Colleyville\nJOHN MCCAIN RD//NULL\n Fire Box = 2313",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:7026 PRIMROSE LN",
        "CITY:Colleyville",
        "X:JOHN MCCAIN RD",
        "BOX:2313");

    doTest("T81",
        "(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 1329 SNOW MOUNTAIN CIR, Keller\nSNOW MOUNTAIN CIR//SNOW MOUNTAIN CIR\n Fire Box = 53420304",
        "CALL:FIRE - STRUCTURE",
        "ADDR:1329 SNOW MOUNTAIN CIR",
        "CITY:Keller",
        "X:SNOW MOUNTAIN CIR/SNOW MOUNTAIN CIR",
        "BOX:53420304");

    doTest("T82",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5207 HERITAGE AVE, Colleyville\nCHEEK SPARGER RD//NULL\n Fire Box = 2241",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:5207 HERITAGE AVE",
        "CITY:Colleyville",
        "X:CHEEK SPARGER RD",
        "BOX:2241");

    doTest("T83",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 6521 COLLEYVILLE BLVD, Colleyville\nTARRANT LN//\n Fire Box = 2121",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:6521 COLLEYVILLE BLVD",
        "CITY:Colleyville",
        "X:TARRANT LN",
        "BOX:2121");

    doTest("T84",
        "(GAS - ODOR OUTSIDE) \nGAS - ODOR OUTSIDE\n--  REMINGTON PKWY, Colleyville\nMCDONWELL SCH RD W//NULL\n Fire Box = 2326",
        "CALL:GAS - ODOR OUTSIDE",
        "ADDR:REMINGTON PKWY",
        "MADDR:REMINGTON PKWY & MCDONWELL SCH RD W",
        "CITY:Colleyville",
        "X:MCDONWELL SCH RD W",
        "BOX:2326");

    doTest("T85",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 7204 OVERLAND TRL, Colleyville\nBANDIT TRL//\n Fire Box = 2310",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:7204 OVERLAND TRL",
        "CITY:Colleyville",
        "X:BANDIT TRL",
        "BOX:2310");

    doTest("T86",
        "(MUTUAL AID - FIRE) \nMUTUAL AID - FIRE\n-- 1312 Hardisty, Colleyville\n//\n Fire Box =",
        "CALL:MUTUAL AID - FIRE",
        "ADDR:1312 Hardisty",
        "CITY:Colleyville");

    doTest("T87",
        "(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 7300 CHANEL CT, Colleyville\nBANDIT TRL//NULL\n Fire Box = 2310",
        "CALL:FIRE ALARM - RESIDENTIAL",
        "ADDR:7300 CHANEL CT",
        "CITY:Colleyville",
        "X:BANDIT TRL",
        "BOX:2310");

    doTest("T88",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 110 MAIN ST, Colleyville\nCOLLEYVILLE BLVD//VILLAGE LN\n Fire Box = 2136",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:110 MAIN ST",
        "CITY:Colleyville",
        "X:COLLEYVILLE BLVD/VILLAGE LN",
        "BOX:2136");

    doTest("T89",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 3838 SAN BAR LN, Colleyville\nWOODBINE DR//NULL\n Fire Box = 2152",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:3838 SAN BAR LN",
        "CITY:Colleyville",
        "X:WOODBINE DR",
        "BOX:2152");

    doTest("T90",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5232 COLLEYVILLE BLVD,100 Colleyville\nMAIN ST//PROFESSIONAL CT\n Fire Box = 2136",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:5232 COLLEYVILLE BLVD",
        "CITY:100 Colleyville",
        "X:MAIN ST/PROFESSIONAL CT",
        "BOX:2136");

    doTest("T91",
        "(FIRE - GRASS) \nFIRE - GRASS\n-- 4712 BILL SIMMONS RD, Colleyville\nGLADE RD//NULL\n Fire Box = 2248",
        "CALL:FIRE - GRASS",
        "ADDR:4712 BILL SIMMONS RD",
        "CITY:Colleyville",
        "X:GLADE RD",
        "BOX:2248");

    doTest("T92",
        "(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 1033 PALO DURO TR, Keller\nKING TR//EOP\n Fire Box = 53420401",
        "CALL:FIRE - STRUCTURE",
        "ADDR:1033 PALO DURO TR",
        "CITY:Keller",
        "X:KING TR/EOP",
        "BOX:53420401");

    doTest("T93",
        "(POWER LINE ARCING/POLE ON FIRE) \n" +
        "POWER LINE ARCING/POLE ON FIRE\n" +
        "-- 4200 JACKSON RD, Colleyville\n" +
        "CHEEK SPARGER RD//\n" +
        " Fire Box = 2249",

        "CALL:POWER LINE ARCING/POLE ON FIRE",
        "ADDR:4200 JACKSON RD",
        "CITY:Colleyville",
        "X:CHEEK SPARGER RD",
        "BOX:2249");

    doTest("T94",
        "(FIRE ALARM - COMMERCIAL) \n" +
        "FIRE ALARM - COMMERCIAL\n" +
        "-- 919 CHEEK SPARGER RD, Colleyville\n" +
        "WAYNE DR//CHEECK SPARGER RD\n" +
        " Fire Box = 2154",

        "CALL:FIRE ALARM - COMMERCIAL",
        "ADDR:919 CHEEK SPARGER RD",
        "CITY:Colleyville",
        "X:WAYNE DR/CHEECK SPARGER RD",
        "BOX:2154");

    doTest("T95",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 7201 WINDSWEPT TRL, Colleyville\nBANDIT TRL//\n Fire Box = 2310",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:7201 WINDSWEPT TRL",
        "CITY:Colleyville",
        "X:BANDIT TRL",
        "BOX:2310");

    doTest("T96",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Lifetime Fitness- 1221 Church St, Colleyville\nCOLLEYVILLE BLVD.//\n Fire Box = 2137",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:Lifetime Fitness",
        "ADDR:1221 Church St",
        "CITY:Colleyville",
        "X:COLLEYVILLE BLVD.",
        "BOX:2137");

    doTest("T97",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 4809 JIM MITCHELL TRL E, Colleyville\nGLADE RD//NULL\n Fire Box = 2249",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4809 JIM MITCHELL TRL E",
        "CITY:Colleyville",
        "X:GLADE RD",
        "BOX:2249");

    doTest("T98",
        "(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 6709 MEADE DR, Colleyville\nFRANCES LN//\n Fire Box = 2122",
        "CALL:FIRE ALARM - RESIDENTIAL",
        "ADDR:6709 MEADE DR",
        "CITY:Colleyville",
        "X:FRANCES LN",
        "BOX:2122");

    doTest("T99",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5314 BRANSFORD RD,105 Colleyville\nWHITE DR//\n Fire Box = 2135",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:5314 BRANSFORD RD",
        "CITY:105 Colleyville",
        "X:WHITE DR",
        "BOX:2135");

    doTest("T100",
        "(MEDICAL EMERGENCY) \n" +
        "MEDICAL EMERGENCY\n" +
        "-Heritage Middle School- 5300 Heritage Ave,Box308 Colleyville\n" +
        "CHEEK SPARGER RD//NULL\n" +
        " Fire Box = 2241",

        "CALL:MEDICAL EMERGENCY",
        "PLACE:Heritage Middle School",
        "ADDR:5300 Heritage Ave, Box 308",
        "MADDR:5300 Heritage Ave",
        "CITY:Colleyville",
        "X:CHEEK SPARGER RD",
        "BOX:2241");

    doTest("T101",
        "(CARBON MONOXIDE) \nCARBON MONOXIDE\n-- 4604 MEANDERING WAY, Colleyville\nLAKESIDE DR//\n Fire Box = 2249",
        "CALL:CARBON MONOXIDE",
        "ADDR:4604 MEANDERING WAY",
        "CITY:Colleyville",
        "X:LAKESIDE DR",
        "BOX:2249");

    doTest("T102",
        "(PUBLIC SERVICE) \nPUBLIC SERVICE\n-- 4105 LEXINGTON PKWY, Colleyville\nPEMBROOKE PKWY S//\n Fire Box = 2259",
        "CALL:PUBLIC SERVICE",
        "ADDR:4105 LEXINGTON PKWY",
        "CITY:Colleyville",
        "X:PEMBROOKE PKWY S",
        "BOX:2259");

    doTest("T103",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5056 HERITAGE OAKS DR, Colleyville\nHERITAGE AVE//NULL\n Fire Box = 2241",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:5056 HERITAGE OAKS DR",
        "CITY:Colleyville",
        "X:HERITAGE AVE",
        "BOX:2241");

    doTest("T104",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-Lakes Of Somerset- 1100 Somerset Blvd,Box401A Colleyville\nBEDFORD RD//\n Fire Box = 2146",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:Lakes Of Somerset",
        "ADDR:1100 Somerset Blvd, Box 401",
        "MADDR:1100 Somerset Blvd",
        "CITY:A Colleyville",
        "X:BEDFORD RD",
        "BOX:2146");

    doTest("T105",
        "(MEDICAL EMERGENCY) \n" +
        "MEDICAL EMERGENCY\n" +
        "-Heritage High School- 5401 Heritage Ave, Colleyville\n" +
        "CHEEK SPARGER RD//NULL\n" +
        " Fire Box = 2241",

        "CALL:MEDICAL EMERGENCY",
        "PLACE:Heritage High School",
        "ADDR:5401 Heritage Ave",
        "CITY:Colleyville",
        "X:CHEEK SPARGER RD",
        "BOX:2241");

    doTest("T106",
        "(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 7215 BROOKE DR, Colleyville\nPRINCE MEADOW DR//\n Fire Box = 2114",
        "CALL:FIRE ALARM - RESIDENTIAL",
        "ADDR:7215 BROOKE DR",
        "CITY:Colleyville",
        "X:PRINCE MEADOW DR",
        "BOX:2114");

    doTest("T107",
        "(PUBLIC SERVICE) \nPUBLIC SERVICE\n-- 3609 COTSWOLD CT, Colleyville\nPRESTWICK DR//GLADE RD\n Fire Box = 2251",
        "CALL:PUBLIC SERVICE",
        "ADDR:3609 COTSWOLD CT",
        "CITY:Colleyville",
        "X:PRESTWICK DR/GLADE RD",
        "BOX:2251");

    doTest("T108",
        "(FIRE ALARM - RESIDENTIAL) \nFIRE ALARM - RESIDENTIAL\n-- 5005 SAN GABRIEL AVE, Colleyville\nRIVERWALK CT//NULL\n Fire Box = 2136",
        "CALL:FIRE ALARM - RESIDENTIAL",
        "ADDR:5005 SAN GABRIEL AVE",
        "CITY:Colleyville",
        "X:RIVERWALK CT",
        "BOX:2136");

    doTest("T109",
        "(FIRE - STRUCTURE) \nFIRE - STRUCTURE\n-- 6512 HORSESHOE BND, Colleyville\n//\n Fire Box = 2317",
        "CALL:FIRE - STRUCTURE",
        "ADDR:6512 HORSESHOE BND",
        "CITY:Colleyville",
        "BOX:2317");

    doTest("T110",
        "(FIRE - GRASS) \nFIRE - GRASS\n-- 6512 KINGSTON DR, Colleyville\nTINKER RD//\n Fire Box = 2121",
        "CALL:FIRE - GRASS",
        "ADDR:6512 KINGSTON DR",
        "CITY:Colleyville",
        "X:TINKER RD",
        "BOX:2121");

    doTest("T111",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 3136 WOODLAND HEIGHTS CIR, Colleyville\nMARTIN PKWY//NULL\n Fire Box = 2258",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:3136 WOODLAND HEIGHTS CIR",
        "CITY:Colleyville",
        "X:MARTIN PKWY",
        "BOX:2258");

    doTest("T112",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 5508 REAGAN RD, Colleyville\nL D LOCKETT RD W//\n Fire Box = 2326",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:5508 REAGAN RD",
        "CITY:Colleyville",
        "X:L D LOCKETT RD W",
        "BOX:2326");

    doTest("T113",
        "(MEDICAL EMERGENCY) \nMEDICAL EMERGENCY\n-- 6020 STERLING DR, Colleyville\nCRYSTAL WAY//L D LOCKETT RD W\n Fire Box = 2325",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:6020 STERLING DR",
        "CITY:Colleyville",
        "X:CRYSTAL WAY/L D LOCKETT RD W",
        "BOX:2325");

  }
  
  public static void main(String[] args) {
    new TXKellerParserTest().generateTests("T1");
  }
}
