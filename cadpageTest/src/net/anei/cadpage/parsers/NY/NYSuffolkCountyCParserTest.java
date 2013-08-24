package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYSuffolkCountyCParser;

import org.junit.Test;

/*
Suffolk County, NY
Sender: Paging@alpinesoftware.com
System "Red Alert"

Holbrook FD, NY
Contact: "bfdtecresq@aol.com" <bfdtecresq@aol.com>
MOTOR VEHICLE ACCIDENT . . MVA 29D4 at intersection of GREENBELT PKWY and PATCHOGUE-HOLBROOK RD. . 10:48:57
WIRES . . POWER CONDENSER FIRE at intersection of PATCHOGUE-HOLBROOK RD and FURROWS RD. . 07:14:36
WORKING STRUCTURE FIRE at 223 SPRINGMEADOW DR. . 16:22:21
AMBULANCE CALL . . E/M RESP 6D2 at 76 LINCOLN AVE. . 17:48:14
AMBULANCE CALL: 63 YOF RESP. 6-D-2 at 1585 CLAAS AVE, Holbrook . . 20:49:28
CARBON MONOXIDE ALARM: ALARM GOING OFF - NEG SYMPTOMS at 53 TIMBER RIDGE DR, Holbrook . . 22:46:56
FUEL SPILL: SHERIFFS ON SCENE REQUESTING at E/B SUNRISE HWY SRVC / BROADWAY AVE, HOLBROOK . . 23:06:50
CARBON MONOXIDE ALARM: CO ALARM at 53 TIMBER RIDGE DR, HOLBROOK  c/s: SPRINGMEADOW DR . . 00:15:25
MUTUAL AID - STRUCTURE FIRE at 62 POTOMAC  c/s: GRUNDY . . 15:08:02
MOTOR VEHICLE ACCIDENT at LINCOLN AVE / VETERANS MEMORIAL HWY, HOLBROOK . . 12:16:23
MISC: UNKNOWN TYPE FIRE - SOUTH END OF MUSKET DR at MUSKET DR / CANNON DR, HOLBROOK . . 20:58:10
MUTUAL AID - STRUCTURE FIRE: 1 LADDER TO THE SCENE at 456 WAVERLY AVE  c/s: BUCKLEY RD . . 13:56:21
AMBULANCE CALL: E/F FALL 17B1  at 229 SPRINGMEADOW DR #G, HOLBROOK  c/s: BEECH LN . . 08:39:55
VEHICLE FIRE: CAR FIRE - MULTIPLE CALLS at 24 ANNANDALE ROAD  c/s: INVERNESS ROAD . . 06:07:57
Contact: "bfdtecresq@aol.com" <bfdtecresq@aol.com>
HazMat 10 is OOS, HazMat 11 relocated to Fire Rescue. TFN
Hazmat: gas pumps knocked over at 125 Crooked hill road, Brentwood  c/s: Wicks road   O: 7-11 store . . 11:29:34
need a team leader to respond to brentwood fire for  gas pump knocked over at 7-11 store at 125 crooked hill road

Farmingdale, NY
Contact: Frank Romano <fromano129@gmail.com>
Signal 9 . . Stroke (CVA) at 64 DOUD ST. . 11:31:21
General Alarm . . SMOKE ODOR IN AREA at 36 WAVERLY PL. . 17:04:46
House Fire . . Electrical Fire at 23 BEECHWOOD ST. . 18:24:03
Motor Vehicle Accident . . With Aided at intersection of MAIN ST and FULTON ST. . 11:46:09
Signal 9 . . Cardiac / Respiratory Arrest at 610 CONKLIN ST. . 06:20:05

Setauket, NY
AMBULANCE, CONVULSIONS / SEIZURES: 12-D-2 44 YOF SEIZURES at 43 NEAL PATH, SETAUKET   O: FAIRFIELD GABLES            TRUSS . . 19:39:51
AMBULANCE, SICK PERSON (SPECIFIC DIAGNOSIS): 56 YOF SICK 26-A-5 IFO BUILDING at 5000 ROUTE 347, East Setauket  c/s: ARROWHEAD LN SOUTH   O: KOHLS . . 14:54:20
MISC CALL, CHIEFS INVESTIGATION: GENERAL FIRE ALARM 52C04 Residential (multiple) at 700H HEALTH SCIENCES DR, STONY BROOK  c/s: NICOLLS RD   O: CHAPIN APTS - S: 26-A-16 at 20 FAWN LN W, SOUTH SETAUKET  c/s: LONGBOW LN . . 00:20:06
AMBULANCE, HEMORRHAGE / LACERATIONS: 21-A-1 - 61 YOM - CUT TO HAND at 8 HOLLY LN, EAST SETAUKET  c/s: CRANE NECK RD . . 16:57:21
MISC CALL WITH RESCUE, MVA: 29-B-1U - INJURIES at C/O, Setauket  c/s: WIRELESS RD . . 16:08:02

Rocky Point, NY
Contact: Jonathan broder <redorbj@gmail.com>
Falls, Not dangerous body area at 6 CROWN RD, ROCKY POINT  c/s: FISH RD . . 08:00:02
Automatic Alarm, Residential at 38 CHERYL DR, SHOREHAM  c/s: COBBLESTONE DR . . 08:23:03
Breathing Problems, Abnormal breathing at 151 BROADWAY, ROCKY POINT  c/s: CLUBHOUSE DR . . 12:42:23
Breathing Problems, Difficulty Speaking Between Breaths at 6 CROWN RD, ROCKY POINT  c/s: FISH RD . . 16:09:05
Cardiac or Respiratory Arrest, Not breathing at all at 258 GLEN DR, SHOREHAM  c/s: LEISURE DR . . 14:31:40

Southhampton Village, NY
Contact: Chris Mckay <ccmckay18@gmail.com>
ALARM - GENERAL at 64 COUNTY RD 39, SOUTHAMPTON  c/s: NORTH SEA RD   O: HAMPTONS CENTER FOR REHAB . . 11:09:34
STRUCTURE FIRE, RESIDENTIAL at 133 North Magee St, Southampton  c/s: Sebonic Inlet Rd . . 16:42:18
MISC ALARM, GAS LEAK at 271 Gin . . 09:24:18
ALARM - GENERAL at 151 WINDMILL LN, SOUTHAMPTON  c/s: JAGGER LN   O: SVPD HQ . . 12:02:10
STRUCTURE FIRE, RESIDENTIAL at HILL ST / CAPTAINS NECK LN, SOUTHAMPTON . . 15:36:34

Brentwood, NY
General Alarm, Auto Fire Alarm at 601 SUFFOLK AVE #201, BRENTWOOD  c/s: ADAMS AVE   O: LONG ISLAND EYE SURGICAL CARE . . 08:56:41

Huntington Manor, NY
STRUCTURE FIRE at 7 HARE PLACE. . 15:27:04

Contact: Kristin Baker <kristinlbaker@gmail.com>
Ambulance Call, Unknown Problem: 32-B-2 at 911 FENWAY ROAD, St. James  c/s: FAIRFIELD DRIVE . . 12:21:46

Contact: Ralph Oswald <medic154@gmail.com>
Contact: paging@alpinesoftware.com
Ambulance Call: mva 1 injury at 338 West Montauk Highway, Hampton Bays  c/s: Bess Lane . . 13:45:27
Ambulance Call: a/m inj fall main lifeguard stand at 280 Dune Road, Hampton Bays  c/s: Road I   O: Ponquogue Beach Pavillion . . 13:04:55

Contact: kathleen clifford <kcnnp20@gmail.com>
Sender: lakelandfd@rednmxcad.com
Ambulance Call, Unconscious / Syncope: 63 YOM UNC... at 500 PECONIC STREET #335A  c/s: LOUIS KOSSUTH AVENUE . . 15:23:11 

Contact: Ira <emtcc7@gmail.com>
Sender: rockypointfd@rednmxcad.com
Sick Person (Specific Diagnosis), New Onset of Immobility at 534 LEISURE DR, SHOREHAM  c/s: LAUREL DR . . 13:00:36 

Contact: Michael Bellis <mbellis@optonline.net>
Sender: greenlawnfd@rednmxcad.com
Driver and/or EMT Needed for 2508 PAUMANACK VILLAGE DR . . 13:16:53

Contact: michael allen <spca202@gmail.com>
Sender: paging@alpinesoftware.com
AUTOMATIC ALARM at 1708 CHURCH ST, HOLBROOK  c/s: RAFT AVE . . 19:34:22

Contact: "Lord Richard S. Michels" <sirblknight007@aol.com>
Sender: 3-13-0@rednmx.com
FRM:3-13-0@rednmx.com\nMSG:Ambulance Call: A/M RESP at 2100 SMITHTOWN AVENUE, RONKONKOMA  c/s: LAKELAND AVENUE   O: NBTY / NATAURES BOUNTY . . 10:41:21

Contact: Ralph Oswald <medic154@gmail.com>
Sender: hamptonbays@rednmxcad.com
Ambulance Call, Chest Pains: A/F at 10 Holzman Drive, Hampton Bays  c/s: Newtown Road . . 12:33:48
Ambulance Call, Victim of a Fall: E/M at 6 Rowland Court, Hampton Bays  c/s: Lynn Avenue . . 13:32:36
Ambulance Call, Siezures: *** 2nd alarm\r\na/m siezures @ RUMBA at 43 Canoe Place Road South, Hampton Bays  c/s: Carter Avenue . . 19:57:19
Ambulance Call, Chest Pains: A/F at 25 Ponquogue Avenue, Hampton Bays  c/s: East Montauk Highway   O: Senior - Community Center . . 11:14:08

Contact: Paul Smith <smittyp330@gmail.com>
Sender: medford@rednmxcad.com
Automatic Alarm, General Fire at 2 RUSSELL CT, MEDFORD  c/s: MAPLE AVE   O: SMALDONE, SUZANN . . 11:47:20
Ambulance Call: e/f ams at 5 Loetscher Lane, Hampton Bays  c/s: Wakeman Road   O: John Loetscher . . 12:32:42

*/

