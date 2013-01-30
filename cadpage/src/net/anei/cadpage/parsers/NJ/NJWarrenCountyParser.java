package net.anei.cadpage.parsers.NJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


/**
 * Warren County, NJ
 */
public class NJWarrenCountyParser extends SmartAddressParser {
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile(" +\\(SENT (\\d\\d/\\d\\d) (\\d\\d:\\d\\d)\\)$");
  private static final Pattern REGULAR_MARKER = Pattern.compile("^([A-Z0-9]+) ALERT: +");
  private static final Pattern HAZMAT_MASTER = Pattern.compile("^([A-Z0-9]+ HAZMAT) L-\\d RESPONSE REQUESTED: *(.*?) AT ([^,/]+)(?:/([^,]+))?,([^,]+),([^,]+)");
  private static final Pattern DELIM = Pattern.compile(" *, +");
  private static final Pattern CITY_TRIM_PTN = Pattern.compile(" (?:BORO|TOWN)$");
  
  public NJWarrenCountyParser() {
    super(CITY_LIST, "WARREN COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "WC911@co.warren.nj.us";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    String[] lines = body.split("\n");
    body = lines[0];
    Matcher match = DATE_TIME_PTN.matcher(body);
    if (!match.find()) return false;
    data.strDate = match.group(1);
    data.strTime = match.group(2);
    body = body.substring(0,match.start());
    
    // There are two calls, regular and hazmat, with slightly different formats
    // Let's handle the regular one first
    match = REGULAR_MARKER.matcher(body);
    if (match.find()) {
      
      data.strUnit = match.group(1);
      String sAddr = body.substring(match.end());
      
      // Sometimes there are nice comma delimiters
      String[] flds = DELIM.split(sAddr);
      if (flds.length == 3) {
        data.strCall = flds[0];
        data.strCity = flds[2];
        
        String addr = flds[1];
        String[] parts = addr.split(" / ");
        if (parts.length == 2 && checkAddress(parts[0]) == 0) {
          data.strPlace = parts[0].trim();
          addr = parts[1].trim();
        }
        parseAddress(addr, data);
      }
      
      // and sometimes there are not
      else {
        parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, sAddr, data);
      }
      
      // Clean up odd things in call and city fields
      if (data.strCall.endsWith("/")) data.strCall = data.strCall.substring(0,data.strCall.length()-1).trim();
      match = CITY_TRIM_PTN.matcher(data.strCity);
      if (match.find()) data.strCity = data.strCity.substring(0,match.start());
      
      if (lines.length > 1) {
        String cross = lines[1];
        if (cross.startsWith("Cross Streets-")) {
          data.strCross = cross.substring(14).trim();
        }
      }
      return true;
    }
    
    // No such luck, see if this has a Hazmat marker
    match = HAZMAT_MASTER.matcher(body);
    if (match.matches()) {
      data.strUnit = match.group(1);
      data.strCall = match.group(2).trim();
      String tmp = match.group(3).trim();
      if (checkAddress(tmp) > 0) {
        parseAddress(tmp, data);
      } else {
        data.strPlace = tmp;
      }
      tmp = getOptGroup(match.group(4));
      if (tmp.length() > 0) {
        if (data.strAddress.length() == 0 && checkAddress(tmp) > 0) {
          parseAddress(tmp, data);
        } else {
          data.strPlace = append(data.strPlace, " / ", tmp);
        }
      }
      
      data.strSupp = match.group(6).trim();
      tmp = match.group(5).trim();
      if (isCity(tmp)) {
        data.strCity = tmp;
      } else {
        data.strSupp = append(tmp, " / ", data.strSupp);
      }
      return true;
    }
    
    // Strike out
    return false;
  }
  
  private static String[] CITY_LIST = new String[]{
    "ALLAMUCHY TWP",
    "ALLAMUCHY-PANTHER VALLEY",
    "ALPHA BORO",
    "BELVIDERE TOWN",
    "BEATYESTOWN",
    "BLAIRSTOWN TWP",
    "BRASS CASTLE",
    "FRANKLIN TWP",
    "FRELINGHUYSEN TWP",
    "GREAT MEADOWS-VIENNA",
    "GREENWICH TWP",
    "HACKETTSTOWN TOWN",
    "HARDWICK TWP",
    "HARMONY TWP",
    "HOPE TWP",
    "INDEPENDENCE TWP",
    "KNOWLTON TWP",
    "LIBERTY TWP",
    "LOPATCONG TWP",
    "MANSFIELD TWP",
    "OXFORD",
    "OXFORD TWP",
    "PHILLIPSBURG TOWN",
    "POHATCONG TWP",
    "PORT MURRAY",
    "WASHINGTON BORO",
    "WASHINGTON TWP",
    "WHITE TWP",
  };
}
