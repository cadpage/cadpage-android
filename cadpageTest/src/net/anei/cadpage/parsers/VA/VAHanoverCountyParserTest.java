package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Hanover County, VA
Contact: brian_grimes@verizon.net
Contact: James Mayhew <kc4bpx@gmail.com>
Sender: e911@ps400.hanoverva.org

Subject:(21777) a\nUnit:E12 UnitSts: Inc#:2010-00000919 Inc:MVANoInj Loc:36 S INTERSTATE 295 MapRef:R Map 1591 VEH VS DEER, NO INJS, H
(16407]  a ) Unit:E07 UnitSts: Inc#:2012-00031976 Inc:DifBreathn Loc:7103 NEW HUNTER RD MapRef:R Map 1593 APT 1011 Addtl:DIFF BREATHING
(12716a ) Unit:E07 UnitSts: Inc#:2012-00031961 Inc:Unconscous Loc:7052 MECHANICSVILLE TP MapRef:R Map 1592 PASSED OUT Addtl:
[(7584]  a ) Unit:E07 UnitSts: Inc#:2012-00031934 Inc:VehFire Loc:MECHANICSVILLE TP/BELL CREEK MapRef:R Map 1592 Addtl:IN TURNING LANE, ON FIRE
(5677 a ) Unit:E07 UnitSts: Inc#:2012-00000667 Inc:OutSmall Loc:BELLFLOWER CR/TIFFANY MapRef:R Map 1503 Addtl:WPH2:
[(5243]  a ) Unit:E07 UnitSts: Inc#:2012-00031927 Inc:VehCrash Loc:COLD HARBOR RD/BELL CREEK MapRef:R Map 1594 3 VEH MVA, UNKNW INJURIES Addtl:ONE ON RIGHT
[(3875]  a ) Unit:E07 UnitSts: Inc#:2012-00031920 Inc:OutSmall Loc:MECHANICSVILLE TP/COLONY MapRef:R Map 1592   IN THE MEDIAN SMOKING Addtl:

Contact: support@active911.com
Agency name: Ashland Volunteer Fire Company Location: Ashland, VA 
Sender: e911@ps400.hanoverva.org