public class NYSuffolkCountyCParserTest extends BaseParserTest {
  
  public NYSuffolkCountyCParserTest() {
    setParser(new NYSuffolkCountyCParser(), "SUFFOLK COUNTY", "NY");
  }
  
  @Test
  public void testNotPage() {
    doBadTest("I'm at the store");
    doBadTest("I'm at a meeting right now. . .");
    doBadTest("*** 16 ***202 DEPOT RDCS: LYNCH STADTML: 21-B-1TOA: 07:38 01-22-132013-000321TYPE: BLEEDING / LACERATIONS LOC: 202 DEPOT RD HUNTIS  APT 4 CROSS: LYNCH ST / E 14 ST CODE: 21-B-1TIME: 07:38:32");
  }
  
  @Test
  public void testHolbrookParser() {

    doTest("T1",
        "MOTOR VEHICLE ACCIDENT . . MVA 29D4 at intersection of GREENBELT PKWY and PATCHOGUE-HOLBROOK RD. . 10:48:57",
        "CALL:MOTOR VEHICLE ACCIDENT - MVA 29D4",
        "ADDR:GREENBELT PKWY and PATCHOGUE-HOLBROOK RD",
        "MADDR:GREENBELT PKWY & PATCHOGUE-HOLBROOK RD",
        "TIME:10:48:57");

    doTest("T2",
        "WIRES . . POWER CONDENSER FIRE at intersection of PATCHOGUE-HOLBROOK RD and FURROWS RD. . 07:14:36",
        "CALL:WIRES - POWER CONDENSER FIRE",
        "ADDR:PATCHOGUE-HOLBROOK RD and FURROWS RD",
        "MADDR:PATCHOGUE-HOLBROOK RD & FURROWS RD",
        "TIME:07:14:36");

    doTest("T3",
        "WORKING STRUCTURE FIRE at 223 SPRINGMEADOW DR. . 16:22:21",
        "CALL:WORKING STRUCTURE FIRE",
        "ADDR:223 SPRINGMEADOW DR",
        "TIME:16:22:21");

    doTest("T4",
        "AMBULANCE CALL . . E/M RESP 6D2 at 76 LINCOLN AVE. . 17:48:14",
        "CALL:AMBULANCE CALL - E/M RESP 6D2",
        "ADDR:76 LINCOLN AVE",
        "TIME:17:48:14");

    doTest("T5",
        "AMBULANCE CALL: 63 YOF RESP. 6-D-2 at 1585 CLAAS AVE, Holbrook . . 20:49:28",
        "CALL:AMBULANCE CALL",
        "INFO:63 YOF RESP.",
        "CODE:6-D-2",
        "ADDR:1585 CLAAS AVE",
        "CITY:Holbrook",
        "TIME:20:49:28");

    doTest("T6",
        "CARBON MONOXIDE ALARM: ALARM GOING OFF - NEG SYMPTOMS at 53 TIMBER RIDGE DR, Holbrook . . 22:46:56",
        "CALL:CARBON MONOXIDE ALARM",
        "INFO:ALARM GOING OFF - NEG SYMPTOMS",
        "ADDR:53 TIMBER RIDGE DR",
        "CITY:Holbrook",
        "TIME:22:46:56");

    doTest("T7",
        "FUEL SPILL: SHERIFFS ON SCENE REQUESTING at E/B SUNRISE HWY SRVC / BROADWAY AVE, HOLBROOK . . 23:06:50",
        "CALL:FUEL SPILL",
        "INFO:SHERIFFS ON SCENE REQUESTING",
        "ADDR:EB SUNRISE HWY SRVC & BROADWAY AVE",
        "MADDR:SUNRISE HWY SRVC & BROADWAY AVE",
        "CITY:HOLBROOK",
        "TIME:23:06:50");

    doTest("T8",
        "CARBON MONOXIDE ALARM: CO ALARM at 53 TIMBER RIDGE DR, HOLBROOK  c/s: SPRINGMEADOW DR . . 00:15:25",
        "CALL:CARBON MONOXIDE ALARM",
        "INFO:CO ALARM",
        "ADDR:53 TIMBER RIDGE DR",
        "CITY:HOLBROOK",
        "X:SPRINGMEADOW DR",
        "TIME:00:15:25");

    doTest("T9",
        "MUTUAL AID - STRUCTURE FIRE at 62 POTOMAC  c/s: GRUNDY . . 15:08:02",
        "CALL:MUTUAL AID - STRUCTURE FIRE",
        "ADDR:62 POTOMAC",
        "X:GRUNDY",
        "TIME:15:08:02");

    doTest("T10",
        "MOTOR VEHICLE ACCIDENT at LINCOLN AVE / VETERANS MEMORIAL HWY, HOLBROOK . . 12:16:23",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:LINCOLN AVE & VETERANS MEMORIAL HWY",
        "CITY:HOLBROOK",
        "TIME:12:16:23");

    doTest("T11",
        "MISC: UNKNOWN TYPE FIRE - SOUTH END OF MUSKET DR at MUSKET DR / CANNON DR, HOLBROOK . . 20:58:10",
        "CALL:MISC",
        "INFO:UNKNOWN TYPE FIRE - SOUTH END OF MUSKET DR",
        "ADDR:MUSKET DR & CANNON DR",
        "CITY:HOLBROOK",
        "TIME:20:58:10");

    doTest("T12",
        "MUTUAL AID - STRUCTURE FIRE: 1 LADDER TO THE SCENE at 456 WAVERLY AVE  c/s: BUCKLEY RD . . 13:56:21",
        "CALL:MUTUAL AID - STRUCTURE FIRE",
        "INFO:1 LADDER TO THE SCENE",
        "ADDR:456 WAVERLY AVE",
        "X:BUCKLEY RD",
        "TIME:13:56:21");

    doTest("T13",
        "AMBULANCE CALL: E/F FALL 17B1  at 229 SPRINGMEADOW DR #G, HOLBROOK  c/s: BEECH LN . . 08:39:55",
        "CALL:AMBULANCE CALL",
        "CODE:17B1",
        "INFO:E/F FALL",
        "ADDR:229 SPRINGMEADOW DR",
        "APT:G",
        "CITY:HOLBROOK",
        "X:BEECH LN",
        "TIME:08:39:55");

    doTest("T14",
        "VEHICLE FIRE: CAR FIRE - MULTIPLE CALLS at 24 ANNANDALE ROAD  c/s: INVERNESS ROAD . . 06:07:57",
        "CALL:VEHICLE FIRE",
        "INFO:CAR FIRE - MULTIPLE CALLS",
        "ADDR:24 ANNANDALE ROAD",
        "X:INVERNESS ROAD",
        "TIME:06:07:57");

    doTest("T15",
        "Hazmat: gas pumps knocked over at 125 Crooked hill road, Brentwood  c/s: Wicks road   O: 7-11 store . . 11:29:34",
        "CALL:Hazmat",
        "INFO:gas pumps knocked over",
        "ADDR:125 Crooked hill road",
        "CITY:Brentwood",
        "X:Wicks road",
        "PLACE:7-11 store",
        "TIME:11:29:34");
  }
  
