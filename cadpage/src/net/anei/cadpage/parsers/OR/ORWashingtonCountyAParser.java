package net.anei.cadpage.parsers.OR;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Washington County, OR
 * Also Clackamas County
 */
public class ORWashingtonCountyAParser extends ORWashingtonCountyBaseParser {
  
  private static final Pattern BAD_SUBJECT_PTN = Pattern.compile("PW(\\d+)|VisiCAD Email");
  
  private static final Pattern RECALL_PTN = Pattern.compile("(RECALL):(.*) C\\*\\d{5}(?:CANCEL|RECALL)?(.*)");
  private static final Pattern RECALL_CITY_PTN = Pattern.compile("(.*),([A-Z]{3}) (.*)");
  
  private static final Pattern MASTER_PTN1 = Pattern.compile("([A-Z0-9]+) - ([-A-Z0-9]{2,4}) \\((.*?)\\) (.*?)#([A-Z]{2}\\d+)\\b[, ]*(.*)");

  private static final Pattern MASTER_PTN2 = Pattern.compile("([A-Z0-9]+) +\\*[A-Z] +(\\d\\d:\\d\\d:\\d\\d) (.*?)  Dt: ([^ ]+)  Zn: (\\d+)  Gd: ([^ ]+) (.*) /");
  
  private String version;

  public ORWashingtonCountyAParser() {
    this("WASHINGTON COUNTY", "OR");
  }
  
  public ORWashingtonCountyAParser(String defCity, String defState) {
    super(CITY_CODES, defCity, defState,
          "( SELECT/1 ADDR1/SC! MAP:MAP UNIT:UNIT! | " +
            "ADDRCITY SRC! ( MAP:MAP X2 | ) DASH? PLACE2 NAME2! )");
    setupCallList(CALL_LIST);
  }
  
  @Override
  public String getAliasCode() {
    return "ORWashingtonCountyA";
  }
  
  @Override
  public String getFilter() {
    return "930010,777,888,wccca@wccca.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    // Reject anything for ORWashingtonCountyB or ORWashingtonCountyC
    if (BAD_SUBJECT_PTN.matcher(subject).matches()) return false;
    
    // Special recall format
    Matcher match = RECALL_PTN.matcher(body);
    if (match.matches()) {
      setFieldList("CALL ADDR APT CITY UNIT");
      data.strCall = append(match.group(1), " - ", match.group(3).trim());
      body = match.group(2).trim();
      match = RECALL_CITY_PTN.matcher(body);
      if (match.matches()) {
        parseAddress(match.group(1).trim(), data);
        data.strCity = convertCodes(match.group(2), CITY_CODES);
        data.strUnit = match.group(3).trim();
      } else {
        parseAddress(StartType.START_ADDR, body, data);
        data.strUnit = getLeft();
      }
      return true;
    }
    
    // Another alternate format
    match = MASTER_PTN1.matcher(body);
    if (match.matches()) {
      version = "2";
      data.strUnit = match.group(1);
      data.strCode = match.group(2);
      data.strCall = match.group(3).trim();
      body = match.group(4);
      data.strCallId = match.group(5);
      data.strSupp = match.group(6);
      
      return parseFields(body.split("- ", -1), data);
    }
    
    // Yet another alternate format
    match = MASTER_PTN2.matcher(body);
    if (match.matches()) {
      setFieldList("CALL TIME ADDR APT MAP X");
      data.strCall = match.group(1);
      data.strTime = match.group(2);
      parseAddress(match.group(3).trim(), data);
      data.strMap = append(append(match.group(4), "-", match.group(5)), "-", match.group(6));
      data.strCross = match.group(7);
      return true;
    }

    version = "1";
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    String result = super.getProgram();
    if (version.equals("2")) result = "UNIT CODE CALL " + result + " ID INFO";
    return result;
  }
  
  @Override
  protected String getSelectValue() {
    return version;
  }

  @Override
  public Field getField(String name) {
    if (name.equals("ADDR1")) return new MyAddressField();
    if (name.equals("X2")) return new MyCross2Field();
    if (name.equals("DASH")) return new SkipField("-", true);
    if (name.equals("PLACE2")) return new MyPlace2Field();
    if (name.equals("NAME2")) return new MyName2Field();
    return super.getField(name);
  }

