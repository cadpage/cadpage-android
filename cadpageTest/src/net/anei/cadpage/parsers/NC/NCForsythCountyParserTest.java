package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Forsyth County, NC
Contact: Shane Taylor <dstaylor9@gmail.com>
Contact: "Fulk, Brad" <bfulk@huntersvillefd.com>
Sender: forsythcountyfir@bellsouth.net,lfdalltext@lewisvillefire.com

Location: 1 STOKES COUNTY: @STOKES COUNTY: 2312 HWY 65 E Nature: Unconscious/Unresponsive/Syncope P:1  - default DISTRICT: R09 X Str: / CALLER NAME: STOK
Location: 6206 REIDSVILLE RD FC: @CREEKSIDE MANOR Nature: Chest Pain/Heart Problems P:1  - WITH_SYMPTOMS DISTRICT: R31 X Str: GOODWILL CHURCH RD/PINEY GR
Location: 9350 FREEMAN RD FC Nature: Headache P:1  - VISION_PROBLEMS DISTRICT: R31 X Str: PINEY GROVE RD/GOODWILL CHURCH RD CALLER NAME: MARTIN, NAOMI
Location: 6000BLK REIDSVILLE RD FC Nature: PUBLIC SERVICE CALL P:3  - default DISTRICT: F31 X Str: BRINKLEY RD/GOODWILL CHURCH RD CALLER NAME:
Location: 1105 WHISPERING PINES DR FC Nature: Power Lines Arcing on Pole P:2  - default DISTRICT: F31 X Str: WARDS POND CT/QUAIL HOLLOW RD CALLER NAME:
Location: 5825 POPPY SEED DR FC Nature: Brush Fire P:1  - default DISTRICT: F31 X Str: BRINKLEY PARK DR/JILAIN ST CALLER NAME: CARANNA, KENWYN
Location: 1800 SPRINGFIELD FARM CT CL Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: R11 X Str: SPRINGFIELD FARM RD/ CALLER NAME:
Location: 4595 STYERS FERRY RD WS Nature: Sick/Unknown P:1  - default DISTRICT: R11 X Str: FOX RIDGE LN/REMINGTON DR CALLER NAME:
Nature: Motor Vehicle Accident P:1  - default DISTRICT: R11 X Str: LEWISVILLE-CLEMMONS RD/REYNOLDS RD CALLER NAME:
Location: NB 421 FC Nature: Motor Vehicle Accident P:1  - default DISTRICT: R13 X Str: SCOTT RD/SB 421 CALLER NAME: FCSD
Location: 191 LOWES FOOD DR FC: @A CLEANER WORLD Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F11 X Str: JENNINGS RD/SHALLOWFORD RD CALLER
Location: 6441 HOLDER RD CL,RM 8: @CLEMMONS VILLAGE II Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: R11 X Str: HOLDER CT/SOUTHWEST SCH

Contact: Eugene Vogler <pwvogler@gmail.com>
Location: 1 STOKES COUNTY: @STOKES COUNTY:511 WINDMILL ST Nature: DOA P:1  - default DISTRICT: F09 X Str: / CALLER NAME: 1224

Contact: Joshua Brady <jbrady1009@gmail.com>
Location: NB 311 WS Nature: Motor Vehicle Accident P:1  - default DISTRICT: F28 X Str: UNION CROSS RD_NB 311 RA/NB 311_RIDGEWOOD

Contact: Tim Swaim <swaimus@gmail.com>
Location: 125 CHAUCER VIEW CIR KE Nature: Chest Pain/Heart Problems P:1  - default DISTRICT: F41 X Str: CHAUCER MANOR LN/CHAUCER

Contact: support@active911.com
Sender: FCFD <forsythcountyfir@bellsouth.net>
Location: 6010 MEADOWBROOK MALL CT CL: @CREST OF CLEMMONS Nature: Unconscious/Unresponsive/Syncope P:1  - CONFIRMED DISTRICT: F14 X Str: RAMADA DR/ CALLER NAME: THE CREST OF CLEMMONS
Location: 3905 CLEMMONS RD CL: @REGENCY CARE OF CLEMMONS Nature: Breathing Difficulty P:1  - OVER_50_DIFF DISTRICT: F14 X Str: BRIDGEWATER DR/JOY PARK LN CALLER NAME: DOMINION MANAGEMENT GROUP / FORS

Contact: Active911
Agency name: Colfax Fire Department
Location: Colfax, NC, United States
Sender: FCFD <forsythcountyfir@bellsouth.net>
Location: WB 40 FC Nature: Vehicle Fire P:1  - default DISTRICT: F26 X Str: EB 40/BROOKFORD RD CALLER NAME: WILL SMITH 
Location: 218 LAKEVIEW DR KE Nature: House Fire P:1  - default DISTRICT: FGU16 X Str: EAST MOUNTAIN ST/ CALLER NAME: LAZURE, LOIS 

Contact: Active911
Agency name: Old Richmond Volunteer Fire Department
Location: Tobaccoville, NC, United States
Sender: FCFD <forsythcountyfir@bellsouth.net>

