package net.anei.cadpage.parsers.IL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Kankakee County, IL
Contact: "Steven Spraker" <sspraker@k3twpfire.com>
Sender: dispatchmessage@nwsmessage.net

[NWS Message]  ALARM:FIRE Location: KANKAKEE TERRACE 100 BELLE AIRE AVE Bourbonnais 05/27/11 05:29 Incident #: 2011-00001016
[NWS Message]  SMOKE/ODOR Location: COURT STREET FORD 558 WILLIAM LATHAM DR Bourbonnais 05/09/11 15:57 Incident #: 2011-00000889
[NWS Message]  WIRES DOWN Location: 968 N 2750E RD Kankakee 05/30/11 11:09 Incident #: 2011-00000111
[NWS Message]  AMB:MUTUAL AID Location: 4552/3400N RD 06/01/11 14:00 Incident #: 2011-00000113
[NWS Message]  AMBULANCE Location: 55 SAINT FRANCIS DR Bourbonnais 06/01/11 12:38 Incident #: 2011-00001056
[NWS Message] AMBULANCE Location: 1355 N  ARTHUR BURCH DR F11 Bourbonnais 06/03/11 14:32 Incident #: 2011-00001066
[NWS Message]  AMBULANCE Location: 874 EDWIN DR Bourbonnais 06/01/11 14:24 Incident #: 2011-00004870

*/


public class ILKankakeeCountyParser extends SmartAddressParser {
  
  private static final String[] CITY_LIST = new String[]{
    "KANKAKEE",
    "MOMENCE",

    "AROMA PARK",
    "BONFIELD",
    "BOURBONNAIS",
    "BRADLEY",
    "BUCKINGHAM",
    "CHEBANSE",
    "ESSEX",
    "GRANT PARK",
    "HERSCHER",
    "HOPKINS PARK",
    "IRWIN",
    "LIMESTONE",
    "MANTENO",
    "ST. ANNE",
    "REDDICK",
    "SAMMONS POINT",
    "SUN RIVER TERRACE",
    "UNION HILL",

    "PEMBROKE",
    "SOLLITT",
    "YEAGER",
    "PEWING",
  };
  
  private static final Pattern MASTER_PTN = 
      Pattern.compile("(.+) Location: (.+) \\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d Incident #: (.+)");
  private static final Pattern HOUSE_SLASH_PTN = Pattern.compile("^\\d+(/)[^ ]");
  
  public ILKankakeeCountyParser() {
    super(CITY_LIST, "KANKAKEE COUNTY", "IL");
  }
  
  @Override
  public String getFilter() {
    return "dispatchmessage@nwsmessage.net";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("NWS Message")) return false;
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.find()) return false;
    data.strCall = match.group(1).trim();
    String sAddr = match.group(2);
    Matcher match2 = HOUSE_SLASH_PTN.matcher(sAddr);
    if (match2.find()) sAddr = sAddr.substring(0,match2.start(1)) + " " + sAddr.substring(match2.end(1));
    parseAddress(StartType.START_PLACE, FLAG_ANCHOR_END, sAddr, data);
    data.strCallId = match.group(3);
    
    return true;
  }
}
