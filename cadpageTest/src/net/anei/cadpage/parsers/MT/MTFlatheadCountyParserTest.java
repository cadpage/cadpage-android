package net.anei.cadpage.parsers.MT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Flathead County, MT
Contact: Tristan Peterson <twpetetson72@gmail.com>
Sender: dispatch@communicationcenter.com

1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: 417 1ST AVE N Martin City Call\n(Con't) 2 of 3\nType: Medical ALS Call Time: 06:29 Info:  ton of cars in front drive, thengo to back yard  had chest pains prior to this  CO UNITS ADV \n(Con't) 3 of 3\ncpr in progress  50 ACK  55 ACK  turning blue  unk what happened, goingto him now  \n(End)
1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: Hungry Horse Reservoir Call\n(Con't) 2 of 3\nType: Medical ALS Call Time: 21:13 Info:  RUN CARD SHOWED NO FIRE UNITS TODISPATCH, DISPATCHED HHFD AND MCFD FROM MEMORY  1602 AND 1501\n(Con't) 3 of 3\nACK  RP CALLED BACK....FATHER IS FEELING WEAK AND SLEEPY  ADV TO CALL BACKWHEN GETS\n(End)
1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: HIGHWAY 2 E Hungry Horse Call\n(Con't) 2 of 3\nType: F Smoke Investigation - Outside Call Time: 20:00 Info:  RP LIVES AT844 WOODLAND AVE  CAN SEE WHAT APPEARS TO BE A SMOKE CLOUD\n(Con't) 3 of 3\nCOMING FORM THE AREA OF HUNGRY HORSE. \n(End)
1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: Call Type: MVA Injury Call Time:\n(Con't) 2 of 3\n17:03 Info:  RP STATED THEY DID NOT NEED ALERT  KIDC SAYS TREMS CAN MAKEIT UP THERE...LOWER LEFT LEG PAIN, NO LOC & SOME HEAD ABRASIONS \n(Con't) 3 of 3\n4 MILES UP RD #497//TOWARD DESERT MTN RD  LEG AND BACK\n(End)

Contact: Active911
Agency name: Whitefish Fire
Location: Whitefish, MT, United States
Sender: <dispatch@communicationcenter.com>

(Dispatch Information) Unit:221 Status:Dispatched Location: 1005 BAKER AVE Gen: WHITEFISH CREDIT UNION - SECOND BRANCH WFWhitefish Call Type: Medical BLS RED Call Time: 10:45 Info:  IS CONC AND BREATHING  50 YOM  SEIZURE  E911 Info - Class of Service: WPH2 
(Dispatch Information) Unit:221 Status:Dispatched Location: 1060 E EDGEWOOD DR Gen: Whitefish Call Type: Medical BLS YEL Call Time: 20:14 Info:  NUMB FOR 5-10 MIN  ALERT, CONSCIOUS AND BREATHING  NOW LEG IS NUMB AND WON'T SUPPORT WEIGHT  24YOM HAD A TORN HAMSTRING A WEEK AGO  E911 Info - Class of Service: WRLS 
(Dispatch Information) Unit:221 Status:Dispatched Location: 1305 E 7TH ST Gen: WHITEFISH CARE AND REHABWhitefish Call Type: Medical ALS Call Time: 19:01 Info:  UNABLE TO SPEAK CLEARLY, CANNOT TRACK WITH HER EYES  SYMPTOMS JUST STARTED  FRONT ENTRANCE  AT NURSES STATION 1--COME ALL THE WAY TO THE BACK  Nature Of Call: 18M3  BREATHING ALRIGHT  DECREASED LOC  POSSIBLE STROKE  75 YOF 02 LEVELS LOW, LOW PULSE 
(Dispatch Information) Unit:221 Status:Dispatched Location: 1600 HOSPITAL WAY Gen: NVHWhitefish Call Type: Medical BLS YEL Call Time: 18:36 Info:  CONC AND BREATHING  Nature Of Call: 24Y2  JUST NEED ASSISTANCE MOVING HIM  ER IS AFRAID TO MOVE HIM  FALL PATIENT  NEED A PATIENT MOVED FROM A BUS TO THE ER 
(Dispatch Information) Unit:221 Status:Dispatched Location: 930 ASHAR AVE Gen: Whitefish Call Type: Medical ALS Call Time: 18:14 Info:  not breathing  58 yom cold to the touch  E911 Info - Class of Service: WRLS 
(Dispatch Information) Unit:221 Status:Dispatched Location: 1345 E 7TH ST Gen: WHITEFISH MANORWhitefish Call Type: Medical BLS YEL Call Time: 16:57 Info:  NO HX OR ROOM #  KEYHOLDER PENDING  MEDICAL ALARM 
(Dispatch Information) Unit:223 Status:Dispatched Location: Gen: MM 141 HIGHWAY 93 NOLNEY Call Type: MVA BLS RED Call Time: 12:41 Info:  4DOOR SEDAN REAREND BY 3/4 TON TRUCK  Nature Of Call: 25R3  REQ AND AMBULANDCE AND MHP  MT DOT  E911 Info - Class of Service: RESD 
(Dispatch Information) Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: Inter Facility Transfer Call Time: 12:29 Info: 
(Dispatch Information) Unit:221 Status:Dispatched Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: < New Call > Call Time: 12:29 Info: 
(Dispatch Information) Unit:221 Status:Dispatched Location: 1600 HOSPITAL WAY Gen: NVHWhitefish Call Type: Inter Facility Transfer Call Time: 08:31 Info:  BLS LEVEL IS FINE  NEED PATIENT PICKED UP AT MED/SURG AT 10:30 TO GO TO KRMC FOR A PROCEDURE 
(Dispatch Information) Unit:221 Status:Dispatched Location: 807 GREENWOOD DR Gen: Whitefish Call Type: Medical BLS YEL Call Time: 09:05 Info:  Nature Of Call: 1Y2  UNABLE TO STAND  CONS AND BREATHING  88 YOF  ON OXYGEN  LEGS ARE NUMB  RPS MOTHER HAS A SHARP PAIN IN BACK  E911 Info - Class of Service: RESD 
(Dispatch Information) Unit:221 Status:Dispatched Location: 240 FOREST RIDGE DR D Gen: Whitefish Call Type: Medical ALS Call Time: 12:20 Info:  HAS HX OF HEART PROBLEMS  BEEN GOING FOR 5 MINUTES  AND AFIB  61 YOF CHEST PAIN  E911 Info - Class of Service: RESD 
(Dispatch Information) Unit:221 Status:Enroute Location: 1600 HOSPITAL WAY Gen: NVHWhitefish Call Type: Inter Facility Transfer Call Time: 10:32 Info:  Nature Of Call: 11M1 
(Dispatch Information) Unit:221 Status:Dispatched Location: 4010 HIGHWAY 93 N Gen: SPENCERS STEAK HOUSEKalispell Call Type: Medical ALS Call Time: 19:45 Info:  CHEST PAINS  Nature Of Call: 7M3  86 YOF  IS BREATHING, DECREASED LOC  ELDERLY WOMAN FELL POSSIBLE CARDIAC ARREST  E911 Info - Class of Service: WRLS 
(Dispatch Information) Unit:223 Status:Dispatched Location: 1600 HOSPITAL WAY Gen: NVHWhitefish Call Type: Inter Facility Transfer Call Time: 18:16 Info:  ON O2  89 YOF  TRANSPORT TO PATHWAY 

Contact: Active911
Agency name: Lakeside QRU
Location: Lakeside, MT, United States
Sender: dispatch@communicationcenter.com

(Dispatch Information) Unit:2621 Status:Dispatched Location: Gen: MM 96 HIGHWAY 93 SLakeside Call Type: MVA ALS Call Time: 22:19 Info:  FCSO ADVD  Call #: 95 - 10-5 FROM LAKE COUNTY, TRUCK OR SUV SUBJS TRAPPED, ONE VEH UNKNOWN HOW BAD INJURYSIES  UNK INJURIES  RP NO LONGER ON SCENE HAD TO DRIVE FOR CELL SERVICE  SB  PICKUP TRUCK,S B  ONE VEH, ROLLOVER  E911 Info - Class of Service: WRLS 
(Dispatch Information) Unit:2621 Status:Dispatched Location: HIGHWAY 93 S Gen: Kalispell Call Type: Medical BLS RED Call Time: 17:33 Info:  Nature Of Call: 2R1  62 YOM  EPI PEN USED  CONC  BREATHING ALRIGHT  AT ABOVE CROSS STREETS  MAN STUNG BY A BEE// ALLERGIC  E911 Info - Class of Service: WRLS 
(Dispatch Information) Unit:2621 Status:Dispatched Location: 445 BUFFALO LN Gen: Somers Call Type: Medical ALS Call Time: 14:39 Info:  Nature Of Call: 24M5  NO BLEEDING  HAS SHOULDER AND BACK PAIN  STILL DOWN  CONC AND BREATHING  AT LEAST 10 FT  ONE OF THE MEN WORKING ON HIS ROOF FELL OFF  E911 Info - Class of Service: RESD 
(Dispatch Information) Unit:2621 Status:Dispatched Location: 1432 KLONDYKE LOOP Gen: Somers Call Type: Medical ALS Call Time: 13:04 Info:  Nature Of Call: 21M3  CONC AND BREATHING  27 YO  HUSBAND PINNED UNDER TRUCK  E911 Info - Class of Service: WRLS 
(Dispatch Information) Location: HIGHWAY 93 S Gen: Kalispell Call Type: MVA BLS RED Call Time: 19:35 Info:  Dispatch received by unit 621  Call #: 415 - NO NEW INFO  Dispatch received by unit 722  Call #: 415 - E911 Info - Class of Service: WRLS  Call #: 412 - PLOTS 435 FT FROM 4810 HIGHWAY 93 S  Call #: 412 - NO ANSWER  Call #: 412 - CALLING BACK  Call #: 412 - ABANDONED  Call #: 412 - E911 Info - Class of Service: WPH2  TRANSFERRING TO MHP  UNKNOWN INJURIES  RE
(Dispatch Information) Unit:LSQ Status:Dispatched Location: FOREST HILL RD Gen: Kalispell Call Type: Medical ALS Call Time: 19:52 Info:  1ST PREGNANCY  BREATHING OKAY  NOT BLEEDING  SHE IS NOT DUE UNTIL OCTOBER 2ND  RP CANNOT GET TO HOSPITAL DUE TO THE ACCIDENT  RP IS FACING THE WHITE OAK,, BEHIND A BIG RED DODGE  IS IN GREEN CHEVY S10  IN A LOT OF PAIN IN HER STOMACH WHERE THE BABY IS  NEED MEDICAL ASAP  AT THE ACCIDENT BUT NOT INVOLVED  WOMAN HAVING CONTRACTIONS  E911 Info - Class of Servi
(Dispatch Information) Unit:2621 Status:Dispatched Location: FOREST HILL RD Gen: Kalispell Call Type: MVA BLS RED Call Time: 19:35 Info:  TRANSFERRING TO MHP  UNKNOWN INJURIES  RED PU HIT THE SIDE OF FORD EXPLORERE WHICH HIT ANOTHER  3 CAR ACCIDENT  RP NOT INVOLVED  E911 Info - Class of Service: WPH2 
(Dispatch Information) Unit:2621 Status:Dispatched Location: Gen: SOMERS BOAT LAUNCHSOMERS Call Type: Medical ALS Call Time: 18:06 Info:  RP ADVISED THAT SHE CAN'T GET OUT OF HER CAR....  SHE HIT A GIRL CROSSING THE HIGHWAY  E911 Info - Class of Service: WRLS 
(Dispatch Information) Unit:2621 Status:Dispatched Location: 380 BOON RD Somers Call Type: Medical ALS Call Time: 21:08 Info:  MALE WILL NOT WAKE UP  MALE IS BREATHIGN  MAEL IS PASSED OUT  E911 Info - Class of Service: RESD 
(Dispatch Information) Unit:2621 Status:Dispatched Location: 675 CONRAD POINT RD Lakeside Call Type: Medical ALS Call Time: 19:33 Info:  88 YOM IS UNRESPONSIVE/ BREATHING BUT NOT CONSIOUS  E911 Info - Class of Service: RESD 

