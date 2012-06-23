package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
This has been identified as Interact GIS system
And as CAD Interactive
Go Figure

Date County, GA
DADE COUNTY 911:M10 >CHEST PAIN 367 GRAY RD XS: 224 FAWN DAWN DR. NEW SALEM KATY DILLS Map:10-D1,E1 Grids:0,0 Cad: 2011-0000000796
DADE COUNTY 911:M26 >SICK PERSON 391 BIBLE GULF RD XS: 869 TATUM GULF RD OFF OLD STATE RD HEAD RIVER KEATON, GLENN Map:12-D2 Grids:0,0 Cad: 2011-0000000651
DADE COUNTY 911:M5 >FALL - ANY 2862 YANKEE RD XS: HWY 157 S HEAD RIVER KEENER, CAROL Map:11,12 Grids:0,0 Cad: 2011-0000001152
DADE COUNTY 911:50PI >M.V.A. - POSSIBLE INJURIES 13500 HWY 136 E XS: N & S MOORE RD NEW SALEM ROBERTS, CHIP Map:6,15 Grids:0,0 Cad: 2011-0000000992
DADE COUNTY 911:M1 >ABDOMINAL PAIN/PROBLEM 2321 OLD STATE RD XS: 16548 HWY 157 S HEAD RIVER CHAD LANIER Map:11,12 Grids:0,0 Cad: 2011-0000001270
DADE COUNTY 911:78 >ASSISTANCE/ MUTUAL AID 84 RUSHING WATER TRL CHRISTY / WALKER Cad: 2011-0000001334

Harford, MD
[!] EOC:A1091 UNC >UNCONSCIOUS 2200 CHANNEL RD XS: X BIG BRANCH BRDG #127 PYLESVILLE CRIZER,KIM BOX: N08 Cad: 2010-0000162717
[!] EOC:A1091 SICK >SICK PERSON 1606 SCOTT RD XS: X FAWN GROVE RD PYLESVILLE BATCHELDER,MICHELLE BOX: N04 Cad: 2010-0000162427
[!] EOC:A1091 DIAB >DIABETIC EMRG. 2145 HARKINS RD XS: SAINT PAULS CHURCH RD PYLESVILLE ROHREAUGH,KEN BOX: N04 Cad: 2010-0000162445
[!] EOC:E1011 MISC >MISC 4873 CAREA RD XS: X WALNUT SPRING CT WHITE HALL SHERBS,ROBERT BOX: N08 Cad: 2010-0000162395
[!] EOC:A1091 MVA >MV ACCIDENT W/INJURY SRT24&SAINT MARYS RD XS: SAINT MARYS RD PYLESVILLE DEDRICK.PATTI Cad: 2010-0000162161
[!] EOC:E1011 MVA >MV ACCIDENT W/INJURY SRT24&SAINT MARYS RD XS: SAINT MARYS RD PYLESVILLE DEDRICK.PATTI Cad: 2010-0000162161
[!] EOC:F03 BUILD >BUILDING FIRE 21 EASTERN AVE XS: S MAIN ST BEL AIR LEBRUN,MARLEEN BOX: 302 Cad: 2010-0000195539
Subject:HCCAD\n[!] EOC:F03 WIRES >WIRES/POLE SHAWNEE DR&WALTERS MILL RD XS: WALTERS MILL RD FOREST HILL NOT ENTERED Cad: 2010-000019169

Greene County, NY
GREENE 911:WIRES >WIRES DOWN / ARCING 117 RIVER RD ATHENS BRAUMULLER, HELENE Map: Grids:0,0 Cad: 2010-0000033052
GREENE 911:ALARMF>FIRE ALARM 558 SLEEPY HOLLOW RD ATHENS ADT SECURITY-OP ANDREA- Map:62 Grids:0,0 Cad: 2010-0000033344

Daviess County, KY
911-CENTER:MBD >BREATHING DIFFICULTY 6261 MILLERS MILL RD XS: HIGHWAY 142 PHILPOT MARTIN Map: Grids:, Cad: 2011-0000013315
911-CENTER:ACCINJ>ACCIDENT WITH INJURIES 3970 CRANE POND RD XS: U S HIGHWAY 231 PHILPOT JOHNS, AMY Map: Grids:, Cad: 2011-0000013291
911-CENTER:FF >WILDLAND FIRE 9707 OLD HARTFORD RD XS: U S HIGHWAY 231 UTICA KIPLING, ED Map: Grids:, Cad: 2011-0000013076
911-CENTER:FF >WILDLAND FIRE 12957 RED HILL-MAXWELL RD XS: E HARMONS FERRY RD UTICA PRESSON, DAVID Map: Grids:, Cad: 2011-0000012778
911-CENTER:FF >WILDLAND FIRE 9707 OLD HARTFORD RD XS: U S HIGHWAY 231 UTICA KIPLING, ED Map: Grids:, Cad: 2011-0000013076
911-CENTER:ACCINJ>ACCIDENT WITH INJURIES 3970 CRANE POND RD XS: U S HIGHWAY 231 PHILPOT JOHNS, AMY Map: Grids:, Cad: 2011-0000013291
911-CENTER:MBD >BREATHING DIFFICULTY 6261 MILLERS MILL RD XS: HIGHWAY 142 PHILPOT MARTIN Map: Grids:, Cad: 2011-0000013315
911-CENTER:MPD >UNKNOWN/PERSON DOWN 4255 NEW HARTFORD RD XS: NEAR SOUTHEASTERN PKY OWENSBORO DAVIESS COUNTY BOARD OF EDUCAT Map: Grids:, Cad: 2011-0000013349
911-CENTER:FF >WILDLAND FIRE 2324 HARRIET LN XS: OLD HARTFORD RD OWENSBORO HUTCHINSON, G & M Map: Grids:, Cad: 2011-0000013387
911-CENTER:MSTR >STROKE 3294 BELLTOWN RD XS: NEW BETHEL CHURCH LN HARTFORD Map: Grids:, Cad: 2011-0000013576
911-CENTER:MSZ >SEIZURES 4255 NEW HARTFORD RD XS: NEAR SOUTHEASTERN PKY OWENSBORO DAY, RUS Map: Grids:, Cad: 2011-0000013611

