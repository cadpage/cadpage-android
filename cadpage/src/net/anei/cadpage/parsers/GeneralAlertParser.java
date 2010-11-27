package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

public class GeneralAlertParser extends SmsMsgParser {

  @Override
  protected boolean parseMsg(String body, Data data) {

    // Everything goes in the call description
    data.strCall = body;
    return true;
  }
}
