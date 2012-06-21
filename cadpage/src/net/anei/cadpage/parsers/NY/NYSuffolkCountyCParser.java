package net.anei.cadpage.parsers.NY;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchRedAlertParser;

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

*/

public class NYSuffolkCountyCParser extends DispatchRedAlertParser {
  
  private static final Pattern DIR_SLASH_BOUND = Pattern.compile("\\b([NSEW])/B\\b");
  
  public NYSuffolkCountyCParser() {
    super("SUFFOLK COUNTY","NY");
  }

  @Override
  public String getFilter() {
    return "paging@alpinesoftware.com,@rednmxcad.com,@rednmx.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Anything starting with TYPE: belongs to variant A
    if (body.startsWith("TYPE:")) return false;
    
    // They use a strange E/B convention
    return super.parseMsg(subject, DIR_SLASH_BOUND.matcher(body).replaceAll("$1B"), data);
  }
}
