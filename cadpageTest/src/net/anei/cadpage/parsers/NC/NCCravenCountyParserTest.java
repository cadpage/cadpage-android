package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Craven County, NC
Contact: Active911
Agency name: Dover Vol Fire Dept
Location: Dover, NC, United States
Sender: dispatch@cravencountync.gov

(CC911) Location: 317 W WILSON ST Dover Medical Call Time: 07/23/13 13:37 Narrative:  3261 REQ LIFT ASSIST  asked for conformation on west or east,,they stated west  73 yof..stomach pain..res 252-526-5092..annie bryans  35.2170695965602 -77.4407216603698
(CC911) Location: 500 DAUGHERTY RD BLK Dover Fire Unknown Size or Type Call Time: 07/22/13 19:22 Narrative:  35.2723029915473 -77.415604399778
(CC911) Location: 500 DAUGHERTY RD Dover Fire Unknown Size or Type Call Time: 07/22/13 19:22 Narrative:  35.2723029915473 -77.415604399778
(CC911) Location: 319 E OLD DOVER RD Dover Fire Grass/Brush Call Time: 07/19/13 16:20 Narrative:  adv same is out of control  wheat filed fire  35.2201800890001 -77.428904899
(CC911) Location: W KORNEGAY ST Dover Veh Crash-Injury  Call Time: 07/05/13 20:08 Narrative:  3262-8 waiting mp  03T200000Z.SEND XXA2, 1050 2 PI'S  W KORNEGAY ST/ N WEST ST DOVER   CALLED IN BY THE FIRE DEPT  1050 2 pi's  35.2187642910001 -77.437546106
(CC911) Location: W KORNEGAY ST Dover Veh Crash-Injury  Call Time: 07/05/13 20:08 Narrative:  1050 2 pi's  35.2187642910001 -77.437546106
(CC911) Location: OLD US 70 HWY Dover Traffic All Other Call Time: 07/05/13 08:26 Narrative:  between railroad and tilghmans garage  E911 Info - Class of Service: WPH2  35.2188136290001 -77.452486564
(CC911) Location: 235 JEREMY ST Cove City Security Check Residential Call Time: 06/28/13 19:00 Narrative:  this one popped up early.....the next one after midnite tonight will be the one that needs to be handled.....  compl advised that the subject that lived here has died and that she adv that she and her daughter will be moving items out of the residence during the day, and that no one should be there at night...she adv that her daughter can be reached at 252-474-7581...Ms Latham....\nThis will be set up for the next two weeks, she will call back if she needs it extended any longer, although she believes that 2 weeks will be long enough to clear the residence....\n  35.2253174803295 -77.2899399601001
(CC911) Location: 441 W KORNEGAY ST Dover Fire Forest/Woods Call Time: 06/25/13 17:16 Narrative:  35.2187450700001 -77.445917473
(CC911) Location: 2229 WINTERGREEN RD Cove City Fire Alarm Business Call Time: 06/19/13 07:02 Narrative:  general fire alarm - fire arm physicians  attempting to contact  oper 7064 

Contact: Active911
Agency name: No 7 Township Fire and Rescue
Location: New Bern, NC, United States
Sender: dispatch@cravencountync.gov 