  @Test
  public void testFarmingdaleParser() {

    doTest("T1",
        "Signal 9 . . Stroke (CVA) at 64 DOUD ST. . 11:31:21",
        "CALL:Signal 9 - Stroke (CVA)",
        "ADDR:64 DOUD ST",
        "TIME:11:31:21");

    doTest("T2",
        "General Alarm . . SMOKE ODOR IN AREA at 36 WAVERLY PL. . 17:04:46",
        "CALL:General Alarm - SMOKE ODOR IN AREA",
        "ADDR:36 WAVERLY PL",
        "TIME:17:04:46");

    doTest("T3",
        "House Fire . . Electrical Fire at 23 BEECHWOOD ST. . 18:24:03",
        "CALL:House Fire - Electrical Fire",
        "ADDR:23 BEECHWOOD ST",
        "TIME:18:24:03");

    doTest("T4",
        "Motor Vehicle Accident . . With Aided at intersection of MAIN ST and FULTON ST. . 11:46:09",
        "CALL:Motor Vehicle Accident - With Aided",
        "ADDR:MAIN ST and FULTON ST",
        "MADDR:MAIN ST & FULTON ST",
        "TIME:11:46:09");

    doTest("T5",
        "Signal 9 . . Cardiac / Respiratory Arrest at 610 CONKLIN ST. . 06:20:05",
        "CALL:Signal 9 - Cardiac / Respiratory Arrest",
        "ADDR:610 CONKLIN ST",
        "TIME:06:20:05");
   
  }
  
