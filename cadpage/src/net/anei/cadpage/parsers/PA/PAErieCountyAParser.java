package net.anei.cadpage.parsers.PA;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class PAErieCountyAParser extends DispatchB2Parser {
  
  private static final Pattern MARKER2 = Pattern.compile("^[0-9A-Z]+ ?>");
  private static final Pattern CITY_SUFFIX = Pattern.compile("^(?:BORO|CITY|VILLAGE|TWP|CO)\\b *");
 
  public PAErieCountyAParser() {
    super(PAErieCountyParser.CITY_LIST, "ERIE COUNTY", "PA");
    setupMultiWordStreets(
        "BEAR CREEK",
        "CARRIAGE HILL",
        "CAMBRIDGE SPRINGS",
        "CHERRY HILL",
        "CROSS STATION",
        "FOREST GLEN",
        "GREEN OAKS",
        "HASKELL HILL",
        "IMPERIAL POINT",
        "LAKE PLEASANT",
        "LAKE SHORE",
        "NICKLE PLATE",
        "OLD RIDGE",
        "OLD STATE",
        "OLD WATTSBURG",
        "OLD ZUCK",
        "PENELEC PARK",
        "PINE LEAF",
        "PINE TREE",
        "RILEY SIDING",
        "SUNRISE LAKES",
        "TAYLOR RIDGE",
        "VILLAGE COMMON",
        "WASHINGTON TOWNE"
    );
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Dummy do loop
    do {
      if (body.startsWith("ERIE911:")) {
        data.strSource = "ERIE911";
        body = body.substring(8).trim();
        break;
      }
      
      if (subject.length() > 0) {
        if (MARKER2.matcher(body).find()) {
          data.strSource = subject;
          break;
        }
      }
      
      return false;
    } while (false);

    body = body.replace("=20", " ").trim();
    boolean result = super.parseMsg(body, data);
    if (result) {
      Matcher match = CITY_SUFFIX.matcher(data.strName);
      if (match.find()) data.strName = data.strName.substring(match.end());
      result =  
          (data.strCross.length() > 0 || 
           data.strCallId.length() > 0);
      if (!result) {
        int pt = body.indexOf('>');
        result = (pt >= 0 && pt <= 20);
      }
    }
    if (!result && data.strSource.equals("ERIE911")) {
      data.parseGeneralAlert(this, body.trim());
      data.strSource = "ERIE911";
      result = true;
    }
    return result;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
  
  @Override
  protected CodeSet buildCallList() {
    return new CodeSet(
        "ABD PN - FEM PAIN ABOVE NAV>45",
        "ABDOM PAIN - FEM 12-50 W/FAINT",
        "ABDOM PAIN FAINT/NEAR > 50",
        "ABDOM PAIN KNOWN AORTIC ANEURY",
        "ABDOMINAL PAIN - NOT ALERT",
        "ABDOMINAL PAIN BLS P2",
        "ABDOMINAL PAIN DELTA RESPONSE",
        "ALARM - COMM/INDUSTRY GEN/FIRE",
        "ALARM - COMM/INDUSTRY PULL STA",
        "ALARM - COMM/INDUSTRY WATERFLO",
        "ALARM - HI LIFE HAZARD",
        "ALARM - HI-LIFE HAZ GEN/FIRE",
        "ALARM - HI-LIFE HAZ OTHER",
        "ALARM - MULTI RESID WATERFLOW",
        "ALARM - SINGLE RESID CO ALARM",
        "ALARM - UNK SIT-SMOKE DETECT",
        "ALARM BRAVO RESPONSE",
        "ALARM- COMM/INDUSTRY SMOKE DET",
        "ALARM-SINGLE RES SMOKE DETECT",
        "ALLERGIES-DIFF BREATH/SWALLOW",
        "ALLERGIES-SWARMING ATTACK",
        "ALLERGY-DIFF SPEAK BTW BREATH",
        "ASSAULT - NOT ALERT",
        "ASSAULT-NOT DANGER BODY AREA",
        "ASSAULT-POSS DANGER BODY AREA",
        "ASSAULT/SEXUAL ASSAULT DELTA",
        "AUTO-PEDESTRIAN",
        "BACK PAIN ALPHA RESPONSE",
        "BACK PAIN-TRAM-NON RECENT>6HRS",
        "BREATH PROB-DIFF SPEAK BTW BRE",
        "BREATHING PROB-ASTHMA-CLAMMY",
        "BREATHING PROBLEMS",
        "BREATHING PROBLEMS-ABNORMAL",
        "BREATHING PROBLEMS-CLAMMY",
        "BREATHING PROBLEMS-NOT ALERT",
        "CARDIAC/RESP ARR-OBVIOUS DEATH",
        "CARDIAC/RESP ARREST / DEATH",
        "CARDIAC/RESP ARREST-INEFF BREA",
        "CARDIAC/RESP/DEATH-NOT BREATH",
        "CHEST PAIN",
        "CHEST PAIN - BREATH NORMAL=>35",
        "CHEST PAIN - BREATH NORMAL=3D>35",
        "CHEST PAIN - CARDIAC HISTORY",
        "CHEST PAIN - CLAMMY",
        "CHEST PAIN - PATIENT NOT ALERT",
        "CHEST PAIN DELTA",
        "CHEST PAIN DIFF SPEAK BTW BRE",
        "CHEST PAIN-DIFFICULT BREATHING",
        "CITIZEN ASSIST-DOWNED TREE/OBJ",
        "CONV / SEIZ - MULTI/CONTINUOUS",
        "CONV/SEIZ-EFF BREATH NOT VERIF",
        "CONV/SEIZ-EPI-CONTINUOUS/MULTI",
        "DIAB PROB - ABNORMAL BEHAVIOR",
        "DIABETIC PROB-ALERT/NORM BEHAV",
        "DIABETIC PROBLEMS",
        "DIABETIC PROBLEMS - NOT ALERT",
        "DIABETIC PROBLEMS-UNCONCIOUS",
        "DIFF BREATHING",
        "ELEC HAZ/PWR REPT DISCONNECTED",
        "ELECTRICAL HAZ-NEAR WATER",
        "EXTINGUISHED STR FIRE ODOR",
        "FALLS",
        "FALLS (GRD/FLR) POSS DANGER BO",
        "FALLS (GRND/FLOOR) UNK STATUS",
        "FALLS - NOT ALERT",
        "FALLS - POSS DANGER BODY AREA",
        "FALLS - UNCONSCIOUS / ARREST",
        "FALLS - UNKNOWN STATUS",
        "FALLS(ON GRD/FL)-PUBLIC ASSIST",
        "FALLS- NOT DANGEROUS BODY AREA",
        "FALLS-ON GRD/FL-NOT DANGER BOD",
        "FIRE/GENERAL ALARM-COMM STRUC",
        "FUEL SPILL SM CONTAINED",
        "GAS LEAK/ODOR NAT/LP-OUTSIDE",
        "GAS LEAK/ODOR-RESIDENTIAL",
        "GAS ODOR ONLY - OUTSIDE",
        "GAS ODOR-COMMERCIAL/INDUSTRIAL",
        "GUNSHOT DELTA OVERRIDE",
        "HEADACHE - NOT ALERT",
        "HEADACHE CHANGE BEHAVIOR <=3HR",
        "HEADACHE SUDDEN ONSET SEVERE P",
        "HEART PROB / A.I.C.D. CLAMMY",
        "HEART PROB/AICD - CARDIAC HIST",
        "HEART PROB/AICD - NOT ALERT",
        "HEART PROB/AICD - UNK STATUS",
        "HEMORR/LACE-POSS DANGER HEMORR",
        "HEMORR/LACER - SERIOUS HEMORRH",
        "HEMORR/LACERA - ABNORM BREATH",
        "HEMORR/LACERA - BLEED DISORDER",
        "HEMORR/LACERA - BLOOD THINNERS",
        "HEMORR/LACERA - DANGER HEMORRA",
        "HEMORR/LACERATIONS - NOT ALERT",
        "HEMORRHAGE / LACERATIONS",
        "MAJOR INCIDENT - MVA DELTA RES",
        "MED DEFAULT FOR PROQA",
        "MUTL AID TO INC-MULTI UNITS P2",
        "MUTUAL AID/ASSIST OUTSIDE AGEN",
        "MVA - MAJOR INCIDENT",
        "MVA - NOT ALERT",
        "MVA - PINNED / ENTRAPPED",
        "MVA - UNKNOWN STATUS",
        "MVA - WITH INJURIES",
        "MVA -EJECTION- HIGH MECHANISM",
        "MVA- AUTO-BICYCLE / MOTORCYCLE",
        "MVA- ROLLOVERS",
        "MVA- SERIOUS HEMOR / MULTI PT",
        "MVA- TRAPPED / UNKN # PTS",
        "MVA-INJ-UNK # PATS & ADD RESPO",
        "MVA-TRAPPED MULTI PT/ADD RESPO",
        "OD/POISON-NOT ALERT-VIOLENT",
        "OUTSIDE FIRE - SMALL",
        "OUTSIDE FIRE BRAVO RESPONSE",
        "OUTSIDE FIRE- TRANSFORMER FIRE",
        "OVERDOSE/POISON-OD INTENTIONAL",
        "PSYCH/ABNORM BEH/SUIC UNK STAT",
        "PSYCH/ABNORM BEH/SUICIDE OVERR",
        "PSYCH/SUICID-NOT ALERT,VIOLENT",
        "PSYCH/SUICIDAL-NOT ALERT",
        "RES (SINGLE) HEAT DETECTOR",
        "RESIDENTIAL FIRE ALARM-GENERAL",
        "ROAD CLOSING",
        "SEIZURES - DIABETIC",
        "SEIZURES-EFF BREATH NOT VERIFY",
        "SEIZURES-EPI-BREATH NOT VERIFY",
        "SEIZURES-EPILEPTIC-NOT SEIZING",
        "SEIZURES-NOT SEIZING-EFF BREAT",
        "SICK PERSON",
        "SICK PERSON ALPHA RESPONSE",
        "SICK PERSON - FEVER / CHILLS",
        "SICK PERSON - GENERAL WEAKNESS",
        "SICK PERSON - NAUSEA",
        "SICK PERSON - NOT ALERT",
        "SICK PERSON - UNWELL / ILL",
        "SICK PERSON - VOMITING",
        "SICK PERSON DELTA RESPONSE",
        "SICK PERSON W/ NO PRIORITY SYP",
        "SICK PERSON- DIZZINESS/VERTIGO",
        "SICK PERSON-ABNORMAL BREATHING",
        "SICK PERSON-ALT LVL OF CONSC",
        "SICK PERSON-NEW ONSET IMMOBILI",
        "SICK PERSON-PENIS PROBLEM/PAIN",
        "SMOKE INV/OUTSIDE HEAVY SMOKE",
        "STROKE (CVA) - NOT ALERT <2HRS",
        "STROKE (CVA) BREATH NORM > 35",
        "STROKE (CVA)-NOT ALERT-UNK TIM",
        "STROKE-ABNORMAL BREATH <2HRS",
        "STROKE-SUDDEN PARALYSIS <2HRS",
        "STROKE-SUDDEN WEAK/NUMB <2HRS",
        "STRUC FIRE-MOBILE HOME",
        "STRUC FIRE-SINGLE RESID-SMOKE",
        "STRUC FIRE-SINGLE RESIDENTIAL",
        "STRUC FIRE-SM NON DWELLING",
        "STRUC FIRE-UNK SITUATION/INVES",
        "STRUCTURE FIRE - OVERRIDE",
        "STRUCTURE FIRE CHARLEY RESPONS",
        "STRUCTURE FIRE DELTA RESPONSE",
        "STRUCTURE FIRE-COMMERCIAL/INDU",
        "SYNC EPISODE-ALERT/ABNORM BREA",
        "SYNC EPISODE-ALERT>35 CARD HX",
        "SYNCOPE/ALERT < 35 W/O CARDIAC",
        "SYNCOPE/ALERT >35 W/O CARDIAC",
        "TRAFFIC CONTROL",
        "TRAFFIC/TRANS ACC OVERRIDE",
        "TRAFFIC/TRANSPORT ACC OVERRIDE",
        "TRANSFORMER FIRE-UNK EXPOSURE",
        "TRAUMA INJ-POSS DANGER BODY AR",
        "TRAUMA INJURY-NOT DANGER BODY",
        "TRAUMATIC INJ-SERIOUS HEMORRHA",
        "TRAUMATIC INJURIES DELTA RESPO",
        "UNCONSCIOUS CHANGING COLOR",
        "UNCONSCIOUS EFFECT BREATHING",
        "UNCONSCIOUS/FAINT - NOT ALERT",
        "UNCONSCIOUS/FAINT DELTA OVERRI",
        "UNCONSCIOUS/FAINTING DELTA",
        "UNKN PROB-MED ALRM,NO PT INFO",
        "UNKN PROBLEM-LIFE STATUS QUES",
        "UNKN PROBLEM-STAND,SIT,MOVING",
        "UNKN PROBLEM-UNKN STATUS",
        "UNKNOWN PROBLEM",
        "UNKNOWN PROBLEM DELTA RESPONSE",
        "VEH FIRE-LARGE FUEL/ FIRE LOAD CROSS",
        "VEH FIRE-THREATENED STRUCTURE",
        "VEHICLE FIRE",
        "VEHICLE FIRE-EXTINGUISHED",
        "WATER RESCUE DELTA RESPONSE",
        "WATER RESCUE-COASTAL WATER",
        "WIRES DOWN-NO SMOKE OR ARCING"
    );
  }
}