(CC911) Location: 1000 US 70 HWY E New Bern Fire Vehicle  Call Time: 07/24/13 10:23 Narrative:  caller adv that there is someone out with the veh  caller adv that it is a car poss a camaro  caller adv that there is a veh on fire in the pva of the waffle house  E911 Info - Class of Service: BUSN  35.0821437500001 -77.030651275
(CC911) Location: 1000 US 70 HWY E Fire Vehicle  Call Time: 07/24/13 10:23 Narrative:  caller adv that there is someone out with the veh  caller adv that it is a car poss a camaro  caller adv that there is a veh on fire in the pva of the waffle house  E911 Info - Class of Service: BUSN  -361 -361
(CC911) Location: 1000 US 70 HWY Fire Vehicle  Call Time: 07/24/13 10:23 Narrative:  caller adv that it is a car poss a camaro  caller adv that there is a veh on fire in the pva of the waffle house  E911 Info - Class of Service: BUSN  -361 -361
(CC911) Location: 160 BLOUNT BRIMAGE DR New Bern Medical Call Time: 07/23/13 16:26 Narrative:  JAS128 REQ LIFT ASSIST  R20 ADV SEND M/A  FEMALE SHAKING..60 YOF..  E911 Info - Class of Service: RESD  35.050584621 -77.076017054
(CC911) Location: 3907 OLD CHERRY POINT RD 1 New Bern Citizen Assist Call Time: 07/20/13 16:40 Narrative:  CALLER ADV THAT SHE DOESNT THINK THAT SHE IS INJURED  UNABLE TO GET UP  HAS FALLEN  53 YOF  E911 Info - Class of Service: RESD  35.0438854930001 -77.002648235
(CC911) Location: 313 HOKE ST New Bern Fire Alarm Business Call Time: 07/20/13 07:16 Narrative:  op 7108  showing office smoke dector  arc craven #3 group home 
(CC911) Location: WILLIAMS RD New Bern Veh Crash-Injury  Call Time: 07/19/13 15:50 Narrative:  in the bj pva  with injuries  E911 Info - Class of Service: WRLS  35.081639792 -77.031452224
(CC911) Location: 3707 OLD CHERRY POINT RD New Bern Fire Structure Call Time: 07/18/13 22:53 Narrative:  the barn is on fire  E911 Info - Class of Service: WPH2  35.046907622 -77.004935255
(CC911) Location: 2713 US 70 HWY E New Bern Gas Leak Non-confirmed Call Time: 07/18/13 09:28 Narrative:  pizza hut does not open until 10:00 am  caller is at state farm and can smell gas  gas leak  pizza hut  35.057343766 -77.0195029129999
(CC911) Location: 2703 US 70 HWY E New Bern Alarm Business Call Time: 07/18/13 09:31 Narrative:  notified c141  attempt to contact call list  oper 7059  general burg alarm  no premise number  ashley furniture  35.0588429600001 -77.019907783
(CC911) Location: 2713 US 70 HWY E New Bern Gas Leak Non-confirmed Call Time: 07/18/13 09:28 Narrative:  caller is at state farm and can smell gas  gas leak  pizza hut  35.057343766 -77.0195029129999
(CC911) Location: <UNKNOWN> New Call Call Time: 07/18/13 09:28 Narrative:  caller is at state farm and can smell gas  gas leak  pizza hut  -361 -361
(CC911) Location: 3707 OLD CHERRY POINT RD New Bern Fire Structure Call Time: 07/17/13 22:35 Narrative:  KENNETH REASON BELIVES THE FIRE IS INTENTIONAL  adv that there is no vehicles or gasoline or anything like that  adv that the garage is on fire  E911 Info - Class of Service: WPH2  35.046907622 -77.004935255
(CC911) Location: 4711 TRENT RIVER DR New Bern Fire Heat Alarm Call Time: 07/16/13 15:05 Narrative:  op oab  showing attic smoke dector  last name is carptner  35.0760681150001 -77.100520793
(CC911) Location: 4316 US 70 HWY E New Bern New Call Call Time: 07/14/13 22:59 Narrative:  E911 Info - Class of Service: WPH2  35.028654524 -77.001495556
(CC911) Location: 613 ALEXIS DR New Bern Fire Structure Call Time: 07/11/13 20:17 Narrative:  possible electrical fire  fire in the wall  E911 Info - Class of Service: WRLS  35.0818287700001 -77.050250481
(CC911) Location: 423 SATTERFIELD DR New Bern Fire Alarm Residence Call Time: 07/11/13 17:52 Narrative:  252-342-1638  terence juion/oper 469- fire alarm - living room smoke dector  35.05062387 -77.010924453
(CC911) Location: 1213 US 70 HWY E New Bern Fire Unknown Size or Type Call Time: 07/10/13 17:53 Narrative:  call came in from craven tire  adv can see smoke and flames coming from same  adv same is behind craven pre cast and is on the rr trcts in the area  E911 Info - Class of Service: BUSN  35.076528904 -77.029910905
(CC911) Location: 1100 OLD CHERRY POINT RD New Bern Fire Alarm Business Call Time: 07/10/13 06:48 Narrative:  correction 31p5 advises last  21P5 10-23 NOTHING SHOWING SINGLE STORY STRUCTURE  21p5 10-17  31p5 enr  31p1 enr  oper bcw  location fire alarm activation from keypad  business: machine and welding su
(CC911) Location: 2600 STREETS FERRY RD Vanceboro New Call Call Time: 07/10/13 06:57 Narrative:  35.2375956970001 -77.1366757339999
(CC911) Location: 1100 OLD CHERRY POINT RD New Bern Fire Alarm Business Call Time: 07/10/13 06:48 Narrative:  oper bcw  location fire alarm activation from keypad  business: machine and welding supply co 
(CC911) Location: US 70 HWY E New Bern Veh Crash-Property Call Time: 07/09/13 13:55 Narrative:  ON THE ROAD  NO PI  10-50  E911 Info - Class of Service: WPH2  35.0378980580001 -77.0072286239999
(CC911) Location: 105 HOLLY BERRY RD New Bern New Call Call Time: 07/08/13 18:20 Narrative:  BOTH SUBJS ON THE PHONE SOUNDED LIKE THEY WERE HAVING SOME DIFF BREATHING.. ALL OCCUPANTS ARE OUT OF THE HOUSE  FIRE IS OUT.. HOUSE IF FULL OF SMOKE...  GREASE FIRE ON STOVE...  E911 Info - Class of Service: WRLS  35.031321119 -76.994701865
(CC911) Location: US 70 HWY E New Bern Veh Crash-Injury  Call Time: 07/07/13 15:19 Narrative:  1 IS ON THE OUTSIDE LANE AND THE OTHER IS IN THE OTHER LANE  03T400004F.SEND XAA2, CREAM COLORED TRUCK AND A WHITE FORD EXPLORER IN THE ROADWAY ON HWY 70 E WEST   BOUND NEAR AIRPORT RD UNK FURTHER IF IT IS AN ACCIDENT       CRC1/MCW  WEST BOUND LANE TOWARDS NEW BERN  E911 Info - Class of Service: WPH2  35.0746740270001 -77.027927135
(CC911) Location: 104 WADKINS BLVD New Bern Fire Structure Call Time: 07/06/13 12:19 Narrative:  caller adv that he put a fire extinguisher  oven door is closed, fire still going inside the oven  the fire is still inside the oven  caller adv that everyone is out of the house  call 800-357-4911  john oven fire that wont go out  34.963379935 -76.937906595
(CC911) Location: 212 KALE RD New Bern Fire Structure Call Time: 07/03/13 14:26 Narrative:  FIRE IN THE WALL  E911 Info - Class of Service: BUSN  35.067371253 -77.0292738809999
(CC911) Location: US 70 HWY E New Bern Veh Crash-Property Call Time: 07/02/13 13:09 Narrative:  CALLER ADV IT WAS A MINI VAN  910-393-8659  MALE SUBJ OUT OF THE VEHICLE IS RIGHT ON THE LINE  Call #: 1209 - E911 Info - Class of Service: WRLS  UNSOL.XAA2.SEND.20130702131222.    TO: CRC1    -069877 20130702 13:12:22   0CCA0082D8     FROM: XAA2            20130702 13:12:12  SEND CRC1,  10-4  03SZ00001R.SEND XAA2, US 70 HWY E PAST E FISHER AVE THERE IS A SINGLE VEHICLE ACCIDENT IN THE MEDIAN   AND CALLER SAYS THAT THE SUBJECT NEEDS TO BE SPOKEN TO BY TROOPER     CRC1/MCW  NO PI AND SUBJ IS OUT OF SAME  SINGLE VEHICLE ACCIDENT IN THE MEDIAN  E911 Info - Class of Service: WPH2  34.9889567000001 -76.9817226059999
(CC911) Location: US 70 HWY E New Bern Veh Crash-Injury  Call Time: 07/02/13 12:14 Narrative:  BLOCKIGN TRAFFIC  UNK PII'S  2 VEHICLES IN THE ROADWAY  35.0381720890001 -77.0067954789999
(CC911) Location: 4890 WILCOX RD New Bern New Call Call Time: 07/02/13 11:24 Narrative:  subjs still on the roadway  occured in the roadway  male subj says he is fine  bicyclist ran into the back of callers car  E911 Info - Class of Service: WPH2  35.0050543680001 -76.992681367
(CC911) Location: US 70 HWY E New Bern Veh Crash-Injury  Call Time: 07/01/13 16:32 Narrative:  NISSAN DEALERSHIP IS ON THE LEFT  CORRECTION OUT OF THE ROADWAY INTO THE MEDIAN  HE DID MOVE HIS CAR OUT OF THE MEDIAN  18 WHEELER PULLED INTO THE TOYOTA DEALERSHIP AND ANOTHER CAR SLAMMED ON BREAKS AND ENDED UP THRU THE MEDIAN AND OTHER SIDE OF THE ROADWAY  E911 Info - Class of Service: WPH2  35.05044365 -77.0144657239999
(CC911) Location: 2500 US 70 HWY E New Bern Veh Crash-Injury  Call Time: 07/01/13 16:32 Narrative:  NISSAN DEALERSHIP IS ON THE LEFT  CORRECTION OUT OF THE ROADWAY INTO THE MEDIAN  HE DID MOVE HIS CAR OUT OF THE MEDIAN  18 WHEELER PULLED INTO THE TOYOTA DEALERSHIP AND ANOTHER CAR SLAMMED ON BREAKS AND ENDED UP THRU THE MEDIAN AND OTHER SIDE OF THE ROADWAY  E911 Info - Class of Service: WPH2  35.060617193 -77.019460551
(CC911) Location: 935 US 70 HWY E New Bern Fire Alarm Business Call Time: 07/01/13 07:53 Narrative:  OP 28  RESTROOM PULL STATION 
(CC911) Location: OLD CHERRY POINT RD New Bern New Call Call Time: 06/29/13 22:49 Narrative:  two car mvc  E911 Info - Class of Service: WRLS  35.0766323940001 -77.027181172
(CC911) Location: WILLIAMS RD New Bern Veh Crash-Property Call Time: 06/29/13 11:11 Narrative:  03SW000038.SEND XAA2, 2 CAR 10-50 WILLIAMS RD AND HWY 70 E ON SERVICE RD..UNKNOW PIS      CRC1/ORMOND  NO INJURIES  ON THE SERVICE RD AT BURGER KING  IN THE ROADWAY  2 VEH  E911 Info - Class of Service: WPH2  35.081639792 -77.031452224
(CC911) Location: 4001 OLD CHERRY POINT RD New Bern Veh Crash-Injury  Call Time: 06/29/13 08:09 Narrative:  wreck..thurman rd old cherry point rd..2 car 10-50  E911 Info - Class of Service: BUSN  35.0413469050001 -77.0010687019999
(CC911) Location: 235 JEREMY ST Cove City Security Check Residential Call Time: 06/28/13 19:00 Narrative:  this one popped up early.....the next one after midnite tonight will be the one that needs to be handled.....  compl advised that the subject that lived here has died and that she adv that she and her daughter will be moving items out of the residence during the day, and that no one should be there at night...she adv that her daughter can be reached at 252-474-7581...Ms Latham....\nThis will be set up for the next two weeks, she will call back if she needs it extended any longer, although she believes that 2 weeks will be long enough to clear the residence....\n  35.2253174803295 -77.2899399601001
(CC911) Location: 1604 US 70 HWY E 1 New Bern Medical Call Time: 06/28/13 11:50 Narrative:  60 y/o m  fell in the front yard and his hip his hurting real bad  E911 Info - Class of Service: WRLS  35.073692039 -77.026358143
(CC911) Location: 617 ALEXIS DR New Bern Fire Unknown Size or Type Call Time: 06/25/13 18:32 Narrative:  switch traffic to state fire per command  21 station 3 standing by  21p2 on scene est command  2062 standing by at station  21p4 responding  2062 standing by at building  21p7 on scene  21p2 advised to standby at station  single story residential structure nothing showing  31p4 responding  31p5 responding  21p2 responding to scene  21p7 responding  smells smoke  systems are out thinks her house got struck by lighting  E911 Info - Class of Service: RESD  35.081622554 -77.050829613
(CC911) Location: 617 ALEXIS DR New Bern Fire Unknown Size or Type Call Time: 06/25/13 18:32 Narrative:  smells smoke  systems are out thinks her house got struck by lighting  E911 Info - Class of Service: RESD  35.081622554 -77.050829613
(CC911) Location: 3305 US 70 HWY E New Bern Veh Crash-Injury  Call Time: 06/25/13 12:15 Narrative:  35.0497774670001 -77.014614517
(CC911) Location: 4607 WEST FAIRWAY DR New Bern New Call Call Time: 06/25/13 11:05 Narrative:  house fire  E911 Info - Class of Service: BUSN  35.0795352980001 -77.097099978
(CC911) Location: GARNER RD New Bern Veh Crash-Injury  Call Time: 06/24/13 17:03 Narrative:  03SR00007F.SEND XAA2, 2 CAR 10-50...GARNER RD/US 70 HWY..EAST BOUND..  CRC1/ORMOND  Call #: 342 - E911 Info - Class of Service: WRLS  AT THE INTERSECTION  POSSIBLE PI'S  ONE IN DITCH ONE IN ROADWAY  2 VEH  ACROSS FROM HYUNDAI DEALERSHIP  E911 Info - Class of Service: WPH2  35.0563179980001 -77.017648503
(CC911) Location: GARNER RD New Bern Veh Crash-Injury  Call Time: 06/24/13 17:03 Narrative:  03SR00007F.SEND XAA2, 2 CAR 10-50...GARNER RD/US 70 HWY..EAST BOUND..  CRC1/ORMOND  Call #: 342 - E911 Info - Class of Service: WRLS  AT THE INTERSECTION  POSSIBLE PI'S  ONE IN DITCH ONE IN ROADWAY  2 VEH  ACROSS FROM HYUNDAI DEALERSHIP  E911 Info - Class of Service: WPH2  35.0563179980001 -77.017648503
(CC911) Location: Veh Crash-Injury  Call Time: 06/24/13 17:03 Narrative:  AT THE INTERSECTION  POSSIBLE PI'S  ONE IN DITCH ONE IN ROADWAY  2 VEH  ACROSS FROM HYUNDAI DEALERSHIP  E911 Info - Class of Service: WPH2  35.055946 -77.017915
(CC911) Location: WILLIAMS RD New Bern Veh Crash-Property Call Time: 06/24/13 16:32 Narrative:  2 car 10-50...rd way..no pis..shp on scene  35.081639792 -77.031452224
(CC911) Location: 2601 HOUNDS TRL New Bern Fire Alarm Residence Call Time: 06/24/13 16:05 Narrative:  OPER UYC  ATTEMPTING TO CONTACT  SMOKE DETECTION HALLWAY  35.0868108870001 -77.0722225769999
(CC911) Location: US 70 HWY E New Bern Veh Crash-Property Call Time: 06/23/13 21:25 Narrative:  truck in the ditch, burg veh pulled off with it  before you get to taberna  east bound side of the road  truck in the ditch  35.05044365 -77.0144657239999
(CC911) Location: US 70 HWY E New Bern Veh Crash-Injury  Call Time: 06/23/13 19:09 Narrative:  252-916-1931  WHITE OR SILVER TRUCK  unk on  injuries  dodge dakota blue or silver  truck just hydroplaned in the median  E911 Info - Class of Service: WPH2  35.0564455840001 -77.017310774
(CC911) Location: 322 FALCON BRIDGE DR New Bern Fire Alarm Residence Call Time: 06/23/13 10:39 Narrative:  ref #  b3702705 oper 417  called in by alarm comp fire alarm coming from the entry way x4  res of mike smasal  34.9730731060001 -76.967750343
(CC911) Location: 127 KELSO RD New Bern Fire Unknown Size or Type Call Time: 06/23/13 02:42 Narrative:  caller adv that it doesnt appear to be sparking any longer  in the area of this location  caller adv it was a huge explosion then sparks  transformer just blew  E911 Info - Class of Service: WPH2  35.079316722 -77.04852442
(CC911) Location: COUNTY LINE RD New Bern Veh Crash-Injury  Call Time: 06/22/13 18:06 Narrative:  SMALL GREEN PICK UP  DIRT ROAD SECTION  RAN OFF THE ROAD AND HIT A RAIL  2 SUBJS IN SAME  VEHICLE ACCIDENT  E911 Info - Class of Service: WPH2  34.993298462 -76.9900088319999
(CC911) Location: 1200 BRICES CREEK RD BLK New Bern Veh Crash-Injury  Call Time: 06/22/13 11:31 Narrative:  21p3 10-23  spoke with new bern city power adv they have been dispatched  21p2 10-23  213 10-23  214 10-23 levl 1 staging  213 10-17  214 10-17  UNSOL.XAA2.SEND.20130622114046.  TO: CRC     -230822 20130622 11:40:46   0CCA00812D     FROM: XAA2            20130622 11:40:46  SEND CRC,  10-4  21p3 10-7  03SP00005X.SEND XAA2, NEED A TROOPER TO RESPOND TO THE AREA OF 1800 BRICES CREEK RD REF TO A SINGLE VEH 10-50 4X4 KIA SPORTAGE LIGHT GREEN IN COLOR HIT A TELEPHONE POLE LINE IS 3   FT OFF THE GROUND SAME IS IN THE CURVE NEAR PERRYTOWN RD  21p6  10-17  same will be in the curve  line is about 3ft off the ground believe same is a power line  poss 1 pi  same hit a telephone pole  1050 4x4 sportage 35.0714569276583 -77.0556358655448
(CC911) Location: 1200 BRICES CREEK RD New Bern Veh Crash-Injury  Call Time: 06/22/13 11:31 Narrative:  21p3 10-23  spoke with new bern city power adv they have been dispatched  21p2 10-23  213 10-23  214 10-23 levl 1 staging  213 10-17  214 10-17  UNSOL.XAA2.SEND.20130622114046.  TO: CRC     -230822 20130622 11:40:46   0CCA00812D     FROM: XAA2            20130622 11:40:46  SEND CRC,  10-4  21p3 10-7  03SP00005X.SEND XAA2, NEED A TROOPER TO RESPOND TO THE AREA OF 1800 BRICES CREEK RD REF TO A SINGLE VEH 10-50 4X4 KIA SPORTAGE LIGHT GREEN IN COLOR HIT A TELEPHONE POLE LINE IS 3   FT OFF THE GROUND SAME IS IN THE CURVE NEAR PERRYTOWN RD  21p6  10-17  same will be in the curve  line is about 3ft off the ground believe same is a power line  poss 1 pi  same hit a telephone pole  1050 4x4 sportage 35.0714569276583 -77.0556358655448
(CC911) Location: 1800 BRICES CREEK RD New Bern Veh Crash-Injury  Call Time: 06/22/13 11:31 Narrative:  poss 1 pi  same hit a telephone pole  1050 4x4 sportage light green kia  E911 Info - Class of Service: WPH2  35.0664350722301 -77.0733944230661
(CC911) Location: 3720 US 70 HWY E New Bern Fire Alarm Business Call Time: 06/21/13 08:54 Narrative:  op ybx  showing key pad fire  the plant farm 
(CC911) Location: 305 SCOTT ST New Bern Medical Call Time: 06/21/13 07:47 Narrative:  no breathing  correction f  76 yo m  female is not responding  E911 Info - Class of Service: RESD  35.0896587230001 -77.038620737
(CC911) Location: OLD AIRPORT RD New Bern Veh Crash-Injury  Call Time: 06/19/13 16:55 Narrative:  trooper on scene advised leg pain  male subject struck riding bicycle  35.0661855720001 -77.0336583169999
(CC911) Location: US 70 HWY E New Bern Veh Crash-Property Call Time: 06/19/13 11:59 Narrative:  small child has bleeding ear  E911 Info - Class of Service: WPH2  Call #: 9732 - UNSOL.XAA2.SEND.20130619115603.    TO: CRC     -229811 20130619 11:56:03   0CCA0080AC     FROM: XAA2            20130619 11:56:03  SEND CRC,  10-4  Call #: 9732 - 03SM00004A.SEND XAA2, EASTBOUND ON US 70 HWY E AND E FISHER AVE REPORT OF A 10-50 VEHICLES ARE OFF THE ROAD WITH NO INJURIES    CRC/DANI  Call #: 9732 - EAST BOUND  Call #: 9732 - TURQUOISE NISSAN CENTRA  Call #: 9732 - CHEVY IMPALA SILVER IN COLOR  Call #: 9732 - NO INJURIES  Call #: 9732 - OFF THE ROADWAY  Call #: 9732 - 2 VEH 10-50  Call #: 9732 - ACROSS FROM NC FOREST SERVICE STATION  Call #: 9732 - E911 Info - Class of Service: WPH2  34.988826513 -76.981922853
(CC911) Location: E FISHER AVE New Bern Veh Crash-Property Call Time: 06/19/13 11:51 Narrative:  34.988826513 -76.981922853
(CC911) Location: 500 W  THURMAN RD New Bern Fire Hazardous Cond. Gas Oil Call Time: 06/18/13 19:37 Narrative:  right above the ground tanks  caller adv that they are putting fire extinguisher  veh has been moved from the gas pumps  veh on fire  comp is jennifer  E911 Info - Class of Service: BUSN  35.03787971 -77.008088887
(CC911) Location: 307 JAMES ST New Bern Medical Call Time: 06/17/13 18:53 Narrative:  20p3-17  male subj says he is dehydrated  he has fallen and is real weak  38 yom  E911 Info - Class of Service: RESD  35.0872164260001 -77.029992196
(CC911) Location: US 70 HWY E New Bern Veh Crash-Property Call Time: 06/17/13 15:27 Narrative:  NO INJURIES  3 CAR 10-50  SMAE IS IN THE TURN LN  IN THE RD WAY  E911 Info - Class of Service: WPH2  35.081639792 -77.031452224
(CC911) Location: TWIN SPANS New Bern Veh Crash-Property Call Time: 06/17/13 13:01 Narrative:  heather hopkinson 671-0645  by the pembroke  on the briddge by downtown  boat on a bridge  E911 Info - Class of Service: WPH2  -361 -361
(CC911) Location: Veh Crash-Property Call Time: 06/17/13 13:01 Narrative:  heather hopkinson 671-0645  by the pembroke  on the briddge by downtown  boat on a bridge  E911 Info - Class of Service: WPH2  35.096147 -77.045037
(CC911) Location: 2600 OLD CHERRY POINT RD New Bern Medical Call Time: 06/15/13 14:27 Narrative:  2062 REQUESTING M/A  everything on her right side hurts  in pain  78 y/o f fell in the bathroom on he rright side  E911 Info - Class of Service: BUSN  35.065000572 -77.015222716
(CC911) Location: 3919 OLD CHERRY POINT RD A New Bern Fire Structure Call Time: 06/14/13 19:37 Narrative:  burner on stove was on fire..now out  E911 Info - Class of Service: RESD  35.0422642837816 -77.0012206940276
(CC911) Location: 417 MM HWY New Bern Veh Crash-Property Call Time: 06/14/13 11:23 Narrative:  UNSOL.XAA2.SEND.20130614112732.  TO: CRC1    -068141 20130614 11:27:32   0CCA007FCB     FROM: XAA2            20130614 11:27:32  SEND CRC1,  10-4  03SH00001O.SEND XAA2, 2 CAR 10-50 417B MM HWY AT THE
(CC911) Location: 417 MM HWY b New Bern Veh Crash-Property Call Time: 06/14/13 11:23 Narrative:  unknown injuries  veh in roadway  two car mvc  E911 Info - Class of Service: WPH2 
(CC911) Location: AIRPORT RD New Bern Veh Crash-Property Call Time: 06/14/13 08:59 Narrative:  C141 ADVISES THAT FD IS NEEDED FOR TRAFFIC CONTROL  BY FIRST CITIZENS BANK  VEH IN THE ROADWAY  C141 ADVISES PD ONLY  2 CARS  10-50  E911 Info - Class of Service: WRLS 
(CC911) Location: 201 APPENZELL LN New Bern Medical Call Time: 06/14/13 06:51 Narrative:  code blue  FELL OUT OF THE CHAIR ON THE FLOOR  UNABLE TO RESPOND  BARELY BREATHING  POSSIBLE STROKE  FROM EYE  BLOOD IS COMING  68 Y/O M PASSED OUT  E911 Info - Class of Service: RESD 
(CC911) Location: OLD CHERRY POINT RD New Bern Veh Crash-Injury  Call Time: 06/12/13 16:14 Narrative:  21p1-17  jas125-17  UNSOL.XAA2.SEND.20130612162029.    TO: CRC     -227714 20130612 16:20:29   0CCA007F7F     FROM: XAA2            20130612 16:20:29  SEND CRC,  10-4  03SF00007T.SEND XAA2, POSSIBLY 
(CC911) Location: OLD CHERRY POINT RD New Bern Veh Crash-Injury  Call Time: 06/12/13 16:14 Narrative:  03SF00007K.SEND XAA2, NEED A TROOPER TO RESPOND TO US 70 HWY WEST BOUND BY OLD CHERRY POINT BY OLD MEXICAN IMPORTS/LYNNAIRE KENNEL TO 2 VEHICLE ACCIDENT     MICHELLE/CRC  poss 4 pi's  2 vehicles  hon
(CC911) Location: CAMELOT DR New Bern Veh Crash-Property Call Time: 06/11/13 06:51 Narrative:  unable to tell if anyone is in the vehicle  vehicle over turned in the ditch  E911 Info - Class of Service: WRLS 
(CC911) Location: US 70 HWY E New Bern Veh Crash-Injury  Call Time: 06/09/13 17:03 Narrative:  E911 Info - Class of Service: WPH2 
(CC911) Location: US 70 HWY E New Bern Veh Crash-Injury  Call Time: 06/08/13 12:50 Narrative:  west bound 
(CC911) Location: 235 CAROLINA PINES BLVD New Bern Fire Alarm Residence Call Time: 06/08/13 10:16 Narrative:  oper 870  location: smoke alarm  residence: dorman,robert 
(CC911) Location: 2600 OLD CHERRY POINT RD New Bern Fire Alarm Business Call Time: 06/08/13 08:02 Narrative:  OP 7206  SMOKE DETECTOR/FIRE ALARM  RIVER POINTE CREST 

Contact: Active911
Agency name: West of New Bern Vol. Fire Dept
Location: New  Bern, NC, United States
Sender: dispatch@cravencountync.gov 

