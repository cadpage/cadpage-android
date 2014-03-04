package net.anei.cadpage.parsers.dispatch;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class DispatchBParser extends FieldProgramParser {
  
  private static final String[] FIXED_KEYWORDS = new String[]{"Map", "Grids", "Cad"};
  private static final String[] KEYWORDS = 
    new String[]{"Loc", "Return Phone", "BOX", "Map", "Grids", "Cad"};
  private static final Pattern REPORT_PTN = Pattern.compile("EVENT:.* Cad: ([-0-9]+) |.* DSP \\d\\d:\\d\\d:\\d\\d ");
  private static final Pattern PHONE_PTN = Pattern.compile("(?: +(?:VERIZON|AT ?& ?T MOBILITY))? +(\\d{10}|\\d{7}|\\d{3} \\d{7}|\\d{3}-\\d{4})$");
  
  int version;
  
  public DispatchBParser(Properties cityCodes, String defCity, String defState) {
    this(0, cityCodes, defCity, defState);
  }
  
  public DispatchBParser(String[] cityList, String defCity, String defState) {
    this(0, cityList, defCity, defState);
  }
  
  public DispatchBParser(String defCity, String defState) {
    this(0, defCity, defState);
  }
  
  public DispatchBParser(int version, Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState, calcProgram(version));
    this.version = version;
    setup();
  }
  
  public DispatchBParser(int version, String[] cityList, String defCity, String defState) {
    super(cityList, defCity, defState, calcProgram(version));
    this.version = version;
    setup();
  }
  
  public DispatchBParser(int version, String defCity, String defState) {
    super(defCity, defState, calcProgram(version));
    this.version = version;
    setup();
  }
  
  private static String calcProgram(int version) {
    switch (version) {
    case 0: return null;
    case 1: return "ADDR/SC XS:X NAME Return_Phone:PHONE Cad:ID!";
    case 2: return "CALL ADDR Apt:APT? CITY? PLACE Map:MAP Cad:ID";
    case 3: return "CALL ADDR Apt:APT? CITY? NAME Map:MAP Cad:ID";
    default:return null;
    }
  }
  
  private static final int MIN_FIELD_COUNTS[] = new int[]{ 4, 2, 2};

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // See if this is the new fangled line break delimited format
    if (version > 0) {
      String[] flds = body.split("\n");
      if (flds.length >= MIN_FIELD_COUNTS[version-1]) return parseFields(flds, data);
    }
 
    // Otherwise use the old logic
    if (! isPageMsg(body)) return false;
    
    Matcher match = REPORT_PTN.matcher(body);
    if (match.find()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body.substring(match.start());
      data.strCallId = getOptGroup(match.group(1));
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
  
  @Override
  public String getProgram() {
    return super.getProgram() + " INFO";
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
    field = field.replaceAll("//+", "/");
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ, field, data);
    data.strName = cleanWirelessCarrier(getLeft());
    if (data.strName.startsWith("Bldg")) {
      data.strApt = data.strApt + " Bldg";
      data.strName = data.strName.substring(4).trim();
    }
    if (data.strName.equals("UNK")) data.strName = "";
    return true;
  }
  
  private class BaseCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('>');
      if (pt < 0) abort();
      data.strCode = field.substring(0,pt).trim();
      data.strCall = field.substring(pt+1).trim();
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL";
    }
  }
  
  private class BaseAptField extends AptField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf("Bldg");
      if (pt >= 0) field = append(field.substring(pt+4).trim(), "-", field.substring(0,pt).trim());
      super.parse(field, data);
    }
  }
  
  private class BaseMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf("Grids:");
      if (pt >= 0) {
        String grid = field.substring(pt+6).trim();
        if (grid.equals("00000,000") || grid.equals(",")) grid = "";
        field = field.substring(0,pt).trim();
        field = append(field, "-", grid);
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new BaseCallField();
    if (name.equals("APT")) return new BaseAptField();
    if (name.equals("MAP")) return new BaseMapField();
    return super.getField(name);
  }
  
  private void setup() {
    setFieldList("CODE CALL ADDR APT X PLACE CITY NAME PHONE BOX MAP ID");
    setupCallList(
        "911 HANG UP",
        "911 HANGUP/OPEN LINE",
        "911 TRANSFER TO ANOTHER COUNTY",
        "ABANDONED VEHICLE",
        "ABD PN - FEM PAIN ABOVE NAV>45",
        "ABDOM PAIN - FEM 12-50 W/FAINT",
        "ABDOM PAIN FAINT/NEAR > 50",
        "ABDOMINAL PAIN",
        "ABDOMINAL PAIN/PROBLEMS",
        "ABDOMINAL PAINS",
        "ABDOMINAL PAINS CHARLIE",
        "ABDOMINAL/BACK PAIN",
        "ABDOMINAL / BACK PAIN ALS",
        "ABDOMINAL / BACK PAIN BLS",
        "ABDOMINAL PAIN/PROBLEM",
        "ABNORMAL BEHAVIOR",
        "ABORT",
        "ABPAIN",
        "ABUSE/ABANDONMENT/NEGLECT",
        "ACCIDENT - BOAT",
        "ACCIDENT - INJURIES",
        "ACCIDENT INJURIES",
        "ACCIDENT MVA WITH INJURIES",
        "ACCIDENT W/ INJURIES",
        "ACCIDENT WITH INJURIES",
        "ADVANCED LIFE SUPPORT",
        "ADVANCED LIFE SUPPORT CALL",
        "AGRICULTURAL ACCIDENT",
        "AIRCRAFT EMERGENCY",
        "ALARM ACTIVATION",
        "ALARM/COMMERCIAL",
        "ALARM FIRE",
        "ALARM/FIRE",
        "ALARM/RESID/COMM/PANIC",
        "ALARM/RESIDENCE",
        "ALARM SYSTEM-NIGHT",
        "ALARM - BURG",
        "ALARM / FIRE",
        "ALARM-HOLDUP",
        "ALARM - MEDICAL",
        "ALARMS",
        "ALL OTHER",
        "ALLERGIC REACTION",
        "ALLERGIES/ENVENOMATIONS CHARLI",
        "ALLERGY/HIVES/MED REA/STINGS",
        "ALS",
        "ALTERED LOC",
        "ALTERED MENTAL STATUS",
        "AMBULANCE ALS",
        "ANIMAL BITE",
        "ANIMAL BITES/ATTACKS",
        "ANIMAL CALLS",
        "ANIMAL COMPLAINT",
        "AOA BOOKING ARREST",
        "ARMED ROBBERY IN PROG.",
        "ARSON FIRE",
        "ASSAULT",
        "ASSAULT/SEXUAL ASLT",
        "ASSAULT/SEXUAL ASSAULT",
        "ASSAULT/SEXUAL ASSAULT BRAVO",
        "ASSIST",
        "ASSIST ENROUTE (CLI)",
        "ASSIST OCCUPANT",
        "ASSIST OTHER AGENCY",
        "ASSISTANCE/ MUTUAL AID",
        "ATTEMPT TO LOCATE",
        "ATV CRASH",
        "AUTO ACCIDENT/INJURY",
        "AUTO ACCIDENT/NO INJURY",
        "AUTO ACCIDENT NO INJURIES",
        "AUTO ACCIDENT WITH INJURIES",
        "AUTO ACCIDENT UNKNOWN",
        "AUTO ACCIDENT UNKNOWN INJURIES",
        "AUTO ALARM/FIRE",
        "AUTO THEFT/TAMPERING",
        "BACK PAIN",
        "BACK PAIN (NON-TRAUMATIC)",
        "BASIC LIFE SUPPORT",
        "BASIC LIFE SUPPORT CALL",
        "BEHAVIORAL DISORDER",
        "BLEEDING",
        "BLEEDING (NON-TRAUMATIC)",
        "BLOOD PRESSURE PROB",
        "BLS",
        "BOAT FIRE/ACCIDENT",
        "BOMB THREAT",
        "BOX ALARM",
        "BOOKING ARREST",
        "BREAK IN",
        "BREATHING ALS",
        "BREATHING DIFFICULTY",
        "BREATHING PROBLEM",
        "BREATHING PROBLEMS",
        "BREATHING PROBLEMS A",
        "BREATHING PROBLEMS / SEVERE",
        "BREATHING PROBLEMS CHARLIE",
        "BREATHING PROBLEMS DELTA",
        "BREATHING PROBLEMS/DIFFICULTY",
        "BREATING PROBLEMS",
        "BRUSH FIRE",
        "BRUSH FIRE NORMAL",
        "BRUSH/FOREST FIRE",
        "BRUSH/GRASS/MULCH/WOODS",
        "BRUSH/RUBBISH FIRE",
        "BTHPRB",
        "BUILDING FIRE",
        "BUILDING SEARCH/OPEN DOOR",
        "BURGLARY/HOME INVASION",
        "BURNS/EXPLOSION",
        "CAD SYSTEM TEST",
        "CARBON MONOXIDE DETECTOR ACT",
        "CARBON MONOXIDE/INHAL/HZMT",
        "CARBON MONOXIDE INVESTIGATION",
        "CARDIAC ARREST",
        "CARDIAC ARREST/DEATH ECHO",
        "CARDIAC OR RESP ARREST/DEATH",
        "CARDIAC PROBLEMS",
        "CARDIAC-OBVIOUS DEATH",
        "CARDIAC/RESPIRATORY ARREST",
        "CARDIAC/RESP ARREST/DEATH",
        "CARDIAC/RESP ARREST / DEATH",
        "CARDIAC SYMPTOMS",
        "CHANGE IN MENTAL STATUS",
        "CHECK WELFARE",
        "CHECK WELL BEING",
        "CHEMICAL LEAK",
        "CHEST PAIN",
        "CHEST PAIN ALS",
        "CHEST PAIN - BREATH NORMAL=>35",
        "CHEST PAIN - CARDIAC HISTORY",
        "CHEST PAIN - CLAMMY",
        "CHEST PAIN CHARLIE",
        "CHEST PAIN DELTA",
        "CHEST PAIN - PATIENT NOT ALERT",
        "CHEST PAIN - SEVERE SOB",
        "CHEST PAIN-CLAMMY",
        "CHEST PAIN DIFF SPEAK BTW BRE",
        "CHEST PAIN/RESPIRATORY DISTRES",
        "CHEST PAINS",
        "CHILD LOCKED IN CAR",
        "CHILD LOCKED IN VEHICLE",
        "CITIZEN ASSIST",
        "CIVIL MATTER",
        "CIVIL PROCESS",
        "CIVIL STANDBY",
        "CHOKING",
        "CHOKING VICTIM",
        "CODE",
        "CODE 3 CHEST PAIN",
        "CODE 3 DIFFICULTY BREATHING",
        "CODE3 UNCONSCIOUS/UNRESPONSIVE",
        "CO DETECTOR / FIRE RESPONSE",
        "COMMERCIAL FIRE ALARM",
        "COMMERCIAL STRUCTURE FIRE",
        "CONFINE SPACE/STRUCTURE COLLAP",
        "CONSV BOOKING ARREST",
        "CONVULSIONS/SEIZURES",
        "CONTROL BURN",
        "CONVULSION/SEIZURE",
        "CONVULSIONS/SEIZURES",
        "CONVULSIONS/SEIZURES DELTA",
        "DECEASED PERSON",
        "DIABETIC",
        "DIABETIC ALS",
        "DIABETIC EMRG.",
        "DIABETIC PROBLEM",
        "DIABETIC PROBLEMS",
        "DIABETIC PROBLEMS CHARLIE",
        "DIABETIC-ALS PRI2",
        "DIABETIC-UNCONSCIOUS",
        "DIFFICULTY BREATHING",
        "DISABLED VEHICLE",
        "DISORIENTED",
        "DISTURBANCE",
        "DIZZINESS",
        "DOMESTIC",
        "DOMESTIC IN PROGRESS",
        "DOMESTIC DISTURBANCE",
        "DRIVING UNDER INFLUENCE",
        "DROWNING",
        "DROWNING/DIVING/SCUBA ACC",
        "DRUG OVERDOSE",
        "DRUGS",
        "DUMPSTER FIRE",
        "DUMPSTER FIRE NO EXPOSURES",
        "DWELING FIRE",
        "DWELLING FIRE",
        "E_BREATHING ALS",
        "ELEC HAZ/PWR REPT DISCONNECTED",
        "ELECTRICAL FIRE",
        "ELECTRICAL HAZARD",
        "ELECTROCUTION/LIGHTNING",
        "EMD CALL",
        "EMD PROGRAM",
        "EMERGENACY RUN",
        "EMERGENCY RUN",
        "EMS ASSIST",
        "EMS CALL",
        "EMS LIFELINE CALL",
        "EMS NEEDED",
        "EMS NEEDED PRIORITY 1",
        "EMS NEEDED PRIORITY 2",
        "EMS NEEDED PRIORITY-1",
        "EMS NEEDED PRIORITY-2",
        "EMS STAND BY",
        "EMS TRANSPORT",
        "EMS - ABDOMINAL PAIN",
        "EMS - ALTERED MENTAL STATUS",
        "EMS - ANAPHYLAXIS",
        "EMS - ANXIETY ATTACK",
        "EMS - BLEEDING/LACERATION",
        "EMS - CARDIAC ARREST",
        "EMS - CARDIAC SYMPTOMS",
        "EMS - CHEST PAIN",
        "EMS - CHEST PAINS",
        "EMS - CHF",
        "EMS - CVA",
        "EMS - DEHYDRATION",
        "EMS - DIABETIC COMPLICATIONS",
        "EMS - DIABETIC PROBLEM",
        "EMS - DIFFICULTY BREATHING",
        "EMS - DYSPNEA",
        "EMS - EPISTAXIS",
        "EMS - FALL",
        "EMS - FALL VICTIM",
        "EMS - GENERAL ILLNESS",
        "EMS - HIGH BLOOD PRESSURE",
        "EMS - HYPERTENSION",
        "EMS - ILL PERSON",
        "EMS - IMMEDIATE TRANSPORT",
        "EMS - INJURY / EXTREMITY",
        "EMS - LIFTING ASSISTANCE",
        "EMS - MEDICAL ALARM",
        "EMS - MEDICAL EMERGENCY",
        "EMS - NAUSEA / VOMITING",
        "EMS - OVERDOSE",
        "EMS - PAIN",
        "EMS - PAIN, ALL OVER",
        "EMS - PASSED OUT",
        "EMS - PREGNANCY, UNKNOWN PAIN",
        "EMS - ROUTINE TRANSPORT",
        "EMS - SEIZURE",
        "EMS - SEIZURES",
        "EMS - SEMI-RESPONSIVE",
        "EMS - SHORTNESS OF BREATH",
        "EMS - STOMACH PAINS",
        "EMS - STROKE",
        "EMS - SUICIDE / COMPLETED",
        "EMS - UNCONSCIOUS",
        "EMS - UNRESPONSIVE PERSON",
        "EMS - UNKNOWN",
        "EMS - UNKNOWN CONDITIONS",
        "EMS - VERTIGO, DIZZY",
        "E SICK/UNKNOWN ALS",
        "ESCAPE",
        "ESCORT",
        "EXPLOSION",
        "EXTRA PATROL",
        "EXTRICATION",
        "EYE PROBLEM/INJURIES",
        "F_ACCIDENT NO INJURIES",
        "F-ACCIDENT W/ INJURIES",
        "FALL",
        "FALL VICTIM",
        "FALL INJURY BLS",
        "FALL - ANY",
        "FALL-NOT DANGEROUS BODY AREA",
        "FALLS",
        "FALLS (GRND/FLOOR) UNK STATUS",
        "FALLS BRAVO",
        "FALLS DELTA",
        "FALLS/ACCIDENTS BLS",
        "FALLS-ALS PRI1-FR",
        "FALLS/BACK INJURY (TRAUMATIC)",
        "FALLS-BLS PRI2",
        "FALLS-ON GRD/FL-NOT DANGER BOD",
        "FALLS (GRD/FLR) POSS DANGER BO",
        "FALLS - NOT ALERT",
        "FIELD/WOOD FIRE",
        "FIGHT",
        "FIGHT IN PROGRESS",
        "FIRE",    
        "FIRE AGRICULTURE",
        "FIRE ALARM",
        "FIRE ALARM COMMERCIAL/INDUST",
        "FIRE ALARM-RESIDENTIAL",
        "FIRE ALARM TEST/WORK",
        "FIRE BRUSH",
        "FIRE CALL",
        "FIRE CARBON MONOXIDE ALARM",
        "FIRE DEPT CALL",
        "FIRE DEPARTMENT CALL",
        "FIRE EXPLOSION",
        "FIRE GAS\\PROPANE LEAK",
        "FIRE GENERIC (TYPE)",
        "FIRE GRASS OR WOODS",
        "FIRE INDUSTRIAL",
        "FIRE INVESTIGATION",
        "FIRE INVESTIGATION INSIDE",
        "FIRE INVESTIGATION OUTSIDE",
        "FIRE OTHER",
        "FIRE POWERLINE",
        "FIRE POWER LINE DOWN",
        "FIRE PRE-ALERT",
        "FIRE RESIDENTIAL",
        "FIRE SERVICE CALL",
        "FIRE SMOKE INVESTIGATION",
        "FIRE STANDBY",
        "FIRE STRUCTURE",
        "FIRE TRANSFORMER / WIRES",
        "FIRE TREE DOWN",
        "FIRE VEHICLE",
        "FIRE WILD",
        "FIRE (UNKNOWN ORGIN)",
        "FIRE - AUTO ALARM/FIRE",
        "FIRE - ALARM",
        "FIRE - BARN / LARGE INDUSTRIAL",
        "FIRE - BRUSH FIRE",
        "FIRE - CONTROLLED BURN",
        "FIRE - ELECTRICAL FIRE",
        "FIRE - FUEL SPILL/LEAK",
        "FIRE - HELICOPTER LANDING ZONE",
        "FIRE - INSPECTION",
        "FIRE - INVESTIGATION",
        "FIRE - LINES DOWN (NOT-ELEC.)",
        "FIRE - STRUCTURE",
        "FIRE - STRUCTURE / HOUSE, BLDG",
        "FIRE - STRUCTURE/RESIDENTIAL",
        "FIRE - TREE DOWN",
        "FIRE - TREES DOWN",
        "FIRE - UNKNOWN FIRE",
        "FIRE - UNKNOWN SMOKE",
        "FIRE - VEHICLE",
        "FIRE - VEHICLE FIRE",
        "FIRE - WILDFIRE",
        "FIRE / STRUCTURE",
        "FIRE / VEHICLE",
        "FIRE/ARSON",
        "FIRE/GENERAL ALARM-COMM STRUC",
        "FIRE/PROQA GENERATED",
        "FIRE/WILDFIRE",
        "FIRST RESPONDER",
        "FLOODING / BASEMENT",
        "FLU LIKE SYMPTOMS",
        "FOLLOW UP",
        "FORGERY/COUNTERFEITING",
        "F_TREE DOWN",
        "F_TREE DOWN BUENA",
        "FRAUD",
        "FUEL SPILL 10 GAL OR LESS",
        "GAS LEAK",
        "GAS ODOR/OUTSIDE",
        "GENERAL ILLNESS",
        "GI PROBLEM",
        "GRASS/WOODS FIRE",
        "GUN/WEAPON PERSON WITH",
        "HARRASMENT/TELEPHONE",
        "HAZARD",
        "HAZARDOUS MATERIAL",
        "HAZARDOUS MATERIALS",
        "HAZMAT/SPILL/LEAK/GAS EMERG",
        "HEADACHE",
        "HEADACHE CHARLIE",
        "HEART PROB/AICD - UNK STATUS",
        "HEART PROBLEM",
        "HEART PROBLEMS/AICD",
        "HEART PROBLEMS/AICD CHARLIE",
        "HEART PROBLEMS/AICD DELTA",
        "HEAT/COLD EXPOSURE",
        "HEM/LACER-SERIOUS",
        "HEMORRHAGE BLS",
        "HEMORRAGE/LACERATION",
        "HEMORRHAGE / LAC - DANGER HEM",
        "HEMORRHAGE / LACERATIONS",
        "HEMORRHAGE/LACERATIONS",
        "HEMORRHAGE/LACERATIONS BRAVO",
        "HEMORR/LACER - SERIOUS HEMORRH",
        "HIT AND RUN",
        "HIT & RUN JUST OCC.",
        "HGH LIFE HZD ALRM GEN",
        "HOLD UP ALARM IP",
        "HOUSE FIRE",
        "ILL PERSON",
        "ILLPERSON",
        "ILL PERSON ALS",
        "ILL PERSON BLS",
        "IMMEDIATE TRANSPORT",
        "INDECENT EXPOSURE",
        "INDUSTRIAL/MACHINERY ACCIDENT",
        "INFORMATIONAL",
        "INHALATION/HAZ-MAT",
        "INJURED PERSON",
        "INJURED PERSON ALS",
        "INJURED PERSON BLS",
        "INJURY ACCIDENT",
        "INVESTIGATE SMOKE",
        "INVESTIGATE WEATHER DAMAGE",
        "KEYS - LOCKED OUT - RESIDENCE",
        "KIDNAPPING",
        "KIDNAPPING REPORT",
        "LAND FIRE",
        "LANDING ZONE",
        "LAW - DISPUTE / FAMILY",
        "LAW EVENT",
        "LAW/POLICE PROQA",
        "LEG INJURY / PAIN",
        "LIFE CALL UNKNOWN PROBLEM",
        "LIFT ASSIST",
        "LIFT ASSISTANCE",
        "LIFT ASSIST/NON EMER EMS",
        "LINES DOWN",
        "LINES DOWN POWER/PHONE/CABLE",
        "LITTERING",
        "LIVESTOCK",
        "MANUFACTURE CONT SUBSTANCE",
        "MARIJUANA ERADICATION - CULT",
        "MARINE FIRE",
        "MARINE THEFT",
        "MATERNITY",
        "MVA-ALS PRI1",
        "M.V.A. - POSSIBLE INJURIES",
        "MED PRE-ALERT",
        "MEDICAL",
        "MEDICAL ALARM",
        "MEDICAL ALARM ACTIVATION",
        "MEDICAL ALPHA",
        "MEDICAL BRAVO",
        "MEDICAL CALL",
        "MEDICAL CALL PROQA",
        "MEDICAL CALL - UNKNOWN",
        "MEDICAL CHARLIE",
        "MEDICAL DELTA",
        "MEDICAL ECHO",
        "MEDICAL CALL",
        "MEDICAL EMERGENCY",
        "MEDICAL GENERIC",
        "MEDICAL SERVICE CALL-NON EMERG",
        "MED GENERIC DO NOT DELETE",
        "MEET COMPLAINANT",
        "MEET COMPLAINTANT",
        "MENTAL/EMOTIONAL/PSYCHOLOGICAL",
        "MENTAL PATIENT FOR TRANSPORT",
        "MENTAL PERSON",
        "MISC",
        "MISC FIRE",
        "MISC. FIRE",
        "MISSING PERSON",
        "MISSING PERSON / RUNAWAY",
        "MISSING PERSON/UNDER 18YOA/JUV",
        "MISSING/RUNAWAY/FOUND PERSON",
        "MOTOR VEH ACC UNKNOWN INJ",
        "MOTOR VEH ACC W/INJ",
        "MOTOR VEHICLE ACCIDENT",
        "MOTOR VEHICLE ACCIDENT INJ",
        "MOTOR VEHICLE ACCIDENT INJURY",
        "MOTOR VEHICLE ACCIDENT NEED FD",
        "MOTOR VEHICLE ACCIDENT UNK INJ",
        "MOTOR VEHICLE ACCIDENT W/INJUR",
        "MOTOR VEHICLE COLLISION",
        "MOTORIST ASSIST",
        "MSHP BOOKING ARREST",
        "MSWP BOOKING ARREST",
        "MURDER",
        "MUT AID",
        "MUTUAL AID",
        "MUTUAL AID/ASSIST OUTSIDE AGEN",
        "MUTUAL AID FIRE RESPONSE",
        "MUTUAL AIDE",
        "MV ACCIDENT W/INJURY",
        "MVA",
        "MVA LEAVING THE SCENE",
        "MVA NO INJURIES",
        "MVA NO INJURY",
        "MVA NONE INJURY",
        "MVA W/ RESCUE",
        "MVA WITH INJURIES",
        "MVA WITH INJURY",
        "MVA WITH INJURY & ENTRAPMENT",
        "MVA UNKNOWN INJURY OR ENTRAP",
        "MVA WITH UNKNOW INJUIRIES",
        "MVA -EJECTION- HIGH MECHANISM",
        "MVA - MAJOR INCIDENT",
        "MVA - PINNED",
        "MVA - PINNED / ENTRAPPED",
        "MVA - UNKNOWN STATUS",
        "MVA - WITH INJURIES",
        "MVA-ALS PRI1",
        "MVA-TRAPPED MULTI PT/ADD RESPO",
        "MVC UNKNOWN INJURIES",
        "NATURAL OR LP GAS LEAK",
        "NATURAL GAS ODOR/LEAK",
        "NEED ASSISTANCE",
        "NO INJURY ACCIDENT",
        "NON-INJURY ACCIDENT",
        "NON EMERG TRANSPORT",
        "NON EMERG TRANSPORT DPD///TEST",
        "NON EMERG TRANSPORT DPD/TEST",
        "NON-SPECIFIC DIAGNOSIS",
        "OBSCENE/THREATENING PHONE",
        "ODOR",
        "ODOR INVESTIGATION/COMPL",
        "ODOR / OTHER THAN SMOKE",
        "ODOR/OTHER THAN SMOKE",
        "ORDINANCE VIOLATION",
        "OTHER EVENT NOT DEFINED",
        "OTHER-FIRE",
        "OTHER FIRE CALL",
        "OVERDOSE",
        "OVERDOSE/INJESTION/POISONING",
        "OVERDOSE/POISONING",
        "PAIN GENERAL",
        "PARK CHECK",
        "PATIENT TRANSPORT",
        "PEACE DISTURBANCE",
        "PHONE",
        "PHONE CALL",
        "POISONING",
        "POSS OF CONTROLLED SUBSTANCE",
        "POSSESSION OF ALCOHOL BY MINOR",
        "POSSIBLE DOA",
        "POSSIBLE OPEN BURN",
        "POST SURGICAL COMPLICATION",
        "POWER LINES DOWN",
        "POWER OUTAGE",
        "PREGNANCY/CHILDBIRTH/MISCARR",
        "PRISONER TRANSPORT",
        "PROPERTY DAMAGE/VANDALISM",
        "PROWLER",
        "PSYC/ABN BEHAV/SUICIDE",
        "PSYC/ABN BEHAV/SUICIDE DELTA",
        "PSYCHIATRIC/SUICIDE ATTEMPT",
        "PUBLIC SERVICE",
        "PURSUIT",
        "REC/RECOVER STOLEN PROPERTY",
        "RECKLESS DRIVER",
        "REFER TO OUTSIDE AGENCY",
        "REFINERY/TANK FARM/FUEL STORAG",
        "REQUEST FOR TOW LAND/WATER",
        "RES (SINGLE) HEAT DETECTOR",
        "RESCUE",
        "RESCUE NOT MVA",
        "RESCUE - AUTO ACC / ENTRAPMENT",
        "RESCUE - AUTO ACCIDENT/ INJURY",
        "RESCUE - AUTO ACCIDENT/INJURY",
        "RESCUE (TYPE)",
        "RESCUE/ANIMAL RESCUE",
        "RESCUE/ELEVATOR EMERGENCY",
        "RESIDENTIAL STRUCTURE FIRE",
        "RESPIRATORY DISTRESS",
        "ROAD BLOCKAGE OF ANY TYPE",
        "ROAD CLOSING",
        "ROAD HAZARD",
        "ROBBERY/CARJACKING",
        "ROUTINE TRANSPORT",
        "RUBBISH FIRE NO EXPOSURES",
        "RUNWAY JUVENILE",
        "SEARCH AND RESCUE",
        "SEXUAL MISCONDUCT",
        "SEZIURE\\CONVULSION",
        "SEIZURES",
        "SEIZURES ALS",
        "SEIZURES - NOT CURRENT NOT VER",
        "SERVICE CALL",
        "SERVICE CALL/ALL OTHER/SPECIFY",
        "SHOOTING",
        "SHOPLIFTING",
        "SICK",
        "SICK PERSON",
        "SICK PERSON CHARLIE",
        "SICK PERSON (SPECIFIC DIAG)",
        "SICK PERSON - NAUSEA",
        "SICK PERSON - NOT ALERT",
        "SICK-ALTERED LEV OF CONSCIOUS",
        "SICK - NO SYMPTOMS",
        "SICK UNKNOWN",
        "SICK/UNKNOWN",
        "SICK/UNKNOWN ALS",
        "SMELL OF SMOKE",
        "SMOKE",
        "SMOKE IN THE AREA",
        "SMOKE INVESTIGATION",
        "SMOKE INVEST/SMELL SMOKE",
        "SPILL (TYPE)",
        "S/SMOK",
        "STAB/GUNSHOT WOUND/PENET TRAUM",
        "STABBING",
        "STABBING ON",
        "STALKING",
        "STEALING",
        "STAND BY FOR FIRE COVERAGE",
        "STR FIR HGH RISE",
        "STROKE",
        "STROKE-ABNORMAL BREATH <2HRS",
        "STROKE(CVA)",
        "STROKE-CVA",
        "STROKE (CVA)",
        "STROKE (CVA) CHARLIE",
        "STROKE-NOT ALERT",
        "STOKE(CVA)",
        "STROKE/CVA",
        "STROKE/CVA PATIENT",
        "STROKE (CVA) BREATH NORM > 35",
        "STRUC FIRE-SINGLE RESIDENTIAL",
        "STRUCTURE FIRE",                          // Locked :(
        "STRUCTURE FIRE CHARLEY RESPONS",
        "STRUCTURE FIRE-COMMERCIAL",
        "STRUCTURE FIRE-BARN/GARAGE/OTH",
        "STRUCTURE FIRE DELTA RESPONSE",
        "STRUCTURE FIRE - LOW HAZARD",
        "STRUCTURE FIRE-MEDIUM HAZARD",
        "STRUCTURE FIRE - HIGH HAZARD",
        "STRUCTURE FIRE- HIGH RISE",
        "STRUCTURE FIRE-MULTIFAMILY",
        "STRUCTURE FIRE-RESIDENTAL",
        "STRUCTURE FIRE W ENTRAPMENT",
        "SUICIDE",
        "SUICIDE ATTEMPT",
        "SUICIDE OR ATTEMPTED SUICIDE",
        "SUICIDE THREAT",
        "SUICIDAL PERSON/ATTEMPTED SUIC",
        "SUSPICIOUS ACTIVITY",
        "SUSPICIOUS PERSON",
        "SUSPICIOUS PERSON/VEHICLE",
        "SUSPICIOUS VEHICLE",
        "SUSPICIOUS VEHICLE STOP",
        "SWIFT/FLOOD WATER RES",
        "SYNCOPE",
        "TEST",
        "THEFT COMPLAINT",
        "THREATS",
        "TRAFAC",
        "TRAFFIC ACCIDENT",
        "TRAFFIC ACCIDENTS",
        "TRAFF OR TRANSPT ACC/MVA W/INJ",
        "TRAFFIC CONTRO",
        "TRAFFIC CONTROL",
        "TRAFFIC VIOL/COMPLAINT/HAZARD",
        "TRAFFIC PROBLEM",
        "TRAFFIC PURSUIT",
        "TRAFFIC STOP",
        "TRAFFIC/TRANSPORTATION ACCIDEN",
        "TRAILER FIRE",
        "TRAIN/RAIL ACCIDENT",
        "TRAMATIC INJURY",
        "TRANSFERED TO HP",
        "TRASH FIRE",
        "TRAUMA",
        "TRAUMA WITH INJURY",
        "TRAUMATIC INJURY",
        "TRANSFORMER INCIDENT",
        "TRANSPORT PATIENT",
        "TRANSPORTING PRISONER",
        "TRAUMATIC INJ - DANGEROUS",
        "TRAUMATIC INJURIES (SPECIFIC)",
        "TREE DOWN",
        "TREE_DOWN",
        "TREES DOWN",
        "TREES/WIRES DOWN URGENT",
        "TRESPASSING",
        "TRFC/HIGH MECHANISM",
        "TRY TO CONTACT",
        "UNCONCIOUS",
        "UNCONCIOUS PERSON",
        "UNCONSCIOUS",
        "UNCONSCIOUS CHANGING COLOR",
        "UNCONSCIOUS EFFECT BREATHING",
        "UNCONSCIOUS/FAINTING",
        "UNCONSCIOUS/FAINTING (NEAR)",
        "UNCONSCIOUS/FAINTING DELTA",
        "UNCONSCIOUS/FAINTING NONTRAUMA",
        "UNCONSCIOUS PERSON",
        "UNCONSCIOUS SUBJECT",
        "UNCONTAINED HAZMAT",
        "UNK PROBLEM-LIFE STAT QUESTION",
        "UNKNOWN",
        "UNKNOWN MEDICAL",
        "UNKNOWN PROB (MAN DOWN)",
        "UNKNOWN PROBLEM (MAN DOWN)",
        "UNKNOWN PROB (MAN DOWN) BRAVO",
        "UNKNOWN PROB (MAN DOWN) DELTA",
        "UNKNOWN PROBLEM",
        "UNKNOWN PROBLEMS",
        "UNKNOWN SITUATION",
        "UNKNOWN/PERSON DOWN",
        "UNRESPONSIVE / SYNCOPE ALS",
        "UNRESPONSIVE / SYNCOPE BLS",
        "UNRSPONSIVE / SYNCOPE ALS",
        "VA / INJURIES",
        "VEHICLE ACCIDENT",
        "VEHICLE COLLISION/W INJURIES",
        "VEHICLE COLLISION /W INJURIES",
        "VEHICLE FIRE",
        "VEHICLE PURSUIT",
        "VEHICLE- DISABLED",
        "WALKAWAY FROM HOSPITAL/HOME",
        "WARRANT SERVICE",
        "WARRANT SERVICE / FELONY",
        "WATER RESCUE",
        "WATER/ICE RESCUE",
        "WEAPONS/FIREARMS",
        "WEATHER SPOTTERS",
        "WELFARE CHECK",
        "WELFARE CHECK CHILD FOUND ON DOOR STEP ON",
        "WILDLAND FIRE",
        "WILD FIRE",
        "WIRE DOWN",
        "WIRE (GENERAL PROBLEM)",
        "WIRES",
        "WIRES/POLE",
        "WIRES DOWN",
        "WIRE(S) DOWN",
        "WIRES DOWN / ARCING",
        "WIRES/TRANSFORMER DOWN FIRE",
        "WRECK"
    );
  };
}
