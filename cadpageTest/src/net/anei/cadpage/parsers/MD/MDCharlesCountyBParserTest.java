package net.anei.cadpage.parsers.MD;


import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*    
Charles County, MD (Version B)
Contact: "rogersonjg@gmail.com" <rogersonjg@gmail.com>
Sender: fire12alerting-bounces@sms.mdfiretech.com

TRASH, DEBRIS, MULCH, TREE FIRE, REFUSE\r\nHERRING CT, DORCHESTER LAKE @ END\r\nmdft.us/?VSm3jy\r\n1215465\r\nS12\r\n8/26/2012 5:23:48 PM
STAB, STABBING, PENETRATING TRAUMA, EMS, ALS, 27D\r\n4092 BLUEBIRD DR\r\nmdft.us/?Dh6z3p\r\n1215519\r\nS12 R12 RDO16A PA517\r\n8/27/2012 2:25:38 PM\r
BRUSH, WOODS, FIELD FIRE (Class 1,2 & 3 days)\r\n3600 WOODLEY RD\r\nmdft.us/?Mf5g96\r\n1215451\r\nS3 S12 TA12 S836 33 B12\r\n8/26/2012 2:36:48 PM
FILL IN, MISC TRANSFER, FIRE\r\n15245 PR FREDERICK RD (RT 231), STATION 2\r\nmdft.us/?d6v4tY\r\n1215448\r\nTA5 TA836 TA1 TA12\r\n8/26/2012 2:18:27 P
MVC EXTRICATION, TRAPPED, PINNED, PI, EMS, ALS, 29B, 29D\r\n91 SMALLWOOD DR, TACO BELL\r\nmdft.us/?Pkhf7P\r\n1215441\r\nS3 S12 HT3 HT12 PA37 PA609
MVC EMS, BLS, PI, 29A\r\nSMALLWOOD DR W / ST PATRICKS DR\r\nmdft.us/?smTKFV\r\n1215411\r\nS12 R12\r\n8/25/2012 11:29:40 PM
MVC EXTRICATION, TRAPPED, PINNED, PI, EMS, ALS, 29B, 29D\r\n11920 ACTON LN, AMF WALDORF LANES IFO\r\nmdft.us/?JK66VG\r\n1215393\r\nS3 S12 HT3 HT12
MVC EMS, BLS, PI, 29A\r\n2276 CRAIN HWY, WALDORF LIQUORS IFO\r\nmdft.us/?WS95SK\r\n1215389\r\nS3 R3 S12\r\n8/25/2012 3:32:35 PM
STANDBY, EMS, BLS\r\n3300 MIDDLETOWN RD, WESTLAKE HIGH\r\nmdft.us/?JmWN6s\r\n1215376\r\nEMS12\r\n8/25/2012 12:23:47 PM
UNKNOWN MEDICAL ALARM, EMS, BLS, 32B\r\n2860 LYON CT\r\nmdft.us/?Pdb3mF\r\n1215368\r\nS3 R3 39 S12\r\n8/25/2012 10:54:30 AM\r\nPERMIT# R142547
STRUC, SF HOUSE, TRAILER, ATTACHED SHED, GARAGE FIRE\r\n7835 HAWTHORNE RD\r\nmdft.us/?JXvLRm\r\n1215352\r\nS1 S8 T11 SQ7 S12 T3 S10 TA1 TA8 R51 51
STRUC, ODOR OF SMOKE - NO FIRE, MF HOUSE, TOWNHOUSE, APARTMENT, COMMERCIAL BLDG\r\n3750 CRAIN HWY, HAMPTON INN\r\nmdft.us/?WW3tS4\r\n1215348\r\nS3
SPILL LEAK FROM AUTO, NO FIRE, GASOLINE\r\n5715 SPRINGFISH PL\r\nmdft.us/?RhM7xm\r\n1215340\r\nS12\r\n8/24/2012 6:45:33 PM\r\n2001 HONDA ACCORD, SILVE
LANDING SITE, LZ, MISC\r\n6222 PANTHER CT\r\nmdft.us/?ZydLqp\r\n1215261\r\nS12\r\n8/23/2012 3:02:18 PM
MVC EMS, BLS, PI, 29A\r\nBENSVILLE RD / SHANNON DR\r\nmdft.us/?dMKhFz\r\n1215251\r\nS12 R12 129 123 CH12B\r\n8/23/2012 12:07:04 PM
SIT FND WORKING FIRE WF\r\n11025 MALL CIR, ROCK 'N ROLL MCDONALDS\r\nmdft.us/?yShWXt\r\n1215239\r\nS3 S12 T1 S824 T11 SQ840 S836 S2 R60 609 CH3B C
STRUC, COMMERCIAL BLDG, WAREHOUSE, STORAGE UNITS, BUSINESS\r\n11025 MALL CIR, ROCK 'N ROLL MCDONALDS\r\nmdft.us/?Zy8gBP\r\n1215239\r\nS3 S12 T1 S8
STRUC, OUTLET SMOKING - NO FIRE, MF HOUSE, TOWNHOUSE, APARTMENT, COMMERCIAL BLDG, MULTI FAMILY HOUSE, BUILDING\r\n4210 QUIGLEY CT\r\nmdft.us/?
STRUC, COMMERCIAL BLDG, WAREHOUSE, STORAGE UNITS, BUSINESS\r\n11040 CRAIN HWY, GLASVA CITGO INC\r\nmdft.us/?LSYpfw\r\n1215225\r\nS14 S10 T28 KG2 T
AFA - SINGLE FAMILY DWELLING, FIRE ALARM, SF HOUSE\r\n11829 MURRE CT\r\nmdft.us/?hb29jZ\r\n1215152\r\nS3 S12\r\n8/21/2012 5:27:26 PM\r\nZONE 13 1ST FL
STANDBY, EMS, BLS\r\n2500 DAVIS RD, NORTH POINT HIGH SCHOOL\r\nmdft.us/?myBdBB\r\n1215094\r\nEMS12\r\n8/20/2012 4:43:29 PM\r\nEMS12=1
FILL IN, (2) ENGINE TRANSFER, FIRE\r\n12245 ROCK POINT RD, STATION 14\r\nmdft.us/?2FFb38\r\n1215053\r\nS1 S2 SM2 S12\r\n8/20/2012 12:37:04 AM
ASSIST THE AMBULANCE, MISC\r\n8520 ABELL WAY\r\nmdft.us/?WVcYXr\r\n1215048\r\nS12\r\n8/19/2012 10:51:11 PM
GAS LEAK INSIDE A COMMERCIAL BUILDING OR MF MULTI FAMILY\r\n3835 GATEVIEW PL\r\nmdft.us/?HNkxzs\r\n1215035\r\nS3 S12 T1 R3 399 CH12B 121 S1 S2 33 
AFA - SINGLE FAMILY DWELLING, FIRE ALARM, SF HOUSE\r\n8660 NORMAN DR\r\nmdft.us/?DTc59Q\r\n1215030\r\nS12\r\n8/19/2012 7:38:17 PM\r\nGENERAL FIRE ALAR
WASH DOWN, MISC\r\n7375 BENSVILLE RD\r\nmdft.us/?NZVQJG\r\n1215022\r\nS12\r\n8/19/2012 6:15:02 PM
LANDING SITE, LZ, MISC\r\n6980 BENSVILLE RD, BENSVILLE PARK\r\nmdft.us/?8mCwsx\r\n1215020\r\nS12\r\n8/19/2012 5:36:33 PM
MVC OVERTURNED, EJECTED, ROLLOVER, EMS, ALS, PI, 29D\r\n7375 BENSVILLE RD\r\nmdft.us/?6Cf9hD\r\n1215019\r\nS12 PA127\r\n8/19/2012 5:09:46 PM
UNKNOWN MEDICAL ALARM, EMS, BLS, 32B\r\n4210 SOUTHWINDS PL, RM 410\r\nmdft.us/?MH4d8g\r\n1215008\r\nS12 R12\r\n8/19/2012 2:24:42 PM
AFA - COMMERCIAL BUILDING, ALARM\r\n2040 ST THOMAS DR, STODDERT MIDDLE SCHOOL\r\nmdft.us/?VvG7sK\r\n1214990\r\nS3 S12\r\n8/19/2012 6:15:34 AM\r\nGEN F
STRUC, SF HOUSE, TRAILER, ATTACHED SHED, GARAGE FIRE\r\n11691 FOUNTAIN HEAD CT\r\nmdft.us/?RGN5HS\r\n1214966\r\nS3 S12 T1 SQ2 E840 T824 S836 R3\r\n8
UNKNOWN MEDICAL ALARM, EMS, BLS, 32B\r\n4210 SOUTHWINDS PL, APT 114\r\nmdft.us/?Xs8yVy\r\n1214964\r\nS12 R60\r\n8/18/2012 7:15:17 PM\r\nUNKN MEDICAL A
 
