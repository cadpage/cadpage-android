package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Mecklenburg County, VA
Contact: Active911
Agency name: Southside Rescue Squad
Location: South Hill, VA, United States
Sender: swpage2@vameck911.com 

(MECK 911) 13-021361 SUBJECT FALLEN \n Reported: 05/09/2013 04:23:53 \n 1276 WILSON RD \n SR 638 / \n MECK CO \n SSRS \n \n 
(MECK 911) 13-021275 DIABETIC \n Reported: 05/08/2013 17:40:26 \n 4507 HIGHWAY ONE \n / \n BOAT RAMP - STEEL BRIDGE  MECK CO \n SSRS \n \n 
(MECK 911) 13-021264 PASSED OUT \n Reported: 05/08/2013 15:38:23 \n 365 PETER WALKER RD \n SR 765 / \n LACROSSE \n SSRS \n \n 
(MECK 911) 13-021260 AUTO VS DEER W/DAMAGE \n Reported: 05/08/2013 14:21:58 \n SB I-85 MM 13 \n / \n SB INTERSTATE EIGHTY-FIVE - MM 13  MECK CO \n CO#7 SSRS VSP \n \n 
(MECK 911) 13-021246 STROKE PATIENT \n Reported: 05/08/2013 10:43:54 \n 2661 MINERAL SPRINGS RD \n SR 711 / \n MECK CO \n SSRS \n \n 
(MECK 911) 13-021237 ACCIDENT W/INJURY \n Reported: 05/08/2013 08:03:08 \n NB I-85 MM 1 \n / \n NB INTERSTATE EIGHTY-FIVE - MM 01  MECK CO \n CO#7 SSRS \n \n 
(MECK 911) 13-021208 HEART PROBLEMS \n Reported: 05/08/2013 04:02:32 \n 5796 GOODES FERRY RD \n / \n MECK CO \n SSRS \n \n 
(MECK 911) 13-021112 SUBJECT FALLEN \n Reported: 05/07/2013 21:41:37 \n 2450 MINERAL SPRINGS RD \n SR 711 / \n PALMER SPRINGS FAMILY CARE  MECK CO \n SSRS \n \n 
(MECK 911) 13-021085 DIABETIC \n Reported: 05/07/2013 19:57:03 \n 11232 SKIPWITH RD \n SR 688 / \n MECK CO \n CCRS R41 SSRS \n \n 
(MECK 911) 13-021075 10-50 ACCIDENT \n Reported: 05/07/2013 18:09:25 \n 715 EAST ATLANTIC ST \n / \n FOOD LION - TOWNE SQUARE  SOUTH HILL \n 409 SSRS \n \n 
(MECK 911) 13-021052 STROKE PATIENT \n Reported: 05/07/2013 13:41:54 \n 621 ACADEMY LN \n / \n PINEVIEW RETIREMENT HOME  SOUTH HILL \n SSRS \n \n 
(MECK 911) 13-021027 SHORTNESS OF BREATH \n Reported: 05/07/2013 09:21:08 \n 211 EAST FERRELL ST \n / \n SOUTH HILL \n SSRS \n \n 
(MECK 911) 13-021021 SHORTNESS OF BREATH \n Reported: 05/07/2013 08:53:18 \n 3487 STONEY CROSS RD \n SR 671 / \n MECK CO \n SSRS \n \n 
(MECK 911) 13-020905 SHORTNESS OF BREATH \n Reported: 05/06/2013 20:18:34 \n 1034 UNION MILL RD \n HWY 138 / \n MECK CO \n SSRS \n \n 
(MECK 911) 13-020863 ILL, NOT FEELING WELL \n Reported: 05/06/2013 13:12:08 \n 501 VIRGINIA AVE \n / \n CHASE CITY \n 207 CCRS R44 SSRS \n \n 
(MECK 911) 13-020850 SUBJECT FALLEN \n Reported: 05/06/2013 08:56:47 \n 18 HURON TRL \n CALL GATE FOR ACCESS / \n RIVER RIDGE SUB \n SSRS \n \n 

Contact: Active911
Agency name: VSP-A22
Location: South Hill, VA, United States
Sender: swpage2@vameck911.com

