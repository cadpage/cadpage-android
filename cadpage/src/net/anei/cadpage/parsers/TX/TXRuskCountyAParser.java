
package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class TXRuskCountyAParser extends DispatchSouthernParser {

  public TXRuskCountyAParser() {
    super(CITY_LIST, "RUSK COUNTY", "TX", DSFLAG_OPT_DISPATCH_ID);
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CITY", "X CITY");
  }
  
  private static final String[] CITY_LIST = new String[]{

    // Cities
    "EASTON",
    "HENDERSON",
    "KILGORE",
    "MOUNT ENTERPRISE",
    "NEW LONDON",
    "OVERTON",
    "REKLAW",
    "TATUM",

    // Unincorporated communities
    "CONCORD",
    "ELDERVILLE",
    "JOINERVILLE",
    "LAIRD HILL",
    "LANEVILLE",
    "LEVERETT'S CHAPEL",
    "MINDEN",
    "PRICE",
    "SELMAN CITY",
    "TURNERTOWN"
  };
}
