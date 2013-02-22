package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchBParser extends FieldProgramParser {
  
  private static final String FIELD_PROGRAM = "ADDR/SC XS:X NAME Return_Phone:PHONE Cad:ID!";
  private static final String[] FIXED_KEYWORDS = new String[]{"Map", "Grids", "Cad"};
  private static final String[] KEYWORDS = 
    new String[]{"Loc", "Return Phone", "BOX", "Map", "Grids", "Cad"};
  private static final Pattern REPORT_PTN = Pattern.compile("EVENT:.* Cad: ([-0-9]+) ");
  private static final Pattern PHONE_PTN = Pattern.compile("(?: +(?:VERIZON|AT ?& ?T MOBILITY))? +(\\d{10}|\\d{7}|\\d{3} \\d{7}|\\d{3}-\\d{4})$");
  
  public DispatchBParser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState, FIELD_PROGRAM);
    setup();
  }
  
  public DispatchBParser(String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState, FIELD_PROGRAM);
    setup();
  }
  
  public DispatchBParser(String defCity, String defState) {
    super(defCity, defState, FIELD_PROGRAM);
    setup();
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // See if this is the new fangled line break delimited format
    String[] flds = body.split("\n");
    if (flds.length >= 4) return parseFields(flds, data);
 
    // Otherwise use the old logic
    if (! isPageMsg(body)) return false;
    
    Matcher match = REPORT_PTN.matcher(body);
    if (match.find()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body.substring(match.start());
      data.strCallId = match.group(1);
      return true;
    }
    
    body = "Loc: " + body;
    Properties props = parseMessage(body, KEYWORDS);
    
    if (!parseAddrField(props.getProperty("Loc", ""), data)) return false;
    
    String phone = props.getProperty("Return Phone");
    if (phone != null) data.strPhone = phone;
    data.strBox = props.getProperty("BOX", "");
    data.strMap = props.getProperty("Map", "");
    String callId = props.getProperty("Cad");
    if (callId != null) {
      int pt = callId.indexOf(' ');
      if (pt >= 0) {
        data.strSupp = callId.substring(pt+1).trim();
        callId = callId.substring(0,pt);
      }
      data.strCallId = callId;
    }
    
    return true;
  }
  
  /**
   * Determines if this is a CAD page (may be overridden by subclasses)
   * @param body
   * @return
   */
  protected boolean isPageMsg(String body) {
    return isPageMsg(body, FIXED_KEYWORDS);
  }
  
  /**
   * Processes the complicated first address field
   * Will usually be overridden by subclasses
   * @param field first address field
   * @param data message information data object
   * @return true if parse was successful
   */
  protected boolean parseAddrField(String field, Data data) {
    
    // Default is to ignore everything up to the first '>'
    int ipt = field.indexOf('>');
    if (ipt >= 0) field = field.substring(ipt+1);
    Matcher match = PHONE_PTN.matcher(field);
    if (match.find()) {
      data.strPhone = match.group(1);
      field = field.substring(0,match.start());
    }
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, field, data);
    data.strName = getLeft();
    if (data.strName.startsWith("Bldg")) {
      data.strApt = data.strApt + " Bldg";
      data.strName = data.strName.substring(4).trim();
    }
    if (data.strName.equals("UNK")) data.strName = "";
    return true;
  }
  
  private void setup() {
    setFieldList("CODE CALL ADDR APT X CITY NAME PHONE BOX MAP ID");
    setupCallList(
        "911 HANG UP",
        "ACCIDENT - INJURIES",
        "ACCIDENT INJURIES",
        "ACCIDENT MVA WITH INJURIES",
        "ACCIDENT W/ INJURIES",
        "ACCIDENT WITH INJURIES",
        "ABDOM PAIN - FEM 12-50 W/FAINT",
        "ABDOMINAL PAIN/PROBLEM",
        "ADVANCED LIFE SUPPORT CALL",
        "AUTO ACCIDENT/INJURY",
        "AUTO ACCIDENT/NO INJURY",
        "AUTO ALARM/FIRE",
        "ALARM ACTIVATION",
        "ALARM FIRE",
        "ALARM/FIRE",
        "ALARM SYSTEM-NIGHT",
        "ALARMS",
        "ALS",
        "ALTERED MENTAL STATUS",
        "ASSAULT/SEXUAL ASSAULT",
        "ASSIST OCCUPANT",
        "ASSISTANCE/ MUTUAL AID",
        "BASIC LIFE SUPPORT CALL",
        "BLS",
        "BREATHING ALS",
        "BREATHING DIFFICULTY",
        "BREATHING PROBLEMS",
        "BREATHING PROBLEMS A",
        "BREATHING PROBLEMS / SEVERE",
        "BRUSH FIRE",
        "BUILDING FIRE",
        "CARDIAC OR RESP ARREST/DEATH",
        "CARDIAC PROBLEMS",
        "CARDIAC/RESPIRATORY ARREST",
        "CARDIAC/RESP ARREST / DEATH",
        "CARDIAC SYMPTOMS",
//        "CHEST PAIN",
        "CHEST PAIN - BREATH NORMAL=>35",
        "CHEST PAIN - CARDIAC HISTORY",
        "CHEST PAIN - PATIENT NOT ALERT",
        "CHEST PAIN - SEVERE SOB",
        "CHEST PAIN DIFF SPEAK BTW BRE",
        "CHEST PAIN/RESPIRATORY DISTRES",
        "CHILD LOCKED IN CAR",
        "CHILD LOCKED IN VEHICLE",
        "CO DETECTOR / FIRE RESPONSE",
        "DIABETIC-ALS PRI2",
        "DIABETIC EMRG.",
        "DIABETIC PROBLEM",
        "DOMESTIC DISTURBANCE",
        "DUMPSTER FIRE",
        "ELEC HAZ/PWR REPT DISCONNECTED",
        "ELECTRICAL HAZARD",
        "EMERGENACY RUN",
        "EMS CALL",
        "EMS LIFELINE CALL",
        "EMS NEEDED",
        "EMS NEEDED PRIORITY 1",
        "EMS NEEDED PRIORITY 2",
        "FALL - ANY",
//        "FALLS",
        "FALLS/ACCIDENTS BLS",
        "FALLS-ALS PRI1-FR",
        "FALLS-BLS PRI2 ",
        "FALLS (GRD/FLR) POSS DANGER BO",
        "FALLS - NOT ALERT",
        "FIGHT",
//        "FIRE",        
//        "FIRE ALARM",
        "FIRE ALARM COMMERCIAL/INDUST",
        "FIRE ALARM TEST/WORK",
        "FIRE CALL",
        "FIRE INDUSTRIAL",
        "FIRE/GENERAL ALARM-COMM STRUC",
        "FIRE RESIDENTIAL",
        "FIRE - STRUCTURE", 
        "FIRE SMOKE INVESTIGATION",
        "FIRE TREE DOWN",
        "FIRE/WILDFIRE",
        "GAS ODOR/OUTSIDE",
        "GRASS/WOODS FIRE",
        "HAZARDOUS MATERIALS",
        "HEM/LACER-SERIOUS",
        "HEMORRHAGE / LAC - DANGER HEM",
        "HEMORRHAGE / LACERATIONS",
        "HGH LIFE HZD ALRM GEN",
        "ILL PERSON",
        "ILLPERSON",
        "ILL PERSON BLS",
        "IMMEDIATE TRANSPORT",
        "INJURED PERSON",
        "INJURED PERSON ALS",
        "INJURED PERSON BLS",
        "INJURY ACCIDENT",
        "LIFT ASSIST/NON EMER EMS",
        "MVA-ALS PRI1",
        "M.V.A. - POSSIBLE INJURIES",
//        "MEDICAL",
        "MEDICAL ALPHA",
        "MEDICAL BRAVO",
        "MEDICAL CHARLIE",
        "MEDICAL DELTA",
        "MEDICAL ECHO",
        "MEDICAL ALARM",
        "MEDICAL CALL",
        "MEDICAL EMERGENCY",
        "MEDICAL GENERIC",
        "MISC",
        "MISSING PERSON / RUNAWAY",
        "MOTOR VEH ACC UNKNOWN INJ",
        "MOTOR VEHICLE ACCIDENT",
        "MOTOR VEHICLE ACCIDENT INJURY",
        "MUTUAL AID/ASSIST OUTSIDE AGEN",
        "MV ACCIDENT W/INJURY",
//        "MVA",
        "MVA -EJECTION- HIGH MECHANISM",
        "MVA - MAJOR INCIDENT",
        "MVA NONE INJURY",
        "MVA - PINNED",
        "MVA - UNKNOWN STATUS",
        "MVA-TRAPPED MULTI PT/ADD RESPO",
        "MVA WITH INJURIES",
        "MVA - WITH INJURIES",
        "MVA WITH UNKNOW INJUIRIES",
        "MVA W/ RESCUE",
        "NO INJURY ACCIDENT",
        "NON-SPECIFIC DIAGNOSIS",
        "ODOR / OTHER THAN SMOKE",
        "OTHER-FIRE",
        "POSSIBLE OPEN BURN",
        "REFINERY/TANK FARM/FUEL STORAG",
        "RES (SINGLE) HEAT DETECTOR",
        "ROAD HAZARD",
        "SEIZURES",
        "SEIZURES - NOT CURRENT NOT VER",
        "SICK - NO SYMPTOMS",
//        "SICK PERSON",
        "SICK PERSON (SPECIFIC DIAG)",
        "SICK PERSON - NAUSEA",
        "SICK PERSON - NOT ALERT",
        "SICK/UNKNOWN ALS",
        "SMOKE IN THE AREA",
        "SMOKE INVESTIGATION",
        "SPILL (TYPE)",
        "STROKE",
        "STROKE-CVA",
        "STROKE/CVA PATIENT",
        "STROKE (CVA) BREATH NORM > 35",
        "STRUC FIRE-SINGLE RESIDENTIAL",
        "STRUCTURE FIRE",                          // Locked :(
        "STRUCTURE FIRE CHARLEY RESPONS",
        "STRUCTURE FIRE DELTA RESPONSE",
        "STRUCTURE FIRE - LOW HAZARD",
        "STRUCTURE FIRE-MEDIUM HAZARD",
        "STRUCTURE FIRE - HIGH HAZARD",
        "STRUCTURE FIRE- HIGH RISE",
        "SUSPICIOUS VEHICLE STOP",
        "TRANSFERED TO HP",
        "TRAUMATIC INJURY",
        "TRAFF OR TRANSPT ACC/MVA W/INJ",
        "TRAFFIC CONTRO",
        "TRAFFIC CONTROL",
        "TRAUMATIC INJ - DANGEROUS",
        "TREE_DOWN",
        "TREES/WIRES DOWN URGENT",
        "UNCONCIOUS",
        "UNCONSCIOUS/FAINTING",
        "UNCONSCIOUS/FAINTING (NEAR)",
        "UNCONSCIOUS SUBJECT",
        "UNCONTAINED HAZMAT",
        "UNK PROBLEM-LIFE STAT QUESTION",
        "UNKNOWN/PERSON DOWN",
        "UNKNOWN PROBLEM (MAN DOWN)",
        "UNKNOWN PROBLEM",
        "UNRSPONSIVE / SYNCOPE ALS",
        "VEHICLE ACCIDENT",
        "VEHICLE PURSUIT",
        "WILDLAND FIRE",
        "WIRES",
        "WIRES DOWN",
        "WIRE(S) DOWN",
        "WIRES DOWN / ARCING",
        "WRECK"
    );
  };
}
