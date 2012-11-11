package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class SCRichlandCountyParser extends FieldProgramParser {
 
  public SCRichlandCountyParser() {
    super("RICHLAND COUNTY", "SC",
          "Address:ADDR! Problem:CALL!");
  }
  
  @Override
  public String getFilter() {
    return "2002000004";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // If the regular message parser handles this all is well
    if (super.parseMsg(body, data)) return true;
    
    // If not, see if we can get this through a general type parser
    // Which will only accept it caller has identified this as a dispatch page
    if (!isPositiveId()) return false;
    
    parseAddress(StartType.START_CALL, FLAG_IGNORE_AT | FLAG_NO_IMPLIED_APT, body, data);
    if (data.strAddress.length() == 0) return false;
    data.strSupp = getLeft();
    return true;
  }
}
