package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Kent County, DE (Variant B)
Contact: jeffrey morris <bowers4015@gmail.com>
Contact: Adam Warner <awarner7777@gmail.com>
Contact: Mark Hall <markhall285@gmail.com>
Contact: Kevin Sipple <kevin.sipple@verizon.net>
Sender: msg@cfmsg.com
System: Aegis CAD

(Chief ALT) [40 EMS] - 26A10 - Sick Person - Unwell/Ill -- 2536 Skeeter Neck Rd, Frederica -- Xst's: Bowers Beach Rd / E Front St -- Caller: High Vue Logging Inc
(Chief ALT) [KCPS] - [911, Kent] NWS UPGRADED LAST TO A WARNING, WILL BE IN WESTERN KENT COUNTY AROUND 22:30 HRS.
(Chief ALT) [40 EMS] - 23C1V - Overdose/Poisoning -- 181 Holly Dr, Frederica -- High Point Mhp -- Xst's: Garden Pl / Maple Dr -- Caller: Marrillo Paul
(Chief ALT) [55 EMS 1] - 2D2 - Allergic Reaction -- 149 Juanita Dr, Magnolia -- London Village -- Xst's: Jeffrey Dr / Millchop Ln -- Caller: Price Laura
(Chief ALT) [40 EMS] - 29B4 - MVC Unknown -- Mulberrie Point Rd, Frederica
(Chief ALT) [40 EMS] - 10D2 - Chest Pains -- 196 N  Bayshore Dr, Frederica -- Bowers Beach -- Xst's: N Flack Ave / Main St -- Caller: Margaret
(Chief ALT) [40 EMS] - 26C2 - Sick Person -- 201 Hubbard Ave, Frederica -- Bowers Beach -- Xst's: Dead End / Canal St -- Caller: Ingle Heather
(Chief ALT) [40 EMS] - 10C4 - Chest Pains -- 302 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Second St, Sycamore Dr / Lorna Ln -- Caller: Thom Ronald
(Chief ALT) [40 EMS] - 6C1 - Breathing Problems -- 294 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Kiwi Ct / Kylie Ln -- Caller: Hurd Shirley
(Chief ALT) [40 Fire] - 17A2 - Falls - Non-Recent -- 254 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Tyson Ln / Ibis Ct -- Caller: Spink Kimberley
(Chief ALT) [40 Fire] - Outside Fire-Unknown 2124 BOWERS BEACH RD, Frederica -- Xst's: Grm Dr / Whitwell Delight Rd
(Chief ALT) [46 Fire] -- Alarms-High Life Hazard -- APT-WHITEOAK APTS -- 1001 Whiteoak Rd Dover - Cross Sts: N Halsey R - Caller:GRIER, KIEASHA
(Chief ALT) [48 Fire] - Outside Fire-Small -- : 121 Allan Ave :, Felton -- Mount Vernon Estates -- Xst's: Kings Ln / Mount Vernon Dr -- Caller: Steff Diane
(Chief ALT) [48 Fire] - 29D5 - MVC Not Alert -- : 837 Equitation Ln :, Felton -- Xst's: Jump School House Rd / Holly Spring Rd -- Caller: Bright Pam

Contact:Active911
[Chief ALT] [46 Fire] -- Stand-By,Cover-up -- 110 Firehouse Ln Marydel - Cross Sts: Strauss Av\n
[Chief ALT] [46 Fire] -- Outside Fire-Small -- Wolf Creek Blvd/ Glenda Rd Dover - Cross Sts: None\n
[Chief ALT] [46 Fire] -- Stand-By,Cover-up -- 2898 Arthursville Rd Hartly - Cross Sts: Main St\n Everetts Corner R Cross St2: Main St\n Everetts\n
[Chief ALT] [46 Fire] -- Structure-Commercial -- 1481 N Dupont Hwy Dover - Cross Sts: W Rustic L - Caller:HILL, ANTONETTE\n
[Chief ALT] [46 Fire] -- Alarms-Residential (single) -- 40 Saulsbury Rd Dover - Cross Sts: Carver R\n
[Chief ALT] [46 Fire] -- Outside Fire-Field,Grass,Woods -- 1365 N Dupont Hwy Dover - Cross Sts: Dover Mal - Caller:dfd\n
[Chief ALT] [46 Fire] -- 29D2L MVC Motorcycle/Bicycle -- 1131 N Dupont Hwy Dover - Cross Sts: Unknow - Caller:CODY\n
[Chief ALT] [46 Fire] -- 29B4 MVC Unknown -- College Rd/ Mckee Rd Dover - Cross Sts: None - Caller:JAKE\n
[Chief ALT] [46 Fire] -- Electrical Hazard-Arcing -- 1001 Forrest Ave Dover - Cross Sts: Saulsbury Rd\n Forest S Cross St2: Saulsbury\n
[Chief ALT] [46 Fire] -- Fuel Spill (Small) -- 411 S Queen St Dover - Cross Sts: Dupont S\n
[Chief ALT] [46 Fire] -- Alarms CO-Residential (single) -- 39 Kentwood Dr Dover - Cross Sts: Bismark D\n
[Chief ALT] [46 Fire] -- Outside Fire-Small -- 1368 Rose Valley School Rd Dover - Cross Sts: Unknow\n
[Chief ALT] [46 Fire] -- Search -- 1200 N Dupont Hwy Dover - Cross Sts: College R - Caller:DFD\n
[Chief ALT] [46 Fire] -- 6D1 Breathing Problems -- 14 Fair Wind Pl Dover - Cross Sts: Bay Tree R - Caller:LUKE\n
[Chief ALT] [46 Fire] -- Outside Fire-Small -- 100 Haman Dr Dover - Cross Sts: Kesselring Av - Caller:TORRES, DIANNA\n
[Chief ALT] [46 Fire] -- Outside Fire-Small -- 217 Rose Valley School Rd Dover - Cross Sts: Hazlettville R - Caller:KWNTCOM\n
[Chief ALT] [46 Fire] -- Vehicle Fire -- 439 Phoenix Dr Dover - Cross Sts: Santa Fe D - Caller:RILEY, EDEDE, E\n
[Chief ALT] [46 Fire] -- Outside Fire-Small -- 75 Quail Hollow Dr Dover - Cross Sts: Village D - Caller:AUSTIN, THERESA\n
[Chief ALT] [46 Fire] -- Alarms-Residential (single) -- 868 Woodcrest Dr Dover - Cross Sts: Woodcrest Tur - Caller:DFD\n
[Chief ALT] [46 Fire] -- Outside Fire-Small -- State Hwy 1  - Cross Sts: None - Caller:BAER, BRETT\n
[Chief ALT] [46 Fire] -- Structure-Residential Single -- 880 Buttner Pl Dover - Cross Sts: Dead En\n
[Chief ALT] [46 Fire] -- Alarms-Commercial -- 800 Otis Dr Dover - Cross Sts: Fowler C - Caller:DFD\n
[Chief ALT] [46 Fire] -- Fuel Spill (Small) -- KENT CO COURT HOUSE -- 414 Federal St Dover - Cross Sts: William Penn S - Caller:SHANER, DISPATCHER\n
[Chief ALT] [46 Fire] -- Alarms-High Life Hazard -- LUTHER VILLAGE 1, LUTHER VILLAGE 2 -- 101 Babb Dr Dover - Cross Sts: Nob Hill R\n
[Chief ALT] [46 Fire] -- Alarms-Commercial -- COMPASSIONATE PAIN MANAGEMENT -- 740 S New St Dover - Cross Sts: South S - Caller:44, DES\n
[Chief ALT] [46 Fire] -- Alarms-Residential (multiple) -- APT-PINE GROVE APTS -- 255 Webbs Ln Dover - Cross Sts: John Clark Rd\n Mayberry L Cross St2: John Clark R - Caller:DFD\n
[Chief ALT] [46 Fire] -- Alarms-High Life Hazard -- SILVER LAKE CENTER -- 1080 Silver Lake Blvd Dover - Cross Sts: Unknow - Caller:DFD\n
[Chief ALT] [46 Fire] -- Alarms-Commercial -- 22 The Green Dover - Cross Sts: Bank L - Caller:DFD\n
[Chief ALT] [46 Fire] -- Alarms-Commercial -- CHRIST CHURCH -- 501 S State St Dover - Cross Sts: W Water St\n Water S Cross St2: W Water S - Caller:DFD\n
[Chief ALT] [46 Fire] -- Alarms-Commercial -- 800 Otis Dr Dover - Cross Sts: Fowler C - Caller:DFD\n
[Chief ALT] [46 Fire] -- Alarms-Residential (single) -- 281 Sheffield Dr Dover - Cross Sts: Norwich Wa - Caller:ADT\n
[Chief ALT] [46 Fire] -- Structure-Mobile Home/Trailer -- 243 Kentwood Dr Dover - Cross Sts: Phoenix D - Caller:SHANON\n

