package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Los Angeles County, CA
Contact: Active911
Agency name: Verdugo Fire Communications 
Location: Glendale, CA 
Sender: <Verdugo@VerdugoFire.com>

Verdugo:07/17/12 10:27:21/1/BREATH/552 MANZANITA AV ,SMD/btwn PARK AV & S SUNNYSIDE AV//R1/566_3J /VFC1240411 /EMS INFO: Male Age 73 Conscious Diff Breath UNABLE TO STAND
Verdugo:07/17/12 10:35:18/1/TR2 /169 N HALSTEAD ST ,PAS/btwn DEAD-END & E FOOTHILL BL//R1/566_4G /VFC1240412 /EMS INFO: Male Age 5 FX RIGHT ARM
Verdugo:07/17/12 10:41:24/1/FUEL /EB 134 FWY AT 5 FWY ,LFD//DODGE NEON WITH A FUEL LEAK FSP OS/R2/
Verdugo:07/17/12 11:00:54/1/BACK /616 W LEXINGTON DR ,GLN/btwn N KENILWORTH AV & BRENT PL//R1/564_4D /VFC1240417 /EMS INFO: Female Age 85 Conscious
Verdugo:07/17/12 11:02:34/1/MED /1123 E DORAN ST ,GLN/btwn N ADAMS ST & NARANJA DR//R1/564_4G /VFC1240418 /EMS INFO: Male Age 39 Conscious SHAKING
Verdugo:07/17/12 11:11:57/1/SEIZ /439 W MAPLE ST #B ,GLN/btwn S COLUMBUS AV & S PACIFIC AV/BACK UNIT/R1/564_6D /VFC1240420 /EMS INFO: Female Age 54 Unconscious Diff Breath
Verdugo:07/17/12 11:13:22/1/STROKE/330 N BRAND BL ,GLN/btwn W CALIFORNIA AV & W LEXINGTON DR/SUITE 230 AT DMA CLAIMS/R1/564 E4 /VFC1240421 /EMS INFO: Female Age 63 Conscious RIGHT ARM NUMB--UNABLE TO SIT UP
Verdugo:07/17/12 11:15:06/1/HEART /990 S EL MOLINO AV ,PAS/btwn ALPINE ST & E GLENARM ST//R1/566_7A /VFC1240422 /EMS INFO: Male Age 70S Conscious Diff Breath PACEMAKER// ALOC
Verdugo:07/17/12 11:17:04/1/DOWN /N LOS ROBLES AV/E ORANGE GROVE BL ,PAS/ /AT BUS STOP ON WEST SIDE OF LOS ROBLES/R1/565_3J /VFC1240423 /EMS INFO: Male Age ELDR HANGING ON THE BUS BENCH
Verdugo:07/17/12 11:18:55/1/ALARM /290 N MADISON AV ,PAS/btwn E WALNUT ST & E CORSON ST/FUJIOKA/R1/565_4J /VFC1240424 /ZONE 4--GENERAL FIRE--NO RESET--
Verdugo:07/17/12 11:56:32/1/SICK /1860 LUNDY AV ,PAS/btwn FLOWER ST & E MONTANA ST//R1/535_7J /VFC1240426 /EMS INFO: Male Age 23 NOT FEELING WELL
Verdugo:07/17/12 12:16:08/1/TC /N BRAND BL/VENTURA FWY ,GLN/ //R1/564_3E /VFC1240429 /EMS INFO: Female PERSON DIZZY// PD ER SHORTLY
Verdugo:07/17/12 12:25:35/1/BP /740 E WASHINGTON BL ,PAS/btwn PALM TER & RUTAN WAY//R1/566 A1 /VFC1240430 /EMS INFO: Male Age 71 Conscious LEFT FINGERS NUMBER// RN OS
Verdugo:07/17/12 12:31:33/1/ALARM /160 N LAKE AV ,PAS/btwn E UNION ST & E WALNUT ST//R1/566 A4 /VFC1240432 /SMK DET IN DOWNSTAIRS RESTROOM // NO RESET
Verdugo:07/17/12 12:44:23/1/BP /1077 NEWBY ST #1 ,GLN/btwn SAN FERNANDO RD & W GLENOAKS BL//R1/564_2B /VFC1240433 /EMS INFO: Female Age 77 Conscious Diff Breath FEELS WEAK--HIGH BP
Verdugo:07/17/12 12:44:41/1/RESET /3521 COUNTRY CLUB DR ,GLN/btwn OAKMONT VIEW DR & DEAD-END/RESI: STEPANYAN/R1/534_4G /VFC1240434 /ZONE 42 FIRST FL SMK DET // ALARM HAS RESET
Verdugo:07/17/12 13:48:22/1/HAZARD/205 E LOS FELIZ RD ,GLN/btwn S BRAND BL & S GLENDALE AV//R1/564 E7 /VFC1240442 /OUTLET TO THE BUILDING DOES WORK/// SCARED IT WILL CAUSE A FIRE// RP WILL MEET OUT FRONT
Verdugo:07/17/12 14:03:08/1/ALOC /1132 E CALIFORNIA AV #6 ,GLN/btwn N ADAMS ST & MC HENRY RD//R1/564_4G /VFC1240445 /EMS INFO: Female Age 60 Conscious
Verdugo:07/17/12 14:05:54/1/BACK /2716 E COLORADO BL ,PAS/btwn N SAN GABRIEL BL & S DAISY AV//R1/566_4F /VFC1240446 /EMS INFO: Female Age 50 Conscious
Verdugo:07/17/12 14:47:36/1/FALL2 /1727 E WASHINGTON BL ,PAS/btwn SINALOA AV & DOMINION AV/YOGURT SHOP/R1/566_1C /VFC1240453 /EMS INFO: Female Age 75 Conscious
Verdugo:07/17/12 14:55:29/1/UNKMED/50 N CRAIG AV #4 ,PAS/btwn E COLORADO BL & GLADYS ST//R1/566_4D /VFC1240454 /EMS INFO: Female Age 88 Conscious
Verdugo:07/17/12 14:56:51/1/SEIZ /818 N OAKLAND AV #1 ,PAS/btwn BUCKEYE ST & E MOUNTAIN ST//R1/565_2J /VFC1240455 /EMS INFO: Male Age 17
Verdugo:07/17/12 15:02:08/1/HANG /607 ASHTABULA ST ,PAS/btwn N MADISON AV & HINES AL//R2/565_3J /VFC1240456 /NO FURTHER INFORMATION
Verdugo:07/17/12 15:02:44/1/FALL2 /123 S ISABEL ST #505 ,GLN/btwn E BROADWAY & E HARVARD ST//R1/564 F5 /VFC1240457 /EMS INFO: Female Age 85 Conscious SLIPPED OFF TOILET
Verdugo:07/17/12 15:12:06/1/TC /W CHEVY CHASE DR/S COLUMBUS AV ,GLN/ //R1/564_6D /VFC1240460 /TC - 1 PT DIZZY - PD OS
Verdugo:07/17/12 15:29:43/1/TR1 /E COLORADO BL/N HUDSON AV ,PAS/ /N/O COLORADO/R1/566_4A /VFC1240463 /EMS INFO: Female Age 20S PD OS// HEAD INJ FROM A TRAFFIC COLLISION
Verdugo:07/17/12 15:30:09/1/TC /S BRAND BL/E CHEVY CHASE DR ,GLN/ //R1/564_6E /VFC1240464 /PD ADV
Verdugo:07/17/12 15:31:30/1/ALOC /675 S ARROYO PKWY ,PAS/btwn PICO ST & FILLMORE ST/3RD FLOOR/R1/565_6H /VFC1240465 /EMS INFO: Male Age 62 Conscious LOW BLOOD PRESSURE - ALOC - DR OS
Verdugo:07/17/12 15:37:23/1/STROKE/190 ARROYO TER #301 ,PAS/btwn LIVE OAKS AV & N GRAND AV//R1/565_4F /VFC1240467 /EMS INFO: Male Age 64 Conscious SLURRED SPEACH
Verdugo:07/17/12 15:43:36/1/ALOC /2900 E DEL MAR BL #232 ,PAS/btwn S SUNNYSLOPE AV & EL NIDO AV//R1/566 F5 /VFC1240468 /EMS INFO: Male Age 38 Conscious DR OS

