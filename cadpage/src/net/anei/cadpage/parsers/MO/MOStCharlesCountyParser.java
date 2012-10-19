package net.anei.cadpage.parsers.MO;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class MOStCharlesCountyParser extends MsgParser {
  
  private static final Pattern ID_PTN = Pattern.compile("\\d{6}-\\d{5}");
 
  public MOStCharlesCountyParser() {
    super("ST CHARLES COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@sccda.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    data.strCallId = substring(body, 0, 12);
    if (! ID_PTN.matcher(data.strCallId).matches()) return false;
    data.strSupp = substring(body, 12, 20);
    data.strCall = substring(body, 20, 45);
    parseAddress(substring(body, 45, 95), data);
    data.strPlace = substring(body, 95, 120);
    data.strApt = substring(body, 124, 140);
    data.strCross = substring(body, 145, 175);
    data.strMap = substring(body, 179, 194);
    data.strSource = substring(body, 194, 999);
    return true;
  }
}