package net.anei.cadpage.parsers.MO;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class MOStCharlesCountyParser extends MsgParser {
  
  private static final Pattern ID_PTN = Pattern.compile("\\d{6}-\\d{5}");
 
  public MOStCharlesCountyParser() {
    super("ST CHARLES COUNTY", "MO");
    setFieldList("ID INFO CALL ADDR PLACE APT X MAP SRC UNIT");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@sccda.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (body.startsWith("ID:")) body = body.substring(3).trim();
    data.strCallId = substring(body, 0, 12);
    if (! ID_PTN.matcher(data.strCallId).matches()) return false;
    data.strSupp = substring(body, 12, 20);
    data.strCall = substring(body, 20, 45);
    parseAddress(substring(body, 45, 95), data);
    data.strPlace = substring(body, 95, 120);
    if (!substring(body, 120, 124).equals("APT:")) return false;
    
    int crossPos = -1;
    for (int pos : new int[]{129,140}) {
      if (substring(body, pos, pos+5).equals("X ST:")) {
        crossPos = pos;
        break;
      }
    }
    if (crossPos < 0) return false;
    
    data.strApt = substring(body, 124, crossPos);
    data.strCross = substring(body, crossPos+5, crossPos+35);
    data.strMap = substring(body, crossPos+39, crossPos+54);
    if (data.strMap.length() > 0 && !substring(body, crossPos+35, crossPos+39).equals("MAP:")) return false;
    
    data.strSource = substring(body, crossPos+54, crossPos+84);
    
    data.strUnit = substring(body, crossPos+90);
    if (data.strUnit.length() > 0 && !substring(body, crossPos+84, crossPos+90).equals("Units:")) return false;
    
    return true;
  }
}