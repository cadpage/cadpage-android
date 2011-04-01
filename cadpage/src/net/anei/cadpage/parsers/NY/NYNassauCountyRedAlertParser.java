package net.anei.cadpage.parsers.NY;


import net.anei.cadpage.parsers.dispatch.DispatchRedAlertParser;

/*
Nassau County, NY
Contact: Besnik Gjonlekaj <tigerfdny@gmail.com>
Sender: paging@rednmxcad.com & paging@alpinesoftware.com
System: Red Alert

Belmore, NY
Contact: Timothy Beuth <tbeuth@gmail.com>
RESCUE at 2438 BEDFORD PLACE. . 11:34:04
AUTO ACCIDENT at intersection of BELTAGH AVENUE and BELLMORE AVENUE. . 15:03:39
AUTO ACCIDENT at 2971 LEE PLACE. . 04:08:29
MUTUAL AID RESCUE at 3015 CHERYL ROAD. . 19:12:04
AUTOMATIC ALARM BUILDING . . UNREGISTERED ALARM at 609 SUNRISE HIGHWAY. . 11:46:13
HAZMAT - NATURAL GAS INTERIOR . . ODOR INSIDE at 1 SUNRISE HIGHWAY. . 05:07:37
HOUSE FIRE . . SMOKE IN THE HOUSE at 2764 MARTIN AVENUE. . 17:09:53
6011 IS OUT OF SERVICE
6011 IS BACK IN SERVICE 

Levittown Fire Department
Contact: Adam Freed <afreed00789@gmail.com>
Sender: paging@rednmxcad.com <From%3Apaging@rednmxcad.com>
System: Red Alert
[Auto Alarm]  at 2890 HEMPSTEAD TPKE #A, LEVITTOWN  c/s: SHELTER LN   O: THE LITTLE GYM . . 16:01:16
[Phone In]  at 47 STEVEDORE LN, LEVITTOWN  c/s: PARSON LN   O: CAIOLA . . 10:24:26
Signal 9 at 62 FLAMINGO RD, LEVITTOWN  c/s: GULL LN   O: OLSEN . . 09:34:27
Brush Fires at TARRY LN / BAYBERRY LN, LEVITTOWN . . 14:28:07

Hicksville FD
SIGNAL 9 at 17 BRIDLE LN, HICKSVILLE c/s: BLUEBERRY LN O: KENDALL, ANNA..14:48:48

Glen Cove FD
GENERAL ALARM, POSSIBLE HOUSE FIRE: SMOKE IN THE HOUSE at 62 TOWN PATH RD, GLEN COVE  c/s: WALNUT RD   O: CAPOBIANCO . . 12:34:31
SIG 8, CARBON MONOXIDE ACTIVATION at 238 WALNUT RD EXT, GLEN COVE  c/s: SEAMAN RD   O: IANNONE . . 11:32:25
GENERAL ALARM, AUTOMATIC FIRE ALARM at 5 MCKINLEY PL, GLEN COVE  c/s: GRANT PL   O: RASENBERGER . . 19:11:33
GENERAL ALARM, ELECTRICAL BURNING at 10 YALE PL, GLEN COVE c/s: PURDUE RD O: MORRISSEY..09:27:08

Oyster Bay FD
RESCUE, AMBU at OYSTER BAY LIBRARY 89 MAIN ST E, OYSTER BAY c/s: PEARL ST / ANSTICE ST, PEDESTRIAN STRUCK . . 12:45:00
CHIEF, WIRE at  SANDY HILL ROAD, OYSTER BAY c/s: MAIN (E) ST, WIRES BURNING . . 00:20:00

*/

public class NYNassauCountyRedAlertParser extends DispatchRedAlertParser {
  
  public NYNassauCountyRedAlertParser() {
    super("NASSAU COUNTY","NY");
  }

  @Override
  public String getFilter() {
    return "paging@rednmxcad.com,paging@alpinesoftware.com";
  }
}
