package net.anei.cadpage.parsers.WV;


import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;


public class WVRaleighCountyParser extends DispatchB2Parser {
  
  private static final Pattern MAP_GRID_CAD_PTN = Pattern.compile("(.*?) Map: Grids:, Cad: ([-\\d]+)$");
  
  public WVRaleighCountyParser() {
    super("RALEIGH911:", CITY_LIST, "RALEIGH COUNTY", "WV");
    setupCallList(CALL_LIST);
    removeWords("BV", "TURNPIKE");
    setupDoctorNames("KELLY");
    setupMultiWordStreets(
        "4-H LAKE",
        "AFFINITY COMPLEX",
        "APPALACHIAN HEIGHTS",
        "BEE BRANCH",
        "BLUE JAY SIX",
        "BLUE ROOM",
        "BOYD CRAWFORD",
        "BURNING ROCK",
        "C AND O DAM",
        "CHERRY CREEK",
        "CLAY FARM",
        "CLEAR FORK",
        "COAL CITY",
        "COAL RIVER",
        "D C LILLY",
        "DRY HILL",
        "FLAT TOP",
        "FLAT TOP MOUNTAIN",
        "GLADE CREEK",
        "GLEN ROGERS-RAVENCLIFF",
        "HARPER HEIGHTS",
        "HOLLY HILL",
        "HOO HOO",
        "HOT COAL",
        "INDUSTRIAL PARK",
        "JIM BAILEY FARM",
        "JOHN LANE",
        "LAKE STEPHENS",
        "MAPLE FORK",
        "MAPLE MEADOW MINING",
        "MCKINNEY MOUNTAIN",
        "MILL CREEK",
        "MONT PHILLIPS",
        "MOUNTAIN VIEW",
        "MT BREEZE",
        "MT TABOR",
        "MT VIEW",
        "OAK CREEK",
        "OAK GROVE",
        "ORCHARD HILL",
        "RALEIGH RIDGE",
        "ROBERT C BYRD",
        "ROCK CREEK",
        "RUSTIC HILLS",
        "SAND BRANCH",
        "SAXON BOLT",
        "SCOTT RIDGE",
        "SHADY LAKE",
        "SLAB FORK",
        "SNUFFER MOUNTAIN",
        "STEPHENS BRANCH",
        "TOLBERT FARM",
        "TOMMY CREEK",
        "VALLEY VIEW",
        "WILCOX VALLEY"
    );
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("RALEIGH911:Return Phone:")) {
      Parser p = new Parser(body.substring(24).trim());
      data.strPhone = p.get(' ');
      data.strCode = p.get(' ');
      String addr = p.get();
      Matcher match = MAP_GRID_CAD_PTN.matcher(addr);
      if (match.matches()) {
        data.strCall = "GENERAL ALERT";
        data.strPlace = match.group(1).trim();
        data.strCallId = match.group(2);
        data.strCode = "";
      } else {
        parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_NO_CITY, addr, data);
        data.strName = getLeft();
      }
      return true;
    }
    return super.parseMsg(body, data);
  }
  
  @Override
  public String getProgram() {
    return "PHONE " + super.getProgram();
  }
  
  @Override
  protected int getExtraParseAddressFlags() {
    return FLAG_IGNORE_AT;
  }
  
  @Override
  public boolean isValidAddress(String addr) {
    // FMnnn is a valid highway in some states, but not here
    if (addr.startsWith("FM")) return false;
    return super.isValidAddress(addr);
  }

  @Override
  public String adjustMapCity(String city) {
    return convertCodes(city, CITY_PLACE_NAMES);
  }
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "911 HANGUP",
      "ABDOMINAL PAIN",
      "ABDUCTION",
      "ACCIDENT WITHOUT INJURY",
      "AIRCRAFT DISTRUBANCE",
      "ALARM-HOLDUP",
      "ALARM(SPECIFY)",
      "ALLERGIC REACTION",
      "ANIMAL PROBLEM",
      "ARSON FIRE",
      "ASSAULT",
      "ASSIST OTHER DEPT",
      "ASSULT WITH INJURY",
      "ATTEMPTED SUICIDE",
      "BACK PAIN",
      "BLEEDING/NON-TRAUMAT",
      "BREATHING DIFFICULTY",
      "BRUSH FIRE",
      "BURGLARY IN PROGRESS",
      "CHECK WELFARE",
      "CHEST PAIN",
      "CHILD BIRTH",
      "CHIMNEY FIRE",
      "CHOKING",
      "CIVIL ASSIST",
      "CONGESTIVE HEART FAILURE",
      "CPR-ADULT",
      "CPR-INFANT",
      "DAMAGE FROM STORM",
      "DEAD BODY",
      "DIABETIC",
      "DISORIENTED",
      "DISTURBANCE",
      "DOMESTIC",
      "EDEMA/SWELLING",
      "EOC PROJECT",
      "EMPLOYEE CALL IN SICK",
      "EXERCISE",
      "EXPLOSION",
      "EYE INJURY",
      "FALLS",
      "FIGHT-IN PROGRESS",
      "FIRE",
      "FIRE ALARM",
      "FRACTURE-BONE",
      "GAS LEAK",
      "HAZMAT",
      "HEAD INJURY",
      "HEALTHNET LANDING",
      "HEART ATTACK",
      "ILLEGAL BURN",
      "INTOX PERSON",
      "LIFTING ASSISTANCE",
      "LINES DOWN",
      "MEDICAL ALARM",
      "MENTAL/EMOTIONAL/PS",
      "MINING ACCIDENT",
      "MOTOR VEH ACCID PRIVATE LOT",
      "MOTOR VEHICLE ACCIDENT",
      "MOTOR VEHICLE ACCIDENT INJURY",
      "MVA LEAVING THE SCENE",
      "OVERDOSE",
      "PEDSTRIAN HIT",
      "PERSON DOWN",
      "PLANE MALFUNCTION",
      "POSSIBLE DUI",
      "PURSUIT",
      "REKINDLE",
      "ROAD HAZZARD",
      "ROBBERY OCCURED EARLIER",
      "ROCK SLIDE",
      "RUNAWAY JUV",
      "RUN REPORT",
      "SEIZURES",
      "SHOOTING",
      "SHOTS FIRE",
      "SICK",
      "SHOTS FIRED",
      "SMOKE",
      "SPECIAL ASSIGNMENT",
      "SPECIFY -(I.E. -ARM/LEG)",
      "SPECIFY-RUN OFF/HIGH",
      "STROKE",
      "STRUCTURE FIRE",
      "SUSPICIOUS PERSON",
      "TRAFFIC STOP",
      "TRANSFORMER",
      "TREE DOWN",
      "UNCONSCIOUS/SYNCOPE",
      "UNRESPONSIVE",
      "VEHICLE- DISABLED",
      "VEHICLE FIRE",
      "WANTED PERSON"
  );
  
  private static final String[] CITY_LIST = new String[]{

    // Cities & Towns
    "BECKLEY",
    "LESTER",
    "MABSCOTT",
    "RHODELL",
    "SOPHIA",
    
    // Subdivisions
    "CALLOWAY HEIGHTS",

    // Unincorporated communities
    "ABNEY",
    "ABRAHAM",
    "AFFINITY",
    "AMIGO",
    "ARNETT",
    "ARTIE",
    "BEAVER",
    "BESOCO",
    "BIG STICK",
    "BLUE JAY",
    "BLUE JAY 6",
    "BOLT",
    "BOWYER",
    "BRADLEY",
    "BRAGG",
    "CABELL HEIGHTS",
    "CEDAR",
    "CIRTSVILLE",
    "COAL CITY",
    "COLCORD",
    "COOL RIDGE",
    "CRAB ORCHARD",
    "CRANBERRY",
    "CROW",
    "DAMERON",
    "DANIELS",
    "DOROTHY",
    "DRY CREEK",
    "DRY HILL",
    "EASTGULF",
    "ECCLES",
    "EGERIA",
    "EUNICE",
    "FAIRDALE",
    "FARLEY HILL",
    "FIRECO",
    "FITZPATRICK",
    "FLAT TOP",
    "GHENT",
    "GLEN DANIEL",
    "GLEN MORGAN",
    "GLEN VIEW",
    "GLEN WHITE",
    "GRANDVIEW",
    "HELEN",
    "HOLLYWOOD",
    "HOT COAL",
    "HOTCHKISS",
    "JONBEN",
    "JOSEPHINE",
    "HARPER",
    "HARPER HEIGHTS",
    "HARPER PARK",
    "KILLARNEY",
    "LEEVALE",
    "LEGO",
    "LILLYBROOK",
    "MACARTHUR",
    "MAPLE FORK",
    "MCALPIN",
    "MCCREERY",
    "MCREERY",
    "MCVEY",
    "MEAD",
    "METALTON",
    "MIDWAY",
    "MONTCOAL",
    "MT TABOR",
    "NAOMA",
    "NEW",
    "OAK GROVE",
    "ODD",
    "PACKSVILLE",
    "PEMBERTON",
    "PICKSHIN",
    "PINEPOCA",
    "PINEY VIEW",
    "PLEASANT HILLS",
    "PLUTO",
    "PRICE HILL",
    "PRINCEWICK",
    "PROSPERITY",
    "RALEIGH",
    "REDBIRD",
    "ROCK CREEK",
    "SANDLICK",
    "SHADY SPRING",
    "SHILOH",
    "SKELTON",
    "SLAB FORK",
    "SOAK CREEK",
    "SOPHIA",
    "SPRAGUE",
    "STANAFORD",
    "STICKNEY",
    "STOTESBURY",
    "STOVER",
    "SULLIVAN",
    "SUNDIAL",
    "SURVEYOR",
    "SWEENEYSBURG",
    "SYLVIA",
    "TAMS",
    "TOLLEYTOWN",
    "URY",
    "WESTVIEW",
    "WHITBY",
    "WHITE OAK",
    "WILLIBET",
    "WINDING GULF",
    "WOODPECK",
    
    // Boone County
    "BOONE",
    "BOONE COUNTY",
    "WHITESVILLE",
    
    // Wyoming county
    "WYOMING"
  };
  
  private static final Properties CITY_PLACE_NAMES = buildCodeTable(new String[]{
      "CABELL HEIGHTS",     "BECKLEY",
      "CALLOWAY HEIGHTS",   "BECKLEY",
      "CRANBERRY",          "BECKLEY",
      "DAMERON",            "",
      "DRY HILL",           "BECKLEY",
      "EUNICE",             "WHITESVILLE",
      "FARLEY HILL",        "PRINCEWICK",
      "GLEN VIEW",          "CRAB ORCHARD",
      "HARPER",             "BECKLEY",
      "HARPER HEIGHTS",     "BECKLEY",
      "HARPER PARK",        "BECKLEY",
      "LEEVALE",            "WHITESVILLE",
      "MAPLE FORK",         "MT HOPE",
      "MCCREERY",           "BECKLEY",
      "MCREERY",            "BECKLEY",
      "METALTON",           "BECKLEY",
      "MT TABOR",           "BECKLEY",
      "OAK GROVE",          "BECKLEY",
      "PACKSVILLE",         "",
      "PLEASANT HILLS",     "BECKLEY",
      "SANDLICK",           "BECKLEY",
      "STOVER",             "GLEN DANIEL",
      "TOLLEYTOWN",         "SURVEYOR"
  });
}