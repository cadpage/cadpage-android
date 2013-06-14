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
  private static final Pattern MARKER_PATTERN1 = Pattern.compile(" +(\\d+) +(\\d\\d:\\d\\d)$");
  private static final Pattern MARKER_PATTERN2 = Pattern.compile(" +(\\d{1,6}) (\\d\\d:\\d\\d)(?: (\\d{10}))?(?: +([A-Z0-9]+))?$");
  
  public PAArmstrongCountyParser() {
    super("ARMSTRONG COUNTY", "PA");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // There are two different formats we process.
    // First look for the current one
    if (subject.equals("Dispatch")) {
      Matcher match = MARKER_PATTERN1.matcher(body);
      if (match.find()) {
        setFieldList("CALL PLACE ADDR X ID TIME");
        data.strCallId = match.group(1);
        data.strTime = match.group(2);
        body = body.substring(0,match.start());
        
        parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_CROSS_FOLLOWS | FLAG_NO_IMPLIED_APT, body, data);
        data.strCross = getLeft();
        
        int pt = data.strCall.indexOf("  ");
        if (pt >= 0) {
          data.strPlace = data.strCall.substring(pt+2).trim();
          data.strCall = data.strCall.substring(0,pt);
        }
        return true;
      }
    }
    
    
    // No go, see if this matches an older format
    Matcher match = MARKER_PATTERN2.matcher(body);
    if (match.find()) {
      setFieldList("ADDR X PLACE ID TIME PHONE CALL");
      
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
    
    // Not luck oneitehr format
    return false;
  }
}
