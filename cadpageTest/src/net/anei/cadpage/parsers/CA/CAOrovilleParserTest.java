package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Oroville, CA
Contact: Active911
Agency name: El Medio Fire District
Location: Oroville, CA, United States

(Dispatched Call (121)) MYERS ST/OROVILLE DAM BLVD E, Oroville, CA *  * OROVILLE DAM BLVD E *  * FDTC1 *  * \nTWO VEHICLES
(Dispatched Call (313)) 3093 OROVILLE BANGOR HWY, Oroville, CA *  * V-6 RD/AUTREY LN *  * FDMED *  * Service Class: VOIP\nMATERNITY COMPLICATIONS
(Dispatched Call (313)) 2024 OROVILLE DAM BLVD E, Oroville, CA * BLOCKBUSTER VIDEO * BROWN AV/CURRIER CT *  * FDINVEST *  * ZONE 100 GENERAL
(Dispatched Call (121)) 445 OROVILLE DAM BLVD E, Oroville, CA * MCDONALDS * FEATHER RIVER BLVD/7TH A *  * FDTC1 *  * \nIN DRIVETHRU         WHITE NISSAN 4DR     GREE
(Dispatched Call (113)) 1751 OROVILLE DAM BLVD E, Oroville, CA * PAPACITOS * LINCOLN ST/MYERS ST * 14 * FDMED *  * BODY LYING NEXT TO TRACKS ON OVERPASS            
(Dispatched Call (113)) 1218 POMONA AV, Oroville, CA *  * 3RD AV/VEATCH ST * 1 * FDMED *  * \nILL BABY
(Dispatched Call (113)) 1611 FEATHER RIVER BLVD, Oroville, CA * COMMUNITY COMPREHENSIVE-WOMENS * HIGH ST/POMONA AV * 10 * FDMED *  * Service Class: BUSN\nhigh blood
(Dispatched Call (121)) 2060 2ND ST, Oroville, CA * PROSPECT HIGH SCHOOL * GRAND AV/NELSON AV *  * FDMED *  * Service Class: CNTX\nover medicated
(Dispatched Call (121)) 1408 OROVILLE DAM BLVD W, Oroville, CA *  * 14TH ST/HARLAN AV *  * FDMED *  * ill fem
(Dispatched Call (121)) 125 COTTONWOOD CIR, Oroville, CA *  * 5TH AV/MULBERRY DR * BLDG TRL * FDASSIST *  * Service Class: RESD\nlift assist
(Dispatched Call (313)) OROVILLE BANGOR HWY/MYERS ST, Oroville, CA *  * MYERS ST *  * FDFIRE1 *  * VEH FIRE
(Dispatched Call (313)) 3020 GREENVILLE ST, Oroville, CA *  * LOWER WYANDOTTE RD/V-C R *  * FDMED *  * DIFF BREATHING
(Dispatched Call (113)) 646 POMONA AV, Oroville, CA *  * 7TH AV/8TH AV *  * FDMED *  * 10-5 FORM CAL FIRE. ILL MALE, 3RD HAND REPORT OF MEDICAL ISSUE.
(Dispatched Call (313)) 1825 FORT WAYNE ST, Oroville, CA *  * LINCOLN BLVD/LINCOLN BLVD *  * FDMED *  * SEIZURE
(Dispatched Call (313)) 3106 LINCOLN BLVD, Oroville, CA * B & S COIN LAUNDRY * WYANDOTTE AV/A ST *  * FDMED *  * ALOC / GOLD SATURN
(Dispatched Call (121)) 1735 MONTGOMERY ST, Oroville, CA * CITY HALL * OAK ST/LINCOLN ST *  * FDHAZMA1 *  * 
(Dispatched Call (113)) 1735 MONTGOMERY ST, Oroville, CA * CITY HALL * OAK ST/LINCOLN ST *  * FDHAZMA1 *  * 
(Dispatched Call (313)) 2262 LAS PLUMAS AV, Oroville, CA *  * LAS PLUMAS WAY/CRESTRIDG *  * FDMED *  * Service Class: RESD\n\nILL MALE
(Dispatched Call (113)) 1460 OLIVER ST, Oroville, CA * SHEAR ELEGANCE BEAUTY SALON * HIGH ST/ROBINSON ST *  * FDMED *  * \n\nFALL
(Dispatched Call (313)) OROVILLE DAM BLVD E/CANYON DR, Oroville, CA *  * CANYON DR *  * FDTC1 *  * AUTO AID CAL FIRE
(Dispatched Call (313)) 5825 VISTA DEL CERRO, Oroville, CA *  * VIA LATON *  * FDMED *  * \nILL FEM
(Dispatched Call (113)) WYANDOTTE AV/LINCOLN BLVD, Oroville, CA *  * LINCOLN BLVD *  * FDMED *  * Service Class: VOIP\n\nFALL UNK INJURIES
(Dispatched Call (313)) 3070 MYERS ST, Oroville, CA * PIGGS CLUB * WYANDOTTE AV/A ST *  * FDMED *  * STAGE / ASSAULT / PD ENRT
(Dispatched Call (113)) 1000 EXECUTIVE PKWY, Oroville, CA * OLIVE RIDGE CARE HOME * MEDICAL CENTER DR * 101 A * FDMED *  * DIFF BREATHING
(Dispatched Call (113)) 825 GARDELLA AV, Oroville, CA *  * 5TH AV/6TH AV *  * FDMED *  * FALL
(Dispatched Call (113)) 900 OROVILLE DAM BLVD E, Oroville, CA *  * 5TH AV/VEATCH ST *  * FDMED *  * Service Class: BUSN\n\nDIFFICULTY BREATHING
(Dispatched Call (121)) 1827 OROVILLE DAM BLVD E, Oroville, CA * ORO JEWELRY AND LOAN * LINCOLN ST/MYERS ST *  * FDTC1 *  * BLK HONDA GRY ESCORT ROADWAY IS CLEAR
(Dispatched Call (113)) 900 OROVILLE DAM BLVD E, Oroville, CA * COMMUNITY COMP CARE * 5TH AV/VEATCH ST *  * FDMED *  * Service Class: BUSN\n\nSHORTNESS OF BREATH. I
(Dispatched Call (313)) 2850 MYERS ST, Oroville, CA *  * ONTARIO AV/CORTO ST * 11 * FDMED *  * Service Class: RESD\n\nFALL WITH INJURY
(Dispatched Call (113)) 1911 OROVILLE DAM BLVD E, Oroville, CA * DOLLAR STORE * MYERS ST/BROWN AV *  * FDMED *  * \n\nFEM W/ KNEE INJURY. FEM IS WEARING A GRN JACKET
(Dispatched Call (121)) 3415 OROVILLE DAM BLVD E, Oroville, CA * WE LANDSCAPE * STANFORD AV/ACACIA AV * 114 * FDASSIST *  * \nLIFT ASSIST, BACK BEDROOM
(Dispatched Call (113)) 1536 5TH AV, Oroville, CA *  * ROBINSON ST/HIGH ST *  * FDMED *  * Service Class: RESD\n\nDIFFICULTY BREATHING
(Dispatched Call (113)) 700 MITCHELL AV, Oroville, CA * WINSTON GARDENS * 5TH AV/3RD AV * 32 * FDMED *  * 92 YEAR OLD FEMALE 530-534-6512 VELMA MORRISON\nCHEST PAIN
(Dispatched Call (121)) 2185 PERKINS AV, Oroville, CA *  * QUARTZ AV/MITCHELL AV *  * FDINVEST *  * Service Class: VOIP\n\nSMOKE ALARM SOUNDING, RP DOES NOT SMELL S
(Dispatched Call (313)) 2930 GREENVILLE ST, Oroville, CA *  * BURLINGTON AV/V-C RD * 4 * FDMED *  * CHEST PAIN
(Dispatched Call (121)) 2588 OLIVE HWY, Oroville, CA * FLUFF & FOLD LAUNDRY * FAY WAY/FAY WAY * AB * FDMED *  * ILL MALE
(Dispatched Call (113)) TABLE MOUNTAIN BLVD/WASHINGTON A, Oroville, CA * GREEN BRIDGE * WASHINGTON AV *  * FDMED *  * 
(Dispatched Call (121)) 1017 BIRD ST, Oroville, CA * STEADFAST MANAGEMENT * 4TH AV/3RD AV *  * FDASSIST *  * 2 YR OLD LOCKED INSIDE RUNNING VEHICLE; HEATER ON HIGH
(Dispatched Call (113)) 1000 EXECUTIVE PKWY, Oroville, CA * OLIVE RIDGE CARE HOME * MEDICAL CENTER DR * 109 * FDMED *  * Service Class: PBXb\n\nUNRESPONSIVE
(Dispatched Call (113)) MONTGOMERY ST/MYERS ST, Oroville, CA *  * MYERS ST *  * FDINVEST *  * 
(Dispatched Call (121)) 293 COLINA WAY, Oroville, CA *  * GOLD AVE *  * FDMED *  * MAN DOWN
(Dispatched Call (313)) 5280 SUZANNE CT, Oroville, CA *  * OAK KNOLL WAY *  * FDMED *  * Service Class: RESD\nBREATHING DIFF
(Dispatched Call (313)) 2606 OAK KNOLL WAY, Oroville, CA *  * V-E AV/SEACREST DR *  * FDMED *  * INJURIES FROM FALL
(Dispatched Call (113)) 2329 MONTGOMERY ST, Oroville, CA * TASSIS HAIR & NAILS * ARLIN RHINE DR/WASHINGTO * 7 * FDMED *  * Service Class: VOIP\n\nILL FEMALE
(Dispatched Call (121)) 1601 MITCHELL AV, Oroville, CA * PACIFIC COAST PRODUCERS * PINE ST/W LINCOLN ST *  * FDINVEST *  * FIRE ALARM WATER FLOW FROM WAREHOUSE G N/
(Dispatched Call (121)) 2472 OROVILLE QUINCY HWY, Oroville, CA *  * MYRTLE DR/LINDA LOMA DR * B * FDINVEST *  * HOME AT REAR OF LOCATION.  CO2 DETECTOR.
(Dispatched Call (113)) 2750 LINCOLN BLVD, Oroville, CA * OROVILLE MANOR APARTMENTS * OROVILLE DAM BLVD E/PEAR * 105 * FDMED *  * Service Class: RESD\n\nILL FEMALE
(Dispatched Call (113)) 505 MONTGOMERY ST, Oroville, CA * MOTEL 6 * EB HWY 70 OFFRAMP/EB HWY * 133 * FDMED *  * Service Class: V\n\nILL MALE
(Dispatched Call (113)) 2740 OROVILLE DAM BLVD E, Oroville, CA * TRICOUNTY TREATMENT * GILMORE LN/OROVILLE QUIN *  * FDMED *  * CHEST PAIN
(Dispatched Call (313)) 5342 BECKY LN, Oroville, CA *  * CINDY CT/STUMP DR *  * FDMED *  * CHEST PAIN
(Dispatched Call (313)) OLIVE HWY/KELLY RIDGE RD, Oroville, CA *  * KELLY RIDGE RD *  * FDTC1 *  * OLIVE IC ON CALCORD
(Dispatched Call (313)) 5721 AUTREY LN, Oroville, CA *  * MONTE VISTA AV/VIA MADER *  * FDMED *  * CHEST PAIN
(Dispatched Call (313)) 3515 MYERS ST, Oroville, CA * EL MEDIO FIRE * D ST/ELGIN ST *  * FDMED *  * DIFFICULTY BREATHING
(Dispatched Call (113)) 60 HIGHLANDS BLVD, Oroville, CA *  * COVENTRY DR/ROCKRIDGE RD *  * FDMED *  * Service Class: VOIP\nILL FEMALE  POSSIBLE STROKE
(Dispatched Call (113)) 1454 14TH ST, Oroville, CA *  * FEATHER AV/GRAND AV *  * FDMED *  * \nDIFF BREATHING
(Dispatched Call (121)) 1454 14TH ST, Oroville, CA *  * FEATHER AV/GRAND AV *  * FDMED *  * \nDIFF BREATHING
(Dispatched Call (113)) 1215 5TH AV, Oroville, CA *  * SAFFORD ST/MONTGOMERY ST *  * FDMED *  * Service Class: RESD\n\nILL FEMALE
(Dispatched Call (313)) 2156 WYANDOTTE AV, Oroville, CA *  * BARNES WAY/FLORENCE AV *  * FDMED *  * Service Class: VOIP\nILL BABY  SIEZURES
(Dispatched Call (313)) 2923 MYERS ST, Oroville, CA *  * ONTARIO AV/CORTO ST *  * FDMED *  * \n\nDIFFICULTY BREATHING
(Dispatched Call (121)) 1100 FEATHER RIVER BLVD, Oroville, CA * BEDROCK PARK * 5TH AV/SAFFORD ST *  * FDMED *  * \n\nILL FEM AT TENNIS COURTS
(Dispatched Call (113)) 2160 FEATHER RIVER BLVD, Oroville, CA * APPLEBEES * MITCHELL AV/OROVILLE DAM *  * FDTC1 *  * \n\nNECK INJURY IN PARKING LOT\n2 VEHS
(Dispatched Call (113)) 2055 LINCOLN ST, Oroville, CA * OROVILLE POLICE DEPARTMENT * HUNTOON ST/MITCHELL AV *  * TEST *  * TEST ONLY
(Dispatched Call (121)) 1875 FEATHER RIVER BLVD, Oroville, CA * OROVILLE GYMNASTICS ACADEMY * MITCHELL AV/OROVILLE DAM *  * FDMED *  * \n\nNECK INJURY
(Dispatched Call (113)) 1100 FEATHER RIVER BLVD, Oroville, CA * SKATE PARK * 5TH AV/SAFFORD ST *  * FDMED *  * \nANKLE INJURY  NEAR ENTRANCE
(Dispatched Call (113)) 2719 MITCHELL AV, Oroville, CA *  * OROVILLE QUINCY HWY/BRID * 4 * FDMED *  * \n\nSEIZURE
(Dispatched Call (113)) 2105 PARK AV, Oroville, CA * PARK PLACE APARTMENTS * PLACER LN/HEWITT AV * 6 * FDMED *  * Service Class: RESD\n\nDIFFICULTY BREATHING
(Dispatched Call (313)) 3245 COLUMBIA AV, Oroville, CA *  * A ST/B ST * A * FDMED *  * ILL FEMALE \n\nService Class: RESD
(Dispatched Call (113)) 505 MONTGOMERY ST, Oroville, CA * MOTEL 6 * EB HWY 70 OFFRAMP/EB HWY * 130 * FDMED *  * \n\nSEIZURE
(Dispatched Call (113)) 965 MONTGOMERY ST, Oroville, CA *  * 4TH AV/3RD AV *  * FDMED *  * ILL MALE.
(Dispatched Call (313)) 3245 COLUMBIA AV, Oroville, CA *  * A ST/B ST * A * FDMED *  * Service Class: RESD\nILL FEMALE
(Dispatched Call (313)) WASHINGTON AV/OROVILLE DAM BLVD, Oroville, CA *  * OROVILLE DAM BLVD E *  * TE *  * 
(Dispatched Call (121)) 2078 2ND ST, Oroville, CA *  * GRAND AV/NELSON AV *  * FDMED *  * POSS UNRESPONSIVE INFANT \n\nCellular E911 Call: \nLat:39.521556  Lon:-121
(Dispatched Call (113)) 85 RANCHO VISTA DR, Oroville, CA * RANCHO VISTA APARTMENTS * GRAND AV * 12 * FDMED *  * \nILL FEMALE   DIFF BREATHING
(Dispatched Call (313)) 3245 COLUMBIA AV, Oroville, CA *  * A ST/B ST * A * FDMED *  * Service Class: RESD\nILL FEMALE BREATHING DIFF   DOOR OPEN
(Dispatched Call (313)) 3010 MYERS ST, Oroville, CA * ROBERTS DRUG STORE * CORTO ST/WYANDOTTE AV *  * FDMED *  * Service Class: BUSN\nUNCONSCIOUS FEMALE
(Dispatched Call (313)) 2167 B ST, Oroville, CA *  * SPENCER AV/ROSEBEN AV *  * FDMED *  * \n\nILL FEMALE
(Dispatched Call (113)) 974 MONTGOMERY ST, Oroville, CA *  * 4TH AV/3RD AV * 1 * FDMED *  * 
(Dispatched Call (113)) 85 RANCHO VISTA DR, Oroville, CA * RANCHO VISTA APARTMENTS * GRAND AV * 34 * FDMED *  * Service Class: RESD\n\nAPARTMENT CLOSEST TO RIO VIST
(Dispatched Call (313)) EL NOBLE AV/MESA AV, Oroville, CA *  * MESA AV *  * FDHAZD3 *  * BROKEN FIRE HYDRANTE
(Dispatched Call (113)) 1 GILMORE LN, Oroville, CA * SHADOWBROOK HEALTH CARE * OROVILLE DAM BLVD E/MEDI * 19 * FDMED *  * bed 2 chest pain
(Dispatched Call (313)) 55 CONCORDIA LN, Oroville, CA * COUNTRY CREST * EDGEWOOD DR * 209 * FDMED *  * ALTERED LOC
(Dispatched Call (113)) 2053 OROVILLE BANGOR HWY, Oroville, CA *  * LINCOLN BLVD/SPENCER AV *  * FDMED *  * \n\nILL MALE
(Dispatched Call (114)) 2053 OROVILLE BANGOR HWY, Oroville, CA *  * LINCOLN BLVD/SPENCER AV *  * FDMED *  * \n\nILL MALE
(Dispatched Call (313)) 28 REGENT LOOP, Oroville, CA *  * MONTE VISTA AV *  * FDMED *  * AUTO MEDICAL
(Dispatched Call (114)) 1980 MOUNTAIN VISTA DR, Oroville, CA *  * CREST DR *  * FDMED *  * ALTERED LOC
(Dispatched Call (121)) 18 COVENTRY DR, Oroville, CA *  * PARKWOOD DR/LINDA DR *  * FDASSIST *  * Service Class: RESD\nLIFT ASSIST

