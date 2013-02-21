package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;



public class COTellerCountyParser extends MsgParser {
  
  public COTellerCountyParser() {
    super("TELLER COUNTY", "CO");
  }
  
  @Override
  public String getFilter() {
    return "ept@ept911.info";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (body.length() >= 87 &&
        body.substring(0,5).equals("PROB:") &&
        body.substring(40,45).equals("ADD: ") &&
        body.substring(75,79).equals("APT:") &&
        body.substring(84,88).equals("LOC:")) { 
     
      setFieldList("ADDR CALL APT PLACE");
      parseAddress(substring(body, 5, 40), data);
      data.strCall = substring(body, 45, 75);
      data.strApt = substring(body, 79, 84);
      data.strPlace = substring(body, 88, 108);
      return true;
    }
    
    return false;
  }
}
