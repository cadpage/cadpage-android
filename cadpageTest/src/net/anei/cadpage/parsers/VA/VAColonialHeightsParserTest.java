package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Colonial Heights, VA
Contact: Active911
Agency name: Colonial Heights Fire and EMS
Location: Colonial Heights, VA, United States
Sender: comm-page@colonialheightsva.gov

(from CHECC) 13-025406 MEDICAL CALL \n Reported: 07/29/2013 19:51:22 \n 112-H CLEARFIELD CIR \n DUNLOP FARMS BLVD / DUNLOP FARMS BLVD \n COLONIAL HEIGHTS \n MED3 \n \n 
(from CHECC) 13-025383 ACTIVE SEIZURE \n Reported: 07/29/2013 15:37:06 \n 400-C SOUTHPARK BLVD \n I-95 OVERPASS /  E ROSLYN RD \n KOOL SMILES  COLONIAL HEIGHTS \n E1 MED1 \n \n 
(from CHECC) 13-025377 FIRE ALARM W/O WATER FLOW \n Reported: 07/29/2013 15:02:52 \n 2701 BOULEVARD \n NEWCASTLE DR /  ESSEX RD \n HOPE UNITY FREEDOM CENTER  COLONIAL HEIGHTS \n QNT2 \n \n 
(from CHECC) 13-025374 BLEEDING \n Reported: 07/29/2013 14:49:57 \n 100-A HIGHLAND AVE \n 1400-BLK BOULEVARD /  ALLEY \n COLONIAL HEIGHTS POLICE DEPT  COLONIAL HEIGHTS \n MED1 \n \n 
(from CHECC) 13-025369 ALARM WITH WATER FLOW \n Reported: 07/29/2013 14:00:41 \n 1156 TEMPLE AVE \n SOUTHPARK BLVD / CHARLES DIMMOCK PKWY \n BUFFALO WILD WINGS  COLONIAL HEIGHTS \n BAT2 E1 FIREV QNT2 SD2 \n \n 
(from CHECC) 13-025364 MENTAL PERSON \n Reported: 07/29/2013 12:41:10 \n 412 HILLCREST AVE \n ROSS AVE / DEAD END EN \n COLONIAL HEIGHTS \n 213 218 MED3 \n \n 
(from CHECC) 13-025349 PUBLIC SERVICE FOR A FIRE ENG \n Reported: 07/29/2013 09:48:28 \n 151 ARCHER AVE \n 100 BLK OF BLVD /  HILLSIDE DR \n APPAMATUCK PARK (ARCHER PARK)  COLONIAL HEIGHTS \n QNT2 \n \n 
(from CHECC) 13-025345 DIFFICULTY BREATHING \n Reported: 07/29/2013 09:16:17 \n 900 HAMILTON AVE \n LYNCHBURG AVE / E WESTOVER AVE \n COLONIAL HEIGHTS \n QNT2 \n \n 
(from CHECC) 13-025343 DIFFICULTY BREATHING \n Reported: 07/29/2013 09:12:26 \n 101 HOMESTEAD DR \n FORESTVIEW DR / BROOKHILL AVE \n COLONIAL HEIGHTS \n MED2 \n \n 
(from CHECC) 13-025337 DIFFICULTY BREATHING \n Reported: 07/29/2013 08:24:26 \n 2102 SNEAD AVE \n ELLIS LN / CRESTWOOD DR \n WILKINSON,GROVER  COLONIAL HEIGHTS \n MED1 \n \n 
(from CHECC) 13-025334 HEART ATTACK \n Reported: 07/29/2013 08:02:00 \n 423 ELLERSLIE AVE \n RR TRACKS / OLD TOWN DR \n COLONIAL HEIGHTS \n MED3 QNT2 \n \n 
(from CHECC) 13-025331 DIABETIC REACTION \n Reported: 07/29/2013 05:00:45 \n 831 ELLERSLIE AVE \n BENT OAKS DR / I-95 BRIDGE \n COLONIAL HEIGHTS HEALTH CARE & REHAB CTR  COLONIAL HEIGHTS \n MED3 \n \n 
(from CHECC) 13-025328 INJURED PERSON \n Reported: 07/29/2013 00:59:27 \n 100-A HIGHLAND AVE \n 1400-BLK BOULEVARD /  ALLEY \n COLONIAL HEIGHTS POLICE DEPT  COLONIAL HEIGHTS \n MED1 \n \n 
(from CHECC) 13-025324 UNRESPONSIVE PERSON \n Reported: 07/28/2013 23:38:00 \n 5100 CONDUIT RD \n HUNTINGTON RD / PEACE CLIFF CT \n COLONIAL HEIGHTS \n 216 231 MED3 QNT2 \n \n 
(from CHECC) 13-025324 STROKE \n Reported: 07/28/2013 23:38:00 \n 5100 CONDUIT RD \n HUNTINGTON RD / PEACE CLIFF CT \n COLONIAL HEIGHTS \n MED3 \n \n 
(from CHECC) 13-025313 SMOKE DETECTOR ACT. - NO SMOKE \n Reported: 07/28/2013 21:56:42 \n 808 FORESTVIEW DR \n NOTTINGHAM DR /  SHERWOOD DR \n 808 FORESTVIEW DR *SEE ALERT*  COLONIAL HEIGHTS \n QNT2 \n \n 
(from CHECC) 13-025272 SEIZURES \n Reported: 07/28/2013 14:35:24 \n 3107-15 BOULEVARD \n LAKEVIEW AVE /  ELLERSLIE AVE \n MARTIN'S FOOD MARKET & PHARMACY  COLONIAL HEIGHTS \n MED3 \n \n 
(from CHECC) 13-025264 FIRE ALARM W/O WATER FLOW \n Reported: 07/28/2013 12:19:49 \n 235 DUNLOP FARMS BLVD \n CLAIRMONT CT / OLD OAK LN \n DUNLOP HOUSE  COLONIAL HEIGHTS \n BAT1 QNT2 SD2 \n \n 
(from CHECC) 13-025263 FIRE ALARM W/O WATER FLOW \n Reported: 07/28/2013 12:19:21 \n 840 W ROSLYN RD \n I-95 / CONDUIT RD \n MEDALLION POOLS  COLONIAL HEIGHTS \n E1 \n \n 
(from CHECC) 13-025255 MEDICAL CALL \n Reported: 07/28/2013 10:08:09 \n 3110 GREENWOOD AVE \n OAKWOOD DR /  YACHT BASIN DR \n MT PLEASANT BAPTIST CHURCH  COLONIAL HEIGHTS \n MED3 \n \n 
(from CHECC) 13-025248 OVERDOSE \n Reported: 07/28/2013 08:03:56 \n 716 HAMILTON AVE \n LYNCHBURG AVE / E WESTOVER AVE \n COLONIAL HEIGHTS \n 243 MED1 \n \n 
(from CHECC) 13-025244 MUTUAL AID FOR A FIRE ENGINE \n Reported: 07/28/2013 06:20:13 \n 115 FLINTLOCK DR \n SWIFT CR / DEAD END EN \n CHESTERFIELD \n QNT2 \n \n 
(from CHECC) 13-025236 DIFFICULTY BREATHING \n Reported: 07/28/2013 00:55:14 \n 101 ESSEX DR \n 2700 BLK BLVD / HAMPTON DR \n COLONIAL HEIGHTS \n MED3 \n \n 
(from CHECC) 13-025184 MUTUAL AID FOR AN AMBULANCE \n Reported: 07/27/2013 17:00:48 \n 3111 JACKSON FARM RD \n MED1 \n \n 
(from CHECC) 13-025172 FIRE ALARM W/O WATER FLOW \n Reported: 07/27/2013 15:41:41 \n 3245 BOULEVARD \n BEECHWOOD AVE / SHERWOOD DR \n VICTORY LANE AUTO SALES  COLONIAL HEIGHTS \n QNT2 \n \n 
(from CHECC) 13-025171 HEART RELATED PROBLEM \n Reported: 07/27/2013 15:36:37 \n 1211 CANTERBURY LN \n CEDARWOOD AVE / DUKE OF GLOUCESTER \n COLONIAL HEIGHTS \n MED3 \n \n 
(from CHECC) 13-025164 INJURED PERSON \n Reported: 07/27/2013 12:56:28 \n 401 TASWELL AVE \n VANCE AVE /  WOODLAWN AVE \n LAKEVIEW ELEMENTARY SCHOOL  COLONIAL HEIGHTS \n MED3 \n \n 
(from CHECC) 13-025150 INJURED PERSON \n Reported: 07/27/2013 10:45:26 \n 1823 SOUTHPARK BLVD \n SOUTHPARK CIR /  SOUTHPARK CIR \n GOLD'S GYM  COLONIAL HEIGHTS \n MED3 \n \n 
(from CHECC) 13-025151 UNCONSCIOUS PERSON \n Reported: 07/27/2013 10:46:03 \n 721 SOUTHPARK BLVD \n CHARLES DIMMOCK PKWY /  SOUTHPARK CIR \n TARGET  COLONIAL HEIGHTS \n E1 MED1 \n \n 
(from CHECC) 13-025147 SMELL OF NAT. GAS OUTSIDE \n Reported: 07/27/2013 09:30:36 \n BOULEVARD/ DUPUY AVE \n COLONIAL HEIGHTS \n E1 \n \n 

