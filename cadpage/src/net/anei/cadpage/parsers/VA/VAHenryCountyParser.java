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
    
    else {
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



  private static final String[] CITY_LIST = new String[]
     {"RIDGEWAY", "MARTINSVILLE", "SPENCER", "BASSETT", "COLLINSVILLE", "FIELDALE", "AXTON"};
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "ABDOMINAL / BACK PAIN",
      "ALLERGIC REACTION",
      "ANIMAL / SNAKE BITE",
      "ASSAULT AGGRAVATED",
      "ASSAULT WITH INJURY",
      "BLEEDING (NON-TRAUMATIC)",
      "CARDIAC (WITH PREVIOUS HISTORY)",
      "CHEST PAINS",
      "DIABETIC ILLNESS",
      "DIFFICULTY BREATHING",
      "DISTURBANCE",
      "DIZZINESS, WEAKNESS",
      "F-EXPLOSION W-FIRE",
      "F-STRUCTURE FIRE",
      "FALL",
      "FALL - FRACTURE",
      "HEADACHE",
      "HIGH BLOOD PRESSURE",
      "MEDICAL ALARM",
      "MOTOR VEHICLE CRASH",
      "MOTOR VEHICL CRASH / PEDESTRIAN",
      "MOTOR VEHICLE CRASH W/INJURY",
      "OVERDOSE",
      "SICK / UNKNOWN",
      "SICK FLU LIKE SYMPTOMS",
      "STROKE",
      "SEIZURES",
      "SUSPICIOUS PERSON",
      "TRAUMA",
      "UNCONSCIOUS / UNRESPONSIVE SYNCOPE",
      "WELLBEING CHECK"
  );
}
