package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;

/**
 * Oxford, OH
 */
public class OHOxfordParser extends DispatchCiscoParser {
  
  public OHOxfordParser() {
    super(null, "OXFORD", "OH");
  }
  
  @Override
  public String getFilter() {
    return "cisco@cityofoxford.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() > 0 && !body.startsWith("Ct:")) {
      body = "Ct: " + subject + ' ' + body;
    }
    return super.parseMsg(body, data);
  }
}
