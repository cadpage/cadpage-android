
package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Chilton County, AL
 */

public class ALChiltonCountyParser extends DispatchSouthernParser {
  
  private static final String[] CITY_LIST = new String[]{
    "CLANTON",
    "ISABELLA",
    "JEMISON",
    "MAPLESVILLE",
    "MOUNTAIN CREEK",
    "STANTON",
    "THORSBY",
    "VERBENA",
    "BILLINGSLEY", 
  };

  public ALChiltonCountyParser() {
    super(CITY_LIST, "CHILTON COUNTY", "AL", 0);
    
    
  }
  @Override
  public String getFilter() {
    return "dispatch@chiltoncounty.org,dispatch@dispatch.ccso911.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    body = body.replace('\\', '/');
    body = body.replaceAll("\\bCOUNTY RD\\b", "CO");
    if (body.startsWith("/")) body = body.substring(1).trim();
    if (! super.parseMsg(body, data)) return false;
    data.strAddress = data.strAddress.replaceAll("\\bCO\\b", "COUNTY RD");
    return true;
  }
}
