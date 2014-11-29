package net.anei.cadpage.parsers.OH;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class OHHamiltonCountyParser extends SmartAddressParser {
 
  public OHHamiltonCountyParser() {
    super(CITY_CODES, "HAMILTON COUNTY", "OH");
    setFieldList("ADDR CITY ST APT PLACE CALL INFO TIME UNIT X");
    setupDoctorNames("FELDMAN", "KATIE");
    setupMultiWordStreets(
        "ALTA VISTA",
        "ANDERSON FERRY",
        "ASBURY HILLS",
        "ASHLEY VIEW",
        "ASPEN POINT",
        "ASTON OAKS",
        "BAYLEY PLACE",
        "BERKSHIRE CLUB",
        "BLUE ASH",
        "BLUE ROCK",
        "BRANCH HILL",
        "BRANCH HILL GUINEA",
        "BREEZY VISTA",
        "BRIERLY CREEK",
        "BUNKER HILL",
        "CARVER WOODS",
        "CHESTNUT PARK",
        "CHESTNUT RIDGE",
        "CINCINNATI MILLS",
        "CLEVES WARSAW",
        "COMPTON RIDGE",
        "CONCORD WOODS",
        "CORNELL PARK",
        "COUNT FLEET",
        "COUNTRY VIEW",
        "COUNTRY WOODS",
        "CROSSING AT PARK",
        "CURLY MAPLE",
        "DARK STAR",
        "DE ARMAND",
        "DEER CHASE",
        "DEER PARK",
        "DEERVIEW WOODS",
        "DRY FORK",
        "DRY RIDGE",
        "DUGAN GAP",
        "EAGLE RIDGE",
        "EAGLES LAKE",
        "EAST MIAMI RIVER",
        "EAST WILLOW",
        "EIGHT MILE",
        "EMERALD GLADE",
        "FIDDLERS GREEN",
        "FIELDS ERTEL",
        "FIVE MILE",
        "FOREST VIEW",
        "FORFEIT RUN",
        "FOUR MILE",
        "FOUR WORLDS",
        "FOX CHASE",
        "FOX CUB",
        "FOX RIDGE",
        "FOX RUN",
        "GALBRAITH POINTE",
        "GLEN EAGLE",
        "GLENDALE MILFORD",
        "GOOD SAMARITAN",
        "GRAND OAKS",
        "GREEN ACRES",
        "HAMILTON CLEVES",
        "HARBOR RIDGE",
        "HARRISON BROOKVILLE",
        "HERITAGE LAKE",
        "HERITAGE SQUARE",
        "HICKORY FLATS",
        "HICKORY TRAIL",
        "HIDDEN MEADOWS",
        "INDIAN HILL",
        "INDIAN TRACE",
        "INDIAN VIEW",
        "IVY HILLS",
        "JAKE SWEENEY",
        "JAMISON CREEK",
        "JOHN GRAY",
        "KATIES GREEN",
        "KEMPER MEADOW",
        "KUGLER MILL",
        "LA BOITEAUX",
        "LAKE FOREST",
        "LEES CROSSING",
        "LITTLE CREEK",
        "MADEIRA HILLS",
        "MALLARD COVE",
        "MAPLE KNOLL TERRACE",
        "MAR DEL",
        "MERRITT GROVE",
        "MIAMI BLUFF",
        "MICHAEL ANTHONY",
        "MILLVILLE SHANDON",
        "MT ALVERNO",
        "MT CARMEL",
        "MT HOPE",
        "MT NEBO",
        "MUDDY CREEK",
        "NORTH BEND",
        "NORTH COMMERCE PARK",
        "NORTH HILL",
        "OLDE GATE",
        "PADDYS RUN",
        "PINE MEADOW",
        "PLEASANT RUN",
        "RAINBOW HILL",
        "RAPID RUN",
        "RED BANK",
        "RED BIRD",
        "REED HARTMAN",
        "REGENCY RUN",
        "RIVER CREST",
        "RIVER WALK",
        "RONALD REAGAN",
        "ROSE PETAL",
        "ROUND BOTTOM",
        "ROUND TOP",
        "ROWAN HILL",
        "ROYAL GLEN",
        "SAND RUN",
        "SCHOOL SECTION",
        "SHAKER POINT",
        "SHARON PARK",
        "SHAWNEE RUN",
        "SHEPHERD CREEK",
        "SIGNAL HILL",
        "SIGNAL POINTE",
        "SOUTH EAGLESNEST",
        "SOUTH MILFORD",
        "SOUTH TERRACE",
        "SOUTH WHETZEL",
        "SPDL BLUE ROCK",
        "SPOOKY HOLLOW",
        "SPRING HILL",
        "SPY GLASS",
        "ST ANDREWS",
        "ST CLAIR",
        "ST CLOUD",
        "ST JOHNS",
        "ST REGIS",
        "STONE BARN",
        "STONE RIDGE",
        "STONEY CULVERT",
        "SUSPENSION BRIDGE",
        "SUTTERS MILL",
        "SYCAMORE GROVE",
        "THREE RIVERS",
        "TIMBER RIDGE",
        "TIMBER TOP",
        "TOWNE COMMONS",
        "TREE HEIGHTS",
        "TRI COUNTY",
        "TURF WOOD",
        "UNION CENTRE",
        "VALLEY RIDGE",
        "VAN FLEET",
        "VAN NES",
        "VAN ROBERTS",
        "VAN ZANDT",
        "VIEW PLACE",
        "VIEW POINTE",
        "VILLAGE GATE",
        "VILLAGE GREEN",
        "VISTA VIEW",
        "WALDEN GLEN",
        "WAR ADMIRAL",
        "WEST MC KELVEY",
        "WESTIN RIDGE",
        "WESTWOOD NORTHERN",
        "WINDING BROOK",
        "WITTS MILL",
        "WOODLANDS PATH",
        "ZIG ZAG",
        "ZION HILL"

    );
    setupDoctorNames(
        "MATT",
        "MAYO",
        "RISCALLA",
        "WILSON"
    );
    setupSaintNames(
        "CLAIRE",
        "JOHN"
    );
    removeWords("ALLEY");
    setupCallList(CALL_LIST);
    addRoadSuffixTerms("CONNECTOR");
  }
  
  @Override
  public String getFilter() {
    return "hc@hamilton-co.org,9300,messaging@iamresponding.com,6245";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return WILLIAM_HENRY_HARR.matcher(addr).replaceAll("WILLIAM HENRY HARRISON");
  }
  private static final Pattern WILLIAM_HENRY_HARR = Pattern.compile("\\bWILLIAM HENRY HARR\\b", Pattern.CASE_INSENSITIVE);

  
  private static final Pattern MASTER = Pattern.compile("HC:(.*?)(?: \\*\\*? (.*?) \\*\\*( .*?)??)?(?: (\\d{1,2}:\\d\\d)( .*)?)?");
  private static final Pattern APT_PTN = Pattern.compile("(.*?) +APT: *([^ ]+) +(.*)");
  private static final Pattern ORIG_LOC_PTN = Pattern.compile(" *\\bOriginal Location : *");
  private static final Pattern YMCA_PTN = Pattern.compile("\\bY ?M ?C ?A\\b", Pattern.CASE_INSENSITIVE);

  @Override
  public boolean parseMsg(String body, Data data) {
    
    if (body.startsWith("HC:AD:") || body.startsWith("HC:TIME:")) {
      data.strCall = "GENERAL ALERT";
      data.strPlace = body.substring(3);
      return true;
    }
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    String addr = match.group(1).trim();
    String call = match.group(2);
    String info = match.group(3);
    String time = match.group(4);
    String extra = match.group(5);
    
    // Clean blanks out of YMCA RD
    addr = YMCA_PTN.matcher(addr).replaceAll("YMCA");
    
    // Old format had an asterisk delimited call field with a place
    // name in front of it and a info field behind.  There is another
    // call description in front of the address that duplicates the
    // asterisk delimited field so we just skip it
    if (call != null) {
      parseAddress(StartType.START_OTHER, FLAG_IGNORE_AT | FLAG_CROSS_FOLLOWS, addr, data);
      String sPlace = fixCity(getLeft(), data);
      if (sPlace.startsWith("APT ")) {
        Parser p = new Parser(sPlace.substring(4).trim());
        data.strApt = p.get(' ');
        sPlace = p.get();
      }
      data.strPlace = sPlace;
      data.strCall = call.trim();
      data.strSupp = getOptGroup(info);
      if (data.strSupp.startsWith("Original Location :")) data.strSupp = "";
    }
    
    // New format just has one field with a call description, address, and additional information
    else {
      
      // Sometimes the put an APT: label and field between the call and address
      // which makes things easier
      StartType st = StartType.START_CALL;
      int flags = FLAG_START_FLD_REQ;
      match = APT_PTN.matcher(addr);
      if (match.matches()) {
        st = StartType.START_ADDR;
        flags = 0;
        data.strCall = match.group(1);
        data.strApt = match.group(2);
        addr = match.group(3);
      }
      
      // otherwise we have to do this the hard way.
      
      parseAddress(st, flags | FLAG_IGNORE_AT | FLAG_CROSS_FOLLOWS, addr, data);
      info = fixCity(getLeft(), data);
      if (info.startsWith("LOC:")) {
        info = info.substring(4).trim();
        match = ORIG_LOC_PTN.matcher(info);
        if (match.find()) info = info.substring(0,match.start());
        data.strPlace = info;
      } else {
        match = ORIG_LOC_PTN.matcher(info);
        if (match.find()) {
          String place = info.substring(match.end());
          if (!data.strAddress.contains(place)) data.strPlace = place;
          info = info.substring(0,match.start());
        }
        data.strSupp = info;
      }
    }

    // Fix some Dispatch address typos
    data.strAddress = data.strAddress.replace("DE SOTO", "DESOTO");
    
    // Process time if present
    if (time  != null) data.strTime = time;

    // Process leftover stuff
    if (extra != null) {
      Parser p = new Parser(extra.trim());
      String x2 = p.getLastOptional(" XST2:");
      String x1 = p.getLastOptional(" XST:");
      data.strUnit = p.get();
      data.strCross = append(x1, " & ", x2);
    }
    
    // Last check to clean up mystery NECC city code
    if (data.strCity.equals("NECC")) {
      data.strPlace = append(data.strCity, " - ", data.strPlace);
      data.strCity = "";
    }
    
    return true;
  }
  
  private static String fixCity(String left, Data data) {
    int pt = data.strCity.indexOf('/');
    if (pt >= 0) {
      String state = data.strCity.substring(pt+1);
      data.strCity = data.strCity.substring(0,pt);
      if (!state.equals("OH")) data.strState = state;
      Matcher match = COUNTY_PTN.matcher(left);
      if (match.matches()) left = match.group(1);
    }
    return left;
  }
  private static final Pattern COUNTY_PTN = Pattern.compile("[A-Z]+ +(?:CO|CTY)\\b *(.*)");

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ADDY", "ADDYSTON",
      "AMBR", "AMBERLY VILLAGE",
      "ANDR", "ANDERSON TWP",
      "ARLN", "ARLINGTON HEIGHTS",
      "BLUE", "BLUE ASH",
      "CHEV", "CHEVIOT",
      "CINC", "CINCINNATI",
      "CLVS", "CLEVES",
      "COTP", "COLERAIN TWP",
      "COLM", "COLUMBIA TWP",
      "CROS", "CROSBY TWP",
      "DLHI", "DELHI TWP",
      "DRPK", "DEER PARK",
      "ELMW", "ELMWOOD PLACE",
      "EVEN", "EVENDALE",
      "FRFD", "FAIRFIELD",
      "FRFX", "FAIRFAX",
      "FRPK", "FOREST PARK",
      "GLEN", "GLENDALE",
      "GOLF", "GOLF MANOR",
      "GREN", "GREENHILLS",
      "GRTP", "GREEN TWP",
      "HARR", "HARRISON",
      "HRTP", "HARRISON TWP",
      "INDN", "INDIAN HILL",
      "LINC", "LINCOLN HEIGHTS",
      "LOCK", "LOCKLAND",
      "LOVE", "LOVELAND",
      "MDRA", "MADEIRA",
      "MRMT", "MARIEMONT",
      "MIAC", "MIAMI TWP",
      "MIAM", "MIAMI TWP",
      "MILF", "MILFORD",
      "MONT", "MONTGOMERY",
      "MRMT", "MARIEMONT",
      "MTHL", "MOUNT HEALTHY",
      "NCHL", "NORTH COLLEGE HILL",
      "NECC", "NECC",   // No idea what this is.  We will save it in place field
      "NEWT", "NEWTOWN",
      "NORW", "NORWOOD",
      "NRBN", "NORTH BEND",
      "NCHL", "NORTH COLLEGE HILL",
      "READ", "READING",
      "SHRN", "SHARONVILLE",
      "SLVT", "SILVERTON",
      "SPDL", "SPRINGDALE",
      "SPTP", "SPRINGFIELD TWP",
      "STBN", "SAINT BERNARD",
      "SYCM", "SYCAMORE TWP",
      "SYMM", "SYMMES TWP",
      "TERR", "TERRACE PARK",
      "UNTC", "UNION TWP",
      "WWTR", "WHITEWATER TWP",
      "WOOD", "WOODLAWN",
      "WWTR", "WHITEWATER TWP",
      "WYOM", "WYOMING",
      
      // Butler County
      "MGTP", "MORGAN TWP",
      "WCHE", "WEST CHESTER TWP",

      // Clermont County
      "CLER", "CLERMONT COUNTY",

      // Dearborn County, IN
      "DEAR", "DEARBORN COUNTY/IN",
      "HRTI", "HARRISON TWP/IN",
      "WHAR", "WEST HARRISON/IN",
      
      // Warren County
      "DFTP", "DEERFIELD TWP/OH",
      
      "FRANKLIN CO",   "FRANKLIN COUNTY",
      "JACKSON BUTL",  "HAMILTON"
      
  });
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "A/A -",
      "A/A -BUILDING STRUCK",
      "A/A - ENTRAPMENT",
      "A/A - FUEL LEAK/FIRE",
      "A/A - INJURY",
      "A/A - PERSON STRUCK",
      "ABDOMINAL PAIN",
      "ALLERGIC REACTION",
      "ANIMAL BITE",
      "APPLIANCE FIRE",
      "BACK PAIN",
      "CHECK TAZED PERSON",
      "CHEST PAIN",
      "CHOKING",
      "CO ALARM",
      "CO ALARM - SICK PERS",
      "DIABETIC EMERGENCY",
      "DUMPSTER FIRE",
      "ELECTRICAL FIRE",
      "ELEVATOR ALARM/RESCU",
      "EMS / LIFT ASSISTANCE",
      "FIELD/BRUSH/MULCH",
      "FIRE ALARM",
      "FUEL SPILL",
      "GENERAL ALERT",
      "GENERAL RESPONSE",
      "GYNECOLOGICAL EMER",
      "HEADACHE",
      "HEAD INJURY",
      "HEART ATTACK",
      "HEMORRHAGING",
      "HIGH ANGLE RESCUE",
      "HIGH FEVER",
      "HYPERTHERMIA",
      "HYPOTHERMIA",
      "INJ DURING ROBBERY",
      "INJURED PERSON",
      "INJURY FROM A FALL",
      "INVESTIGATION",
      "LACERATION",
      "LIFT ASSISTANCE",
      "MATERNITY RUN",
      "MEDICAL ALARM",
      "MISCARRIAGE",
      "NON-BREATHER",
      "ODOR OF GAS",
      "OPEN BURN",
      "OVERDOSE",
      "PERSON ASSAULTED",
      "PERSON BURNED",
      "PERSON ELECTROCUTED",
      "PERSON INJURED",
      "PERSON SHOT",
      "PERSON SICK",
      "PERSON UNCONSCIOUS / NON-RESPONSIVE",
      "POISONING",
      "POLE/TRANSFORM FIRE",
      "PROPERTY EMERGENCY",
      "PSYCHIATRIC EMER",
      "PSYCHIATRIC EMERGENCY",
      "REC ELEVATOR ALARM",
      "RECORDED FIRE ALARM",
      "SEIZURES",
      "SEXUAL ASSAULT",
      "SICKLE CELL EMER",
      "SICK PERSON",
      "STROKE",
      "STRUCTURE FIRE",
      "SUICIDE ATT/THREATS",
      "TESTING",
      "TROUBLE BREATHING",
      "UNCONSCIOUS PERSON",
      "VEHICLE FIRE",
      "WATER FLOW ALARM",
      "WATER RESCUE/RECOVER",
      "WIRES DOWN"
  );
}