  @Test
  public void testSetauketParser() {

    doTest("T1",
        "AMBULANCE, CONVULSIONS / SEIZURES: 12-D-2 44 YOF SEIZURES at 43 NEAL PATH, SETAUKET   O: FAIRFIELD GABLES            TRUSS . . 19:39:51",
        "CALL:AMBULANCE, CONVULSIONS / SEIZURES",
        "INFO:44 YOF SEIZURES",
        "CODE:12-D-2",
        "ADDR:43 NEAL PATH",
        "CITY:SETAUKET",
        "PLACE:FAIRFIELD GABLES TRUSS",
        "TIME:19:39:51");

    doTest("T2",
        "AMBULANCE, SICK PERSON (SPECIFIC DIAGNOSIS): 56 YOF SICK 26-A-5 IFO BUILDING at 5000 ROUTE 347, East Setauket  c/s: ARROWHEAD LN SOUTH   O: KOHLS . . 14:54:20",
        "CALL:AMBULANCE, SICK PERSON (SPECIFIC DIAGNOSIS)",
        "INFO:56 YOF SICK IFO BUILDING",
        "CODE:26-A-5",
        "ADDR:5000 ROUTE 347",
        "CITY:East Setauket",
        "X:ARROWHEAD LN SOUTH",
        "PLACE:KOHLS",
        "TIME:14:54:20");

    doTest("T3",
        "MISC CALL, CHIEFS INVESTIGATION: GENERAL FIRE ALARM 52C04 Residential (multiple) at 700H HEALTH SCIENCES DR, STONY BROOK  c/s: NICOLLS RD   O: CHAPIN APTS - S: 26-A-16 at 20 FAWN LN W, SOUTH SETAUKET  c/s: LONGBOW LN . . 00:20:06",
        "CALL:MISC CALL, CHIEFS INVESTIGATION",
        "INFO:GENERAL FIRE ALARM Residential (multiple)",
        "CODE:52C04",
        "ADDR:700H HEALTH SCIENCES DR",
        "CITY:STONY BROOK",
        "X:NICOLLS RD",
        "PLACE:CHAPIN APTS",
        "TIME:00:20:06");

    doTest("T4",
        "AMBULANCE, HEMORRHAGE / LACERATIONS: 21-A-1 - 61 YOM - CUT TO HAND at 8 HOLLY LN, EAST SETAUKET  c/s: CRANE NECK RD . . 16:57:21",
        "CALL:AMBULANCE, HEMORRHAGE / LACERATIONS",
        "CODE:21-A-1",
        "INFO:61 YOM - CUT TO HAND",
        "ADDR:8 HOLLY LN",
        "CITY:EAST SETAUKET",
        "X:CRANE NECK RD",
        "TIME:16:57:21");

    doTest("T5",
        "MISC CALL WITH RESCUE, MVA: 29-B-1U - INJURIES at C/O, Setauket  c/s: WIRELESS RD . . 16:08:02",
        "CALL:MISC CALL WITH RESCUE, MVA",
        "CODE:29-B-1U",
        "INFO:INJURIES",
        "ADDR:C/O",
        "MADDR:C/O & WIRELESS RD",
        "CITY:Setauket",
        "X:WIRELESS RD",
        "TIME:16:08:02");
    
  }
  
