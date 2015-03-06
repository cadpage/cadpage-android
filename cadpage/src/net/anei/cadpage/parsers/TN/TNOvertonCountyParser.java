package net.anei.cadpage.parsers.TN;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

/**
 * Overton County, TN
 */
public class TNOvertonCountyParser extends DispatchB2Parser {

  public TNOvertonCountyParser() {
    super(CITY_LIST, "OVERTON COUNTY", "TN");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "BEATY SWAMP",
        "BRADFORD HICKS",
        "BUENA VISTA",
        "CECIL SPECK",
        "COLUMBIA HILL",
        "COUNTY HOUSE",
        "COVE CREEK",
        "CRAWFORD CHAPEL",
        "EAST FORK",
        "GARRETT MILL",
        "GIB YOUNG",
        "HANGING LIMB",
        "HI TECH",
        "HIDDEN COVE",
        "JOHN T POINDEXTER",
        "KOGER MOUNTAIN",
        "LLOYD STOVER",
        "MARY ELLEN",
        "MEDICAL CENTER",
        "MELVIN JOHNSON",
        "MUDDY POND",
        "OAK HILL",
        "OAKLEY ALLONS",
        "POPLAR SPRINGS",
        "RICKMAN MONTEREY",
        "SCHOOL MTN",
        "SPRING CREEK",
        "STANDING STONE",
        "STATE LINE",
        "SUNK CANE",
        "TERRAPIN RIDGE",
        "THORN GAP",
        "TOMMY DODSON",
        "TWIN OAKS",
        "WATER TANK",
        "WILLOW GROVE",
        "WINDLE COMMUNITY",
        "ZION HILL"
   );
  }
  
  @Override
  protected boolean parseAddrField(String field, Data data) {
    
    // The code DR VIS appears to have no long description, which messes up our
    // parser, so we will add our own.
    if (field.startsWith("DR VIS>")) field = "DR VIS>DOCTOR VISIT " + field.substring(7).trim();
    return super.parseAddrField(field, data);
  }

  @Override
  protected boolean isPageMsg(String body) {
    return PAGE_PTN.matcher(body).matches();
  }
  private static final Pattern PAGE_PTN = Pattern.compile("[^>]+>.* Cad: *[-\\d]+");
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "911 OPEN LINE",
      "ALARM",
      "ALLERGIC REACTION (NON ANAPHY)",
      "BREAKING & ENTERING",
      "BRUSH FIRE",
      "CARDIAC (GENERAL)",
      "CHEST PAIN",
      "CONVALESCENT",
      "DELIVER MESSAGE",
      "DIABETIC",
      "DIRECT ADMIT",
      "DISTURBING THE PEACE",
      "DOA",
      "DOCTOR VISIT",
      "DOMESTIC",
      "DUI",
      "ESCORT",
      "EXTRA PATROL",
      "FALL",
      "FIRE",
      "GEN INVESTIGATION",
      "GENERAL ASSISTANCE",
      "GENERAL INFORMATION",
      "GENERAL INFORMATION LOG",
      "GENERAL SICKNESS",
      "GRASS FIRE",
      "HELIPAD RUN",
      "INJURIES",
      "LIVESTOCK CALL",
      "MISSING PERSONS",
      "MOTORIST ASSIST",
      "MVA",
      "MVA W/INJURIES",
      "MVA W/NO INJURIES",
      "PATROL",
      "POWER OUTAGE",
      "RECKLESS DRIVING",
      "SERVING WARRANT",
      "S.O.B >SHORTNESS OF BREATH",
      "SHOPLIFTER",
      "SHOULDER INJURY",
      "SUSPICIOUS VEHICLE",
      "TEST CALL",
      "THEFT OF PROPERTY",
      "TRANSFER",
      "TRANSPORT",
      "TRESPASSING",
      "UNCONSCIOUS",
      "UNLOCK CAR DOOR",
      "UNRULY PERSONS",
      "UTILITY CALL",
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
