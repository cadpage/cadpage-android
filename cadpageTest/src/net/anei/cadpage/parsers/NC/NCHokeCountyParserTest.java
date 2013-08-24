package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Hoke County, NC

Contact: Active911
Agency name: Hoke Rescue
Location: Hoke, NC, United States
Sender: Hoke Co 911@hokecounty.org

Hoke Co 911:3000 TURNPIKE RD* * * * LESLIE DR* **L MCLAUGHLIN RD* 67K* * AC/OT/PI* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:568 L A SANDY RD* * * * 3641 ARABIA RD* **DEAD END* 74B* * 21 HEMM/LAC* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:2909 HWY 401 BUSINESS* * * * 813 SCURLOCK SCHOOL RD* **HAZEL LN* 68J* * AC/PI* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:100 N SHANNON RD* * * * 3401 RED SPRINGS RD* **2799 HAIRE RD* 73N* * AC/PI* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:7619 ROCKFISH RD* * * * 7699 PHILLIPI CHURCH RD* **WALTER DR* 71F* * AC/PI* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:322 S HORACE WALTERS RD* * * * 9062 TURNPIKE RD* **DEAD END* 61U* * FIREHOUSE* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:250 GOOSE POND RD* * * * 6780 RED SPRINGS RD* **GRANNY LN* 73X* * AC/PI* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:5073 ROCKFISH RD* * * * PITTMAN GROVE CHURCH RD* **GALATIA CHURCH RD* 70G* * AC/PI* * * * * * Line16=* Line17=* Line18=01/31/2013 07:45:08 : pos2 : RCRUMPLER3351 Cross streets: PITTMAN GROVE CHURCH RD//GALATIA CHURCH RD Landmark
Hoke Co 911:520 E CENTRAL AVE* * * * MCDUFFIE ST* **HOUSE OF RAEFORD PLANT DR* 68Q* * STABBING* * * * * * Line16=* Line17=* Line18=01/29/2013 22:41:36 : pos1 : LGRADY7274 Cross streets: MCDUFFIE ST//HOUSE OF RAEFORD PLANT DR*
Hoke Co 911:PHILLIPI CHURCH RD* * * * 1232 ROCKFISH RD* **HUCKABEE ST* 69K* * AC/PD* * * * * * Line16=* Line17=* Line18=01/29/2013 16:42:44 : pos2 : TGESSLER0782 Cross streets: 1232 ROCKFISH RD//HUCKABEE ST NBH: SCURLOCK*
Hoke Co 911:100 HOBSON CT* * * * 1151 HOBSON RD* **DEAD END* 64D* * AC/PI* * * * * * Line16=* Line17=* Line18=01/29/2013 16:01:53 : pos4 : DMELTON1918 HOBSON CT//1151 HOBSON RD NBH: HOBSON PLACE S/D Landmark: READY MIX CONCRETE Cross street
Hoke Co 911:9615 FAYETTEVILLE RD* * * * FOREST WOODS RD* **WAYSIDE RD* 65H* * AC/PI* * * * * * Line16=* Line17=* Line18=01/29/2013 14:20:00 : pos3 : TGESSLER0782 Cross streets: FOREST WOODS RD//WAYSIDE RD Landmark: BP 104 1 FEMALE AND CHILD
Hoke Co 911:399 FAIRFIELD CIR* * * * 100 THORNCLIFF DR* *** 65R* * AC/PI* * * * * * Line16=* Line17=* Line18=01/29/2013 13:12:22 : pos3 : TGESSLER0782 Cross streets: 100 THORNCLIFF DR// Geo Comment: CIRCLES BACK ONTO ITSELF AT THORNCLIFF DR
Hoke Co 911:117 YADKIN TRL* * * * 500 WOOLEY ST* **WOOLEY ST* 67T* * 26 SICK PERS* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:104 MIDWAY DR* * * * FAYETTEVILLE RD* **COOL BREEZE DR* 65F* * AC/PI* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:1401 DARBY DR* * * * 111 CLAN CAMPBELL DR* **O'BANNON DR* 65A* * EMD* * * * * * Line16=* Line17=* Line18=01/27/2013 17:13:21 : pos4 : LHOWELL1154 ** EMD Key Questions Finished ** Key Questions: * 1.The cardiac arrest was not wit
Hoke Co 911:2474 JOHN RD* * * * COOK RD* **2551 BALFOUR RD* 80A* * AC/PI* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:3250 BALFOUR RD* * * * 600 ALBERT CURRIE RD* **5100 N SHANNON RD* 80B* * EMD* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:180 RAINDROP LOOP* * * * 624 ALEX BAKER RD* **676 ALEX BAKER RD* 67D* * AC/PI* * * * * * Line16=* Line17=* Line18=01/26/2013 06:22:01 : pos2 : RMUNGUIA5433 Cross streets: 624 ALEX BAKER RD//676 ALEX BAKER RD NBH: QUEENMORE Cross
Hoke Co 911:7097 WALTER GIBSON RD* * * * 699 CENTER GROVE CHURCH RD* **200 S OLD WIRE RD* 73W* * AC/PI* * * * * * Line16=* Line17=* Line18=01/25/2013 22:07:55 : pos2 : RMUNGUIA5433 Cross streets: 699 CENTER GROVE CHURCH RD//200 S OLD WIRE R
Hoke Co 911:1860 HWY 401 BUSINESS* * * * AZALEA ST* **BROAD DR* 68M* * AC/PI* * * * * * Line16=* Line17=* Line18=01/25/2013 20:14:01 : pos1 : SGRAHAM9861 Cross streets: AZALEA ST//BROAD DR Landmark: MANNING MINI STORAGE NBH: HILLCREST*
Hoke Co 911:5000 RED SPRINGS RD* * * * ANDREWS RD* **HAWKEYE DR* 73S* * AC/PI* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:3697 RED SPRINGS RD* * * * N SHANNON RD* **APPLEWOOD LN* 73I* * AC/PI* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:200 RANIER DR* * * * 338 FAIRFIELD CIR* *** 65R* * FIREELEC* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:7369 ROCKFISH RD* * * * EULON LOOP* **SCHOOL ST* 70J* * AC/PI* * * * * * Line16=* Line17=* Line18=01/24/2013 13:47:09 : pos4 : DMELTON1918 Cross streets: EULON LOOP//SCHOOL ST Landmark: DOLLAR GENERAL NBH: ROCKFISH*
Hoke Co 911:400 NEW LN* * * * 1746 HAIRE RD* *** 73I* * FIREHOUSE* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:709 E PALMER ST* * * * LAURINBURG RD* **742 S MAIN ST* 67Y* * TEST* * * * * * Line16=* Line17=* Line18=01/23/2013 19:38:25 : pos4 : TMCKNIGHT7534 Landmark: NEW COMMUNICATIONS CENTER Cross streets: LAURINBURG RD//742 S MAIN ST Ge
Hoke Co 911:15598 HWY 15-501* * * * 100 GRAY RUN LN* **5300 ASHEMONT RD* 56U* * AC/PI* * * * RESC* * Line16=* Line17=* Line18=01/23/2013 15:35:15 : pos1 : hjacobsen8281 Cross streets: 100 GRAY RUN LN//5300 ASHEMONT RD Landmark: FIVE STAR FO
Hoke Co 911:900 WALLACE MCLEAN RD* * * * LAURINBURG RD* **LEMONT DR* 67S* * AC/PI* * * * M2,RESC* * Line16=* Line17=* Line18=01/22/2013 08:59:46 : pos1 : rfairbanks1339 Cross streets: LAURINBURG RD//LEMONT DR BACK INJURY*
Hoke Co 911:439 GREENTREE DR* * * * 473 FOREST WOODS DR* **SCARLET OAK DR* 65M* * FIREHOUSE* * * * FD3,RESC* * Line16=* Line17=* Line18=01/21/2013 18:37:32 : pos1 : rfairbanks1339 Cross streets: 473 FOREST WOODS DR//SCARLET OAK DR NBH: FORE
Hoke Co 911:198 PINEY GROVE MHP* * * * 415 HAMILTON DR* *** 67H* * 06 BREATH PR* * * * M2,RESC* * Line16=* Line17=* Line18=01/20/2013 21:50:28 : pos2 : SCOOPER9403 ** EMD Case Complete ** Key Questions: 67 year old, Female, Conscious, Breat
Hoke Co 911:100 ALBERT CURRIE RD* * * * 5500 N SHANNON RD* **2910 BALFOUR RD* 80B* * AC/PI* * * * FD8,M1,RESC* * Line16=* Line17=* Line18=01/20/2013 02:45:22 : pos4 : DMELTON1918 ALBERT CURRIE RD//5500 N SHANNON RD*
Hoke Co 911:446 DAVIS BRIDGE RD* * * * 8999 ARABIA RD* **ROBESON CO LINE* 75G* * AC/PI* * * * FD2,M4,RESC* * Line16=* Line17=* Line18=01/20/2013 00:11:59 : pos4 : DMELTON1918 Cross streets: 8999 ARABIA RD//ROBESON CO LINE NBH: DAVIS BRIDGE*
Hoke Co 911:100 WAYSIDE RD* * * * FAYETTEVILLE RD* **OLD OAK RD* 65H* * AC/PI* * * * FD3,RESC* * Line16=* Line17=* Line18=01/19/2013 15:35:12 : pos1 : hjacobsen8281 Cross streets: FAYETTEVILLE RD//OLD OAK RD*
Hoke Co 911:100 CLUB POND RD* * * * 311 PHILLIPI CHURCH RD* **1470 ROCKFISH RD* 69K* * AC/PI* * * * FD1,RESC* * Line16=* Line17=* Line18=01/19/2013 13:17:41 : pos4 : DMELTON1918 Cross streets: 311 PHILLIPI CHURCH RD//1470 ROCKFISH RD NBH: S
Hoke Co 911:1392 RESERVATION RD* * * * CALLOWAY RD* **QUEWIFFLE RD* 56J* * AC/PI* * * * FD7,RESC* * Line16=* Line17=* Line18=01/18/2013 19:28:26 : pos1 : LGRADY7274 RESERVATION RD//CALLOWAY RD Geo Comment: RESCUE 2 AREA NBH: QUEWHIFFLE TWO 
Hoke Co 911:4002 FAYETTEVILLE RD* * * * TENNESSEE WALKER DR* **RILEY ST* 63Y* * AC/PI* * * * RESC* * Line16=* Line17=* Line18=01/18/2013 19:19:15 : pos4 : DMELTON1918 Cross streets: TENNESSEE WALKER DR//RILEY ST Landmark: RED DOOR HOMES*
Hoke Co 911:195 RANDLEMAN DR* * * * 251 WINDOVER DR* **511 WINDOVER DR* 65R* * EMD* * * * M3,RESC* * Line16=* Line17=* Line18=01/17/2013 22:51:35 : pos4 : CROWLAND4749 ** EMD Key Questions Finished ** Key Questions: 15 year old, Female, Unc
Hoke Co 911:10399 FAYETTEVILLE RD* * * * * **AC/PI* * * * * * * * 01/15/2013 18:50:23 : pos4 : DMELTON1918 Cross streets: PLAZA DR//CUMBERLAND COUNTY LINE Landmark: COUNTY LINE - CUMBERLAND COUNTY*
Hoke Co 911:2214 HWY 401 BUSINESS* * * * * **AC/PI* * * * * * * * 01/14/2013 22:43:14 : pos1 : LGRADY7274 HWY 401 BUSINESS//ROCKFISH RD NBH: HILLCREST Cross streets: E PROSPECT AVE//CRUMPLER DR NBH: HILLCREST 35YOM MOTORCYCLE ONE*
Hoke Co 911:803 EDINBURGH RD* * * * * **EMD* * * * * * * * 01/12/2013 20:35:21 : pos4 : CROWLAND4749 ** EMD Case Complete ** Key Questions: 22 year old, Female, Conscious, Breathing. 01/12/2013 20:34:51 : pos4 : CROWLAND4749 ** EMD Recommen

Contact: Active911
Agency name: Rockfish Fire Department
Location: Raeford, NC, United States

