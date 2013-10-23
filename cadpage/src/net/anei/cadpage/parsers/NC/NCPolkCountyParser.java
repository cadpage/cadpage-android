

package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCPolkCountyParser extends DispatchSouthernParser {
  
  private static final String[] CITY_LIST = new String[]{
    "COLUMBUS",
    "MILL SPRING",
    "RUTHERFORDTON",
    "SALUDA",
    "TRYON"
  };
  
  private static final Pattern ID_TIME_PTN = Pattern.compile("\\b(\\d{10})(\\d\\d:\\d\\d:\\d\\d)\\b");
  private static final Pattern TRAIL_TIME_PTN = Pattern.compile("\\. +[A-Z][a-z]+ \\d+, \\d+:\\d+ [AP]M\\.?$");

  public NCPolkCountyParser() {
    super(CITY_LIST, "POLK COUNTY", "NC", DSFLAG_DISPATCH_ID | DSFLAG_ID_OPTIONAL);
  }
  
  @Override
  public String getFilter() {
    return "polkcounty911@polknc.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    // Sometimes an ID and time run together, in which case we need to split them apart
    Matcher match = ID_TIME_PTN.matcher(body);
    if (match.find()) {
      body = body.substring(0, match.end(1)) + " " + body.substring(match.start(2));
    }
    match = TRAIL_TIME_PTN.matcher(body);
    if (match.find()) body = body.substring(0,match.start()).trim();
    
    body = body.replace('@', '&');
    if (!super.parseMsg(body, data)) return false;
    
    int pt = data.strAddress.toLowerCase().indexOf(" before ");
    if (pt >= 0) {
      data.strCross = data.strAddress.substring(pt+8).trim();
      data.strAddress = data.strAddress.substring(0,pt).trim();
    }
    
    // Fix some after market additions
    if (data.strName.length() == 0) {
      data.strName = data.strPlace;
      data.strPlace = "";
    }
    
    Parser p = new Parser(data.strSupp);
    p.getLastOptional(". ");
    data.strCross = append(data.strCross, " / ", p.getLastOptional(" FROM ").replace(" TO ", " / "));
    data.strSupp = p.get();
    return true;
  }

  @Override
  protected boolean isNotExtraApt(String apt) {
    if (apt.startsWith("NR ")) return true;
    return super.isNotExtraApt(apt);
  }
}