(CC911) Location: 313 HOKE ST New Bern Fire Alarm Business Call Time: 07/20/13 07:16 Narrative:  op 7108  showing office smoke dector  arc craven #3 group home 
(CC911) Location: 124 DRY MONIA RD New Bern Fire Alarm Residence Call Time: 07/19/13 05:29 Narrative:  OPR GWR RES FIRE ALARM  35.1609989070001 -77.213118327
(CC911) Location: 3707 OLD CHERRY POINT RD New Bern Fire Structure Call Time: 07/18/13 22:53 Narrative:  the barn is on fire  E911 Info - Class of Service: WPH2  35.046907622 -77.004935255
(CC911) Location: 3707 OLD CHERRY POINT RD New Bern Fire Structure Call Time: 07/17/13 22:35 Narrative:  KENNETH REASON BELIVES THE FIRE IS INTENTIONAL  adv that there is no vehicles or gasoline or anything like that  adv that the garage is on fire  E911 Info - Class of Service: WPH2  35.046907622 -77.004935255
(CC911) Location: 103 EXECUTIVE PKWY New Bern Fire Alarm Business Call Time: 07/17/13 16:49 Narrative:  attempting to contact  progress energy new bern administration  oper 7060  fire smoke detectors 
(CC911) Location: 4711 TRENT RIVER DR New Bern Fire Heat Alarm Call Time: 07/16/13 15:05 Narrative:  op oab  showing attic smoke dector  last name is carptner  35.0760681150001 -77.100520793
(CC911) Location: 613 ALEXIS DR New Bern Fire Structure Call Time: 07/11/13 20:17 Narrative:  possible electrical fire  fire in the wall  E911 Info - Class of Service: WRLS  35.0818287700001 -77.050250481
(CC911) Location: 161 CHRIS RD Vanceboro New Call Call Time: 07/11/13 20:02 Narrative:  smoking coming from the furnace  E911 Info - Class of Service: WPH2  35.269617919 -77.1721476829999
(CC911) Location: 423 SATTERFIELD DR New Bern Fire Alarm Residence Call Time: 07/11/13 17:52 Narrative:  252-342-1638  terence juion/oper 469- fire alarm - living room smoke dector  35.05062387 -77.010924453
(CC911) Location: 1213 US 70 HWY E New Bern Fire Unknown Size or Type Call Time: 07/10/13 17:53 Narrative:  call came in from craven tire  adv can see smoke and flames coming from same  adv same is behind craven pre cast and is on the rr trcts in the area  E911 Info - Class of Service: BUSN  35.076528904 -77.029910905
(CC911) Location: 901 INDUSTRIAL DR New Bern Fire Alarm Business Call Time: 07/10/13 13:26 Narrative:  FIRE ZONE 11  CAROLINA TEECH PLASTICS  REF# 1373330  OP JC05 
(CC911) Location: 1100 OLD CHERRY POINT RD New Bern Fire Alarm Business Call Time: 07/10/13 06:48 Narrative:  oper bcw  location fire alarm activation from keypad  business: machine and welding supply co 
(CC911) Location: 105 HOLLY BERRY RD New Bern Fire Structure Call Time: 07/08/13 18:20 Narrative:  BOTH SUBJS ON THE PHONE SOUNDED LIKE THEY WERE HAVING SOME DIFF BREATHING.. ALL OCCUPANTS ARE OUT OF THE HOUSE  FIRE IS OUT.. HOUSE IF FULL OF SMOKE...  GREASE FIRE ON STOVE...  E911 Info - Class of Service: WRLS  35.031321119 -76.994701865
(CC911) Location: 411 MM HWY New Bern Veh Crash-Injury  Call Time: 07/05/13 06:52 Narrative:  VEHICLE IS IN THE WOODS  FEMALE IS HOLDING HER ARM  WHITE EXPLORER  OVER TURNED VEHICLE  Call #: 1556 - E911 Info - Class of Service: WPH2  E911 Info - Class of Service: WPH2  35.1275008010001 -77.1346616549999
(CC911) Location: 410 MM HWY New Bern Veh Crash-Injury  Call Time: 07/05/13 06:52 Narrative:  VEHICLE IS IN THE WOODS  FEMALE IS HOLDING HER ARM  WHITE EXPLORER  OVER TURNED VEHICLE  Call #: 1556 - E911 Info - Class of Service: WPH2  E911 Info - Class of Service: WPH2  35.1324666150001 -77.151187111
(CC911) Location: 411 MM HWY New Bern Veh Crash-Injury  Call Time: 07/05/13 06:52 Narrative:  VEHICLE IS IN THE WOODS  FEMALE IS HOLDING HER ARM  WHITE EXPLORER  OVER TURNED VEHICLE  E911 Info - Class of Service: WPH2  35.1275008010001 -77.1346616549999
(CC911) Location: 212 KALE RD New Bern Fire Structure Call Time: 07/03/13 14:26 Narrative:  FIRE IN THE WALL  E911 Info - Class of Service: BUSN  35.067371253 -77.0292738809999
(CC911) Location: 715 S WEST CRAVEN MIDDLE SCHOOL RD New Bern Fire Structure Call Time: 07/01/13 18:08 Narrative:  old tobacco barn burning  E911 Info - Class of Service: WPH2  35.187971438 -77.1587135029999
(CC911) Location: 935 US 70 HWY E New Bern Fire Alarm Business Call Time: 07/01/13 07:53 Narrative:  OP 28  RESTROOM PULL STATION 
(CC911) Location: 235 JEREMY ST Cove City Security Check Residential Call Time: 06/28/13 19:00 Narrative:  this one popped up early.....the next one after midnite tonight will be the one that needs to be handled.....  compl advised that the subject that lived here has died and that she adv that she and her daughter will be moving items out of the residence during the day, and that no one should be there at night...she adv that her daughter can be reached at 252-474-7581...Ms Latham....\nThis will be set up for the next two weeks, she will call back if she needs it extended any longer, although she believes that 2 weeks will be long enough to clear the residence....\n  35.2253174803295 -77.2899399601001
(CC911) Location: 412 MM HWY New Bern Veh Crash-Injury  Call Time: 06/27/13 21:15 Narrative:  VEHICLE IN THE MEDIAN  E911 Info - Class of Service: WPH2  35.122508657 -77.1181686369999
(CC911) Location: 411 MM HWY New Bern Veh Crash-Injury  Call Time: 06/27/13 18:47 Narrative:  18 WHEELER FLIPPED OVER ON THE RAMP GOING TO HWY 43  E911 Info - Class of Service: WPH2  35.1275008010001 -77.1346616549999
(CC911) Location: 104 PORTSIDE LN New Bern Weather Related Call Time: 06/27/13 15:35 Narrative:  CALLER ADV THAT THE PHONE WILL NOT WORK BUT THE HOUSE HAS POWER  THE SMOKE DETECTOR  CALLER ADV THAT THE ALARM IN THE RES IS GOING OFF  CALLER ADV THAT THE NEIGHBOR COULD NOT SEE OR SMELL ANY SMOKE BUT WOULD LIKE SAME TO BE CHECKED OUT  CALLER ADV THAT THERE IS NO ONE IN THE RES NOW  CALLER ADV THAT THE NEIGHBOR CAME TO HER HOUSE AND ASKED HER TO CALL THE FD  CALLER ADV THAT LIGHTING HIT HER NEIGHBORS RES  E911 Info - Class of Service: WRLS  35.076205057 -77.145592928
(CC911) Location: 617 ALEXIS DR New Bern Fire Unknown Size or Type Call Time: 06/25/13 18:32 Narrative:  smells smoke  systems are out thinks her house got struck by lighting  E911 Info - Class of Service: RESD  35.081622554 -77.050829613
(CC911) Location: 411 MM HWY New Bern New Call Call Time: 06/25/13 16:00 Narrative:  NO INJURIES  ONE IN DITCH  ONE IN MEDIAN  2 VEH  east bound  E911 Info - Class of Service: WPH2  35.1275008010001 -77.1346616549999
(CC911) Location: 4607 WEST FAIRWAY DR New Bern New Call Call Time: 06/25/13 11:05 Narrative:  house fire  E911 Info - Class of Service: BUSN  35.0795352980001 -77.097099978
(CC911) Location: 1100 CLARKS RD New Bern Fire Alarm Business Call Time: 06/24/13 18:23 Narrative:  attempting to contact  oper 7047  fire water flow alarm 
(CC911) Location: 2601 HOUNDS TRL New Bern Fire Alarm Residence Call Time: 06/24/13 16:05 Narrative:  31TRAFFIC4 ADV COND 7  31P4 CAN CANCEL STA21 AND UNITS NOT ON SCENE  31P5 RESPONDING  ADV NOTHING SHOWING  31TRAFFIC4 ON SCENE  21P7 RESPONDING TO STATION 1  216 STANDING BY AWAITING DRIVER  31P4 RESPONDING  OPER UYC  ATTEMPTING TO CONTACT  SMOKE DETECTION HALLWAY  35.0868108870001 -77.0722225769999
(CC911) Location: 2601 HOUNDS TRL New Bern Fire Alarm Residence Call Time: 06/24/13 16:05 Narrative:  OPER UYC  ATTEMPTING TO CONTACT  SMOKE DETECTION HALLWAY  35.0868108870001 -77.0722225769999
(CC911) Location: 4130 ML KING JR BLVD New Bern Veh Crash-Property Call Time: 06/24/13 12:36 Narrative:  03SR00004U.SEND XAA2, 2 CAR 10-50  GREENLEAF CEMETARY RD AND HWY 17 S..4000 BLK OF HWY 17..          CRC1/ORMOND  hwy 17 southbound  lincoln and ford escape  caller adv no injuries  unsure of injuries  one of road one in middle of rd  2 veh  E911 Info - Class of Service: WPH2  35.0946805496365 -77.1219862137577
(CC911) Location: 411 MM HWY New Bern Veh Crash-Property Call Time: 06/23/13 18:26 Narrative:  03SQ000087.SEND XAA2, NEED A TROOPER TO RESPOND TO 411 MM HWY REF TO WHITE CHEVY IMPALA HAS   HYDROPLANED AND IS IN THE MEDIAN    MICHELLE/CRC  unk on injuries  veh is a white chevy impala 4 dr  facing east bound  in the median  E911 Info - Class of Service: WPH2  35.1275008010001 -77.1346616549999
(CC911) Location: WEDGEWOOD DR New Bern Fire Unknown Size or Type Call Time: 06/23/13 15:38 Narrative:  2nd pole o the right pass dunn and dunn law office  by dunns law office  power line on fire  E911 Info - Class of Service: WRLS  35.079811695 -77.071882256
(CC911) Location: 322 FALCON BRIDGE DR New Bern Fire Alarm Residence Call Time: 06/23/13 10:39 Narrative:  ref #  b3702705 oper 417  called in by alarm comp fire alarm coming from the entry way x4  res of mike smasal  34.9730731060001 -76.967750343
(CC911) Location: 3720 US 70 HWY E New Bern Fire Alarm Business Call Time: 06/21/13 08:54 Narrative:  op ybx  showing key pad fire  the plant farm 
(CC911) Location: CLARKS RD New Bern Traffic All Other Call Time: 06/17/13 19:58 Narrative:  WANTS TO KNOW IF FD CAN ASSIT  HAS OIL IN THE TURN LANE,  CALLER IS MANGUM TOWING, TRUCK HAS BLOWN AN OIL PAN  HE IS ON THE WEST BOUND SIDE  70 EAST BOUND  E911 Info - Class of Service: WRLS  35.141915822 -77.1641077

*/

public class NCCravenCountyParserTest extends BaseParserTest {
  
  public NCCravenCountyParserTest() {
    setParser(new NCCravenCountyParser(), "CRAVEN COUNTY", "NC");
  }
  
  @Test
  public void testDoverVolFireDept() {

    doTest("T1",
        "(CC911) Location: 317 W WILSON ST Dover Medical Call Time: 07/23/13 13:37 Narrative:  3261 REQ LIFT ASSIST  asked for conformation on west or east,,they stated west  73 yof..stomach pain..res 252-526-5092..annie bryans  35.2170695965602 -77.4407216603698",
        "ADDR:317 W WILSON ST",
        "CITY:Dover",
        "CALL:Medical",
        "DATE:07/23/13",
        "TIME:13:37",
        "INFO:3261 REQ LIFT ASSIST  asked for conformation on west or east,,they stated west  73 yof..stomach pain..res 252-526-5092..annie bryans",
        "GPS:+35.217070,-77.440722");

    doTest("T2",
        "(CC911) Location: 500 DAUGHERTY RD BLK Dover Fire Unknown Size or Type Call Time: 07/22/13 19:22 Narrative:  35.2723029915473 -77.415604399778",
        "ADDR:500 DAUGHERTY RD BLK",
        "MADDR:500 DAUGHERTY RD",
        "CITY:Dover",
        "CALL:Fire Unknown Size or Type",
        "DATE:07/22/13",
        "TIME:19:22",
        "GPS:+35.272303,-77.415604");

    doTest("T3",
        "(CC911) Location: 500 DAUGHERTY RD Dover Fire Unknown Size or Type Call Time: 07/22/13 19:22 Narrative:  35.2723029915473 -77.415604399778",
        "ADDR:500 DAUGHERTY RD",
        "CITY:Dover",
        "CALL:Fire Unknown Size or Type",
        "DATE:07/22/13",
        "TIME:19:22",
        "GPS:+35.272303,-77.415604");

    doTest("T4",
        "(CC911) Location: 319 E OLD DOVER RD Dover Fire Grass/Brush Call Time: 07/19/13 16:20 Narrative:  adv same is out of control  wheat filed fire  35.2201800890001 -77.428904899",
        "ADDR:319 E OLD DOVER RD",
        "CITY:Dover",
        "CALL:Fire Grass/Brush",
        "DATE:07/19/13",
        "TIME:16:20",
        "INFO:adv same is out of control  wheat filed fire",
        "GPS:+35.220180,-77.428905");

    doTest("T5",
        "(CC911) Location: W KORNEGAY ST Dover Veh Crash-Injury  Call Time: 07/05/13 20:08 Narrative:  3262-8 waiting mp  03T200000Z.SEND XXA2, 1050 2 PI'S  W KORNEGAY ST/ N WEST ST DOVER   CALLED IN BY THE FIRE DEPT  1050 2 pi's  35.2187642910001 -77.437546106",
        "ADDR:W KORNEGAY ST",
        "CITY:Dover",
        "CALL:Veh Crash-Injury",
        "DATE:07/05/13",
        "TIME:20:08",
        "INFO:3262-8 waiting mp  03T200000Z.SEND XXA2, 1050 2 PI'S  W KORNEGAY ST/ N WEST ST DOVER   CALLED IN BY THE FIRE DEPT  1050 2 pi's",
        "GPS:+35.218764,-77.437546");

    doTest("T6",
        "(CC911) Location: W KORNEGAY ST Dover Veh Crash-Injury  Call Time: 07/05/13 20:08 Narrative:  1050 2 pi's  35.2187642910001 -77.437546106",
        "ADDR:W KORNEGAY ST",
        "CITY:Dover",
        "CALL:Veh Crash-Injury",
        "DATE:07/05/13",
        "TIME:20:08",
        "INFO:1050 2 pi's",
        "GPS:+35.218764,-77.437546");

    doTest("T7",
        "(CC911) Location: OLD US 70 HWY Dover Traffic All Other Call Time: 07/05/13 08:26 Narrative:  between railroad and tilghmans garage  E911 Info - Class of Service: WPH2  35.2188136290001 -77.452486564",
        "ADDR:OLD US 70 HWY",
        "MADDR:OLD US 70",
        "CITY:Dover",
        "CALL:Traffic All Other",
        "DATE:07/05/13",
        "TIME:08:26",
        "INFO:between railroad and tilghmans garage",
        "GPS:+35.218814,-77.452487");

    doTest("T8",
        "(CC911) Location: 235 JEREMY ST Cove City Security Check Residential Call Time: 06/28/13 19:00 Narrative:  this one popped up early.....the next one after midnite tonight will be the one that needs to be handled.....  compl advised that the subject that lived here has died and that she adv that she and her daughter will be moving items out of the residence during the day, and that no one should be there at night...she adv that her daughter can be reached at 252-474-7581...Ms Latham....\n" +
        "This will be set up for the next two weeks, she will call back if she needs it extended any longer, although she believes that 2 weeks will be long enough to clear the residence....\n" +
        "  35.2253174803295 -77.2899399601001",

        "ADDR:235 JEREMY ST",
        "CITY:Cove City",
        "CALL:Security Check Residential",
        "DATE:06/28/13",
        "TIME:19:00",
        "INFO:this one popped up early.....the next one after midnite tonight will be the one that needs to be handled.....  compl advised that the subject that lived here has died and that she adv that she and her daughter will be moving items out of the residence during the day, and that no one should be there at night...she adv that her daughter can be reached at 252-474-7581...Ms Latham....\nThis will be set up for the next two weeks, she will call back if she needs it extended any longer, although she believes that 2 weeks will be long enough to clear the residence....",
        "GPS:+35.225317,-77.289940");

    doTest("T9",
        "(CC911) Location: 441 W KORNEGAY ST Dover Fire Forest/Woods Call Time: 06/25/13 17:16 Narrative:  35.2187450700001 -77.445917473",
        "ADDR:441 W KORNEGAY ST",
        "CITY:Dover",
        "CALL:Fire Forest/Woods",
        "DATE:06/25/13",
        "TIME:17:16",
        "GPS:+35.218745,-77.445917");

    doTest("T10",
        "(CC911) Location: 2229 WINTERGREEN RD Cove City Fire Alarm Business Call Time: 06/19/13 07:02 Narrative:  general fire alarm - fire arm physicians  attempting to contact  oper 7064 ",
        "ADDR:2229 WINTERGREEN RD",
        "CITY:Cove City",
        "CALL:Fire Alarm Business",
        "DATE:06/19/13",
        "TIME:07:02",
        "INFO:general fire alarm - fire arm physicians  attempting to contact  oper 7064");
   
  }
  
