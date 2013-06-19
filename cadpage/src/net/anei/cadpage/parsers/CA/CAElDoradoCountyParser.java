package net.anei.cadpage.parsers.CA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * El Dorado County, CA
 */

public class CAElDoradoCountyParser extends MsgParser {
  
  private static final Pattern MARKER = Pattern.compile("^(\\d{1,2}-\\w{3}-\\d{4})/(\\d\\d:\\d\\d:\\d\\d)[:;] ");
  private static final Pattern MASTER = Pattern.compile("^(.*?)[:;] Inc# (.*?)[:;] (.*?) *,([_A-Za-z]*?)[ ;](?:\\((.*?)\\) )? *(.*?)(?:;|$)");
  private static final Pattern B_ADDR = Pattern.compile("=[BL]\\(.*\\)");
  private static final DateFormat DATE_FMT = new SimpleDateFormat("dd-MMM-yyyy");
  
  public CAElDoradoCountyParser() {
    super("EL DORADO COUNTY", "CA");
    setFieldList("DATE TIME CALL ID ADDR CITY PLACE UNIT GPS");
  }
  
  @Override
  public String getFilter() {
    return "AEUCAD@fire.ca.gov";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD Page")) return false;
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    setDate(DATE_FMT, match.group(1), data);
    data.strTime = match.group(2);
    body = body.substring(match.end()).trim();
    
    match = MASTER.matcher(body);
    if (!match.find()) return false;
    
    data.strCall = match.group(1).trim();
    data.strCallId = match.group(2).trim();
    String addr = match.group(3).trim();
    if (!B_ADDR.matcher(addr).matches()) {
      int pt = addr.indexOf('@');
      if (pt >= 0) {
        data.strPlace = addr.substring(0,pt).trim();
        addr = addr.substring(pt+1).trim();
      }
    }
    parseAddress(addr, data);
    data.strCity = match.group(4).trim().replace('_', ' ');
    if (data.strCity.startsWith("GEORGETOWN ")) data.strCity = "GEORGETOWN";
    String sPlace = match.group(5);
    if (sPlace != null) data.strPlace = sPlace.trim();
    data.strUnit = match.group(6).trim();
    
    body = body.substring(match.end()).trim();
    if (body.startsWith(";") || body.startsWith(";")) body = body.substring(1).trim();
    if (body.endsWith(";") || body.endsWith(";")) body = body.substring(0,body.length()-1).trim();
    setGPSLoc(body, data);
    
    return true;
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS | MAP_FLG_SUPPR_LA;
  }
}
