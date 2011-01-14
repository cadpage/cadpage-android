package net.anei.cadpage.parsers;

import net.anei.cadpage.TestManagePreferences;

import org.junit.BeforeClass;
import org.junit.Test;


public class GeneralParserTest extends BaseParserTest {
  
  public GeneralParserTest() {
    setParser(new GeneralParser(), "", "");
  }
  
  @SuppressWarnings("static-access")
  @BeforeClass
  public static void classSetup() {
    TestManagePreferences pmgr = new TestManagePreferences();
    pmgr.setLocation("General");
    pmgr.setOverrideDefault(true);
    pmgr.setFilter("1112223333");
  }
  
  @Test
  public void testProblem() {
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "2010-189098*1211 PECAN ST***CONOVER**OVERDOSE*********",
        "ID:2010-189098",
        "ADDR:1211 PECAN ST",
        "CALL:CONOVER",
        "INFO:OVERDOSE");
    
    doTest("T2",
        "DEPTWK     TYP: MVA- UNKNOWN STATUS AD: RTE 17 W&DARK DR W OFF CTY: WALLKILL CN: RICHARD CMT1: CALLER REPORTS A 2 CAR MV",
        "CALL:MVA- UNKNOWN STATUS",
        "ADDR:RTE 17 W & DARK DR W",
        "CITY:WALLKILL",
        "PLACE:RICHARD",
        "INFO:OFF / CALLER REPORTS A 2 CAR MV");
    
    doTest("T3",
        "S: M:CAD:4 HICKORY TREE RD;B11;VERIZON;(Z)MOTOR VEH ACCIDENT INJURY;LOWER GRASSY BRANCH RD;JULIANNE PL",
        "ADDR:4 HICKORY TREE RD",
        "UNIT:B11",
        "CALL:VERIZON",
        "INFO:(Z)MOTOR VEH ACCIDENT INJURY",
        "X:LOWER GRASSY BRANCH RD & JULIANNE PL");
    
    doTest("T4",
        "([cad13] ) Call:30A01-TRAUMA NOT DAN,775 GATEWAY DR SE Apt:CLUBHS,X-St:SYCOLIN RD SE VAN,M6132 ACO13,Box:2013 ,ADC:515",
        "CALL:30A01-TRAUMA NOT DAN",
        "ADDR:775 GATEWAY DR SE",
        "APT:CLUBHS",
        "X:SYCOLIN RD SE VAN",
        "UNIT:M6132 ACO13",
        "BOX:515");

    doTest("T5",
        "MBLS-MEDICAL Location: 160 RICHARD DR DAYTON XENIA RD / ROBERT LN XENIA TWP Time: 17:31 Units: M51  Common",
        "CALL:MBLS-MEDICAL",
        "ADDR:160 RICHARD DR",
        "INFO:DAYTON XENIA RD / ROBERT LN XENIA TWP",
        "UNIT:M51  Common");
    
    doTest("T6",
        "ST3000 TYP: SMOKE IN DWELLING AD: 2008 ELBOW LN CTY: LOWER MACUNGIE CN: LINDA STROHL CMT1: **SMOKE IN THE DWELLING CMT2: SMOKE COMING FROM THE EXHAUST PIPE OF HEATING SYSTEM FILLING BASEMENT WIT TIME: 06:58 UNTS: FD/30CHIEFS FD/ST30 FD/A6681 FD/ST66 FD/R3041 FD/E3012 FD/TK3031 FD/E3112 XST: 4486 REDWOOD LN XST2: HESS CIR",
        "CALL:SMOKE IN DWELLING",
        "ADDR:2008 ELBOW LN",
        "CITY:LOWER MACUNGIE",
        "INFO:SMOKE IN THE DWELLING / SMOKE COMING FROM THE EXHAUST PIPE OF HEATING SYSTEM FILLING BASEMENT WIT",
        "PLACE:LINDA STROHL",
        "UNIT:FD/30CHIEFS FD/ST30 FD/A6681 FD/ST66 FD/R3041 FD/E3012 FD/TK3031 FD/E3112",
        "X:4486 REDWOOD LN & HESS CIR");
    
    doTest("T7",
        "IPS I/Page Notification / Loc: 7583 WALL TRIANA HWY MDCO: @URGENT MEDCARE EVT#: C1009726 TYPE: M TIME: 13:36:55",
        "CALL:IPS I/Page Notification /",
        "ADDR:7583 WALL TRIANA HWY",
        "INFO:MDCO: @URGENT MEDCARE",
        "ID:C1009726");
    
    doTest("T8",
        "(*CAD*) [CAD] CO DETECTOR, CARBON MONOXIDE, 8A 2204 JASON CT 7 K2 CALLER ADVISED HIS BSMT CO DETECTOR IS GOING OFF. F103510001 1022578 02:01",
        "CALL:CARBON MONOXIDE",
        "ADDR:8A 2204 JASON CT",
        "APT:7",
        "INFO:K2 CALLER ADVISED HIS BSMT CO DETECTOR IS GOING OFF F103510001 1022578 02: 01");
    
    doTest("T9",
        "CAD:16 BLUE HERON DR;B213;BECKHAM, LINDA & MALACHY;FALLS;RIVER CANE DR",
        "ADDR:16 BLUE HERON DR",
        "UNIT:B213",
        "CALL:BECKHAM",
        "X:LINDA & MALACHY & RIVER CANE DR",
        "INFO:FALLS");
    
    doTest("T10",
          "(CAD Page) FIRE, SMOKE CHECK; 21199 HWY 299 E ,BELLAVISTA ; ; 11764 BLK REBECCA LN; Map: 3225; Inc# 009012; VOL33; neighbor burning",
          "CALL:SMOKE CHECK",
          "ADDR:21199 HWY 299 E",
          "INFO:BELLAVISTA; neighbor burning",
          "X:11764 BLK REBECCA LN",
          "MAP:3225",
          "ID:009012",
          "UNIT:VOL33");
    
    doTest("T11",
          "Inc: SICK PERSON Add: 352 STATE ST\nCity: ST_MARYS\nXSt: ANTHONY RD * RIDGWAY ST MARYS RD\nAgency: ST MARYS AMB", 
          "CALL:SICK PERSON",
          "ADDR:352 STATE ST",
          "CITY:ST_MARYS",
          "X:ANTHONY RD",
          "INFO:RIDGWAY ST MARYS RD",
          "SRC:ST MARYS AMB"); 
    
    doTest("T12",
        "DEPTWK     TYP: MEDICAL ASSISTANCE AD: 455 SCHUTT ROAD EXT CTY: WALLKILL CN: MOBILE LIFE CMT1: EVALUATION FROM MVA CMT2: Ori",
        "CALL:MEDICAL ASSISTANCE",
        "ADDR:455 SCHUTT ROAD EXT",
        "CITY:WALLKILL",
        "PLACE:MOBILE LIFE",
        "INFO:EVALUATION FROM MVA / Ori");
    
    doTest("T13",
        "DEPTWK     TYP: HEMORHAGE/LACERATION BLD: 10 APT: 1001 AD: 203 GENUNG ST CTY: WALLKILL CN: BERNADETTE CMT1: MLACERATION TO H",
        "CALL:HEMORHAGE/LACERATION",
        "APT:10-1001",
        "ADDR:203 GENUNG ST",
        "CITY:WALLKILL",
        "PLACE:BERNADETTE",
        "INFO:MLACERATION TO H");

  }
}