Contact: Active911
Agency name: South Kalispell Fire Department
Location: Kalispell, MT, United States
Sender: dispatch@communicationcenter.com

(Dispatch Information) Unit:2332 Status:Dispatched Location: 81 WOODLAND PARK DR Gen: WOODLAND QUICK STOPKalispell Call Type: MVA Non Injury Call Time: 12:12 Info:  99 BUICK PARK AVE WAS BACKED INTO BY A TRUCK WITH A TRAILER 
(Dispatch Information) Unit:2332 Status:Dispatched Location: 2910 HIGHWAY 93 S Gen: TOWN PUMP - 4 CORNERS, KALKalispell Call Type: Medical BLS RED Call Time: 03:52 Info:  RP BELIEVES SUBJECT WAS EITHER HBD OR ON SOME SORT OF DRUGS  RP IS INSIDE THE STORE, ANOTHER SUBJECT REPORTED THIS TO RP  MALE THAT WAS IN THE STORE EARLIER IS NOW PASSED OUT BEHIND THE POWER BOXES ON THE EAST SIDE OF THE BUILDING BY THE BILLBOARD FACING HIGHWAY 93 
(Dispatch Information) Unit:SKFD Status:Dispatched Location: WILLOW GLEN DR Gen: Kalispell Call Type: MVA BLS RED Call Time: 00:27 Info:  Call #: 111 - CALLING LINE BACK,, WILL BE FOR M/C DOWN  Dispatch received by unit K19  Dispatch received by unit 745  Call #: 111 - E911 Info - Class of Service: WPH2 
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 494 WILLOW GLEN DR Kalispell Call Type: Medical BLS RED Call Time: 20:02 Info:  NO VERIFABLE INFO/  SHE IS CRYING  BELIVES ITS A LITTLE GIRL  UNKNOWN AGE/ RP'S WIFE IS GOING TO CHECK ON THE CHILD  BIKE PATH AND WILLOW GLEN/ CHILD HAS FALLEN OFF BICYCLE  E911 Info - Class of Service: RSDX 
(Dispatch Information) Location: 705 FOYS CANYON RD Kalispell Call Type: MVA BLS RED Call Time: 18:11 Info:  OS 934  2303 ADV 951 THIS IS SOUTH KALISPELL FIRES JURISDICITON//  2303 IS ON SCN  FEMALE ALSO COMPLAINING OF BACK PAIN  CSPINE BEING ADMINISTERED  RP DID NOT SEE THE VEHICLE ROLL OVER  MALE AND FEMALE/ MALE COMPLAINING OF BACK PAIN  BOTH ARE OUT OF THE VEHILCE  Dispatch received by unit 721  Dispatch received by unit 726  Dispatch received by unit 728  Nat
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 695 FOYS CANYON RD Kalispell Call Type: MVA BLS RED Call Time: 18:11 Info:  FEMALE ALSO COMPLAINING OF BACK PAIN  CSPINE BEING ADMINISTERED  RP DID NOT SEE THE VEHICLE ROLL OVER  MALE AND FEMALE/ MALE COMPLAINING OF BACK PAIN  BOTH ARE OUT OF THE VEHILCE  Dispatch received by unit 721  Dispatch received by unit 726  Dispatch received by unit 728  Nature Of Call: 25R2  1921 ack  RP IS A WITNESS  VEHICLE IS SILVER IN COLOR  BOTH PEOP
(Dispatch Information) Location: 595 PATRICK CREEK RD Kalispell Call Type: F Illegal Burn Call Time: 11:33 Info:  OUT W/PROPERTY OWNER // WILL COUNSEL ON CLOSED BURNING  2308 ACKN / ENROUTE  KIDC ACKN  CANNOT MISS THE FIRE WHEN APPROACHING  RP ADVISES NEIGHBOR IS BURNING GRASS IN THE DITCH ALONG THE ROADWAY... 
(Dispatch Information) Unit:2332 Status:Dispatched Location: MM 1 PATRICK CREEK RDKALISPELL Call Type: F Illegal Burn Call Time: 11:33 Info:  CANNOT MISS THE FIRE WHEN APPROACHING  RP ADVISES NEIGHBOR IS BURNING GRASS IN THE DITCH ALONG THE ROADWAY... 
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 1717 S WOODLAND DR 19 Kalispell Call Type: Medical BLS YEL Call Time: 21:41 Info:  Nature Of Call: 5Y3  NO TROUBLE BREATHING AT THIS POINT  WANTS SOMEONE TO COME CHECK IT FOR HER  DIDN'T KNOW WHO ELSE TO CALL  88 YOF  RP IS HAVING TROUBLE WITH HER OXYGEN METER  E911 Info - Class of Service: WRLS 
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 1925 PINE GROVE LN Kalispell Call Type: F Structure Fire Call Time: 17:47 Info:  FULL ON FIRE--HEARD EXPLOSOING  LOTS OF FLAMES  NO CARS IN PARKING LOT  UNKONWN IF ANYONE IN HOUSE  1925 PINE GROVE// NEAR ROSE CROOSING  HOUSE FIRE NEXT DOOR TO ABOVE ADDRESS  E911 Info - Class of Service: RESD 
(Dispatch Information) Unit:2332 Status:Dispatched Location: 1540 EAGLE DR Kalispell Call Type: F Smoke Investigation - Outside Call Time: 03:29 Info:  RP CANNOT SEE FLAMES  RP STATES UNKN HOW MUCH , CAN SMELL THE SMOKE  TOWARDS S WOODLAND  RP CAN SEE SMOKE TO THE WEST OF HIS HOME 
(Dispatch Information) Location: 95 RIDGEWOOD DR Lakeside Call Type: F Structure Fire Call Time: 22:57 Info:  Dispatch received by unit 631  Dispatch received by unit 601  HOUSE IFO THE ABOVE LOCATION HAS A FIRE FROM FIREWORKS  E911 Info - Class of Service: WPH2 
(Dispatch Information) Unit:2331 Status:Dispatched Location: 95 RIDGEWOOD DR Kalispell Call Type: F Structure Fire Call Time: 22:57 Info:  HOUSE IFO THE ABOVE LOCATION HAS A FIRE FROM FIREWORKS  E911 Info - Class of Service: WPH2 
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 2745 HIGHWAY 93 S Kalispell Call Type: Medical ALS Call Time: 10:51 Info:  Nature Of Call: 17M2  Call Number 282 was created from Call Number 276(Jul  4 2013 10:29AM)  REQ'ING MEDICAL // MALE DISORIENTED  I  Call #: 277 - IN KM MARINE PARKING LOT  Call #: 277 - NOW NEXT TO SS CAMPER ON FOOT NEIGHBOR IS IN A TRUCK  Call #: 277 - BLACK SHIRT AND JEANS NEIGHBOR IS CHASING HIM  Call #: 277 - REUNNING AWAY TORWard ss campers  Call #: 2
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 543 LENWOOD LN Kalispell Call Type: Medical BLS RED Call Time: 13:47 Info:  MAN LYING IN DRIVEWAY....FEMALE YELLING FOR HELP  E911 Info - Class of Service: RESD 
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 1717 S WOODLAND DR 19 Kalispell Call Type: Medical BLS RED Call Time: 18:24 Info:  BREATHING DIFFICULTY  BLU BUICK AND TURQ BUICK  BEIGE TRAILER  PORCH LIGHT IS ON  IS ON OXYGEN DUE TO SLEEP APNEA  IS ON OXYGEN  77 YO FEMALE  E911 Info - Class of Service: WPH2 
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 234 SHELTER VALLEY DR Kalispell Call Type: Medical BLS YEL Call Time: 04:14 Info:  LEFT SIDE PAIN  92 YOA FEMALE FELL FROM STANDING POSITION  E911 Info - Class of Service: BUSN 
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 50 TWIN ACRES DR 9 Kalispell Call Type: Medical ALS Call Time: 17:30 Info:  BREATHING BUT SLURRING SPEACH  Nature Of Call: 18M2  E911 Info - Class of Service: WRLS 
(Dispatch Information) Unit:2332 Status:Dispatched Location: 38 TRAILS END DR Kalispell Call Type: MVA Non Injury Call Time: 15:05 Info:  ADVISED MHP  GOLD POINTIAC BONNIVILLE BLK CHEVY SILVERADO 
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 508 CONRAD DR Kalispell Call Type: Medical ALS Call Time: 10:28 Info:  CHEST FEELS HEAVY  PAIN UP HER ARM AND INTO HER SHOULDERS  74 YOF // HAVING PAIN IN HER RIGHT ARM  E911 Info - Class of Service: RESD 
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 243 CAROLINE RD Kalispell Call Type: Medical BLS RED Call Time: 12:20 Info:  GO TO BACK DOOR  GENERALIZED WEAKNESS / HEADACHE  93 YOA FEMALE  E911 Info - Class of Service: RESD 
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 134 COLLIER LN Kalispell Call Type: Medical ALS Call Time: 22:06 Info:  MALE NOT BREATHING  E911 Info - Class of Service: RESD 
(Dispatch Information) Unit:2391 Status:Dispatched Location: 1715 W RESERVE DR Kalispell Call Type: F Structure Fire Call Time: 22:56 Info:  HOUSE ON FIRE  E911 Info - Class of Service: WRLS 
(Dispatch Information) Location: 516 CONRAD DR Kalispell Call Type: Medical BLS RED Call Time: 18:14 Info:  Nature Of Call: 14R3  Dispatch received by unit 621  SPACE B  PM  MALE SUBJ ATTEMPTING TO OD ON TYLONAL P,  Call Number 435 was created from Call Number 434(Jun  6 2013  6:12PM) 
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 516 CONRAD DR Kalispell Call Type: Medical BLS RED Call Time: 18:14 Info:  SPACE B  PM  MALE SUBJ ATTEMPTING TO OD ON TYLONAL P,  Call Number 435 was created from Call Number 434(Jun  6 2013  6:12PM) 
(Dispatch Information) Unit:2332 Status:Dispatched Location: Call Type: MVA BLS RED Call Time: 12:27 Info:  RED AND BLUE CARS  E911 Info - Class of Service: WPH2 
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 100 SHELTER VALLEY DR Kalispell Call Type: Medical BLS RED Call Time: 13:55 Info:  Nature Of Call: 4R1  RP STATING HIS HEAD IS BLEEDING  RP STATING HIS SISTER JUST THREW A GLASS AT RP'S HEAD 
(Dispatch Information) Unit:SKFD Status:Dispatched Location: 1249 WILLOW GLEN DR COUNTY SHOPKalispell Call Type: AA Call Time: 17:38 Info:  Call Number 63 was created from Call Number 62(May 26 2013  5:31PM)  738 REQ'S FIRE DEPT  Dispatch received by unit 738  B/C COUNTY SHOPS  HOLE IN THE TOP OF THE TANK  LARGE LEAK  SO MUCH LIQUID THAT ITS CREATING A POOL  RP ADV THIS IS NOT NORMAL....UNKN WHAT KIND OF LIQUID  RP JUST WALKED BY THE FLATHEAD COUNTY SHOP.....15 FT TANK IS GUSHING OUT WATER  E91

