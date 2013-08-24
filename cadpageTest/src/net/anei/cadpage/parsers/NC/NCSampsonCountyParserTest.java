package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Sampson County, NC
Contact: "klee@intrstar.net" <klee@intrstar.net>
Sender: EMS@sampsonnc.com
System: VisionCAD

EMS:2012-013061* 2280 HOBBTON HWY* * * CLINTON* WEDGEWOOD LN* BUMPY LN* K12* * ABDOMINAL* ABDOMINAL PAIN* CSRS,EMS79* 1328A* Medical: No* Hazards:  
EMS:2012-013062* 219 W CARTER ST* * * CLINTON* BARDEN ST* BUNTING ST* L11* * BREATH DIFF* BREATHING DIFFICULTIES* CSRS,EMS75* 1379* Medical: No* Hazards: No* 02/2
EMS:2012-013047* I40 MM 343* * * NEWTON GROVE* MCLAMB RD UNDERPASS* EXIT 343 HOBBTON HWY* D11* * MVA I* MOTOR VEHICLE ACCIDENT WITH INJURIES* EMS79* 1263* Medical
EMS:2012-013001* 91 N CHURCH AVE* * * GARLAND* W THIRD ST* W FOURTH ST* T10* * CHEST PAIN* CHEST PAIN* EMS77* 1376* Medical: No* Hazards: No* *
EMS:2012-012994* 303 MARTIN LUTHER KING JR BLVD* * * CLINTON* WEEKS ST* SOUTHEAST BLVD* L12* * UNCONSCIOUS* UNCONSCIOUS/FAINTING* CSRS,EMS77* 1380* Medical: No* H
EMS:2012-012960* 120 SOUTHWOOD DR* 305A* * CLINTON* SOUTH WEST BLVD* * M12* Landmark Comment: UPDATED 01/07* BREATH DIFF* BREATHING DIFFICULTIES* CSRS,EMS75* 1380
EMS:2012-012906* 229 e MORISEY BLVD* * * CLINTON* LISBON ST* DEVANE ST* L12* * BURNS* BURNS* CSRS,EMS75* 1275* Medical: No* Hazards: No* *
EMS:2012-012904* 134 W SECOND ST* * * GARLAND* S CHURCH AVE* BROOKS AVE* T10* * SICK CALLS* SICK CALLS* 7112* 1376* Medical: No* Hazards: No* *
EMS:2012-012890* 2100 REEDSFORD RD* * * CLINTON* MELVABROOK DR* BILLY LN* M13,M14* * MVA I* MOTOR VEHICLE ACCIDENT WITH INJURIES* CSRS,EMS76,STA14* 1330* Medical: Comment: TRACT 10 OVERDOSE* OVERDOSE* CSRS,EMS71* 1284A* Medical: No* Hazards: No* *
EMS:2012-012887* 249 KAYLA LN* * * CLINTON* KING RD* KING RD* I14* Geo Comment: TRACT *10* OVERDOSE* OVERDOSE* CSRS,EMS71* 1284A* Medical: No* Hazards: No* *
EMS:2012-012877* 233 EFFIE PETERSON LN* * * ROSEBORO* PORTER RD* DEAD END* M9* * STRUCTURE FI* STRUCTURE FIRE* CSRS,EMS76* 1336* Medical: No* Hazards: No* *
EMS:2012-012839* 4056 REEDSFORD RD* * * CLINTON* HUCKLEBERRY LN* STEVE HARRIS LN* N14,N15* * CHEST PAIN* CHEST PAIN* CSRS,EMS71* 1347A* Medical: No* Hazards: No*
EMS:2012-012887* 249 KAYLA LN* * * CLINTON* KING RD* KING RD* I14* Geo Comment: TRACT 10 OVERDOSE* OVERDOSE* CSRS,EMS71* 1284A* Medical: No* Hazards: No* *
EMS:2012-012838* 1498 HAWLEY RD* * OR* DUNN* FRED TEW RD* UNION GROVE CH RD* C4* * MVA I* MOTOR VEHICLE ACCIDENT WITH INJURIES* EMS72,PVRS,Z951RT* 1254C* Medical:
EMS:2012-012833* 253 PINE OAK LN* * * DUNN* MIDWAY ELEM SCH RD* DEAD END* E6* * SICK CALLS* SICK CALLS* EMS78* 1255A* Medical: No* Hazards: No* *
EMS:2012-012830* 203 N MAIN ST* * * SALEMBURG* CLINTON ST* CHURCH ST* K6* * BREATH DIFF* BREATHING DIFFICULTIES* EMS76* 1378* Medical: No* Hazards: No* 02/26/2012
EMS:2012-012826* 939 SOUTHWEST BLVD* * TAC3* CLINTON* MARTIN LUTH KING BLV* * L12* * STRUCTURE FI* STRUCTURE FIRE* CSRS,EMS72,STA14,STA16,STA8* 1380* Medical: No*
EMS:2012-012816* 301 MAIN ST* * * NEWTON GROVE* E CIRCLE ST* N CHURCH ST* C11* Landmark Comment: UPDATED 2-02* BREATH DIFF* BREATHING DIFFICULTIES* EMS71,EMS72,NG
EMS:2012-017694* 79 ROMAY MCKOY LN* * * ROSE HILL* BILL TOWN RD* LOOPS BACK TO ITSELF* S14* Geo Comment: *24* ABDOMINAL* ABDOMINAL PAIN* EMS77* 1352A* Medical: No

Contact: Active911
Agency name: Sampson County EMS
Location: Clinton, NC, United States
Sender: EMS@sampsonnc.com
Sender: EMS@relay.dnsexit.com

