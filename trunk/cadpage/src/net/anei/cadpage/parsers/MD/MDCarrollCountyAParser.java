package net.anei.cadpage.parsers.MD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeTable;
import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Carroll County, MD
 */
public class MDCarrollCountyAParser extends FieldProgramParser {
  
  private static final Pattern TRAIL_SEQ = Pattern.compile(" \\[\\d+\\]$");
  
  public MDCarrollCountyAParser() {
    super("CARROLL COUNTY", "MD",
           "TIME CT:ADDR! BOX:BOX! DUE:UNIT!");
    setupMultiWordStreets(
        "BEAR BRANCH",
        "DAVE RILL", 
        "EAST CHERRY HILL",
        "GRAVE RUN",
        "LE MANS",
        "SCOTCH HEATHER",
        "TIMBER BRANCH",
        "WAKEFIELD VALLEY");
  }
  
  @Override
  public String getFilter() {
    return "@c-msg.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    do {
      if (subject.equals("!")) break;
      
      if (subject.endsWith("|!")) {
        data.strSource = subject.substring(0,subject.length()-2);
        break;
      }
      
      int pt = body.indexOf(" / [!] ");
      if (pt >= 0) {
        data.strSource = body.substring(0,pt).trim();
        body = body.substring(pt+7).trim();
        break;
      }

      // Message signatures are now optional.  If we don't find one, keep on procesing
    } while (false);
    