Contact: Active911
Agency name: American Legion Ambulance Service Sta. 64 Location: Smyrna, DE 
Sender: 3022415352@mms.att.net
- 32B2 - Medic Alert 289 INDIA DR , Smyrna: Xst's: HOFFECKER'S MILL DR / LAMBERTA FARM DR Caller:alert, life 
- 17B1G Falls - Possibly Dangerous 5500 DU PONT PKWY , Smyrna: SMYRNA REST AREA Xst's: UNKNOWN / S EXIT 119B OFF RAMP RD S EXIT 119 ON RAMP RD Caller:CLARK, SAM 

Contact: Active911
Agency name: Felton Community Fire Company Inc.
Location: Felton, DE, United States

(Chief ALT) [48 EMS1] - 6D2 - Breathing Problems -- 266 Lake Cove Ln, Felton -- Lakewind -- Xst's: Windward Dr / Pine Needle Dr -- Caller: Doughty Graeme\r\n\r\n
(Chief ALT) [48 EMS1] - 23B1I - Overdose/Poisoning -- 221 E  Sewell St, Felton -- Xst's: Nile St / East St -- Caller: Kerry\r\n\r\n
(Chief ALT) [48 EMS1] - 26C1 - Sick Person -- 562 Irish Hill Rd, Felton -- Stag Crossing -- Xst's: Blaine Dr / Canterbury Rd -- Caller: Jennifer\r\n\r\n
(Chief ALT) [48 EMS1] - 12D2 - Seizure -- 987 Andrews Lake Rd, Felton -- Xst's: Canterbury Rd / Yoemans Tale Ln -- Caller: Sheeter Wendolyn\r\n\r\n
(Chief ALT) [48 EMS1] - 9E2 - Cardiac Arrest - Agonal -- 709 Peach Basket Rd, Felton -- Xst's: Tomahawk Ln / Walnut St -- Caller: Mifflin Wanda\r\n\r\n
(Chief ALT) [48 EMS1] - Unit:A48 Status:At Scene Citizen Assist/Service Call  280 GAREY DR  Venue: Felton Dev/Sub: Xst's: DEAD END / BURNITE MILL RD Caller:\r\n\r\n
(Chief ALT) [48 EMS1] - 26D1 - Sick Person - Not Alert -- 5612 Burnite Mill Rd, Felton -- Xst's: Black Swamp Rd / Chandlers Rd -- Caller: Pinder Teresa\r\n\r\n

Contact: Active911
Agency name: Bowers Fire Company Inc. Sta. 40
Location: Frederica, DE, United States
Sender: msg@cfmsg.com

(Chief ALT) [40 EMS] - 23B1V - Overdose/Poisoning -- 62 Sycamore Dr, Frederica -- High Point Mhp -- Xst's: Second St, Front St / Lake Shore Dr, Second St -- Caller: Diamond Angel\r\n\r\n
(Chief ALT) [40 EMS] - 5A1 - Back Pain - Non -Traumatic -- 90 N  Bayshore Dr, Frederica -- Bowers Beach -- Xst's: Main St / N Flack Ave -- Caller: Pat Reitmeyer\r\n\r\n
(Chief ALT) [40 EMS] - 9B1A - Obvious Death -- 320 N  Flack Ave, Frederica -- Bowers Beach -- Xst's: Dead End / N Bayshore Dr -- Caller: Foley Lawrence\r\n\r\n
(Chief ALT) [40 EMS] - 6D2 - Breathing Problems -- 55 Williams Ave, Frederica -- Bowers Beach -- Xst's: Unknown / Main St -- Caller: Cubbage Kathryn\r\n\r\n
(Chief ALT) [40 EMS] - 18C2 - Headache -- 2859 Skeeter Neck Rd, Frederica -- Xst's: Eastwood Manor Dr / Bay Rd -- Caller: Harris Sandra\r\n\r\n
(Chief ALT) [40 EMS] - 6D2 - Breathing Problems -- 217 E Poplar St, Frederica -- Bakers Choice -- Xst's: E 2nd St / E Front St -- Caller: Hill Sheila\r\n\r\n
(Chief ALT) [40 EMS] - 5A1 - Back Pain - Non -Traumatic -- 371 Mark St, Frederica -- High Point Mhp -- Xst's: Dead End / West Dr, David St -- Caller: Melvin Georgia\r\n\r\n
(Chief ALT) [40 EMS] - 29B4 - MVC Unknown -- 7232 Carpenter Bridge Rd, Felton -- Xst's: No Cross Streets Found -- Caller: 4015\r\n\r\n
(Chief ALT) [40 Fire] - Alarms CO-Residential (single) -- 3044 Main St, Frederica -- Bowers Beach -- Xst's: Bowers Beach Rd / Cedar Ave\r\n\r\n
(Chief ALT) [40 EMS] - 10D4 - Chest Pains - Clammy -- 392 Jeffery St, Frederica -- High Point Mhp -- Xst's: No Cross Streets Found -- Caller: Helwig Tammy\r\n\r\n
(Chief ALT) [40 Fire] - 26C2 - Sick Person -- 79 Sycamore Dr, Frederica -- High Point Mhp -- Xst's: Lake Shore Dr, Second St / Second St, Front St -- Caller: Desiney Stevens\r\n\r\n
(Chief ALT) [40 EMS] - 17B3G - Falls - Unknown -- 2106 Reynolds Rd, Milford -- Xst's: Pritchett Rd / Paris Kirby Rd -- Caller: Abbott Gary\r\n\r\n
(Chief ALT) [40 Fire] - Water Rescue -- 40 Delaware Bay Bay- 40 District, Frederica -- Xst's: No Cross Streets Found\r\n\r\n
(Chief ALT) [40 EMS] - Water Rescue -- 40 Delaware Bay Bay- 40 District, Frederica -- Xst's: No Cross Streets Found\r\n\r\n
(Chief ALT) [40 EMS] - 5A1 - Back Pain - Non -Traumatic -- 220 S  Market St, Frederica -- Xst's: St Agnes St / Frederica Rd -- Caller: Officer 49\r\n\r\n
(Chief ALT) [40 EMS] - Non-Emergency Transport -- 21 W  Clarke Ave Mmh, Milford -- Xst's: Polk Ave / Plum St -- Caller: 40-41\r\n\r\n
(Chief ALT) [40 EMS] - 17A1G - Falls - Not Dangerous -- 555 Frederica Rd, Frederica -- Xst's: Waterway Dr / S Market St -- Caller: Life Link\r\n\r\n
(Chief ALT) [40 EMS] - Drill 124 FRONT ST LAKE FOREST EAST, Frederica -- Xst's: Frog Leg Ln / Johnny Cake Landing Rd -- Caller: 49-15\r\n\r\n
(Chief ALT) [40 EMS] - Drill 40 DELAWARE BAY BAY- 40 DISTRICT, Frederica -- Xst's: No Cross Streets Found -- Caller: 40-16\r\n\r\n
(Chief ALT) [40 Fire] - Drill 40 DELAWARE BAY BAY- 40 DISTRICT, Frederica -- Xst's: No Cross Streets Found -- Caller: 40-16\r\n\r\n
(Chief ALT) [40 EMS] - 26A4 - Sick Person - Fever -- 67 Ruyter Dr, Frederica -- Riverview Estates -- Xst's: Mcginnis Pond Rd / Marcel Ave -- Caller: Whitelock Jonathan\r\n\r\n
(Chief ALT) [40 EMS] - 10C2 - Chest Pains -- 108 Franklin St, Frederica -- Xst's: Darby Ave / St Agnes St -- Caller: Macklin Bertha\r\n\r\n
(Chief ALT) [40 EMS] - 18C4 - Headache - Sudden Onset -- 2268 Bowers Beach Rd, Frederica -- Xst's: Grm Dr / Whitwell Delight Rd -- Caller: Ross\r\n\r\n
(Chief ALT) [40 EMS] - 12A1 - Seizure -- 111 Bowers Beach Rd, Frederica -- Xst's: E Poplar St / Bay Rd -- Caller: Plumbing Dominici\r\n\r\n
(Chief ALT) [40 EMS] - 13A1 - Diabetic - Alert -- 3256 Main St, Frederica -- Bowers Beach -- Xst's: Church St / Davidson St -- Caller: 40 Sta\r\n\r\n
(Chief ALT) [40 EMS] - 6D2 - Breathing Problems -- 333 Jean Bradley Cir, Frederica -- High Point Mhp -- Xst's: West Dr / Lake Shore Dr -- Caller: Pitner Stanley\r\n\r\n
(Chief ALT) [40 EMS] - 17B1G - Falls - Possibly Dangerous -- 1491 Frederica Rd, Frederica -- Xst's: Front St, E Front St / N Market St -- Caller: Hurley Ashley\r\n\r\n
(Chief ALT) [40 Fire] - 29B1 - MVC Injuries -- 158 Clapham Rd, Frederica -- Xst's: High Point Park / Mulberrie Point Rd\r\n\r\n
(Chief ALT) [40 EMS] - 29B1 - MVC Injuries -- 158 Clapham Rd, Frederica -- Xst's: High Point Park / Mulberrie Point Rd\r\n\r\n
(Chief ALT) [40 EMS] - 1A1 - Abdominal Pains -- 113 Lea Ave, Frederica -- Riverview Estates -- Xst's: Marcel Ave / Christensen Way -- Caller: Stiller\r\n\r\n
(Chief ALT) [40 Fire] - Structure-Mobile Home/Trailer -- 1424 Frederica Rd, Frederica -- Xst's: David St / S Market St -- Caller: Pickle Shawn\r\n\r\n
(Chief ALT) [40 EMS] - 26A3 - Sick Person - Dizziness -- 321 Jean Bradley Cir, Frederica -- High Point Mhp -- Xst's: West Dr / Lake Shore Dr -- Caller: Faulkner Deborah\r\n\r\n
(Chief ALT) [40 EMS] - Unit:A40 Status:At Scene 26A1 Sick Person 3285 MAIN ST STATION 40 Venue: Frederica Dev/Sub: BOWERS BEACH Xst's: DAVIDSON ST / CHURCH ST Caller: 40 STATION\r\n\r\n
(Chief ALT) [40 EMS] - Unit:A40 Status:At Scene 26A1 Sick Person 1131 N DUPONT HWY NORTH FIRST AID DIS - NORTH FIRST AID Venue: Dover Dev/Sub: DOVER DOWNS Xst's: UNKNOWN / DOVER DOWNS Caller: A40\r\n\r\n
(Chief ALT) [40 EMS] - EMS Stand-by 1131 N DUPONT HWY FAN CARE CENTER DIS - OUTSIDE FIRST AID, Dover -- Dover Downs -- Xst's: Unknown / Dover Downs -- Caller: Ec24\r\n\r\n
(Chief ALT) [40 EMS] - 10C1 - Chest Pains -- 3285 Main St Station 40, Frederica -- Bowers Beach -- Xst's: Davidson St / Church St -- Caller: 40 Station\r\n\r\n
(Chief ALT) [40 EMS] - Unit:A40 Status:At Scene EMS Stand-by 1131 N  DUPONT HWY DIS - SPEEDWAY Venue: Dover Dev/Sub: DOVER DOWNS Xst's: UNKNOWN / DOVER DOWNS Caller:\r\n\r\n
(Chief ALT) [40 EMS] - 29B1 - MVC Injuries -- 11102 S Dupont Hwy, Felton -- Xst's: Unknown / S Erin Ave -- Caller: Clark Charles \r\n\r\nTHIS IS A TEST!!!!\r\n
(Chief ALT) [40 EMS] - 29B1 - MVC Injuries -- 11102 S  Dupont Hwy, Felton -- Xst's: Unknown / S Erin Ave -- Caller: Clark Charles\r\n\r\n
(Chief ALT) [40 EMS] - 19D2 - Heart Problems -- 2284 Bowers Beach Rd, Frederica -- Xst's: Grm Dr / Whitwell Delight Rd -- Caller: Henry\r\n\r\n
(Chief ALT) [40 EMS] - 26C2 - Sick Person -- 134 Maple Dr, Frederica -- High Point Mhp -- Xst's: Willow Dr / Willow Dr, Garden Pl\r\n\r\n
(Chief ALT) [40 EMS] - 29B1A - MVC Multiple Injuries -- Scrap Tavern Rd, Felton -- Caller: Gunning Fran\r\n\r\n

 */

