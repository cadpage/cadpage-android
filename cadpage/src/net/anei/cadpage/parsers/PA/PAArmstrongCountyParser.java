package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Armstrong County, PA
 */
public class PAArmstrongCountyParser extends SmartAddressParser {

  // Marker is time and run number at end of message
  private static final Pattern MARKER_PATTERN = Pattern.compile(" +(\\d{1,6}) (\\d\\d:\\d\\d)(?: (\\d{10}))?(?: +([A-Z0-9]+))?$");
  
  public PAArmstrongCountyParser() {
    super("ARMSTRONG COUNTY", "PA");
    setFieldList("ADDR X PLACE ID TIME PHONE CALL");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = MARKER_PATTERN.matcher(body);
    if (! match.find()) return false;
    
    data.strCallId = match.group(1);
    data.strTime = match.group(2);
    data.strPhone = getOptGroup(match.group(3));
    data.strCall = getOptGroup(match.group(4));
    body = body.substring(0,match.start());
    
    if (data.strCall.length() == 0) {
      Parser p = new Parser(body);
      data.strCall = p.getLast(' ');
      body = p.get();
    }
    
    
    // We need to call the smart parser twice, once for the real address
    // and a second time to get the cross streets (which look like intersections)
    
    body = body.replace(",", "/");
    parseAddress(StartType.START_ADDR, body, data);
    body = getLeft();
    do {
      if (body.startsWith("/")) body = body.substring(1).trim();
      Result result2 = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, body);
      if (result2.getStatus() > 0) {
        String oldCross = data.strCross;
        data.strCross = "";
        result2.getData(data);
        data.strCross = append(oldCross, " / ", data.strCross);
        body = result2.getLeft();
      }
    } while (body.startsWith("/"));
    
    data.strPlace = body;

    return true;
  }
}
