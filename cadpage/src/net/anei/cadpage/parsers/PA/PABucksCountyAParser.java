package net.anei.cadpage.parsers.PA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Bucks County, PA
 */
public class PABucksCountyAParser extends PABucksCountyBaseParser {
  
  private static final Pattern MARKER1 = Pattern.compile("(?:(Station [^/:]+) / )?([A-Z]+\\s+(?:Adr:|adr:|Box:).*)", Pattern.DOTALL);
  private static final Pattern MARKER2 = Pattern.compile("^([A-Z0-9 ]+):([A-Z]+) *");
  private static final Pattern NAKED_DATE_TIME = Pattern.compile("(?<!: ?)\\d\\d/\\d\\d/\\d\\d +\\d\\d:\\d\\d:\\d\\d\\b");
  private static final Pattern GEN_ALERT_MARKER = Pattern.compile("^(\\d\\d/\\d\\d/\\d\\d) +(\\d\\d:\\d\\d:\\d\\d) +~TO~ [A-Z0-9]+ FROM [A-Z0-9]+:\n?");
  private static final Pattern SRC_MARKER = Pattern.compile("^([A-Z]+[0-9]+)[, ]");
  
  public PABucksCountyAParser() {
    super("SRC type:CALL! Box:BOX? adr:ADDR! aai:INFO box:BOX map:MAP tm:TIME% Run:UNIT");
  }
  
  @Override
  public String getFilter() {
    return "8276,@bnn.us,iamresponding.com,Bucks RSAN,@alert.bucksema.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (body.startsWith("911:")) body = body.substring(4).trim();
    
    if (body.endsWith("=")) body = body.substring(0,body.length()-1).trim();
    int pt = body.lastIndexOf('=');
    if (pt >= 100) body = body.substring(0,pt) + body.substring(pt+1);
    pt = body.indexOf("Sent by mss911 ");
    if (pt < 0) pt = body.indexOf("\nSent by Berks County RSAN");
    if (pt >= 0) body = body.substring(0,pt).trim();
    String saveBody = body;
    
    boolean mark2 = false;
    Matcher match = MARKER1.matcher(body);
    if (match.matches()) {
      String src = match.group(1);
      body = "type:" + match.group(2).replace('\n', ' ').trim();
      if (src != null) body = src + " " + body;
    } else {
      match = MARKER2.matcher(body);
      if (match.find()) {
        mark2 = true;
        body = match.group(1) + " type:" + match.group(2) + " " + body.substring(match.end()).replace('\n', ' ').trim();
      }
    }
    
    body = NAKED_DATE_TIME.matcher(body).replaceFirst(" tm: $0");
    body = body.replace(" Adr:", " adr:").replace(" stype:", " type:").replace(" saai:", " aai:").trim();
    if (super.parseMsg(body, data)) {
      if (mark2 && data.strUnit.length() == 0) {
        data.strUnit = data.strSource;
        data.strSource = "";
      }
      return true;
    }
    
    // Parse failure - but see if this is one of two kinds of recognized general message
    if (subject.equals("Important message from Bucks County RSAN")) {
      data.parseGeneralAlert(saveBody);
    } else if (subject.equals("911 Data")) {
      match = GEN_ALERT_MARKER.matcher(saveBody);
      if (!match.find()) return false;
      data.parseGeneralAlert(saveBody.substring(match.end()).trim());
      data.strDate = match.group(1);
      data.strTime = match.group(2);
    } else return false;
    
    //  See if the general alert data (in the place field) has a leading station code
    match = SRC_MARKER.matcher(data.strPlace);
    if (match.find()) {
      data.strSource = match.group(1);
      data.strPlace = data.strPlace.substring(match.end()).trim();
    }
    return true;
  }
  
  private class MyCallField extends CallField {
    
    @Override
    public void parse(String field, Data data) {
      String desc = TYPE_CODES.getProperty(field);
      if (desc != null) field = field + " - " + desc;
      super.parse(field, data);
    }
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String sAddr, Data data) {
      
      // Not the usual parseAddress method, this one is in the PABucksCountyBaseParser class
      parseAddressA7(sAddr, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE " + super.getFieldNames() + " CITY X";
    }
  }
  