  @Test
  public void testRockyPointParser() {

    doTest("T1",
        "Falls, Not dangerous body area at 6 CROWN RD, ROCKY POINT  c/s: FISH RD . . 08:00:02",
        "CALL:Falls, Not dangerous body area",
        "ADDR:6 CROWN RD",
        "CITY:ROCKY POINT",
        "X:FISH RD",
        "TIME:08:00:02");

    doTest("T2",
        "Automatic Alarm, Residential at 38 CHERYL DR, SHOREHAM  c/s: COBBLESTONE DR . . 08:23:03",
        "CALL:Automatic Alarm, Residential",
        "ADDR:38 CHERYL DR",
        "CITY:SHOREHAM",
        "X:COBBLESTONE DR",
        "TIME:08:23:03");

    doTest("T3",
        "Breathing Problems, Abnormal breathing at 151 BROADWAY, ROCKY POINT  c/s: CLUBHOUSE DR . . 12:42:23",
        "CALL:Breathing Problems, Abnormal breathing",
        "ADDR:151 BROADWAY",
        "CITY:ROCKY POINT",
        "X:CLUBHOUSE DR",
        "TIME:12:42:23");

    doTest("T4",
        "Breathing Problems, Difficulty Speaking Between Breaths at 6 CROWN RD, ROCKY POINT  c/s: FISH RD . . 16:09:05",
        "CALL:Breathing Problems, Difficulty Speaking Between Breaths",
        "ADDR:6 CROWN RD",
        "CITY:ROCKY POINT",
        "X:FISH RD",
        "TIME:16:09:05");

    doTest("T5",
        "Cardiac or Respiratory Arrest, Not breathing at all at 258 GLEN DR, SHOREHAM  c/s: LEISURE DR . . 14:31:40",
        "CALL:Cardiac or Respiratory Arrest, Not breathing at all",
        "ADDR:258 GLEN DR",
        "CITY:SHOREHAM",
        "X:LEISURE DR",
        "TIME:14:31:40");
  }
  