(Dispatched Call (114)) 974 MONTGOMERY ST, Oroville, CA *  * 4TH AV/3RD AV * 2 * FDMED *  * #130819101 * \n\nABDOMINAL PAIN\n\n

 */


public class CAOrovilleParserTest extends BaseParserTest {
  
  public CAOrovilleParserTest() {
    setParser(new CAOrovilleParser(), "OROVILLE", "CA");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(Dispatched Call (121)) MYERS ST/OROVILLE DAM BLVD E, Oroville, CA *  * OROVILLE DAM BLVD E *  * FDTC1 *  * \nTWO VEHICLES",
        "UNIT:121",
        "ADDR:MYERS ST & OROVILLE DAM BLVD E",
        "CITY:Oroville",
        "X:OROVILLE DAM BLVD E",
        "CODE:FDTC1",
        "CALL:TWO VEHICLES");

    doTest("T2",
        "(Dispatched Call (313)) 3093 OROVILLE BANGOR HWY, Oroville, CA *  * V-6 RD/AUTREY LN *  * FDMED *  * Service Class: VOIP\n" +
        "MATERNITY COMPLICATIONS",

        "UNIT:313",
        "ADDR:3093 OROVILLE BANGOR HWY",
        "CITY:Oroville",
        "X:V-6 RD/AUTREY LN",
        "CODE:FDMED",
        "CALL:MATERNITY COMPLICATIONS");

