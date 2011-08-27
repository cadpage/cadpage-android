package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.dispatch.DispatchBParser;


/*
Salem County, NJ
Contact: Mike Khairzada <mkhairzada@comcast.net>
Sender: receivers phone number
System: Interact

911-CENTER:06N >ALARM SYSTEM-NIGHT 40 EATON RD XS: LINCOLN DR AND S WASHINGTON DR PENNSVILLE TWP TC02 // MONITORING CENT 
911-CENTER:02 >STRUCTURE FIRE-MEDIUM HAZARD 429 N BROADWAY WAY XS: ROUTE 130 OVERPASS PENNSVILLE TWP KIM MILLER 3511754 
911-CENTER:41 >ALS 25 W PITTSFIELD ST XS: N BROADWAY PENNSVILLE TWP AMERICAN LEGION BROWN MOORE PO 6789801 Map: Grids:00 
911-CENTER:40 >BLS 9 HARVARD RD XS: FORT MOTT ROAD PENNSVILLE TWP JIM MCCLAGHLIN 3142134 Map: Grids: 00000 ,000 
911-CENTER:40 >BLS 108 MADISON ST XS: GARFIELD ST PENNSVILLE TWP MC GRAW ROBIN 2996816 Map: Grids: 00000 ,000 
911-CENTER:40 >BLS 556 N BROADWAY PENNSVILLE SARA MORIARTY 4078169 
911-CENTER:01 >STRUCTURE FIRE - LOW HAZARD 21 VAN BUREN ST XS: CANAL ROAD PENNSVILLE TWP JENNIFER PORADOSKY 0383396 Map: 
911-CENTER:40 >BLS 90 N BROADWAY WAY XS: CLIFTON PLACE PENNSVILLE TWP 504 6783089 Map: Grids: 00000 ,000 
911-CENTER:41 >ALS 29 MARKET ST XS: HOWELL ST SALEM CITY BARBARA CRISPIN 2028606 Map: Grids: 00000 ,000 
911-CENTER:40 >BLS 255 N RIVER DR XS: MEADOW ROAD PENNSVILLE TWP CONEY, KENNETH R 6785492 Map: Grids: 00000 ,000 
911-CENTER:40 >BLS 11 KENT AVE Apt: 412 Bldg XS: NORTH BROADWAY PENNSVILLE TWP FRANKLIN ALARM CO OPER 2769 6782600 Map: 

*/

public class NJSalemCountyParser extends DispatchBParser {
  
  private static final String[] CITY_LIST = new String[]{
    "ALLOWAY TWP",
    "ALLOWAY",
    "CARNEYS POINT TWP",
    "CARNEYS POINT",
    "ELMER",
    "ELSINBORO TWP",
    "LOWER ALLOWAYS CREEK TWP",
    "MANNINGTON TWP",
    "OLDMANS TWP",
    "PENNS GROVE",
    "PENNSVILLE TWP",
    "PENNSVILLE",
    "PILESGROVE TWP",
    "PITTSGROVE TWP",
    "OLIVET",
    "QUINTON TWP",
    "SALEM CITY",
    "UPPER PITTSGROVE TWP",
    "WOODSTOWN"
    
  };
  
  public NJSalemCountyParser() {
    super(CITY_LIST, "SALEM COUNTY", "NJ");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("911-CENTER:");
  }
}
