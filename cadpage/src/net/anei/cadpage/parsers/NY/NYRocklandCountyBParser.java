package net.anei.cadpage.parsers.NY;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NYRocklandCountyBParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("([^ ]+) +- +(.*?) +CROSS: *(.*?) +\\d\\d:\\d\\d \\d\\d.*");
  private static final Pattern ADDR_PTN = Pattern.compile("(.*?)   (?:(\\d{7}) - )?+(.*?)");
  
  public NYRocklandCountyBParser() {
    super("ROCKLAND COUNTY","NY");
  }

  @Override
  public String getFilter() {
    return "44_Control@verizon.net,9300";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strUnit = match.group(1);
    String sAddr = match.group(2);
    data.strCross = match.group(3);
    
    match = ADDR_PTN.matcher(sAddr);
    if (match.matches()) {
      data.strCall = match.group(1);
      data.strCallId = getOptGroup(match.group(2));
      sAddr = match.group(3);
      
      Result res = parseAddress(StartType.START_PLACE, FLAG_ANCHOR_END, sAddr);
      if (res.getStatus() == 0) {
        data.strAddress = sAddr;
      } else {
        res.getData(data);
      }
    }
    
    else {
      parseAddress(StartType.START_CALL, FLAG_ANCHOR_END, sAddr, data);
    }
    return true;
  }
}