Hoke Co 911:6207 PITTMAN GROVE CHURCH RD* * * * 1341 TC JONES RD* **SPANGLER DR* 74E* * EMD* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:300 ROLLING PINES CT* * * * 137 WINDY PINES CT* **100 CRABAPPLE LN* 71K* * 24B01* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:174 E TWELVE OAKS RD* * * * TWELVE OAKS RD* *** 75C* * ILLEGALBURN* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:4767 PHILLIPI CHURCH RD* * * * GOLF COURSE RD* **PITTMAN GROVE CHURCH RD* 70V* * 26C02* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:7619 ROCKFISH RD* * * * 7699 PHILLIPI CHURCH RD* **WALTER DR* 71F* * AC/PI* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:7525 ARABIA RD* * * * SUNSET LAKE RD* **MISSIONVILLE RD* 74E* * EMD* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:632 SUNSET LAKE RD* * * * 7100 ARABIA RD* **DEAD END* 74E* * 26A01* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:186 STARLITE DR* * * * 6729 PITTMAN GROVE CHURCH* **258 RENEES LN* 75A* * EMD* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:5073 ROCKFISH RD* * * * PITTMAN GROVE CHURCH RD* **GALATIA CHURCH RD* 70G* * AC/PI* * * * * * Line16=* Line17=* Line18=01/31/2013 07:45:08 : pos2 : RCRUMPLER3351 Cross streets: PITTMAN GROVE CHURCH RD//GALATIA CHURCH RD Landmark
Hoke Co 911:441 CAMDEN RD* * * * STONEWALL ST* **REGENCY DR* 75B* * 5A01* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:1122 DAVIS BRIDGE RD* * * * 8999 ARABIA RD* **ROBESON CO LINE* 75G* * FIREOTHER* * * * * * Line16=* Line17=* Line18=01/30/2013 21:05:14 : pos2 : RMUNGUIA5433 Cross streets: 8999 ARABIA RD//ROBESON CO LINE NBH: DAVIS BRIDGE INREF
Hoke Co 911:2420 GALATIA CHURCH RD* * * * LINDSAY RD* **RIDGE MANOR DR* 65Y* * EMD* * * * * * Line16=* Line17=* Line18=01/30/2013 18:21:59 : pos2 : RCRUMPLER3351 ** EMD Case Entry Finished ** Chief Complaint Number: 10 Key Questions: 20-yea
Hoke Co 911:248 MUMFORD RD* * * * 6933 PITTMAN GROVE CH RD* **WILDLIFE LN* 75A* * EMD* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:170 TRIPLE CROWN DR* * * * 255 STEEPLE RUN DR* *** 71A* * EMD* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:385 SUNSET LAKE RD* * * * 7100 ARABIA RD* **DEAD END* 74E* * EMD* * * * * * Line16=* Line17=* Line18=01/29/2013 18:45:17 : pos1 : hjacobsen8281 Cross streets: 7100 ARABIA RD//DEAD END*
Hoke Co 911:157 EULON LOOP* * * * 7115 ROCKFISH RD* *** 70J* * EMD* * * * * * Line16=* Line17=* Line18=01/27/2013 20:45:39 : pos1 : SGRAHAM9861 Cross streets: 7115 ROCKFISH RD// NBH: DAVIS ESTATES*
Hoke Co 911:125 FRANKLIN DR* * * * 122 BOSTIC RD* **SHADOWOOD DR* 70O* * EMD* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:6727 IRONGATE DR* B* * * * *** * * FIRESTRUCT* * * * * * Line16=* Line17=* Line18=01/27/2013 10:06:54 : pos1 : rfairbanks1339 SURRY RD / GATES 4 SD , 23 , CUMB 6A 69D5*
Hoke Co 911:630 DOGWOOD LN* * * * 299 HICKORY DR* *** 70V* * FIREALARM* * * * * * Line16=* Line17=* Line18=01/26/2013 20:23:05 : pos2 : RMUNGUIA5433 Cross streets: 299 HICKORY DR// A/A HALL WAY SMOKE DET NKH HOI: LORENCE MONROE 910 875 6446
Hoke Co 911:365 EVERITT RD* * * * HILLCREEK DR* **CREEK FARM DR* 75G* * EMD* * * * * * Line16=* Line17=* Line18=01/26/2013 20:15:36 : pos1 : SGRAHAM9861 Cross streets: HILLCREEK DR//CREEK FARM DR*
Hoke Co 911:189 BETTY`S TRL* * * * 580 EVERITT RD* **DEAD END* 75L* * EMD* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:9701 ROCKFISH RD* * * * MALLERNEE LN* **OVERTON RD* 71V* * EMD* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:200 RANIER DR* * * * 338 FAIRFIELD CIR* *** 65R* * FIREELEC* * * * * * Line16=* Line17=* Line18=01/24/2013 20:23:57 : pos2 : SCOOPER9403 Cross streets: 338 FAIRFIELD CIR// NBH: WESTGATE S/D CAN SMELL ELECTRICAL BURNING*
Hoke Co 911:7369 ROCKFISH RD* * * * EULON LOOP* **SCHOOL ST* 70J* * AC/PI* * * * * * Line16=* Line17=* Line18=01/24/2013 13:47:09 : pos4 : DMELTON1918 Cross streets: EULON LOOP//SCHOOL ST Landmark: DOLLAR GENERAL NBH: ROCKFISH*
Hoke Co 911:189 BETTY`S TRL* * * * 580 EVERITT RD* **DEAD END* 75L* * EMD* * * * FD20,M2* * Line16=* Line17=* Line18=01/22/2013 01:57:27 : pos2 : RMUNGUIA5433 ** EMD Recommended Dispatch ** Response Text: Delta Dispatch Level: 12D02 Suffix:
Hoke Co 911:439 GREENTREE DR* * * * 473 FOREST WOODS DR* **SCARLET OAK DR* 65M* * FIREHOUSE* * * * FD1,FD2,FD3,M4,RESC* * Line16=* Line17=* Line18=01/21/2013 18:37:32 : pos1 : rfairbanks1339 Cross streets: 473 FOREST WOODS DR//SCARLET OAK D
Hoke Co 911:CAMP ROCKFISH RD* * * * 153 DAVIS BRIDGE RD* **DEAD END* 75G* * 06 BREATH PR* * * * FD20* * Line16=* Line17=* Line18=01/21/2013 14:11:30 : pos4 : CROWLAND4749 FD20 ADV CANCEL, UNABLE TO LOCATE ANYTHING 01/21/2013 14:10:35 : pos1
Hoke Co 911:270 JODY LN* * * * 1499 MYRA RD* **DEAD END* 71U* * EMD* * * * FD20,M2* * Line16=* Line17=* Line18=01/21/2013 09:26:12 : pos2 : RCRUMPLER3351 ** EMD Case Entry Finished ** Chief Complaint Number: 21 Key Questions: 67 year old, M
Hoke Co 911:4520 PITTMAN GROVE CHURCH RD* * * * NANDAKAR TRL* **4769 PHILLIPI CHURCH RD* 70Q* * EMD* * * * FD20,M3* * Line16=* Line17=* Line18=01/20/2013 16:49:33 : pos4 : DMELTON1918 Cross streets: NANDAKAR TRL//4769 PHILLIPI CHURCH RD*
Hoke Co 911:446 DAVIS BRIDGE RD* * * * 8999 ARABIA RD* **ROBESON CO LINE* 75G* * AC/PI* * * * 11,52,94,FD20,FD22,M4,RES1,RESC* * Line16=* Line17=* Line18=01/20/2013 00:20:12 : pos1 : LGRADY7274 IN THE WOODLINE LIVE LINE DOWN 01/20/2013 00:1
Hoke Co 911:110 SAGE CREEK DR* * * * 1754 GALATIA CHURCH RD* *** 70D* * EMD* * * * FD20,M3* * Line16=* Line17=* Line18=01/20/2013 00:00:23 : pos4 : DMELTON1918 ** EMD Case Complete ** Key Questions: 9 year old, Male, Unconscious, Breathing.
Hoke Co 911:345 BERWICK DR* * * * YORK CT* **SHEFFIELD CT* 65X* * EMD* * * * FD20* * Line16=* Line17=* Line18=01/19/2013 22:17:19 : pos4 : DMELTON1918 Cross streets: YORK CT//SHEFFIELD CT NBH: RIDGE MANOR S/D*
Hoke Co 911:102 BELTONS LOOP* * * * 6669 PITTMAN GROVE CHURCH* *** 75A* * EMD* * * * FD20,M2* * Line16=* Line17=* Line18=01/19/2013 13:35:33 : pos4 : DMELTON1918 ** EMD Case Complete ** Key Questions: 40 year old, Female, Unconscious, Breat
Hoke Co 911:561 MUMFORD RD* B* * * WILDLIFE LN* **BEARD RD* 75A* * EMD* * * * FD20,M3* * Line16=* Line17=* Line18=01/19/2013 09:09:54 : pos1 : RMUNGUIA5433 Cross streets: WILDLIFE LN//BEARD RD*
Hoke Co 911:205 BONNEY LN* * * * 585 CORSEGAN RD* **DEAD END* 71L* * DOMESTIC INP* * * * 33,FD20,M3,S16* * Line16=* Line17=* Line18=01/19/2013 02:50:35 : pos1 : LGRADY7274 25YOF INJURY TO SIDE AND SHOULDER ROAD RASH ROUTINE 01/19/2013 02:40
Hoke Co 911:520 CAMDEN RD* * * * STONEWALL ST* **REGENCY DR* 75B* * EMD* * * * FD20,M2* * Line16=* Line17=* Line18=01/17/2013 21:53:21 : pos2 : RMUNGUIA5433 Cross streets: STONEWALL ST//REGENCY DR NBH: ROCKFISH*
Hoke Co 911:118 ZANE DR* * * * 113 SOUTHERN OAKS DR* **DEAD END* 70O* * EMD* * * * * * Line16=* Line17=* Line18=01/16/2013 18:16:02 : pos2 : RCRUMPLER3351 202 ONSCENE 01/16/2013 18:15:44 : pos2 : RCRUMPLER3351 ** EMD Case Complete ** Key Qu
Hoke Co 911:118 ZANE DR* * * * 113 SOUTHERN OAKS DR* **DEAD END* 70O* * EMD* * * * * * Line16=* Line17=* Line18=01/16/2013 18:15:44 : pos2 : RCRUMPLER3351 ** EMD Case Complete ** Key Questions: 30 year old, Female, Conscious, Breathing. 01/
Hoke Co 911:213 WELSH RD* * * * 663 TC JONES RD* **DEAD END* 70X* * 31 UNCON/FAI* * * * * * Line16=* Line17=* Line18=01/16/2013 16:47:45 : pos2 : RCRUMPLER3351 Cross streets: 663 TC JONES RD//DEAD END DIS 1505 ENR 1506 20 ONSCENE 1511 M1 ON
Hoke Co 911:194 HICKORY DR* * * * * **ASSAULT* * * * * * * * 01/16/2013 01:28:34 : pos1 : LGRADY7274 13 NEED EMS ROUTINE HEAD INJURY 01/16/2013 01:18:36 : pos1 : LGRADY7274 Cross streets: 4770 PITTMAN GROVE CHURCH//700 DOGWOOD LN 01/16/2013
Hoke Co 911:194 HICKORY DR* * * * * **17 FALLS* * * * * * * * 01/13/2013 21:10:58 : pos1 : SGRAHAM9861 ** EMD Case Complete ** Key Questions: 63 year old, Female, Conscious, Breathing. 01/13/2013 21:10:49 : pos4 : CROWLAND4749 FD202 01/13/2
Hoke Co 911:194 HICKORY DR* * * * * **EMD* * * * * * * * 01/13/2013 21:09:35 : pos1 : SGRAHAM9861 Cross streets: 4770 PITTMAN GROVE CHURCH//700 DOGWOOD LN*
Hoke Co 911:527 SUNSET LAKE RD* * * * * **EMD* * * * * * * * 01/12/2013 20:35:55 : pos2 : RMUNGUIA5433 ** EMD Recommended Dispatch ** Response Text: Delta Dispatch Level: 19D04 CAD Incident Code: 19D04 Key Questions: 1.She is completely ale
Hoke Co 911:572 TC JONES RD* * * * * **EMD* * * * * * * * 01/12/2013 14:46:00 : pos1 : rfairbanks1339 Cross streets: LEDEZMA DR//WELSH RD*
Hoke Co 911:385 SUNSET LAKE RD* * * * * **EMD* * * * * * * * 01/11/2013 21:47:37 : pos2 : RMUNGUIA5433 Cross streets: 7100 ARABIA RD//DEAD END*
Hoke Co 911:4498 PITTMAN GROVE CHURCH RD* * * * * **EMD* * * * * * * * 01/11/2013 15:05:00 : pos1 : rfairbanks1339 ** EMD Key Questions Finished ** Key Questions: 6.She has had a heart attack before. 7.She took a prescribed medication in th

Contact: Active911
Agency name: Hillcrest Fire Department
Location: Raeford, NC, United States
Sender: Hoke Co 911@hokecounty.org

