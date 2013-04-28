package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/**
 * Monterey County, CA
 */
public class CAMontereyCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("(?:(.*?) - )?([A-Z]{2,3}:.*?) - (.*?)(?:(?:Units?:(.*?))| - ([A-Z]{3}))");
  
  public CAMontereyCountyParser() {
    super("MONTEREY COUNTY", "CA");
    setFieldList("MAP CALL ADDR UNIT INFO");
  }
  
  @Override
  public String getFilter() {
    return "donotreply@co.monterey.ca.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CAD Page")) return false;
    
    int pt = body.indexOf('\n');
    String extra = null;
    if (pt >= 0) {
      extra = body.substring(pt+1).trim();
      body = body.substring(0,pt).trim();
    }
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    data.strMap = getOptGroup(match.group(1));
    data.strCall = match.group(2).trim();
    parseAddress(match.group(3).trim(), data);
    String sUnit = match.group(4);
    if (sUnit == null) sUnit = match.group(5);
    data.strUnit = sUnit.trim();
    
    if (extra != null) {
      if (extra.startsWith("Message:")) extra = extra.substring(8).trim();
      data.strSupp = extra;
    }
    
    return true;
  }
}
