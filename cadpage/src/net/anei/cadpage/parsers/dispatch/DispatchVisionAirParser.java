package net.anei.cadpage.parsers.dispatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/* 
Hoke County, NC
Hoke Co 911:795 TC JONES RD* * * * * **EMD* * * * * * * * 09/15/2011 14:36:26 : pos4 : mblack3325 ** EMD Case Entry Finished ** Chief Complaint Number: 19 Key Q
Hoke Co 911:385 SUNSET LAKE RD* * * * * **EMD* * * * * * * * 09/19/2011 06:20:35 : pos2 : SCOOPER9403 Cross streets: 7100 ARABIA RD//DEAD END Cross streets: 205
Hoke Co 911:6020 PHILLIPI CHURCH RD* * * * * **26 SICK PERS* * * * * * * * 09/18/2011 00:57:12 : pos1 : LGRADY7274 ** EMD Case Complete ** Key Questions: 46 yea
Hoke Co 911:6020 PHILLIPI CHURCH RD* * * * * **EMD* * * * * * * * 09/18/2011 00:56:49 : pos1 : LGRADY7274 ** EMD Recommended Dispatch ** Response Text: Alpha Di
Hoke Co 911:216 ROLLING PINES CT* * * * * **01 ABD PAIN* * * * * * * * 09/17/2011 19:54:51 : pos2 : SCOOPER9403 205 10-8 09/17/2011 19:54:38 : pos2 : SCOOPER940
Hoke Co 911:216 ROLLING PINES CT* * * * * **EMD* * * * * * * * 09/17/2011 19:37:54 : pos1 : LGRADY7274 ** EMD Recommended Dispatch ** Response Text: Alpha Dispa
Hoke Co 911:265 BETTY`S TRL* * * * * **EMD* * * * * * * * 09/16/2011 19:14:15 : pos2 : SCOOPER9403 Cross streets: 580 EVERITT RD//DEAD END WILL BE IN THE VERY E
Hoke Co 911:730 GALATIA CHURCH RD* * * * * **EMD* * * * * * * * 09/15/2011 13:51:27 : pos4 : mblack3325 Cross streets: 5365 ROCKFISH RD//CUMBERLAND CO LINE*
Hoke Co 911:100 WAYSIDE RD* * * * * **AC/PI* * * * * * * * 04/25/2012 18:18:57 : pos2 : RCRUMPLER3351 Cross streets: FAYETTEVILLE RD//OLD OAK RD*

Stamford, CT
 * 107 EAGLE DR* * * * * 654 STRUCT* * * 203-274-3396* * * * * 6/11/2012 5:32:43 PM : pos2 : SESTABROOK CALLER AND HIS WIFE WILL BE OUT
 * 1035 NEWFIELD AV* * * * * F ALARM* * JEWISH COMM CENTER* 203-322-7900* * * * * 05/29/2012 14:53:36 : pos4 : hkokinchak Landmark: JEWISH COMMUNITY CENTER Cross streets: VINE RD//CLUB RD USA CENT OP 33 800-422-2300 GENERAL FIRE*
 * 2700 BEDFORD ST* C* * * * 654 STRUCT* * * 203- -* * * * * 5/12/2012 10:11:52 PM : pos2 : SESTABROOK FIRE IN APT C. 5/12/2012 10:11:40 PM : pos2 : SESTABROOK FIRE IN APT C. 5/12/2012 10:10:50 PM : pos2 : SESTABROOK Cross streets: LOCUST LN//HIGH RIDGE RD 5/12/2012 10:10:16 PM : pos2 : SESTABROOK: Cross streets: LOCUST:
 * 243 TRESSER BLVD* * * * * 644 MED LIFE* * MARRIOTT STAMFORD* 203-357-9555* * * * * 06/18/2012 09:23:23 : pos1 : AMSMITH ** EMD Case Complete ** 06/18/2012 09:23:20 : pos1 : AMSMITH ** EMD Recommended Dispatch ** Response Text: Charlie Dispatch Level: 06C01 CAD Incident Code: 06C01 Key Questions: 56 year old, Male, Co
 * 58 E CROSS RD* * * * * 654 STRUCT* * JAMES* 203-595-6454* * * * * 06/18/2012 13:36:31 : pos1 : AMSMITH Cross streets: HOPE ST//HAWKS HILL RD SMELL OF SMOKE OR ELECTRICAL BURNING FROM THE WASHING MACHINE...*
911Fire:* 42 HALLOWEEN BLVD* * * * * 654 STRUCT* * * 203-667-1756* * * * 7/5/2012 11:54:59 PM : pos11 : AMITCHELL SAFETY OFC WARD RESPONDING, NOT ETA... 7/5/2012 11:53:26 PM : pos11 : AMITCHELL UNIT 4, REQUESTING FIRE MARSHALL, AND SAFETY OFFICER... 7/5/2012 11:50:17 PM : pos8 : CZARMSKY EVACUATED 07/05/2012 23:48:46 : pos12 : JMASTRO E3 RIT TEAM 07/05/2012 23:47:30 : pos4 : LJORDHAMO NUMEROUS CALL..PARTIES ALL OUT 07/05/2012 23:47:10 : pos2 : HFALLON ADVISED TO EVACUATE 07/05/2012 23:47:01 : pos2 : HFALLON ANOTHER CALLER SEE FLAMES IN THE BASEMENT 07/05/2012 23:46:21 : pos3 : MSEMMEL Cross streets: GLEASON AV//SAINT MARYS ST FIRE IN THE BASEMENT*

Trumbull County, OH
*3481 NILES CORTLAND RD NE*12**BAZETTA TWP***UNKNOWN PROBLEM/UNCLASSIFIED***STA11****07/10/2012 10:10:24 : pos7 : ASP   Cross streets: WINDSOR PL//GREENBRIAR  Landmark: CASS LAKE TRAILER PARK  Geo Comment: STATE RD/AKA ST RTE 46  NBH: MVA AT NILES CORTLAND @ GREENBRIER STA 11/12/13*
*2438 ELM RD EXT NE***BAZETTA TWP***CRASH WITH REPORTED INJURIES***STA11****07/10/2012 17:49:50 : pos3 : RLC   Landmark: MUSCLE & MORE AUTO SALES  Cross streets: HOAGLAND BLACKSTUB RD//BURNETT DR  Geo Comment: STATE RD/AKA ST RTE 5  GUY RAN FROM THE SCENE*
*2438 ELM RD EXT NE***BAZETTA TWP***CRASH WITH REPORTED INJURIES***STA11,STA13****07/10/2012 17:49:50 : pos3 : RLC   Landmark: MUSCLE & MORE AUTO SALES  Cross streets: HOAGLAND BLACKSTUB RD//BURNETT DR  Geo Comment: STATE RD/AKA ST RTE 5  GUY RAN FROM THE SCENE*
*2755 HOAGLAND BLACKSTUB RD***BAZETTA TWP***ODOR INVESTIGATION***STA11****07/10/2012 19:29:40 : pos4 : JB   THIRD PARTY CALL UNK WHAT TYPE OF ODOR / LIKE SOMETHING BURNING     07/10/2012 19:29:12 : pos4 : JB   Cross streets: JANET DR//JOHNSON PLANK RD  Landmark: BAZETTA ELEMENTARY SCHOOL  Geo Comment: COUNTY RD #203/AKA BAZETTA RD  330/847-9199 DAUGHTER IS WORKING AT CONSESSION STAND / SMELLING A BURNING ODOR*
*6080 DOWNS RD******STRUCTURE FIRE***21OFF,STA11,STA17,STA21****07/11/2012 02:00:47 : pos4 : RONNIE   EVERYONE OUT - COMMING FROM ATTIC ABOVE MASTER BEDROOM     07/11/2012 02:00:23 : pos4 : RONNIE   Cross streets: CENTER ST W//PRENTICE RD  Geo Comment: TOWNSHIP RD #207  NBH: 6491 HAS 5 BUILDINGS ON THE PROPERTY A-E  Cross streets: MAHONING AV//BIKE TRAIL  Geo Comment: STATE RD/AKA ST RTE 305     HOUSE FIRE*
*1058 PERKINS JONES RD*B12**BAZETTA TWP***SEIZURE***STA11****07/11/2012 08:57:19 : pos3 : JG   Cross streets: PERKINS JONES CT//HOAGLAND BLACKSTUB RD  Geo Comment: COUNTY RD #149  36 YOF  JUST HAD A SEIZURE  ... WHOLE BODY CONVULSION*
*2249 ELM RD EXT NE***BAZETTA TWP***UNKNOWN PROBLEM/UNCLASSIFIED***STA11****07/11/2012 12:29:11 : pos4 : PC   Landmark: DR NAPLES ROBERT DO  Cross streets: HOAGLAND BLACKSTUB RD//BURNETT DR  Geo Comment: STATE RD/AKA ST RTE 5  51 YOF  POST FALL   UNABLE TO FOCUS, VOMITTING AND FEELS FAINT / CALLER- LINDA HEASLEY*
*1014 PERKINS JONES RD*B2**BAZETTA TWP***ALARM DROP MEDICAL***STA11****07/11/2012 12:43:50 : pos3 : JG   Landmark: APARTMENTS SUBURBAN MANOR APARTMENTS  Cross streets: PERKINS JONES CT//HOAGLAND BLACKSTUB RD  Geo Comment: COUNTY RD #149  BETTY ALDERMAN   77 YOF   REC ALARM REF TO A FALL    CALLED BACK RES AND SPOKE WTIH SON ON PREMISE   CONFIRMED FALL AND  THERE IS AN INJURY.....   PS AT RES    330 847 0605*
*2600 ELM RD EXT NE**D****CHEST PAINS***STA11****07/11/2012 17:48:36 : pos1 : CS   Landmark Comment: BUILDING D/PHONE # FOR DR OFFICES IN BACK 372-8902  Landmark: TRUMBULL MAHONING MEDICAL GROUP  Cross streets: BURNETT DR//TIMBERLINE DR  Geo Comment: STATE RD/AKA ST RTE 5  ELDERLY MALE IN A WHITE SUV IN THE PARKING LOT HAVING CP //*
*1439 ST RTE 305*59*****BURNING COMPLAINT***STA11****07/11/2012 22:14:11 : pos4 : LA   Cross streets: DURST DR//STATE PARK ENTRANCE  Geo Comment: STATE RD/AKA WILSON SHARPSVILLE RD  Cross streets: DURST DR//STATE PARK ENTRANCE  Landmark: MOSQUITO LAKE STATE PARK   Geo Comment: STATE RD/AKA WILSON SHARPSVILLE RD  Landmark Comment: UNDERWATER CAMERA 724-854-2412  LARGE FIRE ALMOST TOUCHING THE TREES // WANTS THEM ADVISED DUE TO IT BEING SO DRY*
*1060 PERKINS JONES RD*B11**BAZETTA TWP***DIABETIC***STA11****07/12/2012 08:09:58 : pos4 : KH   Cross streets: PERKINS JONES CT//HOAGLAND BLACKSTUB RD  Geo Comment: COUNTY RD #149  ALI X Coordinate: -080.775411  ALI Y Coordinate: 041.275677  LAKESHORE APTS // DIABETIC  37 YOF*
*2100 MILLENNIUM BLVD***BAZETTA TWP***BLEEDING***STA11****07/12/2012 11:06:09 : pos8 : DV   Landmark: FRESENIUS MEDICAL CARE  Cross streets: ELM RD EXT NE//DEAD END  Geo Comment: TOWNSHIP RD    FEMALE PT..BLEEDING FISTULA*
*952 JOHNSON PLANK RD******SEIZURE***STA11****07/12/2012 12:16:20 : pos3 : JG   Cross streets: DURST CLAGG RD//HOAGLAND BLACKSTUB RD  Geo Comment: COUNTY RD #200  36 YOF   CONVULSION SEIZURE  CALLER IS PATIENT*
*2100 MILLENNIUM BLVD***BAZETTA TWP***CHEST PAINS***STA11****07/13/2012 08:14:16 : pos4 : KH   Landmark: FRESENIUS MEDICAL CARE  Cross streets: ELM RD EXT NE//DEAD END  Geo Comment: TOWNSHIP RD  51 YOF // CHEST PAIN / TACHY  CON / BREATHING*
*3640 ST RTE 5 S******FALL***STA11****07/13/2012 11:04:09 : pos4 : KH   Cross streets: ST RTE 305//ST RTE 46  Landmark: BP OIL CO   Geo Comment: STATE RD  OUTSIDE / FELL HURT BACK / POSS LEG /*
*773 JOHNSON PLANK RD******CARDIAC ARREST***STA11****07/13/2012 11:34:35 : pos1 : CR   Cross streets: DURST CLAGG RD//HOAGLAND BLACKSTUB RD  Geo Comment: COUNTY RD #200  86YOM QUIT BREATHING 5 MIN AGO*
*0 ST RTE 5 S***BAZETTA TWP***CRASH WITH REPORTED INJURIES***1300,STA11****07/13/2012 12:54:31 : pos1 : CR   Cross streets: ST RTE 305//ST RTE 46  Geo Comment: STATE RD  NBH: MVA @ RTE 5 & 46 SEND BOTH STA 11/13/12  AT 305 2 VEH*
*110 HUNTINGTON TR******STRUCTURE FIRE***STA11,STA12****07/13/2012 13:36:53 : pos3 : JG   CALLER IS THE BABYSITTER  GETTING EVERYONE OUT     07/13/2012 13:35:48 : pos3 : JG   Cross streets: WAE TR//DEER CREEK TR  Landmark: CINGULAR TOWER  MICROWAVE EXPLODED       IS NOT ON FIRE  SMOKING  STILL PLUGGED IN  SHE WAS ADV TO EVACUATE*
*2179 HIGH ST******STRUCTURE FIRE***724,726,STA11,STA21,STA49****07/13/2012 15:22:04 : pos5 : AS   ALL ARE OUT// SHE HAS HER DOG WITH HER// NO ONE ELSE INSIDE     07/13/2012 15:21:05 : pos5 : AS   Cross streets: MAHONING AV//CHAPEL HILL DR E  Geo Comment: TOWNSHIP RD #595    HOUSE ON FIRE// OVEN ON FIRE*
*2389 BIANCA LN******ASSAULT***1324,STA11****07/15/2012 17:01:46 : pos5 : LA   OTHER SUBJECT STILL THERE     07/15/2012 17:01:32 : pos5 : LA   Cross streets: KEYSTONE TR N//CUL DE SAC  Geo Comment: TOWNSHIP RD  NBH: TIMBER CREEK ESTATES  MALE WAS ASSULTED BY TONY ENGLISH // NEEDS EMS*
*3566 LARCHMONT AV**15*BAZETTA TWP***FIRE INFORMATION***STA11****07/16/2012 08:15:16 : pos7 : ASP   Cross streets: HOWLAND TWP LINE//ST RTE 5 BYPASS  Landmark: BJ ALAN CO  Geo Comment: COUNTY RD #149  Landmark Comment: **DUAL RESPONSE ZONE FIRE** HOWLAND & BAZETTA  OFF LINE TILL APP 1700*
*0 ELM RD NE***BAZETTA TWP***CRASH WITH REPORTED INJURIES***STA11****07/16/2012 09:40:24 : pos3 : TG   Cross streets: ST RTE 5 BYPASS//HOAGLAND BLACKSTUB RD  Geo Comment: STATE RD/AKA ST RTE 5  ELM RD ON RAMP TO WB ST RTE 82...UNK INJURIES...OSP IS ENT FROM COURT IN THE CITY.*
*2600 ELM RD EXT NE**D****BLEEDING***STA11****07/16/2012 15:56:14 : pos3 : RLC   Landmark Comment: BUILDING D/PHONE # FOR DR OFFICES IN BACK 372-8902  Landmark: TMMG  Cross streets: BURNETT DR//TIMBERLINE DR  Geo Comment: STATE RD/AKA ST RTE 5  23 YOF/LARGE LACERATION ON LEFT ARM/SAID IT WASN`T INTENTIONAL*
*3566 LARCHMONT AV**15****FIRE INFORMATION***STA11****07/17/2012 06:42:44 : pos6 : RM   Cross streets: HOWLAND TWP LINE//ST RTE 5 BYPASS  Landmark: BJ ALAN CO  Geo Comment: COUNTY RD #149  Landmark Comment: **DUAL RESPONSE ZONE FIRE** HOWLAND & BAZETTA    FIRE ALARM ON TEST WILL CALL WHEN DONE AROUND 5 OR 5:50 // CALL WAS MADE TO THE PRIVATE LINE AT THE FIRE DESK HE WAS GIVEN THE PROPER NUMBER TO CALL NEXT TIME*
*0 CADWALLADER SONK RD E******BRUSH/GRASS FIRE***1300,STA11****07/17/2012 17:41:21 : pos4 : JB   Cross streets: CANTERBURY TRACE//HENN HYDE RD  Geo Comment: TOWNSHIP RD #196  Cross streets: NILES CORTLAND RD NE//DEAD END  Geo Comment: PRIVATE RD  GRASS ON FIRE / NEAR THE WOODS - CAN SEE SMOKE   AREA OF HENN HYDE*
*0 BYPASS******CRASH WITH REPORTED INJURIES***1300,413,426,STA11,STA30****07/17/2012 20:47:00 : pos3 : RLC   STILL IN THE VEH     07/17/2012 20:46:18 : pos3 : RLC   NO SMOKE OR FIRE     07/17/2012 20:46:14 : pos3 : RLC   5 PEOPLE TRYING TO HELP HIM OUT OF THE CAR     07/17/2012 20:46:08 : pos4 : JB   **Appended Information from duplicate call:  Caller Name : VERIZON WIRELESS, Phone : 330-716-5025,Complaint : C4  Apt/Suite :  , Flr/Bldg :   Narrative : Cross streets: ELM RD//HOWLAND TWP LINE  Geo Comment: STATE RD  Cross streets: NUTLEY AV NE//BIRCHWOOD AV NE  Geo Comment: COUNTY RD #142  WB BYPASS / BEFORE ELM   CAR FLIPPED OVER IN TREES   **End of Appended Information.     07/17/2012 20:45:28 : pos3 : RLC   MALE STILL IN THE VEH/FLIPPED OVER AND FLEW IN THE WOODS     07/17/2012 20:45:15 : pos3 : RLC   SLID OFF ROADWAY AND FLEW INTO THE WOODS     07/17/2012 20:44:56 : pos3 : RLC   Cross streets: ELM RD//HOWLAND TWP LINE  Geo Comment: STATE RD  Landmark: T MOBILE TOWER  Cross streets: NUTLEY AV NE//BIRCHWOOD AV NE  Geo Comment: COUNTY RD #142  DIRECTLY BETWEEN ELM AND E MARKET/VEH OFF ROADWAY/EB ON BYPASS*
*3531 IVY HILL CIR S******ABDOMINAL PAIN***STA11****07/18/2012 01:33:32 : pos5 : JR   Cross streets: IVY HILL LN//HUNTERS TR  Geo Comment: TOWNSHIP RD #1289  ALI X Coordinate: -080.776398  ALI Y Coordinate: 041.278295  34 YOF SEVERE STOMACH PAINS*
*2295 HOAGLAND BLACKSTUB RD***BAZETTA TWP***SHORTNESS OF BREATH***STA11****07/18/2012 03:50:01 : pos5 : ASP   Landmark: MILLER YOUNT PAVING  Cross streets: RAILROAD TRACKS//PERKINS JONES RD  Geo Comment: COUNTY RD #203/AKA BAZETTA RD  59 YOM C/B*
*3566 LARCHMONT AV**15*BAZETTA TWP***FIRE INFORMATION***STA11****07/18/2012 07:06:10 : pos3 : JD   Cross streets: HOWLAND TWP LINE//ST RTE 5 BYPASS  Landmark: BJ ALAN CO  Geo Comment: COUNTY RD #149  Landmark Comment: **DUAL RESPONSE ZONE FIRE** HOWLAND & BAZETTA    ON TEST/ WILL CALL BACK WHEN FINISHED*
*2016 MILLENNIUM BLVD***BAZETTA TWP***CHEST PAINS***STA11****07/18/2012 12:13:39 : pos1 : CR   Cross streets: ELM RD EXT NE//DEAD END  Landmark: WALMART  Geo Comment: TOWNSHIP RD  37YO M EMPLOYEE GO TO BACK OF BLD*
*20 LARRY LN***BAZETTA TWP***UNKNOWN PROBLEM/UNCLASSIFIED***STA11****07/18/2012 13:19:43 : pos7 : ASP   Cross streets: DURST COLEBROOK RD//DEAD END  Geo Comment: PRIVATE RD*
*2366 ANDREWS DR***BAZETTA TWP***CARDIAC ARREST***STA11****07/18/2012 23:36:19 : pos1 : CS   Cross streets: DEAD END//LYNN DR  Geo Comment: TOWNSHIP RD #1230  70 MALE ///NO PULSE*
*3566 LARCHMONT AV NE**12*HOWLAND TWP***FIRE INFORMATION***STA11****07/19/2012 07:13:02 : pos4 : KH   Landmark Comment: **DUAL RESPONSE ZONE FIRE** HOWLAND & BAZETTA  Landmark: BJ ALAN CO  Cross streets: LAFAYETTE AV NE//BYPASS  ON TEST TODAY WILL CALL WHEN DONE*
*2016 MILLENNIUM BLVD***BAZETTA TWP***SUSPICIOUS PERSON***1321,1333,STA11****07/19/2012 11:03:23 : pos5 : TW   RQUEST SQUAD     07/19/2012 10:55:49 : pos5 : TW   1300 UNITS NOT NEEDING SQUAD AT THSI TIME WILL ADVISE.     07/19/2012 10:53:01 : pos7 : ASP   Cross streets: ELM RD EXT NE//DEAD END  Landmark: WALMART  Geo Comment: TOWNSHIP RD  MALE IN OLDER RED TRAIL BLAIZER HUFFING PROPANE  == ROW 2 TOWARDS FRONT OF STORE*
*2100 MILLENNIUM BLVD***BAZETTA TWP***UNKNOWN PROBLEM/UNCLASSIFIED***STA11****07/19/2012 12:17:51 : pos8 : DV   Landmark: FRESENIUS MEDICAL CARE  Cross streets: ELM RD EXT NE//DEAD END  Geo Comment: TOWNSHIP RD    36 YOFEMALE PT...HYPERKELEMIA*
*2436 NORTHVIEW DR***BAZETTA TWP***UNKNOWN PROBLEM/UNCLASSIFIED***1300,STA11****07/19/2012 15:21:57 : pos6 : LA   CALLER ALREADY CALLED GAS COMPANY // ETA 1 HR     07/19/2012 15:21:36 : pos6 : LA   Cross streets: NILES CORTLAND RD NE//DEAD END  Geo Comment: TOWNSHIP RD #1041  CALLER HAVING ISSUES WITH HER STOVE // STOVE STUCK IN LIGHT POSITION AND GAS FUMES LEAKING INTO THE HOME // CALLER IS AT HER FRIENDS HOUSE NOW // DAUGHTER IN THE VEHICLE IN DRIVEWAY WAITING FOR FD*
*20 LARRY LN***BAZETTA TWP***GENERAL ILLNESS***STA11****07/19/2012 19:15:32 : pos7 : AS   Cross streets: DURST COLEBROOK RD//DEAD END  Geo Comment: PRIVATE RD    SWOLLEN LEGS AND VOMITING 56 YOM*
*2598 ELM RD EXT NE**D*BAZETTA TWP***FIRE ALARM DROP***1300,STA11****07/19/2012 21:06:31 : pos1 : CS   Landmark Comment: BUILDING D/NORTH DOOR/OLD BUILDING  Landmark: TMH REHAB SERVICES  Cross streets: BURNETT DR//TIMBERLINE DR  Geo Comment: STATE RD/AKA ST RTE 5  GEN FIRE ALARM //NO DESCRIPTION FIRE ALARM //OPER DARLENE 8887467539*
*2971 NILES CORTLAND RD NE***BAZETTA TWP***WIRES/TREES DOWN***1300,L11,STA11****07/19/2012 22:46:38 : pos1 : CS   Cross streets: TOBIN LN//ST RTE 305  Landmark: FARMER JIMS INDOOR SOCCER COMPLEX  Geo Comment: STATE RD/AKA ST RTE 46  NBH: MVA AT RTE 305 @ RTE 46 11/12/13  UNMARKED WARREN CITY OFFICER WITH BLUE LIGHTS IN THE VEH IS STANDING BY FOR A TREE DOWN THAT IS BLOCKING THE ENTIRE ROAD*
*2701 ST RTE 305******DOMESTIC***1300,STA11****07/20/2012 16:37:51 : pos4 : JB   Cross streets: NILES CORTLAND RD NE//DEER CREEK TR  Geo Comment: STATE RD  NBH: MVA RTE 305 & RTE 46 & DEER CREEK TONE 11/13/12  SON AND HUSBAND FIGHTING // 17YO NEEDS EMS / FELL LANDED ON HEAD / MALE LEFT POSS IN GARAGE - UNK WEP*
*2444 HOAGLAND BLACKSTUB RD***BAZETTA TWP***ALARM DROP MEDICAL***STA13****07/21/2012 11:07:35 : pos8 : DV   Cross streets: LYNN DR//HARVEST DR  Geo Comment: COUNTY RD #203/AKA BAZETTA RD    FEMALE PT PUSH BUTTON..HOWEVER NEGATIVE CONTACT MADE...  CARE CENTER....8005016370*
*0 FAIRHILL DR NE***HOWLAND TWP***STRUCTURE FIRE***STA11,STA30****07/21/2012 21:21:16 : pos7 : LA   Cross streets: BRENTWOOD AV NE//LONGVIEW DR NE  Cross streets: FAIRHILL DR NE//TIMBERLANE ST NE  Landmark: T MOBILE TOWER  Cross streets: NUTLEY AV NE//BIRCHWOOD AV NE  Geo Comment: COUNTY RD #142  ON FAIRHILL NEAR BRENTWOOD WORKING FIRE // UNKNOWN IF OCCUPIED*
*2498 ELM RD EXT NE***BAZETTA TWP***CRASH WITH REPORTED INJURIES***STA11****07/21/2012 22:32:50 : pos3 : RLC   Cross streets: HOAGLAND BLACKSTUB RD//BURNETT DR  Landmark: BURNETT POOLS  Geo Comment: STATE RD/AKA ST RTE 5  Landmark: CINGULAR TOWER  Cross streets: NILES CORTLAND RD NE//DEAD END  Geo Comment: PRIVATE RD  SB ON ELM IN FRONT OF BURNETT/UNK INJ*
*2772 TALL OAK CIR******ALLERGIC REACTION***STA11****07/22/2012 14:58:40 : pos5 : AS   Cross streets: TIMBER CREEK E//DEAD END  Geo Comment: PRIVATE RD    STUNG BY A WASP// ITICHING// NO TROUBLE BREATHING// 81YOF*
*2619 HOAGLAND BLACKSTUB RD******UNCONSCIOUS/FAINTED***STA11****07/22/2012 21:55:19 : pos3 : RLC   Landmark: BAZETTA CORTLAND OPTIMIST CLUB  Cross streets: JANET DR//JOHNSON PLANK RD  Geo Comment: COUNTY RD #203/AKA BAZETTA RD  ELDERLY FM PASSING IN AND OUT DURING BINGO*
*2016 MILLENNIUM BLVD***BAZETTA TWP***CRASH WITH REPORTED INJURIES***1300,STA11****07/23/2012 15:21:11 : pos7 : tw   Cross streets: ELM RD EXT NE//DEAD END  Landmark: WALMART  Geo Comment: TOWNSHIP RD  PULLING INTO WALMART ON ELM. UNKNOWN VEHICLES, UNKNOWN INJURIES. HAPPENED WHILE VEH WERE TURNING INTO LOT.*
*2600 ELM RD EXT NE**D*BAZETTA TWP***UNKNOWN PROBLEM/UNCLASSIFIED***STA13****07/23/2012 16:48:09 : pos3 : RLC   Landmark Comment: BUILDING D/PHONE # FOR DR OFFICES IN BACK 372-8902  Landmark: TMMG  Cross streets: BURNETT DR//TIMBERLINE DR  Geo Comment: STATE RD/AKA ST RTE 5  URGENT CARE/24 YOF DEHYDRATED*
*2600 ELM RD EXT NE**D****UNKNOWN PROBLEM/UNCLASSIFIED***M11,STA11****07/23/2012 16:48:09 : pos3 : RLC   Landmark Comment: BUILDING D/PHONE # FOR DR OFFICES IN BACK 372-8902  Landmark: TMMG  Cross streets: BURNETT DR//TIMBERLINE DR  Geo Comment: STATE RD/AKA ST RTE 5  URGENT CARE/24 YOF DEHYDRATED*
*0 ST RTE 305******CRASH WITH REPORTED INJURIES***STA11****07/23/2012 17:06:21 : pos3 : RLC   Cross streets: MOSQUITO LAKE//WARREN MEADVILLE RD  Geo Comment: STATE RD/AKA WILSON SHARPSVILLE RD  Landmark: CINGULAR TOWER  Cross streets: ST RTE 305//ST RTE 305  Geo Comment: STATE RD  ALI X Coordinate: -080.748181  ALI Y Coordinate: 041.303991  BY THE DAM*
*4060 WESTLAKE DR******FALL***STA11****07/24/2012 05:06:28 : pos3 : JD   Cross streets: LAKESHORE DR//LAKESHORE DR  Geo Comment: TOWNSHIP RD #964    70 YO M/ FELL OUT OF BED/ CANT GET UP/ GARAGE DOOR OPENER IN GREEN SUV IN DRIVEWAY*
*2580 ELM RD EXT NE**A*BAZETTA TWP***FIRE ALARM DROP***STA11****07/24/2012 09:35:38 : pos7 : RONNIE   Landmark Comment: BUILDING A  Landmark: TMH CENTER FOR SURGERY  Cross streets: BURNETT DR//TIMBERLINE DR  Geo Comment: STATE RD/AKA ST RTE 5     GENERAL FIRE ALARM*
*3487 IVY HILL CIR S*B*****BLEEDING***STA11****07/24/2012 17:22:24 : pos3 : RLC   REFUSES TO SAY WHERE SHE WAS/JUST GOT OUT OF PRISON/ALSO THINKS SHE`S HIGH ON SOMETHING     07/24/2012 17:22:03 : pos3 : RLC   MOM JAIME WARREN     07/24/2012 17:21:38 : pos3 : RLC   Cross streets: IVY HILL LN//HUNTERS TR  Geo Comment: TOWNSHIP RD #1289  Landmark: A T & T  Cross streets: HOAGLAND BLACKSTUB RD//BURNETT DR  Geo Comment: STATE RD/AKA ST RTE 5  ALI X Coordinate: -080.776398  ALI Y Coordinate: 041.278295  MOM VERY 19/BLOOD GUSHING FROM HER EYE*
*2034 TIMBER CREEK E******UNCONSCIOUS/FAINTED***STA11****07/25/2012 13:18:57 : pos3 : JG   Cross streets: BEAVER TR//TALL OAKS CIR  Geo Comment: TOWNSHIP RD #1371  18 YOM PASSED OUT  IS CON NOW.   HAD WISDOM TEETH OUT THIS MORNING*
*4060 WESTLAKE DR***BAZETTA TWP***CHECK WELFARE***1300,STA11****07/25/2012 13:44:25 : pos6 : GB   1321 REQ FD HEAD THAT WAY JUST IN CASE///NEG S-5     07/25/2012 13:32:20 : pos1 : CR   Cross streets: LAKESHORE DR//LAKESHORE DR  Geo Comment: TOWNSHIP RD #964  JAMES MICHEIL MCMANN 70 YO M HAVENT HEARD FROM HIM TODAY LINE IS BUSY FOR 5 HRS 330-638-7221 ADV THEY WERE OUT THERE TUES AND OTHER CASEWORKER ADV HAD DAMAGE TO VEH  WHEN ASKED WHAT HAPPENED HE ADV THAT HE HIT A CHILD ON BIKE AND WHILE SHE WAS THERE RAN OVER CURB AND TRASH CAN*
*2600 ELM RD EXT NE**D*BAZETTA TWP***UNKNOWN PROBLEM/UNCLASSIFIED***STA13****07/26/2012 09:59:07 : pos3 : JG   Landmark Comment: BUILDING D/PHONE # FOR DR OFFICES IN BACK 372-8902  Landmark: TRUMBULL MAHONING MEDICAL GROUP  Cross streets: BURNETT DR//TIMBERLINE DR  Geo Comment: STATE RD/AKA ST RTE 5  55 YOM WITH A POSSIBLE BEGINNING OF A STEMI   EKG IRREGULAR   LIGHTS AND SIRENS*
*773 EVERETT HULL RD***BAZETTA TWP***FIRE INFORMATION***STA11****07/26/2012 16:45:16 : pos7 : AS   Cross streets: DURST CLAGG RD//HOAGLAND BLACKSTUB RD  Landmark: BAZETTA FIRE DEPARTMENT #11  Geo Comment: COUNTY RD #193    STATION COVERAGE*
*0 ELM RD EXT NE***BAZETTA TWP***CRASH WITH REPORTED INJURIES***1322,1324,STA11,STA12****07/26/2012 18:02:05 : pos5 : TW   1324 REQUESTED SQUAD.     07/26/2012 18:01:26 : pos7 : AS     Cross streets: ST RTE 5 BYPASS//HOAGLAND BLACKSTUB RD  Geo Comment: STATE RD/AKA ST RTE 5     07/26/2012 18:00:01 : pos5 : TW   W145334 / EYY4492     07/26/2012 17:58:28 : pos4 : JB   VEHS IN FRONT OF COLE VALLEY /     07/26/2012 17:52:04 : pos6 : LA   Cross streets: ELM RD//HOWLAND TWP LINE  Geo Comment: STATE RD  ALI X Coor
*2270 PERKINS JONES CT***BAZETTA TWP***BLEEDING***STA11****07/27/2012 00:18:35 : pos6 : MT   Cross streets: PERKINS JONES RD//DEAD END  Geo Comment: COUNTY RD/SIDE STREET LEFT SIDE AFTER SECOND CURVE    75 YOF RECTAL BLEED*
*3850 ELM RD NE***BAZETTA TWP***UNCONSCIOUS/FAINTED***STA13****07/27/2012 08:22:28 : pos4 : KH   IN FRONT OF BUILDING     07/27/2012 08:22:14 : pos4 : KH   Landmark Comment: **DUAL RESPONSE ZONE FIRE AND EMS ** HOWLAND & BAZETTA  Landmark: VISTA WINDOW COMPANY  Cross streets: TOWNSHIP LINE//ST RTE 5 BYPASS  Geo Comment: DUAL RESP ZONE FIRE & EMS BAZETTA & HOWLAND  FEMALE EMPLOYEE / GETTING READY TO PASS OUT /  40 YOF*
*20 LARRY LN******FALL***STA13****07/28/2012 01:27:36 : pos3 : GJ   Cross streets: DURST COLEBROOK RD//DEAD END  Geo Comment: PRIVATE RD    56 YOM FELL OUT OF BAD//HX CHF//ACTING OUT OF SORTS//*
*2057 WALMART DR NE***BAZETTA TWP***BLOOD PRESSURE***STA13****07/28/2012 09:08:44 : pos7 : PC   Cross streets: ELM RD//DEAD END  Landmark: EAT N PARK RESTAURANT  Geo Comment: PRIVATE RD  UNK AGE FEMALE    LOW BLOOD PRESSURE PROBLEM*
*2057 WALMART DR NE***BAZETTA TWP***BLOOD PRESSURE***1300,STA11,STA13****07/28/2012 09:08:44 : pos7 : PC   Cross streets: ELM RD//DEAD END  Landmark: EAT N PARK RESTAURANT  Geo Comment: PRIVATE RD  UNK AGE FEMALE    LOW BLOOD PRESSURE PROBLEM*
*3328 EAGLESLOFT******SHORTNESS OF BREATH***STA11****07/28/2012 14:22:00 : pos3 : JG   Cross streets: DEER TR//TRAPPERS TR  Geo Comment: PRIVATE RD  67 YOF  HAVING A HARD TIME BREATHING   CALLER/HUSBAND ADV NEG LIGHTS OR SIRENS*
*2619 HOAGLAND BLACKSTUB RD******FALL***STA11****07/28/2012 15:06:06 : pos1 : JF   Cross streets: JANET DR//JOHNSON PLANK RD  Landmark: CANDLELITE KNOLLS  Geo Comment: COUNTY RD #203/AKA BAZETTA RD  UNK AGED FEMALE FELL, POSS BACK INJURY. IS C&B, FEMALE IS INSIDE THE SMALL HALL.*

*/

