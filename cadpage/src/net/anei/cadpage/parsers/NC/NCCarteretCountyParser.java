package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Carteret county, NC
 */
public class NCCarteretCountyParser extends DispatchSouthernParser {
  
  private final static Pattern SUB_MARKER = Pattern.compile("^CEC:\\d\\d:\\d\\d[ ,]");
  private final static Pattern SUB_TRAILER = Pattern.compile(" \\d\\d$");
  private final static Pattern CALL_ID_PTN = Pattern.compile(" +OCA: *(\\d\\d-\\d\\d-\\d{4})$");
  
  public NCCarteretCountyParser() {
    super(CITY_LIST, "CARTERET COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "cec@carteretcountygov.org,@sealevelfire-rescue.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    subject = subject.trim();
    boolean badTime = false;
    if (subject.length() > 0 && SUB_MARKER.matcher(body).find()) {
      if (!SUB_TRAILER.matcher(subject).find()) {
        subject += " 00";
        badTime = true;
      }
      body = "CEC:" + subject + ':' + body.substring(4);
    }
    body = body.replace(",", "");
    
    Matcher match = CALL_ID_PTN.matcher(body);
    String callId = "";
    if (match.find()) {
      callId = match.group(1);
      body = body.substring(0,match.start());
    }
    
    if (!super.parseMsg(body, data)) return false;
    if (badTime) data.strTime = "";
    
    if (data.strCallId.length() == 0) data.strCallId = callId;
    
    // Sometimes city name is duplicated in address
    // which ends up as the place name
    if (data.strCity.equals(data.strPlace)) data.strPlace = "";
    return true;
  }
  

  private static final String[] CITY_LIST = new String[]{
    "ATLANTIC BEACH",
    "BEAUFORT",
    "BOGUE",
    "CAPE CARTERET",
    "CEDAR POINT",
    "EMERALD ISLE",
    "INDIAN BEACH",
    "MOREHEAD CITY",
    "NEWPORT",
    "PELETIER",
    "PINE KNOLL SHORES",
    
    "ATLANTIC",
    "BETTIE",
    "BROAD CREEK",
    "CEDAR ISLAND",
    "DAVIS",
    "GALES CREEK",
    "GLOUCESTER",
    "HARKERS ISLAND",
    "HARLOWE",
    "LOLA",
    "MARSHALLBERG",
    "MERRIMON",
    "MILL CREEK",
    "NORTH RIVER",
    "OCEAN",
    "OTWAY",
    "SALTER PATH",
    "SEA GATE",
    "SEA LEVEL",
    "STACY",
    "STELLA",
    "STRAITS",
    "SMYRNA",
    "WILDWOOD",
    "WILLISTON",
    "WIREGRASS"
   
  };

}