    doTest("T3",
        "(Dispatched Call (313)) 2024 OROVILLE DAM BLVD E, Oroville, CA * BLOCKBUSTER VIDEO * BROWN AV/CURRIER CT *  * FDINVEST *  * ZONE 100 GENERAL",
        "UNIT:313",
        "ADDR:2024 OROVILLE DAM BLVD E",
        "CITY:Oroville",
        "PLACE:BLOCKBUSTER VIDEO",
        "X:BROWN AV/CURRIER CT",
        "CODE:FDINVEST",
        "CALL:ZONE 100 GENERAL");

    doTest("T4",
        "(Dispatched Call (121)) 445 OROVILLE DAM BLVD E, Oroville, CA * MCDONALDS * FEATHER RIVER BLVD/7TH A *  * FDTC1 *  * \n" +
        "IN DRIVETHRU         WHITE NISSAN 4DR     GREE",

        "UNIT:121",
        "ADDR:445 OROVILLE DAM BLVD E",
        "CITY:Oroville",
        "PLACE:MCDONALDS",
        "X:FEATHER RIVER BLVD/7TH A",
        "CODE:FDTC1",
        "CALL:IN DRIVETHRU",
        "INFO:WHITE NISSAN 4DR / GREE");

    doTest("T5",
        "(Dispatched Call (113)) 1751 OROVILLE DAM BLVD E, Oroville, CA * PAPACITOS * LINCOLN ST/MYERS ST * 14 * FDMED *  * BODY LYING NEXT TO TRACKS ON OVERPASS            ",
        "UNIT:113",
        "ADDR:1751 OROVILLE DAM BLVD E",
        "APT:14",
        "CITY:Oroville",
        "PLACE:PAPACITOS",
        "X:LINCOLN ST/MYERS ST",
        "CODE:FDMED",
        "CALL:BODY LYING NEXT TO TRACKS ON OVERPASS");

    doTest("T6",
        "(Dispatched Call (113)) 1218 POMONA AV, Oroville, CA *  * 3RD AV/VEATCH ST * 1 * FDMED *  * \nILL BABY",
        "UNIT:113",
        "ADDR:1218 POMONA AV",
        "MADDR:1218 POMONA AVE",
        "APT:1",
        "CITY:Oroville",
        "X:3RD AV/VEATCH ST",
        "CODE:FDMED",
        "CALL:ILL BABY");

    doTest("T7",
        "(Dispatched Call (113)) 1611 FEATHER RIVER BLVD, Oroville, CA * COMMUNITY COMPREHENSIVE-WOMENS * HIGH ST/POMONA AV * 10 * FDMED *  * Service Class: BUSN\n" +
        "high blood",

        "UNIT:113",
        "ADDR:1611 FEATHER RIVER BLVD",
        "APT:10",
        "CITY:Oroville",
        "PLACE:COMMUNITY COMPREHENSIVE-WOMENS",
        "X:HIGH ST/POMONA AV",
        "CODE:FDMED",
        "CALL:high blood");

    doTest("T8",
        "(Dispatched Call (121)) 2060 2ND ST, Oroville, CA * PROSPECT HIGH SCHOOL * GRAND AV/NELSON AV *  * FDMED *  * Service Class: CNTX\n" +
        "over medicated",

        "UNIT:121",
        "ADDR:2060 2ND ST",
        "CITY:Oroville",
        "PLACE:PROSPECT HIGH SCHOOL",
        "X:GRAND AV/NELSON AV",
        "CODE:FDMED",
        "CALL:over medicated");

    doTest("T9",
        "(Dispatched Call (121)) 1408 OROVILLE DAM BLVD W, Oroville, CA *  * 14TH ST/HARLAN AV *  * FDMED *  * ill fem",
        "UNIT:121",
        "ADDR:1408 OROVILLE DAM BLVD W",
        "CITY:Oroville",
        "X:14TH ST/HARLAN AV",
        "CODE:FDMED",
        "CALL:ill fem");

    doTest("T10",
        "(Dispatched Call (121)) 125 COTTONWOOD CIR, Oroville, CA *  * 5TH AV/MULBERRY DR * BLDG TRL * FDASSIST *  * Service Class: RESD\n" +
        "lift assist",

        "UNIT:121",
        "ADDR:125 COTTONWOOD CIR",
        "APT:BLDG TRL",
        "CITY:Oroville",
        "X:5TH AV/MULBERRY DR",
        "CODE:FDASSIST",
        "CALL:lift assist");