Contact: Active911
Agency name: Big Mountain Fire Department
Location: whitefish, MT, United States
Sender: dispatch@communicationcenter.com

(Dispatch Information) Unit:2021 Status:Dispatched Location: 3808 BIG MOUNTAIN RD Gen: Whitefish Call Type: Medical BLS RED Call Time: 10:37 Info:  Nature Of Call: 12R2  2 PATIENTS FEMALE 40 AND MALE 48 YOA  CALL TK ON CHANNEL 1  NECK AND BACK PAIN  BOTTOM OF ZIP LINE #4  E911 Info - Class of Service: WPH2 
(Dispatch Information) Unit:2021 Status:Dispatched Location: 3450 BIG MOUNTAIN RD Whitefish Call Type: F Automatic Fire Alarm Call Time: 13:25 Info:  FIRE ALARM // HAYES RESIDENCE // AT THE GUEST HOUSE 

Contact: Active911
Agency name: Evergreen Fire Rescue
Location: Kalispell, MT, United States
Sender: dispatch@communicationcenter.com

(Dispatch Information) Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: Inter Facility Transfer Call Time: 11:38 Info:  TO RADIATION 
(Dispatch Information) Unit:821 Status:Enroute Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: < New Call > Call Time: 11:38 Info:  TO RADIATION 
(Dispatch Information) Unit:821 Status:Dispatched Location: 1985 HIGHWAY 35 24 Gen: SPRUCE PARKKalispell Call Type: Medical BLS RED Call Time: 09:45 Info:  DIABETIC // NOT FEELING WEEL / WEAK 
(Dispatch Information) Location: 200 HERITAGE WAY Gen: PATHWAYSKalispell Call Type: Inter Facility Transfer Call Time: 07:53 Info:  TO WARM SPRING 
(Dispatch Information) Unit:824 Status:Enroute Location: 200 HERITAGE WAY Gen: PATHWAYSKalispell Call Type: < New Call > Call Time: 07:53 Info:  TO WARM SPRING 
(Dispatch Information) Unit:841 Status:Dispatched Location: W RESERVE DR Gen: Kalispell Call Type: MVA BLS RED Call Time: 06:47 Info:  REAR END ACCIDENT // NECK INJURY  E911 Info - Class of Service: WPH2 
(Dispatch Information) Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: Inter Facility Transfer Call Time: 06:11 Info: 
(Dispatch Information) Unit:824 Status:Enroute Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: < New Call > Call Time: 06:11 Info: 
(Dispatch Information) Unit:824 Status:Enroute Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: Inter Facility Transfer Call Time: 00:51 Info: 
(Dispatch Information) Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: Inter Facility Transfer Call Time: 11:51 Info: 

*/

public class MTFlatheadCountyParserTest extends BaseParserTest {
  
  public MTFlatheadCountyParserTest() {
    setParser(new MTFlatheadCountyParser(), "FLATHEAD COUNTY", "MT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: 417 1ST AVE N Martin City Call\n(Con't) 2 of 3\nType: Medical ALS Call Time: 06:29 Info:  ton of cars in front drive, thengo to back yard  had chest pains prior to this  CO UNITS ADV \n(Con't) 3 of 3\ncpr in progress  50 ACK  55 ACK  turning blue  unk what happened, goingto him now  \n(End)",
        "UNIT:MCFD",
        "ADDR:417 1ST AVE N",
        "CITY:Martin City",
        "CALL:Medical ALS",
        "TIME:06:29",
        "INFO:ton of cars in front drive, thengo to back yard  had chest pains prior to this  CO UNITS ADV  cpr in progress  50 ACK  55 ACK  turning blue  unk what happened, goingto him now");

    doTest("T2",
        "1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: Hungry Horse Reservoir Call\n(Con't) 2 of 3\nType: Medical ALS Call Time: 21:13 Info:  RUN CARD SHOWED NO FIRE UNITS TODISPATCH, DISPATCHED HHFD AND MCFD FROM MEMORY  1602 AND 1501\n(Con't) 3 of 3\nACK  RP CALLED BACK....FATHER IS FEELING WEAK AND SLEEPY  ADV TO CALL BACKWHEN GETS\n(End)",
        "UNIT:MCFD",
        "ADDR:Hungry Horse Reservoir",
        "CALL:Medical ALS",
        "TIME:21:13",
        "INFO:RUN CARD SHOWED NO FIRE UNITS TODISPATCH, DISPATCHED HHFD AND MCFD FROM MEMORY  1602 AND 1501 ACK  RP CALLED BACK....FATHER IS FEELING WEAK AND SLEEPY  ADV TO CALL BACKWHEN GETS");

    doTest("T3",
        "1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: HIGHWAY 2 E Hungry Horse Call\n(Con't) 2 of 3\nType: F Smoke Investigation - Outside Call Time: 20:00 Info:  RP LIVES AT844 WOODLAND AVE  CAN SEE WHAT APPEARS TO BE A SMOKE CLOUD\n(Con't) 3 of 3\nCOMING FORM THE AREA OF HUNGRY HORSE. \n(End)",
        "UNIT:MCFD",
        "ADDR:HIGHWAY 2 E",
        "CITY:Hungry Horse",
        "CALL:F Smoke Investigation - Outside",
        "TIME:20:00",
        "INFO:RP LIVES AT844 WOODLAND AVE  CAN SEE WHAT APPEARS TO BE A SMOKE CLOUD COMING FORM THE AREA OF HUNGRY HORSE.");

    doTest("T4",
        "1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: Call Type: MVA Injury Call Time:\n(Con't) 2 of 3\n17:03 Info:  RP STATED THEY DID NOT NEED ALERT  KIDC SAYS TREMS CAN MAKEIT UP THERE...LOWER LEFT LEG PAIN, NO LOC & SOME HEAD ABRASIONS \n(Con't) 3 of 3\n4 MILES UP RD #497//TOWARD DESERT MTN RD  LEG AND BACK\n(End)",
        "UNIT:MCFD",
        "CALL:MVA Injury",
        "TIME:17:03",
        "INFO:RP STATED THEY DID NOT NEED ALERT  KIDC SAYS TREMS CAN MAKEIT UP THERE...LOWER LEFT LEG PAIN, NO LOC & SOME HEAD ABRASIONS  4 MILES UP RD #497//TOWARD DESERT MTN RD  LEG AND BACK");

  }
  
