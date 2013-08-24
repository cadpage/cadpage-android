package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDDorchesterCountyParser;

import org.junit.Test;


/*
Dorchester County, MD
Contact:ryan travers <traversboy@gmail.com>
Sender:dor911@docogonet.com
DOR911:CT:COMMERCIAL FIRE ALAR 2715 OCEAN GTWY @HOLIDAY INN CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC
DOR911:CT:GAS LEAK OUTSIDE 513 RACE ST CAMB BOX:1-2 DUE: EN1-1 EN1-2 :DC
DOR911:CT:VEHICLE FIRE HARDEES @800 WOODS RD CAMB BOX:1-1 DUE:EN1-3 EN1-4 :DC
DOR911:CT:STRUCTURE FIRE 118 VIRGINIA AVE CAMB BOX:1-1 DUE: EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100 :DC
DOR911:CT:SICK PERSON 5226 WOODS RD @CAMBRIDGE CLUB APT 6 APT 6127 CAMB BOX:1-1 DUE: P101 RS1-1 :DC

Contact: cwaynecook@aol.com <cwaynecook@aol.com>
Sender: DOR911@docogonet.com
DOR911:CT:BOAT UNK DISTRESS OYSTERSHELL PT BOX:21-5 DUE:EN21-1 EN21-2 DV1-1 BT1-1 BT26-1 P100 A16-1 :DC

Contact: Active911
Agency name: Rescue Fire Company Sta. 1
Location: Cambridge, MD, United States
Sender: DOR911@docogonet.com

(Message Forwarded by PageGate) \r\nCT:CHOKING 800 PHILLIPS ST CAMB BOX:1-2 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:SICK PERSON 2210 DAILSVILLE RD CAMB BOX:1-5 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:PAGER TEST EMS OFFICE @829 FIELDCREST RD CAMB BOX:1-1 DUE:P100 P101 P200 P500 P600 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:BREATHING PROBLEMS 2439 ROCK DR CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:TRANSFER STATION 46 @1902 CHURCH CREEK RD CHUR BOX:46-1 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:ABDOMINAL PAINS 433 WILLIS ST CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:PREG/CHILDBIRTH/MATR 617 SCHOOL HOUSE LN CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:FALLS 701 RACE ST @BRADFORD HOUSE APT 108 CAMB BOX:1-2 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:FALLS 1374 CAMBRIDGE BLTW CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:BREATHING PROBLEMS 208 GLENBURN AVE CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:COMMERCIAL FIRE ALAR 824 FAIRMOUNT AVE @SOJOURNER DOUGLAS CO CAMB BOX:1-2 DUE:EN1-1 EN1-2 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:PAGER TEST EMERGENCY MANAGEMENT @829 FIELDCREST RD CAMB BOX:1-1 DUE:P100 P200 P500 P600 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:BREATHING PROBLEMS 303 BUNKER ST APT A CAMB BOX:1-1 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:PREG/CHILDBIRTH/MATR 300 BYRN ST @DORCHESTER GENERAL CAMB BOX:1-1 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:PREG/CHILDBIRTH/MATR 706 HUGHLETT ST CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:BREATHING PROBLEMS 503 BYRN ST CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:CONVULSIONS/SEIZURES DISTRICT COURT @310 GAY ST CAMB BOX:1-1 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:PAGER TEST EMS OFFICE @829 FIELDCREST RD CAMB BOX:1-1 DUE:P100 P101 P200 P500 P600 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:SICK PERSON 14 HOLLY TER CAMB BOX:1-3 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:MOTOR VEH. COLLISION JACKTOWN TRAILER PAR @2950 OCEAN GTWY CAMB BOX:1-4 DUE:RS1-1 EN1-1 EN1-2 P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:STAB/GUNSHOT/PENETRA 600 RACE ST @CENTER MARKET CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:FALLS WALMART @2775 DORCHESTER SQUARE MALL CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:PAGER TEST EMS OFFICE @829 FIELDCREST RD CAMB BOX:1-1 DUE:P100 P101 P200 P500 P600 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:COMMERCIAL FIRE ALAR 904 WOODS RD @PROTENERGY CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:UNKNOWN PROBLEM WALMART @2775 DORCHESTER SQUARE MALL CAMB BOX:1-1 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:DIABETIC PROBLEMS 908 ROSLYN AVE CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:OVERDOSE/POISONING 511 HUBERT ST CAMB BOX:1-2 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:UNCONSCIOUS/FAINTING 525 GLENBURN AVE @CHESAPEAKE WOODS CEN APT 21B CAMB BOX:1-2 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:CHEST PAINS 830 CHESAPEAKE DR @CAMB VETERANS CLINIC CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:EYE PROBLEM/INJURY 408 CEMETERY AVE CAMB BOX:1-1 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:FALLS 503 MUIR ST @NEW HORIZON APARTMEN APT 206 CAMB BOX:1-2 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:STROKE (CVA) 1354 CAMBRIDGE BELTWAY CAMB BOX:1-1 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:SICK PERSON ZION UNITED METHODIS @612 LOCUST ST CAMB BOX:1-2 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:FALLS 321 CHOPTANK AVE CAMB BOX:1-2 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:SICK PERSON 6143 CASTLE HAVEN RD CAMB BOX:36-1 DUE:P101 A31-1 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:SICK PERSON 4803 EGYPT RD CAMB BOX:1-5 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:STROKE (CVA) 3007 N SKIPJACK DR CAMB BOX:1-4 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:PAGER TEST EMS OFFICE @829 FIELDCREST RD CAMB BOX:1-1 DUE:P100 P101 P200 P500 P600 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:BREATHING PROBLEMS 212 DORCHESTER AVE CAMB BOX:1-1 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:ABDOMINAL PAINS 6143 CASTLE HAVEN RD CAMB BOX:36-1 DUE:P100 A31-1 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:DIABETIC PROBLEMS 303 BUNKER ST APT A CAMB BOX:1-1 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:SICK PERSON 3005 N SKIPJACK DR CAMB BOX:1-4 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:MEDICAL ASSIST 1232 CHESTNUT PL CAMB BOX:1-2 DUE:EN1-1 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:BACK PAIN-NONTRAUMA 1232 CHESTNUT PL APT 201 CAMB BOX:1-2 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:UNKNOWN PROBLEM 518 GLENBURN AVE @GLENBURN HOUSE APT 202 CAMB BOX:1-2 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:COMMERCIAL FIRE ALAR 821 FIELDCREST RD @PATOMAC RIDGE CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:SICK PERSON DENNYS @781 SUNBURST HWY CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:CONVULSIONS/SEIZURES 416 PLEASANT ST CAMB BOX:1-1 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:PAGER TEST EMS OFFICE @829 FIELDCREST RD CAMB BOX:1-1 DUE:P100 P101 P200 P500 P600 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:BREATHING PROBLEMS 859 PARK LN CAMB BOX:1-2 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:CHEST PAIN 317 WILLIS ST CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:RESIDENTIAL FIRE ALA 2520 WESTWIND BLVD CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:CHEST PAINS 918 ROSLYN AVE CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:BREATHING PROBLEMS 614 GOLDSBOROUGH AVE CAMB BOX:1-2 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:SICK PERSON 210 METEOR AVE APT 601 CAMB BOX:1-1 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:ABDOMINAL PAINS 501 DOBSON ST CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:(SMALL) FUEL SPILL 209 HAYWARD ST @PEP UP CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:STRUCTURE FIRE 615 DOUGLAS ST CAMB BOX:1-2 DUE:EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:CHEST PAINS 503 MUIR ST @NEW HORIZON APARTMEN APT 202 CAMB BOX:1-2 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:CONVULSIONS/SEIZURES 828 PARK LN CAMB BOX:1-2 DUE:P100 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:RESIDENTIAL FIRE ALA 104 RIVERSIDE DR CAMB BOX:1-3 DUE::DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:PAGER TEST EMS OFFICE @829 FIELDCREST RD CAMB BOX:1-1 DUE:P100 P101 P200 P500 P600 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:911 TEST CALL STATION 100 @8 WASHINGTON ST CAMB BOX:1-1 DUE:A103 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:UNKNOWN PROBLEM RIGBY AVE/ FAIRMOUNT AVE  BOX:1-2 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:PREG/CHILDBIRTH/MATR 508 GREENWOOD AVE APT 301 CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:STROKE (CVA) 104 JOHNSON ST CAMB BOX:1-3 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:PREG/CHILDBIRTH/MATR 617 SCHOOL HOUSE LN CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:SICK PERSON 408 CEMETERY AVE CAMB BOX:1-1 DUE:P101 :DC\r\n\r\n
(Message Forwarded by PageGate) \r\nCT:FALLS 124 SECOND ST SECR BOX:16-1 DUE:P100 A16-1 :DC\r\n\r\n
(Message forwarded by pagegate) DOR911:CT:STRUCTURE FIRE 318 CRUSADER RD APT 203 CAMB BOX:1-1\r\nDUE:EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100 :DC\r\n
(Message forwarded by PageGate) DOR911:CT:STROKE (CVA) 520 GLENBURN AVE @MALLARD BAY UNIT 200 CAMB\r\nBOX:1-2 DUE:P100 P101 :DC\r\n

***/

