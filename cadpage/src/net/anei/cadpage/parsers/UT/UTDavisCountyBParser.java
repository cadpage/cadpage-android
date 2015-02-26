package net.anei.cadpage.parsers.UT;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class UTDavisCountyBParser extends MsgParser {
  
  public UTDavisCountyBParser() {
    super("DAVIS COUNTY", "UT");
  }
  
  @Override
  public String getFilter() {
    return "paging@daviscountyutah.gov";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (body.length() > 79 && body.charAt(15) == '\n' && body.charAt(76) == ' ' && body.charAt(77) != ' ') {
      setFieldList("CALL ADDR APT PLACE CITY INFO");
      FParser p = new FParser(body);
      data.strCall = p.get(15);
      if (!p.check("\n")) return false;
      String addr = p.get(60);
      int pt = addr.indexOf(';');
      if (pt >= 0) {
        data.strPlace = addr.substring(pt+1).trim();
        addr = addr.substring(0,pt).trim();
      }
      parseAddress(addr, data);
      if (!p.check(" ")) return false;
      data.strCity = p.get(15);
      p.setOptional();
      if (!p.check("\n")) return false;
      data.strSupp = p.get();
      return true;
    }
    
    return false;
  }
}
