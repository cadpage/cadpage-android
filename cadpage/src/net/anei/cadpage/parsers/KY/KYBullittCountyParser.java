package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;


public class KYBullittCountyParser extends DispatchBParser {
  
  private static final String DEF_CITY = "BULLITT COUNTY";
  private static final String DEF_STATE = "KY";
  
  private static final String[] CITY_LIST =new String[]{
	  "BROOKS", "BROWNINGTON", "CLERMONT", "FOX CHASE", "HEBRON ESTATES", 
	  "HILLVIEW", "HUNTERS HOLLOW" ,"LEBANON JUNCTION", "MOUNT WASHINGTON", "MT WASHINGTON", 
	  "PIONEER VILLAGE", "SHEPHERDSVILLE", "SOLITUDE", "TAYLORSVILLE", };

  public KYBullittCountyParser() {
    super(CITY_LIST, DEF_CITY, DEF_STATE);
  }
  
  public String getFilter() {
    return "@c-msg.net";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    
    // First token following BULLITT CO 911: is the call type
    if (! body.startsWith("BULLITT CO 911:")) return false;
    body = body.substring(15).trim();

    return super.parseMsg(body, data);
  }
}
