package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYNassauCountyBParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^(?:FireCom:|RedAlert:)");
  private static final Pattern CALL_PTN = Pattern.compile(" *\\(([\\- A-Z0-9]{2,})\\) *");
  private static final Pattern PRIORITY_PTN = Pattern.compile(" - +(\\d)$");

  public NYNassauCountyBParser() {
    super("NASSAU COUNTY", "NY");
    addExtendedDirections();
    setFieldList("ADDR X PRI CALL INFO ID");
  }
  
  public String getFilter() {
    return "paging@alpinesoftware.com,@rednmxcad.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    
    match = CALL_PTN.matcher(body);
    if (!match.find()) return false;
    String sAddr = body.substring(0, match.start());
    data.strCall = match.group(1);
    String sExtra = body.substring(match.end());
    
    match = PRIORITY_PTN.matcher(sAddr);
    if (match.find()) {
      data.strPriority = match.group(1);
      sAddr = sAddr.substring(0,match.start()).trim();
    }
    parseAddress(StartType.START_PLACE, FLAG_ANCHOR_END, sAddr, data);
    
    Parser p = new Parser(sExtra);
    data.strSupp = p.get(" D:");
    p.get(" #:");
    data.strCallId = p.get();

    return true;
  }
}