EMS:2013-010747* 216 W DR MARTIN L KING JR BLVD* * * ROSEBORO* CULBRETH ST* N BROAD ST* M6* Landmark Comment: UPDATED 3/99* UNCONSCIOUS* UNCONSCIOUS/FAINTING* EMS76,RRS* 1374* Medical: No* Hazards: No* 02/21/2013 18:02:03 : pos1 : CLIFFBROW
EMS:2013-00854* 70 TODD LANE* * * DUNN* SHANE LANE* * R81* * HEADACHE*\nHEADACHE* EMS78* 1839* Medical: No* Hazards: No* *
EMS:2012-072596* 306 DR MARTIN LUTHER KING JR BLVD* * * ROSEBORO* COVIL\nAVE* * R31* * CHEST PAIN* CHEST PAIN* EMS75* 1731* Medical: No* Hazards:\nNo* *
EMS:2013-0848* 360 HAYNE STRETCH ROAD* * * ROSEBORO* WOODLAND LN*  * *CHEST\nPAIN* EMS76* 1368* Medical: No* Hazards: No* *
EMS:2012-072596* 318 RALEIGH ST* * * NEWTON GROVE* WEEKSDALE ST* NORTH\nCHURCH* R42* * SICK CALLS* SICK CALLS* EMS79* 1731* Medical: No* Hazards:\nNo* *
EMS:2013-000179* 1325 HARMONY CHURCH RD* * * CLINTON*BAKER RD * BASS LAKE\nRD* R1* * SICK CALLS* SICK CALLS* EMS76* CSR1* Medical: No* Hazards: No* *
EMS:2012-072596* 318 RALEIGH ST* * * NEWTON GROVE* WEEKSDALE ST* NORTH\nCHURCH* R42* * SICK CALLS* SICK CALLS* EMS79* 1731* Medical: No* Hazards:\nNo* *
EMS:2012-072590* 2201 WILDCAT RD* * * HARRELLS* BLAND SCH RD* BELVIN\nMAYNARD RD* W15* * SICK CALLS* SICK CALLS* EMS77* 1368* Medical: No*\nHazards: No* *
EMS:2012-072596* 318 RALEIGH ST* * * NEWTON GROVE* WEEKSDALE ST* NORTH\nCHURCH* R42* * SICK CALLS* SICK CALLS* EMS79* 1731* Medical: No* Hazards:\nNo* *
EMS:2012-072590* 2201 WILDCAT RD* * * HARRELLS* BLAND SCH RD* BELVIN\nMAYNARD RD* W15* * SICK CALLS* SICK CALLS* EMS77* 1368* Medical: No*\nHazards: No* *
EMS:2012-072596* 318 RALEIGH ST* * * NEWTON GROVE* WEEKSDALE ST* NORTH\nCHURCH* R42* * SICK CALLS* SICK CALLS* EMS79* 1731* Medical: No* Hazards:\nNo* *
EMS:2012-072596* 318 RALEIGH ST* * * NEWTON GROVE* WEEKSDALE ST* NORTH\nCHURCH* R42* * SICK CALLS* SICK CALLS* EMS79* 1731* Medical: No* Hazards:\nNo* *
EMS:2012-072596* 318 RALEIGH ST* * * NEWTON GROVE* WEEKSDALE ST* NORTH\nCHURCH* R42* * SICK CALLS* SICK CALLS* EMS79* 1731* Medical: No* Hazards:\nNo* *
EMS:2013-000179* 1325 HARMONY CHURCH RD* * * CLINTON*BAKER RD * BASS LAKE\nRD* R1* * SICK CALLS* SICK CALLS* EMS76* CSR1* Medical: No* Hazards: No* *
EMS:2013-026767* W JOHNSON ST* TAC3* * CLINTON* MCKOY ST* GIDDENS ST* L12* * GAS LEAK* GAS LEAK* ST21/ST22* 1379* Medical: No* Hazards: No* 5/9/2013 21:30:06 : pos2 : RHONDABLACKMAN Cross streets: MCKOY ST//GIDDENS ST advised strong smell o\r\n
EMS:2013-026874* 4633 N US 421 HWY* * * CLINTON* KITTY FORK RD* * J10* Place Comment: UPDATED 3/99* VEHICLE FIRE* VEHICLE FIRE* ST21/ST22* 1333* Medical: No* Hazards: No* 5/10/2013 11:57:14 AM : pos3 : TYLERCOX Cross streets: KITTY FORK RD/\r\n
EMS:2013-026874* 4633 N US 421 HWY* * * CLINTON* KITTY FORK RD* * J10* Place Comment: UPDATED 3/99* VEHICLE FIRE* VEHICLE FIRE* ST21/ST22,STA15,Z2131,Z2151* 1333* Medical: No* Hazards: No* 05/10/2013 12:03:08 : pos4 : MELISSAWESCOTT **Appen\r\n

Contact: Active911
Agency name: Roseboro Rescue  EMS
Location: Roseboro, NC, United States
Sender: EMS@sampsonnc.com

EMS:2013-011198* 1274 YELLOW SKIN RD* * * AUTRYVILLE* DEWITT WILLIAMS RD* RONNIE RD* K4* * CHEST PAIN* CHEST PAIN* 7111,RRS* 1316A* Medical: No* Hazards: No* *
EMS:2013-011171* 300 HAYNE STRETCH RD* * * AUTRYVILLE* HAYNE EXIT RD* * M4,N4* * OVERDOSE* OVERDOSE* 7111,C8,RRS* 1316* Medical: No* Hazards: No* *
EMS:2013-011120* 205 W NORTH ST* * * ROSEBORO* N WEST ST* N CHURCH ST* N6* * STAB/GUN WOU* STABBING OR GUNSHOT WOUND* EMS76,R5,RRS* 1374* Medical: No* Hazards: No* *
EMS:2013-011050* 9750 MINNIE-HALL RD* * * ROSEBORO* COOPER RD* HOLLANDTOWN RD* J6,K6* * HEART PROB* HEART PROBLEMS* EMS76,RRS* 1318* Medical: No* Hazards: No* 2/23/2013 07:22:55 : pos2 : RHONDABLACKMAN ** EMD Case Entry Finished ** Chief Co
EMS:2013-010989* 1274 YELLOW SKIN RD* * * AUTRYVILLE* DEWITT WILLIAMS RD* RONNIE RD* K4* * CHEST PAIN* CHEST PAIN* 7111,RRS* 1316A* Medical: No* Hazards: No* *
EMS:2013-010909* 705 BOONE ST* * * ROSEBORO* _* DEAD END* N6* Landmark Comment: SEE IMPORTANT NOTE IN DIRECTIONS.* SICK CALLS* SICK CALLS* EMS76,RRS* 1374* Medical: No* Hazards: No* *
EMS:2013-010862* 507 W PINEWOOD ST* * * ROSEBORO* * * * * FALLS* FALLS OR BACK INJURY* EMS76,RRS* * Medical: No* Hazards: No* *
EMS:2013-010747* 216 W DR MARTIN L KING JR BLVD* * * ROSEBORO* CULBRETH ST* N BROAD ST* M6* Landmark Comment: UPDATED 3/99* UNCONSCIOUS* UNCONSCIOUS/FAINTING* EMS76,RRS* 1374* Medical: No* Hazards: No* 02/21/2013 18:02:03 : pos1 : CLIFFBROW
EMS:2013-010704* 2883 OLD MINTZ HWY* TAC3* * ROSEBORO* DOC HIGHSMITH LN* ANDREWS CHAPEL RD* O7,P7* * GRASS/BRUSH* GRASS OR BRUSH FIRE* STA4* 1364* Medical: No* Hazards: No* *
EMS:2013-010623* 304 W DR MARTIN L KING JR BLVD* * * ROSEBORO* CULBRETH ST* N BROAD ST* M6* * SICK CALLS* SICK CALLS* EMS76,RRS* 1374* Medical: No* Hazards: No* 02/21/2013 08:58:43 : pos1 : CLIFFBROWN ** EMD Case Entry Finished ** Chief Com
EMS:2013-010607* 1052 PLEASANT UNION RD* * * ROSEBORO* FAIRCLOTH RD* OLD BRICK MILL RD* M5* Geo Comment: 680 & 989 PLEASANT UNION RD - SO RIVER* SICK CALLS* SICK CALLS* EMS76,RRS* 1338B* Medical: No* Hazards: No* *
EMS:2013-010558* 2425 AUTRY HWY* * * ROSEBORO* DOWDY RD* MICROWAVE TOWER RD* M5* * BREATH DIFF* BREATHING DIFFICULTIES* 7111,RRS* 1339* Medical: No* Hazards: No* *
EMS:2013-010542* 277 E OLD STAGE RD* * * AUTRYVILLE* HUNTERS VIEW DR* DEER RUN LN* L2* * BREATH DIFF* BREATHING DIFFICULTIES* EMS76,RRS* 1316A* Medical: No* Hazards: No* *
EMS:2013-010412* 500 S FAYETTEVILLE ST* * * SALEMBURG* MATTHEWS ST* SALEMBURG C/L* L6* * BREATH DIFF* BREATHING DIFFICULTIES* EMS76,RRS* 1378* Medical: No* Hazards: No* *
EMS:2013-010286* SHARON ST* * * ROSEBORO* PEARL ST* DEAD END* N6* Geo Comment: STREET IN EAST RIDGE MHP* HEMMORRHAGE* HEMMORRHAGE OR LACERATIONS* EMS76,RRS* 1374A* Medical: No* Hazards: No* 2/19/2013 14:43:01 : pos4 : KEVINPEARSON Cross str
EMS:2013-010238* 310 CHURCH ST* * * SALEMBURG* N FAYETTEVILLE ST* FACULTY ST* K6* * FALLS* FALLS OR BACK INJURY* EMS76,RRS* 1378* Medical: No* Hazards: No* *
EMS:2013-010211* 1422 NIXON RD* * * AUTRYVILLE* SADDLE CLUB RD* MINNIE-HALL RD* K3,K2* * CHEST PAIN* CHEST PAIN* 7111,RRS* 1316A* Medical: No* Hazards: No* *
EMS:2013-010202* 313 E HOWARD ST* * * ROSEBORO* PARK DR* PEARL ST* N6* * BREATH DIFF* BREATHING DIFFICULTIES* RRS* 1374* Medical: No* Hazards: No* *
EMS:2013-010201* 550 DILLON ST* * * ROSEBORO* ROSEBORO HWY* DEAD END* N6* * SUICIDE ATTM* SUICIDE ATTEMPTS* RRS* 1338* Medical: No* Hazards: No* *
EMS:2013-010199* 1901 N SALEMBURG HWY* * * SALEMBURG* MINN HALL/ZOAR CH RD* COOPER RD* K6,K7* * STROKE* STROKE* 7111,RRS* 1324B* Medical: No* Hazards: No* 2/18/2013 23:36:48 : pos2 : CARMENJENKINS Cross streets: MINN HALL/ZOAR CH RD//COOPER