Herkimer County, NY 
(EMS   >EMS CALL) 185 GUIDEBOARD RD XS: DAIRY HILL RD NORWAY AAAAAAA AAAAAAA 3150000000 Map: Grids:, Cad: 2010-0000049305
(MVA   >MOTOR VEHICLE ACCIDENT) 5781 STHY 28 XS: TOWN LINE NEWPORT AAAAAA AAAAA 3150000000 Map: Grids:, Cad: 2010-0000049651
(EMS   >EMS CALL) 808 OLD STATE RD NEWPORT AAAAAAAA 8880000000 Map: Grids:, Cad: 2010-0000049432
(EMS   >EMS CALL) 3141 MECHANIC ST XS: MAIN ST NEWPORT VILLAGE JOHN 3157179999 Map: Grids:, Cad: 2010-0000058093
(EMS   >EMS CALL) 3746 BLACK CREEK RD Apt: C Bldg XS: TAYLOR BROOK RD RUSSIA SMITH, E 3158265805 Map: Grids:,Cad: 2010-0000058750
(FIREST>STRUCTURE FIRE) 1316 HARD SCRABBLE RD XS: BEGIN ESN 029 FAIRFIELD JONES, CORA 3158913818 Map: Grids:, Cad: 2010-0000060399
(LIFT  >LIFT ASSIST/NON EMER EMS) 3746 BLACK CREEK RD Apt: LOTC Bldg XS: TAYLOR BROOK RD RUSSIA JOHN SMITH 3158265805 Map: Grids:, Cad: 2010-0000064384
(EMS>EMS CALL) 112 N Main St\nGrids:,, NY X:Fairfield St\nMiddleville Village Smith, John\n5419991234 MAP:
(EMS>EMS CALL) 54 Fairfield St\nGrids:,, NY X:Fairfield St\nMiddleville Village Smith, John\n5419991234 MAP:
(LIFT>LIFT ASSIST/NON EMER EMS)\n112 N Main St Grids:,, NY\nX:Fairfield St Smith, John\n5419991234 MAP:

Macon County, NC
911 CENTER:88S >STRUCTURE FIRE REPORTED AT 1650 WIDE HORIZON DR FRANKLIN AAAAA, AAAAA 5555559999 Map: Grids:0,0
911 CENTER:90F >FIRE ALARM 120 RIVERVIEW ST FRANKLIN ANGEL MEDICAL CENTER 5555558411 Map: Grids:0,0
911 CENTER:88S >STRUCTURE FIRE REPORTED AT 289 SUTTON LN FRANKLIN AAAAA, AAAAAAA& AAAAAA 5555559999 Map: Grids:0,0
911 CENTER:MED >EMERGENCY RUN 248 HARRISON AVE XS: W MAIN ST TO BRYSON CITY RD FRANKLIN AAAAAA, CHARMAYNE 5555559999 Map: Grids:0,0
911 CENTER:C1 >EMERGENCY RUN 11 CHATTACHOEE LN FRANKLIN VERIZON WIRELESS 5555559999
911 CENTER:C1 >EMERGENCY RUN 236 PAULINE AVE XS: ULCO DR FRANKLIN AAAAA, AAAAAAA P 5555559999 Map: Grids:0,0
911 CENTER:88S >STRUCTURE FIRE REPORTED AT 1682 LEATHERMAN GAP RD FRANKLIN  AAA, ANGIE 5555559999 Map: Grids:0,0
911 CENTER:50 >VEHICLE ACCIDENT 837 GEORGIA RD FRANKLIN AAAAA 5555558237 Map: Grids:0,0
911 CENTER:C1 >EMERGENCY RUN 730 LAKESHORE DR FRANKLIN CHRISTIAN, JOHN SMITH 8285249999 Map: Grids:0,0
911 CENTER:88B >BRUSH FIRE REPORTED AT RADIO HILL RD FRANKLIN BLACKSTONE, SHORE 8285249991 Map: Grids:0,0
911 CENTER:C1 >EMERGENCY RUN 31 SCROGGS RD XS: LOUISA CHAPEL @ 1020 FRANKLIN VERIZON WIRELESS 8283713353 Map: Grids:0,0
911 CENTER:50 >VEHICLE ACCIDENT 428 COWEETA CHURCH RD OTTO SMITH, J 828369999 Map: Grids:0,0

Anderson County, SC
ANDERSON CO 911:29B1 >MVA-ALS PRI1 3814 N HIGHWAY 29 XS: BROOKS RD - DORCHESTER RD BELTON PLATINUM PLUS Map: Grids:0,0 Cad: 2011-0000004351
ANDERSON CO 911:29B4 >MVA-ALS PRI1 HIGHWAY 29 N MICHAEL QUEEN2214421 Cad: 2011-0000004070
ANDERSON CO 911:32 >UNKNOWN PROBLEM 1216 ROUND ABOUT TRL JOSH 201-4436 Cad: 2011-0000004370
ANDERSON CO 911:17B1 >FALLS-ALS PRI1-FR 110 FRANKLIN RD ANDERSON HAWKINS, PAUL Map: Grids:0,0 Cad: 2011-0000004223
ANDERSON CO 911:31 >UNCONSCIOUS/FAINTING 210 KIRK LN Apt: 11 Bldg PENDLETON6463347 MICHELLE DURHAM Map: Grids:0,0 Cad: 2011-0000004465
ANDERSON CO 911:13A1 >DIABETIC-ALS PRI2 7900 HIGHWAY 76 PENDLETON OFFICER SUMMERS 934-3443 Map: Grids:0,0 Cad: 2011-0000004494

Summer County, TN
INITIAL.\nSC EMS COMMUNICATIONS:42 >NON-SPECIFIC DIAGNOSIS 521 SHUTE LN XS: SHORESIDE DR HENDERSONVILLE  MIKE 6158249869 Map: Grids:0,0
INITIAL.\nSC EMS COMMUNICATIONS:50 >STROKE-CVA 114 MOONLIGHT DR HENDERSONVILLE AT&T MOBILITY 6153058788 Map: Grids:0,0
INITIAL.\nSC EMS COMMUNICATIONS:2 >FIRE ALARM 1109 LAKE RISE OVERLOOK HENDERSONVILLE L., JOHN 6158264086 Map: Grids:0,0
INITIAL.\nSC EMS COMMUNICATIONS:43 >OTHER-FIRE 209 BROOKHAVEN DR GALLATIN W., MYRA 6154529951 Map: Grids:0,0
INITIAL.\nSC EMS COMMUNICATIONS:32 >HAZARDOUS MATERIALS 2079 MORGANS WAY GALLATIN Map: Grids:0,0
INITIAL.\nSC EMS COMMUNICATIONS:10 >BREATHING PROBLEMS A 1080 BRADLEY RD GALLATIN E., ROGER D 6154528905 Map: Grids:0,0
INITIAL.\nSC EMS COMMUNICATIONS:2 >FIRE ALARM 1005 LAKE RISE PL HENDERSONVILLE HAY, BRUCE 6158262033 Map: Grids:0,0

