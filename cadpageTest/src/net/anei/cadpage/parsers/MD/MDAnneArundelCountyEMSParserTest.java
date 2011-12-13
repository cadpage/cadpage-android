package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDAnneArundelCountyEMSParser;

import org.junit.Test;


public class MDAnneArundelCountyEMSParserTest extends BaseParserTest {
  
  public MDAnneArundelCountyEMSParserTest() {
    setParser(new MDAnneArundelCountyEMSParser(), "ANNE ARUNDEL COUNTY", "MD");
  }
  
  @Test
  public void testArnoldParser() {
    
    doTest("T1",
        "MEDICAL Box 17-7 1236 JONES STATION RD  [MT CALVARY UNITED METH CHURCH] E171,PM17 TASER PATIENT; 1145 [1/49]  /4m-5/",
        "BOX:17-7",
        "ADDR:1236 JONES STATION RD",
        "PLACE:MT CALVARY UNITED METH CHURCH",
        "UNIT:E171,PM17",
        "CALL:TASER PATIENT",
        "TIME:11:45");
    
    doTest("T2",
        "Box Alarm 12-19 540 BENFIELD RD (CENTER DR) Echo E12,QNT30,E18,E171,QNT23,TK26,SQ23,PM12,BC2,SCA ODOR GAS IN STRUCTURE (HOT); 1351 [2/50]",
        "BOX:12-19",
        "ADDR:540 BENFIELD RD",
        "X:CENTER DR",
        "CH:Echo",
        "UNIT:E12,QNT30,E18,E171,QNT23,TK26,SQ23,PM12,BC2,SCA",
        "CALL:ODOR GAS IN STRUCTURE (HOT)",
        "TIME:13:51");

    doTest("T3",
        "Local Alarm 17-12 24 CASCADE RD (GRANDVIEW RD) E171 ALARMS/NON HIGH LIFE (HOT); 1705 [3/51]", 
        "BOX:17-12",
        "ADDR:24 CASCADE RD",
        "X:GRANDVIEW RD",
        "UNIT:E171",
        "CALL:ALARMS/NON HIGH LIFE (HOT)",
        "TIME:17:05");
    
    doTest("T4",
        "*MEDICAL BOX 23-5 831 RITCHIE HWY N  [Unit 307A]  [KRIS LEIGH CATERED LIVING] QNT23,PM17,TRO CARDIAC ARREST; 0548 [2/42]  /2d-96/",
        "BOX:23-5",
        "ADDR:831 RITCHIE HWY N",
        "APT:307A",
        "PLACE:KRIS LEIGH CATERED LIVING",
        "UNIT:QNT23,PM17,TRO",
        "CALL:CARDIAC ARREST",
        "TIME:05:48");
    
    doTest("T5",
        "*MEDICAL Box 23-12 1244 RITCHIE HWY S  [Unit 18]  [SEVERN COMMERCE CENTER] QNT23,PM17 STROKE; 0921 [3/43]  /lm-2/", 
        "BOX:23-12",
        "ADDR:1244 RITCHIE HWY S",
        "APT:18",
        "PLACE:SEVERN COMMERCE CENTER",
        "UNIT:QNT23,PM17",
        "CALL:STROKE",
        "TIME:09:21");
    
    doTest("T6",
        "*Medical Box 40-83 RT50 W/JENNIFER RD MU40,E40,E171 MVC; 1517 [4/44]  /18d-19/", 
        "BOX:40-83",
        "ADDR:RT50 W & JENNIFER RD",
        "MADDR:RT 50 W & JENNIFER RD",
        "UNIT:MU40,E40,E171",
        "CALL:MVC",
        "TIME:15:17");

    doTest("T7",
        "Box Alarm 23-15 812 WINDSOR RD (FOREST LN) Echo QNT23,E171,E19,TW40,QNT30,SQ23,PM17,BC2,SCA STRUCTURE/BARN/GARAGE (HOT); 1607 [5/45]", 
        "BOX:23-15",
        "ADDR:812 WINDSOR RD",
        "X:FOREST LN",
        "CH:Echo",
        "UNIT:QNT23,E171,E19,TW40,QNT30,SQ23,PM17,BC2,SCA",
        "CALL:STRUCTURE/BARN/GARAGE (HOT)",
        "TIME:16:07");
    
    doTest("T8",
        "MEDICAL Box 19-5 1604 ORCHARD WAY (HARMONY ACRES LN) E172,MU39 STROKE; 1643 [6/46]", 
        "BOX:19-5",
        "ADDR:1604 ORCHARD WAY",
        "X:HARMONY ACRES LN",
        "UNIT:E172,MU39",
        "CALL:STROKE",
        "TIME:16:43");
    
    doTest("T9",
        "MEDICAL Box 40-26 1724 VINEYARD TRL (RAMSHORN TRL) TW40,PM17 SEIZURES; 0035 [1/41]",
        "BOX:40-26",
        "ADDR:1724 VINEYARD TRL",
        "X:RAMSHORN TRL",
        "UNIT:TW40,PM17",
        "CALL:SEIZURES",
        "TIME:00:35");

    doTest("T10",
        "HazMat Box 17-17 1939 BALTO ANNAP BLVD (CARVEL DR) Kilo E171,SQ2,BC2,SU23,SCA,PM39 Chemical ODOR ...",
        "BOX:17-17",
        "ADDR:1939 BALTO ANNAP BLVD",
        "X:CARVEL DR",
        "CH:Kilo",
        "UNIT:E171,SQ2,BC2,SU23,SCA,PM39",
        "CALL:Chemical ODOR ...");
    
    doTest("T11",
        "Local Box 23-6 88 HOYLE LN (BRENDA JOYCE LN) Charlie B17 ELECTRIC WIRES OUTSIDE (COLD); 1404[9...",
        "BOX:23-6",
        "ADDR:88 HOYLE LN",
        "X:BRENDA JOYCE LN",
        "CH:Charlie",
        "UNIT:B17",
        "CALL:ELECTRIC WIRES OUTSIDE (COLD)",
        "TIME:14:04");
    
    doTest("T12",
        "Still Box 40-24A 1872 ANNAPOLIS MALL [CHEESCAKE FACTORY] Kilo E172,TK36 ALARMS/MALLS (WARM ...",
        "BOX:40-24A",
        "ADDR:1872 ANNAPOLIS MALL",
        "PLACE:CHEESCAKE FACTORY",
        "CH:Kilo",
        "UNIT:E172,TK36",
        "CALL:ALARMS/MALLS (WARM ...");
    
    doTest("T13",
        "Local Box 19-5 1652 PLEASANT PLAINS RD (OLD SAINT MARGARETS RD) Charlie HOLD,U@*,E172 ELECTRIC ...",
        "BOX:19-5",
        "ADDR:1652 PLEASANT PLAINS RD",
        "X:OLD SAINT MARGARETS RD",
        "CH:Charlie",
        "UNIT:HOLD,U@*,E172",
        "CALL:ELECTRIC ...");
    
    doTest("T14",
        "MEDICAL Box 19-13 1572 SECRETARIAT DR (MAN O WAR CT) A19,PM17 CHEST PAIN; 1341 [6/284] /13m-1", 
        "BOX:19-13",
        "ADDR:1572 SECRETARIAT DR",
        "X:MAN O WAR CT",
        "UNIT:A19,PM17",
        "CALL:CHEST PAIN",
        "TIME:13:41");
    
    doTest("T15",
        "Medical Box 40-83 RT50 E/BESTGATE RD MU40,E40,E172 MVC; 1238 [5/283] /lm-7",
        "BOX:40-83",
        "ADDR:RT50 E & BESTGATE RD",
        "MADDR:RT 50 E & BESTGATE RD",
        "UNIT:MU40,E40,E172",
        "CALL:MVC",
        "TIME:12:38");
    
    doTest("T16",
        "Medical Box 17-QA BRIDE POINT DR /COX [Unit NECK] [RD BX1-10] MOA PM17 MVC; PM17 REQ TAX 3 1133 ...",
        "BOX:17-QA",
        "ADDR:BRIDE POINT DR & COX",
        "APT:NECK",
        "PLACE:RD BX1-10",
        "UNIT:MOA",
        "CALL:PM17 MVC; PM17 REQ TAX 3",
        "TIME:11:33");
  }

