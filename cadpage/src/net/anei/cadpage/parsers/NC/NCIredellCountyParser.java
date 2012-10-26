package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NCIredellCountyParser extends MsgParser {
  
  public NCIredellCountyParser() {
    super("IREDELL COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "CommtechMessenger,@co.iredell.nc.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Parser p = new Parser(body);
    data.strSource = p.get(' ');
    data.strCall = p.get(',');
    data.strAddress = p.get();
    return (data.strAddress.length() > 0);
  }
}
