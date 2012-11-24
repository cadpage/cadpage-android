package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA12Parser;


public class MDGarrettCountyParser extends DispatchA12Parser {
  
  public MDGarrettCountyParser() {
    super("GARRETT COUNTY", "MD");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equals("GRANT CO")) {
      data.strCity = "GRANT COUNTY";
      data.strState = "WV";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CITY", "CITY ST");
  }
  
  @Override
  public String getFilter() {
    return "garrettco911@garrettcounty.org";
  }
}
