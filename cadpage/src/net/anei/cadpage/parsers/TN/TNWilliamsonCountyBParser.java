package net.anei.cadpage.parsers.TN;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB3Parser;

public class TNWilliamsonCountyBParser extends DispatchB3Parser {

  public TNWilliamsonCountyBParser() {
    super("911-CENTER:", "WILLIAMSON COUNTY", "TN", B2_FORCE_CALL_CODE);
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@brentwood-notification-system.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // 615 is a naked area code.  Turn it into a phone number
    body = body.replace(" 615 ", " 6159999999 ");
    if (!super.parseMsg(subject, body, data)) return false;
    if (data.strPhone.equals("6159999999")) data.strPhone = "";
    return true;
  }
  
  
}