*/
public class VAColonialHeightsParserTest extends BaseParserTest {
  
  public VAColonialHeightsParserTest() {
    setParser(new VAColonialHeightsParser(), "COLONIAL HEIGHTS", "VA");
  }
  
  @Test
  public void testColonialHeightsFireAndEMS() {

    doTest("T1",
        "(from CHECC) 13-025406 MEDICAL CALL \n" +
        " Reported: 07/29/2013 19:51:22 \n" +
        " 112-H CLEARFIELD CIR \n" +
        " DUNLOP FARMS BLVD / DUNLOP FARMS BLVD \n" +
        " COLONIAL HEIGHTS \n" +
        " MED3 \n" +
        " \n" +
        " ",

        "ID:13-025406",
        "CALL:MEDICAL CALL",
        "DATE:07/29/2013",
        "TIME:19:51:22",
        "ADDR:112-H CLEARFIELD CIR",
        "MADDR:112 CLEARFIELD CIR",
        "X:DUNLOP FARMS BLVD / DUNLOP FARMS BLVD",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:MED3");

    doTest("T2",
        "(from CHECC) 13-025383 ACTIVE SEIZURE \n" +
        " Reported: 07/29/2013 15:37:06 \n" +
        " 400-C SOUTHPARK BLVD \n" +
        " I-95 OVERPASS /  E ROSLYN RD \n" +
        " KOOL SMILES  COLONIAL HEIGHTS \n" +
        " E1 MED1 \n" +
        " \n" +
        " ",

        "ID:13-025383",
        "CALL:ACTIVE SEIZURE",
        "DATE:07/29/2013",
        "TIME:15:37:06",
        "ADDR:400-C SOUTHPARK BLVD",
        "MADDR:400 SOUTHPARK BLVD",
        "X:I-95 OVERPASS /  E ROSLYN RD",
        "PLACE:KOOL SMILES",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:E1 MED1");

    doTest("T3",
        "(from CHECC) 13-025377 FIRE ALARM W/O WATER FLOW \n" +
        " Reported: 07/29/2013 15:02:52 \n" +
        " 2701 BOULEVARD \n" +
        " NEWCASTLE DR /  ESSEX RD \n" +
        " HOPE UNITY FREEDOM CENTER  COLONIAL HEIGHTS \n" +
        " QNT2 \n" +
        " \n" +
        " ",

        "ID:13-025377",
        "CALL:FIRE ALARM W/O WATER FLOW",
        "DATE:07/29/2013",
        "TIME:15:02:52",
        "ADDR:2701 BOULEVARD",
        "X:NEWCASTLE DR /  ESSEX RD",
        "PLACE:HOPE UNITY FREEDOM CENTER",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:QNT2");

    doTest("T4",
        "(from CHECC) 13-025374 BLEEDING \n" +
        " Reported: 07/29/2013 14:49:57 \n" +
        " 100-A HIGHLAND AVE \n" +
        " 1400-BLK BOULEVARD /  ALLEY \n" +
        " COLONIAL HEIGHTS POLICE DEPT  COLONIAL HEIGHTS \n" +
        " MED1 \n" +
        " \n" +
        " ",

        "ID:13-025374",
        "CALL:BLEEDING",
        "DATE:07/29/2013",
        "TIME:14:49:57",
        "ADDR:100-A HIGHLAND AVE",
        "MADDR:100 HIGHLAND AVE",
        "X:1400-BLK BOULEVARD /  ALLEY",
        "PLACE:COLONIAL HEIGHTS POLICE DEPT",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:MED1");

    doTest("T5",
        "(from CHECC) 13-025369 ALARM WITH WATER FLOW \n" +
        " Reported: 07/29/2013 14:00:41 \n" +
        " 1156 TEMPLE AVE \n" +
        " SOUTHPARK BLVD / CHARLES DIMMOCK PKWY \n" +
        " BUFFALO WILD WINGS  COLONIAL HEIGHTS \n" +
        " BAT2 E1 FIREV QNT2 SD2 \n" +
        " \n" +
        " ",

        "ID:13-025369",
        "CALL:ALARM WITH WATER FLOW",
        "DATE:07/29/2013",
        "TIME:14:00:41",
        "ADDR:1156 TEMPLE AVE",
        "X:SOUTHPARK BLVD / CHARLES DIMMOCK PKWY",
        "PLACE:BUFFALO WILD WINGS",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:BAT2 E1 FIREV QNT2 SD2");

    doTest("T6",
        "(from CHECC) 13-025364 MENTAL PERSON \n" +
        " Reported: 07/29/2013 12:41:10 \n" +
        " 412 HILLCREST AVE \n" +
        " ROSS AVE / DEAD END EN \n" +
        " COLONIAL HEIGHTS \n" +
        " 213 218 MED3 \n" +
        " \n" +
        " ",

        "ID:13-025364",
        "CALL:MENTAL PERSON",
        "DATE:07/29/2013",
        "TIME:12:41:10",
        "ADDR:412 HILLCREST AVE",
        "X:ROSS AVE / DEAD END EN",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:213 218 MED3");

    doTest("T7",
        "(from CHECC) 13-025349 PUBLIC SERVICE FOR A FIRE ENG \n" +
        " Reported: 07/29/2013 09:48:28 \n" +
        " 151 ARCHER AVE \n" +
        " 100 BLK OF BLVD /  HILLSIDE DR \n" +
        " APPAMATUCK PARK (ARCHER PARK)  COLONIAL HEIGHTS \n" +
        " QNT2 \n" +
        " \n" +
        " ",

        "ID:13-025349",
        "CALL:PUBLIC SERVICE FOR A FIRE ENG",
        "DATE:07/29/2013",
        "TIME:09:48:28",
        "ADDR:151 ARCHER AVE",
        "X:100 BLK OF BLVD /  HILLSIDE DR",
        "PLACE:APPAMATUCK PARK (ARCHER PARK)",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:QNT2");

    doTest("T8",
        "(from CHECC) 13-025345 DIFFICULTY BREATHING \n" +
        " Reported: 07/29/2013 09:16:17 \n" +
        " 900 HAMILTON AVE \n" +
        " LYNCHBURG AVE / E WESTOVER AVE \n" +
        " COLONIAL HEIGHTS \n" +
        " QNT2 \n" +
        " \n" +
        " ",

        "ID:13-025345",
        "CALL:DIFFICULTY BREATHING",
        "DATE:07/29/2013",
        "TIME:09:16:17",
        "ADDR:900 HAMILTON AVE",
        "X:LYNCHBURG AVE / E WESTOVER AVE",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:QNT2");

    doTest("T9",
        "(from CHECC) 13-025343 DIFFICULTY BREATHING \n" +
        " Reported: 07/29/2013 09:12:26 \n" +
        " 101 HOMESTEAD DR \n" +
        " FORESTVIEW DR / BROOKHILL AVE \n" +
        " COLONIAL HEIGHTS \n" +
        " MED2 \n" +
        " \n" +
        " ",

        "ID:13-025343",
        "CALL:DIFFICULTY BREATHING",
        "DATE:07/29/2013",
        "TIME:09:12:26",
        "ADDR:101 HOMESTEAD DR",
        "X:FORESTVIEW DR / BROOKHILL AVE",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:MED2");

    doTest("T10",
        "(from CHECC) 13-025337 DIFFICULTY BREATHING \n" +
        " Reported: 07/29/2013 08:24:26 \n" +
        " 2102 SNEAD AVE \n" +
        " ELLIS LN / CRESTWOOD DR \n" +
        " WILKINSON,GROVER  COLONIAL HEIGHTS \n" +
        " MED1 \n" +
        " \n" +
        " ",

        "ID:13-025337",
        "CALL:DIFFICULTY BREATHING",
        "DATE:07/29/2013",
        "TIME:08:24:26",
        "ADDR:2102 SNEAD AVE",
        "X:ELLIS LN / CRESTWOOD DR",
        "PLACE:WILKINSON,GROVER",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:MED1");

    doTest("T11",
        "(from CHECC) 13-025334 HEART ATTACK \n" +
        " Reported: 07/29/2013 08:02:00 \n" +
        " 423 ELLERSLIE AVE \n" +
        " RR TRACKS / OLD TOWN DR \n" +
        " COLONIAL HEIGHTS \n" +
        " MED3 QNT2 \n" +
        " \n" +
        " ",

        "ID:13-025334",
        "CALL:HEART ATTACK",
        "DATE:07/29/2013",
        "TIME:08:02:00",
        "ADDR:423 ELLERSLIE AVE",
        "X:RR TRACKS / OLD TOWN DR",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:MED3 QNT2");

    doTest("T12",
        "(from CHECC) 13-025331 DIABETIC REACTION \n" +
        " Reported: 07/29/2013 05:00:45 \n" +
        " 831 ELLERSLIE AVE \n" +
        " BENT OAKS DR / I-95 BRIDGE \n" +
        " COLONIAL HEIGHTS HEALTH CARE & REHAB CTR  COLONIAL HEIGHTS \n" +
        " MED3 \n" +
        " \n" +
        " ",

        "ID:13-025331",
        "CALL:DIABETIC REACTION",
        "DATE:07/29/2013",
        "TIME:05:00:45",
        "ADDR:831 ELLERSLIE AVE",
        "X:BENT OAKS DR / I-95 BRIDGE",
        "PLACE:COLONIAL HEIGHTS HEALTH CARE & REHAB CTR",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:MED3");

    doTest("T13",
        "(from CHECC) 13-025328 INJURED PERSON \n" +
        " Reported: 07/29/2013 00:59:27 \n" +
        " 100-A HIGHLAND AVE \n" +
        " 1400-BLK BOULEVARD /  ALLEY \n" +
        " COLONIAL HEIGHTS POLICE DEPT  COLONIAL HEIGHTS \n" +
        " MED1 \n" +
        " \n" +
        " ",

        "ID:13-025328",
        "CALL:INJURED PERSON",
        "DATE:07/29/2013",
        "TIME:00:59:27",
        "ADDR:100-A HIGHLAND AVE",
        "MADDR:100 HIGHLAND AVE",
        "X:1400-BLK BOULEVARD /  ALLEY",
        "PLACE:COLONIAL HEIGHTS POLICE DEPT",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:MED1");

    doTest("T14",
        "(from CHECC) 13-025324 UNRESPONSIVE PERSON \n" +
        " Reported: 07/28/2013 23:38:00 \n" +
        " 5100 CONDUIT RD \n" +
        " HUNTINGTON RD / PEACE CLIFF CT \n" +
        " COLONIAL HEIGHTS \n" +
        " 216 231 MED3 QNT2 \n" +
        " \n" +
        " ",

        "ID:13-025324",
        "CALL:UNRESPONSIVE PERSON",
        "DATE:07/28/2013",
        "TIME:23:38:00",
        "ADDR:5100 CONDUIT RD",
        "X:HUNTINGTON RD / PEACE CLIFF CT",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:216 231 MED3 QNT2");

    doTest("T15",
        "(from CHECC) 13-025324 STROKE \n" +
        " Reported: 07/28/2013 23:38:00 \n" +
        " 5100 CONDUIT RD \n" +
        " HUNTINGTON RD / PEACE CLIFF CT \n" +
        " COLONIAL HEIGHTS \n" +
        " MED3 \n" +
        " \n" +
        " ",

        "ID:13-025324",
        "CALL:STROKE",
        "DATE:07/28/2013",
        "TIME:23:38:00",
        "ADDR:5100 CONDUIT RD",
        "X:HUNTINGTON RD / PEACE CLIFF CT",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:MED3");

    doTest("T16",
        "(from CHECC) 13-025313 SMOKE DETECTOR ACT. - NO SMOKE \n" +
        " Reported: 07/28/2013 21:56:42 \n" +
        " 808 FORESTVIEW DR \n" +
        " NOTTINGHAM DR /  SHERWOOD DR \n" +
        " 808 FORESTVIEW DR *SEE ALERT*  COLONIAL HEIGHTS \n" +
        " QNT2 \n" +
        " \n" +
        " ",

        "ID:13-025313",
        "CALL:SMOKE DETECTOR ACT. - NO SMOKE",
        "DATE:07/28/2013",
        "TIME:21:56:42",
        "ADDR:808 FORESTVIEW DR",
        "X:NOTTINGHAM DR /  SHERWOOD DR",
        "PLACE:808 FORESTVIEW DR *SEE ALERT*",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:QNT2");

    doTest("T17",
        "(from CHECC) 13-025272 SEIZURES \n" +
        " Reported: 07/28/2013 14:35:24 \n" +
        " 3107-15 BOULEVARD \n" +
        " LAKEVIEW AVE /  ELLERSLIE AVE \n" +
        " MARTIN'S FOOD MARKET & PHARMACY  COLONIAL HEIGHTS \n" +
        " MED3 \n" +
        " \n" +
        " ",

        "ID:13-025272",
        "CALL:SEIZURES",
        "DATE:07/28/2013",
        "TIME:14:35:24",
        "ADDR:3107-15 BOULEVARD",
        "MADDR:3107 BOULEVARD",
        "X:LAKEVIEW AVE /  ELLERSLIE AVE",
        "PLACE:MARTIN'S FOOD MARKET & PHARMACY",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:MED3");

    doTest("T18",
        "(from CHECC) 13-025264 FIRE ALARM W/O WATER FLOW \n" +
        " Reported: 07/28/2013 12:19:49 \n" +
        " 235 DUNLOP FARMS BLVD \n" +
        " CLAIRMONT CT / OLD OAK LN \n" +
        " DUNLOP HOUSE  COLONIAL HEIGHTS \n" +
        " BAT1 QNT2 SD2 \n" +
        " \n" +
        " ",

        "ID:13-025264",
        "CALL:FIRE ALARM W/O WATER FLOW",
        "DATE:07/28/2013",
        "TIME:12:19:49",
        "ADDR:235 DUNLOP FARMS BLVD",
        "X:CLAIRMONT CT / OLD OAK LN",
        "PLACE:DUNLOP HOUSE",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:BAT1 QNT2 SD2");

    doTest("T19",
        "(from CHECC) 13-025263 FIRE ALARM W/O WATER FLOW \n" +
        " Reported: 07/28/2013 12:19:21 \n" +
        " 840 W ROSLYN RD \n" +
        " I-95 / CONDUIT RD \n" +
        " MEDALLION POOLS  COLONIAL HEIGHTS \n" +
        " E1 \n" +
        " \n" +
        " ",

        "ID:13-025263",
        "CALL:FIRE ALARM W/O WATER FLOW",
        "DATE:07/28/2013",
        "TIME:12:19:21",
        "ADDR:840 W ROSLYN RD",
        "X:I-95 / CONDUIT RD",
        "PLACE:MEDALLION POOLS",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:E1");

    doTest("T20",
        "(from CHECC) 13-025255 MEDICAL CALL \n" +
        " Reported: 07/28/2013 10:08:09 \n" +
        " 3110 GREENWOOD AVE \n" +
        " OAKWOOD DR /  YACHT BASIN DR \n" +
        " MT PLEASANT BAPTIST CHURCH  COLONIAL HEIGHTS \n" +
        " MED3 \n" +
        " \n" +
        " ",

        "ID:13-025255",
        "CALL:MEDICAL CALL",
        "DATE:07/28/2013",
        "TIME:10:08:09",
        "ADDR:3110 GREENWOOD AVE",
        "X:OAKWOOD DR /  YACHT BASIN DR",
        "PLACE:MT PLEASANT BAPTIST CHURCH",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:MED3");

    doTest("T21",
        "(from CHECC) 13-025248 OVERDOSE \n" +
        " Reported: 07/28/2013 08:03:56 \n" +
        " 716 HAMILTON AVE \n" +
        " LYNCHBURG AVE / E WESTOVER AVE \n" +
        " COLONIAL HEIGHTS \n" +
        " 243 MED1 \n" +
        " \n" +
        " ",

        "ID:13-025248",
        "CALL:OVERDOSE",
        "DATE:07/28/2013",
        "TIME:08:03:56",
        "ADDR:716 HAMILTON AVE",
        "X:LYNCHBURG AVE / E WESTOVER AVE",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:243 MED1");

    doTest("T22",
        "(from CHECC) 13-025244 MUTUAL AID FOR A FIRE ENGINE \n" +
        " Reported: 07/28/2013 06:20:13 \n" +
        " 115 FLINTLOCK DR \n" +
        " SWIFT CR / DEAD END EN \n" +
        " CHESTERFIELD \n" +
        " QNT2 \n" +
        " \n" +
        " ",

        "ID:13-025244",
        "CALL:MUTUAL AID FOR A FIRE ENGINE",
        "DATE:07/28/2013",
        "TIME:06:20:13",
        "ADDR:115 FLINTLOCK DR",
        "X:SWIFT CR / DEAD END EN",
        "CITY:CHESTERFIELD",
        "UNIT:QNT2");

    doTest("T23",
        "(from CHECC) 13-025236 DIFFICULTY BREATHING \n" +
        " Reported: 07/28/2013 00:55:14 \n" +
        " 101 ESSEX DR \n" +
        " 2700 BLK BLVD / HAMPTON DR \n" +
        " COLONIAL HEIGHTS \n" +
        " MED3 \n" +
        " \n" +
        " ",

        "ID:13-025236",
        "CALL:DIFFICULTY BREATHING",
        "DATE:07/28/2013",
        "TIME:00:55:14",
        "ADDR:101 ESSEX DR",
        "X:2700 BLK BLVD / HAMPTON DR",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:MED3");

    doTest("T24",
        "(from CHECC) 13-025184 MUTUAL AID FOR AN AMBULANCE \n Reported: 07/27/2013 17:00:48 \n 3111 JACKSON FARM RD \n MED1 \n \n ",
        "ID:13-025184",
        "CALL:MUTUAL AID FOR AN AMBULANCE",
        "DATE:07/27/2013",
        "TIME:17:00:48",
        "ADDR:3111 JACKSON FARM RD",  // In Hopewell
        "UNIT:MED1");

    doTest("T25",
        "(from CHECC) 13-025172 FIRE ALARM W/O WATER FLOW \n" +
        " Reported: 07/27/2013 15:41:41 \n" +
        " 3245 BOULEVARD \n" +
        " BEECHWOOD AVE / SHERWOOD DR \n" +
        " VICTORY LANE AUTO SALES  COLONIAL HEIGHTS \n" +
        " QNT2 \n" +
        " \n" +
        " ",

        "ID:13-025172",
        "CALL:FIRE ALARM W/O WATER FLOW",
        "DATE:07/27/2013",
        "TIME:15:41:41",
        "ADDR:3245 BOULEVARD",
        "X:BEECHWOOD AVE / SHERWOOD DR",
        "PLACE:VICTORY LANE AUTO SALES",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:QNT2");

    doTest("T26",
        "(from CHECC) 13-025171 HEART RELATED PROBLEM \n" +
        " Reported: 07/27/2013 15:36:37 \n" +
        " 1211 CANTERBURY LN \n" +
        " CEDARWOOD AVE / DUKE OF GLOUCESTER \n" +
        " COLONIAL HEIGHTS \n" +
        " MED3 \n" +
        " \n" +
        " ",

        "ID:13-025171",
        "CALL:HEART RELATED PROBLEM",
        "DATE:07/27/2013",
        "TIME:15:36:37",
        "ADDR:1211 CANTERBURY LN",
        "X:CEDARWOOD AVE / DUKE OF GLOUCESTER",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:MED3");

    doTest("T27",
        "(from CHECC) 13-025164 INJURED PERSON \n" +
        " Reported: 07/27/2013 12:56:28 \n" +
        " 401 TASWELL AVE \n" +
        " VANCE AVE /  WOODLAWN AVE \n" +
        " LAKEVIEW ELEMENTARY SCHOOL  COLONIAL HEIGHTS \n" +
        " MED3 \n" +
        " \n" +
        " ",

        "ID:13-025164",
        "CALL:INJURED PERSON",
        "DATE:07/27/2013",
        "TIME:12:56:28",
        "ADDR:401 TASWELL AVE",
        "X:VANCE AVE /  WOODLAWN AVE",
        "PLACE:LAKEVIEW ELEMENTARY SCHOOL",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:MED3");

    doTest("T28",
        "(from CHECC) 13-025150 INJURED PERSON \n" +
        " Reported: 07/27/2013 10:45:26 \n" +
        " 1823 SOUTHPARK BLVD \n" +
        " SOUTHPARK CIR /  SOUTHPARK CIR \n" +
        " GOLD'S GYM  COLONIAL HEIGHTS \n" +
        " MED3 \n" +
        " \n" +
        " ",

        "ID:13-025150",
        "CALL:INJURED PERSON",
        "DATE:07/27/2013",
        "TIME:10:45:26",
        "ADDR:1823 SOUTHPARK BLVD",
        "X:SOUTHPARK CIR /  SOUTHPARK CIR",
        "PLACE:GOLD'S GYM",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:MED3");

    doTest("T29",
        "(from CHECC) 13-025151 UNCONSCIOUS PERSON \n" +
        " Reported: 07/27/2013 10:46:03 \n" +
        " 721 SOUTHPARK BLVD \n" +
        " CHARLES DIMMOCK PKWY /  SOUTHPARK CIR \n" +
        " TARGET  COLONIAL HEIGHTS \n" +
        " E1 MED1 \n" +
        " \n" +
        " ",

        "ID:13-025151",
        "CALL:UNCONSCIOUS PERSON",
        "DATE:07/27/2013",
        "TIME:10:46:03",
        "ADDR:721 SOUTHPARK BLVD",
        "X:CHARLES DIMMOCK PKWY /  SOUTHPARK CIR",
        "PLACE:TARGET",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:E1 MED1");

    doTest("T30",
        "(from CHECC) 13-025147 SMELL OF NAT. GAS OUTSIDE \n" +
        " Reported: 07/27/2013 09:30:36 \n" +
        " BOULEVARD/ DUPUY AVE \n" +
        " COLONIAL HEIGHTS \n" +
        " E1 \n" +
        " \n" +
        " ",

        "ID:13-025147",
        "CALL:SMELL OF NAT. GAS OUTSIDE",
        "DATE:07/27/2013",
        "TIME:09:30:36",
        "ADDR:BOULEVARD & DUPUY AVE",
        "CITY:COLONIAL HEIGHTS",
        "UNIT:E1");

  }
  
  public static void main(String[] args) {
    new VAColonialHeightsParserTest().generateTests("T1");
  }
}