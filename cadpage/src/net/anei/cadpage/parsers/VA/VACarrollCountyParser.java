package net.anei.cadpage.parsers.VA;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;



public class VACarrollCountyParser extends DispatchDAPROParser {
  
  private static final Pattern LEAD_ZERO_PTN = Pattern.compile("^0+ *");
  
  public VACarrollCountyParser() {
    super("CARROLL COUNTY", "VA");
  }
  
  @Override
  public String getFilter() {
    return "MAILBOX@GalaxVa.com,pm_bounces@pm.mtasv.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!body.startsWith("MAILBOX:")) return false;
    body = body.substring(8).trim();
    if (!super.parseMsg(body, data)) return false;
    data.strAddress = LEAD_ZERO_PTN.matcher(data.strAddress).replaceFirst("");
    return true;
  }
}