  @Test
  public void testWhitefishFire() {

    doTest("T1",
        "(Dispatch Information) Unit:221 Status:Dispatched Location: 1005 BAKER AVE Gen: WHITEFISH CREDIT UNION - SECOND BRANCH WFWhitefish Call Type: Medical BLS RED Call Time: 10:45 Info:  IS CONC AND BREATHING  50 YOM  SEIZURE  E911 Info - Class of Service: WPH2 ",
        "UNIT:221",
        "ADDR:1005 BAKER AVE",
        "CITY:Whitefish",
        "PLACE:WHITEFISH CREDIT UNION - SECOND BRANCH WF",
        "CALL:Medical BLS RED",
        "TIME:10:45",
        "INFO:IS CONC AND BREATHING  50 YOM  SEIZURE  E911 Info - Class of Service: WPH2");

    doTest("T2",
        "(Dispatch Information) Unit:221 Status:Dispatched Location: 1060 E EDGEWOOD DR Gen: Whitefish Call Type: Medical BLS YEL Call Time: 20:14 Info:  NUMB FOR 5-10 MIN  ALERT, CONSCIOUS AND BREATHING  NOW LEG IS NUMB AND WON'T SUPPORT WEIGHT  24YOM HAD A TORN HAMSTRING A WEEK AGO  E911 Info - Class of Service: WRLS ",
        "UNIT:221",
        "ADDR:1060 E EDGEWOOD DR",
        "CITY:Whitefish",
        "CALL:Medical BLS YEL",
        "TIME:20:14",
        "INFO:NUMB FOR 5-10 MIN  ALERT, CONSCIOUS AND BREATHING  NOW LEG IS NUMB AND WON'T SUPPORT WEIGHT  24YOM HAD A TORN HAMSTRING A WEEK AGO  E911 Info - Class of Service: WRLS");

    doTest("T3",
        "(Dispatch Information) Unit:221 Status:Dispatched Location: 1305 E 7TH ST Gen: WHITEFISH CARE AND REHABWhitefish Call Type: Medical ALS Call Time: 19:01 Info:  UNABLE TO SPEAK CLEARLY, CANNOT TRACK WITH HER EYES  SYMPTOMS JUST STARTED  FRONT ENTRANCE  AT NURSES STATION 1--COME ALL THE WAY TO THE BACK  Nature Of Call: 18M3  BREATHING ALRIGHT  DECREASED LOC  POSSIBLE STROKE  75 YOF 02 LEVELS LOW, LOW PULSE ",
        "UNIT:221",
        "ADDR:1305 E 7TH ST",
        "CITY:Whitefish",
        "PLACE:WHITEFISH CARE AND REHAB",
        "CALL:Medical ALS",
        "TIME:19:01",
        "INFO:UNABLE TO SPEAK CLEARLY, CANNOT TRACK WITH HER EYES  SYMPTOMS JUST STARTED  FRONT ENTRANCE  AT NURSES STATION 1--COME ALL THE WAY TO THE BACK  Nature Of Call: 18M3  BREATHING ALRIGHT  DECREASED LOC  POSSIBLE STROKE  75 YOF 02 LEVELS LOW, LOW PULSE");

    doTest("T4",
        "(Dispatch Information) Unit:221 Status:Dispatched Location: 1600 HOSPITAL WAY Gen: NVHWhitefish Call Type: Medical BLS YEL Call Time: 18:36 Info:  CONC AND BREATHING  Nature Of Call: 24Y2  JUST NEED ASSISTANCE MOVING HIM  ER IS AFRAID TO MOVE HIM  FALL PATIENT  NEED A PATIENT MOVED FROM A BUS TO THE ER ",
        "UNIT:221",
        "ADDR:1600 HOSPITAL WAY",
        "CITY:Whitefish",
        "CALL:Medical ALS",
        "PLACE:NVH",
        "CALL:Medical BLS YEL",
        "TIME:18:36",
        "INFO:CONC AND BREATHING  Nature Of Call: 24Y2  JUST NEED ASSISTANCE MOVING HIM  ER IS AFRAID TO MOVE HIM  FALL PATIENT  NEED A PATIENT MOVED FROM A BUS TO THE ER");

    doTest("T5",
        "(Dispatch Information) Unit:221 Status:Dispatched Location: 930 ASHAR AVE Gen: Whitefish Call Type: Medical ALS Call Time: 18:14 Info:  not breathing  58 yom cold to the touch  E911 Info - Class of Service: WRLS ",
        "UNIT:221",
        "ADDR:930 ASHAR AVE",
        "CITY:Whitefish",
        "CALL:Medical ALS",
        "TIME:18:14",
        "INFO:not breathing  58 yom cold to the touch  E911 Info - Class of Service: WRLS");

    doTest("T6",
        "(Dispatch Information) Unit:221 Status:Dispatched Location: 1345 E 7TH ST Gen: WHITEFISH MANORWhitefish Call Type: Medical BLS YEL Call Time: 16:57 Info:  NO HX OR ROOM #  KEYHOLDER PENDING  MEDICAL ALARM ",
        "UNIT:221",
        "ADDR:1345 E 7TH ST",
        "CITY:Whitefish",
        "PLACE:WHITEFISH MANOR",
        "CALL:Medical BLS YEL",
        "TIME:16:57",
        "INFO:NO HX OR ROOM #  KEYHOLDER PENDING  MEDICAL ALARM");

    doTest("T7",
        "(Dispatch Information) Unit:223 Status:Dispatched Location: Gen: MM 141 HIGHWAY 93 NOLNEY Call Type: MVA BLS RED Call Time: 12:41 Info:  4DOOR SEDAN REAREND BY 3/4 TON TRUCK  Nature Of Call: 25R3  REQ AND AMBULANDCE AND MHP  MT DOT  E911 Info - Class of Service: RESD ",
        "UNIT:223",
        "ADDR:MM 141 HIGHWAY 93 N",
        "CITY:OLNEY",
        "CALL:MVA BLS RED",
        "TIME:12:41",
        "INFO:4DOOR SEDAN REAREND BY 3/4 TON TRUCK  Nature Of Call: 25R3  REQ AND AMBULANDCE AND MHP  MT DOT  E911 Info - Class of Service: RESD");

    doTest("T8",
        "(Dispatch Information) Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: Inter Facility Transfer Call Time: 12:29 Info: ",
        "ADDR:310 SUNNY VIEW LN",
        "CITY:Kalispell",
        "PLACE:KRMC",
        "CALL:Inter Facility Transfer",
        "TIME:12:29");

    doTest("T9",
        "(Dispatch Information) Unit:221 Status:Dispatched Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: < New Call > Call Time: 12:29 Info: ",
        "UNIT:221",
        "ADDR:310 SUNNY VIEW LN",
        "CITY:Kalispell",
        "PLACE:KRMC",
        "CALL:< New Call >",
        "TIME:12:29");

    doTest("T10",
        "(Dispatch Information) Unit:221 Status:Dispatched Location: 1600 HOSPITAL WAY Gen: NVHWhitefish Call Type: Inter Facility Transfer Call Time: 08:31 Info:  BLS LEVEL IS FINE  NEED PATIENT PICKED UP AT MED/SURG AT 10:30 TO GO TO KRMC FOR A PROCEDURE ",
        "UNIT:221",
        "ADDR:1600 HOSPITAL WAY",
        "CITY:Whitefish",
        "PLACE:NVH",
        "CALL:Inter Facility Transfer",
        "TIME:08:31",
        "INFO:BLS LEVEL IS FINE  NEED PATIENT PICKED UP AT MED/SURG AT 10:30 TO GO TO KRMC FOR A PROCEDURE");

    doTest("T11",
        "(Dispatch Information) Unit:221 Status:Dispatched Location: 807 GREENWOOD DR Gen: Whitefish Call Type: Medical BLS YEL Call Time: 09:05 Info:  Nature Of Call: 1Y2  UNABLE TO STAND  CONS AND BREATHING  88 YOF  ON OXYGEN  LEGS ARE NUMB  RPS MOTHER HAS A SHARP PAIN IN BACK  E911 Info - Class of Service: RESD ",
        "UNIT:221",
        "ADDR:807 GREENWOOD DR",
        "CITY:Whitefish",
        "CALL:Medical BLS YEL",
        "TIME:09:05",
        "INFO:Nature Of Call: 1Y2  UNABLE TO STAND  CONS AND BREATHING  88 YOF  ON OXYGEN  LEGS ARE NUMB  RPS MOTHER HAS A SHARP PAIN IN BACK  E911 Info - Class of Service: RESD");

    doTest("T12",
        "(Dispatch Information) Unit:221 Status:Dispatched Location: 240 FOREST RIDGE DR D Gen: Whitefish Call Type: Medical ALS Call Time: 12:20 Info:  HAS HX OF HEART PROBLEMS  BEEN GOING FOR 5 MINUTES  AND AFIB  61 YOF CHEST PAIN  E911 Info - Class of Service: RESD ",
        "UNIT:221",
        "ADDR:240 FOREST RIDGE DR",
        "CITY:Whitefish",
        "CALL:Medical ALS",
        "TIME:12:20",
        "INFO:HAS HX OF HEART PROBLEMS  BEEN GOING FOR 5 MINUTES  AND AFIB  61 YOF CHEST PAIN  E911 Info - Class of Service: RESD");

    doTest("T13",
        "(Dispatch Information) Unit:221 Status:Enroute Location: 1600 HOSPITAL WAY Gen: NVHWhitefish Call Type: Inter Facility Transfer Call Time: 10:32 Info:  Nature Of Call: 11M1 ",
        "UNIT:221",
        "ADDR:1600 HOSPITAL WAY",
        "CITY:Whitefish",
        "PLACE:NVH",
        "CALL:Inter Facility Transfer",
        "TIME:10:32",
        "INFO:Nature Of Call: 11M1");

    doTest("T14",
        "(Dispatch Information) Unit:221 Status:Dispatched Location: 4010 HIGHWAY 93 N Gen: SPENCERS STEAK HOUSEKalispell Call Type: Medical ALS Call Time: 19:45 Info:  CHEST PAINS  Nature Of Call: 7M3  86 YOF  IS BREATHING, DECREASED LOC  ELDERLY WOMAN FELL POSSIBLE CARDIAC ARREST  E911 Info - Class of Service: WRLS ",
        "UNIT:221",
        "ADDR:4010 HIGHWAY 93 N",
        "CITY:Kalispell",
        "PLACE:SPENCERS STEAK HOUSE",
        "CALL:Medical ALS",
        "TIME:19:45",
        "INFO:CHEST PAINS  Nature Of Call: 7M3  86 YOF  IS BREATHING, DECREASED LOC  ELDERLY WOMAN FELL POSSIBLE CARDIAC ARREST  E911 Info - Class of Service: WRLS");

    doTest("T15",
        "(Dispatch Information) Unit:223 Status:Dispatched Location: 1600 HOSPITAL WAY Gen: NVHWhitefish Call Type: Inter Facility Transfer Call Time: 18:16 Info:  ON O2  89 YOF  TRANSPORT TO PATHWAY ",
        "UNIT:223",
        "ADDR:1600 HOSPITAL WAY",
        "CITY:Whitefish",
        "PLACE:NVH",
        "CALL:Inter Facility Transfer",
        "TIME:18:16",
        "INFO:ON O2  89 YOF  TRANSPORT TO PATHWAY");
 
  }
  
