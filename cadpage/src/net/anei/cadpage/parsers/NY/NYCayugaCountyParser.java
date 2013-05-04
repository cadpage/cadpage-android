package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NYCayugaCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^\\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d ");
  private static final Pattern PLACE_PTN = Pattern.compile("^[ A-Z]*[A-Z](?=\\d)");

  public NYCayugaCountyParser() {
    super(CITY_LIST, "CAYUGA COUNTY", "NY");
    setFieldList("PLACE ADDR CITY CALL INFO");
    setupMultiWordStreets("WEST LAKE");
  }
  
  @Override
  public String getFilter() {
    return "cayuga911@co.cayuga.ny.us,cayuga911@nameservices.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("From 911 Center") &&
        !subject.equals("From911Center")) return false;
    Matcher match = MARKER.matcher(body);
    if (!match.find()) {
      data.strCall = "GENERAL ALERT";
      data.strPlace = body;
      return true;
    }
    body = body.substring(match.end()).trim();
    
    // They do not leave spaces between place names and street numbers :(
    StartType st = StartType.START_PLACE;
    match = PLACE_PTN.matcher(body);
    if (match.find()) {
      data.strPlace = match.group();
      body = body.substring(match.end());
      st = StartType.START_ADDR;
    }
    parseAddress(st, FLAG_IMPLIED_INTERSECT, body, data);
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
    "VICTORY",
    
    "ONONDAGA COUNTY"
  };
  
}
	