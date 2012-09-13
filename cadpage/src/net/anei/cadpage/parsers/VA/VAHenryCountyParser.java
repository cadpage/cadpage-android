package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Henrey County, VA
 */
public class VAHenryCountyParser extends DispatchSouthernParser {
  
  public VAHenryCountyParser() {
    super(CITY_LIST, "HENRY COUNTY", "VA", DSFLAG_CROSS_NAME_PHONE | DSFLAG_UNIT);
  }

  @Override
  public String getFilter() {
    return "MHC911@co.henry.va.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    
    // Missing units show up as the first word of the call description (or info) with a leading dash
    if (data.strUnit.startsWith("-")) {
      String word = data.strUnit.substring(1) + " ";
      if (data.strCall.length() > 0) data.strCall = word + data.strCall;
      else data.strSupp = word + data.strSupp;
      data.strUnit = "";
    }
    
    // Dispatch - Google spat
    data.strAddress = data.strAddress.replace("WILLIAM F STONE PARK ", "WILLIAM F STONE ");
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]
     {"RIDGEWAY", "MARTINSVILLE", "SPENCER", "BASSETT", "COLLINSVILLE", "FIELDALE", "AXTON"}; 
}
