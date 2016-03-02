package net.anei.cadpage.parsers.VA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Warren County, VA
 */
public class VAWarrenCountyParser extends DispatchSouthernParser {
  
  public VAWarrenCountyParser() {
    super(CITY_LIST, "WARREN COUNTY", "VA", DSFLAG_OPT_DISPATCH_ID | DSFLAG_FOLLOW_CROSS);
  }
  
  private static final Pattern SHORT_TIME_PREFIX_PTN = Pattern.compile("\\d\\d:\\d\\d ");
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Really wierd data mangling that I hope is never repeated anywhere :(
    if (subject.length() > 0 && SHORT_TIME_PREFIX_PTN.matcher(body).lookingAt()) {
      body = subject + " 9999999999 99:" + body;
    }
    if (!super.parseMsg(body, data)) return false;
    
    if (data.strCallId.equals("9999999999")) data.strCallId = "";
    if (data.strTime.startsWith("99:")) data.strTime = "";
    
    if (data.strCity.endsWith(" CO")) data.strCity += "UNTY";
    else if (data.strCity.endsWith(" Co")) data.strCity += "unty";
    return true;
  }

  @Override
  public String getFilter() {
    return "mailbox@warrencountysheriff.org";
  }

  private static final String[] CITY_LIST = new String[]{
    "FRONT ROYAL",
    "ASHBY",
    "BENTONVILLE",
    "BETHEL",
    "BROWNTOWN",
    "BUCKTON",
    "CEDARVILLE",
    "HAPPY CREEK",
    "HOWELLSVILLE",
    "KARO",
    "LIMETON",
    "LINDEN",
    "MILLDALE",
    "NINEVEH",
    "OVERALL",
    "RELIANCE",
    "RIVERTON",
    "ROCKLAND",
    "WATERLICK",
    
    // Clarke County
    "CLARKE CO",
    
    // Frederick County
    "FREDERICK CO",
    "MIDDLETOWN",
    
    // Shenendoah County
    "SHENENDOAH CO",
    "STRASBURG"
  };
}