  private static final Pattern COVER_PTN = Pattern.compile("\\bCV +[A-Z]?(\\d)\\d\\d[A-Z]?\\b");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = COVER_PTN.matcher(field);
      if (match.find()) {
        String code = match.group(1);
        switch (code.charAt(0)-'0') {
        case 3:
          data.strCity = "MONTGOMERY COUNTY";
          break;
        }
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "INFO CITY";
    }
  }
    
  private class MyTimeField extends TimeField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String token = p.get(' ');
      if (token.contains("/")) {
        data.strDate = token;
        token = p.get(' ');
      }
      data.strTime = token;
      data.strCallId = p.get();
    }
    
    @Override
    public String getFieldNames() {
      return "DATE TIME ID";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("TIME")) return new MyTimeField();
    return super.getField(name);
  }
  
  private static final Properties TYPE_CODES = buildCodeTable(new String[]{
      "AIRC",     "AIRPLANE CRASH (TAC)",
      "ACARDA",   "CARDIAC/RESPIRATORY ARREST",
      "APOSXP",   "POSSIBLE EXPIRATION",
      "BOMB",     "BOMB THREAT",
      "BURN",     "BURN VICTIM (LOC)",
      "CBURN",    "CONTROLLED BURN",
      "COALRM",   "CARBON MONOXIDE ALARM (LOC)",
      "DECON",    "DECON ASSIGNMENT (LOC)",
      "ELEVAT",   "STUCK ELEVATOR (LOC)",
      "EXBLD",    "EXTINGUISHED STRUCTURE (TAC)",
      "FALRM",    "FIRE ALARM (LOC)",
      "FAPL",     "APPLIANCE FIRE (TAC)",
      "FAPT",     "APARTMENT FIRE (BOX)",
      "FAST",     "FIRE ASSIST (OUT OF COUNTY)",
      "FAUTO",    "AUTOMOBILE (LOC)",
      "FBARN",    "BARN FIRE (TAC)",
      "FBLD",     "BUILDING FIRE (BOX)",
      "FBOAT",    "BOAT FIRE (LOC)",
      "FBRU",     "BRUSH FIRE (LOC)",
      "FBUS",     "BUS FIRE (LOC)",
      "FCHIMN",   "CHIMNEY FIRE (TAC)",
      "FCOV",     "FIRE STATION COVER",
      "FDRILL",   "FIRE DRILL",
      "FDUMP",    "DUMPSTER FIRE (LOC)",
      "FDWL",     "DWELLING FIRE (TAC)",
      "FEXP",     "EXPLOSION (LOC)",
      "FEMS",     "FIRE ASSIST EMS (LOC)",
      "FGARAG",   "GARAGE FIRE (TAC)",
      "FGRILL",   "GRILL FIRE (LOC)",
      "FHAZ",     "HAZMAT FIXED LOCATION (TAC)",
      "FHOSP",    "HOSPITAL FIRE (BOX)",
      "FINFO",    "FIRE INFORMATION",
      "FINV",     "FIRE INVESTIGATION (LOC)",
      "FIRE",     "FIRE OTHERS (LOC)",
      "FIRCAL",   "FIRE CALL (EMS)",
      "FMPAGE",   "FM PAGE REQUEST",
      "FNURS",    "NURSING HOME FIRE (BOX)",
      "FOBLD",    "OUTBUILDING FIRE (TAC)",
      "FPAGE",    "FD PAGE REQUEST",
      "FPOL",     "FIRE POLICE REQUEST",
      "FRUB",     "RUBBISH FIRE (LOC)",
      "FSCHOL",   "SCHOOL FIRE (BOX)",
      "FSPEC",    "SPECIAL ASSIGNMENT",
      "FSPILL",   "FUEL LEAK INCIDENT (LOC)",
      "FSTORE",   "SMALL STORE FIRE (TAC)",
      "FTA",      "ACCIDENT W/FIRE (LOC)",
      "FTAI",     "ACCIDENT W/FIRE & INJ (LOC)",
      "FTHAZ",    "TRANSPORTATION HAZMAT",
      "FTRAIN",   "TRAIN FIRE (TAC)",
      "FTRUCK",   "TRUCK FIRE (LOC)",
      "FUMEIN",   "FUMES INSIDE STRUCTURE (TAC)",
      "FUMES",    "FUMES OUTSIDE (LOC)",
      "FUNK",     "UNKNOWN TYPE FIRE (LOC)",
      "GALRM",    "GENERAL ALARM",
      "GASL",     "GAS LEAK",
      "RAUTO",    "AUTO EXTRICATION (RBOX)",
      "RDOM",     "DOMESTIC RESCUE (RBOX)",
      "RMAR",     "MARINE RESCUE (MBOX)",
      "RVBLD",    "VEHICLE INTO A BUILDING (RBOX)",
      "STDBY",    "FIRE STANDBY",
      "WATER",    "WATER FLOW (LOC)",
      "WIREIN",   "WIRES IN DWELLING (TAC)",
      "WIRES",    "WIRES DOWN (LOC)",

      "AABDO",      "ACUTE ABDOMEN",
      "AALLR",      "ANAPHYLAXIS",
      "AASSL",      "ASSAULT VICTIM (ALS)",
      "ABLED",      "ACUTE HEMORRHAGE",
      "ABURN",      "CRITICAL BURN VICTIM",
      "ACHESP",     "CHEST PAINS (CARDIAC SYMPT.)",
      "ACHOKE",     "OBSTRUCTED AIRWAY (ACTIVE)",
      "ACOP",       "CARBON MONOXIDE POISONING",
      "ACVA",       "CVA/STROKE",
      "ADIAB",      "DIABETIC EMERGENCY",
      "ADROWN",     "DROWNING - CRITICAL",
      "AELEC",      "ELECTRICAL SHOCK VICTIM",
      "AENVIR",     "ENVIRONMENTAL EMERGENCY",
      "AFAINT",     "SYNCOPAL EPISODE",
      "AFALL",      "FALL VICTIM - CRITICAL",
      "AGUN",       "GUNSHOT VICTIM",
      "AHRI",       "ALS HIT & RUN ACCIDENT WITH INJURY",
      "AOBG",       "ALS OB/GYN EMERGENCY",
      "AOD",        "OVERDOSE/POISONING - CRITICAL",
      "APREG",      "MATERNITY - CRITICAL",
      "ARESP",      "RESPIRATORY DISTRESS",
      "ASEIZ",      "SEIZURES - ACTIVE",
      "AASSLT",     "ASSAULT W/ TRAUMA",
      "ASTAB",      "STABBING VICTIM",
      "ATAI",       "ALS TRAFFIC ACCIDENT INJURIES",
      "ATRAN",      "ALS/UNSPECIFIED EMERGENCY",
      "ATRAUM",     "MULTI-SYSTEMS TRAUMA",
      "AUNC",       "UNCONSCIOUS SUBJECT",
      "AUNR",       "UNRESPONSIVE SUBJECT",
      "BABDO",      "ABDOMINAL PAIN",
      "BALLR",      "ALLERGIC REACTION",
      "BASSLT",     "ASSAULT - NON CRITICAL",
      "BBLED",      "BLEEDING (NON TRAUMATIC)",
      "BCHESP",     "CHEST PAIN  (NON CRITICAL)",
      "BINJ",       "MINOR INJURY - NON CRITICAL",
      "BLAC",       "ANIMAL BITE",
      "BPSYCH",     "PSYCHIATRIC TRANSPORTATION",
      "BOD",        "OVERDOSE/POISONING - NON CRITICAL",
      "BPREG",      "MATERNITY - NON CRITICAL",
      "BUNK",       "BLS/UNKNOWN PROBLEM",
      "BBURN",      "SCALDING/MINOR BURNS",
      "BDROWN",     "AQUATIC ACCIDENT (NON CRITICAL)",
      "BFALL",      "FALL VICTIM - NON CRITICAL",
      "BLAC",       "LACERATION/CONTROLLED BLEEDING",
      "BPTAST",     "PATIENT ASSIST",
      "COP",        "CARBON MONOXIDE POISONING",
      "BTAI",       "BLS TRAFFIC ACCIDENT (MINOR INJURIES)",
      "BTRAN",      "EMERGENCY TRANSPORTATION",
      "ESPEC",      "STANDBY / SPECIAL ASSIGNMENT (EMS)",
      "MALRM",      "MEDICAL ALARM"
  });
}