public class MDDorchesterCountyParserTest extends BaseParserTest {
  
  public MDDorchesterCountyParserTest() {
    setParser(new MDDorchesterCountyParser(), "DORCHESTER COUNTY", "MD");
  }
  
  @Test
  public void testRyanTravers() {

    doTest("T1",
        "DOR911:CT:COMMERCIAL FIRE ALAR 2715 OCEAN GTWY @HOLIDAY INN CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC",
        "CALL:COMMERCIAL FIRE ALAR",
        "ADDR:2715 OCEAN GTWY",
        "CITY:CAMBRIDGE",
        "PLACE:HOLIDAY INN",
        "BOX:1-1",
        "UNIT:EN1-1 EN1-2");

    doTest("T2",
        "DOR911:CT:GAS LEAK OUTSIDE 513 RACE ST CAMB BOX:1-2 DUE: EN1-1 EN1-2 :DC",
        "CALL:GAS LEAK OUTSIDE",
        "ADDR:513 RACE ST",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:EN1-1 EN1-2");

    doTest("T3",
        "DOR911:CT:VEHICLE FIRE HARDEES @800 WOODS RD CAMB BOX:1-1 DUE:EN1-3 EN1-4 :DC",
        "CALL:VEHICLE FIRE HARDEES",
        "ADDR:800 WOODS RD",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:EN1-3 EN1-4");

    doTest("T4",
        "DOR911:CT:STRUCTURE FIRE 118 VIRGINIA AVE CAMB BOX:1-1 DUE: EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100 :DC",
        "CALL:STRUCTURE FIRE",
        "ADDR:118 VIRGINIA AVE",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100");

    doTest("T5",
        "DOR911:CT:SICK PERSON 5226 WOODS RD @CAMBRIDGE CLUB APT 6 APT 6127 CAMB BOX:1-1 DUE: P101 RS1-1 :DC",
        "CALL:SICK PERSON",
        "ADDR:5226 WOODS RD",
        "APT:6 APT 6127",
        "CITY:CAMBRIDGE",
        "PLACE:CAMBRIDGE CLUB",
        "BOX:1-1",
        "UNIT:P101 RS1-1");

  }
  
  @Test
  public void testCWayneCook() {

    doTest("T1",
        "DOR911:CT:BOAT UNK DISTRESS OYSTERSHELL PT BOX:21-5 DUE:EN21-1 EN21-2 DV1-1 BT1-1 BT26-1 P100 A16-1 :DC",
        "CALL:BOAT UNK DISTRESS",
        "ADDR:OYSTERSHELL PT",
        "BOX:21-5",
        "UNIT:EN21-1 EN21-2 DV1-1 BT1-1 BT26-1 P100 A16-1");
   
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Message Forwarded by PageGate) \r\nCT:CHOKING 800 PHILLIPS ST CAMB BOX:1-2 DUE:P101 :DC\r\n\r\n",
        "CALL:CHOKING",
        "ADDR:800 PHILLIPS ST",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P101");

    doTest("T2",
        "(Message Forwarded by PageGate) \r\nCT:SICK PERSON 2210 DAILSVILLE RD CAMB BOX:1-5 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:SICK PERSON",
        "ADDR:2210 DAILSVILLE RD",
        "CITY:CAMBRIDGE",
        "BOX:1-5",
        "UNIT:P100 P101");

    doTest("T3",
        "(Message Forwarded by PageGate) \r\nCT:PAGER TEST EMS OFFICE @829 FIELDCREST RD CAMB BOX:1-1 DUE:P100 P101 P200 P500 P600 :DC\r\n\r\n",
        "CALL:PAGER TEST EMS OFFICE",
        "ADDR:829 FIELDCREST RD",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100 P101 P200 P500 P600");

    doTest("T4",
        "(Message Forwarded by PageGate) \r\nCT:BREATHING PROBLEMS 2439 ROCK DR CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:BREATHING PROBLEMS",
        "ADDR:2439 ROCK DR",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P100 P101");

    doTest("T5",
        "(Message Forwarded by PageGate) \r\nCT:TRANSFER STATION 46 @1902 CHURCH CREEK RD CHUR BOX:46-1 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:TRANSFER STATION 46",
        "ADDR:1902 CHURCH CREEK RD",
        "CITY:CHURCH CREEK",
        "BOX:46-1",
        "UNIT:P100 P101");

    doTest("T6",
        "(Message Forwarded by PageGate) \r\nCT:ABDOMINAL PAINS 433 WILLIS ST CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:ABDOMINAL PAINS",
        "ADDR:433 WILLIS ST",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P100 P101");

    doTest("T7",
        "(Message Forwarded by PageGate) \r\nCT:PREG/CHILDBIRTH/MATR 617 SCHOOL HOUSE LN CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:PREG/CHILDBIRTH/MATR",
        "ADDR:617 SCHOOL HOUSE LN",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P100 P101");

    doTest("T8",
        "(Message Forwarded by PageGate) \r\nCT:FALLS 701 RACE ST @BRADFORD HOUSE APT 108 CAMB BOX:1-2 DUE:P100 :DC\r\n\r\n",
        "CALL:FALLS",
        "ADDR:701 RACE ST",
        "APT:108",
        "CITY:CAMBRIDGE",
        "PLACE:BRADFORD HOUSE",
        "BOX:1-2",
        "UNIT:P100");

    doTest("T9",
        "(Message Forwarded by PageGate) \r\nCT:FALLS 1374 CAMBRIDGE BLTW CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n",
        "CALL:FALLS",
        "ADDR:1374 CAMBRIDGE BLTW",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100");

    doTest("T10",
        "(Message Forwarded by PageGate) \r\nCT:BREATHING PROBLEMS 208 GLENBURN AVE CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:BREATHING PROBLEMS",
        "ADDR:208 GLENBURN AVE",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P100 P101");

    doTest("T11",
        "(Message Forwarded by PageGate) \r\n" +
        "CT:COMMERCIAL FIRE ALAR 824 FAIRMOUNT AVE @SOJOURNER DOUGLAS CO CAMB BOX:1-2 DUE:EN1-1 EN1-2 :DC\r\n" +
        "\r\n",

        "CALL:COMMERCIAL FIRE ALAR",
        "ADDR:824 FAIRMOUNT AVE",
        "CITY:CAMBRIDGE",
        "PLACE:SOJOURNER DOUGLAS CO",
        "BOX:1-2",
        "UNIT:EN1-1 EN1-2");

    doTest("T12",
        "(Message Forwarded by PageGate) \r\n" +
        "CT:PAGER TEST EMERGENCY MANAGEMENT @829 FIELDCREST RD CAMB BOX:1-1 DUE:P100 P200 P500 P600 :DC\r\n" +
        "\r\n",

        "CALL:PAGER TEST EMERGENCY MANAGEMENT",
        "ADDR:829 FIELDCREST RD",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100 P200 P500 P600");

    doTest("T13",
        "(Message Forwarded by PageGate) \r\nCT:BREATHING PROBLEMS 303 BUNKER ST APT A CAMB BOX:1-1 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:BREATHING PROBLEMS",
        "ADDR:303 BUNKER ST",
        "APT:A",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100 P101");

    doTest("T14",
        "(Message Forwarded by PageGate) \r\nCT:PREG/CHILDBIRTH/MATR 300 BYRN ST @DORCHESTER GENERAL CAMB BOX:1-1 DUE:P101 :DC\r\n\r\n",
        "CALL:PREG/CHILDBIRTH/MATR",
        "ADDR:300 BYRN ST",
        "CITY:CAMBRIDGE",
        "PLACE:DORCHESTER GENERAL",
        "BOX:1-1",
        "UNIT:P101");

    doTest("T15",
        "(Message Forwarded by PageGate) \r\nCT:PREG/CHILDBIRTH/MATR 706 HUGHLETT ST CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n",
        "CALL:PREG/CHILDBIRTH/MATR",
        "ADDR:706 HUGHLETT ST",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100");

    doTest("T16",
        "(Message Forwarded by PageGate) \r\nCT:BREATHING PROBLEMS 503 BYRN ST CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n",
        "CALL:BREATHING PROBLEMS",
        "ADDR:503 BYRN ST",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100");

    doTest("T17",
        "(Message Forwarded by PageGate) \r\nCT:CONVULSIONS/SEIZURES DISTRICT COURT @310 GAY ST CAMB BOX:1-1 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:CONVULSIONS/SEIZURES DISTRICT COURT",
        "ADDR:310 GAY ST",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100 P101");

    doTest("T18",
        "(Message Forwarded by PageGate) \r\nCT:PAGER TEST EMS OFFICE @829 FIELDCREST RD CAMB BOX:1-1 DUE:P100 P101 P200 P500 P600 :DC\r\n\r\n",
        "CALL:PAGER TEST EMS OFFICE",
        "ADDR:829 FIELDCREST RD",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100 P101 P200 P500 P600");

    doTest("T19",
        "(Message Forwarded by PageGate) \r\nCT:SICK PERSON 14 HOLLY TER CAMB BOX:1-3 DUE:P100 :DC\r\n\r\n",
        "CALL:SICK PERSON",
        "ADDR:14 HOLLY TER",
        "CITY:CAMBRIDGE",
        "BOX:1-3",
        "UNIT:P100");

    doTest("T20",
        "(Message Forwarded by PageGate) \r\n" +
        "CT:MOTOR VEH. COLLISION JACKTOWN TRAILER PAR @2950 OCEAN GTWY CAMB BOX:1-4 DUE:RS1-1 EN1-1 EN1-2 P100 :DC\r\n" +
        "\r\n",

        "CALL:MOTOR VEH. COLLISION JACKTOWN TRAILER PAR",
        "ADDR:2950 OCEAN GTWY",
        "CITY:CAMBRIDGE",
        "BOX:1-4",
        "UNIT:RS1-1 EN1-1 EN1-2 P100");

    doTest("T21",
        "(Message Forwarded by PageGate) \r\nCT:STAB/GUNSHOT/PENETRA 600 RACE ST @CENTER MARKET CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n",
        "CALL:STAB/GUNSHOT/PENETRA",
        "ADDR:600 RACE ST",
        "CITY:CAMBRIDGE",
        "PLACE:CENTER MARKET",
        "BOX:1-1",
        "UNIT:P100");

    doTest("T22",
        "(Message Forwarded by PageGate) \r\nCT:FALLS WALMART @2775 DORCHESTER SQUARE MALL CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n",
        "CALL:FALLS WALMART",
        "ADDR:2775 DORCHESTER SQUARE MALL",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100");

    doTest("T23",
        "(Message Forwarded by PageGate) \r\nCT:PAGER TEST EMS OFFICE @829 FIELDCREST RD CAMB BOX:1-1 DUE:P100 P101 P200 P500 P600 :DC\r\n\r\n",
        "CALL:PAGER TEST EMS OFFICE",
        "ADDR:829 FIELDCREST RD",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100 P101 P200 P500 P600");

    doTest("T24",
        "(Message Forwarded by PageGate) \r\nCT:COMMERCIAL FIRE ALAR 904 WOODS RD @PROTENERGY CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC\r\n\r\n",
        "CALL:COMMERCIAL FIRE ALAR",
        "ADDR:904 WOODS RD",
        "CITY:CAMBRIDGE",
        "PLACE:PROTENERGY",
        "BOX:1-1",
        "UNIT:EN1-1 EN1-2");

    doTest("T25",
        "(Message Forwarded by PageGate) \r\nCT:UNKNOWN PROBLEM WALMART @2775 DORCHESTER SQUARE MALL CAMB BOX:1-1 DUE:P101 :DC\r\n\r\n",
        "CALL:UNKNOWN PROBLEM WALMART",
        "ADDR:2775 DORCHESTER SQUARE MALL",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P101");

    doTest("T26",
        "(Message Forwarded by PageGate) \r\nCT:DIABETIC PROBLEMS 908 ROSLYN AVE CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n",
        "CALL:DIABETIC PROBLEMS",
        "ADDR:908 ROSLYN AVE",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100");

    doTest("T27",
        "(Message Forwarded by PageGate) \r\nCT:OVERDOSE/POISONING 511 HUBERT ST CAMB BOX:1-2 DUE:P101 :DC\r\n\r\n",
        "CALL:OVERDOSE/POISONING",
        "ADDR:511 HUBERT ST",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P101");

    doTest("T28",
        "(Message Forwarded by PageGate) \r\n" +
        "CT:UNCONSCIOUS/FAINTING 525 GLENBURN AVE @CHESAPEAKE WOODS CEN APT 21B CAMB BOX:1-2 DUE:P101 :DC\r\n" +
        "\r\n",

        "CALL:UNCONSCIOUS/FAINTING",
        "ADDR:525 GLENBURN AVE",
        "APT:21B",
        "CITY:CAMBRIDGE",
        "PLACE:CHESAPEAKE WOODS CEN",
        "BOX:1-2",
        "UNIT:P101");

    doTest("T29",
        "(Message Forwarded by PageGate) \r\nCT:CHEST PAINS 830 CHESAPEAKE DR @CAMB VETERANS CLINIC CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n",
        "CALL:CHEST PAINS",
        "ADDR:830 CHESAPEAKE DR",
        "CITY:CAMBRIDGE",
        "PLACE:CAMB VETERANS CLINIC",
        "BOX:1-1",
        "UNIT:P100");

    doTest("T30",
        "(Message Forwarded by PageGate) \r\nCT:EYE PROBLEM/INJURY 408 CEMETERY AVE CAMB BOX:1-1 DUE:P101 :DC\r\n\r\n",
        "CALL:EYE PROBLEM/INJURY",
        "ADDR:408 CEMETERY AVE",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P101");

    doTest("T31",
        "(Message Forwarded by PageGate) \r\nCT:FALLS 503 MUIR ST @NEW HORIZON APARTMEN APT 206 CAMB BOX:1-2 DUE:P100 :DC\r\n\r\n",
        "CALL:FALLS",
        "ADDR:503 MUIR ST",
        "APT:206",
        "CITY:CAMBRIDGE",
        "PLACE:NEW HORIZON APARTMEN",
        "BOX:1-2",
        "UNIT:P100");

    doTest("T32",
        "(Message Forwarded by PageGate) \r\nCT:STROKE (CVA) 1354 CAMBRIDGE BELTWAY CAMB BOX:1-1 DUE:P101 :DC\r\n\r\n",
        "CALL:STROKE (CVA)",
        "ADDR:1354 CAMBRIDGE BELTWAY",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P101");

    doTest("T33",
        "(Message Forwarded by PageGate) \r\nCT:SICK PERSON ZION UNITED METHODIS @612 LOCUST ST CAMB BOX:1-2 DUE:P101 :DC\r\n\r\n",
        "CALL:SICK PERSON ZION UNITED METHODIS",
        "ADDR:612 LOCUST ST",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P101");

    doTest("T34",
        "(Message Forwarded by PageGate) \r\nCT:FALLS 321 CHOPTANK AVE CAMB BOX:1-2 DUE:P100 :DC\r\n\r\n",
        "CALL:FALLS",
        "ADDR:321 CHOPTANK AVE",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P100");

    doTest("T35",
        "(Message Forwarded by PageGate) \r\nCT:SICK PERSON 6143 CASTLE HAVEN RD CAMB BOX:36-1 DUE:P101 A31-1 :DC\r\n\r\n",
        "CALL:SICK PERSON",
        "ADDR:6143 CASTLE HAVEN RD",
        "CITY:CAMBRIDGE",
        "BOX:36-1",
        "UNIT:P101 A31-1");

    doTest("T36",
        "(Message Forwarded by PageGate) \r\nCT:SICK PERSON 4803 EGYPT RD CAMB BOX:1-5 DUE:P100 :DC\r\n\r\n",
        "CALL:SICK PERSON",
        "ADDR:4803 EGYPT RD",
        "CITY:CAMBRIDGE",
        "BOX:1-5",
        "UNIT:P100");

    doTest("T37",
        "(Message Forwarded by PageGate) \r\nCT:STROKE (CVA) 3007 N SKIPJACK DR CAMB BOX:1-4 DUE:P100 :DC\r\n\r\n",
        "CALL:STROKE (CVA)",
        "ADDR:3007 N SKIPJACK DR",
        "CITY:CAMBRIDGE",
        "BOX:1-4",
        "UNIT:P100");

    doTest("T38",
        "(Message Forwarded by PageGate) \r\nCT:PAGER TEST EMS OFFICE @829 FIELDCREST RD CAMB BOX:1-1 DUE:P100 P101 P200 P500 P600 :DC\r\n\r\n",
        "CALL:PAGER TEST EMS OFFICE",
        "ADDR:829 FIELDCREST RD",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100 P101 P200 P500 P600");

    doTest("T39",
        "(Message Forwarded by PageGate) \r\nCT:BREATHING PROBLEMS 212 DORCHESTER AVE CAMB BOX:1-1 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:BREATHING PROBLEMS",
        "ADDR:212 DORCHESTER AVE",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100 P101");

    doTest("T40",
        "(Message Forwarded by PageGate) \r\nCT:ABDOMINAL PAINS 6143 CASTLE HAVEN RD CAMB BOX:36-1 DUE:P100 A31-1 :DC\r\n\r\n",
        "CALL:ABDOMINAL PAINS",
        "ADDR:6143 CASTLE HAVEN RD",
        "CITY:CAMBRIDGE",
        "BOX:36-1",
        "UNIT:P100 A31-1");

    doTest("T41",
        "(Message Forwarded by PageGate) \r\nCT:DIABETIC PROBLEMS 303 BUNKER ST APT A CAMB BOX:1-1 DUE:P101 :DC\r\n\r\n",
        "CALL:DIABETIC PROBLEMS",
        "ADDR:303 BUNKER ST",
        "APT:A",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P101");

    doTest("T42",
        "(Message Forwarded by PageGate) \r\nCT:SICK PERSON 3005 N SKIPJACK DR CAMB BOX:1-4 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:SICK PERSON",
        "ADDR:3005 N SKIPJACK DR",
        "CITY:CAMBRIDGE",
        "BOX:1-4",
        "UNIT:P100 P101");

    doTest("T43",
        "(Message Forwarded by PageGate) \r\nCT:MEDICAL ASSIST 1232 CHESTNUT PL CAMB BOX:1-2 DUE:EN1-1 :DC\r\n\r\n",
        "CALL:MEDICAL ASSIST",
        "ADDR:1232 CHESTNUT PL",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:EN1-1");

    doTest("T44",
        "(Message Forwarded by PageGate) \r\nCT:BACK PAIN-NONTRAUMA 1232 CHESTNUT PL APT 201 CAMB BOX:1-2 DUE:P100 :DC\r\n\r\n",
        "CALL:BACK PAIN-NONTRAUMA",
        "ADDR:1232 CHESTNUT PL",
        "APT:201",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P100");

    doTest("T45",
        "(Message Forwarded by PageGate) \r\nCT:UNKNOWN PROBLEM 518 GLENBURN AVE @GLENBURN HOUSE APT 202 CAMB BOX:1-2 DUE:P100 :DC\r\n\r\n",
        "CALL:UNKNOWN PROBLEM",
        "ADDR:518 GLENBURN AVE",
        "APT:202",
        "CITY:CAMBRIDGE",
        "PLACE:GLENBURN HOUSE",
        "BOX:1-2",
        "UNIT:P100");

    doTest("T46",
        "(Message Forwarded by PageGate) \r\nCT:COMMERCIAL FIRE ALAR 821 FIELDCREST RD @PATOMAC RIDGE CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC\r\n\r\n",
        "CALL:COMMERCIAL FIRE ALAR",
        "ADDR:821 FIELDCREST RD",
        "CITY:CAMBRIDGE",
        "PLACE:PATOMAC RIDGE",
        "BOX:1-1",
        "UNIT:EN1-1 EN1-2");

    doTest("T47",
        "(Message Forwarded by PageGate) \r\nCT:SICK PERSON DENNYS @781 SUNBURST HWY CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n",
        "CALL:SICK PERSON DENNYS",
        "ADDR:781 SUNBURST HWY",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100");

    doTest("T48",
        "(Message Forwarded by PageGate) \r\nCT:CONVULSIONS/SEIZURES 416 PLEASANT ST CAMB BOX:1-1 DUE:P101 :DC\r\n\r\n",
        "CALL:CONVULSIONS/SEIZURES",
        "ADDR:416 PLEASANT ST",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P101");

    doTest("T49",
        "(Message Forwarded by PageGate) \r\nCT:PAGER TEST EMS OFFICE @829 FIELDCREST RD CAMB BOX:1-1 DUE:P100 P101 P200 P500 P600 :DC\r\n\r\n",
        "CALL:PAGER TEST EMS OFFICE",
        "ADDR:829 FIELDCREST RD",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100 P101 P200 P500 P600");

    doTest("T50",
        "(Message Forwarded by PageGate) \r\nCT:BREATHING PROBLEMS 859 PARK LN CAMB BOX:1-2 DUE:P100 :DC\r\n\r\n",
        "CALL:BREATHING PROBLEMS",
        "ADDR:859 PARK LN",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P100");

    doTest("T51",
        "(Message Forwarded by PageGate) \r\nCT:CHEST PAIN 317 WILLIS ST CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:CHEST PAIN",
        "ADDR:317 WILLIS ST",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P100 P101");

    doTest("T52",
        "(Message Forwarded by PageGate) \r\nCT:RESIDENTIAL FIRE ALA 2520 WESTWIND BLVD CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC\r\n\r\n",
        "CALL:RESIDENTIAL FIRE ALA",
        "ADDR:2520 WESTWIND BLVD",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:EN1-1 EN1-2");

    doTest("T53",
        "(Message Forwarded by PageGate) \r\nCT:CHEST PAINS 918 ROSLYN AVE CAMB BOX:1-1 DUE:P100 :DC\r\n\r\n",
        "CALL:CHEST PAINS",
        "ADDR:918 ROSLYN AVE",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100");

    doTest("T54",
        "(Message Forwarded by PageGate) \r\nCT:BREATHING PROBLEMS 614 GOLDSBOROUGH AVE CAMB BOX:1-2 DUE:P101 :DC\r\n\r\n",
        "CALL:BREATHING PROBLEMS",
        "ADDR:614 GOLDSBOROUGH AVE",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P101");

    doTest("T55",
        "(Message Forwarded by PageGate) \r\nCT:SICK PERSON 210 METEOR AVE APT 601 CAMB BOX:1-1 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:SICK PERSON",
        "ADDR:210 METEOR AVE",
        "APT:601",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100 P101");

    doTest("T56",
        "(Message Forwarded by PageGate) \r\nCT:ABDOMINAL PAINS 501 DOBSON ST CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:ABDOMINAL PAINS",
        "ADDR:501 DOBSON ST",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P100 P101");

    doTest("T57",
        "(Message Forwarded by PageGate) \r\nCT:(SMALL) FUEL SPILL 209 HAYWARD ST @PEP UP CAMB BOX:1-1 DUE:EN1-1 EN1-2 :DC\r\n\r\n",
        "CALL:(SMALL) FUEL SPILL",
        "ADDR:209 HAYWARD ST",
        "CITY:CAMBRIDGE",
        "PLACE:PEP UP",
        "BOX:1-1",
        "UNIT:EN1-1 EN1-2");

    doTest("T58",
        "(Message Forwarded by PageGate) \r\nCT:STRUCTURE FIRE 615 DOUGLAS ST CAMB BOX:1-2 DUE:EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100 :DC\r\n\r\n",
        "CALL:STRUCTURE FIRE",
        "ADDR:615 DOUGLAS ST",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100");

    doTest("T59",
        "(Message Forwarded by PageGate) \r\nCT:CHEST PAINS 503 MUIR ST @NEW HORIZON APARTMEN APT 202 CAMB BOX:1-2 DUE:P101 :DC\r\n\r\n",
        "CALL:CHEST PAINS",
        "ADDR:503 MUIR ST",
        "APT:202",
        "CITY:CAMBRIDGE",
        "PLACE:NEW HORIZON APARTMEN",
        "BOX:1-2",
        "UNIT:P101");

    doTest("T60",
        "(Message Forwarded by PageGate) \r\nCT:CONVULSIONS/SEIZURES 828 PARK LN CAMB BOX:1-2 DUE:P100 :DC\r\n\r\n",
        "CALL:CONVULSIONS/SEIZURES",
        "ADDR:828 PARK LN",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P100");

    doTest("T61",
        "(Message Forwarded by PageGate) \r\nCT:RESIDENTIAL FIRE ALA 104 RIVERSIDE DR CAMB BOX:1-3 DUE::DC\r\n\r\n",
        "CALL:RESIDENTIAL FIRE ALA",
        "ADDR:104 RIVERSIDE DR",
        "CITY:CAMBRIDGE",
        "BOX:1-3");

    doTest("T62",
        "(Message Forwarded by PageGate) \r\nCT:PAGER TEST EMS OFFICE @829 FIELDCREST RD CAMB BOX:1-1 DUE:P100 P101 P200 P500 P600 :DC\r\n\r\n",
        "CALL:PAGER TEST EMS OFFICE",
        "ADDR:829 FIELDCREST RD",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P100 P101 P200 P500 P600");

    doTest("T63",
        "(Message Forwarded by PageGate) \r\nCT:911 TEST CALL STATION 100 @8 WASHINGTON ST CAMB BOX:1-1 DUE:A103 :DC\r\n\r\n",
        "CALL:911 TEST CALL STATION 100",
        "ADDR:8 WASHINGTON ST",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:A103");

    doTest("T64",
        "(Message Forwarded by PageGate) \r\nCT:UNKNOWN PROBLEM RIGBY AVE/ FAIRMOUNT AVE  BOX:1-2 DUE:P101 :DC\r\n\r\n",
        "CALL:UNKNOWN PROBLEM",
        "ADDR:RIGBY AVE & FAIRMOUNT AVE",
        "BOX:1-2",
        "UNIT:P101");

    doTest("T65",
        "(Message Forwarded by PageGate) \r\nCT:PREG/CHILDBIRTH/MATR 508 GREENWOOD AVE APT 301 CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:PREG/CHILDBIRTH/MATR",
        "ADDR:508 GREENWOOD AVE",
        "APT:301",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P100 P101");

    doTest("T66",
        "(Message Forwarded by PageGate) \r\nCT:STROKE (CVA) 104 JOHNSON ST CAMB BOX:1-3 DUE:P101 :DC\r\n\r\n",
        "CALL:STROKE (CVA)",
        "ADDR:104 JOHNSON ST",
        "CITY:CAMBRIDGE",
        "BOX:1-3",
        "UNIT:P101");

    doTest("T67",
        "(Message Forwarded by PageGate) \r\nCT:PREG/CHILDBIRTH/MATR 617 SCHOOL HOUSE LN CAMB BOX:1-2 DUE:P100 P101 :DC\r\n\r\n",
        "CALL:PREG/CHILDBIRTH/MATR",
        "ADDR:617 SCHOOL HOUSE LN",
        "CITY:CAMBRIDGE",
        "BOX:1-2",
        "UNIT:P100 P101");

    doTest("T68",
        "(Message Forwarded by PageGate) \r\nCT:SICK PERSON 408 CEMETERY AVE CAMB BOX:1-1 DUE:P101 :DC\r\n\r\n",
        "CALL:SICK PERSON",
        "ADDR:408 CEMETERY AVE",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:P101");

    doTest("T69",
        "(Message Forwarded by PageGate) \r\nCT:FALLS 124 SECOND ST SECR BOX:16-1 DUE:P100 A16-1 :DC\r\n\r\n",
        "CALL:FALLS",
        "ADDR:124 SECOND ST",
        "CITY:SECRETARY",
        "BOX:16-1",
        "UNIT:P100 A16-1");

    doTest("T70",
        "(Message forwarded by pagegate) DOR911:CT:STRUCTURE FIRE 318 CRUSADER RD APT 203 CAMB BOX:1-1\r\n" +
        "DUE:EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100 :DC\r\n",

        "CALL:STRUCTURE FIRE",
        "ADDR:318 CRUSADER RD",
        "APT:203",
        "CITY:CAMBRIDGE",
        "BOX:1-1",
        "UNIT:EN1-1 EN1-2 EN1-3 RS1-1 TW1-1 P100");

    doTest("T71",
        "(Message forwarded by PageGate) DOR911:CT:STROKE (CVA) 520 GLENBURN AVE @MALLARD BAY UNIT 200 CAMB\r\nBOX:1-2 DUE:P100 P101 :DC\r\n",
        "CALL:STROKE (CVA)",
        "ADDR:520 GLENBURN AVE",
        "CITY:CAMBRIDGE",
        "PLACE:MALLARD BAY UNIT 200",
        "BOX:1-2",
        "UNIT:P100 P101");

  }
  
  public static void main(String[] args) {
    new MDDorchesterCountyParserTest().generateTests("T1");
  }
}