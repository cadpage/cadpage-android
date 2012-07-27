package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/* 
Onslow County, NC
Contact: Kim Cytryszewski <kimcytryszewski@gmail.com>,2526220424@messaging.sprintpcs.com
Sender: CAD@onslowcountync.gov

CAD:100 VANCE LN/RIGGS RD;DIST: 158.12 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C\r
CAD:141 SHADY ST;STRUCTURE FIRE;PGFD;11B
CAD:417 LITTLE CREEK CT;ELECTRICAL HAZARD;WOFD;20D
CAD:1061 RIGGS RD/SMITH RD;DIST: 16.79 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20B
CAD:1612 RIGGS RD;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C
CAD:100 VANCE LN/RIGGS RD;DIST: 158.12 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C
CAD:485 OLD 30 RD;MORTON ELEMENTARY;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20D
CAD:227 MIDDLE RIDGE DR;ALARMS;HFD;8D
CAD:100 BELGRADE SWANSBORO RD/FREEDOM WAY;DIST: 235.62 FT;STRUCTURE FIRE;SFD;17A
CAD:1000 YORKTOWN LN;LIBERTY POINTE APARTMENTS;STRUCTURE FIRE;PGFD;11B

*/

public class NCOnslowCountyParser extends DispatchOSSIParser {
  
  public NCOnslowCountyParser() {
    super("ONSLOW COUNTY", "NC",
           "ADDR PLACE? CALL SRC UNIT!");
  }
  
  @Override
  public String getFilter() {
    return "CAD@onslowcountync.gov";
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("SRC")) return new SourceField("[A-Z]{1,2}FD", true);
    if (name.equals("UNIT")) return new UnitField("\\d{1,2}[A-Z]", true);
    return super.getField(name);
  }
}
