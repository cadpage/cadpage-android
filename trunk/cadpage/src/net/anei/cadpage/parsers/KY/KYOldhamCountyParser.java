package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

/**
 * Oldham County, KY
 */
public class KYOldhamCountyParser extends DispatchEmergitechParser {
  
  public KYOldhamCountyParser() {
    super("", 60, CITY_LIST, "OLDHAM COUNTY", "KY");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@oldhamcountyky.gov,textmsg@ballardsvillefire.com";
  }
  
  
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // If preparser removed the dispatch unit, put it back
    if (subject.length() > 0) body = '[' + subject + "]" + body; 
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equalsIgnoreCase("LAGRANGE")) data.strCity =  "LA GRANGE";
    
    // They use the unit field for a dispatcher ID, which we are not interested in
    data.strUnit = "";
    return true;
  }



  private static final String[] CITY_LIST = new String[]{
    "BALLARDSVILLE",
    "BROWNSBORO",
    "BUCKNER",
    "CENTERFIELD",
    "CRESTWOOD",
    "FLOYDSBURG",
    "GOSHEN",
    "LAGRANGE",
    "LA GRANGE",
    "ORCHARD GRASS HILLS",
    "PARK LAKE",
    "PEWEE VALLEY",
    "PROSPECT",
    "RIVER BLUFF",
    "WESTPORT"
  };
}
