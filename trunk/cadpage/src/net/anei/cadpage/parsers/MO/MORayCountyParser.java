package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Ray County, MO
Contact: "Chief O'Dell" <leeodell@woodheightsfire.com>
Sender: raycountycentraldispatch@gmail.com
HIGHWAY Y RAY COUNTY CrossStreets: 10-50 TRAFFIC/TRANSPORT INCIDENT (CRASH)
14851 HIGHWAY Y CRYSTAL LAKES CrossStreets: BEACH DR 0.09 mi N RAVENWOOD DR 0.00 mi W OUTSIDE FIRE
15659 HIGHWAY Y RAY COUNTY CrossStreets: PINE RD 0.07 mi N W 158TH ST 0.10 mi S OUTSIDE FIRE
107 S DONNA DR RAY COUNTY CrossStreets: W DONNA DR 0.02 mi NE CAROL LN 0.05 mi S OUTSIDE FIRE
4364 HIGHWAY 10 RAY COUNTY CrossStreets: MOCKINGBIRD LN 0.18 mi NW LITTLE FARM RD 0.17 mi SE STROKE (CVA)
4684 HIGHWAY 10 RAY COUNTY CrossStreets: CROWLEY RD 0.20 mi NW SHORT RD 0.30 mi SE FIRE ALARM

Contact: Active911
[] 15659 HIGHWAY Y RAY COUNTY CrossStreets: PINE RD 0.07 mi N W 158TH ST 0.10 mi S OUTSIDE FIRE\r\n\r\n\r\n\r\n\r\n\r\n
[] 14851 HIGHWAY Y CRYSTAL LAKES CrossStreets: BEACH DR 0.09 mi N RAVENWOOD DR 0.00 mi W OUTSIDE FIRE\r\n\r\n\r\n\r\n\r\n\r\n
[] HIGHWAY Y RAY COUNTY CrossStreets: 10-50 TRAFFIC/TRANSPORT INCIDENT (CRASH)\r\n\r\n\r\n\r\n\r\n\r\n
[] HIGHWAY 10 & W 133RD ST RAY COUNTY CrossStreets: OUTSIDE FIRE\r\n\r\n\r\n\r\n\r\n\r\n
[] 18347 N UNION RD RAY COUNTY CrossStreets: HIGHWAY C 0.40 mi S MUTUAL AID/ASSIST OUTSIDE AGENCIES\r\n\r\n\r\n\r\n\r\n\r\n

*/


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
