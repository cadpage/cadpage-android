package net.anei.cadpage.parsers;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.SmsMsgInfo.Data;

public class GeneralParser extends SmartAddressParser {

  @Override
  public boolean isPageMsg(String body) {
    
    // Accept anything, but only if there is a valid sender filter
    return (ManagePreferences.filter().length() > 1);
  }

  @Override
  protected void parse(String body, Data data) {

    // Lets see what the smart parser can make of this
    body = body.replaceAll("\n", " ");
    parseAddress(StartType.START_CALL, body, data);
  }
}
