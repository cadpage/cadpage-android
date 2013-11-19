package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/**
 * Monterey County, CA
 */
public class CAMontereyCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("(?:(.*?) - )?([A-Z]{2,5}):(.*?) - (.*?)(?: - ([A-Z]{3}))? *(?:Units?:(.*?))?");
  
  public CAMontereyCountyParser() {
    super("MONTEREY COUNTY", "CA");
    setFieldList("MAP CODE CALL ADDR CITY UNIT INFO");
  }
  
  @Override
  public String getFilter() {
    return "donotreply@co.monterey.ca.us";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
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
    data.strCode = match.group(2);
    data.strCall = match.group(3).trim();
    parseAddress(match.group(4).trim(), data);
    String city = match.group(5);
    if (city != null) data.strCity = convertCodes(city, CITY_CODES);
    data.strUnit = getOptGroup(match.group(6));
    
    if (extra != null) {
      if (extra.startsWith("Message:")) extra = extra.substring(8).trim();
      data.strSupp = extra;
    }
    
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CHU", "CHUALAR",
      "GON", "GONZALES",
      "GRN", "GRNFIELD",
      "MCO", "",          // Monterey County
      "MTY", "MONTEREY",
      "PRU", "PRUNDALE",
      "SCO", "GONZALES",   // ??????? 
      "SOL", "SOLEDAD"
  });
}
