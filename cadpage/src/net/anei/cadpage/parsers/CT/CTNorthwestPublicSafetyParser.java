package net.anei.cadpage.parsers.CT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Roxbury, CT
 * Seymour, CT
 */
public class CTNorthwestPublicSafetyParser extends SmartAddressParser {
  
  private static final Pattern UNIT_PTN = Pattern.compile("\\b(?:ROX?|TANGO)\\b");

  public CTNorthwestPublicSafetyParser() {
    super(CITY_LIST, "", "CT");
  }
  
  @Override
  public String getLocName() {
    return "Northwest Public Safety, CT";
  }

  @Override
  public String getFilter() {
    return "globalpaging@nowestps.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("From Northwest")) return false;
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    Parser p = new Parser(body);
    String sAddr = p.get("Primary Incident:");
    data.strCallId = p.get(' ');
    if (data.strCallId.length() == 0) return false;
    
    sAddr = sAddr.replace(',', ' ').trim();
    parseAddress(StartType.START_ADDR, sAddr, data);
    body = getLeft();
    Matcher match = UNIT_PTN.matcher(body);
    if (match.find()) {
      data.strUnit = body.substring(match.start());
      body = body.substring(0,match.start()).trim();
    }
    data.strCall = body;
    return true;
  }
  
  private static String[] CITY_LIST = new String[]{
    "ROXBURY",
    "SEYMOUR",
    "WASHINGTON"
  };
}