Hoke Co 911:2909 HWY 401 BUSINESS* * * * 813 SCURLOCK SCHOOL RD* **HAZEL LN* 68J* * FIREALARM* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:4248 FAYETTEVILLE RD* * * * WOODBRIDGE DR* **HWY 401 BUSINESS* 63Y* * FIRERS* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:601 SCOTT CURRIE RD* * * * 1301 RED SPRINGS RD* **1828 OAKDALE GIN RD* 73C* * FIREGRASS* * * * * * Line16=* Line17=* Line18=01/31/2013 15:24:01 : pos2 : RCRUMPLER3351 Cross streets: 1301 RED SPRINGS RD//1828 OAKDALE GIN RD Landm
Hoke Co 911:4702 FAYETTEVILLE RD* * * * CLUB POND RD* **NORTHWOODS DR* 64U* * FIREALARM* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:108 MEADOW WOOD DR* * * * 2643 HWY 401 BUSINESS* **DEAD END* 68I* * FIREWOODS* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:PHILLIPI CHURCH RD* * * * 1232 ROCKFISH RD* **HUCKABEE ST* 69K* * AC/PD* * * * * * Line16=* Line17=* Line18=01/29/2013 16:47:10 : pos2 : TGESSLER0782 male is laying on the ground no moving 01/29/2013 16:42:44 : pos2 : TGESSLER07
Hoke Co 911:HILLCREST DR* * * * 2887 HWY 401 BUSINESS* **T AND K MHP* 68J* * FIRESMOKE* * * * * * Line16=* Line17=* Line18=01/28/2013 17:56:24 : pos2 : TGESSLER0782 Cross streets: 2887 HWY 401 BUSINESS//T AND K MHP Geo Comment: BESIDE HILLC
Hoke Co 911:513 PHILLIPI CHURCH RD* * * * OLD FOREST RD* **MILL PK* 69L* * FIREELEC* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:1860 HWY 401 BUSINESS* * * * AZALEA ST* **BROAD DR* 68M* * AC/PI* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:4400 FAYETTEVILLE RD* * * * HWY 401 BUSINESS* **CLUB POND RD* 63Y* * POWERLINE* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:200 RANIER DR* * * * 338 FAIRFIELD CIR* *** 65R* * FIREELEC* * * * * * Line16=* Line17=* Line18=01/24/2013 20:23:57 : pos2 : SCOOPER9403 Cross streets: 338 FAIRFIELD CIR// NBH: WESTGATE S/D CAN SMELL ELECTRICAL BURNING*
Hoke Co 911:400 NEW LN* * * * 1746 HAIRE RD* *** 73I* * FIREHOUSE* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:204 HILLCREST DR* * * * 2887 HWY 401 BUSINESS* **T AND K MHP* 68J* * FIREALARM* * * * FD1* * Line16=* Line17=* Line18=01/22/2013 07:51:13 : pos1 : rfairbanks1339 Cross streets: 2887 HWY 401 BUSINESS//T AND K MHP Geo Comment: BES
Hoke Co 911:439 GREENTREE DR* * * * 473 FOREST WOODS DR* **SCARLET OAK DR* 65M* * FIREHOUSE* * * * FD1,FD3,M4,RESC* * Line16=* Line17=* Line18=01/21/2013 18:37:32 : pos1 : rfairbanks1339 Cross streets: 473 FOREST WOODS DR//SCARLET OAK DR NB
Hoke Co 911:400 CELTIC CT* * * * 620 PHILLIPI CHURCH RD* **DEAD END* 69L* * FIREVEHICLE* * * * FD1* * Line16=* Line17=* Line18=01/21/2013 14:26:43 : pos4 : CROWLAND4749 Cross streets: 620 PHILLIPI CHURCH RD//DEAD END NBH: POSS HARTS MHP ?*
Hoke Co 911:1945 JOHNSON MILL RD* * * * CITADEL CT* **PITTMAN GROVE CHURCH RD* 64S* * FIREALARM* * * * FD1,FD31* * Line16=* Line17=* Line18=01/20/2013 16:14:41 : pos4 : DMELTON1918 Cross streets: CITADEL CT//PITTMAN GROVE CHURCH RD FORYER S
Hoke Co 911:100 CLUB POND RD* * * * 311 PHILLIPI CHURCH RD* **1470 ROCKFISH RD* 69K* * AC/PI* * * * FD1* * Line16=* Line17=* Line18=01/19/2013 13:17:41 : pos4 : DMELTON1918 Cross streets: 311 PHILLIPI CHURCH RD//1470 ROCKFISH RD NBH: SCURLO
Hoke Co 911:4002 FAYETTEVILLE RD* * * * TENNESSEE WALKER DR* **RILEY ST* 63Y* * AC/PI* * * * FD1,RESC* * Line16=* Line17=* Line18=01/18/2013 19:19:15 : pos4 : DMELTON1918 Cross streets: TENNESSEE WALKER DR//RILEY ST Landmark: RED DOOR HOMES

Contact: Active911
Agency name: West Hoke Fire Dept
Location: Raeford, NC, United States
Sender: Hoke Co 911@hokecounty.org

Hoke Co 911:100 RYAN MCBRYDE RD* * * * 6301 LAURINBURG RD* **2229 EDINBURGH RD* 72I* * AC/PI* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:1691 CALLOWAY RD* * * * SUMNER LN* **BAMA LN* 61N* * FIREFIELD* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:4011 FULFORD MCMILLAN RD* * * * L MCLAUGHLIN RD* **NORTON RD* 61W* * FIREELEC* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:619 MCGILVARY LN* * * * 1504 NEILL SINCLAIR RD* **DEAD END* 61Q* * FIREHOUSE* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:2291 GAINEY RD* * * * FULFORD MCMILLAN RD* **PLATT RD* 72C* * FIREBRUSH* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:8000 LAURINBURG RD* * * * N HILLTOP RD* **EDINBURGH RD* 72M* * AC/PI* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:497 EQUESTRIAN WAY* * * * 5497 ABERDEEN RD* **HOME STRETCH LN* 61I* * FIREALARM* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:1170 GAINEY RD* * * * TYEHIMBA LN* **TODD LN* 72M* * FIREGRASS* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:322 S HORACE WALTERS RD* * * * 9062 TURNPIKE RD* **DEAD END* 61U* * FIREHOUSE* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:233 STUBBS RD* * * * 7220 LAURINBURG RD* **480 GAINEY RD* 72M* * FIREALARM* * * * * * Line16=* Line17=* Line18=*
Hoke Co 911:100 HECTOR MCNEILL RD* * * * 6600 LAURINBURG RD* **690 GAINEY RD* 72M* * FIREBRUSH* * * * FD5* * Line16=* Line17=* Line18=01/23/2013 12:14:21 : pos4 : DMELTON1918 HECTOR MCNEILL RD//6600 LAURINBURG RD*

Contact: Active911
Agency name: 440 Puppy Creek Fire Department
Location: Raeford, NC, United States
Sender: Hoke Co 911@hokecounty.org

Hoke Co 911:104 MIDWAY DR* * * * FAYETTEVILLE RD* **COOL BREEZE DR* 65F* * AC/PI* * * * * * Line16=* Line17=* Line18=*\n
Hoke Co 911:504 OLD PARKER FARM RD* * * * 692 WAYSIDE RD* **DEAD END* 65G* * 06 BREATH PR* * * * * * Line16=* Line17=* Line18=*\n
Hoke Co 911:203 FALLINGLEAF DR* * * * BLUE WATER DR* **CAMROSE CT* 64C* * FIREALARM* * * * * * Line16=* Line17=* Line18=*\n
Hoke Co 911:131 SPRING VALLEY DR* * * * 1305 S PARKER CHURCH RD* *** 69E* * FIREALARM* * * * * * Line16=* Line17=* Line18=*\n
Hoke Co 911:1000 TOWNSEND RD* * * * WILLA MAE LN* **JOHNSON MILL RD* 69C* * AC/PI* * * * * * Line16=* Line17=* Line18=*\n
Hoke Co 911:336 SOMERSET DR* * * * BLUE WATER DR* **FALLINGLEAF DR* 64C* * FIREALARM* * * * * * Line16=* Line17=* Line18=*\n
Hoke Co 911:448 WOOD VALLEY LN* * * * 3682 ROCKFISH RD* **239 BECKMAN PL* 69J* * FIREALARM* * * * * * Line16=* Line17=* Line18=*\n
Hoke Co 911:2508 DANAHEY DR* * * * 2417 O`HARA DR* **O`GLESBY DR* 65A* * FIREVEHICLE* * * * * * Line16=* Line17=* Line18=*\n
Hoke Co 911:5073 ROCKFISH RD* * * * PITTMAN GROVE CHURCH RD* **GALATIA CHURCH RD* 70G* * AC/PI* * * * * * Line16=* Line17=* Line18=01/31/2013 07:45:08 : pos2 : RCRUMPLER3351 Cross streets: PITTMAN GROVE CHURCH RD//GALATIA CHURCH RD Landmark\n
Hoke Co 911:1401 DARBY DR* * * * 111 CLAN CAMPBELL DR* **O'BANNON DR* 65A* * TREE DOWN* * * * * * Line16=* Line17=* Line18=*\n
Hoke Co 911:100 HOBSON CT* * * * 1151 HOBSON RD* **DEAD END* 64D* * AC/PI* * * * * * Line16=* Line17=* Line18=01/29/2013 16:01:53 : pos4 : DMELTON1918 HOBSON CT//1151 HOBSON RD NBH: HOBSON PLACE S/D Landmark: READY MIX CONCRETE Cross street\n
Hoke Co 911:9615 FAYETTEVILLE RD* * * * FOREST WOODS RD* **WAYSIDE RD* 65H* * AC/PI* * * * * * Line16=* Line17=* Line18=01/29/2013 14:20:00 : pos3 : TGESSLER0782 Cross streets: FOREST WOODS RD//WAYSIDE RD Landmark: BP 104 1 FEMALE AND CHILD\n
Hoke Co 911:399 FAIRFIELD CIR* * * * 100 THORNCLIFF DR* *** 65R* * AC/PI* * * * * * Line16=* Line17=* Line18=01/29/2013 13:12:22 : pos3 : TGESSLER0782 Cross streets: 100 THORNCLIFF DR// Geo Comment: CIRCLES BACK ONTO ITSELF AT THORNCLIFF DR\n
Hoke Co 911:520 DUNROBIN DR* * * * 534 MCDOUGALD DR* **MCDOUGALD DR* 58U* * FIREALARM* * * * * * Line16=* Line17=* Line18=01/25/2013 17:27:18 : pos2 : RCRUMPLER3351 Cross streets: 534 MCDOUGALD DR//MCDOUGALD DR NBH: MCDOUGALD DOWNS S/D HALL\n

*/

public class NCHokeCountyParserTest extends BaseParserTest {
  
  public NCHokeCountyParserTest() {
    setParser(new NCHokeCountyParser(), "HOKE COUNTY", "NC");
  }
  
