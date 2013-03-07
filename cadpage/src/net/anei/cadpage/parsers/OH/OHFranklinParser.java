package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class OHFranklinParser extends DispatchEmergitechParser {
  
  private static final Pattern GPS_PTN = Pattern.compile("^X([-+]\\d+\\.\\d{4,}) +Y([-+]\\d+\\.\\d{4,})\\b");
  
  public OHFranklinParser() {
    super("", 54, CITY_LIST, "FRANKLIN", "OH");
  }
  
  @Override
  public String getFilter() {
    return "@cmsg.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    body = "[ZZ]- NATURE:" + body;
    if (!super.parseMsg(body, data)) return false;
    
    data.strUnit = "";
    
    Matcher match = GPS_PTN.matcher(data.strSupp);
    if (match.find()) {
      setGPSLoc(match.group(1) + ' ' + match.group(2), data);
      data.strSupp = data.strSupp.substring(match.end()).trim();
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("INFO", "GPS INFO");
  }
  
  private static final String[] CITY_LIST = new String[]{
    "FRANKLIN",
    "FRANKLIN TWP",
    "LEBANON"
  };
}
