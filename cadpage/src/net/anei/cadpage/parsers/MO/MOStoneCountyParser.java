package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Stone County, MO
Contact: Ryan Joy <crazyrockj@gmail.com>

911-CENTER:FMA MUTUAL AID/ASSIST OUTSIDE AGEN 214 E 5TH ST 4175270913 S MAPLE ST MUTUAL AID ASSIST OUTSIDE AGENCY
911-CENTER:FMVC MOTOR VEHICLE COLLISION STATE HWY TT&STATE HWY D 4178498278 STATE HWY D MOTOR VEHICLE COLLISION
911-CENTER:FBF BRUSH/FOREST FIRE 546 CAMP CLARK HL 4175989172 SMALL ST BRUSH FIRE
911-CENTER:FIO FIRE INVESTIGATION OUTSIDE 110 S MAPLE ST 4173576116 E 4TH ST FIRE INVESTIGATION OUTSIDE
911-CENTER:FMVC MOTOR VEHICLE COLLISION 41604 STATE HWY 413 4178389861 MOTOR VEHICLE COLLISION
911-CENTER:FRF RUBBISH FIRE NO EXPOSURES OLD WIRE RD&ROUNDHOUSE RD 417 ROUNDHOUSE RD RUBBISH FIRE.

*/

public class MOStoneCountyParser extends SmartAddressParser {
  
  private static final Pattern PHONE_PTN = Pattern.compile("\\b\\d{10}\\b");
  
  public MOStoneCountyParser() {
    super("STONE COUNTY", "MO");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!body.startsWith("911-CENTER:")) return false;
    body = body.substring(11).trim();
    String sInfo;
    Matcher match = PHONE_PTN.matcher(body);
    if (match.find()) {
      String sAddr = body.substring(0,match.start()).trim();
      parseAddress(StartType.START_CALL, FLAG_ANCHOR_END, sAddr, data);
      data.strPhone = match.group();
      sInfo = body.substring(match.end()).trim();
    } else {
      parseAddress(StartType.START_CALL, body, data);
      sInfo = getLeft();
    }
    
    Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, sInfo);
    if (res.getStatus() > 0) {
      res.getData(data);
      data.strSupp = res.getLeft();
    } else {
      data.strSupp = sInfo;
    }
    
    return true;
  }

}
