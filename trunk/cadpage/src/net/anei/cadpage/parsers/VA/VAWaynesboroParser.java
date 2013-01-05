package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class VAWaynesboroParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "VA";
  private static final String DEF_CITY = "WAYNESBORO";
  
  private static final Pattern MARKER = Pattern.compile("^(?:Dispatch\\d?|eocdir):");
  
  public VAWaynesboroParser() {
    super(DEF_CITY, DEF_STATE);
  }
  
  @Override
  public String getFilter() {
    return "@ci.waynesboro.va.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    
    if (body.startsWith("RESPOND ")) {
      body = body.substring(7).trim();
    }
    if (body.startsWith("- ")) {
      body = body.substring(2).trim();
    }
    
    // All commas must go
    body = body.replaceAll(",", "");
    
    // This is about as good as we are going to get
    parseAddress(StartType.START_CALL, body, data);
    if (getStatus() == 0) return false;
    data.strSupp = getLeft();
    
    if (data.strCall.endsWith(" -")) {
      data.strCall = data.strCall.substring(0, data.strCall.length()-2).trim();
    }
    if (data.strSupp.startsWith("- ") || data.strSupp.startsWith(", ")) {
      data.strSupp = data.strSupp.substring(2).trim();
    }
    if (data.strCall.length() == 0) {
      data.strCall = data.strSupp;
      data.strSupp = "";
    }
    
    return true;
  }    
}


