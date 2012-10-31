package net.anei.cadpage.parsers.NY;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchRedAlertParser;



public class NYErieCountyRedAlertParser extends DispatchRedAlertParser {
  
  public NYErieCountyRedAlertParser() {
    super("ERIE COUNTY","NY");
    setupMultiWordStreets(
        "BOSTON STATE",
        "LOWER EAST HILL"
    );
  }

  @Override
  public String getFilter() {
    return "dispatch@townofhamburgny.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (body.startsWith("Erie_Alert ")) return false;
    if (body.startsWith("*2")) body = body.substring(2).trim();
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt);
    return super.parseMsg(subject, body, data);
  }
}
