package net.anei.cadpage.parsers.TN;


import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Williamson County, TN 
Contact: Jay Bonson <jaybonson@gmail.com>
Sender: 911-CENTER@williamson-tn.org

911-CENTER:MED >MEDICAL CALL 3939 PERKINS RD XS: SYCAMORE RD THOMPSONS STATION Map: Grids:N,15 Cad: 2012-0000017268
911-CENTER:F >FIRE (UNKNOWN ORGIN) SNEED RD W XS: HILLSBORO RD FRANKLIN VERIZON WIRELESS Cad: 2012-0000017084
911-CENTER:MED >MEDICAL CALL 326 VAUGHN RD XS: STRICKLAND DR NASHVILLE MALLOY, MITCH Map: Grids:U,2 Cad: 2012-0000017260
911-CENTER:FA >FIRE ALARM 330 LAKE VALLEY DR XS: GLEN LAKES CT FRANKLIN PETERSON,JAY & MYRA Map: Grids:W,6 Cad: 2012-0000017023
911-CENTER:MED >MEDICAL CALL NATCHEZ TRACE PKY XS: NEW HIGHWAY 96 W FRANKLIN CENTERSTONE CRISIS CENTER Cad: 2012-0000017016
911-CENTER:MC >MEDICAL CALL 716 LEGENDS CREST DR XS: LEGENDS RIDGE DR FRANKLIN Map: Grids:W,5 Cad: 2012-0000016926
911-CENTER:FA >FIRE ALARM 1201 BRADLEY DR XS: BOBBY DR FRANKLIN DAN WATERS Map: Grids:W,4 Cad: 2012-0000016906
911-CENTER:MED >MEDICAL CALL 1786 MASTERS DR XS: SIGNATURE CT FRANKLIN NELSON, JACK Map: Grids:V,13 Cad: 2012-0000016869

*/

public class TNWilliamsonCountyParser extends DispatchBParser {
  
  public TNWilliamsonCountyParser() {
    super(CITY_LIST, "WILLIAMSON COUNTY", "TN");
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@williamson-tn.org";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("911-CENTER:");
  }

  private static final String[] CITY_LIST = new String[]{
    
    // Cities & Towns
    "BRENTWOOD",
    "FAIRVIEW",
    "FRANKLIN",
    "NOLENSVILLE",
    "SPRING HILL",
    "THOMPSONS STATION",
    
    // Unincorporated Communities
    "ALLISONA",
    "ARRINGTON",
    "BERRY'S CHAPEL",
    "BETHESDA",
    "BETHLEHEM",
    "BOSTON",
    "BURWOOD",
    "COLLEGE GROVE",
    "CLOVERCROFT",
    "COOL SPRINGS",
    "FERNVALE",
    "GRASSLAND",
    "KIRKLAND",
    "LEIPER'S FORK",
    "LIBERTY HILL",
    "PEYTONSVILLE",
    "PRIMM SPRINGS",
    "RUDDERVILLE",
    "SOUTHALL",
    "TRIUNE",
    
    // Davidson County
    "NASHVILLE"
  };
  
}