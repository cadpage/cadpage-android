package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA20Parser;

/**
 * Umatilla County, OR
 */
public class ORUmatillaCountyParser extends DispatchA20Parser {
  
  public ORUmatillaCountyParser() {
    super("UMATILLA COUNTY", "OR");
  }
  
  @Override
  public String getFilter() {
    return "notifier@umatillacounty.net,dpspagesa@ctuir.org";
  }
 
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (subject.equals("(ACTIVE)")) subject = "Dispatched Call (XXX)";
    else if (subject.startsWith("(ACTIVE)|")) {
      subject = "Dispatched Call (XXX)|" + subject.substring(9);
    }
    if (!super.parseMsg(subject,  body, data)) return false;
    if (data.strUnit.equals("XXX")) data.strUnit = "";
    if (data.strAddress.equals("(UNKNOWN ADDRESS)") && data.strPlace.length() > 0) {
      data.strAddress = "";
      parseAddress(data.strPlace, data);
      data.strPlace = "";
    }
    return true;
  }
}
