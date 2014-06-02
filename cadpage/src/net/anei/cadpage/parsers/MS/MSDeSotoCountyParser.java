package net.anei.cadpage.parsers.MS;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class MSDeSotoCountyParser extends SmartAddressParser {

  public MSDeSotoCountyParser() {
    super("DESOTO COUNTY", "MS");
    
    setFieldList("CALL ADDR APT X NAME");
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    //Disqualifiers
    if (subject.length() == 0) return false;
    if (!body.startsWith("911CENTER:")) return false;
    
    //CALL and remove 911CENTER: from body
    data.strCall = subject;
    body = body.substring(10);
    
    //ADDR
    parseAddress(StartType.START_ADDR, body, data);
    if (!isValidAddress()) return false;
    body = getLeft();
    
    //X (CV is a street abbreviation for cove)
    Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, body);
    if (res.isValid()) {
      res.getData(data);
      body = res.getLeft();
    }

    //NAME
    data.strName = cleanWirelessCarrier(body);

    return true;
  }

}
