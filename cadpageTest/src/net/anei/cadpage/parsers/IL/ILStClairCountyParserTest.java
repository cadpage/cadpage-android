package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
St Clair County, IL


Contact: Active911
Agency name: New Athens Fire Protection District
Location: New Athens, IL, United States
Sender: tcadinfo@stclaircountyil.gov

(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/ENTRAPMENT  Location: 3414 STATE RT 13, NEW ATHENS, 62264  (/WERNER RD) \nCreation Time: 06/27/2013 17:49:39  \nAgency: NEW ATHENS FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 3970 STATE RT 13, NEW ATHENS, 62264  (ROBINSON SCHOOL RD, FIVE FORKS RD/) \nCreation Time: 06/26/2013 17:38:20  \nAgency: NEW ATHENS FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 609 S BENTON ST, NEW ATHENS, 62264  (HUGHES ST/)  \nCreation Time: 06/25/2013 08:00:59  \nAgency: NEW ATHENS FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 2467 KEIM RD, NEW ATHENS, 62264  (WHITE ELM DR/)  \nCreation Time: 06/23/2013 20:59:50  \nAgency: NEW ATHENS FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 506 S JOHNSON ST, NEW ATHENS, 62264  (SPOTSYLVANIA ST/BELSHA ST)  \nCreation Time: 06/17/2013 15:48:15  \nAgency: NEW ATHENS FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 1111 PHILLIPS ST, NEW ATHENS, 62264  (NEW BALDWIN RD/OLD BALDWIN RD)  \nCreation Time: 06/14/2013 10:14:59  \nAgency: NEW ATHENS FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 400 S BENTON ST, NEW ATHENS, 62264  (BELSHA ST/SOUTH ST)  \nCreation Time: 06/12/2013 13:01:19  \nAgency: NEW ATHENS FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 1026 SPOTSYLVANIA ST, NEW ATHENS, 62264  (/HANFT ST)  \nCreation Time: 06/12/2013 02:46:56  \nAgency: NEW ATHENS FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE ALARM Location: 106 S CLINTON ST, NEW ATHENS, 62264  (ST CLAIR ST/KASKASKIA ST, N CLINTON ST) \nCreation Time: 06/07/2013 14:33:35  \nAgency: NEW ATHENS FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 2352 VINEGAR HILL RD, NEW ATHENS, 62264  (OLD STATE RT 13/) \nCreation Time: 05/27/2013 17:32:05  \nAgency: NEW ATHENS FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 103 N BENTON ST, NEW ATHENS, 62264  (CHESTER ST/KASKASKIA ST, S BENTON ST)  \nCreation Time: 05/25/2013 14:02:21  \nAgency: NEW ATHENS FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 604 S MARKET ST, NEW ATHENS, 62264  (HUGHES ST/SPOTSYLVANIA ST) \nCreation Time: 05/14/2013 17:41:31  \nAgency: NEW ATHENS FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 200 S VAN BUREN ST, NEW ATHENS, 62264  (MILL ST/ST CLAIR ST; Near:ROYS AUTO REPAIR) \nCreation Time: 05/11/2013 15:48:21  \nAgency: NEW ATHENS FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: BALDWIN RD/STATE RT 13, NEW ATHENS  \nCreation Time: 04/27/2013 05:12:41  \nAgency: NEW ATHENS FD 
\n﻿Fire Run\n\nResponse Type: FIRE ALARM    Location: 10 S ALTON ST, FREEBURG, 62243  (W HIGH ST/N ALTON ST, W WHITE ST; Near:LIGHTHOUSE LEARNING CENTER OF FREEBURG)    \nCreation Time: 04/09/2013 22:01:22    \nAgency: FREEBURG FD    
﻿Fire Run\n\nResponse Type: FIRE ALARM    Location: 10 S ALTON ST, FREEBURG, 62243  (W HIGH ST/N ALTON ST, W WHITE ST; Near:LIGHTHOUSE LEARNING CENTER OF FREEBURG)    \nCreation Time: 04/09/2013 22:01:22    \nAgency: FREEBURG FD    

Contact: Active911
Agency name: Smithton Fire Dept.
Location: Smithton, IL, United States
Sender: tcadinfo@stclaircountyil.gov

(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/ENTRAPMENT  Location: STATE RT 159, FREEBURG/DOUGLAS RD, SMITHTON \nCreation Time: 06/29/2013 17:32:21  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 505 S MAIN ST, SMITHTON, 62285  \nCreation Time: 06/26/2013 14:12:20  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: OLD FEED MILL \nCreation Time: 06/24/2013 19:14:41  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/INJURY  Location: N STATE ST, FREEBURG, 62243 \nCreation Time: 06/15/2013 11:41:00  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 740 CEMETERY RD, FREEBURG, 62243  \nCreation Time: 06/07/2013 14:48:27  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 3000 S ILLINOIS ST, BELLEVILLE, 62220 \nCreation Time: 06/05/2013 21:44:50  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE ALARM Location: 309 SILVERTHORNE DR, FREEBURG, 62243  (/REDCLIFF DR)  \nCreation Time: 06/05/2013 19:58:29  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: MEDICAL - FIRST RESPONDERS Location: 429 S JULIA ST, SMITHTON, 62285  (MEMORIAL DR/W FRANKLIN ST)  \nCreation Time: 06/02/2013 09:44:49  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 159 south of stonegate  \nCreation Time: 06/01/2013 16:59:25  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: MEDICAL - FIRST RESPONDERS Location: 711 N MAIN ST, SMITHTON, 62285  (; Near:SMITHTON FIRE DEPT.)  \nCreation Time: 05/31/2013 12:38:44  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 101 S VINE ST, FREEBURG, 62243  (E WASHINGTON ST/E HIGH ST) \nCreation Time: 05/30/2013 17:17:08  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: MEDICAL - FIRST RESPONDERS Location: 304 EUGENIA ST, SMITHTON, 62285 \nCreation Time: 05/30/2013 10:19:32  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE BRUSH Location: OLD FREEBURG RD/S GREEN MOUNT RD, BELLEVILLE  \nCreation Time: 05/29/2013 21:43:50  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: MEDICAL - FIRST RESPONDERS Location: 6470 ROBINSON SCHOOL RD, NEW ATHENS, 62264  (BLACKSMITH SHOP RD/) \nCreation Time: 05/29/2013 20:55:26  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE HAZMAT  Location: E STATE RT 15, BELLEVILLE/PEABODY RD, FREEBURG  \nCreation Time: 05/24/2013 15:57:38  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/INJURY  Location: STATE RT 159/DOUGLAS RD, SMITHTON \nCreation Time: 05/17/2013 21:10:15  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/ENTRAPMENT  Location: 3000 S ILLINOIS ST, BELLEVILLE, 62220 \nCreation Time: 05/15/2013 23:43:39  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/INJURY  Location: STATE RT 159, SMITHTON/FLECKENSTEIN RD, NEW ATHENS  \nCreation Time: 05/12/2013 14:47:47  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE ALARM Location: 3001 SAVE RD, BELLEVILLE, 62221  (LEE HOPP DR/UNNAMED RD) \nCreation Time: 05/07/2013 09:55:47  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE BRUSH Location: 2652 OLD FREEBURG RD, BELLEVILLE, 62220 \nCreation Time: 05/06/2013 20:18:34  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/INJURY  Location: DOUGLAS RD, SMITHTON/STATE RT 159, FREEBURG \nCreation Time: 05/02/2013 17:10:24  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE ALARM Location: 746 URBANNA DR, FREEBURG, 62243 \nCreation Time: 05/02/2013 11:00:24  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: MEDICAL - FIRST RESPONDERS Location: STATE RT 159/DOUGLAS RD, FREEBURG \nCreation Time: 04/30/2013 05:30:28  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 3401 LUNCH RD, BELLEVILLE, 62220  \nCreation Time: 04/27/2013 07:06:51  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: E WASHINGTON ST/S STATE ST, FREEBURG  \nCreation Time: 04/26/2013 19:35:26  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 3401 LUNCH RD, BELLEVILLE, 62220  \nCreation Time: 04/26/2013 13:16:22  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 3401 LUNCH RD, BELLEVILLE, 62220  \nCreation Time: 04/26/2013 13:16:22  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: N STATE ST/W ST CLAIR ST, FREEBURG  \nCreation Time: 04/24/2013 08:12:32  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: MEDICAL - FIRST RESPONDERS Location: S ILLINOIS ST/SCHLUETER-GERMAINE RD (SCHLUETER GERMAINE RD), BELLEVILLE \nCreation Time: 04/22/2013 15:26:32  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 524 SCHLUETER-GERMAINE RD, BELLEVILLE, 62220  \nCreation Time: 04/20/2013 21:16:12  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 407 N MAIN ST, SMITHTON, 62285  (CENTER ST/BREVO ST)  \nCreation Time: 04/19/2013 19:48:03  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: MEDICAL - FIRST RESPONDERS Location: 4921 LONE ROCK LN, SMITHTON, 62285  (/DRIFTSTONE LN)  \nCreation Time: 04/19/2013 07:12:03  \nAgency: SMITHTON FD 

Contact: Active911
Agency name: Fairmont City Fire Department
Location: Fairmont City, IL, United States
Sender: tcadinfo@stclaircountyil.gov

{[Alert] Notification} ﻿Fire Run\n\nResponse Type: FIRE Location: 5533 COLLINSVILLE RD, FAIRMONT CITY,  62201  (CANTEEN ST/JONDRO AVE)  \nCreation Time: 05/20/2013 21:58:24  \nAgency: FAIRMONT CITY FD  
{[Alert] Notification} ﻿Fire Run\n\nResponse Type: FIRE ALARM Location: 1245 N 1ST ST, FAIRMONT CITY, 62201  (; Near:APEX RECYCLING)  \nCreation Time: 05/18/2013 11:15:56  \nAgency: FAIRMONT CITY FD  
{[Alert] Notification} ﻿Fire Run\n\nResponse Type: FIRE Location: 3107 #21 KINGSHIGHWAY, FAIRMONT CITY, 62201  (UNNAMED RD/)  \nCreation Time: 05/18/2013 03:11:17  \nAgency: FAIRMONT CITY FD  
{[Alert] Notification} ﻿Fire Run\n\nResponse Type: FIRE Location: 5110 COLLINSVILLE RD, FAIRMONT CITY, 62201  (UNNAMED RD/N 51ST ST)  \nCreation Time: 05/14/2013 12:07:02  \nAgency: FAIRMONT CITY FD  
{[Alert] Notification} ﻿Fire Run\n\nResponse Type: FIRE BRUSH Location: 312 S 5TH ST, BROOKLYN, 62059  (CANAL ST/WASHINGTON ST; Near:BROOKLYN POLICE DEPT)  \nCreation Time: 05/09/2013 15:17:24  \nAgency: FAIRMONT CITY FD  

Contact: Active911
Agency name: Freeburg Fire
Location: Freeburg, IL, United States
Sender: tcadinfo@stclaircountyil.gov

(Notification) ﻿Fire Run\n\nResponse Type: MEDICAL - FIRST RESPONDERS Location: 429 S JULIA ST, SMITHTON, 62285  (MEMORIAL DR/W FRANKLIN ST)  \nCreation Time: 06/02/2013 09:44:49  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 159 south of stonegate  \nCreation Time: 06/01/2013 16:59:25  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: MEDICAL - FIRST RESPONDERS Location: 711 N MAIN ST, SMITHTON, 62285  (; Near:SMITHTON FIRE DEPT.)  \nCreation Time: 05/31/2013 12:38:44  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 101 S VINE ST, FREEBURG, 62243  (E WASHINGTON ST/E HIGH ST) \nCreation Time: 05/30/2013 17:17:08  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: MEDICAL - FIRST RESPONDERS Location: 304 EUGENIA ST, SMITHTON, 62285 \nCreation Time: 05/30/2013 10:19:32  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE BRUSH Location: OLD FREEBURG RD/S GREEN MOUNT RD, BELLEVILLE  \nCreation Time: 05/29/2013 21:43:50  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: MEDICAL - FIRST RESPONDERS Location: 6470 ROBINSON SCHOOL RD, NEW ATHENS, 62264  (BLACKSMITH SHOP RD/) \nCreation Time: 05/29/2013 20:55:26  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE HAZMAT  Location: E STATE RT 15, BELLEVILLE/PEABODY RD, FREEBURG  \nCreation Time: 05/24/2013 15:57:38  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/INJURY  Location: STATE RT 159/DOUGLAS RD, SMITHTON \nCreation Time: 05/17/2013 21:10:15  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/ENTRAPMENT  Location: 3000 S ILLINOIS ST, BELLEVILLE, 62220 \nCreation Time: 05/15/2013 23:43:39  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/INJURY  Location: STATE RT 159, SMITHTON/FLECKENSTEIN RD, NEW ATHENS  \nCreation Time: 05/12/2013 14:47:47  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE ALARM Location: 3001 SAVE RD, BELLEVILLE, 62221  (LEE HOPP DR/UNNAMED RD) \nCreation Time: 05/07/2013 09:55:47  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE BRUSH Location: 2652 OLD FREEBURG RD, BELLEVILLE, 62220 \nCreation Time: 05/06/2013 20:18:34  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/INJURY  Location: DOUGLAS RD, SMITHTON/STATE RT 159, FREEBURG \nCreation Time: 05/02/2013 17:10:24  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE ALARM Location: 746 URBANNA DR, FREEBURG, 62243 \nCreation Time: 05/02/2013 11:00:24  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: MEDICAL - FIRST RESPONDERS Location: STATE RT 159/DOUGLAS RD, FREEBURG \nCreation Time: 04/30/2013 05:30:28  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: E WASHINGTON ST/S STATE ST, FREEBURG  \nCreation Time: 04/26/2013 19:35:26  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 3401 LUNCH RD, BELLEVILLE, 62220  \nCreation Time: 04/26/2013 13:16:22  \nAgency: SMITHTON FD 

Contact: Active911
Agency name: Freeburg Fire
Location: Freeburg, IL, United States
Sender: freeburgfire@yahoo.com, tcadinfo@stclaircountyil.gov

(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: N STATE ST/W ST CLAIR ST, FREEBURG  \nCreation Time: 04/24/2013 08:12:32  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: MEDICAL - FIRST RESPONDERS Location: S ILLINOIS ST/SCHLUETER-GERMAINE RD (SCHLUETER GERMAINE RD), BELLEVILLE \nCreation Time: 04/22/2013 15:26:32  \nAgency: SMITHTON FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE EMS Location: 214 N MAIN ST, FREEBURG, 62243  (/W PHILLIPS ST)  \nCreation Time: 04/20/2013 03:34:48  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/INJURY  Location: 4200 STATE RT 15, FREEBURG, 62243  (/ROSS DR) \nCreation Time: 04/18/2013 14:26:51  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE WATER RESCUE/RECOVERY Location: PEABODY RD/WHITE OAKS CLUB RD, FREEBURG \nCreation Time: 04/18/2013 12:45:22  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 17 DEERFIELD CT, FREEBURG, 62243  \nCreation Time: 04/18/2013 01:28:26  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE ALARM Location: 10 S ALTON ST, FREEBURG, 62243  (W HIGH ST/N ALTON ST, W WHITE ST; Near:LIGHTHOUSE LEARNING CENTER OF FREEBURG) \nCreation Time: 04/09/2013 22:01:22  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE BRUSH Location: 2014 CAMP JACKSON RD, CAHOKIA, 62206  (LYNN ST/LOUISE AVE)  \nCreation Time: 04/08/2013 15:12:16  \nAgency: FREEBURG FD 
(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/INJURY  Location: RENTCHLER RD/JEFFERSON RD, BELLEVILLE \nCreation Time: 04/06/2013 07:53:38  \nAgency: FREEBURG FD 
Fire Run\n\nResponse Type: FIRE    Location: 410 W HIGH ST, FREEBURG, 62243 (UNNAMED RD/S MAIN ST) \nCreation Time: 04/01/2013 17:22:05 \nAgency: FREEBURG FD��� 

Contact: Active911
Agency name: Belleville Fire Department
Location: Belleville, IL, United States
Sender: tcadinfo@stclaircountyil.gov

(Notification) ﻿Fire Run\n\nResponse Type: FIRE ALARM Location: 300 ALLSUP PL, BELLEVILLE, 62223  (W STATE RT 15/TOWN HALL RD)  \nCreation Time: 07/15/2013 08:17:56  \nAgency: BELLEVILLE FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: @Central Jr. High School  (1801 CENTRAL SCHOOL RD)  \nCreation Time: 07/15/2013 05:36:19  \nAgency: BELLEVILLE FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 15 PINECREST CIR, BELLEVILLE, 62223  (/EXPRESS DR)  \nCreation Time: 07/15/2013 05:02:36  \nAgency: BELLEVILLE FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: @Roosevelt School  (700 WEST CLEVELAND) \nCreation Time: 07/15/2013 00:53:57  \nAgency: BELLEVILLE FD 
(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/LANE BLOCKAGE Location: 7200 OLD ST LOUIS RD, BELLEVILLE, 62223  (UNNAMED RD/HILLSIDE LN) #BLK  \nCreation Time: 07/14/2013 18:54:22  \nAgency: BELLEVILLE FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 1315 E A ST, BELLEVILLE, 62221  (N MICHIGAN AVE/N FLORIDA AVE)  \nCreation Time: 07/14/2013 08:19:31  \nAgency: BELLEVILLE FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE ALARM Location: @ST ELIZABETHS HOSPITAL  (211 S 3RD ST) \nCreation Time: 07/14/2013 04:38:36  \nAgency: BELLEVILLE FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 238 FREEDOM DR, BELLEVILLE, 62226   #B  \nCreation Time: 07/13/2013 21:02:59  \nAgency: BELLEVILLE FD 
(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: 1050 WEST BLVD, BELLEVILLE, 62221  (REDWOOD DR/MALLARD DR, OLD COLLINSVILLE RD) \nCreation Time: 07/13/2013 16:21:45  \nAgency: BELLEVILLE FD 
(Notification) ﻿Fire Run\n\nResponse Type: ACCIDENT W/INJURY  Location: 2100 W MAIN ST , BELLEVILLE \nCreation Time: 07/13/2013 12:38:53  \nAgency: BELLEVILLE FD 
 
*/

public class ILStClairCountyParserTest extends BaseParserTest {
  
  public ILStClairCountyParserTest() {
    setParser(new ILStClairCountyParser(), "ST CLAIR COUNTY", "IL");
  }
  
  @Test
  public void testNewAthens() {

    doTest("T1",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: ACCIDENT W/ENTRAPMENT  Location: 3414 STATE RT 13, NEW ATHENS, 62264  (/WERNER RD) \n" +
        "Creation Time: 06/27/2013 17:49:39  \n" +
        "Agency: NEW ATHENS FD ",

        "CALL:ACCIDENT W/ENTRAPMENT",
        "ADDR:3414 STATE RT 13",
        "MADDR:3414 STATE 13",
        "CITY:NEW ATHENS",
        "X:WERNER RD",
        "DATE:06/27/2013",
        "TIME:17:49:39",
        "SRC:NEW ATHENS FD");

    doTest("T2",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 3970 STATE RT 13, NEW ATHENS, 62264  (ROBINSON SCHOOL RD, FIVE FORKS RD/) \n" +
        "Creation Time: 06/26/2013 17:38:20  \n" +
        "Agency: NEW ATHENS FD ",

        "CALL:FIRE",
        "ADDR:3970 STATE RT 13",
        "MADDR:3970 STATE 13",
        "CITY:NEW ATHENS",
        "X:ROBINSON SCHOOL RD, FIVE FORKS RD/",
        "DATE:06/26/2013",
        "TIME:17:38:20",
        "SRC:NEW ATHENS FD");

    doTest("T3",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 609 S BENTON ST, NEW ATHENS, 62264  (HUGHES ST/)  \n" +
        "Creation Time: 06/25/2013 08:00:59  \n" +
        "Agency: NEW ATHENS FD ",

        "CALL:FIRE",
        "ADDR:609 S BENTON ST",
        "CITY:NEW ATHENS",
        "X:HUGHES ST/",
        "DATE:06/25/2013",
        "TIME:08:00:59",
        "SRC:NEW ATHENS FD");

    doTest("T4",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 2467 KEIM RD, NEW ATHENS, 62264  (WHITE ELM DR/)  \n" +
        "Creation Time: 06/23/2013 20:59:50  \n" +
        "Agency: NEW ATHENS FD ",

        "CALL:FIRE",
        "ADDR:2467 KEIM RD",
        "CITY:NEW ATHENS",
        "X:WHITE ELM DR/",
        "DATE:06/23/2013",
        "TIME:20:59:50",
        "SRC:NEW ATHENS FD");

    doTest("T5",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 506 S JOHNSON ST, NEW ATHENS, 62264  (SPOTSYLVANIA ST/BELSHA ST)  \n" +
        "Creation Time: 06/17/2013 15:48:15  \n" +
        "Agency: NEW ATHENS FD ",

        "CALL:FIRE",
        "ADDR:506 S JOHNSON ST",
        "CITY:NEW ATHENS",
        "X:SPOTSYLVANIA ST/BELSHA ST",
        "DATE:06/17/2013",
        "TIME:15:48:15",
        "SRC:NEW ATHENS FD");

    doTest("T6",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 1111 PHILLIPS ST, NEW ATHENS, 62264  (NEW BALDWIN RD/OLD BALDWIN RD)  \n" +
        "Creation Time: 06/14/2013 10:14:59  \n" +
        "Agency: NEW ATHENS FD ",

        "CALL:FIRE",
        "ADDR:1111 PHILLIPS ST",
        "CITY:NEW ATHENS",
        "X:NEW BALDWIN RD/OLD BALDWIN RD",
        "DATE:06/14/2013",
        "TIME:10:14:59",
        "SRC:NEW ATHENS FD");

    doTest("T7",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 400 S BENTON ST, NEW ATHENS, 62264  (BELSHA ST/SOUTH ST)  \n" +
        "Creation Time: 06/12/2013 13:01:19  \n" +
        "Agency: NEW ATHENS FD ",

        "CALL:FIRE",
        "ADDR:400 S BENTON ST",
        "CITY:NEW ATHENS",
        "X:BELSHA ST/SOUTH ST",
        "DATE:06/12/2013",
        "TIME:13:01:19",
        "SRC:NEW ATHENS FD");

    doTest("T8",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 1026 SPOTSYLVANIA ST, NEW ATHENS, 62264  (/HANFT ST)  \n" +
        "Creation Time: 06/12/2013 02:46:56  \n" +
        "Agency: NEW ATHENS FD ",

        "CALL:FIRE",
        "ADDR:1026 SPOTSYLVANIA ST",
        "CITY:NEW ATHENS",
        "X:HANFT ST",
        "DATE:06/12/2013",
        "TIME:02:46:56",
        "SRC:NEW ATHENS FD");

    doTest("T9",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE ALARM Location: 106 S CLINTON ST, NEW ATHENS, 62264  (ST CLAIR ST/KASKASKIA ST, N CLINTON ST) \n" +
        "Creation Time: 06/07/2013 14:33:35  \n" +
        "Agency: NEW ATHENS FD ",

        "CALL:FIRE ALARM",
        "ADDR:106 S CLINTON ST",
        "CITY:NEW ATHENS",
        "X:ST CLAIR ST/KASKASKIA ST, N CLINTON ST",
        "DATE:06/07/2013",
        "TIME:14:33:35",
        "SRC:NEW ATHENS FD");

    doTest("T10",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 2352 VINEGAR HILL RD, NEW ATHENS, 62264  (OLD STATE RT 13/) \n" +
        "Creation Time: 05/27/2013 17:32:05  \n" +
        "Agency: NEW ATHENS FD ",

        "CALL:FIRE",
        "ADDR:2352 VINEGAR HILL RD",
        "CITY:NEW ATHENS",
        "X:OLD STATE RT 13/",
        "DATE:05/27/2013",
        "TIME:17:32:05",
        "SRC:NEW ATHENS FD");

    doTest("T11",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 103 N BENTON ST, NEW ATHENS, 62264  (CHESTER ST/KASKASKIA ST, S BENTON ST)  \n" +
        "Creation Time: 05/25/2013 14:02:21  \n" +
        "Agency: NEW ATHENS FD ",

        "CALL:FIRE",
        "ADDR:103 N BENTON ST",
        "CITY:NEW ATHENS",
        "X:CHESTER ST/KASKASKIA ST, S BENTON ST",
        "DATE:05/25/2013",
        "TIME:14:02:21",
        "SRC:NEW ATHENS FD");

    doTest("T12",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 604 S MARKET ST, NEW ATHENS, 62264  (HUGHES ST/SPOTSYLVANIA ST) \n" +
        "Creation Time: 05/14/2013 17:41:31  \n" +
        "Agency: NEW ATHENS FD ",

        "CALL:FIRE",
        "ADDR:604 S MARKET ST",
        "CITY:NEW ATHENS",
        "X:HUGHES ST/SPOTSYLVANIA ST",
        "DATE:05/14/2013",
        "TIME:17:41:31",
        "SRC:NEW ATHENS FD");

    doTest("T13",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 200 S VAN BUREN ST, NEW ATHENS, 62264  (MILL ST/ST CLAIR ST; Near:ROYS AUTO REPAIR) \n" +
        "Creation Time: 05/11/2013 15:48:21  \n" +
        "Agency: NEW ATHENS FD ",

        "CALL:FIRE",
        "ADDR:200 S VAN BUREN ST",
        "CITY:NEW ATHENS",
        "X:MILL ST/ST CLAIR ST; Near:ROYS AUTO REPAIR",
        "DATE:05/11/2013",
        "TIME:15:48:21",
        "SRC:NEW ATHENS FD");

    doTest("T14",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: BALDWIN RD/STATE RT 13, NEW ATHENS  \n" +
        "Creation Time: 04/27/2013 05:12:41  \n" +
        "Agency: NEW ATHENS FD ",

        "CALL:FIRE",
        "ADDR:BALDWIN RD & STATE RT 13",
        "MADDR:BALDWIN RD & STATE 13",
        "CITY:NEW ATHENS",
        "DATE:04/27/2013",
        "TIME:05:12:41",
        "SRC:NEW ATHENS FD");

    doTest("T15",
        "\n﻿Fire Run\n\n" +
        "Response Type: FIRE ALARM    Location: 10 S ALTON ST, FREEBURG, 62243  (W HIGH ST/N ALTON ST, W WHITE ST; Near:LIGHTHOUSE LEARNING CENTER OF FREEBURG)    \n" +
        "Creation Time: 04/09/2013 22:01:22    \n" +
        "Agency: FREEBURG FD    ",

        "CALL:FIRE ALARM",
        "ADDR:10 S ALTON ST",
        "CITY:FREEBURG",
        "X:W HIGH ST/N ALTON ST, W WHITE ST; Near:LIGHTHOUSE LEARNING CENTER OF FREEBURG",
        "DATE:04/09/2013",
        "TIME:22:01:22",
        "SRC:FREEBURG FD");

    doTest("T16",
        "﻿Fire Run\n\n" +
        "Response Type: FIRE ALARM    Location: 10 S ALTON ST, FREEBURG, 62243  (W HIGH ST/N ALTON ST, W WHITE ST; Near:LIGHTHOUSE LEARNING CENTER OF FREEBURG)    \n" +
        "Creation Time: 04/09/2013 22:01:22    \n" +
        "Agency: FREEBURG FD    ",

        "CALL:FIRE ALARM",
        "ADDR:10 S ALTON ST",
        "CITY:FREEBURG",
        "X:W HIGH ST/N ALTON ST, W WHITE ST; Near:LIGHTHOUSE LEARNING CENTER OF FREEBURG",
        "DATE:04/09/2013",
        "TIME:22:01:22",
        "SRC:FREEBURG FD");
  }
           
  @Test
  public void testSmithton() {

    doTest("T1",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: ACCIDENT W/ENTRAPMENT  Location: STATE RT 159, FREEBURG/DOUGLAS RD, SMITHTON \n" +
        "Creation Time: 06/29/2013 17:32:21  \n" +
        "Agency: SMITHTON FD ",

        "CALL:ACCIDENT W/ENTRAPMENT",
        "ADDR:STATE RT 159, FREEBURG & DOUGLAS RD",
        "MADDR:STATE 159, FREEBURG & DOUGLAS RD",
        "CITY:SMITHTON",
        "DATE:06/29/2013",
        "TIME:17:32:21",
        "SRC:SMITHTON FD");

    doTest("T2",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 505 S MAIN ST, SMITHTON, 62285  \n" +
        "Creation Time: 06/26/2013 14:12:20  \n" +
        "Agency: SMITHTON FD ",

        "CALL:FIRE",
        "ADDR:505 S MAIN ST",
        "CITY:SMITHTON",
        "DATE:06/26/2013",
        "TIME:14:12:20",
        "SRC:SMITHTON FD");

    doTest("T3",
        "(Notification) ﻿Fire Run\n\nResponse Type: FIRE Location: OLD FEED MILL \nCreation Time: 06/24/2013 19:14:41  \nAgency: SMITHTON FD ",
        "CALL:FIRE",
        "ADDR:OLD FEED MILL",
        "DATE:06/24/2013",
        "TIME:19:14:41",
        "SRC:SMITHTON FD");

    doTest("T4",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: ACCIDENT W/INJURY  Location: N STATE ST, FREEBURG, 62243 \n" +
        "Creation Time: 06/15/2013 11:41:00  \n" +
        "Agency: FREEBURG FD ",

        "CALL:ACCIDENT W/INJURY",
        "ADDR:N STATE ST",
        "CITY:FREEBURG",
        "DATE:06/15/2013",
        "TIME:11:41:00",
        "SRC:FREEBURG FD");

    doTest("T5",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 740 CEMETERY RD, FREEBURG, 62243  \n" +
        "Creation Time: 06/07/2013 14:48:27  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE",
        "ADDR:740 CEMETERY RD",
        "CITY:FREEBURG",
        "DATE:06/07/2013",
        "TIME:14:48:27",
        "SRC:FREEBURG FD");

    doTest("T6",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 3000 S ILLINOIS ST, BELLEVILLE, 62220 \n" +
        "Creation Time: 06/05/2013 21:44:50  \n" +
        "Agency: SMITHTON FD ",

        "CALL:FIRE",
        "ADDR:3000 S ILLINOIS ST",
        "CITY:BELLEVILLE",
        "DATE:06/05/2013",
        "TIME:21:44:50",
        "SRC:SMITHTON FD");

    doTest("T7",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE ALARM Location: 309 SILVERTHORNE DR, FREEBURG, 62243  (/REDCLIFF DR)  \n" +
        "Creation Time: 06/05/2013 19:58:29  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE ALARM",
        "ADDR:309 SILVERTHORNE DR",
        "CITY:FREEBURG",
        "X:REDCLIFF DR",
        "DATE:06/05/2013",
        "TIME:19:58:29",
        "SRC:FREEBURG FD");

    doTest("T8",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: MEDICAL - FIRST RESPONDERS Location: 429 S JULIA ST, SMITHTON, 62285  (MEMORIAL DR/W FRANKLIN ST)  \n" +
        "Creation Time: 06/02/2013 09:44:49  \n" +
        "Agency: SMITHTON FD ",

        "CALL:MEDICAL - FIRST RESPONDERS",
        "ADDR:429 S JULIA ST",
        "CITY:SMITHTON",
        "X:MEMORIAL DR/W FRANKLIN ST",
        "DATE:06/02/2013",
        "TIME:09:44:49",
        "SRC:SMITHTON FD");

    doTest("T9",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 159 south of stonegate  \n" +
        "Creation Time: 06/01/2013 16:59:25  \n" +
        "Agency: SMITHTON FD ",

        "CALL:FIRE",
        "ADDR:159 south of stonegate",
        "MADDR:159 & stonegate",
        "DATE:06/01/2013",
        "TIME:16:59:25",
        "SRC:SMITHTON FD");

    doTest("T10",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: MEDICAL - FIRST RESPONDERS Location: 711 N MAIN ST, SMITHTON, 62285  (; Near:SMITHTON FIRE DEPT.)  \n" +
        "Creation Time: 05/31/2013 12:38:44  \n" +
        "Agency: SMITHTON FD ",

        "CALL:MEDICAL - FIRST RESPONDERS",
        "ADDR:711 N MAIN ST",
        "CITY:SMITHTON",
        "X:; Near:SMITHTON FIRE DEPT.",
        "DATE:05/31/2013",
        "TIME:12:38:44",
        "SRC:SMITHTON FD");

    doTest("T11",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 101 S VINE ST, FREEBURG, 62243  (E WASHINGTON ST/E HIGH ST) \n" +
        "Creation Time: 05/30/2013 17:17:08  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE",
        "ADDR:101 S VINE ST",
        "CITY:FREEBURG",
        "X:E WASHINGTON ST/E HIGH ST",
        "DATE:05/30/2013",
        "TIME:17:17:08",
        "SRC:FREEBURG FD");

    doTest("T12",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: MEDICAL - FIRST RESPONDERS Location: 304 EUGENIA ST, SMITHTON, 62285 \n" +
        "Creation Time: 05/30/2013 10:19:32  \n" +
        "Agency: SMITHTON FD ",

        "CALL:MEDICAL - FIRST RESPONDERS",
        "ADDR:304 EUGENIA ST",
        "CITY:SMITHTON",
        "DATE:05/30/2013",
        "TIME:10:19:32",
        "SRC:SMITHTON FD");

    doTest("T13",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE BRUSH Location: OLD FREEBURG RD/S GREEN MOUNT RD, BELLEVILLE  \n" +
        "Creation Time: 05/29/2013 21:43:50  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE BRUSH",
        "ADDR:OLD FREEBURG RD & S GREEN MOUNT RD",
        "CITY:BELLEVILLE",
        "DATE:05/29/2013",
        "TIME:21:43:50",
        "SRC:FREEBURG FD");

    doTest("T14",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: MEDICAL - FIRST RESPONDERS Location: 6470 ROBINSON SCHOOL RD, NEW ATHENS, 62264  (BLACKSMITH SHOP RD/) \n" +
        "Creation Time: 05/29/2013 20:55:26  \n" +
        "Agency: SMITHTON FD ",

        "CALL:MEDICAL - FIRST RESPONDERS",
        "ADDR:6470 ROBINSON SCHOOL RD",
        "CITY:NEW ATHENS",
        "X:BLACKSMITH SHOP RD/",
        "DATE:05/29/2013",
        "TIME:20:55:26",
        "SRC:SMITHTON FD");

    doTest("T15",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE HAZMAT  Location: E STATE RT 15, BELLEVILLE/PEABODY RD, FREEBURG  \n" +
        "Creation Time: 05/24/2013 15:57:38  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE HAZMAT",
        "ADDR:E STATE RT 15, BELLEVILLE & PEABODY RD",
        "MADDR:E STATE 15, BELLEVILLE & PEABODY RD",
        "CITY:FREEBURG",
        "DATE:05/24/2013",
        "TIME:15:57:38",
        "SRC:FREEBURG FD");

    doTest("T16",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: ACCIDENT W/INJURY  Location: STATE RT 159/DOUGLAS RD, SMITHTON \n" +
        "Creation Time: 05/17/2013 21:10:15  \n" +
        "Agency: SMITHTON FD ",

        "CALL:ACCIDENT W/INJURY",
        "ADDR:STATE RT 159 & DOUGLAS RD",
        "MADDR:STATE 159 & DOUGLAS RD",
        "CITY:SMITHTON",
        "DATE:05/17/2013",
        "TIME:21:10:15",
        "SRC:SMITHTON FD");

    doTest("T17",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: ACCIDENT W/ENTRAPMENT  Location: 3000 S ILLINOIS ST, BELLEVILLE, 62220 \n" +
        "Creation Time: 05/15/2013 23:43:39  \n" +
        "Agency: SMITHTON FD ",

        "CALL:ACCIDENT W/ENTRAPMENT",
        "ADDR:3000 S ILLINOIS ST",
        "CITY:BELLEVILLE",
        "DATE:05/15/2013",
        "TIME:23:43:39",
        "SRC:SMITHTON FD");

    doTest("T18",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: ACCIDENT W/INJURY  Location: STATE RT 159, SMITHTON/FLECKENSTEIN RD, NEW ATHENS  \n" +
        "Creation Time: 05/12/2013 14:47:47  \n" +
        "Agency: SMITHTON FD ",

        "CALL:ACCIDENT W/INJURY",
        "ADDR:STATE RT 159, SMITHTON & FLECKENSTEIN RD",
        "MADDR:STATE 159, SMITHTON & FLECKENSTEIN RD",
        "CITY:NEW ATHENS",
        "DATE:05/12/2013",
        "TIME:14:47:47",
        "SRC:SMITHTON FD");

    doTest("T19",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE ALARM Location: 3001 SAVE RD, BELLEVILLE, 62221  (LEE HOPP DR/UNNAMED RD) \n" +
        "Creation Time: 05/07/2013 09:55:47  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE ALARM",
        "ADDR:3001 SAVE RD",
        "CITY:BELLEVILLE",
        "X:LEE HOPP DR/UNNAMED RD",
        "DATE:05/07/2013",
        "TIME:09:55:47",
        "SRC:FREEBURG FD");

    doTest("T20",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE BRUSH Location: 2652 OLD FREEBURG RD, BELLEVILLE, 62220 \n" +
        "Creation Time: 05/06/2013 20:18:34  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE BRUSH",
        "ADDR:2652 OLD FREEBURG RD",
        "CITY:BELLEVILLE",
        "DATE:05/06/2013",
        "TIME:20:18:34",
        "SRC:FREEBURG FD");

    doTest("T21",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: ACCIDENT W/INJURY  Location: DOUGLAS RD, SMITHTON/STATE RT 159, FREEBURG \n" +
        "Creation Time: 05/02/2013 17:10:24  \n" +
        "Agency: SMITHTON FD ",

        "CALL:ACCIDENT W/INJURY",
        "ADDR:DOUGLAS RD, SMITHTON & STATE RT 159",
        "MADDR:DOUGLAS RD, SMITHTON & STATE 159",
        "CITY:FREEBURG",
        "DATE:05/02/2013",
        "TIME:17:10:24",
        "SRC:SMITHTON FD");

    doTest("T22",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE ALARM Location: 746 URBANNA DR, FREEBURG, 62243 \n" +
        "Creation Time: 05/02/2013 11:00:24  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE ALARM",
        "ADDR:746 URBANNA DR",
        "CITY:FREEBURG",
        "DATE:05/02/2013",
        "TIME:11:00:24",
        "SRC:FREEBURG FD");

    doTest("T23",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: MEDICAL - FIRST RESPONDERS Location: STATE RT 159/DOUGLAS RD, FREEBURG \n" +
        "Creation Time: 04/30/2013 05:30:28  \n" +
        "Agency: SMITHTON FD ",

        "CALL:MEDICAL - FIRST RESPONDERS",
        "ADDR:STATE RT 159 & DOUGLAS RD",
        "MADDR:STATE 159 & DOUGLAS RD",
        "CITY:FREEBURG",
        "DATE:04/30/2013",
        "TIME:05:30:28",
        "SRC:SMITHTON FD");

    doTest("T24",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 3401 LUNCH RD, BELLEVILLE, 62220  \n" +
        "Creation Time: 04/27/2013 07:06:51  \n" +
        "Agency: SMITHTON FD ",

        "CALL:FIRE",
        "ADDR:3401 LUNCH RD",
        "CITY:BELLEVILLE",
        "DATE:04/27/2013",
        "TIME:07:06:51",
        "SRC:SMITHTON FD");

    doTest("T25",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: E WASHINGTON ST/S STATE ST, FREEBURG  \n" +
        "Creation Time: 04/26/2013 19:35:26  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE",
        "ADDR:E WASHINGTON ST & S STATE ST",
        "CITY:FREEBURG",
        "DATE:04/26/2013",
        "TIME:19:35:26",
        "SRC:FREEBURG FD");

    doTest("T26",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 3401 LUNCH RD, BELLEVILLE, 62220  \n" +
        "Creation Time: 04/26/2013 13:16:22  \n" +
        "Agency: SMITHTON FD ",

        "CALL:FIRE",
        "ADDR:3401 LUNCH RD",
        "CITY:BELLEVILLE",
        "DATE:04/26/2013",
        "TIME:13:16:22",
        "SRC:SMITHTON FD");

    doTest("T27",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 3401 LUNCH RD, BELLEVILLE, 62220  \n" +
        "Creation Time: 04/26/2013 13:16:22  \n" +
        "Agency: SMITHTON FD ",

        "CALL:FIRE",
        "ADDR:3401 LUNCH RD",
        "CITY:BELLEVILLE",
        "DATE:04/26/2013",
        "TIME:13:16:22",
        "SRC:SMITHTON FD");

    doTest("T28",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: N STATE ST/W ST CLAIR ST, FREEBURG  \n" +
        "Creation Time: 04/24/2013 08:12:32  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE",
        "ADDR:N STATE ST & W ST CLAIR ST",
        "CITY:FREEBURG",
        "DATE:04/24/2013",
        "TIME:08:12:32",
        "SRC:FREEBURG FD");

    doTest("T29",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: MEDICAL - FIRST RESPONDERS Location: S ILLINOIS ST/SCHLUETER-GERMAINE RD (SCHLUETER GERMAINE RD), BELLEVILLE \n" +
        "Creation Time: 04/22/2013 15:26:32  \n" +
        "Agency: SMITHTON FD ",

        "CALL:MEDICAL - FIRST RESPONDERS",
        "ADDR:S ILLINOIS ST & SCHLUETER-GERMAINE RD (SCHLUETER GERMAINE RD)",
        "MADDR:S ILLINOIS ST & SCHLUETER-GERMAINE RD",
        "CITY:BELLEVILLE",
        "DATE:04/22/2013",
        "TIME:15:26:32",
        "SRC:SMITHTON FD");

    doTest("T30",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 524 SCHLUETER-GERMAINE RD, BELLEVILLE, 62220  \n" +
        "Creation Time: 04/20/2013 21:16:12  \n" +
        "Agency: SMITHTON FD ",

        "CALL:FIRE",
        "ADDR:524 SCHLUETER-GERMAINE RD",
        "CITY:BELLEVILLE",
        "DATE:04/20/2013",
        "TIME:21:16:12",
        "SRC:SMITHTON FD");

    doTest("T31",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 407 N MAIN ST, SMITHTON, 62285  (CENTER ST/BREVO ST)  \n" +
        "Creation Time: 04/19/2013 19:48:03  \n" +
        "Agency: SMITHTON FD ",

        "CALL:FIRE",
        "ADDR:407 N MAIN ST",
        "CITY:SMITHTON",
        "X:CENTER ST/BREVO ST",
        "DATE:04/19/2013",
        "TIME:19:48:03",
        "SRC:SMITHTON FD");

    doTest("T32",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: MEDICAL - FIRST RESPONDERS Location: 4921 LONE ROCK LN, SMITHTON, 62285  (/DRIFTSTONE LN)  \n" +
        "Creation Time: 04/19/2013 07:12:03  \n" +
        "Agency: SMITHTON FD ",

        "CALL:MEDICAL - FIRST RESPONDERS",
        "ADDR:4921 LONE ROCK LN",
        "CITY:SMITHTON",
        "X:DRIFTSTONE LN",
        "DATE:04/19/2013",
        "TIME:07:12:03",
        "SRC:SMITHTON FD");

  }
  
  @Test
  public void testFairmontCityFireDepartment() {

    doTest("T1",
        "{[Alert] Notification} ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 5533 COLLINSVILLE RD, FAIRMONT CITY,  62201  (CANTEEN ST/JONDRO AVE)  \n" +
        "Creation Time: 05/20/2013 21:58:24  \n" +
        "Agency: FAIRMONT CITY FD  ",

        "CALL:FIRE",
        "ADDR:5533 COLLINSVILLE RD",
        "CITY:FAIRMONT CITY",
        "X:CANTEEN ST/JONDRO AVE",
        "DATE:05/20/2013",
        "TIME:21:58:24",
        "SRC:FAIRMONT CITY FD");

    doTest("T2",
        "{[Alert] Notification} ﻿Fire Run\n\n" +
        "Response Type: FIRE ALARM Location: 1245 N 1ST ST, FAIRMONT CITY, 62201  (; Near:APEX RECYCLING)  \n" +
        "Creation Time: 05/18/2013 11:15:56  \n" +
        "Agency: FAIRMONT CITY FD  ",

        "CALL:FIRE ALARM",
        "ADDR:1245 N 1ST ST",
        "CITY:FAIRMONT CITY",
        "X:; Near:APEX RECYCLING",
        "DATE:05/18/2013",
        "TIME:11:15:56",
        "SRC:FAIRMONT CITY FD");

    doTest("T3",
        "{[Alert] Notification} ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 3107 #21 KINGSHIGHWAY, FAIRMONT CITY, 62201  (UNNAMED RD/)  \n" +
        "Creation Time: 05/18/2013 03:11:17  \n" +
        "Agency: FAIRMONT CITY FD  ",

        "CALL:FIRE",
        "ADDR:3107 #21 KINGSHIGHWAY",
        "CITY:FAIRMONT CITY",
        "X:UNNAMED RD/",
        "DATE:05/18/2013",
        "TIME:03:11:17",
        "SRC:FAIRMONT CITY FD");

    doTest("T4",
        "{[Alert] Notification} ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 5110 COLLINSVILLE RD, FAIRMONT CITY, 62201  (UNNAMED RD/N 51ST ST)  \n" +
        "Creation Time: 05/14/2013 12:07:02  \n" +
        "Agency: FAIRMONT CITY FD  ",

        "CALL:FIRE",
        "ADDR:5110 COLLINSVILLE RD",
        "CITY:FAIRMONT CITY",
        "X:UNNAMED RD/N 51ST ST",
        "DATE:05/14/2013",
        "TIME:12:07:02",
        "SRC:FAIRMONT CITY FD");

    doTest("T5",
        "{[Alert] Notification} ﻿Fire Run\n\n" +
        "Response Type: FIRE BRUSH Location: 312 S 5TH ST, BROOKLYN, 62059  (CANAL ST/WASHINGTON ST; Near:BROOKLYN POLICE DEPT)  \n" +
        "Creation Time: 05/09/2013 15:17:24  \n" +
        "Agency: FAIRMONT CITY FD  ",

        "CALL:FIRE BRUSH",
        "ADDR:312 S 5TH ST",
        "CITY:BROOKLYN",
        "X:CANAL ST/WASHINGTON ST; Near:BROOKLYN POLICE DEPT",
        "DATE:05/09/2013",
        "TIME:15:17:24",
        "SRC:FAIRMONT CITY FD");
    
  }
  
  @Test
  public void testFreeburgFire2() {

    doTest("T1",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: MEDICAL - FIRST RESPONDERS Location: 429 S JULIA ST, SMITHTON, 62285  (MEMORIAL DR/W FRANKLIN ST)  \n" +
        "Creation Time: 06/02/2013 09:44:49  \n" +
        "Agency: SMITHTON FD ",

        "CALL:MEDICAL - FIRST RESPONDERS",
        "ADDR:429 S JULIA ST",
        "CITY:SMITHTON",
        "X:MEMORIAL DR/W FRANKLIN ST",
        "DATE:06/02/2013",
        "TIME:09:44:49",
        "SRC:SMITHTON FD");

    doTest("T2",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 159 south of stonegate  \n" +
        "Creation Time: 06/01/2013 16:59:25  \n" +
        "Agency: SMITHTON FD ",

        "CALL:FIRE",
        "ADDR:159 south of stonegate",
        "MADDR:159 & stonegate",
        "DATE:06/01/2013",
        "TIME:16:59:25",
        "SRC:SMITHTON FD");

    doTest("T3",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: MEDICAL - FIRST RESPONDERS Location: 711 N MAIN ST, SMITHTON, 62285  (; Near:SMITHTON FIRE DEPT.)  \n" +
        "Creation Time: 05/31/2013 12:38:44  \n" +
        "Agency: SMITHTON FD ",

        "CALL:MEDICAL - FIRST RESPONDERS",
        "ADDR:711 N MAIN ST",
        "CITY:SMITHTON",
        "X:; Near:SMITHTON FIRE DEPT.",
        "DATE:05/31/2013",
        "TIME:12:38:44",
        "SRC:SMITHTON FD");

    doTest("T4",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 101 S VINE ST, FREEBURG, 62243  (E WASHINGTON ST/E HIGH ST) \n" +
        "Creation Time: 05/30/2013 17:17:08  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE",
        "ADDR:101 S VINE ST",
        "CITY:FREEBURG",
        "X:E WASHINGTON ST/E HIGH ST",
        "DATE:05/30/2013",
        "TIME:17:17:08",
        "SRC:FREEBURG FD");

    doTest("T5",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: MEDICAL - FIRST RESPONDERS Location: 304 EUGENIA ST, SMITHTON, 62285 \n" +
        "Creation Time: 05/30/2013 10:19:32  \n" +
        "Agency: SMITHTON FD ",

        "CALL:MEDICAL - FIRST RESPONDERS",
        "ADDR:304 EUGENIA ST",
        "CITY:SMITHTON",
        "DATE:05/30/2013",
        "TIME:10:19:32",
        "SRC:SMITHTON FD");

    doTest("T6",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE BRUSH Location: OLD FREEBURG RD/S GREEN MOUNT RD, BELLEVILLE  \n" +
        "Creation Time: 05/29/2013 21:43:50  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE BRUSH",
        "ADDR:OLD FREEBURG RD & S GREEN MOUNT RD",
        "CITY:BELLEVILLE",
        "DATE:05/29/2013",
        "TIME:21:43:50",
        "SRC:FREEBURG FD");

    doTest("T7",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: MEDICAL - FIRST RESPONDERS Location: 6470 ROBINSON SCHOOL RD, NEW ATHENS, 62264  (BLACKSMITH SHOP RD/) \n" +
        "Creation Time: 05/29/2013 20:55:26  \n" +
        "Agency: SMITHTON FD ",

        "CALL:MEDICAL - FIRST RESPONDERS",
        "ADDR:6470 ROBINSON SCHOOL RD",
        "CITY:NEW ATHENS",
        "X:BLACKSMITH SHOP RD/",
        "DATE:05/29/2013",
        "TIME:20:55:26",
        "SRC:SMITHTON FD");

    doTest("T8",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE HAZMAT  Location: E STATE RT 15, BELLEVILLE/PEABODY RD, FREEBURG  \n" +
        "Creation Time: 05/24/2013 15:57:38  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE HAZMAT",
        "ADDR:E STATE RT 15, BELLEVILLE & PEABODY RD",
        "MADDR:E STATE 15, BELLEVILLE & PEABODY RD",
        "CITY:FREEBURG",
        "DATE:05/24/2013",
        "TIME:15:57:38",
        "SRC:FREEBURG FD");

    doTest("T9",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: ACCIDENT W/INJURY  Location: STATE RT 159/DOUGLAS RD, SMITHTON \n" +
        "Creation Time: 05/17/2013 21:10:15  \n" +
        "Agency: SMITHTON FD ",

        "CALL:ACCIDENT W/INJURY",
        "ADDR:STATE RT 159 & DOUGLAS RD",
        "MADDR:STATE 159 & DOUGLAS RD",
        "CITY:SMITHTON",
        "DATE:05/17/2013",
        "TIME:21:10:15",
        "SRC:SMITHTON FD");

    doTest("T10",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: ACCIDENT W/ENTRAPMENT  Location: 3000 S ILLINOIS ST, BELLEVILLE, 62220 \n" +
        "Creation Time: 05/15/2013 23:43:39  \n" +
        "Agency: SMITHTON FD ",

        "CALL:ACCIDENT W/ENTRAPMENT",
        "ADDR:3000 S ILLINOIS ST",
        "CITY:BELLEVILLE",
        "DATE:05/15/2013",
        "TIME:23:43:39",
        "SRC:SMITHTON FD");

    doTest("T11",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: ACCIDENT W/INJURY  Location: STATE RT 159, SMITHTON/FLECKENSTEIN RD, NEW ATHENS  \n" +
        "Creation Time: 05/12/2013 14:47:47  \n" +
        "Agency: SMITHTON FD ",

        "CALL:ACCIDENT W/INJURY",
        "ADDR:STATE RT 159, SMITHTON & FLECKENSTEIN RD",
        "MADDR:STATE 159, SMITHTON & FLECKENSTEIN RD",
        "CITY:NEW ATHENS",
        "DATE:05/12/2013",
        "TIME:14:47:47",
        "SRC:SMITHTON FD");

    doTest("T12",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE ALARM Location: 3001 SAVE RD, BELLEVILLE, 62221  (LEE HOPP DR/UNNAMED RD) \n" +
        "Creation Time: 05/07/2013 09:55:47  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE ALARM",
        "ADDR:3001 SAVE RD",
        "CITY:BELLEVILLE",
        "X:LEE HOPP DR/UNNAMED RD",
        "DATE:05/07/2013",
        "TIME:09:55:47",
        "SRC:FREEBURG FD");

    doTest("T13",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE BRUSH Location: 2652 OLD FREEBURG RD, BELLEVILLE, 62220 \n" +
        "Creation Time: 05/06/2013 20:18:34  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE BRUSH",
        "ADDR:2652 OLD FREEBURG RD",
        "CITY:BELLEVILLE",
        "DATE:05/06/2013",
        "TIME:20:18:34",
        "SRC:FREEBURG FD");

    doTest("T14",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: ACCIDENT W/INJURY  Location: DOUGLAS RD, SMITHTON/STATE RT 159, FREEBURG \n" +
        "Creation Time: 05/02/2013 17:10:24  \n" +
        "Agency: SMITHTON FD ",

        "CALL:ACCIDENT W/INJURY",
        "ADDR:DOUGLAS RD, SMITHTON & STATE RT 159",
        "MADDR:DOUGLAS RD, SMITHTON & STATE 159",
        "CITY:FREEBURG",
        "DATE:05/02/2013",
        "TIME:17:10:24",
        "SRC:SMITHTON FD");

    doTest("T15",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE ALARM Location: 746 URBANNA DR, FREEBURG, 62243 \n" +
        "Creation Time: 05/02/2013 11:00:24  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE ALARM",
        "ADDR:746 URBANNA DR",
        "CITY:FREEBURG",
        "DATE:05/02/2013",
        "TIME:11:00:24",
        "SRC:FREEBURG FD");

    doTest("T16",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: MEDICAL - FIRST RESPONDERS Location: STATE RT 159/DOUGLAS RD, FREEBURG \n" +
        "Creation Time: 04/30/2013 05:30:28  \n" +
        "Agency: SMITHTON FD ",

        "CALL:MEDICAL - FIRST RESPONDERS",
        "ADDR:STATE RT 159 & DOUGLAS RD",
        "MADDR:STATE 159 & DOUGLAS RD",
        "CITY:FREEBURG",
        "DATE:04/30/2013",
        "TIME:05:30:28",
        "SRC:SMITHTON FD");

    doTest("T17",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: E WASHINGTON ST/S STATE ST, FREEBURG  \n" +
        "Creation Time: 04/26/2013 19:35:26  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE",
        "ADDR:E WASHINGTON ST & S STATE ST",
        "CITY:FREEBURG",
        "DATE:04/26/2013",
        "TIME:19:35:26",
        "SRC:FREEBURG FD");

    doTest("T18",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 3401 LUNCH RD, BELLEVILLE, 62220  \n" +
        "Creation Time: 04/26/2013 13:16:22  \n" +
        "Agency: SMITHTON FD ",

        "CALL:FIRE",
        "ADDR:3401 LUNCH RD",
        "CITY:BELLEVILLE",
        "DATE:04/26/2013",
        "TIME:13:16:22",
        "SRC:SMITHTON FD");

  }
  
  @Test
  public void testFreeburgFire() {
    doTest("T1",
        "(Notification) ï»¿Fire Run\n\n" +
        "Response Type: FIRE Location: N STATE ST/W ST CLAIR ST, FREEBURG  \n" +
        "Creation Time: 04/24/2013 08:12:32  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE",
        "ADDR:N STATE ST & W ST CLAIR ST",
        "CITY:FREEBURG",
        "DATE:04/24/2013",
        "TIME:08:12:32",
        "SRC:FREEBURG FD");

    doTest("T2",
        "(Notification) ï»¿Fire Run\n\n" +
        "Response Type: MEDICAL - FIRST RESPONDERS Location: S ILLINOIS ST/SCHLUETER-GERMAINE RD (SCHLUETER GERMAINE RD), BELLEVILLE \n" +
        "Creation Time: 04/22/2013 15:26:32  \n" +
        "Agency: SMITHTON FD ",

        "CALL:MEDICAL - FIRST RESPONDERS",
        "ADDR:S ILLINOIS ST & SCHLUETER-GERMAINE RD (SCHLUETER GERMAINE RD)",
        "MADDR:S ILLINOIS ST & SCHLUETER-GERMAINE RD",
        "CITY:BELLEVILLE",
        "DATE:04/22/2013",
        "TIME:15:26:32",
        "SRC:SMITHTON FD");

    doTest("T3",
        "(Notification) ï»¿Fire Run\n\n" +
        "Response Type: FIRE EMS Location: 214 N MAIN ST, FREEBURG, 62243  (/W PHILLIPS ST)  \n" +
        "Creation Time: 04/20/2013 03:34:48  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE EMS",
        "ADDR:214 N MAIN ST",
        "CITY:FREEBURG",
        "X:W PHILLIPS ST",
        "DATE:04/20/2013",
        "TIME:03:34:48",
        "SRC:FREEBURG FD");

    doTest("T4",
        "(Notification) ï»¿Fire Run\n\n" +
        "Response Type: ACCIDENT W/INJURY  Location: 4200 STATE RT 15, FREEBURG, 62243  (/ROSS DR) \n" +
        "Creation Time: 04/18/2013 14:26:51  \n" +
        "Agency: FREEBURG FD ",

        "CALL:ACCIDENT W/INJURY",
        "ADDR:4200 STATE RT 15",
        "MADDR:4200 STATE 15",
        "CITY:FREEBURG",
        "X:ROSS DR",
        "DATE:04/18/2013",
        "TIME:14:26:51",
        "SRC:FREEBURG FD");

    doTest("T5",
        "(Notification) ï»¿Fire Run\n\n" +
        "Response Type: FIRE WATER RESCUE/RECOVERY Location: PEABODY RD/WHITE OAKS CLUB RD, FREEBURG \n" +
        "Creation Time: 04/18/2013 12:45:22  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE WATER RESCUE/RECOVERY",
        "ADDR:PEABODY RD & WHITE OAKS CLUB RD",
        "CITY:FREEBURG",
        "DATE:04/18/2013",
        "TIME:12:45:22",
        "SRC:FREEBURG FD");

    doTest("T6",
        "(Notification) ï»¿Fire Run\n\n" +
        "Response Type: FIRE Location: 17 DEERFIELD CT, FREEBURG, 62243  \n" +
        "Creation Time: 04/18/2013 01:28:26  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE",
        "ADDR:17 DEERFIELD CT",
        "CITY:FREEBURG",
        "DATE:04/18/2013",
        "TIME:01:28:26",
        "SRC:FREEBURG FD");

    doTest("T7",
        "(Notification) ï»¿Fire Run\n\n" +
        "Response Type: FIRE ALARM Location: 10 S ALTON ST, FREEBURG, 62243  (W HIGH ST/N ALTON ST, W WHITE ST; Near:LIGHTHOUSE LEARNING CENTER OF FREEBURG) \n" +
        "Creation Time: 04/09/2013 22:01:22  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE ALARM",
        "ADDR:10 S ALTON ST",
        "CITY:FREEBURG",
        "X:W HIGH ST/N ALTON ST, W WHITE ST; Near:LIGHTHOUSE LEARNING CENTER OF FREEBURG",
        "DATE:04/09/2013",
        "TIME:22:01:22",
        "SRC:FREEBURG FD");

    doTest("T8",
        "(Notification) ï»¿Fire Run\n\n" +
        "Response Type: FIRE BRUSH Location: 2014 CAMP JACKSON RD, CAHOKIA, 62206  (LYNN ST/LOUISE AVE)  \n" +
        "Creation Time: 04/08/2013 15:12:16  \n" +
        "Agency: FREEBURG FD ",

        "CALL:FIRE BRUSH",
        "ADDR:2014 CAMP JACKSON RD",
        "CITY:CAHOKIA",
        "X:LYNN ST/LOUISE AVE",
        "DATE:04/08/2013",
        "TIME:15:12:16",
        "SRC:FREEBURG FD");

    doTest("T9",
        "(Notification) ï»¿Fire Run\n\n" +
        "Response Type: ACCIDENT W/INJURY  Location: RENTCHLER RD/JEFFERSON RD, BELLEVILLE \n" +
        "Creation Time: 04/06/2013 07:53:38  \n" +
        "Agency: FREEBURG FD ",

        "CALL:ACCIDENT W/INJURY",
        "ADDR:RENTCHLER RD & JEFFERSON RD",
        "CITY:BELLEVILLE",
        "DATE:04/06/2013",
        "TIME:07:53:38",
        "SRC:FREEBURG FD");

    doTest("T10",
        "Fire Run\n\n" +
        "Response Type: FIRE    Location: 410 W HIGH ST, FREEBURG, 62243 (UNNAMED RD/S MAIN ST) \n" +
        "Creation Time: 04/01/2013 17:22:05 \n" +
        "Agency: FREEBURG FDï¿½ï¿½ï¿½ ",

        "CALL:FIRE",
        "ADDR:410 W HIGH ST",
        "CITY:FREEBURG",
        "X:UNNAMED RD/S MAIN ST",
        "DATE:04/01/2013",
        "TIME:17:22:05",
        "SRC:FREEBURG FD");
  }
  
  @Test
  public void testBelevilleFireDepartment() {

    doTest("T1",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE ALARM Location: 300 ALLSUP PL, BELLEVILLE, 62223  (W STATE RT 15/TOWN HALL RD)  \n" +
        "Creation Time: 07/15/2013 08:17:56  \n" +
        "Agency: BELLEVILLE FD ",

        "CALL:FIRE ALARM",
        "ADDR:300 ALLSUP PL",
        "CITY:BELLEVILLE",
        "X:W STATE RT 15/TOWN HALL RD",
        "DATE:07/15/2013",
        "TIME:08:17:56",
        "SRC:BELLEVILLE FD");

    doTest("T2",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: @Central Jr. High School  (1801 CENTRAL SCHOOL RD)  \n" +
        "Creation Time: 07/15/2013 05:36:19  \n" +
        "Agency: BELLEVILLE FD ",

        "CALL:FIRE",
        "PLACE:Central Jr High School",
        "ADDR:1801 CENTRAL SCHOOL RD",
        "DATE:07/15/2013",
        "TIME:05:36:19",
        "SRC:BELLEVILLE FD");

    doTest("T3",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 15 PINECREST CIR, BELLEVILLE, 62223  (/EXPRESS DR)  \n" +
        "Creation Time: 07/15/2013 05:02:36  \n" +
        "Agency: BELLEVILLE FD ",

        "CALL:FIRE",
        "ADDR:15 PINECREST CIR",
        "CITY:BELLEVILLE",
        "X:EXPRESS DR",
        "DATE:07/15/2013",
        "TIME:05:02:36",
        "SRC:BELLEVILLE FD");

    doTest("T4",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: @Roosevelt School  (700 WEST CLEVELAND) \n" +
        "Creation Time: 07/15/2013 00:53:57  \n" +
        "Agency: BELLEVILLE FD ",

        "CALL:FIRE",
        "PLACE:Roosevelt School",
        "ADDR:700 WEST CLEVELAND",
        "DATE:07/15/2013",
        "TIME:00:53:57",
        "SRC:BELLEVILLE FD");

    doTest("T5",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: ACCIDENT W/LANE BLOCKAGE Location: 7200 OLD ST LOUIS RD, BELLEVILLE, 62223  (UNNAMED RD/HILLSIDE LN) #BLK  \n" +
        "Creation Time: 07/14/2013 18:54:22  \n" +
        "Agency: BELLEVILLE FD ",

        "CALL:ACCIDENT W/LANE BLOCKAGE",
        "ADDR:7200 OLD ST LOUIS RD",
        "CITY:BELLEVILLE",
        "X:UNNAMED RD/HILLSIDE LN#BLK",
        "DATE:07/14/2013",
        "TIME:18:54:22",
        "SRC:BELLEVILLE FD");

    doTest("T6",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 1315 E A ST, BELLEVILLE, 62221  (N MICHIGAN AVE/N FLORIDA AVE)  \n" +
        "Creation Time: 07/14/2013 08:19:31  \n" +
        "Agency: BELLEVILLE FD ",

        "CALL:FIRE",
        "ADDR:1315 E A ST",
        "CITY:BELLEVILLE",
        "X:N MICHIGAN AVE/N FLORIDA AVE",
        "DATE:07/14/2013",
        "TIME:08:19:31",
        "SRC:BELLEVILLE FD");

    doTest("T7",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE ALARM Location: @ST ELIZABETHS HOSPITAL  (211 S 3RD ST) \n" +
        "Creation Time: 07/14/2013 04:38:36  \n" +
        "Agency: BELLEVILLE FD ",

        "CALL:FIRE ALARM",
        "PLACE:ST ELIZABETHS HOSPITAL",
        "ADDR:211 S 3RD ST",
        "DATE:07/14/2013",
        "TIME:04:38:36",
        "SRC:BELLEVILLE FD");

    doTest("T8",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 238 FREEDOM DR, BELLEVILLE, 62226   #B  \n" +
        "Creation Time: 07/13/2013 21:02:59  \n" +
        "Agency: BELLEVILLE FD ",

        "CALL:FIRE",
        "ADDR:238 FREEDOM DR",
        "CITY:BELLEVILLE",
        "DATE:07/13/2013",
        "TIME:21:02:59",
        "SRC:BELLEVILLE FD");

    doTest("T9",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: FIRE Location: 1050 WEST BLVD, BELLEVILLE, 62221  (REDWOOD DR/MALLARD DR, OLD COLLINSVILLE RD) \n" +
        "Creation Time: 07/13/2013 16:21:45  \n" +
        "Agency: BELLEVILLE FD ",

        "CALL:FIRE",
        "ADDR:1050 WEST BLVD",
        "CITY:BELLEVILLE",
        "X:REDWOOD DR/MALLARD DR, OLD COLLINSVILLE RD",
        "DATE:07/13/2013",
        "TIME:16:21:45",
        "SRC:BELLEVILLE FD");

    doTest("T10",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: ACCIDENT W/INJURY  Location: 2100 W MAIN ST , BELLEVILLE \n" +
        "Creation Time: 07/13/2013 12:38:53  \n" +
        "Agency: BELLEVILLE FD ",

        "CALL:ACCIDENT W/INJURY",
        "ADDR:2100 W MAIN ST",
        "CITY:BELLEVILLE",
        "DATE:07/13/2013",
        "TIME:12:38:53",
        "SRC:BELLEVILLE FD");

    doTest("T10X",
        "(Notification) ﻿Fire Run\n\n" +
        "Response Type: ACCIDENT W/INJURY\tLocation: 2100 W MAIN ST , BELLEVILLE \n" +
        "Creation Time: 07/13/2013 12:38:53  \n" +
        "Agency: BELLEVILLE FD ",

        "CALL:ACCIDENT W/INJURY",
        "ADDR:2100 W MAIN ST",
        "CITY:BELLEVILLE",
        "DATE:07/13/2013",
        "TIME:12:38:53",
        "SRC:BELLEVILLE FD");

  }
  
  public static void main(String[] args) {
    new ILStClairCountyParserTest().generateTests("T1");
  }
}