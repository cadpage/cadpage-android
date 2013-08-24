package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
El Paso County, CO
Contact: Shane Gattis <cfpd1400@gmail.com>
Sender: ept@ept911.info
System: Tri Tech

CAL FD - Unconscious / Fainti24615 Scott Rd                Big Cats of Ser[Premise:  24615 SCOTT RD] [Low] [UNKNOWN] See " P\r
CAL FD - Medical             1222 Ververs Ln                              1481 transporting,no further resp needed,Automatic\r
CAL FD - Medical             5TH ST / CASCADE ST                          5C42  NEED MEDICAL - SCRAPE ON HEAD -[Shared],5C42\r
CAL FD - Medical             1350 8th St                                  [Page] Unit: 5c46, Sent From: EPSO4 ,MP , 5C46 5C4\r
CAL FD - Chest Pain          185 4th St                    Calhan Full Gos911ALI Info: Verizon WRLS 800-451-5242, Wireless,\r

El Paso County, CO (fix)
Contact: benrackl <benrackl@msn.com>
Sender: ept@ept911.info
BFFD D4      Choking                       5021 Roundup Ridge R               911ALI Info: FRIER, JEFF & KATBFFD12-0767
BFFD D3      Explosion                     5150 High Meadows Ln               MOST RECENT ONE WAS 5 MIN AGO[TRL121732

Contact: Active911
Agency name: Manitou Springs Fire Department
Location: Manitou Springs, CO, United States
Sender: ept@ept911.info

MSFD-15 El Paso Blvd          APT-LOT 3 Medical                  DET-
MSFD-906 Osage Ave            APT-APT MAChest Pain               DET-10D02
MSFD-1 - 96 Serpentine Dr     APT-      F Outside Fire           DET-
MSFD-9 Capitol Hill Av        APT-      Check the Welfare        DET-
MSFD-819 Manitou Ave          APT-      F Fire Alarm             DET-
MSFD-312 Ruxton Ave           APT-      Domestic                 DET-
MSFD-106 Manitou Av           APT-B     Overdose/ Poisoning      DET-
MSFD-211 Beckers Ln           APT-APT A Citizen/Public Assist    DET-
MSFD-103 Ruxton Ave           APT-c     Medical                  DET-
MSFD-502 Canon Ave            APT-F     Medical                  DET-
MSFD-15 El Paso Blvd          APT-      Medical                  DET-
MSFD-211 Beckers Ln           APT-APT A Medical                  DET-
MSFD-415 El Monte Pl          APT-      CAMPING                  DET-
MSFD-515 Ruxton Av            APT-      Medical                  DET-
MSFD-819 Duclo Ave            APT-APT A Medical                  DET-
MSFD-531 Canon Ave            APT-      Medical                  DET-
MSFD-401 El Monte Pl          APT-NEW   Medical                  DET-
MSFD-311 Manitou Av           APT-APT 96F Fire Alarm             DET-
MSFD-52 EL PASO BLVD          APT-2C    Information              DET-
MSFD-606 Manitou Av           APT-      Utility Problem          DET-
MSFD-531 Canon Ave            APT-      Suicidal Check the WelfarDET-
MSFD-404 El Paso Blvd         APT-      F Fire Alarm             DET-
MSFD-W Hwy 24 / El Paso Blvd  APT-      Traffic Accident         DET-
MSFD-934 Manitou Av           APT-      Criminal Mischief        DET-

Contact: VirpiMattson@elpasoco.com
Sender: ept@ept911.info
System: Tri Tech

[primary jurisdiction code (manual entry, up to 5 char): RESPONSE AREA/GRID (7 char)]
UNITS ASSIGNED (60 char)~PROBLEM (25 char)~ADDRESS (25 char).#APARTMENT (5 char)~
LOCATION NAME (20 char)~INCIDENT NUMBER (11 char)

[AFA: AFA D1] AFA1,2111,AMR~TRAUMATIC INJURY~5234 ASPEN DR.#~COMMUNITY GYMNASIUM~AFA217748
[CAL: 597-4] CAL,AMR,CSP~TRAFF ACC W/INJURIES~SOAP WEED/MCCLASKEY RD.#~~CAL217932
[CAS: 250-2] CAS,AMR1,CSP1,SARG,CSU~TRAFF ACC UNK INJURIES~8180 W 24 HWY.#~NORTH POLE SANTAS WORKSHOP~CAS217800
[DWFD: DWH6b] DWFD,511,CSFD~CHEST PAIN~11195 83 HWY.#~PPCC NORTH~DWFD217637
[PLFD: 239] PLFD,2231,2281,TRM2~ALARM, MEDICAL~210 SOUTH VALLEY RD.#5~~PLFD217638
[TRM: TLH2f] TRM2,2231,2281~SICK PERSON~24 LINCOLN AVE.#A~~TRL217681
[WILD: 619] WILDC,FTC~SMOKE INVESTIGATION~NELSON BLVD/HWY 115.#~~EPC217742

Contact:  Eric Riffle <ericriffle@ymail.com>
Sender: ept@ept911.info
ept@ept911.info
[AFA: AFA D1] AFA11,2111,2113,2170,2130,2152,REHAB2,HAZC~Odor                          ~6776 Carlton Dr               #     ~CARLTON HOUSE - USAF~AFA300130

Contact: Active911
Agency name: El Paso County Sheriffs Office Fire Crew
Location: Colorado Springs, CO, United States
Sender: ept@ept911.info

[FAL FD:FAL D5   ] BFFD,REHAB3,FAL5,WILDC~Outside Fire             ~18425 Table Rock Rd       #     ~                    ~FAL218808
[FAL FD:FAL D6   ] FAL6,REHAB3,WILDC~Outside Fire             ~6245 Peerless Farms Rd    #     ~                    ~FAL218650
[GMF FD :242      ] GMF,CAS,REHAB,WILDC~Smoke Investigation      ~11160 W 24 Hwy            #     ~Big Pines Storage   ~GMF218637
[EPSO: 258      ] WILDC,CSFD,PFS,REHAB2~Outside Fire             ~3445 W Colorado Ave       #     ~Mountain Scape Motel~EPC218618
[EPSO: 237-12   ] 3141,3151,WILDG,PFS~Smoke Investigation      ~0 Incline Overlook - Barr #     ~Incline Overlook  - ~EPC218605
[CHFD:223      ] Chm,CHFD1,WILDC,REHAB~Smoke Investigation      ~1100 Kachina Dr           #     ~                    ~CHFD218582
[FAL FD:FAL D1   ] FAL1,BFFD,REHAB2,WILDC~Smoke Investigation      ~Judge Orr Rd / E Hwy 24   #     ~                    ~FAL218556
[CAL FD:597-2  ] CAL,SIM,TRC,WILDC~Outside Fire             ~36350 Funk Rd             #     ~                    ~CAL218491
[AFA: AFA D4 ] AFA44,2113,2152,WILDC~Vehicle Fire             ~I 25 / Interquest Pkwy    #     ~MM153 I-25          ~AFA218835\r\n

Contact: Active911
Agency name: Donald Wescott Fire Protection District
Location: Colorado Springs, CO, United States
Sender: ept@ept911.info

[DWFD:DW6a     ] 511,DWFD,582~Vehicle Fire             ~0 83 Hwy                  #     ~MM25 Hwy 83         ~DWFD218990
[TRL FD:TLH3a    ] 531,TRM3,2281,CSP~Traff Acc W/Injuries~W Baptist Rd / I 25       #     ~               ~TRL218987  ~~
[TRL FD:TLH3b    ] 531,TRM3,2281~Breathing Problem   ~15854 Jackson Creek Pkwy  #rm 2 ~               ~TRL218976  ~~
[DWFD:DW6a     ] 511,582,DWFD,AMR~Unconscious / Fainting   ~14710 Roller Coaster Rd   #     ~                    ~DWFD218966
[DWFD:DWH5c    ] 531,582,DWFD,AMR~Diabetic Problem         ~15430 Paddington Cir      #     ~                    ~DWFD218936
[BFFD:BFFD D4  ] DWFD,BFFD4,CSP~Traff Acc Unk Injuries        ~Hwy 83 / Flying Horse Club Dr       #     ~                    ~BFFD218910
[DWFD:DWH5c    ] 582,531,DWFD~Utility Problem          ~STRUTHERS RD / PARADISE V #     ~                    ~DWFD218903
[DWFD:DWH5c    ] 531,DWFD,2273~Alarm, Fire              ~701 Airman Ln             #     ~                    ~DWFD218895
[DWFD:DWH5c    ] 531,DWFD,2273~Alarm, Fire              ~701 Airman Ln             #     ~                    ~DWFD218895
[DWFD:DW6c     ] 511,DWFD,582~Citizen Assist/Service Ca~1135 Old Ranch Rd         #     ~                    ~DWFD218866

Contact: Active911
Agency name: Hanover Fire Protection District
Location: Colorado Springs, CO, United States
Sender: ept@ept911.info

[HAN FD:HAN D1] HAN1,AMR~Med-Stage                ~17050 S Peyton Hwy                  #     ~Hanover Schools Dist~HAN13-039
[HAN FD:HAN D1] HAN1,AMR~Med-Stage                ~12393 S Squirrel Creek Rd           #     ~                    ~HAN13-038
[HAN FD:HAN D4] HAN4,AMR1~Overdose / Poisoning     ~9650 Las Haciendas Pt               #     ~                    ~HAN13-037
[HAN FD:HAN D2] FINFO,HAN2~Controlled Burn          ~20480 Wigwam Rd                     #     ~                    ~HAN13-036
[HAN FD:HAN D1] HAN,AMR~Med-Stage                ~12393 Squirrel Creek Rd             #     ~                    ~HAN13-035
[HAN FD:HAN D1] HAN1,AMR~Suicidal Check the Welfar~13865 Hobby Horse Ln                #     ~                    ~HAN13-034
[HAN FD:HAN D4] HAN4,AMR~Back Pain                ~20911 Boca Chica Hts                #     ~                    ~HAN13-033
[HAN FD:HAN D1] HAN~Alarm, Fire              ~17050 S Peyton Hwy                  #     ~Hanover Schools Dist~HAN13-032
[HAN FD:HAN D1] HAN1~Med-Stage                ~17050 S Peyton Hwy                  #     ~Han Middle - 3571 os~HAN13-031
[HAN FD:HAN D2] HAN2~Fire Page                ~13325 Old Pueblo Rd                 #     ~TEST ONLY Hanover FD~HAN13-030
[HAN FD:HAN D1] HAN~Fire Page                ~17550 S Peyton Hwy                  #     ~TEST PAGE           ~HAN301776
[CSFD:220-6 ] HAN,HAN,HAN,HAN~Fire Page                     ~2739 E Las Vegas St                 #     ~CJC                 ~CSFD301775

 */

public class COElPasoCountyParserTest extends BaseParserTest {
  
  public COElPasoCountyParserTest() {
    setParser(new COElPasoCountyParser(), "EL PASO COUNTY", "CO");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "CAL FD - Unconscious / Fainti24615 Scott Rd                Big Cats of Ser[Premise:  24615 SCOTT RD] [Low] [UNKNOWN] See \" P\r",
        "SRC:CAL FD",
        "CALL:Unconscious / Fainti",
        "ADDR:24615 Scott Rd",
        "PLACE:Big Cats of Ser",
        "INFO:[Premise:  24615 SCOTT RD] [Low] [UNKNOWN] See \" P");

    doTest("T2",
        "CAL FD - Medical             1222 Ververs Ln                              1481 transporting,no further resp needed,Automatic\r",
        "SRC:CAL FD",
        "CALL:Medical",
        "ADDR:1222 Ververs Ln",
        "INFO:1481 transporting,no further resp needed,Automatic");

    doTest("T3",
        "CAL FD - Medical             5TH ST / CASCADE ST                          5C42  NEED MEDICAL - SCRAPE ON HEAD -[Shared],5C42\r",
        "SRC:CAL FD",
        "CALL:Medical",
        "ADDR:5TH ST & CASCADE ST",  // Not mapping
        "INFO:5C42  NEED MEDICAL - SCRAPE ON HEAD -[Shared],5C42");

    doTest("T4",
        "CAL FD - Medical             1350 8th St                                  [Page] Unit: 5c46, Sent From: EPSO4 ,MP , 5C46 5C4\r",
        "SRC:CAL FD",
        "CALL:Medical",
        "ADDR:1350 8th St",
        "INFO:[Page] Unit: 5c46, Sent From: EPSO4 ,MP , 5C46 5C4");

    doTest("T5",
        "CAL FD - Chest Pain          185 4th St                    Calhan Full Gos911ALI Info: Verizon WRLS 800-451-5242, Wireless,\r",
        "SRC:CAL FD",
        "CALL:Chest Pain",
        "ADDR:185 4th St",
        "PLACE:Calhan Full Gos",
        "INFO:911ALI Info: Verizon WRLS 800-451-5242, Wireless,");

  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "BFFD D4      Choking                       5021 Roundup Ridge R               911ALI Info: FRIER, JEFF & KATBFFD12-0767",
        "SRC:BFFD",
        "PRI:D4",
        "CALL:Choking",
        "ADDR:5021 Roundup Ridge R",
        "INFO:911ALI Info: FRIER, JEFF & KATBFFD12-0767");

    doTest("T2",
        "BFFD D3      Explosion                     5150 High Meadows Ln               MOST RECENT ONE WAS 5 MIN AGO[TRL121732",
        "SRC:BFFD",
        "PRI:D3",
        "CALL:Explosion",
        "ADDR:5150 High Meadows Ln",
        "INFO:MOST RECENT ONE WAS 5 MIN AGO[TRL121732");

  }
  
  @Test
  public void testManitouSpringsFire() {

    doTest("T1",
        "MSFD-15 El Paso Blvd          APT-LOT 3 Medical                  DET-",
        "SRC:MSFD",
        "ADDR:15 El Paso Blvd",
        "APT:LOT 3",
        "CALL:Medical");

    doTest("T2",
        "MSFD-906 Osage Ave            APT-APT MAChest Pain               DET-10D02",
        "SRC:MSFD",
        "ADDR:906 Osage Ave",
        "APT:APT MA",
        "CALL:Chest Pain",
        "INFO:10D02");

    doTest("T3",
        "MSFD-1 - 96 Serpentine Dr     APT-      F Outside Fire           DET-",
        "SRC:MSFD",
        "ADDR:1 - 96 Serpentine Dr",
        "MADDR:1 Serpentine Dr",
        "CALL:F Outside Fire");

    doTest("T4",
        "MSFD-9 Capitol Hill Av        APT-      Check the Welfare        DET-",
        "SRC:MSFD",
        "ADDR:9 Capitol Hill Av",
        "MADDR:9 Capitol Hill Ave",
        "CALL:Check the Welfare");

    doTest("T5",
        "MSFD-819 Manitou Ave          APT-      F Fire Alarm             DET-",
        "SRC:MSFD",
        "ADDR:819 Manitou Ave",
        "CALL:F Fire Alarm");

    doTest("T6",
        "MSFD-312 Ruxton Ave           APT-      Domestic                 DET-",
        "SRC:MSFD",
        "ADDR:312 Ruxton Ave",
        "CALL:Domestic");

    doTest("T7",
        "MSFD-106 Manitou Av           APT-B     Overdose/ Poisoning      DET-",
        "SRC:MSFD",
        "ADDR:106 Manitou Av",
        "MADDR:106 Manitou Ave",
        "APT:B",
        "CALL:Overdose/ Poisoning");

    doTest("T8",
        "MSFD-211 Beckers Ln           APT-APT A Citizen/Public Assist    DET-",
        "SRC:MSFD",
        "ADDR:211 Beckers Ln",
        "APT:APT A",
        "CALL:Citizen/Public Assist");

    doTest("T9",
        "MSFD-103 Ruxton Ave           APT-c     Medical                  DET-",
        "SRC:MSFD",
        "ADDR:103 Ruxton Ave",
        "APT:c",
        "CALL:Medical");

    doTest("T10",
        "MSFD-502 Canon Ave            APT-F     Medical                  DET-",
        "SRC:MSFD",
        "ADDR:502 Canon Ave",
        "APT:F",
        "CALL:Medical");

    doTest("T11",
        "MSFD-15 El Paso Blvd          APT-      Medical                  DET-",
        "SRC:MSFD",
        "ADDR:15 El Paso Blvd",
        "CALL:Medical");

    doTest("T12",
        "MSFD-211 Beckers Ln           APT-APT A Medical                  DET-",
        "SRC:MSFD",
        "ADDR:211 Beckers Ln",
        "APT:APT A",
        "CALL:Medical");

    doTest("T13",
        "MSFD-415 El Monte Pl          APT-      CAMPING                  DET-",
        "SRC:MSFD",
        "ADDR:415 El Monte Pl",
        "CALL:CAMPING");

    doTest("T14",
        "MSFD-515 Ruxton Av            APT-      Medical                  DET-",
        "SRC:MSFD",
        "ADDR:515 Ruxton Av",
        "MADDR:515 Ruxton Ave",
        "CALL:Medical");

    doTest("T15",
        "MSFD-819 Duclo Ave            APT-APT A Medical                  DET-",
        "SRC:MSFD",
        "ADDR:819 Duclo Ave",
        "APT:APT A",
        "CALL:Medical");

    doTest("T16",
        "MSFD-531 Canon Ave            APT-      Medical                  DET-",
        "SRC:MSFD",
        "ADDR:531 Canon Ave",
        "CALL:Medical");

    doTest("T17",
        "MSFD-401 El Monte Pl          APT-NEW   Medical                  DET-",
        "SRC:MSFD",
        "ADDR:401 El Monte Pl",
        "APT:NEW",
        "CALL:Medical");

    doTest("T18",
        "MSFD-311 Manitou Av           APT-APT 96F Fire Alarm             DET-",
        "SRC:MSFD",
        "ADDR:311 Manitou Av",
        "MADDR:311 Manitou Ave",
        "APT:APT 96",
        "CALL:F Fire Alarm");

    doTest("T19",
        "MSFD-52 EL PASO BLVD          APT-2C    Information              DET-",
        "SRC:MSFD",
        "ADDR:52 EL PASO BLVD",
        "APT:2C",
        "CALL:Information");

    doTest("T20",
        "MSFD-606 Manitou Av           APT-      Utility Problem          DET-",
        "SRC:MSFD",
        "ADDR:606 Manitou Av",
        "MADDR:606 Manitou Ave",
        "CALL:Utility Problem");

    doTest("T21",
        "MSFD-531 Canon Ave            APT-      Suicidal Check the WelfarDET-",
        "SRC:MSFD",
        "ADDR:531 Canon Ave",
        "CALL:Suicidal Check the Welfar");

    doTest("T22",
        "MSFD-404 El Paso Blvd         APT-      F Fire Alarm             DET-",
        "SRC:MSFD",
        "ADDR:404 El Paso Blvd",
        "CALL:F Fire Alarm");

    doTest("T23",
        "MSFD-W Hwy 24 / El Paso Blvd  APT-      Traffic Accident         DET-",
        "SRC:MSFD",
        "ADDR:W Hwy 24 & El Paso Blvd",
        "CALL:Traffic Accident");

    doTest("T24",
        "MSFD-934 Manitou Av           APT-      Criminal Mischief        DET-",
        "SRC:MSFD",
        "ADDR:934 Manitou Av",
        "MADDR:934 Manitou Ave",
        "CALL:Criminal Mischief");

  }
  
  @Test
  public void testVirpiMatson() {

    doTest("T1",
        "[AFA: AFA D1] AFA1,2111,AMR~TRAUMATIC INJURY~5234 ASPEN DR.#~COMMUNITY GYMNASIUM~AFA217748",
        "SRC:AFA",
        "MAP:AFA D1",
        "UNIT:AFA1,2111,AMR",
        "CALL:TRAUMATIC INJURY",
        "ADDR:5234 ASPEN DR",
        "PLACE:COMMUNITY GYMNASIUM",
        "ID:AFA217748");

    doTest("T2",
        "[CAL: 597-4] CAL,AMR,CSP~TRAFF ACC W/INJURIES~SOAP WEED/MCCLASKEY RD.#~~CAL217932",
        "SRC:CAL",
        "MAP:597-4",
        "UNIT:CAL,AMR,CSP",
        "CALL:TRAFF ACC W/INJURIES",
        "ADDR:SOAP WEED & MCCLASKEY RD",  // Google knows this as MC CLASKEY RD
        "ID:CAL217932");

    doTest("T3",
        "[CAS: 250-2] CAS,AMR1,CSP1,SARG,CSU~TRAFF ACC UNK INJURIES~8180 W 24 HWY.#~NORTH POLE SANTAS WORKSHOP~CAS217800",
        "SRC:CAS",
        "MAP:250-2",
        "UNIT:CAS,AMR1,CSP1,SARG,CSU",
        "CALL:TRAFF ACC UNK INJURIES",
        "ADDR:8180 W 24 HWY",
        "MADDR:8180 W HWY 24",
        "PLACE:NORTH POLE SANTAS WORKSHOP",
        "ID:CAS217800");

    doTest("T4",
        "[DWFD: DWH6b] DWFD,511,CSFD~CHEST PAIN~11195 83 HWY.#~PPCC NORTH~DWFD217637",
        "SRC:DWFD",
        "MAP:DWH6b",
        "UNIT:DWFD,511,CSFD",
        "CALL:CHEST PAIN",
        "ADDR:11195 83 HWY",
        "MADDR:11195 HWY 83",
        "PLACE:PPCC NORTH",
        "ID:DWFD217637");

    doTest("T5",
        "[PLFD: 239] PLFD,2231,2281,TRM2~ALARM, MEDICAL~210 SOUTH VALLEY RD.#5~~PLFD217638",
        "SRC:PLFD",
        "MAP:239",
        "UNIT:PLFD,2231,2281,TRM2",
        "CALL:ALARM, MEDICAL",
        "ADDR:210 SOUTH VALLEY RD",
        "APT:5",
        "ID:PLFD217638");

    doTest("T6",
        "[TRM: TLH2f] TRM2,2231,2281~SICK PERSON~24 LINCOLN AVE.#A~~TRL217681",
        "SRC:TRM",
        "MAP:TLH2f",
        "UNIT:TRM2,2231,2281",
        "CALL:SICK PERSON",
        "ADDR:24 LINCOLN AVE",
        "APT:A",
        "ID:TRL217681");

    doTest("T7",
        "[WILD: 619] WILDC,FTC~SMOKE INVESTIGATION~NELSON BLVD/HWY 115.#~~EPC217742",
        "SRC:WILD",
        "MAP:619",
        "UNIT:WILDC,FTC",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:NELSON BLVD & HWY 115",
        "ID:EPC217742");
   
  }
  
  @Test
  public void testERicRiffle() {

    doTest("T1",
        "[AFA: AFA D1] AFA11,2111,2113,2170,2130,2152,REHAB2,HAZC~Odor                          ~6776 Carlton Dr               #     ~CARLTON HOUSE - USAF~AFA300130",
        "SRC:AFA",
        "MAP:AFA D1",
        "UNIT:AFA11,2111,2113,2170,2130,2152,REHAB2,HAZC",
        "CALL:Odor",
        "ADDR:6776 Carlton Dr",
        "PLACE:CARLTON HOUSE - USAF",
        "ID:AFA300130");
   
  }
  
  @Test
  public void testElPasoCountySheriffFire() {

    doTest("T1",
        "[FAL FD:FAL D5   ] BFFD,REHAB3,FAL5,WILDC~Outside Fire             ~18425 Table Rock Rd       #     ~                    ~FAL218808",
        "SRC:FAL FD",
        "MAP:FAL D5",
        "UNIT:BFFD,REHAB3,FAL5,WILDC",
        "CALL:Outside Fire",
        "ADDR:18425 Table Rock Rd",
        "ID:FAL218808");

    doTest("T2",
        "[FAL FD:FAL D6   ] FAL6,REHAB3,WILDC~Outside Fire             ~6245 Peerless Farms Rd    #     ~                    ~FAL218650",
        "SRC:FAL FD",
        "MAP:FAL D6",
        "UNIT:FAL6,REHAB3,WILDC",
        "CALL:Outside Fire",
        "ADDR:6245 Peerless Farms Rd",
        "ID:FAL218650");

    doTest("T3",
        "[GMF FD :242      ] GMF,CAS,REHAB,WILDC~Smoke Investigation      ~11160 W 24 Hwy            #     ~Big Pines Storage   ~GMF218637",
        "SRC:GMF FD",
        "MAP:242",
        "UNIT:GMF,CAS,REHAB,WILDC",
        "CALL:Smoke Investigation",
        "ADDR:11160 W 24 Hwy",
        "MADDR:11160 W Hwy 24",
        "PLACE:Big Pines Storage",
        "ID:GMF218637");

    doTest("T4",
        "[EPSO: 258      ] WILDC,CSFD,PFS,REHAB2~Outside Fire             ~3445 W Colorado Ave       #     ~Mountain Scape Motel~EPC218618",
        "SRC:EPSO",
        "MAP:258",
        "UNIT:WILDC,CSFD,PFS,REHAB2",
        "CALL:Outside Fire",
        "ADDR:3445 W Colorado Ave",
        "PLACE:Mountain Scape Motel",
        "ID:EPC218618");

    doTest("T5",
        "[EPSO: 237-12   ] 3141,3151,WILDG,PFS~Smoke Investigation      ~0 Incline Overlook - Barr #     ~Incline Overlook  - ~EPC218605",
        "SRC:EPSO",
        "MAP:237-12",
        "UNIT:3141,3151,WILDG,PFS",
        "CALL:Smoke Investigation",
        "ADDR:Incline Overlook - Barr",  // Not mapping
        "PLACE:Incline Overlook  -",
        "ID:EPC218605");

    doTest("T6",
        "[CHFD:223      ] Chm,CHFD1,WILDC,REHAB~Smoke Investigation      ~1100 Kachina Dr           #     ~                    ~CHFD218582",
        "SRC:CHFD",
        "MAP:223",
        "UNIT:Chm,CHFD1,WILDC,REHAB",
        "CALL:Smoke Investigation",
        "ADDR:1100 Kachina Dr",
        "ID:CHFD218582");

    doTest("T7",
        "[FAL FD:FAL D1   ] FAL1,BFFD,REHAB2,WILDC~Smoke Investigation      ~Judge Orr Rd / E Hwy 24   #     ~                    ~FAL218556",
        "SRC:FAL FD",
        "MAP:FAL D1",
        "UNIT:FAL1,BFFD,REHAB2,WILDC",
        "CALL:Smoke Investigation",
        "ADDR:Judge Orr Rd & E Hwy 24",
        "ID:FAL218556");

    doTest("T8",
        "[CAL FD:597-2  ] CAL,SIM,TRC,WILDC~Outside Fire             ~36350 Funk Rd             #     ~                    ~CAL218491",
        "SRC:CAL FD",
        "MAP:597-2",
        "UNIT:CAL,SIM,TRC,WILDC",
        "CALL:Outside Fire",
        "ADDR:36350 Funk Rd",
        "ID:CAL218491");

    doTest("T9",
        "[AFA: AFA D4 ] AFA44,2113,2152,WILDC~Vehicle Fire             ~I 25 / Interquest Pkwy    #     ~MM153 I-25          ~AFA218835\r\n",
        "SRC:AFA",
        "MAP:AFA D4",
        "UNIT:AFA44,2113,2152,WILDC",
        "CALL:Vehicle Fire",
        "ADDR:I 25 & Interquest Pkwy",
        "PLACE:MM153 I-25",
        "ID:AFA218835");

  }
  
  @Test
  public void testDonaldWescottFire() {

    doTest("T1",
        "[DWFD:DW6a     ] 511,DWFD,582~Vehicle Fire             ~0 83 Hwy                  #     ~MM25 Hwy 83         ~DWFD218990",
        "SRC:DWFD",
        "MAP:DW6a",
        "UNIT:511,DWFD,582",
        "CALL:Vehicle Fire",
        "ADDR:83 Hwy",
        "MADDR:Hwy 83",
        "PLACE:MM25 Hwy 83",
        "ID:DWFD218990");

    doTest("T2",
        "[TRL FD:TLH3a    ] 531,TRM3,2281,CSP~Traff Acc W/Injuries~W Baptist Rd / I 25       #     ~               ~TRL218987  ~~",
        "SRC:TRL FD",
        "MAP:TLH3a",
        "UNIT:531,TRM3,2281,CSP",
        "CALL:Traff Acc W/Injuries",
        "ADDR:W Baptist Rd & I 25",
        "ID:TRL218987");

    doTest("T3",
        "[TRL FD:TLH3b    ] 531,TRM3,2281~Breathing Problem   ~15854 Jackson Creek Pkwy  #rm 2 ~               ~TRL218976  ~~",
        "SRC:TRL FD",
        "MAP:TLH3b",
        "UNIT:531,TRM3,2281",
        "CALL:Breathing Problem",
        "ADDR:15854 Jackson Creek Pkwy",
        "APT:rm 2",
        "ID:TRL218976");

    doTest("T4",
        "[DWFD:DW6a     ] 511,582,DWFD,AMR~Unconscious / Fainting   ~14710 Roller Coaster Rd   #     ~                    ~DWFD218966",
        "SRC:DWFD",
        "MAP:DW6a",
        "UNIT:511,582,DWFD,AMR",
        "CALL:Unconscious / Fainting",
        "ADDR:14710 Roller Coaster Rd",
        "ID:DWFD218966");

    doTest("T5",
        "[DWFD:DWH5c    ] 531,582,DWFD,AMR~Diabetic Problem         ~15430 Paddington Cir      #     ~                    ~DWFD218936",
        "SRC:DWFD",
        "MAP:DWH5c",
        "UNIT:531,582,DWFD,AMR",
        "CALL:Diabetic Problem",
        "ADDR:15430 Paddington Cir",
        "ID:DWFD218936");

    doTest("T6",
        "[BFFD:BFFD D4  ] DWFD,BFFD4,CSP~Traff Acc Unk Injuries        ~Hwy 83 / Flying Horse Club Dr       #     ~                    ~BFFD218910",
        "SRC:BFFD",
        "MAP:BFFD D4",
        "UNIT:DWFD,BFFD4,CSP",
        "CALL:Traff Acc Unk Injuries",
        "ADDR:Hwy 83 & Flying Horse Club Dr",
        "ID:BFFD218910");

    doTest("T7",
        "[DWFD:DWH5c    ] 582,531,DWFD~Utility Problem          ~STRUTHERS RD / PARADISE V #     ~                    ~DWFD218903",
        "SRC:DWFD",
        "MAP:DWH5c",
        "UNIT:582,531,DWFD",
        "CALL:Utility Problem",
        "ADDR:STRUTHERS RD & PARADISE V",
        "ID:DWFD218903");

    doTest("T8",
        "[DWFD:DWH5c    ] 531,DWFD,2273~Alarm, Fire              ~701 Airman Ln             #     ~                    ~DWFD218895",
        "SRC:DWFD",
        "MAP:DWH5c",
        "UNIT:531,DWFD,2273",
        "CALL:Alarm, Fire",
        "ADDR:701 Airman Ln",
        "ID:DWFD218895");

    doTest("T9",
        "[DWFD:DWH5c    ] 531,DWFD,2273~Alarm, Fire              ~701 Airman Ln             #     ~                    ~DWFD218895",
        "SRC:DWFD",
        "MAP:DWH5c",
        "UNIT:531,DWFD,2273",
        "CALL:Alarm, Fire",
        "ADDR:701 Airman Ln",
        "ID:DWFD218895");

    doTest("T10",
        "[DWFD:DW6c     ] 511,DWFD,582~Citizen Assist/Service Ca~1135 Old Ranch Rd         #     ~                    ~DWFD218866",
        "SRC:DWFD",
        "MAP:DW6c",
        "UNIT:511,DWFD,582",
        "CALL:Citizen Assist/Service Ca",
        "ADDR:1135 Old Ranch Rd",
        "ID:DWFD218866");
   
  }
  
  @Test
  public void testHanoverFire() {

    doTest("T1",
        "[HAN FD:HAN D1] HAN1,AMR~Med-Stage                ~17050 S Peyton Hwy                  #     ~Hanover Schools Dist~HAN13-039",
        "SRC:HAN FD",
        "MAP:HAN D1",
        "UNIT:HAN1,AMR",
        "CALL:Med-Stage",
        "ADDR:17050 S Peyton Hwy",
        "PLACE:Hanover Schools Dist",
        "ID:HAN13-039");

    doTest("T2",
        "[HAN FD:HAN D1] HAN1,AMR~Med-Stage                ~12393 S Squirrel Creek Rd           #     ~                    ~HAN13-038",
        "SRC:HAN FD",
        "MAP:HAN D1",
        "UNIT:HAN1,AMR",
        "CALL:Med-Stage",
        "ADDR:12393 S Squirrel Creek Rd",
        "ID:HAN13-038");

    doTest("T3",
        "[HAN FD:HAN D4] HAN4,AMR1~Overdose / Poisoning     ~9650 Las Haciendas Pt               #     ~                    ~HAN13-037",
        "SRC:HAN FD",
        "MAP:HAN D4",
        "UNIT:HAN4,AMR1",
        "CALL:Overdose / Poisoning",
        "ADDR:9650 Las Haciendas Pt",
        "ID:HAN13-037");

    doTest("T4",
        "[HAN FD:HAN D2] FINFO,HAN2~Controlled Burn          ~20480 Wigwam Rd                     #     ~                    ~HAN13-036",
        "SRC:HAN FD",
        "MAP:HAN D2",
        "UNIT:FINFO,HAN2",
        "CALL:Controlled Burn",
        "ADDR:20480 Wigwam Rd",
        "ID:HAN13-036");

    doTest("T5",
        "[HAN FD:HAN D1] HAN,AMR~Med-Stage                ~12393 Squirrel Creek Rd             #     ~                    ~HAN13-035",
        "SRC:HAN FD",
        "MAP:HAN D1",
        "UNIT:HAN,AMR",
        "CALL:Med-Stage",
        "ADDR:12393 Squirrel Creek Rd",
        "ID:HAN13-035");

    doTest("T6",
        "[HAN FD:HAN D1] HAN1,AMR~Suicidal Check the Welfar~13865 Hobby Horse Ln                #     ~                    ~HAN13-034",
        "SRC:HAN FD",
        "MAP:HAN D1",
        "UNIT:HAN1,AMR",
        "CALL:Suicidal Check the Welfar",
        "ADDR:13865 Hobby Horse Ln",
        "ID:HAN13-034");

    doTest("T7",
        "[HAN FD:HAN D4] HAN4,AMR~Back Pain                ~20911 Boca Chica Hts                #     ~                    ~HAN13-033",
        "SRC:HAN FD",
        "MAP:HAN D4",
        "UNIT:HAN4,AMR",
        "CALL:Back Pain",
        "ADDR:20911 Boca Chica Hts",
        "ID:HAN13-033");

    doTest("T8",
        "[HAN FD:HAN D1] HAN~Alarm, Fire              ~17050 S Peyton Hwy                  #     ~Hanover Schools Dist~HAN13-032",
        "SRC:HAN FD",
        "MAP:HAN D1",
        "UNIT:HAN",
        "CALL:Alarm, Fire",
        "ADDR:17050 S Peyton Hwy",
        "PLACE:Hanover Schools Dist",
        "ID:HAN13-032");

    doTest("T9",
        "[HAN FD:HAN D1] HAN1~Med-Stage                ~17050 S Peyton Hwy                  #     ~Han Middle - 3571 os~HAN13-031",
        "SRC:HAN FD",
        "MAP:HAN D1",
        "UNIT:HAN1",
        "CALL:Med-Stage",
        "ADDR:17050 S Peyton Hwy",
        "PLACE:Han Middle - 3571 os",
        "ID:HAN13-031");

    doTest("T10",
        "[HAN FD:HAN D2] HAN2~Fire Page                ~13325 Old Pueblo Rd                 #     ~TEST ONLY Hanover FD~HAN13-030",
        "SRC:HAN FD",
        "MAP:HAN D2",
        "UNIT:HAN2",
        "CALL:Fire Page",
        "ADDR:13325 Old Pueblo Rd",
        "PLACE:TEST ONLY Hanover FD",
        "ID:HAN13-030");

    doTest("T11",
        "[HAN FD:HAN D1] HAN~Fire Page                ~17550 S Peyton Hwy                  #     ~TEST PAGE           ~HAN301776",
        "SRC:HAN FD",
        "MAP:HAN D1",
        "UNIT:HAN",
        "CALL:Fire Page",
        "ADDR:17550 S Peyton Hwy",
        "PLACE:TEST PAGE",
        "ID:HAN301776");

    doTest("T12",
        "[CSFD:220-6 ] HAN,HAN,HAN,HAN~Fire Page                     ~2739 E Las Vegas St                 #     ~CJC                 ~CSFD301775",
        "SRC:CSFD",
        "MAP:220-6",
        "UNIT:HAN,HAN,HAN,HAN",
        "CALL:Fire Page",
        "ADDR:2739 E Las Vegas St",
        "PLACE:CJC",
        "ID:CSFD301775");

  }
  
  public static void main(String[] args) {
    new COElPasoCountyParserTest().generateTests("T1");
  }
}