((23317) a ) Unit:SQ01 UnitSts: Inc:VehCrash Inc#:2012-00020175 Loc:99 N INTERSTATE 95 MapRef:R Map 46 Addtl:WPH2:      PLOTTING TO GET 10-50 LOCATION...
((23457) a ) Unit:E01 UnitSts: Inc:Sickness Inc#:2012-00084696 Loc:118 WINTER OAK DR MapRef:R Map 98-1 BEEN SICK SINCE LAST NIGHT,LIGHT HEADED, Addtl:BREATHING WIERD
((23568) a ) Unit:E01 UnitSts: Inc:Unknown Inc#:2012-00084697 Loc:314 MACMURDO ST MapRef:R Map 97-2 Addtl:
((23340) a ) Unit:E01 UnitSts: Inc:VehFire Inc#:2012-00020176 Loc:KINGS DOMINION BV DOMINON/INTERSTATE 95 MapRef:R Map 46 Addtl:OVERPASS AREA, L SHOULDER, WB, CAR FIRE...SMOKE...
((23274) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00020175 Loc:99 N INTERSTATE 95 MapRef:R Map 46 Addtl:WPH2:      PLOTTING TO GET 10-50 LOCATION...
((24341) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00084698 Loc:90 S INTERSTATE 95 MapRef:R Map 98-4 MVA/ RED CAR/ ON LEFT SHOULDER Addtl:
((24387) a ) Unit:E01 UnitSts: Inc:AstSrvCall Inc#:2012-00023808 Loc:HANOVER COURTHOUSE RD/PATRICK HENRY MapRef:R Map 85 TREE DOWN IN THE RDWY BLOCKING 301 Addtl:
((24764) a ) Unit:E01 UnitSts: Inc:Trauma Inc#:2012-00007175 Loc:BLUNTS BRIDGE RD/NEW FOUND MapRef:R Map 66 BICYCLE MVA // UNRESPONSIVE PT Addtl:WPH2:
((24941) a ) Unit:E01 UnitSts: Inc:ChestPain Inc#:2012-00084700 Loc:99 S CARTER RD ROOM 203 MapRef:R Map 83-3 Addtl:WPH2:  LEGS GOING NUMB, CHEST PAINS, CARDIAC HX, BACK PROBLEMS
((25899) a ) Unit:E01 UnitSts: Inc:Diabetic Inc#:2012-00084705 Loc:217 WESLEY ST MapRef:R Map 82-4 Addtl:
((26070) a ) Unit:E01 UnitSts: Inc:AlmMobile Inc#:2012-00084706 Loc:118 BROWN BARK PL MapRef:R Map 98-1 Addtl:
((26174) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00001006 Loc:501 CAROLINE ST MapRef:R Map 82-4 TRACTOR TRL HIT LAMP POLE Addtl:
((26648) a ) Unit:E01 UnitSts: Inc:AlmComm Inc#:2012-00020178 Loc:16280 INTERNATIONAL ST MapRef:R Map 46 Addtl:
((26652) a ) Unit:TK01 UnitSts: Inc:AlmComm Inc#:2012-00020178 Loc:16280 INTERNATIONAL ST MapRef:R Map 46 Addtl:
((26767) a ) Unit:TK01 UnitSts: Inc:AlmComm Inc#:2012-00050171 Loc:13264 MOUNTAIN RD MapRef:R Map 123 Addtl:
((26944) a ) Unit:E01 UnitSts: Inc:StrAplianc Inc#:2012-00045372 Loc:9416 WINDSOR SHADE DR MapRef:R Map 1271 STOVE FIRE Addtl:VOIP:
((26946) a ) Unit:TK01 UnitSts: Inc:StrAplianc Inc#:2012-00045372 Loc:9416 WINDSOR SHADE DR MapRef:R Map 1271 STOVE FIRE Addtl:VOIP:
((27098) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00020179 Loc:101.4 S INTERSTATE 95 MapRef:R Map 46 95 N CAR ROLLED OVER FROM THE SOUTHBOUND Addtl:SHOOK
((27132) a ) Unit:SQ01 UnitSts: Inc:VehCrash Inc#:2012-00020179 Loc:101.4 S INTERSTATE 95 MapRef:R Map 46 95 N CAR ROLLED OVER FROM THE SOUTHBOUND Addtl:SHOOK
((27168) a ) Unit:E01 UnitSts: Inc:Sickness Inc#:2012-00084707 Loc:12023 ASHCAKE RD MapRef:R Map 96 Addtl:
((27416) a ) Unit:TK01 UnitSts: Inc:AlmComm Inc#:2012-00050172 Loc:13264 MOUNTAIN RD MapRef:R Map 123 Addtl:
((27453) a ) Unit:E01 UnitSts: Inc:EleTrans Inc#:2012-00084709 Loc:401 CAROLINE ST MapRef:R Map 82-4 SHE LOST POWER HEARD A LOUD BANG AND SAW A Addtl:BOLT OF FIRE
((30713) a ) Unit:E01-2 UnitSts: Inc:VehCrash Inc#:2012-00084710 Loc:95.8 N INTERSTATE 95 MapRef:R Map 83-3 Addtl:
((30711) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00084710 Loc:95.8 N INTERSTATE 95 MapRef:R Map 83-3 Addtl:
((30877) a ) Unit:E01-2 UnitSts: Inc:StrResd Inc#:2012-00040216 Loc:15357 GREENWOOD CHURCH RD MapRef:R Map 63    SOCET OUTSIDE OF THE AIRCONDITING UNIT Addtl:RES :
((30946) a ) Unit:TK01 UnitSts: Inc:StrResd Inc#:2012-00040216 Loc:15357 GREENWOOD CHURCH RD MapRef:R Map 63    SOCET OUTSIDE OF THE AIRCONDITING UNIT Addtl:RES :
((31199) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00020182 Loc:101.4 S INTERSTATE 95 MapRef:R Map 46 Addtl:
((32531) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00084711 Loc:94 N INTERSTATE 95 MapRef:R Map 83-3 MALE CALLER STATING A VEH RAN OFF THE Addtl:ROAD AND DOWN IN THE WOODS//4 PEOPLE NO INJURES
((33091) a ) Unit:E01 UnitSts: Inc:MAStage Inc#:2012-00020183 Loc:203 CAROLINE ST MapRef:R Map 82-4 Addtl:
((33963) a ) Unit:E01 UnitSts: Inc:Unconscous Inc#:2012-00084714 Loc:101 JUNCTION DR MapRef:R Map 83-3 CHARLES Addtl:BUS :
((36152) a ) Unit:E01 UnitSts: Inc:Poisoning Inc#:2012-00084719 Loc:212 N JAMES ST MapRef:R Map 82-4 Addtl:
((36190) a ) Unit:E01 UnitSts: Inc:OutTransfm Inc#:2012-00084720 Loc:100 N CARTER RD MapRef:R Map 83-3 FIRE OUT ON POLE Addtl:
((36415) a ) Unit:E01 UnitSts: Inc:StrSmokOdr Inc#:2012-00050176 Loc:13418 GREENWOOD RD MapRef:R Map 112 ELECTRICAL FIRE IN THE WALL Addtl:RES :
((36955) a ) Unit:E01 UnitSts: Inc:DifBreathn Inc#:2012-00050177 Loc:13371 WINSTON RD MapRef:R Map 80 DIFF BREATHING Addtl:RES :
((37992) a ) Unit:E01 UnitSts: Inc:StrComm Inc#:2012-00007180 Loc:423 ENGLAND ST MapRef:R Map 82-4 SMELLS SMELLS SOMETHING BURNING Addtl:VOIP:
((38344) a ) Unit:TK01 UnitSts: Inc:StrComm Inc#:2012-00007180 Loc:423 ENGLAND ST MapRef:R Map 82-4 SMELLS SMELLS SOMETHING BURNING Addtl:VOIP:
((39245) a ) Unit:E01 UnitSts: Inc:GasOutside Inc#:2012-00045382 Loc:11700 NORTH LAKERIDGE PK MapRef:R Map 1152 CHECK BEHIND BUILDING REF SMELL OF GAS Addtl:
((39315) a ) Unit:TK01 UnitSts: Inc:GasOutside Inc#:2012-00045382 Loc:11700 NORTH LAKERIDGE PK MapRef:R Map 1152 CHECK BEHIND BUILDING REF SMELL OF GAS Addtl:
((40168) a ) Unit:E01 UnitSts: Inc:Fall Inc#:2012-00007181 Loc:408 EAST OMNI CT MapRef:R Map 83-3 Addtl:WPH2:   HUSBAND FALLEN WHILE COMING DOWN THE STEPS - BACK IS HURTING
((41189) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00001061 Loc:12605 W PATRICK HENRY RD MapRef:R Map 66 1 VEH OVER TURN Addtl:
((41636) a ) Unit:E01 UnitSts: Inc:OutSmall Inc#:2012-00084727 Loc:WINSTON RD/WINSTON ESTATES MapRef:R Map 80 FIELD ON FIRE, ON A DIRT ROAD Addtl:NEXT ROAD PAST THE FIRE TRAINING CENTER
((41805) a ) Unit:B01 UnitSts: Inc:OutSmall Inc#:2012-00084727 Loc:WINSTON RD/WINSTON ESTATES MapRef:R Map 80 FIELD ON FIRE, ON A DIRT ROAD Addtl:NEXT ROAD PAST THE FIRE TRAINING CENTER
((42235) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00084728 Loc:W PATRICK HENRY RD/MEDLEY GROVE MapRef:R Map 65 VEH WENT OVER THE SIDE, W/B 54 Addtl:RIGHT PAST PHHS
((42456) a ) Unit:E01 UnitSts: Inc:StrHiLife Inc#:2012-00084730 Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:
((42576) a ) Unit:TK01 UnitSts: Inc:StrHiLife Inc#:2012-00084730 Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:
((42695) a ) Unit:SQ01 UnitSts: Inc:StrHiLife Inc#:2012-00084730 Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:
((43334) a ) Unit:E01 UnitSts: Inc:AlmComm Inc#:2012-00045389 Loc:9407 KINGS CHARTER DR MapRef:R Map 1271 Addtl:
((43392) a ) Unit:TK01 UnitSts: Inc:AlmComm Inc#:2012-00045389 Loc:9407 KINGS CHARTER DR MapRef:R Map 1271 Addtl:
((45390) a ) Unit:E01 UnitSts: Inc:Sickness Inc#:2012-00084733 Loc:145 SOUTH HILL CARTER PK MapRef:R Map 98-1 REQSTNG AMBULANCE Addtl:SHEILA
((46064) a ) Unit:E01 UnitSts: Inc:ChestPain Inc#:2012-00084734 Loc:100 N CARTER RD MapRef:R Map 83-3 42 YOF C/B W/ SLIGHT CHEST PAIN, SWEATING Addtl:AT THE FUEL DESK,
((46324) a ) Unit:E01 UnitSts: Inc:Seizures Inc#:2012-00084735 Loc:11252 GWATHMEY CHURCH RD MapRef:R Map 97-3 MALIE HAVING SEIZURE Addtl:
((46514) a ) Unit:SQ01 UnitSts: Inc:VehCrash Inc#:2012-00016157 Loc:MECHANICSVILLE TP/DEER COON MapRef:R Map 1512 MVA / REQ RESCUE Addtl:
((46694) a ) Unit:E01 UnitSts: Inc:AlmComm Inc#:2012-00045393 Loc:11132 PROGRESS RD STE B MapRef:R Map 1154 Addtl:
((37882) a ) Unit:Q01 UnitSts: Inc:Unknown Inc#:2012-00043119 Loc:11182 TINSLEY DR MapRef:R Map 67 Addtl:
((37936) a ) Unit:E04 UnitSts: Inc#:2012-00001031 Inc:ProQA Loc:14199 WASHINGTON HW MapRef:R Map 68 HEAVY BLACK SMOKE Addtl:
((38154) a ) Unit:M04 UnitSts: Inc#:2012-00007180 Inc:StrComm Loc:423 ENGLAND ST MapRef:R Map 82-4 SMELLS SMELLS SOMETHING BURNING Addtl:VOIP:
((39472) a ) Unit:M04 UnitSts: Inc#:2012-00040228 Inc:Poisoning Loc:15411 ROBERT TERRELL RD MapRef:R Map 51      POSS OVERDOSE//COMBATIVE Addtl:
((50237) a ) Unit:A04 UnitSts: Inc#:2012-00020190 Inc:Assault Loc:9900 DOSWELL RD RM 131 MapRef:R Map 58 Addtl:
((39976) a ) Unit:M04 UnitSts: Inc#:2012-00001054 Inc:Sickness Loc:15102 DEARBORN DR MapRef:R Map 56 Addtl:
((40529) a ) Unit:A04 UnitSts: Inc#:2012-00014113 Inc:VehCrash Loc:VERDON RD/LANDORA BRIDGE MapRef:R Map 14 MC MAN DOWN Addtl:
((42488) a ) Unit:E04 UnitSts: Inc#:2012-00084730 Inc:StrHiLife Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:
((42693) a ) Unit:Q01 UnitSts: Inc:StrHiLife Inc#:2012-00084730 Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:
((43410) a ) Unit:Q01 UnitSts: Inc:AlmComm Inc#:2012-00045389 Loc:9407 KINGS CHARTER DR MapRef:R Map 1271 Addtl:
((43505) a ) Unit:E04 UnitSts: Inc#:2012-00045389 Inc:AlmComm Loc:9407 KINGS CHARTER DR MapRef:R Map 1271 Addtl:
((44043) a ) Unit:A04 UnitSts: Inc#:2012-00020191 Inc:Sickness Loc:11020 HEMLOCK LN MapRef:R Map 56 Addtl:
((44241) a ) Unit:A04 UnitSts: Inc#:2012-00007182 Inc:Psych Loc:101 OMNI RD MapRef:R Map 83-3 Addtl:EXTREMELY SUICIDAL CRYING ALL DAY AND ALL NIGHT
((44666) a ) Unit:A04 UnitSts: Inc#:2012-00001070 Inc:VehCrash Loc:ENGLAND ST/CARTER MapRef:R Map 83-3 2 VEH NO INJ Addtl:
((44823) a ) Unit:A04 UnitSts: Inc#:2012-00020192 Inc:ChestPain Loc:17107 ENGLISH WALNUT RD MapRef:R Map 33 WIFE IS HAVING TROUBLE BREATHING Addtl:RES :
((45368) a ) Unit:Q01 UnitSts: Inc:Sickness Inc#:2012-00084733 Loc:145 SOUTH HILL CARTER PK MapRef:R Map 98-1 REQSTNG AMBULANCE Addtl:SHEILA
((45781) a ) Unit:Q01 UnitSts: Inc:DifBreathn Inc#:2012-00045391 Loc:9300 FALCON DR MapRef:R Map 1273 Addtl:
((46307) a ) Unit:A04 UnitSts: Inc#:2012-00001072 Inc:Assault Loc:407 ENGLAND ST MapRef:R Map 82-4      YELLING SCREAMING Addtl:WPH2: SOMEONE WAS PUNCHED IN THE FACE
((46337) a ) Unit:Q01 UnitSts: Inc:Seizures Inc#:2012-00084735 Loc:11252 GWATHMEY CHURCH RD MapRef:R Map 97-3 MALIE HAVING SEIZURE Addtl:
((47409) a ) Unit:M04 UnitSts: Inc#:2012-00020193 Inc:ChestPain Loc:16000 THEME PARK WY MapRef:R Map 46 51 YOF / SVT / NO HX 194 PULSE Addtl:144/110 - MINOR CHEST PAIN / ALS AMBULANCE / NO LIGHTS OR SIRENS
((47903) a ) Unit:A04 UnitSts: Inc#:2012-00007183 Inc:Abdominal Loc:101 OMNI RD MapRef:R Map 83-3 OMNI PARK PLACE Addtl:CTX :
((48821) a ) Unit:Q01 UnitSts: Inc:ChestPain Inc#:2012-00052172 Loc:7190 HIGGINS LN MapRef:R Map 162 MOTHER CHEST PAINS,SOB Addtl:
((1151) a) Unit:TK01 UnitSts: Inc:GasResd Inc#:2012-00014217 Loc:20073 BEAVER DAM RD MapRef:R Map 7 STRONG SMELL OF GAS IN AREA OF HER BEDROOM. Addtl:THOUGHT IT WAS ORIGINALLY A SKUNK. BEEN SMELLING IT FOR HOURS
((933) a) Unit:TK01 UnitSts: Inc:StrAplianc Inc#:2012-00079140 Loc:17287 FOXCROFT LN MapRef:R Map 28 STARTED KEROSENE HEATER AND IT ISN'T Addtl:OPERATING CORRECTLY, WANTS SOMEONE TO COME PUT IT OUT

Contact: Active911
Agency name: Hanover Fire ADMIN
Location: Hanover, VA, United States

((14521) a ) Unit:FADM UnitSts: Inc:StrComm Inc#:2012-00016345 MapRef:R Map 142 Loc:4225 MECHANICSVILLE TP SOMETHING SPARKING Addtl:\r\n\r\n
((12883) a ) Unit:NUA UnitSts: Inc:ProQA Inc#:2012-00023997 MapRef:R Map 86 Loc:7501 LIBRARY DR NO AMBULANCES AVAILABLE Addtl:\r\n\r\n
((11719) a ) Unit:NUA UnitSts: Inc:No Unit Av Inc#:2012-00023996 MapRef:R Map 86 Loc:7501 LIBRARY DR NO RSQ AVAIL Addtl:\r\n\r\n

** oddball - not parsing
((23057) a) > E01|ChestPain|16355 LITTLE RIVER DR , Ashland, VA|R Map 44 |WPH2:

 */

public class VAHanoverCountyParserTest extends BaseParserTest {
  
  public VAHanoverCountyParserTest() {
    setParser(new VAHanoverCountyParser(), "HANOVER COUNTY", "VA");
  }
  
  @Test
  public void testParser() {

        doTest("T1",
            "Subject:(21777) a\n" +
            "Unit:E12 UnitSts: Inc#:2010-00000919 Inc:MVANoInj Loc:36 S INTERSTATE 295 MapRef:R Map 1591 VEH VS DEER, NO INJS, H",

            "ID:2010-00000919",
            "UNIT:E12",
            "CALL:MVANoInj",
            "ADDR:36 S INTERSTATE 295",
            "MAP:R Map 1591",
            "INFO:VEH VS DEER, NO INJS, H");

        doTest("T2",
            "(16407]  a ) Unit:E07 UnitSts: Inc#:2012-00031976 Inc:DifBreathn Loc:7103 NEW HUNTER RD MapRef:R Map 1593 APT 1011 Addtl:DIFF BREATHING",
            "ID:2012-00031976",
            "UNIT:E07",
            "CALL:DifBreathn",
            "ADDR:7103 NEW HUNTER RD",
            "MAP:R Map 1593",
            "APT:1011",
            "INFO:DIFF BREATHING");

        doTest("T3",
            "(12716a ) Unit:E07 UnitSts: Inc#:2012-00031961 Inc:Unconscous Loc:7052 MECHANICSVILLE TP MapRef:R Map 1592 PASSED OUT Addtl:",
            "ID:2012-00031961",
            "UNIT:E07",
            "CALL:Unconscous",
            "ADDR:7052 MECHANICSVILLE TP",
            "MADDR:7052 MECHANICSVILLE TPK",
            "MAP:R Map 1592",
            "INFO:PASSED OUT");

        doTest("T4",
            "[(7584]  a ) Unit:E07 UnitSts: Inc#:2012-00031934 Inc:VehFire Loc:MECHANICSVILLE TP/BELL CREEK MapRef:R Map 1592 Addtl:IN TURNING LANE, ON FIRE",
            "ID:2012-00031934",
            "UNIT:E07",
            "CALL:VehFire",
            "ADDR:MECHANICSVILLE TP & BELL CREEK",
            "MADDR:MECHANICSVILLE TPK & BELL CREEK",
            "MAP:R Map 1592",
            "INFO:IN TURNING LANE, ON FIRE");

        doTest("T5",
            "(5677 a ) Unit:E07 UnitSts: Inc#:2012-00000667 Inc:OutSmall Loc:BELLFLOWER CR/TIFFANY MapRef:R Map 1503 Addtl:WPH2:",
            "ID:2012-00000667",
            "UNIT:E07",
            "CALL:OutSmall",
            "ADDR:BELLFLOWER CR & TIFFANY",
            "MADDR:BELLFLOWER CIR & TIFFANY",
            "MAP:R Map 1503",
            "INFO:WPH2:");

        doTest("T6",
            "[(5243]  a ) Unit:E07 UnitSts: Inc#:2012-00031927 Inc:VehCrash Loc:COLD HARBOR RD/BELL CREEK MapRef:R Map 1594 3 VEH MVA, UNKNW INJURIES Addtl:ONE ON RIGHT",
            "ID:2012-00031927",
            "UNIT:E07",
            "CALL:VehCrash",
            "ADDR:COLD HARBOR RD & BELL CREEK",
            "MAP:R Map 1594",
            "INFO:3 VEH MVA, UNKNW INJURIES / ONE ON RIGHT");

        doTest("T7",
            "[(3875]  a ) Unit:E07 UnitSts: Inc#:2012-00031920 Inc:OutSmall Loc:MECHANICSVILLE TP/COLONY MapRef:R Map 1592   IN THE MEDIAN SMOKING Addtl:",
            "ID:2012-00031920",
            "UNIT:E07",
            "CALL:OutSmall",
            "ADDR:MECHANICSVILLE TP & COLONY",
            "MADDR:MECHANICSVILLE TPK & COLONY",
            "MAP:R Map 1592",
            "INFO:IN THE MEDIAN SMOKING");
   
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "((23317) a ) Unit:SQ01 UnitSts: Inc:VehCrash Inc#:2012-00020175 Loc:99 N INTERSTATE 95 MapRef:R Map 46 Addtl:WPH2:      PLOTTING TO GET 10-50 LOCATION...",
        "ID:2012-00020175",
        "UNIT:SQ01",
        "CALL:VehCrash",
        "ADDR:99 N INTERSTATE 95",
        "MAP:R Map 46",
        "INFO:WPH2:      PLOTTING TO GET 10-50 LOCATION...");

    doTest("T2",
        "((23457) a ) Unit:E01 UnitSts: Inc:Sickness Inc#:2012-00084696 Loc:118 WINTER OAK DR MapRef:R Map 98-1 BEEN SICK SINCE LAST NIGHT,LIGHT HEADED, Addtl:BREATHING WIERD",
        "ID:2012-00084696",
        "UNIT:E01",
        "CALL:Sickness",
        "ADDR:118 WINTER OAK DR",
        "MAP:R Map 98-1",
        "INFO:BEEN SICK SINCE LAST NIGHT,LIGHT HEADED / BREATHING WIERD");

    doTest("T3",
        "((23568) a ) Unit:E01 UnitSts: Inc:Unknown Inc#:2012-00084697 Loc:314 MACMURDO ST MapRef:R Map 97-2 Addtl:",
        "ID:2012-00084697",
        "UNIT:E01",
        "CALL:Unknown",
        "ADDR:314 MACMURDO ST", // Not mapping
        "MAP:R Map 97-2");

    doTest("T4",
        "((23340) a ) Unit:E01 UnitSts: Inc:VehFire Inc#:2012-00020176 Loc:KINGS DOMINION BV DOMINON/INTERSTATE 95 MapRef:R Map 46 Addtl:OVERPASS AREA, L SHOULDER, WB, CAR FIRE...SMOKE...",
        "ID:2012-00020176",
        "UNIT:E01",
        "CALL:VehFire",
        "ADDR:KINGS DOMINION BV DOMINON & INTERSTATE 95", // Not mapping - how to interpret
        "MAP:R Map 46",
        "INFO:OVERPASS AREA, L SHOULDER, WB, CAR FIRE...SMOKE...");

    doTest("T5",
        "((23274) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00020175 Loc:99 N INTERSTATE 95 MapRef:R Map 46 Addtl:WPH2:      PLOTTING TO GET 10-50 LOCATION...",
        "ID:2012-00020175",
        "UNIT:E01",
        "CALL:VehCrash",
        "ADDR:99 N INTERSTATE 95",
        "MAP:R Map 46",
        "INFO:WPH2:      PLOTTING TO GET 10-50 LOCATION...");

    doTest("T6",
        "((24341) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00084698 Loc:90 S INTERSTATE 95 MapRef:R Map 98-4 MVA/ RED CAR/ ON LEFT SHOULDER Addtl:",
        "ID:2012-00084698",
        "UNIT:E01",
        "CALL:VehCrash",
        "ADDR:90 S INTERSTATE 95",
        "MAP:R Map 98-4",
        "INFO:MVA/ RED CAR/ ON LEFT SHOULDER");

    doTest("T7",
        "((24387) a ) Unit:E01 UnitSts: Inc:AstSrvCall Inc#:2012-00023808 Loc:HANOVER COURTHOUSE RD/PATRICK HENRY MapRef:R Map 85 TREE DOWN IN THE RDWY BLOCKING 301 Addtl:",
        "ID:2012-00023808",
        "UNIT:E01",
        "CALL:AstSrvCall",
        "ADDR:HANOVER COURTHOUSE RD & PATRICK HENRY",
        "MAP:R Map 85",
        "INFO:TREE DOWN IN THE RDWY BLOCKING 301");

    doTest("T8",
        "((24764) a ) Unit:E01 UnitSts: Inc:Trauma Inc#:2012-00007175 Loc:BLUNTS BRIDGE RD/NEW FOUND MapRef:R Map 66 BICYCLE MVA // UNRESPONSIVE PT Addtl:WPH2:",
        "ID:2012-00007175",
        "UNIT:E01",
        "CALL:Trauma",
        "ADDR:BLUNTS BRIDGE RD & NEW FOUND",
        "MAP:R Map 66",
        "INFO:BICYCLE MVA // UNRESPONSIVE PT / WPH2:");

    doTest("T9",
        "((24941) a ) Unit:E01 UnitSts: Inc:ChestPain Inc#:2012-00084700 Loc:99 S CARTER RD ROOM 203 MapRef:R Map 83-3 Addtl:WPH2:  LEGS GOING NUMB, CHEST PAINS, CARDIAC HX, BACK PROBLEMS",
        "ID:2012-00084700",
        "UNIT:E01",
        "CALL:ChestPain",
        "ADDR:99 S CARTER RD",
        "APT:203",
        "MAP:R Map 83-3",
        "INFO:WPH2:  LEGS GOING NUMB, CHEST PAINS, CARDIAC HX, BACK PROBLEMS");

    doTest("T10",
        "((25899) a ) Unit:E01 UnitSts: Inc:Diabetic Inc#:2012-00084705 Loc:217 WESLEY ST MapRef:R Map 82-4 Addtl:",
        "ID:2012-00084705",
        "UNIT:E01",
        "CALL:Diabetic",
        "ADDR:217 WESLEY ST",
        "MAP:R Map 82-4");

    doTest("T11",
        "((26070) a ) Unit:E01 UnitSts: Inc:AlmMobile Inc#:2012-00084706 Loc:118 BROWN BARK PL MapRef:R Map 98-1 Addtl:",
        "ID:2012-00084706",
        "UNIT:E01",
        "CALL:AlmMobile",
        "ADDR:118 BROWN BARK PL",
        "MAP:R Map 98-1");

    doTest("T12",
        "((26174) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00001006 Loc:501 CAROLINE ST MapRef:R Map 82-4 TRACTOR TRL HIT LAMP POLE Addtl:",
        "ID:2012-00001006",
        "UNIT:E01",
        "CALL:VehCrash",
        "ADDR:501 CAROLINE ST",
        "MAP:R Map 82-4",
        "INFO:TRACTOR TRL HIT LAMP POLE");

    doTest("T13",
        "((26648) a ) Unit:E01 UnitSts: Inc:AlmComm Inc#:2012-00020178 Loc:16280 INTERNATIONAL ST MapRef:R Map 46 Addtl:",
        "ID:2012-00020178",
        "UNIT:E01",
        "CALL:AlmComm",
        "ADDR:16280 INTERNATIONAL ST",
        "MAP:R Map 46");

    doTest("T14",
        "((26652) a ) Unit:TK01 UnitSts: Inc:AlmComm Inc#:2012-00020178 Loc:16280 INTERNATIONAL ST MapRef:R Map 46 Addtl:",
        "ID:2012-00020178",
        "UNIT:TK01",
        "CALL:AlmComm",
        "ADDR:16280 INTERNATIONAL ST",
        "MAP:R Map 46");

    doTest("T15",
        "((26767) a ) Unit:TK01 UnitSts: Inc:AlmComm Inc#:2012-00050171 Loc:13264 MOUNTAIN RD MapRef:R Map 123 Addtl:",
        "ID:2012-00050171",
        "UNIT:TK01",
        "CALL:AlmComm",
        "ADDR:13264 MOUNTAIN RD",
        "MAP:R Map 123");

    doTest("T16",
        "((26944) a ) Unit:E01 UnitSts: Inc:StrAplianc Inc#:2012-00045372 Loc:9416 WINDSOR SHADE DR MapRef:R Map 1271 STOVE FIRE Addtl:VOIP:",
        "ID:2012-00045372",
        "UNIT:E01",
        "CALL:StrAplianc",
        "ADDR:9416 WINDSOR SHADE DR",
        "MAP:R Map 1271",
        "INFO:STOVE FIRE / VOIP:");

    doTest("T17",
        "((26946) a ) Unit:TK01 UnitSts: Inc:StrAplianc Inc#:2012-00045372 Loc:9416 WINDSOR SHADE DR MapRef:R Map 1271 STOVE FIRE Addtl:VOIP:",
        "ID:2012-00045372",
        "UNIT:TK01",
        "CALL:StrAplianc",
        "ADDR:9416 WINDSOR SHADE DR",
        "MAP:R Map 1271",
        "INFO:STOVE FIRE / VOIP:");

    doTest("T18",
        "((27098) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00020179 Loc:101.4 S INTERSTATE 95 MapRef:R Map 46 95 N CAR ROLLED OVER FROM THE SOUTHBOUND Addtl:SHOOK",
        "ID:2012-00020179",
        "UNIT:E01",
        "CALL:VehCrash",
        "ADDR:101.4 S INTERSTATE 95",
        "MAP:R Map 46",
        "INFO:95 N CAR ROLLED OVER FROM THE SOUTHBOUND / SHOOK");

    doTest("T19",
        "((27132) a ) Unit:SQ01 UnitSts: Inc:VehCrash Inc#:2012-00020179 Loc:101.4 S INTERSTATE 95 MapRef:R Map 46 95 N CAR ROLLED OVER FROM THE SOUTHBOUND Addtl:SHOOK",
        "ID:2012-00020179",
        "UNIT:SQ01",
        "CALL:VehCrash",
        "ADDR:101.4 S INTERSTATE 95",
        "MAP:R Map 46",
        "INFO:95 N CAR ROLLED OVER FROM THE SOUTHBOUND / SHOOK");

    doTest("T20",
        "((27168) a ) Unit:E01 UnitSts: Inc:Sickness Inc#:2012-00084707 Loc:12023 ASHCAKE RD MapRef:R Map 96 Addtl:",
        "ID:2012-00084707",
        "UNIT:E01",
        "CALL:Sickness",
        "ADDR:12023 ASHCAKE RD",
        "MAP:R Map 96");

    doTest("T21",
        "((27416) a ) Unit:TK01 UnitSts: Inc:AlmComm Inc#:2012-00050172 Loc:13264 MOUNTAIN RD MapRef:R Map 123 Addtl:",
        "ID:2012-00050172",
        "UNIT:TK01",
        "CALL:AlmComm",
        "ADDR:13264 MOUNTAIN RD",
        "MAP:R Map 123");

    doTest("T22",
        "((27453) a ) Unit:E01 UnitSts: Inc:EleTrans Inc#:2012-00084709 Loc:401 CAROLINE ST MapRef:R Map 82-4 SHE LOST POWER HEARD A LOUD BANG AND SAW A Addtl:BOLT OF FIRE",
        "ID:2012-00084709",
        "UNIT:E01",
        "CALL:EleTrans",
        "ADDR:401 CAROLINE ST",
        "MAP:R Map 82-4",
        "INFO:SHE LOST POWER HEARD A LOUD BANG AND SAW A / BOLT OF FIRE");

    doTest("T23",
        "((30713) a ) Unit:E01-2 UnitSts: Inc:VehCrash Inc#:2012-00084710 Loc:95.8 N INTERSTATE 95 MapRef:R Map 83-3 Addtl:",
        "ID:2012-00084710",
        "UNIT:E01-2",
        "CALL:VehCrash",
        "ADDR:95.8 N INTERSTATE 95",
        "MAP:R Map 83-3");

    doTest("T24",
        "((30711) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00084710 Loc:95.8 N INTERSTATE 95 MapRef:R Map 83-3 Addtl:",
        "ID:2012-00084710",
        "UNIT:E01",
        "CALL:VehCrash",
        "ADDR:95.8 N INTERSTATE 95",
        "MAP:R Map 83-3");

    doTest("T25",
        "((30877) a ) Unit:E01-2 UnitSts: Inc:StrResd Inc#:2012-00040216 Loc:15357 GREENWOOD CHURCH RD MapRef:R Map 63    SOCET OUTSIDE OF THE AIRCONDITING UNIT Addtl:RES :",
        "ID:2012-00040216",
        "UNIT:E01-2",
        "CALL:StrResd",
        "ADDR:15357 GREENWOOD CHURCH RD",
        "MAP:R Map 63",
        "INFO:SOCET OUTSIDE OF THE AIRCONDITING UNIT / RES :");

    doTest("T26",
        "((30946) a ) Unit:TK01 UnitSts: Inc:StrResd Inc#:2012-00040216 Loc:15357 GREENWOOD CHURCH RD MapRef:R Map 63    SOCET OUTSIDE OF THE AIRCONDITING UNIT Addtl:RES :",
        "ID:2012-00040216",
        "UNIT:TK01",
        "CALL:StrResd",
        "ADDR:15357 GREENWOOD CHURCH RD",
        "MAP:R Map 63",
        "INFO:SOCET OUTSIDE OF THE AIRCONDITING UNIT / RES :");

    doTest("T27",
        "((31199) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00020182 Loc:101.4 S INTERSTATE 95 MapRef:R Map 46 Addtl:",
        "ID:2012-00020182",
        "UNIT:E01",
        "CALL:VehCrash",
        "ADDR:101.4 S INTERSTATE 95",
        "MAP:R Map 46");

    doTest("T28",
        "((32531) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00084711 Loc:94 N INTERSTATE 95 MapRef:R Map 83-3 MALE CALLER STATING A VEH RAN OFF THE Addtl:ROAD AND DOWN IN THE WOODS//4 PEOPLE NO INJURES",
        "ID:2012-00084711",
        "UNIT:E01",
        "CALL:VehCrash",
        "ADDR:94 N INTERSTATE 95",
        "MAP:R Map 83-3",
        "INFO:MALE CALLER STATING A VEH RAN OFF THE / ROAD AND DOWN IN THE WOODS//4 PEOPLE NO INJURES");

    doTest("T29",
        "((33091) a ) Unit:E01 UnitSts: Inc:MAStage Inc#:2012-00020183 Loc:203 CAROLINE ST MapRef:R Map 82-4 Addtl:",
        "ID:2012-00020183",
        "UNIT:E01",
        "CALL:MAStage",
        "ADDR:203 CAROLINE ST",
        "MAP:R Map 82-4");

    doTest("T30",
        "((33963) a ) Unit:E01 UnitSts: Inc:Unconscous Inc#:2012-00084714 Loc:101 JUNCTION DR MapRef:R Map 83-3 CHARLES Addtl:BUS :",
        "ID:2012-00084714",
        "UNIT:E01",
        "CALL:Unconscous",
        "ADDR:101 JUNCTION DR",
        "MAP:R Map 83-3",
        "INFO:CHARLES / BUS :");

    doTest("T31",
        "((36152) a ) Unit:E01 UnitSts: Inc:Poisoning Inc#:2012-00084719 Loc:212 N JAMES ST MapRef:R Map 82-4 Addtl:",
        "ID:2012-00084719",
        "UNIT:E01",
        "CALL:Poisoning",
        "ADDR:212 N JAMES ST",
        "MAP:R Map 82-4");

    doTest("T32",
        "((36190) a ) Unit:E01 UnitSts: Inc:OutTransfm Inc#:2012-00084720 Loc:100 N CARTER RD MapRef:R Map 83-3 FIRE OUT ON POLE Addtl:",
        "ID:2012-00084720",
        "UNIT:E01",
        "CALL:OutTransfm",
        "ADDR:100 N CARTER RD",
        "MAP:R Map 83-3",
        "INFO:FIRE OUT ON POLE");

    doTest("T33",
        "((36415) a ) Unit:E01 UnitSts: Inc:StrSmokOdr Inc#:2012-00050176 Loc:13418 GREENWOOD RD MapRef:R Map 112 ELECTRICAL FIRE IN THE WALL Addtl:RES :",
        "ID:2012-00050176",
        "UNIT:E01",
        "CALL:StrSmokOdr",
        "ADDR:13418 GREENWOOD RD",
        "MAP:R Map 112",
        "INFO:ELECTRICAL FIRE IN THE WALL / RES :");

    doTest("T34",
        "((36955) a ) Unit:E01 UnitSts: Inc:DifBreathn Inc#:2012-00050177 Loc:13371 WINSTON RD MapRef:R Map 80 DIFF BREATHING Addtl:RES :",
        "ID:2012-00050177",
        "UNIT:E01",
        "CALL:DifBreathn",
        "ADDR:13371 WINSTON RD",
        "MAP:R Map 80",
        "INFO:DIFF BREATHING / RES :");

    doTest("T35",
        "((37992) a ) Unit:E01 UnitSts: Inc:StrComm Inc#:2012-00007180 Loc:423 ENGLAND ST MapRef:R Map 82-4 SMELLS SMELLS SOMETHING BURNING Addtl:VOIP:",
        "ID:2012-00007180",
        "UNIT:E01",
        "CALL:StrComm",
        "ADDR:423 ENGLAND ST",
        "MAP:R Map 82-4",
        "INFO:SMELLS SMELLS SOMETHING BURNING / VOIP:");

    doTest("T36",
        "((38344) a ) Unit:TK01 UnitSts: Inc:StrComm Inc#:2012-00007180 Loc:423 ENGLAND ST MapRef:R Map 82-4 SMELLS SMELLS SOMETHING BURNING Addtl:VOIP:",
        "ID:2012-00007180",
        "UNIT:TK01",
        "CALL:StrComm",
        "ADDR:423 ENGLAND ST",
        "MAP:R Map 82-4",
        "INFO:SMELLS SMELLS SOMETHING BURNING / VOIP:");

    doTest("T37",
        "((39245) a ) Unit:E01 UnitSts: Inc:GasOutside Inc#:2012-00045382 Loc:11700 NORTH LAKERIDGE PK MapRef:R Map 1152 CHECK BEHIND BUILDING REF SMELL OF GAS Addtl:",
        "ID:2012-00045382",
        "UNIT:E01",
        "CALL:GasOutside",
        "ADDR:11700 NORTH LAKERIDGE PK",    // Not mapping
        "MADDR:11700 NORTH LAKERIDGE PKWY",
        "MAP:R Map 1152",
        "INFO:CHECK BEHIND BUILDING REF SMELL OF GAS");

    doTest("T38",
        "((39315) a ) Unit:TK01 UnitSts: Inc:GasOutside Inc#:2012-00045382 Loc:11700 NORTH LAKERIDGE PK MapRef:R Map 1152 CHECK BEHIND BUILDING REF SMELL OF GAS Addtl:",
        "ID:2012-00045382",
        "UNIT:TK01",
        "CALL:GasOutside",
        "ADDR:11700 NORTH LAKERIDGE PK",
        "MADDR:11700 NORTH LAKERIDGE PKWY",
        "MAP:R Map 1152",
        "INFO:CHECK BEHIND BUILDING REF SMELL OF GAS");

    doTest("T39",
        "((40168) a ) Unit:E01 UnitSts: Inc:Fall Inc#:2012-00007181 Loc:408 EAST OMNI CT MapRef:R Map 83-3 Addtl:WPH2:   HUSBAND FALLEN WHILE COMING DOWN THE STEPS - BACK IS HURTING",
        "ID:2012-00007181",
        "UNIT:E01",
        "CALL:Fall",
        "ADDR:408 EAST OMNI CT",
        "MAP:R Map 83-3",
        "INFO:WPH2:   HUSBAND FALLEN WHILE COMING DOWN THE STEPS - BACK IS HURTING");

    doTest("T40",
        "((41189) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00001061 Loc:12605 W PATRICK HENRY RD MapRef:R Map 66 1 VEH OVER TURN Addtl:",
        "ID:2012-00001061",
        "UNIT:E01",
        "CALL:VehCrash",
        "ADDR:12605 W PATRICK HENRY RD",
        "MAP:R Map 66",
        "INFO:1 VEH OVER TURN");

    doTest("T41",
        "((41636) a ) Unit:E01 UnitSts: Inc:OutSmall Inc#:2012-00084727 Loc:WINSTON RD/WINSTON ESTATES MapRef:R Map 80 FIELD ON FIRE, ON A DIRT ROAD Addtl:NEXT ROAD PAST THE FIRE TRAINING CENTER",
        "ID:2012-00084727",
        "UNIT:E01",
        "CALL:OutSmall",
        "ADDR:WINSTON RD & WINSTON ESTATES",
        "MAP:R Map 80",
        "INFO:FIELD ON FIRE, ON A DIRT ROAD / NEXT ROAD PAST THE FIRE TRAINING CENTER");

    doTest("T42",
        "((41805) a ) Unit:B01 UnitSts: Inc:OutSmall Inc#:2012-00084727 Loc:WINSTON RD/WINSTON ESTATES MapRef:R Map 80 FIELD ON FIRE, ON A DIRT ROAD Addtl:NEXT ROAD PAST THE FIRE TRAINING CENTER",
        "ID:2012-00084727",
        "UNIT:B01",
        "CALL:OutSmall",
        "ADDR:WINSTON RD & WINSTON ESTATES",
        "MAP:R Map 80",
        "INFO:FIELD ON FIRE, ON A DIRT ROAD / NEXT ROAD PAST THE FIRE TRAINING CENTER");

    doTest("T43",
        "((42235) a ) Unit:E01 UnitSts: Inc:VehCrash Inc#:2012-00084728 Loc:W PATRICK HENRY RD/MEDLEY GROVE MapRef:R Map 65 VEH WENT OVER THE SIDE, W/B 54 Addtl:RIGHT PAST PHHS",
        "ID:2012-00084728",
        "UNIT:E01",
        "CALL:VehCrash",
        "ADDR:W PATRICK HENRY RD & MEDLEY GROVE",
        "MAP:R Map 65",
        "INFO:VEH WENT OVER THE SIDE, W/B 54 / RIGHT PAST PHHS");

    doTest("T44",
        "((42456) a ) Unit:E01 UnitSts: Inc:StrHiLife Inc#:2012-00084730 Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:",
        "ID:2012-00084730",
        "UNIT:E01",
        "CALL:StrHiLife",
        "ADDR:221 COTTAGE GREENE DR",
        "MAP:R Map 83-3",
        "INFO:GREASE FIRE / VOIP:");

    doTest("T45",
        "((42576) a ) Unit:TK01 UnitSts: Inc:StrHiLife Inc#:2012-00084730 Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:",
        "ID:2012-00084730",
        "UNIT:TK01",
        "CALL:StrHiLife",
        "ADDR:221 COTTAGE GREENE DR",   // Google things this is GREEN DR
        "MAP:R Map 83-3",
        "INFO:GREASE FIRE / VOIP:");

    doTest("T46",
        "((42695) a ) Unit:SQ01 UnitSts: Inc:StrHiLife Inc#:2012-00084730 Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:",
        "ID:2012-00084730",
        "UNIT:SQ01",
        "CALL:StrHiLife",
        "ADDR:221 COTTAGE GREENE DR",
        "MAP:R Map 83-3",
        "INFO:GREASE FIRE / VOIP:");

    doTest("T47",
        "((43334) a ) Unit:E01 UnitSts: Inc:AlmComm Inc#:2012-00045389 Loc:9407 KINGS CHARTER DR MapRef:R Map 1271 Addtl:",
        "ID:2012-00045389",
        "UNIT:E01",
        "CALL:AlmComm",
        "ADDR:9407 KINGS CHARTER DR",
        "MAP:R Map 1271");

    doTest("T48",
        "((43392) a ) Unit:TK01 UnitSts: Inc:AlmComm Inc#:2012-00045389 Loc:9407 KINGS CHARTER DR MapRef:R Map 1271 Addtl:",
        "ID:2012-00045389",
        "UNIT:TK01",
        "CALL:AlmComm",
        "ADDR:9407 KINGS CHARTER DR",
        "MAP:R Map 1271");

    doTest("T49",
        "((45390) a ) Unit:E01 UnitSts: Inc:Sickness Inc#:2012-00084733 Loc:145 SOUTH HILL CARTER PK MapRef:R Map 98-1 REQSTNG AMBULANCE Addtl:SHEILA",
        "ID:2012-00084733",
        "UNIT:E01",
        "CALL:Sickness",
        "ADDR:145 SOUTH HILL CARTER PK", // Could not identify street address
        "MADDR:145 SOUTH HILL CARTER PKWY",
        "MAP:R Map 98-1",
        "INFO:REQSTNG AMBULANCE / SHEILA");

    doTest("T50",
        "((46064) a ) Unit:E01 UnitSts: Inc:ChestPain Inc#:2012-00084734 Loc:100 N CARTER RD MapRef:R Map 83-3 42 YOF C/B W/ SLIGHT CHEST PAIN, SWEATING Addtl:AT THE FUEL DESK,",
        "ID:2012-00084734",
        "UNIT:E01",
        "CALL:ChestPain",
        "ADDR:100 N CARTER RD",
        "MAP:R Map 83-3",
        "INFO:42 YOF C/B W/ SLIGHT CHEST PAIN, SWEATING / AT THE FUEL DESK,");

    doTest("T51",
        "((46324) a ) Unit:E01 UnitSts: Inc:Seizures Inc#:2012-00084735 Loc:11252 GWATHMEY CHURCH RD MapRef:R Map 97-3 MALIE HAVING SEIZURE Addtl:",
        "ID:2012-00084735",
        "UNIT:E01",
        "CALL:Seizures",
        "ADDR:11252 GWATHMEY CHURCH RD",
        "MAP:R Map 97-3",
        "INFO:MALIE HAVING SEIZURE");

    doTest("T52",
        "((46514) a ) Unit:SQ01 UnitSts: Inc:VehCrash Inc#:2012-00016157 Loc:MECHANICSVILLE TP/DEER COON MapRef:R Map 1512 MVA / REQ RESCUE Addtl:",
        "ID:2012-00016157",
        "UNIT:SQ01",
        "CALL:VehCrash",
        "ADDR:MECHANICSVILLE TP & DEER COON",
        "MADDR:MECHANICSVILLE TPK & DEER COON",
        "MAP:R Map 1512",
        "INFO:MVA / REQ RESCUE");

    doTest("T53",
        "((46694) a ) Unit:E01 UnitSts: Inc:AlmComm Inc#:2012-00045393 Loc:11132 PROGRESS RD STE B MapRef:R Map 1154 Addtl:",
        "ID:2012-00045393",
        "UNIT:E01",
        "CALL:AlmComm",
        "ADDR:11132 PROGRESS RD",
        "APT:B",
        "MAP:R Map 1154");

    doTest("T54",
        "((37882) a ) Unit:Q01 UnitSts: Inc:Unknown Inc#:2012-00043119 Loc:11182 TINSLEY DR MapRef:R Map 67 Addtl:",
        "ID:2012-00043119",
        "UNIT:Q01",
        "CALL:Unknown",
        "ADDR:11182 TINSLEY DR",
        "MAP:R Map 67");

    doTest("T55",
        "((37936) a ) Unit:E04 UnitSts: Inc#:2012-00001031 Inc:ProQA Loc:14199 WASHINGTON HW MapRef:R Map 68 HEAVY BLACK SMOKE Addtl:",
        "ID:2012-00001031",
        "UNIT:E04",
        "CALL:ProQA",
        "ADDR:14199 WASHINGTON HW",
        "MADDR:14199 WASHINGTON HWY",
        "MAP:R Map 68",
        "INFO:HEAVY BLACK SMOKE");

    doTest("T56",
        "((38154) a ) Unit:M04 UnitSts: Inc#:2012-00007180 Inc:StrComm Loc:423 ENGLAND ST MapRef:R Map 82-4 SMELLS SMELLS SOMETHING BURNING Addtl:VOIP:",
        "ID:2012-00007180",
        "UNIT:M04",
        "CALL:StrComm",
        "ADDR:423 ENGLAND ST",
        "MAP:R Map 82-4",
        "INFO:SMELLS SMELLS SOMETHING BURNING / VOIP:");

    doTest("T57",
        "((39472) a ) Unit:M04 UnitSts: Inc#:2012-00040228 Inc:Poisoning Loc:15411 ROBERT TERRELL RD MapRef:R Map 51      POSS OVERDOSE//COMBATIVE Addtl:",
        "ID:2012-00040228",
        "UNIT:M04",
        "CALL:Poisoning",
        "ADDR:15411 ROBERT TERRELL RD",
        "MAP:R Map 51",
        "INFO:POSS OVERDOSE//COMBATIVE");

    doTest("T58",
        "((50237) a ) Unit:A04 UnitSts: Inc#:2012-00020190 Inc:Assault Loc:9900 DOSWELL RD RM 131 MapRef:R Map 58 Addtl:",
        "ID:2012-00020190",
        "UNIT:A04",
        "CALL:Assault",
        "ADDR:9900 DOSWELL RD",
        "APT:131",
        "MAP:R Map 58");

    doTest("T59",
        "((39976) a ) Unit:M04 UnitSts: Inc#:2012-00001054 Inc:Sickness Loc:15102 DEARBORN DR MapRef:R Map 56 Addtl:",
        "ID:2012-00001054",
        "UNIT:M04",
        "CALL:Sickness",
        "ADDR:15102 DEARBORN DR",
        "MAP:R Map 56");

    doTest("T60",
        "((40529) a ) Unit:A04 UnitSts: Inc#:2012-00014113 Inc:VehCrash Loc:VERDON RD/LANDORA BRIDGE MapRef:R Map 14 MC MAN DOWN Addtl:",
        "ID:2012-00014113",
        "UNIT:A04",
        "CALL:VehCrash",
        "ADDR:VERDON RD & LANDORA BRIDGE",
        "MAP:R Map 14",
        "INFO:MC MAN DOWN");

    doTest("T61",
        "((42488) a ) Unit:E04 UnitSts: Inc#:2012-00084730 Inc:StrHiLife Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:",
        "ID:2012-00084730",
        "UNIT:E04",
        "CALL:StrHiLife",
        "ADDR:221 COTTAGE GREENE DR",
        "MAP:R Map 83-3",
        "INFO:GREASE FIRE / VOIP:");

    doTest("T62",
        "((42693) a ) Unit:Q01 UnitSts: Inc:StrHiLife Inc#:2012-00084730 Loc:221 COTTAGE GREENE DR MapRef:R Map 83-3 GREASE FIRE Addtl:VOIP:",
        "ID:2012-00084730",
        "UNIT:Q01",
        "CALL:StrHiLife",
        "ADDR:221 COTTAGE GREENE DR",
        "MAP:R Map 83-3",
        "INFO:GREASE FIRE / VOIP:");

    doTest("T63",
        "((43410) a ) Unit:Q01 UnitSts: Inc:AlmComm Inc#:2012-00045389 Loc:9407 KINGS CHARTER DR MapRef:R Map 1271 Addtl:",
        "ID:2012-00045389",
        "UNIT:Q01",
        "CALL:AlmComm",
        "ADDR:9407 KINGS CHARTER DR",
        "MAP:R Map 1271");

    doTest("T64",
        "((43505) a ) Unit:E04 UnitSts: Inc#:2012-00045389 Inc:AlmComm Loc:9407 KINGS CHARTER DR MapRef:R Map 1271 Addtl:",
        "ID:2012-00045389",
        "UNIT:E04",
        "CALL:AlmComm",
        "ADDR:9407 KINGS CHARTER DR",
        "MAP:R Map 1271");

    doTest("T65",
        "((44043) a ) Unit:A04 UnitSts: Inc#:2012-00020191 Inc:Sickness Loc:11020 HEMLOCK LN MapRef:R Map 56 Addtl:",
        "ID:2012-00020191",
        "UNIT:A04",
        "CALL:Sickness",
        "ADDR:11020 HEMLOCK LN",
        "MAP:R Map 56");

    doTest("T66",
        "((44241) a ) Unit:A04 UnitSts: Inc#:2012-00007182 Inc:Psych Loc:101 OMNI RD MapRef:R Map 83-3 Addtl:EXTREMELY SUICIDAL CRYING ALL DAY AND ALL NIGHT",
        "ID:2012-00007182",
        "UNIT:A04",
        "CALL:Psych",
        "ADDR:101 OMNI RD",
        "MAP:R Map 83-3",
        "INFO:EXTREMELY SUICIDAL CRYING ALL DAY AND ALL NIGHT");

    doTest("T67",
        "((44666) a ) Unit:A04 UnitSts: Inc#:2012-00001070 Inc:VehCrash Loc:ENGLAND ST/CARTER MapRef:R Map 83-3 2 VEH NO INJ Addtl:",
        "ID:2012-00001070",
        "UNIT:A04",
        "CALL:VehCrash",
        "ADDR:ENGLAND ST & CARTER",
        "MAP:R Map 83-3",
        "INFO:2 VEH NO INJ");

    doTest("T68",
        "((44823) a ) Unit:A04 UnitSts: Inc#:2012-00020192 Inc:ChestPain Loc:17107 ENGLISH WALNUT RD MapRef:R Map 33 WIFE IS HAVING TROUBLE BREATHING Addtl:RES :",
        "ID:2012-00020192",
        "UNIT:A04",
        "CALL:ChestPain",
        "ADDR:17107 ENGLISH WALNUT RD",
        "MAP:R Map 33",
        "INFO:WIFE IS HAVING TROUBLE BREATHING / RES :");

    doTest("T69",
        "((45368) a ) Unit:Q01 UnitSts: Inc:Sickness Inc#:2012-00084733 Loc:145 SOUTH HILL CARTER PK MapRef:R Map 98-1 REQSTNG AMBULANCE Addtl:SHEILA",
        "ID:2012-00084733",
        "UNIT:Q01",
        "CALL:Sickness",
        "ADDR:145 SOUTH HILL CARTER PK",  // Not mapping, possibly CARTER RD
        "MADDR:145 SOUTH HILL CARTER PKWY",
        "MAP:R Map 98-1",
        "INFO:REQSTNG AMBULANCE / SHEILA");

    doTest("T70",
        "((45781) a ) Unit:Q01 UnitSts: Inc:DifBreathn Inc#:2012-00045391 Loc:9300 FALCON DR MapRef:R Map 1273 Addtl:",
        "ID:2012-00045391",
        "UNIT:Q01",
        "CALL:DifBreathn",
        "ADDR:9300 FALCON DR",
        "MAP:R Map 1273");

    doTest("T71",
        "((46307) a ) Unit:A04 UnitSts: Inc#:2012-00001072 Inc:Assault Loc:407 ENGLAND ST MapRef:R Map 82-4      YELLING SCREAMING Addtl:WPH2: SOMEONE WAS PUNCHED IN THE FACE",
        "ID:2012-00001072",
        "UNIT:A04",
        "CALL:Assault",
        "ADDR:407 ENGLAND ST",
        "MAP:R Map 82-4",
        "INFO:YELLING SCREAMING / WPH2: SOMEONE WAS PUNCHED IN THE FACE");

    doTest("T72",
        "((46337) a ) Unit:Q01 UnitSts: Inc:Seizures Inc#:2012-00084735 Loc:11252 GWATHMEY CHURCH RD MapRef:R Map 97-3 MALIE HAVING SEIZURE Addtl:",
        "ID:2012-00084735",
        "UNIT:Q01",
        "CALL:Seizures",
        "ADDR:11252 GWATHMEY CHURCH RD",
        "MAP:R Map 97-3",
        "INFO:MALIE HAVING SEIZURE");

    doTest("T73",
        "((47409) a ) Unit:M04 UnitSts: Inc#:2012-00020193 Inc:ChestPain Loc:16000 THEME PARK WY MapRef:R Map 46 51 YOF / SVT / NO HX 194 PULSE Addtl:144/110 - MINOR CHEST PAIN / ALS AMBULANCE / NO LIGHTS OR SIRENS",
        "ID:2012-00020193",
        "UNIT:M04",
        "CALL:ChestPain",
        "ADDR:16000 THEME PARK WY",
        "MAP:R Map 46",
        "INFO:51 YOF / SVT / NO HX 194 PULSE / 144/110 - MINOR CHEST PAIN / ALS AMBULANCE / NO LIGHTS OR SIRENS");

    doTest("T74",
        "((47903) a ) Unit:A04 UnitSts: Inc#:2012-00007183 Inc:Abdominal Loc:101 OMNI RD MapRef:R Map 83-3 OMNI PARK PLACE Addtl:CTX :",
        "ID:2012-00007183",
        "UNIT:A04",
        "CALL:Abdominal",
        "ADDR:101 OMNI RD",
        "MAP:R Map 83-3",
        "INFO:OMNI PARK PLACE / CTX :");

    doTest("T75",
        "((48821) a ) Unit:Q01 UnitSts: Inc:ChestPain Inc#:2012-00052172 Loc:7190 HIGGINS LN MapRef:R Map 162 MOTHER CHEST PAINS,SOB Addtl:",
        "ID:2012-00052172",
        "UNIT:Q01",
        "CALL:ChestPain",
        "ADDR:7190 HIGGINS LN",
        "MAP:R Map 162",
        "INFO:MOTHER CHEST PAINS,SOB");

    doTest("T76",
        "((1151) a) Unit:TK01 UnitSts: Inc:GasResd Inc#:2012-00014217 Loc:20073 BEAVER DAM RD MapRef:R Map 7 STRONG SMELL OF GAS IN AREA OF HER BEDROOM. Addtl:THOUGHT IT WAS ORIGINALLY A SKUNK. BEEN SMELLING IT FOR HOURS",
        "ID:2012-00014217",
        "UNIT:TK01",
        "CALL:GasResd",
        "MAP:R Map 7",
        "INFO:STRONG SMELL OF GAS IN AREA OF HER BEDROOM. / THOUGHT IT WAS ORIGINALLY A SKUNK. BEEN SMELLING IT FOR HOURS",
        "ADDR:20073 BEAVER DAM RD");

    doTest("T77",
        "((933) a) Unit:TK01 UnitSts: Inc:StrAplianc Inc#:2012-00079140 Loc:17287 FOXCROFT LN MapRef:R Map 28 STARTED KEROSENE HEATER AND IT ISN'T Addtl:OPERATING CORRECTLY, WANTS SOMEONE TO COME PUT IT OUT",
        "ID:2012-00079140",
        "UNIT:TK01",
        "CALL:StrAplianc",
        "MAP:R Map 28",
        "INFO:STARTED KEROSENE HEATER AND IT ISN'T / OPERATING CORRECTLY, WANTS SOMEONE TO COME PUT IT OUT",
        "ADDR:17287 FOXCROFT LN");
    
  }
  
  @Test
  public void testHanoverFire() {

    doTest("T1",
        "((14521) a ) Unit:FADM UnitSts: Inc:StrComm Inc#:2012-00016345 MapRef:R Map 142 Loc:4225 MECHANICSVILLE TP SOMETHING SPARKING Addtl:\r\n" +
        "\r\n",

        "ID:2012-00016345",
        "UNIT:FADM",
        "CALL:StrComm",
        "MAP:R Map 142",
        "ADDR:4225 MECHANICSVILLE TP",
        "MADDR:4225 MECHANICSVILLE TPK",
        "INFO:SOMETHING SPARKING");

    doTest("T2",
        "((12883) a ) Unit:NUA UnitSts: Inc:ProQA Inc#:2012-00023997 MapRef:R Map 86 Loc:7501 LIBRARY DR NO AMBULANCES AVAILABLE Addtl:\r\n" +
        "\r\n",

        "ID:2012-00023997",
        "UNIT:NUA",
        "CALL:ProQA",
        "MAP:R Map 86",
        "ADDR:7501 LIBRARY DR",
        "INFO:NO AMBULANCES AVAILABLE");

    doTest("T3",
        "((11719) a ) Unit:NUA UnitSts: Inc:No Unit Av Inc#:2012-00023996 MapRef:R Map 86 Loc:7501 LIBRARY DR NO RSQ AVAIL Addtl:\r\n\r\n",
        "ID:2012-00023996",
        "UNIT:NUA",
        "CALL:No Unit Av",
        "MAP:R Map 86",
        "ADDR:7501 LIBRARY DR",
        "INFO:NO RSQ AVAIL");

  }
  
  public static void main(String[] args) {
    new VAHanoverCountyParserTest().generateTests("T1");
  }
}