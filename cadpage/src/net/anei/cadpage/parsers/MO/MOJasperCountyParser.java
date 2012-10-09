package net.anei.cadpage.parsers.MO;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/**
 * Jasper County, MO
 */
public class MOJasperCountyParser extends SmartAddressParser {
 
  public MOJasperCountyParser() {
    super("JASPER COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "@jasco.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Really aren't any definitive markers, so we have to county on something
    // else identifying this as a CAD page
    if (!isPositiveId()) return false;
    
    // Not much to go on.  a "- " separator marks an address and call description
    int pt = body.indexOf("- ");
    if (pt >= 0) {
      parseAddress(body.substring(0,pt).trim(), data);
      data.strCall = body.substring(pt+2).trim();
    }
    
    else {
      parseAddress(StartType.START_CALL, body, data);
      String tail = getLeft();
      if (data.strCall.length() == 0) {
        data.strCall = tail;
      } else {
        data.strSupp = tail;
      }
    }
    return true;
  }
}