(MECK 911) 13-021260 AUTO VS DEER W/DAMAGE \n Reported: 05/08/2013 14:21:58 \n SB I-85 MM 13 \n / \n SB INTERSTATE EIGHTY-FIVE - MM 13  MECK CO \n CO#7 SSRS VSP \n \n 
(MECK 911) 13-021235 RECKLESS DRIVING \n Reported: 05/08/2013 07:44:10 \n NB I-85 MM 4 \n / \n NB INTERSTATE EIGHTY-FIVE - MM 04  MECK CO \n 055 VSP \n \n 
(MECK 911) 13-021237 ACCIDENT W/INJURY \n Reported: 05/08/2013 08:03:08 \n NB I-85 MM 1 \n / \n NB INTERSTATE EIGHTY-FIVE - MM 01  MECK CO \n CO#7 F701 SSRS VSP \n \n 
(MECK 911) 13-021235 RECKLESS DRIVING \n Reported: 05/08/2013 07:44:10 \n NB I-85 MM 4 \n / \n NB INTERSTATE EIGHTY-FIVE - MM 04  MECK CO \n 055 VSP \n \n 
(MECK 911) 13-021182 TRESPASSING ON PRIVATE PROPRTY \n Reported: 05/08/2013 01:38:47 \n 107 MONTGOMERY ST \n / \n LACROSSE \n 098 877 VSP \n \n 
(MECK 911) 13-020886 ACCIDENT W/INJURY \n Reported: 05/06/2013 16:30:54 \n 8800-BLK OLD COX RD \n SR 660 / \n MECK CO \n 071 CCRS CO#3 F31 F32 R3 R41 VSP \n \n 
(MECK 911) 13-020899 ACCIDENT W/INJURY \n Reported: 05/06/2013 18:41:27 \n 1846 HIGHWAY FORTY-NINE \n SOUTH OF CLARKSVILLE / \n MECK CO \n CO#4 MCRS R32 R33 VSP \n \n 
(MECK 911) 13-020886 ACCIDENT W/INJURY \n Reported: 05/06/2013 16:30:54 \n 8000-BLK OLD COX RD \n SR 660 / \n MECK CO \n CCRS CO#3 VSP \n \n 
(MECK 911) 13-020871 ACCIDENT W/INJURY \n Reported: 05/06/2013 14:16:26 \n HIGHWAY FIFTY-EIGHT/ SULLIVAN RD \n MECK CO \n CO#4 MCRS VSP \n \n 
(MECK 911) 13-020840 ACCIDENT W/INJURY \n Reported: 05/06/2013 06:50:38 \n NB I-85 MM 19 \n / \n NB INTERSTATE EIGHTY-FIVE - MM 19  MECK CO \n CO#5 CO#7 F701 F73 R7 SSRS VSP \n \n 
(MECK 911) 13-020841 10-50 ACCIDENT \n Reported: 05/06/2013 06:54:02 \n EASTERS RD/ HAYES MILL RD \n MECK CO \n VSP \n \n 
(MECK 911) 13-020840 ACCIDENT W/INJURY \n Reported: 05/06/2013 06:50:38 \n NB I-85 MM 19 \n / \n NB INTERSTATE EIGHTY-FIVE - MM 19  MECK CO \n CO#7 VSP \n \n 
(MECK 911) 13-020704 ACCIDENT W/PROPERTY DAMAGE \n Reported: 05/05/2013 09:55:05 \n HIGHWAY FIFTEEN/ NOBLIN FARM RD \n MECK CO \n VSP \n \n 
(MECK 911) 13-020691 SUSPICIOUS PERSONS / VEHICLE \n Reported: 05/05/2013 07:40:08 \n SB I-85 MM 2 \n / \n SB INTERSTATE EIGHTY-FIVE - MM 02  MECK CO \n VSP \n \n 
(MECK 911) 13-020687 CHASE IN PROGRESS \n Reported: 05/05/2013 03:14:59 \n SB I-85 \n / \n SB INTERSTATE EIGHTY-FIVE  MECK CO \n 042 046 VSP \n \n 
(MECK 911) 13-020667 DISTURBANCE \n Reported: 05/05/2013 00:37:44 \n 729 MORGAN FARM RD \n SR 702 / \n MECK CO \n 065 VSP \n \n 
(MECK 911) 13-020640 BREAKING AND ENTERING \n Reported: 05/04/2013 21:17:02 \n 1032 TRINITY CHURCH RD \n SR 641 / \n MECK CO \n 042 VSP \n \n 
(MECK 911) 13-020530 RECKLESS DRIVING \n Reported: 05/04/2013 08:17:45 \n SB I-85 MM 6 \n / \n SB INTERSTATE EIGHTY-FIVE - MM 06  MECK CO \n VSP \n \n 
(MECK 911) 13-020452 ASSIST MOTORIST \n Reported: 05/03/2013 22:06:49 \n NB I-85 MM 7 \n / \n NB INTERSTATE EIGHTY-FIVE - MM 07  MECK CO \n VSP \n \n 
(MECK 911) 13-020411 ACCIDENT W/PROPERTY DAMAGE \n Reported: 05/03/2013 16:09:52 \n SB I-85 MM 13 \n / \n SB INTERSTATE EIGHTY-FIVE - MM 13  MECK CO \n VSP \n \n 

Contact: Active911
Agency name: Mecklenburg County Sheriffs Offfice
Location: Boydton, VA, United States
Sender: swpage2@vameck911.com 

(MECK 911) 13-009546 BURGLAR ALARM \n Reported: 03/01/2013 11:49:43 \n 2173 ROCKY BRANCH RD \n SR 642 / \n MECK CO \n 087 \n \n 
(MECK 911) 13-009544 FOLLOW UP CALL \n Reported: 03/01/2013 11:25:48 \n 216 DORTCH LN \n / \n SOUTH HILL \n 087 \n \n 
(MECK 911) 13-009541 FOLLOW UP CALL \n Reported: 03/01/2013 11:06:16 \n 103 SOUTH BRUNSWICK AVE \n / \n SOUTH HILL POLICE DEPT.  SOUTH HILL \n 087 \n \n 
(MECK 911) 13-009536 BURGLAR ALARM \n Reported: 03/01/2013 10:19:43 \n 2173 ROCKY BRANCH RD \n SR 642 / \n MECK CO \n 087 \n \n 
(MECK 911) 13-009421 RUNAWAY JUVENILE \n Reported: 02/28/2013 11:24:15 \n 6825 SKIPWITH RD \n SR 688 / \n BLUESTONE SENIOR HIGH SCHOOL  MECK CO \n 048 \n \n 
(MECK 911) 13-009399 FOLLOW UP CALL \n Reported: 02/28/2013 08:27:57 \n 2685 WILLARDS MILL RD \n SR 604 / \n MECK CO \n 048 \n \n 
(MECK 911) 13-008974 TAKING REPORT \n Reported: 02/25/2013 16:51:33 \n 254 MONROE ST \n / \n MECKLENBURG COUNTY - SHERIFF ADM BLD  BOYDTON \n 087 \n \n 
(MECK 911) 13-008969 SERVING SHOW CAUSE \n Reported: 02/25/2013 16:14:54 \n 315 FURR ST \n OFF EAST ATLANTIC ST /  BEHIND BOJANGLES \n WAL MART  SOUTH HILL \n 087 \n \n 
(MECK 911) 13-008962 BUSY- UNLESS URGENT \n Reported: 02/25/2013 14:20:31 \n 401 MADISON ST \n / \n COMMONWEALTH ATTONERYS OFFICE  BOYDTON \n 087 \n \n 
(MECK 911) 13-008953 GRAND OR PETIT LARCENY \n Reported: 02/25/2013 12:38:44 \n 103 SOUTH BRUNSWICK AVE \n / \n SOUTH HILL POLICE DEPT.  SOUTH HILL \n 019 087 \n \n 
(MECK 911) 13-008925 BURGLAR ALARM \n Reported: 02/25/2013 07:11:18 \n 857 QUARTER RD \n SR 758 / \n CREEDLE AUTOMOTIVE  MECK CO \n 087 \n \n 
(MECK 911) 13-008408 EXPOSED THEMSELVES \n Reported: 02/21/2013 18:00:07 \n 621 EVERGREEN LN \n / \n MECK CO \n 087 \n \n 
(MECK 911) 13-008395 ANIMAL COMPLAINT \n Reported: 02/21/2013 15:52:44 \n 814 HAWTREE WAY \n / \n MERRYMOUNT SUBD \n 061 087 \n \n 
(MECK 911) 13-008385 DISTURBANCE \n Reported: 02/21/2013 14:27:14 \n 91 MORRIS TOWN CIR \n SR 624 / \n MECK CO \n 087 \n \n 
(MECK 911) 13-008381 GRAND OR PETIT LARCENY \n Reported: 02/21/2013 12:59:24 \n 100-BLK BLACKRIDGE RD \n SR 626 / \n MECK CO \n 087 \n \n 
(MECK 911) 13-008364 COMPLAINT \n Reported: 02/21/2013 09:09:03 \n 309 BROOKSTONE DR \n / \n MECK CO \n 087 \n \n 
(MECK 911) 13-008363 BURGLAR ALARM \n Reported: 02/21/2013 08:57:59 \n 319 CLOVER RD \n / \n MECK CO \n 087 \n \n 
(MECK 911) 13-008358 COMPLAINT \n Reported: 02/21/2013 07:00:02 \n MARENGO RD/ MORRIS TOWN CIR \n MECK CO \n 087 \n \n 
(MECK 911) 13-008356 FOLLOW UP CALL \n Reported: 02/21/2013 06:32:50 \n 8188 HIGHWAY FIFTEEN NORT \n / \n UPPYS #24  (NEW LOCATION)  CLARKSVILLE \n 087 \n \n 
(MECK 911) 13-008216 FOLLOW UP CALL \n Reported: 02/20/2013 13:02:15 \n 3384 HIGHWAY NINE-O-THREE \n / \n UPPYS #4 - BRACEY  MECK CO \n 087 \n \n 

