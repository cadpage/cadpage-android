package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

/*
Northampton County, NC
Contact: "kk4arx" <kk4arx@gmail.com>
Sender: Northampton911@nhcnc.net

S: M:Northampton911:* URIAH MARTIN RD // NEAR CEMETERY* * * CONWAY* * FIRE - BRUSH* * * * EMS3,FS20* * Medical: No* Hazards: No* * 
S: M:Northampton911:* BOAT LANDING* * * WELDON* * MISSING PERS* * * * EMS8,FS20* * Medical: No* Hazards: No* * 
S: M:Northampton911:* 907 HORNE RD* * * PENDLETON* * FIRE - SMOKE* * * * EMS3,FS18,FS20* * Medical: No* Hazards: No* * 
S: M:Northampton911:* 203 WHITE ST* * * CONWAY* * ODOR OF GAS* * * * FS20* * Medical: No* Hazards: No* * 

*/
public class NCNorthamptonCountyParser extends DispatchA3Parser {
  
  private static final String MARKER = "Northampton911:* ";
  
  public NCNorthamptonCountyParser() {
    super("NORTHAMPTON COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "Northampton911@nhcnc.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith(MARKER)) return false;
    body = body.substring(MARKER.length()).trim();
    return super.parseMsg(body, data);
  }
  
}
