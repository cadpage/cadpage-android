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
        "ABD PN - FEM PAIN ABOVE NAV>45",
        "ABDOM PAIN - FEM 12-50 W/FAINT",
        "ABDOM PAIN FAINT/NEAR > 50",
        "ABDOMINAL PAIN",
        "ABDOMINAL PAINS",
        "ABDOMINAL PAINS CHARLIE",
        "ABDOMINAL/BACK PAIN",
        "ABDOMINAL / BACK PAIN BLS",
        "ABDOMINAL PAIN/PROBLEM",
        "ABNORMAL BEHAVIOR",
        "ABORT",
        "ABPAIN",
        "ACCIDENT - INJURIES",
        "ACCIDENT INJURIES",
        "ACCIDENT MVA WITH INJURIES",
        "ACCIDENT W/ INJURIES",
        "ACCIDENT WITH INJURIES",
        "ADVANCED LIFE SUPPORT",
        "ADVANCED LIFE SUPPORT CALL",
        "AGRICULTURAL ACCIDENT",
        "ALARM ACTIVATION",
        "ALARM FIRE",
        "ALARM/FIRE",
        "ALARM SYSTEM-NIGHT",
        "ALARM - BURG",
        "ALARM / FIRE",
        "ALARM-HOLDUP",
        "ALARM - MEDICAL",
        "ALARMS",
        "ALLERGIC REACTION",
        "ALLERGIES/ENVENOMATIONS CHARLI",
        "ALS",
        "ALTERED LOC",
        "ALTERED MENTAL STATUS",
        "AMBULANCE ALS",
        "ANIMAL BITE",
        "ANIMAL COMPLAINT",
        "ARMED ROBBERY IN PROG.",
        "ARSON FIRE",
        "ASSAULT",
        "ASSAULT/SEXUAL ASSAULT",
        "ASSAULT/SEXUAL ASSAULT BRAVO",
        "ASSIST",
        "ASSIST OCCUPANT",
        "ASSISTANCE/ MUTUAL AID",
        "ATTEMPT TO LOCATE",
        "ATV CRASH",
        "AUTO ACCIDENT/INJURY",
        "AUTO ACCIDENT/NO INJURY",
        "AUTO ALARM/FIRE",
        "BACK PAIN",
        "BASIC LIFE SUPPORT",
        "BASIC LIFE SUPPORT CALL",
        "BEHAVIORAL DISORDER",
        "BLEEDING",
        "BLOOD PRESSURE PROB",
        "BLS",
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
        "BRUSH FIRE",
        "BRUSH FIRE NORMAL",
        "BRUSH/GRASS/MULCH/WOODS",
        "BRUSH/RUBBISH FIRE",
        "BTHPRB",
        "BUILDING FIRE",
        "CAD SYSTEM TEST",
        "CARDIAC ARREST",
        "CARDIAC ARREST/DEATH ECHO",
        "CARDIAC OR RESP ARREST/DEATH",
        "CARDIAC PROBLEMS",
        "CARDIAC-OBVIOUS DEATH",
        "CARDIAC/RESPIRATORY ARREST",
        "CARDIAC/RESP ARREST / DEATH",
        "CARDIAC SYMPTOMS",
        "CHANGE IN MENTAL STATUS",
        "CHECK WELFARE",
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
        "CHOKING VICTIM",
        "CO DETECTOR / FIRE RESPONSE",
        "COMMERCIAL FIRE ALARM",
        "CONTROL BURN",
        "CONVULSIONS/SEIZURES",
        "CONVULSIONS/SEIZURES DELTA",
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
        "DRUG OVERDOSE",
        "DRUGS",
        "DUMPSTER FIRE",
        "DWELING FIRE",
        "DWELLING FIRE",
        "E_BREATHING ALS",
        "ELEC HAZ/PWR REPT DISCONNECTED",
        "ELECTRICAL FIRE",
        "ELECTRICAL HAZARD",
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
        "EMS - ALTERED MENTAL STATUS",
        "EMS - ANAPHYLAXIS",
        "EMS - BLEEDING/LACERATION",
        "EMS - CHEST PAIN",
        "EMS - CHEST PAINS",
        "EMS - CHF",
        "EMS - CVA",
        "EMS - DIABETIC COMPLICATIONS",
        "EMS - DIABETIC PROBLEM",
        "EMS - DIFFICULTY BREATHING",
        "EMS - DYSPNEA",
        "EMS - FALL",
        "EMS - FALL VICTIM",
        "EMS - GENERAL ILLNESS",
        "EMS - HIGH BLOOD PRESSURE",
        "EMS - ILL PERSON",
        "EMS - LIFTING ASSISTANCE",
        "EMS - MEDICAL ALARM",
        "EMS - MEDICAL EMERGENCY",
        "EMS - NAUSEA / VOMITING",
        "EMS - PAIN, ALL OVER",
        "EMS - PASSED OUT",
        "EMS - PREGNANCY, UNKNOWN PAIN",
        "EMS - SEIZURE",
        "EMS - SEIZURES",
        "EMS - SHORTNESS OF BREATH",
        "EMS - STOMACH PAINS",
        "EMS - STROKE",
        "EMS - UNCONSCIOUS",
        "EMS - UNKNOWN",
        "EMS - UNKNOWN CONDITIONS",
        "EMS - VERTIGO, DIZZY",
        "E SICK/UNKNOWN ALS",
        "ESCORT",
        "EXPLOSION",
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
        "FALLS-BLS PRI2",
        "FALLS-ON GRD/FL-NOT DANGER BOD",
        "FALLS (GRD/FLR) POSS DANGER BO",
        "FALLS - NOT ALERT",
        "FIELD/WOOD FIRE",
        "FIGHT",
        "FIRE",    
        "FIRE AGRICULTURE",
        "FIRE ALARM",
        "FIRE ALARM COMMERCIAL/INDUST",
        "FIRE ALARM-RESIDENTIAL",
        "FIRE ALARM TEST/WORK",
        "FIRE BRUSH",
        "FIRE CALL",
        "FIRE DEPT CALL",
        "FIRE DEPARTMENT CALL",
        "FIRE EXPLOSION",
        "FIRE GAS\\PROPANE LEAK",
        "FIRE GENERIC (TYPE)",
        "FIRE GRASS OR WOODS",
        "FIRE INDUSTRIAL",
        "FIRE POWERLINE",
        "FIRE POWER LINE DOWN",
        "FIRE PRE-ALERT",
        "FIRE RESIDENTIAL",
        "FIRE SERVICE CALL",
        "FIRE SMOKE INVESTIGATION",
        "FIRE STRUCTURE",
        "FIRE TRANSFORMER / WIRES",
        "FIRE TREE DOWN",
        "FIRE VEHICLE",
        "FIRE WILD",
        "FIRE (UNKNOWN ORGIN)",
        "FIRE - AUTO ALARM/FIRE",
        "FIRE - ALARM",
        "FIRE - BRUSH FIRE",
        "FIRE - CONTROLLED BURN",
        "FIRE - ELECTRICAL FIRE",
        "FIRE - FUEL SPILL/LEAK",
        "FIRE - HELICOPTER LANDING ZONE",
        "FIRE - INSPECTION",
        "FIRE - INVESTIGATION",
        "FIRE - LINES DOWN (NOT-ELEC.)",
        "FIRE - STRUCTURE",
        "FIRE - STRUCTURE/RESIDENTIAL",
        "FIRE - TREES DOWN",
        "FIRE - UNKNOWN FIRE",
        "FIRE - UNKNOWN SMOKE",
        "FIRE - VEHICLE",
        "FIRE - VEHICLE FIRE",
        "FIRE - WILDFIRE",
        "FIRE / STRUCTURE",
        "FIRE / VEHICLE",
        "FIRE/GENERAL ALARM-COMM STRUC",
        "FIRE/WILDFIRE",
        "FLOODING / BASEMENT",
        "FLU LIKE SYMPTOMS",
        "F_TREE DOWN",
        "F_TREE DOWN BUENA",
        "GAS ODOR/OUTSIDE",
        "GENERAL ILLNESS",
        "GI PROBLEM",
        "GRASS/WOODS FIRE",
        "HAZARD",
        "HAZARDOUS MATERIAL",
        "HAZARDOUS MATERIALS",
        "HEADACHE",
        "HEADACHE CHARLIE",
        "HEART PROB/AICD - UNK STATUS",
        "HEART PROBLEM",
        "HEART PROBLEMS/AICD",
        "HEART PROBLEMS/AICD CHARLIE",
        "HEART PROBLEMS/AICD DELTA",
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
        "ILL PERSON",
        "ILLPERSON",
        "ILL PERSON ALS",
        "ILL PERSON BLS",
        "IMMEDIATE TRANSPORT",
        "INJURED PERSON",
        "INJURED PERSON ALS",
        "INJURED PERSON BLS",
        "INJURY ACCIDENT",
        "INVESTIGATE SMOKE",
        "INVESTIGATE WEATHER DAMAGE",
        "KEYS - LOCKED OUT - RESIDENCE",
        "KIDNAPPING REPORT",
        "LAND FIRE",
        "LAW EVENT",
        "LEG INJURY / PAIN",
        "LIFE CALL UNKNOWN PROBLEM",
        "LIFT ASSIST",
        "LIFT ASSISTANCE",
        "LIFT ASSIST/NON EMER EMS",
        "LINES DOWN",
        "LINES DOWN POWER/PHONE/CABLE",
        "LIVESTOCK",
        "MVA-ALS PRI1",
        "M.V.A. - POSSIBLE INJURIES",
        "MED PRE-ALERT",
        "MEDICAL",
        "MEDICAL ALARM",
        "MEDICAL ALARM ACTIVATION",
        "MEDICAL ALPHA",
        "MEDICAL BRAVO",
        "MEDICAL CALL",
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
        "MOTOR VEH ACC UNKNOWN INJ",
        "MOTOR VEHICLE ACCIDENT",
        "MOTOR VEHICLE ACCIDENT INJ",
        "MOTOR VEHICLE ACCIDENT INJURY",
        "MOTOR VEHICLE ACCIDENT NEED FD",
        "MOTOR VEHICLE ACCIDENT UNK INJ",
        "MOTOR VEHICLE COLLISION",
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
        "ODOR",
        "ODOR INVESTIGATION/COMPL",
        "ODOR / OTHER THAN SMOKE",
        "ODOR/OTHER THAN SMOKE",
        "OTHER EVENT NOT DEFINED",
        "OTHER-FIRE",
        "OVERDOSE",
        "OVERDOSE/POISONING",
        "PAIN GENERAL",
        "PATIENT TRANSPORT",
        "PHONE",
        "PHONE CALL",
        "POISONING",
        "POSSIBLE DOA",
        "POSSIBLE OPEN BURN",
        "POWER OUTAGE",
        "PSYC/ABN BEHAV/SUICIDE",
        "PSYC/ABN BEHAV/SUICIDE DELTA",
        "PUBLIC SERVICE",
        "PURSUIT",
        "RECKLESS DRIVER",
        "REFER TO OUTSIDE AGENCY",
        "REFINERY/TANK FARM/FUEL STORAG",
        "RES (SINGLE) HEAT DETECTOR",
        "RESCUE NOT MVA",
        "RESCUE - AUTO ACCIDENT/ INJURY",
        "RESCUE - AUTO ACCIDENT/INJURY",
        "RESCUE (TYPE)",
        "RESIDENTIAL STRUCTURE FIRE",
        "RESPIRATORY DISTRESS",
        "ROAD BLOCKAGE OF ANY TYPE",
        "ROAD CLOSING",
        "ROAD HAZARD",
        "ROUTINE TRANSPORT",
        "SEARCH AND RESCUE",
        "SEZIURE\\CONVULSION",
        "SEIZURES",
        "SEIZURES ALS",
        "SEIZURES - NOT CURRENT NOT VER",
        "SERVICE CALL",
        "SERVICE CALL/ALL OTHER/SPECIFY",
        "SHOOTING",
        "SICK",
        "SICK PERSON",
        "SICK PERSON CHARLIE",
        "SICK PERSON (SPECIFIC DIAG)",
        "SICK PERSON - NAUSEA",
        "SICK PERSON - NOT ALERT",
        "SICK-ALTERED LEV OF CONSCIOUS",
        "SICK - NO SYMPTOMS",
        "SICK/UNKNOWN",
        "SICK/UNKNOWN ALS",
        "SMELL OF SMOKE",
        "SMOKE",
        "SMOKE IN THE AREA",
        "SMOKE INVESTIGATION",
        "SMOKE INVEST/SMELL SMOKE",
        "SPILL (TYPE)",
        "S/SMOK",
        "STABBING",
        "STABBING ON",
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
        "SUSPICIOUS ACTIVITY",
        "SUSPICIOUS PERSON",
        "SUSPICIOUS VEHICLE",
        "SUSPICIOUS VEHICLE STOP",
        "SWIFT/FLOOD WATER RES",
        "SYNCOPE",
        "TEST",
        "THEFT COMPLAINT",
        "TRAFAC",
        "TRAFFIC ACCIDENT",
        "TRAMATIC INJURY",
        "TRANSFERED TO HP",
        "TRASH FIRE",
        "TRAUMA",
        "TRAUMATIC INJURY",
        "TRAFFIC ACCIDENTS ARBYS BOAZ",
        "TRAFF OR TRANSPT ACC/MVA W/INJ",
        "TRAFFIC CONTRO",
        "TRAFFIC CONTROL",
        "TRAFFIC STOP",
        "TRANSPORTING PRISONER",
        "TRAUMATIC INJ - DANGEROUS",
        "TREE DOWN",
        "TREE_DOWN",
        "TREES DOWN",
        "TREES/WIRES DOWN URGENT",
        "TRESPASSING",
        "TRFC/HIGH MECHANISM",
        "UNCONCIOUS",
        "UNCONCIOUS PERSON",
        "UNCONSCIOUS",
        "UNCONSCIOUS CHANGING COLOR",
        "UNCONSCIOUS/FAINTING",
        "UNCONSCIOUS/FAINTING (NEAR)",
        "UNCONSCIOUS/FAINTING DELTA",
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
        "WARRANT SERVICE / FELONY",
        "WATER RESCUE",
        "WATER/ICE RESCUE",
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