*/

public class MDCharlesCountyBParserTest extends BaseParserTest {
  
  public MDCharlesCountyBParserTest() {
    setParser(new MDCharlesCountyBParser(), "CHARLES COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "TRASH, DEBRIS, MULCH, TREE FIRE, REFUSE\r\nHERRING CT, DORCHESTER LAKE @ END\r\nmdft.us/?VSm3jy\r\n1215465\r\nS12\r\n8/26/2012 5:23:48 PM",
        "ID:1215465",
        "CALL:TRASH, DEBRIS, MULCH, TREE FIRE, REFUSE",
        "ADDR:HERRING CT",
        "MADDR:HERRING CT & DORCHESTER LAKE",
        "X:DORCHESTER LAKE / END",
        "URL:http://mdft.us/?VSm3jy",
        "UNIT:S12",
        "DATE:8/26/2012",
        "TIME:17:23:48");

    doTest("T2",
        "STAB, STABBING, PENETRATING TRAUMA, EMS, ALS, 27D\r\n" +
        "4092 BLUEBIRD DR\r\n" +
        "mdft.us/?Dh6z3p\r\n" +
        "1215519\r\n" +
        "S12 R12 RDO16A PA517\r\n" +
        "8/27/2012 2:25:38 PM\r",

        "ID:1215519",
        "CALL:STAB, STABBING, PENETRATING TRAUMA, EMS, ALS, 27D",
        "ADDR:4092 BLUEBIRD DR",
        "URL:http://mdft.us/?Dh6z3p",
        "UNIT:S12 R12 RDO16A PA517",
        "DATE:8/27/2012",
        "TIME:14:25:38");

    doTest("T3",
        "BRUSH, WOODS, FIELD FIRE (Class 1,2 & 3 days)\r\n" +
        "3600 WOODLEY RD\r\n" +
        "mdft.us/?Mf5g96\r\n" +
        "1215451\r\n" +
        "S3 S12 TA12 S836 33 B12\r\n" +
        "8/26/2012 2:36:48 PM",

        "ID:1215451",
        "CALL:BRUSH, WOODS, FIELD FIRE (Class 1,2 & 3 days)",
        "ADDR:3600 WOODLEY RD",
        "URL:http://mdft.us/?Mf5g96",
        "UNIT:S3 S12 TA12 S836 33 B12",
        "DATE:8/26/2012",
        "TIME:14:36:48");

    doTest("T4",
        "FILL IN, MISC TRANSFER, FIRE\r\n" +
        "15245 PR FREDERICK RD (RT 231), STATION 2\r\n" +
        "mdft.us/?d6v4tY\r\n" +
        "1215448\r\n" +
        "TA5 TA836 TA1 TA12\r\n" +
        "8/26/2012 2:18:27 P",

        "ID:1215448",
        "CALL:FILL IN, MISC TRANSFER, FIRE",
        "ADDR:15245 PR FREDERICK RD (RT 231)",
        "MADDR:15245 PRINCE FREDERICK RD",
        "PLACE:STATION 2",
        "URL:http://mdft.us/?d6v4tY",
        "UNIT:TA5 TA836 TA1 TA12");

    doTest("T5",
        "MVC EXTRICATION, TRAPPED, PINNED, PI, EMS, ALS, 29B, 29D\r\n" +
        "91 SMALLWOOD DR, TACO BELL\r\n" +
        "mdft.us/?Pkhf7P\r\n" +
        "1215441\r\n" +
        "S3 S12 HT3 HT12 PA37 PA609",

        "ID:1215441",
        "CALL:MVC EXTRICATION, TRAPPED, PINNED, PI, EMS, ALS, 29B, 29D",
        "ADDR:91 SMALLWOOD DR",
        "PLACE:TACO BELL",
        "URL:http://mdft.us/?Pkhf7P",
        "UNIT:S3 S12 HT3 HT12 PA37 PA609");

    doTest("T6",
        "MVC EMS, BLS, PI, 29A\r\nSMALLWOOD DR W / ST PATRICKS DR\r\nmdft.us/?smTKFV\r\n1215411\r\nS12 R12\r\n8/25/2012 11:29:40 PM",
        "ID:1215411",
        "CALL:MVC EMS, BLS, PI, 29A",
        "ADDR:SMALLWOOD DR W & ST PATRICKS DR",
        "URL:http://mdft.us/?smTKFV",
        "UNIT:S12 R12",
        "DATE:8/25/2012",
        "TIME:23:29:40");

    doTest("T7",
        "MVC EXTRICATION, TRAPPED, PINNED, PI, EMS, ALS, 29B, 29D\r\n" +
        "11920 ACTON LN, AMF WALDORF LANES IFO\r\n" +
        "mdft.us/?JK66VG\r\n" +
        "1215393\r\n" +
        "S3 S12 HT3 HT12",

        "ID:1215393",
        "CALL:MVC EXTRICATION, TRAPPED, PINNED, PI, EMS, ALS, 29B, 29D",
        "ADDR:11920 ACTON LN",
        "PLACE:AMF WALDORF LANES IFO",
        "URL:http://mdft.us/?JK66VG",
        "UNIT:S3 S12 HT3 HT12");

    doTest("T8",
        "MVC EMS, BLS, PI, 29A\r\n2276 CRAIN HWY, WALDORF LIQUORS IFO\r\nmdft.us/?WS95SK\r\n1215389\r\nS3 R3 S12\r\n8/25/2012 3:32:35 PM",
        "ID:1215389",
        "CALL:MVC EMS, BLS, PI, 29A",
        "ADDR:2276 CRAIN HWY",
        "PLACE:WALDORF LIQUORS IFO",
        "URL:http://mdft.us/?WS95SK",
        "UNIT:S3 R3 S12",
        "DATE:8/25/2012",
        "TIME:15:32:35");

    doTest("T9",
        "STANDBY, EMS, BLS\r\n3300 MIDDLETOWN RD, WESTLAKE HIGH\r\nmdft.us/?JmWN6s\r\n1215376\r\nEMS12\r\n8/25/2012 12:23:47 PM",
        "ID:1215376",
        "CALL:STANDBY, EMS, BLS",
        "ADDR:3300 MIDDLETOWN RD",
        "PLACE:WESTLAKE HIGH",
        "URL:http://mdft.us/?JmWN6s",
        "UNIT:EMS12",
        "DATE:8/25/2012",
        "TIME:12:23:47");

    doTest("T10",
        "UNKNOWN MEDICAL ALARM, EMS, BLS, 32B\r\n" +
        "2860 LYON CT\r\n" +
        "mdft.us/?Pdb3mF\r\n" +
        "1215368\r\n" +
        "S3 R3 39 S12\r\n" +
        "8/25/2012 10:54:30 AM\r\n" +
        "PERMIT# R142547",

        "ID:1215368",
        "CALL:UNKNOWN MEDICAL ALARM, EMS, BLS, 32B",
        "ADDR:2860 LYON CT",
        "URL:http://mdft.us/?Pdb3mF",
        "UNIT:S3 R3 39 S12",
        "DATE:8/25/2012",
        "TIME:10:54:30",
        "INFO:PERMIT# R142547");

    doTest("T11",
        "STRUC, SF HOUSE, TRAILER, ATTACHED SHED, GARAGE FIRE\r\n" +
        "7835 HAWTHORNE RD\r\n" +
        "mdft.us/?JXvLRm\r\n" +
        "1215352\r\n" +
        "S1 S8 T11 SQ7 S12 T3 S10 TA1 TA8 R51 51",

        "ID:1215352",
        "CALL:STRUC, SF HOUSE, TRAILER, ATTACHED SHED, GARAGE FIRE",
        "ADDR:7835 HAWTHORNE RD",
        "URL:http://mdft.us/?JXvLRm",
        "UNIT:S1 S8 T11 SQ7 S12 T3 S10 TA1 TA8 R51 51");

    doTest("T12",
        "STRUC, ODOR OF SMOKE - NO FIRE, MF HOUSE, TOWNHOUSE, APARTMENT, COMMERCIAL BLDG\r\n" +
        "3750 CRAIN HWY, HAMPTON INN\r\n" +
        "mdft.us/?WW3tS4\r\n" +
        "1215348\r\n" +
        "S3",

        "ID:1215348",
        "CALL:STRUC, ODOR OF SMOKE - NO FIRE, MF HOUSE, TOWNHOUSE, APARTMENT, COMMERCIAL BLDG",
        "ADDR:3750 CRAIN HWY",
        "PLACE:HAMPTON INN",
        "URL:http://mdft.us/?WW3tS4",
        "UNIT:S3");

    doTest("T13",
        "SPILL LEAK FROM AUTO, NO FIRE, GASOLINE\r\n" +
        "5715 SPRINGFISH PL\r\n" +
        "mdft.us/?RhM7xm\r\n" +
        "1215340\r\n" +
        "S12\r\n" +
        "8/24/2012 6:45:33 PM\r\n" +
        "2001 HONDA ACCORD, SILVE",

        "ID:1215340",
        "CALL:SPILL LEAK FROM AUTO, NO FIRE, GASOLINE",
        "ADDR:5715 SPRINGFISH PL",
        "URL:http://mdft.us/?RhM7xm",
        "UNIT:S12",
        "DATE:8/24/2012",
        "TIME:18:45:33",
        "INFO:2001 HONDA ACCORD, SILVE");

    doTest("T14",
        "LANDING SITE, LZ, MISC\r\n6222 PANTHER CT\r\nmdft.us/?ZydLqp\r\n1215261\r\nS12\r\n8/23/2012 3:02:18 PM",
        "ID:1215261",
        "CALL:LANDING SITE, LZ, MISC",
        "ADDR:6222 PANTHER CT",
        "URL:http://mdft.us/?ZydLqp",
        "UNIT:S12",
        "DATE:8/23/2012",
        "TIME:15:02:18");

    doTest("T15",
        "MVC EMS, BLS, PI, 29A\r\nBENSVILLE RD / SHANNON DR\r\nmdft.us/?dMKhFz\r\n1215251\r\nS12 R12 129 123 CH12B\r\n8/23/2012 12:07:04 PM",
        "ID:1215251",
        "CALL:MVC EMS, BLS, PI, 29A",
        "ADDR:BENSVILLE RD & SHANNON DR",
        "URL:http://mdft.us/?dMKhFz",
        "UNIT:S12 R12 129 123 CH12B",
        "DATE:8/23/2012",
        "TIME:12:07:04");

    doTest("T16",
        "SIT FND WORKING FIRE WF\r\n" +
        "11025 MALL CIR, ROCK 'N ROLL MCDONALDS\r\n" +
        "mdft.us/?yShWXt\r\n" +
        "1215239\r\n" +
        "S3 S12 T1 S824 T11 SQ840 S836 S2 R60 609 CH3B C",

        "ID:1215239",
        "CALL:SIT FND WORKING FIRE WF",
        "ADDR:11025 MALL CIR",
        "PLACE:ROCK 'N ROLL MCDONALDS",
        "URL:http://mdft.us/?yShWXt",
        "UNIT:S3 S12 T1 S824 T11 SQ840 S836 S2 R60 609 CH3B C");

    doTest("T17",
        "STRUC, COMMERCIAL BLDG, WAREHOUSE, STORAGE UNITS, BUSINESS\r\n" +
        "11025 MALL CIR, ROCK 'N ROLL MCDONALDS\r\n" +
        "mdft.us/?Zy8gBP\r\n" +
        "1215239\r\n" +
        "S3 S12 T1 S8",

        "ID:1215239",
        "CALL:STRUC, COMMERCIAL BLDG, WAREHOUSE, STORAGE UNITS, BUSINESS",
        "ADDR:11025 MALL CIR",
        "PLACE:ROCK 'N ROLL MCDONALDS",
        "URL:http://mdft.us/?Zy8gBP",
        "UNIT:S3 S12 T1 S8");

    doTest("T18",
        "STRUC, OUTLET SMOKING - NO FIRE, MF HOUSE, TOWNHOUSE, APARTMENT, COMMERCIAL BLDG, MULTI FAMILY HOUSE, BUILDING\r\n" +
        "4210 QUIGLEY CT\r\n" +
        "mdft.us/?",

        "CALL:STRUC, OUTLET SMOKING - NO FIRE, MF HOUSE, TOWNHOUSE, APARTMENT, COMMERCIAL BLDG, MULTI FAMILY HOUSE, BUILDING",
        "ADDR:4210 QUIGLEY CT",
        "URL:http://mdft.us/?");

    doTest("T19",
        "STRUC, COMMERCIAL BLDG, WAREHOUSE, STORAGE UNITS, BUSINESS\r\n" +
        "11040 CRAIN HWY, GLASVA CITGO INC\r\n" +
        "mdft.us/?LSYpfw\r\n" +
        "1215225\r\n" +
        "S14 S10 T28 KG2 T",

        "ID:1215225",
        "CALL:STRUC, COMMERCIAL BLDG, WAREHOUSE, STORAGE UNITS, BUSINESS",
        "ADDR:11040 CRAIN HWY",
        "PLACE:GLASVA CITGO INC",
        "URL:http://mdft.us/?LSYpfw",
        "UNIT:S14 S10 T28 KG2 T");

    doTest("T20",
        "AFA - SINGLE FAMILY DWELLING, FIRE ALARM, SF HOUSE\r\n" +
        "11829 MURRE CT\r\n" +
        "mdft.us/?hb29jZ\r\n" +
        "1215152\r\n" +
        "S3 S12\r\n" +
        "8/21/2012 5:27:26 PM\r\n" +
        "ZONE 13 1ST FL",

        "ID:1215152",
        "CALL:AFA - SINGLE FAMILY DWELLING, FIRE ALARM, SF HOUSE",
        "ADDR:11829 MURRE CT",
        "URL:http://mdft.us/?hb29jZ",
        "UNIT:S3 S12",
        "DATE:8/21/2012",
        "TIME:17:27:26",
        "INFO:ZONE 13 1ST FL");

    doTest("T21",
        "STANDBY, EMS, BLS\r\n2500 DAVIS RD, NORTH POINT HIGH SCHOOL\r\nmdft.us/?myBdBB\r\n1215094\r\nEMS12\r\n8/20/2012 4:43:29 PM\r\nEMS12=1",
        "ID:1215094",
        "CALL:STANDBY, EMS, BLS",
        "ADDR:2500 DAVIS RD",
        "PLACE:NORTH POINT HIGH SCHOOL",
        "URL:http://mdft.us/?myBdBB",
        "UNIT:EMS12",
        "DATE:8/20/2012",
        "TIME:16:43:29",
        "INFO:EMS12=1");

    doTest("T22",
        "FILL IN, (2) ENGINE TRANSFER, FIRE\r\n" +
        "12245 ROCK POINT RD, STATION 14\r\n" +
        "mdft.us/?2FFb38\r\n" +
        "1215053\r\n" +
        "S1 S2 SM2 S12\r\n" +
        "8/20/2012 12:37:04 AM",

        "ID:1215053",
        "CALL:FILL IN, (2) ENGINE TRANSFER, FIRE",
        "ADDR:12245 ROCK POINT RD",
        "PLACE:STATION 14",
        "URL:http://mdft.us/?2FFb38",
        "UNIT:S1 S2 SM2 S12",
        "DATE:8/20/2012",
        "TIME:00:37:04");

    doTest("T23",
        "ASSIST THE AMBULANCE, MISC\r\n8520 ABELL WAY\r\nmdft.us/?WVcYXr\r\n1215048\r\nS12\r\n8/19/2012 10:51:11 PM",
        "ID:1215048",
        "CALL:ASSIST THE AMBULANCE, MISC",
        "ADDR:8520 ABELL WAY",
        "URL:http://mdft.us/?WVcYXr",
        "UNIT:S12",
        "DATE:8/19/2012",
        "TIME:22:51:11");

    doTest("T24",
        "GAS LEAK INSIDE A COMMERCIAL BUILDING OR MF MULTI FAMILY\r\n" +
        "3835 GATEVIEW PL\r\n" +
        "mdft.us/?HNkxzs\r\n" +
        "1215035\r\n" +
        "S3 S12 T1 R3 399 CH12B 121 S1 S2 33 ",

        "ID:1215035",
        "CALL:GAS LEAK INSIDE A COMMERCIAL BUILDING OR MF MULTI FAMILY",
        "ADDR:3835 GATEVIEW PL",
        "URL:http://mdft.us/?HNkxzs",
        "UNIT:S3 S12 T1 R3 399 CH12B 121 S1 S2 33");

    doTest("T25",
        "AFA - SINGLE FAMILY DWELLING, FIRE ALARM, SF HOUSE\r\n" +
        "8660 NORMAN DR\r\n" +
        "mdft.us/?DTc59Q\r\n" +
        "1215030\r\n" +
        "S12\r\n" +
        "8/19/2012 7:38:17 PM\r\n" +
        "GENERAL FIRE ALAR",

        "ID:1215030",
        "CALL:AFA - SINGLE FAMILY DWELLING, FIRE ALARM, SF HOUSE",
        "ADDR:8660 NORMAN DR",
        "URL:http://mdft.us/?DTc59Q",
        "UNIT:S12",
        "DATE:8/19/2012",
        "TIME:19:38:17",
        "INFO:GENERAL FIRE ALAR");

    doTest("T26",
        "WASH DOWN, MISC\r\n7375 BENSVILLE RD\r\nmdft.us/?NZVQJG\r\n1215022\r\nS12\r\n8/19/2012 6:15:02 PM",
        "ID:1215022",
        "CALL:WASH DOWN, MISC",
        "ADDR:7375 BENSVILLE RD",
        "URL:http://mdft.us/?NZVQJG",
        "UNIT:S12",
        "DATE:8/19/2012",
        "TIME:18:15:02");

    doTest("T27",
        "LANDING SITE, LZ, MISC\r\n6980 BENSVILLE RD, BENSVILLE PARK\r\nmdft.us/?8mCwsx\r\n1215020\r\nS12\r\n8/19/2012 5:36:33 PM",
        "ID:1215020",
        "CALL:LANDING SITE, LZ, MISC",
        "ADDR:6980 BENSVILLE RD",
        "PLACE:BENSVILLE PARK",
        "URL:http://mdft.us/?8mCwsx",
        "UNIT:S12",
        "DATE:8/19/2012",
        "TIME:17:36:33");

    doTest("T28",
        "MVC OVERTURNED, EJECTED, ROLLOVER, EMS, ALS, PI, 29D\r\n" +
        "7375 BENSVILLE RD\r\n" +
        "mdft.us/?6Cf9hD\r\n" +
        "1215019\r\n" +
        "S12 PA127\r\n" +
        "8/19/2012 5:09:46 PM",

        "ID:1215019",
        "CALL:MVC OVERTURNED, EJECTED, ROLLOVER, EMS, ALS, PI, 29D",
        "ADDR:7375 BENSVILLE RD",
        "URL:http://mdft.us/?6Cf9hD",
        "UNIT:S12 PA127",
        "DATE:8/19/2012",
        "TIME:17:09:46");

    doTest("T29",
        "UNKNOWN MEDICAL ALARM, EMS, BLS, 32B\r\n4210 SOUTHWINDS PL, RM 410\r\nmdft.us/?MH4d8g\r\n1215008\r\nS12 R12\r\n8/19/2012 2:24:42 PM",
        "ID:1215008",
        "CALL:UNKNOWN MEDICAL ALARM, EMS, BLS, 32B",
        "ADDR:4210 SOUTHWINDS PL",
        "APT:410",
        "URL:http://mdft.us/?MH4d8g",
        "UNIT:S12 R12",
        "DATE:8/19/2012",
        "TIME:14:24:42");

    doTest("T30",
        "AFA - COMMERCIAL BUILDING, ALARM\r\n" +
        "2040 ST THOMAS DR, STODDERT MIDDLE SCHOOL\r\n" +
        "mdft.us/?VvG7sK\r\n" +
        "1214990\r\n" +
        "S3 S12\r\n" +
        "8/19/2012 6:15:34 AM\r\n" +
        "GEN F",

        "ID:1214990",
        "CALL:AFA - COMMERCIAL BUILDING, ALARM",
        "ADDR:2040 ST THOMAS DR",
        "PLACE:STODDERT MIDDLE SCHOOL",
        "URL:http://mdft.us/?VvG7sK",
        "UNIT:S3 S12",
        "DATE:8/19/2012",
        "TIME:06:15:34",
        "INFO:GEN F");

    doTest("T31",
        "STRUC, SF HOUSE, TRAILER, ATTACHED SHED, GARAGE FIRE\r\n" +
        "11691 FOUNTAIN HEAD CT\r\n" +
        "mdft.us/?RGN5HS\r\n" +
        "1214966\r\n" +
        "S3 S12 T1 SQ2 E840 T824 S836 R3\r\n" +
        "8",

        "ID:1214966",
        "CALL:STRUC, SF HOUSE, TRAILER, ATTACHED SHED, GARAGE FIRE",
        "ADDR:11691 FOUNTAIN HEAD CT",
        "URL:http://mdft.us/?RGN5HS",
        "UNIT:S3 S12 T1 SQ2 E840 T824 S836 R3");

    doTest("T32",
        "UNKNOWN MEDICAL ALARM, EMS, BLS, 32B\r\n" +
        "4210 SOUTHWINDS PL, APT 114\r\n" +
        "mdft.us/?Xs8yVy\r\n" +
        "1214964\r\n" +
        "S12 R60\r\n" +
        "8/18/2012 7:15:17 PM\r\n" +
        "UNKN MEDICAL A",

        "ID:1214964",
        "CALL:UNKNOWN MEDICAL ALARM, EMS, BLS, 32B",
        "ADDR:4210 SOUTHWINDS PL",
        "APT:114",
        "URL:http://mdft.us/?Xs8yVy",
        "UNIT:S12 R60",
        "DATE:8/18/2012",
        "TIME:19:15:17",
        "INFO:UNKN MEDICAL A");

  }
    
  public static void main(String[] args) {
    new MDCharlesCountyBParserTest().generateTests("T1");
  }

}