  @Test
  public void testSouthamptonParser() {

    doTest("T1",
        "ALARM - GENERAL at 64 COUNTY RD 39, SOUTHAMPTON  c/s: NORTH SEA RD   O: HAMPTONS CENTER FOR REHAB . . 11:09:34",
        "CALL:ALARM - GENERAL",
        "ADDR:64 COUNTY RD 39",
        "MADDR:64 COUNTY ROAD 39",
        "CITY:SOUTHAMPTON",
        "X:NORTH SEA RD",
        "PLACE:HAMPTONS CENTER FOR REHAB",
        "TIME:11:09:34");

    doTest("T2",
        "STRUCTURE FIRE, RESIDENTIAL at 133 North Magee St, Southampton  c/s: Sebonic Inlet Rd . . 16:42:18",
        "CALL:STRUCTURE FIRE, RESIDENTIAL",
        "ADDR:133 North Magee St",
        "CITY:Southampton",
        "X:Sebonic Inlet Rd",
        "TIME:16:42:18");

    doTest("T3",
        "MISC ALARM, GAS LEAK at 271 Gin . . 09:24:18",
        "CALL:MISC ALARM, GAS LEAK",
        "ADDR:271 Gin",
        "TIME:09:24:18");

    doTest("T4",
        "ALARM - GENERAL at 151 WINDMILL LN, SOUTHAMPTON  c/s: JAGGER LN   O: SVPD HQ . . 12:02:10",
        "CALL:ALARM - GENERAL",
        "ADDR:151 WINDMILL LN",
        "CITY:SOUTHAMPTON",
        "X:JAGGER LN",
        "PLACE:SVPD HQ",
        "TIME:12:02:10");

    doTest("T5",
        "STRUCTURE FIRE, RESIDENTIAL at HILL ST / CAPTAINS NECK LN, SOUTHAMPTON . . 15:36:34",
        "CALL:STRUCTURE FIRE, RESIDENTIAL",
        "ADDR:HILL ST & CAPTAINS NECK LN",
        "CITY:SOUTHAMPTON",
        "TIME:15:36:34");
    
  }
  
