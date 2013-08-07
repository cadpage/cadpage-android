package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MOStLouisCountyCParser extends MsgParser {
  
  private static final Pattern ZIP_CODE_PTN = Pattern.compile(" +(?:\\[Zip\\])?(\\d{5})$");
  private static final Pattern LAT_LONG_PTN = Pattern.compile("Lat/Long(\\d{2})(\\d{6}) +(\\d{2})(\\d{6})");

  public MOStLouisCountyCParser() {
    super("ST LOUIS COUNTY", "MO");
    setFieldList("SRC CALL ADDR APT CITY X PLACE ID DATE TIME UNIT GPS");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@cce911.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    String[] parts = subject.split("\\|");
    if (parts.length != 2 || !parts[0].equals("Cad Page")) return false;
    data.strSource = parts[1];
  
    Parser p = new Parser(body);
    data.strCall = p.get(" at");
    String addr = p.get(" - CrossStreet:");
    Matcher match = ZIP_CODE_PTN.matcher(addr);
    if (match.find()) {
      data.strCity = match.group(1);
      addr = addr.substring(0,match.start());
    }
    parseAddress(addr, data);
    data.strCross = p.get(" -");
    data.strPlace = p.get(" [");
    data.strCallId = p.get('/');
    data.strTime = p.get('/');
    data.strUnit = p.get(']');
    if (data.strUnit.length() == 0) return false;
    
    match = LAT_LONG_PTN.matcher(p.get());
    if (match.matches()) {
      setGPSLoc(match.group(1)+'.'+match.group(2)+','+match.group(3)+'.'+match.group(4), data);
    }
    return true;
  }

}
