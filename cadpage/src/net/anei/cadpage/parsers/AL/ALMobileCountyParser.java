
package net.anei.cadpage.parsers.AL;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgInfo.MsgType;
import net.anei.cadpage.parsers.ReverseCodeSet;
import net.anei.cadpage.parsers.SmartAddressParser;

/**
 * Mobile County, AL
 */
public class ALMobileCountyParser extends SmartAddressParser {
  
  private static final Pattern RUN_REPORT_PTN =  Pattern.compile("EVENT: ?([A-Za-z]\\d{9,10}) +(.*\\bADD: .* / DISP: .*|RCVD .* DISP .*)");
  private static final Pattern RUN_REPORT_BRK_PTN = Pattern.compile(" */ *");
  private static final Pattern OPT_PREFIX_PTN = Pattern.compile("^EVENT: [A-Za-z]\\d{9,10} +");
  private static final Pattern MASTER = Pattern.compile("Respond To: (.*?) Event#: ([A-Za-z]\\d{9,10})(.*?)(?: +(\\d\\d:\\d\\d:\\d\\d) +(\\d\\d/\\d\\d/\\d\\d) (?:Dispatch\\b|//|~|) *(.*))?");
  private static final Pattern PART_MARK_PTN = Pattern.compile(" +\\d\\d:");
  private static final Pattern CITY_ADDR_PTN1 = Pattern.compile("([A-Z]{4}): @(.*)");
  private static final Pattern CITY_ADDR_PTN2 = Pattern.compile("(.*?) ([A-Z]{4})(?:,(\\S*))?:[, ]*(.*)");
  private static final Pattern APT_PTN = Pattern.compile("(?:LOT|APT|#) *(\\S+)\\b *(.*)");
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
      data.msgType = MsgType.RUN_REPORT;
      data.strCallId = match.group(1);
      data.strSupp = RUN_REPORT_BRK_PTN.matcher(match.group(2)).replaceAll("\n").trim();
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
    
    // Check for leading city
    match = CITY_ADDR_PTN1.matcher(addr);
    if (match.matches()) {
      data.strCity = convertCodes(match.group(1), CITY_CODES);
      addr = match.group(2).trim();
    }
    
    String place = null;
    String apt = null;
    match = CITY_ADDR_PTN2.matcher(addr);
    if (match.matches()) {
      String city = CITY_CODES.getProperty(match.group(2));
      if (city != null) {
        addr = match.group(1).trim();
        data.strCity = city;
        apt = match.group(3);
        place = match.group(4);
        
        int pt = place.indexOf('@');
        if (pt >= 0) {
          if (apt == null) apt = "";
          apt = append(apt, "-", place.substring(0,pt).trim());
          place = place.substring(pt+1).trim();
        }
        else if ((match = APT_PTN.matcher(place)).matches()) {
          if (apt == null) apt = "";
          apt = append(apt, "-", match.group(1));
          place = match.group(2);
        }
      }
    }
    
    boolean endAddr = (place != null || data.strCall.length() > 0);
    if (endAddr) {
      if (!addr.endsWith(")")) {
        int pt = addr.lastIndexOf(',');
        if (pt >= 0) {
          if (apt == null) apt = "";
          apt = append(addr.substring(pt+1).trim(), " ", apt);
          addr = addr.substring(0,pt).trim();
        }
      }
    }

