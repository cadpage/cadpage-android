package net.anei.cadpage.parsers.OK;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;


public class OKPontotocCountyParser extends MsgParser {
  
  public OKPontotocCountyParser() {
    super("PONTOTOC COUNTY", "OK");
  }
  
  @Override
  public String getFilter() {
    return "paging@adaok.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("DispatchAlert")) return false;
    Parser p = new Parser(body);
    data.strApt = p.getLastOptional(", Apt.");
    data.strCall = p.get('\n');
    parseAddress(p.get(), data);
    return data.strAddress.length() > 0;
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return addr.replace("SH3W", "OK 3W");
  }
}