  @Test
  public void testLakesideQRU() {

    doTest("T1",
        "(Dispatch Information) Unit:2621 Status:Dispatched Location: Gen: MM 96 HIGHWAY 93 SLakeside Call Type: MVA ALS Call Time: 22:19 Info:  FCSO ADVD  Call #: 95 - 10-5 FROM LAKE COUNTY, TRUCK OR SUV SUBJS TRAPPED, ONE VEH UNKNOWN HOW BAD INJURYSIES  UNK INJURIES  RP NO LONGER ON SCENE HAD TO DRIVE FOR CELL SERVICE  SB  PICKUP TRUCK,S B  ONE VEH, ROLLOVER  E911 Info - Class of Service: WRLS ",
        "UNIT:2621",
        "CITY:Lakeside",
        "ADDR:MM 96 HIGHWAY 93 S",
        "CALL:MVA ALS",
        "TIME:22:19",
        "INFO:FCSO ADVD  Call #: 95 - 10-5 FROM LAKE COUNTY, TRUCK OR SUV SUBJS TRAPPED, ONE VEH UNKNOWN HOW BAD INJURYSIES  UNK INJURIES  RP NO LONGER ON SCENE HAD TO DRIVE FOR CELL SERVICE  SB  PICKUP TRUCK,S B  ONE VEH, ROLLOVER  E911 Info - Class of Service: WRLS");

    doTest("T2",
        "(Dispatch Information) Unit:2621 Status:Dispatched Location: HIGHWAY 93 S Gen: Kalispell Call Type: Medical BLS RED Call Time: 17:33 Info:  Nature Of Call: 2R1  62 YOM  EPI PEN USED  CONC  BREATHING ALRIGHT  AT ABOVE CROSS STREETS  MAN STUNG BY A BEE// ALLERGIC  E911 Info - Class of Service: WRLS ",
        "UNIT:2621",
        "ADDR:HIGHWAY 93 S",
        "CITY:Kalispell",
        "CALL:Medical BLS RED",
        "TIME:17:33",
        "INFO:Nature Of Call: 2R1  62 YOM  EPI PEN USED  CONC  BREATHING ALRIGHT  AT ABOVE CROSS STREETS  MAN STUNG BY A BEE// ALLERGIC  E911 Info - Class of Service: WRLS");

    doTest("T3",
        "(Dispatch Information) Unit:2621 Status:Dispatched Location: 445 BUFFALO LN Gen: Somers Call Type: Medical ALS Call Time: 14:39 Info:  Nature Of Call: 24M5  NO BLEEDING  HAS SHOULDER AND BACK PAIN  STILL DOWN  CONC AND BREATHING  AT LEAST 10 FT  ONE OF THE MEN WORKING ON HIS ROOF FELL OFF  E911 Info - Class of Service: RESD ",
        "UNIT:2621",
        "ADDR:445 BUFFALO LN",
        "CITY:Somers",
        "CALL:Medical ALS",
        "TIME:14:39",
        "INFO:Nature Of Call: 24M5  NO BLEEDING  HAS SHOULDER AND BACK PAIN  STILL DOWN  CONC AND BREATHING  AT LEAST 10 FT  ONE OF THE MEN WORKING ON HIS ROOF FELL OFF  E911 Info - Class of Service: RESD");

    doTest("T4",
        "(Dispatch Information) Unit:2621 Status:Dispatched Location: 1432 KLONDYKE LOOP Gen: Somers Call Type: Medical ALS Call Time: 13:04 Info:  Nature Of Call: 21M3  CONC AND BREATHING  27 YO  HUSBAND PINNED UNDER TRUCK  E911 Info - Class of Service: WRLS ",
        "UNIT:2621",
        "ADDR:1432 KLONDYKE LOOP",   // Not mapping
        "CITY:Somers",
        "CALL:Medical ALS",
        "TIME:13:04",
        "INFO:Nature Of Call: 21M3  CONC AND BREATHING  27 YO  HUSBAND PINNED UNDER TRUCK  E911 Info - Class of Service: WRLS");

    doTest("T5",
        "(Dispatch Information) Location: HIGHWAY 93 S Gen: Kalispell Call Type: MVA BLS RED Call Time: 19:35 Info:  Dispatch received by unit 621  Call #: 415 - NO NEW INFO  Dispatch received by unit 722  Call #: 415 - E911 Info - Class of Service: WRLS  Call #: 412 - PLOTS 435 FT FROM 4810 HIGHWAY 93 S  Call #: 412 - NO ANSWER  Call #: 412 - CALLING BACK  Call #: 412 - ABANDONED  Call #: 412 - E911 Info - Class of Service: WPH2  TRANSFERRING TO MHP  UNKNOWN INJURIES  RE",
        "ADDR:HIGHWAY 93 S",
        "CITY:Kalispell",
        "CALL:MVA BLS RED",
        "TIME:19:35",
        "INFO:Dispatch received by unit 621  Call #: 415 - NO NEW INFO  Dispatch received by unit 722  Call #: 415 - E911 Info - Class of Service: WRLS  Call #: 412 - PLOTS 435 FT FROM 4810 HIGHWAY 93 S  Call #: 412 - NO ANSWER  Call #: 412 - CALLING BACK  Call #: 412 - ABANDONED  Call #: 412 - E911 Info - Class of Service: WPH2  TRANSFERRING TO MHP  UNKNOWN INJURIES  RE");

    doTest("T6",
        "(Dispatch Information) Unit:LSQ Status:Dispatched Location: FOREST HILL RD Gen: Kalispell Call Type: Medical ALS Call Time: 19:52 Info:  1ST PREGNANCY  BREATHING OKAY  NOT BLEEDING  SHE IS NOT DUE UNTIL OCTOBER 2ND  RP CANNOT GET TO HOSPITAL DUE TO THE ACCIDENT  RP IS FACING THE WHITE OAK,, BEHIND A BIG RED DODGE  IS IN GREEN CHEVY S10  IN A LOT OF PAIN IN HER STOMACH WHERE THE BABY IS  NEED MEDICAL ASAP  AT THE ACCIDENT BUT NOT INVOLVED  WOMAN HAVING CONTRACTIONS  E911 Info - Class of Servi",
        "UNIT:LSQ",
        "ADDR:FOREST HILL RD",
        "CITY:Kalispell",
        "CALL:Medical ALS",
        "TIME:19:52",
        "INFO:1ST PREGNANCY  BREATHING OKAY  NOT BLEEDING  SHE IS NOT DUE UNTIL OCTOBER 2ND  RP CANNOT GET TO HOSPITAL DUE TO THE ACCIDENT  RP IS FACING THE WHITE OAK,, BEHIND A BIG RED DODGE  IS IN GREEN CHEVY S10  IN A LOT OF PAIN IN HER STOMACH WHERE THE BABY IS  NEED MEDICAL ASAP  AT THE ACCIDENT BUT NOT INVOLVED  WOMAN HAVING CONTRACTIONS  E911 Info - Class of Servi");

    doTest("T7",
        "(Dispatch Information) Unit:2621 Status:Dispatched Location: FOREST HILL RD Gen: Kalispell Call Type: MVA BLS RED Call Time: 19:35 Info:  TRANSFERRING TO MHP  UNKNOWN INJURIES  RED PU HIT THE SIDE OF FORD EXPLORERE WHICH HIT ANOTHER  3 CAR ACCIDENT  RP NOT INVOLVED  E911 Info - Class of Service: WPH2 ",
        "UNIT:2621",
        "ADDR:FOREST HILL RD",
        "CITY:Kalispell",
        "CALL:MVA BLS RED",
        "TIME:19:35",
        "INFO:TRANSFERRING TO MHP  UNKNOWN INJURIES  RED PU HIT THE SIDE OF FORD EXPLORERE WHICH HIT ANOTHER  3 CAR ACCIDENT  RP NOT INVOLVED  E911 Info - Class of Service: WPH2");

    doTest("T8",
        "(Dispatch Information) Unit:2621 Status:Dispatched Location: Gen: SOMERS BOAT LAUNCHSOMERS Call Type: Medical ALS Call Time: 18:06 Info:  RP ADVISED THAT SHE CAN'T GET OUT OF HER CAR....  SHE HIT A GIRL CROSSING THE HIGHWAY  E911 Info - Class of Service: WRLS ",
        "UNIT:2621",
        "CITY:SOMERS",
        "ADDR:SOMERS BOAT LAUNCH",
        "CALL:Medical ALS",
        "TIME:18:06",
        "INFO:RP ADVISED THAT SHE CAN'T GET OUT OF HER CAR....  SHE HIT A GIRL CROSSING THE HIGHWAY  E911 Info - Class of Service: WRLS");

    doTest("T9",
        "(Dispatch Information) Unit:2621 Status:Dispatched Location: 380 BOON RD Somers Call Type: Medical ALS Call Time: 21:08 Info:  MALE WILL NOT WAKE UP  MALE IS BREATHIGN  MAEL IS PASSED OUT  E911 Info - Class of Service: RESD ",
        "UNIT:2621",
        "ADDR:380 BOON RD",
        "CITY:Somers",
        "CALL:Medical ALS",
        "TIME:21:08",
        "INFO:MALE WILL NOT WAKE UP  MALE IS BREATHIGN  MAEL IS PASSED OUT  E911 Info - Class of Service: RESD");

    doTest("T10",
        "(Dispatch Information) Unit:2621 Status:Dispatched Location: 675 CONRAD POINT RD Lakeside Call Type: Medical ALS Call Time: 19:33 Info:  88 YOM IS UNRESPONSIVE/ BREATHING BUT NOT CONSIOUS  E911 Info - Class of Service: RESD ",
        "UNIT:2621",
        "ADDR:675 CONRAD POINT RD",
        "CITY:Lakeside",
        "CALL:Medical ALS",
        "TIME:19:33",
        "INFO:88 YOM IS UNRESPONSIVE/ BREATHING BUT NOT CONSIOUS  E911 Info - Class of Service: RESD");

  }
  
