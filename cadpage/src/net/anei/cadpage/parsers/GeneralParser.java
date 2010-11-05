package net.anei.cadpage.parsers;

import net.anei.cadpage.ManagePreferences;
import net.anei.cadpage.SmsMsgInfo.Data;

public class GeneralParser extends SmsMsgParser {

  @Override
  public boolean isPageMsg(String body) {
    
    // Accept anything, but only if there is a valid sender filter
    return (ManagePreferences.filter().length() > 1);
  }

  @Override
  protected void parse(String body, Data data) {
    data.strCall = "General alert";
    data.strAddress = body;
  }
}