public class DispatchVisionAirParser extends FieldProgramParser {
  
  private String[] prefixs;
  
  public DispatchVisionAirParser(String prefix, String defCity, String defState) {
    this(new String[]{prefix}, null, defCity, defState);
  }
  
  public DispatchVisionAirParser(String prefix, String varFields, String defCity, String defState) {
    this(new String[]{prefix}, varFields, defCity, defState);
  }
  
  public DispatchVisionAirParser(String[] prefixs, String defCity, String defState) {
    this(prefixs, null, defCity, defState);
    this.prefixs = prefixs;
  }
  
  public DispatchVisionAirParser(String[] prefixs, String varFields, String defCity, String defState) {
    super(defCity, defState,
           "ADDR APT UNK CITY SKIP+? CALL! " + (varFields != null ? varFields + " " : "") + "UNK+? EXTRA! INFO+");
    this.prefixs = prefixs;
  }
  
  private static final Pattern DELIM = Pattern.compile("(?<!\\*)\\* ");

  @Override
  protected boolean parseMsg(String body, Data data) {
    boolean found = false;
    for (String prefix : prefixs) {
      if (body.startsWith(prefix)) {
        body = body.substring(prefix.length()).trim();
        found = true;
        break;
      }
    }
    if (!found) return false;
    if (body.endsWith("*")) body = body.substring(0,body.length()-1).trim();
    return parseFields(DELIM.split(body), 12, data);
  }
  
