package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;


public class COTellerCountyParser extends MsgParser {
  
  public COTellerCountyParser() {
    super("TELLER COUNTY", "CO");
    setFieldList("ADDR APT PLACE CALL CITY");
  }
  
  @Override
  public String getFilter() {
    return "ept@ept911.info";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    FParser p = new FParser(body);
    if (p.check("Add: ")) {
      parseAddress(p.get(35), data);
      data.strPlace = p.get(35);
      if (!p.check("Problem: ")) return false;
      data.strCall = p.get(35);
      if (!p.check("City: ")) return false;
      data.strCity = p.get();
      return true;
    }
    
    if (p.check("Add")) {
      String addr = p.getOptional(30, "Problem");
      if (addr != null) {
        parseAddress(addr, data);
        data.strCall = p.get();
        return true;
      }
      parseAddress(p.get(35), data);
      data.strPlace = p.get(35);
      if (!p.check("Problem")) return false;
      data.strCall = p.get(35);
      if (!p.check("City")) return false;
      data.strCity = p.get(35);
      return true;
    }
    return false;
  }
}
