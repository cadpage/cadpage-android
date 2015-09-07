
package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class TXRuskCountyAParser extends DispatchSouthernParser {

  public TXRuskCountyAParser() {
    super(CITY_LIST, "RUSK COUNTY", "TX", DSFLAG_OPT_DISPATCH_ID | DSFLAG_CROSS_NAME_PHONE);
    addExtendedDirections();
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CITY", "PLACE X CITY");
  }
  
  @Override
  protected int getExtraParseAddressFlags() {
    return FLAG_IMPLIED_INTERSECT;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private class MyAddressField extends BaseAddressField {
    @Override
    public void parse(String field, Data data) {
      int ndx = field.indexOf('@');
      if (ndx >= 0) {
        data.strPlace = field.substring(ndx+1).trim();
        field = field.substring(0,ndx).trim();
      }
      super.parse(field, data);
    }
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
