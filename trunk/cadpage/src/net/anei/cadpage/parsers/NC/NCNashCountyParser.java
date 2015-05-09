package net.anei.cadpage.parsers.NC;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeTable;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3AParser;


public class NCNashCountyParser extends DispatchA3AParser {
  
  private static final Pattern CHANNEL_PTN = Pattern.compile("TAC.*", Pattern.CASE_INSENSITIVE);
  private static final Pattern HAZARD_PTN = Pattern.compile("Hazards: .*");
  private static final Pattern UNIT_PTN = Pattern.compile("(?!FIRES)(?:\\b(?:\\d*[A-Z]*\\d+[A-Z]?|\\d+-\\d+|[A-Z]*EMS|[A-Z]*FIR?E|[A-Z]*FD|[A-Z]*RES|[A-Z]*CEM|[A-Z]CSO|DOT|TOISN|(?:BRUSH|EMS|PPO|Nash Car|UNIT|RESCUE|ENG|SQD) ?\\d+)\\b,?)+");
  private static final Pattern PHONE_PTN = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
  private static final Pattern COMMENT_LABEL_PTN = Pattern.compile("(?:Geo|Landmark|Place) Comment: *(.*)|NBH: *(.*)");
  
  public NCNashCountyParser() {
    super(CITY_LIST, "NASH COUNTY", "NC");
    setFieldList("ADDR APT CH CITY X PLACE CODE CALL NAME UNIT PHONE INFO " + getFieldList());
    setupGpsLookupTable(GPS_LOOKUP_TABLE);
    setupMultiWordStreets(
        "ADOLPHUS T BOONE",
        "BARNES HILL CHURCH",
        "BARNHILL FARM",
        "BATTLE PARK",
        "BATTLEBORO LEEGETT",
        "BATTLEBORO LEGGETT",
        "BELLAMY MILL",
        "BEND OF THE RIVER",
        "BIG WOODS",
        "BODDIE MILL POND",
        "BONES ACRES",
        "BRADLEY CUTCHIN",
        "BUCK DEANS",
        "CARTER GROVE",
        "COKER TOWN",
        "COLLIE TYSON",
        "COUNTRY CLUB",
        "COUNTY LINE",
        "CRESCENT MEADOWS",
        "CURTIS ELLIS",
        "DAVIS STORE",
        "FLAG POND LOOP",
        "FLOODS STORE",
        "FOUNTAIN BRANCH",
        "GOLD ROCK",
        "GREEN HILLS",
        "GREEN PASTURE",
        "GREYS MILL",
        "HORNES CHURCH",
        "HUNTER HILL",
        "HUNTER RIDGE",
        "JOHN J SHARPE",
        "LAKE ROYALE",
        "LAKE VIEW",
        "LANCASTER STORE",
        "MAMAS RUN",
        "MARTIN LUTHER KING",
        "MEADOW PARK",
        "MILL BRANCH",
        "MILLIE FIELD",
        "MORNING STAR CH",
        "MORNING STAR CHURCH",
        "MT ZION CHURCH",
        "NASHVILLE COMMONS",
        "NICODEMUS MILE",
        "OAK GROVE",
        "OAK LEVEL",
        "PEACHTREE HILLS",
        "PLEASANT GROVE",
        "PLEASANT GROVE CHURCH",
        "PREACHER JOYNER",
        "RED OAK",
        "RED OAK BATTLEBORO",
        "REGES STORE",
        "RIVER GLENN",
        "RIVER LAKE",
        "ROCK QUARRY",
        "SANCTIFIED CHURCH",
        "SANDY CROSS",
        "SEVEN PATHS",
        "SHADY LANE",
        "SPEIGHTS CHAPEL",
        "SPRING HILL",
        "SPRING HOPE",
        "STONE ROSE",
        "STRAIGHT GATE",
        "TABERNACLE CHURCH",
        "TAYLORS STORE",
        "THOMAS A BETTS",
        "THOMAS BETTS",
        "THOMPSON CHAPEL",
        "TOWN CREEK",
        "TRESSELL LOOP",
        "VAUGHAN CHAPEL",
        "WAGON WHEEL",
        "WATER LOO",
        "WATERS EDGE",
        "WATSON SEED FARM",
        "WEBBS MILL",
        "WEST MOUNT",
        "WHITE OAK",
        "WHITLEY CIRCLE",
        "WINDCHASE POINTE",
        "WOLLETT MILL"
     );
  }
  
