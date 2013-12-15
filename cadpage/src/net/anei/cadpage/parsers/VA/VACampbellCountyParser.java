package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;


public class VACampbellCountyParser extends DispatchDAPROParser {
  
  public VACampbellCountyParser() {
    super(CITY_CODES, "CAMPBELL COUNTY","VA");
    setupCallList(CALL_SET);
  }
  
  @Override
  public String getFilter() {
    return "MAILBOX@ccgvn.net";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!super.parseMsg(body, data)) return false;
    
    if (data.strCity.length() == 0) {
      int pt = data.strAddress.lastIndexOf("- ");
      if (pt >= 0) {
        data.strCity = data.strAddress.substring(pt+2).trim();
        data.strAddress = data.strAddress.substring(0,pt).trim();
      }
    }
    
    return true;
  }

  private static final CodeSet CALL_SET = new CodeSet(
      "(3)ACCIDENT",
      "BRUSH/FIELD FIRE",
      "CHEST PAIN (NO CARDIAC HISTORY",
      "HANGUP 911",
      "HEADACHE",
      "MENTAL SUBJECT",
      "MUTUAL AID",
      "MUTUAL AID (OUTSIDE OF COUNTY",
      "MVC/MOTOR VEHICLE CRASH/ACCIDE",
      "PAIN",
      "STABBING",
      "STROKE",
      "UNRESPONSIVE"
     );
  
  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "ALT", "ALTAVISTA",
      
      "EVI", "EVINGTON",
      "LYN", "LYNCH STATION",
      "RUS", "RUSTBURG"
  });
}
