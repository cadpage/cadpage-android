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
  
  public static void main(String[] args) {
    new NYNassauCountyRedAlertParserTest().generateTests("T3", "CALL INFO ADDR APT CITY X PLACE");
  }

}