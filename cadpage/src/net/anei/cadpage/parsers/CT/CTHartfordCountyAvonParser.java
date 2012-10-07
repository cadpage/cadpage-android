package net.anei.cadpage.parsers.CT;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class CTHartfordCountyAvonParser extends SmartAddressParser {
  
  private static final Pattern UNIT_PTN = Pattern.compile("(?: +[A-Z]{0,3}\\d+)+$");
  private static final Pattern CROSS_DELIM_PTN = Pattern.compile(" Cross: | NA\\b");
  private static final Pattern LEAD_ZERO_PTN = Pattern.compile("^0+(?=\\d)");
  
  public CTHartfordCountyAvonParser() {
    super("AVON", "CT");
  }
  
  public CTHartfordCountyAvonParser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState);
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    body = body.replaceAll("  +", " ");
    Matcher match = UNIT_PTN.matcher(body);
    if (!match.find()) return false;
    data.strUnit = match.group().trim();
    body = body.substring(0,match.start()).trim();
    
    int flags = FLAG_CROSS_FOLLOWS;
    match = CROSS_DELIM_PTN.matcher(body);
    if (match.find()) {
      flags = FLAG_ANCHOR_END;
      data.strCross = body.substring(match.end()).trim();
      body = body.substring(0,match.start()).trim();
    }
    parseAddress(StartType.START_CALL, flags, body, data);
    if (data.strAddress.length() == 0) return false;
    if (flags == FLAG_CROSS_FOLLOWS) data.strCross = getLeft();
    
    match = LEAD_ZERO_PTN.matcher(data.strAddress);
    if (match.find()) data.strAddress = data.strAddress.substring(match.end());
    
    return true;
  }
}