*/

public class VAMecklenburgCountyParserTest extends BaseParserTest {
  
  public VAMecklenburgCountyParserTest() {
    setParser(new VAMecklenburgCountyParser(), "MECKLENBURG COUNTY", "VA");
  }
  
  @Test
  public void testSouthsideRescueSquad() {

    doTest("T1",
        "(MECK 911) 13-021361 SUBJECT FALLEN \n Reported: 05/09/2013 04:23:53 \n 1276 WILSON RD \n SR 638 / \n MECK CO \n SSRS \n \n ",
        "ID:13-021361",
        "CALL:SUBJECT FALLEN",
        "DATE:05/09/2013",
        "TIME:04:23:53",
        "ADDR:1276 WILSON RD",
        "X:SR 638",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:SSRS");

    doTest("T2",
        "(MECK 911) 13-021275 DIABETIC \n" +
        " Reported: 05/08/2013 17:40:26 \n" +
        " 4507 HIGHWAY ONE \n" +
        " / \n" +
        " BOAT RAMP - STEEL BRIDGE  MECK CO \n" +
        " SSRS \n" +
        " \n" +
        " ",

        "ID:13-021275",
        "CALL:DIABETIC",
        "DATE:05/08/2013",
        "TIME:17:40:26",
        "ADDR:4507 HIGHWAY 1",    // Not mapping - reported to google
        "PLACE:BOAT RAMP - STEEL BRIDGE",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:SSRS");

    doTest("T3",
        "(MECK 911) 13-021264 PASSED OUT \n Reported: 05/08/2013 15:38:23 \n 365 PETER WALKER RD \n SR 765 / \n LACROSSE \n SSRS \n \n ",
        "ID:13-021264",
        "CALL:PASSED OUT",
        "DATE:05/08/2013",
        "TIME:15:38:23",
        "ADDR:365 PETER WALKER RD",
        "X:SR 765",
        "CITY:LA CROSSE",
        "UNIT:SSRS");

    doTest("T4",
        "(MECK 911) 13-021260 AUTO VS DEER W/DAMAGE \n" +
        " Reported: 05/08/2013 14:21:58 \n" +
        " SB I-85 MM 13 \n" +
        " / \n" +
        " SB INTERSTATE EIGHTY-FIVE - MM 13  MECK CO \n" +
        " CO#7 SSRS VSP \n" +
        " \n" +
        " ",

        "ID:13-021260",
        "CALL:AUTO VS DEER W/DAMAGE",
        "DATE:05/08/2013",
        "TIME:14:21:58",
        "ADDR:SB I-85 MM 13",
        "MADDR:I 85 MM 13",
        "PLACE:SB INTERSTATE EIGHTY-FIVE - MM 13",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:CO#7 SSRS VSP");

    doTest("T5",
        "(MECK 911) 13-021246 STROKE PATIENT \n Reported: 05/08/2013 10:43:54 \n 2661 MINERAL SPRINGS RD \n SR 711 / \n MECK CO \n SSRS \n \n ",
        "ID:13-021246",
        "CALL:STROKE PATIENT",
        "DATE:05/08/2013",
        "TIME:10:43:54",
        "ADDR:2661 MINERAL SPRINGS RD",
        "X:SR 711",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:SSRS");

    doTest("T6",
        "(MECK 911) 13-021237 ACCIDENT W/INJURY \n" +
        " Reported: 05/08/2013 08:03:08 \n" +
        " NB I-85 MM 1 \n" +
        " / \n" +
        " NB INTERSTATE EIGHTY-FIVE - MM 01  MECK CO \n" +
        " CO#7 SSRS \n" +
        " \n" +
        " ",

        "ID:13-021237",
        "CALL:ACCIDENT W/INJURY",
        "DATE:05/08/2013",
        "TIME:08:03:08",
        "ADDR:NB I-85 MM 1",
        "MADDR:I 85 MM 1",
        "PLACE:NB INTERSTATE EIGHTY-FIVE - MM 01",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:CO#7 SSRS");

    doTest("T7",
        "(MECK 911) 13-021208 HEART PROBLEMS \n Reported: 05/08/2013 04:02:32 \n 5796 GOODES FERRY RD \n / \n MECK CO \n SSRS \n \n ",
        "ID:13-021208",
        "CALL:HEART PROBLEMS",
        "DATE:05/08/2013",
        "TIME:04:02:32",
        "ADDR:5796 GOODES FERRY RD",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:SSRS");

    doTest("T8",
        "(MECK 911) 13-021112 SUBJECT FALLEN \n" +
        " Reported: 05/07/2013 21:41:37 \n" +
        " 2450 MINERAL SPRINGS RD \n" +
        " SR 711 / \n" +
        " PALMER SPRINGS FAMILY CARE  MECK CO \n" +
        " SSRS \n" +
        " \n" +
        " ",

        "ID:13-021112",
        "CALL:SUBJECT FALLEN",
        "DATE:05/07/2013",
        "TIME:21:41:37",
        "ADDR:2450 MINERAL SPRINGS RD",
        "X:SR 711",
        "PLACE:PALMER SPRINGS FAMILY CARE",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:SSRS");

    doTest("T9",
        "(MECK 911) 13-021085 DIABETIC \n Reported: 05/07/2013 19:57:03 \n 11232 SKIPWITH RD \n SR 688 / \n MECK CO \n CCRS R41 SSRS \n \n ",
        "ID:13-021085",
        "CALL:DIABETIC",
        "DATE:05/07/2013",
        "TIME:19:57:03",
        "ADDR:11232 SKIPWITH RD",
        "X:SR 688",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:CCRS R41 SSRS");

    doTest("T10",
        "(MECK 911) 13-021075 10-50 ACCIDENT \n" +
        " Reported: 05/07/2013 18:09:25 \n" +
        " 715 EAST ATLANTIC ST \n" +
        " / \n" +
        " FOOD LION - TOWNE SQUARE  SOUTH HILL \n" +
        " 409 SSRS \n" +
        " \n" +
        " ",

        "ID:13-021075",
        "CALL:10-50 ACCIDENT",
        "DATE:05/07/2013",
        "TIME:18:09:25",
        "ADDR:715 EAST ATLANTIC ST",
        "PLACE:FOOD LION - TOWNE SQUARE",
        "CITY:SOUTH HILL",
        "UNIT:409 SSRS");

    doTest("T11",
        "(MECK 911) 13-021052 STROKE PATIENT \n" +
        " Reported: 05/07/2013 13:41:54 \n" +
        " 621 ACADEMY LN \n" +
        " / \n" +
        " PINEVIEW RETIREMENT HOME  SOUTH HILL \n" +
        " SSRS \n" +
        " \n" +
        " ",

        "ID:13-021052",
        "CALL:STROKE PATIENT",
        "DATE:05/07/2013",
        "TIME:13:41:54",
        "ADDR:621 ACADEMY LN",
        "PLACE:PINEVIEW RETIREMENT HOME",
        "CITY:SOUTH HILL",
        "UNIT:SSRS");

    doTest("T12",
        "(MECK 911) 13-021027 SHORTNESS OF BREATH \n Reported: 05/07/2013 09:21:08 \n 211 EAST FERRELL ST \n / \n SOUTH HILL \n SSRS \n \n ",
        "ID:13-021027",
        "CALL:SHORTNESS OF BREATH",
        "DATE:05/07/2013",
        "TIME:09:21:08",
        "ADDR:211 EAST FERRELL ST",
        "CITY:SOUTH HILL",
        "UNIT:SSRS");

    doTest("T13",
        "(MECK 911) 13-021021 SHORTNESS OF BREATH \n Reported: 05/07/2013 08:53:18 \n 3487 STONEY CROSS RD \n SR 671 / \n MECK CO \n SSRS \n \n ",
        "ID:13-021021",
        "CALL:SHORTNESS OF BREATH",
        "DATE:05/07/2013",
        "TIME:08:53:18",
        "ADDR:3487 STONEY CROSS RD",
        "X:SR 671",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:SSRS");

    doTest("T14",
        "(MECK 911) 13-020905 SHORTNESS OF BREATH \n Reported: 05/06/2013 20:18:34 \n 1034 UNION MILL RD \n HWY 138 / \n MECK CO \n SSRS \n \n ",
        "ID:13-020905",
        "CALL:SHORTNESS OF BREATH",
        "DATE:05/06/2013",
        "TIME:20:18:34",
        "ADDR:1034 UNION MILL RD",
        "X:HWY 138",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:SSRS");

    doTest("T15",
        "(MECK 911) 13-020863 ILL, NOT FEELING WELL \n" +
        " Reported: 05/06/2013 13:12:08 \n" +
        " 501 VIRGINIA AVE \n" +
        " / \n" +
        " CHASE CITY \n" +
        " 207 CCRS R44 SSRS \n" +
        " \n" +
        " ",

        "ID:13-020863",
        "CALL:ILL, NOT FEELING WELL",
        "DATE:05/06/2013",
        "TIME:13:12:08",
        "ADDR:501 VIRGINIA AVE",
        "CITY:CHASE CITY",
        "UNIT:207 CCRS R44 SSRS");

    doTest("T16",
        "(MECK 911) 13-020850 SUBJECT FALLEN \n" +
        " Reported: 05/06/2013 08:56:47 \n" +
        " 18 HURON TRL \n" +
        " CALL GATE FOR ACCESS / \n" +
        " RIVER RIDGE SUB \n" +
        " SSRS \n" +
        " \n" +
        " ",

        "ID:13-020850",
        "CALL:SUBJECT FALLEN",
        "DATE:05/06/2013",
        "TIME:08:56:47",
        "ADDR:18 HURON TRL",
        "X:CALL GATE FOR ACCESS",
        "PLACE:RIVER RIDGE SUB",
        "UNIT:SSRS");
 
  }
  
  @Test
  public void testVSPA22() {

    doTest("T1",
        "(MECK 911) 13-021260 AUTO VS DEER W/DAMAGE \n" +
        " Reported: 05/08/2013 14:21:58 \n" +
        " SB I-85 MM 13 \n" +
        " / \n" +
        " SB INTERSTATE EIGHTY-FIVE - MM 13  MECK CO \n" +
        " CO#7 SSRS VSP \n" +
        " \n" +
        " ",

        "ID:13-021260",
        "CALL:AUTO VS DEER W/DAMAGE",
        "DATE:05/08/2013",
        "TIME:14:21:58",
        "ADDR:SB I-85 MM 13",
        "MADDR:I 85 MM 13",
        "PLACE:SB INTERSTATE EIGHTY-FIVE - MM 13",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:CO#7 SSRS VSP");

    doTest("T2",
        "(MECK 911) 13-021235 RECKLESS DRIVING \n" +
        " Reported: 05/08/2013 07:44:10 \n" +
        " NB I-85 MM 4 \n" +
        " / \n" +
        " NB INTERSTATE EIGHTY-FIVE - MM 04  MECK CO \n" +
        " 055 VSP \n" +
        " \n" +
        " ",

        "ID:13-021235",
        "CALL:RECKLESS DRIVING",
        "DATE:05/08/2013",
        "TIME:07:44:10",
        "ADDR:NB I-85 MM 4",
        "MADDR:I 85 MM 4",
        "PLACE:NB INTERSTATE EIGHTY-FIVE - MM 04",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:055 VSP");

    doTest("T3",
        "(MECK 911) 13-021237 ACCIDENT W/INJURY \n" +
        " Reported: 05/08/2013 08:03:08 \n" +
        " NB I-85 MM 1 \n" +
        " / \n" +
        " NB INTERSTATE EIGHTY-FIVE - MM 01  MECK CO \n" +
        " CO#7 F701 SSRS VSP \n" +
        " \n" +
        " ",

        "ID:13-021237",
        "CALL:ACCIDENT W/INJURY",
        "DATE:05/08/2013",
        "TIME:08:03:08",
        "ADDR:NB I-85 MM 1",
        "MADDR:I 85 MM 1",
        "PLACE:NB INTERSTATE EIGHTY-FIVE - MM 01",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:CO#7 F701 SSRS VSP");

    doTest("T4",
        "(MECK 911) 13-021235 RECKLESS DRIVING \n" +
        " Reported: 05/08/2013 07:44:10 \n" +
        " NB I-85 MM 4 \n" +
        " / \n" +
        " NB INTERSTATE EIGHTY-FIVE - MM 04  MECK CO \n" +
        " 055 VSP \n" +
        " \n" +
        " ",

        "ID:13-021235",
        "CALL:RECKLESS DRIVING",
        "DATE:05/08/2013",
        "TIME:07:44:10",
        "ADDR:NB I-85 MM 4",
        "MADDR:I 85 MM 4",
        "PLACE:NB INTERSTATE EIGHTY-FIVE - MM 04",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:055 VSP");

    doTest("T5",
        "(MECK 911) 13-021182 TRESPASSING ON PRIVATE PROPRTY \n" +
        " Reported: 05/08/2013 01:38:47 \n" +
        " 107 MONTGOMERY ST \n" +
        " / \n" +
        " LACROSSE \n" +
        " 098 877 VSP \n" +
        " \n" +
        " ",

        "ID:13-021182",
        "CALL:TRESPASSING ON PRIVATE PROPRTY",
        "DATE:05/08/2013",
        "TIME:01:38:47",
        "ADDR:107 MONTGOMERY ST",
        "CITY:LA CROSSE",
        "UNIT:098 877 VSP");

    doTest("T6",
        "(MECK 911) 13-020886 ACCIDENT W/INJURY \n" +
        " Reported: 05/06/2013 16:30:54 \n" +
        " 8800-BLK OLD COX RD \n" +
        " SR 660 / \n" +
        " MECK CO \n" +
        " 071 CCRS CO#3 F31 F32 R3 R41 VSP \n" +
        " \n" +
        " ",

        "ID:13-020886",
        "CALL:ACCIDENT W/INJURY",
        "DATE:05/06/2013",
        "TIME:16:30:54",
        "ADDR:8800-BLK OLD COX RD",
        "MADDR:8800 OLD COX RD",
        "X:SR 660",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:071 CCRS CO#3 F31 F32 R3 R41 VSP");

    doTest("T7",
        "(MECK 911) 13-020899 ACCIDENT W/INJURY \n" +
        " Reported: 05/06/2013 18:41:27 \n" +
        " 1846 HIGHWAY FORTY-NINE \n" +
        " SOUTH OF CLARKSVILLE / \n" +
        " MECK CO \n" +
        " CO#4 MCRS R32 R33 VSP \n" +
        " \n" +
        " ",

        "ID:13-020899",
        "CALL:ACCIDENT W/INJURY",
        "DATE:05/06/2013",
        "TIME:18:41:27",
        "ADDR:1846 HIGHWAY 49",
        "X:SOUTH OF CLARKSVILLE",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:CO#4 MCRS R32 R33 VSP");

    doTest("T8",
        "(MECK 911) 13-020886 ACCIDENT W/INJURY \n" +
        " Reported: 05/06/2013 16:30:54 \n" +
        " 8000-BLK OLD COX RD \n" +
        " SR 660 / \n" +
        " MECK CO \n" +
        " CCRS CO#3 VSP \n" +
        " \n" +
        " ",

        "ID:13-020886",
        "CALL:ACCIDENT W/INJURY",
        "DATE:05/06/2013",
        "TIME:16:30:54",
        "ADDR:8000-BLK OLD COX RD",
        "MADDR:8000 OLD COX RD",
        "X:SR 660",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:CCRS CO#3 VSP");

    doTest("T9",
        "(MECK 911) 13-020871 ACCIDENT W/INJURY \n" +
        " Reported: 05/06/2013 14:16:26 \n" +
        " HIGHWAY FIFTY-EIGHT/ SULLIVAN RD \n" +
        " MECK CO \n" +
        " CO#4 MCRS VSP \n" +
        " \n" +
        " ",

        "ID:13-020871",
        "CALL:ACCIDENT W/INJURY",
        "DATE:05/06/2013",
        "TIME:14:16:26",
        "ADDR:HIGHWAY 58 & SULLIVAN RD",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:CO#4 MCRS VSP");

    doTest("T10",
        "(MECK 911) 13-020840 ACCIDENT W/INJURY \n" +
        " Reported: 05/06/2013 06:50:38 \n" +
        " NB I-85 MM 19 \n" +
        " / \n" +
        " NB INTERSTATE EIGHTY-FIVE - MM 19  MECK CO \n" +
        " CO#5 CO#7 F701 F73 R7 SSRS VSP \n" +
        " \n" +
        " ",

        "ID:13-020840",
        "CALL:ACCIDENT W/INJURY",
        "DATE:05/06/2013",
        "TIME:06:50:38",
        "ADDR:NB I-85 MM 19",
        "MADDR:I 85 MM 19",
        "PLACE:NB INTERSTATE EIGHTY-FIVE - MM 19",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:CO#5 CO#7 F701 F73 R7 SSRS VSP");

    doTest("T11",
        "(MECK 911) 13-020841 10-50 ACCIDENT \n Reported: 05/06/2013 06:54:02 \n EASTERS RD/ HAYES MILL RD \n MECK CO \n VSP \n \n ",
        "ID:13-020841",
        "CALL:10-50 ACCIDENT",
        "DATE:05/06/2013",
        "TIME:06:54:02",
        "ADDR:EASTERS RD & HAYES MILL RD",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:VSP");

    doTest("T12",
        "(MECK 911) 13-020840 ACCIDENT W/INJURY \n" +
        " Reported: 05/06/2013 06:50:38 \n" +
        " NB I-85 MM 19 \n" +
        " / \n" +
        " NB INTERSTATE EIGHTY-FIVE - MM 19  MECK CO \n" +
        " CO#7 VSP \n" +
        " \n" +
        " ",

        "ID:13-020840",
        "CALL:ACCIDENT W/INJURY",
        "DATE:05/06/2013",
        "TIME:06:50:38",
        "ADDR:NB I-85 MM 19",
        "MADDR:I 85 MM 19",
        "PLACE:NB INTERSTATE EIGHTY-FIVE - MM 19",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:CO#7 VSP");

    doTest("T13",
        "(MECK 911) 13-020704 ACCIDENT W/PROPERTY DAMAGE \n" +
        " Reported: 05/05/2013 09:55:05 \n" +
        " HIGHWAY FIFTEEN/ NOBLIN FARM RD \n" +
        " MECK CO \n" +
        " VSP \n" +
        " \n" +
        " ",

        "ID:13-020704",
        "CALL:ACCIDENT W/PROPERTY DAMAGE",
        "DATE:05/05/2013",
        "TIME:09:55:05",
        "ADDR:HIGHWAY 15 & NOBLIN FARM RD",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:VSP");

    doTest("T14",
        "(MECK 911) 13-020691 SUSPICIOUS PERSONS / VEHICLE \n" +
        " Reported: 05/05/2013 07:40:08 \n" +
        " SB I-85 MM 2 \n" +
        " / \n" +
        " SB INTERSTATE EIGHTY-FIVE - MM 02  MECK CO \n" +
        " VSP \n" +
        " \n" +
        " ",

        "ID:13-020691",
        "CALL:SUSPICIOUS PERSONS / VEHICLE",
        "DATE:05/05/2013",
        "TIME:07:40:08",
        "ADDR:SB I-85 MM 2",
        "MADDR:I 85 MM 2",
        "PLACE:SB INTERSTATE EIGHTY-FIVE - MM 02",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:VSP");

    doTest("T15",
        "(MECK 911) 13-020687 CHASE IN PROGRESS \n" +
        " Reported: 05/05/2013 03:14:59 \n" +
        " SB I-85 \n" +
        " / \n" +
        " SB INTERSTATE EIGHTY-FIVE  MECK CO \n" +
        " 042 046 VSP \n" +
        " \n" +
        " ",

        "ID:13-020687",
        "CALL:CHASE IN PROGRESS",
        "DATE:05/05/2013",
        "TIME:03:14:59",
        "ADDR:SB I-85",
        "MADDR:I 85",
        "PLACE:SB INTERSTATE EIGHTY-FIVE",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:042 046 VSP");

    doTest("T16",
        "(MECK 911) 13-020667 DISTURBANCE \n Reported: 05/05/2013 00:37:44 \n 729 MORGAN FARM RD \n SR 702 / \n MECK CO \n 065 VSP \n \n ",
        "ID:13-020667",
        "CALL:DISTURBANCE",
        "DATE:05/05/2013",
        "TIME:00:37:44",
        "ADDR:729 MORGAN FARM RD",
        "X:SR 702",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:065 VSP");

    doTest("T17",
        "(MECK 911) 13-020640 BREAKING AND ENTERING \n" +
        " Reported: 05/04/2013 21:17:02 \n" +
        " 1032 TRINITY CHURCH RD \n" +
        " SR 641 / \n" +
        " MECK CO \n" +
        " 042 VSP \n" +
        " \n" +
        " ",

        "ID:13-020640",
        "CALL:BREAKING AND ENTERING",
        "DATE:05/04/2013",
        "TIME:21:17:02",
        "ADDR:1032 TRINITY CHURCH RD",
        "X:SR 641",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:042 VSP");

    doTest("T18",
        "(MECK 911) 13-020530 RECKLESS DRIVING \n" +
        " Reported: 05/04/2013 08:17:45 \n" +
        " SB I-85 MM 6 \n" +
        " / \n" +
        " SB INTERSTATE EIGHTY-FIVE - MM 06  MECK CO \n" +
        " VSP \n" +
        " \n" +
        " ",

        "ID:13-020530",
        "CALL:RECKLESS DRIVING",
        "DATE:05/04/2013",
        "TIME:08:17:45",
        "ADDR:SB I-85 MM 6",
        "MADDR:I 85 MM 6",
        "PLACE:SB INTERSTATE EIGHTY-FIVE - MM 06",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:VSP");

    doTest("T19",
        "(MECK 911) 13-020452 ASSIST MOTORIST \n" +
        " Reported: 05/03/2013 22:06:49 \n" +
        " NB I-85 MM 7 \n" +
        " / \n" +
        " NB INTERSTATE EIGHTY-FIVE - MM 07  MECK CO \n" +
        " VSP \n" +
        " \n" +
        " ",

        "ID:13-020452",
        "CALL:ASSIST MOTORIST",
        "DATE:05/03/2013",
        "TIME:22:06:49",
        "ADDR:NB I-85 MM 7",
        "MADDR:I 85 MM 7",
        "PLACE:NB INTERSTATE EIGHTY-FIVE - MM 07",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:VSP");

    doTest("T20",
        "(MECK 911) 13-020411 ACCIDENT W/PROPERTY DAMAGE \n" +
        " Reported: 05/03/2013 16:09:52 \n" +
        " SB I-85 MM 13 \n" +
        " / \n" +
        " SB INTERSTATE EIGHTY-FIVE - MM 13  MECK CO \n" +
        " VSP \n" +
        " \n" +
        " ",

        "ID:13-020411",
        "CALL:ACCIDENT W/PROPERTY DAMAGE",
        "DATE:05/03/2013",
        "TIME:16:09:52",
        "ADDR:SB I-85 MM 13",
        "MADDR:I 85 MM 13",
        "PLACE:SB INTERSTATE EIGHTY-FIVE - MM 13",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:VSP");

  }
  
  @Test
  public void testMecklenburgCountySheriffsOfffice() {

    doTest("T1",
        "(MECK 911) 13-009546 BURGLAR ALARM \n Reported: 03/01/2013 11:49:43 \n 2173 ROCKY BRANCH RD \n SR 642 / \n MECK CO \n 087 \n \n ",
        "ID:13-009546",
        "CALL:BURGLAR ALARM",
        "DATE:03/01/2013",
        "TIME:11:49:43",
        "ADDR:2173 ROCKY BRANCH RD",
        "X:SR 642",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:087");

    doTest("T2",
        "(MECK 911) 13-009544 FOLLOW UP CALL \n Reported: 03/01/2013 11:25:48 \n 216 DORTCH LN \n / \n SOUTH HILL \n 087 \n \n ",
        "ID:13-009544",
        "CALL:FOLLOW UP CALL",
        "DATE:03/01/2013",
        "TIME:11:25:48",
        "ADDR:216 DORTCH LN",
        "CITY:SOUTH HILL",
        "UNIT:087");

    doTest("T3",
        "(MECK 911) 13-009541 FOLLOW UP CALL \n" +
        " Reported: 03/01/2013 11:06:16 \n" +
        " 103 SOUTH BRUNSWICK AVE \n" +
        " / \n" +
        " SOUTH HILL POLICE DEPT.  SOUTH HILL \n" +
        " 087 \n" +
        " \n" +
        " ",

        "ID:13-009541",
        "CALL:FOLLOW UP CALL",
        "DATE:03/01/2013",
        "TIME:11:06:16",
        "ADDR:103 SOUTH BRUNSWICK AVE",
        "PLACE:SOUTH HILL POLICE DEPT.",
        "CITY:SOUTH HILL",
        "UNIT:087");

    doTest("T4",
        "(MECK 911) 13-009536 BURGLAR ALARM \n Reported: 03/01/2013 10:19:43 \n 2173 ROCKY BRANCH RD \n SR 642 / \n MECK CO \n 087 \n \n ",
        "ID:13-009536",
        "CALL:BURGLAR ALARM",
        "DATE:03/01/2013",
        "TIME:10:19:43",
        "ADDR:2173 ROCKY BRANCH RD",
        "X:SR 642",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:087");

    doTest("T5",
        "(MECK 911) 13-009421 RUNAWAY JUVENILE \n" +
        " Reported: 02/28/2013 11:24:15 \n" +
        " 6825 SKIPWITH RD \n" +
        " SR 688 / \n" +
        " BLUESTONE SENIOR HIGH SCHOOL  MECK CO \n" +
        " 048 \n" +
        " \n" +
        " ",

        "ID:13-009421",
        "CALL:RUNAWAY JUVENILE",
        "DATE:02/28/2013",
        "TIME:11:24:15",
        "ADDR:6825 SKIPWITH RD",
        "X:SR 688",
        "PLACE:BLUESTONE SENIOR HIGH SCHOOL",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:048");

    doTest("T6",
        "(MECK 911) 13-009399 FOLLOW UP CALL \n Reported: 02/28/2013 08:27:57 \n 2685 WILLARDS MILL RD \n SR 604 / \n MECK CO \n 048 \n \n ",
        "ID:13-009399",
        "CALL:FOLLOW UP CALL",
        "DATE:02/28/2013",
        "TIME:08:27:57",
        "ADDR:2685 WILLARDS MILL RD",
        "X:SR 604",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:048");

    doTest("T7",
        "(MECK 911) 13-008974 TAKING REPORT \n" +
        " Reported: 02/25/2013 16:51:33 \n" +
        " 254 MONROE ST \n" +
        " / \n" +
        " MECKLENBURG COUNTY - SHERIFF ADM BLD  BOYDTON \n" +
        " 087 \n" +
        " \n" +
        " ",

        "ID:13-008974",
        "CALL:TAKING REPORT",
        "DATE:02/25/2013",
        "TIME:16:51:33",
        "ADDR:254 MONROE ST",
        "PLACE:MECKLENBURG COUNTY - SHERIFF ADM BLD",
        "CITY:BOYDTON",
        "UNIT:087");

    doTest("T8",
        "(MECK 911) 13-008969 SERVING SHOW CAUSE \n" +
        " Reported: 02/25/2013 16:14:54 \n" +
        " 315 FURR ST \n" +
        " OFF EAST ATLANTIC ST /  BEHIND BOJANGLES \n" +
        " WAL MART  SOUTH HILL \n" +
        " 087 \n" +
        " \n" +
        " ",

        "ID:13-008969",
        "CALL:SERVING SHOW CAUSE",
        "DATE:02/25/2013",
        "TIME:16:14:54",
        "ADDR:315 FURR ST",
        "X:OFF EAST ATLANTIC ST /  BEHIND BOJANGLES",
        "PLACE:WAL MART",
        "CITY:SOUTH HILL",
        "UNIT:087");

    doTest("T9",
        "(MECK 911) 13-008962 BUSY- UNLESS URGENT \n" +
        " Reported: 02/25/2013 14:20:31 \n" +
        " 401 MADISON ST \n" +
        " / \n" +
        " COMMONWEALTH ATTONERYS OFFICE  BOYDTON \n" +
        " 087 \n" +
        " \n" +
        " ",

        "ID:13-008962",
        "CALL:BUSY- UNLESS URGENT",
        "DATE:02/25/2013",
        "TIME:14:20:31",
        "ADDR:401 MADISON ST",
        "PLACE:COMMONWEALTH ATTONERYS OFFICE",
        "CITY:BOYDTON",
        "UNIT:087");

    doTest("T10",
        "(MECK 911) 13-008953 GRAND OR PETIT LARCENY \n" +
        " Reported: 02/25/2013 12:38:44 \n" +
        " 103 SOUTH BRUNSWICK AVE \n" +
        " / \n" +
        " SOUTH HILL POLICE DEPT.  SOUTH HILL \n" +
        " 019 087 \n" +
        " \n" +
        " ",

        "ID:13-008953",
        "CALL:GRAND OR PETIT LARCENY",
        "DATE:02/25/2013",
        "TIME:12:38:44",
        "ADDR:103 SOUTH BRUNSWICK AVE",
        "PLACE:SOUTH HILL POLICE DEPT.",
        "CITY:SOUTH HILL",
        "UNIT:019 087");

    doTest("T11",
        "(MECK 911) 13-008925 BURGLAR ALARM \n" +
        " Reported: 02/25/2013 07:11:18 \n" +
        " 857 QUARTER RD \n" +
        " SR 758 / \n" +
        " CREEDLE AUTOMOTIVE  MECK CO \n" +
        " 087 \n" +
        " \n" +
        " ",

        "ID:13-008925",
        "CALL:BURGLAR ALARM",
        "DATE:02/25/2013",
        "TIME:07:11:18",
        "ADDR:857 QUARTER RD",
        "X:SR 758",
        "PLACE:CREEDLE AUTOMOTIVE",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:087");

    doTest("T12",
        "(MECK 911) 13-008408 EXPOSED THEMSELVES \n Reported: 02/21/2013 18:00:07 \n 621 EVERGREEN LN \n / \n MECK CO \n 087 \n \n ",
        "ID:13-008408",
        "CALL:EXPOSED THEMSELVES",
        "DATE:02/21/2013",
        "TIME:18:00:07",
        "ADDR:621 EVERGREEN LN",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:087");

    doTest("T13",
        "(MECK 911) 13-008395 ANIMAL COMPLAINT \n Reported: 02/21/2013 15:52:44 \n 814 HAWTREE WAY \n / \n MERRYMOUNT SUBD \n 061 087 \n \n ",
        "ID:13-008395",
        "CALL:ANIMAL COMPLAINT",
        "DATE:02/21/2013",
        "TIME:15:52:44",
        "ADDR:814 HAWTREE WAY",
        "PLACE:MERRYMOUNT SUBD",
        "UNIT:061 087");

    doTest("T14",
        "(MECK 911) 13-008385 DISTURBANCE \n Reported: 02/21/2013 14:27:14 \n 91 MORRIS TOWN CIR \n SR 624 / \n MECK CO \n 087 \n \n ",
        "ID:13-008385",
        "CALL:DISTURBANCE",
        "DATE:02/21/2013",
        "TIME:14:27:14",
        "ADDR:91 MORRIS TOWN CIR",
        "X:SR 624",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:087");

    doTest("T15",
        "(MECK 911) 13-008381 GRAND OR PETIT LARCENY \n" +
        " Reported: 02/21/2013 12:59:24 \n" +
        " 100-BLK BLACKRIDGE RD \n" +
        " SR 626 / \n" +
        " MECK CO \n" +
        " 087 \n" +
        " \n" +
        " ",

        "ID:13-008381",
        "CALL:GRAND OR PETIT LARCENY",
        "DATE:02/21/2013",
        "TIME:12:59:24",
        "ADDR:100-BLK BLACKRIDGE RD",
        "MADDR:100 BLACKRIDGE RD",
        "X:SR 626",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:087");

    doTest("T16",
        "(MECK 911) 13-008364 COMPLAINT \n Reported: 02/21/2013 09:09:03 \n 309 BROOKSTONE DR \n / \n MECK CO \n 087 \n \n ",
        "ID:13-008364",
        "CALL:COMPLAINT",
        "DATE:02/21/2013",
        "TIME:09:09:03",
        "ADDR:309 BROOKSTONE DR",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:087");

    doTest("T17",
        "(MECK 911) 13-008363 BURGLAR ALARM \n Reported: 02/21/2013 08:57:59 \n 319 CLOVER RD \n / \n MECK CO \n 087 \n \n ",
        "ID:13-008363",
        "CALL:BURGLAR ALARM",
        "DATE:02/21/2013",
        "TIME:08:57:59",
        "ADDR:319 CLOVER RD",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:087");

    doTest("T18",
        "(MECK 911) 13-008358 COMPLAINT \n Reported: 02/21/2013 07:00:02 \n MARENGO RD/ MORRIS TOWN CIR \n MECK CO \n 087 \n \n ",
        "ID:13-008358",
        "CALL:COMPLAINT",
        "DATE:02/21/2013",
        "TIME:07:00:02",
        "ADDR:MARENGO RD & MORRIS TOWN CIR",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:087");

    doTest("T19",
        "(MECK 911) 13-008356 FOLLOW UP CALL \n" +
        " Reported: 02/21/2013 06:32:50 \n" +
        " 8188 HIGHWAY FIFTEEN NORT \n" +
        " / \n" +
        " UPPYS #24  (NEW LOCATION)  CLARKSVILLE \n" +
        " 087 \n" +
        " \n" +
        " ",

        "ID:13-008356",
        "CALL:FOLLOW UP CALL",
        "DATE:02/21/2013",
        "TIME:06:32:50",
        "ADDR:8188 HIGHWAY 15 NORT",
        "PLACE:UPPYS #24  (NEW LOCATION)",
        "CITY:CLARKSVILLE",
        "UNIT:087");

    doTest("T20",
        "(MECK 911) 13-008216 FOLLOW UP CALL \n" +
        " Reported: 02/20/2013 13:02:15 \n" +
        " 3384 HIGHWAY NINE-O-THREE \n" +
        " / \n" +
        " UPPYS #4 - BRACEY  MECK CO \n" +
        " 087 \n" +
        " \n" +
        " ",

        "ID:13-008216",
        "CALL:FOLLOW UP CALL",
        "DATE:02/20/2013",
        "TIME:13:02:15",
        "ADDR:3384 HIGHWAY 903",
        "PLACE:UPPYS #4 - BRACEY",
        "CITY:MECKLENBURG COUNTY",
        "UNIT:087");
  
  }
 
  public static void main(String[] args) {
    new VAMecklenburgCountyParserTest().generateTests("T1");
  }
}