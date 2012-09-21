package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.dispatch.DispatchGeoconxParser;

/* 
Johnson County, TN
Contact: Pc Doctors <2209751@gmail.com>
Sender: 911 dispatch
System: Geoconx

[E911]  STRUCTURE FIRE\nGRADY STOUT 4235341985\n1312 CRACKERS NECK RD, MOUNTAIN CITY
[E911]  STRUCTURE FIRE\nCORNETT*S USED CARS 4237394613\n530 CRETSINGER RD, SHADY VALLEY
[E911]  STRUCTURE FIRE\nROBIN STANLEY 4237278607\n870 FURNACE CREEK RD, MOUNTAIN CITY
[E911]  VEHICLE FIRE\nCHRIS PIERCE 5555555555\n123 SESAME ST, MOUNTAIN CITY\nTEST ONLY
[E911]  FIRE CALL\nBETTY BRYANT 4237275474\n5833 HWY 421 S, MOUNTAIN CITY\nVEHICLE FIRE

 */

public class TNJohnsonCountyParser extends DispatchGeoconxParser {
  
  public TNJohnsonCountyParser() {
    super("JOHNSON COUNTY", "TN");
  }
  
  @Override
  public String getFilter() {
    return "911 dispatch";
  }
}
