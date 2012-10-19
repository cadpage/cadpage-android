package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;



public class MOStFrancoisCountyParser extends DispatchCiscoParser {
  
  public MOStFrancoisCountyParser() {
    super("ST FRANCOIS COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "IPN.9999900138@ipnpaging.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return super.parseMsg(body.replace('\n', ' ').replace("!",""), data);
  }
}