  @Test
  public void testSouthKalispellFireDepartment() {

    doTest("T1",
        "(Dispatch Information) Unit:2332 Status:Dispatched Location: 81 WOODLAND PARK DR Gen: WOODLAND QUICK STOPKalispell Call Type: MVA Non Injury Call Time: 12:12 Info:  99 BUICK PARK AVE WAS BACKED INTO BY A TRUCK WITH A TRAILER ",
        "UNIT:2332",
        "ADDR:81 WOODLAND PARK DR",
        "PLACE:WOODLAND QUICK STOP",
        "CITY:Kalispell",
        "CALL:MVA Non Injury",
        "TIME:12:12",
        "INFO:99 BUICK PARK AVE WAS BACKED INTO BY A TRUCK WITH A TRAILER");

    doTest("T2",
        "(Dispatch Information) Unit:2332 Status:Dispatched Location: 2910 HIGHWAY 93 S Gen: TOWN PUMP - 4 CORNERS, KALKalispell Call Type: Medical BLS RED Call Time: 03:52 Info:  RP BELIEVES SUBJECT WAS EITHER HBD OR ON SOME SORT OF DRUGS  RP IS INSIDE THE STORE, ANOTHER SUBJECT REPORTED THIS TO RP  MALE THAT WAS IN THE STORE EARLIER IS NOW PASSED OUT BEHIND THE POWER BOXES ON THE EAST SIDE OF THE BUILDING BY THE BILLBOARD FACING HIGHWAY 93 ",
        "UNIT:2332",
        "ADDR:2910 HIGHWAY 93 S",
        "PLACE:TOWN PUMP - 4 CORNERS, KAL",
        "CITY:Kalispell",
        "CALL:Medical BLS RED",
        "TIME:03:52",
        "INFO:RP BELIEVES SUBJECT WAS EITHER HBD OR ON SOME SORT OF DRUGS  RP IS INSIDE THE STORE, ANOTHER SUBJECT REPORTED THIS TO RP  MALE THAT WAS IN THE STORE EARLIER IS NOW PASSED OUT BEHIND THE POWER BOXES ON THE EAST SIDE OF THE BUILDING BY THE BILLBOARD FACING HIGHWAY 93");

    doTest("T3",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: WILLOW GLEN DR Gen: Kalispell Call Type: MVA BLS RED Call Time: 00:27 Info:  Call #: 111 - CALLING LINE BACK,, WILL BE FOR M/C DOWN  Dispatch received by unit K19  Dispatch received by unit 745  Call #: 111 - E911 Info - Class of Service: WPH2 ",
        "UNIT:SKFD",
        "ADDR:WILLOW GLEN DR",
        "CITY:Kalispell",
        "CALL:MVA BLS RED",
        "TIME:00:27",
        "INFO:Call #: 111 - CALLING LINE BACK,, WILL BE FOR M/C DOWN  Dispatch received by unit K19  Dispatch received by unit 745  Call #: 111 - E911 Info - Class of Service: WPH2");

    doTest("T4",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 494 WILLOW GLEN DR Kalispell Call Type: Medical BLS RED Call Time: 20:02 Info:  NO VERIFABLE INFO/  SHE IS CRYING  BELIVES ITS A LITTLE GIRL  UNKNOWN AGE/ RP'S WIFE IS GOING TO CHECK ON THE CHILD  BIKE PATH AND WILLOW GLEN/ CHILD HAS FALLEN OFF BICYCLE  E911 Info - Class of Service: RSDX ",
        "UNIT:SKFD",
        "ADDR:494 WILLOW GLEN DR",
        "CITY:Kalispell",
        "CALL:Medical BLS RED",
        "TIME:20:02",
        "INFO:NO VERIFABLE INFO/  SHE IS CRYING  BELIVES ITS A LITTLE GIRL  UNKNOWN AGE/ RP'S WIFE IS GOING TO CHECK ON THE CHILD  BIKE PATH AND WILLOW GLEN/ CHILD HAS FALLEN OFF BICYCLE  E911 Info - Class of Service: RSDX");

    doTest("T5",
        "(Dispatch Information) Location: 705 FOYS CANYON RD Kalispell Call Type: MVA BLS RED Call Time: 18:11 Info:  OS 934  2303 ADV 951 THIS IS SOUTH KALISPELL FIRES JURISDICITON//  2303 IS ON SCN  FEMALE ALSO COMPLAINING OF BACK PAIN  CSPINE BEING ADMINISTERED  RP DID NOT SEE THE VEHICLE ROLL OVER  MALE AND FEMALE/ MALE COMPLAINING OF BACK PAIN  BOTH ARE OUT OF THE VEHILCE  Dispatch received by unit 721  Dispatch received by unit 726  Dispatch received by unit 728  Nat",
        "ADDR:705 FOYS CANYON RD",
        "CITY:Kalispell",
        "CALL:MVA BLS RED",
        "TIME:18:11",
        "INFO:OS 934  2303 ADV 951 THIS IS SOUTH KALISPELL FIRES JURISDICITON//  2303 IS ON SCN  FEMALE ALSO COMPLAINING OF BACK PAIN  CSPINE BEING ADMINISTERED  RP DID NOT SEE THE VEHICLE ROLL OVER  MALE AND FEMALE/ MALE COMPLAINING OF BACK PAIN  BOTH ARE OUT OF THE VEHILCE  Dispatch received by unit 721  Dispatch received by unit 726  Dispatch received by unit 728  Nat");

    doTest("T6",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 695 FOYS CANYON RD Kalispell Call Type: MVA BLS RED Call Time: 18:11 Info:  FEMALE ALSO COMPLAINING OF BACK PAIN  CSPINE BEING ADMINISTERED  RP DID NOT SEE THE VEHICLE ROLL OVER  MALE AND FEMALE/ MALE COMPLAINING OF BACK PAIN  BOTH ARE OUT OF THE VEHILCE  Dispatch received by unit 721  Dispatch received by unit 726  Dispatch received by unit 728  Nature Of Call: 25R2  1921 ack  RP IS A WITNESS  VEHICLE IS SILVER IN COLOR  BOTH PEOP",
        "UNIT:SKFD",
        "ADDR:695 FOYS CANYON RD",
        "CITY:Kalispell",
        "CALL:MVA BLS RED",
        "TIME:18:11",
        "INFO:FEMALE ALSO COMPLAINING OF BACK PAIN  CSPINE BEING ADMINISTERED  RP DID NOT SEE THE VEHICLE ROLL OVER  MALE AND FEMALE/ MALE COMPLAINING OF BACK PAIN  BOTH ARE OUT OF THE VEHILCE  Dispatch received by unit 721  Dispatch received by unit 726  Dispatch received by unit 728  Nature Of Call: 25R2  1921 ack  RP IS A WITNESS  VEHICLE IS SILVER IN COLOR  BOTH PEOP");

    doTest("T7",
        "(Dispatch Information) Location: 595 PATRICK CREEK RD Kalispell Call Type: F Illegal Burn Call Time: 11:33 Info:  OUT W/PROPERTY OWNER // WILL COUNSEL ON CLOSED BURNING  2308 ACKN / ENROUTE  KIDC ACKN  CANNOT MISS THE FIRE WHEN APPROACHING  RP ADVISES NEIGHBOR IS BURNING GRASS IN THE DITCH ALONG THE ROADWAY... ",
        "ADDR:595 PATRICK CREEK RD",
        "CITY:Kalispell",
        "CALL:F Illegal Burn",
        "TIME:11:33",
        "INFO:OUT W/PROPERTY OWNER // WILL COUNSEL ON CLOSED BURNING  2308 ACKN / ENROUTE  KIDC ACKN  CANNOT MISS THE FIRE WHEN APPROACHING  RP ADVISES NEIGHBOR IS BURNING GRASS IN THE DITCH ALONG THE ROADWAY...");

    doTest("T8",
        "(Dispatch Information) Unit:2332 Status:Dispatched Location: MM 1 PATRICK CREEK RDKALISPELL Call Type: F Illegal Burn Call Time: 11:33 Info:  CANNOT MISS THE FIRE WHEN APPROACHING  RP ADVISES NEIGHBOR IS BURNING GRASS IN THE DITCH ALONG THE ROADWAY... ",
        "UNIT:2332",
        "ADDR:MM 1 PATRICK CREEK RD",
        "CITY:KALISPELL",
        "CALL:F Illegal Burn",
        "TIME:11:33",
        "INFO:CANNOT MISS THE FIRE WHEN APPROACHING  RP ADVISES NEIGHBOR IS BURNING GRASS IN THE DITCH ALONG THE ROADWAY...");

    doTest("T9",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 1717 S WOODLAND DR 19 Kalispell Call Type: Medical BLS YEL Call Time: 21:41 Info:  Nature Of Call: 5Y3  NO TROUBLE BREATHING AT THIS POINT  WANTS SOMEONE TO COME CHECK IT FOR HER  DIDN'T KNOW WHO ELSE TO CALL  88 YOF  RP IS HAVING TROUBLE WITH HER OXYGEN METER  E911 Info - Class of Service: WRLS ",
        "UNIT:SKFD",
        "ADDR:1717 S WOODLAND DR",
        "APT:19",
        "CITY:Kalispell",
        "CALL:Medical BLS YEL",
        "TIME:21:41",
        "INFO:Nature Of Call: 5Y3  NO TROUBLE BREATHING AT THIS POINT  WANTS SOMEONE TO COME CHECK IT FOR HER  DIDN'T KNOW WHO ELSE TO CALL  88 YOF  RP IS HAVING TROUBLE WITH HER OXYGEN METER  E911 Info - Class of Service: WRLS");

    doTest("T10",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 1925 PINE GROVE LN Kalispell Call Type: F Structure Fire Call Time: 17:47 Info:  FULL ON FIRE--HEARD EXPLOSOING  LOTS OF FLAMES  NO CARS IN PARKING LOT  UNKONWN IF ANYONE IN HOUSE  1925 PINE GROVE// NEAR ROSE CROOSING  HOUSE FIRE NEXT DOOR TO ABOVE ADDRESS  E911 Info - Class of Service: RESD ",
        "UNIT:SKFD",
        "ADDR:1925 PINE GROVE LN",
        "CITY:Kalispell",
        "CALL:F Structure Fire",
        "TIME:17:47",
        "INFO:FULL ON FIRE--HEARD EXPLOSOING  LOTS OF FLAMES  NO CARS IN PARKING LOT  UNKONWN IF ANYONE IN HOUSE  1925 PINE GROVE// NEAR ROSE CROOSING  HOUSE FIRE NEXT DOOR TO ABOVE ADDRESS  E911 Info - Class of Service: RESD");

    doTest("T11",
        "(Dispatch Information) Unit:2332 Status:Dispatched Location: 1540 EAGLE DR Kalispell Call Type: F Smoke Investigation - Outside Call Time: 03:29 Info:  RP CANNOT SEE FLAMES  RP STATES UNKN HOW MUCH , CAN SMELL THE SMOKE  TOWARDS S WOODLAND  RP CAN SEE SMOKE TO THE WEST OF HIS HOME ",
        "UNIT:2332",
        "ADDR:1540 EAGLE DR",
        "CITY:Kalispell",
        "CALL:F Smoke Investigation - Outside",
        "TIME:03:29",
        "INFO:RP CANNOT SEE FLAMES  RP STATES UNKN HOW MUCH , CAN SMELL THE SMOKE  TOWARDS S WOODLAND  RP CAN SEE SMOKE TO THE WEST OF HIS HOME");

    doTest("T12",
        "(Dispatch Information) Location: 95 RIDGEWOOD DR Lakeside Call Type: F Structure Fire Call Time: 22:57 Info:  Dispatch received by unit 631  Dispatch received by unit 601  HOUSE IFO THE ABOVE LOCATION HAS A FIRE FROM FIREWORKS  E911 Info - Class of Service: WPH2 ",
        "ADDR:95 RIDGEWOOD DR",
        "CITY:Lakeside",
        "CALL:F Structure Fire",
        "TIME:22:57",
        "INFO:Dispatch received by unit 631  Dispatch received by unit 601  HOUSE IFO THE ABOVE LOCATION HAS A FIRE FROM FIREWORKS  E911 Info - Class of Service: WPH2");

    doTest("T13",
        "(Dispatch Information) Unit:2331 Status:Dispatched Location: 95 RIDGEWOOD DR Kalispell Call Type: F Structure Fire Call Time: 22:57 Info:  HOUSE IFO THE ABOVE LOCATION HAS A FIRE FROM FIREWORKS  E911 Info - Class of Service: WPH2 ",
        "UNIT:2331",
        "ADDR:95 RIDGEWOOD DR",
        "CITY:Kalispell",
        "CALL:F Structure Fire",
        "TIME:22:57",
        "INFO:HOUSE IFO THE ABOVE LOCATION HAS A FIRE FROM FIREWORKS  E911 Info - Class of Service: WPH2");

    doTest("T14",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 2745 HIGHWAY 93 S Kalispell Call Type: Medical ALS Call Time: 10:51 Info:  Nature Of Call: 17M2  Call Number 282 was created from Call Number 276(Jul  4 2013 10:29AM)  REQ'ING MEDICAL // MALE DISORIENTED  I  Call #: 277 - IN KM MARINE PARKING LOT  Call #: 277 - NOW NEXT TO SS CAMPER ON FOOT NEIGHBOR IS IN A TRUCK  Call #: 277 - BLACK SHIRT AND JEANS NEIGHBOR IS CHASING HIM  Call #: 277 - REUNNING AWAY TORWard ss campers  Call #: 2",
        "UNIT:SKFD",
        "ADDR:2745 HIGHWAY 93 S",
        "CITY:Kalispell",
        "CALL:Medical ALS",
        "TIME:10:51",
        "INFO:Nature Of Call: 17M2  Call Number 282 was created from Call Number 276(Jul  4 2013 10:29AM)  REQ'ING MEDICAL // MALE DISORIENTED  I  Call #: 277 - IN KM MARINE PARKING LOT  Call #: 277 - NOW NEXT TO SS CAMPER ON FOOT NEIGHBOR IS IN A TRUCK  Call #: 277 - BLACK SHIRT AND JEANS NEIGHBOR IS CHASING HIM  Call #: 277 - REUNNING AWAY TORWard ss campers  Call #: 2");

    doTest("T15",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 543 LENWOOD LN Kalispell Call Type: Medical BLS RED Call Time: 13:47 Info:  MAN LYING IN DRIVEWAY....FEMALE YELLING FOR HELP  E911 Info - Class of Service: RESD ",
        "UNIT:SKFD",
        "ADDR:543 LENWOOD LN",
        "CITY:Kalispell",
        "CALL:Medical BLS RED",
        "TIME:13:47",
        "INFO:MAN LYING IN DRIVEWAY....FEMALE YELLING FOR HELP  E911 Info - Class of Service: RESD");

    doTest("T16",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 1717 S WOODLAND DR 19 Kalispell Call Type: Medical BLS RED Call Time: 18:24 Info:  BREATHING DIFFICULTY  BLU BUICK AND TURQ BUICK  BEIGE TRAILER  PORCH LIGHT IS ON  IS ON OXYGEN DUE TO SLEEP APNEA  IS ON OXYGEN  77 YO FEMALE  E911 Info - Class of Service: WPH2 ",
        "UNIT:SKFD",
        "ADDR:1717 S WOODLAND DR",
        "APT:19",
        "CITY:Kalispell",
        "CALL:Medical BLS RED",
        "TIME:18:24",
        "INFO:BREATHING DIFFICULTY  BLU BUICK AND TURQ BUICK  BEIGE TRAILER  PORCH LIGHT IS ON  IS ON OXYGEN DUE TO SLEEP APNEA  IS ON OXYGEN  77 YO FEMALE  E911 Info - Class of Service: WPH2");

    doTest("T17",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 234 SHELTER VALLEY DR Kalispell Call Type: Medical BLS YEL Call Time: 04:14 Info:  LEFT SIDE PAIN  92 YOA FEMALE FELL FROM STANDING POSITION  E911 Info - Class of Service: BUSN ",
        "UNIT:SKFD",
        "ADDR:234 SHELTER VALLEY DR",
        "CITY:Kalispell",
        "CALL:Medical BLS YEL",
        "TIME:04:14",
        "INFO:LEFT SIDE PAIN  92 YOA FEMALE FELL FROM STANDING POSITION  E911 Info - Class of Service: BUSN");

    doTest("T18",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 50 TWIN ACRES DR 9 Kalispell Call Type: Medical ALS Call Time: 17:30 Info:  BREATHING BUT SLURRING SPEACH  Nature Of Call: 18M2  E911 Info - Class of Service: WRLS ",
        "UNIT:SKFD",
        "ADDR:50 TWIN ACRES DR",
        "APT:9",
        "CITY:Kalispell",
        "CALL:Medical ALS",
        "TIME:17:30",
        "INFO:BREATHING BUT SLURRING SPEACH  Nature Of Call: 18M2  E911 Info - Class of Service: WRLS");

    doTest("T19",
        "(Dispatch Information) Unit:2332 Status:Dispatched Location: 38 TRAILS END DR Kalispell Call Type: MVA Non Injury Call Time: 15:05 Info:  ADVISED MHP  GOLD POINTIAC BONNIVILLE BLK CHEVY SILVERADO ",
        "UNIT:2332",
        "ADDR:38 TRAILS END DR",
        "CITY:Kalispell",
        "CALL:MVA Non Injury",
        "TIME:15:05",
        "INFO:ADVISED MHP  GOLD POINTIAC BONNIVILLE BLK CHEVY SILVERADO");

    doTest("T20",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 508 CONRAD DR Kalispell Call Type: Medical ALS Call Time: 10:28 Info:  CHEST FEELS HEAVY  PAIN UP HER ARM AND INTO HER SHOULDERS  74 YOF // HAVING PAIN IN HER RIGHT ARM  E911 Info - Class of Service: RESD ",
        "UNIT:SKFD",
        "ADDR:508 CONRAD DR",
        "CITY:Kalispell",
        "CALL:Medical ALS",
        "TIME:10:28",
        "INFO:CHEST FEELS HEAVY  PAIN UP HER ARM AND INTO HER SHOULDERS  74 YOF // HAVING PAIN IN HER RIGHT ARM  E911 Info - Class of Service: RESD");

    doTest("T21",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 243 CAROLINE RD Kalispell Call Type: Medical BLS RED Call Time: 12:20 Info:  GO TO BACK DOOR  GENERALIZED WEAKNESS / HEADACHE  93 YOA FEMALE  E911 Info - Class of Service: RESD ",
        "UNIT:SKFD",
        "ADDR:243 CAROLINE RD",
        "CITY:Kalispell",
        "CALL:Medical BLS RED",
        "TIME:12:20",
        "INFO:GO TO BACK DOOR  GENERALIZED WEAKNESS / HEADACHE  93 YOA FEMALE  E911 Info - Class of Service: RESD");

    doTest("T22",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 134 COLLIER LN Kalispell Call Type: Medical ALS Call Time: 22:06 Info:  MALE NOT BREATHING  E911 Info - Class of Service: RESD ",
        "UNIT:SKFD",
        "ADDR:134 COLLIER LN",
        "CITY:Kalispell",
        "CALL:Medical ALS",
        "TIME:22:06",
        "INFO:MALE NOT BREATHING  E911 Info - Class of Service: RESD");

    doTest("T23",
        "(Dispatch Information) Unit:2391 Status:Dispatched Location: 1715 W RESERVE DR Kalispell Call Type: F Structure Fire Call Time: 22:56 Info:  HOUSE ON FIRE  E911 Info - Class of Service: WRLS ",
        "UNIT:2391",
        "ADDR:1715 W RESERVE DR",
        "CITY:Kalispell",
        "CALL:F Structure Fire",
        "TIME:22:56",
        "INFO:HOUSE ON FIRE  E911 Info - Class of Service: WRLS");

    doTest("T24",
        "(Dispatch Information) Location: 516 CONRAD DR Kalispell Call Type: Medical BLS RED Call Time: 18:14 Info:  Nature Of Call: 14R3  Dispatch received by unit 621  SPACE B  PM  MALE SUBJ ATTEMPTING TO OD ON TYLONAL P,  Call Number 435 was created from Call Number 434(Jun  6 2013  6:12PM) ",
        "ADDR:516 CONRAD DR",
        "CITY:Kalispell",
        "CALL:Medical BLS RED",
        "TIME:18:14",
        "INFO:Nature Of Call: 14R3  Dispatch received by unit 621  SPACE B  PM  MALE SUBJ ATTEMPTING TO OD ON TYLONAL P,  Call Number 435 was created from Call Number 434(Jun  6 2013  6:12PM)");

    doTest("T25",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 516 CONRAD DR Kalispell Call Type: Medical BLS RED Call Time: 18:14 Info:  SPACE B  PM  MALE SUBJ ATTEMPTING TO OD ON TYLONAL P,  Call Number 435 was created from Call Number 434(Jun  6 2013  6:12PM) ",
        "UNIT:SKFD",
        "ADDR:516 CONRAD DR",
        "CITY:Kalispell",
        "CALL:Medical BLS RED",
        "TIME:18:14",
        "INFO:SPACE B  PM  MALE SUBJ ATTEMPTING TO OD ON TYLONAL P,  Call Number 435 was created from Call Number 434(Jun  6 2013  6:12PM)");

    doTest("T26",
        "(Dispatch Information) Unit:2332 Status:Dispatched Location: Call Type: MVA BLS RED Call Time: 12:27 Info:  RED AND BLUE CARS  E911 Info - Class of Service: WPH2 ",
        "UNIT:2332",
        "CALL:MVA BLS RED",
        "TIME:12:27",
        "INFO:RED AND BLUE CARS  E911 Info - Class of Service: WPH2");

    doTest("T27",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 100 SHELTER VALLEY DR Kalispell Call Type: Medical BLS RED Call Time: 13:55 Info:  Nature Of Call: 4R1  RP STATING HIS HEAD IS BLEEDING  RP STATING HIS SISTER JUST THREW A GLASS AT RP'S HEAD ",
        "UNIT:SKFD",
        "ADDR:100 SHELTER VALLEY DR",
        "CITY:Kalispell",
        "CALL:Medical BLS RED",
        "TIME:13:55",
        "INFO:Nature Of Call: 4R1  RP STATING HIS HEAD IS BLEEDING  RP STATING HIS SISTER JUST THREW A GLASS AT RP'S HEAD");

    doTest("T28",
        "(Dispatch Information) Unit:SKFD Status:Dispatched Location: 1249 WILLOW GLEN DR COUNTY SHOPKalispell Call Type: AA Call Time: 17:38 Info:  Call Number 63 was created from Call Number 62(May 26 2013  5:31PM)  738 REQ'S FIRE DEPT  Dispatch received by unit 738  B/C COUNTY SHOPS  HOLE IN THE TOP OF THE TANK  LARGE LEAK  SO MUCH LIQUID THAT ITS CREATING A POOL  RP ADV THIS IS NOT NORMAL....UNKN WHAT KIND OF LIQUID  RP JUST WALKED BY THE FLATHEAD COUNTY SHOP.....15 FT TANK IS GUSHING OUT WATER  E91",
        "UNIT:SKFD",
        "ADDR:1249 WILLOW GLEN DR",
        "PLACE:COUNTY SHOP",
        "CITY:Kalispell",
        "CALL:AA",
        "TIME:17:38",
        "INFO:Call Number 63 was created from Call Number 62(May 26 2013  5:31PM)  738 REQ'S FIRE DEPT  Dispatch received by unit 738  B/C COUNTY SHOPS  HOLE IN THE TOP OF THE TANK  LARGE LEAK  SO MUCH LIQUID THAT ITS CREATING A POOL  RP ADV THIS IS NOT NORMAL....UNKN WHAT KIND OF LIQUID  RP JUST WALKED BY THE FLATHEAD COUNTY SHOP.....15 FT TANK IS GUSHING OUT WATER  E91");

  }
  
