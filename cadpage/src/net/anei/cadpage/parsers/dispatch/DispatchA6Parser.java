package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchA6Parser extends SmartAddressParser {
  
  public DispatchA6Parser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState);
    setFieldList("CALL ID MAP DATE ADDR APT CITY PLACE ID X INFO TIME UNIT");
  }
  
  private static final Pattern LEAD_DATE_PAT = Pattern.compile("^(?:([- A-Z0-9]+) )?(?:(?:Ic# +(.*?) +Ds# ([^ ]*?) (?:Al# ([^ ]*?))? Utl# (?:([^ ]*?) +)?)?(\\d\\d/\\d\\d/\\d\\d)|\\^ )");
  private static final Pattern CROSS_MARK_PAT = Pattern.compile(" :\\\\?\\( *(\\d*) *\\) | <> ");
  private static final Pattern TIME_UNIT_PAT = Pattern.compile("(?<!\\d)(\\d{4}),(\\d{3})");
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = LEAD_DATE_PAT.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    data.strCall = getOptGroup(match.group(1));
    String call = match.group(2);
    if (call != null) {
      data.strCall = call;
      data.strCallId = append(match.group(3), "-", getOptGroup(match.group(4)));
      data.strMap = getOptGroup(match.group(5));
    }
    if (data.strDate.length() == 0) data.strDate = getOptGroup(match.group(6));
    
    match = CROSS_MARK_PAT.matcher(body);
    if (!match.find()) return false;
    String crossNumber = match.group(1);
    
    String sAddr = body.substring(0,match.start()).replace('{', ' ').replace('}', ' ').trim();
    int pt = sAddr.lastIndexOf('#');
    if (pt >= 0) {
      data.strPlace = sAddr.substring(pt+1).trim();
      sAddr = sAddr.substring(0,pt).trim();
    }
    parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sAddr, data);
    body = body.substring(match.end()).trim();
    
    match = TIME_UNIT_PAT.matcher(body);
    if (match.find()) {
      String time = match.group(1);
      if (data.strTime.length() == 0) data.strTime = time.substring(0,2) + ":" + time.substring(2);
      if (data.strUnit.length() == 0) data.strUnit = match.group(2);
      
      body = match.replaceAll(" / ").replaceAll("  +", " ").trim();
      if (body.endsWith("/")) body = body.substring(0,body.length()-1).trim();
    }
    
    Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, body);
    if (res.getStatus() > 0) {
      res.getData(data);
      data.strSupp = res.getLeft();
      if (crossNumber != null) data.strCross = append(crossNumber, " ", data.strCross);
    } else {
      data.strSupp = body;
    }
    
    return true;
  }
}