*/

public class NCSampsonCountyParserTest extends BaseParserTest {
  
  public NCSampsonCountyParserTest() {
    setParser(new NCSampsonCountyParser(), "SAMPSON COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "EMS:2012-013061* 2280 HOBBTON HWY* * * CLINTON* WEDGEWOOD LN* BUMPY LN* K12* * ABDOMINAL* ABDOMINAL PAIN* CSRS,EMS79* 1328A* Medical: No* Hazards:  ",
        "ID:2012-013061",
        "ADDR:2280 HOBBTON HWY",
        "CITY:CLINTON",
        "X:WEDGEWOOD LN & BUMPY LN",
        "MAP:K12",
        "INFO:1328A / Medical: No / Hazards:",
        "CALL:(CLINTON) ABDOMINAL PAIN",
        "UNIT:CSRS,EMS79");

    doTest("T2",
        "EMS:2012-013062* 219 W CARTER ST* * * CLINTON* BARDEN ST* BUNTING ST* L11* * BREATH DIFF* BREATHING DIFFICULTIES* CSRS,EMS75* 1379* Medical: No* Hazards: No* 02/2",
        "ID:2012-013062",
        "ADDR:219 W CARTER ST",
        "CITY:CLINTON",
        "X:BARDEN ST & BUNTING ST",
        "MAP:L11",
        "INFO:1379 / Medical: No / Hazards: No / 02/2",
        "CALL:(CLINTON) BREATHING DIFFICULTIES",
        "UNIT:CSRS,EMS75");

    doTest("T3",
        "EMS:2012-013047* I40 MM 343* * * NEWTON GROVE* MCLAMB RD UNDERPASS* EXIT 343 HOBBTON HWY* D11* * MVA I* MOTOR VEHICLE ACCIDENT WITH INJURIES* EMS79* 1263* Medical",
        "ID:2012-013047",
        "ADDR:I-40",
        "MADDR:I 40 & MCLAMB RD UNDERPASS",
        "CITY:NEWTON GROVE",
        "PLACE:MM 343",
        "X:MCLAMB RD UNDERPASS & EXIT 343 HOBBTON HWY",
        "MAP:D11",
        "INFO:1263 / Medical",
        "CALL:(NEWTON GROVE) MOTOR VEHICLE ACCIDENT WITH INJURIES",
        "UNIT:EMS79");

    doTest("T4",
        "EMS:2012-013001* 91 N CHURCH AVE* * * GARLAND* W THIRD ST* W FOURTH ST* T10* * CHEST PAIN* CHEST PAIN* EMS77* 1376* Medical: No* Hazards: No* *",
        "ID:2012-013001",
        "ADDR:91 N CHURCH AVE",
        "CITY:GARLAND",
        "X:W THIRD ST & W FOURTH ST",
        "MAP:T10",
        "INFO:1376 / Medical: No / Hazards: No",
        "CALL:(GARLAND) CHEST PAIN",
        "UNIT:EMS77");

    doTest("T5",
        "EMS:2012-012994* 303 MARTIN LUTHER KING JR BLVD* * * CLINTON* WEEKS ST* SOUTHEAST BLVD* L12* * UNCONSCIOUS* UNCONSCIOUS/FAINTING* CSRS,EMS77* 1380* Medical: No* H",
        "ID:2012-012994",
        "ADDR:303 MARTIN LUTHER KING JR BLVD",
        "CITY:CLINTON",
        "X:WEEKS ST & SOUTHEAST BLVD",
        "MAP:L12",
        "INFO:1380 / Medical: No / H",
        "CALL:(CLINTON) UNCONSCIOUS/FAINTING",
        "UNIT:CSRS,EMS77");

    doTest("T6",
        "EMS:2012-012960* 120 SOUTHWOOD DR* 305A* * CLINTON* SOUTH WEST BLVD* * M12* Landmark Comment: UPDATED 01/07* BREATH DIFF* BREATHING DIFFICULTIES* CSRS,EMS75* 1380",
        "ID:2012-012960",
        "ADDR:120 SOUTHWOOD DR",
        "APT:305A",
        "CITY:CLINTON",
        "X:SOUTH WEST BLVD",
        "MAP:M12",
        "INFO:1380",
        "CALL:(CLINTON) BREATHING DIFFICULTIES",
        "UNIT:CSRS,EMS75");

    doTest("T7",
        "EMS:2012-012906* 229 e MORISEY BLVD* * * CLINTON* LISBON ST* DEVANE ST* L12* * BURNS* BURNS* CSRS,EMS75* 1275* Medical: No* Hazards: No* *",
        "ID:2012-012906",
        "ADDR:229 e MORISEY BLVD",
        "CITY:CLINTON",
        "X:LISBON ST & DEVANE ST",
        "MAP:L12",
        "INFO:1275 / Medical: No / Hazards: No",
        "CALL:(CLINTON) BURNS",
        "UNIT:CSRS,EMS75");

    doTest("T8",
        "EMS:2012-012904* 134 W SECOND ST* * * GARLAND* S CHURCH AVE* BROOKS AVE* T10* * SICK CALLS* SICK CALLS* 7112* 1376* Medical: No* Hazards: No* *",
        "ID:2012-012904",
        "ADDR:134 W SECOND ST",
        "CITY:GARLAND",
        "X:S CHURCH AVE & BROOKS AVE",
        "MAP:T10",
        "INFO:1376 / Medical: No / Hazards: No",
        "CALL:(GARLAND) SICK CALLS",
        "UNIT:7112");

    doTest("T9",
        "EMS:2012-012890* 2100 REEDSFORD RD* * * CLINTON* MELVABROOK DR* BILLY LN* M13,M14* * MVA I* MOTOR VEHICLE ACCIDENT WITH INJURIES* CSRS,EMS76,STA14* 1330* Medical: Comment: TRACT 10 OVERDOSE* OVERDOSE* CSRS,EMS71* 1284A* Medical: No* Hazards: No* *",
        "ID:2012-012890",
        "ADDR:2100 REEDSFORD RD",
        "CITY:CLINTON",
        "X:MELVABROOK DR & BILLY LN",
        "MAP:M13,M14",
        "INFO:1330 / Medical: Comment: TRACT 10 OVERDOSE / OVERDOSE / CSRS,EMS71 / 1284A / Medical: No / Hazards: No",
        "CALL:(CLINTON) MOTOR VEHICLE ACCIDENT WITH INJURIES",
        "UNIT:CSRS,EMS76,STA14");

    doTest("T10",
        "EMS:2012-012887* 249 KAYLA LN* * * CLINTON* KING RD* KING RD* I14* Geo Comment: TRACT *10* OVERDOSE* OVERDOSE* CSRS,EMS71* 1284A* Medical: No* Hazards: No* *",
        "ID:2012-012887",
        "ADDR:249 KAYLA LN",
        "CITY:CLINTON",
        "X:KING RD & KING RD",
        "MAP:I14",
        "INFO:TRACT *10 / 1284A / Medical: No / Hazards: No",
        "CALL:(CLINTON) OVERDOSE",
        "UNIT:CSRS,EMS71");

    doTest("T11",
        "EMS:2012-012877* 233 EFFIE PETERSON LN* * * ROSEBORO* PORTER RD* DEAD END* M9* * STRUCTURE FI* STRUCTURE FIRE* CSRS,EMS76* 1336* Medical: No* Hazards: No* *",
        "ID:2012-012877",
        "ADDR:233 EFFIE PETERSON LN",
        "CITY:ROSEBORO",
        "X:PORTER RD & DEAD END",
        "MAP:M9",
        "INFO:1336 / Medical: No / Hazards: No",
        "CALL:(ROSEBORO) STRUCTURE FIRE",
        "UNIT:CSRS,EMS76");

    doTest("T12",
        "EMS:2012-012839* 4056 REEDSFORD RD* * * CLINTON* HUCKLEBERRY LN* STEVE HARRIS LN* N14,N15* * CHEST PAIN* CHEST PAIN* CSRS,EMS71* 1347A* Medical: No* Hazards: No*",
        "ID:2012-012839",
        "ADDR:4056 REEDSFORD RD",
        "CITY:CLINTON",
        "X:HUCKLEBERRY LN & STEVE HARRIS LN",
        "MAP:N14,N15",
        "INFO:1347A / Medical: No / Hazards: No",
        "CALL:(CLINTON) CHEST PAIN",
        "UNIT:CSRS,EMS71");

    doTest("T13",
  
        "EMS:2012-012887* 249 KAYLA LN* * * CLINTON* KING RD* KING RD* I14* Geo Comment: TRACT *10* OVERDOSE* OVERDOSE* CSRS,EMS71* 1284A* Medical: No* Hazards: No* *",
        "ID:2012-012887",
        "ADDR:249 KAYLA LN",
        "CITY:CLINTON",
        "X:KING RD & KING RD",
        "MAP:I14",
        "INFO:TRACT *10 / 1284A / Medical: No / Hazards: No",
        "CALL:(CLINTON) OVERDOSE",
        "UNIT:CSRS,EMS71");

    doTest("T14",
        "EMS:2012-012838* 1498 HAWLEY RD* * OR* DUNN* FRED TEW RD* UNION GROVE CH RD* C4* * MVA I* MOTOR VEHICLE ACCIDENT WITH INJURIES* EMS72,PVRS,Z951RT* 1254C* Medical:",
        "ID:2012-012838",
        "ADDR:1498 HAWLEY RD",
        "CITY:DUNN",
        "CH:OR",
        "X:FRED TEW RD & UNION GROVE CH RD",
        "MAP:C4",
        "INFO:1254C / Medical:",
        "CALL:(DUNN) MOTOR VEHICLE ACCIDENT WITH INJURIES",
        "UNIT:EMS72,PVRS,Z951RT");

    doTest("T15",
        "EMS:2012-012833* 253 PINE OAK LN* * * DUNN* MIDWAY ELEM SCH RD* DEAD END* E6* * SICK CALLS* SICK CALLS* EMS78* 1255A* Medical: No* Hazards: No* *",
        "ID:2012-012833",
        "ADDR:253 PINE OAK LN",
        "CITY:DUNN",
        "X:MIDWAY ELEM SCH RD & DEAD END",
        "MAP:E6",
        "INFO:1255A / Medical: No / Hazards: No",
        "CALL:(DUNN) SICK CALLS",
        "UNIT:EMS78");

    doTest("T16",
        "EMS:2012-012830* 203 N MAIN ST* * * SALEMBURG* CLINTON ST* CHURCH ST* K6* * BREATH DIFF* BREATHING DIFFICULTIES* EMS76* 1378* Medical: No* Hazards: No* 02/26/2012",
        "ID:2012-012830",
        "ADDR:203 N MAIN ST",
        "CITY:SALEMBURG",
        "X:CLINTON ST & CHURCH ST",
        "MAP:K6",
        "INFO:1378 / Medical: No / Hazards: No / 02/26/2012",
        "CALL:(SALEMBURG) BREATHING DIFFICULTIES",
        "UNIT:EMS76");

    doTest("T17",
        "EMS:2012-012826* 939 SOUTHWEST BLVD* * TAC3* CLINTON* MARTIN LUTH KING BLV* * L12* * STRUCTURE FI* STRUCTURE FIRE* CSRS,EMS72,STA14,STA16,STA8* 1380* Medical: No*",
        "ID:2012-012826",
        "ADDR:939 SOUTHWEST BLVD",
        "CITY:CLINTON",
        "CH:TAC3",
        "X:MARTIN LUTH KING BLV",
        "MAP:L12",
        "INFO:1380 / Medical: No",
        "CALL:(CLINTON) STRUCTURE FIRE",
        "UNIT:CSRS,EMS72,STA14,STA16,STA8");

    doTest("T18",
        "EMS:2012-012816* 301 MAIN ST* * * NEWTON GROVE* E CIRCLE ST* N CHURCH ST* C11* Landmark Comment: UPDATED 2-02* BREATH DIFF* BREATHING DIFFICULTIES* EMS71,EMS72,NG",
        "ID:2012-012816",
        "ADDR:301 MAIN ST",
        "CITY:NEWTON GROVE",
        "X:E CIRCLE ST & N CHURCH ST",
        "MAP:C11",
        "CALL:(NEWTON GROVE) BREATHING DIFFICULTIES",
        "UNIT:EMS71,EMS72,NG");

    doTest("T19",
        "EMS:2012-017694* 79 ROMAY MCKOY LN* * * ROSE HILL* BILL TOWN RD* LOOPS BACK TO ITSELF* S14* Geo Comment: *24* ABDOMINAL* ABDOMINAL PAIN* EMS77* 1352A* Medical: No",
        "ID:2012-017694",
        "ADDR:79 ROMAY MCKOY LN",   // ROMAY MCCOY LN
        "CITY:ROSE HILL",
        "X:BILL TOWN RD & LOOPS BACK TO ITSELF",
        "MAP:S14",
        "INFO:*24 / 1352A / Medical: No",
        "CALL:(ROSE HILL) ABDOMINAL PAIN",
        "UNIT:EMS77");

  } 
  
