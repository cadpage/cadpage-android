package net.anei.cadpage.parsers.NJ;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchChiefWebPagingParser;

/**
 * Salem County, NJ (Deepwater)
 */
public class NJSalemCountyBParser extends DispatchChiefWebPagingParser {
  
  public NJSalemCountyBParser() {
    super(CITY_LIST, "SALEM COUNTY", "NJ");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Drop calls from New Castle County, DE (B)
    if (body.contains(" EMD:")) return false;
    
    return super.parseMsg(subject, body, data);
  }
  
  private static String[] CITY_LIST = new String[]{
    "NEW CASTLE",
    "DELMAR",
    "PARSONSBURG",
    "CARNEYS POINT TOWNSHIP",
    "PENNSVILLE TOWNSHIP"
  };
}


