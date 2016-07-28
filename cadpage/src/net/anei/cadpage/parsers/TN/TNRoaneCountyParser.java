package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class TNRoaneCountyParser extends DispatchEmergitechParser {
  
  public TNRoaneCountyParser() {
    super("Roane County ECD:", 60, CITY_LIST, "ROANE COUNTY", "TN");
  }
  
  @Override
  public String getFilter() {
    return "RoaneCountyECD@roanecounty911.com";
  }

  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace('\n', ' ');
    return super.parseMsg(body, data);
  }


  private static final String[] CITY_LIST = new String[]{

    // Cities and towns
    "HARRIMAN",
    "KINGSTON",
    "OAK RIDGE",
    "OLIVER SPRINGS",
    "ROCKWOOD",

    // Census-designated place
    "MIDTOWN",

    // Unincorporated communities
    "CEDAR GROVE",
    "MIDWAY",
    "TEN MILE",
    
    // Loudoun County
    "LENOIR CITY"
  };
}
