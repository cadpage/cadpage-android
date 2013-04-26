package net.anei.cadpage.parsers.IL;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class ILCookCountyParser extends MsgParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("(\\d\\d:\\d\\d:\\d\\d) (\\d\\d-\\d\\d-\\d{4})");
  private static final Pattern MASTER_PTN = Pattern.compile("\\*D (\\d{4} [A-Z0-9]+)/([^,]+) ,([A-Z]+)(?: \\((.*)\\))? (.*)");
  
  public ILCookCountyParser() {
    super("COOK COUNTY", "IL");
    setFieldList("TIME DATE CALL ADDR APT CITY PLACE UNIT");
  }
  
  @Override
  public String getFilter() {
    return "911@NWCDS.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strTime = match.group(1);
    data.strDate = match.group(2);
    
    match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strCall = match.group(1);
    parseAddress(match.group(2).trim(), data);
    data.strCity = convertCodes(match.group(3), CITY_CODES);
    data.strPlace = getOptGroup(match.group(4));
    data.strUnit = match.group(5).trim();
    
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "MP", "MT PROSPECT"
  });
}
