package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA38Parser;



public class ALLimestoneCountyParser extends DispatchA38Parser {
  
  public ALLimestoneCountyParser() {
    super("LIMESTONE COUNTY", "AL");
  }
  
  @Override
  public String getFilter() {
    return "mail-noreply@google.com";
  }
  
  @Override
  public boolean parseMsg(String field, Data data) {
    if (!super.parseMsg(field, data)) return false;
    
    // We have no idea what the numeric city codes mean
    // until we have  more information, save them in the box code
    if (NUMERIC.matcher(data.strCity).matches()) {
      data.strBox = data.strCity;
      data.strCity = "";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram() + " BOX";
  }
}
