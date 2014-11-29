package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchGlobalDispatchParser;



public class KSAndoverParser extends DispatchGlobalDispatchParser {

  public KSAndoverParser() {
    super("ANDOVER", "KS");
  }
  
  @Override
  public String getFilter() {
    return "DispatchMail@andoverks.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if(!subject.equals("CAD Call")) return false;
    
    body = body.replace('\n', ' ');
    if (!super.parseMsg(subject, body, data)) return false;
    
    if (data.strCity.endsWith(" KS")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-3).trim();
    }
    return true;
  }
}
