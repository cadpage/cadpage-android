package net.anei.cadpage.parsers.GA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class GAPikeCountyParser extends SmartAddressParser {
  
  private static final Pattern PHONE_PTN = Pattern.compile("\\b\\d{10}\\b");
  private static final Pattern PHONE_TRAIL_PTN = Pattern.compile(" +\\d{3,}$");
  
  public GAPikeCountyParser() {
    super("PIKE COUNTY", "GA");
    setFieldList("CALL ADDR PLACE PHONE X");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!body.startsWith("PIKE COUNTY E-911:")) return false;
    body = body.substring(18).trim();
    
    String sAddr;
    Matcher match = PHONE_PTN.matcher(body);
    if (match.find()) {
      sAddr = body.substring(0,match.start()).trim();
      data.strPhone = match.group();
      data.strCross = body.substring(match.end()).trim();
    } else {
      sAddr = body;
      match = PHONE_TRAIL_PTN.matcher(sAddr);
      if (match.find()) sAddr = sAddr.substring(0,match.start()).trim();
    }
    
    sAddr = sAddr.replace('@', '&').replace(" AT ", " & ");
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, sAddr, data);
    data.strPlace = getLeft();
    if (data.strPlace.startsWith("/")) data.strPlace = data.strPlace.substring(1).trim();
    return true;
  }
}
