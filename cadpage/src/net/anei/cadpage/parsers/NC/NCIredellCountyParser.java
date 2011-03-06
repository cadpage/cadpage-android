package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/* 
Iredell county, NC
Contact: Jason Little <jason.little82@gmail.com>
Sender: CommtechMessenger@co.iredell.nc.us

FD20 C-5 FIRE ALARM, 347 JENNINGS RD
FR200 FALL, HAWKS RD
FD20 C-36 STAND BY AT BASE, 641 MOCKSVILLE HWY
FR200 MEDICAL ALARM, 142 NEW MEXICO DR
FD20 PUBLIC SERVICE, 106 KNOLLCREST LN

*/

public class NCIredellCountyParser extends SmsMsgParser {
  
  public NCIredellCountyParser() {
    super("IREDELL COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "CommtechMessenger@co.iredell.nc.us";
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
