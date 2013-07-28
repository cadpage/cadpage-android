package net.anei.cadpage.parsers.NY;


import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchRedAlertParser;



public class NYNassauCountyRedAlertParser extends DispatchRedAlertParser {
  
  private static final Pattern JUNK_PTN = Pattern.compile(" *\\([A-Z]\\) *");
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "LAKE SUCCESS QUARD", "LAKE SUCCESS",
      "STRATHMORE VILLAGE", "STRATHMORE"
  });
  
  public NYNassauCountyRedAlertParser() {
    super("NASSAU COUNTY","NY");
  }

  @Override
  public String getFilter() {
    return super.getFilter() + ",alarms@rvcny.us,notifications@Plainviewfd.com,vtext.com@mxh3.email-od.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    body = body.replace('\n', ' ');
    if (!super.parseMsg(subject, body, data)) return false;
    
    // Supp info can have all kinds of fun things
    Parser p = new Parser(data.strSupp);
    data.strUnit = p.getLastOptional(", Response:");
    data.strMap = p.getLastOptional("Zone:");
    String sInfo = p.get();
    if (sInfo.endsWith(":")) sInfo = sInfo.substring(0, sInfo.length()-1).trim();
    data.strSupp = sInfo;
    
    // Some of the city names need to be adjusted
    data.strCity = convertCodes(data.strCity, CITY_CODES);
    
    // Clean paren stuff out of cross fields
    data.strCross = JUNK_PTN.matcher(data.strCross).replaceAll(" ");
    return true;
  }
}
