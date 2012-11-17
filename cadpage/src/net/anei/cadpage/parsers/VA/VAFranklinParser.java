package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Franlin County, VA (B)
 */
public class VAFranklinParser extends DispatchSouthernParser {
  
  private static final Pattern CALL_PATTERN = Pattern.compile("([A-Z0-9 ]+- [A-Z0-9]+) +(.*)");
  
  public VAFranklinParser() {
    super(CITY_LIST, "FRANKLIN", "VA", 
           DSFLAG_DISPATCH_ID | DSFLAG_LEAD_PLACE | DSFLAG_CROSS_NAME_PHONE | DSFLAG_ID_OPTIONAL);
  }

  @Override
  public String getFilter() {
    return "@franklinpolice.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) {
      Matcher match = CALL_PATTERN.matcher(data.strSupp);
      if (match.matches()) {
        data.strCall = match.group(1);
        data.strSupp = match.group(2).trim();
      }
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "FRANKLIN"
  };
}