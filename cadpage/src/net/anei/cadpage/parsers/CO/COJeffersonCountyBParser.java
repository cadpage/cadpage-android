package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/**
 * Jefferson County, CO
 */
public class COJeffersonCountyBParser extends SmartAddressParser {
  

  public COJeffersonCountyBParser() {
    super("JEFFERSON COUNTY", "CO");
    setFieldList("ADDR CALL INFO");
  }

  @Override
  public String getFilter() {
    return "@jeffco.us";
  }
  
  @Override 
  public boolean parseMsg(String subject, String body, Data data) {
    if (checkAddress(subject) == 0)  return false;
    parseAddress(subject, data);
    if (body.length() <= 30) {
      data.strCall = body;
    } else {
      data.strSupp = body;
    }
    return true;
  }
}
  