  @Test
  public void testHokeRescue() {

    doTest("T1",
        "Hoke Co 911:3000 TURNPIKE RD* * * * LESLIE DR* **L MCLAUGHLIN RD* 67K* * AC/OT/PI* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:3000 TURNPIKE RD",  // Not mapping
        "X:LESLIE DR & L MCLAUGHLIN RD",
        "MAP:67K",
        "CALL:AC/OT/PI");

    doTest("T2",
        "Hoke Co 911:568 L A SANDY RD* * * * 3641 ARABIA RD* **DEAD END* 74B* * 21 HEMM/LAC* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:568 L A SANDY RD",
        "X:3641 ARABIA RD & DEAD END",
        "MAP:74B",
        "CALL:21 HEMM/LAC");

    doTest("T3",
        "Hoke Co 911:2909 HWY 401 BUSINESS* * * * 813 SCURLOCK SCHOOL RD* **HAZEL LN* 68J* * AC/PI* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:2909 HWY 401 BUSINESS",  // Not mapping
        "X:813 SCURLOCK SCHOOL RD & HAZEL LN",
        "MAP:68J",
        "CALL:AC/PI");

    doTest("T4",
        "Hoke Co 911:100 N SHANNON RD* * * * 3401 RED SPRINGS RD* **2799 HAIRE RD* 73N* * AC/PI* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:100 N SHANNON RD",
        "X:3401 RED SPRINGS RD & 2799 HAIRE RD",
        "MAP:73N",
        "CALL:AC/PI");

    doTest("T5",
        "Hoke Co 911:7619 ROCKFISH RD* * * * 7699 PHILLIPI CHURCH RD* **WALTER DR* 71F* * AC/PI* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:7619 ROCKFISH RD",
        "X:7699 PHILLIPI CHURCH RD & WALTER DR",
        "MAP:71F",
        "CALL:AC/PI");

    doTest("T6",
        "Hoke Co 911:322 S HORACE WALTERS RD* * * * 9062 TURNPIKE RD* **DEAD END* 61U* * FIREHOUSE* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:322 S HORACE WALTERS RD",
        "X:9062 TURNPIKE RD & DEAD END",
        "MAP:61U",
        "CALL:FIREHOUSE");

    doTest("T7",
        "Hoke Co 911:250 GOOSE POND RD* * * * 6780 RED SPRINGS RD* **GRANNY LN* 73X* * AC/PI* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:250 GOOSE POND RD",
        "X:6780 RED SPRINGS RD & GRANNY LN",
        "MAP:73X",
        "CALL:AC/PI");

    doTest("T8",
        "Hoke Co 911:5073 ROCKFISH RD* * * * PITTMAN GROVE CHURCH RD* **GALATIA CHURCH RD* 70G* * AC/PI* * * * * * Line16=* Line17=* Line18=01/31/2013 07:45:08 : pos2 : RCRUMPLER3351 Cross streets: PITTMAN GROVE CHURCH RD//GALATIA CHURCH RD Landmark",
        "ADDR:5073 ROCKFISH RD",
        "X:PITTMAN GROVE CHURCH RD & GALATIA CHURCH RD",
        "MAP:70G",
        "CALL:AC/PI",
        "INFO:Landmark",
        "DATE:01/31/2013",
        "TIME:07:45:08",
        "CH:pos2");

    doTest("T9",
        "Hoke Co 911:520 E CENTRAL AVE* * * * MCDUFFIE ST* **HOUSE OF RAEFORD PLANT DR* 68Q* * STABBING* * * * * * Line16=* Line17=* Line18=01/29/2013 22:41:36 : pos1 : LGRADY7274 Cross streets: MCDUFFIE ST//HOUSE OF RAEFORD PLANT DR*",
        "ADDR:520 E CENTRAL AVE",
        "X:MCDUFFIE ST & HOUSE OF RAEFORD PLANT DR",
        "MAP:68Q",
        "CALL:STABBING",
        "DATE:01/29/2013",
        "TIME:22:41:36",
        "CH:pos1");

    doTest("T10",
        "Hoke Co 911:PHILLIPI CHURCH RD* * * * 1232 ROCKFISH RD* **HUCKABEE ST* 69K* * AC/PD* * * * * * Line16=* Line17=* Line18=01/29/2013 16:42:44 : pos2 : TGESSLER0782 Cross streets: 1232 ROCKFISH RD//HUCKABEE ST NBH: SCURLOCK*",
        "ADDR:PHILLIPI CHURCH RD",
        "MADDR:PHILLIPI CHURCH RD & ROCKFISH RD",
        "X:1232 ROCKFISH RD & HUCKABEE ST",
        "MAP:69K",
        "CALL:AC/PD",
        "INFO:NBH: SCURLOCK",
        "DATE:01/29/2013",
        "TIME:16:42:44",
        "CH:pos2");

    doTest("T11",
        "Hoke Co 911:100 HOBSON CT* * * * 1151 HOBSON RD* **DEAD END* 64D* * AC/PI* * * * * * Line16=* Line17=* Line18=01/29/2013 16:01:53 : pos4 : DMELTON1918 HOBSON CT//1151 HOBSON RD NBH: HOBSON PLACE S/D Landmark: READY MIX CONCRETE Cross street",
        "ADDR:100 HOBSON CT",
        "X:1151 HOBSON RD & DEAD END",
        "MAP:64D",
        "CALL:AC/PI",
        "INFO:HOBSON CT//1151 HOBSON RD / NBH: HOBSON PLACE S/D",
        "DATE:01/29/2013",
        "TIME:16:01:53",
        "CH:pos4",
        "PLACE:READY MIX CONCRETE Cross street");

    doTest("T12",
        "Hoke Co 911:9615 FAYETTEVILLE RD* * * * FOREST WOODS RD* **WAYSIDE RD* 65H* * AC/PI* * * * * * Line16=* Line17=* Line18=01/29/2013 14:20:00 : pos3 : TGESSLER0782 Cross streets: FOREST WOODS RD//WAYSIDE RD Landmark: BP 104 1 FEMALE AND CHILD",
        "ADDR:9615 FAYETTEVILLE RD",
        "X:FOREST WOODS RD & WAYSIDE RD",
        "MAP:65H",
        "CALL:AC/PI",
        "DATE:01/29/2013",
        "TIME:14:20:00",
        "CH:pos3",
        "PLACE:BP 104 1 FEMALE AND CHILD");

    doTest("T13",
        "Hoke Co 911:399 FAIRFIELD CIR* * * * 100 THORNCLIFF DR* *** 65R* * AC/PI* * * * * * Line16=* Line17=* Line18=01/29/2013 13:12:22 : pos3 : TGESSLER0782 Cross streets: 100 THORNCLIFF DR// Geo Comment: CIRCLES BACK ONTO ITSELF AT THORNCLIFF DR",
        "ADDR:399 FAIRFIELD CIR",
        "X:100 THORNCLIFF DR",
        "MAP:65R",
        "CALL:AC/PI",
        "INFO:CIRCLES BACK ONTO ITSELF AT THORNCLIFF DR",
        "DATE:01/29/2013",
        "TIME:13:12:22",
        "CH:pos3");

    doTest("T14",
        "Hoke Co 911:117 YADKIN TRL* * * * 500 WOOLEY ST* **WOOLEY ST* 67T* * 26 SICK PERS* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:117 YADKIN TRL",
        "X:500 WOOLEY ST & WOOLEY ST",
        "MAP:67T",
        "CALL:26 SICK PERS");

    doTest("T15",
        "Hoke Co 911:104 MIDWAY DR* * * * FAYETTEVILLE RD* **COOL BREEZE DR* 65F* * AC/PI* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:104 MIDWAY DR",
        "X:FAYETTEVILLE RD & COOL BREEZE DR",
        "MAP:65F",
        "CALL:AC/PI");

    doTest("T16",
        "Hoke Co 911:1401 DARBY DR* * * * 111 CLAN CAMPBELL DR* **O'BANNON DR* 65A* * EMD* * * * * * Line16=* Line17=* Line18=01/27/2013 17:13:21 : pos4 : LHOWELL1154 ** EMD Key Questions Finished ** Key Questions: * 1.The cardiac arrest was not wit",
        "ADDR:1401 DARBY DR",
        "X:111 CLAN CAMPBELL DR & O'BANNON DR",
        "MAP:65A",
        "CALL:EMD",
        "INFO:** EMD Key Questions Finished **",
        "DATE:01/27/2013",
        "TIME:17:13:21",
        "CH:pos4");

    doTest("T17",
        "Hoke Co 911:2474 JOHN RD* * * * COOK RD* **2551 BALFOUR RD* 80A* * AC/PI* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:2474 JOHN RD",
        "X:COOK RD & 2551 BALFOUR RD",
        "MAP:80A",
        "CALL:AC/PI");

    doTest("T18",
        "Hoke Co 911:3250 BALFOUR RD* * * * 600 ALBERT CURRIE RD* **5100 N SHANNON RD* 80B* * EMD* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:3250 BALFOUR RD",
        "X:600 ALBERT CURRIE RD & 5100 N SHANNON RD",
        "MAP:80B",
        "CALL:EMD");

    doTest("T19",
        "Hoke Co 911:180 RAINDROP LOOP* * * * 624 ALEX BAKER RD* **676 ALEX BAKER RD* 67D* * AC/PI* * * * * * Line16=* Line17=* Line18=01/26/2013 06:22:01 : pos2 : RMUNGUIA5433 Cross streets: 624 ALEX BAKER RD//676 ALEX BAKER RD NBH: QUEENMORE Cross",
        "ADDR:180 RAINDROP LOOP",
        "X:624 ALEX BAKER RD & 676 ALEX BAKER RD",
        "MAP:67D",
        "CALL:AC/PI",
        "INFO:NBH: QUEENMORE Cross",
        "DATE:01/26/2013",
        "TIME:06:22:01",
        "CH:pos2");

    doTest("T20",
        "Hoke Co 911:7097 WALTER GIBSON RD* * * * 699 CENTER GROVE CHURCH RD* **200 S OLD WIRE RD* 73W* * AC/PI* * * * * * Line16=* Line17=* Line18=01/25/2013 22:07:55 : pos2 : RMUNGUIA5433 Cross streets: 699 CENTER GROVE CHURCH RD//200 S OLD WIRE R",
        "ADDR:7097 WALTER GIBSON RD",
        "X:699 CENTER GROVE CHURCH RD & 200 S OLD WIRE RD",
        "MAP:73W",
        "CALL:AC/PI",
        "DATE:01/25/2013",
        "TIME:22:07:55",
        "CH:pos2");

    doTest("T21",
        "Hoke Co 911:1860 HWY 401 BUSINESS* * * * AZALEA ST* **BROAD DR* 68M* * AC/PI* * * * * * Line16=* Line17=* Line18=01/25/2013 20:14:01 : pos1 : SGRAHAM9861 Cross streets: AZALEA ST//BROAD DR Landmark: MANNING MINI STORAGE NBH: HILLCREST*",
        "ADDR:1860 HWY 401 BUSINESS",
        "X:AZALEA ST & BROAD DR",
        "MAP:68M",
        "CALL:AC/PI",
        "INFO:NBH: HILLCREST",
        "DATE:01/25/2013",
        "TIME:20:14:01",
        "CH:pos1",
        "PLACE:MANNING MINI STORAGE");

    doTest("T22",
        "Hoke Co 911:5000 RED SPRINGS RD* * * * ANDREWS RD* **HAWKEYE DR* 73S* * AC/PI* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:5000 RED SPRINGS RD",
        "X:ANDREWS RD & HAWKEYE DR",
        "MAP:73S",
        "CALL:AC/PI");

    doTest("T23",
        "Hoke Co 911:3697 RED SPRINGS RD* * * * N SHANNON RD* **APPLEWOOD LN* 73I* * AC/PI* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:3697 RED SPRINGS RD",
        "X:N SHANNON RD & APPLEWOOD LN",
        "MAP:73I",
        "CALL:AC/PI");

    doTest("T24",
        "Hoke Co 911:200 RANIER DR* * * * 338 FAIRFIELD CIR* *** 65R* * FIREELEC* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:200 RANIER DR",
        "X:338 FAIRFIELD CIR",
        "MAP:65R",
        "CALL:FIREELEC");

    doTest("T25",
        "Hoke Co 911:7369 ROCKFISH RD* * * * EULON LOOP* **SCHOOL ST* 70J* * AC/PI* * * * * * Line16=* Line17=* Line18=01/24/2013 13:47:09 : pos4 : DMELTON1918 Cross streets: EULON LOOP//SCHOOL ST Landmark: DOLLAR GENERAL NBH: ROCKFISH*",
        "ADDR:7369 ROCKFISH RD",
        "X:EULON LOOP & SCHOOL ST",
        "MAP:70J",
        "CALL:AC/PI",
        "INFO:NBH: ROCKFISH",
        "DATE:01/24/2013",
        "TIME:13:47:09",
        "CH:pos4",
        "PLACE:DOLLAR GENERAL");

    doTest("T26",
        "Hoke Co 911:400 NEW LN* * * * 1746 HAIRE RD* *** 73I* * FIREHOUSE* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:400 NEW LN",
        "X:1746 HAIRE RD",
        "MAP:73I",
        "CALL:FIREHOUSE");

    doTest("T27",
        "Hoke Co 911:709 E PALMER ST* * * * LAURINBURG RD* **742 S MAIN ST* 67Y* * TEST* * * * * * Line16=* Line17=* Line18=01/23/2013 19:38:25 : pos4 : TMCKNIGHT7534 Landmark: NEW COMMUNICATIONS CENTER Cross streets: LAURINBURG RD//742 S MAIN ST Ge",
        "ADDR:709 E PALMER ST",
        "X:LAURINBURG RD & 742 S MAIN ST",
        "MAP:67Y",
        "CALL:TEST",
        "INFO:Ge",
        "DATE:01/23/2013",
        "TIME:19:38:25",
        "CH:pos4",
        "PLACE:NEW COMMUNICATIONS CENTER");

    doTest("T28",
        "Hoke Co 911:15598 HWY 15-501* * * * 100 GRAY RUN LN* **5300 ASHEMONT RD* 56U* * AC/PI* * * * RESC* * Line16=* Line17=* Line18=01/23/2013 15:35:15 : pos1 : hjacobsen8281 Cross streets: 100 GRAY RUN LN//5300 ASHEMONT RD Landmark: FIVE STAR FO",
        "ADDR:15598 HWY 15-501",
        "X:100 GRAY RUN LN & 5300 ASHEMONT RD",
        "MAP:56U",
        "CALL:AC/PI",
        "INFO:RESC",
        "DATE:01/23/2013",
        "TIME:15:35:15",
        "CH:pos1",
        "PLACE:FIVE STAR FO");

    doTest("T29",
        "Hoke Co 911:900 WALLACE MCLEAN RD* * * * LAURINBURG RD* **LEMONT DR* 67S* * AC/PI* * * * M2,RESC* * Line16=* Line17=* Line18=01/22/2013 08:59:46 : pos1 : rfairbanks1339 Cross streets: LAURINBURG RD//LEMONT DR BACK INJURY*",
        "ADDR:900 WALLACE MCLEAN RD",
        "X:LAURINBURG RD & LEMONT DR",
        "MAP:67S",
        "CALL:AC/PI",
        "INFO:M2,RESC\nBACK INJURY",
        "DATE:01/22/2013",
        "TIME:08:59:46",
        "CH:pos1");

    doTest("T30",
        "Hoke Co 911:439 GREENTREE DR* * * * 473 FOREST WOODS DR* **SCARLET OAK DR* 65M* * FIREHOUSE* * * * FD3,RESC* * Line16=* Line17=* Line18=01/21/2013 18:37:32 : pos1 : rfairbanks1339 Cross streets: 473 FOREST WOODS DR//SCARLET OAK DR NBH: FORE",
        "ADDR:439 GREENTREE DR",
        "X:473 FOREST WOODS DR & SCARLET OAK DR",
        "MAP:65M",
        "CALL:FIREHOUSE",
        "INFO:FD3,RESC\nNBH: FORE",
        "DATE:01/21/2013",
        "TIME:18:37:32",
        "CH:pos1");

    doTest("T31",
        "Hoke Co 911:198 PINEY GROVE MHP* * * * 415 HAMILTON DR* *** 67H* * 06 BREATH PR* * * * M2,RESC* * Line16=* Line17=* Line18=01/20/2013 21:50:28 : pos2 : SCOOPER9403 ** EMD Case Complete ** Key Questions: 67 year old, Female, Conscious, Breat",
        "ADDR:198 PINEY GROVE MHP",
        "X:415 HAMILTON DR",
        "MAP:67H",
        "CALL:06 BREATH PR",
        "INFO:M2,RESC\n67 year old, Female, Conscious, Breat",
        "DATE:01/20/2013",
        "TIME:21:50:28",
        "CH:pos2");

    doTest("T32",
        "Hoke Co 911:100 ALBERT CURRIE RD* * * * 5500 N SHANNON RD* **2910 BALFOUR RD* 80B* * AC/PI* * * * FD8,M1,RESC* * Line16=* Line17=* Line18=01/20/2013 02:45:22 : pos4 : DMELTON1918 ALBERT CURRIE RD//5500 N SHANNON RD*",
        "ADDR:100 ALBERT CURRIE RD",
        "X:5500 N SHANNON RD & 2910 BALFOUR RD",
        "MAP:80B",
        "CALL:AC/PI",
        "INFO:FD8,M1,RESC\nALBERT CURRIE RD//5500 N SHANNON RD",
        "DATE:01/20/2013",
        "TIME:02:45:22",
        "CH:pos4");

    doTest("T33",
        "Hoke Co 911:446 DAVIS BRIDGE RD* * * * 8999 ARABIA RD* **ROBESON CO LINE* 75G* * AC/PI* * * * FD2,M4,RESC* * Line16=* Line17=* Line18=01/20/2013 00:11:59 : pos4 : DMELTON1918 Cross streets: 8999 ARABIA RD//ROBESON CO LINE NBH: DAVIS BRIDGE*",
        "ADDR:446 DAVIS BRIDGE RD",
        "X:8999 ARABIA RD & ROBESON CO LINE",
        "MAP:75G",
        "CALL:AC/PI",
        "INFO:FD2,M4,RESC\nNBH: DAVIS BRIDGE",
        "DATE:01/20/2013",
        "TIME:00:11:59",
        "CH:pos4");

    doTest("T34",
        "Hoke Co 911:100 WAYSIDE RD* * * * FAYETTEVILLE RD* **OLD OAK RD* 65H* * AC/PI* * * * FD3,RESC* * Line16=* Line17=* Line18=01/19/2013 15:35:12 : pos1 : hjacobsen8281 Cross streets: FAYETTEVILLE RD//OLD OAK RD*",
        "ADDR:100 WAYSIDE RD",
        "X:FAYETTEVILLE RD & OLD OAK RD",
        "MAP:65H",
        "CALL:AC/PI",
        "INFO:FD3,RESC",
        "DATE:01/19/2013",
        "TIME:15:35:12",
        "CH:pos1");

    doTest("T35",
        "Hoke Co 911:100 CLUB POND RD* * * * 311 PHILLIPI CHURCH RD* **1470 ROCKFISH RD* 69K* * AC/PI* * * * FD1,RESC* * Line16=* Line17=* Line18=01/19/2013 13:17:41 : pos4 : DMELTON1918 Cross streets: 311 PHILLIPI CHURCH RD//1470 ROCKFISH RD NBH: S",
        "ADDR:100 CLUB POND RD",
        "X:311 PHILLIPI CHURCH RD & 1470 ROCKFISH RD",
        "MAP:69K",
        "CALL:AC/PI",
        "INFO:FD1,RESC\nNBH: S",
        "DATE:01/19/2013",
        "TIME:13:17:41",
        "CH:pos4");

    doTest("T36",
        "Hoke Co 911:1392 RESERVATION RD* * * * CALLOWAY RD* **QUEWIFFLE RD* 56J* * AC/PI* * * * FD7,RESC* * Line16=* Line17=* Line18=01/18/2013 19:28:26 : pos1 : LGRADY7274 RESERVATION RD//CALLOWAY RD Geo Comment: RESCUE 2 AREA NBH: QUEWHIFFLE TWO ",
        "ADDR:1392 RESERVATION RD",
        "X:CALLOWAY RD & QUEWIFFLE RD",
        "MAP:56J",
        "CALL:AC/PI",
        "INFO:FD7,RESC\nRESERVATION RD//CALLOWAY RD / RESCUE 2 AREA / NBH: QUEWHIFFLE TWO",
        "DATE:01/18/2013",
        "TIME:19:28:26",
        "CH:pos1");

    doTest("T37",
        "Hoke Co 911:4002 FAYETTEVILLE RD* * * * TENNESSEE WALKER DR* **RILEY ST* 63Y* * AC/PI* * * * RESC* * Line16=* Line17=* Line18=01/18/2013 19:19:15 : pos4 : DMELTON1918 Cross streets: TENNESSEE WALKER DR//RILEY ST Landmark: RED DOOR HOMES*",
        "ADDR:4002 FAYETTEVILLE RD",
        "X:TENNESSEE WALKER DR & RILEY ST",
        "MAP:63Y",
        "CALL:AC/PI",
        "INFO:RESC",
        "DATE:01/18/2013",
        "TIME:19:19:15",
        "CH:pos4",
        "PLACE:RED DOOR HOMES");

    doTest("T38",
        "Hoke Co 911:195 RANDLEMAN DR* * * * 251 WINDOVER DR* **511 WINDOVER DR* 65R* * EMD* * * * M3,RESC* * Line16=* Line17=* Line18=01/17/2013 22:51:35 : pos4 : CROWLAND4749 ** EMD Key Questions Finished ** Key Questions: 15 year old, Female, Unc",
        "ADDR:195 RANDLEMAN DR",
        "X:251 WINDOVER DR & 511 WINDOVER DR",
        "MAP:65R",
        "CALL:EMD",
        "INFO:M3,RESC\n** EMD Key Questions Finished ** / 15 year old, Female, Unc",
        "DATE:01/17/2013",
        "TIME:22:51:35",
        "CH:pos4");

    doTest("T39",
        "Hoke Co 911:10399 FAYETTEVILLE RD* * * * * **AC/PI* * * * * * * * 01/15/2013 18:50:23 : pos4 : DMELTON1918 Cross streets: PLAZA DR//CUMBERLAND COUNTY LINE Landmark: COUNTY LINE - CUMBERLAND COUNTY*",
        "ADDR:10399 FAYETTEVILLE RD",
        "X:AC/PI",
        "DATE:01/15/2013",
        "TIME:18:50:23",
        "CH:pos4",
        "PLACE:COUNTY LINE - CUMBERLAND COUNTY");

    doTest("T40",
        "Hoke Co 911:2214 HWY 401 BUSINESS* * * * * **AC/PI* * * * * * * * 01/14/2013 22:43:14 : pos1 : LGRADY7274 HWY 401 BUSINESS//ROCKFISH RD NBH: HILLCREST Cross streets: E PROSPECT AVE//CRUMPLER DR NBH: HILLCREST 35YOM MOTORCYCLE ONE*",
        "ADDR:2214 HWY 401 BUSINESS",
        "X:AC/PI",
        "INFO:HWY 401 BUSINESS//ROCKFISH RD / NBH: HILLCREST / NBH: HILLCREST 35YOM MOTORCYCLE ONE",
        "DATE:01/14/2013",
        "TIME:22:43:14",
        "CH:pos1");

    doTest("T41",
        "Hoke Co 911:803 EDINBURGH RD* * * * * **EMD* * * * * * * * 01/12/2013 20:35:21 : pos4 : CROWLAND4749 ** EMD Case Complete ** Key Questions: 22 year old, Female, Conscious, Breathing. 01/12/2013 20:34:51 : pos4 : CROWLAND4749 ** EMD Recommen",
        "ADDR:803 EDINBURGH RD",
        "X:EMD",
        "INFO:22 year old, Female, Conscious, Breathing.\n** EMD Recommen",
        "DATE:01/12/2013",
        "TIME:20:35:21",
        "CH:pos4");
   
  }
  
