package net.anei.cadpage.parsers.TN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class TNWarrenCountyParser extends DispatchEmergitechParser {
  
  private static final Pattern GEN_ALERT_PTN = Pattern.compile("WarrenCo911:\\[(\\d+)\\]-- *");

  public TNWarrenCountyParser() {
    super("WarrenCo911:", 0, CITY_LIST, "WARREN COUNTY", "TN");
  }
  
  @Override
  public String getFilter() {
    return "WarrenCo911@blomand.net";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (super.parseMsg(body, data)) return true;
    
    Matcher match = GEN_ALERT_PTN.matcher(body);
    if (!match.lookingAt()) return false;
    data.initialize(this);
    data.strUnit = match.group(1);
    body = body.substring(match.end());
    body = body.replace(" W INJURY", " W-INJURY");
    int pt = body.indexOf(" NEAR ");
    if (pt >= 0) body = body.substring(0,pt) + '&' + body.substring(pt+6);
    
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_IGNORE_AT, body, data);
    if (data.strAddress.length() == 0) {
      data.strPlace = data.strCall;
      data.strCall = "GENERAL ALERT";
    } else {
      setFieldList("CALL ADDR APT INFO");
      data.strSupp = getLeft();
    }
    data.strCall = data.strCall.replace("W-INJURY", "W/INJURY");
    data.strPlace = data.strPlace.replace("W-INJURY", "W/INJURY");
    if (pt > 0) {
      data.strAddress = data.strAddress.replace(" & ", " NEAR ");
    }
    return true;
  }

  private static final String[] CITY_LIST = new String[]{

    // Communities
    "CENTERTOWN",
    "MCMINNVILLE",
    "MORRISON",
    "VIOLA",

    // Unincorporated communities
    "BETHANY",
    "CAMPAIGN",
    "DAYLIGHT",
    "DIBRELL",
    "EASTSIDE",
    "FAIRVIEW",
    "HARRISON FERRY",
    "HIAWASSEE",
    "IRVING COLLEGE",
    "JACKSBORO",
    "LUCKY",
    "NEWTOWN",
    "ROCK ISLAND",
    "SMARTT",
    "VERVILLA",
    "WAYSIDE"

  };
}