  private static final Pattern DIR_OF_SLASH_PTN = Pattern.compile("\\b([NSEW] *OF) */ *");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Parser p = new Parser(field);
      String addr;
      String city = p.getLastOptional(')');
      if (city.length() > 0) {
        addr = p.get('(');
        data.strCross = p.get();
      } else {
        city = p.getLast(' ');
        addr = p.get();
      }
      addr = DIR_OF_SLASH_PTN.matcher(addr).replaceAll("$1 ").trim();
      parseAddress(StartType.START_CALL, FLAG_ANCHOR_END, addr, data);
      data.strCity = convertCodes(city, CITY_CODES);
      
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " X CITY";
    }
  }
  
  private class MyCross2Field extends CrossField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() == 0) return;
      if (!field.startsWith("btwn ")) abort();
      super.parse(field.substring(4).trim(), data);
    }
  }
  
  private static final Pattern PLACE_CITY_PTN = Pattern.compile("(.*), *[A-Z]{3}");
  private class MyPlace2Field extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = PLACE_CITY_PTN.matcher(field);
      if (match.matches()) field = match.group(1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyName2Field extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = cleanWirelessCarrier(field, true);
      if (checkPlace(field)) {
        data.strPlace = append(data.strPlace, " - ", field);
      } else {
        data.strName = field;
      }
    }
  }
  
  private final static CodeSet CALL_LIST = new CodeSet(
      "ABDOMINAL PAIN",
      "ABDOMINL PAIN C1",
      "AIR ALERT2:TASK",
      "ALARM,AUDIBLE",
      "ALARM,OTHER",
      "ALLERGIC REACTIO",
      "ANIMAL COMPLAINT",
      "ARREST/CUSTODY",
      "ASSAULT",
      "ASSIST OUTSIDE AGENCY",
      "ASSIST PUBLIC",
      "ASSLT/RAPE/STAB",
      "ATTEMPT WARRANT",
      "BACK PAIN",
      "BACK PAIN C1",
      "BARKDUST FIRE",
      "BARN FIRE",
      "BLEEDING PROBLEM",
      "BREATHING PROB.",
      "BREATHING PROB",
      "BRUSH FIRE",
      "BURN COMPLAINT",
      "CAD TO CAD",
      "CARDIAC ARREST",
      "CARD/RESP ARREST",
      "CAR FIRE",
      "CHEST PAIN",
      "CHEST PAIN/HEART",
      "CHK EXTINGUISHED",
      "CHOKING",
      "CIVIL",
      "COMMERCIAL FIRE",
      "COMMERCIAL FIRE ALARM",
      "CONVULSION/SEIZU",
      "CRIMINAL MISCHIEF",
      "DEATH INVESTIGATION",
      "DETECTOR PROBLEM",
      "DIABETIC",
      "DIABETIC PROBLEM",
      "DISTURBANCE",
      "DIZZY/VERTIGO",
      "DOMESTIC DISTURBANCE",
      "ELECTRICAL FIRE",
      "EXTRA PATROL REQUEST",
      "F/A, ALL OTHER",
      "FALL",
      "FALL-BRAVO RESPONSE",
      "FALL C1",
      "FIRE ALARM, COMM",
      "FIRE ALARM, RESD",
      "FIRE ALARM,RESID",
      "FIRE INFORMATION",
      "FIRE, SINGLE ENGINE",
      "FIRE/STRUCTURE",
      "FIREWORKS",
      "FOLLOW UP CONTACT",
      "FRAUD",
      "GRASS FIRE",
      "HARASSMENT",
      "HAZARD",
      "HEADACHE C1",
      "HEART PROBLEMS",
      "HEAT EXPOSURE",
      "HIT AND RUN,NON INJURY",
      "INCOMPLETE 911",
      "INVALID ASSIST",
      "JUVENILE PROBLEM",
      "LANDING ZONE",
      "LIFT ASSIST",
      "LOCKOUT",
      "MEDICAL ALARM",
      "MEDICAL-DETAILS TO FOLLOW",
      "MENTAL/PSYCH",
      "MISCELLANEOUS",
      "MISC FIRE",
      "MISC NO FIRE",
      "MISSING PERSON",
      "MOVEUP",
      "MR1",
      "MR2",
      "MUTUAL AID",
      "MVA-INJURY ACCID",
      "MVA-UKN INJURY",
      "MVA-UNK INJURY",
      "MVA/UNKNOWN INJ",
      "NOISE COMPLAINT",
      "ODOR INVESTIGATE",
      "ORDINANCE VIOLATION",
      "OVERDOSE/POISON",
      "PARKING COMPLAINT",
      "POLE FIRE",
      "PREGNANCY/BIRTH",
      "PRE NOTIFICATION",
      "PROPERTY INVESTIGATION",
      "PSYCHIATRIC",
      "PUBLIC ASSIST",
      "RECALL",
      "RECALL - FALSE ALARM",
      "REQUEST FOR K-9 UNIT",
      "RESIDENTIAL FIRE",
      "RESIDENTIAL FIRE ALARM",
      "RFIRE",
      "SEIZURES",
      "SHOOTING",
      "SICK PERSON",
      "SICK PERSON C1",
      "SICK PERSON/UNKO",
      "SMOKE INVESTIGAT",
      "SPILL, FUEL/UNK",
      "STROKE",
      "SUBJECT STOP",
      "SUICIDE ATTEMPT",
      "SUSPICIOUS PERSON",
      "SUSPICIOUS VEHICLE",
      "SUSPICIOUS VEHICLE GONE",
      "TAI-HIGH MECHANI",
      "TAU",
      "*TEST ONLY",
      "THEFT",
      "THEFT, JUST OCCURRED",
      "TRAFFIC COMPLAINT",
      "TRAFFIC STOP",
      "TRANSFER/INTERFA",
      "TRAUMA",
      "TRAUMA C1",
      "TRAUMATIC INJURY",
      "TREE FIRE",
      "TRF ACC, INJURY",
      "TRF ACC, NON-INJ",
      "TRF ACC, UNK INJ",
      "TRUCK FIRE",
      "UNCONCIOUS/FAINT",
      "UNCON/FAINTING",
      "UNCONSC/FAINTING",
      "UNCONS/UNRESPONS",
      "UNKNOWN TYP FIRE",
      "UNK PROB/MN DOWN",
      "UNWANTED",
      "VEHICLE FIRE",
      "VIOLATION OF RESTRAINING ORDER",
      "WATER PROBLEM",
      "WELFARE CHECK",
      "WIRES DOWN"
  ); 
  
  static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALO", "ALOHA",
      "AMI", "AMITY",
      "ARI", "ARIEL",
      "AUM", "AUMSVILLE",
      "AUR", "AURORA",
      "BAN", "BANKS",
      "BEA", "BEAVERCREEK",
      "BIN", "BINGEN",
      "BOR", "BORING",
      "BRI", "BRIGHTWOOD",
      "BRV", "BRIDAL VEIL",
      "BTN", "BEAVERTON",
      "BUX", "BUXTON",
      "CAN", "CANBY",
      "CAR", "CARLTON",
      "CAS", "CASCADE LOCKS",
      "CLA", "CLACKAMAS",
      "COL", "COLTON",
      "CON", "CORNELIUS",
      "COR", "CORBET",
      "DAL", "DALLESPORT",
      "DAM", "DAMASCUS",
      "DAY", "DAYTON",
      "DET", "DETROIT",
      "DUF", "DUFUR",
      "DUN", "DUNDEE",
      "EAG", "EAGLE CREEK",
      "EST", "ESTACADA",
      "FAI", "FAIRVIEW",
      "FOR", "FOREST GROVE",
      "GAL", "GALES CREEK",
      "GAS", "GASTON",
      "GAT", "GATES",
      "GER", "GERVAIS",
      "GLA", "GLADSTONE",
      "GOV", "GOVERNMENT CAMP",
      "GRE", "GRESHAM",
      "HAP", "HAPPY VALLEY",
      "HIL", "HILLSBORO",
      "HOO", "HOOD RIVER",
      "HUB", "HUBBARD",
      "IDA", "IDANHA",
      "IND", "INDEPENDENCE",
      "JEF", "JEFFERSON",
      "KEI", "KEIZER",
      "LAF", "LAFAYETTE",
      "LAK", "LAKE OSWEGO",
      "LYL", "LYLE",
      "LYO", "LYONS",
      "MAN", "MANNING",
      "MAR", "MARYLHURST",
      "MAU", "MAUPIN",
      "MCM", "MCMINNVILLE",
      "MCY", "MILL CITY",
      "MIL", "MILWAUKIE",
      "MOL", "MOLALLA",
      "MOS", "MOSIER",
      "MOU", "MOUNT ANGEL",
      "MTH", "MT HOOD PARKDALE",
      "MUL", "MULINO",
      "NEW", "NEWBERG",
      "NOR", "NORTH PLAINS",
      "ODE", "ODELL",
      "ORE", "OREGON CITY",
      "OC" , "OREGON CITY",
      "ORI", "ORIENT",
      "POR", "PORTLAND",
      "RHO", "RHODODENDRON",
      "RIC", "RICKREALL",
      "RID", "RIDGEFIELD",
      "SAL", "SALEM",
      "SAN", "SANDY",
      "SCA", "SCAPPOOSE",
      "SCO", "SCOTTS MILLS",
      "SDN", "SHERIDAN",
      "SEA", "SEASIDE",
      "SHE", "SHERWOOD",
      "SIL", "SILVERTON",
      "STA", "STAYTON",
      "STE", "STEVENSON",
      "STP", "SAINT PAUL",
      "SUB", "SUBLIMITY",
      "THE", "THE DALLES",
      "TIG", "TIGARD",
      "TIM", "TIMBER",
      "TRO", "TROUTDALE",
      "TUA", "TUALATIN",
      "TUR", "TURNER",
      "TYG", "TYGH VALLEY",
      "UND", "UNDERWOOD",
      "USF", "US FOREST SVC",
      "VAN", "VANCOUVER",
      "VER", "VERNONIA",
      "WAR", "WARM SPRINGS",
      "WEL", "WELCHES",
      "WES", "WEST LINN",
      "WHI", "WHITE SALMON",
      "WIL", "WILSONVILLE",
      "WOO", "WOODBURN",
      "YAM", "YAMHILL",
      "RVR", "RIVER FEATURES"
  });
}