Location: 4605 TOBACCOVILLE RD TO:APT 5 Nature: Falls P:1  - BREATHING_DIFF DISTRICT: F27 X Str: FIP NEWSOME RD/ROCKWELL PLACE DR CALLER NAME: MELISSA 
Location: 3395 BEROTH RD FC Nature: House Fire P:1  - default DISTRICT: F21 X Str: PIGLET PL/RIVER RIDGE RD CALLER NAME: FCSO 
Location: 8318 DONNAHA RD FC Nature: Sick/Unknown P:1  - DLOC DISTRICT: F27 X Str: MARTIN FERRY RD/FISHER RD CALLER NAME: ALLEN, STANLEY 
Nature: Brush Fire P:1  - default DISTRICT: F27 X Str: REYNOLDA RD/SEWARD CIR CALLER NAME:  
Location: 5211 BETHANIA RD BE Nature: Motor Vehicle Accident P:1  - default DISTRICT: F27 X Str: DAVIS ACRES LN/QUEENS GRANT RD CALLER NAME: FCSO 
Location: 1645 GRIFFIN RD FC: @FAITH UMC Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F23 X Str: SHORE RD/OLD GRIFFIN RD CALLER NAME: SEC CENTRAL 
Location: 8318 DONNAHA RD FC Nature: Abdominal/Back Pain P:1  - DLOC DISTRICT: F27 X Str: MARTIN FERRY RD/FISHER RD CALLER NAME: ALLEN, STANLEY 
Location: 1 STOKES COUNTY: 216 MOORE RD Nature: Building Fire P:1  - default DISTRICT: F09 X Str: / CALLER NAME:  
Location: 6725 RIDGE RD FC Nature: Sick/Unknown P:1  - MEDIC_ALARM DISTRICT: F27 X Str: CHIGWELL TR/WALL RD CALLER NAME: LIFELINE 
Nature: Motor Vehicle Accident P:1  - MOTORCYCLE DISTRICT: F27 X Str: DORAL DR/MYERS RD CALLER NAME:  
Location: 6725 RIDGE RD FC Nature: Sick/Unknown P:1  - MEDIC_ALARM DISTRICT: F27 X Str: CHIGWELL TR/WALL RD CALLER NAME: LIFELINE/KARENC760801 
Location: 3230 WIDE COUNTRY RD TO Nature: Choking P:1  - default DISTRICT: F27 X Str: GLADEWATER DR/GLARESTONE DR CALLER NAME:  
Location: 4820 ELLEN AV FC Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: F27 X Str: /JANE AV CALLER NAME:  
Location: 5545 MAIN ST BE: @BETHANIA MORAVIAN CHURCH Nature: Breathing Difficulty P:1  - OVER_50_DIFF DISTRICT: F27 X Str: BETHANIA RD/JAN HUS LN CALLER NAME: JOHN 
Location: 1013 BETHANIA-RURAL HALL RD RH: @PRO SHOTS RANGE Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F23 X Str: FORUM PKWY/NORVASA ST CALLER NAME: LOSS PREVENTION 
Location: 4500 COTSWOLD RD FC Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F27 X Str: SHERBORNE DR/ CALLER NAME:  
Location: 2700 GRIFFIN RD TO Nature: Stroke (CVA) P:1  - DIABETIC DISTRICT: F27 X Str: WHIPPORWILL LN/SILVER CREST LN CALLER NAME: NEWSOM, BILL 
Location: 7569 GREENMEADOW DR TO Nature: Public Service (Fire) P:2  - default DISTRICT: F30 X Str: GREENMEADOW CT/ CALLER NAME: HOMEOWNER 
Location: 5878 JOYCE NORMAN RD FC Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: F27 X Str: SCALES DR/VOGLER RD CALLER NAME: JOYNER, H L 
Location: 7765 RIDGE RD TO Nature: Sick/Unknown P:1  - MEDIC_ALARM DISTRICT: F27 X Str: GREEN PARK RD/ALANDALE CIR CALLER NAME: ADT 
Location: 6006 ELKVUE DR FC Nature: Public Service (Fire) P:2  - default DISTRICT: F27 X Str: REYNOLDA RD/INDIAN CAMP DR CALLER NAME: BRITTANY-922-3813 
Location: 6315 TOBACCOVILLE RD TO: @OLD RICHMOND ELEMENTARY Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F27 X Str: BRIGGS RD/LEAFMORE LN CALLER NAME: SECURITY CENTRAL 7160 
Location: 4355 JANE AV FC Nature: Abdominal/Back Pain P:1  - UPPER_ABD DISTRICT: F27 X Str: ELLEN AV/ CALLER NAME: JACKSON, MARIE 
Location: 1065 BETHANIA-RURAL HALL RD RH: @KANGAROO EXPRESS Nature: Building Fire P:1  - default DISTRICT: F23 X Str: NORVASA ST/BETHANIA RURAL HALL RD_NB 52 RA CALLER NAME: 860-MOORE 
Location: 6601 YADKINVILLE RD LE: @VIENNA VILLAGE Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F21 X Str: PINE TRAILS RD/JUST A MERE LN CALLER NAME: UNITED CENTRAL 
Location: 5855 WOODSWAY DR TO Nature: Diabetic P:1  - DLOC DISTRICT: F27 X Str: MEADOW LN/MEADOW LN CALLER NAME: PARKER, DAVID L 
Location: 3311 WIDE COUNTRY RD TO Nature: Chest Pain/Heart Problems P:1  - BREATHING_DIFF DISTRICT: F27 X Str: GLADEWATER DR/GLARESTONE DR CALLER NAME: PARLIER, DEWEY G 
Location: 5143 WHITMAN RD FC Nature: Falls P:1  - CRUSHING DISTRICT: F27 X Str: COON CREEK RD/SEVEN HILLS RD CALLER NAME: WHITLEY, JOHN 
Location: 7276 REYNOLDA RD FC Nature: House Fire P:1  - default DISTRICT: F27 X Str: SHADY RIDGE LN/MONTFORD RD CALLER NAME:  
Location: 7424 RIDGE RD FC Nature: Illegal burning P:2  - default DISTRICT: F27 X Str: BOILING SPRINGS RD/GREEN PARK RD CALLER NAME: JOSEPH BOWMAN 
Location: 1 STOKES COUNTY: @STOKES COUNTY: 614 S MAIN,DOMINOS Nature: Building Fire P:1  - default DISTRICT: F09 X Str: / CALLER NAME:  
Nature: Public Service (Fire) P:2  - default DISTRICT: F27 X Str: TOBACCOVILLE RD/RIDGE RD CALLER NAME: JAMES LAWSON 
Location: 7424 OLIN RD FC Nature: Unconscious/Unresponsive/Syncope P:1  - UNCONSCIOUS DISTRICT: F27 X Str: PENROSE RD/BOLIN RD CALLER NAME: FIELDS, CINDY 
Location: 4618 TOBACCOVILLE RD TO Nature: Motor Vehicle Accident P:1  - default DISTRICT: F27 X Str: ROCKWELL PLACE DR/RIDGE RD CALLER NAME:  
Location: 3000 BIG OAKS DR KI: @CRES TOBACCO Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F30 X Str: DORAL DR/ CALLER NAME:  
Location: 6497 DORAL DR TO Nature: Falls P:1  - DLOC DISTRICT: F27 X Str: MIZPAH CHURCH RD/GRIFFIN RD CALLER NAME:  
Nature: Brush Fire P:1  - default DISTRICT: F27 X Str: WESTERLY DR/NORTHEAST DR CALLER NAME: CRYSTAL 
Location: 6825 ROLLING VIEW DR FC: @RIVERWOOD RIDING CENTER Nature: Seizures P:1  - UNKNOWN_HX DISTRICT: F27 X Str: PHILCOAT DR/LITTLEFIELD RD CALLER NAME:  
Location: 350 FORUM PKWY RH: @ALLIANCE DISPLAY Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F23 X Str: /NORTHSTAR DR CALLER NAME: TYCO 
Location: 4730 SEWARD RD FC Nature: Falls P:1  - DLOC DISTRICT: F27 X Str: PARAMOUNT RD/SILVER SPRINGS RD CALLER NAME: STOUT, JUNE 
Location: 3409 WIDE COUNTRY RD TO Nature: Overdose/Poisoning P:1  - RX_MEDS DISTRICT: F27 X Str: BLAZINGWOOD DR/EDGEWORTH TR CALLER NAME: ALAN 
Location: 5135 RIVER BLUFF FARMS RD FC Nature: Bleeding (Non-Traumatic) P:1  - UNCONTROLLED DISTRICT: F27 X Str: /TUTELO FORREST TR CALLER NAME: HICKS, B C 
Location: 9429 REYNOLDA RD FC Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: F27 X Str: WALLER RD/RIDGE RD CALLER NAME: DWAYNE 
Location: 350 FORUM PKWY RH: @ALLIANCE DISPLAY Nature: Alarms - Fire or Smoke P:1  - default DISTRICT:  X Str: /NORTHSTAR DR CALLER NAME: TYCO SECURITY 
Location: 5102 VOGLER RD FC Nature: Breathing Difficulty P:1  - OVER_50_DIFF DISTRICT: F27 X Str: /JOYCE NORMAN RD CALLER NAME: PARKS, VAUGHN L 
Location: 1 STOKES COUNTY: @STOKES COUNTY: @102 KELLYSTONE DR Nature: Multi-Family Dwelling Fire P:1  - default DISTRICT: F09 X Str: / CALLER NAME:  
Location: 2224 VIENNA-DOZIER RD LE Nature: House Fire P:1  - default DISTRICT: F21 X Str: STANDING OAK LN/RIVER RIDGE RD CALLER NAME: CARVANA, MARTINO 
Location: 5715 RIVER BLUFF FARMS RD FC Nature: Unconscious/Unresponsive/Syncope P:1  - default DISTRICT: F27 X Str: TUTELO FORREST TR/DAN LONGMAN RD CALLER NAME: RANDI 
Location: 6140 DORAL DR TO:LOT 12 Nature: Mental/Emotional/Psychological P:1  - UNCONTROL_BLEED DISTRICT: F27 X Str: KAPP RD/WIDE COUNTRY RD CALLER NAME:  
Location: 4057 ELIZABETH PARK DR FC Nature: Breathing Difficulty P:1  - OVER_50_DIFF DISTRICT: F27 X Str: /MATTHEW FOREST LN CALLER NAME: BANNER, VANESSA 
Location: 6585 DORAL DR TO Nature: Unconscious/Unresponsive/Syncope P:1  - FAINT DISTRICT: F27 X Str: GRIFFIN RD/KREEGER FARM RD CALLER NAME: BOYD, MURRY L 
Location: 5143 WHITMAN RD FC Nature: Chest Pain/Heart Problems P:1  - HX DISTRICT: F27 X Str: COON CREEK RD/SEVEN HILLS RD CALLER NAME: WHITLEY, JOHN 
Location: 2880 BIG OAKS DR KI Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F30 X Str: DORAL DR/ CALLER NAME:  
Location: 7765 RIDGE RD TO Nature: Sick/Unknown P:1  - MEDIC_ALARM DISTRICT: F27 X Str: GREEN PARK RD/ALANDALE CIR CALLER NAME: ADT 
Location: 5315 SHADY RIDGE LN FC Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F27 X Str: REYNOLDA RD/ CALLER NAME: ADT 
Location: 7475 OLIN RD FC Nature: BURNS: Thermal/Electrical.Chemical P:1  - OVER_20_PER DISTRICT: F27 X Str: PENROSE RD/BOLIN RD CALLER NAME: BAKER, TRINA 
Location: 5798 DAVIS RD FC Nature: Brush Fire P:1  - default DISTRICT: F18 X Str: DYLANWOOD DR/ CALLER NAME: VALARIA 
Location: 2227 STANDING OAK LN LE Nature: Building Fire P:1  - default DISTRICT: F21 X Str: VIENNA-DOZIER RD/ CALLER NAME:  
Location: 4291 VIENNA-DOZIER RD FC Nature: Chest Pain/Heart Problems P:1  - WITH_SYMPTOMS DISTRICT: F27 X Str: WISHING WELL RD/FRIES CREEK RD CALLER NAME: TUTTLE, JOHN/CASEY 
Location: 5530 MAIN ST BE: @ANTIQUES IN BETHANIA Nature: Assault/Gunshot/Stabbing P:1  - NECK_INJURY DISTRICT: F27 X Str: BETHANIA RD/JAN HUS LN CALLER NAME:  
Location: 4735 WARNER RD FC Nature: House Fire P:1  - default DISTRICT: F27 X Str: ARCHDALE RD/WALDRAVEN RD CALLER NAME:  
Location: 5135 RIVER BLUFF FARMS RD FC Nature: Public Service (Rescue) P:2  - default DISTRICT: F27 X Str: /TUTELO FORREST TR CALLER NAME: LIFELINE 
Location: 4484 COTSWOLD RD FC Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: F27 X Str: COTSWOLD CT/SHERBORNE DR CALLER NAME: BARKER, BETTY 
Location: RIDGE RD FC Nature: Brush Fire P:1  - default DISTRICT: F27 X Str: CHIGWELL TR/WALL RD CALLER NAME: 127 
Location: 3474 BOWENS RD TO Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: F27 X Str: HUNTING HOUNDS RUN/SETTLE WOOD LN CALLER NAME: RACHEL 
Location: 6006 ELKVUE DR FC Nature: Sick/Unknown P:1  - DIAPHORESIS DISTRICT: F27 X Str: REYNOLDA RD/INDIAN CAMP DR CALLER NAME: SUTYAK, DEBORAH A 
Location: 9130 REYNOLDA RD FC Nature: Motor Vehicle Accident P:1  - default DISTRICT: F27 X Str: ELKVUE DR/WALLER RD CALLER NAME: BOST, RODNEY 
Location: 8030 REYNOLDA RD FC Nature: Chest Pain/Heart Problems P:1  - HX DISTRICT: F27 X Str: TURNER RD/JOYCE NORMAN RD CALLER NAME: VERIZON WIRELESS 
Location: 7696 DONNAHA RD FC Nature: Stroke (CVA) P:1  - HEADACHE DISTRICT: F27 X Str: MARTIN FERRY RD/FISHER RD CALLER NAME:  
Location: 6445 REYNOLDA RD FC Nature: Mental/Emotional/Psychological P:1  - default DISTRICT: F27 X Str: BETHANIA RD/ROBERTS RD CALLER NAME:  

 */