  @Test
  public void testNo7TownshipFireAndRescue() {

    doTest("T1",
        "(CC911) Location: 1000 US 70 HWY E New Bern Fire Vehicle  Call Time: 07/24/13 10:23 Narrative:  caller adv that there is someone out with the veh  caller adv that it is a car poss a camaro  caller adv that there is a veh on fire in the pva of the waffle house  E911 Info - Class of Service: BUSN  35.0821437500001 -77.030651275",
        "ADDR:1000 US 70 HWY E",
        "MADDR:1000 US 70 E",
        "CITY:New Bern",
        "CALL:Fire Vehicle",
        "DATE:07/24/13",
        "TIME:10:23",
        "INFO:caller adv that there is someone out with the veh  caller adv that it is a car poss a camaro  caller adv that there is a veh on fire in the pva of the waffle house",
        "GPS:+35.082144,-77.030651");

    doTest("T2",
        "(CC911) Location: 1000 US 70 HWY E Fire Vehicle  Call Time: 07/24/13 10:23 Narrative:  caller adv that there is someone out with the veh  caller adv that it is a car poss a camaro  caller adv that there is a veh on fire in the pva of the waffle house  E911 Info - Class of Service: BUSN  -361 -361",
        "ADDR:1000 US 70 HWY E",
        "MADDR:1000 US 70 E",
        "CALL:Fire Vehicle",
        "DATE:07/24/13",
        "TIME:10:23",
        "INFO:caller adv that there is someone out with the veh  caller adv that it is a car poss a camaro  caller adv that there is a veh on fire in the pva of the waffle house");

    doTest("T3",
        "(CC911) Location: 1000 US 70 HWY Fire Vehicle  Call Time: 07/24/13 10:23 Narrative:  caller adv that it is a car poss a camaro  caller adv that there is a veh on fire in the pva of the waffle house  E911 Info - Class of Service: BUSN  -361 -361",
        "ADDR:1000 US 70 HWY",
        "MADDR:1000 US 70",
        "CALL:Fire Vehicle",
        "DATE:07/24/13",
        "TIME:10:23",
        "INFO:caller adv that it is a car poss a camaro  caller adv that there is a veh on fire in the pva of the waffle house");

    doTest("T4",
        "(CC911) Location: 160 BLOUNT BRIMAGE DR New Bern Medical Call Time: 07/23/13 16:26 Narrative:  JAS128 REQ LIFT ASSIST  R20 ADV SEND M/A  FEMALE SHAKING..60 YOF..  E911 Info - Class of Service: RESD  35.050584621 -77.076017054",
        "ADDR:160 BLOUNT BRIMAGE DR",
        "CITY:New Bern",
        "CALL:Medical",
        "DATE:07/23/13",
        "TIME:16:26",
        "INFO:JAS128 REQ LIFT ASSIST  R20 ADV SEND M/A  FEMALE SHAKING..60 YOF..",
        "GPS:+35.050585,-77.076017");

    doTest("T5",
        "(CC911) Location: 3907 OLD CHERRY POINT RD 1 New Bern Citizen Assist Call Time: 07/20/13 16:40 Narrative:  CALLER ADV THAT SHE DOESNT THINK THAT SHE IS INJURED  UNABLE TO GET UP  HAS FALLEN  53 YOF  E911 Info - Class of Service: RESD  35.0438854930001 -77.002648235",
        "ADDR:3907 OLD CHERRY POINT RD 1",
        "CITY:New Bern",
        "CALL:Citizen Assist",
        "DATE:07/20/13",
        "TIME:16:40",
        "INFO:CALLER ADV THAT SHE DOESNT THINK THAT SHE IS INJURED  UNABLE TO GET UP  HAS FALLEN  53 YOF",
        "GPS:+35.043885,-77.002648");

    doTest("T6",
        "(CC911) Location: 313 HOKE ST New Bern Fire Alarm Business Call Time: 07/20/13 07:16 Narrative:  op 7108  showing office smoke dector  arc craven #3 group home ",
        "ADDR:313 HOKE ST",
        "CITY:New Bern",
        "CALL:Fire Alarm Business",
        "DATE:07/20/13",
        "TIME:07:16",
        "INFO:op 7108  showing office smoke dector  arc craven #3 group home");

    doTest("T7",
        "(CC911) Location: WILLIAMS RD New Bern Veh Crash-Injury  Call Time: 07/19/13 15:50 Narrative:  in the bj pva  with injuries  E911 Info - Class of Service: WRLS  35.081639792 -77.031452224",
        "ADDR:WILLIAMS RD",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:07/19/13",
        "TIME:15:50",
        "INFO:in the bj pva  with injuries",
        "GPS:+35.081640,-77.031452");

    doTest("T8",
        "(CC911) Location: 3707 OLD CHERRY POINT RD New Bern Fire Structure Call Time: 07/18/13 22:53 Narrative:  the barn is on fire  E911 Info - Class of Service: WPH2  35.046907622 -77.004935255",
        "ADDR:3707 OLD CHERRY POINT RD",
        "CITY:New Bern",
        "CALL:Fire Structure",
        "DATE:07/18/13",
        "TIME:22:53",
        "INFO:the barn is on fire",
        "GPS:+35.046908,-77.004935");

    doTest("T9",
        "(CC911) Location: 2713 US 70 HWY E New Bern Gas Leak Non-confirmed Call Time: 07/18/13 09:28 Narrative:  pizza hut does not open until 10:00 am  caller is at state farm and can smell gas  gas leak  pizza hut  35.057343766 -77.0195029129999",
        "ADDR:2713 US 70 HWY E",
        "MADDR:2713 US 70 E",
        "CITY:New Bern",
        "CALL:Gas Leak Non-confirmed",
        "DATE:07/18/13",
        "TIME:09:28",
        "INFO:pizza hut does not open until 10:00 am  caller is at state farm and can smell gas  gas leak  pizza hut",
        "GPS:+35.057344,-77.019503");

    doTest("T10",
        "(CC911) Location: 2703 US 70 HWY E New Bern Alarm Business Call Time: 07/18/13 09:31 Narrative:  notified c141  attempt to contact call list  oper 7059  general burg alarm  no premise number  ashley furniture  35.0588429600001 -77.019907783",
        "ADDR:2703 US 70 HWY E",
        "MADDR:2703 US 70 E",
        "CITY:New Bern",
        "CALL:Alarm Business",
        "DATE:07/18/13",
        "TIME:09:31",
        "INFO:notified c141  attempt to contact call list  oper 7059  general burg alarm  no premise number  ashley furniture",
        "GPS:+35.058843,-77.019908");

    doTest("T11",
        "(CC911) Location: 2713 US 70 HWY E New Bern Gas Leak Non-confirmed Call Time: 07/18/13 09:28 Narrative:  caller is at state farm and can smell gas  gas leak  pizza hut  35.057343766 -77.0195029129999",
        "ADDR:2713 US 70 HWY E",
        "MADDR:2713 US 70 E",
        "CITY:New Bern",
        "CALL:Gas Leak Non-confirmed",
        "DATE:07/18/13",
        "TIME:09:28",
        "INFO:caller is at state farm and can smell gas  gas leak  pizza hut",
        "GPS:+35.057344,-77.019503");

    doTest("T12",
        "(CC911) Location: <UNKNOWN> New Call Call Time: 07/18/13 09:28 Narrative:  caller is at state farm and can smell gas  gas leak  pizza hut  -361 -361",
        "CALL:<UNKNOWN> New Call",
        "DATE:07/18/13",
        "TIME:09:28",
        "INFO:caller is at state farm and can smell gas  gas leak  pizza hut");

    doTest("T13",
        "(CC911) Location: 3707 OLD CHERRY POINT RD New Bern Fire Structure Call Time: 07/17/13 22:35 Narrative:  KENNETH REASON BELIVES THE FIRE IS INTENTIONAL  adv that there is no vehicles or gasoline or anything like that  adv that the garage is on fire  E911 Info - Class of Service: WPH2  35.046907622 -77.004935255",
        "ADDR:3707 OLD CHERRY POINT RD",
        "CITY:New Bern",
        "CALL:Fire Structure",
        "DATE:07/17/13",
        "TIME:22:35",
        "INFO:KENNETH REASON BELIVES THE FIRE IS INTENTIONAL  adv that there is no vehicles or gasoline or anything like that  adv that the garage is on fire",
        "GPS:+35.046908,-77.004935");

    doTest("T14",
        "(CC911) Location: 4711 TRENT RIVER DR New Bern Fire Heat Alarm Call Time: 07/16/13 15:05 Narrative:  op oab  showing attic smoke dector  last name is carptner  35.0760681150001 -77.100520793",
        "ADDR:4711 TRENT RIVER DR",
        "CITY:New Bern",
        "CALL:Fire Heat Alarm",
        "DATE:07/16/13",
        "TIME:15:05",
        "INFO:op oab  showing attic smoke dector  last name is carptner",
        "GPS:+35.076068,-77.100521");

    doTest("T15",
        "(CC911) Location: 4316 US 70 HWY E New Bern New Call Call Time: 07/14/13 22:59 Narrative:  E911 Info - Class of Service: WPH2  35.028654524 -77.001495556",
        "ADDR:4316 US 70 HWY E",
        "MADDR:4316 US 70 E",
        "CITY:New Bern",
        "CALL:New Call",
        "DATE:07/14/13",
        "TIME:22:59",
        "GPS:+35.028655,-77.001496");

    doTest("T16",
        "(CC911) Location: 613 ALEXIS DR New Bern Fire Structure Call Time: 07/11/13 20:17 Narrative:  possible electrical fire  fire in the wall  E911 Info - Class of Service: WRLS  35.0818287700001 -77.050250481",
        "ADDR:613 ALEXIS DR",
        "CITY:New Bern",
        "CALL:Fire Structure",
        "DATE:07/11/13",
        "TIME:20:17",
        "INFO:possible electrical fire  fire in the wall",
        "GPS:+35.081829,-77.050250");

    doTest("T17",
        "(CC911) Location: 423 SATTERFIELD DR New Bern Fire Alarm Residence Call Time: 07/11/13 17:52 Narrative:  252-342-1638  terence juion/oper 469- fire alarm - living room smoke dector  35.05062387 -77.010924453",
        "ADDR:423 SATTERFIELD DR",
        "CITY:New Bern",
        "CALL:Fire Alarm Residence",
        "DATE:07/11/13",
        "TIME:17:52",
        "INFO:252-342-1638  terence juion/oper 469- fire alarm - living room smoke dector",
        "GPS:+35.050624,-77.010924");

    doTest("T18",
        "(CC911) Location: 1213 US 70 HWY E New Bern Fire Unknown Size or Type Call Time: 07/10/13 17:53 Narrative:  call came in from craven tire  adv can see smoke and flames coming from same  adv same is behind craven pre cast and is on the rr trcts in the area  E911 Info - Class of Service: BUSN  35.076528904 -77.029910905",
        "ADDR:1213 US 70 HWY E",
        "MADDR:1213 US 70 E",
        "CITY:New Bern",
        "CALL:Fire Unknown Size or Type",
        "DATE:07/10/13",
        "TIME:17:53",
        "INFO:call came in from craven tire  adv can see smoke and flames coming from same  adv same is behind craven pre cast and is on the rr trcts in the area",
        "GPS:+35.076529,-77.029911");

    doTest("T19",
        "(CC911) Location: 1100 OLD CHERRY POINT RD New Bern Fire Alarm Business Call Time: 07/10/13 06:48 Narrative:  correction 31p5 advises last  21P5 10-23 NOTHING SHOWING SINGLE STORY STRUCTURE  21p5 10-17  31p5 enr  31p1 enr  oper bcw  location fire alarm activation from keypad  business: machine and welding su",
        "ADDR:1100 OLD CHERRY POINT RD",
        "CITY:New Bern",
        "CALL:Fire Alarm Business",
        "DATE:07/10/13",
        "TIME:06:48",
        "INFO:correction 31p5 advises last  21P5 10-23 NOTHING SHOWING SINGLE STORY STRUCTURE  21p5 10-17  31p5 enr  31p1 enr  oper bcw  location fire alarm activation from keypad  business: machine and welding su");

    doTest("T20",
        "(CC911) Location: 2600 STREETS FERRY RD Vanceboro New Call Call Time: 07/10/13 06:57 Narrative:  35.2375956970001 -77.1366757339999",
        "ADDR:2600 STREETS FERRY RD",
        "CITY:Vanceboro",
        "CALL:New Call",
        "DATE:07/10/13",
        "TIME:06:57",
        "GPS:+35.237596,-77.136676");

    doTest("T21",
        "(CC911) Location: 1100 OLD CHERRY POINT RD New Bern Fire Alarm Business Call Time: 07/10/13 06:48 Narrative:  oper bcw  location fire alarm activation from keypad  business: machine and welding supply co ",
        "ADDR:1100 OLD CHERRY POINT RD",
        "CITY:New Bern",
        "CALL:Fire Alarm Business",
        "DATE:07/10/13",
        "TIME:06:48",
        "INFO:oper bcw  location fire alarm activation from keypad  business: machine and welding supply co");

    doTest("T22",
        "(CC911) Location: US 70 HWY E New Bern Veh Crash-Property Call Time: 07/09/13 13:55 Narrative:  ON THE ROAD  NO PI  10-50  E911 Info - Class of Service: WPH2  35.0378980580001 -77.0072286239999",
        "ADDR:US 70 HWY E",
        "MADDR:US 70 E",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:07/09/13",
        "TIME:13:55",
        "INFO:ON THE ROAD  NO PI  10-50",
        "GPS:+35.037898,-77.007229");

    doTest("T23",
        "(CC911) Location: 105 HOLLY BERRY RD New Bern New Call Call Time: 07/08/13 18:20 Narrative:  BOTH SUBJS ON THE PHONE SOUNDED LIKE THEY WERE HAVING SOME DIFF BREATHING.. ALL OCCUPANTS ARE OUT OF THE HOUSE  FIRE IS OUT.. HOUSE IF FULL OF SMOKE...  GREASE FIRE ON STOVE...  E911 Info - Class of Service: WRLS  35.031321119 -76.994701865",
        "ADDR:105 HOLLY BERRY RD",
        "CITY:New Bern",
        "CALL:New Call",
        "DATE:07/08/13",
        "TIME:18:20",
        "INFO:BOTH SUBJS ON THE PHONE SOUNDED LIKE THEY WERE HAVING SOME DIFF BREATHING.. ALL OCCUPANTS ARE OUT OF THE HOUSE  FIRE IS OUT.. HOUSE IF FULL OF SMOKE...  GREASE FIRE ON STOVE...  E911 Info - Class of Service: WRLS  35.031321119 -76.994701865");

    doTest("T24",
        "(CC911) Location: US 70 HWY E New Bern Veh Crash-Injury  Call Time: 07/07/13 15:19 Narrative:  1 IS ON THE OUTSIDE LANE AND THE OTHER IS IN THE OTHER LANE  03T400004F.SEND XAA2, CREAM COLORED TRUCK AND A WHITE FORD EXPLORER IN THE ROADWAY ON HWY 70 E WEST   BOUND NEAR AIRPORT RD UNK FURTHER IF IT IS AN ACCIDENT       CRC1/MCW  WEST BOUND LANE TOWARDS NEW BERN  E911 Info - Class of Service: WPH2  35.0746740270001 -77.027927135",
        "ADDR:US 70 HWY E",
        "MADDR:US 70 E",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:07/07/13",
        "TIME:15:19",
        "INFO:1 IS ON THE OUTSIDE LANE AND THE OTHER IS IN THE OTHER LANE  03T400004F.SEND XAA2, CREAM COLORED TRUCK AND A WHITE FORD EXPLORER IN THE ROADWAY ON HWY 70 E WEST   BOUND NEAR AIRPORT RD UNK FURTHER IF IT IS AN ACCIDENT       CRC1/MCW  WEST BOUND LANE TOWARDS NEW BERN",
        "GPS:+35.074674,-77.027927");

    doTest("T25",
        "(CC911) Location: 104 WADKINS BLVD New Bern Fire Structure Call Time: 07/06/13 12:19 Narrative:  caller adv that he put a fire extinguisher  oven door is closed, fire still going inside the oven  the fire is still inside the oven  caller adv that everyone is out of the house  call 800-357-4911  john oven fire that wont go out  34.963379935 -76.937906595",
        "ADDR:104 WADKINS BLVD",
        "CITY:New Bern",
        "CALL:Fire Structure",
        "DATE:07/06/13",
        "TIME:12:19",
        "INFO:caller adv that he put a fire extinguisher  oven door is closed, fire still going inside the oven  the fire is still inside the oven  caller adv that everyone is out of the house  call 800-357-4911  john oven fire that wont go out  34.963379935 -76.937906595");

    doTest("T26",
        "(CC911) Location: 212 KALE RD New Bern Fire Structure Call Time: 07/03/13 14:26 Narrative:  FIRE IN THE WALL  E911 Info - Class of Service: BUSN  35.067371253 -77.0292738809999",
        "ADDR:212 KALE RD",
        "CITY:New Bern",
        "CALL:Fire Structure",
        "DATE:07/03/13",
        "TIME:14:26",
        "INFO:FIRE IN THE WALL",
        "GPS:+35.067371,-77.029274");

    doTest("T27",
        "(CC911) Location: US 70 HWY E New Bern Veh Crash-Property Call Time: 07/02/13 13:09 Narrative:  CALLER ADV IT WAS A MINI VAN  910-393-8659  MALE SUBJ OUT OF THE VEHICLE IS RIGHT ON THE LINE  Call #: 1209 - E911 Info - Class of Service: WRLS  UNSOL.XAA2.SEND.20130702131222.    TO: CRC1    -069877 20130702 13:12:22   0CCA0082D8     FROM: XAA2            20130702 13:12:12  SEND CRC1,  10-4  03SZ00001R.SEND XAA2, US 70 HWY E PAST E FISHER AVE THERE IS A SINGLE VEHICLE ACCIDENT IN THE MEDIAN   AND CALLER SAYS THAT THE SUBJECT NEEDS TO BE SPOKEN TO BY TROOPER     CRC1/MCW  NO PI AND SUBJ IS OUT OF SAME  SINGLE VEHICLE ACCIDENT IN THE MEDIAN  E911 Info - Class of Service: WPH2  34.9889567000001 -76.9817226059999",
        "ADDR:US 70 HWY E",
        "MADDR:US 70 E",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:07/02/13",
        "TIME:13:09",
        "INFO:CALLER ADV IT WAS A MINI VAN  910-393-8659  MALE SUBJ OUT OF THE VEHICLE IS RIGHT ON THE LINE  Call #: 1209 - E911 Info - Class of Service: WRLS  UNSOL.XAA2.SEND.20130702131222.    TO: CRC1    -069877 20130702 13:12:22   0CCA0082D8     FROM: XAA2            20130702 13:12:12  SEND CRC1,  10-4  03SZ00001R.SEND XAA2, US 70 HWY E PAST E FISHER AVE THERE IS A SINGLE VEHICLE ACCIDENT IN THE MEDIAN   AND CALLER SAYS THAT THE SUBJECT NEEDS TO BE SPOKEN TO BY TROOPER     CRC1/MCW  NO PI AND SUBJ IS OUT OF SAME  SINGLE VEHICLE ACCIDENT IN THE MEDIAN  E911 Info - Class of Service: WPH2  34.9889567000001 -76.9817226059999");

    doTest("T28",
        "(CC911) Location: US 70 HWY E New Bern Veh Crash-Injury  Call Time: 07/02/13 12:14 Narrative:  BLOCKIGN TRAFFIC  UNK PII'S  2 VEHICLES IN THE ROADWAY  35.0381720890001 -77.0067954789999",
        "ADDR:US 70 HWY E",
        "MADDR:US 70 E",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:07/02/13",
        "TIME:12:14",
        "INFO:BLOCKIGN TRAFFIC  UNK PII'S  2 VEHICLES IN THE ROADWAY",
        "GPS:+35.038172,-77.006795");

    doTest("T29",
        "(CC911) Location: 4890 WILCOX RD New Bern New Call Call Time: 07/02/13 11:24 Narrative:  subjs still on the roadway  occured in the roadway  male subj says he is fine  bicyclist ran into the back of callers car  E911 Info - Class of Service: WPH2  35.0050543680001 -76.992681367",
        "ADDR:4890 WILCOX RD",
        "CITY:New Bern",
        "CALL:New Call",
        "DATE:07/02/13",
        "TIME:11:24",
        "INFO:subjs still on the roadway  occured in the roadway  male subj says he is fine  bicyclist ran into the back of callers car  E911 Info - Class of Service: WPH2  35.0050543680001 -76.992681367");

    doTest("T30",
        "(CC911) Location: US 70 HWY E New Bern Veh Crash-Injury  Call Time: 07/01/13 16:32 Narrative:  NISSAN DEALERSHIP IS ON THE LEFT  CORRECTION OUT OF THE ROADWAY INTO THE MEDIAN  HE DID MOVE HIS CAR OUT OF THE MEDIAN  18 WHEELER PULLED INTO THE TOYOTA DEALERSHIP AND ANOTHER CAR SLAMMED ON BREAKS AND ENDED UP THRU THE MEDIAN AND OTHER SIDE OF THE ROADWAY  E911 Info - Class of Service: WPH2  35.05044365 -77.0144657239999",
        "ADDR:US 70 HWY E",
        "MADDR:US 70 E",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:07/01/13",
        "TIME:16:32",
        "INFO:NISSAN DEALERSHIP IS ON THE LEFT  CORRECTION OUT OF THE ROADWAY INTO THE MEDIAN  HE DID MOVE HIS CAR OUT OF THE MEDIAN  18 WHEELER PULLED INTO THE TOYOTA DEALERSHIP AND ANOTHER CAR SLAMMED ON BREAKS AND ENDED UP THRU THE MEDIAN AND OTHER SIDE OF THE ROADWAY",
        "GPS:+35.050444,-77.014466");

    doTest("T31",
        "(CC911) Location: 2500 US 70 HWY E New Bern Veh Crash-Injury  Call Time: 07/01/13 16:32 Narrative:  NISSAN DEALERSHIP IS ON THE LEFT  CORRECTION OUT OF THE ROADWAY INTO THE MEDIAN  HE DID MOVE HIS CAR OUT OF THE MEDIAN  18 WHEELER PULLED INTO THE TOYOTA DEALERSHIP AND ANOTHER CAR SLAMMED ON BREAKS AND ENDED UP THRU THE MEDIAN AND OTHER SIDE OF THE ROADWAY  E911 Info - Class of Service: WPH2  35.060617193 -77.019460551",
        "ADDR:2500 US 70 HWY E",
        "MADDR:2500 US 70 E",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:07/01/13",
        "TIME:16:32",
        "INFO:NISSAN DEALERSHIP IS ON THE LEFT  CORRECTION OUT OF THE ROADWAY INTO THE MEDIAN  HE DID MOVE HIS CAR OUT OF THE MEDIAN  18 WHEELER PULLED INTO THE TOYOTA DEALERSHIP AND ANOTHER CAR SLAMMED ON BREAKS AND ENDED UP THRU THE MEDIAN AND OTHER SIDE OF THE ROADWAY",
        "GPS:+35.060617,-77.019461");

    doTest("T32",
        "(CC911) Location: 935 US 70 HWY E New Bern Fire Alarm Business Call Time: 07/01/13 07:53 Narrative:  OP 28  RESTROOM PULL STATION ",
        "ADDR:935 US 70 HWY E",
        "MADDR:935 US 70 E",
        "CITY:New Bern",
        "CALL:Fire Alarm Business",
        "DATE:07/01/13",
        "TIME:07:53",
        "INFO:OP 28  RESTROOM PULL STATION");

    doTest("T33",
        "(CC911) Location: OLD CHERRY POINT RD New Bern New Call Call Time: 06/29/13 22:49 Narrative:  two car mvc  E911 Info - Class of Service: WRLS  35.0766323940001 -77.027181172",
        "ADDR:OLD CHERRY POINT RD",
        "CITY:New Bern",
        "CALL:New Call",
        "DATE:06/29/13",
        "TIME:22:49",
        "INFO:two car mvc",
        "GPS:+35.076632,-77.027181");

    doTest("T34",
        "(CC911) Location: WILLIAMS RD New Bern Veh Crash-Property Call Time: 06/29/13 11:11 Narrative:  03SW000038.SEND XAA2, 2 CAR 10-50 WILLIAMS RD AND HWY 70 E ON SERVICE RD..UNKNOW PIS      CRC1/ORMOND  NO INJURIES  ON THE SERVICE RD AT BURGER KING  IN THE ROADWAY  2 VEH  E911 Info - Class of Service: WPH2  35.081639792 -77.031452224",
        "ADDR:WILLIAMS RD",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:06/29/13",
        "TIME:11:11",
        "INFO:03SW000038.SEND XAA2, 2 CAR 10-50 WILLIAMS RD AND HWY 70 E ON SERVICE RD..UNKNOW PIS      CRC1/ORMOND  NO INJURIES  ON THE SERVICE RD AT BURGER KING  IN THE ROADWAY  2 VEH",
        "GPS:+35.081640,-77.031452");

    doTest("T35",
        "(CC911) Location: 4001 OLD CHERRY POINT RD New Bern Veh Crash-Injury  Call Time: 06/29/13 08:09 Narrative:  wreck..thurman rd old cherry point rd..2 car 10-50  E911 Info - Class of Service: BUSN  35.0413469050001 -77.0010687019999",
        "ADDR:4001 OLD CHERRY POINT RD",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/29/13",
        "TIME:08:09",
        "INFO:wreck..thurman rd old cherry point rd..2 car 10-50",
        "GPS:+35.041347,-77.001069");

    doTest("T36",
        "(CC911) Location: 235 JEREMY ST Cove City Security Check Residential Call Time: 06/28/13 19:00 Narrative:  this one popped up early.....the next one after midnite tonight will be the one that needs to be handled.....  compl advised that the subject that lived here has died and that she adv that she and her daughter will be moving items out of the residence during the day, and that no one should be there at night...she adv that her daughter can be reached at 252-474-7581...Ms Latham....\n" +
        "This will be set up for the next two weeks, she will call back if she needs it extended any longer, although she believes that 2 weeks will be long enough to clear the residence....\n" +
        "  35.2253174803295 -77.2899399601001",

        "ADDR:235 JEREMY ST",
        "CITY:Cove City",
        "CALL:Security Check Residential",
        "DATE:06/28/13",
        "TIME:19:00",
        "INFO:this one popped up early.....the next one after midnite tonight will be the one that needs to be handled.....  compl advised that the subject that lived here has died and that she adv that she and her daughter will be moving items out of the residence during the day, and that no one should be there at night...she adv that her daughter can be reached at 252-474-7581...Ms Latham....\nThis will be set up for the next two weeks, she will call back if she needs it extended any longer, although she believes that 2 weeks will be long enough to clear the residence....",
        "GPS:+35.225317,-77.289940");

    doTest("T37",
        "(CC911) Location: 1604 US 70 HWY E 1 New Bern Medical Call Time: 06/28/13 11:50 Narrative:  60 y/o m  fell in the front yard and his hip his hurting real bad  E911 Info - Class of Service: WRLS  35.073692039 -77.026358143",
        "ADDR:1604 US 70 HWY E 1",
        "MADDR:1604 US 70 E 1",
        "CITY:New Bern",
        "CALL:Medical",
        "DATE:06/28/13",
        "TIME:11:50",
        "INFO:60 y/o m  fell in the front yard and his hip his hurting real bad",
        "GPS:+35.073692,-77.026358");

    doTest("T38",
        "(CC911) Location: 617 ALEXIS DR New Bern Fire Unknown Size or Type Call Time: 06/25/13 18:32 Narrative:  switch traffic to state fire per command  21 station 3 standing by  21p2 on scene est command  2062 standing by at station  21p4 responding  2062 standing by at building  21p7 on scene  21p2 advised to standby at station  single story residential structure nothing showing  31p4 responding  31p5 responding  21p2 responding to scene  21p7 responding  smells smoke  systems are out thinks her house got struck by lighting  E911 Info - Class of Service: RESD  35.081622554 -77.050829613",
        "ADDR:617 ALEXIS DR",
        "CITY:New Bern",
        "CALL:Fire Unknown Size or Type",
        "DATE:06/25/13",
        "TIME:18:32",
        "INFO:switch traffic to state fire per command  21 station 3 standing by  21p2 on scene est command  2062 standing by at station  21p4 responding  2062 standing by at building  21p7 on scene  21p2 advised to standby at station  single story residential structure nothing showing  31p4 responding  31p5 responding  21p2 responding to scene  21p7 responding  smells smoke  systems are out thinks her house got struck by lighting",
        "GPS:+35.081623,-77.050830");

    doTest("T39",
        "(CC911) Location: 617 ALEXIS DR New Bern Fire Unknown Size or Type Call Time: 06/25/13 18:32 Narrative:  smells smoke  systems are out thinks her house got struck by lighting  E911 Info - Class of Service: RESD  35.081622554 -77.050829613",
        "ADDR:617 ALEXIS DR",
        "CITY:New Bern",
        "CALL:Fire Unknown Size or Type",
        "DATE:06/25/13",
        "TIME:18:32",
        "INFO:smells smoke  systems are out thinks her house got struck by lighting",
        "GPS:+35.081623,-77.050830");

    doTest("T40",
        "(CC911) Location: 3305 US 70 HWY E New Bern Veh Crash-Injury  Call Time: 06/25/13 12:15 Narrative:  35.0497774670001 -77.014614517",
        "ADDR:3305 US 70 HWY E",
        "MADDR:3305 US 70 E",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/25/13",
        "TIME:12:15",
        "GPS:+35.049777,-77.014615");

    doTest("T41",
        "(CC911) Location: 4607 WEST FAIRWAY DR New Bern New Call Call Time: 06/25/13 11:05 Narrative:  house fire  E911 Info - Class of Service: BUSN  35.0795352980001 -77.097099978",
        "ADDR:4607 WEST FAIRWAY DR",
        "CITY:New Bern",
        "CALL:New Call",
        "DATE:06/25/13",
        "TIME:11:05",
        "INFO:house fire",
        "GPS:+35.079535,-77.097100");

    doTest("T42",
        "(CC911) Location: GARNER RD New Bern Veh Crash-Injury  Call Time: 06/24/13 17:03 Narrative:  03SR00007F.SEND XAA2, 2 CAR 10-50...GARNER RD/US 70 HWY..EAST BOUND..  CRC1/ORMOND  Call #: 342 - E911 Info - Class of Service: WRLS  AT THE INTERSECTION  POSSIBLE PI'S  ONE IN DITCH ONE IN ROADWAY  2 VEH  ACROSS FROM HYUNDAI DEALERSHIP  E911 Info - Class of Service: WPH2  35.0563179980001 -77.017648503",
        "ADDR:GARNER RD",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/24/13",
        "TIME:17:03",
        "INFO:03SR00007F.SEND XAA2, 2 CAR 10-50...GARNER RD/US 70 HWY..EAST BOUND..  CRC1/ORMOND  Call #: 342 -",
        "GPS:+35.056318,-77.017649");

    doTest("T43",
        "(CC911) Location: GARNER RD New Bern Veh Crash-Injury  Call Time: 06/24/13 17:03 Narrative:  03SR00007F.SEND XAA2, 2 CAR 10-50...GARNER RD/US 70 HWY..EAST BOUND..  CRC1/ORMOND  Call #: 342 - E911 Info - Class of Service: WRLS  AT THE INTERSECTION  POSSIBLE PI'S  ONE IN DITCH ONE IN ROADWAY  2 VEH  ACROSS FROM HYUNDAI DEALERSHIP  E911 Info - Class of Service: WPH2  35.0563179980001 -77.017648503",
        "ADDR:GARNER RD",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/24/13",
        "TIME:17:03",
        "INFO:03SR00007F.SEND XAA2, 2 CAR 10-50...GARNER RD/US 70 HWY..EAST BOUND..  CRC1/ORMOND  Call #: 342 -",
        "GPS:+35.056318,-77.017649");

    doTest("T44",
        "(CC911) Location: Veh Crash-Injury  Call Time: 06/24/13 17:03 Narrative:  AT THE INTERSECTION  POSSIBLE PI'S  ONE IN DITCH ONE IN ROADWAY  2 VEH  ACROSS FROM HYUNDAI DEALERSHIP  E911 Info - Class of Service: WPH2  35.055946 -77.017915",
        "CALL:Veh Crash-Injury",
        "MADDR:+35.055946,-77.017915",
        "DATE:06/24/13",
        "TIME:17:03",
        "INFO:AT THE INTERSECTION  POSSIBLE PI'S  ONE IN DITCH ONE IN ROADWAY  2 VEH  ACROSS FROM HYUNDAI DEALERSHIP",
        "GPS:+35.055946,-77.017915");

    doTest("T45",
        "(CC911) Location: WILLIAMS RD New Bern Veh Crash-Property Call Time: 06/24/13 16:32 Narrative:  2 car 10-50...rd way..no pis..shp on scene  35.081639792 -77.031452224",
        "ADDR:WILLIAMS RD",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:06/24/13",
        "TIME:16:32",
        "INFO:2 car 10-50...rd way..no pis..shp on scene",
        "GPS:+35.081640,-77.031452");

    doTest("T46",
        "(CC911) Location: 2601 HOUNDS TRL New Bern Fire Alarm Residence Call Time: 06/24/13 16:05 Narrative:  OPER UYC  ATTEMPTING TO CONTACT  SMOKE DETECTION HALLWAY  35.0868108870001 -77.0722225769999",
        "ADDR:2601 HOUNDS TRL",
        "CITY:New Bern",
        "CALL:Fire Alarm Residence",
        "DATE:06/24/13",
        "TIME:16:05",
        "INFO:OPER UYC  ATTEMPTING TO CONTACT  SMOKE DETECTION HALLWAY",
        "GPS:+35.086811,-77.072223");

    doTest("T47",
        "(CC911) Location: US 70 HWY E New Bern Veh Crash-Property Call Time: 06/23/13 21:25 Narrative:  truck in the ditch, burg veh pulled off with it  before you get to taberna  east bound side of the road  truck in the ditch  35.05044365 -77.0144657239999",
        "ADDR:US 70 HWY E",
        "MADDR:US 70 E",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:06/23/13",
        "TIME:21:25",
        "INFO:truck in the ditch, burg veh pulled off with it  before you get to taberna  east bound side of the road  truck in the ditch",
        "GPS:+35.050444,-77.014466");

    doTest("T48",
        "(CC911) Location: US 70 HWY E New Bern Veh Crash-Injury  Call Time: 06/23/13 19:09 Narrative:  252-916-1931  WHITE OR SILVER TRUCK  unk on  injuries  dodge dakota blue or silver  truck just hydroplaned in the median  E911 Info - Class of Service: WPH2  35.0564455840001 -77.017310774",
        "ADDR:US 70 HWY E",
        "MADDR:US 70 E",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/23/13",
        "TIME:19:09",
        "INFO:252-916-1931  WHITE OR SILVER TRUCK  unk on  injuries  dodge dakota blue or silver  truck just hydroplaned in the median",
        "GPS:+35.056446,-77.017311");

    doTest("T49",
        "(CC911) Location: 322 FALCON BRIDGE DR New Bern Fire Alarm Residence Call Time: 06/23/13 10:39 Narrative:  ref #  b3702705 oper 417  called in by alarm comp fire alarm coming from the entry way x4  res of mike smasal  34.9730731060001 -76.967750343",
        "ADDR:322 FALCON BRIDGE DR",
        "CITY:New Bern",
        "CALL:Fire Alarm Residence",
        "DATE:06/23/13",
        "TIME:10:39",
        "INFO:ref #  b3702705 oper 417  called in by alarm comp fire alarm coming from the entry way x4  res of mike smasal  34.9730731060001 -76.967750343");

    doTest("T50",
        "(CC911) Location: 127 KELSO RD New Bern Fire Unknown Size or Type Call Time: 06/23/13 02:42 Narrative:  caller adv that it doesnt appear to be sparking any longer  in the area of this location  caller adv it was a huge explosion then sparks  transformer just blew  E911 Info - Class of Service: WPH2  35.079316722 -77.04852442",
        "ADDR:127 KELSO RD",
        "CITY:New Bern",
        "CALL:Fire Unknown Size or Type",
        "DATE:06/23/13",
        "TIME:02:42",
        "INFO:caller adv that it doesnt appear to be sparking any longer  in the area of this location  caller adv it was a huge explosion then sparks  transformer just blew",
        "GPS:+35.079317,-77.048524");

    doTest("T51",
        "(CC911) Location: COUNTY LINE RD New Bern Veh Crash-Injury  Call Time: 06/22/13 18:06 Narrative:  SMALL GREEN PICK UP  DIRT ROAD SECTION  RAN OFF THE ROAD AND HIT A RAIL  2 SUBJS IN SAME  VEHICLE ACCIDENT  E911 Info - Class of Service: WPH2  34.993298462 -76.9900088319999",
        "ADDR:COUNTY LINE RD",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/22/13",
        "TIME:18:06",
        "INFO:SMALL GREEN PICK UP  DIRT ROAD SECTION  RAN OFF THE ROAD AND HIT A RAIL  2 SUBJS IN SAME  VEHICLE ACCIDENT  E911 Info - Class of Service: WPH2  34.993298462 -76.9900088319999");

    doTest("T52",
        "(CC911) Location: 1200 BRICES CREEK RD BLK New Bern Veh Crash-Injury  Call Time: 06/22/13 11:31 Narrative:  21p3 10-23  spoke with new bern city power adv they have been dispatched  21p2 10-23  213 10-23  214 10-23 levl 1 staging  213 10-17  214 10-17  UNSOL.XAA2.SEND.20130622114046.  TO: CRC     -230822 20130622 11:40:46   0CCA00812D     FROM: XAA2            20130622 11:40:46  SEND CRC,  10-4  21p3 10-7  03SP00005X.SEND XAA2, NEED A TROOPER TO RESPOND TO THE AREA OF 1800 BRICES CREEK RD REF TO A SINGLE VEH 10-50 4X4 KIA SPORTAGE LIGHT GREEN IN COLOR HIT A TELEPHONE POLE LINE IS 3   FT OFF THE GROUND SAME IS IN THE CURVE NEAR PERRYTOWN RD  21p6  10-17  same will be in the curve  line is about 3ft off the ground believe same is a power line  poss 1 pi  same hit a telephone pole  1050 4x4 sportage 35.0714569276583 -77.0556358655448",
        "ADDR:1200 BRICES CREEK RD BLK",
        "MADDR:1200 BRICES CREEK RD",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/22/13",
        "TIME:11:31",
        "INFO:21p3 10-23  spoke with new bern city power adv they have been dispatched  21p2 10-23  213 10-23  214 10-23 levl 1 staging  213 10-17  214 10-17  UNSOL.XAA2.SEND.20130622114046.  TO: CRC     -230822 20130622 11:40:46   0CCA00812D     FROM: XAA2            20130622 11:40:46  SEND CRC,  10-4  21p3 10-7  03SP00005X.SEND XAA2, NEED A TROOPER TO RESPOND TO THE AREA OF 1800 BRICES CREEK RD REF TO A SINGLE VEH 10-50 4X4 KIA SPORTAGE LIGHT GREEN IN COLOR HIT A TELEPHONE POLE LINE IS 3   FT OFF THE GROUND SAME IS IN THE CURVE NEAR PERRYTOWN RD  21p6  10-17  same will be in the curve  line is about 3ft off the ground believe same is a power line  poss 1 pi  same hit a telephone pole  1050 4x4 sportage",
        "GPS:+35.071457,-77.055636");

    doTest("T53",
        "(CC911) Location: 1200 BRICES CREEK RD New Bern Veh Crash-Injury  Call Time: 06/22/13 11:31 Narrative:  21p3 10-23  spoke with new bern city power adv they have been dispatched  21p2 10-23  213 10-23  214 10-23 levl 1 staging  213 10-17  214 10-17  UNSOL.XAA2.SEND.20130622114046.  TO: CRC     -230822 20130622 11:40:46   0CCA00812D     FROM: XAA2            20130622 11:40:46  SEND CRC,  10-4  21p3 10-7  03SP00005X.SEND XAA2, NEED A TROOPER TO RESPOND TO THE AREA OF 1800 BRICES CREEK RD REF TO A SINGLE VEH 10-50 4X4 KIA SPORTAGE LIGHT GREEN IN COLOR HIT A TELEPHONE POLE LINE IS 3   FT OFF THE GROUND SAME IS IN THE CURVE NEAR PERRYTOWN RD  21p6  10-17  same will be in the curve  line is about 3ft off the ground believe same is a power line  poss 1 pi  same hit a telephone pole  1050 4x4 sportage 35.0714569276583 -77.0556358655448",
        "ADDR:1200 BRICES CREEK RD",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/22/13",
        "TIME:11:31",
        "INFO:21p3 10-23  spoke with new bern city power adv they have been dispatched  21p2 10-23  213 10-23  214 10-23 levl 1 staging  213 10-17  214 10-17  UNSOL.XAA2.SEND.20130622114046.  TO: CRC     -230822 20130622 11:40:46   0CCA00812D     FROM: XAA2            20130622 11:40:46  SEND CRC,  10-4  21p3 10-7  03SP00005X.SEND XAA2, NEED A TROOPER TO RESPOND TO THE AREA OF 1800 BRICES CREEK RD REF TO A SINGLE VEH 10-50 4X4 KIA SPORTAGE LIGHT GREEN IN COLOR HIT A TELEPHONE POLE LINE IS 3   FT OFF THE GROUND SAME IS IN THE CURVE NEAR PERRYTOWN RD  21p6  10-17  same will be in the curve  line is about 3ft off the ground believe same is a power line  poss 1 pi  same hit a telephone pole  1050 4x4 sportage",
        "GPS:+35.071457,-77.055636");

    doTest("T54",
        "(CC911) Location: 1800 BRICES CREEK RD New Bern Veh Crash-Injury  Call Time: 06/22/13 11:31 Narrative:  poss 1 pi  same hit a telephone pole  1050 4x4 sportage light green kia  E911 Info - Class of Service: WPH2  35.0664350722301 -77.0733944230661",
        "ADDR:1800 BRICES CREEK RD",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/22/13",
        "TIME:11:31",
        "INFO:poss 1 pi  same hit a telephone pole  1050 4x4 sportage light green kia",
        "GPS:+35.066435,-77.073394");

    doTest("T55",
        "(CC911) Location: 3720 US 70 HWY E New Bern Fire Alarm Business Call Time: 06/21/13 08:54 Narrative:  op ybx  showing key pad fire  the plant farm ",
        "ADDR:3720 US 70 HWY E",
        "MADDR:3720 US 70 E",
        "CITY:New Bern",
        "CALL:Fire Alarm Business",
        "DATE:06/21/13",
        "TIME:08:54",
        "INFO:op ybx  showing key pad fire  the plant farm");

    doTest("T56",
        "(CC911) Location: 305 SCOTT ST New Bern Medical Call Time: 06/21/13 07:47 Narrative:  no breathing  correction f  76 yo m  female is not responding  E911 Info - Class of Service: RESD  35.0896587230001 -77.038620737",
        "ADDR:305 SCOTT ST",
        "CITY:New Bern",
        "CALL:Medical",
        "DATE:06/21/13",
        "TIME:07:47",
        "INFO:no breathing  correction f  76 yo m  female is not responding",
        "GPS:+35.089659,-77.038621");

    doTest("T57",
        "(CC911) Location: OLD AIRPORT RD New Bern Veh Crash-Injury  Call Time: 06/19/13 16:55 Narrative:  trooper on scene advised leg pain  male subject struck riding bicycle  35.0661855720001 -77.0336583169999",
        "ADDR:OLD AIRPORT RD",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/19/13",
        "TIME:16:55",
        "INFO:trooper on scene advised leg pain  male subject struck riding bicycle",
        "GPS:+35.066186,-77.033658");

    doTest("T58",
        "(CC911) Location: US 70 HWY E New Bern Veh Crash-Property Call Time: 06/19/13 11:59 Narrative:  small child has bleeding ear  E911 Info - Class of Service: WPH2  Call #: 9732 - UNSOL.XAA2.SEND.20130619115603.    TO: CRC     -229811 20130619 11:56:03   0CCA0080AC     FROM: XAA2            20130619 11:56:03  SEND CRC,  10-4  Call #: 9732 - 03SM00004A.SEND XAA2, EASTBOUND ON US 70 HWY E AND E FISHER AVE REPORT OF A 10-50 VEHICLES ARE OFF THE ROAD WITH NO INJURIES    CRC/DANI  Call #: 9732 - EAST BOUND  Call #: 9732 - TURQUOISE NISSAN CENTRA  Call #: 9732 - CHEVY IMPALA SILVER IN COLOR  Call #: 9732 - NO INJURIES  Call #: 9732 - OFF THE ROADWAY  Call #: 9732 - 2 VEH 10-50  Call #: 9732 - ACROSS FROM NC FOREST SERVICE STATION  Call #: 9732 - E911 Info - Class of Service: WPH2  34.988826513 -76.981922853",
        "ADDR:US 70 HWY E",
        "MADDR:US 70 E",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:06/19/13",
        "TIME:11:59",
        "INFO:small child has bleeding ear  E911 Info - Class of Service: WPH2  Call #: 9732 - UNSOL.XAA2.SEND.20130619115603.    TO: CRC     -229811 20130619 11:56:03   0CCA0080AC     FROM: XAA2            20130619 11:56:03  SEND CRC,  10-4  Call #: 9732 - 03SM00004A.SEND XAA2, EASTBOUND ON US 70 HWY E AND E FISHER AVE REPORT OF A 10-50 VEHICLES ARE OFF THE ROAD WITH NO INJURIES    CRC/DANI  Call #: 9732 - EAST BOUND  Call #: 9732 - TURQUOISE NISSAN CENTRA  Call #: 9732 - CHEVY IMPALA SILVER IN COLOR  Call #: 9732 - NO INJURIES  Call #: 9732 - OFF THE ROADWAY  Call #: 9732 - 2 VEH 10-50  Call #: 9732 - ACROSS FROM NC FOREST SERVICE STATION  Call #: 9732 - E911 Info - Class of Service: WPH2  34.988826513 -76.981922853");

    doTest("T59",
        "(CC911) Location: E FISHER AVE New Bern Veh Crash-Property Call Time: 06/19/13 11:51 Narrative:  34.988826513 -76.981922853",
        "ADDR:E FISHER AVE",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:06/19/13",
        "TIME:11:51",
        "INFO:34.988826513 -76.981922853");

    doTest("T60",
        "(CC911) Location: 500 W  THURMAN RD New Bern Fire Hazardous Cond. Gas Oil Call Time: 06/18/13 19:37 Narrative:  right above the ground tanks  caller adv that they are putting fire extinguisher  veh has been moved from the gas pumps  veh on fire  comp is jennifer  E911 Info - Class of Service: BUSN  35.03787971 -77.008088887",
        "ADDR:500 W THURMAN RD",
        "CITY:New Bern",
        "CALL:Fire Hazardous Cond. Gas Oil",
        "DATE:06/18/13",
        "TIME:19:37",
        "INFO:right above the ground tanks  caller adv that they are putting fire extinguisher  veh has been moved from the gas pumps  veh on fire  comp is jennifer",
        "GPS:+35.037880,-77.008089");

    doTest("T61",
        "(CC911) Location: 307 JAMES ST New Bern Medical Call Time: 06/17/13 18:53 Narrative:  20p3-17  male subj says he is dehydrated  he has fallen and is real weak  38 yom  E911 Info - Class of Service: RESD  35.0872164260001 -77.029992196",
        "ADDR:307 JAMES ST",
        "CITY:New Bern",
        "CALL:Medical",
        "DATE:06/17/13",
        "TIME:18:53",
        "INFO:20p3-17  male subj says he is dehydrated  he has fallen and is real weak  38 yom",
        "GPS:+35.087216,-77.029992");

    doTest("T62",
        "(CC911) Location: US 70 HWY E New Bern Veh Crash-Property Call Time: 06/17/13 15:27 Narrative:  NO INJURIES  3 CAR 10-50  SMAE IS IN THE TURN LN  IN THE RD WAY  E911 Info - Class of Service: WPH2  35.081639792 -77.031452224",
        "ADDR:US 70 HWY E",
        "MADDR:US 70 E",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:06/17/13",
        "TIME:15:27",
        "INFO:NO INJURIES  3 CAR 10-50  SMAE IS IN THE TURN LN  IN THE RD WAY",
        "GPS:+35.081640,-77.031452");

    doTest("T63",
        "(CC911) Location: TWIN SPANS New Bern Veh Crash-Property Call Time: 06/17/13 13:01 Narrative:  heather hopkinson 671-0645  by the pembroke  on the briddge by downtown  boat on a bridge  E911 Info - Class of Service: WPH2  -361 -361",
        "ADDR:TWIN SPANS",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:06/17/13",
        "TIME:13:01",
        "INFO:heather hopkinson 671-0645  by the pembroke  on the briddge by downtown  boat on a bridge");

    doTest("T64",
        "(CC911) Location: Veh Crash-Property Call Time: 06/17/13 13:01 Narrative:  heather hopkinson 671-0645  by the pembroke  on the briddge by downtown  boat on a bridge  E911 Info - Class of Service: WPH2  35.096147 -77.045037",
        "CALL:Veh Crash-Property",
        "MADDR:+35.096147,-77.045037",
        "DATE:06/17/13",
        "TIME:13:01",
        "INFO:heather hopkinson 671-0645  by the pembroke  on the briddge by downtown  boat on a bridge",
        "GPS:+35.096147,-77.045037");

    doTest("T65",
        "(CC911) Location: 2600 OLD CHERRY POINT RD New Bern Medical Call Time: 06/15/13 14:27 Narrative:  2062 REQUESTING M/A  everything on her right side hurts  in pain  78 y/o f fell in the bathroom on he rright side  E911 Info - Class of Service: BUSN  35.065000572 -77.015222716",
        "ADDR:2600 OLD CHERRY POINT RD",
        "CITY:New Bern",
        "CALL:Medical",
        "DATE:06/15/13",
        "TIME:14:27",
        "INFO:2062 REQUESTING M/A  everything on her right side hurts  in pain  78 y/o f fell in the bathroom on he rright side",
        "GPS:+35.065001,-77.015223");

    doTest("T66",
        "(CC911) Location: 3919 OLD CHERRY POINT RD A New Bern Fire Structure Call Time: 06/14/13 19:37 Narrative:  burner on stove was on fire..now out  E911 Info - Class of Service: RESD  35.0422642837816 -77.0012206940276",
        "ADDR:3919 OLD CHERRY POINT RD A",
        "CITY:New Bern",
        "CALL:Fire Structure",
        "DATE:06/14/13",
        "TIME:19:37",
        "INFO:burner on stove was on fire..now out",
        "GPS:+35.042264,-77.001221");

    doTest("T67",
        "(CC911) Location: 417 MM HWY New Bern Veh Crash-Property Call Time: 06/14/13 11:23 Narrative:  UNSOL.XAA2.SEND.20130614112732.  TO: CRC1    -068141 20130614 11:27:32   0CCA007FCB     FROM: XAA2            20130614 11:27:32  SEND CRC1,  10-4  03SH00001O.SEND XAA2, 2 CAR 10-50 417B MM HWY AT THE",
        "ADDR:417 MM HWY",
        "MADDR:417 HWY MM",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:06/14/13",
        "TIME:11:23",
        "INFO:UNSOL.XAA2.SEND.20130614112732.  TO: CRC1    -068141 20130614 11:27:32   0CCA007FCB     FROM: XAA2            20130614 11:27:32  SEND CRC1,  10-4  03SH00001O.SEND XAA2, 2 CAR 10-50 417B MM HWY AT THE");

    doTest("T68",
        "(CC911) Location: 417 MM HWY b New Bern Veh Crash-Property Call Time: 06/14/13 11:23 Narrative:  unknown injuries  veh in roadway  two car mvc  E911 Info - Class of Service: WPH2 ",
        "ADDR:417 MM HWY b",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:06/14/13",
        "TIME:11:23",
        "INFO:unknown injuries  veh in roadway  two car mvc  E911 Info - Class of Service: WPH2");

    doTest("T69",
        "(CC911) Location: AIRPORT RD New Bern Veh Crash-Property Call Time: 06/14/13 08:59 Narrative:  C141 ADVISES THAT FD IS NEEDED FOR TRAFFIC CONTROL  BY FIRST CITIZENS BANK  VEH IN THE ROADWAY  C141 ADVISES PD ONLY  2 CARS  10-50  E911 Info - Class of Service: WRLS ",
        "ADDR:AIRPORT RD",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:06/14/13",
        "TIME:08:59",
        "INFO:C141 ADVISES THAT FD IS NEEDED FOR TRAFFIC CONTROL  BY FIRST CITIZENS BANK  VEH IN THE ROADWAY  C141 ADVISES PD ONLY  2 CARS  10-50  E911 Info - Class of Service: WRLS");

    doTest("T70",
        "(CC911) Location: 201 APPENZELL LN New Bern Medical Call Time: 06/14/13 06:51 Narrative:  code blue  FELL OUT OF THE CHAIR ON THE FLOOR  UNABLE TO RESPOND  BARELY BREATHING  POSSIBLE STROKE  FROM EYE  BLOOD IS COMING  68 Y/O M PASSED OUT  E911 Info - Class of Service: RESD ",
        "ADDR:201 APPENZELL LN",
        "CITY:New Bern",
        "CALL:Medical",
        "DATE:06/14/13",
        "TIME:06:51",
        "INFO:code blue  FELL OUT OF THE CHAIR ON THE FLOOR  UNABLE TO RESPOND  BARELY BREATHING  POSSIBLE STROKE  FROM EYE  BLOOD IS COMING  68 Y/O M PASSED OUT  E911 Info - Class of Service: RESD");

    doTest("T71",
        "(CC911) Location: OLD CHERRY POINT RD New Bern Veh Crash-Injury  Call Time: 06/12/13 16:14 Narrative:  21p1-17  jas125-17  UNSOL.XAA2.SEND.20130612162029.    TO: CRC     -227714 20130612 16:20:29   0CCA007F7F     FROM: XAA2            20130612 16:20:29  SEND CRC,  10-4  03SF00007T.SEND XAA2, POSSIBLY ",
        "ADDR:OLD CHERRY POINT RD",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/12/13",
        "TIME:16:14",
        "INFO:21p1-17  jas125-17  UNSOL.XAA2.SEND.20130612162029.    TO: CRC     -227714 20130612 16:20:29   0CCA007F7F     FROM: XAA2            20130612 16:20:29  SEND CRC,  10-4  03SF00007T.SEND XAA2, POSSIBLY");

    doTest("T72",
        "(CC911) Location: OLD CHERRY POINT RD New Bern Veh Crash-Injury  Call Time: 06/12/13 16:14 Narrative:  03SF00007K.SEND XAA2, NEED A TROOPER TO RESPOND TO US 70 HWY WEST BOUND BY OLD CHERRY POINT BY OLD MEXICAN IMPORTS/LYNNAIRE KENNEL TO 2 VEHICLE ACCIDENT     MICHELLE/CRC  poss 4 pi's  2 vehicles  hon",
        "ADDR:OLD CHERRY POINT RD",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/12/13",
        "TIME:16:14",
        "INFO:03SF00007K.SEND XAA2, NEED A TROOPER TO RESPOND TO US 70 HWY WEST BOUND BY OLD CHERRY POINT BY OLD MEXICAN IMPORTS/LYNNAIRE KENNEL TO 2 VEHICLE ACCIDENT     MICHELLE/CRC  poss 4 pi's  2 vehicles  hon");

    doTest("T73",
        "(CC911) Location: CAMELOT DR New Bern Veh Crash-Property Call Time: 06/11/13 06:51 Narrative:  unable to tell if anyone is in the vehicle  vehicle over turned in the ditch  E911 Info - Class of Service: WRLS ",
        "ADDR:CAMELOT DR",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:06/11/13",
        "TIME:06:51",
        "INFO:unable to tell if anyone is in the vehicle  vehicle over turned in the ditch  E911 Info - Class of Service: WRLS");

    doTest("T74",
        "(CC911) Location: US 70 HWY E New Bern Veh Crash-Injury  Call Time: 06/09/13 17:03 Narrative:  E911 Info - Class of Service: WPH2 ",
        "ADDR:US 70 HWY E",
        "MADDR:US 70 E",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/09/13",
        "TIME:17:03",
        "INFO:E911 Info - Class of Service: WPH2");

    doTest("T75",
        "(CC911) Location: US 70 HWY E New Bern Veh Crash-Injury  Call Time: 06/08/13 12:50 Narrative:  west bound ",
        "ADDR:US 70 HWY E",
        "MADDR:US 70 E",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/08/13",
        "TIME:12:50",
        "INFO:west bound");

    doTest("T76",
        "(CC911) Location: 235 CAROLINA PINES BLVD New Bern Fire Alarm Residence Call Time: 06/08/13 10:16 Narrative:  oper 870  location: smoke alarm  residence: dorman,robert ",
        "ADDR:235 CAROLINA PINES BLVD",
        "CITY:New Bern",
        "CALL:Fire Alarm Residence",
        "DATE:06/08/13",
        "TIME:10:16",
        "INFO:oper 870  location: smoke alarm  residence: dorman,robert");

    doTest("T77",
        "(CC911) Location: 2600 OLD CHERRY POINT RD New Bern Fire Alarm Business Call Time: 06/08/13 08:02 Narrative:  OP 7206  SMOKE DETECTOR/FIRE ALARM  RIVER POINTE CREST ",
        "ADDR:2600 OLD CHERRY POINT RD",
        "CITY:New Bern",
        "CALL:Fire Alarm Business",
        "DATE:06/08/13",
        "TIME:08:02",
        "INFO:OP 7206  SMOKE DETECTOR/FIRE ALARM  RIVER POINTE CREST");
   
  }