  @Test
  public void testBigMountainFire() {

    doTest("T1",
        "(Dispatch Information) Unit:2021 Status:Dispatched Location: 3808 BIG MOUNTAIN RD Gen: Whitefish Call Type: Medical BLS RED Call Time: 10:37 Info:  Nature Of Call: 12R2  2 PATIENTS FEMALE 40 AND MALE 48 YOA  CALL TK ON CHANNEL 1  NECK AND BACK PAIN  BOTTOM OF ZIP LINE #4  E911 Info - Class of Service: WPH2 ",
        "UNIT:2021",
        "ADDR:3808 BIG MOUNTAIN RD",
        "CITY:Whitefish",
        "CALL:Medical BLS RED",
        "TIME:10:37",
        "INFO:Nature Of Call: 12R2  2 PATIENTS FEMALE 40 AND MALE 48 YOA  CALL TK ON CHANNEL 1  NECK AND BACK PAIN  BOTTOM OF ZIP LINE #4  E911 Info - Class of Service: WPH2");

    doTest("T2",
        "(Dispatch Information) Unit:2021 Status:Dispatched Location: 3450 BIG MOUNTAIN RD Whitefish Call Type: F Automatic Fire Alarm Call Time: 13:25 Info:  FIRE ALARM // HAYES RESIDENCE // AT THE GUEST HOUSE ",
        "UNIT:2021",
        "ADDR:3450 BIG MOUNTAIN RD",
        "CITY:Whitefish",
        "CALL:F Automatic Fire Alarm",
        "TIME:13:25",
        "INFO:FIRE ALARM // HAYES RESIDENCE // AT THE GUEST HOUSE");

  }
  