  @Test
  public void testAnneArundelParser() {

    doTest("T1",
        "*Medical Box 28-8 1496 ANNAPOLIS RD  [BLOCKBUSTER VIDEO] 12-F1 E281,MU29 MVC; 2306 [14/81]  /lm-33/",
        "BOX:28-8",
        "ADDR:1496 ANNAPOLIS RD",
        "PLACE:BLOCKBUSTER VIDEO",
        "MAP:12-F1",
        "UNIT:E281,MU29",
        "CALL:MVC",
        "TIME:23:06");

    doTest("T2",
        "*MEDICAL Box 28-13 TELEGRAPH RD/JACKSON GROVE RD 6-K13 E283,MU4 FAINTING; 1328 [9/90]  14m-2",
        "BOX:28-13",
        "ADDR:TELEGRAPH RD & JACKSON GROVE RD",
        "MAP:6-K13",
        "UNIT:E283,MU4",
        "CALL:FAINTING",
        "TIME:13:28");

    doTest("T3",
        "Medical Box 34-5 7390 BALTO ANNAP BLVD  [MTA LIGHT RAIL CROMWELL] 7-J1 TK33,MU21,A28 ABDOM PAIN; 1256 [8/89]",
        "BOX:34-5",
        "ADDR:7390 BALTO ANNAP BLVD",
        "PLACE:MTA LIGHT RAIL CROMWELL",
        "MAP:7-J1",
        "UNIT:TK33,MU21,A28",
        "CALL:ABDOM PAIN",
        "TIME:12:56");
    

    doTest("T4",
        "*MEDICAL Box 5-22 1325 GREYSWOOD RD (CHAPELVIEW DR) 12-H6 E283,MU6 BREATHING PROB; 1145 [7/88]  22d-20",
        "BOX:5-22",
        "ADDR:1325 GREYSWOOD RD",
        "X:CHAPELVIEW DR",
        "MAP:12-H6",
        "UNIT:E283,MU6",
        "CALL:BREATHING PROB",
        "TIME:11:45");

    doTest("T5",
        "*Medical Box 28-8 1496 ANNAPOLIS RD  [BLOCKBUSTER VIDEO] 12-F1 E281,MU29 MVC; 2306 [14/81]  lm-33",
        "BOX:28-8",
        "ADDR:1496 ANNAPOLIS RD",
        "PLACE:BLOCKBUSTER VIDEO",
        "MAP:12-F1",
        "UNIT:E281,MU29",
        "CALL:MVC",
        "TIME:23:06");

    doTest("T6",
        "*Medical Box 28-27 PINEY ORCHARD PKWY/RIVERSCAPE RD 12-E7 E281,PM26 MVC; 1415 [6/91]  lm-8",
        "BOX:28-27",
        "ADDR:PINEY ORCHARD PKWY & RIVERSCAPE RD",
        "MAP:12-E7",
        "UNIT:E281,PM26",
        "CALL:MVC",
        "TIME:14:15");

    doTest("T7",
        "MEDICAL Box 28-27 RIVERSCAPE RD/RUNNING WOLF TRL 12-F8 E283,MU21 CHEST PAIN; 2010 [13/78]",
        "BOX:28-27",
        "ADDR:RIVERSCAPE RD & RUNNING WOLF TRL",
        "MAP:12-F8",
        "UNIT:E283,MU21",
        "CALL:CHEST PAIN",
        "TIME:20:10");

    doTest("T8",
        "Local Box 28-27 2615 LOTUSWOOD CT (RIVERSCAPE RD) 12-E7 E283 SERVICE CALL (COLD); 1740 [9/293]",
        "BOX:28-27",
        "ADDR:2615 LOTUSWOOD CT",
        "X:RIVERSCAPE RD",
        "MAP:12-E7",
        "UNIT:E283",
        "CALL:SERVICE CALL (COLD)",
        "TIME:17:40");

    doTest("T9",
        "*MEDICAL Box 28-27 8718 THORNBROOK DR (RIVERSCAPE RD) 12-E7 E281,MU6 HEADACHE; BURNING INSIDE  2001 [15/297]  41m-1",
        "BOX:28-27",
        "ADDR:8718 THORNBROOK DR",
        "X:RIVERSCAPE RD",
        "MAP:12-E7",
        "UNIT:E281,MU6",
        "CALL:HEADACHE; BURNING INSIDE",
        "TIME:20:01");

    doTest("T10",
        "*MEDICAL Box 28-27 8700 NATURES TRAIL CT  [Unit 304] (RIVERSCAPE RD) 12-E8 A28,PM5 BREATHING PROB; 0524 [4/313]  6m-5",
        "BOX:28-27",
        "ADDR:8700 NATURES TRAIL CT",
        "APT:304",
        "X:RIVERSCAPE RD",
        "MAP:12-E8",
        "UNIT:A28,PM5",
        "CALL:BREATHING PROB",
        "TIME:05:24");

    doTest("T11",
        "*Medical Box 28-6 2012 BEALMEAR MILL LN  [Unit 7208] (COWMAN CT) 12-G1 E281,MU29 BACK PAIN; 0539 [1/68]  25d-2",
        "BOX:28-6",
        "ADDR:2012 BEALMEAR MILL LN",
        "APT:7208",
        "X:COWMAN CT",
        "MAP:12-G1",
        "UNIT:E281,MU29",
        "CALL:BACK PAIN",
        "TIME:05:39");

    doTest("T12",
        "*Local Box 17-13 1641 WINCHESTER RD  [MONTESSORI INTL CHILDRENS HOME] E171 HI LIFE/ALARMS SOUNDING (WARM); 1243 [6/88]  /9d-7/",
        "BOX:17-13",
        "CALL:HI LIFE/ALARMS SOUNDING (WARM)",
        "ADDR:1641 WINCHESTER RD",
        "PLACE:MONTESSORI INTL CHILDRENS HOME",
        "UNIT:E171",
        "TIME:12:43");

    doTest("T13",
        "MEDICAL Box 23-16 254 PENDLETON CT (WAYCROSS WAY) QNT23,PM17 BREATHING PROB; 0911 [3/127]",
        "BOX:23-16",
        "CALL:BREATHING PROB",
        "ADDR:254 PENDLETON CT",
        "X:WAYCROSS WAY",
        "UNIT:QNT23,PM17",
        "TIME:09:11");

    doTest("T14",
        "MEDICAL BOX 19-6 824 HOLLY DR E A19,PM17,TRO MVC; 1808 PM2 [3/25]\n",
        "BOX:19-6",
        "CALL:MVC",
        "ADDR:824 HOLLY DR E",
        "UNIT:A19,PM17,TRO",
        "TIME:18:08",
        "INFO:PM2");

    doTest("T14",
        "MEDICAL Box 17-4 1220 VIKING DR N E171,PM17 CHEST PAIN; 1834 PM1 Y>HHC,HHC R>UoM,UoM [3/30]\n",
        "BOX:17-4",
        "CALL:CHEST PAIN",
        "ADDR:1220 VIKING DR N",
        "UNIT:E171,PM17",
        "TIME:18:34",
        "INFO:PM1 Y>HHC,HHC R>UoM,UoM");

    doTest("T15",
        "Medical Box 17-18 2156 MULBERRY HILL RD A19 SICK PERSON; 1549 A Y>UoM [10/29]",
        "BOX:17-18",
        "CALL:SICK PERSON",
        "ADDR:2156 MULBERRY HILL RD",
        "UNIT:A19",
        "TIME:15:49",
        "INFO:A Y>UoM");

    doTest("T16",
        "Local Box 23-4 133 BOONE TRL E171 CO DET./NO INJURIES (COLD); 1159 CO [4/186] \n",
        "BOX:23-4",
        "CALL:CO DET / NO INJURIES (COLD)",
        "ADDR:133 BOONE TRL",
        "UNIT:E171",
        "TIME:11:59",
        "INFO:CO");

    doTest("T17",
        "Box Alarm 7-13 2903 COLD SPRING WAY  [Unit 446] (PARKRIDGE CIR) 17-K3 Echo E7,E5,PE39,PE16,TK28,PTW43,SQ1,PM5,BC3,SCA COMMERCIAL/INDUSTRIAL (HOT); 1008 [3/33]",
        "BOX:7-13",
        "CALL:COMMERCIAL/INDUSTRIAL (HOT)",
        "ADDR:2903 COLD SPRING WAY",
        "APT:446",
        "X:PARKRIDGE CIR",
        "MAP:17-K3",
        "CH:Echo",
        "UNIT:E7,E5,PE39,PE16,TK28,PTW43,SQ1,PM5,BC3,SCA",
        "TIME:10:08");

    doTest("T18",
        "Medical Box 7-13 1719 DRYDEN WY, CR - btwn DANA ST and DANA ST (5291K8) Bravo A79 Medical Alert Alarm; 1500 [7/52]",
        "BOX:7-13",
        "CALL:Medical Alert Alarm",
        "ADDR:1719 DRYDEN WY",
        "CITY:CROFTON",
        "X:DANA ST and DANA ST",
        "MAP:5291K8",
        "CH:Bravo",
        "UNIT:A79",
        "TIME:15:00");

    doTest("T19",
        "Medical Box 5-27 SB CRAIN HY/CAPITOL RACEWAY RD (5291K7) Bravo PM6,E5,A839,A289 MVC: Uknown Status; 2234 [6/118]",
        "BOX:5-27",
        "CALL:MVC: Uknown Status",
        "ADDR:SB CRAIN HY & CAPITOL RACEWAY RD",
        "MADDR:CRAIN HWY & CAPITOL RACEWAY RD",
        "MAP:5291K7",
        "CH:Bravo",
        "UNIT:PM6,E5,A839,A289",
        "TIME:22:34");

    doTest("T20",
        "Box Alarm 21-14 1562 PENZANCE WY, HA - btwn DORCHESTER BL and DORCHESTER BL (5055C5) Echo E29,TA5,QNT4,E10,SQ43,TK45,E45,TK28,E34,MU21,BC1,SCA1 Dwelling Fire (Hot ); 1920 [5/117]",
        "BOX:21-14",
        "CALL:Dwelling Fire (Hot )",
        "ADDR:1562 PENZANCE WY",
        "CITY:HANOVER",
        "X:DORCHESTER BL and DORCHESTER BL",
        "MAP:5055C5",
        "CH:Echo",
        "UNIT:E29,TA5,QNT4,E10,SQ43,TK45,E45,TK28,E34,MU21,BC1,SCA1",
        "TIME:19:20");
   
  }


  public static void main(String[] args) {
    new MDAnneArundelCountyEMSParserTest().generateTests("T19", "BOX CALL ADDR APT CITY PLACE X MAP CH UNIT TIME INFO");
  }
  
}