Contact: Active911
Agency name: Emergency Radio System - ERS
Location: Pasadena, CA, United States
Sender: Verdugo@VerdugoFire.com

(VFCC Alert) Verdugo:14:02/2/HOUSE /520 S GARFIELD AV ,MPK/btwn E NEWMARK AV & S RAMONA AV//R3/636_1B /VFC1337311 /2 STORY HOUSE
(VFCC Alert) Verdugo:07:21/1/HOUSE /520 N GARFIELD AV ,MPK/btwn HILLIARD AV & W HAMPTON AV//R3/636_1B /VFC1337311 /2 STORY HOUSE
(VFCC Alert) Verdugo:40:26/1/VEG /1003 ROSE BOWL DR ,PAS/btwn ROSEMONT AV & N ARROYO BL/SOUTH OF LOT F AT ROSE BOWL DR/SECO/R2/565 3F /VFC1337306 /NO FURTHER INFORMATION
(VFCC Alert) Verdugo:32:29/1/HOUSE /2292 WHITE ST ,PAS/btwn LOLA AV & MARTELO AV/HOUSE NEXT DOOR/R2/566_4D /VFC1337278 /FIRE ALARM ACTIVATED - SMOKE FROM 2ND STY WINDOW - NO ANSWER FRONT DOOR
(VFCC Alert) Verdugo:14:53/1/RESCUE/655 N FAIR OAKS AV ,PAS/btwn E PEORIA ST & E ORANGE GROVE BL/ENTRANCE OF STORE/R2/565 H3 /VFC1337276 /EMS INFO: Male Age 4 Conscious HEAD STUCK IN TURNSTYLE AT STORE
(VFCC Alert) Verdugo:21:06/1/STR /437 E PALM AV ,BRK/btwn N GLENOAKS BL & N FIFTH ST/IN GARAGE UNDERGROUND PARKING/R2/533_6H /VFC1337258 /SUBTERANNEAN GARAGE BLOW APTS
(VFCC Alert) Verdugo:44:00/1/TCRES /W COLORADO ST/S PACIFIC AV ,GLN/ //R1/564_5D /VFC1337252 /NO FURTHER INFORMATION
(VFCC Alert) Verdugo:32:52/1/JUMPER/855 W EL REPETTO DR #13C ,MPK/btwn S ATLANTIC BL & SUNRISE DR/STAGE FOR PD/R3/635_4J /VFC1337250 /EMS INFO: Female Age TEEN PD NOT SURE IF SHE IS TRYING TO POSS JUMP OR ESCAPE..
(VFCC Alert) Verdugo:39:23/1/TCRES /718 S LOS ROBLES AV ,PAS/btwn MILES ST & FILLMORE ST//R1/565_6J /VFC1337242 /PD ER
(VFCC Alert) Verdugo:27:39/1/HOUSE /1826 S MAYFLOWER AV ,MRV/btwn W DUARTE RD & EL NORTE AV//R2/567 6F /VFC1337241 /NO FURTHER INFORMATION
(VFCC Alert) Verdugo:13:17/1/TCRES /1644 ROYAL BL ,GLN/btwn IMPERIAL DR & OLD PHILLIPS RD//R3/564_1G /VFC1337205 /OVERTURNED VEH - PD ER
(VFCC Alert) Verdugo:53:54/1/TCRES /MADELINE DR/S ORANGE GROVE BL ,PAS/ //R2/565_7G /VFC1337171 /ONE VEH ROLLOVER - PD ER SHORTLY
(VFCC Alert) Verdugo:44:30/1/UNKF /2016 ISABELLA AV ,MPK/btwn W ELMGATE ST & FERNBANK AV//R2/636_5B /VFC1337160 /ODOR OF SOMETHING BURNING IN AREA
(VFCC Alert) Verdugo:24:21/1/HOUSE /2917 GLENAVEN AV ,ALH/btwn ORANGE GROVE AV & PARK VIEW DR//R2/635_1G /VFC1337133 /SMOKE COMING FROM PORCH
(VFCC Alert) Verdugo:58:03/1/STR /3843 E FIRST ST #75 ,LAC/btwn N HERBERT AV & S HERBERT AV//B3/635_6E /VFC1337118 /REQ E63 W/COE3 BLUE 3 TAC V10D
(VFCC Alert) Verdugo:18:49/1/MTNRES/000 CHANTRY FLATS RD ,LAC//AT HERMIT FALLS/R3/537 4D /VFC1337101 /ANKLE INJ REQ E41 W/COE44 SQ32..BLUE 6 V9 DIRECT
(VFCC Alert) Verdugo:46:51/1/APT /3832 WHITESIDE ST #2 ,LAC/btwn N HERBERT AV & N BONNIE BEACH PL//B3/635_3E /VFC1337089 /REQ E63 W/CO1 BLUE3 V10 DIRECT
(VFCC Alert) Verdugo:07:07/1/RESFWY/WB 210 FWY AT SANTA ANITA AV ,ARC///R2/
(VFCC Alert) Verdugo:40:17/1/TCRES /501 S MONTEBELLO BL ,MTB/btwn W WALNUT AV & MINES AV//R1/676_3D /VFC1336988 /---PERSON TRAPPED--- PD ER
(VFCC Alert) Verdugo:05:41/1/GARAGE/1925 HILTON DR ,BRK/btwn CAMBRIDGE DR & ETON DR//R2/533_4G /VFC1336971 /---APPROX LOCATION FROM LAT/LONG OF CALLER...ADV FIRE...NFD

 */

