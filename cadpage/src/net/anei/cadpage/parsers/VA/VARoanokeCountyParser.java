package net.anei.cadpage.parsers.VA;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class VARoanokeCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER_PTN1 = Pattern.compile("(.*?)  (\\d{4}) (.*)(Roanoke County|Floyd County|Town of Vinton) ([ A-Z]+) (\\d{4} \\d{8})");
  private static final Pattern DATE_TIME_PTN = Pattern.compile(" (\\d{1,2}/\\d{1,2}/\\d{4}) +(\\d{1,2}:\\d{1,2}:\\d{1,2} [AP]M)$");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  private static final Pattern X_APT_PTN = Pattern.compile("(?:APT|RM|(FL|LOT)) *([^ ]+)\\b *(.*)", Pattern.CASE_INSENSITIVE);
  private static final Pattern X_NO_CROSS_PTN = Pattern.compile("(.*?) *\\bNo Cross Streets Found\\b *(.*)");
  private static final Pattern UNIT_PTN = Pattern.compile("^((?:[A-Z]+\\d+|SALEMEMS) +)+");
  private static final Pattern X_PHONE_PTN = Pattern.compile("((?:\\(?\\d{3}\\)? ?)?\\d{3}[- ]\\d{4})\\b *(.*)");
  private static final Pattern APT_PHONE_PTN = Pattern.compile("(?:\\(?\\d{3}\\)? ?)?\\d{3}[- ]\\d{4}");
    
  
  public VARoanokeCountyParser() {
    super("ROANOKE COUNTY", "VA");
    setupCallList(
        "ACCIDENT",
        "ACCIDENT MINOR INJURY",
        "ACCIDENT MINOR INJURY PD ONSCENE",
        "ACCIDENT PERSONAL INJURY",
        "ALARMC",
        "ALARMR",
        "ALS",
        "ALSC",
        "ALS CRITICAL",
        "ASSISTF",
        "ASSISTR",
        "BLS",
        "BRUSH FIRE",
        "CARBON",
        "CARBON MONOXIDE LEAK",
        "CHIMNEY FIRE",
        "CODE BLUE",
        "COMMERCIAL FIRE ALARM",
        "COMMERCIAL GAS LEAK",
        "COMMERCIAL STRUCTURE FIRE",
        "ELEVATOR",
        "EMS SERVICE CALL",
        "ESERVICE",
        "FIRE SERVICE CALL",
        "HAZMAT RESPONSE",
        "HIT & RUN PERSONAL INJURY",
        "ILLEGAL BURN",
        "RESIDENTIAL FIRE ALARM",
        "RESIDENTIAL GAS LEAK",
        "RESIDENTIAL STRUCTURE FIRE",
        "SERVICE CALL",
        "SMOKE REPORT",
        "STRUCTC",
        "STRUCTR",
        "TEST CALL",
        "VEHICLE",
        "VEHICLE FIRE",
        "WIRE DOWN",
        "WIREDOWN"
    );
    setupMultiWordStreets(
        "BENT MOUNTAIN",
        "ELM VIEW",
        "TWELVE OCLOCK KNOB"
    );
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // There seem to be two different formats, possibly separated chronologically
    // This one can be identified by a pattern match
    Matcher match = MASTER_PTN1.matcher(body);
    if (match.matches()) {
      setFieldList("UNIT BOX ADDR APT CITY CALL ID");
      data.strUnit = match.group(1).trim();
      data.strBox = match.group(2);
      parseAddress(match.group(3).trim(), data);
      String city = match.group(4);
      if (city.startsWith("Town of ")) city = city.substring(8).trim();
      data.strCity = city;
      data.strCall = match.group(5).trim();
      data.strCallId = match.group(6);
      return true;
    }
    
    setFieldList("UNIT CALL PLACE ADDR APT PHONE X DATE TIME");
    boolean good = false;
    match = DATE_TIME_PTN.matcher(body);
    if (match.find()) {
      data.strDate = match.group(1);
      setTime(TIME_FMT, match.group(2), data);
      body = body.substring(0,match.start()).trim();
      good = true;
    }
    
    String bodyUpsh = body.toUpperCase();
    int pt = bodyUpsh.indexOf(" XST ");
    if (pt >= 0) {
      String cross  = body.substring(pt+5).trim();
      body = body.substring(0,pt).trim();
      good = true;
      
      match = X_APT_PTN.matcher(cross);
      if (match.matches()) {
        data.strApt = append(getOptGroup(match.group(1)), " ", match.group(2));
        cross = match.group(3);
      }
      match = X_PHONE_PTN.matcher(cross);
      if (match.matches()) {
        data.strPhone = match.group(1);
        cross = match.group(2);
      }
      match = X_NO_CROSS_PTN.matcher(cross);
      if (match.matches()) {
        data.strApt = append(data.strApt, "-", match.group(1));
        data.strPlace = append(data.strPlace, " - ", match.group(2));
      } else { 
        cross = cross.replaceAll("  +", " / ");
        parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT, cross, data);
        String left = getLeft();
        if (left.startsWith("/")) {
          left = left.substring(1).trim();
          String saveCross = data.strCross;
          data.strCross = "";
          parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS, left, data);
          data.strCross = append(saveCross, " / ", data.strCross);
          data.strPlace = append(data.strPlace, " - ", getLeft());
        } else if (checkAddress(left) > 0) {
            data.strCross = append(data.strCross, " / ", left);
        } else  { 
          data.strPlace = append(data.strPlace, " - ", left);
        }
      }
    } else if (bodyUpsh.endsWith(" XST")) {
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
    
    parseAddress(StartType.START_CALL_PLACE, FLAG_START_FLD_REQ | FLAG_IGNORE_AT | FLAG_START_FLD_NO_DELIM, body.toUpperCase(), data);
    if (data.strAddress.length() == 0) return false;
    String left = getLeft();
    if (APT_PHONE_PTN.matcher(left).matches()) {
      data.strPhone = left;
    } else {
      data.strApt = append(data.strApt, "-", getLeft());
    }
    
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