Fayette County, Pennsylvania
FAYETTE-911:FACINJ>F-ACCIDENT W/ INJURIES VANCES MILL RD NORTH UNION WILSON PAUL 7249637757 Map: Grids:, Cad: 2011-0000029638
FAYETTE-911:ESCK_A>E SICK/UNKNOWN ALS 570 FLATWOODS RD XS: TOWN COUNTRY RD FRANKLIN ADAMS, J 7243980234 Map: Grids:, Cad: 2011-0000031363
FAYETTE-911:FACCNO>F_ACCIDENT NO INJURIES 1829 PITTSBURGH RD XS: RESERVOIR RD FRANKLIN HARPER, FRAN 4126910370 Map: Grids:, Cad: 2011-0000029521
FAYETTE-911:FACINJ>F-ACCIDENT W/ INJURIES VANCES MILL RD NORTH UNION WILSON PAUL 7249637757 Map: Grids:, Cad: 2011-0000029638
FAYETTE-911:FACINJ>F-ACCIDENT W/ INJURIES 2418 PITTSBURGH RD XS: RESERVOIR RD & BRADY LN FRANKLIN CHRIS 3046855898 Map: Grids:, Cad: 2011-0000029569
FAYETTE-911:EBRT_A>E_BREATHING ALS 1829 PITTSBURGH RD XS: RESERVOIR RD FRANKLIN DELBRIDGE JOY 7247106364 Map: Grids:, Cad: 2011-0000030505
FAYETTE-911:FACINJ>F-ACCIDENT W/ INJURIES BOLDEN RD XS: COOPER RD & PITTSBURGH RD FRANKLIN HIGGNS ERENST 7245526428 Cad: 2011-0000030796
FAYETTE-911:EBRT_A>E_BREATHING ALS 2527 PITTSBURGH RD FRANKLIN JOHNSON JULIE 7244157363 Map: Grids:, Cad: 2011-0000030936
FAYETTE-911:FTREE >F_TREE DOWN BUENA VISTA RD XS: FLATWOODS RD FRANKLIN THOMPSON KAREN 7248800052 Map: Grids:, Cad: 2011-0000031144
FAYETTE-911:FTREE >F_TREE DOWN BITNER RD XS: VANCES MILL RD & ROUND BARN RD FRANKLIN VERIZON WIRELESS 7248808596 Map: Grids:, Cad: 2011-0000031156
FAYETTE-911:ESCK_A>E SICK/UNKNOWN ALS 570 FLATWOODS RD XS: TOWN COUNTRY RD FRANKLIN ADAMS, J 7243980234 Map: Grids:, Cad: 2011-0000031363
FAYETTE-911:FTREE >F_TREE DOWN BITNER RD XS: VANCES MILL RD & ROUND BARN RD FRANKLIN ROSINSKI, SUSAN 7248802229 Map: Grids:, Cad: 2011-0000031167

Northampton County, NC
[e49]ALS >ADVANCED LIFE SUPPORT CALL 602 E 21ST ST Apt: 119 Bldg NORTHAMPTON DIANE ECK Map: Grids:0,0 Cad: 2011-0000086714
[e49]BLS >BASIC LIFE SUPPORT CALL 1323 NEWPORT AVE Apt: REAR Bldg NORTHAMPTON TONY FERRERA Map: Grids:0,0 Cad: 2011-00000
[e49]MVAI >MVA WITH INJURIES 248 AT PENNSVILLE LIGHT LEHIGH TWP NATALIE BRODIANO Cad: 2011-0000086361
[e49]ALS >ADVANCED LIFE SUPPORT CALL 612 E 10TH ST NORTHAMPTON ROBERTS PAMELA Map: Grids:0,0 Cad: 2011-0000086262
[e49]BLS >BASIC LIFE SUPPORT CALL 1001 WASHINGTON AVE Apt: 105 Bldg NORTHAMPTON MEGAN MOREY Map: Grids:0,0 Cad: 2011-000008
[e49]ALS >ADVANCED LIFE SUPPORT CALL 5962 KEYSTONE DR EAST ALLEN CHRISTINA WIGMER Map: Grids:0,0 Cad: 2011-0000086103
[e49]BLS >BASIC LIFE SUPPORT CALL 1323 NEWPORT AVE NORTHAMPTON TONY CABRERA Map: Grids:0,0 Cad: 2011-0000086010

Salem County, NJ
911-CENTER:06N >ALARM SYSTEM-NIGHT 40 EATON RD XS: LINCOLN DR AND S WASHINGTON DR PENNSVILLE TWP TC02 // MONITORING CENT 
911-CENTER:02 >STRUCTURE FIRE-MEDIUM HAZARD 429 N BROADWAY WAY XS: ROUTE 130 OVERPASS PENNSVILLE TWP KIM MILLER 3511754 
911-CENTER:41 >ALS 25 W PITTSFIELD ST XS: N BROADWAY PENNSVILLE TWP AMERICAN LEGION BROWN MOORE PO 6789801 Map: Grids:00 
911-CENTER:40 >BLS 9 HARVARD RD XS: FORT MOTT ROAD PENNSVILLE TWP JIM MCCLAGHLIN 3142134 Map: Grids: 00000 ,000 
911-CENTER:40 >BLS 108 MADISON ST XS: GARFIELD ST PENNSVILLE TWP MC GRAW ROBIN 2996816 Map: Grids: 00000 ,000 
911-CENTER:40 >BLS 556 N BROADWAY PENNSVILLE SARA MORIARTY 4078169 
911-CENTER:01 >STRUCTURE FIRE - LOW HAZARD 21 VAN BUREN ST XS: CANAL ROAD PENNSVILLE TWP JENNIFER PORADOSKY 0383396 Map: 
911-CENTER:40 >BLS 90 N BROADWAY WAY XS: CLIFTON PLACE PENNSVILLE TWP 504 6783089 Map: Grids: 00000 ,000 
911-CENTER:41 >ALS 29 MARKET ST XS: HOWELL ST SALEM CITY BARBARA CRISPIN 2028606 Map: Grids: 00000 ,000 
911-CENTER:40 >BLS 255 N RIVER DR XS: MEADOW ROAD PENNSVILLE TWP CONEY, KENNETH R 6785492 Map: Grids: 00000 ,000 
911-CENTER:40 >BLS 11 KENT AVE Apt: 412 Bldg XS: NORTH BROADWAY PENNSVILLE TWP FRANKLIN ALARM CO OPER 2769 6782600 Map: 
911-CENTER:02 >STRUCTURE FIRE-MEDIUM HAZARD 429 N BROADWAY WAY XS: ROUTE 130 OVERPASS PENNSVILLE TWP KIM MILLER 3511754 
911-CENTER:41 >ALS 25 W PITTSFIELD ST XS: N BROADWAY PENNSVILLE TWP AMERICAN LEGION BROWN MOORE PO 6789801 Map: Grids:00 
911-CENTER:40 >BLS 9 HARVARD RD XS: FORT MOTT ROAD PENNSVILLE TWP JIM MCCLAGHLIN 3142134 Map: Grids: 00000 ,000 
911-CENTER:40 >BLS 108 MADISON ST XS: GARFIELD ST PENNSVILLE TWP MC GRAW ROBIN 2996816 Map: Grids: 00000 ,000 
911-CENTER:40 >BLS 556 N BROADWAY PENNSVILLE SARA MORIARTY 4078169 
911-CENTER:01 >STRUCTURE FIRE - LOW HAZARD 21 VAN BUREN ST XS: CANAL ROAD PENNSVILLE TWP JENNIFER PORADOSKY 0383396 Map: 
911-CENTER:40 >BLS 90 N BROADWAY WAY XS: CLIFTON PLACE PENNSVILLE TWP 504 6783089 Map: Grids: 00000 ,000 
911-CENTER:41 >ALS 29 MARKET ST XS: HOWELL ST SALEM CITY BARBARA CRISPIN 2028606 Map: Grids: 00000 ,000 
911-CENTER:40 >BLS 255 N RIVER DR XS: MEADOW ROAD PENNSVILLE TWP CONEY, KENNETH R 6785492 Map: Grids: 00000 ,000 
911-CENTER:40 >BLS 11 KENT AVE Apt: 412 Bldg XS: NORTH BROADWAY PENNSVILLE TWP FRANKLIN ALARM CO OPER 2769 6782600 Map: 

