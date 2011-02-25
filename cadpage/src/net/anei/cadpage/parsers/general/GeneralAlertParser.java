package net.anei.cadpage.parsers.general;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

public class GeneralAlertParser extends SmsMsgParser {
  
  public GeneralAlertParser() {
    super("", "");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    // Everything goes in the place name.  Odd choice, but it comes out 
    // looking right without a prefix keyword.  if we put the entire text
    // in the call field it won't wrap more than two lines.
    data.strCall = "GENERAL ALERT";
    data.strPlace = body;
    return true;
  }
}
