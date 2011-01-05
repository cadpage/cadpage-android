package net.anei.cadpage.parsers;

import java.util.regex.Pattern;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.SmsMsgInfo.Data;

public class GeneralParser extends SmartAddressParser {
  
  private static final Pattern SPACE_FILTER = Pattern.compile("[\\s*:;,]+");
  
  public GeneralParser() {
    super("","");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Accept anything, but only if there is a valid sender filter
    if (ManagePreferences.filter().length() <= 1) return false;

    // convert normal separation characters to blanks
    body = SPACE_FILTER.matcher(body).replaceAll(" ");
    body = body.replaceAll("\n", " ");
    parseAddress(StartType.START_CALL, body, data);
    data.strSupp = getLeft();
    
    return true;
  }
}
