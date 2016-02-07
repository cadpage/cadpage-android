package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Henry County, VA
 */
public class VAHenryCountyParser extends DispatchSouthernParser {
  
  public VAHenryCountyParser() {
    super(CALL_LIST, CITY_LIST, "HENRY COUNTY", "VA", DSFLAG_CROSS_NAME_PHONE | DSFLAG_FOLLOW_CROSS);
    allowBadChars("()");
  }

  @Override
  public String getFilter() {
    return "MHC911@co.henry.va.us,Henrycova911@co.henry.va.us";
  }
  
  private static final Pattern UNIT_PRI_PTN = Pattern.compile(" +([A-Z0-9]+)-\\((\\d)\\) +");
  private static final Pattern LEAD_PRIORITY_PTN = Pattern.compile("^(0?\\d)\\b");
  private static final Pattern APT_MAP_PTN = Pattern.compile("(?:(.*) )?([NSEW]{1,2} SECTOR?)");
  private static final Pattern APT_MAP_PTN2 = Pattern.compile("SECTOR?");
  private static final Pattern ADDR_DIR_PTN = Pattern.compile("(.*) ([NSEW]{1,2})");
  
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
    
    // Fix DEER TRL RD
    data.strAddress = data.strAddress.replace("DEER TRL & RD", "DEER TRL RD");
    
    // The apparently have eliminated all blanks from call descriptions recently
    // so if we did not find a call match, split call description at first blank
    String code = CALL_LIST.getCode(data.strCall);
    if (code == null || code.length() != data.strCall.length()) {
      String info = append(data.strCall, " ", data.strSupp);
      int pt = info.indexOf(' ');
      if (pt >= 0) {
        data.strSupp = info.substring(pt+1).trim();
        data.strCall = info.substring(0,pt);
      }
    }
    
    // See if we can find a priority in front of what is left
    if ((match = LEAD_PRIORITY_PTN.matcher(data.strSupp)).find()) {
      data.strPriority = match.group(1);
      data.strSupp = data.strSupp.substring(match.end()).trim();
    }
    
    match = APT_MAP_PTN.matcher(data.strApt);
    if (match.matches()) {
      data.strApt = getOptGroup(match.group(1));
      data.strMap = match.group(2);
    }
    
