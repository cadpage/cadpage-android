package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NCIredellCountyParser extends MsgParser {
  
  private static final Pattern SRC_PTN = Pattern.compile("F[RD]\\d+|[A-Z]{1,2}FD");
  
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
    return (data.strAddress.length() > 0 && SRC_PTN.matcher(data.strSource).matches());
  }
}