  @Override
  public String getFilter() {
    return "nash911@nashcountync.gov,9300";
  }
  
  @Override
  public boolean parseMain(String body, Data data) {
  
    body = stripFieldStart(body, "/ ");
    body = body.replace("\n", "  ");
    if (!body.startsWith("NASH911:")) return false;
    body = body.substring(8);
    boolean mBlankFmt = body.startsWith("  ");
    body = body.trim();
    
    // If we are lucky, we can count on the fields being separated by multiple blanks
    if (mBlankFmt) {
      
      // Split out fields by multiple blank separators
      String[] flds = body.split("  +");
      int spt = 0;
      int ept = flds.length;
     
      // First field has to be the address
      String addr = flds[spt++].replace("//", "/");
      parseAddress(StartType.START_ADDR, FLAG_RECHECK_APT | FLAG_ANCHOR_END, addr, data);
      
      // Second field has to be city.  Unless we found city in first field
      // Or unless second field is apt and third field is city
      if (data.strCity.length() == 0) {
        if (spt >= ept) return false;
        String city = flds[spt++];
        if (!isCity(city)) {
          if (CHANNEL_PTN.matcher(city).matches()) {
            data.strChannel = city;
          } else {
            data.strApt = append(data.strApt, "-", city);
          }
          if (spt >= ept) return false;
          city = flds[spt++];
          if (!isCity(city)) return false;
        }
        data.strCity = city;
      }
      
      // Now lets start working from the end.
      // First check for a special info field
      String lastFld = flds[--ept];
      if (HAZARD_PTN.matcher(lastFld).matches()) {
        data.strSupp = lastFld;
        if (spt > ept) return false;
        lastFld = flds[--ept];
      }
      
      // Check for (possibly multiple) unit fields 
      // at end.
      while (true) {
        if (spt > ept) return false;
        if (!UNIT_PTN.matcher(lastFld).matches()) break;
        data.strUnit = append(lastFld.replace(' ', '_'), ",", data.strUnit);
        lastFld = flds[--ept];
      }
      
      // This may be preceded by a phone number
      if (PHONE_PTN.matcher(lastFld).matches()) {
        data.strPhone = lastFld;
        if (spt > ept) return false;
        lastFld = flds[--ept];
      }
      
      // Or a empty "252-   -    " phone number which will be split across two fields
      else if (lastFld.equals("-") && flds[ept-1].equals("252-")) {
        ept--;
        if (spt > ept) return false;
        lastFld = flds[--ept];
      }
      
      // Which may be preceded by a name
      if (!CALL_SET.contains(lastFld)) {
        if (!lastFld.equals("UNK")) data.strName = cleanWirelessCarrier(lastFld);
        if (spt > ept) return false;
        lastFld = flds[--ept];
      }
      
      // Which is preceded by a call description
      data.strCall = lastFld;
      if (spt > ept) return false;
      lastFld = flds[--ept];
      
      // Which may be preceded by a call code
      if (CODE_TABLE.getResult(lastFld, true) != null) {
        data.strCode = lastFld;
        if (spt > ept) return false;
        lastFld = flds[--ept];
      }
      
      // Check for a Geo|Place|Landmark Comment: info field
      while (true) {
        Matcher match = COMMENT_LABEL_PTN.matcher(lastFld);
        if (!match.matches()) break;
        String info = match.group(1);
        if (info == null) {
          data.strPlace = match.group(2);
        } else {
          data.strSupp = append(info, "\n", data.strSupp);
        }
        if (spt > ept) return false;
        lastFld = flds[--ept];
      }
      
      // Anything that hasn't been processed is a cross street
      for (int ii = spt; ii <= ept; ii++) {
        data.strCross = append(data.strCross, " / ", flds[ii]);
      }
    }
    
    // Multiple blanks have been removed, we have do this the hard way
    else {
      body = body.replace("//", "/");
      parseAddress(StartType.START_ADDR, FLAG_RECHECK_APT | FLAG_CROSS_FOLLOWS, body, data);
      String left = getLeft();
      if (left.length() == 0) return false;
      
      // Last token of what is left is "usually" a unit designation
      // But only if it contains at least one digit
      Parser p =  new Parser(left);
      String unit = p.getLast(' ');
      if (UNIT_PTN.matcher(unit).matches()) {
        data.strUnit = unit.replace(' ', '_');
        left = p.get();
      }
      
      // If there is a landmark comment, it nicely separates the cross streets
      // from the comment & call description.  There is non easy way to identify
      // the call description.  We could put in a long description table to do 
      // this, but since the single blank format is no longer used, we will not
      // bother, instead just leave the call description in the info field.
      Matcher match = COMMENT_LABEL_PTN.matcher(left);
      if (match.find()) {
        data.strSupp = append(match.group(1), "\n", data.strSupp);
        left = left.substring(0,match.start()).trim();
        parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, left, data);
      }
      
      // Otherwise, there may be a  cross street at the start of what is left.  But we
      // will check for a recognized call description first, lest we get tripped
      // up by something like STRUCTURE PAUL LANE being misinterpreted as a 
      // cross street
      else {
        CodeTable.Result cRes = CODE_TABLE.getResult(left);
        if (cRes == null) {
          Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT, left);
          if (res.isValid()) {
            res.getData(data);
            left = res.getLeft();
            cRes = CODE_TABLE.getResult(left);
          }
        }
        
        // Now things get sticky.
        // What is left is either specific call code (which may be multiple words)
        // followed by a name.  Or is all call description :(
        if (cRes != null) {
          data.strCode = cRes.getCode();
          data.strCall  = cRes.getDescription();
          data.strName = cleanWirelessCarrier(cRes.getRemainder());
        } else {
          data.strCall = left;
        }
      }
    }
    data.strAddress = data.strAddress.replace("LEEGETT", "LEGGETT");
    if (data.strCity.equals("EDGECOMBE CO")) data.strCity = "EDGECOMBE COUNTY";
    return true;
  }
  
  @Override
  public boolean checkCall(String call) {
    return CALL_SET.contains(call);
  }

  @Override
  public String adjustGpsLookupAddress(String addr) {
    Matcher match = US64_PTN.matcher(addr);
    if (match.matches()) addr = match.group(1) + " US64";
    return addr;
  }
  private static final Pattern US64_PTN = Pattern.compile("(\\d+) US ?64(?: [EW]B)?");
  
  private static final Properties GPS_LOOKUP_TABLE = buildCodeTable(new String[]{
      "454 US64", "35.945492,-78.039942",
      "455 US64", "35.949149,-78.023140",
      "456 US64", "35.955508,-78.007927",
      "457 US64", "35.966097,-77.995484",
      "458 US64", "35.975398,-77.982828",
      "459 US64", "35.981547,-77.967077",
      "460 US64", "35.976349,-77.950999",
      "461 US64", "35.974279,-77.934634",
      "462 US64", "35.976803,-77.918041",
      "463 US64", "35.981781,-77.895261",
      "464 US64", "35.981860,-77.876863"

  });
  
  private static final CodeTable CODE_TABLE = new CodeTable(
      
        // Fire:
        "911 HANGUP", "911 HANGUP",
        "ADMIN-C",    "SERVICE CALL",
        "ADMIN-H",    "SERVICE CALL",
        "ALARM-FIRE", "FIRE ALARM",
        "ALARMS-C",   "UNKNOWN ALARM",
        "ALARMS-H",   "UNKNOWN ALARM",
        "ELECTRICAL", "ELECTRICAL",
        "EXPLOSION",  "EXPLOSION",
        "FUEL SPILL", "FUEL SPILL",
        "GAS LEAK",   "GAS LEAK",
        "MISC-C",     "MISC PROBLEM",
        "MISS PER-C", "MISSING PERSON",
        "MISS PER-H", "MISSING PERSON",
        "MUTUAL AID", "MUTUAL AID",
        "MVA PD",     "MVA PROPERTY DAMAGE",
        "MVA PD/OT",  "MVA OTHER",
        "MVA PI-C",   "MVA PERSON INJURED",
        "MVA PI-H",   "MVA PERSON INJURED",
        "MVA PIN-C",  "MVA PERSON PINNED",
        "MVA PIN-H",  "MVA PERSON PINNED",
        "ODOR",       "ODOR INVESTIGATION",
        "OUTSIDE FI", "OUTSIDE FIRE",
        "PUBL SER-C", "SERVICE CALL",
        "PUBL SER-H", "SERVICE CALL",
        "SERV CALL",  "SERVICE CALL",
        "SMOKE INVE", "SMOKE INVESTIGATION",
        "STRUCTURE",  "STRUCTURE FIRE",
        "TRAF/V/H-C", "MVA UNKNOWN",
        "TRAF/V/H-H", "MVA UNKNOWN",
        "VEH FIRE S", "SMALL VEHICLE FIRE",
        "VEH FIRE L", "LARGE VEHICLE FIRE",
        "VEH FIRE-L", "LARGE VEHICLE FIRE",
        "WATER RESC", "WATER RESCUE",
        
        // Police
        "THEFT-H",    "THEFT",

        // Medical:
        "ABD-C",      "ABDOMINAL PAIN",
        "ABD-H",      "ABDOMINAL PAIN",
        "ALLERGY-C",  "ALLERGIC REACTION",
        "ALLERGY-H",  "ALLERGIC REACTION",
        "ANIMAL-M-H", "ANIMAL BITE",
        "ANIMAL-M-L", "ANIMAL BITE",
        "ASSALT-M-C", "INJURED PERSON",
        "ASSALT-M-H", "INJURED PERSON",
        "BK PAIN-C",  "BACK PAIN",
        "BK PAIN-H",  "BACK PAIN",
        "BREATH-C",   "BREATHING DIFFICULTY",
        "BREATH-H",   "BREATHING DIFFICULTY",
        "BURNS-C",    "SUBJECT BURNED",
        "BURNS-H",    "SUBJECT BURNED",
        "CARBON-C",   "CO INHALATION",
        "CARBON-H",   "CO INHALATION",
        "CARD/ARR-C", "CODE BLUE",
        "CARD/ARR-H", "CODE BLUE",
        "CARDIAC-C",  "CODE BLUE",
        "CARDIAC-H",  "CODE BLUE",
        "CHEST-C",    "CHEST PAIN",
        "CHEST-H",    "CHEST PAIN",
        "CONF SPACE", "CONFINED SPACE RESCUE",
        "DIABETIC-C", "DIABETIC EMERGENCY",
        "DIABETIC-H", "DIABETIC EMERGENCY",
        "DISTURB-H",  "DISTURB",
        "FALLS-C",    "SUBJECT FALLEN",
        "FALLS-H",    "SUBJECT FALLEN",
        "HEADACHE-C", "HEADACHE",
        "HEADACHE-H", "HEADACHE",
        "HEART PR-C", "HEART PROBLEMS",
        "HEART PR-H", "HEART PROBLEMS",
        "HEAT/CLD-C", "HEAT EMERGENCY",
        "HEAT/CLD-H", "HEAT EMERGENCY",
        "HEMORRHA-C", "SUBJECT HEMORRHAGING",
        "HEMORRHA-H", "SUBJECT HEMORRHAGING",
        "MEDICAL",    "MEDICAL",
        "OB/PREG-H",  "OB/PREGNANCY",
        "OVERDOSE-C", "OVERDOSE",
        "OVERDOSE-H", "OVERDOSE",
        "PSYC/SUI-C", "PSYCHIATRIC PROBLEM",
        "PSYC/SUI-H", "PSYCHIATRIC PROBLEM",
        "SEIZURES-C", "SEIZURES",
        "SEIZURES-H", "SEIZURES",
        "SHOTSTAB-C", "SHOOTING/ STABBING",
        "SHOTSTAB-H", "SHOOTING/ STABBING",
        "SICK-C",     "SICK CALL",
        "SICK-H",     "SICK CALL",
        "STROKE-C",   "STROKE/ CVA",
        "STROKE-H",   "STROKE/ CVA",
        "SUSPWANT-C", "ASSIST LAW",
        "SUSPWANT-H", "ASSIST LAW",
        "TRANSFER-C", "TRANSFER ASST",
        "TRANSFER-H", "TRANSFER ASST",
        "TRAUMA-C",   "INJURED PERSON",
        "TRAUMA-H",   "INJURED PERSON",
        "UNCONSC-C",  "UNRESPONSIVE PERSON",
        "UNCONSC-H",  "UNRESPONSIVE PERSON",
        "UNK PROB-C", "UNKNOWN MEDICAL",
        "UNK PROB-H", "UNKNOWN MEDICAL"

  );
  
  private static final Set<String> CALL_SET = new HashSet<String>(Arrays.asList(
      "ABDOMINAL PAIN",
      "ABDOMINAL PAINS/PROBLEMS - COLD",
      "ABDOMINAL PAINS/PROBLEMS - HOT",
      "ALLERGIES,REACTIONS,ENVENOMATIONS-HOT",
      "ALL FIRE RELATED ALARMS",
      "ALL LARGE VEHICLE RELATED FIRES - INCLUDING TRACTOR TRAILERS",
      "ALL LAW ENFORCEMENT REALTED ALARMS-COLD",
      "ALL SMALL VEHICLE RELATED FIRES",
      "ANY OUTSIDE FIRE,GRASS,BRUSH, GRILL, DOG HOUSE, PUMP HOUSE",
      "BREATHING DIFFICULTY",
      "BREATHING PROBLEMS-EMERGENCY",
      "CARDIAC OR RESPIRATORY ARREST-HOT",
      "CHEST PAIN",
      "CHEST PAIN NON-TRAUMATIC-EMERGENCY",
      "CHOKING-EMERGENCY",
      "CONVALESCENT TRANSFER",
      "DIABETIC PROBLEMS-EMERGENCY",
      "DIABETIC PROBLEMS-ROUTINE",
      "ELECTRICAL HAZZARD OUSIDE/AWAY FROM A STRUCTURE",
      "ELECTROCUTION/LIGHTNING",
      "EMERGENCY FIRE DISPATCH",
      "EMERGENCY MEDICAL DISPATCH",
      "FALLS-EMERGENCY",
      "FALLS-LIFTING ASST. ROUTINE - EMS ONLY",
      "FUEL SPILL",
      "FIGHTS/PHYSICAL/SEXUAL ASSALT W/ INJUR-HOT (FRSP & EMS ONLY)",
      "FIRE ALARM",
      "GAS LEAK",
      "GAS LEAK/GAS ODOR/ NATURAL OR LP GAS LEAK",
      "HEADACHE-EMERGENCY",
      "HEADACHE-ROUTINE",
      "HEART PROBLEMS",
      "HEART PROBLEMS/AICD-EMERGENCY",
      "HEMORRHAGE/LACERATIONS/BLEEDING-EMERGENCY",
      "LOCK-IN/OUT, WELFARE CHECK, SECURITY CHECKS-COLD -SPECIFY",
      "LOCK-IN/OUT, WELFARE CHECK, SECURITY CHECKS-HOT -SPECIFY",
      "MENTAL DISORDER/BEHAVIOR PROBLEMS/SUICIDAL-HOT FRSP&EMS",
      "MOTOR VEH ACCIDENT PROPERTY DAMAGE ONLY VEH OVERTURNED",
      "MOTOR VEH ACCIDENT WITH INJURIES NO ONE PINNED -HOT",
      "MOTOR VEHICLE ACCIDENT WITH INJURIES-COLD",
      "MOTOR VEHICLE ACCIDENT WITH PROPERTY DAMAGE ONLY",
      "MOTOR VEHICLE ACC WITH INJURIES-UNK/PIN IN-HOT",
      "MUTUAL AID ASSIST ANOTHER DEPT - FIRE & EMS ONLY",
      "MVA PERSON INJURED",
      "MVA PERSON PINNED",
      "NON-TRAUMATIC OR NON-RECENT TRAUMA-COLD",
      "OB/CHILDBIRTH/MISCARR-HOT",
      "OD/POISONING-EMERGENCY",
      "OUTSIDE FIRE",
      "PATIENT TRANSFER ROUTINE/EMERGENCY - SPECIFY IN NARRATIVE",
      "SCALDS/BURNS ETC.-HOT",
      "SEIZURES",
      "SEIZURES/CONVULSIONS-EMERGENCY",
      "SEIZURES/CONVULSIONS-ROUTINE",
      "SERV CALL",
      "SERVICE/CITIZEN ASSISTANCE CALLS/",
      "SHOOTING,STABBING, OR OTHER PENETRATING TRAUMA-EMERGENCY",
      "SICK CALL-EMERGENCY",
      "SICK CALL-ROUTINE",
      "SMOKE INVESTIGATION OUTSIDE OF A STRUCTURE",
      "STROKE/CVA-EMERGENCY",
      "STRUCTURE FIRE",
      "SUBJECT FALLEN",
      "TRAFFIC VIOLATION/COMPLAINT/HAZARD/LIVESTOCK/-COLD",
      "TRAUMATIC INJURIES SPECIFIC/ EMERG",
      "TRAUMATIC INJURIES SPECIFIC/ ROUTINE",
      "UNCONSCIOUS/FAINTING-EMERGENCY",
      "UNKNOWN PROBLEM/PERSON DOWN -HOT (EMS RELATED)",
      "UNRESPONSIVE PERSON",
      "WARRANT SERV",
      "WATER RESCUE"
  ));
  
  private static final String[] CITY_LIST = new String[]{
    
      //  Cities
      "BAILEY",
      "CASTALIA",
      "DORTCHES",
      "ELM CITY",
      "MIDDLESEX",
      "MOMEYER",
      "NASHVILLE",
      "RED OAK",
      "ROCKY MOUNT",
      "SHARPSBURG",
      "SPRING HOPE",
      "WHITAKERS",
      "ZEBULON",
      
      // Townships
      "BAILEY",
      "BATTLEBORO",
      "CASTALIA",
      "COOPERS",
      "DRY WELLS",
      "FERRELLS",
      "GRIFFINS",
      "JACKSON",
      "MANNINGS",
      "NASHVILLE",
      "NORTH WHITAKERS",
      "OAK LEVEL",
      "RED OAK",
      "ROCKY MOUNT",
      "SPRING HOPE",
      "SOUTH WHITAKERS",
      "STONY CREEK",
      
      // Franklin County
      "LOUISBURG",
      
      // Halifax county
      "HOLLISTER",
      
      // Wilson County
      "ELM CITY",
      "SIMS",
      "WILSON",
      
      // Counties
      "EDGECOMBE CO",
      "FRANKLIN CO",
      "JOHNSTON CO",
      "HALIFAX CO",
      "WARREN CO",
      "WILSON CO"

  };
}
