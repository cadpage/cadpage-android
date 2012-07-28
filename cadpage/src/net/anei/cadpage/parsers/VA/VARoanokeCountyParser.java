package net.anei.cadpage.parsers.VA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Roanoke County, VA
Contact: Josh Waagmeester <josh@cavespringfire.org>
System: New World AEGIS

RES3 R33 CO3 W3 EMS2  ACCIDENT PERSONAL INJURY CHAPARRAL DR XST  PENN FOREST
CO9 W9 CO10 W10 CO3 W3 RES9 M92 TOWR9 BATT1 EMS2  COMMERCIAL FIRE ALARM(RKCHFIELD MEMORY CARE CENTER3719 KNOLLRIDGE RD XST 5/5/2012 11:38:29 AM
COMMERCIAL FIRE ALARM RICHFIELD MEMORY CARE CENTER 3719 KNOLLRIDGE RD XST 5/5/2012 11:40:27 AM
CO3 W3 CO11 E11 CO7 W7 RES3 M31 L3 EMS2 Commercial Structure Fire 3155 Berry LN XST ELECTRIC RD POSTAL DR DEAD END
COMMERCIAL FIRE ALARM RICHFIELD MEMORY CARE CENTER 3719 KNOLLRIDGE RD XST
RES3 M33 CO3 W3 EMS2  ACCIDENT PERSONAL INJURY 5807 PENN FOREST PL XST  MERRIMAN RD   DEAD END 5/6/2012 3:10:28 PM
W3  ALS 3556 KENWICK TRL XST  VERONA TRL   OVERHILL TRL 5/6/2012 3:56:38 PM
CO7 W7 CO3 W3 RES7 M7 L3 BATT1 EMS2  Residential Structure Fire 7249 BIRCH CT XST  SOUTH MOUNTAIN DR   PINE CT 5/6/2012 4:56:42 PM

Contact: Active911.com
[] CO7 W7 CO3 W3 CO6 W6 RES7 M7 L3 BATT1 EMS2  COMMERCIAL FIRE ALARM LOWES FRANKLIN4224 VALLEY AVE XST
[] CO7 W7 CO3 E3 RES7 M7 L3 BATT1  COMMERCIAL GAS LEAK HUNTING HILLS COUNTRY CLUB5220 HUNTING HILLS DR XST  FOX RIDGE RD   FLINTLOCK RD
[] CO3 W3 CO7 W7 CO11 E11 RES3 M31 L3 EMS2  COMMERCIAL FIRE ALARM CAVE SPRING HIGH3712 CHAPARRAL DR XST

 */


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
