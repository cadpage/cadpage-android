package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.dispatch.DispatchA65Parser;

public class ALMarshallCountyCParser extends DispatchA65Parser {
  
  public ALMarshallCountyCParser() {
    super(CITY_LIST, "MARSHALL COUNTY", "AL");
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "ALBERTVILLE",
    "ARAB",
    "BOAZ",
    "GUNTERSVILLE",

    // Towns
    "DOUGLAS",
    "GRANT",
    "SARDIS CITY",
    "UNION GROVE",

    // Census-designated place
    "JOPPA",

    // Unincorporated communities
    "ASBURY",
    "BUCKSNORT",
    "CLAYSVILLE",
    "EDDY",
    "EGYPT",
    "GRASSY",
    "HOG JAW",
    "HORTON",
    "HUSTLEVILLE",
    "KENNAMER COVE",
    "LITTLE NEW YORK",
    "MORGAN CITY",
    "MOUNT HEBRON",
    "RAYBURN",
    "RED HILL",
    "RUTH",
    "SCANT CITY",
    "SWEARENGIN",
    "WARRENTON",
    
    // Dekalb County
    "CROSSVILLE",
    
    // Jackson County
    "SCOTTSBORO"
  };
}
