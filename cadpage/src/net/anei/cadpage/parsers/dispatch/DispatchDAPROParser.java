package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class DispatchDAPROParser extends FieldProgramParser {
  
  private static final String PROGRAM_STR = "ADDR/SC! CFS:ID! Run:ID? CROSS:X";
  
  public DispatchDAPROParser(String defCity, String defState) {
    super(defCity, defState, PROGRAM_STR);
    setup();
  }
  
  public DispatchDAPROParser(Properties cityCodeTable, String defCity, String defState) {
    super(cityCodeTable, defCity, defState, PROGRAM_STR);
    setup();
  }
  
  public DispatchDAPROParser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState, PROGRAM_STR);
    setup();
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    int pt = body.indexOf(" CFS# ");
    if (pt < 0) return false;
    pt += 4;
    body = body.substring(0,pt) + ':' + body.substring(pt+1);
    if (body.startsWith("MAILBOX:")) body = body.substring(8).trim();
    body = body.replace(" Run# ", " Run: ");
    
    if (! super.parseMsg(body, data)) return false;
    return true;
  }

  private static final Pattern TIME_PTN = Pattern.compile("^(\\d\\d:\\d\\d) ");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      
      // First token is always the source
      int pt = field.indexOf(' ');
      if (pt < 0) abort();
      data.strSource = field.substring(0,pt);
      field = field.substring(pt+1).trim();
      
      // Might be followed by a dispatch time
      Matcher match = TIME_PTN.matcher(field);
      if (match.find()) {
        data.strTime = match.group(1);
        field = field.substring(match.end()).trim();
      }
      
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "SRC TIME CALL ADDR APT CITY";
    }
  }
  
  @Override 
  public Field getField(String name) {
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
  
  private void setup() {
    setupCallList(
        "EMS-OTHER",
        "EMS-OTHER/DEFINE",
        "EMS-ABDOMINAL PAIN",
        "EMS-ALLERGIC REACTION",
        "EMS-ALS ASSIST",
        "EMS-ALTERED LOC",
        "EMS-AMPUTATION",
        "EMS-ASSAULT; INJURIES FROM",
        "EMS-AVULSION",
        "EMS-BACK PAIN",
        "EMS-ANIMAL BITE",
        "EMS-BURNS",
        "EMS-CARDIAC",
        "EMS-CARDIAC CONDITION",
        "EMS-CHEST PAIN",
        "EMS-CHOKING",
        "EMS-CO INHALATION",
        "EMS-CODE BLUE",
        "EMS-DIABETIC EMERGENCY",
        "EMS-DIFFICULTY BREATHING",
        "EMS-PERSON DOWN",
        "EMS-ELECTROCUTION",
        "EMS-EYE PROBLEM",
        "EMS-FALLS",
        "EMS-GUNSHOT",
        "EMS-HEADACHE",
        "EMS-HEAT/COLD EXPOSURE",
        "EMS-HEMORRHAGING",
        "EMS-HIGH BLOOD PRESSURE",
        "EMS-ILLNESS",
        "EMS-LACERATION",
        "EMS-MENTAL PROBLEM",
        "EMS-OB RELATED EVENT",
        "EMS-OVERDOSE/POISONING",
        "EMS-PATIENT FALLEN",
        "EMS-SEIZURES",
        "EMS-STAB WOUND",
        "EMS-STROKE",
        "EMS-TRAUMA INJURIES",
        "EMS-UNCONSCIOUS",
        "EMS-UNKNOWN MADICAL",
        "911 HANG UP",
        "911 OPEN LINE",
        "ACCIDENT-INJURY",
        "AUTOMATIC FIRE ALARM",
        "AIRCRAFT INCIDENT",
        "MEDICAL ALARM",
        "ALARM SOUNDING",
        "ATTEMPTED SUICIDE",
        "BOMB THREAT",
        "BRUSH FIRE",
        "BRUSH FIRE THREATENING A STRUC",
        "CHIMNEY FIRE",
        "CO DETECTOR ACTIVATION",
        "POSSIBLE CO EVENT",
        "STRUCTURE COLLAPSE",
        "CONSTRUCTION ACCIDENT",
        "CONTROLLED BURN",
        "TRAFFIC CRASH",
        "TRAFFIC CRASH INVOLVING A BUS",
        "TRAFFIC CRASH W/PEDESTRIAN",
        "TRAFFIC CRASH INVOLVING A STRU",
        "DUMPSTER FIRE",
        "ELEVATOR ENTRAPMENT",
        "EXPLOSION",
        "FARM ACCIDENT",
        "FILL QUARTERS",
        "FIRE-DUMPSTER",
        "FORREST FIRE",
        "GRASS FIRE",
        "GRASS FIRE THREATENING A STRUC",
        "HAZMAT INCIDENT",
        "HAZMAT LEVEL 3 INCIDENT",
        "HOSTAGE/BARRICADE",
        "INDUSTRIAL ACCIDENT",
        "LANDING ZONE",
        "LINES DOWN",
        "LOCK OUT SERVICE",
        "MENTAL CASE",
        "MULCH FIRE",
        "MULCH FIRE THREATENING A STRUC",
        "ODOR INVESTIGATION",
        "ODOR INVESTIGATION IN STRUCTUR",
        "OFFICER INVOLVED SHOOTING",
        "SUSPICIOUS PACKAGE",
        "PUBLIC SERVICE CALL",
        "RAPE",
        "REKINDLE",
        "GROUND RESCUE",
        "GROUND SEARCH",
        "SMOKE INVESTIGATION",
        "LARGE SPILL",
        "SMALL SPILL",
        "STAND-BY",
        "POSSIBLE STRUCTURE FIRE",
        "STRUCTURE FIRE",
        "SUICIDE",
        "TECHNICAL RESCUE",
        "TRAIN CRASH",
        "TRAIN FIRE",
        "TRANSFORMER FIRE",
        "TRASH FIRE",
        "TREE FIRE",
        "TREE FIRE THREATENING A STRUCTUR",
        "UNAUTHORIZED BURN",
        "UNKNOWN SITUATION",
        "UNKNOWN FIRE",
        "VEHICLE FIRE",
        "VEHICLE FIRE THREATENING A STRUCTURE",
        "WATER EVENT",
        "WATER REMOVAL"
    );
  }
}
