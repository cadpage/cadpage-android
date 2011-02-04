package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDArnoldParser;

import org.junit.Test;


public class MDArnoldParserTest extends BaseParserTest {
  
  public MDArnoldParserTest() {
    setParser(new MDArnoldParser(), "Arnold", "MD");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "MEDICAL Box 17-7 1236 JONES STATION RD  [MT CALVARY UNITED METH CHURCH] E171,PM17 TASER PATIENT; 1145 [1/49]  /4m-5/",
        "CALL:MEDICAL Box 17-7",
        "ADDR:1236 JONES STATION RD",
        "PLACE:MT CALVARY UNITED METH CHURCH",
        "UNIT:E171,PM17",
        "INFO:TASER PATIENT");
    
    doTest("T2",
        "Box Alarm 12-19 540 BENFIELD RD (CENTER DR) Echo E12,QNT30,E18,E171,QNT23,TK26,SQ23,PM12,BC2,SCA ODOR GAS IN STRUCTURE (HOT); 1351 [2/50]",
        "CALL:Box Alarm 12-19",
        "ADDR:540 BENFIELD RD",
        "X:CENTER DR",
        "UNIT:E12,QNT30,E18,E171,QNT23,TK26,SQ23,PM12,BC2,SCA",
        "INFO:ODOR GAS IN STRUCTURE (HOT)");

    doTest("T3",
        "Local Alarm 17-12 24 CASCADE RD (GRANDVIEW RD) E171 ALARMS/NON HIGH LIFE (HOT); 1705 [3/51]", 
        "CALL:Local Alarm 17-12",
        "ADDR:24 CASCADE RD",
        "X:GRANDVIEW RD",
        "UNIT:E171",
        "INFO:ALARMS/NON HIGH LIFE (HOT)");
    
    doTest("T4",
        "*MEDICAL BOX 23-5 831 RITCHIE HWY N  [Unit 307A]  [KRIS LEIGH CATERED LIVING] QNT23,PM17,TRO CARDIAC ARREST; 0548 [2/42]  /2d-96/",
        "CALL:*MEDICAL BOX 23-5",
        "ADDR:831 RITCHIE HWY N",
        "PLACE:Unit 307A - KRIS LEIGH CATERED LIVING",
        "UNIT:QNT23,PM17,TRO",
        "INFO:CARDIAC ARREST");
    
    doTest("T5",
        "*MEDICAL Box 23-12 1244 RITCHIE HWY S  [Unit 18]  [SEVERN COMMERCE CENTER] QNT23,PM17 STROKE; 0921 [3/43]  /lm-2/", 
        "CALL:*MEDICAL Box 23-12",
        "ADDR:1244 RITCHIE HWY S",
        "PLACE:Unit 18 - SEVERN COMMERCE CENTER",
        "UNIT:QNT23,PM17",
        "INFO:STROKE");
    
    doTest("T6",
        "*Medical Box 40-83 RT50 W/JENNIFER RD MU40,E40,E171 MVC; 1517 [4/44]  /18d-19/", 
        "CALL:*Medical Box 40-83",
        "ADDR:RT50 W & JENNIFER RD",
        "UNIT:MU40,E40,E171",
        "INFO:MVC");

    doTest("T7",
        "Box Alarm 23-15 812 WINDSOR RD (FOREST LN) Echo QNT23,E171,E19,TW40,QNT30,SQ23,PM17,BC2,SCA STRUCTURE/BARN/GARAGE (HOT); 1607 [5/45]", 
        "CALL:Box Alarm 23-15",
        "ADDR:812 WINDSOR RD",
        "X:FOREST LN",
        "UNIT:QNT23,E171,E19,TW40,QNT30,SQ23,PM17,BC2,SCA",
        "INFO:STRUCTURE/BARN/GARAGE (HOT)");
    
    doTest("T8",
        "MEDICAL Box 19-5 1604 ORCHARD WAY (HARMONY ACRES LN) E172,MU39 STROKE; 1643 [6/46]", 
        "CALL:MEDICAL Box 19-5",
        "ADDR:1604 ORCHARD WAY",
        "X:HARMONY ACRES LN",
        "UNIT:E172,MU39",
        "INFO:STROKE");
    
    doTest("T9",
        "MEDICAL Box 40-26 1724 VINEYARD TRL (RAMSHORN TRL) TW40,PM17 SEIZURES; 0035 [1/41]",
        "CALL:MEDICAL Box 40-26",
        "ADDR:1724 VINEYARD TRL",
        "X:RAMSHORN TRL",
        "UNIT:TW40,PM17",
        "INFO:SEIZURES");

    doTest("T10",
        "HazMat Box 17-17 1939 BALTO ANNAP BLVD (CARVEL DR) Kilo E171,SQ2,BC2,SU23,SCA,PM39 Chemical ODOR ...",
        "CALL:HazMat Box 17-17",
        "ADDR:1939 BALTO ANNAP BLVD",
        "X:CARVEL DR",
        "UNIT:E171,SQ2,BC2,SU23,SCA,PM39",
        "INFO:Chemical ODOR ...");
    
    doTest("T11",
        "Local Box 23-6 88 HOYLE LN (BRENDA JOYCE LN) Charlie B17 ELECTRIC WIRES OUTSIDE (COLD); 1404[9...",
        "CALL:Local Box 23-6",
        "ADDR:88 HOYLE LN",
        "X:BRENDA JOYCE LN",
        "UNIT:B17",
        "INFO:ELECTRIC WIRES OUTSIDE (COLD)");
    
    doTest("T12",
        "Still Box 40-24A 1872 ANNAPOLIS MALL [CHEESCAKE FACTORY] Kilo E172,TK36 ALARMS/MALLS (WARM ...",
        "CALL:Still Box 40-24A",
        "ADDR:1872 ANNAPOLIS MALL",
        "PLACE:CHEESCAKE FACTORY",
        "UNIT:E172,TK36",
        "INFO:ALARMS/MALLS (WARM ...");
    
    doTest("T13",
        "Local Box 19-5 1652 PLEASANT PLAINS RD (OLD SAINT MARGARETS RD) Charlie HOLD,U@*,E172 ELECTRIC ...",
        "CALL:Local Box 19-5",
        "ADDR:1652 PLEASANT PLAINS RD",
        "X:OLD SAINT MARGARETS RD",
        "UNIT:HOLD,U@*,E172",
        "INFO:ELECTRIC ...");
    
    doTest("T14",
        "MEDICAL Box 19-13 1572 SECRETARIAT DR (MAN O WAR CT) A19,PM17 CHEST PAIN; 1341 [6/284] /13m-1", 
        "CALL:MEDICAL Box 19-13",
        "ADDR:1572 SECRETARIAT DR",
        "X:MAN O WAR CT",
        "UNIT:A19,PM17",
        "INFO:CHEST PAIN");
    
    doTest("T15",
        "Medical Box 40-83 RT50 E/BESTGATE RD MU40,E40,E172 MVC; 1238 [5/283] /lm-7",
        "CALL:Medical Box 40-83",
        "ADDR:RT50 E & BESTGATE RD",
        "UNIT:MU40,E40,E172",
        "INFO:MVC");
    
    doTest("T16",
        "Medical Box 17-QA BRIDE POINT DR /COX [Unit NECK] [RD BX1-10] MOA PM17 MVC; PM17 REQ TAX 3 1133 ...",
        "CALL:Medical Box 17-QA",
        "ADDR:BRIDE POINT DR & COX",
        "PLACE:Unit NECK - RD BX1-10",
        "UNIT:MOA",
        "INFO:PM17 MVC");
 }
}