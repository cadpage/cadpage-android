
package net.anei.cadpage.parsers.AL;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.ReverseCodeSet;
import net.anei.cadpage.parsers.SmartAddressParser;

/**
 * Mobile County, AL
 */
public class ALMobileCountyParser extends SmartAddressParser {
  
  private static final Pattern RUN_REPORT_PTN =  Pattern.compile("EVENT: ([A-Za-z]\\d{10}) .* / ADD: .* / DISP: .*");
  private static final Pattern OPT_PREFIX_PTN = Pattern.compile("^EVENT: [A-Za-z]\\d{10} +");
  private static final Pattern MASTER = Pattern.compile("Respond To: (.*?) Event#: ([A-Za-z]\\d{10})(.*?)(?: +(\\d\\d:\\d\\d:\\d\\d) +(\\d\\d/\\d\\d/\\d\\d) Dispatch\\b *(.*))?");
  private static final Pattern PART_MARK_PTN = Pattern.compile(" +\\d\\d:");
  private static final Pattern PLACE_MARK_PTN = Pattern.compile(": *@?");
  private static final Pattern TRAIL_APT_PTN = Pattern.compile("(.*), *([^ ]+)");

  public ALMobileCountyParser() {
    super(CITY_CODES, "MOBILE COUNTY", "AL");
    setFieldList("ADDR CITY PLACE APT CALL ID X TIME DATE INFO");
  }
  
  
  @Override
  public String getFilter() {
    return "@c-msg.net";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    body = stripFieldEnd(body, "_x000D_");

    Matcher match = RUN_REPORT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "RUN REPORT";
      data.strCallId = match.group(1);
      data.strPlace = body;
      return true;
    }
    
    match = OPT_PREFIX_PTN.matcher(body);
    if (match.lookingAt()) body = body.substring(match.end());
    
    match = MASTER.matcher(body);
    if (!match.matches()) return false;
    String addr = match.group(1).trim();
    data.strCallId = match.group(2);
    data.strCross = match.group(3).trim();
    data.strTime = getOptGroup(match.group(4));
    data.strDate = getOptGroup(match.group(5));
    data.strSupp = getOptGroup(match.group(6));
    data.expectMore = (data.strDate.length() == 0);
    
    // Parsing a truncated alert gets complicated
    if (data.expectMore) {
      match = PART_MARK_PTN.matcher(data.strCross);
      if (match.find()) {
        String trail = data.strCross.substring(match.start()).trim().replaceAll("  +", " ");
        data.strCross = data.strCross.substring(0,match.start());
        String trail2 = trail.replaceAll("\\d", "N");
        if (!"NN:NN:NN NN/NN/NN Dispatch".startsWith(trail2)) return false;
        if (trail.length() >= 8) data.strTime = trail.substring(0,8);
        if (trail.length() >= 17) data.strDate = trail.substring(9,17);
      }
    }
    data.strCross = stripFieldEnd(data.strCross, "/");

    // See if we can identify call description at end of addr field
    // that will make life a lot easier
    String call = CALL_SET.getCode(addr);
    if (call != null) {
      data.strCall = call;
      addr = stripFieldEnd(addr.substring(0,addr.length()-call.length()).trim(), "**");
    }
    
    String place = null;
    String apt = null;
    match = PLACE_MARK_PTN.matcher(addr);
    if (addr.startsWith("LL(")) {
      int minPt = addr.indexOf(')');
      if (minPt < 0) return false;
      match.region(minPt+1, addr.length());
    }
    if (match.find()) {
      place = addr.substring(match.end()).trim();
      addr = addr.substring(0,match.start()).trim();
    }
    
    boolean endAddr = (place != null || data.strCall.length() > 0);
    if (endAddr) {
      if (!addr.endsWith(")")) {
        int pt = addr.lastIndexOf(',');
        if (pt >= 0) {
          apt = addr.substring(pt+1).trim();
          addr = addr.substring(0,pt).trim();
        }
      }
    }
    
    parseAddress(StartType.START_ADDR, (endAddr ? FLAG_ANCHOR_END : 0), addr, data);
    if (!addr.endsWith(")") && data.strCity.length() == 0) return false;
    if (data.strCity.equals("CNTY")) data.strCity = "";
    
    // So  many different choices
    
    // If we found an postive end address, either we found a place marker or call 
    // description or both
    if (endAddr) {
      
      // If we found a place marker and did not find a call description, then we 
      // have to figure out where the place ends and the call description starts
      if (data.strCall.length() == 0 && place != null) {
        
        // First see if there is a ** marker separating the place and call description
        int pt = place.indexOf(" ** ");
        if (pt >= 0) {
          data.strCall = place.substring(pt+4).trim();
          place = place.substring(0,pt).trim();
        } 
        
        // No go there, treat first word as place name, rest as call description
        else {
          pt = place.indexOf(' ');
          if (pt < 0) return false;
          data.strCall = place.substring(pt+1).trim();
          place = place.substring(0,pt).trim();
        }
      }
      
      // However we got here, see if there is a remaining place name
      // and if there is strip off a possible apt field before saving it
      if (place != null) {
        match = TRAIL_APT_PTN.matcher(place);
        if (match.matches()) {
          place = match.group(1).trim();
          if (apt == null) apt = "";
          apt = append(apt, "-", match.group(2));
        }
        data.strPlace = place;
      }
    }
    