Snyder County, PA
SNYDER911:IMMTRA>IMMEDIATE TRANSPORT 308 S MARKET ST XS:SASSAFRAS ST SELINSGROVE BORO YOUNG, AMBER Map:Grids:00000,000 CAD:2011-0000005449
SNYDER911:CARSY>CARDIAC SYMPTOMS 2084 ROUTE 522 PENN TWP HUFFNAGLE, CRYSTAL Map:Grids:00000,000 CAD:2011-0000005448
SNYDER911:ILLPER>ILLPERSON 620 UNIVERSITY AVE SELINSGROVE BORO ESHENAUR, MOLLY Map:Grids:00000,000 CAD:2011-0000005444
SNYDER911:GASOUT>GAS ODOR/OUTSIDE 1011 SUNRISE DR SELINSGROVE BORO UGI/SAND Map:Grids:00000,000 CAD 2011-0000005999
SNYDER911:AUTONI>AUTO ACCIDENT/NO INJURY 1769 N SUSQUEHANNA TRL MONROE TWP Map:Grids:00000,000 CAD 2011-0000006003
SNYDER911:FIREWI>FIRE/WILDFIRE 1035 N SUSQUEHANNA TRL XS:SUSQUEHANNA VALLEY MALL DR MONROE TWP DUN, SCOTT Map:00000,000 CAD:2011-0000005987
SYNDER911:AAFIRE>AUTO ALARM/FIRE 111 MARKETPLACE BLVD MONROE TWP SECURITY SERVICE  CO., 8717 Map:Grids: CAD:2011-0000005983
SYNDER911:AUTOIN>AUTO ACCIDENT/INJURY 892 ROUTE 522 PENN TWP Map:Grids:00000,000 Cad:2011-0000005857

Tioga County, PA
TC911:21D >HEMORRHAGE / LAC - DANGER HEM 76 BAKER CREST LN XS: HICKORY RD RUTLAND TWP DONALD BAKER Map: Grids:, Cad: 2011-0000020687
TC911:MVA >MOTOR VEHICLE ACCIDENT PITTS RD XS: CANOE CAMP CREEK RD RICHMOND TWP BRANT MAXWELL Map: Grids:, Cad: 2011-0000020573
TC911:26A >SICK - NO SYMPTOMS 51 SOUTH MAIN ST MANSFIELD BORO CHERLY BLOOM Cad: 2011-0000020561
TC911:MED >MEDICAL 37 CENTRAL AVE XS: WALNUT ST WELLSBORO BORO GREEN HOME INC Map: Grids:, Cad: 2011-0000020394
TC911:6D >BREATHING PROBLEMS / SEVERE 1883 SHUMWAY HILL RD XS: ROUTE 6 CHARLESTON TWP BROAD ACRS HLTH/REHAB423 Map: Grids:, Cad: 2011-0000020675TC911:21D >HEMORRHAGE / LAC - DANGER HEM 76 BAKER CREST LN XS: HICKORY RD RUTLAND TWP DONALD BAKER Map: Grids:, Cad: 2011-0000020687
TC911:12B >SEIZURES - NOT CURRENT NOT VER 2146 S MAIN ST XS: RICHMOND DR RICHMOND TWP GOODRICH RESIDENCE Map: Grids:, Cad: 2011-0000020612
TC911:30D >TRAUMATIC INJ - DANGEROUS 312 BRADFORD RD XS: ROUTE 6 SULLIVAN TWP JOYCE R BRADFORD-ROBERT Map: Grids:, Cad: 2011-0000020081
TC911:10D >CHEST PAIN - SEVERE SOB 55 BENEDICT LN XS: BENSON AVE ROSEVILLE BORO JAMIE KIRK Map: Grids:, Cad: 2011-0000020564
TC911:MED >MEDICAL 100 SHERWOOD MNR Apt: 219 Bldg XS: NOVELTY PL MANSFIELD BORO FORD, VIRGINIA Map: Grids:, Cad: 2011-0000020827

St Clair County, AL
9-1-1CENTRAL:MED >MEDICAL CALL 3213 EVERGREEN RD XS: R INT @ 3992 AL HWY 23 SPRINGVILLE ALTON DOLLAR 2056297007 Map: Grids:0,0 Cad: 2011-0000088977
9-1-1CENTRAL:MED >MEDICAL CALL 25 GRAY RD XS: L INT @ 2949 AL HWY 23 SPRINGVILLE WOODS, KATIE 2054676649 Map: Grids:0,0 Cad: 2011-0000089146
9-1-1CENTRAL:MED >MEDICAL CALL 3213 EVERGREEN RD XS: R INT @ 3992 AL HWY 23 SPRINGVILLE ALTON DOLLAR 2056297007 Map: Grids:0,0 Cad: 2011-0000088977
9-1-1CENTRAL:MED >MEDICAL CALL 25 GRAY RD XS: L INT @ 2949 AL HWY 23 SPRINGVILLE WOODS, KATHY 2054670992 Map: Grids:0,0 Cad: 2011-0000084537
9-1-1CENTRAL:MED >MEDICAL CALL 70 HOYT HILL RD COOL SPRINGS KURT 2054923800 Map: Grids:0,0 Cad: 2011-0000079042
9-1-1CENTRAL:MED >MEDICAL CALL 70 HOYT HILL RD XS: L INT @ 1641 RAY WYATT RD ASHVILLE KURT 2054923800 Map: Grids:0,0 Cad: 2011-0000079041
9-1-1CENTRAL:MED >MEDICAL CALL 1276 BEULAH CIR XS: L INT @ 5063 AL HWY 23 SPRINGVILLE MARGARET FRANKLIN 2053621848 Map: Grids:0,0 Cad: 2011-0000076650
9-1-1CENTRAL:MED >MEDICAL CALL 437 BUCKS VALLEY RD XS: R INT @ 10824 CO RD 31 ASHVILLE ELIZABETH WHEELER 2055291043 Map: Grids:0,0 Cad: 2011-0000074532
9-1-1CENTRAL:MED >MEDICAL CALL 115 HONEYSUCKLE WAY RIVERSIDE JOYCE RAMSEY 2054716335 Map: Grids:0,0 Cad: 2011-0000073897
9-1-1CENTRAL:50 >WRECK CO RD 23 @ BEULAH LN ASHVILLE DORIS LAWLER 2054731205 Cad: 2011-0000073324
9-1-1CENTRAL:MED >MEDICAL CALL 104 LAKE DR XS: L INT @ 375 EVERGREEN DR SPRINGVILLE BAILEY,NOAH 2059658047 Map: Grids:0,0 Cad: 2011-0000073129
9-1-1CENTRAL:50 >WRECK 8599 CO RD 31 XS: R INT @ 13064 US HWY 11 ASHVILLE ENSEY,KAREN 2055945299 Map: Grids:0,0 Cad: 2011-0000073086
9-1-1CENTRAL:FIRES >STRUCTURE FIRE 65 SALEM CT XS: R INT @ 7430 CO RD 31 ASHVILLE ISAAC PILA 2055777932 Map: Grids:0,0 Cad: 2011-0000073040
9-1-1CENTRAL:MED >MEDICAL CALL 25139 US HWY 411 XS: BEGINS @ END OF MOODY PRKWY ASHVILLE FARMER, RANDY 2055945861 Map: Grids:0,0 Cad: 2011-0000072997
9-1-1CENTRAL:FIRES >STRUCTURE FIRE 60 SALEM CT XS: R INT @ 7430 CO RD 31 ASHVILLE PAULA 9112755039 Map: Grids:0,0 Cad: 2011-0000072597
9-1-1CENTRAL:MED >MEDICAL CALL 2607 AL HWY 23 SPRINGVILLE CHUCK BACHUSS 2053695680 Map: Grids:0,0 Cad: 2011-0000071871

