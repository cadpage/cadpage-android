package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class MORayCountyParser extends SmartAddressParser {
  
  private static final Pattern CROSS_DELIM_PTN = Pattern.compile(" +(\\d+\\.\\d+ mi [NSEW]{1,2})\\b");
  
  public MORayCountyParser() {
    super(CITY_TABLE, "RAY COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@raycounty911.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Parser p = new Parser(body);
    String sAddr = p.getOptional(" CrossStreets: ");
    if (sAddr.length() == 0) return false;
    parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sAddr, data);
    if (data.strCity.equals("RAY COUNTY")) data.strCity = "";
    
    String sLeft = p.get();
    while (true) {
      Matcher match = CROSS_DELIM_PTN.matcher(sLeft);
      if (!match.find()) break;
      String sCross = sLeft.substring(0,match.start()) + "/" + match.group(1);
      data.strCross = append(data.strCross, " / ", sCross);
      sLeft = sLeft.substring(match.end()).trim();
    }
    
    data.strCall = sLeft;
    return (data.strCall.length() > 0);
  }
  
  private static final String[] CITY_TABLE = new String[]{
    "CAMDEN",
    "CRYSTAL LAKES",
    "ELMIRA",
    "EXCELSIOR SPRINGS",
    "FLEMING",
    "HARDIN",
    "HENRIETTA",
    "HOMESTEAD",
    "HOMESTEAD VILLAGE",
    "LAWSON",
    "ORRICK",
    "RAYVILLE",
    "RICHMOND",
    "STET",
    "WOODS HEIGHTS",
    "RAY COUNTY"
  };
}