  @Test
  public void testSampsonCountyEMS() {

    doTest("T1",
        "EMS:2013-010747* 216 W DR MARTIN L KING JR BLVD* * * ROSEBORO* CULBRETH ST* N BROAD ST* M6* Landmark Comment: UPDATED 3/99* UNCONSCIOUS* UNCONSCIOUS/FAINTING* EMS76,RRS* 1374* Medical: No* Hazards: No* 02/21/2013 18:02:03 : pos1 : CLIFFBROW",
        "ID:2013-010747",
        "ADDR:216 W DR MARTIN L KING JR BLVD",
        "CITY:ROSEBORO",
        "X:CULBRETH ST & N BROAD ST",
        "MAP:M6",
        "INFO:1374 / Medical: No / Hazards: No",
        "CALL:(ROSEBORO) UNCONSCIOUS/FAINTING",
        "DATE:02/21/2013",
        "TIME:18:02:03",
        "UNIT:EMS76,RRS");

    doTest("T2",
        "EMS:2013-00854* 70 TODD LANE* * * DUNN* SHANE LANE* * R81* * HEADACHE*\nHEADACHE* EMS78* 1839* Medical: No* Hazards: No* *",
        "ID:2013-00854",
        "ADDR:70 TODD LANE",
        "CITY:DUNN",
        "X:SHANE LANE",
        "MAP:R81",
        "INFO:1839 / Medical: No / Hazards: No",
        "CALL:(DUNN) HEADACHE",
        "UNIT:EMS78");

    doTest("T3",
        "EMS:2012-072596* 306 DR MARTIN LUTHER KING JR BLVD* * * ROSEBORO* COVIL\n" +
        "AVE* * R31* * CHEST PAIN* CHEST PAIN* EMS75* 1731* Medical: No* Hazards:\n" +
        "No* *",

        "ID:2012-072596",
        "ADDR:306 DR MARTIN LUTHER KING JR BLVD",
        "CITY:ROSEBORO",
        "X:COVIL AVE",
        "MAP:R31",
        "INFO:1731 / Medical: No / Hazards: No",
        "CALL:(ROSEBORO) CHEST PAIN",
        "UNIT:EMS75");
    
    doTest("T4",
        "EMS:2013-0848* 360 HAYNE STRETCH ROAD* * * ROSEBORO* WOODLAND LN* * * *CHEST\nPAIN* CHEST PAIN* EMS76* 1368* Medical: No* Hazards: No* *",
        "ID:2013-0848",
        "ADDR:360 HAYNE STRETCH ROAD",
        "CITY:ROSEBORO",
        "X:WOODLAND LN",
        "CALL:(ROSEBORO) CHEST PAIN",
        "UNIT:EMS76",
        "INFO:1368 / Medical: No / Hazards: No");

    doTest("T5",
        "EMS:2012-072596* 318 RALEIGH ST* * * NEWTON GROVE* WEEKSDALE ST* NORTH\n" +
        "CHURCH* R42* * SICK CALLS* SICK CALLS* EMS79* 1731* Medical: No* Hazards:\n" +
        "No* *",

        "ID:2012-072596",
        "ADDR:318 RALEIGH ST",
        "CITY:NEWTON GROVE",
        "X:WEEKSDALE ST & NORTH CHURCH",
        "MAP:R42",
        "INFO:1731 / Medical: No / Hazards: No",
        "CALL:(NEWTON GROVE) SICK CALLS",
        "UNIT:EMS79");

    doTest("T6",
        "EMS:2013-000179* 1325 HARMONY CHURCH RD* * * CLINTON*BAKER RD * BASS LAKE\n" +
        "RD* R1* * SICK CALLS* SICK CALLS* EMS76* CSR1* Medical: No* Hazards: No* *",

        "ID:2013-000179",
        "ADDR:1325 HARMONY CHURCH RD",
        "CITY:CLINTON",
        "X:BAKER RD & BASS LAKE RD",
        "MAP:R1",
        "INFO:CSR1 / Medical: No / Hazards: No",
        "CALL:(CLINTON) SICK CALLS",
        "UNIT:EMS76");

    doTest("T7",
        "EMS:2012-072596* 318 RALEIGH ST* * * NEWTON GROVE* WEEKSDALE ST* NORTH\n" +
        "CHURCH* R42* * SICK CALLS* SICK CALLS* EMS79* 1731* Medical: No* Hazards:\n" +
        "No* *",

        "ID:2012-072596",
        "ADDR:318 RALEIGH ST",
        "CITY:NEWTON GROVE",
        "X:WEEKSDALE ST & NORTH CHURCH",
        "MAP:R42",
        "INFO:1731 / Medical: No / Hazards: No",
        "CALL:(NEWTON GROVE) SICK CALLS",
        "UNIT:EMS79");

    doTest("T8",
        "EMS:2012-072590* 2201 WILDCAT RD* * * HARRELLS* BLAND SCH RD* BELVIN\n" +
        "MAYNARD RD* W15* * SICK CALLS* SICK CALLS* EMS77* 1368* Medical: No*\n" +
        "Hazards: No* *",

        "ID:2012-072590",
        "ADDR:2201 WILDCAT RD",
        "CITY:HARRELLS",
        "X:BLAND SCH RD & BELVIN MAYNARD RD",
        "MAP:W15",
        "INFO:1368 / Medical: No / Hazards: No",
        "CALL:(HARRELLS) SICK CALLS",
        "UNIT:EMS77");

    doTest("T9",
        "EMS:2012-072596* 318 RALEIGH ST* * * NEWTON GROVE* WEEKSDALE ST* NORTH\n" +
        "CHURCH* R42* * SICK CALLS* SICK CALLS* EMS79* 1731* Medical: No* Hazards:\n" +
        "No* *",

        "ID:2012-072596",
        "ADDR:318 RALEIGH ST",
        "CITY:NEWTON GROVE",
        "X:WEEKSDALE ST & NORTH CHURCH",
        "MAP:R42",
        "INFO:1731 / Medical: No / Hazards: No",
        "CALL:(NEWTON GROVE) SICK CALLS",
        "UNIT:EMS79");

    doTest("T10",
        "EMS:2012-072590* 2201 WILDCAT RD* * * HARRELLS* BLAND SCH RD* BELVIN\n" +
        "MAYNARD RD* W15* * SICK CALLS* SICK CALLS* EMS77* 1368* Medical: No*\n" +
        "Hazards: No* *",

        "ID:2012-072590",
        "ADDR:2201 WILDCAT RD",
        "CITY:HARRELLS",
        "X:BLAND SCH RD & BELVIN MAYNARD RD",
        "MAP:W15",
        "INFO:1368 / Medical: No / Hazards: No",
        "CALL:(HARRELLS) SICK CALLS",
        "UNIT:EMS77");

    doTest("T11",
        "EMS:2012-072596* 318 RALEIGH ST* * * NEWTON GROVE* WEEKSDALE ST* NORTH\n" +
        "CHURCH* R42* * SICK CALLS* SICK CALLS* EMS79* 1731* Medical: No* Hazards:\n" +
        "No* *",

        "ID:2012-072596",
        "ADDR:318 RALEIGH ST",
        "CITY:NEWTON GROVE",
        "X:WEEKSDALE ST & NORTH CHURCH",
        "MAP:R42",
        "INFO:1731 / Medical: No / Hazards: No",
        "CALL:(NEWTON GROVE) SICK CALLS",
        "UNIT:EMS79");

    doTest("T12",
        "EMS:2012-072596* 318 RALEIGH ST* * * NEWTON GROVE* WEEKSDALE ST* NORTH\n" +
        "CHURCH* R42* * SICK CALLS* SICK CALLS* EMS79* 1731* Medical: No* Hazards:\n" +
        "No* *",

        "ID:2012-072596",
        "ADDR:318 RALEIGH ST",
        "CITY:NEWTON GROVE",
        "X:WEEKSDALE ST & NORTH CHURCH",
        "MAP:R42",
        "INFO:1731 / Medical: No / Hazards: No",
        "CALL:(NEWTON GROVE) SICK CALLS",
        "UNIT:EMS79");

    doTest("T13",
        "EMS:2012-072596* 318 RALEIGH ST* * * NEWTON GROVE* WEEKSDALE ST* NORTH\n" +
        "CHURCH* R42* * SICK CALLS* SICK CALLS* EMS79* 1731* Medical: No* Hazards:\n" +
        "No* *",

        "ID:2012-072596",
        "ADDR:318 RALEIGH ST",
        "CITY:NEWTON GROVE",
        "X:WEEKSDALE ST & NORTH CHURCH",
        "MAP:R42",
        "INFO:1731 / Medical: No / Hazards: No",
        "CALL:(NEWTON GROVE) SICK CALLS",
        "UNIT:EMS79");

    doTest("T14",
        "EMS:2013-000179* 1325 HARMONY CHURCH RD* * * CLINTON*BAKER RD * BASS LAKE\n" +
        "RD* R1* * SICK CALLS* SICK CALLS* EMS76* CSR1* Medical: No* Hazards: No* *",

        "ID:2013-000179",
        "ADDR:1325 HARMONY CHURCH RD",
        "CITY:CLINTON",
        "X:BAKER RD & BASS LAKE RD",
        "MAP:R1",
        "INFO:CSR1 / Medical: No / Hazards: No",
        "CALL:(CLINTON) SICK CALLS",
        "UNIT:EMS76");

    doTest("T15",
        "EMS:2013-026767* W JOHNSON ST* TAC3* * CLINTON* MCKOY ST* GIDDENS ST* L12* * GAS LEAK* GAS LEAK* ST21/ST22* 1379* Medical: No* Hazards: No* 5/9/2013 21:30:06 : pos2 : RHONDABLACKMAN Cross streets: MCKOY ST//GIDDENS ST advised strong smell o\r\n",
        "ID:2013-026767",
        "ADDR:W JOHNSON ST",
        "MADDR:W JOHNSON ST & MCKOY ST",
        "CITY:CLINTON",
        "CH:TAC3",
        "X:MCKOY ST & GIDDENS ST",
        "MAP:L12",
        "INFO:1379 / Medical: No / Hazards: No\nadvised strong smell o",
        "CALL:(CLINTON) GAS LEAK",
        "DATE:5/9/2013",
        "TIME:21:30:06",
        "UNIT:ST21/ST22");

    doTest("T16",
        "EMS:2013-026874* 4633 N US 421 HWY* * * CLINTON* KITTY FORK RD* * J10* Place Comment: UPDATED 3/99* VEHICLE FIRE* VEHICLE FIRE* ST21/ST22* 1333* Medical: No* Hazards: No* 5/10/2013 11:57:14 AM : pos3 : TYLERCOX Cross streets: KITTY FORK RD/\r\n",
        "ID:2013-026874",
        "ADDR:4633 N US 421 HWY",
        "MADDR:4633 N US 421",
        "CITY:CLINTON",
        "X:KITTY FORK RD",
        "MAP:J10",
        "INFO:1333 / Medical: No / Hazards: No",
        "CALL:(CLINTON) VEHICLE FIRE",
        "DATE:5/10/2013",
        "TIME:11:57:14",
        "UNIT:ST21/ST22");

    doTest("T17",
        "EMS:2013-026874* 4633 N US 421 HWY* * * CLINTON* KITTY FORK RD* * J10* Place Comment: UPDATED 3/99* VEHICLE FIRE* VEHICLE FIRE* ST21/ST22,STA15,Z2131,Z2151* 1333* Medical: No* Hazards: No* 05/10/2013 12:03:08 : pos4 : MELISSAWESCOTT **Appen\r\n",
        "ID:2013-026874",
        "ADDR:4633 N US 421 HWY",
        "MADDR:4633 N US 421",
        "CITY:CLINTON",
        "X:KITTY FORK RD",
        "MAP:J10",
        "INFO:1333 / Medical: No / Hazards: No\n** Appen",
        "CALL:(CLINTON) VEHICLE FIRE",
        "DATE:05/10/2013",
        "TIME:12:03:08",
        "UNIT:ST21/ST22,STA15,Z2131,Z2151");

  }
  
