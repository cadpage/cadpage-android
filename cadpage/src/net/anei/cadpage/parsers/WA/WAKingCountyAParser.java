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
    if (parseNormalMsg(body, data)) return true;
    data.initialize(this);
    return parseCompressedMsg(body, data);
  }
  
  private boolean parseNormalMsg(String body, Data data) {
    
    // Retrieve GPS coordinates from end of message
    Matcher match = GPS_PTN.matcher(body);
    if (match.find()) {
      data.strGPSLoc = '+' + match.group(1) + '.' + match.group(2) + ",-" + match.group(3) + '.' + match.group(4);
      body = body.substring(0,match.start());
    }
    
    FParser p = new FParser(body);
    parseAddress(p.get(50), data);
    if (!p.check("#")) return false;
    data.strApt = p.get(10);
    if (p.check(" ")) return false;
    
    if (p.lookahead(34,1).length() == 0 && p.lookahead(35,1).length() == 1) data.strCity = p.get(35);
    data.strCall = p.get(29);
    if (!p.check(" ")) return false;
    String channel = p.get(9);
    if (channel.startsWith("FT")) data.strChannel = channel;
    if (!p.check(" ") || p.check(" ")) return false;
    data.strUnit = p.get();
    return true;
  }
  
  private static final Pattern COMP_MASTER = Pattern.compile("([^#]+) # ([^ ]*) (.*?) (FT[A-Z0-9]+) ([A-Z0-9,]+)");
  private boolean parseCompressedMsg(String body, Data data) {
    if (body.startsWith("CAD||")) return false;
    Matcher match = COMP_MASTER.matcher(body);
    if (!match.matches()) return false;
    parseAddress(match.group(1).trim(), data);
    data.strApt = match.group(2);
    data.strCall = match.group(3).trim();
    data.strChannel = match.group(4);
    data.strUnit = match.group(5).trim();
    return true;
  }
}