public class NCForsythCountyParserTest extends BaseParserTest {
  
  public NCForsythCountyParserTest() {
    setParser(new NCForsythCountyParser(), "FORSYTH COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Location: 1 STOKES COUNTY: @STOKES COUNTY: 2312 HWY 65 E Nature: Unconscious/Unresponsive/Syncope P:1  - default DISTRICT: R09 X Str: / CALLER NAME: STOK",
        "ADDR:2312 HWY 65 E",
        "CITY:STOKES COUNTY",
        "CALL:Unconscious/Unresponsive/Syncope",
        "PRI:1",
        "UNIT:R09",
        "NAME:STOK");

    doTest("T2",
        "Location: 6206 REIDSVILLE RD FC: @CREEKSIDE MANOR Nature: Chest Pain/Heart Problems P:1  - WITH_SYMPTOMS DISTRICT: R31 X Str: GOODWILL CHURCH RD/PINEY GR",
        "ADDR:6206 REIDSVILLE RD",
        "PLACE:CREEKSIDE MANOR",
        "CALL:Chest Pain/Heart Problems",
        "PRI:1",
        "UNIT:R31",
        "X:GOODWILL CHURCH RD/PINEY GR");

    doTest("T3",
        "Location: 9350 FREEMAN RD FC Nature: Headache P:1  - VISION_PROBLEMS DISTRICT: R31 X Str: PINEY GROVE RD/GOODWILL CHURCH RD CALLER NAME: MARTIN, NAOMI",
        "ADDR:9350 FREEMAN RD",
        "CALL:Headache",
        "PRI:1",
        "UNIT:R31",
        "X:PINEY GROVE RD/GOODWILL CHURCH RD",
        "NAME:MARTIN, NAOMI");

    doTest("T4",
        "Location: 6000BLK REIDSVILLE RD FC Nature: PUBLIC SERVICE CALL P:3  - default DISTRICT: F31 X Str: BRINKLEY RD/GOODWILL CHURCH RD CALLER NAME:",
        "ADDR:6000BLK REIDSVILLE RD",
        "MADDR:6000 REIDSVILLE RD",
        "CALL:PUBLIC SERVICE CALL",
        "PRI:3",
        "UNIT:F31",
        "X:BRINKLEY RD/GOODWILL CHURCH RD");

    doTest("T5",
        "Location: 1105 WHISPERING PINES DR FC Nature: Power Lines Arcing on Pole P:2  - default DISTRICT: F31 X Str: WARDS POND CT/QUAIL HOLLOW RD CALLER NAME:",
        "ADDR:1105 WHISPERING PINES DR",
        "CALL:Power Lines Arcing on Pole",
        "PRI:2",
        "UNIT:F31",
        "X:WARDS POND CT/QUAIL HOLLOW RD");

    doTest("T6",
        "Location: 5825 POPPY SEED DR FC Nature: Brush Fire P:1  - default DISTRICT: F31 X Str: BRINKLEY PARK DR/JILAIN ST CALLER NAME: CARANNA, KENWYN",
        "ADDR:5825 POPPY SEED DR",
        "CALL:Brush Fire",
        "PRI:1",
        "UNIT:F31",
        "X:BRINKLEY PARK DR/JILAIN ST",
        "NAME:CARANNA, KENWYN");

    doTest("T7",
        "Location: 1800 SPRINGFIELD FARM CT CL Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: R11 X Str: SPRINGFIELD FARM RD/ CALLER NAME:",
        "ADDR:1800 SPRINGFIELD FARM CT",
        "CITY:CLEMMONS",
        "CALL:Breathing Difficulty",
        "PRI:1",
        "UNIT:R11",
        "X:SPRINGFIELD FARM RD");

    doTest("T8",
        "Location: 4595 STYERS FERRY RD WS Nature: Sick/Unknown P:1  - default DISTRICT: R11 X Str: FOX RIDGE LN/REMINGTON DR CALLER NAME:",
        "ADDR:4595 STYERS FERRY RD",
        "CITY:WINSTON-SALEM",
        "CALL:Sick/Unknown",
        "PRI:1",
        "UNIT:R11",
        "X:FOX RIDGE LN/REMINGTON DR");

    doTest("T9",
        "Nature: Motor Vehicle Accident P:1  - default DISTRICT: R11 X Str: LEWISVILLE-CLEMMONS RD/REYNOLDS RD CALLER NAME:",
        "ADDR:LEWISVILLE-CLEMMONS RD & REYNOLDS RD",
        "CALL:Motor Vehicle Accident",
        "PRI:1",
        "UNIT:R11");

    doTest("T10",
        "Location: NB 421 FC Nature: Motor Vehicle Accident P:1  - default DISTRICT: R13 X Str: SCOTT RD/SB 421 CALLER NAME: FCSD",
        "ADDR:NB 421",
        "MADDR:421 & SCOTT RD",
        "CALL:Motor Vehicle Accident",
        "PRI:1",
        "UNIT:R13",
        "X:SCOTT RD/SB 421",
        "NAME:FCSD");

    doTest("T11",
        "Location: 191 LOWES FOOD DR FC: @A CLEANER WORLD Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F11 X Str: JENNINGS RD/SHALLOWFORD RD CALLER",
        "ADDR:191 LOWES FOOD DR",
        "PLACE:A CLEANER WORLD",
        "CALL:Alarms - Fire or Smoke",
        "PRI:1",
        "UNIT:F11",
        "X:JENNINGS RD/SHALLOWFORD RD");

    doTest("T12",
        "Location: 6441 HOLDER RD CL,RM 8: @CLEMMONS VILLAGE II Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: R11 X Str: HOLDER CT/SOUTHWEST SCH",
        "ADDR:6441 HOLDER RD",
        "CITY:CLEMMONS",
        "APT:8",
        "PLACE:CLEMMONS VILLAGE II",
        "CALL:Breathing Difficulty",
        "PRI:1",
        "UNIT:R11",
        "X:HOLDER CT/SOUTHWEST SCH");
    
    doTest("T13",
        "Location: 1 STOKES COUNTY: @STOKES COUNTY:511 WINDMILL ST Nature: DOA P:1  - default DISTRICT: F09 X Str: / CALLER NAME: 1224",
        "ADDR:511 WINDMILL ST",
        "CITY:STOKES COUNTY",
        "CALL:DOA",
        "PRI:1",
        "UNIT:F09",
        "NAME:1224");

    doTest("T14",
        "Location: NB 311 WS Nature: Motor Vehicle Accident P:1  - default DISTRICT: F28 X Str: UNION CROSS RD_NB 311 RA/NB 311_RIDGEWOOD",
        "ADDR:NB 311",
        "MADDR:311 & UNION CROSS RD 311",
        "CITY:WINSTON-SALEM",
        "CALL:Motor Vehicle Accident",
        "PRI:1",
        "UNIT:F28",
        "X:UNION CROSS RD NB 311 RA/NB 311 RIDGEWOOD");

    doTest("T15",
        "Location: 125 CHAUCER VIEW CIR KE Nature: Chest Pain/Heart Problems P:1  - default DISTRICT: F41 X Str: CHAUCER MANOR LN/CHAUCER",
        "ADDR:125 CHAUCER VIEW CIR",
        "CITY:KERNERSVILLE",
        "CALL:Chest Pain/Heart Problems",
        "PRI:1",
        "UNIT:F41",
        "X:CHAUCER MANOR LN/CHAUCER");
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "Location: 6010 MEADOWBROOK MALL CT CL: @CREST OF CLEMMONS Nature: Unconscious/Unresponsive/Syncope P:1  - CONFIRMED DISTRICT: F14 X Str: RAMADA DR/ CALLER NAME: THE CREST OF CLEMMONS",
        "ADDR:6010 MEADOWBROOK MALL CT",
        "CITY:CLEMMONS",
        "PLACE:CREST OF CLEMMONS",
        "CALL:Unconscious/Unresponsive/Syncope",
        "PRI:1",
        "UNIT:F14",
        "X:RAMADA DR",
        "NAME:THE CREST OF CLEMMONS");