    doTest("T11",
        "(Dispatched Call (313)) OROVILLE BANGOR HWY/MYERS ST, Oroville, CA *  * MYERS ST *  * FDFIRE1 *  * VEH FIRE",
        "UNIT:313",
        "ADDR:OROVILLE BANGOR HWY & MYERS ST",
        "CITY:Oroville",
        "X:MYERS ST",
        "CODE:FDFIRE1",
        "CALL:VEH FIRE");

    doTest("T12",
        "(Dispatched Call (313)) 3020 GREENVILLE ST, Oroville, CA *  * LOWER WYANDOTTE RD/V-C R *  * FDMED *  * DIFF BREATHING",
        "UNIT:313",
        "ADDR:3020 GREENVILLE ST",
        "CITY:Oroville",
        "X:LOWER WYANDOTTE RD/V-C R",
        "CODE:FDMED",
        "CALL:DIFF BREATHING");

    doTest("T13",
        "(Dispatched Call (113)) 646 POMONA AV, Oroville, CA *  * 7TH AV/8TH AV *  * FDMED *  * 10-5 FORM CAL FIRE. ILL MALE, 3RD HAND REPORT OF MEDICAL ISSUE.",
        "UNIT:113",
        "ADDR:646 POMONA AV",
        "MADDR:646 POMONA AVE",
        "CITY:Oroville",
        "X:7TH AV/8TH AV",
        "CODE:FDMED",
        "CALL:10-5 FORM CAL FIRE. ILL MALE, 3RD HAND REPORT OF MEDICAL ISSUE.");

    doTest("T14",
        "(Dispatched Call (313)) 1825 FORT WAYNE ST, Oroville, CA *  * LINCOLN BLVD/LINCOLN BLVD *  * FDMED *  * SEIZURE",
        "UNIT:313",
        "ADDR:1825 FORT WAYNE ST",
        "CITY:Oroville",
        "X:LINCOLN BLVD/LINCOLN BLVD",
        "CODE:FDMED",
        "CALL:SEIZURE");

    doTest("T15",
        "(Dispatched Call (313)) 3106 LINCOLN BLVD, Oroville, CA * B & S COIN LAUNDRY * WYANDOTTE AV/A ST *  * FDMED *  * ALOC / GOLD SATURN",
        "UNIT:313",
        "ADDR:3106 LINCOLN BLVD",
        "CITY:Oroville",
        "PLACE:B & S COIN LAUNDRY",
        "X:WYANDOTTE AV/A ST",
        "CODE:FDMED",
        "CALL:ALOC / GOLD SATURN");

    doTest("T16",
        "(Dispatched Call (121)) 1735 MONTGOMERY ST, Oroville, CA * CITY HALL * OAK ST/LINCOLN ST *  * FDHAZMA1 *  * ",
        "UNIT:121",
        "ADDR:1735 MONTGOMERY ST",
        "CITY:Oroville",
        "PLACE:CITY HALL",
        "X:OAK ST/LINCOLN ST",
        "CODE:FDHAZMA1",
        "CALL:ALERT");

    doTest("T17",
        "(Dispatched Call (113)) 1735 MONTGOMERY ST, Oroville, CA * CITY HALL * OAK ST/LINCOLN ST *  * FDHAZMA1 *  * ",
        "UNIT:113",
        "ADDR:1735 MONTGOMERY ST",
        "CITY:Oroville",
        "PLACE:CITY HALL",
        "X:OAK ST/LINCOLN ST",
        "CODE:FDHAZMA1",
        "CALL:ALERT");

    doTest("T18",
        "(Dispatched Call (313)) 2262 LAS PLUMAS AV, Oroville, CA *  * LAS PLUMAS WAY/CRESTRIDG *  * FDMED *  * Service Class: RESD\n\n" +
        "ILL MALE",

        "UNIT:313",
        "ADDR:2262 LAS PLUMAS AV",
        "MADDR:2262 LAS PLUMAS AVE",
        "CITY:Oroville",
        "X:LAS PLUMAS WAY/CRESTRIDG",
        "CODE:FDMED",
        "CALL:ILL MALE");

    doTest("T19",
        "(Dispatched Call (113)) 1460 OLIVER ST, Oroville, CA * SHEAR ELEGANCE BEAUTY SALON * HIGH ST/ROBINSON ST *  * FDMED *  * \n\nFALL",
        "UNIT:113",
        "ADDR:1460 OLIVER ST",
        "CITY:Oroville",
        "PLACE:SHEAR ELEGANCE BEAUTY SALON",
        "X:HIGH ST/ROBINSON ST",
        "CODE:FDMED",
        "CALL:FALL");

    doTest("T20",
        "(Dispatched Call (313)) OROVILLE DAM BLVD E/CANYON DR, Oroville, CA *  * CANYON DR *  * FDTC1 *  * AUTO AID CAL FIRE",
        "UNIT:313",
        "ADDR:OROVILLE DAM BLVD E & CANYON DR",
        "CITY:Oroville",
        "X:CANYON DR",
        "CODE:FDTC1",
        "CALL:AUTO AID CAL FIRE");

    doTest("T21",
        "(Dispatched Call (313)) 5825 VISTA DEL CERRO, Oroville, CA *  * VIA LATON *  * FDMED *  * \nILL FEM",
        "UNIT:313",
        "ADDR:5825 VISTA DEL CERRO",
        "CITY:Oroville",
        "X:VIA LATON",
        "CODE:FDMED",
        "CALL:ILL FEM");

    doTest("T22",
        "(Dispatched Call (113)) WYANDOTTE AV/LINCOLN BLVD, Oroville, CA *  * LINCOLN BLVD *  * FDMED *  * Service Class: VOIP\n\n" +
        "FALL UNK INJURIES",

        "UNIT:113",
        "ADDR:WYANDOTTE AV & LINCOLN BLVD",
        "MADDR:WYANDOTTE AVE & LINCOLN BLVD",
        "CITY:Oroville",
        "X:LINCOLN BLVD",
        "CODE:FDMED",
        "CALL:FALL UNK INJURIES");

    doTest("T23",
        "(Dispatched Call (313)) 3070 MYERS ST, Oroville, CA * PIGGS CLUB * WYANDOTTE AV/A ST *  * FDMED *  * STAGE / ASSAULT / PD ENRT",
        "UNIT:313",
        "ADDR:3070 MYERS ST",
        "CITY:Oroville",
        "PLACE:PIGGS CLUB",
        "X:WYANDOTTE AV/A ST",
        "CODE:FDMED",
        "CALL:STAGE / ASSAULT / PD ENRT");

    doTest("T24",
        "(Dispatched Call (113)) 1000 EXECUTIVE PKWY, Oroville, CA * OLIVE RIDGE CARE HOME * MEDICAL CENTER DR * 101 A * FDMED *  * DIFF BREATHING",
        "UNIT:113",
        "ADDR:1000 EXECUTIVE PKWY",
        "APT:101 A",
        "CITY:Oroville",
        "PLACE:OLIVE RIDGE CARE HOME",
        "X:MEDICAL CENTER DR",
        "CODE:FDMED",
        "CALL:DIFF BREATHING");

    doTest("T25",
        "(Dispatched Call (113)) 825 GARDELLA AV, Oroville, CA *  * 5TH AV/6TH AV *  * FDMED *  * FALL",
        "UNIT:113",
        "ADDR:825 GARDELLA AV",
        "MADDR:825 GARDELLA AVE",
        "CITY:Oroville",
        "X:5TH AV/6TH AV",
        "CODE:FDMED",
        "CALL:FALL");

    doTest("T26",
        "(Dispatched Call (113)) 900 OROVILLE DAM BLVD E, Oroville, CA *  * 5TH AV/VEATCH ST *  * FDMED *  * Service Class: BUSN\n\n" +
        "DIFFICULTY BREATHING",

        "UNIT:113",
        "ADDR:900 OROVILLE DAM BLVD E",
        "CITY:Oroville",
        "X:5TH AV/VEATCH ST",
        "CODE:FDMED",
        "CALL:DIFFICULTY BREATHING");

