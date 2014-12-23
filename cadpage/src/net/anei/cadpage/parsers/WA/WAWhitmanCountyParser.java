package net.anei.cadpage.parsers.WA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA11Parser;

/**
 * Whitman County, NJ
 */
public class WAWhitmanCountyParser extends DispatchA11Parser {
  
  public WAWhitmanCountyParser() {
    super("WHITMAN COUNTY", "WA");
  }
  
  @Override
  public String getFilter() {
    return "markj@wsu.edu";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.startsWith("Call Complete Notification") || body.startsWith("Incident #: ")) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      return true;
    }
    
    if (subject.equals("test") || isPositiveId()) {
      String[] fields = body.split("\n");
      if (fields.length < 6) fields = body.split("  +"); 
      return super.parseFields(fields, 6, data);
    }
    else return false;
  }
  
 }