    doTest("T2",
        "Location: 3905 CLEMMONS RD CL: @REGENCY CARE OF CLEMMONS Nature: Breathing Difficulty P:1  - OVER_50_DIFF DISTRICT: F14 X Str: BRIDGEWATER DR/JOY PARK LN CALLER NAME: DOMINION MANAGEMENT GROUP / FORS",
        "ADDR:3905 CLEMMONS RD",
        "CITY:CLEMMONS",
        "PLACE:REGENCY CARE OF CLEMMONS",
        "CALL:Breathing Difficulty",
        "PRI:1",
        "UNIT:F14",
        "X:BRIDGEWATER DR/JOY PARK LN",
        "NAME:DOMINION MANAGEMENT GROUP / FORS");

  }
  
  @Test
  public void testColfaxFire() {

    doTest("T1",
        "Location: WB 40 FC Nature: Vehicle Fire P:1  - default DISTRICT: F26 X Str: EB 40/BROOKFORD RD CALLER NAME: WILL SMITH ",
        "ADDR:WB 40",
        "MADDR:40 & 40",
        "CALL:Vehicle Fire",
        "PRI:1",
        "UNIT:F26",
        "X:EB 40/BROOKFORD RD",
        "NAME:WILL SMITH");

    doTest("T2",
        "Location: 218 LAKEVIEW DR KE Nature: House Fire P:1  - default DISTRICT: FGU16 X Str: EAST MOUNTAIN ST/ CALLER NAME: LAZURE, LOIS ",
        "ADDR:218 LAKEVIEW DR",
        "CITY:KERNERSVILLE",
        "CALL:House Fire",
        "PRI:1",
        "UNIT:FGU16",
        "X:EAST MOUNTAIN ST",
        "NAME:LAZURE, LOIS");

  }
  
  @Test
  public void testOldRichmondVolunteerFireDepartment() {

    doTest("T1",
        "Location: 4605 TOBACCOVILLE RD TO:APT 5 Nature: Falls P:1  - BREATHING_DIFF DISTRICT: F27 X Str: FIP NEWSOME RD/ROCKWELL PLACE DR CALLER NAME: MELISSA ",
        "ADDR:4605 TOBACCOVILLE RD",
        "CITY:TOBACCOVILLE",
        "APT:5",
        "CALL:Falls",
        "PRI:1",
        "UNIT:F27",
        "X:FIP NEWSOME RD/ROCKWELL PLACE DR",
        "NAME:MELISSA");

    doTest("T2",
        "Location: 3395 BEROTH RD FC Nature: House Fire P:1  - default DISTRICT: F21 X Str: PIGLET PL/RIVER RIDGE RD CALLER NAME: FCSO ",
        "ADDR:3395 BEROTH RD",
        "CALL:House Fire",
        "PRI:1",
        "UNIT:F21",
        "X:PIGLET PL/RIVER RIDGE RD",
        "NAME:FCSO");

    doTest("T3",
        "Location: 8318 DONNAHA RD FC Nature: Sick/Unknown P:1  - DLOC DISTRICT: F27 X Str: MARTIN FERRY RD/FISHER RD CALLER NAME: ALLEN, STANLEY ",
        "ADDR:8318 DONNAHA RD",
        "CALL:Sick/Unknown",
        "PRI:1",
        "UNIT:F27",
        "X:MARTIN FERRY RD/FISHER RD",
        "NAME:ALLEN, STANLEY");

    doTest("T4",
        "Nature: Brush Fire P:1  - default DISTRICT: F27 X Str: REYNOLDA RD/SEWARD CIR CALLER NAME:  ",
        "CALL:Brush Fire",
        "PRI:1",
        "UNIT:F27",
        "ADDR:REYNOLDA RD & SEWARD CIR");

    doTest("T5",
        "Location: 5211 BETHANIA RD BE Nature: Motor Vehicle Accident P:1  - default DISTRICT: F27 X Str: DAVIS ACRES LN/QUEENS GRANT RD CALLER NAME: FCSO ",
        "ADDR:5211 BETHANIA RD",
        "CITY:BETHANIA",
        "CALL:Motor Vehicle Accident",
        "PRI:1",
        "UNIT:F27",
        "X:DAVIS ACRES LN/QUEENS GRANT RD",
        "NAME:FCSO");

    doTest("T6",
        "Location: 1645 GRIFFIN RD FC: @FAITH UMC Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F23 X Str: SHORE RD/OLD GRIFFIN RD CALLER NAME: SEC CENTRAL ",
        "ADDR:1645 GRIFFIN RD",
        "PLACE:FAITH UMC",
        "CALL:Alarms - Fire or Smoke",
        "PRI:1",
        "UNIT:F23",
        "X:SHORE RD/OLD GRIFFIN RD",
        "NAME:SEC CENTRAL");

    doTest("T7",
        "Location: 8318 DONNAHA RD FC Nature: Abdominal/Back Pain P:1  - DLOC DISTRICT: F27 X Str: MARTIN FERRY RD/FISHER RD CALLER NAME: ALLEN, STANLEY ",
        "ADDR:8318 DONNAHA RD",
        "CALL:Abdominal/Back Pain",
        "PRI:1",
        "UNIT:F27",
        "X:MARTIN FERRY RD/FISHER RD",
        "NAME:ALLEN, STANLEY");

    doTest("T8",
        "Location: 1 STOKES COUNTY: 216 MOORE RD Nature: Building Fire P:1  - default DISTRICT: F09 X Str: / CALLER NAME:  ",
        "ADDR:216 MOORE RD",
        "CITY:STOKES COUNTY",
        "CALL:Building Fire",
        "PRI:1",
        "UNIT:F09");

    doTest("T9",
        "Location: 6725 RIDGE RD FC Nature: Sick/Unknown P:1  - MEDIC_ALARM DISTRICT: F27 X Str: CHIGWELL TR/WALL RD CALLER NAME: LIFELINE ",
        "ADDR:6725 RIDGE RD",
        "CALL:Sick/Unknown",
        "PRI:1",
        "UNIT:F27",
        "X:CHIGWELL TR/WALL RD",
        "NAME:LIFELINE");

    doTest("T10",
        "Nature: Motor Vehicle Accident P:1  - MOTORCYCLE DISTRICT: F27 X Str: DORAL DR/MYERS RD CALLER NAME:  ",
        "CALL:Motor Vehicle Accident",
        "PRI:1",
        "UNIT:F27",
        "ADDR:DORAL DR & MYERS RD");

    doTest("T11",
        "Location: 6725 RIDGE RD FC Nature: Sick/Unknown P:1  - MEDIC_ALARM DISTRICT: F27 X Str: CHIGWELL TR/WALL RD CALLER NAME: LIFELINE/KARENC760801 ",
        "ADDR:6725 RIDGE RD",
        "CALL:Sick/Unknown",
        "PRI:1",
        "UNIT:F27",
        "X:CHIGWELL TR/WALL RD",
        "NAME:LIFELINE/KARENC760801");

    doTest("T12",
        "Location: 3230 WIDE COUNTRY RD TO Nature: Choking P:1  - default DISTRICT: F27 X Str: GLADEWATER DR/GLARESTONE DR CALLER NAME:  ",
        "ADDR:3230 WIDE COUNTRY RD",
        "CITY:TOBACCOVILLE",
        "CALL:Choking",
        "PRI:1",
        "UNIT:F27",
        "X:GLADEWATER DR/GLARESTONE DR");

    doTest("T13",
        "Location: 4820 ELLEN AV FC Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: F27 X Str: /JANE AV CALLER NAME:  ",
        "ADDR:4820 ELLEN AV",
        "MADDR:4820 ELLEN AVE",
        "CALL:Breathing Difficulty",
        "PRI:1",
        "UNIT:F27",
        "X:/JANE AV");

    doTest("T14",
        "Location: 5545 MAIN ST BE: @BETHANIA MORAVIAN CHURCH Nature: Breathing Difficulty P:1  - OVER_50_DIFF DISTRICT: F27 X Str: BETHANIA RD/JAN HUS LN CALLER NAME: JOHN ",
        "ADDR:5545 MAIN ST",
        "CITY:BETHANIA",
        "PLACE:BETHANIA MORAVIAN CHURCH",
        "CALL:Breathing Difficulty",
        "PRI:1",
        "UNIT:F27",
        "X:BETHANIA RD/JAN HUS LN",
        "NAME:JOHN");

    doTest("T15",
        "Location: 1013 BETHANIA-RURAL HALL RD RH: @PRO SHOTS RANGE Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F23 X Str: FORUM PKWY/NORVASA ST CALLER NAME: LOSS PREVENTION ",
        "ADDR:1013 BETHANIA-RURAL HALL RD",
        "CITY:RURAL HALL",
        "PLACE:PRO SHOTS RANGE",
        "CALL:Alarms - Fire or Smoke",
        "PRI:1",
        "UNIT:F23",
        "X:FORUM PKWY/NORVASA ST",
        "NAME:LOSS PREVENTION");

    doTest("T16",
        "Location: 4500 COTSWOLD RD FC Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F27 X Str: SHERBORNE DR/ CALLER NAME:  ",
        "ADDR:4500 COTSWOLD RD",
        "CALL:Alarms - Fire or Smoke",
        "PRI:1",
        "UNIT:F27",
        "X:SHERBORNE DR");

    doTest("T17",
        "Location: 2700 GRIFFIN RD TO Nature: Stroke (CVA) P:1  - DIABETIC DISTRICT: F27 X Str: WHIPPORWILL LN/SILVER CREST LN CALLER NAME: NEWSOM, BILL ",
        "ADDR:2700 GRIFFIN RD",
        "CITY:TOBACCOVILLE",
        "CALL:Stroke (CVA)",
        "PRI:1",
        "UNIT:F27",
        "X:WHIPPORWILL LN/SILVER CREST LN",
        "NAME:NEWSOM, BILL");

    doTest("T18",
        "Location: 7569 GREENMEADOW DR TO Nature: Public Service (Fire) P:2  - default DISTRICT: F30 X Str: GREENMEADOW CT/ CALLER NAME: HOMEOWNER ",
        "ADDR:7569 GREENMEADOW DR",
        "CITY:TOBACCOVILLE",
        "CALL:Public Service (Fire)",
        "PRI:2",
        "UNIT:F30",
        "X:GREENMEADOW CT",
        "NAME:HOMEOWNER");

    doTest("T19",
        "Location: 5878 JOYCE NORMAN RD FC Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: F27 X Str: SCALES DR/VOGLER RD CALLER NAME: JOYNER, H L ",
        "ADDR:5878 JOYCE NORMAN RD",
        "CALL:Breathing Difficulty",
        "PRI:1",
        "UNIT:F27",
        "X:SCALES DR/VOGLER RD",
        "NAME:JOYNER, H L");

    doTest("T20",
        "Location: 7765 RIDGE RD TO Nature: Sick/Unknown P:1  - MEDIC_ALARM DISTRICT: F27 X Str: GREEN PARK RD/ALANDALE CIR CALLER NAME: ADT ",
        "ADDR:7765 RIDGE RD",
        "CITY:TOBACCOVILLE",
        "CALL:Sick/Unknown",
        "PRI:1",
        "UNIT:F27",
        "X:GREEN PARK RD/ALANDALE CIR",
        "NAME:ADT");

    doTest("T21",
        "Location: 6006 ELKVUE DR FC Nature: Public Service (Fire) P:2  - default DISTRICT: F27 X Str: REYNOLDA RD/INDIAN CAMP DR CALLER NAME: BRITTANY-922-3813 ",
        "ADDR:6006 ELKVUE DR",
        "CALL:Public Service (Fire)",
        "PRI:2",
        "UNIT:F27",
        "X:REYNOLDA RD/INDIAN CAMP DR",
        "NAME:BRITTANY-922-3813");

    doTest("T22",
        "Location: 6315 TOBACCOVILLE RD TO: @OLD RICHMOND ELEMENTARY Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F27 X Str: BRIGGS RD/LEAFMORE LN CALLER NAME: SECURITY CENTRAL 7160 ",
        "ADDR:6315 TOBACCOVILLE RD",
        "CITY:TOBACCOVILLE",
        "PLACE:OLD RICHMOND ELEMENTARY",
        "CALL:Alarms - Fire or Smoke",
        "PRI:1",
        "UNIT:F27",
        "X:BRIGGS RD/LEAFMORE LN",
        "NAME:SECURITY CENTRAL 7160");

    doTest("T23",
        "Location: 4355 JANE AV FC Nature: Abdominal/Back Pain P:1  - UPPER_ABD DISTRICT: F27 X Str: ELLEN AV/ CALLER NAME: JACKSON, MARIE ",
        "ADDR:4355 JANE AV",
        "MADDR:4355 JANE AVE",
        "CALL:Abdominal/Back Pain",
        "PRI:1",
        "UNIT:F27",
        "X:ELLEN AV",
        "NAME:JACKSON, MARIE");

    doTest("T24",
        "Location: 1065 BETHANIA-RURAL HALL RD RH: @KANGAROO EXPRESS Nature: Building Fire P:1  - default DISTRICT: F23 X Str: NORVASA ST/BETHANIA RURAL HALL RD_NB 52 RA CALLER NAME: 860-MOORE ",
        "ADDR:1065 BETHANIA-RURAL HALL RD",
        "CITY:RURAL HALL",
        "PLACE:KANGAROO EXPRESS",
        "CALL:Building Fire",
        "PRI:1",
        "UNIT:F23",
        "X:NORVASA ST/BETHANIA RURAL HALL RD NB 52 RA",
        "NAME:860-MOORE");

    doTest("T25",
        "Location: 6601 YADKINVILLE RD LE: @VIENNA VILLAGE Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F21 X Str: PINE TRAILS RD/JUST A MERE LN CALLER NAME: UNITED CENTRAL ",
        "ADDR:6601 YADKINVILLE RD",
        "CITY:LEWISVILLE",
        "PLACE:VIENNA VILLAGE",
        "CALL:Alarms - Fire or Smoke",
        "PRI:1",
        "UNIT:F21",
        "X:PINE TRAILS RD/JUST A MERE LN",
        "NAME:UNITED CENTRAL");

    doTest("T26",
        "Location: 5855 WOODSWAY DR TO Nature: Diabetic P:1  - DLOC DISTRICT: F27 X Str: MEADOW LN/MEADOW LN CALLER NAME: PARKER, DAVID L ",
        "ADDR:5855 WOODSWAY DR",
        "CITY:TOBACCOVILLE",
        "CALL:Diabetic",
        "PRI:1",
        "UNIT:F27",
        "X:MEADOW LN/MEADOW LN",
        "NAME:PARKER, DAVID L");

    doTest("T27",
        "Location: 3311 WIDE COUNTRY RD TO Nature: Chest Pain/Heart Problems P:1  - BREATHING_DIFF DISTRICT: F27 X Str: GLADEWATER DR/GLARESTONE DR CALLER NAME: PARLIER, DEWEY G ",
        "ADDR:3311 WIDE COUNTRY RD",
        "CITY:TOBACCOVILLE",
        "CALL:Chest Pain/Heart Problems",
        "PRI:1",
        "UNIT:F27",
        "X:GLADEWATER DR/GLARESTONE DR",
        "NAME:PARLIER, DEWEY G");

    doTest("T28",
        "Location: 5143 WHITMAN RD FC Nature: Falls P:1  - CRUSHING DISTRICT: F27 X Str: COON CREEK RD/SEVEN HILLS RD CALLER NAME: WHITLEY, JOHN ",
        "ADDR:5143 WHITMAN RD",
        "CALL:Falls",
        "PRI:1",
        "UNIT:F27",
        "X:COON CREEK RD/SEVEN HILLS RD",
        "NAME:WHITLEY, JOHN");

    doTest("T29",
        "Location: 7276 REYNOLDA RD FC Nature: House Fire P:1  - default DISTRICT: F27 X Str: SHADY RIDGE LN/MONTFORD RD CALLER NAME:  ",
        "ADDR:7276 REYNOLDA RD",
        "CALL:House Fire",
        "PRI:1",
        "UNIT:F27",
        "X:SHADY RIDGE LN/MONTFORD RD");

    doTest("T30",
        "Location: 7424 RIDGE RD FC Nature: Illegal burning P:2  - default DISTRICT: F27 X Str: BOILING SPRINGS RD/GREEN PARK RD CALLER NAME: JOSEPH BOWMAN ",
        "ADDR:7424 RIDGE RD",
        "CALL:Illegal burning",
        "PRI:2",
        "UNIT:F27",
        "X:BOILING SPRINGS RD/GREEN PARK RD",
        "NAME:JOSEPH BOWMAN");

    doTest("T31",
        "Location: 1 STOKES COUNTY: @STOKES COUNTY: 614 S MAIN,DOMINOS Nature: Building Fire P:1  - default DISTRICT: F09 X Str: / CALLER NAME:  ",
        "ADDR:614 S MAIN",
        "APT:DOMINOS",
        "CITY:STOKES COUNTY",
        "CALL:Building Fire",
        "PRI:1",
        "UNIT:F09");

    doTest("T32",
        "Nature: Public Service (Fire) P:2  - default DISTRICT: F27 X Str: TOBACCOVILLE RD/RIDGE RD CALLER NAME: JAMES LAWSON ",
        "CALL:Public Service (Fire)",
        "PRI:2",
        "UNIT:F27",
        "NAME:JAMES LAWSON",
        "ADDR:TOBACCOVILLE RD & RIDGE RD");

    doTest("T33",
        "Location: 7424 OLIN RD FC Nature: Unconscious/Unresponsive/Syncope P:1  - UNCONSCIOUS DISTRICT: F27 X Str: PENROSE RD/BOLIN RD CALLER NAME: FIELDS, CINDY ",
        "ADDR:7424 OLIN RD",
        "CALL:Unconscious/Unresponsive/Syncope",
        "PRI:1",
        "UNIT:F27",
        "X:PENROSE RD/BOLIN RD",
        "NAME:FIELDS, CINDY");

    doTest("T34",
        "Location: 4618 TOBACCOVILLE RD TO Nature: Motor Vehicle Accident P:1  - default DISTRICT: F27 X Str: ROCKWELL PLACE DR/RIDGE RD CALLER NAME:  ",
        "ADDR:4618 TOBACCOVILLE RD",
        "CITY:TOBACCOVILLE",
        "CALL:Motor Vehicle Accident",
        "PRI:1",
        "UNIT:F27",
        "X:ROCKWELL PLACE DR/RIDGE RD");

    doTest("T35",
        "Location: 3000 BIG OAKS DR KI: @CRES TOBACCO Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F30 X Str: DORAL DR/ CALLER NAME:  ",
        "ADDR:3000 BIG OAKS DR",
        "CITY:KING",
        "PLACE:CRES TOBACCO",
        "CALL:Alarms - Fire or Smoke",
        "PRI:1",
        "UNIT:F30",
        "X:DORAL DR");

    doTest("T36",
        "Location: 6497 DORAL DR TO Nature: Falls P:1  - DLOC DISTRICT: F27 X Str: MIZPAH CHURCH RD/GRIFFIN RD CALLER NAME:  ",
        "ADDR:6497 DORAL DR",
        "CITY:TOBACCOVILLE",
        "CALL:Falls",
        "PRI:1",
        "UNIT:F27",
        "X:MIZPAH CHURCH RD/GRIFFIN RD");

    doTest("T37",
        "Nature: Brush Fire P:1  - default DISTRICT: F27 X Str: WESTERLY DR/NORTHEAST DR CALLER NAME: CRYSTAL ",
        "CALL:Brush Fire",
        "PRI:1",
        "UNIT:F27",
        "NAME:CRYSTAL",
        "ADDR:WESTERLY DR & NORTHEAST DR");

    doTest("T38",
        "Location: 6825 ROLLING VIEW DR FC: @RIVERWOOD RIDING CENTER Nature: Seizures P:1  - UNKNOWN_HX DISTRICT: F27 X Str: PHILCOAT DR/LITTLEFIELD RD CALLER NAME:  ",
        "ADDR:6825 ROLLING VIEW DR",
        "PLACE:RIVERWOOD RIDING CENTER",
        "CALL:Seizures",
        "PRI:1",
        "UNIT:F27",
        "X:PHILCOAT DR/LITTLEFIELD RD");

    doTest("T39",
        "Location: 350 FORUM PKWY RH: @ALLIANCE DISPLAY Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F23 X Str: /NORTHSTAR DR CALLER NAME: TYCO ",
        "ADDR:350 FORUM PKWY",
        "CITY:RURAL HALL",
        "PLACE:ALLIANCE DISPLAY",
        "CALL:Alarms - Fire or Smoke",
        "PRI:1",
        "UNIT:F23",
        "X:/NORTHSTAR DR",
        "NAME:TYCO");

    doTest("T40",
        "Location: 4730 SEWARD RD FC Nature: Falls P:1  - DLOC DISTRICT: F27 X Str: PARAMOUNT RD/SILVER SPRINGS RD CALLER NAME: STOUT, JUNE ",
        "ADDR:4730 SEWARD RD",
        "CALL:Falls",
        "PRI:1",
        "UNIT:F27",
        "X:PARAMOUNT RD/SILVER SPRINGS RD",
        "NAME:STOUT, JUNE");

    doTest("T41",
        "Location: 3409 WIDE COUNTRY RD TO Nature: Overdose/Poisoning P:1  - RX_MEDS DISTRICT: F27 X Str: BLAZINGWOOD DR/EDGEWORTH TR CALLER NAME: ALAN ",
        "ADDR:3409 WIDE COUNTRY RD",
        "CITY:TOBACCOVILLE",
        "CALL:Overdose/Poisoning",
        "PRI:1",
        "UNIT:F27",
        "X:BLAZINGWOOD DR/EDGEWORTH TR",
        "NAME:ALAN");

    doTest("T42",
        "Location: 5135 RIVER BLUFF FARMS RD FC Nature: Bleeding (Non-Traumatic) P:1  - UNCONTROLLED DISTRICT: F27 X Str: /TUTELO FORREST TR CALLER NAME: HICKS, B C ",
        "ADDR:5135 RIVER BLUFF FARMS RD",
        "CALL:Bleeding (Non-Traumatic)",
        "PRI:1",
        "UNIT:F27",
        "X:/TUTELO FORREST TR",
        "NAME:HICKS, B C");

    doTest("T43",
        "Location: 9429 REYNOLDA RD FC Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: F27 X Str: WALLER RD/RIDGE RD CALLER NAME: DWAYNE ",
        "ADDR:9429 REYNOLDA RD",
        "CALL:Breathing Difficulty",
        "PRI:1",
        "UNIT:F27",
        "X:WALLER RD/RIDGE RD",
        "NAME:DWAYNE");

    doTest("T44",
        "Location: 350 FORUM PKWY RH: @ALLIANCE DISPLAY Nature: Alarms - Fire or Smoke P:1  - default DISTRICT:  X Str: /NORTHSTAR DR CALLER NAME: TYCO SECURITY ",
        "ADDR:350 FORUM PKWY",
        "CITY:RURAL HALL",
        "PLACE:ALLIANCE DISPLAY",
        "CALL:Alarms - Fire or Smoke",
        "PRI:1",
        "X:/NORTHSTAR DR",
        "NAME:TYCO SECURITY");

    doTest("T45",
        "Location: 5102 VOGLER RD FC Nature: Breathing Difficulty P:1  - OVER_50_DIFF DISTRICT: F27 X Str: /JOYCE NORMAN RD CALLER NAME: PARKS, VAUGHN L ",
        "ADDR:5102 VOGLER RD",
        "CALL:Breathing Difficulty",
        "PRI:1",
        "UNIT:F27",
        "X:/JOYCE NORMAN RD",
        "NAME:PARKS, VAUGHN L");

    doTest("T46",
        "Location: 1 STOKES COUNTY: @STOKES COUNTY: @102 KELLYSTONE DR Nature: Multi-Family Dwelling Fire P:1  - default DISTRICT: F09 X Str: / CALLER NAME:  ",
        "ADDR:1 STOKES COUNTY",
        "PLACE:STOKES COUNTY @102 KELLYSTONE DR",
        "CALL:Multi-Family Dwelling Fire",
        "PRI:1",
        "UNIT:F09");

    doTest("T47",
        "Location: 2224 VIENNA-DOZIER RD LE Nature: House Fire P:1  - default DISTRICT: F21 X Str: STANDING OAK LN/RIVER RIDGE RD CALLER NAME: CARVANA, MARTINO ",
        "ADDR:2224 VIENNA-DOZIER RD",
        "CITY:LEWISVILLE",
        "CALL:House Fire",
        "PRI:1",
        "UNIT:F21",
        "X:STANDING OAK LN/RIVER RIDGE RD",
        "NAME:CARVANA, MARTINO");

    doTest("T48",
        "Location: 5715 RIVER BLUFF FARMS RD FC Nature: Unconscious/Unresponsive/Syncope P:1  - default DISTRICT: F27 X Str: TUTELO FORREST TR/DAN LONGMAN RD CALLER NAME: RANDI ",
        "ADDR:5715 RIVER BLUFF FARMS RD",
        "CALL:Unconscious/Unresponsive/Syncope",
        "PRI:1",
        "UNIT:F27",
        "X:TUTELO FORREST TR/DAN LONGMAN RD",
        "NAME:RANDI");

    doTest("T49",
        "Location: 6140 DORAL DR TO:LOT 12 Nature: Mental/Emotional/Psychological P:1  - UNCONTROL_BLEED DISTRICT: F27 X Str: KAPP RD/WIDE COUNTRY RD CALLER NAME:  ",
        "ADDR:6140 DORAL DR",
        "CITY:TOBACCOVILLE",
        "APT:LOT 12",
        "CALL:Mental/Emotional/Psychological",
        "PRI:1",
        "UNIT:F27",
        "X:KAPP RD/WIDE COUNTRY RD");

    doTest("T50",
        "Location: 4057 ELIZABETH PARK DR FC Nature: Breathing Difficulty P:1  - OVER_50_DIFF DISTRICT: F27 X Str: /MATTHEW FOREST LN CALLER NAME: BANNER, VANESSA ",
        "ADDR:4057 ELIZABETH PARK DR",
        "CALL:Breathing Difficulty",
        "PRI:1",
        "UNIT:F27",
        "X:/MATTHEW FOREST LN",
        "NAME:BANNER, VANESSA");

    doTest("T51",
        "Location: 6585 DORAL DR TO Nature: Unconscious/Unresponsive/Syncope P:1  - FAINT DISTRICT: F27 X Str: GRIFFIN RD/KREEGER FARM RD CALLER NAME: BOYD, MURRY L ",
        "ADDR:6585 DORAL DR",
        "CITY:TOBACCOVILLE",
        "CALL:Unconscious/Unresponsive/Syncope",
        "PRI:1",
        "UNIT:F27",
        "X:GRIFFIN RD/KREEGER FARM RD",
        "NAME:BOYD, MURRY L");

    doTest("T52",
        "Location: 5143 WHITMAN RD FC Nature: Chest Pain/Heart Problems P:1  - HX DISTRICT: F27 X Str: COON CREEK RD/SEVEN HILLS RD CALLER NAME: WHITLEY, JOHN ",
        "ADDR:5143 WHITMAN RD",
        "CALL:Chest Pain/Heart Problems",
        "PRI:1",
        "UNIT:F27",
        "X:COON CREEK RD/SEVEN HILLS RD",
        "NAME:WHITLEY, JOHN");

    doTest("T53",
        "Location: 2880 BIG OAKS DR KI Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F30 X Str: DORAL DR/ CALLER NAME:  ",
        "ADDR:2880 BIG OAKS DR",
        "CITY:KING",
        "CALL:Alarms - Fire or Smoke",
        "PRI:1",
        "UNIT:F30",
        "X:DORAL DR");

    doTest("T54",
        "Location: 7765 RIDGE RD TO Nature: Sick/Unknown P:1  - MEDIC_ALARM DISTRICT: F27 X Str: GREEN PARK RD/ALANDALE CIR CALLER NAME: ADT ",
        "ADDR:7765 RIDGE RD",
        "CITY:TOBACCOVILLE",
        "CALL:Sick/Unknown",
        "PRI:1",
        "UNIT:F27",
        "X:GREEN PARK RD/ALANDALE CIR",
        "NAME:ADT");

    doTest("T55",
        "Location: 5315 SHADY RIDGE LN FC Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F27 X Str: REYNOLDA RD/ CALLER NAME: ADT ",
        "ADDR:5315 SHADY RIDGE LN",
        "CALL:Alarms - Fire or Smoke",
        "PRI:1",
        "UNIT:F27",
        "X:REYNOLDA RD",
        "NAME:ADT");

    doTest("T56",
        "Location: 7475 OLIN RD FC Nature: BURNS: Thermal/Electrical.Chemical P:1  - OVER_20_PER DISTRICT: F27 X Str: PENROSE RD/BOLIN RD CALLER NAME: BAKER, TRINA ",
        "ADDR:7475 OLIN RD",
        "CALL:BURNS: Thermal/Electrical.Chemical",
        "PRI:1",
        "UNIT:F27",
        "X:PENROSE RD/BOLIN RD",
        "NAME:BAKER, TRINA");

    doTest("T57",
        "Location: 5798 DAVIS RD FC Nature: Brush Fire P:1  - default DISTRICT: F18 X Str: DYLANWOOD DR/ CALLER NAME: VALARIA ",
        "ADDR:5798 DAVIS RD",
        "CALL:Brush Fire",
        "PRI:1",
        "UNIT:F18",
        "X:DYLANWOOD DR",
        "NAME:VALARIA");

    doTest("T58",
        "Location: 2227 STANDING OAK LN LE Nature: Building Fire P:1  - default DISTRICT: F21 X Str: VIENNA-DOZIER RD/ CALLER NAME:  ",
        "ADDR:2227 STANDING OAK LN",
        "CITY:LEWISVILLE",
        "CALL:Building Fire",
        "PRI:1",
        "UNIT:F21",
        "X:VIENNA-DOZIER RD");

    doTest("T59",
        "Location: 4291 VIENNA-DOZIER RD FC Nature: Chest Pain/Heart Problems P:1  - WITH_SYMPTOMS DISTRICT: F27 X Str: WISHING WELL RD/FRIES CREEK RD CALLER NAME: TUTTLE, JOHN/CASEY ",
        "ADDR:4291 VIENNA-DOZIER RD",
        "CALL:Chest Pain/Heart Problems",
        "PRI:1",
        "UNIT:F27",
        "X:WISHING WELL RD/FRIES CREEK RD",
        "NAME:TUTTLE, JOHN/CASEY");

    doTest("T60",
        "Location: 5530 MAIN ST BE: @ANTIQUES IN BETHANIA Nature: Assault/Gunshot/Stabbing P:1  - NECK_INJURY DISTRICT: F27 X Str: BETHANIA RD/JAN HUS LN CALLER NAME:  ",
        "ADDR:5530 MAIN ST",
        "CITY:BETHANIA",
        "PLACE:ANTIQUES IN BETHANIA",
        "CALL:Assault/Gunshot/Stabbing",
        "PRI:1",
        "UNIT:F27",
        "X:BETHANIA RD/JAN HUS LN");

    doTest("T61",
        "Location: 4735 WARNER RD FC Nature: House Fire P:1  - default DISTRICT: F27 X Str: ARCHDALE RD/WALDRAVEN RD CALLER NAME:  ",
        "ADDR:4735 WARNER RD",
        "CALL:House Fire",
        "PRI:1",
        "UNIT:F27",
        "X:ARCHDALE RD/WALDRAVEN RD");

    doTest("T62",
        "Location: 5135 RIVER BLUFF FARMS RD FC Nature: Public Service (Rescue) P:2  - default DISTRICT: F27 X Str: /TUTELO FORREST TR CALLER NAME: LIFELINE ",
        "ADDR:5135 RIVER BLUFF FARMS RD",
        "CALL:Public Service (Rescue)",
        "PRI:2",
        "UNIT:F27",
        "X:/TUTELO FORREST TR",
        "NAME:LIFELINE");

    doTest("T63",
        "Location: 4484 COTSWOLD RD FC Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: F27 X Str: COTSWOLD CT/SHERBORNE DR CALLER NAME: BARKER, BETTY ",
        "ADDR:4484 COTSWOLD RD",
        "CALL:Breathing Difficulty",
        "PRI:1",
        "UNIT:F27",
        "X:COTSWOLD CT/SHERBORNE DR",
        "NAME:BARKER, BETTY");

    doTest("T64",
        "Location: RIDGE RD FC Nature: Brush Fire P:1  - default DISTRICT: F27 X Str: CHIGWELL TR/WALL RD CALLER NAME: 127 ",
        "ADDR:RIDGE RD",
        "MADDR:RIDGE RD & CHIGWELL TR",
        "CALL:Brush Fire",
        "PRI:1",
        "UNIT:F27",
        "X:CHIGWELL TR/WALL RD",
        "NAME:127");

    doTest("T65",
        "Location: 3474 BOWENS RD TO Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: F27 X Str: HUNTING HOUNDS RUN/SETTLE WOOD LN CALLER NAME: RACHEL ",
        "ADDR:3474 BOWENS RD",
        "CITY:TOBACCOVILLE",
        "CALL:Breathing Difficulty",
        "PRI:1",
        "UNIT:F27",
        "X:HUNTING HOUNDS RUN/SETTLE WOOD LN",
        "NAME:RACHEL");

    doTest("T66",
        "Location: 6006 ELKVUE DR FC Nature: Sick/Unknown P:1  - DIAPHORESIS DISTRICT: F27 X Str: REYNOLDA RD/INDIAN CAMP DR CALLER NAME: SUTYAK, DEBORAH A ",
        "ADDR:6006 ELKVUE DR",
        "CALL:Sick/Unknown",
        "PRI:1",
        "UNIT:F27",
        "X:REYNOLDA RD/INDIAN CAMP DR",
        "NAME:SUTYAK, DEBORAH A");

    doTest("T67",
        "Location: 9130 REYNOLDA RD FC Nature: Motor Vehicle Accident P:1  - default DISTRICT: F27 X Str: ELKVUE DR/WALLER RD CALLER NAME: BOST, RODNEY ",
        "ADDR:9130 REYNOLDA RD",
        "CALL:Motor Vehicle Accident",
        "PRI:1",
        "UNIT:F27",
        "X:ELKVUE DR/WALLER RD",
        "NAME:BOST, RODNEY");

    doTest("T68",
        "Location: 8030 REYNOLDA RD FC Nature: Chest Pain/Heart Problems P:1  - HX DISTRICT: F27 X Str: TURNER RD/JOYCE NORMAN RD CALLER NAME: VERIZON WIRELESS ",
        "ADDR:8030 REYNOLDA RD",
        "CALL:Chest Pain/Heart Problems",
        "PRI:1",
        "UNIT:F27",
        "X:TURNER RD/JOYCE NORMAN RD");

    doTest("T69",
        "Location: 7696 DONNAHA RD FC Nature: Stroke (CVA) P:1  - HEADACHE DISTRICT: F27 X Str: MARTIN FERRY RD/FISHER RD CALLER NAME:  ",
        "ADDR:7696 DONNAHA RD",
        "CALL:Stroke (CVA)",
        "PRI:1",
        "UNIT:F27",
        "X:MARTIN FERRY RD/FISHER RD");

    doTest("T70",
        "Location: 6445 REYNOLDA RD FC Nature: Mental/Emotional/Psychological P:1  - default DISTRICT: F27 X Str: BETHANIA RD/ROBERTS RD CALLER NAME:  ",
        "ADDR:6445 REYNOLDA RD",
        "CALL:Mental/Emotional/Psychological",
        "PRI:1",
        "UNIT:F27",
        "X:BETHANIA RD/ROBERTS RD");

  }
  
  public static void main(String[] args) {
    new NCForsythCountyParserTest().generateTests("T1");
  }
}

