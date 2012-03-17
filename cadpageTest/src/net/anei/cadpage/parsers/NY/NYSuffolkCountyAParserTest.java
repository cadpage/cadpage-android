package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYSuffolkCountyAParser;

import org.junit.Test;


public class NYSuffolkCountyAParserTest extends BaseParserTest {
  
  public NYSuffolkCountyAParserTest() {
    setParser(new NYSuffolkCountyAParser(), "SUFFOLK COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "TYPE: GAS LEAKS / GAS ODOR (NATURAL / L.P.G.) LOC: 11 BRENTWOOD PKWY BRENTW HOMELESS SHELTER CROSS: PENNSYLVANIA AV / SUFFOLK AV CODE: 60-B-2 TIME: 12:54:16",
        "CALL:GAS LEAKS / GAS ODOR (NATURAL / L.P.G.)",
        "ADDR:11 BRENTWOOD PKWY",
        "CITY:Brentwood",
        "PLACE:HOMELESS SHELTER",
        "X:PENNSYLVANIA AV / SUFFOLK AV",
        "CODE:60-B-2",
        "TIME:12:54:16");

    doTest("T2",
        "TYPE: STRUCTURE FIRE LOC: 81 NEW HAMPSHIRE AV NBAYSH  CROSS: E FORKS RD / E 3 AV CODE: 69-D-10 TIME: 16:36:48",
        "CALL:STRUCTURE FIRE",
        "ADDR:81 NEW HAMPSHIRE AV",
        "MADDR:81 NEW HAMPSHIRE AVE",
        "CITY:Bay Shore",
        "X:E FORKS RD / E 3 AV",
        "CODE:69-D-10",
        "TIME:16:36:48");

    doTest("T3",
        "TYPE: OPEN BURNING LOC: 65 GRANT AVE BRENTW CROSS: SUFFOLK AVE CODE: 54-C-6 TIME: 18:39:20",
        "CALL:OPEN BURNING",
        "ADDR:65 GRANT AVE",
        "X:SUFFOLK AVE",
        "CITY:Brentwood",
        "CODE:54-C-6",
        "TIME:18:39:20");

    doTest("T4",
        "TYPE: BLEEDING / LACERATIONS LOC: 462 SPUR DR N NBAYSH  CROSS: WB SSP OFF RAMP-X42N 5TH AV / E 3 AV CODE: 21-A-1 TIME: 03:36:22",
        "CALL:BLEEDING / LACERATIONS",
        "ADDR:462 SPUR DR N",
        "CITY:Bay Shore",
        "X:WB SSP OFF RAMP-X42N 5TH AV / E 3 AV",
        "CODE:21-A-1",
        "TIME:03:36:22");

    doTest("T5",
        "TYPE: PREGNANCY / CHILDBIRTH / MISCARRIAGE LOC: 330 MOTOR PKWY HAUPPA:@FELDMAN, KRAMER & MONACO STE 400  CROSS: WASHINGTON AV / MARCUS BLVD C",
        "CALL:PREGNANCY / CHILDBIRTH / MISCARRIAGE",
        "ADDR:330 MOTOR PKWY",
        "CITY:Hauppauge",
        "PLACE:FELDMAN, KRAMER & MONACO STE 400",
        "X:WASHINGTON AV / MARCUS BLVD");

    doTest("T6",
        "TYPE: PSYCHIATRIC / ABNORMAL BEHAVIOR / SUICIDE LOC: 200 WIRELESS BLVD HAUPPA: @SOCIAL SERVICES HAUPPAUGE INTERVIEW AREA CROSS: MORELAND RD /",
        "CALL:PSYCHIATRIC / ABNORMAL BEHAVIOR / SUICIDE",
        "ADDR:200 WIRELESS BLVD",
        "CITY:Hauppauge",
        "PLACE:SOCIAL SERVICES HAUPPAUGE INTERVIEW AREA",
        "X:MORELAND RD /");

    doTest("T7",
        "FAINTING (NEAR) LOC: 46 SAUNDERS AV CENTEM:@KINGS CHAPEL CHURCH  CROSS: ROWEIN RD CODE: 31-D-2 TIME: 17:24:12",
        "CALL:FAINTING (NEAR)",
        "ADDR:46 SAUNDERS AV",
        "MADDR:46 SAUNDERS AVE",
        "CITY:Center Moriches",
        "PLACE:KINGS CHAPEL CHURCH",
        "X:ROWEIN RD",
        "CODE:31-D-2",
        "TIME:17:24:12");

    doTest("T8",
        "SEIZURES LOC: 20 TRAINOR AV CENTEM CROSS: SUNRISE HWY S  BERNSTEIN BLVD CODE: 12-C-1 TIME: 03:39:02",
        "CALL:SEIZURES",
        "ADDR:20 TRAINOR AV",
        "MADDR:20 TRAINOR AVE",
        "CITY:Center Moriches",
        "X:SUNRISE HWY S  BERNSTEIN BLVD",
        "CODE:12-C-1",
        "TIME:03:39:02");

    doTest("T9",
        "ABDOMINAL PAINS LOC: 18 INWOOD RD CENTEM CROSS: UNION AV / BEACHFERN RD CODE: 1-A-1 TIME: 21:21:39",
        "CALL:ABDOMINAL PAINS",
        "ADDR:18 INWOOD RD",
        "CITY:Center Moriches",
        "X:UNION AV / BEACHFERN RD",
        "CODE:1-A-1",
        "TIME:21:21:39");

    doTest("T10",
        "UNKNOWN PROBLEM LOC: 150 CHICHESTER AV CENTEM CROSS: YARMOUTH LN / FROWEIN RD CODE: TIME: 08:01:10",
        "CALL:UNKNOWN PROBLEM",
        "ADDR:150 CHICHESTER AV",
        "MADDR:150 CHICHESTER AVE",
        "CITY:Center Moriches",
        "X:YARMOUTH LN / FROWEIN RD",
        "TIME:08:01:10");

    doTest("T11",
        "FAINTING (NEAR) LOC: 6 FROWEIN RD EMORIC: @CEDAR LODGE NURSING HOME IN THE DINING ROOM CROSS: WALDEN CT  OAK ST CODE: 31-D-3 TIME: 18:51:38",
        "CALL:FAINTING (NEAR)",
        "ADDR:6 FROWEIN RD",
        "CITY:East Moriches",
        "PLACE:CEDAR LODGE NURSING HOME IN THE DINING ROOM",
        "X:WALDEN CT  OAK ST",
        "CODE:31-D-3",
        "TIME:18:51:38");

    doTest("T12",
        "GAS ODOR (NATURAL  L.P.G.) LOC: MCGRAW ST SHIRLE I/V/O SHIRLEY PLAZA CROSS: GRAND AV / OAK AV CODE: 60-C-2 TIME: 02:06:34",
        "CALL:GAS ODOR (NATURAL  L.P.G.)",
        "ADDR:MCGRAW ST",
        "MADDR:MCGRAW ST & GRAND AVE",
        "CITY:Shirley",
        "PLACE:I / V / O SHIRLEY PLAZA",
        "X:GRAND AV / OAK AV",
        "CODE:60-C-2",
        "TIME:02:06:34");

    doTest("T13",
        "FAINTING (NEAR) LOC: 53-10 LONG TREE LN MORICH: @PINE HILLS SOUTH CLUBHOUSE COMMUNITY ROOM CROSS:    CODE: 31-E-1 TIME: 14:54:18",
        "CALL:FAINTING (NEAR)",
        "ADDR:53-10 LONG TREE LN",
        "MADDR:53 LONG TREE LN",
        "CITY:Moriches",
        "PLACE:PINE HILLS SOUTH CLUBHOUSE COMMUNITY ROOM",
        "CODE:31-E-1",
        "TIME:14:54:18");

    doTest("T14",
        "TYPE: ALARMS LOC: 127 CRYSTAL BEACH BLVD MORICH  CROSS: BEVERLY CT / CODE: 52-B-1C TIME: 21:15:11",
        "CALL:ALARMS",
        "ADDR:127 CRYSTAL BEACH BLVD",
        "CITY:Moriches",
        "X:BEVERLY CT /",
        "CODE:52-B-1C",
        "TIME:21:15:11");

    doTest("T15",
        "TYPE: PSYCHIATRIC / ABNORMAL BEHAVIOR / SUICIDE LOC: 79 ABBOTT AV MASTIC ***_VIP_***: CROSS: ELGIN ST / FOXCROFT ST CODE: 25-B-6 TIME: 14:36:05",
        "CALL:PSYCHIATRIC / ABNORMAL BEHAVIOR / SUICIDE",
        "ADDR:79 ABBOTT AV",
        "MADDR:79 ABBOTT AVE",
        "CITY:Mastic",
        "PLACE:***_VIP_***",
        "X:ELGIN ST / FOXCROFT ST",
        "CODE:25-B-6",
        "TIME:14:36:05");

    doTest("T16",
        "TYPE: ALARMS LOC: 100 PATRICIA CT OAKDAL @OAKDALE APARTMENTS    APARTMENT 3 CROSS: RACE PL /  CODE: 52-C-1S TIME: 19:16:55",
        "CALL:ALARMS",
        "ADDR:100 PATRICIA CT",
        "CITY:Oakdale",
        "PLACE:OAKDALE APARTMENTS    APARTMENT 3",
        "X:RACE PL /",
        "CODE:52-C-1S",
        "TIME:19:16:55");

    doTest("T18",
        "FWD: TYPE: STRUCTURE FIRE LOC: 1 WILBUR AV MANORV  CROSS: SOHMER ST /  CODE: 69-D-5 TIME: 17:17:43",
        "CALL:STRUCTURE FIRE",
        "ADDR:1 WILBUR AV",
        "MADDR:1 WILBUR AVE",
        "CITY:Manorville",
        "X:SOHMER ST /",
        "CODE:69-D-5",
        "TIME:17:17:43");

    doTest("T19",
        "TYPE: MOTOR VEHICLE ACCIDENT  CROSS: CHURCH ST / LAKELAND AV CODE: 29-B-1U TIME: 09:04:01",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:CHURCH ST & LAKELAND AV",
        "MADDR:CHURCH ST & LAKELAND AVE",
        "CODE:29-B-1U",
        "TIME:09:04:01");

    doTest("T20",
        "TYPE: ALARMS LOC: 311 BAY AV EPATCH: @BAY HOUSE  CROSS: NEWINS ST / PARK ST CODE: 52-C-3G TIME: 15:33:58\n\n",
        "CALL:ALARMS",
        "ADDR:311 BAY AV",
        "MADDR:311 BAY AVE",
        "CITY:East Patchogue",
        "PLACE:BAY HOUSE",
        "X:NEWINS ST / PARK ST",
        "CODE:52-C-3G",
        "TIME:15:33:58");

    doTest("T21",
        "TYPE: CHEST PAIN LOC: 3845 VETERANS MEMORIAL HWY RONKON: @HOLIDAY INN RONKONKOMA: @HOLIDAY INN RONKONKOMA:06:12.4418,40:48:13.4 PARKI",
        "CALL:CHEST PAIN",
        "ADDR:3845 VETERANS MEMORIAL HWY",
        "CITY:Ronkonkoma",
        "PLACE:HOLIDAY INN RONKONKOMA",
        "INFO:HOLIDAY INN RONKONKOMA 06 12.4418,40 48 13.4 PARKI");

    doTest("T22",
        "TYPE: UNKNOWN PROBLEM LOC: 195 CUBA HILL RD GREENL  CROSS: MANOR RD / DANVILLE DR CODE: 32-B-2 TIME: 17:30:40",
        "CALL:UNKNOWN PROBLEM",
        "ADDR:195 CUBA HILL RD",
        "CITY:Greenlawn",
        "X:MANOR RD / DANVILLE DR",
        "CODE:32-B-2",
        "TIME:17:30:40");

    doTest("T23",
        "TYPE: STRUCTURE FIRE LOC: 1 ARNOLD DR HUNTIN  CROSS: PARTRIDGE LN /  CODE: default TIME: 06:38:03",
        "CALL:STRUCTURE FIRE",
        "ADDR:1 ARNOLD DR",
        "CITY:Huntington",
        "X:PARTRIDGE LN /",
        "CODE:default",
        "TIME:06:38:03");

    doTest("T24",
        "TYPE: STRUCTURE FIRE LOC: 6 MAJESTIC DR DIXHIL  CROSS: ROYAL LN / REGENCY LN CODE: 69-D-6 TIME: 02:22:25",
        "CALL:STRUCTURE FIRE",
        "ADDR:6 MAJESTIC DR",
        "CITY:Dix Hills",
        "X:ROYAL LN / REGENCY LN",
        "CODE:69-D-6",
        "TIME:02:22:25");

    doTest("T25",
        "TYPE: FALLS LOC: 37 WATERSIDE AV NORTHP  CROSS: MONROE ST / WILLIS ST CODE: 17-B-3 TIME: 13:40:45",
        "CALL:FALLS",
        "ADDR:37 WATERSIDE AV",
        "MADDR:37 WATERSIDE AVE",
        "CITY:Northport",
        "X:MONROE ST / WILLIS ST",
        "CODE:17-B-3",
        "TIME:13:40:45");

    doTest("T26",
        "TYPE: HEADACHE LOC: 68 FOREST AV SHIRLE  CROSS: DAWN DR / WINSTON DR CODE: 18-C-2 TIME: 16:09:54\n\n",
        "CALL:HEADACHE",
        "ADDR:68 FOREST AV",
        "MADDR:68 FOREST AVE",
        "CITY:Shirley",
        "X:DAWN DR / WINSTON DR",
        "CODE:18-C-2",
        "TIME:16:09:54");

    doTest("T27",
        "TYPE: RESPIRATORY LOC: 16 TEAL CRSN GREATR   CROSS:  / WIDGEON CT CODE: 6-D-1 TIME: 15:59:03",
        "CALL:RESPIRATORY",
        "ADDR:16 TEAL CRSN",
        "MADDR:16 TEAL CRESCENT",
        "CITY:Great River",
        "X:/ WIDGEON CT",
        "CODE:6-D-1",
        "TIME:15:59:03");

    doTest("T28",
        "TYPE: STRUCTURE FIRE LOC: 605 7 AV ENORTH   CROSS: 6 ST / OWEN CT CODE: 69-D-6 TIME: 11:34:38",
        "CALL:STRUCTURE FIRE",
        "ADDR:605 7 AV",
        "MADDR:605 7 AVE",
        "CITY:East Northport",
        "X:6 ST / OWEN CT",
        "CODE:69-D-6",
        "TIME:11:34:38");

    doTest("T29",
        "TYPE: ALARMS LOC: 32 MONTAUK HWY BLUEPO : @BURGER KING BLUE POINT  CROSS: BELL AV / BUFFIN LN CODE: 52-C-3P TIME: 13:20:43\r\n\r\n\r",
        "CALL:ALARMS",
        "ADDR:32 MONTAUK HWY",
        "CITY:Blue Point",
        "PLACE:BURGER KING BLUE POINT",
        "X:BELL AV / BUFFIN LN",
        "CODE:52-C-3P",
        "TIME:13:20:43");
  
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "TYPE: RESPIRATORY LOC: 14 RITA DR MOUNTS CROSS: WESTCLIFF DR / JONI DR CODE:6-D-1 TIME: 23:35:41",
        "CALL:RESPIRATORY",
        "ADDR:14 RITA DR",
        "CITY:Mount Siani",
        "X:WESTCLIFF DR / JONI DR",
        "CODE:6-D-1",
        "TIME:23:35:41");