    doTest("T27",
        "(Dispatched Call (121)) 1827 OROVILLE DAM BLVD E, Oroville, CA * ORO JEWELRY AND LOAN * LINCOLN ST/MYERS ST *  * FDTC1 *  * BLK HONDA GRY ESCORT ROADWAY IS CLEAR",
        "UNIT:121",
        "ADDR:1827 OROVILLE DAM BLVD E",
        "CITY:Oroville",
        "PLACE:ORO JEWELRY AND LOAN",
        "X:LINCOLN ST/MYERS ST",
        "CODE:FDTC1",
        "CALL:BLK HONDA GRY ESCORT ROADWAY IS CLEAR");

    doTest("T28",
        "(Dispatched Call (113)) 900 OROVILLE DAM BLVD E, Oroville, CA * COMMUNITY COMP CARE * 5TH AV/VEATCH ST *  * FDMED *  * Service Class: BUSN\n\n" +
        "SHORTNESS OF BREATH. I",

        "UNIT:113",
        "ADDR:900 OROVILLE DAM BLVD E",
        "CITY:Oroville",
        "PLACE:COMMUNITY COMP CARE",
        "X:5TH AV/VEATCH ST",
        "CODE:FDMED",
        "CALL:SHORTNESS OF BREATH. I");

    doTest("T29",
        "(Dispatched Call (313)) 2850 MYERS ST, Oroville, CA *  * ONTARIO AV/CORTO ST * 11 * FDMED *  * Service Class: RESD\n\n" +
        "FALL WITH INJURY",

        "UNIT:313",
        "ADDR:2850 MYERS ST",
        "APT:11",
        "CITY:Oroville",
        "X:ONTARIO AV/CORTO ST",
        "CODE:FDMED",
        "CALL:FALL WITH INJURY");

    doTest("T30",
        "(Dispatched Call (113)) 1911 OROVILLE DAM BLVD E, Oroville, CA * DOLLAR STORE * MYERS ST/BROWN AV *  * FDMED *  * \n\n" +
        "FEM W/ KNEE INJURY. FEM IS WEARING A GRN JACKET",

        "UNIT:113",
        "ADDR:1911 OROVILLE DAM BLVD E",
        "CITY:Oroville",
        "PLACE:DOLLAR STORE",
        "X:MYERS ST/BROWN AV",
        "CODE:FDMED",
        "CALL:FEM W/ KNEE INJURY. FEM IS WEARING A GRN JACKET");

    doTest("T31",
        "(Dispatched Call (121)) 3415 OROVILLE DAM BLVD E, Oroville, CA * WE LANDSCAPE * STANFORD AV/ACACIA AV * 114 * FDASSIST *  * \n" +
        "LIFT ASSIST, BACK BEDROOM",

        "UNIT:121",
        "ADDR:3415 OROVILLE DAM BLVD E",
        "APT:114",
        "CITY:Oroville",
        "PLACE:WE LANDSCAPE",
        "X:STANFORD AV/ACACIA AV",
        "CODE:FDASSIST",
        "CALL:LIFT ASSIST",
        "INFO:BACK BEDROOM");

    doTest("T32",
        "(Dispatched Call (113)) 1536 5TH AV, Oroville, CA *  * ROBINSON ST/HIGH ST *  * FDMED *  * Service Class: RESD\n\n" +
        "DIFFICULTY BREATHING",

        "UNIT:113",
        "ADDR:1536 5TH AV",
        "MADDR:1536 5TH AVE",
        "CITY:Oroville",
        "X:ROBINSON ST/HIGH ST",
        "CODE:FDMED",
        "CALL:DIFFICULTY BREATHING");

    doTest("T33",
        "(Dispatched Call (113)) 700 MITCHELL AV, Oroville, CA * WINSTON GARDENS * 5TH AV/3RD AV * 32 * FDMED *  * 92 YEAR OLD FEMALE 530-534-6512 VELMA MORRISON\n" +
        "CHEST PAIN",

        "UNIT:113",
        "ADDR:700 MITCHELL AV",
        "MADDR:700 MITCHELL AVE",
        "APT:32",
        "CITY:Oroville",
        "PLACE:WINSTON GARDENS",
        "X:5TH AV/3RD AV",
        "CODE:FDMED",
        "CALL:92 YEAR OLD FEMALE 530-534-6512 VELMA MORRISON",
        "INFO:CHEST PAIN");

    doTest("T34",
        "(Dispatched Call (121)) 2185 PERKINS AV, Oroville, CA *  * QUARTZ AV/MITCHELL AV *  * FDINVEST *  * Service Class: VOIP\n\n" +
        "SMOKE ALARM SOUNDING, RP DOES NOT SMELL S",

        "UNIT:121",
        "ADDR:2185 PERKINS AV",
        "MADDR:2185 PERKINS AVE",
        "CITY:Oroville",
        "X:QUARTZ AV/MITCHELL AV",
        "CODE:FDINVEST",
        "CALL:SMOKE ALARM SOUNDING",
        "INFO:RP DOES NOT SMELL S");

    doTest("T35",
        "(Dispatched Call (313)) 2930 GREENVILLE ST, Oroville, CA *  * BURLINGTON AV/V-C RD * 4 * FDMED *  * CHEST PAIN",
        "UNIT:313",
        "ADDR:2930 GREENVILLE ST",
        "APT:4",
        "CITY:Oroville",
        "X:BURLINGTON AV/V-C RD",
        "CODE:FDMED",
        "CALL:CHEST PAIN");

    doTest("T36",
        "(Dispatched Call (121)) 2588 OLIVE HWY, Oroville, CA * FLUFF & FOLD LAUNDRY * FAY WAY/FAY WAY * AB * FDMED *  * ILL MALE",
        "UNIT:121",
        "ADDR:2588 OLIVE HWY",
        "APT:AB",
        "CITY:Oroville",
        "PLACE:FLUFF & FOLD LAUNDRY",
        "X:FAY WAY/FAY WAY",
        "CODE:FDMED",
        "CALL:ILL MALE");

    doTest("T37",
        "(Dispatched Call (113)) TABLE MOUNTAIN BLVD/WASHINGTON A, Oroville, CA * GREEN BRIDGE * WASHINGTON AV *  * FDMED *  * ",
        "UNIT:113",
        "ADDR:TABLE MOUNTAIN BLVD & WASHINGTON A",
        "CITY:Oroville",
        "PLACE:GREEN BRIDGE",
        "X:WASHINGTON AV",
        "CODE:FDMED",
        "CALL:ALERT");

    doTest("T38",
        "(Dispatched Call (121)) 1017 BIRD ST, Oroville, CA * STEADFAST MANAGEMENT * 4TH AV/3RD AV *  * FDASSIST *  * 2 YR OLD LOCKED INSIDE RUNNING VEHICLE; HEATER ON HIGH",
        "UNIT:121",
        "ADDR:1017 BIRD ST",
        "CITY:Oroville",
        "PLACE:STEADFAST MANAGEMENT",
        "X:4TH AV/3RD AV",
        "CODE:FDASSIST",
        "CALL:2 YR OLD LOCKED INSIDE RUNNING VEHICLE; HEATER ON HIGH");

    doTest("T39",
        "(Dispatched Call (113)) 1000 EXECUTIVE PKWY, Oroville, CA * OLIVE RIDGE CARE HOME * MEDICAL CENTER DR * 109 * FDMED *  * Service Class: PBXb\n\n" +
        "UNRESPONSIVE",

        "UNIT:113",
        "ADDR:1000 EXECUTIVE PKWY",
        "APT:109",
        "CITY:Oroville",
        "PLACE:OLIVE RIDGE CARE HOME",
        "X:MEDICAL CENTER DR",
        "CODE:FDMED",
        "CALL:UNRESPONSIVE");

    doTest("T40",
        "(Dispatched Call (113)) MONTGOMERY ST/MYERS ST, Oroville, CA *  * MYERS ST *  * FDINVEST *  * ",
        "UNIT:113",
        "ADDR:MONTGOMERY ST & MYERS ST",
        "CITY:Oroville",
        "X:MYERS ST",
        "CODE:FDINVEST",
        "CALL:ALERT");

    doTest("T41",
        "(Dispatched Call (121)) 293 COLINA WAY, Oroville, CA *  * GOLD AVE *  * FDMED *  * MAN DOWN",
        "UNIT:121",
        "ADDR:293 COLINA WAY",
        "CITY:Oroville",
        "X:GOLD AVE",
        "CODE:FDMED",
        "CALL:MAN DOWN");

