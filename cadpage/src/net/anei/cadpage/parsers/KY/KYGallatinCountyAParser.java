package net.anei.cadpage.parsers.KY;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA29Parser;

/**
 * Gallatin County, KY
 */
public class KYGallatinCountyAParser extends DispatchA29Parser {
  
  private static final Pattern US_HWY_PTN = Pattern.compile("\\bU +S\\b", Pattern.CASE_INSENSITIVE);
  
  public KYGallatinCountyAParser() {
    super(CITY_LIST, "GALLATIN COUNTY", "KY");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "CEDAR POINTE",
        "DRY CREEK",
        "EAGLE TUNNEL",
        "VERA CRUZ",
        "STEELES BOTTOM",
        "WILLOW POINTE"
    );
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    body = US_HWY_PTN.matcher(body).replaceAll("US");
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equalsIgnoreCase("GALLATIN COUNTY")) data.strCity = "";
    
    // Sometimes intersections need an implied &
    String addr = data.strAddress;
    if (!addr.contains("&")) {
      data.strAddress = "";
      parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS | FLAG_IMPLIED_INTERSECT | FLAG_NO_IMPLIED_APT | FLAG_ANCHOR_END, addr, data);
    }
    return true;
  }

  @Override
  protected void parseAddress(StartType sType, int flags, String address, Data data) {
    address = address.replace('@', '&');
    super.parseAddress(sType, flags, address, data);
  }

  private static final String[] CITY_LIST = new String[]{
    "GALLATIN COUNTY",
    "GLENCOE",
    "SPARTA",
    "WARSAW",
    
    "BOONE COUNTY",
    "NE VERONA",
    "VERONA",
    
    "CARROLL COUNTY",
    "GHENT",
    "SANDERS",
    
    "KENTON COUNTY",
    "ERLANGER"
  };
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "1015",
      "4-WHEELER COMPLAINT",
      "ABANDONED VEHICLE",
      "ALARM-BURGLAR-COMMERCIAL",
      "ALCOHOL INTOXICATION",
      "ASSIST ANOTHER AGENCY",
      "ATTEMPT TO SERVE",
      "B  AND  E",
      "BURGLARY-COMMERCIAL",
      "COMPLAINT",
      "CUSTODY EXCHANGE",
      "DOG BITE",
      "DOMESTIC COMPLAINT",
      "DRIVING UNDER INFLUENCE",
      "FIRE ALARM",
      "FIRE-GENERAL",
      "HARASSING COMMUNICATIONS",
      "JUVENILE PROBLEMS",
      "LINES DOWN (ELECTRIC, TELEPHONE, ETC.)",
      "LOCK OUT",
      "LOUD MUSIC COMPLAINT",
      "LOUD NOISE COMP",
      "MEDICAL",
      "MOTORIST ASSIST",
      "NON-EMERGENCY TRANSPORT",
      "REQUEST SPEAK OFFICER",
      "RESCUE/AMBULANCE",
      "SPEEDWAY POLICE",
      "SUICIDAL SUBJECT",
      "SUSPICIOUS PERSON",
      "THEFT",
      "TRAFFIC ACCIDENT NON-INJURY",
      "TRAFFIC ACCIDENT-INJURIES",
      "TRAFFIC ACCIDENT - VS DEER",
      "TRAFFIC COMPLAINT",
      "TRAFFIC STOP",
      "UNKNOWN PROBLEM",
      "VANDALISM",
      "WEATHER ALERTS",
      "WELFARE CHECK"
  );
}
