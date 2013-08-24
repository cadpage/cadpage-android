package net.anei.cadpage.parsers.ME;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Cumberland County, ME
Contact: Active911
Agency name: Scarborough Fire
Location: Scarborough, ME, United States
Sender: autopage-no-reply@ci.scarborough.me.us

(Imc Solutions Page) FD ALARM FROM MASTERBOX\nENGINE 4\n12 KING ST \nSCARBOROUGH\nDistrict: 415\n8/18/2013 19:23
(Imc Solutions Page) FD ALARM FROM ALARM CO\nHOLIDAY HOUSE\n106 EAST GRAND AVE \nSCARBOROUGH\nDistrict: 415\n8/18/2013 09:52
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nOLD ORCHARD ST \nOLD ORCHARD BEACH\n8/17/2013 22:29
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nPINE POINT VISTA CONDOS\n205 EAST GRAND AVE \nOLD ORCHARD BEACH\nDistrict: OOB\n8/16/2013 12:31
(Imc Solutions Page) FD BRUSH GRASS WOODS RR TRACKS\n96 SPURWINK RD \nSCARBOROUGH\nDistrict: 323\n8/15/2013 15:41
(Imc Solutions Page) FD ALARM FROM ALARM CO\nEXTENDED STAY\n2 ASHLEY DR \nSCARBOROUGH\nDistrict: 714\n8/14/2013 19:37
(Imc Solutions Page) FD MARINE WATER RESCUE\nHURD PARK\n63 KING ST \nSCARBOROUGH\nDistrict: 415\n8/14/2013 14:43
(Imc Solutions Page) FD ALARM FROM ALARM CO\nWILLOWDALE GOLF COURSE & CLUBHOUSE\n52 WILLOWDALE RD \nSCARBOROUGH\nDistrict: 7414\n8/14/2013 10:13
(Imc Solutions Page) FD ALARM FROM ALARM CO\nLESLIE RILEY\n6 HARMON ST \nSCARBOROUGH\nDistrict: 127\n8/13/2013 08:42
(Imc Solutions Page) FD ALARM FROM ALARM CO\nMCDONALDS\n221 ROUTE 1 \nSCARBOROUGH\nDistrict: 799\n8/12/2013 23:47
(Imc Solutions Page) FD ALARM FROM MASTERBOX\nKALER VAIL\n382 BLACK POINT RD \nSCARBOROUGH\nDistrict: 127\n8/12/2013 09:12
(Imc Solutions Page) FD ALARM FROM ALARM CO\nDOUCETTE, RUSSELL & KAY\n3 FREDERICK THOMPSON DR \nSCARBOROUGH\nDistrict: 312\n8/11/2013 18:04
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n2 SCOLLARD RD \nOLD ORCHARD BEACH\nDistrict: OOB\n8/11/2013 10:25
(Imc Solutions Page) FD CHIM,ELEC,EXPLODE,GAS,STOVE\nHANNAFORD SUPERMARKET\n31 HANNAFORD DR \nSCARBOROUGH\nDistrict: 799\n8/11/2013 08:04
(Imc Solutions Page) FD ALARM FROM ALARM CO\nPHANTOM FIREWORKS\n2 CABELA BLVD \nSCARBOROUGH\nDistrict: 622\n8/10/2013 23:55
(Imc Solutions Page) FD FIRE ALARM SOUNDING\n11 KENNEBAGO DR \nSCARBOROUGH\nDistrict: 6241\n8/10/2013 14:21
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n50 ADELAIDE RD \nOLD ORCHARD BEACH\nDistrict: OOB\n8/10/2013 00:23
(Imc Solutions Page) FD ALARM FROM ALARM CO\nBURNHAM, KENNETH\n23 BURNHAM WOODS CIR \nSCARBOROUGH\nDistrict: 411\n8/9/2013 20:58
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nBAYLEYS CAMPGROUND\n275 PINE POINT RD APT R6\nSCARBOROUGH\nDistrict: 415\n8/9/2013 20:29
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n5 KINNEY AVE \nOLD ORCHARD BEACH\nDistrict: OOB\n8/9/2013 17:33
(Imc Solutions Page) FD WATERFLOW FROM ALARM CO\nSAMS\n440 PAYNE RD \nSCARBOROUGH\nDistrict: 714\n8/7/2013 14:04
(Imc Solutions Page) FD WATERFLOW FROM ALARM CO\nSAMS\n440 PAYNE RD \nSCARBOROUGH\nDistrict: 714\n8/5/2013 18:57
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nMEMORIAL PARK\nFIRST ST \nOLD ORCHARD BEACH\n8/5/2013 12:32
(Imc Solutions Page) FD CHIM,ELEC,EXPLODE,GAS,STOVE\nMOOSE LODGE\n19 SPRING ST \nSCARBOROUGH\nDistrict: 714\n8/5/2013 10:20
(Imc Solutions Page) FD MARINE WATER RESCUE\nATLANTIC OCEAN\nSCARBOROUGH\n8/4/2013 20:29
(Imc Solutions Page) FD MARINE WATER RESCUE\nENGINE 4\n12 KING ST \nSCARBOROUGH\nDistrict: 415\n8/4/2013 20:10
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nBAY ST \nSCARBOROUGH\nDistrict: 415\n8/4/2013 10:50
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nSEASCAPE CONDOMINIUMS\n221 EAST GRAND AVE \nOLD ORCHARD BEACH\nDistrict: OOB\n8/4/2013 08:13
(Imc Solutions Page) FD ALARM FROM ALARM CO\nSPARKLE CAR WASH\n285 ROUTE 1 \nSCARBOROUGH\nDistrict: 742\n8/2/2013 18:28
(Imc Solutions Page) FD ALARM FROM MASTERBOX\nMAINE VETERANS HOME\n290 ROUTE 1 \nSCARBOROUGH\nDistrict: 742\n8/2/2013 10:39
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nGIKAS, STEFANOS\n26 AVENUE 5 \nSCARBOROUGH\nDistrict: 415\n8/1/2013 13:06
(Imc Solutions Page) FD ALARM FROM ALARM CO\nNORWAY SAVINGS BANK\n158 ROUTE 1 \nSCARBOROUGH\nDistrict: 799\n8/1/2013 11:46
(Imc Solutions Page) FD ALARM FROM MASTERBOX\nPLEASANT HILL SCHOOL\n143 HIGHLAND AVE \nSCARBOROUGH\nDistrict: 312\n8/1/2013 08:54
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n295 PINE POINT RD \nSCARBOROUGH\nDistrict: 415\n7/31/2013 19:21
(Imc Solutions Page) FD ALARM FROM ALARM CO\nEXTENDED STAY\n2 ASHLEY DR \nSCARBOROUGH\nDistrict: 714\n7/31/2013 15:04
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nBAYLEYS CAMPGROUND\n275 PINE POINT RD \nSCARBOROUGH\nDistrict: 415\n7/31/2013 09:23
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nCLAMBAKE\n356 PINE POINT RD \nSCARBOROUGH\nDistrict: 415\n7/30/2013 19:42
(Imc Solutions Page) FD WIRES DOWN\n56 JONES CREEK DR \nSCARBOROUGH\nDistrict: 415\n7/30/2013 12:53
(Imc Solutions Page) FD ALARM FROM MASTERBOX\nEIGHT CORNERS SCHOOL\n22 MUSSEY RD \nSCARBOROUGH\nDistrict: 714\n7/30/2013 07:06
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n193 PINE POINT RD \nSCARBOROUGH\nDistrict: 411\n7/28/2013 15:05
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nSEAC\n221 EAST GRAND AVE \nOLD ORCHARD BEACH\n7/28/2013 06:10
(Imc Solutions Page) FD ALARM FROM ALARM CO\nLERMAN, BRANDON & AIMEE\n6 HEATHER LN \nSCARBOROUGH\nDistrict: 799\n7/27/2013 20:27
(Imc Solutions Page) FD MARINE WATER RESCUE\nATLANTIC AVE \nOLD ORCHARD BEACH\n7/27/2013 17:37
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nBAYLEYS CAMPGROUND\n275 PINE POINT RD APT F8\nSCARBOROUGH\nDistrict: 415\n7/27/2013 17:01
(Imc Solutions Page) FD ALARM FROM ALARM CO\nKENTUCKY FRIED CHICKEN / TACO BELL\n400 GALLERY BLVD \nSCARBOROUGH\nDistrict: 715\n7/25/2013 22:52
(Imc Solutions Page) FD ALARM FROM ALARM CO\nDOT FLEET SERVICES\n61 PLEASANT HILL RD \nSCARBOROUGH\nDistrict: 343\n7/25/2013 09:07
(Imc Solutions Page) FD ALARM FROM ALARM CO\nDOT FLEET SERVICES\n61 PLEASANT HILL RD \nSCARBOROUGH\nDistrict: 343\n7/25/2013 01:32
(Imc Solutions Page) FD ALARM FROM ALARM CO\nMARKET PLACE BUSINESS BUILDING\n144 ROUTE 1 APT CS\nSCARBOROUGH\nDistrict: 7232\n7/24/2013 18:11
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nPOWDERHORN CAMPGROUND\n48 CASCADE RD \nOLD ORCHARD BEACH\nDistrict: OOB\n7/24/2013 11:58
(Imc Solutions Page) FD ALARM FROM MASTERBOX\nMAINE MEDICAL CENTER RADIOLOGY\n100 CAMPUS DR APT 113\nSCARBOROUGH\nDistrict: 7232\n7/23/2013 11:54
(Imc Solutions Page) FD ALARM FROM ALARM CO\nDUNSTAN DENTAL\n618 ROUTE 1 APT 4\nSCARBOROUGH\nDistrict: 651\n7/23/2013 11:34
(Imc Solutions Page) FD ALARM FROM ALARM CO\nVOGEL, JAMES AND TERRI\n1 COLE FARM DR \nSCARBOROUGH\nDistrict: 127\n7/21/2013 18:56
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n2 PINE BROOK TER \nOLD ORCHARD BEACH\nDistrict: OOB\n7/21/2013 17:46
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n32 PILLSBURY DR \nSCARBOROUGH\nDistrict: 415\n7/21/2013 13:38
(Imc Solutions Page) FD ALARM FROM ALARM CO\nWALGREENS\n233 ROUTE 1 \nSCARBOROUGH\nDistrict: 799\n7/21/2013 10:39
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n247 PINE POINT RD \nSCARBOROUGH\nDistrict: 411\n7/20/2013 16:13
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nGIKAS, STEFANOS\n26 AVENUE 5 \nSCARBOROUGH\nDistrict: 415\n7/20/2013 08:32
(Imc Solutions Page) FD WIRES DOWN\nCLAMBAKE\n356 PINE POINT RD \nSCARBOROUGH\nDistrict: 415\n7/20/2013 08:28
(Imc Solutions Page) FD LOW BATTERY\nSANITARY DISTRICT PLANT\n415 BLACK POINT RD \nSCARBOROUGH\nDistrict: 127\n7/19/2013 19:15
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nGIKAS, STEFANOS\n26 AVENUE 5 \nSCARBOROUGH\nDistrict: 415\n7/19/2013 13:43
(Imc Solutions Page) FD ALARM FROM ALARM CO\n128 HOLMES RD \nSCARBOROUGH\nDistrict: 629\n7/19/2013 13:34
(Imc Solutions Page) FD BRUSH GRASS WOODS RR TRACKS\nHANNAFORD GENERAL OFFICE\n145 PLEASANT HILL RD \nSCARBOROUGH\nDistrict: 312\n7/18/2013 15:12
(Imc Solutions Page) FD ALARM FROM ALARM CO\nGOLF AND SKI WAREHOUSE\n273 PAYNE RD APT 100\nSCARBOROUGH\nDistrict: 622\n7/17/2013 22:28
(Imc Solutions Page) FD FIRE STRUCTURE, PLANE CRASH\n24 CARRIAGE WAY \nSCARBOROUGH\nDistrict: 651\n7/17/2013 22:26
(Imc Solutions Page) FD ALARM FROM ALARM CO\nDUNSTAN VILLAGE SQUARE\n605 ROUTE 1 \nSCARBOROUGH\nDistrict: 651\n7/17/2013 21:37
(Imc Solutions Page) FD MARINE WATER RESCUE\nATLANTIC OCEAN\nSCARBOROUGH\nDistrict: OTH\n7/17/2013 14:17
(Imc Solutions Page) FD WATERFLOW FROM MASTERBOX\nSCARBOROUGH MIDDLE SCHOOL\n21 QUENTIN DR \nSCARBOROUGH\nDistrict: 7171\n7/16/2013 08:42
(Imc Solutions Page) FD ALARM FROM ALARM CO\nROCK AND ROLL DINER\n623 ROUTE 1 \nSCARBOROUGH\nDistrict: 651\n7/15/2013 11:50
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n215 EAST GRAND AVE \nOLD ORCHARD BEACH\nDistrict: OOB\n7/14/2013 02:40
(Imc Solutions Page) FD ALARM FROM ALARM CO\nSTEELE, CAROL\n7 SANCTUARY LN \nSCARBOROUGH\nDistrict: 127\n7/11/2013 13:46
(Imc Solutions Page) FD CHIM,ELEC,EXPLODE,GAS,STOVE\nMUNICIPAL STORAGE BUILDING\n20 WASHINGTON AVE \nSCARBOROUGH\nDistrict: 637\n7/10/2013 12:12
(Imc Solutions Page) FD MARINE WATER RESCUE\nATLANTIC OCEAN \nOLD ORCHARD BEACH\nDistrict: OOB\n7/10/2013 00:17
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nPORTLAND AVE AND FOOTE ST \nOTHER TOWN\n7/9/2013 15:08
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nMOBY DICK\n74 EAST GRAND AVE \nOLD ORCHARD BEACH\n7/8/2013 18:37
(Imc Solutions Page) FD ALARM FROM ALARM CO\nDUNSTAN VILLAGE SQUARE\n605 ROUTE 1 \nSCARBOROUGH\nDistrict: 651\n7/8/2013 07:01
(Imc Solutions Page) FD ALARM FROM ALARM CO\nHIGGINS BEACH INN\n34 OCEAN AVE \nSCARBOROUGH\nDistrict: 127\n7/8/2013 06:49
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nHURD PARK SNACK BAR\n63 KING ST \nSCARBOROUGH\nDistrict: 415\n7/6/2013 13:54
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nSOHO\n39 WEST GRAND AVE \nOLD ORCHARD BEACH\n7/6/2013 10:54
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nHURD PARK\n63 KING ST \nSCARBOROUGH\nDistrict: 415\n7/5/2013 17:00
(Imc Solutions Page) FD CHIM,ELEC,EXPLODE,GAS,STOVE\nDOUCETTE, RUSSELL & KAY\n3 FREDERICK THOMPSON DR \nSCARBOROUGH\nDistrict: 312\n7/5/2013 15:13
(Imc Solutions Page) FD WASH,WIRES,MULCH,BURN,SMELL\nLAROU APARTMENTS\n74 KING ST APT 1,2,3\nSCARBOROUGH\nDistrict: 415\n7/4/2013 22:57
(Imc Solutions Page) FD CHIM,ELEC,EXPLODE,GAS,STOVE\n9 STONEY CREEK DR \nSCARBOROUGH\nDistrict: 742\n7/4/2013 21:53
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n9 PILLSBURY DR \nSCARBOROUGH\nDistrict: 415\n7/4/2013 18:28
(Imc Solutions Page) FD MARINE WATER RESCUE\n35 PILLSBURY DR \nSCARBOROUGH\nDistrict: 415\n7/4/2013 17:29
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nBAYLEYS CAMPGROUND\n275 PINE POINT RD APT 709\nSCARBOROUGH\nDistrict: 415\n7/4/2013 15:27
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nCOPLEY LAREINE HOTEL\n8 HARRISBURG ST \nOLD ORCHARD BEACH\n7/4/2013 15:03
(Imc Solutions Page) FD ALARM FROM ALARM CO\nWEEKLY, RICHARD AND MARGARET\n8 SMITHERS WAY \nSCARBOROUGH\nDistrict: 127\n7/4/2013 14:12
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nATLANTIC OCEAN\nOLD ORCHARD BEACH\nDistrict: OOB\n7/3/2013 02:52
(Imc Solutions Page) FD ALARM FROM ALARM CO\nWAGON MASTERS\n12 BORDER RD \nSCARBOROUGH\nDistrict: 715\n7/2/2013 19:04
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nBAYLEYS CAMPGROUND\n275 PINE POINT RD APT 317\nSCARBOROUGH\nDistrict: 415\n7/2/2013 17:55
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nBAYLEYS CAMPGROUND\n275 PINE POINT RD \nSCARBOROUGH\nDistrict: 415\n7/1/2013 22:30
(Imc Solutions Page) FD ALARM FROM MASTERBOX\nPINE POINT NURSING CENTER\n67 PINE POINT RD \nSCARBOROUGH\nDistrict: 654\n7/1/2013 04:59
(Imc Solutions Page) FD ALARM FROM MASTERBOX\nPINE POINT NURSING CENTER\n67 PINE POINT RD \nSCARBOROUGH\nDistrict: 654\n6/30/2013 18:18
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nENGINE 4\n12 KING ST \nSCARBOROUGH\nDistrict: 415\n6/30/2013 13:46
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n12 BELMONT TER \nGORHAM\n6/30/2013 13:28
(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n28 KING ST \nSCARBOROUGH\nDistrict: 415\n6/30/2013 12:15
(Imc Solutions Page) FD ALARM FROM ALARM CO\nEXTENDED STAY\n2 ASHLEY DR \nSCARBOROUGH\nDistrict: 714\n6/29/2013 20:42
(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n24 PUFFIN ST \nOLD ORCHARD BEACH\nDistrict: OOB\n6/29/2013 19:29

*/

public class MECumberlandCountyParserTest extends BaseParserTest {
  
  public MECumberlandCountyParserTest() {
    setParser(new MECumberlandCountyParser(), "CUMBERLAND COUNTY", "ME");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Imc Solutions Page) FD ALARM FROM MASTERBOX\nENGINE 4\n12 KING ST \nSCARBOROUGH\nDistrict: 415\n8/18/2013 19:23",
        "CALL:FD ALARM FROM MASTERBOX",
        "NAME:ENGINE 4",
        "ADDR:12 KING ST",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:8/18/2013",
        "TIME:19:23");

    doTest("T2",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nHOLIDAY HOUSE\n106 EAST GRAND AVE \nSCARBOROUGH\nDistrict: 415\n8/18/2013 09:52",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:HOLIDAY HOUSE",
        "ADDR:106 EAST GRAND AVE",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:8/18/2013",
        "TIME:09:52");

    doTest("T3",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nOLD ORCHARD ST \nOLD ORCHARD BEACH\n8/17/2013 22:29",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "ADDR:OLD ORCHARD ST",
        "CITY:OLD ORCHARD BEACH",
        "DATE:8/17/2013",
        "TIME:22:29");

    doTest("T4",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n" +
        "PINE POINT VISTA CONDOS\n" +
        "205 EAST GRAND AVE \n" +
        "OLD ORCHARD BEACH\n" +
        "District: OOB\n" +
        "8/16/2013 12:31",

        "CALL:FD MUTUAL AID OLD ORCHARD",
        "PLACE:PINE POINT VISTA CONDOS",
        "ADDR:205 EAST GRAND AVE",
        "CITY:OLD ORCHARD BEACH",
        "UNIT:OOB",
        "DATE:8/16/2013",
        "TIME:12:31");

    doTest("T5",
        "(Imc Solutions Page) FD BRUSH GRASS WOODS RR TRACKS\n96 SPURWINK RD \nSCARBOROUGH\nDistrict: 323\n8/15/2013 15:41",
        "CALL:FD BRUSH GRASS WOODS RR TRACKS",
        "ADDR:96 SPURWINK RD",
        "CITY:SCARBOROUGH",
        "UNIT:323",
        "DATE:8/15/2013",
        "TIME:15:41");

    doTest("T6",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nEXTENDED STAY\n2 ASHLEY DR \nSCARBOROUGH\nDistrict: 714\n8/14/2013 19:37",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:EXTENDED STAY",
        "ADDR:2 ASHLEY DR",
        "CITY:SCARBOROUGH",
        "UNIT:714",
        "DATE:8/14/2013",
        "TIME:19:37");

    doTest("T7",
        "(Imc Solutions Page) FD MARINE WATER RESCUE\nHURD PARK\n63 KING ST \nSCARBOROUGH\nDistrict: 415\n8/14/2013 14:43",
        "CALL:FD MARINE WATER RESCUE",
        "NAME:HURD PARK",
        "ADDR:63 KING ST",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:8/14/2013",
        "TIME:14:43");

    doTest("T8",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\n" +
        "WILLOWDALE GOLF COURSE & CLUBHOUSE\n" +
        "52 WILLOWDALE RD \n" +
        "SCARBOROUGH\n" +
        "District: 7414\n" +
        "8/14/2013 10:13",

        "CALL:FD ALARM FROM ALARM CO",
        "PLACE:WILLOWDALE GOLF COURSE & CLUBHOUSE",
        "ADDR:52 WILLOWDALE RD",
        "CITY:SCARBOROUGH",
        "UNIT:7414",
        "DATE:8/14/2013",
        "TIME:10:13");

    doTest("T9",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nLESLIE RILEY\n6 HARMON ST \nSCARBOROUGH\nDistrict: 127\n8/13/2013 08:42",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:LESLIE RILEY",
        "ADDR:6 HARMON ST",
        "CITY:SCARBOROUGH",
        "UNIT:127",
        "DATE:8/13/2013",
        "TIME:08:42");

    doTest("T10",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nMCDONALDS\n221 ROUTE 1 \nSCARBOROUGH\nDistrict: 799\n8/12/2013 23:47",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:MCDONALDS",
        "ADDR:221 ROUTE 1",
        "CITY:SCARBOROUGH",
        "UNIT:799",
        "DATE:8/12/2013",
        "TIME:23:47");

    doTest("T11",
        "(Imc Solutions Page) FD ALARM FROM MASTERBOX\nKALER VAIL\n382 BLACK POINT RD \nSCARBOROUGH\nDistrict: 127\n8/12/2013 09:12",
        "CALL:FD ALARM FROM MASTERBOX",
        "NAME:KALER VAIL",
        "ADDR:382 BLACK POINT RD",
        "CITY:SCARBOROUGH",
        "UNIT:127",
        "DATE:8/12/2013",
        "TIME:09:12");

    doTest("T12",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\n" +
        "DOUCETTE, RUSSELL & KAY\n" +
        "3 FREDERICK THOMPSON DR \n" +
        "SCARBOROUGH\n" +
        "District: 312\n" +
        "8/11/2013 18:04",

        "CALL:FD ALARM FROM ALARM CO",
        "NAME:DOUCETTE, RUSSELL & KAY",
        "ADDR:3 FREDERICK THOMPSON DR",
        "CITY:SCARBOROUGH",
        "UNIT:312",
        "DATE:8/11/2013",
        "TIME:18:04");

    doTest("T13",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n2 SCOLLARD RD \nOLD ORCHARD BEACH\nDistrict: OOB\n8/11/2013 10:25",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "ADDR:2 SCOLLARD RD",
        "CITY:OLD ORCHARD BEACH",
        "UNIT:OOB",
        "DATE:8/11/2013",
        "TIME:10:25");

    doTest("T14",
        "(Imc Solutions Page) FD CHIM,ELEC,EXPLODE,GAS,STOVE\n" +
        "HANNAFORD SUPERMARKET\n" +
        "31 HANNAFORD DR \n" +
        "SCARBOROUGH\n" +
        "District: 799\n" +
        "8/11/2013 08:04",

        "CALL:FD CHIM,ELEC,EXPLODE,GAS,STOVE",
        "NAME:HANNAFORD SUPERMARKET",
        "ADDR:31 HANNAFORD DR",
        "CITY:SCARBOROUGH",
        "UNIT:799",
        "DATE:8/11/2013",
        "TIME:08:04");

    doTest("T15",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nPHANTOM FIREWORKS\n2 CABELA BLVD \nSCARBOROUGH\nDistrict: 622\n8/10/2013 23:55",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:PHANTOM FIREWORKS",
        "ADDR:2 CABELA BLVD",
        "CITY:SCARBOROUGH",
        "UNIT:622",
        "DATE:8/10/2013",
        "TIME:23:55");

    doTest("T16",
        "(Imc Solutions Page) FD FIRE ALARM SOUNDING\n11 KENNEBAGO DR \nSCARBOROUGH\nDistrict: 6241\n8/10/2013 14:21",
        "CALL:FD FIRE ALARM SOUNDING",
        "ADDR:11 KENNEBAGO DR", // maps to 11 Municipal Dr, Scarborough High School
        "CITY:SCARBOROUGH",
        "UNIT:6241",
        "DATE:8/10/2013",
        "TIME:14:21");

    doTest("T17",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n50 ADELAIDE RD \nOLD ORCHARD BEACH\nDistrict: OOB\n8/10/2013 00:23",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "ADDR:50 ADELAIDE RD",
        "CITY:OLD ORCHARD BEACH",
        "UNIT:OOB",
        "DATE:8/10/2013",
        "TIME:00:23");

    doTest("T18",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nBURNHAM, KENNETH\n23 BURNHAM WOODS CIR \nSCARBOROUGH\nDistrict: 411\n8/9/2013 20:58",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:BURNHAM, KENNETH",
        "ADDR:23 BURNHAM WOODS CIR",
        "CITY:SCARBOROUGH",
        "UNIT:411",
        "DATE:8/9/2013",
        "TIME:20:58");

    doTest("T19",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n" +
        "BAYLEYS CAMPGROUND\n" +
        "275 PINE POINT RD APT R6\n" +
        "SCARBOROUGH\n" +
        "District: 415\n" +
        "8/9/2013 20:29",

        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "NAME:BAYLEYS CAMPGROUND",
        "ADDR:275 PINE POINT RD",
        "APT:R6",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:8/9/2013",
        "TIME:20:29");

    doTest("T20",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n5 KINNEY AVE \nOLD ORCHARD BEACH\nDistrict: OOB\n8/9/2013 17:33",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "ADDR:5 KINNEY AVE",
        "CITY:OLD ORCHARD BEACH",
        "UNIT:OOB",
        "DATE:8/9/2013",
        "TIME:17:33");

    doTest("T21",
        "(Imc Solutions Page) FD WATERFLOW FROM ALARM CO\nSAMS\n440 PAYNE RD \nSCARBOROUGH\nDistrict: 714\n8/7/2013 14:04",
        "CALL:FD WATERFLOW FROM ALARM CO",
        "NAME:SAMS",
        "ADDR:440 PAYNE RD",
        "CITY:SCARBOROUGH",
        "UNIT:714",
        "DATE:8/7/2013",
        "TIME:14:04");

    doTest("T22",
        "(Imc Solutions Page) FD WATERFLOW FROM ALARM CO\nSAMS\n440 PAYNE RD \nSCARBOROUGH\nDistrict: 714\n8/5/2013 18:57",
        "CALL:FD WATERFLOW FROM ALARM CO",
        "NAME:SAMS",
        "ADDR:440 PAYNE RD",
        "CITY:SCARBOROUGH",
        "UNIT:714",
        "DATE:8/5/2013",
        "TIME:18:57");

    doTest("T23",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nMEMORIAL PARK\nFIRST ST \nOLD ORCHARD BEACH\n8/5/2013 12:32",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "NAME:MEMORIAL PARK",
        "ADDR:FIRST ST",
        "CITY:OLD ORCHARD BEACH",
        "DATE:8/5/2013",
        "TIME:12:32");

    doTest("T24",
        "(Imc Solutions Page) FD CHIM,ELEC,EXPLODE,GAS,STOVE\nMOOSE LODGE\n19 SPRING ST \nSCARBOROUGH\nDistrict: 714\n8/5/2013 10:20",
        "CALL:FD CHIM,ELEC,EXPLODE,GAS,STOVE",
        "NAME:MOOSE LODGE",
        "ADDR:19 SPRING ST",
        "CITY:SCARBOROUGH",
        "UNIT:714",
        "DATE:8/5/2013",
        "TIME:10:20");

    doTest("T25",
        "(Imc Solutions Page) FD MARINE WATER RESCUE\nATLANTIC OCEAN\nSCARBOROUGH\n8/4/2013 20:29",
        "CALL:FD MARINE WATER RESCUE",
        "NAME:ATLANTIC OCEAN",
        "ADDR:SCARBOROUGH",
        "DATE:8/4/2013",
        "TIME:20:29");

    doTest("T26",
        "(Imc Solutions Page) FD MARINE WATER RESCUE\nENGINE 4\n12 KING ST \nSCARBOROUGH\nDistrict: 415\n8/4/2013 20:10",
        "CALL:FD MARINE WATER RESCUE",
        "NAME:ENGINE 4",
        "ADDR:12 KING ST",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:8/4/2013",
        "TIME:20:10");

    doTest("T27",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nBAY ST \nSCARBOROUGH\nDistrict: 415\n8/4/2013 10:50",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "ADDR:BAY ST",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:8/4/2013",
        "TIME:10:50");

    doTest("T28",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n" +
        "SEASCAPE CONDOMINIUMS\n" +
        "221 EAST GRAND AVE \n" +
        "OLD ORCHARD BEACH\n" +
        "District: OOB\n" +
        "8/4/2013 08:13",

        "CALL:FD MUTUAL AID OLD ORCHARD",
        "NAME:SEASCAPE CONDOMINIUMS",
        "ADDR:221 EAST GRAND AVE",
        "CITY:OLD ORCHARD BEACH",
        "UNIT:OOB",
        "DATE:8/4/2013",
        "TIME:08:13");

    doTest("T29",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nSPARKLE CAR WASH\n285 ROUTE 1 \nSCARBOROUGH\nDistrict: 742\n8/2/2013 18:28",
        "CALL:FD ALARM FROM ALARM CO",
        "PLACE:SPARKLE CAR WASH",
        "ADDR:285 ROUTE 1", // maps at US 1
        "CITY:SCARBOROUGH",
        "UNIT:742",
        "DATE:8/2/2013",
        "TIME:18:28");

    doTest("T30",
        "(Imc Solutions Page) FD ALARM FROM MASTERBOX\nMAINE VETERANS HOME\n290 ROUTE 1 \nSCARBOROUGH\nDistrict: 742\n8/2/2013 10:39",
        "CALL:FD ALARM FROM MASTERBOX",
        "PLACE:MAINE VETERANS HOME",
        "ADDR:290 ROUTE 1",
        "CITY:SCARBOROUGH",
        "UNIT:742",
        "DATE:8/2/2013",
        "TIME:10:39");

    doTest("T31",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nGIKAS, STEFANOS\n26 AVENUE 5 \nSCARBOROUGH\nDistrict: 415\n8/1/2013 13:06",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "NAME:GIKAS, STEFANOS",
        "ADDR:26 AVENUE 5",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:8/1/2013",
        "TIME:13:06");

    doTest("T32",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nNORWAY SAVINGS BANK\n158 ROUTE 1 \nSCARBOROUGH\nDistrict: 799\n8/1/2013 11:46",
        "CALL:FD ALARM FROM ALARM CO",
        "PLACE:NORWAY SAVINGS BANK",
        "ADDR:158 ROUTE 1",
        "CITY:SCARBOROUGH",
        "UNIT:799",
        "DATE:8/1/2013",
        "TIME:11:46");

    doTest("T33",
        "(Imc Solutions Page) FD ALARM FROM MASTERBOX\nPLEASANT HILL SCHOOL\n143 HIGHLAND AVE \nSCARBOROUGH\nDistrict: 312\n8/1/2013 08:54",
        "CALL:FD ALARM FROM MASTERBOX",
        "PLACE:PLEASANT HILL SCHOOL",
        "ADDR:143 HIGHLAND AVE",
        "CITY:SCARBOROUGH",
        "UNIT:312",
        "DATE:8/1/2013",
        "TIME:08:54");

    doTest("T34",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n295 PINE POINT RD \nSCARBOROUGH\nDistrict: 415\n7/31/2013 19:21",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "ADDR:295 PINE POINT RD",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/31/2013",
        "TIME:19:21");

    doTest("T35",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nEXTENDED STAY\n2 ASHLEY DR \nSCARBOROUGH\nDistrict: 714\n7/31/2013 15:04",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:EXTENDED STAY",
        "ADDR:2 ASHLEY DR",
        "CITY:SCARBOROUGH",
        "UNIT:714",
        "DATE:7/31/2013",
        "TIME:15:04");

    doTest("T36",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nBAYLEYS CAMPGROUND\n275 PINE POINT RD \nSCARBOROUGH\nDistrict: 415\n7/31/2013 09:23",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "NAME:BAYLEYS CAMPGROUND",
        "ADDR:275 PINE POINT RD",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/31/2013",
        "TIME:09:23");

    doTest("T37",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nCLAMBAKE\n356 PINE POINT RD \nSCARBOROUGH\nDistrict: 415\n7/30/2013 19:42",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "NAME:CLAMBAKE",
        "ADDR:356 PINE POINT RD",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/30/2013",
        "TIME:19:42");

    doTest("T38",
        "(Imc Solutions Page) FD WIRES DOWN\n56 JONES CREEK DR \nSCARBOROUGH\nDistrict: 415\n7/30/2013 12:53",
        "CALL:FD WIRES DOWN",
        "ADDR:56 JONES CREEK DR",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/30/2013",
        "TIME:12:53");

    doTest("T39",
        "(Imc Solutions Page) FD ALARM FROM MASTERBOX\nEIGHT CORNERS SCHOOL\n22 MUSSEY RD \nSCARBOROUGH\nDistrict: 714\n7/30/2013 07:06",
        "CALL:FD ALARM FROM MASTERBOX",
        "PLACE:EIGHT CORNERS SCHOOL",
        "ADDR:22 MUSSEY RD",
        "CITY:SCARBOROUGH",
        "UNIT:714",
        "DATE:7/30/2013",
        "TIME:07:06");

    doTest("T40",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n193 PINE POINT RD \nSCARBOROUGH\nDistrict: 411\n7/28/2013 15:05",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "ADDR:193 PINE POINT RD",
        "CITY:SCARBOROUGH",
        "UNIT:411",
        "DATE:7/28/2013",
        "TIME:15:05");

    doTest("T41",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nSEAC\n221 EAST GRAND AVE \nOLD ORCHARD BEACH\n7/28/2013 06:10",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "NAME:SEAC",
        "ADDR:221 EAST GRAND AVE",
        "CITY:OLD ORCHARD BEACH",
        "DATE:7/28/2013",
        "TIME:06:10");

    doTest("T42",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nLERMAN, BRANDON & AIMEE\n6 HEATHER LN \nSCARBOROUGH\nDistrict: 799\n7/27/2013 20:27",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:LERMAN, BRANDON & AIMEE",
        "ADDR:6 HEATHER LN",
        "CITY:SCARBOROUGH",
        "UNIT:799",
        "DATE:7/27/2013",
        "TIME:20:27");

    doTest("T43",
        "(Imc Solutions Page) FD MARINE WATER RESCUE\nATLANTIC AVE \nOLD ORCHARD BEACH\n7/27/2013 17:37",
        "CALL:FD MARINE WATER RESCUE",
        "ADDR:ATLANTIC AVE",
        "CITY:OLD ORCHARD BEACH",
        "DATE:7/27/2013",
        "TIME:17:37");

    doTest("T44",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n" +
        "BAYLEYS CAMPGROUND\n" +
        "275 PINE POINT RD APT F8\n" +
        "SCARBOROUGH\n" +
        "District: 415\n" +
        "7/27/2013 17:01",

        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "NAME:BAYLEYS CAMPGROUND",
        "ADDR:275 PINE POINT RD",
        "APT:F8",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/27/2013",
        "TIME:17:01");

    doTest("T45",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\n" +
        "KENTUCKY FRIED CHICKEN / TACO BELL\n" +
        "400 GALLERY BLVD \n" +
        "SCARBOROUGH\n" +
        "District: 715\n" +
        "7/25/2013 22:52",

        "CALL:FD ALARM FROM ALARM CO",
        "PLACE:KENTUCKY FRIED CHICKEN / TACO BELL",
        "ADDR:400 GALLERY BLVD",
        "CITY:SCARBOROUGH",
        "UNIT:715",
        "DATE:7/25/2013",
        "TIME:22:52");

    doTest("T46",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nDOT FLEET SERVICES\n61 PLEASANT HILL RD \nSCARBOROUGH\nDistrict: 343\n7/25/2013 09:07",
        "CALL:FD ALARM FROM ALARM CO",
        "PLACE:DOT FLEET SERVICES",
        "ADDR:61 PLEASANT HILL RD",
        "CITY:SCARBOROUGH",
        "UNIT:343",
        "DATE:7/25/2013",
        "TIME:09:07");

    doTest("T47",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nDOT FLEET SERVICES\n61 PLEASANT HILL RD \nSCARBOROUGH\nDistrict: 343\n7/25/2013 01:32",
        "CALL:FD ALARM FROM ALARM CO",
        "PLACE:DOT FLEET SERVICES",
        "ADDR:61 PLEASANT HILL RD",
        "CITY:SCARBOROUGH",
        "UNIT:343",
        "DATE:7/25/2013",
        "TIME:01:32");

    doTest("T48",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\n" +
        "MARKET PLACE BUSINESS BUILDING\n" +
        "144 ROUTE 1 APT CS\n" +
        "SCARBOROUGH\n" +
        "District: 7232\n" +
        "7/24/2013 18:11",

        "CALL:FD ALARM FROM ALARM CO",
        "PLACE:MARKET PLACE BUSINESS BUILDING",
        "ADDR:144 ROUTE 1",
        "APT:CS",
        "CITY:SCARBOROUGH",
        "UNIT:7232",
        "DATE:7/24/2013",
        "TIME:18:11");

    doTest("T49",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n" +
        "POWDERHORN CAMPGROUND\n" +
        "48 CASCADE RD \n" +
        "OLD ORCHARD BEACH\n" +
        "District: OOB\n" +
        "7/24/2013 11:58",

        "CALL:FD MUTUAL AID OLD ORCHARD",
        "NAME:POWDERHORN CAMPGROUND",
        "ADDR:48 CASCADE RD",
        "CITY:OLD ORCHARD BEACH",
        "UNIT:OOB",
        "DATE:7/24/2013",
        "TIME:11:58");

    doTest("T50",
        "(Imc Solutions Page) FD ALARM FROM MASTERBOX\n" +
        "MAINE MEDICAL CENTER RADIOLOGY\n" +
        "100 CAMPUS DR APT 113\n" +
        "SCARBOROUGH\n" +
        "District: 7232\n" +
        "7/23/2013 11:54",

        "CALL:FD ALARM FROM MASTERBOX",
        "PLACE:MAINE MEDICAL CENTER RADIOLOGY",
        "ADDR:100 CAMPUS DR",
        "APT:113",
        "CITY:SCARBOROUGH",
        "UNIT:7232",
        "DATE:7/23/2013",
        "TIME:11:54");

    doTest("T51",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nDUNSTAN DENTAL\n618 ROUTE 1 APT 4\nSCARBOROUGH\nDistrict: 651\n7/23/2013 11:34",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:DUNSTAN DENTAL",
        "ADDR:618 ROUTE 1",
        "APT:4",
        "CITY:SCARBOROUGH",
        "UNIT:651",
        "DATE:7/23/2013",
        "TIME:11:34");

    doTest("T52",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nVOGEL, JAMES AND TERRI\n1 COLE FARM DR \nSCARBOROUGH\nDistrict: 127\n7/21/2013 18:56",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:VOGEL, JAMES AND TERRI",
        "ADDR:1 COLE FARM DR",
        "CITY:SCARBOROUGH",
        "UNIT:127",
        "DATE:7/21/2013",
        "TIME:18:56");

    doTest("T53",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n2 PINE BROOK TER \nOLD ORCHARD BEACH\nDistrict: OOB\n7/21/2013 17:46",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "ADDR:2 PINE BROOK TER",
        "CITY:OLD ORCHARD BEACH",
        "UNIT:OOB",
        "DATE:7/21/2013",
        "TIME:17:46");

    doTest("T54",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n32 PILLSBURY DR \nSCARBOROUGH\nDistrict: 415\n7/21/2013 13:38",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "ADDR:32 PILLSBURY DR",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/21/2013",
        "TIME:13:38");

    doTest("T55",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nWALGREENS\n233 ROUTE 1 \nSCARBOROUGH\nDistrict: 799\n7/21/2013 10:39",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:WALGREENS",
        "ADDR:233 ROUTE 1",
        "CITY:SCARBOROUGH",
        "UNIT:799",
        "DATE:7/21/2013",
        "TIME:10:39");

    doTest("T56",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n247 PINE POINT RD \nSCARBOROUGH\nDistrict: 411\n7/20/2013 16:13",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "ADDR:247 PINE POINT RD",
        "CITY:SCARBOROUGH",
        "UNIT:411",
        "DATE:7/20/2013",
        "TIME:16:13");

    doTest("T57",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nGIKAS, STEFANOS\n26 AVENUE 5 \nSCARBOROUGH\nDistrict: 415\n7/20/2013 08:32",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "NAME:GIKAS, STEFANOS",
        "ADDR:26 AVENUE 5",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/20/2013",
        "TIME:08:32");

    doTest("T58",
        "(Imc Solutions Page) FD WIRES DOWN\nCLAMBAKE\n356 PINE POINT RD \nSCARBOROUGH\nDistrict: 415\n7/20/2013 08:28",
        "CALL:FD WIRES DOWN",
        "NAME:CLAMBAKE",
        "ADDR:356 PINE POINT RD",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/20/2013",
        "TIME:08:28");

    doTest("T59",
        "(Imc Solutions Page) FD LOW BATTERY\nSANITARY DISTRICT PLANT\n415 BLACK POINT RD \nSCARBOROUGH\nDistrict: 127\n7/19/2013 19:15",
        "CALL:FD LOW BATTERY",
        "PLACE:SANITARY DISTRICT PLANT",
        "ADDR:415 BLACK POINT RD",
        "CITY:SCARBOROUGH",
        "UNIT:127",
        "DATE:7/19/2013",
        "TIME:19:15");

    doTest("T60",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nGIKAS, STEFANOS\n26 AVENUE 5 \nSCARBOROUGH\nDistrict: 415\n7/19/2013 13:43",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "NAME:GIKAS, STEFANOS",
        "ADDR:26 AVENUE 5",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/19/2013",
        "TIME:13:43");

    doTest("T61",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\n128 HOLMES RD \nSCARBOROUGH\nDistrict: 629\n7/19/2013 13:34",
        "CALL:FD ALARM FROM ALARM CO",
        "ADDR:128 HOLMES RD",
        "CITY:SCARBOROUGH",
        "UNIT:629",
        "DATE:7/19/2013",
        "TIME:13:34");

    doTest("T62",
        "(Imc Solutions Page) FD BRUSH GRASS WOODS RR TRACKS\n" +
        "HANNAFORD GENERAL OFFICE\n" +
        "145 PLEASANT HILL RD \n" +
        "SCARBOROUGH\n" +
        "District: 312\n" +
        "7/18/2013 15:12",

        "CALL:FD BRUSH GRASS WOODS RR TRACKS",
        "PLACE:HANNAFORD GENERAL OFFICE",
        "ADDR:145 PLEASANT HILL RD",
        "CITY:SCARBOROUGH",
        "UNIT:312",
        "DATE:7/18/2013",
        "TIME:15:12");

    doTest("T63",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nGOLF AND SKI WAREHOUSE\n273 PAYNE RD APT 100\nSCARBOROUGH\nDistrict: 622\n7/17/2013 22:28",
        "CALL:FD ALARM FROM ALARM CO",
        "PLACE:GOLF AND SKI WAREHOUSE",
        "ADDR:273 PAYNE RD",
        "APT:100",
        "CITY:SCARBOROUGH",
        "UNIT:622",
        "DATE:7/17/2013",
        "TIME:22:28");

    doTest("T64",
        "(Imc Solutions Page) FD FIRE STRUCTURE, PLANE CRASH\n24 CARRIAGE WAY \nSCARBOROUGH\nDistrict: 651\n7/17/2013 22:26",
        "CALL:FD FIRE STRUCTURE, PLANE CRASH",
        "ADDR:24 CARRIAGE WAY",
        "CITY:SCARBOROUGH",
        "UNIT:651",
        "DATE:7/17/2013",
        "TIME:22:26");

    doTest("T65",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nDUNSTAN VILLAGE SQUARE\n605 ROUTE 1 \nSCARBOROUGH\nDistrict: 651\n7/17/2013 21:37",
        "CALL:FD ALARM FROM ALARM CO",
        "ADDR:DUNSTAN VILLAGE SQUARE",
        "INFO:605 ROUTE 1 / SCARBOROUGH",
        "UNIT:651",
        "DATE:7/17/2013",
        "TIME:21:37");

    doTest("T66",
        "(Imc Solutions Page) FD MARINE WATER RESCUE\nATLANTIC OCEAN\nSCARBOROUGH\nDistrict: OTH\n7/17/2013 14:17",
        "CALL:FD MARINE WATER RESCUE",
        "NAME:ATLANTIC OCEAN",
        "ADDR:SCARBOROUGH",
        "UNIT:OTH",
        "DATE:7/17/2013",
        "TIME:14:17");

    doTest("T67",
        "(Imc Solutions Page) FD WATERFLOW FROM MASTERBOX\n" +
        "SCARBOROUGH MIDDLE SCHOOL\n" +
        "21 QUENTIN DR \n" +
        "SCARBOROUGH\n" +
        "District: 7171\n" +
        "7/16/2013 08:42",

        "CALL:FD WATERFLOW FROM MASTERBOX",
        "PLACE:SCARBOROUGH MIDDLE SCHOOL",
        "ADDR:21 QUENTIN DR",
        "CITY:SCARBOROUGH",
        "UNIT:7171",
        "DATE:7/16/2013",
        "TIME:08:42");

    doTest("T68",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nROCK AND ROLL DINER\n623 ROUTE 1 \nSCARBOROUGH\nDistrict: 651\n7/15/2013 11:50",
        "CALL:FD ALARM FROM ALARM CO",
        "PLACE:ROCK AND ROLL DINER",
        "ADDR:623 ROUTE 1",
        "CITY:SCARBOROUGH",
        "UNIT:651",
        "DATE:7/15/2013",
        "TIME:11:50");

    doTest("T69",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n215 EAST GRAND AVE \nOLD ORCHARD BEACH\nDistrict: OOB\n7/14/2013 02:40",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "ADDR:215 EAST GRAND AVE",
        "CITY:OLD ORCHARD BEACH",
        "UNIT:OOB",
        "DATE:7/14/2013",
        "TIME:02:40");

    doTest("T70",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nSTEELE, CAROL\n7 SANCTUARY LN \nSCARBOROUGH\nDistrict: 127\n7/11/2013 13:46",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:STEELE, CAROL",
        "ADDR:7 SANCTUARY LN",
        "CITY:SCARBOROUGH",
        "UNIT:127",
        "DATE:7/11/2013",
        "TIME:13:46");

    doTest("T71",
        "(Imc Solutions Page) FD CHIM,ELEC,EXPLODE,GAS,STOVE\n" +
        "MUNICIPAL STORAGE BUILDING\n" +
        "20 WASHINGTON AVE \n" +
        "SCARBOROUGH\n" +
        "District: 637\n" +
        "7/10/2013 12:12",

        "CALL:FD CHIM,ELEC,EXPLODE,GAS,STOVE",
        "PLACE:MUNICIPAL STORAGE BUILDING",
        "ADDR:20 WASHINGTON AVE",
        "CITY:SCARBOROUGH",
        "UNIT:637",
        "DATE:7/10/2013",
        "TIME:12:12");

    doTest("T72",
        "(Imc Solutions Page) FD MARINE WATER RESCUE\nATLANTIC OCEAN \nOLD ORCHARD BEACH\nDistrict: OOB\n7/10/2013 00:17",
        "CALL:FD MARINE WATER RESCUE",
        "NAME:ATLANTIC OCEAN",
        "ADDR:OLD ORCHARD BEACH",
        "UNIT:OOB",
        "DATE:7/10/2013",
        "TIME:00:17");

    doTest("T73",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nPORTLAND AVE AND FOOTE ST \nOTHER TOWN\n7/9/2013 15:08",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "ADDR:PORTLAND AVE AND FOOTE ST",
        "MADDR:PORTLAND AVE & FOOTE ST",
        "INFO:OTHER TOWN",
        "DATE:7/9/2013",
        "TIME:15:08");

    doTest("T74",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nMOBY DICK\n74 EAST GRAND AVE \nOLD ORCHARD BEACH\n7/8/2013 18:37",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "NAME:MOBY DICK",
        "ADDR:74 EAST GRAND AVE",
        "CITY:OLD ORCHARD BEACH",
        "DATE:7/8/2013",
        "TIME:18:37");

    doTest("T75",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nDUNSTAN VILLAGE SQUARE\n605 ROUTE 1 \nSCARBOROUGH\nDistrict: 651\n7/8/2013 07:01",
        "CALL:FD ALARM FROM ALARM CO",
        "ADDR:DUNSTAN VILLAGE SQUARE",
        "INFO:605 ROUTE 1 / SCARBOROUGH",
        "UNIT:651",
        "DATE:7/8/2013",
        "TIME:07:01");

    doTest("T76",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nHIGGINS BEACH INN\n34 OCEAN AVE \nSCARBOROUGH\nDistrict: 127\n7/8/2013 06:49",
        "CALL:FD ALARM FROM ALARM CO",
        "PLACE:HIGGINS BEACH INN",
        "ADDR:34 OCEAN AVE",
        "CITY:SCARBOROUGH",
        "UNIT:127",
        "DATE:7/8/2013",
        "TIME:06:49");

    doTest("T77",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nHURD PARK SNACK BAR\n63 KING ST \nSCARBOROUGH\nDistrict: 415\n7/6/2013 13:54",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "PLACE:HURD PARK SNACK BAR",
        "ADDR:63 KING ST",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/6/2013",
        "TIME:13:54");

    doTest("T78",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nSOHO\n39 WEST GRAND AVE \nOLD ORCHARD BEACH\n7/6/2013 10:54",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "NAME:SOHO",
        "ADDR:39 WEST GRAND AVE",
        "CITY:OLD ORCHARD BEACH",
        "DATE:7/6/2013",
        "TIME:10:54");

    doTest("T79",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nHURD PARK\n63 KING ST \nSCARBOROUGH\nDistrict: 415\n7/5/2013 17:00",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "NAME:HURD PARK",
        "ADDR:63 KING ST",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/5/2013",
        "TIME:17:00");

    doTest("T80",
        "(Imc Solutions Page) FD CHIM,ELEC,EXPLODE,GAS,STOVE\n" +
        "DOUCETTE, RUSSELL & KAY\n" +
        "3 FREDERICK THOMPSON DR \n" +
        "SCARBOROUGH\n" +
        "District: 312\n" +
        "7/5/2013 15:13",

        "CALL:FD CHIM,ELEC,EXPLODE,GAS,STOVE",
        "NAME:DOUCETTE, RUSSELL & KAY",
        "ADDR:3 FREDERICK THOMPSON DR",
        "CITY:SCARBOROUGH",
        "UNIT:312",
        "DATE:7/5/2013",
        "TIME:15:13");

    doTest("T81",
        "(Imc Solutions Page) FD WASH,WIRES,MULCH,BURN,SMELL\n" +
        "LAROU APARTMENTS\n" +
        "74 KING ST APT 1,2,3\n" +
        "SCARBOROUGH\n" +
        "District: 415\n" +
        "7/4/2013 22:57",

        "CALL:FD WASH,WIRES,MULCH,BURN,SMELL",
        "NAME:LAROU APARTMENTS",
        "ADDR:74 KING ST",
        "APT:1, 2, 3",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/4/2013",
        "TIME:22:57");

    doTest("T82",
        "(Imc Solutions Page) FD CHIM,ELEC,EXPLODE,GAS,STOVE\n9 STONEY CREEK DR \nSCARBOROUGH\nDistrict: 742\n7/4/2013 21:53",
        "CALL:FD CHIM,ELEC,EXPLODE,GAS,STOVE",
        "ADDR:9 STONEY CREEK DR",
        "CITY:SCARBOROUGH",
        "UNIT:742",
        "DATE:7/4/2013",
        "TIME:21:53");

    doTest("T83",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n9 PILLSBURY DR \nSCARBOROUGH\nDistrict: 415\n7/4/2013 18:28",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "ADDR:9 PILLSBURY DR",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/4/2013",
        "TIME:18:28");

    doTest("T84",
        "(Imc Solutions Page) FD MARINE WATER RESCUE\n35 PILLSBURY DR \nSCARBOROUGH\nDistrict: 415\n7/4/2013 17:29",
        "CALL:FD MARINE WATER RESCUE",
        "ADDR:35 PILLSBURY DR",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/4/2013",
        "TIME:17:29");

    doTest("T85",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n" +
        "BAYLEYS CAMPGROUND\n" +
        "275 PINE POINT RD APT 709\n" +
        "SCARBOROUGH\n" +
        "District: 415\n" +
        "7/4/2013 15:27",

        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "NAME:BAYLEYS CAMPGROUND",
        "ADDR:275 PINE POINT RD",
        "APT:709",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/4/2013",
        "TIME:15:27");

    doTest("T86",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nCOPLEY LAREINE HOTEL\n8 HARRISBURG ST \nOLD ORCHARD BEACH\n7/4/2013 15:03",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "PLACE:COPLEY LAREINE HOTEL",
        "ADDR:8 HARRISBURG ST",
        "CITY:OLD ORCHARD BEACH",
        "DATE:7/4/2013",
        "TIME:15:03");

    doTest("T87",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nWEEKLY, RICHARD AND MARGARET\n8 SMITHERS WAY \nSCARBOROUGH\nDistrict: 127\n7/4/2013 14:12",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:WEEKLY, RICHARD AND MARGARET",
        "ADDR:8 SMITHERS WAY",
        "CITY:SCARBOROUGH",
        "UNIT:127",
        "DATE:7/4/2013",
        "TIME:14:12");

    doTest("T88",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\nATLANTIC OCEAN\nOLD ORCHARD BEACH\nDistrict: OOB\n7/3/2013 02:52",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "NAME:ATLANTIC OCEAN",
        "ADDR:OLD ORCHARD BEACH",
        "UNIT:OOB",
        "DATE:7/3/2013",
        "TIME:02:52");

    doTest("T89",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nWAGON MASTERS\n12 BORDER RD \nSCARBOROUGH\nDistrict: 715\n7/2/2013 19:04",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:WAGON MASTERS",
        "ADDR:12 BORDER RD",
        "CITY:SCARBOROUGH",
        "UNIT:715",
        "DATE:7/2/2013",
        "TIME:19:04");

    doTest("T90",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n" +
        "BAYLEYS CAMPGROUND\n" +
        "275 PINE POINT RD APT 317\n" +
        "SCARBOROUGH\n" +
        "District: 415\n" +
        "7/2/2013 17:55",

        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "NAME:BAYLEYS CAMPGROUND",
        "ADDR:275 PINE POINT RD",
        "APT:317",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/2/2013",
        "TIME:17:55");

    doTest("T91",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nBAYLEYS CAMPGROUND\n275 PINE POINT RD \nSCARBOROUGH\nDistrict: 415\n7/1/2013 22:30",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "NAME:BAYLEYS CAMPGROUND",
        "ADDR:275 PINE POINT RD",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:7/1/2013",
        "TIME:22:30");

    doTest("T92",
        "(Imc Solutions Page) FD ALARM FROM MASTERBOX\nPINE POINT NURSING CENTER\n67 PINE POINT RD \nSCARBOROUGH\nDistrict: 654\n7/1/2013 04:59",
        "CALL:FD ALARM FROM MASTERBOX",
        "PLACE:PINE POINT NURSING CENTER",
        "ADDR:67 PINE POINT RD",
        "CITY:SCARBOROUGH",
        "UNIT:654",
        "DATE:7/1/2013",
        "TIME:04:59");

    doTest("T93",
        "(Imc Solutions Page) FD ALARM FROM MASTERBOX\n" +
        "PINE POINT NURSING CENTER\n" +
        "67 PINE POINT RD \n" +
        "SCARBOROUGH\n" +
        "District: 654\n" +
        "6/30/2013 18:18",

        "CALL:FD ALARM FROM MASTERBOX",
        "PLACE:PINE POINT NURSING CENTER",
        "ADDR:67 PINE POINT RD",
        "CITY:SCARBOROUGH",
        "UNIT:654",
        "DATE:6/30/2013",
        "TIME:18:18");

    doTest("T94",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\nENGINE 4\n12 KING ST \nSCARBOROUGH\nDistrict: 415\n6/30/2013 13:46",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "NAME:ENGINE 4",
        "ADDR:12 KING ST",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:6/30/2013",
        "TIME:13:46");

    doTest("T95",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n12 BELMONT TER \nGORHAM\n6/30/2013 13:28",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "ADDR:12 BELMONT TER",
        "CITY:GORHAM",
        "DATE:6/30/2013",
        "TIME:13:28");

    doTest("T96",
        "(Imc Solutions Page) FD MEDICAL W/ ENGINE ASSIST\n28 KING ST \nSCARBOROUGH\nDistrict: 415\n6/30/2013 12:15",
        "CALL:FD MEDICAL W/ ENGINE ASSIST",
        "ADDR:28 KING ST",
        "CITY:SCARBOROUGH",
        "UNIT:415",
        "DATE:6/30/2013",
        "TIME:12:15");

    doTest("T97",
        "(Imc Solutions Page) FD ALARM FROM ALARM CO\nEXTENDED STAY\n2 ASHLEY DR \nSCARBOROUGH\nDistrict: 714\n6/29/2013 20:42",
        "CALL:FD ALARM FROM ALARM CO",
        "NAME:EXTENDED STAY",
        "ADDR:2 ASHLEY DR",
        "CITY:SCARBOROUGH",
        "UNIT:714",
        "DATE:6/29/2013",
        "TIME:20:42");

    doTest("T98",
        "(Imc Solutions Page) FD MUTUAL AID OLD ORCHARD\n24 PUFFIN ST \nOLD ORCHARD BEACH\nDistrict: OOB\n6/29/2013 19:29",
        "CALL:FD MUTUAL AID OLD ORCHARD",
        "ADDR:24 PUFFIN ST",
        "CITY:OLD ORCHARD BEACH",
        "UNIT:OOB",
        "DATE:6/29/2013",
        "TIME:19:29");

    
  }
  
  public static void main(String[] args) {
    new MECumberlandCountyParserTest().generateTests("T1");
  }
}