Somerset County, PA
Code:  MVA   >MOTOR VEHICLE ACCIDENT\nCode Detail:  Address:  XS:  City:  Caller:  Caller Ph:  Map:  Grid: CAD INC #:  2011-0000029533\n\nUnformatted Message: 9-1-1 CENTER:GRANT ST AT MAIN ST MEYERSDALE RICH SECHLER 8142891447 Cad: 2011-0000029533
Code:  FIRES >STRUCTURE FIRE\nCode Detail:  Address: 9-1-1 CENTER:605 PINEY RUN RD  XS:  ENGLES MILL RD SALISBURY WEIMER SUSAN  City:  Caller:  Caller Ph:  Map:  Grid: CAD INC #: 2011-0000028647\n\nUnformatted Message: 9-1-1 CENTER:605 PINEY RUN RD XS: ENGLES MILL RD SALISBURY WEIMER SUSAN 8146624073 Map: Grids:, Cad: 2011-0000028647
Code:  FIRES >STRUCTURE FIRE\nCode Detail:  Address: 9-1-1 CENTER:5467 MOUNT DAVIS RD  XS:  SAINT PAUL RD MEYERSDALE BENDER LINDA  City:  Caller:  Caller Ph:  Map:  Grid: CAD INC #: 2011-0000030088\n\nUnformatted Message: 9-1-1 CENTER:5467 MOUNT DAVIS RD XS: SAINT PAUL RD MEYERSDALE BENDER LINDA 8146622352 Map: Grids:, Cad: 2011-0000030088
Code:  SPILL >SPILL (TYPE)\nCode Detail:  Address: 9-1-1 CENTER:1041 SHAW MINES RD  XS:  City:  Caller: Caller Ph:  Map:  Grid: CAD INC #:  2011-0000029694\n\nUnformatted Message: 9-1-1 CENTER:1041 SHAW MINES RD XS: SKYLINE DR MEYERSDALE 130 Map: Grids:, Cad: 2011-0000029694
Code:  TC    >TRAFFIC CONTROL\nCode Detail:  Address: 9-1-1 CENTER:1222 GLADE CITY RD  XS:  DEAL RD MEYERSDALE LOTTIG,C  City:  Caller:  Caller Ph:  Map:  Grid: CAD INC #: 2011-0000030890\n\nUnformatted Message: 9-1-1 CENTER:1222 GLADE CITY RD XS: DEAL RD MEYERSDALE LOTTIG,C 8146348503 Map: Grids:, Cad: 2011-0000030890

Delaware County, NY
DELCO911:MVA >MOTOR VEHICLE ACCIDENT 2460 BIG RED KILL RD XS: WOOLHEATER RD MIDDLETOWN MACK, BONNIE LEE Map:54,54CC Grids:0,0 Cad: 2012-0000000256
DELCO911:WIRE >WIRE(S) DOWN 635 STREETER HILL RD MIDDLETOWN ANDERSON, DONALD E Map: Grids:0,0 Cad: 2011-0000016430
DELCO911:RD HAZ>ROAD HAZARD STATE HIGHWAY 28 MIDDLETOWN FINCH, FELICIA Cad: 2011-0000015967
DELCO911:ALMACT>ALARM ACTIVATION LOWER WAGNER AVE FLEISCHMANN Cad: 2011-0000015508
DELCO911:EMS >MEDICAL EMERGENCY 1141 MAIN ST XS: OLD HALCOTT RD FLEISCHMANNS VILLAGE WIRELESS-AT&T MOBILITY(TCS) Map:54CD Grids:0,0 Cad: 2011-0000015068
DELCO911:09D01 >CARDIAC/RESPIRATORY ARREST 451 BARLEY RD XS: COUNTY LINE MIDDLETOWN AJONDEAU, ARMAND Map:55 Grids:0,0 Cad: 2011-0000013362
DELCO911:09E01 >CARDIAC/RESPIRATORY ARREST 1050 MAIN ST XS: REDKILL RD FLEISCHMANNS VILLAGE PATEL MANISHA Map:54CD Grids:0,0 Cad: 2011-0000013284
DELCO911:ALMACT>ALARM ACTIVATION LOWER WAGNER AVE FLEISCHMANN Cad: 2011-0000015508

