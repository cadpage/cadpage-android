package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * San Bernardino County, CA
 */
public class CASanBernardinoCountyAParser extends FieldProgramParser {
  
  private static final Pattern GEN_ALT_UNIT_PTN = Pattern.compile("^([A-Z]+\\d+)[A-Z]?\\b");
  
  public CASanBernardinoCountyAParser() {
    super(CITY_CODES, "SAN BERNARDINO COUNTY", "CA",
           "CALL! ADDR! ( XST:X LOC_INFO:PLACE! CITY! AGN_MAP:MAP! INFO UNIT CALL_INFO:INFO | CITY_EXT LOC_INFO:PLACE AGN_MAP:MAP! X_ST:X! UNIT COMMENTS:INFO LAT/LON:GPS )");
  }
  
  @Override
  public String getFilter() {
    return "cad@confire.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS | MAP_FLG_SUPPR_LA;
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("|")) body = body.substring(1).trim();
    if (parseFields(body.split(">"), data)) {
      int pt = data.strCity.indexOf('/');
      if (pt >= 0) {
        data.strPlace = append(data.strPlace, " - ", data.strCity.substring(0,pt));
        data.strCity = data.strCity.substring(pt+1);
      }
      return true;
    }
    
    // No go for regular dispatch page
    // If positive confirmation, this might be a general alert 
    if (!isPositiveId()) return false;
    
