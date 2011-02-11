//Sender: rc.263@c-msg.net
package net.anei.cadpage.parsers.MD;

import java.util.regex.Pattern;
import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.SmartAddressParser.StartType;


public class MDCharlesCountyParser extends SmartAddressParser {
  
  @Override
  public String getFilter() {
    return "rc.263@c-msg.net";
  }


  public MDCharlesCountyParser() {
    super( "CHARLES COUNTY", "MD");

  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    
    if (!body.contains("[CAD]") ) return false;
    String strAddr = body.substring(body.indexOf("[CAD]")+1);
    parseAddress(StartType.START_CALL, strAddr, data);
    data.strSupp = getLeft();
    
    return true;
    

  }
}