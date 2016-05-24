package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

public class GAPickensCountyParser extends DispatchB2Parser {

  public GAPickensCountyParser() {
    this("PICKENS COUNTY", "GA");
  }
  
  protected GAPickensCountyParser(String defCity, String defState) {
    super("PICKENS_CO.911:", CITY_LIST, defCity, defState);
    setupCallList(CALL_LIST);
    setupMultiWordStreets(MWORD_STREET_LIST);
  }
  
  @Override
  public String getAliasCode() {
    return "GAPickensCounty";
  }
  
  @Override
  public String getFilter() {
    return "PICKENS_CO.911@pickenscountyga.gov";
  }
  
  private static final String[] MWORD_STREET_LIST = new String[]{
    "CHEROKEE WOOD HOLLOW",
    "EAGLE NEST",
    "EAGLE PERCH",
    "FOUR MILE CHURCH",
    "MOUNTAIN OAK",
    "PEA RIDGE",
    "SANDY BOTTOM",
    "SPLIT ROCK",
    "STEVE TATE",
    "TEDDY BEAR",
    "YELLOW CREEK"
  };
  
  private static final CodeSet CALL_LIST = new CodeSet(
      
      "AUDIBLE ALARM",
      "BRUSH FIRE",
      "CARBON MONOXIDE INVESTIGATION",
      "DOMESTIC IN PROGRESS",
      "LOOKOUT",
      "FIRE ALARM COMMERCIAL",
      "FIRE IN RESIDENCE",
      "MVA UNKNOWN INJURIES",
      "MVA WITH INJURIES",
      "PERSON INJURED EMERGENCY",
      "PERSON SICK CODE 3"
  );

  private static final String[] CITY_LIST = new String[]{
      
      // Pickens county
      "BENT TREE",
      "BETHANY",
      "BIG CANOE", 
      "BLAINE",
      "HINTON",
      "HOLCOMB",
      "JASPER",
      "JERUSALEM",
      "LUDVILLE",
      "MARBLE HILL",
      "NELSON",
      "TALKING ROCK",
      "TATE",
      "WHITESTONE",
      
      // Cherokee county
      "AVERY",
      "BALL GROUND",
      "BATESVILLE",
      "BUFFINGTON",
      "BURRIS CROSSROADS",
      "CANTON",
      "CLAYTON",
      "CREIGHTON",
      "FREE HOME",
      "GOBER",
      "GOLD RIDGE",
      "GREELEY",
      "HICKORY FLAT",
      "HOLBROOK",
      "HOLLY SPRINGS",
      "KEITHSBURG",
      "LAKE ARROWHEAD",
      "LATHEMTOWN",
      "LEBANON",
      "MACEDONIA",
      "MICA",
      "MOUNTAIN PARK",
      "NELSON",
      "OAK GROVE",
      "OPHIR",
      "ORANGE",
      "SALACOA",
      "SHARP TOP",
      "SIXES",
      "SUTALLEE",
      "TOONIGH",
      "TOWNE LAKE",
      "UNION HILL",
      "UNIVETER",
      "VICTORIA",
      "WALESKA",
      "WOODSTOCK",

      // Dawson County
      "DAWSONVILLE"

    };
  
}
