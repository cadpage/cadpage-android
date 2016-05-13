
package net.anei.cadpage.parsers.NC;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

public class NCAsheCountyParser extends DispatchSouthernParser {

  public NCAsheCountyParser() {
    super(CITY_LIST, "ASHE COUNTY", "NC", DSFLAG_OPT_DISPATCH_ID | DSFLAG_LEAD_PLACE);
    setupMultiWordStreets(MWORD_STREET_LIST);
    setupSpecialStreets("VIRGINIA ST LINE");
    addExtendedDirections();
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    
    // Fix mispelled city names
    data.strCity = convertCodes(data.strCity.toUpperCase(), FIX_CITY_TABLE);
    
    // Check for out of state locations
    String state = CITY_ST_TABLE.getProperty(data.strCity);
    if (state != null) data.strState = state;
    
    // See if they put a cross street in front of the address
    if (data.strCross.length() == 0 && data.strPlace.endsWith("/")) {
      String cross = data.strPlace.substring(0,data.strPlace.length()-1).trim();
      data.strPlace = "";
      parseAddress(StartType.START_PLACE, FLAG_ONLY_CROSS | FLAG_NO_CITY | FLAG_ANCHOR_END, cross, data);
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return "X " + super.getProgram().replace("CITY", "CITY ST");
  }
  
  @Override
  protected boolean isNotExtraApt(String apt) {
    if (apt.startsWith("(") && apt.endsWith(")")) return true;
    return super.isNotExtraApt(apt);
  }

  private static final String[] MWORD_STREET_LIST = new String[]{
    "ABSHER FARM",
    "ANDERSON HILL",
    "ANDY FOWLER",
    "ASHE CENTRAL SCHOOL",
    "ASHE COUNTY HIGH SCHOOL",
    "ASHE PARK",
    "AUBREY TURNER",
    "B C HUNTER",
    "BALD MOUNTAIN",
    "BARE CREEK",
    "BART HURLEY",
    "BEAVER CREEK SCHOOL",
    "BEAVER CRK SCHOOL",
    "BEN BOLEN",
    "BIG FLATTS CHURCH",
    "BIG HELTON",
    "BIG HORSE CREEK",
    "BIG LAUREL",
    "BIG PEAK CREEK",
    "BIG PINEY CREEK",
    "BIG WINDFALL",
    "BLUE RIDGE",
    "BOWER RIDGE",
    "BROWN HOLLOW",
    "BRUNT HILL",
    "BRUSHY FORK",
    "BRYAN DAVIS",
    "BUCK MT",
    "BURNT HILL",
    "CABBAGE CREEK",
    "CALL CREEK",
    "CANOE GAP",
    "CARSON WOODS",
    "CEDAR RIDGE",
    "CENTRAL BUFFALO",
    "CHEEK MOUNTAIN",
    "CHERRY HILL",
    "CHESTNUT HILL BAPTIST",
    "CHESTNUT HILL",
    "COY HAM",
    "CRANBERRY CREEK",
    "CROSS CREEK",
    "DALE BLEVINS",
    "DEEP FORD",
    "DICK PHILLIPS",
    "DISHMAN SEVERT",
    "DON ADAMS",
    "DON WALTERS",
    "EARL SHEETS",
    "EARNEST HOWELL",
    "EAST BUCK MOUNTAIN",
    "EAST BUFFALO MEADOWS",
    "EAST DOUBLE SPRINGS CH",
    "EAST LANDING",
    "EAST LITTLE HORSE CREEK",
    "EAST SECOND",
    "ED LITTLE",
    "ELK CREEK CHURCH",
    "ELK KNOB",
    "FAIRVIEW CH",
    "FLATWOODS SCHOOL",
    "FLINT HILL",
    "FRANK DILLARD",
    "FRANK ROLAND",
    "FRED PUGH",
    "FULTON REEVES",
    "GAITHER POE",
    "GENTLE RIDGE",
    "GEORGE MCMILLAN",
    "GINGER MTN",
    "GLENDALE SCHOOL",
    "GLENN KING",
    "GLENN MILLER",
    "GOLF COURSE",
    "GRAY STONE",
    "GREEN VALLEY",
    "GREER TOWN",
    "HARDIN GILLEY",
    "HARTZOG FORD",
    "HELEN BLEVINS",
    "HELTON CREEK",
    "HELTON SCHOOL",
    "HIDDEN SPRING",
    "HILLBILLY RIDGE",
    "HORSE CREEK",
    "HOWARD COLVARD",
    "HUBERT TAYLOR",
    "HUCKLEBERRY RIDGE",
    "INDIAN LAKE",
    "J TAYLOR",
    "JACK JONES",
    "JAMES F WATSON",
    "JEFFERSON VIEW",
    "JERD BRANCH",
    "JOE BADGER",
    "JOE HAMPTON",
    "JOE JONES",
    "JOE LITTLE",
    "JOE WEAVER",
    "JOHN GRIFFITH",
    "JOHN HALSEY",
    "JOHN MILLER",
    "LANE L MASSEY",
    "LAUREL FORK",
    "LAUREL KNOB",
    "LEE OSBORNE",
    "LEMLY HILL",
    "LIBERTY GROVE CH",
    "LITTLE LAUREL",
    "LITTLE LYALL",
    "LITTLE PEAK CREEK",
    "LITTLE WINDFALL",
    "LONG BRANCH",
    "MABE DAIRY",
    "MISTY MOUNTAIN",
    "MONT SHEPHERD",
    "MOUNT JEFFERSON",
    "MT JEFF",
    "MT JEFFERSON",
    "MT JEFFERSON STATE PARK",
    "MUDDY BRANCH",
    "NATHANS CREEK SCHOOL",
    "NETTLE KNOB",
    "NOR FIELDS",
    "NORTH ACORN",
    "NORTH FORK NEW RIVER",
    "NORTH FULTON REEVES",
    "NORTH OLD",
    "NORTHWEST SCHOOL",
    "OBIDS BAPTIST CHURCH",
    "ORE KNOB",
    "PARK VISTA",
    "PARKER ELLER",
    "PARKWAY FARM",
    "PAUL GOODMAN",
    "PEACH BOTTOM",
    "PERDY GROGAN",
    "PHILLIPS GAP",
    "PINE MOUNTAIN",
    "PINEY CREEK SCHOOL",
    "PINEY CREEK",
    "PLUMB NEARLY",
    "PONY FARM",
    "QUAIL HOLLOW",
    "RAILROAD GRADE",
    "RASH SCHOOL",
    "RED HILL",
    "RED OAK",
    "RICH HILL",
    "RIP SHIN",
    "RIVER BLUFF",
    "RIVER BREEZE",
    "RIVER HILLS",
    "ROARING FORK",
    "ROBY POE",
    "ROCK CREEK",
    "ROCK FENCE",
    "ROCKY GAP",
    "ROCKY RIDGE",
    "ROE HUNT",
    "ROY GOODMAN",
    "SHARON SWEENEY",
    "SHATLEY ROARK",
    "SHATLEY SPRINGS",
    "SHELTER BAPTIST CHURCH",
    "SILAS CREEK",
    "SMOKEY HOLLOW",
    "SMOKY HOLLOW",
    "SOUR WOOD",
    "SOUTH BALD FORK",
    "SOUTH BIG HORSE CREEK",
    "SOUTH FLATWOODS",
    "SOUTH FORK",
    "SOUTH J E GENTRY",
    "SOUTH LAUREL FORK",
    "SOUTH MAIN",
    "SPENCER BRANCH",
    "SPRING CREEK",
    "STAGGS CREEK",
    "STATE PARK",
    "SUGAR TREE",
    "SWEET HOLLOW",
    "THREE TOP",
    "TRIVETTE HOLLOW",
    "VILLAGE PARK",
    "VIRGIL GREER",
    "W A REED",
    "WAGONER ACCESS",
    "WALNUT COVE",
    "WALTER BLEVINS",
    "WARRENSVILLE SCHOOL",
    "WATERS EDGE",
    "WEAVER FORD",
    "WEST BRUSHY FORK",
    "WEST BUFFALO",
    "WEST EVERGREEN",
    "WEST LAUREL KNOB",
    "WEST MILL CREEK",
    "WEST PEAK",
    "WHENLIN RIDGE",
    "WILDCAT HOLLOW",
    "WILLIE BROWN",
    "WILLIE WALKER",
    "WINDY HILL",
    "WOLF KNOB",
    "WOODROW BARE",
    "YELLOW BEAR",
    "YELLOWKNIFE RANCH"
    
  };
  
  private static final Properties CITY_ST_TABLE = buildCodeTable(new String[]{
      "GRAYSON COUNTY",    "VA",
      "GRAYSON",           "VA",
      "JOHNSON COUNTY",    "TN",
      "JOHNSON",           "TN"
  });

  private static final Properties FIX_CITY_TABLE = buildCodeTable(new String[]{
      "CRUMLPER",   "CRUMPLER"
  });

  private static final String[] CITY_LIST = new String[]{
    
      "ASHE COUNTY",
      "ASHE",
      
      //Towns
      "JEFFERSON",
      "LANSING",
      "WEST JEFFERSON",

      //Townships
      "CHESTNUT HILL",
      "CLIFTON",
      "CRESTON",
      "ELK",
      "GRASSY CREEK",
      "HELTON",
      "HORSE CREEK",
      "HURRICANE",
      "JEFFERSON",
      "LAUREL",
      "LAUREL SPRINGS",
      "NORTH FORK",
      "OBIDS",
      "OLD FIELDS",
      "PEAK CREEK",
      "PINE SWAMP",
      "PINEY CREEK",
      "POND MOUNTAIN",
      "WALNUT HILL",
      "WEST JEFFERSON",

      //Unincorporated Communities
      "BEAVER CREEK",
      "BINA",
      "CHESTNUT HILL",
      "CLIFTON",
      "COMET",
      "CRESTON",
      "CRUMPLER",
      "CRUMLPER",  // Misspelled
      "FIG",
      "FLEETWOOD",
      "GLENDALE SPRINGS",
      "GRASSY CREEK",
      "GRAYSON",
      "HELTON",
      "PARKER",
      "SCOTTVILLE",
      "STURGILLS",
      "TODD",
      "WARRENSVILLE",
      
      // Alleghany County
      "ALLEGHANY COUNTY",
      "ALLEGHANY",
      "ENNICE",
      "SPARTA",
      
      // Wataugua County
      "WATAUGUA COUNTY",
      "WATAUGUA",
      "ZIONVILLE",
      
      // Other counties
      
      "GRAYSON COUNTY",
      "GRAYSON",
      "JOHNSON COUNTY",
      "JOHNSON",
      "WILKES COUNTY",
      "WILKES"
  };
}