public class CALosAngelesCountyParserTest extends BaseParserTest {
  
  public CALosAngelesCountyParserTest() {
    setParser(new CALosAngelesCountyParser(), "LOS ANGELES COUNTY", "CA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Verdugo:07/17/12 10:27:21/1/BREATH/552 MANZANITA AV ,SMD/btwn PARK AV & S SUNNYSIDE AV//R1/566_3J /VFC1240411 /EMS INFO: Male Age 73 Conscious Diff Breath UNABLE TO STAND",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:10:27:21",
        "PRI:3",
        "CALL:Shortness of Breath",
        "ADDR:552 MANZANITA AV",
        "MADDR:552 MANZANITA AVE",
        "CITY:SIERRA MADRE",
        "X:PARK AV & S SUNNYSIDE AV",
        "INFO:Male Age 73 Conscious Diff Breath UNABLE TO STAND",
        "CH:R1",
        "MAP:566_3J",
        "ID:VFC1240411");

    doTest("T2",
        "Verdugo:07/17/12 10:35:18/1/TR2 /169 N HALSTEAD ST ,PAS/btwn DEAD-END & E FOOTHILL BL//R1/566_4G /VFC1240412 /EMS INFO: Male Age 5 FX RIGHT ARM",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:10:35:18",
        "PRI:5",
        "CALL:Minor Trauma",
        "ADDR:169 N HALSTEAD ST",
        "CITY:PASADENA",
        "X:DEAD-END & E FOOTHILL BL",
        "INFO:Male Age 5 FX RIGHT ARM",
        "CH:R1",
        "MAP:566_4G",
        "ID:VFC1240412");

    doTest("T3",
        "Verdugo:07/17/12 10:41:24/1/FUEL /EB 134 FWY AT 5 FWY ,LFD//DODGE NEON WITH A FUEL LEAK FSP OS/R2/",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:10:41:24",
        "PRI:7",
        "CALL:Fuel Spill",
        "ADDR:EB 134 FWY AT 5 FWY",
        "MADDR:RT 134 AT RT 5",
        "CITY:LOS ANGELES CITY",
        "INFO:DODGE NEON WITH A FUEL LEAK FSP OS",
        "CH:R2");

    doTest("T4",
        "Verdugo:07/17/12 11:00:54/1/BACK /616 W LEXINGTON DR ,GLN/btwn N KENILWORTH AV & BRENT PL//R1/564_4D /VFC1240417 /EMS INFO: Female Age 85 Conscious",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:11:00:54",
        "PRI:5",
        "CALL:Back Pain",
        "ADDR:616 W LEXINGTON DR",
        "CITY:GLENDALE",
        "X:N KENILWORTH AV & BRENT PL",
        "INFO:Female Age 85 Conscious",
        "CH:R1",
        "MAP:564_4D",
        "ID:VFC1240417");

    doTest("T5",
        "Verdugo:07/17/12 11:02:34/1/MED /1123 E DORAN ST ,GLN/btwn N ADAMS ST & NARANJA DR//R1/564_4G /VFC1240418 /EMS INFO: Male Age 39 Conscious SHAKING",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:11:02:34",
        "PRI:5",
        "CALL:Misc. Medical",
        "ADDR:1123 E DORAN ST",
        "CITY:GLENDALE",
        "X:N ADAMS ST & NARANJA DR",
        "INFO:Male Age 39 Conscious SHAKING",
        "CH:R1",
        "MAP:564_4G",
        "ID:VFC1240418");

    doTest("T6",
        "Verdugo:07/17/12 11:11:57/1/SEIZ /439 W MAPLE ST #B ,GLN/btwn S COLUMBUS AV & S PACIFIC AV/BACK UNIT/R1/564_6D /VFC1240420 /EMS INFO: Female Age 54 Unconscious Diff Breath",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:11:11:57",
        "PRI:3",
        "CALL:Person In Seizure",
        "ADDR:439 W MAPLE ST",
        "APT:B",
        "CITY:GLENDALE",
        "X:S COLUMBUS AV & S PACIFIC AV",
        "INFO:BACK UNIT / Female Age 54 Unconscious Diff Breath",
        "CH:R1",
        "MAP:564_6D",
        "ID:VFC1240420");

    doTest("T7",
        "Verdugo:07/17/12 11:13:22/1/STROKE/330 N BRAND BL ,GLN/btwn W CALIFORNIA AV & W LEXINGTON DR/SUITE 230 AT DMA CLAIMS/R1/564 E4 /VFC1240421 /EMS INFO: Female Age 63 Conscious RIGHT ARM NUMB--UNABLE TO SIT UP",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:11:13:22",
        "PRI:3",
        "CALL:CVA-Neurological",
        "ADDR:330 N BRAND BL",
        "CITY:GLENDALE",
        "X:W CALIFORNIA AV & W LEXINGTON DR",
        "INFO:SUITE 230 AT DMA CLAIMS / Female Age 63 Conscious RIGHT ARM NUMB--UNABLE TO SIT UP",
        "CH:R1",
        "MAP:564 E4",
        "ID:VFC1240421");

    doTest("T8",
        "Verdugo:07/17/12 11:15:06/1/HEART /990 S EL MOLINO AV ,PAS/btwn ALPINE ST & E GLENARM ST//R1/566_7A /VFC1240422 /EMS INFO: Male Age 70S Conscious Diff Breath PACEMAKER// ALOC",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:11:15:06",
        "PRI:3",
        "CALL:Heart Problem",
        "ADDR:990 S EL MOLINO AV",
        "MADDR:990 S EL MOLINO AVE",
        "CITY:PASADENA",
        "X:ALPINE ST & E GLENARM ST",
        "INFO:Male Age 70S Conscious Diff Breath PACEMAKER / ALOC",
        "CH:R1",
        "MAP:566_7A",
        "ID:VFC1240422");

    doTest("T9",
        "Verdugo:07/17/12 11:17:04/1/DOWN /N LOS ROBLES AV/E ORANGE GROVE BL ,PAS/ /AT BUS STOP ON WEST SIDE OF LOS ROBLES/R1/565_3J /VFC1240423 /EMS INFO: Male Age ELDR HANGING ON THE BUS BENCH",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:11:17:04",
        "PRI:3",
        "CALL:Person Down",
        "ADDR:N LOS ROBLES AV & E ORANGE GROVE BL",
        "MADDR:N LOS ROBLES AVE & E ORANGE GROVE BL",
        "CITY:PASADENA",
        "INFO:AT BUS STOP ON WEST SIDE OF LOS ROBLES / Male Age ELDR HANGING ON THE BUS BENCH",
        "CH:R1",
        "MAP:565_3J",
        "ID:VFC1240423");

    doTest("T10",
        "Verdugo:07/17/12 11:18:55/1/ALARM /290 N MADISON AV ,PAS/btwn E WALNUT ST & E CORSON ST/FUJIOKA/R1/565_4J /VFC1240424 /ZONE 4--GENERAL FIRE--NO RESET--",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:11:18:55",
        "PRI:7",
        "CALL:Fire Alarm",
        "ADDR:290 N MADISON AV",
        "MADDR:290 N MADISON AVE",
        "CITY:PASADENA",
        "X:E WALNUT ST & E CORSON ST",
        "INFO:FUJIOKA / ZONE 4--GENERAL FIRE--NO RESET--",
        "CH:R1",
        "MAP:565_4J",
        "ID:VFC1240424");

    doTest("T11",
        "Verdugo:07/17/12 11:56:32/1/SICK /1860 LUNDY AV ,PAS/btwn FLOWER ST & E MONTANA ST//R1/535_7J /VFC1240426 /EMS INFO: Male Age 23 NOT FEELING WELL",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:11:56:32",
        "PRI:5",
        "CALL:Person Sick",
        "ADDR:1860 LUNDY AV",
        "MADDR:1860 LUNDY AVE",
        "CITY:PASADENA",
        "X:FLOWER ST & E MONTANA ST",
        "INFO:Male Age 23 NOT FEELING WELL",
        "CH:R1",
        "MAP:535_7J",
        "ID:VFC1240426");

    doTest("T12",
        "Verdugo:07/17/12 12:16:08/1/TC /N BRAND BL/VENTURA FWY ,GLN/ //R1/564_3E /VFC1240429 /EMS INFO: Female PERSON DIZZY// PD ER SHORTLY",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:12:16:08",
        "PRI:5",
        "CALL:Traffic Collision",
        "ADDR:N BRAND BL & VENTURA FWY",
        "CITY:GLENDALE",
        "INFO:Female PERSON DIZZY / PD ER SHORTLY",
        "CH:R1",
        "MAP:564_3E",
        "ID:VFC1240429");

    doTest("T13",
        "Verdugo:07/17/12 12:25:35/1/BP /740 E WASHINGTON BL ,PAS/btwn PALM TER & RUTAN WAY//R1/566 A1 /VFC1240430 /EMS INFO: Male Age 71 Conscious LEFT FINGERS NUMBER// RN OS",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:12:25:35",
        "PRI:3",
        "CALL:Blood Pressure Problem",
        "ADDR:740 E WASHINGTON BL",
        "CITY:PASADENA",
        "X:PALM TER & RUTAN WAY",
        "INFO:Male Age 71 Conscious LEFT FINGERS NUMBER / RN OS",
        "CH:R1",
        "MAP:566 A1",
        "ID:VFC1240430");

    doTest("T14",
        "Verdugo:07/17/12 12:31:33/1/ALARM /160 N LAKE AV ,PAS/btwn E UNION ST & E WALNUT ST//R1/566 A4 /VFC1240432 /SMK DET IN DOWNSTAIRS RESTROOM // NO RESET",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:12:31:33",
        "PRI:7",
        "CALL:Fire Alarm",
        "ADDR:160 N LAKE AV",
        "MADDR:160 N LAKE AVE",
        "CITY:PASADENA",
        "X:E UNION ST & E WALNUT ST",
        "INFO:SMK DET IN DOWNSTAIRS RESTROOM / NO RESET",
        "CH:R1",
        "MAP:566 A4",
        "ID:VFC1240432");

    doTest("T15",
        "Verdugo:07/17/12 12:44:23/1/BP /1077 NEWBY ST #1 ,GLN/btwn SAN FERNANDO RD & W GLENOAKS BL//R1/564_2B /VFC1240433 /EMS INFO: Female Age 77 Conscious Diff Breath FEELS WEAK--HIGH BP",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:12:44:23",
        "PRI:3",
        "CALL:Blood Pressure Problem",
        "ADDR:1077 NEWBY ST",
        "APT:1",
        "CITY:GLENDALE",
        "X:SAN FERNANDO RD & W GLENOAKS BL",
        "INFO:Female Age 77 Conscious Diff Breath FEELS WEAK--HIGH BP",
        "CH:R1",
        "MAP:564_2B",
        "ID:VFC1240433");

    doTest("T16",
        "Verdugo:07/17/12 12:44:41/1/RESET /3521 COUNTRY CLUB DR ,GLN/btwn OAKMONT VIEW DR & DEAD-END/RESI: STEPANYAN/R1/534_4G /VFC1240434 /ZONE 42 FIRST FL SMK DET // ALARM HAS RESET",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:12:44:41",
        "PRI:7",
        "CALL:Fire Alarm Reset",
        "ADDR:3521 COUNTRY CLUB DR",
        "CITY:GLENDALE",
        "X:OAKMONT VIEW DR & DEAD-END",
        "INFO:RESI: STEPANYAN / ZONE 42 FIRST FL SMK DET / ALARM HAS RESET",
        "CH:R1",
        "MAP:534_4G",
        "ID:VFC1240434");

    doTest("T17",
        "Verdugo:07/17/12 13:48:22/1/HAZARD/205 E LOS FELIZ RD ,GLN/btwn S BRAND BL & S GLENDALE AV//R1/564 E7 /VFC1240442 /OUTLET TO THE BUILDING DOES WORK/// SCARED IT WILL CAUSE A FIRE// RP WILL MEET OUT FRONT",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:13:48:22",
        "PRI:7",
        "CALL:Investigate a Hazardous Condition",
        "ADDR:205 E LOS FELIZ RD",
        "CITY:GLENDALE",
        "X:S BRAND BL & S GLENDALE AV",
        "INFO:OUTLET TO THE BUILDING DOES WORK / SCARED IT WILL CAUSE A FIRE / RP WILL MEET OUT FRONT",
        "CH:R1",
        "MAP:564 E7",
        "ID:VFC1240442");

    doTest("T18",
        "Verdugo:07/17/12 14:03:08/1/ALOC /1132 E CALIFORNIA AV #6 ,GLN/btwn N ADAMS ST & MC HENRY RD//R1/564_4G /VFC1240445 /EMS INFO: Female Age 60 Conscious",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:14:03:08",
        "PRI:3",
        "CALL:Altered Level of Consciousness",
        "ADDR:1132 E CALIFORNIA AV",
        "MADDR:1132 E CALIFORNIA AVE",
        "APT:6",
        "CITY:GLENDALE",
        "X:N ADAMS ST & MC HENRY RD",
        "INFO:Female Age 60 Conscious",
        "CH:R1",
        "MAP:564_4G",
        "ID:VFC1240445");

    doTest("T19",
        "Verdugo:07/17/12 14:05:54/1/BACK /2716 E COLORADO BL ,PAS/btwn N SAN GABRIEL BL & S DAISY AV//R1/566_4F /VFC1240446 /EMS INFO: Female Age 50 Conscious",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:14:05:54",
        "PRI:5",
        "CALL:Back Pain",
        "ADDR:2716 E COLORADO BL",
        "CITY:PASADENA",
        "X:N SAN GABRIEL BL & S DAISY AV",
        "INFO:Female Age 50 Conscious",
        "CH:R1",
        "MAP:566_4F",
        "ID:VFC1240446");

    doTest("T20",
        "Verdugo:07/17/12 14:47:36/1/FALL2 /1727 E WASHINGTON BL ,PAS/btwn SINALOA AV & DOMINION AV/YOGURT SHOP/R1/566_1C /VFC1240453 /EMS INFO: Female Age 75 Conscious",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:14:47:36",
        "PRI:5",
        "CALL:Fall Minor",
        "ADDR:1727 E WASHINGTON BL",
        "CITY:PASADENA",
        "X:SINALOA AV & DOMINION AV",
        "INFO:YOGURT SHOP / Female Age 75 Conscious",
        "CH:R1",
        "MAP:566_1C",
        "ID:VFC1240453");

    doTest("T21",
        "Verdugo:07/17/12 14:55:29/1/UNKMED/50 N CRAIG AV #4 ,PAS/btwn E COLORADO BL & GLADYS ST//R1/566_4D /VFC1240454 /EMS INFO: Female Age 88 Conscious",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:14:55:29",
        "PRI:3",
        "CALL:Unknown Medical",
        "ADDR:50 N CRAIG AV",
        "MADDR:50 N CRAIG AVE",
        "APT:4",
        "CITY:PASADENA",
        "X:E COLORADO BL & GLADYS ST",
        "INFO:Female Age 88 Conscious",
        "CH:R1",
        "MAP:566_4D",
        "ID:VFC1240454");

    doTest("T22",
        "Verdugo:07/17/12 14:56:51/1/SEIZ /818 N OAKLAND AV #1 ,PAS/btwn BUCKEYE ST & E MOUNTAIN ST//R1/565_2J /VFC1240455 /EMS INFO: Male Age 17",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:14:56:51",
        "PRI:3",
        "CALL:Person In Seizure",
        "ADDR:818 N OAKLAND AV",
        "MADDR:818 N OAKLAND AVE",
        "APT:1",
        "CITY:PASADENA",
        "X:BUCKEYE ST & E MOUNTAIN ST",
        "INFO:Male Age 17",
        "CH:R1",
        "MAP:565_2J",
        "ID:VFC1240455");

    doTest("T23",
        "Verdugo:07/17/12 15:02:08/1/HANG /607 ASHTABULA ST ,PAS/btwn N MADISON AV & HINES AL//R2/565_3J /VFC1240456 /NO FURTHER INFORMATION",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:15:02:08",
        "PRI:2",
        "CALL:Person Hanging",
        "ADDR:607 ASHTABULA ST",
        "CITY:PASADENA",
        "X:N MADISON AV & HINES AL",
        "INFO:NO FURTHER INFORMATION",
        "CH:R2",
        "MAP:565_3J",
        "ID:VFC1240456");

    doTest("T24",
        "Verdugo:07/17/12 15:02:44/1/FALL2 /123 S ISABEL ST #505 ,GLN/btwn E BROADWAY & E HARVARD ST//R1/564 F5 /VFC1240457 /EMS INFO: Female Age 85 Conscious SLIPPED OFF TOILET",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:15:02:44",
        "PRI:5",
        "CALL:Fall Minor",
        "ADDR:123 S ISABEL ST",
        "APT:505",
        "CITY:GLENDALE",
        "X:E BROADWAY & E HARVARD ST",
        "INFO:Female Age 85 Conscious SLIPPED OFF TOILET",
        "CH:R1",
        "MAP:564 F5",
        "ID:VFC1240457");

    doTest("T25",
        "Verdugo:07/17/12 15:12:06/1/TC /W CHEVY CHASE DR/S COLUMBUS AV ,GLN/ //R1/564_6D /VFC1240460 /TC - 1 PT DIZZY - PD OS",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:15:12:06",
        "PRI:5",
        "CALL:Traffic Collision",
        "ADDR:W CHEVY CHASE DR & S COLUMBUS AV",
        "MADDR:W CHEVY CHASE DR & S COLUMBUS AVE",
        "CITY:GLENDALE",
        "INFO:TC - 1 PT DIZZY - PD OS",
        "CH:R1",
        "MAP:564_6D",
        "ID:VFC1240460");

    doTest("T26",
        "Verdugo:07/17/12 15:29:43/1/TR1 /E COLORADO BL/N HUDSON AV ,PAS/ /N/O COLORADO/R1/566_4A /VFC1240463 /EMS INFO: Female Age 20S PD OS// HEAD INJ FROM A TRAFFIC COLLISION",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:15:29:43",
        "PRI:3",
        "CALL:Severe Trauma",
        "ADDR:E COLORADO BL & N HUDSON AV",
        "MADDR:E COLORADO BL & N HUDSON AVE",
        "CITY:PASADENA",
        "INFO:N/O COLORADO / Female Age 20S PD OS / HEAD INJ FROM A TRAFFIC COLLISION",
        "CH:R1",
        "MAP:566_4A",
        "ID:VFC1240463");

    doTest("T27",
        "Verdugo:07/17/12 15:30:09/1/TC /S BRAND BL/E CHEVY CHASE DR ,GLN/ //R1/564_6E /VFC1240464 /PD ADV",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:15:30:09",
        "PRI:5",
        "CALL:Traffic Collision",
        "ADDR:S BRAND BL & E CHEVY CHASE DR",
        "CITY:GLENDALE",
        "INFO:PD ADV",
        "CH:R1",
        "MAP:564_6E",
        "ID:VFC1240464");

    doTest("T28",
        "Verdugo:07/17/12 15:31:30/1/ALOC /675 S ARROYO PKWY ,PAS/btwn PICO ST & FILLMORE ST/3RD FLOOR/R1/565_6H /VFC1240465 /EMS INFO: Male Age 62 Conscious LOW BLOOD PRESSURE - ALOC - DR OS",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:15:31:30",
        "PRI:3",
        "CALL:Altered Level of Consciousness",
        "ADDR:675 S ARROYO PKWY",
        "CITY:PASADENA",
        "X:PICO ST & FILLMORE ST",
        "INFO:3RD FLOOR / Male Age 62 Conscious LOW BLOOD PRESSURE - ALOC - DR OS",
        "CH:R1",
        "MAP:565_6H",
        "ID:VFC1240465");

    doTest("T29",
        "Verdugo:07/17/12 15:37:23/1/STROKE/190 ARROYO TER #301 ,PAS/btwn LIVE OAKS AV & N GRAND AV//R1/565_4F /VFC1240467 /EMS INFO: Male Age 64 Conscious SLURRED SPEACH",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:15:37:23",
        "PRI:3",
        "CALL:CVA-Neurological",
        "ADDR:190 ARROYO TER",
        "APT:301",
        "CITY:PASADENA",
        "X:LIVE OAKS AV & N GRAND AV",
        "INFO:Male Age 64 Conscious SLURRED SPEACH",
        "CH:R1",
        "MAP:565_4F",
        "ID:VFC1240467");

    doTest("T30",
        "Verdugo:07/17/12 15:43:36/1/ALOC /2900 E DEL MAR BL #232 ,PAS/btwn S SUNNYSLOPE AV & EL NIDO AV//R1/566 F5 /VFC1240468 /EMS INFO: Male Age 38 Conscious DR OS",
        "SRC:Verdugo",
        "DATE:07/17/12",
        "TIME:15:43:36",
        "PRI:3",
        "CALL:Altered Level of Consciousness",
        "ADDR:2900 E DEL MAR BL",
        "APT:232",
        "CITY:PASADENA",
        "X:S SUNNYSLOPE AV & EL NIDO AV",
        "INFO:Male Age 38 Conscious DR OS",
        "CH:R1",
        "MAP:566 F5",
        "ID:VFC1240468");

  }
  