  private class BaseAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("0 ")) field = field.substring(2).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern START_STAR_PTN = Pattern.compile("^\\*+");
  private class BaseCallField extends CallField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() == 0) return false;
      field = START_STAR_PTN.matcher(field).replaceFirst("");
      super.parse(field, data);
      return true;
    }
  }

  private static final Pattern EXTRA_MARKER = Pattern.compile("\\b(\\d?\\d/\\d?\\d/\\d{4}) (\\d?\\d:\\d?\\d:\\d?\\d(?: [AP]M)?) : (pos\\d+) : [A-Za-z0-9]+\\b");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private static final Pattern EXTRA_DELIM = Pattern.compile("\\*\\* EMD (?:Case Entry Finished|Case Complete|Recommended Dispatch) \\*\\*|\\bResponse Text:|\\bKey Questions:|\\bGeo Comment:|\\bLandmark Comment:|Narrative ?:|\\b(?=Cross Streets:|Landmark:|NBH:)|  +", Pattern.CASE_INSENSITIVE);
  private class BaseExtraField extends Field {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = EXTRA_MARKER.matcher(field);
      if (!match.find()) return false;
      data.strDate = match.group(1);
      String time = match.group(2);
      if (time.endsWith("M")) {
        setTime(TIME_FMT, time, data);
      } else {
        data.strTime = time;
      }
      data.strChannel = match.group(3);
      field = field.substring(match.end()).trim();
      
      for (String fld1 : EXTRA_MARKER.split(field)) {
        for (String fld2 : EXTRA_DELIM.split(fld1)) {
          fld2 = fld2.trim();
          if (fld2.length() == 0) continue;
          
          String upshift = fld2.toUpperCase();
          if (upshift.startsWith("LANDMARK:")) {
            if (data.strPlace.length() == 0) data.strPlace = fld2.substring(9).trim();
            continue;
          }
          
          if (upshift.startsWith("CROSS STREETS:")) {
            fld2 = fld2.substring(14).trim();
            String saveCross = data.strCross;
            String prefix = "";
            int pt = fld2.indexOf("//");
            if (pt >= 0) {
              prefix = fld2.substring(0,pt).trim();
              fld2 = fld2.substring(pt+2).trim();
            }
            Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, fld2);
            if (res.getStatus() > 0) {
              res.getData(data);
              fld2 = res.getLeft();
            } else {
              data.strCross = fld2;
              fld2 = "";
            }
            data.strCross = append(prefix, " / ", data.strCross);
            if (saveCross.length() > 0) data.strCross = saveCross;
          }
          
          data.strSupp = append(data.strSupp, " / ", fld2);
        }
      }
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME CH X PLACE INFO";
    }
  }
  
  private class UnknownField extends Field {
    @Override
    public void parse(String field, Data data) {
      data.strSupp = field;
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("ADDR")) return new BaseAddressField();
    if (name.equals("CALL")) return new BaseCallField();
    if (name.equals("EXTRA")) return new BaseExtraField();
    if (name.equals("UNK")) return new UnknownField();
    return super.getField(name);
  }
  
  
}