Marion County, MS
-  - 911-CENTER:SFIRE >STRUCTURE FIRE 1129 PICKWICK RD FOXWORTH FORBES, WILLEASE Map: Grids:, Cad: 2012-0000001317\n
-  - 911-CENTER:SIG72 >MEDICAL CALL 577 MT CARMEL CHURCH RD FOXWORTH AT&T MOBILITY Map: Grids:, Cad: 2012-0000001285\n
-  - 911-CENTER:SIG72 >MEDICAL CALL 244 SPRING HILL CHURCH RD SANDY HOOK AT&T MOBILITY Map: Grids:, Cad: 2012-0000001188\n
-  - 911-CENTER:EVENT: SIG72 LOC:185 SHILOH FIRETOWER RD Cad: 2012-0000000979 ENR >22:42 1023 >22:44 1024 >23:22 PATIENT REF TRANS\n
-  - 911-CENTER:SIG72 >MEDICAL CALL 185 SHILOH FIRETOWER RD FOXWORTH BROOM, PAUL & MARTHA Map: Grids:, Cad: 2012-0000000979
-  - 911-CENTER:EVENT: SIG2F LOC:109 HWY 98 E Cad: 2012-0000000949 ENR >14:14 1024 >15:00\n
-  - 911-CENTER:SIG2F >ALARM FIRE 109 HWY 98 E COLUMBIA Map: Grids:, Cad: 2012-0000000949\n
-  - 911-CENTER:SIG72 >MEDICAL CALL 491 JOHNSON RD SANDY HOOK MINGO, KAREN Map: Grids:, Cad: 2012-0000000646\n
-  - 911-CENTER:EVENT: SIG1S LOC:HWY 98 W Cad: 2012-0000000479 1023 >04:52 1024 >14:57\n
-  - 911-CENTER:EVENT: SIG80 LOC:191 STOGNER RD Cad: 2012-0000000431 ENR >20:45 1023 >21:05 1024 >23:17\n
-  - 911-CENTER:SIG80 >MISSING PERSON / RUNAWAY 191 STOGNER RD FOXWORTH CELLULAR SOUTH Map: Grids:, Cad: 2012-0000000431\n
-  - 911-CENTER:EVENT: SIG1 LOC:115 KOKOMO RD Cad: 2012-0000000429 1023 >18:21 1024 >19:28\n
-  - 911-CENTER:SIG1 >MVA 115 KOKOMO RD KOKOMO TONEY, JACK Map: Grids:, Cad: 2012-0000000429\n
-  - 911-CENTER:SIG72 >MEDICAL CALL 91 HURRICANE CREEK RD SANDY HOOK CELLULAR SOUTH Map: Grids:, Cad: 2012-0000000390\n
-  - 911-CENTER:SIG72 >MEDICAL CALL 244 SPRING HILL CHURCH RD SANDY HOOK LEWIS, MARY Map: Grids:, Cad: 2012-0000001643\n
-  - 911-CENTER:SIG72 >MEDICAL CALL 240 BRANTON BAY RD TYLERTOWN AT&T MOBILITY Map: Grids:, Cad: 2012-0000001839\n
-  - 911-CENTER:EVENT: SIG72 LOC:37 STRINGER BULLOCK RD Cad: 2012-0000001996 ENR >21:01 1023 >21:15 1024 >21:41\n
-  - 911-CENTER:EVENT: SIG1 LOC:283 MAYS CREEK RD Cad: 2012-0000002303 1023 >22:12 1024 >22:43\n
-  - 911-CENTER:EVENT: SFIRE LOC:31 OILFIELD CUT OFF RD Cad: 2012-0000002674 ENR >03:33 1023 >03:39 1024 >07:10\n

Williamson County, TN 
911-CENTER:MED >MEDICAL CALL 3939 PERKINS RD XS: SYCAMORE RD THOMPSONS STATION Map: Grids:N,15 Cad: 2012-0000017268
911-CENTER:F >FIRE (UNKNOWN ORGIN) SNEED RD W XS: HILLSBORO RD FRANKLIN VERIZON WIRELESS Cad: 2012-0000017084
911-CENTER:MED >MEDICAL CALL 326 VAUGHN RD XS: STRICKLAND DR NASHVILLE MALLOY, MITCH Map: Grids:U,2 Cad: 2012-0000017260
911-CENTER:FA >FIRE ALARM 330 LAKE VALLEY DR XS: GLEN LAKES CT FRANKLIN PETERSON,JAY & MYRA Map: Grids:W,6 Cad: 2012-0000017023
911-CENTER:MED >MEDICAL CALL NATCHEZ TRACE PKY XS: NEW HIGHWAY 96 W FRANKLIN CENTERSTONE CRISIS CENTER Cad: 2012-0000017016
911-CENTER:MC >MEDICAL CALL 716 LEGENDS CREST DR XS: LEGENDS RIDGE DR FRANKLIN Map: Grids:W,5 Cad: 2012-0000016926
911-CENTER:FA >FIRE ALARM 1201 BRADLEY DR XS: BOBBY DR FRANKLIN DAN WATERS Map: Grids:W,4 Cad: 2012-0000016906
911-CENTER:MED >MEDICAL CALL 1786 MASTERS DR XS: SIGNATURE CT FRANKLIN NELSON, JACK Map: Grids:V,13 Cad: 2012-0000016869

Jackson County, GA
JACKSONE911:1070 >FIRE 1382 WILHITE RD XS: PAYNEVILLE RD JEFFERSON WIER, GILBERT L & SUE 7063678650 Map: Grids:0,0 Cad: 2012-0000049643
JACKSONE911:1050I >ACCIDENT - INJURIES 3835 APPLE VALLEY RD BILL Cad: 2012-0000049719
JACKSONE911:SIG16 >STROKE/CVA PATIENT 87 BEND DR XS: COMMERCE RD JEFFERSON FLOYD PAULSON 7066148432 Map:H6 Grids:0,0 Cad: 2012-0000053376
JACKSONE911:SIG3 >CHEST PAIN/RESPIRATORY DISTRES 95 W G LEGG RD XS: RAFORD WILSON RD COMMERCE LEGG, JERRY 7063675387 Cad: 2012-0000055115
JACKSONE911:SIG3 >CHEST PAIN/RESPIRATORY DISTRES 4513 S APPLE VALLEY RD XS: EDGEFIELD DR COMMERCE HOMAN, JARED 7062026827 Map: Grids:0,0 Cad: 2012-0000054782