    else if (APT_MAP_PTN2.matcher(data.strApt).matches()) {
      match = ADDR_DIR_PTN.matcher(data.strAddress);
      if (match.matches()) {
        data.strAddress = match.group(1).trim();
        data.strMap = match.group(2) + ' ' + data.strApt;
        data.strApt = "";
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
    return super.getProgram().replace("CALL", "CALL PRI").replace("APT", "APT MAP");
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
      "911---911-OPEN-LINE---HANG-UP",
      "ABDOMINAL / BACK PAIN",
      "ABDOMINAL-/-BACK-PAIN",
      "ADMIN MAINTENANCE",
      "ADMIN-MAINTENANCE",
      "ALARM - RESIDENCE",
      "ALARM---RESIDENCE",
      "ALLERGIC REACTION",
      "ALLERGIC-REACTION",
      "ANIMAL / SNAKE BITE",
      "ANIMAL-/-SNAKE-BITE",
      "ASSAULT AGGRAVATED",
      "ASSAULT-AGGRAVATED",
      "ASSAULT-GENERAL",
      "ASSAULT WITH INJURY",
      "ASSAULT-WITH-INJURY",
      "ASSIST-MOTORIST",
      "ASSIST-STATE-POLICE",
      "BLEEDING (NON-TRAUMATIC)",
      "BLEEDING-(NON-TRAUMATIC)",
      "CALL BY PHONE",
      "CALL-BY-PHONE",
      "CARDIAC (WITH PREVIOUS HISTORY)",
      "CARDIAC-(WITH-PREVIOUS-HISTORY)",
      "CHEST PAINS",
      "CHEST-PAINS",
      "CHOKING",
      "CODE-BLUE-(CARDIAC-ARREST)",
      "CODE-GRAY-(SUBJECT-DECEASED)",
      "DELIVER-MESSAGE",
      "DIABETIC ILLNESS",
      "DIABETIC-ILLNESS",
      "DIFFICULTY BREATHING",
      "DIFFICULTY-BREATHING",
      "DISTURBANCE",
      "DISTURBANCE",
      "DIZZINESS, WEAKNESS",
      "DIZZINESS,-WEAKNESS",
      "DOG CASE",
      "DOMESTIC - ASSAULT",
      "DOMESTIC---ASSAULT",
      "EMBEZZLEMENT",
      "ENVIRONMENTAL-EMERGENCIES",
      "EYE-PROBLEM-/-INJURY",
      "F-BRUSH FIRE",
      "F-BRUSH-FIRE",
      "F-CHIMNEY FIRE",
      "F-CHIMNEY-FIRE",
      "F-CONTROLLED BURN",
      "F-CONTROLLED-BURN",
      "F-DUMPSTER FIRE",
      "F-DUMPSTER-FIRE",
      "F-EXPLOSION W-FIRE",
      "F-EXPLOSION-W-FIRE",
      "F-FIRE ALARM",
      "F-FIRE-ALARM",
      "F-GAS SMELL-FUMES",
      "F-GAS-SMELL-FUMES",
      "F-HELICOPTER LANDING ZONE",
      "F-HELICOPTER-LANDING-ZONE",
      "F-OTHER FIRE - EXPLAIN",
      "F-OTHER-FIRE---EXPLAIN",
      "F-POWER LINE DOWN",
      "F-POWER-LINE-DOWN",
      "F-SMOKE INVESTIGATION",
      "F-SMOKE-INVESTIGATION",
      "F-STRUCTURE FIRE",
      "F-STRUCTURE-FIRE",
      "F-UNAUTHORIZED BURNING",
      "F-UNAUTHORIZED-BURNING",
      "F-VEHICLE FIRE",
      "F-VEHICLE-FIRE",
      "FALL - FRACTURE",
      "FALL",
      "FALL---FRACTURE",
      "FAR-ARCING-SHORTED ELEC EQPT",
      "FAR-ARCING-SHORTED-ELEC-EQPT",
      "HEAD-INJURY-/-NEUROLOGICAL",
      "HEADACHE",
      "HIGH BLOOD PRESSURE",
      "HIGH-BLOOD-PRESSURE",
      "HIT & RUN",
      "HIT-&-RUN",
      "LOG FOR RECORD",
      "LOG-FOR-RECORD",
      "MEDICAL ALARM",
      "MEDICAL-ALARM",
      "MOTOR VEHICLE CRASH",
      "MOTOR-VEHICLE-CRASH",
      "MOTOR VEHICL CRASH / PEDESTRIAN",
      "MOTOR-VEHICL-CRASH-/-PEDESTRIAN",
      "MOTOR VEHICLE CRASH W/INJURY",
      "MOTOR-VEHICLE-CRASH-W/INJURY",
      "MOTOR VEHICLE CRASH W/NO INJURY",
      "MOTOR-VEHICLE-CRASH-W/NO-INJURY",
      "OB-GYN (PREGNANCY - MISCARRIAGE)",
      "OB-GYN-(PREGNANCY---MISCARRIAGE)",
      "OVERDOSE",
      "OVERDOSE-/-POISONING",
      "PUBLIC-WORKS-GENERAL",
      "PSYCHIATRIC PATIENT MENTAL",
      "PSYCHIATRIC-PATIENT-MENTAL",
      "PSYCHIATRIC-PATIENT-/-MENTAL",
      "REFUSING-TO-LEAVE",
      "SEIZURES",
      "SERVING WARRANT",
      "SERVING-WARRANT",
      "SICK",
      "SICK / UNKNOWN",
      "SICK-/-UNKNOWN",
      "SICK FLU LIKE SYMPTOMS",
      "SICK-FLU-LIKE-SYMPTOMS",
      "STABBING-/-GUNSHOT-VICTIM",
      "STANDBY",
      "STROKE",
      "SUICIDE SUICIDE ATTEMPT",
      "SUICIDE-SUICIDE-ATTEMPT",
      "SUICIDE-/-SUICIDE-ATTEMPT",
      "SUSPICIOUS CIRCUMSTANCES",
      "SUSPICIOUS-CIRCUMSTANCES",
      "SUSPICIOUS PERSON",
      "SUSPICIOUS-PERSON",
      "SUSPICIOUS-VEHICLE",
      "TRANSPORT (HOSPITAL-DR OFFICE ETC.)",
      "TRANSPORT-(HOSPITAL-DR-OFFICE-ETC.)",
      "TRAUMA",
      "UNCONSCIOUS / UNRESPONSIVE SYNCOPE",
      "UNCONSCIOUS-/-UNRESPONSIVE-SYNCOPE",
      "WEATHER-ALERTS",
      "WELLBEING CHECK",
      "WELLBEING-CHECK"
  );
}
