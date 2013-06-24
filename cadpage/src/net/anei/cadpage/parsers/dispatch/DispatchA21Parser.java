package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


abstract public class DispatchA21Parser extends MsgParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("(\\d\\d:\\d\\d:\\d\\d) (\\d\\d-\\d\\d-\\d{4})");
  private static final Pattern MASTER_PTN = Pattern.compile("\\*[DEU] (\\d{3,5} [A-Z0-9]+)/([^,]+) ,([A-Z]+)(?: <[ ,\\d]*>)?(?: \\((.*)\\))? ?(.*)");
  
  private Properties cityCodes;
  
  public DispatchA21Parser(Properties cityCodes, String defCity, String defState) {
    super(defCity, defState);
    setFieldList("TIME DATE CALL ADDR APT CITY PLACE UNIT");
    this.cityCodes = cityCodes;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strTime = match.group(1);
    data.strDate = match.group(2).replace('-', '/');
    
    match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strCall = match.group(1);
    String addr = match.group(2).trim();
    int pt = addr.indexOf('@');
    if (pt >= 0) {
      data.strPlace = addr.substring(0,pt).trim();
      addr = addr.substring(pt+1).trim();
    }
    parseAddress(addr, data);
    String city = match.group(3);
    if (cityCodes != null) city = convertCodes(city, cityCodes);
    data.strCity = city;
    data.strPlace = append(data.strPlace, " - ", getOptGroup(match.group(4)));
    data.strUnit = match.group(5).trim();
    
    return true;
  }
}