  @Test
  public void testBrentwood() {

    doTest("T1",
        "General Alarm, Auto Fire Alarm at 601 SUFFOLK AVE #201, BRENTWOOD  c/s: ADAMS AVE   O: LONG ISLAND EYE SURGICAL CARE . . 08:56:41",
        "CALL:General Alarm, Auto Fire Alarm",
        "ADDR:601 SUFFOLK AVE",
        "APT:201",
        "CITY:BRENTWOOD",
        "X:ADAMS AVE",
        "PLACE:LONG ISLAND EYE SURGICAL CARE",
        "TIME:08:56:41");
    
  }
  
  @Test
  public void testHuntingtonManor() {

    doTest("T1",
        "STRUCTURE FIRE at 7 HARE PLACE. . 15:27:04",
        "CALL:STRUCTURE FIRE",
        "ADDR:7 HARE PLACE",
        "TIME:15:27:04");

  }
  
  @Test
  public void testStJames() {

    doTest("T1",
        "Ambulance Call, Unknown Problem: 32-B-2 at 911 FENWAY ROAD, St. James  c/s: FAIRFIELD DRIVE . . 12:21:46",
        "CALL:Ambulance Call, Unknown Problem",
        "CODE:32-B-2",
        "ADDR:911 FENWAY ROAD",
        "CITY:St. James",
        "X:FAIRFIELD DRIVE",
        "TIME:12:21:46");
  }
  
  @Test
  public void testHamptonBays() {

    doTest("T1",
        "Ambulance Call: mva 1 injury at 338 West Montauk Highway, Hampton Bays  c/s: Bess Lane . . 13:45:27",
        "CALL:Ambulance Call",
        "INFO:mva 1 injury",
        "ADDR:338 West Montauk Highway",
        "CITY:Hampton Bays",
        "X:Bess Lane",
        "TIME:13:45:27");

    doTest("T2",
        "Ambulance Call: a/m inj fall main lifeguard stand at 280 Dune Road, Hampton Bays  c/s: Road I   O: Ponquogue Beach Pavillion . . 13:04:55",
        "CALL:Ambulance Call",
        "INFO:a/m inj fall main lifeguard stand",
        "ADDR:280 Dune Road",
        "CITY:Hampton Bays",
        "X:Road I",
        "PLACE:Ponquogue Beach Pavillion",
        "TIME:13:04:55");

    doTest("T3",
        "Ambulance Call, Unconscious / Syncope: 63 YOM UNC... at 500 PECONIC STREET #335A  c/s: LOUIS KOSSUTH AVENUE . . 15:23:11 ",
        "CALL:Ambulance Call, Unconscious / Syncope",
        "INFO:63 YOM UNC...",
        "ADDR:500 PECONIC STREET",
        "APT:335A",
        "X:LOUIS KOSSUTH AVENUE",
        "TIME:15:23:11");

    doTest("T4",
        "Sick Person (Specific Diagnosis), New Onset of Immobility at 534 LEISURE DR, SHOREHAM  c/s: LAUREL DR . . 13:00:36 ",
        "CALL:Sick Person (Specific Diagnosis), New Onset of Immobility",
        "ADDR:534 LEISURE DR",
        "CITY:SHOREHAM",
        "X:LAUREL DR",
        "TIME:13:00:36");
  }
  
