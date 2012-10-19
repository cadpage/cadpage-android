package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MOStoneCountyParser extends SmartAddressParser {
  
  private static final Pattern PHONE_PTN = Pattern.compile("\\b\\d{10}\\b");
  
  public MOStoneCountyParser() {
    super("STONE COUNTY", "MO");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!body.startsWith("911-CENTER:")) return false;
    body = body.substring(11).trim();
    String sInfo;
    Matcher match = PHONE_PTN.matcher(body);
    if (match.find()) {
      String sAddr = body.substring(0,match.start()).trim();
      parseAddress(StartType.START_CALL, FLAG_ANCHOR_END, sAddr, data);
      data.strPhone = match.group();
      sInfo = body.substring(match.end()).trim();
    } else {
      parseAddress(StartType.START_CALL, body, data);
      sInfo = getLeft();
    }
    
    Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, sInfo);
    if (res.getStatus() > 0) {
      res.getData(data);
      data.strSupp = res.getLeft();
    } else {
      data.strSupp = sInfo;
    }
    
    return true;
  }

}