    doTest("T42",
        "(Dispatched Call (313)) 5280 SUZANNE CT, Oroville, CA *  * OAK KNOLL WAY *  * FDMED *  * Service Class: RESD\nBREATHING DIFF",
        "UNIT:313",
        "ADDR:5280 SUZANNE CT",
        "CITY:Oroville",
        "X:OAK KNOLL WAY",
        "CODE:FDMED",
        "CALL:BREATHING DIFF");

    doTest("T43",
        "(Dispatched Call (313)) 2606 OAK KNOLL WAY, Oroville, CA *  * V-E AV/SEACREST DR *  * FDMED *  * INJURIES FROM FALL",
        "UNIT:313",
        "ADDR:2606 OAK KNOLL WAY",
        "CITY:Oroville",
        "X:V-E AV/SEACREST DR",
        "CODE:FDMED",
        "CALL:INJURIES FROM FALL");

    doTest("T44",
        "(Dispatched Call (113)) 2329 MONTGOMERY ST, Oroville, CA * TASSIS HAIR & NAILS * ARLIN RHINE DR/WASHINGTO * 7 * FDMED *  * Service Class: VOIP\n\n" +
        "ILL FEMALE",

        "UNIT:113",
        "ADDR:2329 MONTGOMERY ST",
        "APT:7",
        "CITY:Oroville",
        "PLACE:TASSIS HAIR & NAILS",
        "X:ARLIN RHINE DR/WASHINGTO",
        "CODE:FDMED",
        "CALL:ILL FEMALE");

    doTest("T45",
        "(Dispatched Call (121)) 1601 MITCHELL AV, Oroville, CA * PACIFIC COAST PRODUCERS * PINE ST/W LINCOLN ST *  * FDINVEST *  * FIRE ALARM WATER FLOW FROM WAREHOUSE G N/",
        "UNIT:121",
        "ADDR:1601 MITCHELL AV",
        "MADDR:1601 MITCHELL AVE",
        "CITY:Oroville",
        "PLACE:PACIFIC COAST PRODUCERS",
        "X:PINE ST/W LINCOLN ST",
        "CODE:FDINVEST",
        "CALL:FIRE ALARM WATER FLOW FROM WAREHOUSE G N/");

    doTest("T46",
        "(Dispatched Call (121)) 2472 OROVILLE QUINCY HWY, Oroville, CA *  * MYRTLE DR/LINDA LOMA DR * B * FDINVEST *  * HOME AT REAR OF LOCATION.  CO2 DETECTOR.",
        "UNIT:121",
        "ADDR:2472 OROVILLE QUINCY HWY",
        "APT:B",
        "CITY:Oroville",
        "X:MYRTLE DR/LINDA LOMA DR",
        "CODE:FDINVEST",
        "CALL:HOME AT REAR OF LOCATION.",
        "INFO:CO2 DETECTOR.");

    doTest("T47",
        "(Dispatched Call (113)) 2750 LINCOLN BLVD, Oroville, CA * OROVILLE MANOR APARTMENTS * OROVILLE DAM BLVD E/PEAR * 105 * FDMED *  * Service Class: RESD\n\n" +
        "ILL FEMALE",

        "UNIT:113",
        "ADDR:2750 LINCOLN BLVD",
        "APT:105",
        "CITY:Oroville",
        "PLACE:OROVILLE MANOR APARTMENTS",
        "X:OROVILLE DAM BLVD E/PEAR",
        "CODE:FDMED",
        "CALL:ILL FEMALE");

    doTest("T48",
        "(Dispatched Call (113)) 505 MONTGOMERY ST, Oroville, CA * MOTEL 6 * EB HWY 70 OFFRAMP/EB HWY * 133 * FDMED *  * Service Class: V\n\n" +
        "ILL MALE",

        "UNIT:113",
        "ADDR:505 MONTGOMERY ST",
        "APT:133",
        "CITY:Oroville",
        "PLACE:MOTEL 6",
        "X:EB HWY 70 OFFRAMP/EB HWY",
        "CODE:FDMED",
        "CALL:ILL MALE");

    doTest("T49",
        "(Dispatched Call (113)) 2740 OROVILLE DAM BLVD E, Oroville, CA * TRICOUNTY TREATMENT * GILMORE LN/OROVILLE QUIN *  * FDMED *  * CHEST PAIN",
        "UNIT:113",
        "ADDR:2740 OROVILLE DAM BLVD E",
        "CITY:Oroville",
        "PLACE:TRICOUNTY TREATMENT",
        "X:GILMORE LN/OROVILLE QUIN",
        "CODE:FDMED",
        "CALL:CHEST PAIN");

    doTest("T50",
        "(Dispatched Call (313)) 5342 BECKY LN, Oroville, CA *  * CINDY CT/STUMP DR *  * FDMED *  * CHEST PAIN",
        "UNIT:313",
        "ADDR:5342 BECKY LN",
        "CITY:Oroville",
        "X:CINDY CT/STUMP DR",
        "CODE:FDMED",
        "CALL:CHEST PAIN");

    doTest("T51",
        "(Dispatched Call (313)) OLIVE HWY/KELLY RIDGE RD, Oroville, CA *  * KELLY RIDGE RD *  * FDTC1 *  * OLIVE IC ON CALCORD",
        "UNIT:313",
        "ADDR:OLIVE HWY & KELLY RIDGE RD",
        "CITY:Oroville",
        "X:KELLY RIDGE RD",
        "CODE:FDTC1",
        "CALL:OLIVE IC ON CALCORD");

    doTest("T52",
        "(Dispatched Call (313)) 5721 AUTREY LN, Oroville, CA *  * MONTE VISTA AV/VIA MADER *  * FDMED *  * CHEST PAIN",
        "UNIT:313",
        "ADDR:5721 AUTREY LN",
        "CITY:Oroville",
        "X:MONTE VISTA AV/VIA MADER",
        "CODE:FDMED",
        "CALL:CHEST PAIN");

    doTest("T53",
        "(Dispatched Call (313)) 3515 MYERS ST, Oroville, CA * EL MEDIO FIRE * D ST/ELGIN ST *  * FDMED *  * DIFFICULTY BREATHING",
        "UNIT:313",
        "ADDR:3515 MYERS ST",
        "CITY:Oroville",
        "PLACE:EL MEDIO FIRE",
        "X:D ST/ELGIN ST",
        "CODE:FDMED",
        "CALL:DIFFICULTY BREATHING");

    doTest("T54",
        "(Dispatched Call (113)) 60 HIGHLANDS BLVD, Oroville, CA *  * COVENTRY DR/ROCKRIDGE RD *  * FDMED *  * Service Class: VOIP\n" +
        "ILL FEMALE  POSSIBLE STROKE",

        "UNIT:113",
        "ADDR:60 HIGHLANDS BLVD",
        "CITY:Oroville",
        "X:COVENTRY DR/ROCKRIDGE RD",
        "CODE:FDMED",
        "CALL:ILL FEMALE",
        "INFO:POSSIBLE STROKE");

    doTest("T55",
        "(Dispatched Call (113)) 1454 14TH ST, Oroville, CA *  * FEATHER AV/GRAND AV *  * FDMED *  * \nDIFF BREATHING",
        "UNIT:113",
        "ADDR:1454 14TH ST",
        "CITY:Oroville",
        "X:FEATHER AV/GRAND AV",
        "CODE:FDMED",
        "CALL:DIFF BREATHING");

    doTest("T56",
        "(Dispatched Call (121)) 1454 14TH ST, Oroville, CA *  * FEATHER AV/GRAND AV *  * FDMED *  * \nDIFF BREATHING",
        "UNIT:121",
        "ADDR:1454 14TH ST",
        "CITY:Oroville",
        "X:FEATHER AV/GRAND AV",
        "CODE:FDMED",
        "CALL:DIFF BREATHING");

