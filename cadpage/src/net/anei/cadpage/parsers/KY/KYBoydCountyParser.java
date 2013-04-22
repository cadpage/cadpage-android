package net.anei.cadpage.parsers.KY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class KYBoydCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("BC911:([A-Z0-9]{3}) (?:([-A-Z ]+\\*) )?(.*)");
  private static final Pattern FRK_ST_PTN = Pattern.compile("\\bFRK ST\\b"); 
 
  public KYBoydCountyParser() {
    super("BOYD COUNTY", "KY");
    setFieldList("UNIT CALL ADDR APT INFO");
  }
  
  @Override
  public String getFilter() {
    return "BC911@BOYD.KY";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    data.strUnit = match.group(1);
    String call = match.group(2);
    String addr = match.group(3);
    
    StartType st = StartType.START_CALL;
    if (call != null) {
      data.strCall = call.trim();
      st = StartType.START_ADDR;
    }
    
    int flags = 0;
    int pt = addr.indexOf(" Apt: ");
    if (pt > 0) {
      flags = FLAG_ANCHOR_END;
      String info = addr.substring(pt+6).trim();
      addr = addr.substring(0,pt).trim();

      Parser p = new Parser(info);
      data.strApt = p.getOptional(" Bldg");
      if (data.strApt.length() == 0) data.strApt = p.get(' ');
      data.strSupp = p.get();
    }
    
    parseAddress(st, flags | FLAG_IMPLIED_INTERSECT, addr, data);
    if (flags == 0) data.strSupp = getLeft();
    
    data.strAddress = FRK_ST_PTN.matcher(data.strAddress).replaceAll("FORK RD");
    
    return true;
  }
}