public class DEKentCountyBParserTest extends BaseParserTest {
  
  public DEKentCountyBParserTest() {
    setParser(new DEKentCountyBParser(), "KENT COUNTY", "DE");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Chief ALT) [40 EMS] - 26A10 - Sick Person - Unwell/Ill -- 2536 Skeeter Neck Rd, Frederica -- Xst's: Bowers Beach Rd / E Front St -- Caller: High Vue Logging Inc",
        "SRC:40 EMS",
        "CODE:26A10",
        "CALL:Sick Person - Unwell/Ill",
        "ADDR:2536 Skeeter Neck Rd",
        "CITY:Frederica",
        "X:Bowers Beach Rd / E Front St",
        "NAME:High Vue Logging Inc");

    doTest("T2",
        "(Chief ALT) [KCPS] - [911, Kent] NWS UPGRADED LAST TO A WARNING, WILL BE IN WESTERN KENT COUNTY AROUND 22:30 HRS.",
        "SRC:KCPS",
        "CALL:GENERAL ALERT",
        "PLACE:[911, Kent] NWS UPGRADED LAST TO A WARNING, WILL BE IN WESTERN KENT COUNTY AROUND 22:30 HRS.");

    doTest("T3",
        "(Chief ALT) [40 EMS] - 23C1V - Overdose/Poisoning -- 181 Holly Dr, Frederica -- High Point Mhp -- Xst's: Garden Pl / Maple Dr -- Caller: Marrillo Paul",
        "SRC:40 EMS",
        "CALL:23C1V - Overdose/Poisoning",
        "ADDR:181 Holly Dr",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "X:Garden Pl / Maple Dr",
        "NAME:Marrillo Paul");

    doTest("T4",
        "(Chief ALT) [55 EMS 1] - 2D2 - Allergic Reaction -- 149 Juanita Dr, Magnolia -- London Village -- Xst's: Jeffrey Dr / Millchop Ln -- Caller: Price Laura",
        "CODE:2D2",
        "SRC:55 EMS 1",
        "CALL:Allergic Reaction",
        "ADDR:149 Juanita Dr",
        "CITY:Magnolia",
        "PLACE:London Village",
        "X:Jeffrey Dr / Millchop Ln",
        "NAME:Price Laura");

    doTest("T5",
        "(Chief ALT) [40 EMS] - 29B4 - MVC Unknown -- Mulberrie Point Rd, Frederica",
        "SRC:40 EMS",
        "CODE:29B4",
        "CALL:MVC Unknown",
        "ADDR:Mulberrie Point Rd",
        "CITY:Frederica");

    doTest("T6",
        "(Chief ALT) [40 EMS] - 10D2 - Chest Pains -- 196 N  Bayshore Dr, Frederica -- Bowers Beach -- Xst's: N Flack Ave / Main St -- Caller: Margaret",
        "SRC:40 EMS",
        "CODE:10D2",
        "CALL:Chest Pains",
        "ADDR:196 N Bayshore Dr",
        "CITY:Frederica",
        "PLACE:Bowers Beach",
        "X:N Flack Ave / Main St",
        "NAME:Margaret");

    doTest("T7",
        "(Chief ALT) [40 EMS] - 26C2 - Sick Person -- 201 Hubbard Ave, Frederica -- Bowers Beach -- Xst's: Dead End / Canal St -- Caller: Ingle Heather",
        "SRC:40 EMS",
        "CODE:26C2",
        "CALL:Sick Person",
        "ADDR:201 Hubbard Ave",
        "CITY:Frederica",
        "PLACE:Bowers Beach",
        "X:Dead End / Canal St",
        "NAME:Ingle Heather");

    doTest("T8",
        "(Chief ALT) [40 EMS] - 10C4 - Chest Pains -- 302 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Second St, Sycamore Dr / Lorna Ln -- Caller: Thom Ronald",
        "SRC:40 EMS",
        "CODE:10C4",
        "CALL:Chest Pains",
        "ADDR:302 Lake Shore Dr",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "X:Second St, Sycamore Dr / Lorna Ln",
        "NAME:Thom Ronald");

    doTest("T9",
        "(Chief ALT) [40 EMS] - 6C1 - Breathing Problems -- 294 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Kiwi Ct / Kylie Ln -- Caller: Hurd Shirley",
        "SRC:40 EMS",
        "CODE:6C1",
        "CALL:Breathing Problems",
        "ADDR:294 Lake Shore Dr",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "X:Kiwi Ct / Kylie Ln",
        "NAME:Hurd Shirley");

    doTest("T10",
        "(Chief ALT) [40 Fire] - 17A2 - Falls - Non-Recent -- 254 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Tyson Ln / Ibis Ct -- Caller: Spink Kimberley",
        "SRC:40 Fire",
        "CODE:17A2",
        "CALL:Falls - Non-Recent",
        "ADDR:254 Lake Shore Dr",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "X:Tyson Ln / Ibis Ct",
        "NAME:Spink Kimberley");

    doTest("T11",
        "(Chief ALT) [40 Fire] - Outside Fire-Unknown 2124 BOWERS BEACH RD, Frederica -- Xst's: Grm Dr / Whitwell Delight Rd",
        "SRC:40 Fire",
        "CALL:Outside Fire-Unknown",
        "ADDR:2124 BOWERS BEACH RD",
        "CITY:Frederica",
        "X:Grm Dr / Whitwell Delight Rd");

    doTest("T12",
        "(Chief ALT) [46 Fire] -- Alarms-High Life Hazard -- APT-WHITEOAK APTS -- 1001 Whiteoak Rd Dover - Cross Sts: N Halsey R - Caller:GRIER, KIEASHA",
        "SRC:46 Fire",
        "CALL:Alarms-High Life Hazard - APT-WHITEOAK APTS",
        "ADDR:1001 Whiteoak Rd",
        "CITY:Dover",
        "X:N Halsey R",
        "NAME:GRIER, KIEASHA");

    doTest("T13",
        "(Chief ALT) [48 Fire] - Outside Fire-Small -- : 121 Allan Ave :, Felton -- Mount Vernon Estates -- Xst's: Kings Ln / Mount Vernon Dr -- Caller: Steff Diane",
        "SRC:48 Fire",
        "CALL:Outside Fire-Small",
        "ADDR:121 Allan Ave",
        "CITY:Felton",
        "PLACE:Mount Vernon Estates",
        "X:Kings Ln / Mount Vernon Dr",
        "NAME:Steff Diane");

    doTest("T14",
        "(Chief ALT) [48 Fire] - 29D5 - MVC Not Alert -- : 837 Equitation Ln :, Felton -- Xst's: Jump School House Rd / Holly Spring Rd -- Caller: Bright Pam",
        "SRC:48 Fire",
        "CODE:29D5",
        "CALL:MVC Not Alert",
        "ADDR:837 Equitation Ln",
        "CITY:Felton",
        "X:Jump School House Rd / Holly Spring Rd",
        "NAME:Bright Pam");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[Chief ALT] [46 Fire] -- Stand-By,Cover-up -- 110 Firehouse Ln Marydel - Cross Sts: Strauss Av\n",
        "SRC:46 Fire",
        "CALL:Stand-By,Cover-up",
        "ADDR:110 Firehouse Ln",
        "CITY:Marydel",
        "X:Strauss Av");

    doTest("T2",
        "[Chief ALT] [46 Fire] -- Outside Fire-Small -- Wolf Creek Blvd/ Glenda Rd Dover - Cross Sts: None\n",
        "SRC:46 Fire",
        "CALL:Outside Fire-Small",
        "ADDR:Wolf Creek Blvd & Glenda Rd", // Google calls this Wolf Creek
        "CITY:Dover");

    doTest("T3",
        "[Chief ALT] [46 Fire] -- Stand-By,Cover-up -- 2898 Arthursville Rd Hartly - Cross Sts: Main St\n" +
        " Everetts Corner R Cross St2: Main St\n" +
        " Everetts\n",

        "SRC:46 Fire",
        "CALL:Stand-By,Cover-up",
        "ADDR:2898 Arthursville Rd",
        "CITY:Hartly",
        "X:Main St\n Everetts Corner R Cross St2: Main St\n Everetts");

    doTest("T4",
        "[Chief ALT] [46 Fire] -- Structure-Commercial -- 1481 N Dupont Hwy Dover - Cross Sts: W Rustic L - Caller:HILL, ANTONETTE\n",
        "SRC:46 Fire",
        "CALL:Structure-Commercial",
        "ADDR:1481 N Dupont Hwy",
        "CITY:Dover",
        "X:W Rustic L",
        "NAME:HILL, ANTONETTE");

    doTest("T5",
        "[Chief ALT] [46 Fire] -- Alarms-Residential (single) -- 40 Saulsbury Rd Dover - Cross Sts: Carver R\n",
        "SRC:46 Fire",
        "CALL:Alarms-Residential (single)",
        "ADDR:40 Saulsbury Rd",
        "CITY:Dover",
        "X:Carver R");

    doTest("T6",
        "[Chief ALT] [46 Fire] -- Outside Fire-Field,Grass,Woods -- 1365 N Dupont Hwy Dover - Cross Sts: Dover Mal - Caller:dfd\n",
        "SRC:46 Fire",
        "CALL:Outside Fire-Field,Grass,Woods",
        "ADDR:1365 N Dupont Hwy",
        "CITY:Dover",
        "X:Dover Mal",
        "NAME:dfd");

    doTest("T7",
        "[Chief ALT] [46 Fire] -- 29D2L MVC Motorcycle/Bicycle -- 1131 N Dupont Hwy Dover - Cross Sts: Unknow - Caller:CODY\n",
        "SRC:46 Fire",
        "CALL:29D2L MVC Motorcycle/Bicycle",
        "ADDR:1131 N Dupont Hwy",
        "CITY:Dover",
        "X:Unknow",
        "NAME:CODY");

    doTest("T8",
        "[Chief ALT] [46 Fire] -- 29B4 MVC Unknown -- College Rd/ Mckee Rd Dover - Cross Sts: None - Caller:JAKE\n",
        "SRC:46 Fire",
        "CODE:29B4",
        "CALL:MVC Unknown",
        "ADDR:College Rd & Mckee Rd",
        "CITY:Dover",
        "NAME:JAKE");

    doTest("T9",
        "[Chief ALT] [46 Fire] -- Electrical Hazard-Arcing -- 1001 Forrest Ave Dover - Cross Sts: Saulsbury Rd\n" +
        " Forest S Cross St2: Saulsbury\n",

        "SRC:46 Fire",
        "CALL:Electrical Hazard-Arcing",
        "ADDR:1001 Forrest Ave",
        "CITY:Dover",
        "X:Saulsbury Rd\n Forest S Cross St2: Saulsbury");

    doTest("T10",
        "[Chief ALT] [46 Fire] -- Fuel Spill (Small) -- 411 S Queen St Dover - Cross Sts: Dupont S\n",
        "SRC:46 Fire",
        "CALL:Fuel Spill (Small)",
        "ADDR:411 S Queen St",
        "CITY:Dover",
        "X:Dupont S");

    doTest("T11",
        "[Chief ALT] [46 Fire] -- Alarms CO-Residential (single) -- 39 Kentwood Dr Dover - Cross Sts: Bismark D\n",
        "SRC:46 Fire",
        "CALL:Alarms CO-Residential (single)",
        "ADDR:39 Kentwood Dr",
        "CITY:Dover",
        "X:Bismark D");

    doTest("T12",
        "[Chief ALT] [46 Fire] -- Outside Fire-Small -- 1368 Rose Valley School Rd Dover - Cross Sts: Unknow\n",
        "SRC:46 Fire",
        "CALL:Outside Fire-Small",
        "ADDR:1368 Rose Valley School Rd",
        "CITY:Dover",
        "X:Unknow");

    doTest("T13",
        "[Chief ALT] [46 Fire] -- Search -- 1200 N Dupont Hwy Dover - Cross Sts: College R - Caller:DFD\n",
        "SRC:46 Fire",
        "CALL:Search",
        "ADDR:1200 N Dupont Hwy",
        "CITY:Dover",
        "X:College R",
        "NAME:DFD");

    doTest("T14",
        "[Chief ALT] [46 Fire] -- 6D1 Breathing Problems -- 14 Fair Wind Pl Dover - Cross Sts: Bay Tree R - Caller:LUKE\n",
        "SRC:46 Fire",
        "CODE:6D1",
        "CALL:Breathing Problems",
        "ADDR:14 Fair Wind Pl",
        "CITY:Dover",
        "X:Bay Tree R",
        "NAME:LUKE");

    doTest("T15",
        "[Chief ALT] [46 Fire] -- Outside Fire-Small -- 100 Haman Dr Dover - Cross Sts: Kesselring Av - Caller:TORRES, DIANNA\n",
        "SRC:46 Fire",
        "CALL:Outside Fire-Small",
        "ADDR:100 Haman Dr",
        "CITY:Dover",
        "X:Kesselring Av",
        "NAME:TORRES, DIANNA");

    doTest("T16",
        "[Chief ALT] [46 Fire] -- Outside Fire-Small -- 217 Rose Valley School Rd Dover - Cross Sts: Hazlettville R - Caller:KWNTCOM\n",
        "SRC:46 Fire",
        "CALL:Outside Fire-Small",
        "ADDR:217 Rose Valley School Rd",
        "CITY:Dover",
        "X:Hazlettville R",
        "NAME:KWNTCOM");

    doTest("T17",
        "[Chief ALT] [46 Fire] -- Vehicle Fire -- 439 Phoenix Dr Dover - Cross Sts: Santa Fe D - Caller:RILEY, EDEDE, E\n",
        "SRC:46 Fire",
        "CALL:Vehicle Fire",
        "ADDR:439 Phoenix Dr",
        "CITY:Dover",
        "X:Santa Fe D",
        "NAME:RILEY, EDEDE, E");

    doTest("T18",
        "[Chief ALT] [46 Fire] -- Outside Fire-Small -- 75 Quail Hollow Dr Dover - Cross Sts: Village D - Caller:AUSTIN, THERESA\n",
        "SRC:46 Fire",
        "CALL:Outside Fire-Small",
        "ADDR:75 Quail Hollow Dr",
        "CITY:Dover",
        "X:Village D",
        "NAME:AUSTIN, THERESA");

    doTest("T19",
        "[Chief ALT] [46 Fire] -- Alarms-Residential (single) -- 868 Woodcrest Dr Dover - Cross Sts: Woodcrest Tur - Caller:DFD\n",
        "SRC:46 Fire",
        "CALL:Alarms-Residential (single)",
        "ADDR:868 Woodcrest Dr",
        "CITY:Dover",
        "X:Woodcrest Tur",
        "NAME:DFD");

    doTest("T20",
        "[Chief ALT] [46 Fire] -- Outside Fire-Small -- State Hwy 1  - Cross Sts: None - Caller:BAER, BRETT\n",
        "SRC:46 Fire",
        "CALL:GENERAL ALERT",
        "PLACE:Outside Fire-Small -- State Hwy 1  - Xst's: None - Caller:BAER, BRETT");

    doTest("T21",
        "[Chief ALT] [46 Fire] -- Structure-Residential Single -- 880 Buttner Pl Dover - Cross Sts: Dead En\n",
        "SRC:46 Fire",
        "CALL:Structure-Residential Single",
        "ADDR:880 Buttner Pl",
        "CITY:Dover",
        "X:Dead En");

    doTest("T22",
        "[Chief ALT] [46 Fire] -- Alarms-Commercial -- 800 Otis Dr Dover - Cross Sts: Fowler C - Caller:DFD\n",
        "SRC:46 Fire",
        "CALL:Alarms-Commercial",
        "ADDR:800 Otis Dr",
        "CITY:Dover",
        "X:Fowler C",
        "NAME:DFD");

    doTest("T23",
        "[Chief ALT] [46 Fire] -- Fuel Spill (Small) -- KENT CO COURT HOUSE -- 414 Federal St Dover - Cross Sts: William Penn S - Caller:SHANER, DISPATCHER\n",
        "SRC:46 Fire",
        "CALL:Fuel Spill (Small) - KENT CO COURT HOUSE",
        "ADDR:414 Federal St",
        "CITY:Dover",
        "X:William Penn S",
        "NAME:SHANER, DISPATCHER");

    doTest("T24",
        "[Chief ALT] [46 Fire] -- Alarms-High Life Hazard -- LUTHER VILLAGE 1, LUTHER VILLAGE 2 -- 101 Babb Dr Dover - Cross Sts: Nob Hill R\n",
        "SRC:46 Fire",
        "CALL:Alarms-High Life Hazard - LUTHER VILLAGE 1, LUTHER VILLAGE 2",
        "ADDR:101 Babb Dr",
        "CITY:Dover",
        "X:Nob Hill R");

    doTest("T25",
        "[Chief ALT] [46 Fire] -- Alarms-Commercial -- COMPASSIONATE PAIN MANAGEMENT -- 740 S New St Dover - Cross Sts: South S - Caller:44, DES\n",
        "SRC:46 Fire",
        "CALL:Alarms-Commercial - COMPASSIONATE PAIN MANAGEMENT",
        "ADDR:740 S New St",
        "CITY:Dover",
        "X:South S",
        "NAME:44, DES");

    doTest("T26",
        "[Chief ALT] [46 Fire] -- Alarms-Residential (multiple) -- APT-PINE GROVE APTS -- 255 Webbs Ln Dover - Cross Sts: John Clark Rd\n" +
        " Mayberry L Cross St2: John Clark R - Caller:DFD\n",

        "SRC:46 Fire",
        "CALL:Alarms-Residential (multiple) - APT-PINE GROVE APTS",
        "ADDR:255 Webbs Ln",
        "CITY:Dover",
        "X:John Clark Rd\n Mayberry L Cross St2: John Clark R",
        "NAME:DFD");

    doTest("T27",
        "[Chief ALT] [46 Fire] -- Alarms-High Life Hazard -- SILVER LAKE CENTER -- 1080 Silver Lake Blvd Dover - Cross Sts: Unknow - Caller:DFD\n",
        "SRC:46 Fire",
        "CALL:Alarms-High Life Hazard - SILVER LAKE CENTER",
        "ADDR:1080 Silver Lake Blvd",
        "CITY:Dover",
        "X:Unknow",
        "NAME:DFD");

    doTest("T28",
        "[Chief ALT] [46 Fire] -- Alarms-Commercial -- 22 The Green Dover - Cross Sts: Bank L - Caller:DFD\n",
        "SRC:46 Fire",
        "CALL:Alarms-Commercial",
        "ADDR:22 The Green",
        "CITY:Dover",
        "X:Bank L",
        "NAME:DFD");

    doTest("T29",
        "[Chief ALT] [46 Fire] -- Alarms-Commercial -- CHRIST CHURCH -- 501 S State St Dover - Cross Sts: W Water St\n" +
        " Water S Cross St2: W Water S - Caller:DFD\n",

        "SRC:46 Fire",
        "CALL:Alarms-Commercial - CHRIST CHURCH",
        "ADDR:501 S State St",
        "CITY:Dover",
        "X:W Water St\n Water S Cross St2: W Water S",
        "NAME:DFD");

    doTest("T30",
        "[Chief ALT] [46 Fire] -- Alarms-Commercial -- 800 Otis Dr Dover - Cross Sts: Fowler C - Caller:DFD\n",
        "SRC:46 Fire",
        "CALL:Alarms-Commercial",
        "ADDR:800 Otis Dr",
        "CITY:Dover",
        "X:Fowler C",
        "NAME:DFD");

    doTest("T31",
        "[Chief ALT] [46 Fire] -- Alarms-Residential (single) -- 281 Sheffield Dr Dover - Cross Sts: Norwich Wa - Caller:ADT\n",
        "SRC:46 Fire",
        "CALL:Alarms-Residential (single)",
        "ADDR:281 Sheffield Dr",
        "CITY:Dover",
        "X:Norwich Wa",
        "NAME:ADT");

    doTest("T32",
        "[Chief ALT] [46 Fire] -- Structure-Mobile Home/Trailer -- 243 Kentwood Dr Dover - Cross Sts: Phoenix D - Caller:SHANON\n",
        "SRC:46 Fire",
        "CALL:Structure-Mobile Home/Trailer",
        "ADDR:243 Kentwood Dr",
        "CITY:Dover",
        "X:Phoenix D",
        "NAME:SHANON");

  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "- 32B2 - Medic Alert 289 INDIA DR , Smyrna: Xst's: HOFFECKER'S MILL DR / LAMBERTA FARM DR Caller:alert, life ",
        "CODE:32B2",
        "CALL:Medic Alert",
        "ADDR:289 INDIA DR",
        "CITY:Smyrna",
        "X:HOFFECKER'S MILL DR / LAMBERTA FARM DR",
        "NAME:alert, life");

    doTest("T2",
        "- 17B1G Falls - Possibly Dangerous 5500 DU PONT PKWY , Smyrna: SMYRNA REST AREA Xst's: UNKNOWN / S EXIT 119B OFF RAMP RD S EXIT 119 ON RAMP RD Caller:CLARK, SAM ",
        "CALL:17B1G Falls - Possibly Dangerous",
        "ADDR:5500 DU PONT PKWY",
        "CITY:Smyrna",
        "PLACE:SMYRNA REST AREA",
        "X:UNKNOWN / S EXIT 119B OFF RAMP RD S EXIT 119 ON RAMP RD",
        "NAME:CLARK, SAM");

  }
  
  @Test
  public void testActive911C() {

    doTest("T1",
        "(Chief ALT) [48 EMS1] - 6D2 - Breathing Problems -- 266 Lake Cove Ln, Felton -- Lakewind -- Xst's: Windward Dr / Pine Needle Dr -- Caller: Doughty Graeme\r\n" +
        "\r\n",

        "SRC:48 EMS1",
        "CODE:6D2",
        "CALL:Breathing Problems",
        "ADDR:266 Lake Cove Ln",
        "CITY:Felton",
        "PLACE:Lakewind",
        "X:Windward Dr / Pine Needle Dr",
        "NAME:Doughty Graeme");

    doTest("T2",
        "(Chief ALT) [48 EMS1] - 23B1I - Overdose/Poisoning -- 221 E  Sewell St, Felton -- Xst's: Nile St / East St -- Caller: Kerry\r\n\r\n",
        "SRC:48 EMS1",
        "CALL:23B1I - Overdose/Poisoning",
        "ADDR:221 E Sewell St",
        "CITY:Felton",
        "X:Nile St / East St",
        "NAME:Kerry");

    doTest("T3",
        "(Chief ALT) [48 EMS1] - 26C1 - Sick Person -- 562 Irish Hill Rd, Felton -- Stag Crossing -- Xst's: Blaine Dr / Canterbury Rd -- Caller: Jennifer\r\n" +
        "\r\n",

        "SRC:48 EMS1",
        "CODE:26C1",
        "CALL:Sick Person",
        "ADDR:562 Irish Hill Rd",
        "CITY:Felton",
        "PLACE:Stag Crossing",
        "X:Blaine Dr / Canterbury Rd",
        "NAME:Jennifer");

    doTest("T4",
        "(Chief ALT) [48 EMS1] - 12D2 - Seizure -- 987 Andrews Lake Rd, Felton -- Xst's: Canterbury Rd / Yoemans Tale Ln -- Caller: Sheeter Wendolyn\r\n" +
        "\r\n",

        "SRC:48 EMS1",
        "CODE:12D2",
        "CALL:Seizure",
        "ADDR:987 Andrews Lake Rd",
        "CITY:Felton",
        "X:Canterbury Rd / Yoemans Tale Ln",
        "NAME:Sheeter Wendolyn");

    doTest("T5",
        "(Chief ALT) [48 EMS1] - 9E2 - Cardiac Arrest - Agonal -- 709 Peach Basket Rd, Felton -- Xst's: Tomahawk Ln / Walnut St -- Caller: Mifflin Wanda\r\n" +
        "\r\n",

        "SRC:48 EMS1",
        "CODE:9E2",
        "CALL:Cardiac Arrest - Agonal",
        "ADDR:709 Peach Basket Rd",
        "CITY:Felton",
        "X:Tomahawk Ln / Walnut St",
        "NAME:Mifflin Wanda");

    doTest("T6",
        "(Chief ALT) [48 EMS1] - Unit:A48 Status:At Scene Citizen Assist/Service Call  280 GAREY DR  Venue: Felton Dev/Sub: Xst's: DEAD END / BURNITE MILL RD Caller:\r\n" +
        "\r\n",

        "UNIT:A48",
        "CALL:At Scene Citizen Assist/Service Call",
        "ADDR:280 GAREY DR",
        "CITY:Felton",
        "X:DEAD END / BURNITE MILL RD");

    doTest("T7",
        "(Chief ALT) [48 EMS1] - 26D1 - Sick Person - Not Alert -- 5612 Burnite Mill Rd, Felton -- Xst's: Black Swamp Rd / Chandlers Rd -- Caller: Pinder Teresa\r\n" +
        "\r\n",

        "SRC:48 EMS1",
        "CODE:26D1",
        "CALL:Sick Person - Not Alert",
        "ADDR:5612 Burnite Mill Rd",
        "CITY:Felton",
        "X:Black Swamp Rd / Chandlers Rd",
        "NAME:Pinder Teresa");

  }
  
  @Test
  public void testBowersFire() {

    doTest("T1",
        "(Chief ALT) [40 EMS] - 23B1V - Overdose/Poisoning -- 62 Sycamore Dr, Frederica -- High Point Mhp -- Xst's: Second St, Front St / Lake Shore Dr, Second St -- Caller: Diamond Angel\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:23B1V - Overdose/Poisoning",
        "ADDR:62 Sycamore Dr",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "X:Second St, Front St / Lake Shore Dr, Second St",
        "NAME:Diamond Angel");

    doTest("T2",
        "(Chief ALT) [40 EMS] - 5A1 - Back Pain - Non -Traumatic -- 90 N  Bayshore Dr, Frederica -- Bowers Beach -- Xst's: Main St / N Flack Ave -- Caller: Pat Reitmeyer\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Back Pain - Non -Traumatic",
        "ADDR:90 N Bayshore Dr",
        "CITY:Frederica",
        "PLACE:Bowers Beach",
        "CODE:5A1",
        "X:Main St / N Flack Ave",
        "NAME:Pat Reitmeyer");

    doTest("T3",
        "(Chief ALT) [40 EMS] - 9B1A - Obvious Death -- 320 N  Flack Ave, Frederica -- Bowers Beach -- Xst's: Dead End / N Bayshore Dr -- Caller: Foley Lawrence\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:9B1A - Obvious Death",
        "ADDR:320 N Flack Ave",
        "CITY:Frederica",
        "PLACE:Bowers Beach",
        "X:Dead End / N Bayshore Dr",
        "NAME:Foley Lawrence");

    doTest("T4",
        "(Chief ALT) [40 EMS] - 6D2 - Breathing Problems -- 55 Williams Ave, Frederica -- Bowers Beach -- Xst's: Unknown / Main St -- Caller: Cubbage Kathryn\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Breathing Problems",
        "ADDR:55 Williams Ave",
        "CITY:Frederica",
        "PLACE:Bowers Beach",
        "CODE:6D2",
        "X:Unknown / Main St",
        "NAME:Cubbage Kathryn");

    doTest("T5",
        "(Chief ALT) [40 EMS] - 18C2 - Headache -- 2859 Skeeter Neck Rd, Frederica -- Xst's: Eastwood Manor Dr / Bay Rd -- Caller: Harris Sandra\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Headache",
        "ADDR:2859 Skeeter Neck Rd",
        "CITY:Frederica",
        "CODE:18C2",
        "X:Eastwood Manor Dr / Bay Rd",
        "NAME:Harris Sandra");

    doTest("T6",
        "(Chief ALT) [40 EMS] - 6D2 - Breathing Problems -- 217 E Poplar St, Frederica -- Bakers Choice -- Xst's: E 2nd St / E Front St -- Caller: Hill Sheila\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Breathing Problems",
        "ADDR:217 E Poplar St",
        "CITY:Frederica",
        "PLACE:Bakers Choice",
        "CODE:6D2",
        "X:E 2nd St / E Front St",
        "NAME:Hill Sheila");

    doTest("T7",
        "(Chief ALT) [40 EMS] - 5A1 - Back Pain - Non -Traumatic -- 371 Mark St, Frederica -- High Point Mhp -- Xst's: Dead End / West Dr, David St -- Caller: Melvin Georgia\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Back Pain - Non -Traumatic",
        "ADDR:371 Mark St",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "CODE:5A1",
        "X:Dead End / West Dr, David St",
        "NAME:Melvin Georgia");

    doTest("T8",
        "(Chief ALT) [40 EMS] - 29B4 - MVC Unknown -- 7232 Carpenter Bridge Rd, Felton -- Xst's: No Cross Streets Found -- Caller: 4015\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:MVC Unknown",
        "ADDR:7232 Carpenter Bridge Rd",
        "CITY:Felton",
        "CODE:29B4",
        "X:No Cross Streets Found",
        "NAME:4015");

    doTest("T9",
        "(Chief ALT) [40 Fire] - Alarms CO-Residential (single) -- 3044 Main St, Frederica -- Bowers Beach -- Xst's: Bowers Beach Rd / Cedar Ave\r\n" +
        "\r\n",

        "SRC:40 Fire",
        "CALL:Alarms CO-Residential (single)",
        "ADDR:3044 Main St",
        "CITY:Frederica",
        "PLACE:Bowers Beach",
        "X:Bowers Beach Rd / Cedar Ave");

    doTest("T10",
        "(Chief ALT) [40 EMS] - 10D4 - Chest Pains - Clammy -- 392 Jeffery St, Frederica -- High Point Mhp -- Xst's: No Cross Streets Found -- Caller: Helwig Tammy\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Chest Pains - Clammy",
        "ADDR:392 Jeffery St",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "CODE:10D4",
        "X:No Cross Streets Found",
        "NAME:Helwig Tammy");

    doTest("T11",
        "(Chief ALT) [40 Fire] - 26C2 - Sick Person -- 79 Sycamore Dr, Frederica -- High Point Mhp -- Xst's: Lake Shore Dr, Second St / Second St, Front St -- Caller: Desiney Stevens\r\n" +
        "\r\n",

        "SRC:40 Fire",
        "CALL:Sick Person",
        "ADDR:79 Sycamore Dr",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "CODE:26C2",
        "X:Lake Shore Dr, Second St / Second St, Front St",
        "NAME:Desiney Stevens");

    doTest("T12",
        "(Chief ALT) [40 EMS] - 17B3G - Falls - Unknown -- 2106 Reynolds Rd, Milford -- Xst's: Pritchett Rd / Paris Kirby Rd -- Caller: Abbott Gary\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:17B3G - Falls - Unknown",
        "ADDR:2106 Reynolds Rd",
        "CITY:Milford",
        "X:Pritchett Rd / Paris Kirby Rd",
        "NAME:Abbott Gary");

    doTest("T13",
        "(Chief ALT) [40 Fire] - Water Rescue -- 40 Delaware Bay Bay- 40 District, Frederica -- Xst's: No Cross Streets Found\r\n\r\n",
        "SRC:40 Fire",
        "CALL:Water Rescue",
        "ADDR:40 Delaware Bay Bay- 40 District",
        "CITY:Frederica",
        "X:No Cross Streets Found");

    doTest("T14",
        "(Chief ALT) [40 EMS] - Water Rescue -- 40 Delaware Bay Bay- 40 District, Frederica -- Xst's: No Cross Streets Found\r\n\r\n",
        "SRC:40 EMS",
        "CALL:Water Rescue",
        "ADDR:40 Delaware Bay Bay- 40 District",
        "CITY:Frederica",
        "X:No Cross Streets Found");

    doTest("T15",
        "(Chief ALT) [40 EMS] - 5A1 - Back Pain - Non -Traumatic -- 220 S  Market St, Frederica -- Xst's: St Agnes St / Frederica Rd -- Caller: Officer 49\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Back Pain - Non -Traumatic",
        "ADDR:220 S Market St",
        "CITY:Frederica",
        "CODE:5A1",
        "X:St Agnes St / Frederica Rd",
        "NAME:Officer 49");

    doTest("T16",
        "(Chief ALT) [40 EMS] - Non-Emergency Transport -- 21 W  Clarke Ave Mmh, Milford -- Xst's: Polk Ave / Plum St -- Caller: 40-41\r\n\r\n",
        "SRC:40 EMS",
        "CALL:Non-Emergency Transport",
        "ADDR:21 W Clarke Ave Mmh",
        "CITY:Milford",
        "X:Polk Ave / Plum St",
        "NAME:40-41");

    doTest("T17",
        "(Chief ALT) [40 EMS] - 17A1G - Falls - Not Dangerous -- 555 Frederica Rd, Frederica -- Xst's: Waterway Dr / S Market St -- Caller: Life Link\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:17A1G - Falls - Not Dangerous",
        "ADDR:555 Frederica Rd",
        "CITY:Frederica",
        "X:Waterway Dr / S Market St",
        "NAME:Life Link");

    doTest("T18",
        "(Chief ALT) [40 EMS] - Drill 124 FRONT ST LAKE FOREST EAST, Frederica -- Xst's: Frog Leg Ln / Johnny Cake Landing Rd -- Caller: 49-15\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Drill",
        "ADDR:124 FRONT ST LAKE FOREST EAST",
        "CITY:Frederica",
        "X:Frog Leg Ln / Johnny Cake Landing Rd",
        "NAME:49-15");

    doTest("T19",
        "(Chief ALT) [40 EMS] - Drill 40 DELAWARE BAY BAY- 40 DISTRICT, Frederica -- Xst's: No Cross Streets Found -- Caller: 40-16\r\n\r\n",
        "SRC:40 EMS",
        "CALL:Drill",
        "ADDR:40 DELAWARE BAY BAY- 40 DISTRICT",
        "CITY:Frederica",
        "X:No Cross Streets Found",
        "NAME:40-16");

    doTest("T20",
        "(Chief ALT) [40 Fire] - Drill 40 DELAWARE BAY BAY- 40 DISTRICT, Frederica -- Xst's: No Cross Streets Found -- Caller: 40-16\r\n\r\n",
        "SRC:40 Fire",
        "CALL:Drill",
        "ADDR:40 DELAWARE BAY BAY- 40 DISTRICT",
        "CITY:Frederica",
        "X:No Cross Streets Found",
        "NAME:40-16");

    doTest("T21",
        "(Chief ALT) [40 EMS] - 26A4 - Sick Person - Fever -- 67 Ruyter Dr, Frederica -- Riverview Estates -- Xst's: Mcginnis Pond Rd / Marcel Ave -- Caller: Whitelock Jonathan\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Sick Person - Fever",
        "ADDR:67 Ruyter Dr",
        "CITY:Frederica",
        "PLACE:Riverview Estates",
        "CODE:26A4",
        "X:Mcginnis Pond Rd / Marcel Ave",
        "NAME:Whitelock Jonathan");

    doTest("T22",
        "(Chief ALT) [40 EMS] - 10C2 - Chest Pains -- 108 Franklin St, Frederica -- Xst's: Darby Ave / St Agnes St -- Caller: Macklin Bertha\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Chest Pains",
        "ADDR:108 Franklin St",
        "CITY:Frederica",
        "CODE:10C2",
        "X:Darby Ave / St Agnes St",
        "NAME:Macklin Bertha");

    doTest("T23",
        "(Chief ALT) [40 EMS] - 18C4 - Headache - Sudden Onset -- 2268 Bowers Beach Rd, Frederica -- Xst's: Grm Dr / Whitwell Delight Rd -- Caller: Ross\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Headache - Sudden Onset",
        "ADDR:2268 Bowers Beach Rd",
        "CITY:Frederica",
        "CODE:18C4",
        "X:Grm Dr / Whitwell Delight Rd",
        "NAME:Ross");

    doTest("T24",
        "(Chief ALT) [40 EMS] - 12A1 - Seizure -- 111 Bowers Beach Rd, Frederica -- Xst's: E Poplar St / Bay Rd -- Caller: Plumbing Dominici\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Seizure",
        "ADDR:111 Bowers Beach Rd",
        "CITY:Frederica",
        "CODE:12A1",
        "X:E Poplar St / Bay Rd",
        "NAME:Plumbing Dominici");

    doTest("T25",
        "(Chief ALT) [40 EMS] - 13A1 - Diabetic - Alert -- 3256 Main St, Frederica -- Bowers Beach -- Xst's: Church St / Davidson St -- Caller: 40 Sta\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Diabetic - Alert",
        "ADDR:3256 Main St",
        "CITY:Frederica",
        "PLACE:Bowers Beach",
        "CODE:13A1",
        "X:Church St / Davidson St",
        "NAME:40 Sta");

    doTest("T26",
        "(Chief ALT) [40 EMS] - 6D2 - Breathing Problems -- 333 Jean Bradley Cir, Frederica -- High Point Mhp -- Xst's: West Dr / Lake Shore Dr -- Caller: Pitner Stanley\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Breathing Problems",
        "ADDR:333 Jean Bradley Cir",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "CODE:6D2",
        "X:West Dr / Lake Shore Dr",
        "NAME:Pitner Stanley");

    doTest("T27",
        "(Chief ALT) [40 EMS] - 17B1G - Falls - Possibly Dangerous -- 1491 Frederica Rd, Frederica -- Xst's: Front St, E Front St / N Market St -- Caller: Hurley Ashley\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:17B1G - Falls - Possibly Dangerous",
        "ADDR:1491 Frederica Rd",
        "CITY:Frederica",
        "X:Front St, E Front St / N Market St",
        "NAME:Hurley Ashley");

    doTest("T28",
        "(Chief ALT) [40 Fire] - 29B1 - MVC Injuries -- 158 Clapham Rd, Frederica -- Xst's: High Point Park / Mulberrie Point Rd\r\n\r\n",
        "SRC:40 Fire",
        "CALL:MVC Injuries",
        "ADDR:158 Clapham Rd",
        "CITY:Frederica",
        "CODE:29B1",
        "X:High Point Park / Mulberrie Point Rd");

    doTest("T29",
        "(Chief ALT) [40 EMS] - 29B1 - MVC Injuries -- 158 Clapham Rd, Frederica -- Xst's: High Point Park / Mulberrie Point Rd\r\n\r\n",
        "SRC:40 EMS",
        "CALL:MVC Injuries",
        "ADDR:158 Clapham Rd",
        "CITY:Frederica",
        "CODE:29B1",
        "X:High Point Park / Mulberrie Point Rd");

    doTest("T30",
        "(Chief ALT) [40 EMS] - 1A1 - Abdominal Pains -- 113 Lea Ave, Frederica -- Riverview Estates -- Xst's: Marcel Ave / Christensen Way -- Caller: Stiller\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Abdominal Pains",
        "ADDR:113 Lea Ave",
        "CITY:Frederica",
        "PLACE:Riverview Estates",
        "CODE:1A1",
        "X:Marcel Ave / Christensen Way",
        "NAME:Stiller");

    doTest("T31",
        "(Chief ALT) [40 Fire] - Structure-Mobile Home/Trailer -- 1424 Frederica Rd, Frederica -- Xst's: David St / S Market St -- Caller: Pickle Shawn\r\n" +
        "\r\n",

        "SRC:40 Fire",
        "CALL:Structure-Mobile Home/Trailer",
        "ADDR:1424 Frederica Rd",
        "CITY:Frederica",
        "X:David St / S Market St",
        "NAME:Pickle Shawn");

    doTest("T32",
        "(Chief ALT) [40 EMS] - 26A3 - Sick Person - Dizziness -- 321 Jean Bradley Cir, Frederica -- High Point Mhp -- Xst's: West Dr / Lake Shore Dr -- Caller: Faulkner Deborah\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Sick Person - Dizziness",
        "ADDR:321 Jean Bradley Cir",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "CODE:26A3",
        "X:West Dr / Lake Shore Dr",
        "NAME:Faulkner Deborah");

    doTest("T33",
        "(Chief ALT) [40 EMS] - Unit:A40 Status:At Scene 26A1 Sick Person 3285 MAIN ST STATION 40 Venue: Frederica Dev/Sub: BOWERS BEACH Xst's: DAVIDSON ST / CHURCH ST Caller: 40 STATION\r\n" +
        "\r\n",

        "UNIT:A40",
        "CALL:At Scene 26A1 Sick Person",
        "ADDR:3285 MAIN ST",
        "CITY:Frederica",
        "PLACE:STATION 40",
        "MAP:BOWERS BEACH",
        "X:DAVIDSON ST / CHURCH ST",
        "NAME:40 STATION");

    doTest("T34",
        "(Chief ALT) [40 EMS] - Unit:A40 Status:At Scene 26A1 Sick Person 1131 N DUPONT HWY NORTH FIRST AID DIS - NORTH FIRST AID Venue: Dover Dev/Sub: DOVER DOWNS Xst's: UNKNOWN / DOVER DOWNS Caller: A40\r\n" +
        "\r\n",

        "UNIT:A40",
        "CALL:At Scene 26A1 Sick Person",
        "ADDR:1131 N DUPONT HWY",
        "CITY:Dover",
        "PLACE:NORTH FIRST AID DIS - NORTH FIRST AID",
        "MAP:DOVER DOWNS",
        "X:UNKNOWN / DOVER DOWNS",
        "NAME:A40");

    doTest("T35",
        "(Chief ALT) [40 EMS] - EMS Stand-by 1131 N DUPONT HWY FAN CARE CENTER DIS - OUTSIDE FIRST AID, Dover -- Dover Downs -- Xst's: Unknown / Dover Downs -- Caller: Ec24\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:EMS Stand-by 1131 N DUPONT HWY FAN CARE CENTER DIS - OUTSIDE FIRST AID",
        "CITY:Dover",
        "PLACE:Dover Downs",
        "X:Unknown / Dover Downs",
        "NAME:Ec24");

    doTest("T36",
        "(Chief ALT) [40 EMS] - 10C1 - Chest Pains -- 3285 Main St Station 40, Frederica -- Bowers Beach -- Xst's: Davidson St / Church St -- Caller: 40 Station\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Chest Pains",
        "ADDR:3285 Main St Station 40",
        "CITY:Frederica",
        "PLACE:Bowers Beach",
        "CODE:10C1",
        "X:Davidson St / Church St",
        "NAME:40 Station");

    doTest("T37",
        "(Chief ALT) [40 EMS] - Unit:A40 Status:At Scene EMS Stand-by 1131 N  DUPONT HWY DIS - SPEEDWAY Venue: Dover Dev/Sub: DOVER DOWNS Xst's: UNKNOWN / DOVER DOWNS Caller:\r\n" +
        "\r\n",

        "UNIT:A40",
        "CALL:At Scene EMS Stand-by",
        "ADDR:1131 N DUPONT HWY",
        "CITY:Dover",
        "PLACE:DIS - SPEEDWAY",
        "MAP:DOVER DOWNS",
        "X:UNKNOWN / DOVER DOWNS");

    doTest("T38",
        "(Chief ALT) [40 EMS] - 29B1 - MVC Injuries -- 11102 S Dupont Hwy, Felton -- Xst's: Unknown / S Erin Ave -- Caller: Clark Charles \r\n" +
        "\r\n" +
        "THIS IS A TEST!!!!\r\n",

        "SRC:40 EMS",
        "CALL:MVC Injuries",
        "ADDR:11102 S Dupont Hwy",
        "CITY:Felton",
        "CODE:29B1",
        "X:Unknown / S Erin Ave",
        "NAME:Clark Charles \n\nTHIS IS A TEST!!!!");

    doTest("T39",
        "(Chief ALT) [40 EMS] - 29B1 - MVC Injuries -- 11102 S  Dupont Hwy, Felton -- Xst's: Unknown / S Erin Ave -- Caller: Clark Charles\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:MVC Injuries",
        "ADDR:11102 S Dupont Hwy",
        "CITY:Felton",
        "CODE:29B1",
        "X:Unknown / S Erin Ave",
        "NAME:Clark Charles");

    doTest("T40",
        "(Chief ALT) [40 EMS] - 19D2 - Heart Problems -- 2284 Bowers Beach Rd, Frederica -- Xst's: Grm Dr / Whitwell Delight Rd -- Caller: Henry\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Heart Problems",
        "ADDR:2284 Bowers Beach Rd",
        "CITY:Frederica",
        "CODE:19D2",
        "X:Grm Dr / Whitwell Delight Rd",
        "NAME:Henry");

    doTest("T41",
        "(Chief ALT) [40 EMS] - 26C2 - Sick Person -- 134 Maple Dr, Frederica -- High Point Mhp -- Xst's: Willow Dr / Willow Dr, Garden Pl\r\n" +
        "\r\n",

        "SRC:40 EMS",
        "CALL:Sick Person",
        "ADDR:134 Maple Dr",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "CODE:26C2",
        "X:Willow Dr / Willow Dr, Garden Pl");

    doTest("T42",
        "(Chief ALT) [40 EMS] - 29B1A - MVC Multiple Injuries -- Scrap Tavern Rd, Felton -- Caller: Gunning Fran\r\n\r\n",
        "SRC:40 EMS",
        "CALL:29B1A - MVC Multiple Injuries - Scrap",
        "ADDR:Tavern Rd",
        "CITY:Felton",
        "NAME:Gunning Fran");

  }
  
  public static void main(String[] args) {
    new DEKentCountyBParserTest().generateTests("T1");
  }
}
    		