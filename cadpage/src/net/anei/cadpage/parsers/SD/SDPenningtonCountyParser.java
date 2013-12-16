package net.anei.cadpage.parsers.SD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/**
 * Pennington County, SD
 */
public class SDPenningtonCountyParser extends SmartAddressParser {
  
  private static final Pattern UNIT_PTN = Pattern.compile("^([A-Z0-9]+) +\\(Primary\\);? *");
  private static final Pattern CITY_PTN = Pattern.compile("(.*?) *, *([A-Z ]+?) *, SD +\\d{5} *(.*?)");
  
  public SDPenningtonCountyParser() {
    super(CITY_LIST, "PENNINGTON COUNTY", "SD");
    setFieldList("UNIT CALL ADDR APT CITY INFO");
  }

  @Override
  public String getFilter() {
    return "dispatch@co.pennington.sd.us,dispatch@pennco.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equalsIgnoreCase("Dispatch")) return false;
    
    // Parser unit information
    while (true) {
      Matcher match = UNIT_PTN.matcher(body);
      if (!match.find()) break;
      data.strUnit = append(data.strUnit, " ", match.group(1));
      body = body.substring(match.end());
    }
    if (data.strUnit.length() == 0) return false;
    
    String callAddr;
    Matcher  match = CITY_PTN.matcher(body);
    if (match.matches()) {
      callAddr = match.group(1);
      data.strCity = match.group(2);
      data.strSupp = match.group(3);
    } else {
      int pt = body.indexOf(',');
      if (pt < 0) return false;
      callAddr =  body.substring(0,pt).trim();
      body = body.substring(pt+1).trim();
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, body, data);
      if (data.strCity.length() == 0) return false;
      data.strSupp = getLeft();
    }
    if (data.strCity.equals("PENNCO")) data.strCity = "";
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, callAddr, data);
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "PENNCO",
    
    "ASHLAND HEIGHTS",
    "COLONIAL PINE HILLS",
    "CREIGHTON",
    "GREEN VALLEY",
    "HILL CITY",
    "KEYSTONE",
    "NEW UNDERWOOD",
    "OWANKA",
    "QUINN",
    "RAPID CITY",
    "RAPID VALLEY",
    "WALL",
    "WASTA",
    "WICKSVILLE",
    "PENNCO",
    
    "ELK VALE",
    "ELLSWORTH AFB",
    "MUD BUTTE",
    "PIEDMONT",
    "TILFORD",
    "WHITE OWL",
    "BOX ELDER",
    "STURGIS",
    "BLACKHAWK",
    "SUMMERSET",
    "FAITH",
    "MEADCO"
  };
}