  @Test
  public void testGreenLawn() {

    doTest("T1",
        "Driver and/or EMT Needed for 2508 PAUMANACK VILLAGE DR . . 13:16:53",
        "CALL:Driver and/or EMT Needed for",
        "ADDR:2508 PAUMANACK VILLAGE DR",
        "TIME:13:16:53");

    doTest("T2",
        "AUTOMATIC ALARM at 1708 CHURCH ST, HOLBROOK  c/s: RAFT AVE . . 19:34:22",
        "CALL:AUTOMATIC ALARM",
        "ADDR:1708 CHURCH ST",
        "CITY:HOLBROOK",
        "X:RAFT AVE",
        "TIME:19:34:22");
  }
  
  @Test
  public void testRonkonkoma() {

    doTest("T1",
        "FRM:3-13-0@rednmx.com\nMSG:Ambulance Call: A/M RESP at 2100 SMITHTOWN AVENUE, RONKONKOMA  c/s: LAKELAND AVENUE   O: NBTY / NATAURES BOUNTY . . 10:41:21",
        "CALL:Ambulance Call",
        "INFO:A/M RESP",
        "ADDR:2100 SMITHTOWN AVENUE",
        "CITY:RONKONKOMA",
        "X:LAKELAND AVENUE",
        "PLACE:NBTY / NATAURES BOUNTY",
        "TIME:10:41:21");
  }
  
  @Test
  public void testRalphOswald() {

    doTest("T1",
        "Ambulance Call, Chest Pains: A/F at 10 Holzman Drive, Hampton Bays  c/s: Newtown Road . . 12:33:48",
        "CALL:Ambulance Call, Chest Pains",
        "INFO:A/F",
        "ADDR:10 Holzman Drive",
        "CITY:Hampton Bays",
        "X:Newtown Road",
        "TIME:12:33:48");

    doTest("T2",
        "Ambulance Call, Victim of a Fall: E/M at 6 Rowland Court, Hampton Bays  c/s: Lynn Avenue . . 13:32:36",
        "CALL:Ambulance Call, Victim of a Fall",
        "INFO:E/M",
        "ADDR:6 Rowland Court",
        "CITY:Hampton Bays",
        "X:Lynn Avenue",
        "TIME:13:32:36");

    doTest("T3",
        "Ambulance Call, Siezures: *** 2nd alarm\r\n" +
        "a/m siezures @ RUMBA at 43 Canoe Place Road South, Hampton Bays  c/s: Carter Avenue . . 19:57:19",

        "CALL:Ambulance Call, Siezures",
        "INFO:*** 2nd alarm a/m siezures @ RUMBA",
        "ADDR:43 Canoe Place Road South",
        "CITY:Hampton Bays",
        "X:Carter Avenue",
        "TIME:19:57:19");

    doTest("T4",
        "Ambulance Call, Chest Pains: A/F at 25 Ponquogue Avenue, Hampton Bays  c/s: East Montauk Highway   O: Senior - Community Center . . 11:14:08",
        "CALL:Ambulance Call, Chest Pains",
        "INFO:A/F",
        "ADDR:25 Ponquogue Avenue",
        "CITY:Hampton Bays",
        "X:East Montauk Highway",
        "PLACE:Senior - Community Center",
        "TIME:11:14:08");

    doTest("T5",
        "Ambulance Call: e/f ams at 5 Loetscher Lane, Hampton Bays  c/s: Wakeman Road   O: John Loetscher . . 12:32:42",
        "CALL:Ambulance Call",
        "INFO:e/f ams",
        "ADDR:5 Loetscher Lane",
        "CITY:Hampton Bays",
        "X:Wakeman Road",
        "PLACE:John Loetscher",
        "TIME:12:32:42");

  }
  
  @Test
  public void testPaulSmith() {

    doTest("T1",
        "Automatic Alarm, General Fire at 2 RUSSELL CT, MEDFORD  c/s: MAPLE AVE   O: SMALDONE, SUZANN . . 11:47:20",
        "CALL:Automatic Alarm, General Fire",
        "ADDR:2 RUSSELL CT",
        "CITY:MEDFORD",
        "X:MAPLE AVE",
        "PLACE:SMALDONE, SUZANN",
        "TIME:11:47:20");
   
  }
  
  
  public static void main(String[] args) {
    new NYSuffolkCountyCParserTest().generateTests("T1");
  }

}