Clermont county, OH
FSTRUC>STRUCTURE FIRE 1890 SR 232 XS: LAUREL POINT ISABEL RD LAUREL BUTLER, SHAWN Map: Grids:, Cad: 2011-0000014744
MED >MED GENERIC DO NOT DELETE 2458 SR 756 XS: SR 743 WASHINGTON TOWNSHIP BETTLES,LINDA Map: Grids:, Cad: 2011-0000015125
FDUMP >DUMPSTER FIRE 2601 WILDWOOD LN XS: SR 222 TATE TOWNSHIP WIRELESS-VERIZON(XYP) Map: Grids:, Cad: 2011-0000015892
06D02 >BREATHING PROBLEMS 2458 SR 756 XS: SR 743 WASHINGTON TOWNSHIP LESTER,CURTIS Map: Grids:, Cad: 2011-0000016117
29B04 >TRAFF OR TRANSPT ACC/MVA W/INJ 1542 SR 133 XS: RUDD RD FRANKLIN TOWNSHIP WIRELESS-AT&T MOBILITY(XYP) Map: Grids:, Cad: 2011-0000016205
06D02 >BREATHING PROBLEMS 2458 SR 756 XS: SR 743 WASHINGTON TOWNSHIP LESTER,CURTIS Map: Grids:, Cad: 2011-0000016117
29B01 >TRAFF OR TRANSPT ACC/MVA W/INJ BETHEL HYGIENE RD&amp;SR 133 XS: SR 133 TATE TOWNSHIP Cad: 2011-0000016983
FSMOKE>SMOKE IN THE AREA 3465 SR 774 XS: HENSON RD FRANKLIN TOWNSHIP LORI SPARKS Map: Grids:, Cad: 2011-0000017023
29B01 >TRAFF OR TRANSPT ACC/MVA W/INJ LAUREL PT ISABEL RD&BECKELHYMER RD XS: BECKELHYMER RD WASHINGTON TOWNSHIP HAYMOND,LINDA S Cad: 2011-0000017231
FWIRES>WIRES DOWN E OSBORNE ST&N EAST ST XS: N EAST ST BETHEL JEFF W/RUMPKE Cad: 2011-0000017232
FSTRUC>STRUCTURE FIRE 966 E LEGENDARY RUN XS: ABERDEEN RIDGE PIERCE TOWNSHIP HANSBAUER,DAVID & LINDA Map: Grids:, Cad: 2011-0000069848
04B01 >ASSAULT/SEXUAL ASSAULT 5728 GAVEY WAY XS: SR 131 WAYNE TOWNSHIP JEFFERS,JORDAN Map: Grids:, Cad: 2011-0000077041
FALARM>FIRE ALARM 1466 HWY 50 XS: BARRETT RD STONELICK TOWNSHIP CINTAS FIRE PROTECTION-55 Map: Grids:, Cad: 2011-0000077411
MED >MED GENERIC DO NOT DELETE 2800 LINK SIDE DR Apt: 4 Bldg XS: ST ANDREWS DR PIERCE TOWNSHIP WETZELL,CONNIE Map: Grids:, Cad: 2011-0000082440
31C02 >UNCONSCIOUS/FAINTING (NEAR) 5877 WOLFPEN PLEASANT HILL RD Apt: 316 Bldg XS: TRAVERSE CREEK DR MIAMI TWP RYAN, CHRISTY Map: Grids:, Cad: 2012-0000002524
" " 09B01 >CARDIAC OR RESP ARREST/DEATH 3373 COLE RD XS: CHERY LN PIERCE TOWNSHIP SCHAEFFER, DANIEL P Map: Grids:, Cad: 2012-0000015385 TXT STOP to opt-out
" " FBURN >POSSIBLE OPEN BURN BRANDYWINE DR&CUTTY SARK XS: CUTTY SARK LINDALE REFUSED Cad: 2012-0000025310
" " 26A01 >SICK PERSON (SPECIFIC DIAG) 1751 OHIO PIKE Apt: 156 Bldg XS: EAST FORK DR PIERCE TOWNSHIP REFUSED Map: Grids:, Cad: 2012-0000046833
[] 911-CENTER:MED >MED GENERIC DO NOT DELETE 51 DEERFIELD DR XS: DEERFIELD RD GOSHEN TOWNSHIP PAYTES,TINA & TED Map: Grids:, Cad: 2012-0000052916\n
[] 911-CENTER:EVENT: 06D02 LOC:51 DEERFIELD DR Cad: 2012-0000052916 DSP >12:10 ER >12:11 CLR >12:39\n
[] 911-CENTER:06D02 >BREATHING PROBLEMS 51 DEERFIELD DR XS: DEERFIELD RD GOSHEN TOWNSHIP PAYTES,TINA & TED Map: Grids:, Cad: 2012-0000052916\n
[] 911-CENTER:06D02 >BREATHING PROBLEMS 6409 SNIDER RD XS: WOODVILLE PI GOSHEN TOWNSHIP GODSEY,GENEVA Map: Grids:, Cad: 2012-0000053000\n
[] 911-CENTER:EVENT: 06D02 LOC:6409 SNIDER RD Cad: 2012-0000053000 ER >16:54 OS >16:59 OK >17:10 CLR >17:17\n

*/

public class DispatchBParser extends SmartAddressParser {
  
  private static final String[] FIXED_KEYWORDS = new String[]{"Map", "Grids", "Cad"};
  private static final String[] KEYWORDS = 
    new String[]{"Loc", "BOX", "Map", "Grids", "Cad"};
  private static final Pattern REPORT_PTN = Pattern.compile("EVENT:.* Cad: ([-0-9]+) ");
  private static final Pattern PHONE_PTN = Pattern.compile(" (\\d{10}|\\d{7}|\\d{3} \\d{7}|\\d{3}-\\d{4})$");
  
