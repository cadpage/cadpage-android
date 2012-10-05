package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;



public class COElPasoCountyParser extends MsgParser {
  
  public COElPasoCountyParser() {
    super("EL PASO COUNTY", "CO");
  }
  
  @Override
  public String getFilter() {
    return "ept@ept911.info";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (body.length() < 30) return false;
    if (!body.substring(6,9).equals(" - ")) return false;
    
    data.strSource = body.substring(0,6).trim();
    data.strCall = substring(body, 9, 29);
    parseAddress(substring(body, 29, 59), data);
    data.strPlace = substring(body, 59, 74);
    data.strSupp = substring(body, 74);
    return true;
  }
}
