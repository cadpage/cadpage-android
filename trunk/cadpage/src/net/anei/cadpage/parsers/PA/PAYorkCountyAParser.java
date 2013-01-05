package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class PAYorkCountyAParser extends SmartAddressParser {
  
  private static final Pattern TIME_PTN = Pattern.compile(" +(\\d\\d:\\d\\d)¿?$");
  private static final Pattern ID_PTN = Pattern.compile("^(\\d{7}) ");
  private static final Pattern CITY_PTN = Pattern.compile("^([A-Z ]+?) +(?:CITY|BORO|TWP)\\b *");
  private static final Pattern MAP_PTN = Pattern.compile("\\b(\\d{2}-\\d{2,3})\\b");
  private static final Pattern DELIM = Pattern.compile("\n\n|    *");
  private static final Pattern SRC_PTN = Pattern.compile("^(FIRESTA\\d+) ");
  
  public PAYorkCountyAParser() {
    super("YORK COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "FIRE@mantwp.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.length() > 0) {
      if (subject.startsWith("Station ")) data.strSource = subject;
    }
    
    Matcher match = TIME_PTN.matcher(body);
    if (match.find()) {
      data.strTime = match.group(1);
      body = body.substring(0,match.start()).trim();
    }
    
    if (body.startsWith("Fire Incident / ")) {
      body = body.substring(16).trim();
    }
    
    // See if there is a leading call number
    match = ID_PTN.matcher(body);
    if (match.find()) {
      data.strCallId = match.group(1);
      body = body.substring(match.end()).trim();
    }

    // There has to be a leading city
    match = CITY_PTN.matcher(body);
    if (!match.find()) return false;
    data.strCity = match.group(1);
    if (data.strCity.equals("MANCH")) data.strCity = "MANCHESTER";
    body = body.substring(match.end()).trim();
    
    match = MAP_PTN.matcher(body);
    String part3 = "";
    if (match.find()) {
      data.strMap = match.group(1);
      part3 = body.substring(match.end()).trim();
      body = body.substring(0,match.start()).trim();
    }
    
    // Hopefully we can find a clear delimiter separating the first message piece 
    // into two parts.  If not, use the smart address parser to break up the 
    // address field
    StartType st = StartType.START_PLACE;
    match = DELIM.matcher(body);
    if (match.find()) {
      // work on the message header
      // May contain a call description followed by slash
      data.strPlace = body.substring(0,match.start()).trim();
      body = body.substring(match.end()).trim();
      st = StartType.START_ADDR;
    } 
    
    body = body.replace(',', ' ');
    parseAddress(st, FLAG_IMPLIED_INTERSECT, body, data);

      // The address may be a simple address followed by a cross street
    String sAddr = getLeft();
    if (sAddr.startsWith("/")) sAddr = sAddr.substring(1).trim();
    parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT, sAddr, data);

    // Anything left should be the call description
    // If we don't find anything, the field we parsed as the cross street must be 
    // the call description
    data.strCall = getLeft();
    if (data.strCall.length() == 0) {
      data.strCall = data.strCross;
      data.strCross = "";
    }
    
    // last part may contain a station in first position.  Everything else is unit
    match = SRC_PTN.matcher(part3);
    if (match.find()) {
      data.strSource = match.group(1);
      part3 = part3.substring(match.end()).trim();
    }
    data.strUnit = part3;
    
    return true;
  }
}
