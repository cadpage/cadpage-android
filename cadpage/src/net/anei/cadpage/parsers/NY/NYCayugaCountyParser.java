package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYCayugaCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("\\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d ");

  public NYCayugaCountyParser() {
    super(CITY_LIST, "CAYUGA COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "cayuga911@co.cayuga.ny.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("From 911 Center") &&
        !subject.equals("From911Center")) return false;
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    parseAddress(StartType.START_ADDR, body, data);
    data.strCall = getLeft();
    if (data.strCall.length() > 30) {
      data.strSupp = data.strCall;
      data.strCall = "";
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{

    "AUBURN",
    "AURELIUS", "CAYUGA",
    "BRUTUS", "WEEDSPORT",
    "CATO", "MERIDIAN", "CATO",
    "CONQUEST", 
    "FLEMING",
    "GENOA",
    "IRA",
    "LEDYARD", "AURORA",
    "LOCKE",
    "MENTZ", "PORT BYRON",
    "MONTEZUMA",
    "MORAVIA", "MORAVIA",
    "NILES", 
    "OWASCO",
    "SCIPIO",
    "SEMPRONIUS",
    "SENNETT",
    "SPRINGPORT", "UNION SPRINGS",
    "STERLING", "FAIR HAVEN",
    "SUMMERHILL",
    "THROOP",
    "VENICE",
    "VICTORY"
  };
  
}
	