  public DispatchBParser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState);
    setup();
  }
  
  public DispatchBParser(String defCity, String defState) {
    super(defCity, defState);
    setup();
  }
  
  /**
   * Determines if this is a CAD page (may be overridden by subclasses)
   * @param body
   * @return
   */
  protected boolean isPageMsg(String body) {
    return isPageMsg(body, FIXED_KEYWORDS);
  }
  
  /**
   * Processes the complicated first address field
   * Will usually be overridden by subclasses
   * @param field first address field
   * @param data message information data object
   * @return true if parse was successful
   */
  protected boolean parseAddrField(String field, Data data) {
    // Default is to ignore everything up to the first '>'
    int ipt = field.indexOf('>');
    if (ipt >= 0) field = field.substring(ipt+1);
    Matcher match = PHONE_PTN.matcher(field);
    if (match.find()) {
      data.strPhone = match.group(1);
      field = field.substring(0,match.start()).trim();
    }
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, field, data);
    data.strName = getLeft();
    return true;
  }

  @Override
 protected boolean parseMsg(String body, Data data) {
    
    if (! isPageMsg(body)) return false;
    
    Matcher match = REPORT_PTN.matcher(body);
    if (match.find()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body.substring(match.start());
      data.strCallId = match.group(1);
      return true;
    }
    
    body = "Loc: " + body;
    Properties props = parseMessage(body, KEYWORDS);
    
    if (!parseAddrField(props.getProperty("Loc", ""), data)) return false;
    
    data.strBox = props.getProperty("BOX", "");
    data.strMap = props.getProperty("Map", "");
    String callId = props.getProperty("Cad");
    if (callId != null) {
      int pt = callId.indexOf(' ');
      if (pt >= 0) {
        data.strSupp = callId.substring(pt+1).trim();
        callId = callId.substring(0,pt);
      }
      data.strCallId = callId;
    }
    
    return true;
  }
  
  private void setup() {
    setupCallList(
        "ACCIDENT - INJURIES",
        "ACCIDENT INJURIES",
        "ACCIDENT MVA WITH INJURIES",
        "ACCIDENT W/ INJURIES",
        "ACCIDENT WITH INJURIES",
        "ABDOM PAIN - FEM 12-50 W/FAINT",
        "ABDOMINAL PAIN/PROBLEM",
        "ADVANCED LIFE SUPPORT CALL",
        "AUTO ACCIDENT/INJURY",
        "AUTO ACCIDENT/NO INJURY",
        "AUTO ALARM/FIRE",
        "ALARM ACTIVATION",
        "ALARM FIRE",
        "ALARM/FIRE",
        "ALARM SYSTEM-NIGHT",
        "ALARMS",
        "ALS",
        "ALTERED MENTAL STATUS",
        "ASSAULT/SEXUAL ASSAULT",
        "ASSISTANCE/ MUTUAL AID",
        "BASIC LIFE SUPPORT CALL",
        "BLS",
        "BREATHING ALS",
        "BREATHING DIFFICULTY",
        "BREATHING PROBLEMS",
        "BREATHING PROBLEMS A",
        "BREATHING PROBLEMS / SEVERE",
        "BRUSH FIRE",
        "BUILDING FIRE",
        "CARDIAC OR RESP ARREST/DEATH",
        "CARDIAC PROBLEMS",
        "CARDIAC/RESPIRATORY ARREST",
        "CARDIAC/RESP ARREST / DEATH",
        "CARDIAC SYMPTOMS",
        "CHEST PAIN",
        "CHEST PAIN - BREATH NORMAL=>35",
        "CHEST PAIN - CARDIAC HISTORY",
        "CHEST PAIN - SEVERE SOB",
        "CHEST PAIN DIFF SPEAK BTW BRE",
        "CHEST PAIN/RESPIRATORY DISTRES",
        "CHILD LOCKED IN CAR",
        "CO DETECTOR / FIRE RESPONSE",
        "DIABETIC-ALS PRI2",
        "DIABETIC EMRG.",
        "DIABETIC PROBLEM",
        "DOMESTIC DISTURBANCE",
        "DUMPSTER FIRE",
        "ELEC HAZ/PWR REPT DISCONNECTED",
        "ELECTRICAL HAZARD",
        "EMERGENACY RUN",
        "EMS CALL",
        "EMS LIFELINE CALL",
        "FALL - ANY",
        "FALLS",
        "FALLS/ACCIDENTS BLS",
        "FALLS-ALS PRI1-FR",
        "FALLS-BLS PRI2 ",
        "FALLS (GRD/FLR) POSS DANGER BO",
        "FIGHT",
        "FIRE ALARM",
        "FIRE ALARM COMMERCIAL/INDUST",
        "FIRE CALL",
        "FIRE INDUSTRIAL",
        "FIRE/GENERAL ALARM-COMM STRUC",
        "FIRE RESIDENTIAL",
        "FIRE - STRUCTURE", 
        "FIRE SMOKE INVESTIGATION",
        "FIRE TREE DOWN",
        "FIRE/WILDFIRE",
        "GAS ODOR/OUTSIDE",
        "GRASS/WOODS FIRE",
        "HAZARDOUS MATERIALS",
        "HEM/LACER-SERIOUS",
        "HEMORRHAGE / LAC - DANGER HEM",
        "HEMORRHAGE / LACERATIONS",
        "HGH LIFE HZD ALRM GEN",
        "ILL PERSON",
        "ILLPERSON",
        "IMMEDIATE TRANSPORT",
        "LIFT ASSIST/NON EMER EMS",
        "MVA-ALS PRI1",
        "M.V.A. - POSSIBLE INJURIES",
//        "MEDICAL",
        "MEDICAL ALPHA",
        "MEDICAL BRAVO",
        "MEDICAL CHARLIE",
        "MEDICAL DELTA",
        "MEDICAL ECHO",
        "MEDICAL ALARM",
        "MEDICAL CALL",
        "MEDICAL EMERGENCY",
        "MEDICAL GENERIC",
        "MISC",
        "MISSING PERSON / RUNAWAY",
        "MOTOR VEH ACC UNKNOWN INJ",
        "MOTOR VEHICLE ACCIDENT",
        "MUTUAL AID/ASSIST OUTSIDE AGEN",
        "MV ACCIDENT W/INJURY",
//        "MVA",
        "MVA -EJECTION- HIGH MECHANISM",
        "MVA - MAJOR INCIDENT",
        "MVA NONE INJURY",
        "MVA - PINNED",
        "MVA - UNKNOWN STATUS",
        "MVA-TRAPPED MULTI PT/ADD RESPO",
        "MVA WITH INJURIES",
        "MVA - WITH INJURIES",
        "MVA WITH UNKNOW INJUIRIES",
        "MVA W/ RESCUE",
        "NON-SPECIFIC DIAGNOSIS",
        "ODOR / OTHER THAN SMOKE",
        "OTHER-FIRE",
        "POSSIBLE OPEN BURN",
        "REFINERY/TANK FARM/FUEL STORAG",
        "RES (SINGLE) HEAT DETECTOR",
        "ROAD HAZARD",
        "SEIZURES",
        "SEIZURES - NOT CURRENT NOT VER",
        "SICK - NO SYMPTOMS",
//        "SICK PERSON",
        "SICK PERSON (SPECIFIC DIAG)",
        "SICK PERSON - NAUSEA",
        "SICK PERSON - NOT ALERT",
        "SICK/UNKNOWN ALS",
        "SMOKE IN THE AREA",
        "SMOKE INVESTIGATION",
        "SPILL (TYPE)",
        "STROKE",
        "STROKE-CVA",
        "STROKE/CVA PATIENT",
        "STROKE (CVA) BREATH NORM > 35",
        "STRUCTURE FIRE",
        "STRUCTURE FIRE CHARLEY RESPONS",
        "STRUCTURE FIRE - LOW HAZARD",
        "STRUCTURE FIRE-MEDIUM HAZARD",
        "STRUCTURE FIRE - HIGH HAZARD",
        "STRUC FIRE-SINGLE RESIDENTIAL",
        "STRUCTURE FIRE- HIGH RISE",
        "TRAUMATIC INJURY",
        "TRAFF OR TRANSPT ACC/MVA W/INJ",
        "TRAFFIC CONTRO",
        "TRAFFIC CONTROL",
        "TRAUMATIC INJ - DANGEROUS",
        "TREE_DOWN",
        "TREES/WIRES DOWN URGENT",
        "UNCONCIOUS",
        "UNCONSCIOUS/FAINTING",
        "UNCONSCIOUS/FAINTING (NEAR)",
        "UNCONSCIOUS SUBJECT",
        "UNCONTAINED HAZMAT",
        "UNK PROBLEM-LIFE STAT QUESTION",
        "UNKNOWN/PERSON DOWN",
        "UNKNOWN PROBLEM",
        "UNRSPONSIVE / SYNCOPE ALS",
        "VEHICLE ACCIDENT",
        "VEHICLE PURSUIT",
        "WILDLAND FIRE",
        "WIRES",
        "WIRES DOWN",
        "WIRE(S) DOWN",
        "WIRES DOWN / ARCING",
        "WRECK"
    );
  };
}
