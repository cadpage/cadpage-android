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
      "46 TRAFFIC ACCIDENT-INJURIES",
      "0560",
      "1015",
      "1015 1015",
      "45D TRAFFIC ACCIDENT - VS DEER",
      "8001 ALARM-BURGLAR-COMMERCIAL",
      "8007 ASSIST ANOTHER AGENCY",
      "8018 UNKNOWN PROBLEM",
      "8050 FIRE ALARM",
      "8111 MOTORIST ASSIST",
      "8014 BURGLARY-COMMERCIAL",
      "8015 LOUD MUSIC COMPLAINT",
      "8029 DOMESTIC COMPLAINT",
      "8032 DRIVING UNDER INFLUENCE",
      "8038 JUVENILE PROBLEMS",
      "8040 RESCUE/AMBULANCE",
      "8045 FIRE-GENERAL",
      "8081 SUSPICIOUS PERSON",
      "8086 THEFT",
      "8090 TRAFFIC COMPLAINT",
      "8106 VANDALISM",
      "8112 LOCK OUT",
      "8113 LOUD NOISE COMP",
      "8130 CUSTODY EXCHANGE",
      "8157 SUICIDAL SUBJECT",
      "8201 MEDICAL",
      "8215 REQUEST SPEAK OFFICER",
      "8216 WELFARE CHECK",
      "8218 ATTEMPT TO SERVE",
      "8220 COMPLAINT",
      "8223 TRAFFIC ACCIDENT NON-INJURY",
      "8224 B  AND  E",
      "8225 ABANDONED VEHICLE",
      "8227 1012",
      "8241 WEATHER ALERTS",
      "8245 1088",
      "8247 4-WHEELER COMPLAINT",
      "8249 ALCOHOL INTOXICATION",
      "8259 LINES DOWN (ELECTRIC, TELEPHONE, ETC.)",
      "8263 HARASSING COMMUNICATIONS",
      "8268 DOG BITE",
      "T808 TRAFFIC STOP",
      "SP SPEEDWAY POLICE",
      "TRNSPRT NON-EMERGENCY TRANSPORT"
  );
}