  @Test
  public void testEmergenyRadioService() {

    doTest("T1",
        "(VFCC Alert) Verdugo:14:02/2/HOUSE /520 S GARFIELD AV ,MPK/btwn E NEWMARK AV & S RAMONA AV//R3/636_1B /VFC1337311 /2 STORY HOUSE",
        "SRC:Verdugo",
        "TIME:14:02",
        "CALL:House Fire ALARM:2",
        "PRI:4",
        "ADDR:520 S GARFIELD AV",
        "MADDR:520 S GARFIELD AVE",
        "CITY:MONTEREY PARK",
        "X:E NEWMARK AV & S RAMONA AV",
        "INFO:2 STORY HOUSE",
        "CH:R3",
        "MAP:636_1B",
        "ID:VFC1337311");

    doTest("T2",
        "(VFCC Alert) Verdugo:07:21/1/HOUSE /520 N GARFIELD AV ,MPK/btwn HILLIARD AV & W HAMPTON AV//R3/636_1B /VFC1337311 /2 STORY HOUSE",
        "SRC:Verdugo",
        "TIME:07:21",
        "CALL:House Fire",
        "PRI:4",
        "ADDR:520 N GARFIELD AV",
        "MADDR:520 N GARFIELD AVE",
        "CITY:MONTEREY PARK",
        "X:HILLIARD AV & W HAMPTON AV",
        "INFO:2 STORY HOUSE",
        "CH:R3",
        "MAP:636_1B",
        "ID:VFC1337311");

    doTest("T3",
        "(VFCC Alert) Verdugo:40:26/1/VEG /1003 ROSE BOWL DR ,PAS/btwn ROSEMONT AV & N ARROYO BL/SOUTH OF LOT F AT ROSE BOWL DR/SECO/R2/565 3F /VFC1337306 /NO FURTHER INFORMATION",
        "SRC:Verdugo",
        "TIME:40:26",
        "CALL:Vegetation Fire",
        "PRI:4",
        "ADDR:1003 ROSE BOWL DR",
        "CITY:PASADENA",
        "X:ROSEMONT AV & N ARROYO BL",
        "INFO:SOUTH OF LOT F AT ROSE BOWL DR/SECO / NO FURTHER INFORMATION",
        "CH:R2",
        "MAP:565 3F",
        "ID:VFC1337306");

    doTest("T4",
        "(VFCC Alert) Verdugo:32:29/1/HOUSE /2292 WHITE ST ,PAS/btwn LOLA AV & MARTELO AV/HOUSE NEXT DOOR/R2/566_4D /VFC1337278 /FIRE ALARM ACTIVATED - SMOKE FROM 2ND STY WINDOW - NO ANSWER FRONT DOOR",
        "SRC:Verdugo",
        "TIME:32:29",
        "CALL:House Fire",
        "PRI:4",
        "ADDR:2292 WHITE ST",
        "CITY:PASADENA",
        "X:LOLA AV & MARTELO AV",
        "INFO:HOUSE NEXT DOOR / FIRE ALARM ACTIVATED - SMOKE FROM 2ND STY WINDOW - NO ANSWER FRONT DOOR",
        "CH:R2",
        "MAP:566_4D",
        "ID:VFC1337278");

    doTest("T5",
        "(VFCC Alert) Verdugo:14:53/1/RESCUE/655 N FAIR OAKS AV ,PAS/btwn E PEORIA ST & E ORANGE GROVE BL/ENTRANCE OF STORE/R2/565 H3 /VFC1337276 /EMS INFO: Male Age 4 Conscious HEAD STUCK IN TURNSTYLE AT STORE",
        "SRC:Verdugo",
        "TIME:14:53",
        "CALL:Rescue",
        "PRI:2",
        "ADDR:655 N FAIR OAKS AV",
        "MADDR:655 N FAIR OAKS AVE",
        "CITY:PASADENA",
        "X:E PEORIA ST & E ORANGE GROVE BL",
        "INFO:ENTRANCE OF STORE / Male Age 4 Conscious HEAD STUCK IN TURNSTYLE AT STORE",
        "CH:R2",
        "MAP:565 H3",
        "ID:VFC1337276");

    doTest("T6",
        "(VFCC Alert) Verdugo:21:06/1/STR /437 E PALM AV ,BRK/btwn N GLENOAKS BL & N FIFTH ST/IN GARAGE UNDERGROUND PARKING/R2/533_6H /VFC1337258 /SUBTERANNEAN GARAGE BLOW APTS",
        "SRC:Verdugo",
        "TIME:21:06",
        "CALL:Structure Fire",
        "PRI:4",
        "ADDR:437 E PALM AV",
        "MADDR:437 E PALM AVE",
        "CITY:BURBANK",
        "X:N GLENOAKS BL & N FIFTH ST",
        "INFO:IN GARAGE UNDERGROUND PARKING / SUBTERANNEAN GARAGE BLOW APTS",
        "CH:R2",
        "MAP:533_6H",
        "ID:VFC1337258");

    doTest("T7",
        "(VFCC Alert) Verdugo:44:00/1/TCRES /W COLORADO ST/S PACIFIC AV ,GLN/ //R1/564_5D /VFC1337252 /NO FURTHER INFORMATION",
        "SRC:Verdugo",
        "TIME:44:00",
        "CALL:Traffic Collision w/Rescue",
        "PRI:2",
        "ADDR:W COLORADO ST & S PACIFIC AV",
        "MADDR:W COLORADO ST & S PACIFIC AVE",
        "CITY:GLENDALE",
        "INFO:NO FURTHER INFORMATION",
        "CH:R1",
        "MAP:564_5D",
        "ID:VFC1337252");

    doTest("T8",
        "(VFCC Alert) Verdugo:32:52/1/JUMPER/855 W EL REPETTO DR #13C ,MPK/btwn S ATLANTIC BL & SUNRISE DR/STAGE FOR PD/R3/635_4J /VFC1337250 /EMS INFO: Female Age TEEN PD NOT SURE IF SHE IS TRYING TO POSS JUMP OR ESCAPE..",
        "SRC:Verdugo",
        "TIME:32:52",
        "CALL:Person Threatening To Jump",
        "PRI:2",
        "ADDR:855 W EL REPETTO DR",
        "APT:13C",
        "CITY:MONTEREY PARK",
        "X:S ATLANTIC BL & SUNRISE DR",
        "INFO:STAGE FOR PD / Female Age TEEN PD NOT SURE IF SHE IS TRYING TO POSS JUMP OR ESCAPE..",
        "CH:R3",
        "MAP:635_4J",
        "ID:VFC1337250");

    doTest("T9",
        "(VFCC Alert) Verdugo:39:23/1/TCRES /718 S LOS ROBLES AV ,PAS/btwn MILES ST & FILLMORE ST//R1/565_6J /VFC1337242 /PD ER",
        "SRC:Verdugo",
        "TIME:39:23",
        "CALL:Traffic Collision w/Rescue",
        "PRI:2",
        "ADDR:718 S LOS ROBLES AV",
        "MADDR:718 S LOS ROBLES AVE",
        "CITY:PASADENA",
        "X:MILES ST & FILLMORE ST",
        "INFO:PD ER",
        "CH:R1",
        "MAP:565_6J",
        "ID:VFC1337242");

    doTest("T10",
        "(VFCC Alert) Verdugo:27:39/1/HOUSE /1826 S MAYFLOWER AV ,MRV/btwn W DUARTE RD & EL NORTE AV//R2/567 6F /VFC1337241 /NO FURTHER INFORMATION",
        "SRC:Verdugo",
        "TIME:27:39",
        "CALL:House Fire",
        "PRI:4",
        "ADDR:1826 S MAYFLOWER AV",
        "MADDR:1826 S MAYFLOWER AVE",
        "CITY:MONROVIA",
        "X:W DUARTE RD & EL NORTE AV",
        "INFO:NO FURTHER INFORMATION",
        "CH:R2",
        "MAP:567 6F",
        "ID:VFC1337241");

    doTest("T11",
        "(VFCC Alert) Verdugo:13:17/1/TCRES /1644 ROYAL BL ,GLN/btwn IMPERIAL DR & OLD PHILLIPS RD//R3/564_1G /VFC1337205 /OVERTURNED VEH - PD ER",
        "SRC:Verdugo",
        "TIME:13:17",
        "CALL:Traffic Collision w/Rescue",
        "PRI:2",
        "ADDR:1644 ROYAL BL",
        "CITY:GLENDALE",
        "X:IMPERIAL DR & OLD PHILLIPS RD",
        "INFO:OVERTURNED VEH - PD ER",
        "CH:R3",
        "MAP:564_1G",
        "ID:VFC1337205");

    doTest("T12",
        "(VFCC Alert) Verdugo:53:54/1/TCRES /MADELINE DR/S ORANGE GROVE BL ,PAS/ //R2/565_7G /VFC1337171 /ONE VEH ROLLOVER - PD ER SHORTLY",
        "SRC:Verdugo",
        "TIME:53:54",
        "CALL:Traffic Collision w/Rescue",
        "PRI:2",
        "ADDR:MADELINE DR & S ORANGE GROVE BL",
        "CITY:PASADENA",
        "INFO:ONE VEH ROLLOVER - PD ER SHORTLY",
        "CH:R2",
        "MAP:565_7G",
        "ID:VFC1337171");

    doTest("T13",
        "(VFCC Alert) Verdugo:44:30/1/UNKF /2016 ISABELLA AV ,MPK/btwn W ELMGATE ST & FERNBANK AV//R2/636_5B /VFC1337160 /ODOR OF SOMETHING BURNING IN AREA",
        "SRC:Verdugo",
        "TIME:44:30",
        "CALL:Unknown Type Fire",
        "PRI:6",
        "ADDR:2016 ISABELLA AV",
        "MADDR:2016 ISABELLA AVE",
        "CITY:MONTEREY PARK",
        "X:W ELMGATE ST & FERNBANK AV",
        "INFO:ODOR OF SOMETHING BURNING IN AREA",
        "CH:R2",
        "MAP:636_5B",
        "ID:VFC1337160");

    doTest("T14",
        "(VFCC Alert) Verdugo:24:21/1/HOUSE /2917 GLENAVEN AV ,ALH/btwn ORANGE GROVE AV & PARK VIEW DR//R2/635_1G /VFC1337133 /SMOKE COMING FROM PORCH",
        "SRC:Verdugo",
        "TIME:24:21",
        "CALL:House Fire",
        "PRI:4",
        "ADDR:2917 GLENAVEN AV",
        "MADDR:2917 GLENAVEN AVE",
        "CITY:ALHAMBRA",
        "X:ORANGE GROVE AV & PARK VIEW DR",
        "INFO:SMOKE COMING FROM PORCH",
        "CH:R2",
        "MAP:635_1G",
        "ID:VFC1337133");

    doTest("T15",
        "(VFCC Alert) Verdugo:58:03/1/STR /3843 E FIRST ST #75 ,LAC/btwn N HERBERT AV & S HERBERT AV//B3/635_6E /VFC1337118 /REQ E63 W/COE3 BLUE 3 TAC V10D",
        "SRC:Verdugo",
        "TIME:58:03",
        "CALL:Structure Fire",
        "PRI:4",
        "ADDR:3843 E FIRST ST",
        "APT:75",
        "CITY:LOS ANGELES COUNTY",
        "X:N HERBERT AV & S HERBERT AV",
        "INFO:REQ E63 W / COE3 BLUE 3 TAC V10D",
        "CH:B3",
        "MAP:635_6E",
        "ID:VFC1337118");

    doTest("T16",
        "(VFCC Alert) Verdugo:18:49/1/MTNRES/000 CHANTRY FLATS RD ,LAC//AT HERMIT FALLS/R3/537 4D /VFC1337101 /ANKLE INJ REQ E41 W/COE44 SQ32..BLUE 6 V9 DIRECT",
        "SRC:Verdugo",
        "TIME:18:49",
        "CALL:Mountain Rescuer",
        "PRI:2",
        "ADDR:CHANTRY FLATS RD",
        "CITY:LOS ANGELES COUNTY",
        "INFO:AT HERMIT FALLS / ANKLE INJ REQ E41 W / COE44 SQ32..BLUE 6 V9 DIRECT",
        "CH:R3",
        "MAP:537 4D",
        "ID:VFC1337101");

    doTest("T17",
        "(VFCC Alert) Verdugo:46:51/1/APT /3832 WHITESIDE ST #2 ,LAC/btwn N HERBERT AV & N BONNIE BEACH PL//B3/635_3E /VFC1337089 /REQ E63 W/CO1 BLUE3 V10 DIRECT",
        "SRC:Verdugo",
        "TIME:46:51",
        "CALL:Apartment House Fire",
        "PRI:4",
        "ADDR:3832 WHITESIDE ST",
        "APT:2",
        "CITY:LOS ANGELES COUNTY",
        "X:N HERBERT AV & N BONNIE BEACH PL",
        "INFO:REQ E63 W / CO1 BLUE3 V10 DIRECT",
        "CH:B3",
        "MAP:635_3E",
        "ID:VFC1337089");

    doTest("T18",
        "(VFCC Alert) Verdugo:07:07/1/RESFWY/WB 210 FWY AT SANTA ANITA AV ,ARC///R2/",
        "SRC:Verdugo",
        "TIME:07:07",
        "CALL:TC-Rescue on the FWY",
        "PRI:2",
        "ADDR:WB 210 FWY AT SANTA ANITA AV",
        "MADDR:RT 210 AT SANTA ANITA AVE",
        "CITY:ARCADIA",
        "CH:R2");

    doTest("T19",
        "(VFCC Alert) Verdugo:40:17/1/TCRES /501 S MONTEBELLO BL ,MTB/btwn W WALNUT AV & MINES AV//R1/676_3D /VFC1336988 /---PERSON TRAPPED--- PD ER",
        "SRC:Verdugo",
        "TIME:40:17",
        "CALL:Traffic Collision w/Rescue",
        "PRI:2",
        "ADDR:501 S MONTEBELLO BL",
        "CITY:MONTEBELLO",
        "X:W WALNUT AV & MINES AV",
        "INFO:---PERSON TRAPPED--- PD ER",
        "CH:R1",
        "MAP:676_3D",
        "ID:VFC1336988");

    doTest("T20",
        "(VFCC Alert) Verdugo:05:41/1/GARAGE/1925 HILTON DR ,BRK/btwn CAMBRIDGE DR & ETON DR//R2/533_4G /VFC1336971 /---APPROX LOCATION FROM LAT/LONG OF CALLER...ADV FIRE...NFD",
        "SRC:Verdugo",
        "TIME:05:41",
        "CALL:Garage Fire",
        "PRI:4",
        "ADDR:1925 HILTON DR",
        "CITY:BURBANK",
        "X:CAMBRIDGE DR & ETON DR",
        "INFO:---APPROX LOCATION FROM LAT / LONG OF CALLER...ADV FIRE...NFD",
        "CH:R2",
        "MAP:533_4G",
        "ID:VFC1336971");

  }
  
  public static void main(String[] args) {
    new CALosAngelesCountyParserTest().generateTests("T1");
  }
}