    // Otherwise we had to use the smart parser to mark the end of the
    // address and start of call description.  Check for possible apt
    // following the city code.  There is no place name, but might
    // be a ** separator following the city/apt.
    else {
      place = getLeft();
      if (isCommaLeft()) {
        int pt = place.indexOf(' ');
        if (pt < 0) return false;
        apt = place.substring(0,pt);
        place = place.substring(pt+1).trim();
      }
      data.strCall = stripFieldStart(place, "**");
    }
    
    // If there was a place marker, we need to identify the split between
    // the place name and call description
    
    if (apt != null) data.strApt = append(data.strApt, "-", apt);
    return true;
  }
  
  @Override
  public CodeSet getCallList() {
    return CALL_SET;
  }
  
  private static final ReverseCodeSet CALL_SET = new ReverseCodeSet(
      "ABDOMINAL PAIN/PROBLEMS",
      "ALLERGIES/HIVES/MED REACTION/STINGS",
      "ALTERED MENTAL STATUS",
      "BACK PAIN (NON-TRAUMATIC)",
      "BLOOD PRESSURE ABNORMALITY",
      "BREATHING PROBLEMS / DIFFICULTY SPEAKING",
      "BREATHING PROBLEMS",
      "CARDIAC OR RESPIRATORY ARREST",
      "CHEST PAIN / ABNORMAL BREATHING",
      "CHEST PAIN / BREATHING NORMALLY <35",
      "CITIZEN ASSIST -- NON-MEDICAL",
      "COMMERCIAL VEHICLE FIRE",
      "CONVULSIONS / SEIZURES",
      "CHILDBIRTH / IMMINENT DELIVERY",
      "DIABETIC PROBLEMS / ALTERED MENTAL STATUS",
      "DIABETIC PROBLEMS",
      "DIZZINESS/VERTIGO",
      "ELECTRONIC ALARM -- COMMERCIAL STRUCTURE",
      "ELECTRONIC ALARM -- RESIDENTIAL (SINGLE)",
      "FALL INJURY / NOT DANGEROUS BODY AREA",
      "FALL-PUBLIC ASSISTANCE",
      "FALLS: UNK STATUS",
      "FEVER/CHILLS",
      "FIRE INVESTIGATION",
      "GENERAL WEAKNESS",
      "HEART PROBLEMS / A.I.C.D. / CARDIAC HISTORY",
      "HEART PROBLEMS / CLAMMY",
      "HEAT / COLD EXPOSURE: ALERT",
      "HEAT / COLD EXPOSURE / CHANGE IN SKIN COLOR",
      "HEAT / COLD EXPOSURE / UNK STATUS",
      "HEMORRHAGE / LACERATIONS / NOT ALERT",
      "HEMORRHAGE / LACERATIONS / POSS DANGEROUS HEMORRAGE",
      "PARK BLOOD PRESSURE ABNORMALITY",
      "PATIENT NOT ALERT",
      "PEDESTRIAN STRUCK",
      "POLICE DEPARTMENT CHEST PAIN / BREATHING NORMALLY <35",
      "PSYCHIATRIC / SUICIDE ATTEMPT / UNK STATUS",
      "PSYCHIATRIC / THREATENING SUICIDE",
      "RESIDENTIAL FIRE -- MFG HOUSING/TRAILER",
      "RESIDENTIAL FIRE",
      "SEIZURE-NO LONGER SEIZING/EFFECTIVE BREATHING VERIF/NO SZ HX",
      "SEIZURE / EFFECTIVE BREATHING NOT VERIFIED",
      "SEIZURE / NO LONGER SEIZING & BREATHING NORMALLY (KNOWN SEIZURE DISORDER)",
      "SEIZURES / CONTINUOUS or MULTIPLE",
      "SICK CALL",
      "SMALL OUTSIDE/TRASH FIRE",
      "STAB / GUNSHOT : UNKNOWN STATUS",
      "STROKE (CVA) / ABNORMAL BREATHING",
      "STROKE (CVA) / NOT ALERT",
      "STROKE (CVA) / SUDDEN WEAKNESS or NUMBNESS (ONE SIDE)",
      "SYNCOPE / FAINTING / ALERT / ABNORMAL BREATHING",
      "SYNCOPE / FAINTING / ALERT / CARDIAC HISTORY",
      "SYNCOPE / FAINTING / NOT ALERT",
      "TEST EVENT TYPE",
      "TRAFFIC ACCIDENT / UNK STATUS",
      "TRAFFIC ACCIDENT WITH INJURIES",
      "TRAUMATIC INJURIES / MINOR",
      "TRAUMATIC INJURIES / POSSIBLY DANGEROUS BODY AREA",
      "UNCONSCIOUS / EFFECTIVE BREATHING VERIFIED",
      "UNKNOWN PROBLEM",
      "VEHICLE ACCIDENT OVERTURNED VEHICLE",
      "WOODS FIRE"
  );
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BLAB", "BAYOU LA BATRE",
      "CNTY", "CNTY",     // Will be set to empty string
      "PRIC", "PRICHARD",
      "SARA", "SARALAND"
  });
}
