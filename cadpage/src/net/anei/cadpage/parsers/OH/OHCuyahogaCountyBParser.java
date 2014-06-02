package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA44Parser;

public class OHCuyahogaCountyBParser extends DispatchA44Parser {

  public OHCuyahogaCountyBParser() {
    super("CUYAHOGA COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "alert911@parmajustice.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    data.strCode = data.strUnit;
    data.strUnit = "";
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("UNIT", "CODE");
  }
  
}
