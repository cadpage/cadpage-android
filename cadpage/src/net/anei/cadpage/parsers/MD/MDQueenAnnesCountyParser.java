package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MDQueenAnnesCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^(?:(?:qac911|QA911com):\\*)?[DG] ");
  private static final Pattern BOX_PTN = Pattern.compile("\\b(?:(?:LOCAL )?BOX )?([A-Z]{1,2}\\d{2})$");
  private static final Pattern CALL_PTN = Pattern.compile("(?:\\d{1,2}-\\d{1,2} |(.*) MUTUAL AID\\b).*");
  
  public MDQueenAnnesCountyParser() {
    super("QUEEN ANNES COUNTY", "MD");
  }
  
  @Override
  public String getFilter() {
    return "qac911@qac.org,QA911com@qac.org,@c-msg.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    Matcher match = MARKER.matcher(body);
    if (match.find()) body = body.substring(match.end());
    
    // Strip box from end of text
    match = BOX_PTN.matcher(body);
    if (match.find()) {
      data.strBox = match.group(1);
      body = body.substring(0, match.start()).trim();
    } 
    
    // OK, go do your magic!!
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_AT_BOTH, body, data);
    
    // Call description has to match one of two specific patterns
    match = CALL_PTN.matcher(data.strCall);
    if (!match.find()) return false;
    String city = match.group(1);
    if (city != null && city.equalsIgnoreCase("KENT")) data.strCity = city;
    
    // Parse box number from what is left
    String sExtra = getLeft();
    
    // What is left is usually supplemental info.  But if the smart address parser
    // picked a place name from the end of the the address, just append what is
    // left to that
    if (data.strPlace.length() > 0) {
      data.strPlace = data.strPlace + " " + sExtra;
    } else {
      data.strSupp = sExtra;
    }

    // BOX is required, unless this was a mutual aid call
    return (city != null || data.strBox.length() > 0);
  }
}
