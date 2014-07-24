package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Henrey County, VA
 */
public class VAHenryCountyParser extends DispatchSouthernParser {
  
  private static final Pattern UNIT_PRI_PTN = Pattern.compile(" +([A-Z0-9]+)-\\((\\d)\\) +");
  private static final Pattern LEAD_PRIORITY_PTN = Pattern.compile("^(0?\\d)\\b");
  private static final Pattern TRAIL_PRIORITY_PTN = Pattern.compile(" +(0?\\d)$");
  private static final Pattern INLINE_PRIORITY_PTN = Pattern.compile(" +(0?\\d) +");
  
  public VAHenryCountyParser() {
    super(CALL_LIST, CITY_LIST, "HENRY COUNTY", "VA", DSFLAG_CROSS_NAME_PHONE | DSFLAG_FOLLOW_CROSS);
    allowBadChars("()");
  }

  @Override
  public String getFilter() {
    return "MHC911@co.henry.va.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = UNIT_PRI_PTN.matcher(body);
    if (match.find()) {
      data.strUnit = match.group(1);
      data.strPriority = match.group(2);
      body = body.substring(0,match.start()) + " " + body.substring(match.end());
    }
    if (!super.parseMsg(body, data)) return false;
    
    // Dispatch - Google spat
    data.strAddress = data.strAddress.replace("WILLIAM F STONE PARK ", "WILLIAM F STONE ");
    
    // See if we can find a priority anywhere
    if ((match = LEAD_PRIORITY_PTN.matcher(data.strSupp)).find()) {
      data.strPriority = match.group(1);
      data.strSupp = data.strSupp.substring(match.end()).trim();
    }
    
    else if ((match = TRAIL_PRIORITY_PTN.matcher(data.strCall)).find()) {
      data.strCall = data.strCall.substring(0,match.start()).trim();
      data.strPriority = match.group(1);
    }
    
    else if (CALL_LIST.getCode(data.strCall) == null) {
      String info = append(data.strCall, " ", data.strSupp);
      match = INLINE_PRIORITY_PTN.matcher(info);
      if (match.find()) {
        data.strCall = info.substring(0,match.start());
        data.strPriority = match.group(1);
        data.strSupp = info.substring(match.end());
      }
    }
    return true;
  }
  
  @Override
  protected void parseExtra(String sExtra, Data data) {
    if (sExtra.startsWith("-")) sExtra = sExtra.substring(1).trim();
    super.parseExtra(sExtra, data);
  }
  
  @Override
  protected boolean isNotExtraApt(String apt) {
    if (apt.startsWith("(")) return true;
    return super.isNotExtraApt(apt);
  }

  @Override
  public String getProgram() {
    return super.getProgram().replace("CALL", "CALL PRI");
  }

  private static final String[] CITY_LIST = new String[]{
      "MARTINSVILLE",
      "RIDGEWAY",

      "AXTON",
      "BASSETT",
      "CHATMOSS",
      "COLLINSVILLE",
      "FIELDALE",
      "HORSEPASTURE",
      "LAUREL PARK",
      "OAK LEVEL",
      "SANDY LEVEL",
      "SPENCER",
      "STANLEYTOWN",
      "VILLA HEIGHTS"


  };
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "911 - 911 OPEN LINE - HANG UP",
      "ABDOMINAL / BACK PAIN",
      "ADMIN MAINTENANCE",
      "ALARM - RESIDENCE",
      "ALLERGIC REACTION",
      "ANIMAL / SNAKE BITE",
      "ASSAULT AGGRAVATED",
      "ASSAULT WITH INJURY",
      "BLEEDING (NON-TRAUMATIC)",
      "CALL BY PHONE",
      "CARDIAC (WITH PREVIOUS HISTORY)",
      "CHEST PAINS",
      "CHOKING",
      "DIABETIC ILLNESS",
      "DIFFICULTY BREATHING",
      "DISTURBANCE",
      "DIZZINESS, WEAKNESS",
      "DOMESTIC - ASSAULT",
      "F-BRUSH FIRE",
      "F-CHIMNEY FIRE",
      "F-CONTROLLED BURN",
      "F-DUMPSTER FIRE",
      "F-EXPLOSION W-FIRE",
      "F-FIRE ALARM",
      "F-HELICOPTER LANDING ZONE",
      "F-OTHER FIRE - EXPLAIN",
      "F-POWER LINE DOWN",
      "F-GAS SMELL-FUMES",
      "F-SMOKE INVESTIGATION",
      "F-STRUCTURE FIRE",
      "F-UNAUTHORIZED BURNING",
      "F-VEHICLE FIRE",
      "FALL",
      "FALL - FRACTURE",
      "FAR-ARCING-SHORTED ELEC EQPT",
      "HEADACHE",
      "HIGH BLOOD PRESSURE",
      "HIT & RUN",
      "LOG FOR RECORD",
      "MEDICAL ALARM",
      "MOTOR VEHICLE CRASH",
      "MOTOR VEHICL CRASH / PEDESTRIAN",
      "MOTOR VEHICLE CRASH W/INJURY",
      "MOTOR VEHICLE CRASH W/NO INJURY",
      "OB-GYN (PREGNANCY - MISCARRIAGE)",
      "OVERDOSE",
      "PSYCHIATRIC PATIENT MENTAL",
      "SEIZURES",
      "SERVING WARRANT",
      "SICK",
      "SICK / UNKNOWN",
      "SICK FLU LIKE SYMPTOMS",
      "STROKE",
      "SUICIDE SUICIDE ATTEMPT",
      "SUSPICIOUS CIRCUMSTANCES",
      "SUSPICIOUS PERSON",
      "TRANSPORT (HOSPITAL-DR OFFICE ETC.)",
      "TRAUMA",
      "UNCONSCIOUS / UNRESPONSIVE SYNCOPE",
      "WELLBEING CHECK"
  );
}