  @Test
  public void RockfishFire() {

    doTest("T1",
        "Hoke Co 911:6207 PITTMAN GROVE CHURCH RD* * * * 1341 TC JONES RD* **SPANGLER DR* 74E* * EMD* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:6207 PITTMAN GROVE CHURCH RD",
        "X:1341 TC JONES RD & SPANGLER DR",
        "MAP:74E",
        "CALL:EMD");

    doTest("T2",
        "Hoke Co 911:300 ROLLING PINES CT* * * * 137 WINDY PINES CT* **100 CRABAPPLE LN* 71K* * 24B01* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:300 ROLLING PINES CT",
        "X:137 WINDY PINES CT & 100 CRABAPPLE LN",
        "MAP:71K",
        "CALL:24B01");

    doTest("T3",
        "Hoke Co 911:174 E TWELVE OAKS RD* * * * TWELVE OAKS RD* *** 75C* * ILLEGALBURN* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:174 E TWELVE OAKS RD",
        "X:TWELVE OAKS RD",
        "MAP:75C",
        "CALL:ILLEGALBURN");

    doTest("T4",
        "Hoke Co 911:4767 PHILLIPI CHURCH RD* * * * GOLF COURSE RD* **PITTMAN GROVE CHURCH RD* 70V* * 26C02* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:4767 PHILLIPI CHURCH RD",
        "X:GOLF COURSE RD & PITTMAN GROVE CHURCH RD",
        "MAP:70V",
        "CALL:26C02");

    doTest("T5",
        "Hoke Co 911:7619 ROCKFISH RD* * * * 7699 PHILLIPI CHURCH RD* **WALTER DR* 71F* * AC/PI* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:7619 ROCKFISH RD",
        "X:7699 PHILLIPI CHURCH RD & WALTER DR",
        "MAP:71F",
        "CALL:AC/PI");

    doTest("T6",
        "Hoke Co 911:7525 ARABIA RD* * * * SUNSET LAKE RD* **MISSIONVILLE RD* 74E* * EMD* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:7525 ARABIA RD",
        "X:SUNSET LAKE RD & MISSIONVILLE RD",
        "MAP:74E",
        "CALL:EMD");

    doTest("T7",
        "Hoke Co 911:632 SUNSET LAKE RD* * * * 7100 ARABIA RD* **DEAD END* 74E* * 26A01* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:632 SUNSET LAKE RD",
        "X:7100 ARABIA RD & DEAD END",
        "MAP:74E",
        "CALL:26A01");

    doTest("T8",
        "Hoke Co 911:186 STARLITE DR* * * * 6729 PITTMAN GROVE CHURCH* **258 RENEES LN* 75A* * EMD* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:186 STARLITE DR",
        "X:6729 PITTMAN GROVE CHURCH & 258 RENEES LN",
        "MAP:75A",
        "CALL:EMD");

    doTest("T9",
        "Hoke Co 911:5073 ROCKFISH RD* * * * PITTMAN GROVE CHURCH RD* **GALATIA CHURCH RD* 70G* * AC/PI* * * * * * Line16=* Line17=* Line18=01/31/2013 07:45:08 : pos2 : RCRUMPLER3351 Cross streets: PITTMAN GROVE CHURCH RD//GALATIA CHURCH RD Landmark",
        "ADDR:5073 ROCKFISH RD",
        "X:PITTMAN GROVE CHURCH RD & GALATIA CHURCH RD",
        "MAP:70G",
        "CALL:AC/PI",
        "INFO:Landmark",
        "DATE:01/31/2013",
        "TIME:07:45:08",
        "CH:pos2");

    doTest("T10",
        "Hoke Co 911:441 CAMDEN RD* * * * STONEWALL ST* **REGENCY DR* 75B* * 5A01* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:441 CAMDEN RD",
        "X:STONEWALL ST & REGENCY DR",
        "MAP:75B",
        "CALL:5A01");

    doTest("T11",
        "Hoke Co 911:1122 DAVIS BRIDGE RD* * * * 8999 ARABIA RD* **ROBESON CO LINE* 75G* * FIREOTHER* * * * * * Line16=* Line17=* Line18=01/30/2013 21:05:14 : pos2 : RMUNGUIA5433 Cross streets: 8999 ARABIA RD//ROBESON CO LINE NBH: DAVIS BRIDGE INREF",
        "ADDR:1122 DAVIS BRIDGE RD",
        "X:8999 ARABIA RD & ROBESON CO LINE",
        "MAP:75G",
        "CALL:FIREOTHER",
        "INFO:NBH: DAVIS BRIDGE INREF",
        "DATE:01/30/2013",
        "TIME:21:05:14",
        "CH:pos2");

    doTest("T12",
        "Hoke Co 911:2420 GALATIA CHURCH RD* * * * LINDSAY RD* **RIDGE MANOR DR* 65Y* * EMD* * * * * * Line16=* Line17=* Line18=01/30/2013 18:21:59 : pos2 : RCRUMPLER3351 ** EMD Case Entry Finished ** Chief Complaint Number: 10 Key Questions: 20-yea",
        "ADDR:2420 GALATIA CHURCH RD",
        "X:LINDSAY RD & RIDGE MANOR DR",
        "MAP:65Y",
        "CALL:EMD",
        "INFO:Chief Complaint Number: 10 / 20-yea",
        "DATE:01/30/2013",
        "TIME:18:21:59",
        "CH:pos2");

    doTest("T13",
        "Hoke Co 911:248 MUMFORD RD* * * * 6933 PITTMAN GROVE CH RD* **WILDLIFE LN* 75A* * EMD* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:248 MUMFORD RD",
        "X:6933 PITTMAN GROVE CH RD & WILDLIFE LN",
        "MAP:75A",
        "CALL:EMD");

    doTest("T14",
        "Hoke Co 911:170 TRIPLE CROWN DR* * * * 255 STEEPLE RUN DR* *** 71A* * EMD* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:170 TRIPLE CROWN DR",
        "X:255 STEEPLE RUN DR",
        "MAP:71A",
        "CALL:EMD");

    doTest("T15",
        "Hoke Co 911:385 SUNSET LAKE RD* * * * 7100 ARABIA RD* **DEAD END* 74E* * EMD* * * * * * Line16=* Line17=* Line18=01/29/2013 18:45:17 : pos1 : hjacobsen8281 Cross streets: 7100 ARABIA RD//DEAD END*",
        "ADDR:385 SUNSET LAKE RD",
        "X:7100 ARABIA RD & DEAD END",
        "MAP:74E",
        "CALL:EMD",
        "DATE:01/29/2013",
        "TIME:18:45:17",
        "CH:pos1");

    doTest("T16",
        "Hoke Co 911:157 EULON LOOP* * * * 7115 ROCKFISH RD* *** 70J* * EMD* * * * * * Line16=* Line17=* Line18=01/27/2013 20:45:39 : pos1 : SGRAHAM9861 Cross streets: 7115 ROCKFISH RD// NBH: DAVIS ESTATES*",
        "ADDR:157 EULON LOOP",
        "X:7115 ROCKFISH RD",
        "MAP:70J",
        "CALL:EMD",
        "INFO:NBH: DAVIS ESTATES",
        "DATE:01/27/2013",
        "TIME:20:45:39",
        "CH:pos1");

    doTest("T17",
        "Hoke Co 911:125 FRANKLIN DR* * * * 122 BOSTIC RD* **SHADOWOOD DR* 70O* * EMD* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:125 FRANKLIN DR",
        "X:122 BOSTIC RD & SHADOWOOD DR",
        "MAP:70O",
        "CALL:EMD");

    doTest("T18",
        "Hoke Co 911:6727 IRONGATE DR* B* * * * *** * * FIRESTRUCT* * * * * * Line16=* Line17=* Line18=01/27/2013 10:06:54 : pos1 : rfairbanks1339 SURRY RD / GATES 4 SD , 23 , CUMB 6A 69D5*",
        "ADDR:6727 IRONGATE DR",
        "APT:B",
        "CALL:FIRESTRUCT",
        "INFO:SURRY RD / GATES 4 SD , 23 , CUMB 6A 69D5",
        "DATE:01/27/2013",
        "TIME:10:06:54",
        "CH:pos1");

    doTest("T19",
        "Hoke Co 911:630 DOGWOOD LN* * * * 299 HICKORY DR* *** 70V* * FIREALARM* * * * * * Line16=* Line17=* Line18=01/26/2013 20:23:05 : pos2 : RMUNGUIA5433 Cross streets: 299 HICKORY DR// A/A HALL WAY SMOKE DET NKH HOI: LORENCE MONROE 910 875 6446",
        "ADDR:630 DOGWOOD LN",
        "X:299 HICKORY DR",
        "MAP:70V",
        "CALL:FIREALARM",
        "INFO:A/A HALL WAY SMOKE DET NKH HOI: LORENCE MONROE 910 875 6446",
        "DATE:01/26/2013",
        "TIME:20:23:05",
        "CH:pos2");

    doTest("T20",
        "Hoke Co 911:365 EVERITT RD* * * * HILLCREEK DR* **CREEK FARM DR* 75G* * EMD* * * * * * Line16=* Line17=* Line18=01/26/2013 20:15:36 : pos1 : SGRAHAM9861 Cross streets: HILLCREEK DR//CREEK FARM DR*",
        "ADDR:365 EVERITT RD",
        "X:HILLCREEK DR & CREEK FARM DR",
        "MAP:75G",
        "CALL:EMD",
        "DATE:01/26/2013",
        "TIME:20:15:36",
        "CH:pos1");

    doTest("T21",
        "Hoke Co 911:189 BETTY`S TRL* * * * 580 EVERITT RD* **DEAD END* 75L* * EMD* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:189 BETTY`S TRL",
        "X:580 EVERITT RD & DEAD END",
        "MAP:75L",
        "CALL:EMD");

    doTest("T22",
        "Hoke Co 911:9701 ROCKFISH RD* * * * MALLERNEE LN* **OVERTON RD* 71V* * EMD* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:9701 ROCKFISH RD",
        "X:MALLERNEE LN & OVERTON RD",
        "MAP:71V",
        "CALL:EMD");

    doTest("T23",
        "Hoke Co 911:200 RANIER DR* * * * 338 FAIRFIELD CIR* *** 65R* * FIREELEC* * * * * * Line16=* Line17=* Line18=01/24/2013 20:23:57 : pos2 : SCOOPER9403 Cross streets: 338 FAIRFIELD CIR// NBH: WESTGATE S/D CAN SMELL ELECTRICAL BURNING*",
        "ADDR:200 RANIER DR",
        "X:338 FAIRFIELD CIR",
        "MAP:65R",
        "CALL:FIREELEC",
        "INFO:NBH: WESTGATE S/D CAN SMELL ELECTRICAL BURNING",
        "DATE:01/24/2013",
        "TIME:20:23:57",
        "CH:pos2");

    doTest("T24",
        "Hoke Co 911:7369 ROCKFISH RD* * * * EULON LOOP* **SCHOOL ST* 70J* * AC/PI* * * * * * Line16=* Line17=* Line18=01/24/2013 13:47:09 : pos4 : DMELTON1918 Cross streets: EULON LOOP//SCHOOL ST Landmark: DOLLAR GENERAL NBH: ROCKFISH*",
        "ADDR:7369 ROCKFISH RD",
        "X:EULON LOOP & SCHOOL ST",
        "MAP:70J",
        "CALL:AC/PI",
        "INFO:NBH: ROCKFISH",
        "DATE:01/24/2013",
        "TIME:13:47:09",
        "CH:pos4",
        "PLACE:DOLLAR GENERAL");

    doTest("T25",
        "Hoke Co 911:189 BETTY`S TRL* * * * 580 EVERITT RD* **DEAD END* 75L* * EMD* * * * FD20,M2* * Line16=* Line17=* Line18=01/22/2013 01:57:27 : pos2 : RMUNGUIA5433 ** EMD Recommended Dispatch ** Response Text: Delta Dispatch Level: 12D02 Suffix:",
        "ADDR:189 BETTY`S TRL",
        "X:580 EVERITT RD & DEAD END",
        "MAP:75L",
        "CALL:EMD",
        "INFO:FD20,M2\nDelta Dispatch Level: 12D02 Suffix:",
        "DATE:01/22/2013",
        "TIME:01:57:27",
        "CH:pos2");

    doTest("T26",
        "Hoke Co 911:439 GREENTREE DR* * * * 473 FOREST WOODS DR* **SCARLET OAK DR* 65M* * FIREHOUSE* * * * FD1,FD2,FD3,M4,RESC* * Line16=* Line17=* Line18=01/21/2013 18:37:32 : pos1 : rfairbanks1339 Cross streets: 473 FOREST WOODS DR//SCARLET OAK D",
        "ADDR:439 GREENTREE DR",
        "X:473 FOREST WOODS DR & SCARLET OAK DR",
        "MAP:65M",
        "CALL:FIREHOUSE",
        "INFO:FD1,FD2,FD3,M4,RESC",
        "DATE:01/21/2013",
        "TIME:18:37:32",
        "CH:pos1");

    doTest("T27",
        "Hoke Co 911:CAMP ROCKFISH RD* * * * 153 DAVIS BRIDGE RD* **DEAD END* 75G* * 06 BREATH PR* * * * FD20* * Line16=* Line17=* Line18=01/21/2013 14:11:30 : pos4 : CROWLAND4749 FD20 ADV CANCEL, UNABLE TO LOCATE ANYTHING 01/21/2013 14:10:35 : pos1",
        "ADDR:CAMP ROCKFISH RD",
        "MADDR:CAMP ROCKFISH RD & DAVIS BRIDGE RD",
        "X:153 DAVIS BRIDGE RD & DEAD END",
        "MAP:75G",
        "CALL:06 BREATH PR",
        "INFO:FD20\nFD20 ADV CANCEL, UNABLE TO LOCATE ANYTHING 01/21/2013 14:10:35 : pos1",
        "DATE:01/21/2013",
        "TIME:14:11:30",
        "CH:pos4");

    doTest("T28",
        "Hoke Co 911:270 JODY LN* * * * 1499 MYRA RD* **DEAD END* 71U* * EMD* * * * FD20,M2* * Line16=* Line17=* Line18=01/21/2013 09:26:12 : pos2 : RCRUMPLER3351 ** EMD Case Entry Finished ** Chief Complaint Number: 21 Key Questions: 67 year old, M",
        "ADDR:270 JODY LN",
        "X:1499 MYRA RD & DEAD END",
        "MAP:71U",
        "CALL:EMD",
        "INFO:FD20,M2\nChief Complaint Number: 21 / 67 year old, M",
        "DATE:01/21/2013",
        "TIME:09:26:12",
        "CH:pos2");

    doTest("T29",
        "Hoke Co 911:4520 PITTMAN GROVE CHURCH RD* * * * NANDAKAR TRL* **4769 PHILLIPI CHURCH RD* 70Q* * EMD* * * * FD20,M3* * Line16=* Line17=* Line18=01/20/2013 16:49:33 : pos4 : DMELTON1918 Cross streets: NANDAKAR TRL//4769 PHILLIPI CHURCH RD*",
        "ADDR:4520 PITTMAN GROVE CHURCH RD",
        "X:NANDAKAR TRL & 4769 PHILLIPI CHURCH RD",
        "MAP:70Q",
        "CALL:EMD",
        "INFO:FD20,M3",
        "DATE:01/20/2013",
        "TIME:16:49:33",
        "CH:pos4");

    doTest("T30",
        "Hoke Co 911:446 DAVIS BRIDGE RD* * * * 8999 ARABIA RD* **ROBESON CO LINE* 75G* * AC/PI* * * * 11,52,94,FD20,FD22,M4,RES1,RESC* * Line16=* Line17=* Line18=01/20/2013 00:20:12 : pos1 : LGRADY7274 IN THE WOODLINE LIVE LINE DOWN 01/20/2013 00:1",
        "ADDR:446 DAVIS BRIDGE RD",
        "X:8999 ARABIA RD & ROBESON CO LINE",
        "MAP:75G",
        "CALL:AC/PI",
        "INFO:11,52,94,FD20,FD22,M4,RES1,RESC\nIN THE WOODLINE LIVE LINE DOWN 01/20/2013 00:1",
        "DATE:01/20/2013",
        "TIME:00:20:12",
        "CH:pos1");

    doTest("T31",
        "Hoke Co 911:110 SAGE CREEK DR* * * * 1754 GALATIA CHURCH RD* *** 70D* * EMD* * * * FD20,M3* * Line16=* Line17=* Line18=01/20/2013 00:00:23 : pos4 : DMELTON1918 ** EMD Case Complete ** Key Questions: 9 year old, Male, Unconscious, Breathing.",
        "ADDR:110 SAGE CREEK DR",
        "X:1754 GALATIA CHURCH RD",
        "MAP:70D",
        "CALL:EMD",
        "INFO:FD20,M3\n9 year old, Male, Unconscious, Breathing.",
        "DATE:01/20/2013",
        "TIME:00:00:23",
        "CH:pos4");

    doTest("T32",
        "Hoke Co 911:345 BERWICK DR* * * * YORK CT* **SHEFFIELD CT* 65X* * EMD* * * * FD20* * Line16=* Line17=* Line18=01/19/2013 22:17:19 : pos4 : DMELTON1918 Cross streets: YORK CT//SHEFFIELD CT NBH: RIDGE MANOR S/D*",
        "ADDR:345 BERWICK DR",
        "X:YORK CT & SHEFFIELD CT",
        "MAP:65X",
        "CALL:EMD",
        "INFO:FD20\nNBH: RIDGE MANOR S/D",
        "DATE:01/19/2013",
        "TIME:22:17:19",
        "CH:pos4");

    doTest("T33",
        "Hoke Co 911:102 BELTONS LOOP* * * * 6669 PITTMAN GROVE CHURCH* *** 75A* * EMD* * * * FD20,M2* * Line16=* Line17=* Line18=01/19/2013 13:35:33 : pos4 : DMELTON1918 ** EMD Case Complete ** Key Questions: 40 year old, Female, Unconscious, Breat",
        "ADDR:102 BELTONS LOOP",
        "X:6669 PITTMAN GROVE CHURCH",
        "MAP:75A",
        "CALL:EMD",
        "INFO:FD20,M2\n40 year old, Female, Unconscious, Breat",
        "DATE:01/19/2013",
        "TIME:13:35:33",
        "CH:pos4");

    doTest("T34",
        "Hoke Co 911:561 MUMFORD RD* B* * * WILDLIFE LN* **BEARD RD* 75A* * EMD* * * * FD20,M3* * Line16=* Line17=* Line18=01/19/2013 09:09:54 : pos1 : RMUNGUIA5433 Cross streets: WILDLIFE LN//BEARD RD*",
        "ADDR:561 MUMFORD RD",
        "APT:B",
        "X:WILDLIFE LN & BEARD RD",
        "MAP:75A",
        "CALL:EMD",
        "INFO:FD20,M3",
        "DATE:01/19/2013",
        "TIME:09:09:54",
        "CH:pos1");

    doTest("T35",
        "Hoke Co 911:205 BONNEY LN* * * * 585 CORSEGAN RD* **DEAD END* 71L* * DOMESTIC INP* * * * 33,FD20,M3,S16* * Line16=* Line17=* Line18=01/19/2013 02:50:35 : pos1 : LGRADY7274 25YOF INJURY TO SIDE AND SHOULDER ROAD RASH ROUTINE 01/19/2013 02:40",
        "ADDR:205 BONNEY LN",
        "X:585 CORSEGAN RD & DEAD END",
        "MAP:71L",
        "CALL:DOMESTIC INP",
        "INFO:33,FD20,M3,S16\n25YOF INJURY TO SIDE AND SHOULDER ROAD RASH ROUTINE 01/19/2013 02:40",
        "DATE:01/19/2013",
        "TIME:02:50:35",
        "CH:pos1");

    doTest("T36",
        "Hoke Co 911:520 CAMDEN RD* * * * STONEWALL ST* **REGENCY DR* 75B* * EMD* * * * FD20,M2* * Line16=* Line17=* Line18=01/17/2013 21:53:21 : pos2 : RMUNGUIA5433 Cross streets: STONEWALL ST//REGENCY DR NBH: ROCKFISH*",
        "ADDR:520 CAMDEN RD",
        "X:STONEWALL ST & REGENCY DR",
        "MAP:75B",
        "CALL:EMD",
        "INFO:FD20,M2\nNBH: ROCKFISH",
        "DATE:01/17/2013",
        "TIME:21:53:21",
        "CH:pos2");

    doTest("T37",
        "Hoke Co 911:118 ZANE DR* * * * 113 SOUTHERN OAKS DR* **DEAD END* 70O* * EMD* * * * * * Line16=* Line17=* Line18=01/16/2013 18:16:02 : pos2 : RCRUMPLER3351 202 ONSCENE 01/16/2013 18:15:44 : pos2 : RCRUMPLER3351 ** EMD Case Complete ** Key Qu",
        "ADDR:118 ZANE DR",
        "X:113 SOUTHERN OAKS DR & DEAD END",
        "MAP:70O",
        "CALL:EMD",
        "INFO:202 ONSCENE\nKey Qu",
        "DATE:01/16/2013",
        "TIME:18:16:02",
        "CH:pos2");

    doTest("T38",
        "Hoke Co 911:118 ZANE DR* * * * 113 SOUTHERN OAKS DR* **DEAD END* 70O* * EMD* * * * * * Line16=* Line17=* Line18=01/16/2013 18:15:44 : pos2 : RCRUMPLER3351 ** EMD Case Complete ** Key Questions: 30 year old, Female, Conscious, Breathing. 01/",
        "ADDR:118 ZANE DR",
        "X:113 SOUTHERN OAKS DR & DEAD END",
        "MAP:70O",
        "CALL:EMD",
        "INFO:30 year old, Female, Conscious, Breathing. 01/",
        "DATE:01/16/2013",
        "TIME:18:15:44",
        "CH:pos2");

    doTest("T39",
        "Hoke Co 911:213 WELSH RD* * * * 663 TC JONES RD* **DEAD END* 70X* * 31 UNCON/FAI* * * * * * Line16=* Line17=* Line18=01/16/2013 16:47:45 : pos2 : RCRUMPLER3351 Cross streets: 663 TC JONES RD//DEAD END DIS 1505 ENR 1506 20 ONSCENE 1511 M1 ON",
        "ADDR:213 WELSH RD",
        "X:663 TC JONES RD & DEAD END",
        "MAP:70X",
        "CALL:31 UNCON/FAI",
        "INFO:DIS 1505 ENR 1506 20 ONSCENE 1511 M1 ON",
        "DATE:01/16/2013",
        "TIME:16:47:45",
        "CH:pos2");

    doTest("T40",
        "Hoke Co 911:194 HICKORY DR* * * * * **ASSAULT* * * * * * * * 01/16/2013 01:28:34 : pos1 : LGRADY7274 13 NEED EMS ROUTINE HEAD INJURY 01/16/2013 01:18:36 : pos1 : LGRADY7274 Cross streets: 4770 PITTMAN GROVE CHURCH//700 DOGWOOD LN 01/16/2013",
        "ADDR:194 HICKORY DR",
        "X:ASSAULT",
        "INFO:13 NEED EMS ROUTINE HEAD INJURY\n01/16/2013",
        "DATE:01/16/2013",
        "TIME:01:28:34",
        "CH:pos1");

    doTest("T41",
        "Hoke Co 911:194 HICKORY DR* * * * * **17 FALLS* * * * * * * * 01/13/2013 21:10:58 : pos1 : SGRAHAM9861 ** EMD Case Complete ** Key Questions: 63 year old, Female, Conscious, Breathing. 01/13/2013 21:10:49 : pos4 : CROWLAND4749 FD202 01/13/2",
        "ADDR:194 HICKORY DR",
        "X:17 FALLS",
        "INFO:63 year old, Female, Conscious, Breathing.\nFD202 01/13/2",
        "DATE:01/13/2013",
        "TIME:21:10:58",
        "CH:pos1");

    doTest("T42",
        "Hoke Co 911:194 HICKORY DR* * * * * **EMD* * * * * * * * 01/13/2013 21:09:35 : pos1 : SGRAHAM9861 Cross streets: 4770 PITTMAN GROVE CHURCH//700 DOGWOOD LN*",
        "ADDR:194 HICKORY DR",
        "X:EMD",
        "DATE:01/13/2013",
        "TIME:21:09:35",
        "CH:pos1");

    doTest("T43",
        "Hoke Co 911:527 SUNSET LAKE RD* * * * * **EMD* * * * * * * * 01/12/2013 20:35:55 : pos2 : RMUNGUIA5433 ** EMD Recommended Dispatch ** Response Text: Delta Dispatch Level: 19D04 CAD Incident Code: 19D04 Key Questions: 1.She is completely ale",
        "ADDR:527 SUNSET LAKE RD",
        "X:EMD",
        "INFO:Delta Dispatch Level: 19D04 CAD Incident Code: 19D04 / 1.She is completely ale",
        "DATE:01/12/2013",
        "TIME:20:35:55",
        "CH:pos2");

    doTest("T44",
        "Hoke Co 911:572 TC JONES RD* * * * * **EMD* * * * * * * * 01/12/2013 14:46:00 : pos1 : rfairbanks1339 Cross streets: LEDEZMA DR//WELSH RD*",
        "ADDR:572 TC JONES RD",
        "X:EMD",
        "DATE:01/12/2013",
        "TIME:14:46:00",
        "CH:pos1");

    doTest("T45",
        "Hoke Co 911:385 SUNSET LAKE RD* * * * * **EMD* * * * * * * * 01/11/2013 21:47:37 : pos2 : RMUNGUIA5433 Cross streets: 7100 ARABIA RD//DEAD END*",
        "ADDR:385 SUNSET LAKE RD",
        "X:EMD",
        "DATE:01/11/2013",
        "TIME:21:47:37",
        "CH:pos2");

    doTest("T46",
        "Hoke Co 911:4498 PITTMAN GROVE CHURCH RD* * * * * **EMD* * * * * * * * 01/11/2013 15:05:00 : pos1 : rfairbanks1339 ** EMD Key Questions Finished ** Key Questions: 6.She has had a heart attack before. 7.She took a prescribed medication in th",
        "ADDR:4498 PITTMAN GROVE CHURCH RD",
        "X:EMD",
        "INFO:** EMD Key Questions Finished ** / 6.She has had a heart attack before. 7.She took a prescribed medication in th",
        "DATE:01/11/2013",
        "TIME:15:05:00",
        "CH:pos1");

  }
  