    int flags = 0;
    if (data.strCity.length() > 0) flags |= FLAG_NO_CITY;
    if (endAddr) flags |= FLAG_ANCHOR_END;
    parseAddress(StartType.START_ADDR, flags, addr, data);
    if (!addr.endsWith(")") && data.strCity.length() == 0) return false;
    if (data.strCity.equals("MOBILE COUNTY")) data.strCity = "";
    
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
      "**PUBLIC ASSISTANCE*** (FALL)",
      "ABANDONED WASTE",
      "ABDOMINAL PAIN / FEMALES W/PAIN ABOVE NAVEL >45",
      "ABDOMINAL PAIN / FEMALES W/SYNCOPE OR NEAR SYNCOPE 12-50",
      "ABDOMINAL PAIN / MALES W/PAIN ABOVE NAVEL >35",
      "ABDOMINAL PAIN / NOT ALERT",
      "ABDOMINAL PAIN / PROBLEMS",
      "ABDOMINAL PAIN / SYNCOPE OR NEAR SYNCOPE >50",
      "ABDOMINAL PAIN/PROBLEMS",
      "ABDOMINAL PAIN:KNOWN AORTIC ANEURYSM",
      "ABDOMINAL PAIN:POSS AORTIC ANEURYSM",
      "AIRBORNE AIRCRAFT",
      "AIRCRAFT ACCIDENT",
      "AIRCRAFT CRASH -- ALERT III",
      "AIRCRAFT CRASH / STRUCTURE INVOLVED-ALERT III",
      "AIRCRAFT CRASH OUTSIDE AIRPORT",
      "AIRCRAFT EMERGENCY -- UNKNOWN SITUATION",
      "AIRCRAFT EMERGENCY -- WATER (INLAND)",
      "AIRCRAFT EMERGENCY -- WATER (OCEAN)",
      "AIRCRAFT EMERGENCY- COASTAL WATER",
      "AIRCRAFT FIRE ON GROUND-ALERT III",
      "AIRCRAFT INCIDENT *STAND-BY*",
      "AIRCRAFT INCOMING -- ALERT I",
      "AIRCRAFT INCOMING -- ALERT II",
      "ALLERGIC REACTION: NOT ALERT",
      "ALLERGIES / SWARMING ATTACK",
      "ALLERGIES/ Hx SEVERE REACTION",
      "ALLERGIES/ RESPIRATORY PROBLEMS",
      "ALLERGIES/HIVES/MED REACTION/STINGS",
      "ALTERED MENTAL STATUS",
      "ANIMAL ATTACK or MULTIPLE ANIMALS",
      "ANIMAL BITES / ATTACKS / EXOTIC ANIMAL",
      "ANIMAL BITES / ATTACKS / PTN NOT ALERT",
      "ANIMAL BITES / ATTACKS",
      "ANIMAL BITES / ATTACKS/CHEST or NECK INJURY W/DIFF BREATHING",
      "ANIMAL BITES / ATTACKS/LARGE ANIMAL",
      "ANIMAL BITES / ATTACKS/POSS DANGERIOUS BODY AREA",
      "ANIMAL BITES / ATTACKS: NON RECENT INJURIES",
      "ANIMAL BITES / ATTACKS: NOT DANGERIOUS BODY AREA",
      "ANIMAL BITES / ATTACKS: POSS DANGERIOUS BODY AREA",
      "ANIMAL BITES / ATTACKS: PTN UNCONSCIOUS or IN ARREST",
      "ANIMAL BITES / ATTACKS: SERIOUS BLEEDING",
      "ANIMAL BITES / ATTACKS: SUPERFICIAL INJURIES",
      "ANIMAL BITES / ATTACKS: UNK STATUS",
      "ANIMAL RESCUE",
      "APARTMENT FIRE (OR TOWNHOME/CONDO)",
      "APARTMENT FIRE",
      "ASSAULT / SEXUAL ASSAULT / CHEST or NECK INJURY DIFF BREATHING",
      "ASSAULT / SEXUAL ASSAULT / MULTIPLE VICTIMS",
      "ASSAULT / SEXUAL ASSAULT / NON-RECENT INJURIES",
      "ASSAULT / SEXUAL ASSAULT / NOT ALERT",
      "ASSAULT / SEXUAL ASSAULT / NOT DANGEROUS BODY AREA",
      "ASSAULT / SEXUAL ASSAULT / POSS DANGEROUS BODY AREA",
      "ASSAULT / SEXUAL ASSAULT / SERIOUS BLEEDING",
      "ASSAULT / SEXUAL ASSAULT / UNK STATUS",
      "ASSAULT / SEXUAL ASSAULT",
      "ASSAULT / UNCONSCIOUS PATIENT",
      "ASSAULT",
      "ASSIST OUTSIDE AGENCY/ MULTIPLE UNITS",
      "ASSIST OUTSIDE AGENCY/ SINGLE UNIT",
      "ASSIST OUTSIDE AGENCY/MULTIPLE UNITS",
      "ASSIST OUTSIDE AGENCY/SINGLE UNIT",
      "BACK PAIN (NON-RECENT/TRAUMATIC)",
      "BACK PAIN (NON-TRAUMATIC OR NON-RECENT TRAUMATIC)",
      "BACK PAIN (NON-TRAUMATIC)",
      "BACK PAIN W/ KNOWN AORTIC ANEURYSM",
      "BACK PAIN W/FAINTING OR NEAR FAINTING >50",
      "BACK PAIN: NOT ALERT",
      "BACK PAIN:POSS AORTIC ANEURYSM",
      "BLOOD PRESSURE ABNORMALITY",
      "BOAT FIRE",
      "BODY RECOVERY",
      "BOILS",
      "BOMB THREAT",
      "BREATHING PROBLEMS / DIFFICULTY SPEAKING",
      "BREATHING PROBLEMS / NOT ALERT",
      "BREATHING PROBLEMS",
      "BREATHING PROBLEMS: CHANGING COLOR",
      "BREATHING PROBLEMS: CLAMMY",
      "BREATHING PROBLEMS: INEFFECTIVE BREATHING",
      "BRUSH / GRASS FIRE",
      "BRUSH, GRASS, WOODS FIRE",
      "BUILDING FIRE",
      "BUMPS",
      "BURNS (SCALDS)/EXPLOSION",
      "BURNS / BLAST INJURY",
      "BURNS / RESPIRATORY DISTRESS",
      "BURNS / SIGNIFICANT FACIAL",
      "BURNS /EXPLOSION",
      "BURNS < 18% TBSA",
      "BURNS > 18% TBSA",
      "BURNS/EXPLOSION",
      "BURNS/EXPLOSION: UNK STATUS",
      "BURNS/EXPLOSIONS",
      "BURNS: DIFF SPEAKING BET BREATHS",
      "BURNS: PTN NOT ALERT",
      "BURNS: UNCONSCIOUS or ARREST",
      "BURNS:PERSON ON FIRE",
      "CAN'T SLEEP",
      "CAN'T URINATE",
      "CARBON MONOXIDE / INHALATION / HAZ MAT",
      "CARBON MONOXIDE / MULTIPLE VICTIMS",
      "CARBON MONOXIDE / NOT ALERT",
      "CARBON MONOXIDE / SEVERE DIFF BREATHING",
      "CARBON MONOXIDE / UNCONSCIOUS",
      "CARBON MONOXIDE / UNK STATUS",
      "CARBON MONOXIDE DETECTOR",
      "CARDIAC / RESPIRATORY ARREST",
      "CARDIAC  ARREST / STRANGULATION",
      "CARDIAC / RESPIRATORY ARREST / AGONAL",
      "CARDIAC / RESPIRATORY ARREST- ALS RESPONSE",
      "CARDIAC ARREST / HANGING",
      "CARDIAC ARREST / SUFFOCATION",
      "CARDIAC ARREST / UNDERWATER",
      "CARDIAC ARREST/ APPARENT DEATH",
      "CARDIAC ARREST/ OBVIOUS DEATH",
      "CARDIAC ARREST/EXPECTED DEATH",
      "CARDIAC / RESPIRATORY ARREST- ALS RESPONSE",
      "CARDIAC OR RESPIRATORY ARREST",
      "CARDIAC OR RESPIRATORY ARREST/DEATH",
      "CARDIAC/RESPIRATORY ARREST/QUESTIONABLE DEATH",
      "CATHETER PROBLEMS",
      "CAVE IN",
      "CHEST PAIN",
      "CHEST PAIN / ABNORMAL BREATHING",
      "CHEST PAIN / BREATHING DIFF (SEVERE)",
      "CHEST PAIN / BREATHING NORMALLY <35",
      "CHEST PAIN / BREATHING NORMALLY >35",
      "CHEST PAIN / CARDIAC HISTORY",
      "CHEST PAIN / CLAMMY",
      "CHEST PAIN / COCAINE INGESTION",
      "CHEST PAIN / NOT ALERT",
      "CHEST PAIN / SKIN CHANGING COLOR",
      "CHEST PAIN- ALS RESPONSE",
      "CHEST PAIN CARDIAC HISTORY",
      "CHILDBIRTH / BABY BORN / NO COMPLICATIONS",
      "CHILDBIRTH / BABY BORN W/COMPLICATIONS TO BABY",
      "CHILDBIRTH / BABY BORN W/COMPLICATIONS TO MOTHER",
      "CHILDBIRTH / BREECH or CORD PRESENTATION",
      "CHILDBIRTH / HEAD VISIBLE or OUT",
      "CHILDBIRTH / IMMINENT DELIVERY",
      "CHIMNEY FIRE",
      "CHOKING / COMPLETE OBSTRUCTION",
      "CHOKING / NOT ALERT",
      "CHOKING / PARTIAL OBSTRUCTION",
      "CHOKING",
      "CHOKING:NOT CHOKING NOW",
      "CITIZEN ASSIST -- LOCKED IN VEHICLE",
      "CITIZEN ASSIST -- LOCKED IN/OUT OF BUILDING",
      "CITIZEN ASSIST -- NON-MEDICAL",
      "CITIZEN ASSIST -- POSS MEDICAL ASSIST",
      "CITIZEN ASSIST -- WATER PROBLEM",
      "CITIZEN ASSIST -- WATER PROBLEM w/ELECTRICAL HAZARD",
      "CITIZEN LOCKED IN/OUT OF BUILDING",
      "COMMERCIAL BUILDING FIRE",
      "COMMERCIAL VEHICLE FIRE",
      "COMMERCIAL/INDUSTRIAL BUILDING FIRE w/HAZ-MATERIALS",
      "CONFINED SPACE ENTRAPMENT / TECHNICAL RESCUE",
      "CONFINED SPACE RESCUE",
      "CONFINED SPACE/COLLAPSE RESCUE + HAZ-MAT UNCONFIRMED",
      "CONFINED SPACE/COLLAPSE RESCUE + HAZ-MAT",
      "CONFINED SPACE/COLLAPSE RESCUE UNCONFIRMED",
      "CONFINED SPACE/COLLAPSE RESCUE",
      "CONSTIPATION",
      "CONTROLLED BURN",
      "CONVULSIONS / SEIZURES",
      "CRAMPS/SPASMS: IN EXTREMITIES",
      "CUT-OFF RING REQUEST",
      "DEAFNESS",
      "DEFECATION/DIARRHEA",
      "DIABETIC PROBLEMS / ALTERED MENTAL STATUS",
      "DIABETIC PROBLEMS",
      "DIABETIC PROBLEMS/ BEHAVING ABNORMALLY",
      "DIABETIC PROBLEMS/ UNCONSCIOUS",
      "DIABETIC PROBLEMS/ABNORMAL BREATHING",
      "DIABETIC UNCONSCIOUS",
      "DIZZINESS/VERTIGO",
      "DOWNED TREES & OTHER OBJECTS",
      "DROWNING (NEAR) / DIVING ACCIDENT",
      "DROWNING (NEAR) / DIVING ACCIDENT-ALERT & BREATHING NORMALLY",
      "DROWNING / DIVING ACC / ABNORMAL BREATHING",
      "DROWNING / DIVING ACC / IN WATER & BREATHING NORMALLY",
      "DROWNING / DIVING ACC / NECK INJURY",
      "DROWNING / DIVING ACC / NOT ALERT",
      "DROWNING / DIVING ACC / UNCONSCIIOUS PATIENT",
      "DROWNING / DIVING ACC / UNK STATUS",
      "EARACHE",
      "ELECTRICAL HAZARD -- APPLIANCE / NO ODOR",
      "ELECTRICAL HAZARD -- APPLIANCE / ODOR PRESENT",
      "ELECTRICAL HAZARD -- ELECTRICAL ARCING",
      "ELECTRICAL HAZARD -- ELECTRICAL ODOR",
      "ELECTRICAL HAZARD -- NEAR WATER",
      "ELECTRICAL HAZARD -- UNKNOWN SITUATION",
      "ELECTRICAL HAZARD -- WIRES DOWN-NO SMOKE/NO ARCING",
      "ELECTRICAL HAZARD -- WIRES DOWN-SMOKE / ARCING",
      "ELECTROCUTION  / LIGHTNING / ABNORMAL BREATHING",
      "ELECTROCUTION  / LIGHTNING / ALERT & BREATHING NORMALLY",
      "ELECTROCUTION  / LIGHTNING / EXTREME FALL >30FT",
      "ELECTROCUTION  / LIGHTNING / HAZARD PRESENT",
      "ELECTROCUTION  / LIGHTNING / LONG FALL",
      "ELECTROCUTION  / LIGHTNING / NOT ALERT",
      "ELECTROCUTION  / LIGHTNING / NOT BREATHING",
      "ELECTROCUTION  / LIGHTNING / NOT DISCONN FROM POWER",
      "ELECTROCUTION  / LIGHTNING / UNCONSCIOUS",
      "ELECTROCUTION / LIGHTNING / UNK STATUS",
      "ELECTROCUTION / LIGHTNING",
      "ELECTROCUTION",
      "ELECTRONIC ALARM -- BURGLARY/HOLDUP/PANIC/VEHICLE",
      "ELECTRONIC ALARM -- COMMERCIAL STRUCTURE",
      "ELECTRONIC ALARM -- HIGH LIFE HAZARD",
      "ELECTRONIC ALARM -- HIGH RISE STRUCTURE",
      "ELECTRONIC ALARM -- MANUFACTURED HOUSING/OFFICE",
      "ELECTRONIC ALARM -- MEDICAL ALARM",
      "ELECTRONIC ALARM -- NON-DWELLING",
      "ELECTRONIC ALARM -- RESIDENTIAL (CO DETECTOR)",
      "ELECTRONIC ALARM -- RESIDENTIAL (SINGLE)",
      "ELECTRONIC ALARM -- RESIDENTIAL STRUCTURE (MULTIPLE)",
      "ELECTRONIC ALARM -- UNKNOWN SITUATION",
      "ELEVATOR / ESCALATOR RESCUE -- CAUGHT / NO INJURIES",
      "ELEVATOR / ESCALATOR RESCUE -- ENTRAPMENT / INJURIES",
      "ELEVATOR / ESCALATOR RESCUE -- UNK SITUATION",
      "ELEVATOR MALFUNCTION -- NO OCCUPANTS",
      "ELEVATOR RESCUE -- MEDICAL CONDITION",
      "ELEVATOR RESCUE -- OCCUPANTS INSIDE",
      "EMS ASSISTANCE CALL",
      "ENEMA",
      "ESCALATOR INCIDENT NOT CAUGHT NO INJURIES",
      "EXPLOSION -- COMMERCIAL STRUCTURE",
      "EXPLOSION -- COMMERCIAL VEHICLE",
      "EXPLOSION -- HIGH LIFE HAZARD",
      "EXPLOSION -- HIGH RISE",
      "EXPLOSION -- LARGE NON-DWELLING STRUCTURE",
      "EXPLOSION -- NON-STRUCTURE EXPLOSION",
      "EXPLOSION -- RESIDENTIAL (MULTIPLE)",
      "EXPLOSION -- RESIDENTIAL (SINGLE)",
      "EXPLOSION -- SMALL NON-DWELLING",
      "EXPLOSION -- UNKNOWN SITUATION",
      "EXPLOSION -- VEHICLE LARGE FUEL LOAD",
      "EXPLOSION -- VEHICLE",
      "EXTREME FALL   > 30 FEET",
      "EXTRICATION / ENTRAPMENT",
      "EXTRICATION / ENTRAPMENT -- NO LONGER TRAPPED",
      "EXTRICATION / ENTRAPMENT -- UNK SITUATION",
      "EYE INJURY / MODERATE / CHEMICAL IN EYE",
      "EYE PROBLEMS / INJURIES / NOT ALERT",
      "EYE PROBLEMS / INJURIES",
      "EYE PROBLEMS / INJURIES/ MEDICAL",
      "EYE PROBLEMS / INJURIES/ MINOR",
      "FALL INJURY  / NON-RECENT",
      "FALL INJURY / CHEST or NECK INJURY / DIFF BREATHING",
      "FALL INJURY / LONG FALL",
      "FALL INJURY / NOT ALERT",
      "FALL INJURY / NOT DANGEROUS BODY AREA",
      "FALL INJURY / NOT DANGEROUS BODY PART",
      "FALL INJURY / UNCONSCIOUS",
      "FALL-PUBLIC ASSISTANCE",
      "FALLS",
      "FALLS:LIFTING ASSISTANCE",
      "FALLS: POSS DANGEROUS INJURIES",
      "FALLS: SERIOUS BLEEDING",
      "FALLS: UNK STATUS",
      "FEVER/CHILLS",
      "FIRE (IDENTIFY)",
      "FIRE ALARM",
      "FIRE DEPT SET UP LANDING ZONE",
      "FIRE INVESTIGATION",
      "FOCAL SEIZURE-NOT ALERT",
      "FUEL SPILL -- CONTAINED LARGE SPILL",
      "FUEL SPILL -- CONTAINED SMALL SPILL",
      "FUEL SPILL -- IN/NEAR WATERWAY",
      "FUEL SPILL -- UNCONTAINED LARGE SPILL",
      "FUEL SPILL -- UNCONTAINED SMALL SPILL",
      "FUEL SPILL -- UNKNOWN SITUATION",
      "GAS LEAK / ODOR",
      "GAS LEAK / ODOR -- COMMERCIAL STRUCTURE",
      "GAS LEAK / ODOR -- HIGH LIFE HAZARD",
      "GAS LEAK / ODOR -- HIGH RISE",
      "GAS LEAK / ODOR -- OUTSIDE COMMERCIAL LINE or TANK >5 GALS",
      "GAS LEAK / ODOR -- OUTSIDE RESIDENTIAL LINE or TANK <5 GALS",
      "GAS LEAK / ODOR -- RESIDENTIAL",
      "GAS LEAK / ODOR -- RESIDENTIAL (MULTIPLE/APARTMENT)",
      "GENERAL PAIN",
      "GENERAL WEAKNESS",
      "GOUT",
      "GRASS FIRE",
      "GUNSHOT -- CENTRAL WOUND",
      "GUNSHOT -- MULTIPLE VICTIMS",
      "GUNSHOT -- NON RECENT INJURY",
      "GUNSHOT -- NOT ALERT",
      "GUNSHOT -- PERIPHERAL WOUND",
      "GUNSHOT -- POSS DEATH",
      "GUNSHOT -- SERIOUS HEMORRHAGE",
      "GUNSHOT -- UNCONSCIOUS VICTIM",
      "GUNSHOT -- UNK INJURIES",
      "GUNSHOT / OBVIOUS DEATH",
      "GUNSHOT WOUND -- NON RECENT",
      "HAZARDOUS MATERIALS INCIDENT",
      "HAZMAT RESPONSE -- CONTAINED SPILL / LEAK",
      "HAZMAT RESPONSE -- ILLEGAL DRUG LAB (CONTAINED)",
      "HAZMAT RESPONSE -- ILLEGAL DRUG LAB (UNCONTAINED)",
      "HAZMAT RESPONSE -- SMALL SPILL <5 GALS",
      "HAZMAT RESPONSE -- UNCONTAINED SPILL / LEAK",
      "HEADACHE",
      "HEADACHE / ABNORMAL BREATHING",
      "HEADACHE / BREATHING NORMAL",
      "HEADACHE / CHANGE IN BEHAVIOR <3hrs.",
      "HEADACHE / NOT ALERT",
      "HEADACHE / NUMBNESS",
      "HEADACHE / PARALYSIS",
      "HEADACHE / SPEECH PROBLEMS",
      "HEADACHE / SUDDEN ONSET",
      "HEADACHE / UNK STATUS",
      "HEART PROBLEMS",
      "HEART PROBLEMS /  ABNORMAL BREATHING",
      "HEART PROBLEMS / A.I.C.D. / CARDIAC HISTORY",
      "HEART PROBLEMS / A.I.C.D. / CHANGING COLOR",
      "HEART PROBLEMS / A.I.C.D. / CHEST PAIN >35",
      "HEART PROBLEMS / A.I.C.D. / DIFFICULTY BREATHING",
      "HEART PROBLEMS / A.I.C.D. / NOT ALERT",
      "HEART PROBLEMS / A.I.C.D. CHEST PAIN <35",
      "HEART PROBLEMS / A.I.C.D. FIRING",
      "HEART PROBLEMS / A.I.C.D. HR >50bpm & <130bpm",
      "HEART PROBLEMS / A.I.C.D.",
      "HEART PROBLEMS / ABNORMAL BREATHING",
      "HEART PROBLEMS / CLAMMY",
      "HEART PROBLEMS / COCAINE USE",
      "HEART PROBLEMS / HR <50 or >130 bpm",
      "HEART PROBLEMS / RESUSCITATED OR DEFIBRILLATED",
      "HEART PROBLEMS / UNK STATUS",
      "HEART PROBLEMS WITH CHEST PAIN",
      "HEAT / COLD EXPOSURE / CHANGE IN SKIN COLOR",
      "HEAT / COLD EXPOSURE / MULTIPLE VICTIMS",
      "HEAT / COLD EXPOSURE / NOT ALERT",
      "HEAT / COLD EXPOSURE / UNK STATUS",
      "HEAT / COLD EXPOSURE",
      "HEAT / COLD EXPOSURE/ CARDIAC HISTORY",
      "HEAT / COLD EXPOSURE: ALERT",
      "HEMORRHAGE / ABNORMAL BREATHING",
      "HEMORRHAGE / LACERATION / ABNORMAL BREATHING",
      "HEMORRHAGE / LACERATIONS / BLEEDING DISORDER",
      "HEMORRHAGE / LACERATIONS / DANGEROUS BODY AREA",
      "HEMORRHAGE / LACERATIONS / MINOR",
      "HEMORRHAGE / LACERATIONS / NOT ALERT",
      "HEMORRHAGE / LACERATIONS / POSS DANGEROUS HEMORRAGE",
      "HEMORRHAGE / LACERATIONS / SERIOUS",
      "HEMORRHAGE / LACERATIONS / UNCONSCIOUS OR ARREST",
      "HEMORRHAGE / LACERATIONS",
      "HEMORRHAGE / LACERATIONS/ BLOOD THINNERS",
      "HEMORRHAGE / LACERATIONS: NOT DANGERIOUS",
      "HEMORRHAGE / LACERATIONS: NOT DANGEROUS",
      "HEMORRHAGE / SEVERE",
      "HEMORRHAGE FROM DIALYSIS SHUNT",
      "HEMORRHAGE: THROUGH TUBES",
      "HEMORRHOIDS/PILES",
      "HEPATITIS",
      "HICCUPS",
      "HIGH ANGLE RESCUE -- SUICIDAL PERSON",
      "HIGH ANGLE RESCUE -- UNKNOWN SITUATION / INVESTIGATION",
      "HIGH ANGLE RESCUE",
      "HIGH ANGLE ROPE RESCUE",
      "HIGH RISE FIRE",
      "HOSPITAL FIRE",
      "HOTEL FIRE",
      "HYDRANT PROBLEMS",
      "ICE RESCUE",
      "IMPENDING SEIZURE (AURA)",
      "INACCESSIBLE INCIDENT / NO INJURIES",
      "INACCESSIBLE INCIDENT / NO LONGER TRAPPED/ UNK INJURIES",
      "INACCESSIBLE INCIDENT / OTHER ENTRAPMENTS",
      "INACCESSIBLE INCIDENT / OTHER ENTRAPMENTS",
      "INACCESSIBLE INCIDENT / UNK STATUS",
      "INACCESSIBLE TERRAIN SITUATION / TECHNICAL RESCUE",
      "INDUSTRIAL COMPLEX FIRE",
      "INSPECTION FIRE / SMOKE",
      "ITCHING",
      "LARGE OUTSIDE FIRE -- HAZARDOUS MATERIALS PRESENT",
      "LAW ENFORCEMENT STANDBY",
      "LIGHTNING STRIKE (NO FIRE) -- COMMERCIAL STRUCTURE",
      "LIGHTNING STRIKE (NO FIRE) -- HIGH LIFE HAZARD",
      "LIGHTNING STRIKE (NO FIRE) -- HIGH RISE",
      "LIGHTNING STRIKE (NO FIRE) -- LARGE NON-DWELLING STRUCTURE",
      "LIGHTNING STRIKE (NO FIRE) -- MFG HOME/TRAILER",
      "LIGHTNING STRIKE (NO FIRE) -- OUTSIDE",
      "LIGHTNING STRIKE (NO FIRE) -- RESIDENTIAL (MULTIPLE)",
      "LIGHTNING STRIKE (NO FIRE) -- RESIDENTIAL (SINGLE)",
      "LIGHTNING STRIKE -- SMALL NON-DWELLING STRUCTURE",
      "LIGHTNING STRIKE/ INVESTIGATION",
      "LOCKED OUT OF VEH",
      "MAJOR TRAFFIC ACCIDENT",
      "MARINE VESSEL FIRE -- BEACHED/COASTAL",
      "MARINE VESSEL FIRE -- BEACHED/INLAND",
      "MARINE VESSEL FIRE -- DOCKED/COASTAL",
      "MARINE VESSEL FIRE -- DOCKED/INLAND",
      "MARINE VESSEL FIRE -- IN DRY DOCK/ON LAND",
      "MARINE VESSEL FIRE -- ON WATER / COASTAL",
      "MARINE VESSEL FIRE -- ON WATER / GULF",
      "MARINE VESSEL FIRE -- ON WATER / INLAND",
      "MARINE VESSEL FIRE -- REPORTED EXTINGUISHED",
      "MARINE VESSEL FIRE -- THREATENED STRUCTURE/BOAT",
      "MCEMS 911 TRANSFER",
      "MECHANICAL / MACHINERY ENTRAPMENT / TECH RESCUE",
      "MEDICAL ALARM ACTIVATION",
      "MOTEL FIRE",
      "MOTOR VEHICLE COLLISION",
      "MOTOR VEHICLE COLLISION WITH ENTRAPMENT",
      "MOTOR VEHICLE COLLISION HIGH VELOCITY IMPACT",
      "MOTOR VEHICLE COLLISION WITH UNKNOWN INJURIES",
      "MOVING TRAIN",
      "MUDSLIDE / TECHNICAL RESCUE",
      "MUTL-AID MOVE/UP-COVER AREA",
      "MUTL-AID TO INCIDENT/ MULTIPLE UNITS",
      "MUTL-AID TO INCIDENT/ SINGLE UNIT",
      "MUTL-AID TO INCIDENT/MULTIPLE UNITS",
      "MUTL-AID TO INCIDENT/SINGLE UNIT",
      "MUTL-AID TO STAGING AREA",
      "MVC OVERTURNED VEHICLE",
      "NAUSEA",
      "NERVOUS",
      "NEW ONSET OF IMMOBILITY",
      "NURSING HOME FIRE",
      "OBJECT STUCK",
      "OBJECT SWALLOWED",
      "ODOR (STRANGE/UNK) -- INSIDE",
      "ODOR (STRANGE/UNK) -- OUTSIDE",
      "ODOR INVESTIGATION -- INSIDE WITH PATIENTS",
      "ODOR INVESTIGATION -- OUTSIDE WITH PATIENTS",
      "OMEGA",
      "ONE DOWN / LIFE STATUS QUESTIONABLE",
      "ONE DOWN / SUBJ MOVING",
      "ONE DOWN / UNK STATUS",
      "ONE FALLEN",
      "ONE TASED  (ASSIST POLICE)",
      "ONE TRAPPED BY A TRAIN (NO DERAILMENT)",
      "OTHER ASSISTANCE (SPECIFY)",
      "OUTSIDE FIRE (LARGE)",
      "OUTSIDE FIRE -- REPORTED EXTINGUISHED",
      "OUTSIDE FIRE -- UNKNOWN SITUATION",
      "OUTSIDE TANK LEAK <5 GALLONS",
      "OVERDOSE / ANTIDEPRESEANTS",
      "OVERDOSE / COCAINE or METHAMPHETAMINE",
      "OVERDOSE / INGESTION / POISONING",
      "OVERDOSE / NARCOTICS (HEROIN LORTAB MORPHINE etc)",
      "OVERDOSE / POISONING (INGESTION)",
      "OVERDOSE / POISONING / ABNORMAL BREATHING",
      "OVERDOSE / POISONING / ACID / ALKALI",
      "OVERDOSE / POISONING / CHANGING COLOR",
      "OVERDOSE / POISONING / POISON CONTROL REQ RESPONSE",
      "OVERDOSE / POISONING / UNCONSCIOUS",
      "OVERDOSE / WITHOUT PRIORITY SYMPTOMS",
      "OVERDOSE/ POISONING  / NOT ALERT",
      "OVERDOSE/ POISONING / UNK STATUS",
      "PAINFUL URINATION",
      "PANDEMIC OUTBREAK / ABNORMAL BREATHING MULTI SYMPT",
      "PANDEMIC OUTBREAK / ABNORMAL BREATHING w/FLU SYMPTOM",
      "PANDEMIC OUTBREAK / CHEST PAIN <35 w/MULTI FLU SYMPT",
      "PANDEMIC OUTBREAK / CHEST PAIN MULTIPLE FLU SYMPTOMS",
      "PANDEMIC OUTBREAK / CHEST PAIN w/FLU SYMPTOM",
      "PANDEMIC OUTBREAK / CHEST PAIN w/FLU SYMPTOM",
      "PANDEMIC OUTBREAK / DIFF BREATHING w/FLU SYMPTOMS",
      "PANDEMIC OUTBREAK / FLU LIKE SYMPTOMS",
      "PANDEMIC OUTBREAK / INEFFECTIVE BREATHING w/FLU S/S",
      "PANDEMIC OUTBREAK / NOT ALERT w/FLU SYMPTOMS",
      "PANDEMIC OUTBREAK / SKIN CHANGING COLOR w/FLU SYMPTOMS",
      "PATIENT NOT ALERT",
      "PEDESTRIAN STRUCK",
      "PENIS PROBLEMS/PAIN",
      "PERIPHERAL ENTRAPMENT / TECHNICAL RESCUE",
      "PERSON LOCKED IN VEHICLE",
      "PERSON ON FIRE",
      "PERSON ON FIRE ( INSIDE STRUCTURE )",
      "PERSONAL WATERCRAFT ACCIDENT",
      "POISONING- NO PRIORITY SYMPTOMS",
      "PREGNANCY / CHILDBIRTH / IN LABOR",
      "PREGNANCY / CHILDBIRTH / MISCARRIAGE / 1ST TRIMESTER SERIOUS BLEEDING",
      "PREGNANCY / CHILDBIRTH / MISCARRIAGE / 2ND TRIMESTER BLEEDING",
      "PREGNANCY / CHILDBIRTH / MISCARRIAGE / 3RD TRIMESTER BLEEDING",
      "PREGNANCY / CHILDBIRTH / MISCARRIAGE / HIGH RISK",
      "PREGNANCY / CHILDBIRTH / MISCARRIAGE / UNK STATUS",
      "PREGNANCY / CHILDBIRTH / MISCARRIAGE",
      "PREGNANCY / CHILDBIRTH / MISCARRIAGE: 1ST TRIMESTER BLEEDING",
      "PREGNANCY / CHILDBIRTH / WATER BROKEN",
      "PSYCHIATRIC / NON-SUICIDAL & ALERT",
      "PSYCHIATRIC / SUICIDE ATTEMPT",
      "PSYCHIATRIC / SUICIDE ATTEMPT / DANGEROUS BLEEDING",
      "PSYCHIATRIC / SUICIDE ATTEMPT / MINOR BLEEDING",
      "PSYCHIATRIC / SUICIDE ATTEMPT / NOT ALERT",
      "PSYCHIATRIC / SUICIDE ATTEMPT / SERIOUS BLEEDING",
      "PSYCHIATRIC / SUICIDE ATTEMPT / UNK STATUS",
      "PSYCHIATRIC / SUICIDE ATTEMPT",
      "PSYCHIATRIC / THREATENING SUICIDE",
      "PSYCHIATRIC / THREATENING TO JUMP",
      "QUICKSAND / MARSH / MUD RESCUE",
      "RASH/SKIN DISORDER",
      "REFINERY FIRE -- TANK FARM / FUEL STORAGE FACILITY",
      "RESIDENTIAL FIRE",
      "RESIDENTIAL FIRE -- MFG HOUSING/TRAILER",
      "SCHOOL FIRE",
      "SCUBA ACCIDENT",
      "SEIZURE / DIABETIC HISTORY",
      "SEIZURE / EFFECTIVE BREATHING NOT VERIFIED",
      "SEIZURE / EFFECTIVE BREATHING NOT VERIFIED <35",
      "SEIZURE / EFFECTIVE BREATHING UNVERIFIED",
      "SEIZURE / INEFFECTIVE BREATHING",
      "SEIZURE / NO LONGER SEIZING & BREATHING NORMALLY (KNOWN SEIZURE DISORDER)",
      "SEIZURE / NO LONGER SZ, BREATHING",
      "SEIZURE / NOT BREATHING",
      "SEIZURE / PREGNANCY",
      "SEIZURE-ATYPICAL",
      "SEIZURE-FOCAL (ALERT)",
      "SEIZURE-HISTORY OF STROKE OR BRAIN TUMOR",
      "SEIZURE-NO LONGER SEIZING/EFFECTIVE BREATHING VERIF/NO SZ HX",
      "SEIZURE-NOT SEIZING NOW & EFFECTIVE BREATHING VERIF <6 CONF NO SEIZURE DISORDER",
      "SEIZURE-OVERDOSE/POISONING (INGESTION)",
      "SEIZURES / CONTINUOUS or MULTIPLE",
      "SEIZURE CONTINUOUS or MULTIPLE",
      "SELF INFLICTED GUNSHOT -- CENTRAL WOUND",
      "SELF INFLICTED GUNSHOT -- MULTIPLE WOUNDS",
      "SELF INFLICTED GUNSHOT -- NON RECENT",
      "SELF INFLICTED GUNSHOT -- NOT ALERT",
      "SELF INFLICTED GUNSHOT -- PERIPHERAL",
      "SELF INFLICTED GUNSHOT -- POSS DEATH",
      "SELF INFLICTED GUNSHOT -- SERIOUS HEMORRHAGE",
      "SELF INFLICTED GUNSHOT -- UNCONSCIOUS VICTIM",
      "SELF INFLICTED GUNSHOT -- UNK STATUS",
      "SELF INFLICTED GUNSHOT WOUND -- NON RECENT",
      "SERVICE CALL",
      "SERVICE CALL-MULTIPLE UNITS",
      "SERVICE CALL-POSS MEDICAL ASSISTANCE",
      "SEVERE EYE PROBLEMS / INJURIES",
      "SEWER PROBLEMS",
      "SEXUALLY TRANSMITTED DISEASE",
      "SHIP FIRE",
      "SICK PERSON- ALS RESPONSE",
      "SICK CALL / ABNORMAL BREATHING",
      "SICK CALL",
      "SICK PERSON (UNKNOWN SYMPTOMS)",
      "SICK PERSON / UNK STATUS",
      "SICK PERSON",
      "SICKLE CELL CRISIS",
      "SMALL OUTSIDE FIRE -- HAZARDOUS MATERIALS PRESENT",
      "SMALL OUTSIDE/TRASH FIRE",
      "SMOKE INVESTIGATION -- HEAVY SMOKE",
      "SMOKE INVESTIGATION -- LIGHT SMOKE",
      "SMOKE INVESTIGATION -- ODOR OF SMOKE",
      "SMOKE ODOR (RESIDENTIAL)",
      "SNAKEBITE",
      "SORE THROAT",
      "SPECIAL EVENT",
      "SPILL / LEAK",
      "STAB / GUNSHOT / CENTRAL WOUND",
      "STAB / GUNSHOT / MULTIPLE VICTIMS",
      "STAB / GUNSHOT / MULTIPLE WOUNDS",
      "STAB / GUNSHOT / NON-RECENT CENTRAL WOUND",
      "STAB / GUNSHOT / NOT ALERT",
      "STAB / GUNSHOT / PERIPHERAL NON-RECENT WOUNDS",
      "STAB / GUNSHOT / SERIOUS BLEEDING",
      "STAB / GUNSHOT / SINGLE PERIPHERAL WOUND",
      "STAB / GUNSHOT / UNCONSCIOUS / ARREST",
      "STAB / GUNSHOT : UNKNOWN STATUS",
      "STAB / GUNSHOT WOUND",
      "STABBING -- CENTRAL WOUND",
      "STABBING -- MULTIPLE VICTIMS",
      "STABBING -- MULTIPLE WOUNDS",
      "STABBING -- NON RECENT",
      "STABBING -- NON RECENT WOUND",
      "STABBING -- NOT ALERT",
      "STABBING -- PERIPHERAL WOUND",
      "STABBING -- POSS DEATH",
      "STABBING -- SERIOUS HEMORRHAGE",
      "STABBING -- UNCONSCIOUS VICTIM",
      "STABBING -- UNK INJURIES",
      "STROKE (CVA) / ABNORMAL BREATHING",
      "STROKE (CVA) / BREATHING NORMAL <35",
      "STROKE (CVA) / BREATHING NORMALLY >35",
      "STROKE (CVA) / NOT ALERT",
      "STROKE (CVA) / STROKE HISTORY",
      "STROKE (CVA) / SUDDEN LOSS OF BALANCE or COORDINATION",
      "STROKE (CVA) / SUDDEN ONSET OF SEVERE HEADACHE",
      "STROKE (CVA) / SUDDEN PARALYSIS or FACIAL DROOP (ONE SIDE)",
      "STROKE (CVA) / SUDDEN SPEECH PROBLEMS",
      "STROKE (CVA) / SUDDEN VISION PROBLEMS",
      "STROKE (CVA) / SUDDEN WEAKNESS or NUMBNESS (ONE SIDE)",
      "STROKE (CVA) / UNK STATUS",
      "STROKE (CVA) /UNKNOWN STATUS (OTHER CODES NOT APPLICABLE)",
      "STROKE (CVA)",
      "STRUCTURAL COLLAPSE / TECHNICAL RESCUE",
      "STRUCTURE FIRE -- APPLIANCE FIRE",
      "STRUCTURE FIRE -- HIGH LIFE HAZARD",
      "STRUCTURE FIRE -- LARGE NON-DWELLING (SHED/DET. GARAGE)",
      "STRUCTURE FIRE -- SMALL NON-DWELLING STRUCTURE",
      "STRUCTURE FIRE -- UNK SITUATION",
      "STRUCTURE FIRE -- VICTIM INSIDE",
      "STRUCTURE FIRE W/PERSONS INSIDE",
      "SUICIDAL (NOT THREATENING) THOUGHTS & ALERT",
      "SUICIDE ATTEMPT / NEAR HANGING or STRANGULATION",
      "SUNBURN / MINOR BURNS",
      "SYNCOPE / ALERT <35 W/CARDIAC HISTORY",
      "SYNCOPE / ALERT <35",
      "SYNCOPE / ALERT >35",
      "SYNCOPE / FAINTING / ALERT / ABNORMAL BREATHING",
      "SYNCOPE / FAINTING / ALERT / CARDIAC HISTORY",
      "SYNCOPE / FAINTING / CHANGING SKIN COLOR",
      "SYNCOPE / FAINTING / FEMALE with ABDOMINAL PAIN",
      "SYNCOPE / FAINTING / NOT ALERT",
      "TEST EVENT TYPE",
      "TOOTHACHE",
      "TRAFFIC  ACCIDENT / HAZARDOUS MATERIALS INCIDENT",
      "TRAFFIC  ACCIDENT / MINOR INJURIES",
      "TRAFFIC  ACCIDENT / NO INJURIES",
      "TRAFFIC ACCIDENT / HAZARDOUS SCENE",
      "TRAFFIC ACCIDENT / HIGH MECHANISM / PEDESTRIAN",
      "TRAFFIC ACCIDENT / MINOR INJURIES",
      "TRAFFIC ACCIDENT / UNK STATUS",
      "TRAFFIC ACCIDENT W/INJURIES-SERIOUS BLEEDING",
      "TRAFFIC ACCIDENT WITH ENTRAPMENT",
      "TRAFFIC ACCIDENT WITH INJURIES",
      "TRAIN / RAIL INCIDENT -- DERAILMENT ABOVE GROUND",
      "TRAIN / RAIL INCIDENT -- DERAILMENT BELOW GROUND",
      "TRAIN / RAIL INCIDENT -- FIRE ON BOARD IN TUNNEL",
      "TRAIN / RAIL INCIDENT -- GROUND LEVEL",
      "TRAIN / RAIL INCIDENT -- INSIDE TUNNEL",
      "TRAIN / RAIL INCIDENT -- INVOLVING VEHICLES",
      "TRAIN / RAIL INCIDENT -- LARGE FUEL/FIRE LOAD",
      "TRAIN / RAIL INCIDENT -- ON BRIDGE / TRESTLE",
      "TRAIN / RAIL INCIDENT -- VEHICLE INVOLVED",
      "TRAIN COLLISION / DERAILMENT",
      "TRAIN FIRE / EMERGENCY",
      "TRANSFER/INTERFACILITY/PALLIATIVE CARE",
      "TRANSFER/INTERFACILITY/PALLIATIVE CARE/ NOT ALERT",
      "TRANSFER/INTERFACILITY/PALLIATIVE CARE/CARDIAC HISTORY",
      "TRANSFER/INTERFACILITY/PALLIATIVE CARE/DIFF BREATHING",
      "TRANSFER/INTERFACILITY/PALLIATIVE CARE/EMERGENCY RESPONSE",
      "TRANSFER/INTERFACILITY/PALLIATIVE CARE/SEVERE BLEEDING OR SHOCK",
      "TRANSFER/INTERFACILITY/PALLIATIVE CARE/SEVERE PAIN",
      "TRANSFER: POSS CARDIAC ARREST",
      "TRANSFER: RESUSCITATED OR DEFIBRILLATED",
      "TRANSFORMER FIRE ( WIRE / POLE )",
      "TRANSFORMER FIRE ( WIRE or POLE )",
      "TRANSPORTATION ONLY",
      "TRASH FIRE",
      "TRAUMATIC INJURIES",
      "TRAUMATIC INJURIES / CHEST or NECK INJURY  W/ DIFF BREATHING",
      "TRAUMATIC INJURIES / MINOR",
      "TRAUMATIC INJURIES / NON-RECENT",
      "TRAUMATIC INJURIES / NOT ALERT",
      "TRAUMATIC INJURIES / POSSIBLY DANGEROUS BODY AREA",
      "TRAUMATIC INJURIES / SERIOUS BLEEDING",
      "TRAUMATIC INJURIES / UNCONSCIOUS or ARREST",
      "TRAUMATIC INJURY / NON-RECENT",
      "TRENCH COLLAPSE / TECHNICAL RESCUE",
      "TRENCH RESCUE",
      "UNCONSCIOUS / AGONAL BREATHING",
      "UNCONSCIOUS / EFFECTIVE BREATHING VERIFIED",
      "UNCONSCIOUS / FAINTING",
      "UNCONSCIOUS / INEFFECTIVE BREATHING",
      "UNK PROBLEM: CALLERS LANGUAGE NOT UNDERSTOOD",
      "UNKNOWN PROBLEM (MAN DOWN)",
      "UNKNOWN PROBLEM",
      "UNWELL/ILL",
      "VEHICLE ACCCIDENT POSS FATALITY",
      "VEHICLE ACCIDENT -- ATV INVOLVED",
      "VEHICLE ACCIDENT -- BUS INVOLVED",
      "VEHICLE ACCIDENT -- MOTORCYCLE/BICYCLE INVOLVED",
      "VEHICLE ACCIDENT / UNCONSCIOUS or NOT ALERT",
      "VEHICLE ACCIDENT >10 VEHICLES",
      "VEHICLE ACCIDENT OVERTURNED VEHICLE",
      "VEHICLE ACCIDENT SINKING VEHICLE",
      "VEHICLE ACCIDENT VEHICLE OFF BRIDGE",
      "VEHICLE ACCIDENT WITH EJECTION",
      "VEHICLE ACCIDENT",
      "VEHICLE ACCIDENT-SUBWAY/METRO",
      "VEHICLE ACCIDENT-TRAIN INVOLVED",
      "VEHICLE FIRE",
      "VEHICLE FIRE -- EXTINGUISHED (LARGE FUEL LOAD)",
      "VEHICLE FIRE -- EXTINGUISHED",
      "VEHICLE FIRE -- INSIDE TUNNEL",
      "VEHICLE FIRE -- LARGE FUEL/FIRE LOAD",
      "VEHICLE FIRE -- THREATENED NON-STRUCTURE OBJECT",
      "VEHICLE FIRE -- THREATENED STRUCTURE",
      "VEHICLE FIRE / OCCUPANTS TRAPPED",
      "VEHICLE FIRE IN PARKING GARAGE",
      "VEHICLE FIRE",
      "VIOLENT BEHAVIOR",
      "VOMITING",
      "WATER MAIN BREAK",
      "WATER RESCUE (FLOOD)",
      "WATER RESCUE (FLOODING)",
      "WATER RESCUE -- ANIMAL RESCUE",
      "WATER RESCUE -- COASTAL WATER",
      "WATER RESCUE -- GULF OF MEXICO",
      "WATER RESCUE -- INLAND WATER",
      "WATER RESCUE -- SCUBA INCIDENT",
      "WATER RESCUE -- SINKING VEHICLE",
      "WATER RESCUE -- STRANDED MOTORIST (NON-THREATENED)",
      "WATER RESCUE -- SWIFT WATER",
      "WATER RESCUE -- SWIMMING POOL",
      "WATER RESCUE -- UNKNOWN SITUATION",
      "WATERCRAFT / BOATING ACCIDENT",
      "WATERCRAFT IN DISTRESS -- ENGINE STALLED",
      "WATERCRAFT IN DISTRESS -- FLARE SIGHTING (ORANGE or RED)",
      "WATERCRAFT IN DISTRESS -- FLARE SIGHTING",
      "WATERCRAFT IN DISTRESS -- OUT OF FUEL",
      "WATERCRAFT IN DISTRESS -- RUN AGROUND",
      "WATERCRAFT IN DISTRESS -- TAKING ON WATER",
      "WATERCRAFT IN DISTRESS -- UNKNOWN SITUATION",
      "WOODS FIRE",
      "WOUND INFECTED"
  );
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BLAB", "BAYOU LA BATRE",
      "CHIC", "CHICKASAW",
      "CITR", "CITRONELLE",
      "CITY", "CITY OF MOBILE",
      "CNTY", "MOBILE COUNTY",
      "CREO", "CREOLA",
      "DAUP", "DAUPHIN ISLAND",
      "MTVN", "MOUNT VERNON",
      "PRIC", "PRICHARD",
      "SARA", "SARALAND",
      "SATS", "SATSUMA",
      "SEMS", "SEMMES",
      
      
  });
}
