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
  private static final Pattern DATE_TIME_PTN = Pattern.compile("[- ]*\\b(\\d\\d/\\d\\d/\\d\\d) +(\\d\\d:\\d\\d(?::\\d\\d)?)\\b[- ]*");
  private static final Pattern CITY_PTN = Pattern.compile("(.*?) *, *([A-Z ]+?) *, SD +\\d{5} *(.*?)");
  private static final Pattern CODE_PTN1 = Pattern.compile(" *\\bCode: *([-A-Z0-9]+): *");
  private static final Pattern CODE_PTN2 = Pattern.compile("^Code: *([-A-Z0-9]+): *");
  
  public SDPenningtonCountyParser() {
    super(CITY_LIST, "PENNINGTON COUNTY", "SD");
    setFieldList("UNIT CALL ADDR APT CITY CODE INFO DATE TIME");
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
    
    // Process Date/time splits 
    Matcher match = DATE_TIME_PTN.matcher(body);
    if (match.find()) {
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      String save = body.substring(0,match.start());
      int last = match.end();
      String info = "";
      while (match.find()) {
        data.strDate = match.group(1);
        data.strTime = match.group(2);
        info = append(info, "\n", body.substring(last,match.start()));
        last = match.end();
      }
      data.strSupp = append(info, "\n", body.substring(last));
      body = save;
    }
    
    String callAddr = null;
    match = CITY_PTN.matcher(body);
    if (match.matches()) {
      callAddr = match.group(1);
      data.strCity = match.group(2);
      body = match.group(3);
    } else {
      int pt = body.indexOf(',');
      if (pt >= 0) {
        String extra = body.substring(pt+1).trim();
        parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, extra, data);
        if (data.strCity.length() > 0) {
          callAddr =  body.substring(0,pt).trim();
          body = getLeft();
        }
      }
    }
    if (callAddr != null) {
      parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_IGNORE_AT | FLAG_NO_CITY | FLAG_ANCHOR_END, callAddr, data);
      if (data.strCode.length() == 0) {
        match = CODE_PTN2.matcher(body);
        if (match.find()) {
          data.strCode = match.group(1);
          body = body.substring(match.end());
        }
      }
      data.strSupp = append(data.strSupp, "\n", body);
    } else {
      parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_IGNORE_AT, body, data);
      if (data.strAddress.length() == 0) return false;
      String info = getLeft();
      match = CODE_PTN1.matcher(info);
      if (match.find()) {
        data.strCode = match.group(1);
        info = append(info.substring(0,match.start()), " / ", info.substring(match.end()));
      }
      data.strSupp = append(data.strSupp, "\n", info);
    }
    if (data.strCity.equals("PENNCO")) data.strCity = "";
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
