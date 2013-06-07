package net.anei.cadpage.parsers.dispatch;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

public class DispatchB3Parser extends DispatchB2Parser {
  
  private String prefix;

  public DispatchB3Parser(String prefix, String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState);
    setupCallList((CodeSet)null);
    this.prefix = prefix;
  }
  
  @Override
 protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    if (!body.startsWith(prefix)) return false;
    body = subject + " @ " + body.substring(prefix.length()).trim();
    return super.parseMsg(body, data);
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    if (prefix.length() > 0) return true;
    return super.isPageMsg(body);
  }
}
