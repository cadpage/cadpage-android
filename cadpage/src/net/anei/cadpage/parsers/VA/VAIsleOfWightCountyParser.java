package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class VAIsleOfWightCountyParser extends DispatchOSSIParser {
  
  public VAIsleOfWightCountyParser() {
    super("ISLE OF WIGHT COUNTY", "VA",
           "ADDR ( X X? CALL | PLACE X X? CALL | CALL ) INFO+");
  }
  
  @Override
  public String getFilter() {
    return "@isleofwightUS.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!body.startsWith("CAD:")) body = "CAD:" + body;
    return super.parseMsg(body, data);
  }
}