    doTest("T57",
        "(Dispatched Call (113)) 1215 5TH AV, Oroville, CA *  * SAFFORD ST/MONTGOMERY ST *  * FDMED *  * Service Class: RESD\n\nILL FEMALE",
        "UNIT:113",
        "ADDR:1215 5TH AV",
        "MADDR:1215 5TH AVE",
        "CITY:Oroville",
        "X:SAFFORD ST/MONTGOMERY ST",
        "CODE:FDMED",
        "CALL:ILL FEMALE");

    doTest("T58",
        "(Dispatched Call (313)) 2156 WYANDOTTE AV, Oroville, CA *  * BARNES WAY/FLORENCE AV *  * FDMED *  * Service Class: VOIP\n" +
        "ILL BABY  SIEZURES",

        "UNIT:313",
        "ADDR:2156 WYANDOTTE AV",
        "MADDR:2156 WYANDOTTE AVE",
        "CITY:Oroville",
        "X:BARNES WAY/FLORENCE AV",
        "CODE:FDMED",
        "CALL:ILL BABY",
        "INFO:SIEZURES");

    doTest("T59",
        "(Dispatched Call (313)) 2923 MYERS ST, Oroville, CA *  * ONTARIO AV/CORTO ST *  * FDMED *  * \n\nDIFFICULTY BREATHING",
        "UNIT:313",
        "ADDR:2923 MYERS ST",
        "CITY:Oroville",
        "X:ONTARIO AV/CORTO ST",
        "CODE:FDMED",
        "CALL:DIFFICULTY BREATHING");

    doTest("T60",
        "(Dispatched Call (121)) 1100 FEATHER RIVER BLVD, Oroville, CA * BEDROCK PARK * 5TH AV/SAFFORD ST *  * FDMED *  * \n\n" +
        "ILL FEM AT TENNIS COURTS",

        "UNIT:121",
        "ADDR:1100 FEATHER RIVER BLVD",
        "CITY:Oroville",
        "PLACE:BEDROCK PARK",
        "X:5TH AV/SAFFORD ST",
        "CODE:FDMED",
        "CALL:ILL FEM AT TENNIS COURTS");

    doTest("T61",
        "(Dispatched Call (113)) 2160 FEATHER RIVER BLVD, Oroville, CA * APPLEBEES * MITCHELL AV/OROVILLE DAM *  * FDTC1 *  * \n\n" +
        "NECK INJURY IN PARKING LOT\n" +
        "2 VEHS",

        "UNIT:113",
        "ADDR:2160 FEATHER RIVER BLVD",
        "CITY:Oroville",
        "PLACE:APPLEBEES",
        "X:MITCHELL AV/OROVILLE DAM",
        "CODE:FDTC1",
        "CALL:NECK INJURY IN PARKING LOT",
        "INFO:2 VEHS");

    doTest("T62",
        "(Dispatched Call (113)) 2055 LINCOLN ST, Oroville, CA * OROVILLE POLICE DEPARTMENT * HUNTOON ST/MITCHELL AV *  * TEST *  * TEST ONLY",
        "UNIT:113",
        "ADDR:2055 LINCOLN ST",
        "CITY:Oroville",
        "PLACE:OROVILLE POLICE DEPARTMENT",
        "X:HUNTOON ST/MITCHELL AV",
        "CODE:TEST",
        "CALL:TEST ONLY");

    doTest("T63",
        "(Dispatched Call (121)) 1875 FEATHER RIVER BLVD, Oroville, CA * OROVILLE GYMNASTICS ACADEMY * MITCHELL AV/OROVILLE DAM *  * FDMED *  * \n\n" +
        "NECK INJURY",

        "UNIT:121",
        "ADDR:1875 FEATHER RIVER BLVD",
        "CITY:Oroville",
        "PLACE:OROVILLE GYMNASTICS ACADEMY",
        "X:MITCHELL AV/OROVILLE DAM",
        "CODE:FDMED",
        "CALL:NECK INJURY");

    doTest("T64",
        "(Dispatched Call (113)) 1100 FEATHER RIVER BLVD, Oroville, CA * SKATE PARK * 5TH AV/SAFFORD ST *  * FDMED *  * \n" +
        "ANKLE INJURY  NEAR ENTRANCE",

        "UNIT:113",
        "ADDR:1100 FEATHER RIVER BLVD",
        "CITY:Oroville",
        "PLACE:SKATE PARK",
        "X:5TH AV/SAFFORD ST",
        "CODE:FDMED",
        "CALL:ANKLE INJURY",
        "INFO:NEAR ENTRANCE");

    doTest("T65",
        "(Dispatched Call (113)) 2719 MITCHELL AV, Oroville, CA *  * OROVILLE QUINCY HWY/BRID * 4 * FDMED *  * \n\nSEIZURE",
        "UNIT:113",
        "ADDR:2719 MITCHELL AV",
        "MADDR:2719 MITCHELL AVE",
        "APT:4",
        "CITY:Oroville",
        "X:OROVILLE QUINCY HWY/BRID",
        "CODE:FDMED",
        "CALL:SEIZURE");

    doTest("T66",
        "(Dispatched Call (113)) 2105 PARK AV, Oroville, CA * PARK PLACE APARTMENTS * PLACER LN/HEWITT AV * 6 * FDMED *  * Service Class: RESD\n\n" +
        "DIFFICULTY BREATHING",

        "UNIT:113",
        "ADDR:2105 PARK AV",
        "MADDR:2105 PARK AVE",
        "APT:6",
        "CITY:Oroville",
        "PLACE:PARK PLACE APARTMENTS",
        "X:PLACER LN/HEWITT AV",
        "CODE:FDMED",
        "CALL:DIFFICULTY BREATHING");

    doTest("T67",
        "(Dispatched Call (313)) 3245 COLUMBIA AV, Oroville, CA *  * A ST/B ST * A * FDMED *  * ILL FEMALE \n\nService Class: RESD",
        "UNIT:313",
        "ADDR:3245 COLUMBIA AV",
        "MADDR:3245 COLUMBIA AVE",
        "APT:A",
        "CITY:Oroville",
        "X:A ST/B ST",
        "CODE:FDMED",
        "CALL:ILL FEMALE");

    doTest("T68",
        "(Dispatched Call (113)) 505 MONTGOMERY ST, Oroville, CA * MOTEL 6 * EB HWY 70 OFFRAMP/EB HWY * 130 * FDMED *  * \n\nSEIZURE",
        "UNIT:113",
        "ADDR:505 MONTGOMERY ST",
        "APT:130",
        "CITY:Oroville",
        "PLACE:MOTEL 6",
        "X:EB HWY 70 OFFRAMP/EB HWY",
        "CODE:FDMED",
        "CALL:SEIZURE");

    doTest("T69",
        "(Dispatched Call (113)) 965 MONTGOMERY ST, Oroville, CA *  * 4TH AV/3RD AV *  * FDMED *  * ILL MALE.",
        "UNIT:113",
        "ADDR:965 MONTGOMERY ST",
        "CITY:Oroville",
        "X:4TH AV/3RD AV",
        "CODE:FDMED",
        "CALL:ILL MALE.");

    doTest("T70",
        "(Dispatched Call (313)) 3245 COLUMBIA AV, Oroville, CA *  * A ST/B ST * A * FDMED *  * Service Class: RESD\nILL FEMALE",
        "UNIT:313",
        "ADDR:3245 COLUMBIA AV",
        "MADDR:3245 COLUMBIA AVE",
        "APT:A",
        "CITY:Oroville",
        "X:A ST/B ST",
        "CODE:FDMED",
        "CALL:ILL FEMALE");

    doTest("T71",
        "(Dispatched Call (313)) WASHINGTON AV/OROVILLE DAM BLVD, Oroville, CA *  * OROVILLE DAM BLVD E *  * TE *  * ",
        "UNIT:313",
        "ADDR:WASHINGTON AV & OROVILLE DAM BLVD",
        "MADDR:WASHINGTON AVE & OROVILLE DAM BLVD",
        "CITY:Oroville",
        "X:OROVILLE DAM BLVD E",
        "CODE:TE",
        "CALL:ALERT");

