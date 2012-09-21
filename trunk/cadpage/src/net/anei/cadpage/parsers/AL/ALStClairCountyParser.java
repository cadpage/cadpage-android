package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/**
 * St Clair County, AL
 */
public class ALStClairCountyParser extends DispatchBParser {

  public ALStClairCountyParser() {
    super(CITY_LIST, "ST CLAIR COUNTY", "AL");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("9-1-1CENTRAL:");
  }
  
  @Override
  protected boolean parseAddrField(String field, Data data) {
    field = field.replace('@', '&');
    if (! super.parseAddrField(field, data)) return false;
    data.strCross = data.strCross.replace('&', '@');
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ARGO",
    "ASHVILLE",
    "BRANCHVILLE",
    "COOL SPRINGS",
    "LEEDS",
    "MARGARET",
    "MOODY",
    "ODENVILLE",
    "PELL CITY",
    "PINEDALE SHORES",
    "RAGLAND",
    "RIVERSIDE",
    "SPRINGVILLE",
    "STEELE",
    "TRUSSVILLE",
    "VINCENT"
  };
}