  @Test
  public void testHilcrestFire() {

    doTest("T1",
        "Hoke Co 911:2909 HWY 401 BUSINESS* * * * 813 SCURLOCK SCHOOL RD* **HAZEL LN* 68J* * FIREALARM* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:2909 HWY 401 BUSINESS",
        "X:813 SCURLOCK SCHOOL RD & HAZEL LN",
        "MAP:68J",
        "CALL:FIREALARM");

    doTest("T2",
        "Hoke Co 911:4248 FAYETTEVILLE RD* * * * WOODBRIDGE DR* **HWY 401 BUSINESS* 63Y* * FIRERS* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:4248 FAYETTEVILLE RD",
        "X:WOODBRIDGE DR & HWY 401 BUSINESS",
        "MAP:63Y",
        "CALL:FIRERS");

    doTest("T3",
        "Hoke Co 911:601 SCOTT CURRIE RD* * * * 1301 RED SPRINGS RD* **1828 OAKDALE GIN RD* 73C* * FIREGRASS* * * * * * Line16=* Line17=* Line18=01/31/2013 15:24:01 : pos2 : RCRUMPLER3351 Cross streets: 1301 RED SPRINGS RD//1828 OAKDALE GIN RD Landm",
        "ADDR:601 SCOTT CURRIE RD",
        "X:1301 RED SPRINGS RD & 1828 OAKDALE GIN RD",
        "MAP:73C",
        "CALL:FIREGRASS",
        "INFO:Landm",
        "DATE:01/31/2013",
        "TIME:15:24:01",
        "CH:pos2");

    doTest("T4",
        "Hoke Co 911:4702 FAYETTEVILLE RD* * * * CLUB POND RD* **NORTHWOODS DR* 64U* * FIREALARM* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:4702 FAYETTEVILLE RD",
        "X:CLUB POND RD & NORTHWOODS DR",
        "MAP:64U",
        "CALL:FIREALARM");

    doTest("T5",
        "Hoke Co 911:108 MEADOW WOOD DR* * * * 2643 HWY 401 BUSINESS* **DEAD END* 68I* * FIREWOODS* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:108 MEADOW WOOD DR",
        "X:2643 HWY 401 BUSINESS & DEAD END",
        "MAP:68I",
        "CALL:FIREWOODS");

    doTest("T6",
        "Hoke Co 911:PHILLIPI CHURCH RD* * * * 1232 ROCKFISH RD* **HUCKABEE ST* 69K* * AC/PD* * * * * * Line16=* Line17=* Line18=01/29/2013 16:47:10 : pos2 : TGESSLER0782 male is laying on the ground no moving 01/29/2013 16:42:44 : pos2 : TGESSLER07",
        "ADDR:PHILLIPI CHURCH RD",
        "MADDR:PHILLIPI CHURCH RD & ROCKFISH RD",
        "X:1232 ROCKFISH RD & HUCKABEE ST",
        "MAP:69K",
        "CALL:AC/PD",
        "INFO:male is laying on the ground no moving",
        "DATE:01/29/2013",
        "TIME:16:47:10",
        "CH:pos2");

    doTest("T7",
        "Hoke Co 911:HILLCREST DR* * * * 2887 HWY 401 BUSINESS* **T AND K MHP* 68J* * FIRESMOKE* * * * * * Line16=* Line17=* Line18=01/28/2013 17:56:24 : pos2 : TGESSLER0782 Cross streets: 2887 HWY 401 BUSINESS//T AND K MHP Geo Comment: BESIDE HILLC",
        "ADDR:HILLCREST DR",
        "MADDR:HILLCREST DR & HWY 401 BUSINESS",
        "X:2887 HWY 401 BUSINESS & T AND K MHP",
        "MAP:68J",
        "CALL:FIRESMOKE",
        "INFO:BESIDE HILLC",
        "DATE:01/28/2013",
        "TIME:17:56:24",
        "CH:pos2");

    doTest("T8",
        "Hoke Co 911:513 PHILLIPI CHURCH RD* * * * OLD FOREST RD* **MILL PK* 69L* * FIREELEC* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:513 PHILLIPI CHURCH RD",
        "X:OLD FOREST RD & MILL PK",
        "MAP:69L",
        "CALL:FIREELEC");

    doTest("T9",
        "Hoke Co 911:1860 HWY 401 BUSINESS* * * * AZALEA ST* **BROAD DR* 68M* * AC/PI* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:1860 HWY 401 BUSINESS",
        "X:AZALEA ST & BROAD DR",
        "MAP:68M",
        "CALL:AC/PI");

    doTest("T10",
        "Hoke Co 911:4400 FAYETTEVILLE RD* * * * HWY 401 BUSINESS* **CLUB POND RD* 63Y* * POWERLINE* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:4400 FAYETTEVILLE RD",
        "X:HWY 401 BUSINESS & CLUB POND RD",
        "MAP:63Y",
        "CALL:POWERLINE");

    doTest("T11",
        "Hoke Co 911:200 RANIER DR* * * * 338 FAIRFIELD CIR* *** 65R* * FIREELEC* * * * * * Line16=* Line17=* Line18=01/24/2013 20:23:57 : pos2 : SCOOPER9403 Cross streets: 338 FAIRFIELD CIR// NBH: WESTGATE S/D CAN SMELL ELECTRICAL BURNING*",
        "ADDR:200 RANIER DR",
        "X:338 FAIRFIELD CIR",
        "MAP:65R",
        "CALL:FIREELEC",
        "INFO:NBH: WESTGATE S/D CAN SMELL ELECTRICAL BURNING",
        "DATE:01/24/2013",
        "TIME:20:23:57",
        "CH:pos2");

    doTest("T12",
        "Hoke Co 911:400 NEW LN* * * * 1746 HAIRE RD* *** 73I* * FIREHOUSE* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:400 NEW LN",
        "X:1746 HAIRE RD",
        "MAP:73I",
        "CALL:FIREHOUSE");

    doTest("T13",
        "Hoke Co 911:204 HILLCREST DR* * * * 2887 HWY 401 BUSINESS* **T AND K MHP* 68J* * FIREALARM* * * * FD1* * Line16=* Line17=* Line18=01/22/2013 07:51:13 : pos1 : rfairbanks1339 Cross streets: 2887 HWY 401 BUSINESS//T AND K MHP Geo Comment: BES",
        "ADDR:204 HILLCREST DR",
        "X:2887 HWY 401 BUSINESS & T AND K MHP",
        "MAP:68J",
        "CALL:FIREALARM",
        "INFO:FD1\nBES",
        "DATE:01/22/2013",
        "TIME:07:51:13",
        "CH:pos1");

    doTest("T14",
        "Hoke Co 911:439 GREENTREE DR* * * * 473 FOREST WOODS DR* **SCARLET OAK DR* 65M* * FIREHOUSE* * * * FD1,FD3,M4,RESC* * Line16=* Line17=* Line18=01/21/2013 18:37:32 : pos1 : rfairbanks1339 Cross streets: 473 FOREST WOODS DR//SCARLET OAK DR NB",
        "ADDR:439 GREENTREE DR",
        "X:473 FOREST WOODS DR & SCARLET OAK DR",
        "MAP:65M",
        "CALL:FIREHOUSE",
        "INFO:FD1,FD3,M4,RESC",
        "DATE:01/21/2013",
        "TIME:18:37:32",
        "CH:pos1");

    doTest("T15",
        "Hoke Co 911:400 CELTIC CT* * * * 620 PHILLIPI CHURCH RD* **DEAD END* 69L* * FIREVEHICLE* * * * FD1* * Line16=* Line17=* Line18=01/21/2013 14:26:43 : pos4 : CROWLAND4749 Cross streets: 620 PHILLIPI CHURCH RD//DEAD END NBH: POSS HARTS MHP ?*",
        "ADDR:400 CELTIC CT",
        "X:620 PHILLIPI CHURCH RD & DEAD END",
        "MAP:69L",
        "CALL:FIREVEHICLE",
        "INFO:FD1\nNBH: POSS HARTS MHP ?",
        "DATE:01/21/2013",
        "TIME:14:26:43",
        "CH:pos4");

    doTest("T16",
        "Hoke Co 911:1945 JOHNSON MILL RD* * * * CITADEL CT* **PITTMAN GROVE CHURCH RD* 64S* * FIREALARM* * * * FD1,FD31* * Line16=* Line17=* Line18=01/20/2013 16:14:41 : pos4 : DMELTON1918 Cross streets: CITADEL CT//PITTMAN GROVE CHURCH RD FORYER S",
        "ADDR:1945 JOHNSON MILL RD",
        "X:CITADEL CT & PITTMAN GROVE CHURCH RD",
        "MAP:64S",
        "CALL:FIREALARM",
        "INFO:FD1,FD31\nFORYER S",
        "DATE:01/20/2013",
        "TIME:16:14:41",
        "CH:pos4");

    doTest("T17",
        "Hoke Co 911:100 CLUB POND RD* * * * 311 PHILLIPI CHURCH RD* **1470 ROCKFISH RD* 69K* * AC/PI* * * * FD1* * Line16=* Line17=* Line18=01/19/2013 13:17:41 : pos4 : DMELTON1918 Cross streets: 311 PHILLIPI CHURCH RD//1470 ROCKFISH RD NBH: SCURLO",
        "ADDR:100 CLUB POND RD",
        "X:311 PHILLIPI CHURCH RD & 1470 ROCKFISH RD",
        "MAP:69K",
        "CALL:AC/PI",
        "INFO:FD1\nNBH: SCURLO",
        "DATE:01/19/2013",
        "TIME:13:17:41",
        "CH:pos4");

    doTest("T18",
        "Hoke Co 911:4002 FAYETTEVILLE RD* * * * TENNESSEE WALKER DR* **RILEY ST* 63Y* * AC/PI* * * * FD1,RESC* * Line16=* Line17=* Line18=01/18/2013 19:19:15 : pos4 : DMELTON1918 Cross streets: TENNESSEE WALKER DR//RILEY ST Landmark: RED DOOR HOMES",
        "ADDR:4002 FAYETTEVILLE RD",
        "X:TENNESSEE WALKER DR & RILEY ST",
        "MAP:63Y",
        "CALL:AC/PI",
        "INFO:FD1,RESC",
        "DATE:01/18/2013",
        "TIME:19:19:15",
        "CH:pos4",
        "PLACE:RED DOOR HOMES");
   
  }
  