    doTest("T72",
        "(Dispatched Call (121)) 2078 2ND ST, Oroville, CA *  * GRAND AV/NELSON AV *  * FDMED *  * POSS UNRESPONSIVE INFANT \n\n" +
        "Cellular E911 Call: \n" +
        "Lat:39.521556  Lon:-121",

        "UNIT:121",
        "ADDR:2078 2ND ST",
        "CITY:Oroville",
        "X:GRAND AV/NELSON AV",
        "CODE:FDMED",
        "CALL:POSS UNRESPONSIVE INFANT");

    doTest("T73",
        "(Dispatched Call (113)) 85 RANCHO VISTA DR, Oroville, CA * RANCHO VISTA APARTMENTS * GRAND AV * 12 * FDMED *  * \n" +
        "ILL FEMALE   DIFF BREATHING",

        "UNIT:113",
        "ADDR:85 RANCHO VISTA DR",
        "APT:12",
        "CITY:Oroville",
        "PLACE:RANCHO VISTA APARTMENTS",
        "X:GRAND AV",
        "CODE:FDMED",
        "CALL:ILL FEMALE",
        "INFO:DIFF BREATHING");

    doTest("T74",
        "(Dispatched Call (313)) 3245 COLUMBIA AV, Oroville, CA *  * A ST/B ST * A * FDMED *  * Service Class: RESD\n" +
        "ILL FEMALE BREATHING DIFF   DOOR OPEN",

        "UNIT:313",
        "ADDR:3245 COLUMBIA AV",
        "MADDR:3245 COLUMBIA AVE",
        "APT:A",
        "CITY:Oroville",
        "X:A ST/B ST",
        "CODE:FDMED",
        "CALL:ILL FEMALE BREATHING DIFF",
        "INFO:DOOR OPEN");

    doTest("T75",
        "(Dispatched Call (313)) 3010 MYERS ST, Oroville, CA * ROBERTS DRUG STORE * CORTO ST/WYANDOTTE AV *  * FDMED *  * Service Class: BUSN\n" +
        "UNCONSCIOUS FEMALE",

        "UNIT:313",
        "ADDR:3010 MYERS ST",
        "CITY:Oroville",
        "PLACE:ROBERTS DRUG STORE",
        "X:CORTO ST/WYANDOTTE AV",
        "CODE:FDMED",
        "CALL:UNCONSCIOUS FEMALE");

    doTest("T76",
        "(Dispatched Call (313)) 2167 B ST, Oroville, CA *  * SPENCER AV/ROSEBEN AV *  * FDMED *  * \n\nILL FEMALE",
        "UNIT:313",
        "ADDR:2167 B ST",
        "CITY:Oroville",
        "X:SPENCER AV/ROSEBEN AV",
        "CODE:FDMED",
        "CALL:ILL FEMALE");

    doTest("T77",
        "(Dispatched Call (113)) 974 MONTGOMERY ST, Oroville, CA *  * 4TH AV/3RD AV * 1 * FDMED *  * ",
        "UNIT:113",
        "ADDR:974 MONTGOMERY ST",
        "APT:1",
        "CITY:Oroville",
        "X:4TH AV/3RD AV",
        "CODE:FDMED",
        "CALL:ALERT");

    doTest("T78",
        "(Dispatched Call (113)) 85 RANCHO VISTA DR, Oroville, CA * RANCHO VISTA APARTMENTS * GRAND AV * 34 * FDMED *  * Service Class: RESD\n\n" +
        "APARTMENT CLOSEST TO RIO VIST",

        "UNIT:113",
        "ADDR:85 RANCHO VISTA DR",
        "APT:34",
        "CITY:Oroville",
        "PLACE:RANCHO VISTA APARTMENTS",
        "X:GRAND AV",
        "CODE:FDMED",
        "CALL:APARTMENT CLOSEST TO RIO VIST");

    doTest("T79",
        "(Dispatched Call (313)) EL NOBLE AV/MESA AV, Oroville, CA *  * MESA AV *  * FDHAZD3 *  * BROKEN FIRE HYDRANTE",
        "UNIT:313",
        "ADDR:EL NOBLE AV & MESA AV",
        "MADDR:EL NOBLE AVE & MESA AVE",
        "CITY:Oroville",
        "X:MESA AV",
        "CODE:FDHAZD3",
        "CALL:BROKEN FIRE HYDRANTE");

    doTest("T80",
        "(Dispatched Call (113)) 1 GILMORE LN, Oroville, CA * SHADOWBROOK HEALTH CARE * OROVILLE DAM BLVD E/MEDI * 19 * FDMED *  * bed 2 chest pain",
        "UNIT:113",
        "ADDR:1 GILMORE LN",
        "APT:19",
        "CITY:Oroville",
        "PLACE:SHADOWBROOK HEALTH CARE",
        "X:OROVILLE DAM BLVD E/MEDI",
        "CODE:FDMED",
        "CALL:bed 2 chest pain");

    doTest("T81",
        "(Dispatched Call (313)) 55 CONCORDIA LN, Oroville, CA * COUNTRY CREST * EDGEWOOD DR * 209 * FDMED *  * ALTERED LOC",
        "UNIT:313",
        "ADDR:55 CONCORDIA LN",
        "APT:209",
        "CITY:Oroville",
        "PLACE:COUNTRY CREST",
        "X:EDGEWOOD DR",
        "CODE:FDMED",
        "CALL:ALTERED LOC");

    doTest("T82",
        "(Dispatched Call (113)) 2053 OROVILLE BANGOR HWY, Oroville, CA *  * LINCOLN BLVD/SPENCER AV *  * FDMED *  * \n\nILL MALE",
        "UNIT:113",
        "ADDR:2053 OROVILLE BANGOR HWY",
        "CITY:Oroville",
        "X:LINCOLN BLVD/SPENCER AV",
        "CODE:FDMED",
        "CALL:ILL MALE");

    doTest("T83",
        "(Dispatched Call (114)) 2053 OROVILLE BANGOR HWY, Oroville, CA *  * LINCOLN BLVD/SPENCER AV *  * FDMED *  * \n\nILL MALE",
        "UNIT:114",
        "ADDR:2053 OROVILLE BANGOR HWY",
        "CITY:Oroville",
        "X:LINCOLN BLVD/SPENCER AV",
        "CODE:FDMED",
        "CALL:ILL MALE");

    doTest("T84",
        "(Dispatched Call (313)) 28 REGENT LOOP, Oroville, CA *  * MONTE VISTA AV *  * FDMED *  * AUTO MEDICAL",
        "UNIT:313",
        "ADDR:28 REGENT LOOP",
        "CITY:Oroville",
        "X:MONTE VISTA AV",
        "CODE:FDMED",
        "CALL:AUTO MEDICAL");

    doTest("T85",
        "(Dispatched Call (114)) 1980 MOUNTAIN VISTA DR, Oroville, CA *  * CREST DR *  * FDMED *  * ALTERED LOC",
        "UNIT:114",
        "ADDR:1980 MOUNTAIN VISTA DR",
        "CITY:Oroville",
        "X:CREST DR",
        "CODE:FDMED",
        "CALL:ALTERED LOC");

    doTest("T86",
        "(Dispatched Call (121)) 18 COVENTRY DR, Oroville, CA *  * PARKWOOD DR/LINDA DR *  * FDASSIST *  * Service Class: RESD\nLIFT ASSIST",
        "UNIT:121",
        "ADDR:18 COVENTRY DR",
        "CITY:Oroville",
        "X:PARKWOOD DR/LINDA DR",
        "CODE:FDASSIST",
        "CALL:LIFT ASSIST");
   
  }
  
  @Test
  public void testElMedioFireDistrict() {

    doTest("T1",
        "(Dispatched Call (114)) 974 MONTGOMERY ST, Oroville, CA *  * 4TH AV/3RD AV * 2 * FDMED *  * #130819101 * \n\nABDOMINAL PAIN\n\n",
        "UNIT:114",
        "ADDR:974 MONTGOMERY ST",
        "CITY:Oroville",
        "X:4TH AV/3RD AV",
        "APT:2",
        "CODE:FDMED",
        "ID:130819101",
        "CALL:ABDOMINAL PAIN");
 
  }
  
  public static void main(String[] args) {
    new CAOrovilleParserTest().generateTests("T1");
  }
}