    doTest("T2",
        "TYPE: BLEEDING / LACERATIONS LOC: 103 ROE LN PORTJE CROSS: VILLAGE WOODS RD / CODE: 21-B-1 TIME: 13:18:59",
        "CALL:BLEEDING / LACERATIONS",
        "ADDR:103 ROE LN",
        "CITY:Port Jefferson",
        "X:VILLAGE WOODS RD /",
        "CODE:21-B-1",
        "TIME:13:18:59");

    doTest("T3",
        "TYPE: MOTOR VEHICLE ACCIDENT WB RT 347 CROSS: NESCONSET HWY / JAYNE BLVD CODE: 29-B-1A TIME: 18:02:43",
        "CALL:MOTOR VEHICLE ACCIDENT WB RT 347",
        "ADDR:NESCONSET HWY & JAYNE BLVD",
        "CODE:29-B-1A",
        "TIME:18:02:43");

    doTest("T4",
        "TYPE: HEADACHE LOC: 39 MANOR DR MILLEP CROSS: GRAHAM CT / OAKS DR CODE: 18-C-2 TIME:21:50:53",
        "CALL:HEADACHE",
        "ADDR:39 MANOR DR",
        "CITY:Miller Place",
        "X:GRAHAM CT / OAKS DR",
        "CODE:18-C-2",
        "TIME:21:50:53");

