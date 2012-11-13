package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;


public class OHWayneCountyCParser extends DispatchEmergitechParser {
  
  public OHWayneCountyCParser() {
    super("[A-Z0-9]{3,5}:", -23, -21, CITY_LIST, "WAYNE COUNTY", "OH");
  }

  @Override
  public String getFilter() {
    return "JCR@wcjustice-center.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    
    // Fix problem with apple creek broken up at CR CREEK
    if (data.strName.equals ("APPLE CR EEK")) {
      data.strCity = "APPLE CREEK";
      data.strName = "";
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "NORTON",
    "ORRVILLE",
    "RITTMAN",
    "WOOSTER",
    
    // Villages
    "APPLE CREEK",
    "BURBANK",
    "CONGRESS",
    "CRESTON",
    "DALTON",
    "DOYLESTOWN",
    "FREDERICKSBURG",
    "MARSHALLVILLE",
    "MOUNT EATON",
    "SHREVE",
    "SMITHVILLE",
    "WEST SALEM",

    // Townships
    "BAUGHMAN TWP",
    "CANAAN TWP",
    "CHESTER TWP",
    "CHIPPEWA TWP",
    "CLINTON TWP",
    "CONGRESS TWP",
    "EAST UNION TWP",
    "FRANKLIN TWP",
    "GREEN TWP",
    "MILTON TWP",
    "PAINT TWP",
    "PLAIN TWP",
    "SALT CREEK TWP",
    "SUGAR CREEK TWP",
    "WAYNE TWP",
    "WOOSTER TWP",
    
    // Unincorporated Communities
    "FUNK",
    "KIDRON",
    "STERLING",
  };
}