  @Test
  public void testRoseboroRescueEMS() {

    doTest("T1",
        "EMS:2013-011198* 1274 YELLOW SKIN RD* * * AUTRYVILLE* DEWITT WILLIAMS RD* RONNIE RD* K4* * CHEST PAIN* CHEST PAIN* 7111,RRS* 1316A* Medical: No* Hazards: No* *",
        "ID:2013-011198",
        "ADDR:1274 YELLOW SKIN RD",
        "CITY:AUTRYVILLE",
        "X:DEWITT WILLIAMS RD & RONNIE RD",
        "MAP:K4",
        "INFO:1316A / Medical: No / Hazards: No",
        "CALL:(AUTRYVILLE) CHEST PAIN",
        "UNIT:7111,RRS");

    doTest("T2",
        "EMS:2013-011171* 300 HAYNE STRETCH RD* * * AUTRYVILLE* HAYNE EXIT RD* * M4,N4* * OVERDOSE* OVERDOSE* 7111,C8,RRS* 1316* Medical: No* Hazards: No* *",
        "ID:2013-011171",
        "ADDR:300 HAYNE STRETCH RD",
        "CITY:AUTRYVILLE",
        "X:HAYNE EXIT RD",
        "MAP:M4,N4",
        "INFO:1316 / Medical: No / Hazards: No",
        "CALL:(AUTRYVILLE) OVERDOSE",
        "UNIT:7111,C8,RRS");

    doTest("T3",
        "EMS:2013-011120* 205 W NORTH ST* * * ROSEBORO* N WEST ST* N CHURCH ST* N6* * STAB/GUN WOU* STABBING OR GUNSHOT WOUND* EMS76,R5,RRS* 1374* Medical: No* Hazards: No* *",
        "ID:2013-011120",
        "ADDR:205 W NORTH ST",
        "CITY:ROSEBORO",
        "X:N WEST ST & N CHURCH ST",
        "MAP:N6",
        "INFO:1374 / Medical: No / Hazards: No",
        "CALL:(ROSEBORO) STABBING OR GUNSHOT WOUND",
        "UNIT:EMS76,R5,RRS");

    doTest("T4",
        "EMS:2013-011050* 9750 MINNIE-HALL RD* * * ROSEBORO* COOPER RD* HOLLANDTOWN RD* J6,K6* * HEART PROB* HEART PROBLEMS* EMS76,RRS* 1318* Medical: No* Hazards: No* 2/23/2013 07:22:55 : pos2 : RHONDABLACKMAN ** EMD Case Entry Finished ** Chief Co",
        "ID:2013-011050",
        "ADDR:9750 MINNIE-HALL RD",
        "CITY:ROSEBORO",
        "X:COOPER RD & HOLLANDTOWN RD",
        "MAP:J6,K6",
        "INFO:1318 / Medical: No / Hazards: No\nChief Co",
        "CALL:(ROSEBORO) HEART PROBLEMS",
        "DATE:2/23/2013",
        "TIME:07:22:55",
        "UNIT:EMS76,RRS");

    doTest("T5",
        "EMS:2013-010989* 1274 YELLOW SKIN RD* * * AUTRYVILLE* DEWITT WILLIAMS RD* RONNIE RD* K4* * CHEST PAIN* CHEST PAIN* 7111,RRS* 1316A* Medical: No* Hazards: No* *",
        "ID:2013-010989",
        "ADDR:1274 YELLOW SKIN RD",
        "CITY:AUTRYVILLE",
        "X:DEWITT WILLIAMS RD & RONNIE RD",
        "MAP:K4",
        "INFO:1316A / Medical: No / Hazards: No",
        "CALL:(AUTRYVILLE) CHEST PAIN",
        "UNIT:7111,RRS");

    doTest("T6",
        "EMS:2013-010909* 705 BOONE ST* * * ROSEBORO* _* DEAD END* N6* Landmark Comment: SEE IMPORTANT NOTE IN DIRECTIONS.* SICK CALLS* SICK CALLS* EMS76,RRS* 1374* Medical: No* Hazards: No* *",
        "ID:2013-010909",
        "ADDR:705 BOONE ST",
        "CITY:ROSEBORO",
        "X:DEAD END",
        "MAP:N6",
        "INFO:SEE IMPORTANT NOTE IN DIRECTIONS. / 1374 / Medical: No / Hazards: No",
        "CALL:(ROSEBORO) SICK CALLS",
        "UNIT:EMS76,RRS");

    doTest("T7",
        "EMS:2013-010862* 507 W PINEWOOD ST* * * ROSEBORO* * * * * FALLS* FALLS OR BACK INJURY* EMS76,RRS* * Medical: No* Hazards: No* *",
        "ID:2013-010862",
        "ADDR:507 W PINEWOOD ST",
        "CITY:ROSEBORO",
        "INFO:Medical: No / Hazards: No",
        "CALL:(ROSEBORO) FALLS OR BACK INJURY",
        "UNIT:EMS76,RRS");

    doTest("T8",
        "EMS:2013-010747* 216 W DR MARTIN L KING JR BLVD* * * ROSEBORO* CULBRETH ST* N BROAD ST* M6* Landmark Comment: UPDATED 3/99* UNCONSCIOUS* UNCONSCIOUS/FAINTING* EMS76,RRS* 1374* Medical: No* Hazards: No* 02/21/2013 18:02:03 : pos1 : CLIFFBROW",
        "ID:2013-010747",
        "ADDR:216 W DR MARTIN L KING JR BLVD",
        "CITY:ROSEBORO",
        "X:CULBRETH ST & N BROAD ST",
        "MAP:M6",
        "INFO:1374 / Medical: No / Hazards: No",
        "CALL:(ROSEBORO) UNCONSCIOUS/FAINTING",
        "DATE:02/21/2013",
        "TIME:18:02:03",
        "UNIT:EMS76,RRS");

    doTest("T9",
        "EMS:2013-010704* 2883 OLD MINTZ HWY* TAC3* * ROSEBORO* DOC HIGHSMITH LN* ANDREWS CHAPEL RD* O7,P7* * GRASS/BRUSH* GRASS OR BRUSH FIRE* STA4* 1364* Medical: No* Hazards: No* *",
        "ID:2013-010704",
        "ADDR:2883 OLD MINTZ HWY",
        "CITY:ROSEBORO",
        "CH:TAC3",
        "X:DOC HIGHSMITH LN & ANDREWS CHAPEL RD",
        "MAP:O7,P7",
        "INFO:1364 / Medical: No / Hazards: No",
        "CALL:(ROSEBORO) GRASS OR BRUSH FIRE",
        "UNIT:STA4");

    doTest("T10",
        "EMS:2013-010623* 304 W DR MARTIN L KING JR BLVD* * * ROSEBORO* CULBRETH ST* N BROAD ST* M6* * SICK CALLS* SICK CALLS* EMS76,RRS* 1374* Medical: No* Hazards: No* 02/21/2013 08:58:43 : pos1 : CLIFFBROWN ** EMD Case Entry Finished ** Chief Com",
        "ID:2013-010623",
        "ADDR:304 W DR MARTIN L KING JR BLVD",
        "CITY:ROSEBORO",
        "X:CULBRETH ST & N BROAD ST",
        "MAP:M6",
        "INFO:1374 / Medical: No / Hazards: No\nChief Com",
        "CALL:(ROSEBORO) SICK CALLS",
        "DATE:02/21/2013",
        "TIME:08:58:43",
        "UNIT:EMS76,RRS");

    doTest("T11",
        "EMS:2013-010607* 1052 PLEASANT UNION RD* * * ROSEBORO* FAIRCLOTH RD* OLD BRICK MILL RD* M5* Geo Comment: 680 & 989 PLEASANT UNION RD - SO RIVER* SICK CALLS* SICK CALLS* EMS76,RRS* 1338B* Medical: No* Hazards: No* *",
        "ID:2013-010607",
        "ADDR:1052 PLEASANT UNION RD",
        "CITY:ROSEBORO",
        "X:FAIRCLOTH RD & OLD BRICK MILL RD",
        "MAP:M5",
        "INFO:680 & 989 PLEASANT UNION RD - SO RIVER / 1338B / Medical: No / Hazards: No",
        "CALL:(ROSEBORO) SICK CALLS",
        "UNIT:EMS76,RRS");

    doTest("T12",
        "EMS:2013-010558* 2425 AUTRY HWY* * * ROSEBORO* DOWDY RD* MICROWAVE TOWER RD* M5* * BREATH DIFF* BREATHING DIFFICULTIES* 7111,RRS* 1339* Medical: No* Hazards: No* *",
        "ID:2013-010558",
        "ADDR:2425 AUTRY HWY",
        "CITY:ROSEBORO",
        "X:DOWDY RD & MICROWAVE TOWER RD",
        "MAP:M5",
        "INFO:1339 / Medical: No / Hazards: No",
        "CALL:(ROSEBORO) BREATHING DIFFICULTIES",
        "UNIT:7111,RRS");

    doTest("T13",
        "EMS:2013-010542* 277 E OLD STAGE RD* * * AUTRYVILLE* HUNTERS VIEW DR* DEER RUN LN* L2* * BREATH DIFF* BREATHING DIFFICULTIES* EMS76,RRS* 1316A* Medical: No* Hazards: No* *",
        "ID:2013-010542",
        "ADDR:277 E OLD STAGE RD",
        "CITY:AUTRYVILLE",
        "X:HUNTERS VIEW DR & DEER RUN LN",
        "MAP:L2",
        "INFO:1316A / Medical: No / Hazards: No",
        "CALL:(AUTRYVILLE) BREATHING DIFFICULTIES",
        "UNIT:EMS76,RRS");

    doTest("T14",
        "EMS:2013-010412* 500 S FAYETTEVILLE ST* * * SALEMBURG* MATTHEWS ST* SALEMBURG C/L* L6* * BREATH DIFF* BREATHING DIFFICULTIES* EMS76,RRS* 1378* Medical: No* Hazards: No* *",
        "ID:2013-010412",
        "ADDR:500 S FAYETTEVILLE ST",
        "CITY:SALEMBURG",
        "X:MATTHEWS ST & SALEMBURG C/L",
        "MAP:L6",
        "INFO:1378 / Medical: No / Hazards: No",
        "CALL:(SALEMBURG) BREATHING DIFFICULTIES",
        "UNIT:EMS76,RRS");

    doTest("T15",
        "EMS:2013-010286* SHARON ST* * * ROSEBORO* PEARL ST* DEAD END* N6* Geo Comment: STREET IN EAST RIDGE MHP* HEMMORRHAGE* HEMMORRHAGE OR LACERATIONS* EMS76,RRS* 1374A* Medical: No* Hazards: No* 2/19/2013 14:43:01 : pos4 : KEVINPEARSON Cross str",
        "ID:2013-010286",
        "ADDR:SHARON ST",
        "MADDR:SHARON ST & PEARL ST",
        "CITY:ROSEBORO",
        "X:PEARL ST & DEAD END",
        "MAP:N6",
        "INFO:STREET IN EAST RIDGE MHP / 1374A / Medical: No / Hazards: No\nCross str",
        "CALL:(ROSEBORO) HEMMORRHAGE OR LACERATIONS",
        "DATE:2/19/2013",
        "TIME:14:43:01",
        "UNIT:EMS76,RRS");

    doTest("T16",
        "EMS:2013-010238* 310 CHURCH ST* * * SALEMBURG* N FAYETTEVILLE ST* FACULTY ST* K6* * FALLS* FALLS OR BACK INJURY* EMS76,RRS* 1378* Medical: No* Hazards: No* *",
        "ID:2013-010238",
        "ADDR:310 CHURCH ST",
        "CITY:SALEMBURG",
        "X:N FAYETTEVILLE ST & FACULTY ST",
        "MAP:K6",
        "INFO:1378 / Medical: No / Hazards: No",
        "CALL:(SALEMBURG) FALLS OR BACK INJURY",
        "UNIT:EMS76,RRS");

    doTest("T17",
        "EMS:2013-010211* 1422 NIXON RD* * * AUTRYVILLE* SADDLE CLUB RD* MINNIE-HALL RD* K3,K2* * CHEST PAIN* CHEST PAIN* 7111,RRS* 1316A* Medical: No* Hazards: No* *",
        "ID:2013-010211",
        "ADDR:1422 NIXON RD",
        "CITY:AUTRYVILLE",
        "X:SADDLE CLUB RD & MINNIE-HALL RD",
        "MAP:K3,K2",
        "INFO:1316A / Medical: No / Hazards: No",
        "CALL:(AUTRYVILLE) CHEST PAIN",
        "UNIT:7111,RRS");

    doTest("T18",
        "EMS:2013-010202* 313 E HOWARD ST* * * ROSEBORO* PARK DR* PEARL ST* N6* * BREATH DIFF* BREATHING DIFFICULTIES* RRS* 1374* Medical: No* Hazards: No* *",
        "ID:2013-010202",
        "ADDR:313 E HOWARD ST",
        "CITY:ROSEBORO",
        "X:PARK DR & PEARL ST",
        "MAP:N6",
        "INFO:1374 / Medical: No / Hazards: No",
        "CALL:(ROSEBORO) BREATHING DIFFICULTIES",
        "UNIT:RRS");

    doTest("T19",
        "EMS:2013-010201* 550 DILLON ST* * * ROSEBORO* ROSEBORO HWY* DEAD END* N6* * SUICIDE ATTM* SUICIDE ATTEMPTS* RRS* 1338* Medical: No* Hazards: No* *",
        "ID:2013-010201",
        "ADDR:550 DILLON ST",
        "CITY:ROSEBORO",
        "X:ROSEBORO HWY & DEAD END",
        "MAP:N6",
        "INFO:1338 / Medical: No / Hazards: No",
        "CALL:(ROSEBORO) SUICIDE ATTEMPTS",
        "UNIT:RRS");

    doTest("T20",
        "EMS:2013-010199* 1901 N SALEMBURG HWY* * * SALEMBURG* MINN HALL/ZOAR CH RD* COOPER RD* K6,K7* * STROKE* STROKE* 7111,RRS* 1324B* Medical: No* Hazards: No* 2/18/2013 23:36:48 : pos2 : CARMENJENKINS Cross streets: MINN HALL/ZOAR CH RD//COOPER",
        "ID:2013-010199",
        "ADDR:1901 N SALEMBURG HWY",
        "CITY:SALEMBURG",
        "X:MINN HALL/ZOAR CH RD & COOPER RD",
        "MAP:K6,K7",
        "INFO:1324B / Medical: No / Hazards: No",
        "CALL:(SALEMBURG) STROKE",
        "DATE:2/18/2013",
        "TIME:23:36:48",
        "UNIT:7111,RRS");

  }

  public static void main(String[] args) {
    new NCSampsonCountyParserTest().generateTests("T1");
  }
}
