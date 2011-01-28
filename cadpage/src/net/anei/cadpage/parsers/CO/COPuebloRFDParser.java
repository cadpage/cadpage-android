package net.anei.cadpage.parsers.CO;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Pueblo RFD, CO
Contact: Steven Passig <giz5312@gmail.com>
Sender: surepage@wdsl.us
System: Spillman mobile
(Page ) 12:43PM 11/28 RURAL FIRE in the area of 1543 Cooper Pl report of heavy smoke no flames showing...kr
(Page ) 04:26PM 12/13 rural fire:  hwy 50 & 27th ln; north side, 10 ft fire...tdb
(Page ) 04:52PM 11/27 ATTN RURAL FIRE: 28141 south rd....male poss overdose...jaa
(Page ) 09:18AM 12/11 rural fire  33550 hwy 96 E Lot 379 35 yof convulsions
(Page ) 11:45PM 11/15 ATTN RURAL FIRE: 1917 n santa fe ave...at the car wash....39yof...seizure...jaa
*/


public class COPuebloRFDParser extends SmartAddressParser {
  
  private static final String CAD_MARKER = "Page";
  
  private static final Pattern TIME_MARK = Pattern.compile(".*\\d\\d:\\d\\d[A-Z][A-Z] \\d\\d/\\d\\d");
    
  public COPuebloRFDParser() {
    super("PUEBLO COUNTY", "CO");
  }
  
  @Override
  public String getFilter() {
    return "surepage@wdsl.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.length() > 0) body = "Subject:" + subject + ' ' + body;
    
    int pt = body.indexOf(CAD_MARKER);
    int ipt = 0;
    if (pt < 0) return false;
    body =  body.substring(pt+CAD_MARKER.length());
    String sAddr = body.trim();
    if (body.contains("...")) {
      ipt = body.indexOf("...");
      body = body.replace("...", "#");
      sAddr = body.substring(0,ipt);
    } 
    Matcher match = TIME_MARK.matcher(sAddr);
    if (match.find()) {
      sAddr = sAddr.substring(match.end());
    }

   // if (sAddr.contains("&")) sAddr=  sAddr.replace("&","/");
    parseAddress(StartType.START_CALL, sAddr, data);
    data.strCall = data.strCall.trim();
    data.strSupp = getLeft().trim();
    if (data.strSupp.length() <1 ) data.strSupp = body.substring(ipt);
    return true;
  }
}