  @Test
  public void testWestHokeFireDept() {

    doTest("T1",
        "Hoke Co 911:100 RYAN MCBRYDE RD* * * * 6301 LAURINBURG RD* **2229 EDINBURGH RD* 72I* * AC/PI* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:100 RYAN MCBRYDE RD",
        "X:6301 LAURINBURG RD & 2229 EDINBURGH RD",
        "MAP:72I",
        "CALL:AC/PI");

    doTest("T2",
        "Hoke Co 911:1691 CALLOWAY RD* * * * SUMNER LN* **BAMA LN* 61N* * FIREFIELD* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:1691 CALLOWAY RD",
        "X:SUMNER LN & BAMA LN",
        "MAP:61N",
        "CALL:FIREFIELD");

    doTest("T3",
        "Hoke Co 911:4011 FULFORD MCMILLAN RD* * * * L MCLAUGHLIN RD* **NORTON RD* 61W* * FIREELEC* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:4011 FULFORD MCMILLAN RD",
        "X:L MCLAUGHLIN RD & NORTON RD",
        "MAP:61W",
        "CALL:FIREELEC");

    doTest("T4",
        "Hoke Co 911:619 MCGILVARY LN* * * * 1504 NEILL SINCLAIR RD* **DEAD END* 61Q* * FIREHOUSE* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:619 MCGILVARY LN",
        "X:1504 NEILL SINCLAIR RD & DEAD END",
        "MAP:61Q",
        "CALL:FIREHOUSE");

    doTest("T5",
        "Hoke Co 911:2291 GAINEY RD* * * * FULFORD MCMILLAN RD* **PLATT RD* 72C* * FIREBRUSH* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:2291 GAINEY RD",
        "X:FULFORD MCMILLAN RD & PLATT RD",
        "MAP:72C",
        "CALL:FIREBRUSH");

    doTest("T6",
        "Hoke Co 911:8000 LAURINBURG RD* * * * N HILLTOP RD* **EDINBURGH RD* 72M* * AC/PI* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:8000 LAURINBURG RD",
        "X:N HILLTOP RD & EDINBURGH RD",
        "MAP:72M",
        "CALL:AC/PI");

    doTest("T7",
        "Hoke Co 911:497 EQUESTRIAN WAY* * * * 5497 ABERDEEN RD* **HOME STRETCH LN* 61I* * FIREALARM* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:497 EQUESTRIAN WAY",
        "X:5497 ABERDEEN RD & HOME STRETCH LN",
        "MAP:61I",
        "CALL:FIREALARM");

    doTest("T8",
        "Hoke Co 911:1170 GAINEY RD* * * * TYEHIMBA LN* **TODD LN* 72M* * FIREGRASS* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:1170 GAINEY RD",
        "X:TYEHIMBA LN & TODD LN",
        "MAP:72M",
        "CALL:FIREGRASS");

    doTest("T9",
        "Hoke Co 911:322 S HORACE WALTERS RD* * * * 9062 TURNPIKE RD* **DEAD END* 61U* * FIREHOUSE* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:322 S HORACE WALTERS RD",
        "X:9062 TURNPIKE RD & DEAD END",
        "MAP:61U",
        "CALL:FIREHOUSE");

    doTest("T10",
        "Hoke Co 911:233 STUBBS RD* * * * 7220 LAURINBURG RD* **480 GAINEY RD* 72M* * FIREALARM* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:233 STUBBS RD",
        "X:7220 LAURINBURG RD & 480 GAINEY RD",
        "MAP:72M",
        "CALL:FIREALARM");

    doTest("T11",
        "Hoke Co 911:100 HECTOR MCNEILL RD* * * * 6600 LAURINBURG RD* **690 GAINEY RD* 72M* * FIREBRUSH* * * * FD5* * Line16=* Line17=* Line18=01/23/2013 12:14:21 : pos4 : DMELTON1918 HECTOR MCNEILL RD//6600 LAURINBURG RD*",
        "ADDR:100 HECTOR MCNEILL RD",
        "X:6600 LAURINBURG RD & 690 GAINEY RD",
        "MAP:72M",
        "CALL:FIREBRUSH",
        "INFO:FD5\nHECTOR MCNEILL RD//6600 LAURINBURG RD",
        "DATE:01/23/2013",
        "TIME:12:14:21",
        "CH:pos4");

  }
  