    Matcher match = TRAIL_SEQ.matcher(body);
    if (match.find()) body = body.substring(0,match.start()).trim();
    
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }

  private static final Pattern MA_PTN = Pattern.compile("^(?:MA|MUTUAL AID ALARM) (?:BOX |[A-Z]{2} )?(?:(\\d{1,2}-\\d{1,2}(?:-\\d{1,2})?) )?|^([A-Z]+) +(\\d+-\\d+) +");
  private static final Pattern MA_SEPARATOR_PTN = Pattern.compile(" +- +| */ *| *; *");
  private static final Pattern APT_PTN = Pattern.compile("(?:\\bAPT\\b|#) *([^ ]+)$");
  private static final Pattern CHANNEL_PTN = Pattern.compile("(?:[ \\.]+(CP|TB|TG|FC) *| +)(\\d{1,2}(?:-?[A-Z])?|WEST)$");
  private static final Pattern BOX_PTN = Pattern.compile("\\d{1,2}-\\d{1,2}(?:-\\d{1,2})?");
  private static final Pattern BOX_PTN2 = Pattern.compile("(?: +BOX)? +(\\d{1,2}-\\d{1,2}(?:-\\d{1,2})?)$");
  private class MyAddressField extends Field {
    
    @Override
    public void parse(String fld, Data data) {
      
      fld = fld.replaceAll("/+ */+", "/");
      if (fld.endsWith("/")) fld = fld.substring(0,fld.length()-1).trim();

      // The rules all change for mutual aid calls
      Matcher match = MA_PTN.matcher(fld);
      if (match.find()) {
        String maCall = match.group(2);
        if (maCall != null) {
          data.strBox = match.group(3);
        } else {
          maCall = "MA";
          data.strBox = getOptGroup(match.group(1));
        }
        fld = fld.substring(match.end()).trim();
        
        // Sometimes, the address line is nicely split out with slashes, dashes, or semicolons
        // But first protectect L/Z short for Landing Zone
        // Also CP/TB whatever that may be
        String[] flds = MA_SEPARATOR_PTN.split(fld.replace(" L/Z", " L%Z").replace(" CP/TB", " CP%TB"));
        if (flds.length > 2) {
          parseAddress(flds[0], data);
          int sNdx = 1;
          if (isValidAddress(flds[1])) {
            if (data.strAddress.length() == 0 || !Character.isDigit(data.strAddress.charAt(0))) {
              data.strAddress = append(data.strAddress, " & ", flds[1]);
            } else {
              data.strCross = flds[1];
            }
            sNdx++;
          }
          
          int eNdx = flds.length-1;
          if (eNdx-sNdx > 0 && data.strChannel.length() == 0) {
            data.strChannel = flds[eNdx--];
          }
          if (data.strBox.length() == 0 && eNdx-sNdx > 0) {
            String box = flds[eNdx].trim();
            if (BOX_PTN.matcher(box).matches()) {
              data.strBox = box;
              eNdx--;
            }
          }
          data.strCall = append(maCall, " - ", flds[sNdx].replace("L%Z", "L/Z").replace("CP%TB", "CP/TB"));
          for (int j = sNdx+1; j <= eNdx; j++) {
            data.strCall = append(data.strCall, " / ", flds[j].replace("L%Z", "L/Z").replace("CP%TB", "CP/TB"));
          }
        }
        
        // and sometimes they do not :(
        else {
          
          // Check for trailing channel
          match = CHANNEL_PTN.matcher(fld);
          if (match.find()) {
            data.strChannel = append(getOptGroup(match.group(1)), " ", match.group(2));
            fld = fld.substring(0,match.start()).trim();
          }
          
          // And a trailing box number
          match = BOX_PTN2.matcher(fld);
          if (match.find()) {
            data.strBox = match.group(1);
            fld = fld.substring(0,match.start());
            
            // and an occasional trailing channel in front of the box number :(
            if (data.strChannel.length() == 0) {
              match = CHANNEL_PTN.matcher(fld);
              if (match.find()) {
                data.strChannel = append(getOptGroup(match.group(1)), " ", match.group(2));
                fld = fld.substring(0,match.start()).trim();
              }
            }
          }
          
          // Parse place and address, anything following is the rest of the call
          parseAddress(StartType.START_PLACE, fld, data);
          String call = getLeft();
          if (call.startsWith("/")) call = call.substring(1).trim();
          
          if (data.strPlace.endsWith("/")) {
            data.strAddress = append(data.strPlace.substring(0,data.strPlace.length()-1).trim(), " & ", data.strAddress);
            data.strPlace = "";
          }
          
          // Otherwise, just take the leftover stuff as the call description
          // If there isn't anything left over, grab the leading place field instead
          if (call.startsWith(";")) call = call.substring(1).trim();
          if (call.length() == 0) {
            call = data.strPlace;
            data.strPlace = "";
          }
          data.strCall = append("MA", " - ", call);
        }
      }
      
      // If normal (not mutual aid) call
      else {
        
        // First see if we recognize the call description
        StartType st = StartType.START_CALL;
        int flags = FLAG_START_FLD_REQ | FLAG_ANCHOR_END;
        CodeTable.Result res = CALL_TABLE.getResult(fld, true);
        if (res != null) {
          st = StartType.START_PLACE;
          flags = FLAG_ANCHOR_END;
          data.strCode = res.getCode();
          data.strCall = res.getDescription();
          if (data.strCode.equals(data.strCall)) data.strCode = "";
          fld = res.getRemainder();
        }
        
        // Next check if the last token is a recognized city and
        // strip it off if it is, otherwise it messes up the following logic
        Parser p = new Parser(fld);
        String city = CITY_CODES.getProperty(p.getLast(' '));
        if (city != null) {
          data.strCity = city;
          fld = p.get();
        }
        
        // Rest of address could include a place name separated by a ; or @
        // Unfortunately, the two fields might be in either order :(
        // Worse, there could be 3 or  more :(  In which case we only
        // check the first two and force the last one into a place field
        // And the place name might contain an apartment
        String[] flds = fld.split(" *[;@] *", 3);
        if (flds.length == 1) {
          parseAddress(st, flags, fld, data);
          if (data.strPlace.endsWith("/")) {
            data.strAddress =  append(data.strPlace.substring(0,data.strPlace.length()-1).trim(), " & ", data.strAddress);
            data.strPlace = "";
          }
        }
        else {
          String fld1 = flds[0];
          String fld2 = flds[1];
          String savePlace = flds.length > 2 ? flds[2] : "";
          Result res1 = parseAddress(st, flags | FLAG_CHECK_STATUS, fld1);
          Result res2 = parseAddress(StartType.START_ADDR, FLAG_CHECK_STATUS | FLAG_ANCHOR_END, fld2);
          if (res2.getStatus() > res1.getStatus()) {
            res1 = res2;
            fld2 = fld1;
          }
          res1.getData(data);
          if (data.strPlace.endsWith("/")) {
            data.strAddress =  append(data.strPlace.substring(0,data.strPlace.length()-1).trim(), " & ", data.strAddress);
            data.strPlace = "";
          }
          match = APT_PTN.matcher(fld2);
          if (match.find()) {
            data.strApt = match.group(1);
            fld2 = fld2.substring(0,match.start()).trim();
          }
          if (data.strCall.length() == 0) {
            data.strCall = fld;
          } else {
            data.strPlace = append(data.strPlace, " - ", fld2);
          }
          if (savePlace.length() > 0) {
            match = APT_PTN.matcher(savePlace);
            if (match.find()) {
              data.strApt = append(data.strApt, "-", match.group(1));
              savePlace =  savePlace.substring(0,match.start()).trim();
            }
            data.strPlace = append(data.strPlace, " - ", savePlace);
          }
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CODE CALL BOX PLACE ADDR X APT CITY CH";
    }
  }
  
  // Box field behaves normally unless this is a mutual aid call
  // in which case it becomes a county code
  private class MyBoxField extends BoxField {
    
    @Override
    public void parse(String fld, Data data) {
      if (data.strCall.startsWith("MA ") || data.strCall.equals("MA")) {
        String[] tmp = convertCodes(fld, COUNTY_CODES).split(",");
        data.strCity = tmp[0];
        if (tmp.length > 1) data.strState = tmp[1];
      }
      else {
        super.parse(fld, data);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "BOX CITY ST";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TIME")) return new TimeField("\\d\\d:\\d\\d", true);
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("BOX")) return new MyBoxField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String address) {
    // Other location seem OK with decimal street addresses, but not here
    return DECIMAL_PTN.matcher(address).replaceFirst("$1");
  }
  private static final Pattern DECIMAL_PTN = Pattern.compile("^(\\d+)\\.\\d+");

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AIRY", "MT AIRY",
      "FINK", "FINKSBURG",
      "HAMP", "HAMPSTEAD",
      "KEYM", "KEYMAR",
      "LINE", "LINEBORO",
      "LINW", "LINWOOD",
      "MANC", "MANCHESTER",
      "MARR", "MARRIOTSVILLE",
      "MILL", "MILLERS",
      "NWIN", "NEW WINDSOR",
      "REIS", "REISTERSTOWN",
      "SYKE", "SYKESVILLE",
      "TANE", "TANEYTOWN",
      "UNBR", "UNION BRIDGE",
      "UPCO", "UPPERCO",
      "WEST", "WESTMINSTER",
      "WOOD", "WOODBINE",
  });
  
  // Mutual aid count abbreviations
  private static final Properties COUNTY_CODES = buildCodeTable(new String[]{
      "YC", "YORK COUNTY,PA",
      "BC", "BALTIMORE COUNTY",
      "HC", "HOWARD COUNTY",
      "FC", "FREDERICK COUNTY",
      "AC", "ADAMS COUNTY,PA",
      "MC", "MONTGOMERY COUNTY"
  });
  
  private static final CodeTable CALL_TABLE = new CodeTable();
  static {
    String key = null;
    for (String value : new String[]{
        "AAM",        "AUTOMATIC MEDICAL ALARM",
        "ABDOM",      "ABDOMINAL PAIN",
        "ABDOMALS",   "ABDOMINAL PAIN",
        "AIR1L",      "LG PLANE INCOMING",
        "AIR1S",      "SM PLANE INCOMING",
        "AIR2L",      "LG PLANE CRASH/STRUC",
        "AIR2S",      "SM PLANE CRASH/STRUC",
        "AIR3L",      "LG PLANE CRASH",
        "AIR3S",      "SM PLANE CRASH",
        "ALARM",      "ALARM",
        "ALARM 1",    "RES FIRE ALARM",
        "ALARM 2",    "COMM FIRE ALARM",
        "ALLER",      "ALLERGIC REACTION",
        "ALLERBLS",   "ALLERGIC REACTION",
        "ALS",        "ALS MEDICAL CALL",
        "ALS+",       "ALS W/SUPPORT",
        "AMB TRAN",   "TRAN AMBULANCE TRANSFER",
        "AMB TRANS",  "TRAN AMBULANCE TRANSFER",
        "ASTH",       "ASTHMA ATTACK",
        "ATR",        "ATR RESCUE",
        "ATR/HM",     "ATR RESCUE W/HAZMAT",
        "ATROL",      "OVERLAND ATR RESCUE",
        "ATV",        "ATV ACCIDENT",
        "BACK",       "BACK PAIN",
        "BACKALS",    "BACK PAIN (ALS RESPONSE)",
        "BF",         "BUILDING FIRE",
        "BF RESC",    "BLDG FIRE W/RESCUE",
        "BF/HM",      "BLDG FIRE W/HAZMAT",
        "BIO2",       "OPENED ITEM WITH RELEASE / NO DISTRESS",
        "BIO3",       "SUSPICIOUS ITEM WITH EXPOSURE",
        "BIO4",       "SUSPICIOUS PACKAGE W/PERSONS DOWN",
        "BIO5",       "EXPLOSION OR EXPLOSIVE DEVICES",
        "BLS",        "BLS MEDICAL CALL",
        "BLSC",       "NON EMER BLS CALL",
        "BOX",        "BOX ALARM",
        "BOX/HLH",    "BLDG/HIGH LIFE HAZ",
        "BOX/HLHZ",   "BLDG/HIGH LIFE HZ/HM",
        "BOX/HM",     "BOX ALARM W/HAZMAT",
        "BRUSH",      "BRUSH FIRE",
        "BURN",       "BURN INJURY",
        "BURNALS",    "BURN INJURY",
        "CA",         "CARDIAC ARREST",
        "CARD",       "CARDIAC PATIENT",
        "CARDIAC",    "CARDIAC",
        "CARDBLS",    "CARDIAC PATIENT BLS",
        "CHEST",      "CHEST PAIN",
        "CHESTBLS",   "CHEST PAIN BLS",
        "CHIM",       "CHIMNEY FIRE",
        "CHOKE" ,     "CHOKING",
        "CHOKEBLS",   "CHOKING EPISODE AIRWAY CLEAR",
        "CO",         "CO DETECTOR",
        "CO 1",       "CO DETECTOR",
        "CO 2",       "CO DETECTOR",
        "CO 3",       "CO DETECTOR",
        "CO 4",       "CO DETECTOR",
        "COBLS",      "CO POISONING",
        "COPOIS",     "CARBON MONOXIDE POISONING",
        "COLD",       "COLD EXPOSURE",
        "COLDALS",    "COLD EXPOSURE",
        "COLL",       "BUILDING COLLAPSE",
        "CONST",      "CONSTRUCTION / INDUSTRIAL ACCIDENT",
        "COS",        "CO W/SICK PERSON",
        "DIAB",       "DIABETIC",
        "DIABBLS",    "DIABETIC BLS",
        "DLOC",       "DECREASED LEVEL OF CONSCIOUSNESS",
        "DOA",        "DOA",
        "DROWN",      "DROWNING",
        "DROWNALS",   "NEAR DROWNING",
        "DROWNBLS",   "NEAR DROWNING",
        "ELEC",       "ELECTRICAL BURN",
        "ELEV",       "ELEVATOR RESC W/INJ",
        "ELEV/SC",    "ELEVATOR RESC NO INJ",
        "ET",         "EMERGENCY TRANSFER",
        "EYE",        "EYE INJURY",
        "EYEALS",     "EYE INJURY ALS",
        "FARM",       "FARM MACHINERY FIRE",
        "FIELD",      "FIELD FIRE",
        "GAS LINE",   "GAS LINE STRUCK",
        "GAS/OUT",    "OUTSIDE GAS LEAK",
        "HANG",       "HANGING",
        "HAZMAT",     "HAZMAT INCIDENT (SPECIFY)",
        "HEADACHE",   "HEADACHE",
        "HEAT",       "HEAT RELATED EMERGENCY",
        "HEATALS",    "HEAT RELATED EMERGENCY",
        "HEM",        "HEMORRHAGE",
        "HEMALS",     "HEMORRHAGE",
        "HEMIVT",     "HEMORRHAGE",
        "HF",         "HOUSE FIRE",
        "HM",         "HAZMAT ALARM",
        "ILLEG",      "ILLEGAL OPEN BURNING",
        "INHAL",      "INHALATION EMERGENCY",
        "INHALBLS",   "INHALATION EMERGENCY",
        "INJ",        "INJURED PERSON",
        "INJALS",     "INJURED PERSON (SPECIFY NATURE)",
        "INJFALL",    "INJURED PERSON FROM FALL",
        "INJAS",      "INJURED PERSON FROM ASSAULT",
        "INJASALS",   "INJURED PERSON FROM ASSAULT (ALS)",
        "INVEST",     "INVESTIGATION",
        "IVT",        "IVT MEDICAL ALARM",
        "LARGE TRUCK FIRE", "LARGE TRUCK FIRE",
        "LO/E",       "EMERGENCY LOCKOUT",
        "LOCAL",      "LOCAL ALARM",
        "MA",         "MUTUAL AID ALARM",
        "MERCLG",     "MERCURY RELEASE / LARGE",
        "MERCSM",     "MERCURY RELEASE / SMALL",
        "MISC",       "MISCELLANEOUS FIRE - SPECIFY",
        "MO",         "MENTAL PATIENT",
        "MOV",        "VIOLENT MENTAL PATIENT",
        "NOSE",       "NOSEBLEED",
        "OB",         "OBSTETRIC PATIENT",
        "OBALS",      "OBSTETRIC PATIENT ALS",
        "OVERDOSE",   "OVERDOSE",
        "ODBLS",      "OVERDOSE",
        "ODORSICK",   "ODOR WITH SICK SUB",
        "OUTSIDE",    "OUTSIDE FIRE",
        "PA",         "PATIENT ASSIST",
        "PATIENT",    "PATIENT ASSIST",
        "PED",        "PEDESTRIAN STRUCK",
        "PIAMB",      "INJURY FROM VEHICLE ACCIDENT",
        "POIS",       "POISONING",
        "POISBLS",    "POISONING BLS",
        "PROQA DEFAULT", "PROQA DEFAULT",
        "REKIN",      "REKINDLE",
        "RES FIRE ALARM", "RES FIRE ALARM",
        "RESC",       "RESCUE ALARM",
        "RESCONF",    "CONFINED SPACE RESCUE",
        "RESHA",      "HIGH ANGLE RESCUE",
        "RESMI/ALS",  "SPECIFY NATURE (ALS RESPONSE)",
        "RESP",       "TROUBLE BREATHING",
        "RESTR",      "TRENCH RESCUE",
        "RESWN",      "INLAND WATER RESCUE",
        "RESWR",      "SWIFT WATER RESCUE",
        "ROUT",       "ROUTINE TRANSPORT",
        "SC/CO",      "CO DETECTOR ACTIVATION",
        "SC/ELEV",    "STUCK ELEVATOR",
        "SC/FLOOD",   "FLOODING CONDITION",
        "SC/HELI",    "HELICOPTER LANDING ZONE",
        "SC/LOCK",    "LOCKOUT",
        "SC/LOCKV",   "SUBJECT LOCKED IN A VEHICLE",
        "SC/WASH",    "WASHDOWN",
        "SEIZ",       "SEIZURE",
        "SEIZALS",    "SEIZURE",
        "SERVICE",    "SERVICE CALL",
        "SHOOT",      "SHOOTING",
        "SHOOTA",     "ACCIDENTAL SHOOTING",
        "SHOOTBLS",   "SHOOTING BLS",
        "SHOOTS",     "SELF INFLICTED SHOOTING",
        "SICK",       "SICK PERSON",
        "SNAKE",      "SNAKE BITE",
        "SPILL",      "HAZMAT ALARM - FUEL SPILL",
        "STAB",       "STABBING",
        "STABBLS",    "STABBING BLS",
        "STABS",      "SELF INFLICTED - KNIFE",
        "STROKE",     "STROKE",
        "STRUC",      "STRUCTURE ALARM",
        "SYNCO",      "SYNCOPAL EPISODE",
        "TANKER",     "LG FUEL LOAD VEHICLE",
        "TRAIN AC",   "TRAIN ACCIDENT",
        "TRAIN FI",   "TRAIN FIRE",
        "TRANS",      "TRANSFER",
        "TRASH",      "TRASH FIRE",
        "TRUCKLG",    "LARGE TRUCK FIRE",
        "UC",         "UNCONSCIOUS SUBJECT",
        "UNCDIAB",    "UNCONSCIOUS DIABETIC",
        "UNCOD",      "UNCONSCIOUS OVERDOSE",
        "UNK",        "UNKNOWN MEDICAL EMERGENCY",
        "UP",         "UNCONSCIOUS PERSON",
        "VC",         "VEHICLE COLLISION",
        "VC/BIKE",    "BICYCLE ACCIDENT",
        "VC/MOT",     "MOTORCYCLE ACCIDENT",
        "VC BUS",     "BUS ACCIDENT",
        "VC SERIOUS", "VEHICLE COLLISION SERIOUS",
        "VCBUS",      "BUS ACCIDENT",
        "VCR",        "VEHICLE COLLISION RESCUE",
        "VCR/HM",     "VC W/HM",
        "VCS",        "VEHICLE COLLISION SERIOUS",
        "VEH",        "VEHICLE FIRE",
        "VEHICLE",    "VEHICLE COLLISION",
        "WIRES",      "WIRES DOWN",
        "WOODS",      "WOODS FIRE" }) {
      if (key == null) {
        key = value;
      } else {
        CALL_TABLE.put(key, value);
        CALL_TABLE.put(value, value);
        key = null;
      }
    }
  };
}
