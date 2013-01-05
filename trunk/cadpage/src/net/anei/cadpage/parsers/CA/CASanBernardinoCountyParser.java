package net.anei.cadpage.parsers.CA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * San Bernardino County, CA
 */
public class CASanBernardinoCountyParser extends FieldProgramParser {
  
  public CASanBernardinoCountyParser() {
    super("SAN BERNARDINO COUNTY", "CA",
           "CALL! ADDR! LOC_INFO:PLACE AGN_MAP:MAP! X_ST:X! UNIT COMMENTS:INFO");
  }
  
  @Override
  public String getFilter() {
    return "cad@confire.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith("| ")) return false;
    body = body.substring(2).trim();
    return parseFields(body.split(">"), data);
  }
  
  private class MyCallField extends CallField {
    
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      String key = field;
      int pt = key.indexOf(' ');
      if (pt >= 0) key = field.substring(0,pt);
      String desc = TYPE_CODES.getProperty(key);
      if (desc == null) {
        pt = key.indexOf('-');
        if (pt >= 0) key = key.substring(0,pt);
        desc = TYPE_CODES.getProperty(key);
      }
      if (desc != null) field = field + " - " + desc;
      super.parse(field, data);
    }
  }
  
  private class MyAddressField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      data.strCity = convertCodes(p.getLast(' '), CITY_CODES);
      data.strApt = p.getLastOptional(" -");
      parseAddress(p.get(), data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT CITY";
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
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(",External");
      if (pt >= 0) field = field.substring(0,pt).trim();
      field = PRO_QA_PTN.matcher(field).replaceAll(" ");
      Matcher match = CODE_PTN.matcher(field);
      if (match.find()) {
        data.strCode = match.group(1);
        field = field.substring(0,match.start()) + " " + field.substring(match.end());
      }
      field = field.replaceAll("  +", " ").trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ABY", "AMBOY",
      "ADC", "ADELANTO",
      "ADCC", "ADELANTO",
      "ANG", "ANGELES OAKS",
      "APP", "APPLE VALLEY",
      "APPC", "APPLE VALLEY",
      "ARB", "ARROWBEAR",
      "ARG", "ARGUS",
      "BAK", "BAKER",
      "BAR", "BARSTOW",
      "BARC", "BARSTOW",
      "BBC", "BIG BEAR",
      "BBL", "BIG BEAR LAKE",
      "BBLC", "BIG BEAR LAKE",
      "BCR", "BEAR CREEK",
      "BDM", "BALDY MESA",
      "BFL", "BARTON FLATS",
      "BGR", "BIG RIVER",
      "BLD", "BALDY   ",
      "BLK", "BLACK MEADOW LANDING",
      "BLO", "BLOOMINGTON",
      "BLU", "BLUE JAY",
      "CAJ", "CAJON",
      "CDZ", "CADIZ",
      "CED", "CEDAR GLEN",
      "CHHC", "CHINO HILLS",
      "CHI", "CHINO",
      "CHIC", "CHINO",
      "CHL", "CHINA LAKE",
      "CMA", "CIMA",
      "COL", "COLTON",
      "COLC", "COLTON",
      "CPP", "CEDAR PINES PARK",
      "CRA", "CRAFTON",
      "CRL", "CRESTLINE",
      "CRM", "CRESTMORE",
      "CUD", "CUDDEBACK LAKE",
      "DAG", "DAGGETT",
      "DEV", "DEVORE",
      "EDW", "EDWARDS AFB",
      "ELM", "EL MIRAGE",
      "ERP", "EARP",
      "ESX", "ESSEX",
      "FAW", "FAWNSKIN",
      "FFL", "FOREST FALLS",
      "FON", "FONTANA",
      "FONC", "FONTANA",
      "FRE", "FREDALBA",
      "FTI", "FORT IRWIN",
      "GRTC", "GRAND TERRACE",
      "GVL", "GREEN VALLEY LAKE",
      "HAV", "HAVASU",
      "HEL", "HELENDALE",
      "HES", "HESPERIA",
      "HESC", "HESPERIA",
      "HIGC", "HIGHLAND",
      "HIGC", "HIGHLAND",
      "HNK", "HINKLEY",
      "HOL", "HOLCOMB VALLEY",
      "HRV", "HARVARD",
      "IRN", "IRON MOUNTAIN",
      "IVP", "IVANPAH",
      "JNV", "JOHNSON VALLEY",
      "JOT", "JOSHUA TREE",
      "KEL", "KELSO",
      "KRJ", "KRAMER JUNCTION",
      "LAA", "LAKE ARROWHEAD",
      "LAC", "LA COUNTY",
      "LDR", "LANDERS",
      "LEN", "LENWOOD",
      "LOM", "LOMA LINDA",
      "LOMC", "LOMA LINDA",
      "LUC", "LUCERNE VALLEY",
      "LUD", "LUDLOW",
      "LYC", "LYTLE CREEK",
      "MEN", "MENTONE",
      "MOR", "MORONGO",
      "MTCC", "MONTCLAIR",
      "MTCC", "MONTCLAIR",
      "MTH", "MOUNTAIN HOME VILLAGE",
      "MTP", "MOUNTAIN PASS",
      "MUS", "MUSCOY",
      "NBD", "NEBO",
      "NED", "NEEDLES",
      "NEDC", "NEEDLES",
      "OKG", "OAK GLEN",
      "ONTC", "ONTARIO",
      "ORO", "ORO GRANDE",
      "PHL", "PHELAN",
      "PIN", "PINON HILLS",
      "PIO", "PIONEER TOWN",
      "PKD", "PARKER DAM",
      "RCC", "RANCHO CUCAMONGA",
      "RCCC", "RANCHO CUCAMONGA",
      "RED", "REDLANDS",
      "REDC", "REDLANDS",
      "RIA", "RIALTO",
      "RIAC", "RIALTO",
      "RIC", "RICE",
      "RID", "RIDGECREST",
      "RIM", "RIM FOREST",
      "RMT", "RED MOUNTAIN",
      "RRK", "RIMROCK",
      "RSP", "RUNNING SPRINGS",
      "SAH", "SAN ANTONIO HEIGHTS",
      "SBO", "SAN BERNARDINO",
      "SBOC", "SAN BERNARDINO",
      "SIL", "SILVERWOOD",
      "SKY", "SKY FOREST",
      "SUG", "SUGARLOAF",
      "SVL", "SILVER LAKES",
      "SVY", "SPRING VALLEY LAKE",
      "TMD", "MARINE CORP AIR GROUND COMBAT CENTER",
      "TNP", "29 PALMS",
      "TNPC", "29 PALMS",
      "TPK", "TWIN PEAKS",
      "TRN", "TRONA",
      "UPDC", "UPLAND",
      "VDJ", "VIDAL JUNCTION",
      "VDL", "VIDAL",
      "VOE", "VALLEY OF ENCHANTMENT",
      "VVC", "VICTORVILLE ",
      "VVCC", "VICTORVILLE",
      "WON", "WONDER VALLEY",
      "WWD", "WRIGHTWOOD",
      "YER", "YERMO",
      "YUC", "YUCAIPA",
      "YUCC", "YUCAIPA",
      "YVY", "YUCCA VALLEY",
      "YVYC", "YUCCA VALLEY"
  });
  
  private static final Properties TYPE_CODES = buildCodeTable(new String[]{
      "AB", "Animal Bites",
      "ABD", "Abdominal Pain",
      "ALL", "Allergies",
      "AP", "Aircraft Crash on Airport",
      "APH", "VCV AP Crash High",
      "APL", "VCV AP Crash Low",
      "APM", "VCV AP Crash Medium",
      "AS", "Aircraft Standby",
      "ASLT", "Assault",
      "AT", "Ambulance Transport",
      "BIRTH", "Childbirth",
      "BP", "Back Pain",
      "BT", "Bomb Threat",
      "CI", "Commercial Investigation",
      "CO", "Carbon Monoxide Alarm",
      "CP", "Chest Pains",
      "CPR", "CPR in Progress",
      "CST", "Create Strike Team",
      "CVA", "Stroke",
      "DIA", "Diabetic Problem",
      "ELEV", "Elevator Problems",
      "EYE", "Eye Problems",
      "FALL", "Fall Victim",
      "FAR", "Fire Alarm with Reset",
      "FD", "Dumpster Fire",
      "FG", "Vegetation Fire",
      "FH", "Hay Fire",
      "FI", "Improvement Fire",
      "FR", "Refuse Fire",
      "FS", "Structure Fire- Non Comm",
      "FT", "Motorhome/Truck/Bus Fire",
      "FTF", "Frwy Truck/Bus Fire",
      "FU", "Unknown Type Fire",
      "FV", "Vehicle Fire",
      "FVF", "Frwy Vehicle Fire",
      "FWI", "Fireworks Investigation",
      "GAS", "Ambulance Standby",
      "GBP", "Burn Permit",
      "GCC", "County Comm Incident",
      "GEH", "Environmental Health Inc",
      "GEM", "Emergency Medical Inc",
      "GHZ", "Hazardous Materials Inc",
      "GIT", "IT Incident",
      "GLL", "Loma Linda City Inc",
      "GMH", "Medical Helicopter Inc",
      "GMI", "Miscellaneous Gov Inc",
      "GMU", "Out-of-System Mutual Aid",
      "GPH", "Public Health Incident",
      "GRD", "Road Department Inc",
      "GRF", "Referral Incident",
      "GSW", "Gunshot Wound",
      "GWX", "Weather Incident",
      "HA", "Headache",
      "HCE", "Heat/Cold Exposure",
      "HL", "Hemorrhage/Laceration",
      "HP", "Heart problems",
      "HZ", "Hazardous Materials",
      "IN", "Inside Investigation",
      "INH", "Carbon Monoxide/Inh/Haz",
      "MA", "Medical Aid",
      "MCI", "Multi-Casualty Incident",
      "MU", "Mutual Aid Requested",
      "OD", "Overdose",
      "OE", "Other Emergency",
      "OI", "Outside Investigation",
      "PS", "Public Service",
      "PSY", "Psychiatric/Abn Behavior",
      "RA", "Residential Alarm",
      "RQ", "Rescue",
      "RR", "Railcar Incident",
      "RS", "Specialized Rescue",
      "SICK", "Sick Person",
      "SOB", "Shortness of Breath",
      "SP", "Fuel Spill",
      "STAB", "Stabbing",
      "SWTR", "Swift Water Rescue",
      "SZ", "Seizures",
      "TD", "Tree Down",
      "TE", "TC with Extrication",
      "TEF", "Frwy TC w/Extrication",
      "TEST", "TEST INCIDENT",
      "TF", "TC with Fire",
      "TFF", "Frwy TC w/Fire",
      "TFR", "Tactical Fire Response",
      "TI", "TC with Injuries",
      "TIF", "Frwy TC w/Injuries",
      "TO", "TC w Vehicle Over Side",
      "TOF", "Frwy TC Over the side",
      "TRAUMA", "Traumatic Injuries",
      "TU", "TC with Unknown Injuries",
      "TUF", "Frwy TC Unk Injuries",
      "UNC", "Unconscious Person",
      "UNKM", "Unk Medical (Man Down)",
      "WS", "Water Salvage",
      "ZAP", "Outside Elec Incident"
  });
}