  @Test
  public void testEvergreenFireRescue() {

    doTest("T1",
        "(Dispatch Information) Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: Inter Facility Transfer Call Time: 11:38 Info:  TO RADIATION ",
        "ADDR:310 SUNNY VIEW LN",
        "CITY:Kalispell",
        "PLACE:KRMC",
        "CALL:Inter Facility Transfer",
        "TIME:11:38",
        "INFO:TO RADIATION");

    doTest("T2",
        "(Dispatch Information) Unit:821 Status:Enroute Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: < New Call > Call Time: 11:38 Info:  TO RADIATION ",
        "UNIT:821",
        "ADDR:310 SUNNY VIEW LN",
        "CITY:Kalispell",
        "PLACE:KRMC",
        "CALL:< New Call >",
        "TIME:11:38",
        "INFO:TO RADIATION");

    doTest("T3",
        "(Dispatch Information) Unit:821 Status:Dispatched Location: 1985 HIGHWAY 35 24 Gen: SPRUCE PARKKalispell Call Type: Medical BLS RED Call Time: 09:45 Info:  DIABETIC // NOT FEELING WEEL / WEAK ",
        "UNIT:821",
        "ADDR:1985 HIGHWAY 35",
        "APT:24",
        "CITY:Kalispell",
        "PLACE:SPRUCE PARK",
        "CALL:Medical BLS RED",
        "TIME:09:45",
        "INFO:DIABETIC // NOT FEELING WEEL / WEAK");

    doTest("T4",
        "(Dispatch Information) Location: 200 HERITAGE WAY Gen: PATHWAYSKalispell Call Type: Inter Facility Transfer Call Time: 07:53 Info:  TO WARM SPRING ",
        "ADDR:200 HERITAGE WAY",
        "CITY:Kalispell",
        "PLACE:PATHWAYS",
        "CALL:Inter Facility Transfer",
        "TIME:07:53",
        "INFO:TO WARM SPRING");

    doTest("T5",
        "(Dispatch Information) Unit:824 Status:Enroute Location: 200 HERITAGE WAY Gen: PATHWAYSKalispell Call Type: < New Call > Call Time: 07:53 Info:  TO WARM SPRING ",
        "UNIT:824",
        "ADDR:200 HERITAGE WAY",
        "CITY:Kalispell",
        "PLACE:PATHWAYS",
        "CALL:< New Call >",
        "TIME:07:53",
        "INFO:TO WARM SPRING");

    doTest("T6",
        "(Dispatch Information) Unit:841 Status:Dispatched Location: W RESERVE DR Gen: Kalispell Call Type: MVA BLS RED Call Time: 06:47 Info:  REAR END ACCIDENT // NECK INJURY  E911 Info - Class of Service: WPH2 ",
        "UNIT:841",
        "ADDR:W RESERVE DR",
        "CITY:Kalispell",
        "CALL:MVA BLS RED",
        "TIME:06:47",
        "INFO:REAR END ACCIDENT // NECK INJURY  E911 Info - Class of Service: WPH2");

    doTest("T7",
        "(Dispatch Information) Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: Inter Facility Transfer Call Time: 06:11 Info: ",
        "ADDR:310 SUNNY VIEW LN",
        "CITY:Kalispell",
        "PLACE:KRMC",
        "CALL:Inter Facility Transfer",
        "TIME:06:11");

    doTest("T8",
        "(Dispatch Information) Unit:824 Status:Enroute Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: < New Call > Call Time: 06:11 Info: ",
        "UNIT:824",
        "ADDR:310 SUNNY VIEW LN",
        "CITY:Kalispell",
        "PLACE:KRMC",
        "CALL:< New Call >",
        "TIME:06:11");

    doTest("T9",
        "(Dispatch Information) Unit:824 Status:Enroute Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: Inter Facility Transfer Call Time: 00:51 Info: ",
        "UNIT:824",
        "ADDR:310 SUNNY VIEW LN",
        "CITY:Kalispell",
        "PLACE:KRMC",
        "CALL:Inter Facility Transfer",
        "TIME:00:51");

    doTest("T10",
        "(Dispatch Information) Location: 310 SUNNY VIEW LN Gen: KRMCKalispell Call Type: Inter Facility Transfer Call Time: 11:51 Info: ",
        "ADDR:310 SUNNY VIEW LN",
        "CITY:Kalispell",
        "PLACE:KRMC",
        "CALL:Inter Facility Transfer",
        "TIME:11:51");
 
  }
  
  public static void main(String[] args) {
    new MTFlatheadCountyParserTest().generateTests("T1");
  }
}