    // If body starts with something that looks like a unit
    // parse the unit field and report result as general alert
    Matcher match = GEN_ALT_UNIT_PTN.matcher(body);
    if (!match.find()) return false;
    data.initialize(this);
    data.strCall = "GENERAL ALERT";
    data.strUnit = match.group(1);
    data.strPlace = body;
    return true;
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("NUMBER")) return new AddressField("\\d+", true);
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("CITY_EXT")) return new MyCityExtField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("INFO")) return new MyInfoField();
    if (name.equals("GPS")) return new MyGPSField();
    return super.getField(name);
  }
  
  private class MyCallField extends CallField {
    
    @Override
    public void parse(String field, Data data) {
      field = stripFieldEnd(field, "-");
      String key = field;
      String extra = "";
      int pt = key.indexOf(' ');
      if (pt >= 0) {
        key = field.substring(0,pt);
        if (key.endsWith("-")) key = key.substring(0,key.length()-1).trim();
        extra = field.substring(pt+1).trim();
        if (extra.startsWith("-")) extra = extra.substring(1).trim();
      }
      String desc = TYPE_CODES.getProperty(key);
      if (desc == null) {
        int pt2 = key.indexOf('-');
        if (pt2 >= 0) {
          String key2 = key.substring(0,pt2);
          desc = TYPE_CODES.getProperty(key2);
        }
      }
      if (desc != null) {
        if (desc.startsWith(extra)) field = key;
        field = field + " - " + desc;
      }
      super.parse(field, data);
    }
  }
  
  private static final Pattern BLANK_DASH_PTN = Pattern.compile("(.*) -(.*)");
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      
      int pt = field.lastIndexOf(' ');
      if (pt >= 0) {
        String city = CITY_CODES.getProperty(field.substring(pt+1).trim());
        if (city != null) {
          data.strCity = city;
          field = field.substring(0,pt).trim();
        }
      }

      field = stripFieldEnd(field,  "-");
      Matcher match = BLANK_DASH_PTN.matcher(field);
      if (match.matches()) {
        String tmp = match.group(1).trim();
        if (!NUMERIC.matcher(tmp).matches()) {
          field = tmp;
          data.strApt = match.group(2).trim();
        }
      }

      field = append(data.strAddress, " - ", field);
      data.strAddress = "";
      parseAddress(field, data);

      pt = data.strCity.indexOf('/');
      if (pt >= 0) {
        data.strPlace = data.strCity.substring(0,pt);
        data.strCity = data.strCity.substring(pt+1);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("No X-Street", "");
      field = stripFieldStart(field, "/");
      field = stripFieldEnd(field, "/");
      super.parse(field, data);
    }
  }
  
  private class MyCityExtField extends Field {

    @Override
    public void parse(String field, Data data) {
      if (data.strCity.length() == 0) {
        int pt = field.lastIndexOf(" - ");
        if (pt >= 0) {
          data.strCity = convertCodes(field.substring(pt+3).trim(), CITY_CODES);
          field = field.substring(0,pt).trim();
        }
      }
      data.strPlace = append(data.strPlace, " - ", field);
    }

    @Override
    public String getFieldNames() {
      return "PLACE CITY";
    }
    
  }
  
  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace("-TB MAP:", "- ");
      super.parse(field, data);
    }
  }
  
  private static final Pattern PRO_QA_PTN = Pattern.compile(" *\\[ProQA .*?\\] *");
  private static final Pattern CODE_PTN = Pattern.compile("\\bDispatch code: *(\\w+)\\b");
  private static final Pattern INFO_GPS_PTN = Pattern.compile("W(?:PH2|911) LAT:([-+]?[\\d\\.]+) LON:([-+]?[\\d\\.]+) .*");
  private static final String[] SKIP_MARKERS = new String[]{
    "External",
    "Automatic Case Number(s)",
    "A cellular re-bid has occurred", 
    "check the ANI/ALI Viewer",
    "WPH2 ",
    "W911 "
  };
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      
      field = PRO_QA_PTN.matcher(field).replaceAll(" ");
      field = field.replaceAll("  +", " ").trim();
      
      Matcher match = CODE_PTN.matcher(field);
      if (match.find()) {
        data.strCode = match.group(1);
        field = field.substring(0,match.start()) + " " + field.substring(match.end());
      }

      for (String fld : field.split(",")) {
        match = INFO_GPS_PTN.matcher(fld);
        if (match.matches()) {
          data.strGPSLoc = match.group(1) + ',' + match.group(2);
          continue;
        }
        boolean skip = false;
        String trimFld =  fld.trim();
        for (String skip_mark : SKIP_MARKERS) {
          if (trimFld.startsWith(skip_mark) || skip_mark.startsWith(trimFld)) {
            skip = true;
            break;
          }
        }
        if (skip) continue;
        
        data.strSupp = append(data.strSupp, ",", fld).trim();
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CODE GPS INFO";
    }
  }
  
  private static final Pattern GPS_FIELD_PTN = Pattern.compile("(\\d+)(\\d{6}) */ *(\\d+)(\\d{6})");
  private class MyGPSField extends GPSField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = GPS_FIELD_PTN.matcher(field);
      if (!match.matches()) return;
      field = match.group(1) + '.' + match.group(2) + ',' + match.group(3) + '.' + match.group(4);
      setGPSLoc(field, data);
    }
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ABY",  "AMBOY",
      "ADC",  "ADELANTO",
      "ADCC", "ADELANTO",
      "ANG",  "ANGELES OAKS",
      "APP",  "APPLE VALLEY",
      "APPC", "APPLE VALLEY",
      "ARB",  "ARROWBEAR",
      "ARG",  "ARGUS",
      "BAK",  "BAKER",
      "BAR",  "BARSTOW",
      "BARC", "BARSTOW",
      "BBC",  "BIG BEAR",
      "BBL",  "BIG BEAR LAKE",
      "BBLC", "BIG BEAR LAKE",
      "BCR",  "BEAR CREEK/BIGBEAR",
      "BDM",  "BALDY MESA",
      "BFL",  "BARTON FLATS",
      "BGR",  "BIG RIVER",
      "BLD",  "MT BALDY",
      "BLK",  "BLACK MEADOW LANDING",
      "BLO",  "BLOOMINGTON",
      "BLU",  "BLUE JAY",
      "CAJ",  "CAJON PASS",
      "CDZ",  "CADIZ",
      "CED",  "CEDAR GLEN",
      "CHHC", "CHINO HILLS",
      "CHI",  "CHINO",
      "CHIC", "CHINO",
      "CHL",  "CHINA LAKE",
      "CMA",  "CIMA",
      "COL",  "COLTON",
      "COLC", "COLTON",
      "CPP",  "CEDAR PINES PARK",
      "CRA",  "CRAFTON",
      "CRL",  "CRESTLINE",
      "CRM",  "CRESTMORE",
      "CUD",  "CUDDEBACK LAKE",
      "DAG",  "DAGGETT",
      "DEV",  "DEVORE",
      "EDW",  "EDWARDS AFB",
      "ELM",  "EL MIRAGE",
      "ERP",  "EARP",
      "ESX",  "ESSEX",
      "FAW",  "FAWNSKIN",
      "FFL",  "FOREST FALLS",
      "FON",  "FONTANA",
      "FONC", "FONTANA",
      "FRE",  "FREDALBA/RUNNINGSPRINGS",
      "FTI",  "FORT IRWIN",
      "GRTC", "GRAND TERRACE",
      "GVL",  "GREEN VALLEY LAKE",
      "HAV",  "HAVASU",
      "HEL",  "HELENDALE",
      "HES",  "HESPERIA",
      "HESC", "HESPERIA",
      "HIGC", "HIGHLAND",
      "HNK",  "HINKLEY",
      "HOL",  "HOLCOMB VALLEY",
      "HRV",  "HARVARD",
      "IRN",  "IRON MOUNTAIN/RICE",
      "IVP",  "IVANPAH",
      "JNV",  "JOHNSON VALLEY",
      "JOT",  "JOSHUA TREE",
      "KEL",  "KELSO",
      "KRJ",  "KRAMER JUNCTION",
      "LAA",  "LAKE ARROWHEAD",
      "LAC",  "LA COUNTY",
      "LDR",  "LANDERS",
      "LEN",  "LENWOOD",
      "LOM",  "LOMA LINDA",
      "LOMC", "LOMA LINDA",
      "LUC",  "LUCERNE VALLEY",
      "LUD",  "LUDLOW",
      "LYC",  "LYTLE CREEK",
      "MEN",  "MENTONE",
      "MOR",  "MORONGO/YUCCAVALLEY",
      "MTC",  "MONTCLAIR",
      "MTCC", "MONTCLAIR",
      "MTH",  "MOUNTAIN HOMEVILLAGE",
      "MTP",  "MOUNTAIN PASS",
      "MUS",  "MUSCOY",
      "NBD",  "NEWBERRY SPRINGS",
      "NED",  "NEEDLES",
      "NEDC", "NEEDLES",
      "OKG",  "OAK GLEN",
      "ONTC", "ONTARIO",
      "ORO",  "ORO GRANDE",
      "PHL",  "PHELAN",
      "PIN",  "PINON HILLS",
      "PIO",  "PIONEERTOWN",
      "PKD",  "PARKER DAM",
      "RCC",  "RANCHO CUCAMONGA",
      "RCCC", "RANCHO CUCAMONGA",
      "RED",  "REDLANDS",
      "REDC", "REDLANDS",
      "RIA",  "RIALTO",
      "RIAC", "RIALTO",
      "RIC",  "RICE",
      "RID",  "RIDGECREST",
      "RIM",  "RIM FOREST",
      "RMT",  "RED MOUNTAIN",
      "RRK",  "RIMROCK",
      "RSP",  "RUNNING SPRINGS",
      "SAH",  "SAN ANTONIO HEIGHTS",
      "SBO",  "SAN BERNARDINO",
      "SBOC", "SAN BERNARDINO",
      "SIL",  "SILVERWOOD/HESPERIA",
      "SKY",  "SKY FOREST",
      "SUG",  "SUGARLOAF",
      "SVL",  "SPRING VALLEYLAKE/VICTORVILLE",
      "SVY",  "SEARLES VALLEY/TRONA",
      "TMD",  "MARINE CORP AIRGROUND COMBAT CENTER/29PALMS",
      "TNP",  "29 PALMS",
      "TNPC", "29 PALMS",
      "TPK",  "TWIN PEAKS",
      "TRN",  "TRONA",
      "UPDC", "UPLAND",
      "VDJ",  "VIDAL JUNCTION",
      "VDL",  "VIDAL",
      "VOE",  "VALLEY OF ENCHANTMENT/CRESTLINE",
      "VVC",  "VICTORVILLE ",
      "VVCC", "VICTORVILLE",
      "WON",  "WONDER VALLEY/29PALMS",
      "WWD",  "WRIGHTWOOD",
      "YER",  "YERMO",
      "YUC",  "YUCAIPA",
      "YUCC", "YUCAIPA",
      "YVY",  "YUCCA VALLEY",
      "YVYC", "YUCCA VALLEY"

  });
  
  private static final Properties TYPE_CODES = buildCodeTable(new String[]{
      "AB",        "Animal Bite",
      "ABD",       "Abdominal Pain",
      "ALL",       "Allergic Reaction",
      "ANML",      "Animal Bite - non-dangerous body area",
      "ANML-A1",   "Animal Bite - non-dangerous body area",
      "ANML-A3",   "Animal Bite - superficial bite",
      "ANML-B1",   "Animal Bite - poss dangerous body area",
      "ANML-B2",   "Animal Bite - hemorraging",
      "ANML-B3",   "Animal Bite - 3rd hand info",
      "ANML-D1",   "Animal Bite - unconscious",
      "ANML-D2",   "Animal Bite - pt not alert",
      "ANML-D4",   "Animal Bite - dangerous body area",
      "ANML-D7",   "Animal Bite - multiple animal attack",
      "AO",        "Aircraft Crash off Airport",
      "AP",        "Aircraft Crash on Airport",
      "APH",       "SCLA response: High",
      "APL",       "SCLA response: Low",
      "APM",       "SCLA response: Medium",
      "AS",        "Aircraft Standby",
      "ASLT",      "Assault",
      "AT",        "Ambulance Transport",
      "BACK",      "Back Pain",
      "BIRTH",     "Childbirth",
      "BP",        "Back Pain",
      "BT",        "Bomb Threat",
      "BURN",      "Burn Victim",
      "CA",        "Commercial Alarm",
      "CHOKE",     "Choking Victim",
      "CI",        "Commercial Investigation",
      "CO",        "Carbon Monoxide Alarm",
      "CP",        "Chest Pain",
      "CP-A1",     "Chest Pain norm. breathing",
      "CP-C1",     "Chest Pain abn. breathing",
      "CP-C2",     "Chest Pain cardiac Hx",
      "CP-C4",     "Chest Pain w/ reps >35",
      "CP-D1",     "Chest Pain pt not alert",
      "CP-D2",     "Chest Pain w/ diff speaking",
      "CP-D3",     "Chest Pain pt changing color",
      "CP-D4",     "Chest Pain skin clammy",
      "CPR",       "Cardiac Arrest",
      "CST",       "Create Strike Team",
      "CVA",       "Stroke Victim",
      "DIA",       "Diabetic Problem",
      "DRWN",      "Possible Drowning",
      "ELECT",     "Possible Electrocution",
      "ELEV",      "Elevator Rescue",
      "ELEV-MA",   "Elevator Rescue with injury",
      "ELEV-RQ",   "Elevator Rescue no injury",
      "EYE",       "Eye Problems",
      "FALL",      "Fall Victim",
      "FAR",       "Fire Alarm with Reset",
      "FC",        "Structure Fire: Commercial",
      "FD",        "Dumpster Fire",
      "FG",        "Vegetation Fire",
      "FH",        "Hay Fire",
      "FI",        "Improvement Fire",
      "FR",        "Refuse Fire",
      "FS",        "Structure Fire: Residential",
      "FT",        "Motorhome/Truck/Bus Fire",
      "FTF",       "Freeway Truck/Bus Fire",
      "FU",        "Unknown Type Fire",
      "FV",        "Vehicle Fire",
      "FVF",       "Veh Fire on Freeway",
      "FWI",       "Fireworks Investigation",
      "GAS",       "Ambulance Standby",
      "GAT",       "Alarm Testing",
      "GBP",       "Burn Permit",
      "GCC",       "County Comm Incident",
      "GEH",       "Env Health Incident",
      "GEM",       "Emergency Medical Incident",
      "GHZ",       "Hazardous Materials Incident",
      "GIT",       "IT Incident",
      "GLL",       "Loma Linda City Inc",
      "GMH",       "Medical Helicopter Incident",
      "GMI",       "Miscellaneous Gov Inc",
      "GMU",       "Out-of-System Mutual Aid",
      "GPH",       "Public Health Incident",
      "GRD",       "Road Department Inc",
      "GRF",       "Referral Incident",
      "GSW",       "Gunshot Wound",
      "HA",        "Headache",
      "HCE",       "Heat or Cold Exposure",
      "HEAD",      "Headache",
      "HEAD-A1",   "Headache - Breathing Normally",
      "HEAD-B1",   "Headache - Unknown status",
      "HEAD-C1",   "Headache - Not Alert",
      "HEAD-C2",   "Headache - Abnormal Breathing",
      "HEAD-C3",   "Headache - Speech Problems",
      "HEAD-C4",   "Headache - Sudden severe",
      "HEAD-C5",   "Headache - Numbness",
      "HEAD-C6",   "Headache - Paralysis",
      "HEAD-C7",   "Headache",
      "HEART",     "Heart problems",
      "HL",        "Hemorrhage/Laceration",
      "HP",        "Heart problems",
      "HZ",        "Hazardous Materials",
      "IN",        "Inside Investigation",
      "INH",       "Carbon Monoxide/Inh/Haz",
      "MA",        "Medical Aid",
      "MCI",       "Multi-Casualty Incident",
      "MOVUP",     "Moveup and Cover",
      "MU",        "Mutual Aid Requested",
      "NO-EMD",    "Medical problem",
      "OD",        "Overdose",
      "OE",        "Other Emergency",
      "OI",        "Outside Investigation",
      "PS",        "Public Service",
      "PSY",       "Psychiatric/Abn Behavior",
      "RA",        "Residential Alarm",
      "RQ",        "Rescue",
      "RR",        "Railcar Incident",
      "RS",        "Specialized Rescue",
      "SICK",      "Sick Person",
      "SOB",       "Shortness of Breath",
      "SP",        "Fuel Spill",
      "STAB",      "Stabbing",
      "STEMI",     "STEMI Transport",
      "SWTR",      "Swift Water Rescue",
      "SZ",        "Seizures",
      "TD",        "Tree Down",
      "TE",        "TC with Extrication",
      "TEF",       "Freeway TC w/Extrication",
      "TEST",      "Test Incident",
      "TF",        "TC with Fire",
      "TFF",       "Freeway TC w/Fire",
      "TFR",       "Tactical Fire Response",
      "TI",        "TC with Injuries",
      "TIF",       "Freeway TC w/Injuries",
      "TO",        "TC w Vehicle Over the Side",
      "TOF",       "Freeway TC Over the side",
      "TRAUMA",    "Traumatic Injuries",
      "TU",        "TC with Unknown Injuries",
      "TUF",       "Freeway TC Unk Injuries",
      "UNC",       "Unconscious Person",
      "UNKM",      "Unknown Medical Problem",
      "UNKM-B2",   "Medical Alarm Activation",
      "UNKM-B3",   "Unkn prob - 3rd hand caller",
      "UNKM-B4",   "Unkn prob - language barrier",
      "UNKM-D1",   "Unkn prob - life status questionable",
      "WS",        "Water Salvage",
      "ZAP",       "Outside Electrical Incident"
  });
}
