package net.anei.cadpage.parsers.KY;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA29Parser;

/**
 * Gallatin County, KY
 */
public class KYGallatinCountyParser extends DispatchA29Parser {
  
  private static final Pattern US_HWY_PTN = Pattern.compile("\\bU +S\\b", Pattern.CASE_INSENSITIVE);
  
  public KYGallatinCountyParser() {
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

  private static final String[] CITY_LIST = new String[]{
    "GALLATIN COUNTY",
    "GLENCOE",
    "SPARTA",
    "WARSAW",
    
    "BOONE COUNTY",
    "NE VERONA",
    "VERONA",
    
    "CARROLL COUNTY",
    "SANDERS"
  };
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "46 TRAFFIC ACCIDENT-INJURIES",
      "8007 ASSIST ANOTHER AGENCY",
      "8015 LOUD MUSIC COMPLAINT",
      "8029 DOMESTIC COMPLAINT",
      "8038 JUVENILE PROBLEMS",
      "8081 SUSPICIOUS PERSON",
      "8086 THEFT",
      "8090 TRAFFIC COMPLAINT",
      "8106 VANDALISM",
      "8112 LOCK OUT",
      "8130 CUSTODY EXCHANGE",
      "8201 MEDICAL",
      "8215 REQUEST SPEAK OFFICER",
      "8216 WELFARE CHECK",
      "8218 ATTEMPT TO SERVE",
      "8220 COMPLAINT",
      "8223 TRAFFIC ACCIDENT NON-INJURY",
      "8227 1012",
      "8241 WEATHER ALERTS",
      "8245 1088",
      "8259 LINES DOWN (ELECTRIC, TELEPHONE, ETC.)",
      "8268 DOG BITE",
      "TRNSPRT NON-EMERGENCY TRANSPORT"
  );
}
