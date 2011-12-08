package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Jackson County, IN
Contact: J.L McElfresh <jmcelfresh36@gmail.com>
Sender: @injacso.com
 
(medical run) 1047 E CR 400 S Wegan Church 80 y/o/f unconscious
(medical) 4904 W CR 440 N\n25yom Chest Pain
(Brownstown VFD) 10-50 Rollover 4062 N CR 225 W
(medical) 383 S Circle Dr medical unresponsive male
(medical run) 1047 E CR 400 S Wegan Church 80 y/o/f unconscious

*/

public class INJacksonCountyParser extends SmartAddressParser {
  
  public INJacksonCountyParser() {
    super("JACKSON COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "@injacso.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    do {
      if (subject.endsWith("FD")) {
        data.strSource = subject;
        break;
      }
      if (subject.contains("medical")) break;
    } while (false);
    
    parseAddress(StartType.START_CALL, body, data);
    String sExtra = getLeft();
    if (data.strCall.length() == 0) {
      data.strCall = sExtra;
    } else {
      data.strSupp = sExtra;
    }
    return true;
  }
}
