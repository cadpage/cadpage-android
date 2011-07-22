package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Stone County, MO
Contact: Ryan Joy <crazyrockj@gmail.com>

911-CENTER:FMA MUTUAL AID/ASSIST OUTSIDE AGEN 214 E 5TH ST 4175270913 S MAPLE ST MUTUAL AID ASSIST OUTSIDE AGENCY
911-CENTER:FMVC MOTOR VEHICLE COLLISION STATE HWY TT&STATE HWY D 4178498278 STATE HWY D MOTOR VEHICLE COLLISION
911-CENTER:FBF BRUSH/FOREST FIRE 546 CAMP CLARK HL 4175989172 SMALL ST BRUSH FIRE
911-CENTER:FIO FIRE INVESTIGATION OUTSIDE 110 S MAPLE ST 4173576116 E 4TH ST FIRE INVESTIGATION OUTSIDE
911-CENTER:FMVC MOTOR VEHICLE COLLISION 41604 STATE HWY 413 4178389861 MOTOR VEHICLE COLLISION

*/

public class MOStoneCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("911-CENTER:(.*) (\\d{10}) (.*)");
  
  public MOStoneCountyParser() {
    super("STONE COUNTY", "MO");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    String sAddr = match.group(1).trim();
    data.strPhone = match.group(2);
    String sInfo = match.group(3).trim();
    
    parseAddress(StartType.START_CALL, FLAG_ANCHOR_END, sAddr, data);
    Result res = parseAddress(StartType.START_ADDR, sInfo);
    if (res.getStatus() > 0) {
      res.getCrossData(data);
      data.strSupp = res.getLeft();
    } else {
      data.strSupp = sInfo;
    }
    
    return true;
  }

}