  @Test
  public void testPuppyCreekFireDepartment() {

    doTest("T1",
        "Hoke Co 911:104 MIDWAY DR* * * * FAYETTEVILLE RD* **COOL BREEZE DR* 65F* * AC/PI* * * * * * Line16=* Line17=* Line18=*\n",
        "ADDR:104 MIDWAY DR",
        "X:FAYETTEVILLE RD & COOL BREEZE DR",
        "MAP:65F",
        "CALL:AC/PI");

    doTest("T2",
        "Hoke Co 911:504 OLD PARKER FARM RD* * * * 692 WAYSIDE RD* **DEAD END* 65G* * 06 BREATH PR* * * * * * Line16=* Line17=* Line18=*\n",
        "ADDR:504 OLD PARKER FARM RD",
        "X:692 WAYSIDE RD & DEAD END",
        "MAP:65G",
        "CALL:06 BREATH PR");

    doTest("T3",
        "Hoke Co 911:203 FALLINGLEAF DR* * * * BLUE WATER DR* **CAMROSE CT* 64C* * FIREALARM* * * * * * Line16=* Line17=* Line18=*\n",
        "ADDR:203 FALLINGLEAF DR",
        "X:BLUE WATER DR & CAMROSE CT",
        "MAP:64C",
        "CALL:FIREALARM");

    doTest("T4",
        "Hoke Co 911:131 SPRING VALLEY DR* * * * 1305 S PARKER CHURCH RD* *** 69E* * FIREALARM* * * * * * Line16=* Line17=* Line18=*\n",
        "ADDR:131 SPRING VALLEY DR",
        "X:1305 S PARKER CHURCH RD",
        "MAP:69E",
        "CALL:FIREALARM");

    doTest("T5",
        "Hoke Co 911:1000 TOWNSEND RD* * * * WILLA MAE LN* **JOHNSON MILL RD* 69C* * AC/PI* * * * * * Line16=* Line17=* Line18=*\n",
        "ADDR:1000 TOWNSEND RD",
        "X:WILLA MAE LN & JOHNSON MILL RD",
        "MAP:69C",
        "CALL:AC/PI");

    doTest("T6",
        "Hoke Co 911:336 SOMERSET DR* * * * BLUE WATER DR* **FALLINGLEAF DR* 64C* * FIREALARM* * * * * * Line16=* Line17=* Line18=*\n",
        "ADDR:336 SOMERSET DR",
        "X:BLUE WATER DR & FALLINGLEAF DR",
        "MAP:64C",
        "CALL:FIREALARM");

    doTest("T7",
        "Hoke Co 911:448 WOOD VALLEY LN* * * * 3682 ROCKFISH RD* **239 BECKMAN PL* 69J* * FIREALARM* * * * * * Line16=* Line17=* Line18=*\n",
        "ADDR:448 WOOD VALLEY LN",
        "X:3682 ROCKFISH RD & 239 BECKMAN PL",
        "MAP:69J",
        "CALL:FIREALARM");

    doTest("T8",
        "Hoke Co 911:2508 DANAHEY DR* * * * 2417 O`HARA DR* **O`GLESBY DR* 65A* * FIREVEHICLE* * * * * * Line16=* Line17=* Line18=*\n",
        "ADDR:2508 DANAHEY DR",
        "X:2417 O`HARA DR & O`GLESBY DR",
        "MAP:65A",
        "CALL:FIREVEHICLE");

    doTest("T9",
        "Hoke Co 911:5073 ROCKFISH RD* * * * PITTMAN GROVE CHURCH RD* **GALATIA CHURCH RD* 70G* * AC/PI* * * * * * Line16=* Line17=* Line18=01/31/2013 07:45:08 : pos2 : RCRUMPLER3351 Cross streets: PITTMAN GROVE CHURCH RD//GALATIA CHURCH RD Landmark\n",
        "ADDR:5073 ROCKFISH RD",
        "X:PITTMAN GROVE CHURCH RD & GALATIA CHURCH RD",
        "MAP:70G",
        "CALL:AC/PI",
        "INFO:Landmark",
        "DATE:01/31/2013",
        "TIME:07:45:08",
        "CH:pos2");

    doTest("T10",
        "Hoke Co 911:1401 DARBY DR* * * * 111 CLAN CAMPBELL DR* **O'BANNON DR* 65A* * TREE DOWN* * * * * * Line16=* Line17=* Line18=*\n",
        "ADDR:1401 DARBY DR",
        "X:111 CLAN CAMPBELL DR & O'BANNON DR",
        "MAP:65A",
        "CALL:TREE DOWN");

    doTest("T11",
        "Hoke Co 911:100 HOBSON CT* * * * 1151 HOBSON RD* **DEAD END* 64D* * AC/PI* * * * * * Line16=* Line17=* Line18=01/29/2013 16:01:53 : pos4 : DMELTON1918 HOBSON CT//1151 HOBSON RD NBH: HOBSON PLACE S/D Landmark: READY MIX CONCRETE Cross street\n",
        "ADDR:100 HOBSON CT",
        "X:1151 HOBSON RD & DEAD END",
        "MAP:64D",
        "CALL:AC/PI",
        "INFO:HOBSON CT//1151 HOBSON RD / NBH: HOBSON PLACE S/D",
        "DATE:01/29/2013",
        "TIME:16:01:53",
        "CH:pos4",
        "PLACE:READY MIX CONCRETE Cross street");

    doTest("T12",
        "Hoke Co 911:9615 FAYETTEVILLE RD* * * * FOREST WOODS RD* **WAYSIDE RD* 65H* * AC/PI* * * * * * Line16=* Line17=* Line18=01/29/2013 14:20:00 : pos3 : TGESSLER0782 Cross streets: FOREST WOODS RD//WAYSIDE RD Landmark: BP 104 1 FEMALE AND CHILD\n",
        "ADDR:9615 FAYETTEVILLE RD",
        "X:FOREST WOODS RD & WAYSIDE RD",
        "MAP:65H",
        "CALL:AC/PI",
        "DATE:01/29/2013",
        "TIME:14:20:00",
        "CH:pos3",
        "PLACE:BP 104 1 FEMALE AND CHILD");

    doTest("T13",
        "Hoke Co 911:399 FAIRFIELD CIR* * * * 100 THORNCLIFF DR* *** 65R* * AC/PI* * * * * * Line16=* Line17=* Line18=01/29/2013 13:12:22 : pos3 : TGESSLER0782 Cross streets: 100 THORNCLIFF DR// Geo Comment: CIRCLES BACK ONTO ITSELF AT THORNCLIFF DR\n",
        "ADDR:399 FAIRFIELD CIR",
        "X:100 THORNCLIFF DR",
        "MAP:65R",
        "CALL:AC/PI",
        "INFO:CIRCLES BACK ONTO ITSELF AT THORNCLIFF DR",
        "DATE:01/29/2013",
        "TIME:13:12:22",
        "CH:pos3");

    doTest("T14",
        "Hoke Co 911:520 DUNROBIN DR* * * * 534 MCDOUGALD DR* **MCDOUGALD DR* 58U* * FIREALARM* * * * * * Line16=* Line17=* Line18=01/25/2013 17:27:18 : pos2 : RCRUMPLER3351 Cross streets: 534 MCDOUGALD DR//MCDOUGALD DR NBH: MCDOUGALD DOWNS S/D HALL\n",
        "ADDR:520 DUNROBIN DR",
        "X:534 MCDOUGALD DR & MCDOUGALD DR",
        "MAP:58U",
        "CALL:FIREALARM",
        "INFO:NBH: MCDOUGALD DOWNS S/D HALL",
        "DATE:01/25/2013",
        "TIME:17:27:18",
        "CH:pos2");
    
  }


  public static void main(String[] args) {
    new NCHokeCountyParserTest().generateTests("T1");
  }
}