    doTest("T5",
        "TYPE: BURNS (SCALDS) / EXPLOSION LOC: 9 ARBOR RIDGE LN CENTRE CROSS: VALIANT DR / VALIANT DR CODE: 7-A-2 TIME: 03:05:16",
        "CALL:BURNS (SCALDS) / EXPLOSION",
        "ADDR:9 ARBOR RIDGE LN",
        "CITY:Centereach",
        "X:VALIANT DR / VALIANT DR",
        "CODE:7-A-2",
        "TIME:03:05:16");

    doTest("T6",
        "TYPE: BLEEDING / LACERATIONS LOC: 80 GRENADA CIR MOUNTS RIGHT SIDE APT CROSS: CARDIFF RUN / SEVILLA WK CODE: 21-D-3 TIME: 08:47:11",
        "CALL:BLEEDING / LACERATIONS",
        "ADDR:80 GRENADA CIR",
        "CITY:Mount Siani",
        "PLACE:RIGHT SIDE APT",
        "X:CARDIFF RUN / SEVILLA WK",
        "CODE:21-D-3",
        "TIME:08:47:11");

    doTest("T7",
        "TYPE: RESPIRATORY LOC: 255 OAKLAND AV PORTJE :@PAX CHRISTI CROSS: HIGHLAND BLVD / ROUTE 25A CODE: 6-C-1A TIME: 08:55:59",
        "CALL:RESPIRATORY",
        "ADDR:255 OAKLAND AV",
        "MADDR:255 OAKLAND AVE",
        "CITY:Port Jefferson",
        "PLACE:PAX CHRISTI",
        "X:HIGHLAND BLVD / ROUTE 25A",
        "CODE:6-C-1A",
        "TIME:08:55:59");
 
  }
  
  public static void main(String[] args) {
    new NYSuffolkCountyAParserTest().generateTests("T1", "CALL ADDR CITY PLACE X CODE INFO TIME");
  }
}
