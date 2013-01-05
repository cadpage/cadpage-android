package net.anei.cadpage.parsers.VA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class VARoanokeCountyParser extends SmartAddressParser {
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile(" (\\d{1,2}/\\d{1,2}/\\d{4}) +(\\d{1,2}:\\d{1,2}:\\d{1,2} [AP]M)$");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private static final Pattern UNIT_PTN = Pattern.compile("^([A-Z]+\\d+ +)+");
    
  
  public VARoanokeCountyParser() {
    super("ROANOKE COUNTY", "VA");
    setupCallList(
        "ACCIDENT PERSONAL INJURY",
        "ALS",
        "COMMERCIAL FIRE ALARM",
        "COMMERCIAL GAS LEAK",
        "COMMERCIAL STRUCTURE FIRE",
        "RESIDENTIAL FIRE ALARM",
        "RESIDENTIAL GAS LEAK",
        "RESIDENTIAL STRUCTURE FIRE"
    );
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    boolean good = false;
    Matcher match = DATE_TIME_PTN.matcher(body);
    if (match.find()) {
      data.strDate = match.group(1);
      setTime(TIME_FMT, match.group(2), data);
      body = body.substring(0,match.start()).trim();
      good = true;
    }
    
    int pt = body.indexOf(" XST ");
    if (pt >= 0) {
      data.strCross = body.substring(pt+5).trim().replace("   ", " & ");
      body = body.substring(0,pt).trim();
      good = true;
    } else if (body.endsWith(" XST")) {
      body = body.substring(0, body.length()-4).trim();
      good = true;
    }
    
    match = UNIT_PTN.matcher(body);
    if (match.find()) {
      data.strUnit = match.group().trim();
      body = body.substring(match.end()).trim();
      good = true;
    }
    if (!good) return false;
    
    parseAddress(StartType.START_CALL_PLACE, FLAG_START_FLD_REQ | FLAG_ANCHOR_END | FLAG_START_FLD_NO_DELIM, body, data);
    if (data.strAddress.length() == 0) return false;
    
    // See if we should split a place name from the call description
    if (data.strPlace.length() == 0) {
      pt = data.strCall.indexOf('(');
      if (pt >= 0) {
        data.strPlace = data.strCall.substring(pt+1).trim();
        if (data.strPlace.endsWith(")")) data.strPlace = data.strPlace.substring(0,data.strPlace.length()-1).trim(); 
        data.strCall = data.strCall.substring(0,pt).trim();
      }
    }
    return true;
  }
}
