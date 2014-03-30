package net.anei.cadpage.parsers.SC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/**
 * Kershire County, SC
 */
public class SCKershawCountyParser extends SmartAddressParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("As of (\\d\\d?/\\d\\d?/\\d\\d) \\d\\d");
  private static final Pattern MASTER_PTN = Pattern.compile("(\\d\\d:\\d\\d) (\\d{4}-\\d{8}) (\\d{4}[A-Z]) - (.*) Unit Org Name Area Types (.*)");

  public SCKershawCountyParser() {
    super( CITY_LIST, "KERSHAW COUNTY", "SC");
    setupCallList(CALL_LIST);
    setFieldList("DATE TIME ID CODE CALL ADDR APT CITY NAME UNIT");
  }
  
  @Override
  public String getFilter() {
    return "kershawcounty911@kershaw.sc.gov";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strDate = match.group(1);
    
    match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strTime = match.group(1);
    data.strCallId = match.group(2);
    data.strCode = match.group(3);
    String addr = match.group(4).trim();
    data.strUnit = match.group(5).trim();
    
    int pt = addr.lastIndexOf(',');
    if (pt >= 0) {
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, addr.substring(pt+1).trim(), data);
      if (data.strCity.length() > 0) {
        data.strName = stripFieldStart(getLeft(), data.strCity);
        addr = addr.substring(0,pt).trim().replace('@', '&');
        pt = addr.lastIndexOf(',');
        if (pt >= 0) {
          data.strCall = addr.substring(0,pt).trim();
          parseAddress(addr.substring(pt+1).trim(), data);
        } else {
          parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_NO_CITY | FLAG_ANCHOR_END, addr, data);
        }
        return true;
      }
    }
    
    addr = addr.replace('@', '&');
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, addr, data);
    data.strName = getLeft();
    return true;
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "FIRE ALARM SOUNDING",
      "MOTOR VEHICLE ACCIDENT",
      "STRUCTURE FIRE",
      "VEHICLE ACCIDENT",
      "WOODS, BRUSH"
  );
  
  private static final String[] CITY_LIST = new String[]{
    "ANTIOCH",
    "BETHUNE",
    "BOYKIN",
    "CAMDEN",
    "CASSATT",
    "ELGIN",
    "LIBERTY HILL",
    "LUGOFF",
    "WESTVILLE",
    
    // Chester County
    "JEFFERSON",
    
    // Lancaster County
    "KERSHAW"
  };
}
