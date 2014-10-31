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
      "ABD-A1",    "Abdominal Pain",
      "ABD-C1",    "Abdominal Pain",
      "ABD-C2",    "Abdominal Pain",
      "ABD-C3",    "Abdominal Pain",
      "ABD-C4",    "Abdominal Pain",
      "ABD-C5",    "Abdominal Pain",
      "ABD-C6",    "Abdominal Pain",
      "ABD-D1",    "Abdominal Pain",
      "ALL",       "Allergic Reaction",
      "ALL-A1",    "Allergic Reaction",
      "ALL-A2",    "Allergic Reaction",
      "ALL-B1",    "Allergic Reaction",
      "ALL-C1",    "Allergic Reaction",
      "ALL-C2",    "Allergic Reaction",
      "ALL-D1",    "Allergic Reaction",
      "ALL-D2",    "Allergic Reaction",
      "ALL-D3",    "Allergic Reaction",
      "ALL-D4",    "Allergic Reaction",
      "ALL-E1",    "Allergic Reaction",
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
      "ASLT-A1",   "Assault-non dangerous body area",
      "ASLT-B1",   "Assault-poss dangerous body area",
      "ASLT-B2",   "Assault-serious hemorrhage",
      "ASLT-B3",   "Assault-3rd hand info",
      "ASLT-D1",   "Assault-unconscious or cardiac arrest",
      "ASLT-D2",   "Assault-not alert",
      "ASLT-D3",   "Assault-chest or neck injury",
      "ASLT-D4",   "Assault-multiple victims",
      "AT",        "Ambulance Transport",
      "AT-A1",     "Ambulance Transport",
      "AT-A2",     "Ambulance Transport",
      "AT-A3",     "Ambulance Transport",
      "AT-C1",     "Ambulance Transport",
      "AT-C3",     "Ambulance Transport",
      "AT-C4",     "Ambulance Transport",
      "AT-C5",     "Ambulance Transport",
      "AT-C6",     "Ambulance Transport",
      "AT-D1",     "Ambulance Transport",
      "AT-D2",     "Ambulance Transport",
      "BACK-A1",   "Back Pain",
      "BACK-A2",   "Back Pain",
      "BACK-C1",   "Back Pain",
      "BACK-C2",   "Back Pain",
      "BACK-C3",   "Back Pain",
      "BACK-D1",   "Back Pain",
      "BIRTH",     "Childbirth",
      "BIRTH-A1",  "Childbirth",
      "BIRTH-B1",  "Childbirth",
      "BIRTH-B2",  "Childbirth",
      "BIRTH-C1",  "Childbirth",
      "BIRTH-C2",  "Childbirth",
      "BIRTH-C3",  "Childbirth",
      "BIRTH-D1",  "Childbirth",
      "BIRTH-D2",  "Childbirth",
      "BIRTH-D3",  "Childbirth",
      "BIRTH-D4",  "Childbirth",
      "BIRTH-D5",  "Childbirth",
      "BIRTH-D6",  "Childbirth",
      "BIRTH-D7",  "Childbirth",
      "BIRTH-O1",  "Childbirth",
      "BT",        "Bomb Threat",
      "BURN",      "Burn Victim",
      "BURN-A1",   "Burn Victim",
      "BURN-A2",   "Burn Victim",
      "BURN-A3",   "Burn Victim",
      "BURN-B1",   "Burn Victim",
      "BURN-B2",   "Burn Victim",
      "BURN-C1",   "Burn Victim",
      "BURN-C2",   "Burn Victim",
      "BURN-C3",   "Burn Victim",
      "BURN-C4",   "Burn Victim",
      "BURN-D1",   "Burn Victim",
      "BURN-D2",   "Burn Victim",
      "BURN-D3",   "Burn Victim",
      "BURN-D4",   "Burn Victim",
      "CA",        "Commercial Alarm",
      "CHOKE",     "Choking Victim",
      "CHOKE-A1",  "Choking Victim",
      "CHOKE-D1",  "Choking Victim",
      "CHOKE-D2",  "Choking Victim",
      "CHOKE-E1",  "Choking Victim",
      "CI",        "Commercial Investigation",
      "CO",        "Carbon Monoxide Alarm",
      "CP",        "Chest Pain",
      "CP-A1",     "Chest Pain norm. breathing",
      "CP-C1",     "Chest Pain abn. breathing",
      "CP-C2",     "Chest Pain cardiac Hx",
      "CP-C3",     "Chest Pain-Cocaine Involved",
      "CP-C4",     "Chest Pain w/ reps >35",
      "CP-D1",     "Chest Pain pt not alert",
      "CP-D2",     "Chest Pain w/ diff speaking",
      "CP-D3",     "Chest Pain pt changing color",
      "CP-D4",     "Chest Pain skin clammy",
      "CPR",       "Cardiac Arrest",
      "CPR-B1",    "Cardiac Arrest",
      "CPR-D1",    "Cardiac Arrest",
      "CPR-D2",    "Cardiac Arrest",
      "CPR-E1",    "Cardiac Arrest",
      "CPR-E2",    "Cardiac Arrest",
      "CPR-E3",    "Cardiac Arrest",
      "CPR-E4",    "Cardiac Arrest",
      "CPR-E5",    "Cardiac Arrest",
      "CPR-E6",    "Cardiac Arrest",
      "CPR-O1",    "Cardiac Arrest",
      "CVA",       "Stroke Victim",
      "CVA-A1",    "Stroke Victim",
      "CVA-B1",    "Stroke Victim",
      "CVA-C1",    "Stroke Victim",
      "CVA-C2",    "Stroke Victim",
      "CVA-C3",    "Stroke Victim",
      "CVA-C4",    "Stroke Victim",
      "CVA-C5",    "Stroke Victim",
      "CVA-C6",    "Stroke Victim",
      "CVA-C7",    "Stroke Victim",
      "CVA-C8",    "Stroke Victim",
      "DIA",       "Diabetic Problem",
      "DIA-A1",    "Diabetic Problem",
      "DIA-C1",    "Diabetic Problem",
      "DIA-C2",    "Diabetic Problem",
      "DIA-C3",    "Diabetic Problem",
      "DIA-D1",    "Diabetic Problem",
      "DRWN",      "Possible Drowning",
      "DRWN-A1",   "Possible Drowning",
      "DRWN-B1",   "Possible Drowning",
      "DRWN-B2",   "Possible Drowning",
      "DRWN-C1",   "Possible Drowning",
      "DRWN-D1",   "Possible Drowning",
      "DRWN-D2",   "Possible Drowning",
      "DRWN-D3",   "Possible Drowning",
      "DRWN-D4",   "Possible Drowning",
      "ELECT-C1",  "Possible Electrocution",
      "ELECT-D1",  "Possible Electrocution",
      "ELECT-D2",  "Possible Electrocution",
      "ELECT-D3",  "Possible Electrocution",
      "ELECT-D4",  "Possible Electrocution",
      "ELECT-D5",  "Possible Electrocution",
      "ELECT-D6",  "Possible Electrocution",
      "ELECT-D7",  "Possible Electrocution",
      "ELECT-D8",  "Possible Electrocution",
      "ELECT-E1",  "Possible Electrocution",
      "ELEV-MA",   "Elevator Rescue with injury",
      "ELEV-RQ",   "Elevator Rescue no injury",
      "EYE",       "Eye Problems",
      "EYE-A1",    "Eye Problems",
      "EYE-A2",    "Eye Problems",
      "EYE-A3",    "Eye Problems",
      "EYE-B1",    "Eye Problems",
      "EYE-D1",    "Eye Problems",
      "FALL",      "Fall Victim",
      "FALL-A1",   "Fall Victim",
      "FALL-A2",   "Fall Victim",
      "FALL-A3",   "Fall Victim",
      "FALL-B1",   "Fall Victim",
      "FALL-B2",   "Fall Victim",
      "FALL-B3",   "Fall Victim",
      "FALL-D1",   "Fall Victim",
      "FALL-D2",   "Fall Victim",
      "FALL-D3",   "Fall Victim",
      "FALL-D4",   "Fall Victim",
      "FALL-D5",   "Fall Victim",
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
      "GMH",       "Medical Helicopter Incident",
      "GMI",       "Miscellaneous Incident",
      "GMU",       "Out-of-System Mutual Aid",
      "GPH",       "Public Health Incident",
      "GSW",       "Gunshot Wound",
      "GSW-A1",    "Gunshot Wound",
      "GSW-B1",    "Gunshot Wound",
      "GSW-B2",    "Gunshot Wound",
      "GSW-B3",    "Gunshot Wound",
      "GSW-B4",    "Gunshot Wound",
      "GSW-B5",    "Gunshot Wound",
      "GSW-D1",    "Gunshot Wound",
      "GSW-D2",    "Gunshot Wound",
      "GSW-D3",    "Gunshot Wound",
      "GSW-D4",    "Gunshot Wound",
      "GSW-D5",    "Gunshot Wound",
      "HA",        "Headache",
      "HCE",       "Heat or Cold Exposure",
      "HCE-A1",    "Heat or Cold Exposure",
      "HCE-B1",    "Heat or Cold Exposure",
      "HCE-B2",    "Heat or Cold Exposure",
      "HCE-C1",    "Heat or Cold Exposure",
      "HCE-D1",    "Heat or Cold Exposure",
      "HCE-D2",    "Heat or Cold Exposure",
      "HEAD-A1",   "Headache - Breathing Normally",
      "HEAD-B1",   "Headache - Unknown status",
      "HEAD-C1",   "Headache - Not Alert",
      "HEAD-C2",   "Headache - Abnormal Breathing",
      "HEAD-C3",   "Headache - Speech Problems",
      "HEAD-C4",   "Headache - Sudden severe",
      "HEAD-C5",   "Headache - Numbness",
      "HEAD-C6",   "Headache - Paralysis",
      "HEAD-C7",   "Headache",
      "HEART-A1",  "Heart problems",
      "HEART-A2",  "Heart problems",
      "HEART-C1",  "Heart problems",
      "HEART-C2",  "Heart problems",
      "HEART-C3",  "Heart problems",
      "HEART-C4",  "Heart problems",
      "HEART-C5",  "Heart problems",
      "HEART-C6",  "Heart problems",
      "HEART-C7",  "Heart problems",
      "HEART-D1",  "Heart problems",
      "HEART-D2",  "Heart problems",
      "HEART-D3",  "Heart problems",
      "HEART-D4",  "Heart problems",
      "HEART-D5",  "Heart problems",
      "HL",        "Hemorrhage/Laceration",
      "HL-A1",     "Hemorrhage/Laceration",
      "HL-A2",     "Hemorrhage/Laceration",
      "HL-B1",     "Hemorrhage/Laceration",
      "HL-B2",     "Hemorrhage/Laceration",
      "HL-B3",     "Hemorrhage/Laceration",
      "HL-B4",     "Hemorrhage/Laceration",
      "HL-C1",     "Hemorrhage/Laceration",
      "HL-C2",     "Hemorrhage/Laceration",
      "HL-D1",     "Hemorrhage/Laceration",
      "HL-D2",     "Hemorrhage/Laceration",
      "HL-D3",     "Hemorrhage/Laceration",
      "HL-D4",     "Hemorrhage/Laceration",
      "HP",        "Heart problems",
      "HZ",        "Hazardous Materials",
      "IN",        "Inside Investigation",
      "INH",       "Carbon Monoxide/Inh/Haz",
      "INH-B1",    "Carbon Monoxide/Inh/Haz",
      "INH-C1",    "Carbon Monoxide/Inh/Haz",
      "INH-D1",    "Carbon Monoxide/Inh/Haz",
      "INH-D2",    "Carbon Monoxide/Inh/Haz",
      "INH-D3",    "Carbon Monoxide/Inh/Haz",
      "INH-D4",    "Carbon Monoxide/Inh/Haz",
      "INH-D5",    "Carbon Monoxide/Inh/Haz",
      "INH-O1",    "Carbon Monoxide/Inh/Haz",
      "MA",        "Medical Aid",
      "MCI",       "Multi-Casualty Incident",
      "MOVUP",     "Moveup and Cover",
      "MU",        "Mutual Aid Requested",
      "NO-EMD",    "Medical problem",
      "OD",        "Overdose",
      "OD-B1",     "Overdose",
      "OD-C1",     "Overdose",
      "OD-C2",     "Overdose",
      "OD-C3",     "Overdose",
      "OD-C4",     "Overdose",
      "OD-C5",     "Overdose",
      "OD-C6",     "Overdose",
      "OD-C7",     "Overdose",
      "OD-C8",     "Overdose",
      "OD-D1",     "Overdose",
      "OD-D2",     "Overdose",
      "OD-O1",     "Overdose",
      "OE",        "Other Emergency",
      "OI",        "Outside Investigation",
      "PS",        "Public Service",
      "PSY",       "Psychiatric/Abn Behavior",
      "PSY-A1",    "Psychiatric/Abn Behavior",
      "PSY-A2",    "Psychiatric/Abn Behavior",
      "PSY-B1",    "Psychiatric/Abn Behavior",
      "PSY-B2",    "Psychiatric/Abn Behavior",
      "PSY-B3",    "Psychiatric/Abn Behavior",
      "PSY-B4",    "Psychiatric/Abn Behavior",
      "PSY-B5",    "Psychiatric/Abn Behavior",
      "PSY-B6",    "Psychiatric/Abn Behavior",
      "PSY-D1",    "Psychiatric/Abn Behavior",
      "PSY-D2",    "Psychiatric/Abn Behavior",
      "RA",        "Residential Alarm",
      "RQ",        "Rescue",
      "RQ-A1",     "Rescue",
      "RQ-B1",     "Rescue",
      "RQ-B2",     "Rescue",
      "RQ-B3",     "Rescue",
      "RQ-D1",     "Rescue",
      "RQ-D2",     "Rescue",
      "RQ-D3",     "Rescue",
      "RQ-D4",     "Rescue",
      "RQ-D5",     "Rescue",
      "RQ-D6",     "Rescue",
      "RR",        "Railcar Incident",
      "RS",        "Specialized Rescue",
      "SICK",      "Sick Person",
      "SICK-A1",   "Sick Person",
      "SICK-A2",   "Sick Person",
      "SICK-B1",   "Sick Person",
      "SICK-C1",   "Sick Person",
      "SICK-C2",   "Sick Person",
      "SICK-C3",   "Sick Person",
      "SICK-D1",   "Sick Person",
      "SICK-O1",   "Sick Person",
      "SICK-O2",   "Sick Person",
      "SOB",       "Shortness of Breath",
      "SOB-C1",    "Shortness of Breath",
      "SOB-D1",    "Shortness of Breath",
      "SOB-D2",    "Shortness of Breath",
      "SOB-D3",    "Shortness of Breath",
      "SOB-D4",    "Shortness of Breath",
      "SOB-E1",    "Shortness of Breath",
      "SP",        "Fuel Spill",
      "STAB",      "Stabbing",
      "STAB-A1",   "Stabbing",
      "STAB-B1",   "Stabbing",
      "STAB-B2",   "Stabbing",
      "STAB-B3",   "Stabbing",
      "STAB-B4",   "Stabbing",
      "STAB-B5",   "Stabbing",
      "STAB-D1",   "Stabbing",
      "STAB-D2",   "Stabbing",
      "STAB-D3",   "Stabbing",
      "STAB-D4",   "Stabbing",
      "STAB-D5",   "Stabbing",
      "STEMI",     "STEMI Transport",
      "SWTR",      "Swift Water Rescue",
      "SZ",        "Seizures",
      "SZ-A1",     "Seizures",
      "SZ-A2",     "Seizures",
      "SZ-A3",     "Seizures",
      "SZ-B1",     "Seizures",
      "SZ-C1",     "Seizures",
      "SZ-C2",     "Seizures",
      "SZ-C3",     "Seizures",
      "SZ-D1",     "Seizures",
      "SZ-D2",     "Seizures",
      "SZ-D3",     "Seizures",
      "SZ-D4",     "Seizures",
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
      "TRAUMA-A1", "Traumatic Injuries",
      "TRAUMA-A2", "Traumatic Injuries",
      "TRAUMA-B1", "Traumatic Injuries",
      "TRAUMA-B2", "Traumatic Injuries",
      "TRAUMA-D1", "Traumatic Injuries",
      "TRAUMA-D2", "Traumatic Injuries",
      "TRAUMA-D3", "Traumatic Injuries",
      "TU",        "TC with Unknown Injuries",
      "TUF",       "Freeway TC Unk Injuries",
      "UNC",       "Unconscious Person",
      "UNC-A1",    "Unconscious Person",
      "UNC-A2",    "Unconscious Person",
      "UNC-A3",    "Unconscious Person",
      "UNC-C1",    "Unconscious Person",
      "UNC-C2",    "Unconscious Person",
      "UNC-C3",    "Unconscious Person",
      "UNC-D1",    "Unconscious Person",
      "UNC-D2",    "Unconscious Person",
      "UNC-D3",    "Unconscious Person",
      "UNC-D4",    "Unconscious Person",
      "UNC-E1",    "Unconscious Person",
      "UNKM",      "Unknown Medical Problem",
      "UNKM-B1",   "Unknown Medical Problem",
      "UNKM-B2",   "Medical Alarm Activation",
      "UNKM-B3",   "Unkn prob - 3rd hand caller",
      "UNKM-B4",   "Unkn prob - language barrier",
      "UNKM-D1",   "Unkn prob - life status questionable",
      "WS",        "Water Salvage",
      "ZAP",       "Outside Electrical Incident"

  });
}
