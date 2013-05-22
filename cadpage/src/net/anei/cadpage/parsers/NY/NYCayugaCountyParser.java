package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYCayugaCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^(\\d\\d/\\d\\d/\\d\\d) (\\d\\d:\\d\\d) ");
  private static final Pattern PLACE_PTN = Pattern.compile("^[ A-Z]*[A-Z](?=\\d)");

  public NYCayugaCountyParser() {
    super(CITY_LIST, "CAYUGA COUNTY", "NY");
    setFieldList("DATE TIME PLACE ADDR CITY CALL INFO");
    setupMultiWordStreets("WEST LAKE");
  }
  
  @Override
  public String getFilter() {
    return "cayuga911@co.cayuga.ny.us,cayuga911@nameservices.net,cayuga911@www.cayugacounty.us,messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    boolean confirmed = subject.equals("From 911 Center") || subject.equals("From911Center");
    Matcher match = MARKER.matcher(body);
    if (!match.find()) {
      if (!confirmed) return false;
      data.strCall = "GENERAL ALERT";
      data.strPlace = body;
      return true;
    }
    data.strDate = match.group(1);
    data.strTime = match.group(2);
    body = body.substring(match.end()).trim();
    
    // They do not leave spaces between place names and street numbers :(
    StartType st = StartType.START_PLACE;
    match = PLACE_PTN.matcher(body);
    if (match.find()) {
      data.strPlace = match.group();
      body = body.substring(match.end());
      st = StartType.START_ADDR;
    }
    
    // See if there is a comma separating the address from the city.
    // If what follows the comma is not a recognized city, assume it is extraneous
    int pt = body.indexOf(',');
    if (pt >= 0) {
      Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, body.substring(pt+1).trim());
      if (res.getStatus() > 0) {
        parseAddress(st, FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, body.substring(0,pt).trim(), data);
        res.getData(data);
        data.strCall = res.getLeft();
      } else {
        pt = -1;
      }
    } 
    
    if (pt < 0) { 
      parseAddress(st, FLAG_IMPLIED_INTERSECT, body, data);
      data.strCall = getLeft();
    }
    if (data.strCall.length() > 30) {
      data.strSupp = data.strCall;
      data.strCall = "";
    }
    
    if (data.strCity.toUpperCase().endsWith(" ONONDAGA COUNTY")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-16).trim();
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "AUBURN",
    "AURELIUS", 
    "CAYUGA",
    "BRUTUS", 
    "WEEDSPORT",
    "CATO", 
    "MERIDIAN",
    "CONQUEST", 
    "FLEMING",
    "GENOA",
    "IRA",
    "LEDYARD", 
    "AURORA",
    "LOCKE",
    "MENTZ", 
    "PORT BYRON",
    "MONTEZUMA",
    "MORAVIA", 
    "NILES", 
    "OWASCO",
    "SCIPIO",
    "SEMPRONIUS",
    "SENNETT",
    "SPRINGPORT", 
    "UNION SPRINGS",
    "STERLING", 
    "FAIR HAVEN",
    "SUMMERHILL",
    "THROOP",
    "VENICE",
    "VICTORY",
    
    "ONONDAGA COUNTY",
    "SKANEATELES",
    "SKANEATELES ONONDAGA COUNTY"
  };
}
	