  @Test
  public void testWestOfNewBernVolFireDept() {

    doTest("T1",
        "(CC911) Location: 313 HOKE ST New Bern Fire Alarm Business Call Time: 07/20/13 07:16 Narrative:  op 7108  showing office smoke dector  arc craven #3 group home ",
        "ADDR:313 HOKE ST",
        "CITY:New Bern",
        "CALL:Fire Alarm Business",
        "DATE:07/20/13",
        "TIME:07:16",
        "INFO:op 7108  showing office smoke dector  arc craven #3 group home");

    doTest("T2",
        "(CC911) Location: 124 DRY MONIA RD New Bern Fire Alarm Residence Call Time: 07/19/13 05:29 Narrative:  OPR GWR RES FIRE ALARM  35.1609989070001 -77.213118327",
        "ADDR:124 DRY MONIA RD",
        "CITY:New Bern",
        "CALL:Fire Alarm Residence",
        "DATE:07/19/13",
        "TIME:05:29",
        "INFO:OPR GWR RES FIRE ALARM",
        "GPS:+35.160999,-77.213118");

    doTest("T3",
        "(CC911) Location: 3707 OLD CHERRY POINT RD New Bern Fire Structure Call Time: 07/18/13 22:53 Narrative:  the barn is on fire  E911 Info - Class of Service: WPH2  35.046907622 -77.004935255",
        "ADDR:3707 OLD CHERRY POINT RD",
        "CITY:New Bern",
        "CALL:Fire Structure",
        "DATE:07/18/13",
        "TIME:22:53",
        "INFO:the barn is on fire",
        "GPS:+35.046908,-77.004935");

    doTest("T4",
        "(CC911) Location: 3707 OLD CHERRY POINT RD New Bern Fire Structure Call Time: 07/17/13 22:35 Narrative:  KENNETH REASON BELIVES THE FIRE IS INTENTIONAL  adv that there is no vehicles or gasoline or anything like that  adv that the garage is on fire  E911 Info - Class of Service: WPH2  35.046907622 -77.004935255",
        "ADDR:3707 OLD CHERRY POINT RD",
        "CITY:New Bern",
        "CALL:Fire Structure",
        "DATE:07/17/13",
        "TIME:22:35",
        "INFO:KENNETH REASON BELIVES THE FIRE IS INTENTIONAL  adv that there is no vehicles or gasoline or anything like that  adv that the garage is on fire",
        "GPS:+35.046908,-77.004935");

    doTest("T5",
        "(CC911) Location: 103 EXECUTIVE PKWY New Bern Fire Alarm Business Call Time: 07/17/13 16:49 Narrative:  attempting to contact  progress energy new bern administration  oper 7060  fire smoke detectors ",
        "ADDR:103 EXECUTIVE PKWY",
        "CITY:New Bern",
        "CALL:Fire Alarm Business",
        "DATE:07/17/13",
        "TIME:16:49",
        "INFO:attempting to contact  progress energy new bern administration  oper 7060  fire smoke detectors");

    doTest("T6",
        "(CC911) Location: 4711 TRENT RIVER DR New Bern Fire Heat Alarm Call Time: 07/16/13 15:05 Narrative:  op oab  showing attic smoke dector  last name is carptner  35.0760681150001 -77.100520793",
        "ADDR:4711 TRENT RIVER DR",
        "CITY:New Bern",
        "CALL:Fire Heat Alarm",
        "DATE:07/16/13",
        "TIME:15:05",
        "INFO:op oab  showing attic smoke dector  last name is carptner",
        "GPS:+35.076068,-77.100521");

    doTest("T7",
        "(CC911) Location: 613 ALEXIS DR New Bern Fire Structure Call Time: 07/11/13 20:17 Narrative:  possible electrical fire  fire in the wall  E911 Info - Class of Service: WRLS  35.0818287700001 -77.050250481",
        "ADDR:613 ALEXIS DR",
        "CITY:New Bern",
        "CALL:Fire Structure",
        "DATE:07/11/13",
        "TIME:20:17",
        "INFO:possible electrical fire  fire in the wall",
        "GPS:+35.081829,-77.050250");

    doTest("T8",
        "(CC911) Location: 161 CHRIS RD Vanceboro New Call Call Time: 07/11/13 20:02 Narrative:  smoking coming from the furnace  E911 Info - Class of Service: WPH2  35.269617919 -77.1721476829999",
        "ADDR:161 CHRIS RD",
        "CITY:Vanceboro",
        "CALL:New Call",
        "DATE:07/11/13",
        "TIME:20:02",
        "INFO:smoking coming from the furnace",
        "GPS:+35.269618,-77.172148");

    doTest("T9",
        "(CC911) Location: 423 SATTERFIELD DR New Bern Fire Alarm Residence Call Time: 07/11/13 17:52 Narrative:  252-342-1638  terence juion/oper 469- fire alarm - living room smoke dector  35.05062387 -77.010924453",
        "ADDR:423 SATTERFIELD DR",
        "CITY:New Bern",
        "CALL:Fire Alarm Residence",
        "DATE:07/11/13",
        "TIME:17:52",
        "INFO:252-342-1638  terence juion/oper 469- fire alarm - living room smoke dector",
        "GPS:+35.050624,-77.010924");

    doTest("T10",
        "(CC911) Location: 1213 US 70 HWY E New Bern Fire Unknown Size or Type Call Time: 07/10/13 17:53 Narrative:  call came in from craven tire  adv can see smoke and flames coming from same  adv same is behind craven pre cast and is on the rr trcts in the area  E911 Info - Class of Service: BUSN  35.076528904 -77.029910905",
        "ADDR:1213 US 70 HWY E",
        "MADDR:1213 US 70 E",
        "CITY:New Bern",
        "CALL:Fire Unknown Size or Type",
        "DATE:07/10/13",
        "TIME:17:53",
        "INFO:call came in from craven tire  adv can see smoke and flames coming from same  adv same is behind craven pre cast and is on the rr trcts in the area",
        "GPS:+35.076529,-77.029911");

    doTest("T11",
        "(CC911) Location: 901 INDUSTRIAL DR New Bern Fire Alarm Business Call Time: 07/10/13 13:26 Narrative:  FIRE ZONE 11  CAROLINA TEECH PLASTICS  REF# 1373330  OP JC05 ",
        "ADDR:901 INDUSTRIAL DR",
        "CITY:New Bern",
        "CALL:Fire Alarm Business",
        "DATE:07/10/13",
        "TIME:13:26",
        "INFO:FIRE ZONE 11  CAROLINA TEECH PLASTICS  REF# 1373330  OP JC05");

    doTest("T12",
        "(CC911) Location: 1100 OLD CHERRY POINT RD New Bern Fire Alarm Business Call Time: 07/10/13 06:48 Narrative:  oper bcw  location fire alarm activation from keypad  business: machine and welding supply co ",
        "ADDR:1100 OLD CHERRY POINT RD",
        "CITY:New Bern",
        "CALL:Fire Alarm Business",
        "DATE:07/10/13",
        "TIME:06:48",
        "INFO:oper bcw  location fire alarm activation from keypad  business: machine and welding supply co");

    doTest("T13",
        "(CC911) Location: 105 HOLLY BERRY RD New Bern Fire Structure Call Time: 07/08/13 18:20 Narrative:  BOTH SUBJS ON THE PHONE SOUNDED LIKE THEY WERE HAVING SOME DIFF BREATHING.. ALL OCCUPANTS ARE OUT OF THE HOUSE  FIRE IS OUT.. HOUSE IF FULL OF SMOKE...  GREASE FIRE ON STOVE...  E911 Info - Class of Service: WRLS  35.031321119 -76.994701865",
        "ADDR:105 HOLLY BERRY RD",
        "CITY:New Bern",
        "CALL:Fire Structure",
        "DATE:07/08/13",
        "TIME:18:20",
        "INFO:BOTH SUBJS ON THE PHONE SOUNDED LIKE THEY WERE HAVING SOME DIFF BREATHING.. ALL OCCUPANTS ARE OUT OF THE HOUSE  FIRE IS OUT.. HOUSE IF FULL OF SMOKE...  GREASE FIRE ON STOVE...  E911 Info - Class of Service: WRLS  35.031321119 -76.994701865");

    doTest("T14",
        "(CC911) Location: 411 MM HWY New Bern Veh Crash-Injury  Call Time: 07/05/13 06:52 Narrative:  VEHICLE IS IN THE WOODS  FEMALE IS HOLDING HER ARM  WHITE EXPLORER  OVER TURNED VEHICLE  Call #: 1556 - E911 Info - Class of Service: WPH2  E911 Info - Class of Service: WPH2  35.1275008010001 -77.1346616549999",
        "ADDR:411 MM HWY",
        "MADDR:411 HWY MM",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:07/05/13",
        "TIME:06:52",
        "INFO:VEHICLE IS IN THE WOODS  FEMALE IS HOLDING HER ARM  WHITE EXPLORER  OVER TURNED VEHICLE  Call #: 1556 -",
        "GPS:+35.127501,-77.134662");

    doTest("T15",
        "(CC911) Location: 410 MM HWY New Bern Veh Crash-Injury  Call Time: 07/05/13 06:52 Narrative:  VEHICLE IS IN THE WOODS  FEMALE IS HOLDING HER ARM  WHITE EXPLORER  OVER TURNED VEHICLE  Call #: 1556 - E911 Info - Class of Service: WPH2  E911 Info - Class of Service: WPH2  35.1324666150001 -77.151187111",
        "ADDR:410 MM HWY",
        "MADDR:410 HWY MM",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:07/05/13",
        "TIME:06:52",
        "INFO:VEHICLE IS IN THE WOODS  FEMALE IS HOLDING HER ARM  WHITE EXPLORER  OVER TURNED VEHICLE  Call #: 1556 -",
        "GPS:+35.132467,-77.151187");

    doTest("T16",
        "(CC911) Location: 411 MM HWY New Bern Veh Crash-Injury  Call Time: 07/05/13 06:52 Narrative:  VEHICLE IS IN THE WOODS  FEMALE IS HOLDING HER ARM  WHITE EXPLORER  OVER TURNED VEHICLE  E911 Info - Class of Service: WPH2  35.1275008010001 -77.1346616549999",
        "ADDR:411 MM HWY",
        "MADDR:411 HWY MM",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:07/05/13",
        "TIME:06:52",
        "INFO:VEHICLE IS IN THE WOODS  FEMALE IS HOLDING HER ARM  WHITE EXPLORER  OVER TURNED VEHICLE",
        "GPS:+35.127501,-77.134662");

    doTest("T17",
        "(CC911) Location: 212 KALE RD New Bern Fire Structure Call Time: 07/03/13 14:26 Narrative:  FIRE IN THE WALL  E911 Info - Class of Service: BUSN  35.067371253 -77.0292738809999",
        "ADDR:212 KALE RD",
        "CITY:New Bern",
        "CALL:Fire Structure",
        "DATE:07/03/13",
        "TIME:14:26",
        "INFO:FIRE IN THE WALL",
        "GPS:+35.067371,-77.029274");

    doTest("T18",
        "(CC911) Location: 715 S WEST CRAVEN MIDDLE SCHOOL RD New Bern Fire Structure Call Time: 07/01/13 18:08 Narrative:  old tobacco barn burning  E911 Info - Class of Service: WPH2  35.187971438 -77.1587135029999",
        "ADDR:715 S WEST CRAVEN MIDDLE SCHOOL RD",
        "CITY:New Bern",
        "CALL:Fire Structure",
        "DATE:07/01/13",
        "TIME:18:08",
        "INFO:old tobacco barn burning",
        "GPS:+35.187971,-77.158714");

    doTest("T19",
        "(CC911) Location: 935 US 70 HWY E New Bern Fire Alarm Business Call Time: 07/01/13 07:53 Narrative:  OP 28  RESTROOM PULL STATION ",
        "ADDR:935 US 70 HWY E",
        "MADDR:935 US 70 E",
        "CITY:New Bern",
        "CALL:Fire Alarm Business",
        "DATE:07/01/13",
        "TIME:07:53",
        "INFO:OP 28  RESTROOM PULL STATION");

    doTest("T20",
        "(CC911) Location: 235 JEREMY ST Cove City Security Check Residential Call Time: 06/28/13 19:00 Narrative:  this one popped up early.....the next one after midnite tonight will be the one that needs to be handled.....  compl advised that the subject that lived here has died and that she adv that she and her daughter will be moving items out of the residence during the day, and that no one should be there at night...she adv that her daughter can be reached at 252-474-7581...Ms Latham....\n" +
        "This will be set up for the next two weeks, she will call back if she needs it extended any longer, although she believes that 2 weeks will be long enough to clear the residence....\n" +
        "  35.2253174803295 -77.2899399601001",

        "ADDR:235 JEREMY ST",
        "CITY:Cove City",
        "CALL:Security Check Residential",
        "DATE:06/28/13",
        "TIME:19:00",
        "INFO:this one popped up early.....the next one after midnite tonight will be the one that needs to be handled.....  compl advised that the subject that lived here has died and that she adv that she and her daughter will be moving items out of the residence during the day, and that no one should be there at night...she adv that her daughter can be reached at 252-474-7581...Ms Latham....\nThis will be set up for the next two weeks, she will call back if she needs it extended any longer, although she believes that 2 weeks will be long enough to clear the residence....",
        "GPS:+35.225317,-77.289940");

    doTest("T21",
        "(CC911) Location: 412 MM HWY New Bern Veh Crash-Injury  Call Time: 06/27/13 21:15 Narrative:  VEHICLE IN THE MEDIAN  E911 Info - Class of Service: WPH2  35.122508657 -77.1181686369999",
        "ADDR:412 MM HWY",
        "MADDR:412 HWY MM",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/27/13",
        "TIME:21:15",
        "INFO:VEHICLE IN THE MEDIAN",
        "GPS:+35.122509,-77.118169");

    doTest("T22",
        "(CC911) Location: 411 MM HWY New Bern Veh Crash-Injury  Call Time: 06/27/13 18:47 Narrative:  18 WHEELER FLIPPED OVER ON THE RAMP GOING TO HWY 43  E911 Info - Class of Service: WPH2  35.1275008010001 -77.1346616549999",
        "ADDR:411 MM HWY",
        "MADDR:411 HWY MM",
        "CITY:New Bern",
        "CALL:Veh Crash-Injury",
        "DATE:06/27/13",
        "TIME:18:47",
        "INFO:18 WHEELER FLIPPED OVER ON THE RAMP GOING TO HWY 43",
        "GPS:+35.127501,-77.134662");

    doTest("T23",
        "(CC911) Location: 104 PORTSIDE LN New Bern Weather Related Call Time: 06/27/13 15:35 Narrative:  CALLER ADV THAT THE PHONE WILL NOT WORK BUT THE HOUSE HAS POWER  THE SMOKE DETECTOR  CALLER ADV THAT THE ALARM IN THE RES IS GOING OFF  CALLER ADV THAT THE NEIGHBOR COULD NOT SEE OR SMELL ANY SMOKE BUT WOULD LIKE SAME TO BE CHECKED OUT  CALLER ADV THAT THERE IS NO ONE IN THE RES NOW  CALLER ADV THAT THE NEIGHBOR CAME TO HER HOUSE AND ASKED HER TO CALL THE FD  CALLER ADV THAT LIGHTING HIT HER NEIGHBORS RES  E911 Info - Class of Service: WRLS  35.076205057 -77.145592928",
        "ADDR:104 PORTSIDE LN",
        "CITY:New Bern",
        "CALL:Weather Related",
        "DATE:06/27/13",
        "TIME:15:35",
        "INFO:CALLER ADV THAT THE PHONE WILL NOT WORK BUT THE HOUSE HAS POWER  THE SMOKE DETECTOR  CALLER ADV THAT THE ALARM IN THE RES IS GOING OFF  CALLER ADV THAT THE NEIGHBOR COULD NOT SEE OR SMELL ANY SMOKE BUT WOULD LIKE SAME TO BE CHECKED OUT  CALLER ADV THAT THERE IS NO ONE IN THE RES NOW  CALLER ADV THAT THE NEIGHBOR CAME TO HER HOUSE AND ASKED HER TO CALL THE FD  CALLER ADV THAT LIGHTING HIT HER NEIGHBORS RES",
        "GPS:+35.076205,-77.145593");

    doTest("T24",
        "(CC911) Location: 617 ALEXIS DR New Bern Fire Unknown Size or Type Call Time: 06/25/13 18:32 Narrative:  smells smoke  systems are out thinks her house got struck by lighting  E911 Info - Class of Service: RESD  35.081622554 -77.050829613",
        "ADDR:617 ALEXIS DR",
        "CITY:New Bern",
        "CALL:Fire Unknown Size or Type",
        "DATE:06/25/13",
        "TIME:18:32",
        "INFO:smells smoke  systems are out thinks her house got struck by lighting",
        "GPS:+35.081623,-77.050830");

    doTest("T25",
        "(CC911) Location: 411 MM HWY New Bern New Call Call Time: 06/25/13 16:00 Narrative:  NO INJURIES  ONE IN DITCH  ONE IN MEDIAN  2 VEH  east bound  E911 Info - Class of Service: WPH2  35.1275008010001 -77.1346616549999",
        "ADDR:411 MM HWY",
        "MADDR:411 HWY MM",
        "CITY:New Bern",
        "CALL:New Call",
        "DATE:06/25/13",
        "TIME:16:00",
        "INFO:NO INJURIES  ONE IN DITCH  ONE IN MEDIAN  2 VEH  east bound",
        "GPS:+35.127501,-77.134662");

    doTest("T26",
        "(CC911) Location: 4607 WEST FAIRWAY DR New Bern New Call Call Time: 06/25/13 11:05 Narrative:  house fire  E911 Info - Class of Service: BUSN  35.0795352980001 -77.097099978",
        "ADDR:4607 WEST FAIRWAY DR",
        "CITY:New Bern",
        "CALL:New Call",
        "DATE:06/25/13",
        "TIME:11:05",
        "INFO:house fire",
        "GPS:+35.079535,-77.097100");

    doTest("T27",
        "(CC911) Location: 1100 CLARKS RD New Bern Fire Alarm Business Call Time: 06/24/13 18:23 Narrative:  attempting to contact  oper 7047  fire water flow alarm ",
        "ADDR:1100 CLARKS RD",
        "CITY:New Bern",
        "CALL:Fire Alarm Business",
        "DATE:06/24/13",
        "TIME:18:23",
        "INFO:attempting to contact  oper 7047  fire water flow alarm");

    doTest("T28",
        "(CC911) Location: 2601 HOUNDS TRL New Bern Fire Alarm Residence Call Time: 06/24/13 16:05 Narrative:  31TRAFFIC4 ADV COND 7  31P4 CAN CANCEL STA21 AND UNITS NOT ON SCENE  31P5 RESPONDING  ADV NOTHING SHOWING  31TRAFFIC4 ON SCENE  21P7 RESPONDING TO STATION 1  216 STANDING BY AWAITING DRIVER  31P4 RESPONDING  OPER UYC  ATTEMPTING TO CONTACT  SMOKE DETECTION HALLWAY  35.0868108870001 -77.0722225769999",
        "ADDR:2601 HOUNDS TRL",
        "CITY:New Bern",
        "CALL:Fire Alarm Residence",
        "DATE:06/24/13",
        "TIME:16:05",
        "INFO:31TRAFFIC4 ADV COND 7  31P4 CAN CANCEL STA21 AND UNITS NOT ON SCENE  31P5 RESPONDING  ADV NOTHING SHOWING  31TRAFFIC4 ON SCENE  21P7 RESPONDING TO STATION 1  216 STANDING BY AWAITING DRIVER  31P4 RESPONDING  OPER UYC  ATTEMPTING TO CONTACT  SMOKE DETECTION HALLWAY",
        "GPS:+35.086811,-77.072223");

    doTest("T29",
        "(CC911) Location: 2601 HOUNDS TRL New Bern Fire Alarm Residence Call Time: 06/24/13 16:05 Narrative:  OPER UYC  ATTEMPTING TO CONTACT  SMOKE DETECTION HALLWAY  35.0868108870001 -77.0722225769999",
        "ADDR:2601 HOUNDS TRL",
        "CITY:New Bern",
        "CALL:Fire Alarm Residence",
        "DATE:06/24/13",
        "TIME:16:05",
        "INFO:OPER UYC  ATTEMPTING TO CONTACT  SMOKE DETECTION HALLWAY",
        "GPS:+35.086811,-77.072223");

    doTest("T30",
        "(CC911) Location: 4130 ML KING JR BLVD New Bern Veh Crash-Property Call Time: 06/24/13 12:36 Narrative:  03SR00004U.SEND XAA2, 2 CAR 10-50  GREENLEAF CEMETARY RD AND HWY 17 S..4000 BLK OF HWY 17..          CRC1/ORMOND  hwy 17 southbound  lincoln and ford escape  caller adv no injuries  unsure of injuries  one of road one in middle of rd  2 veh  E911 Info - Class of Service: WPH2  35.0946805496365 -77.1219862137577",
        "ADDR:4130 ML KING JR BLVD",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:06/24/13",
        "TIME:12:36",
        "INFO:03SR00004U.SEND XAA2, 2 CAR 10-50  GREENLEAF CEMETARY RD AND HWY 17 S..4000 BLK OF HWY 17..          CRC1/ORMOND  hwy 17 southbound  lincoln and ford escape  caller adv no injuries  unsure of injuries  one of road one in middle of rd  2 veh",
        "GPS:+35.094681,-77.121986");

    doTest("T31",
        "(CC911) Location: 411 MM HWY New Bern Veh Crash-Property Call Time: 06/23/13 18:26 Narrative:  03SQ000087.SEND XAA2, NEED A TROOPER TO RESPOND TO 411 MM HWY REF TO WHITE CHEVY IMPALA HAS   HYDROPLANED AND IS IN THE MEDIAN    MICHELLE/CRC  unk on injuries  veh is a white chevy impala 4 dr  facing east bound  in the median  E911 Info - Class of Service: WPH2  35.1275008010001 -77.1346616549999",
        "ADDR:411 MM HWY",
        "MADDR:411 HWY MM",
        "CITY:New Bern",
        "CALL:Veh Crash-Property",
        "DATE:06/23/13",
        "TIME:18:26",
        "INFO:03SQ000087.SEND XAA2, NEED A TROOPER TO RESPOND TO 411 MM HWY REF TO WHITE CHEVY IMPALA HAS   HYDROPLANED AND IS IN THE MEDIAN    MICHELLE/CRC  unk on injuries  veh is a white chevy impala 4 dr  facing east bound  in the median",
        "GPS:+35.127501,-77.134662");

    doTest("T32",
        "(CC911) Location: WEDGEWOOD DR New Bern Fire Unknown Size or Type Call Time: 06/23/13 15:38 Narrative:  2nd pole o the right pass dunn and dunn law office  by dunns law office  power line on fire  E911 Info - Class of Service: WRLS  35.079811695 -77.071882256",
        "ADDR:WEDGEWOOD DR",
        "CITY:New Bern",
        "CALL:Fire Unknown Size or Type",
        "DATE:06/23/13",
        "TIME:15:38",
        "INFO:2nd pole o the right pass dunn and dunn law office  by dunns law office  power line on fire",
        "GPS:+35.079812,-77.071882");

    doTest("T33",
        "(CC911) Location: 322 FALCON BRIDGE DR New Bern Fire Alarm Residence Call Time: 06/23/13 10:39 Narrative:  ref #  b3702705 oper 417  called in by alarm comp fire alarm coming from the entry way x4  res of mike smasal  34.9730731060001 -76.967750343",
        "ADDR:322 FALCON BRIDGE DR",
        "CITY:New Bern",
        "CALL:Fire Alarm Residence",
        "DATE:06/23/13",
        "TIME:10:39",
        "INFO:ref #  b3702705 oper 417  called in by alarm comp fire alarm coming from the entry way x4  res of mike smasal  34.9730731060001 -76.967750343");

    doTest("T34",
        "(CC911) Location: 3720 US 70 HWY E New Bern Fire Alarm Business Call Time: 06/21/13 08:54 Narrative:  op ybx  showing key pad fire  the plant farm ",
        "ADDR:3720 US 70 HWY E",
        "MADDR:3720 US 70 E",
        "CITY:New Bern",
        "CALL:Fire Alarm Business",
        "DATE:06/21/13",
        "TIME:08:54",
        "INFO:op ybx  showing key pad fire  the plant farm");

    doTest("T35",
        "(CC911) Location: CLARKS RD New Bern Traffic All Other Call Time: 06/17/13 19:58 Narrative:  WANTS TO KNOW IF FD CAN ASSIT  HAS OIL IN THE TURN LANE,  CALLER IS MANGUM TOWING, TRUCK HAS BLOWN AN OIL PAN  HE IS ON THE WEST BOUND SIDE  70 EAST BOUND  E911 Info - Class of Service: WRLS  35.141915822 -77.1641077",
        "ADDR:CLARKS RD",
        "CITY:New Bern",
        "CALL:Traffic All Other",
        "DATE:06/17/13",
        "TIME:19:58",
        "INFO:WANTS TO KNOW IF FD CAN ASSIT  HAS OIL IN THE TURN LANE,  CALLER IS MANGUM TOWING, TRUCK HAS BLOWN AN OIL PAN  HE IS ON THE WEST BOUND SIDE  70 EAST BOUND",
        "GPS:+35.141916,-77.164108");

  }

  public static void main(String[] args) {
    new NCCravenCountyParserTest().generateTests("T1");
  }
}

