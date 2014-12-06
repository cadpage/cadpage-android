package net.anei.cadpage.parsers.TN;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

/**
 * Overton County, TN
 */
public class TNOvertonCountyParser extends DispatchB2Parser {

  public TNOvertonCountyParser() {
    super(CITY_LIST, "OVERTON COUNTY", "TN");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "BRADFORD HICKS",
        "CECIL SPECK",
        "COLUMBIA HILL",
        "EAST FORK",
        "GARRETT MILL",
        "GIB YOUNG",
        "HANGING LIMB",
        "HI TECH",
        "JOHN T POINDEXTER",
        "KOGER MOUNTAIN",
        "MARY ELLEN",
        "MELVIN JOHNSON",
        "MUDDY POND",
        "OAK HILL",
        "OAKLEY ALLONS",
        "SPRING CREEK",
        "THORN GAP",
        "WINDLE COMMUNITY"
   );
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return PAGE_PTN.matcher(body).matches();
  }
  private static final Pattern PAGE_PTN = Pattern.compile("[^>]+>.* Cad: *[-\\d]+");
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "ALARM",
      "BREAKING & ENTERING",
      "BRUSH FIRE",
      "CONVALESCENT",
      "DOMESTIC",
      "DUI",
      "ESCORT",
      "EXTRA PATROL",
      "FALL",
      "GENERAL ASSISTANCE",
      "GEN INVESTIGATION",
      "GRASS FIRE",
      "HELIPAD RUN",
      "LIVESTOCK CALL",
      "MVA W/INJURIES",
      "MVA W/NO INJURIES",
      "POWER OUTAGE",
      "RECKLESS DRIVING",
      "SERVING WARRANT",
      "S.O.B >SHORTNESS OF BREATH",
      "SUSPICIOUS VEHICLE",
      "THEFT OF PROPERTY",
      "TRANSFER",
      "TRESPASSING",
      "UNLOCK CAR DOOR",
      "UNRULY PERSONS",
      "VANDALISM",
      "WALK IN",
      "WALK THRU",
      "WELFARE CHECK"
  );

  private static final String[] CITY_LIST = new String[]{

    // Cities and Towns
      
      "LIVINGSTON",
   
    // Unincorporated communities
      "ALLONS",
      "ALLRED",
      "ALPINE",
      "CRAWFORD",
      "HILHAM",
      "MINERAL SPRINGS",
      "MONROE",
      "RICKMAN",
      
      // Fentris County
      "PALL MALL",
      
      // Pickett County
      "BYRDSTOWN",
      "LOVE LADY",
      "MOODYVILLE",
      "MIDWAY",
      "STATIC",
      
      // Putnam County
      "COOKEVILLE",
      "MONTEREY"
      
  };
}
