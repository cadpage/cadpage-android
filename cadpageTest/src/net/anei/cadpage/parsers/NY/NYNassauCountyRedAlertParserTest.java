package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYNassauCountyRedAlertParserTest extends BaseParserTest {
  
  public NYNassauCountyRedAlertParserTest() {
    setParser(new NYNassauCountyRedAlertParser(), "NASSAU COUNTY", "NY");
  }
  
  @Test
  public void testBelmoreParser() {
    
    doTest("T1",
        "RESCUE at 2438 BEDFORD PLACE. . 11:34:04",
        "CALL:RESCUE",
        "ADDR:2438 BEDFORD PLACE");

    doTest("T2",
        "AUTO ACCIDENT at intersection of BELTAGH AVENUE and BELLMORE AVENUE. . 15:03:39",
        "CALL:AUTO ACCIDENT",
        "ADDR:BELTAGH AVENUE and BELLMORE AVENUE");
    
    doTest("T3",
        "AUTO ACCIDENT at 2971 LEE PLACE. . 04:08:29",
        "CALL:AUTO ACCIDENT",
        "ADDR:2971 LEE PLACE");
    
    doTest("T4",
        "MUTUAL AID RESCUE at 3015 CHERYL ROAD. . 19:12:04",
        "CALL:MUTUAL AID RESCUE",
        "ADDR:3015 CHERYL ROAD");
    
    doTest("T5",
        "AUTOMATIC ALARM BUILDING . . UNREGISTERED ALARM at 609 SUNRISE HIGHWAY. . 11:46:13",
        "CALL:AUTOMATIC ALARM BUILDING - UNREGISTERED ALARM",
        "ADDR:609 SUNRISE HIGHWAY");
    
    doTest("T6",
        "HAZMAT - NATURAL GAS INTERIOR . . ODOR INSIDE at 1 SUNRISE HIGHWAY. . 05:07:37",
        "CALL:HAZMAT - NATURAL GAS INTERIOR - ODOR INSIDE",
        "ADDR:1 SUNRISE HIGHWAY");
    
    doTest("T7",
        "HOUSE FIRE . . SMOKE IN THE HOUSE at 2764 MARTIN AVENUE. . 17:09:53",
        "CALL:HOUSE FIRE - SMOKE IN THE HOUSE",
        "ADDR:2764 MARTIN AVENUE");
  }
  
  @Test
  public void testLevittownParser() {
    
    doTest("T1",
        "[Auto Alarm]  at 2890 HEMPSTEAD TPKE #A, LEVITTOWN  c/s: SHELTER LN   O: THE LITTLE GYM . . 16:01:16",
        "CALL:Auto Alarm",
        "ADDR:2890 HEMPSTEAD TPKE",
        "APT:A",
        "CITY:LEVITTOWN",
        "X:SHELTER LN",
        "PLACE:THE LITTLE GYM");
    
    doTest("T2",
        "Phone In  at 47 STEVEDORE LN, LEVITTOWN  c/s: PARSON LN   O: CAIOLA . . 10:24:26",
        "CALL:Phone In",
        "ADDR:47 STEVEDORE LN",
        "CITY:LEVITTOWN",
        "X:PARSON LN",
        "PLACE:CAIOLA");
    
    doTest("T3",
        "Signal 9 at 62 FLAMINGO RD, LEVITTOWN  c/s: GULL LN   O: OLSEN . . 09:34:27",
        "CALL:Signal 9",
        "ADDR:62 FLAMINGO RD",
        "CITY:LEVITTOWN",
        "X:GULL LN",
        "PLACE:OLSEN");
    
    doTest("T4",
        "Brush Fires at TARRY LN / BAYBERRY LN, LEVITTOWN . . 14:28:07",
        "CALL:Brush Fires",
        "ADDR:TARRY LN & BAYBERRY LN",
        "CITY:LEVITTOWN");
  }
  
  @Test
  public void testHicksville() {

    doTest("T1",
        "SIGNAL 9 at 17 BRIDLE LN, HICKSVILLE c/s: BLUEBERRY LN O: KENDALL, ANNA..14:48:48",
        "CALL:SIGNAL 9",
        "ADDR:17 BRIDLE LN",
        "CITY:HICKSVILLE",
        "X:BLUEBERRY LN",
        "PLACE:KENDALL, ANNA");

    doTest("T2",
        "BUILDING FIRE: SMOKE IN THE STRUCTURE  at 6 W VILLAGE GRN, HICKSVILLE  c/s: BARTER LN   O: ANNE'S WASH AND DRY . . 13:29:45",
        "CALL:BUILDING FIRE",
        "INFO:SMOKE IN THE STRUCTURE",
        "ADDR:6 W VILLAGE GRN",
        "CITY:HICKSVILLE",
        "X:BARTER LN",
        "PLACE:ANNE'S WASH AND DRY");

    doTest("T3",
        "AUTOMATIC ALARM: ZONE 58 / AFA NO ANSWER ON THE CALL BACK  at 111 CANTIAGUE ROCK RD, WESTBURY  c/s: W JOHN ST   O: NASSAU BOCES - CAREER PREPRATORY HIGH S",
        "CALL:AUTOMATIC ALARM",
        "INFO:ZONE 58 / AFA NO ANSWER ON THE CALL BACK",
        "ADDR:111 CANTIAGUE ROCK RD",
        "CITY:WESTBURY",
        "X:W JOHN ST",
        "PLACE:NASSAU BOCES - CAREER PREPRATORY HIGH S");

    doTest("T4",
        "AUTOMATIC ALARM: WATER FLOW at 108 NEW SOUTH RD #A, HICKSVILLE  c/s: COMMERCIAL ST   O: 108-122 NEW SOUTH ROAD REALTY INC.  (MULTIPLE BUSINESSES) . . 14:2",
        "CALL:AUTOMATIC ALARM",
        "INFO:WATER FLOW",
        "ADDR:108 NEW SOUTH RD",
        "APT:A",
        "CITY:HICKSVILLE",
        "X:COMMERCIAL ST",
        "PLACE:108-122 NEW SOUTH ROAD REALTY INC. (MULTIPLE BUSINESSES)");

    doTest("T5",
        "GENERAL ALARM, AUTOMATIC ALARM: FRONT SMOKE DETECTOR/PULL STATION at 284 W PARK AVE, LONG BEACH  c/s: LAURELTON BLVD   O: LONG BEACH",
        "CALL:GENERAL ALARM, AUTOMATIC ALARM",
        "INFO:FRONT SMOKE DETECTOR/PULL STATION",
        "ADDR:284 W PARK AVE",
        "CITY:LONG BEACH",
        "X:LAURELTON BLVD",
        "PLACE:LONG BEACH");
 
  }
  
  @Test
  public void testGlennCove() {

    doTest("T1",
        "GENERAL ALARM, POSSIBLE HOUSE FIRE: SMOKE IN THE HOUSE at 62 TOWN PATH RD, GLEN COVE  c/s: WALNUT RD   O: CAPOBIANCO . . 12:34:31",
        "CALL:GENERAL ALARM, POSSIBLE HOUSE FIRE",
        "INFO:SMOKE IN THE HOUSE",
        "ADDR:62 TOWN PATH RD",
        "CITY:GLEN COVE",
        "X:WALNUT RD",
        "PLACE:CAPOBIANCO");

    doTest("T2",
        "SIG 8, CARBON MONOXIDE ACTIVATION at 238 WALNUT RD EXT, GLEN COVE  c/s: SEAMAN RD   O: IANNONE . . 11:32:25",
        "CALL:SIG 8, CARBON MONOXIDE ACTIVATION",
        "ADDR:238 WALNUT RD EXT",
        "CITY:GLEN COVE",
        "X:SEAMAN RD",
        "PLACE:IANNONE");

    doTest("T3",
        "GENERAL ALARM, AUTOMATIC FIRE ALARM at 5 MCKINLEY PL, GLEN COVE  c/s: GRANT PL   O: RASENBERGER . . 19:11:33",
        "CALL:GENERAL ALARM, AUTOMATIC FIRE ALARM",
        "ADDR:5 MCKINLEY PL",
        "CITY:GLEN COVE",
        "X:GRANT PL",
        "PLACE:RASENBERGER");

    doTest("T4",
        "GENERAL ALARM, ELECTRICAL BURNING at 10 YALE PL, GLEN COVE c/s: PURDUE RD O: MORRISSEY..09:27:08",
        "CALL:GENERAL ALARM, ELECTRICAL BURNING",
        "ADDR:10 YALE PL",
        "CITY:GLEN COVE",
        "X:PURDUE RD",
        "PLACE:MORRISSEY");
    
  }
  
  @Test
  public void testOysterBay() {

    doTest("T1",
        "RESCUE, AMBU at OYSTER BAY LIBRARY 89 MAIN ST E, OYSTER BAY c/s: PEARL ST / ANSTICE ST, PEDESTRIAN STRUCK . . 12:45:00",
        "CALL:RESCUE, AMBU",
        "ADDR:OYSTER BAY LIBRARY 89 MAIN ST E",
        "CITY:OYSTER BAY",
        "X:PEARL ST / ANSTICE ST, PEDESTRIAN STRUCK");

    doTest("T2",
        "CHIEF, WIRE at  SANDY HILL ROAD, OYSTER BAY c/s: MAIN (E) ST, WIRES BURNING . . 00:20:00",
        "CALL:CHIEF, WIRE",
        "ADDR:SANDY HILL ROAD",
        "CITY:OYSTER BAY",
        "X:MAIN (E) ST, WIRES BURNING");
 
  }
  
  @Test
  public void TestUnknown1() {

    doTest("T1",
        "Automatic Alarm - Residential, Water Flow: Zone: 43, Response:CO4, CO3\nat 51 GREAT NECK RD, GREAT NECK   c/s: SO. MIDDLE NECK RD.   O: ATRIA (Use For Fire",
        "CALL:Automatic Alarm - Residential, Water Flow",
        "MAP:43",
        "UNIT:CO4, CO3",
        "ADDR:51 GREAT NECK RD",
        "CITY:GREAT NECK",
        "X:SO. MIDDLE NECK RD.",
        "PLACE:ATRIA (Use For Fire");

    doTest("T2",
        "MVA w/ Aided: Zone: 54, Response:CO5, CO4, CO6\nat LAKEVILLE RD / NORTHERN STATE PKWY, LAKE SUCCESS . . 10:28:36",
        "CALL:MVA w/ Aided",
        "MAP:54",
        "UNIT:CO5, CO4, CO6",
        "ADDR:LAKEVILLE RD & NORTHERN STATE PKWY",
        "CITY:LAKE SUCCESS");

    doTest("T3",
        "Automatic Alarm - Residential: Zone: 21, Response:CO2, CO1\nat 32 BUCKMINSTER LA, STRATHMORE VILLAGE  c/s: SUSSEX DR   O: URALLEY . . 21:03:10",
        "CALL:Automatic Alarm - Residential",
        "MAP:21",
        "UNIT:CO2, CO1",
        "ADDR:32 BUCKMINSTER LA",
        "CITY:STRATHMORE",
        "X:SUSSEX DR",
        "PLACE:URALLEY");

    doTest("T4",
        "Automatic Alarm - Commercial: Zone: 54, Response:CO5, CO4\nat 1 DELAWARE DR, LAKE SUCCESS QUARD  c/s: MARCUS AV   O: PARKER JEWISH CENTER-PRO HEALTH . . 1",
        "CALL:Automatic Alarm - Commercial",
        "MAP:54",
        "UNIT:CO5, CO4",
        "ADDR:1 DELAWARE DR",
        "CITY:LAKE SUCCESS",
        "X:MARCUS AV",
        "PLACE:PARKER JEWISH CENTER-PRO HEALTH");

    doTest("T5",
        "MVA w/ Aided: Zone: 43, Response:CO4, CO3, CO6\nat 363 GREAT NECK RD, GREAT NECK  c/s: WATER MILL LA   O: REMA AUTO COLLISION . . 12:56:01",
        "CALL:MVA w/ Aided",
        "MAP:43",
        "UNIT:CO4, CO3, CO6",
        "ADDR:363 GREAT NECK RD",
        "CITY:GREAT NECK",
        "X:WATER MILL LA",
        "PLACE:REMA AUTO COLLISION");

    doTest("T6",
        "[Brush] Trees: Zone: 45, Response:CO4, CO5\nWIRES DOWN at WESTMINSTER RD / BATES RD, LAKE SUCCESS . . 15:59:47",
        "CALL:Brush Trees",
        "MAP:45",
        "UNIT:CO4, CO5 WIRES DOWN",
        "ADDR:WESTMINSTER RD & BATES RD",
        "CITY:LAKE SUCCESS");

    doTest("T7",
        "MVA w/ Aided: Zone: 43, Response:CO4, CO3\nat NORTHERN BLVD / GREAT NECK RD, GREAT NECK . . 17:45:30",
        "CALL:MVA w/ Aided",
        "MAP:43",
        "UNIT:CO4, CO3",
        "ADDR:NORTHERN BLVD & GREAT NECK RD",
        "CITY:GREAT NECK");

    doTest("T8",
        "[Brush] Trees: Zone: 54, Response:CO5\nat NEW HYDE PARK RD / NORTH SERVICE RD, NEW HYDE PARK . . 18:32:59",
        "CALL:Brush Trees",
        "MAP:54",
        "UNIT:CO5",
        "ADDR:NEW HYDE PARK RD & NORTH SERVICE RD",
        "CITY:NEW HYDE PARK");

    doTest("T9",
        "Carbon Monoxide w/ Aided: Zone: 52, Response:CO5, CO6\nat 45 CHESTNUT HILL, NORTH HILLS  c/s: ACORN PONDS DR . . 00:59:33",
        "CALL:Carbon Monoxide w/ Aided",
        "MAP:52",
        "UNIT:CO5, CO6",
        "ADDR:45 CHESTNUT HILL",
        "CITY:NORTH HILLS",
        "X:ACORN PONDS DR");

    doTest("T10",
        "/ STILL ALARM: ODOR OF GAS at CENTRAL AVE / ROCKAWAY TPKE, LAWRENCE . . 14:20:55",
        "CALL:STILL ALARM",
        "INFO:ODOR OF GAS",
        "ADDR:CENTRAL AVE & ROCKAWAY TPKE",
        "CITY:LAWRENCE");

  }
  
  public static void main(String[] args) {
    new NYNassauCountyRedAlertParserTest().generateTests("T1", "CALL MAP UNIT INFO ADDR APT CITY X PLACE");
  }

}