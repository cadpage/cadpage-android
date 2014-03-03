package net.anei.cadpage.parsers.WA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;



public class WAKingCountyAParser extends MsgParser {
  
  private static final Pattern GPS_PTN = Pattern.compile("#LAT:(\\d{2})(\\d{6}) +#LON:(\\d{3})(\\d{6})$");
  
  public WAKingCountyAParser() {
    super("KING COUNTY", "WA");
    setFieldList("ADDR APT CITY CALL CH UNIT GPS");
  }
  
  @Override
  public String getFilter() {
    return "CAD@bellevuewa.gov,VisiCAD@norcom.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.length() < 102) return false;
    if (body.charAt(50) != '#') return false;
    if (!isStartField(body, 61, false)) return false;
    int endCity = isStartField(body, 91) ? 61 : 96;
    if (!isStartField(body, endCity+30)) return false;
    if (!isStartField(body, endCity+40)) return false;
    
    // Retrieve GPS coordinates
    Matcher match = GPS_PTN.matcher(body);
    if (match.find()) {
      data.strGPSLoc = '+' + match.group(1) + '.' + match.group(2) + ",-" + match.group(3) + '.' + match.group(4);
      body = body.substring(0,match.start());
      if (body.length() < 102) return false;
    }
    
    parseAddress(substring(body, 0, 50), data);
    data.strApt = substring(body, 51, 60);
    data.strCity = substring(body, 61, endCity);
    data.strCall = substring(body, endCity, endCity+29);
    String channel = substring(body, endCity+30, endCity+39);
    if (channel.startsWith("FT")) data.strChannel = channel;
    data.strUnit = substring(body, endCity+40);
    return true;
  }
  
  private boolean isStartField(String body, int pt) {
    return isStartField(body, pt, true);
  }
  
  private boolean isStartField(String body, int pt, boolean leadBlankReq) {
    if (body.length() <= pt) return false;
    if (body.charAt(pt) == ' ') return false;
    if (leadBlankReq && body.charAt(pt-1) != ' ') return false;
    return true;
  }
}
