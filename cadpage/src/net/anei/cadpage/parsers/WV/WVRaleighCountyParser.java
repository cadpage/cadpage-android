package net.anei.cadpage.parsers.WV;


import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;


public class WVRaleighCountyParser extends DispatchBParser {
  
  public WVRaleighCountyParser() {
    super("RALEIGH COUNTY", "WV");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("RALEIGH911:");
  }

  @Override
  protected boolean parseAddrField(String field, Data data) {
    if (field.startsWith("RALEIGH911:Return Phone:")) {
      Parser p = new Parser(field.substring(24).trim());
      data.strPhone = p.get(' ');
      p.get(' ');
      field = p.get();
    }
    return super.parseAddrField(field, data);
  }
}