package net.anei.cadpage.parsers.GA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Pike County, GA
Contact: Brian.Michel@pikeemergencyservices.com, 6786030899@VTEXT.COM

PIKE COUNTY E-911:10-52R EMS/ RESPONDER 11794 HIGHWAY 109 7705673249 ADAMS RD
PIKE COUNTY E-911:10-50I ACCIDENT WITH INJURIES CONCORD RD AT BOTTOMS RD 7066013339
PIKE COUNTY E-911:FIRALM FIRE ALARM 1489 EPPINGER BRIDGE RD 8005441104 HARRIS ST
PIKE COUNTY E-911:10-50I ACCIDENT WITH INJURIES CONCORD ST @ FRANKLIN ST 770
PIKE COUNTY E-911:FIRSTR STRUCTURE FIRE INDUSTRIAL DRIVE/VERY END 770
PIKE COUNTY E-911:FIRVEH VEHICLE FIRE 5277 BLANTON MILL RD 6785720068 BEEKS RD
PIKE COUNTY E-911:FIRE FIRE GENERIC (TYPE) HIGHWAY 362 AREA OF CONCORD RD 3345591717

*/
public class GAPikeCountyParser extends SmartAddressParser {
  
  private static final Pattern PHONE_PTN = Pattern.compile("\\b\\d{10}\\b");
  private static final Pattern PHONE_TRAIL_PTN = Pattern.compile(" +\\d{3,}$");
  
  public GAPikeCountyParser() {
    super("PIKE COUNTY", "GA");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!body.startsWith("PIKE COUNTY E-911:")) return false;
    body = body.substring(18).trim();
    
    String sAddr;
    Matcher match = PHONE_PTN.matcher(body);
    if (match.find()) {
      sAddr = body.substring(0,match.start()).trim();
      data.strPhone = match.group();
      data.strCross = body.substring(match.end()).trim();
    } else {
      sAddr = body;
      match = PHONE_TRAIL_PTN.matcher(sAddr);
      if (match.find()) sAddr = sAddr.substring(0,match.start()).trim();
    }
    
    sAddr = sAddr.replace('@', '&').replace(" AT ", " & ");
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, sAddr, data);
    data.strPlace = getLeft();
    if (data.strPlace.startsWith("/")) data.strPlace = data.strPlace.substring(1).trim();
    return true;
  }
}
