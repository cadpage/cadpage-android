package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchA10Parser;


public class OHAshtabulaCountyParser extends DispatchA10Parser {

  public OHAshtabulaCountyParser() {
    super(CITY_LIST, "ASHTABULA COUNTY", "OH",
           "CALL ADDR/S X!+? INFO+");
  }
  
  @Override
  public String getFilter() {
    return "Sheriffadmin@ashtabulacounty.us";
  }
  
  private static final String[] CITY_LIST = new String[]{

    // Cities
    "ASHTABULA",
    "CONNEAUT",
    "GENEVA",
    
    // Vilages
    "ANDOVER",
    "GENEVA-ON-THE-LAKE",
    "JEFFERSON",
    "NORTH KINGSVILLE",
    "ORWELL",
    "ROAMING SHORES",
    "ROCK CREEK",

    // Townships
    "ANDOVER TWP",
    "ASHTABULA TWP",
    "AUSTINBURG TWP",
    "CHERRY VALLEY TWP",
    "COLEBROOK TWP",
    "DENMARK TWP",
    "DORSET TWP",
    "GENEVA TWP",
    "HARPERSFIELD TWP",
    "HARTSGROVE TWP",
    "JEFFERSON TWP",
    "KINGSVILLE TWP",
    "LENOX TWP",
    "MONROE TWP",
    "MORGAN TWP",
    "NEW LYME TWP",
    "ORWELL TWP",
    "PIERPONT TWP",
    "PLYMOUTH TWP",
    "RICHMOND TWP",
    "ROME TWP",
    "SAYBROOK TWP",
    "SHEFFIELD TWP",
    "TRUMBULL TWP",
    "WAYNE TWP",
    "WILLIAMSFIELD TWP",
    "WINDSOR TWP",
    
    // Census designated places
    "EDGEWOOD",
    
    // Other communities
    "AUSTINBURG",
    "DORSET",
    "EAGLEVILLE",
    "FOOTVILLE",
    "KINGSVILLE",
    "PIERPONT",
    "UNIONVILLE"
  };
}
