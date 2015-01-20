package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class NCSampsonCountyParser extends DispatchSouthernParser {
  
  public NCSampsonCountyParser() {
    super(CITY_LIST, "SAMPSON COUNTY", "NC", DSFLAG_LEAD_PLACE | DSFLAG_FOLLOW_CROSS);
    setupMultiWordStreets(MULT_WORD_STREET_LIST);
  }
  
  @Override
  public String getFilter() {
    return "@sampsonnc.com";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strApt.toUpperCase().startsWith("TAC")) {
      data.strChannel = data.strApt;
      data.strApt = "";
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("APT", "APT CH");
  }
  
  private static final String[] MULT_WORD_STREET_LIST = new String[]{
    "ALEX BENTON",
    "ALPINE CHURCH",
    "AUTRY MILL",
    "BASS LAKE",
    "BEAMAN WOODS",
    "BILL WATERS",
    "BOYKIN BRIDGE",
    "BRICK MILL",
    "BUBBLING BROOK",
    "BULL TAIL",
    "BUSH WAY",
    "BUTLER ISLAND",
    "CABIN MUSEUM",
    "CARROLL STORE",
    "CARRY BRIDGE",
    "CHRISTMAS TREE",
    "CLAUDES DRAG",
    "CLIVE JACOBS",
    "CORINTH CHURCH",
    "COUNTRY CLUB",
    "CURTIS IVEY",
    "DEVANES FARM",
    "DR KERR",
    "DR MARTIN L KING JR",
    "DR MARTIN L KING",
    "DR MARTIN LUTH KING JR",
    "DR MARTIN LUTH KING",
    "DR MARTIN LUTHER KING JR",
    "ERNEST WILLIAMS",
    "FAMILY FARM",
    "FLEET COOPER",
    "GARDEN SPOT",
    "GARLAND AIRPORT",
    "GODWIN LAKE",
    "GREEN PATH",
    "GRUBBS DALE",
    "HARNETT CHURCH",
    "HARPER HOUSE",
    "HAYES MILL",
    "HAYNE STRETCH",
    "HIGH HOUSE",
    "HITCHING POST",
    "HOUSES MILL",
    "HUBBARD BUTLER",
    "HUNTLEY SCHOOL",
    "ISAAC WEEKS",
    "KADER MERRITT",
    "KATTIE TART",
    "KINGS POND",
    "KITTY FORK",
    "LAKE ARTESIA",
    "LAKEWOOD SCHOOL",
    "LEWIS ILEY TEW",
    "LISBON BRIDGE",
    "LITTLE HAWK",
    "LONGVIEW LAKE",
    "MACK JOSEPH",
    "MARSH KORNEGAY",
    "MARTIN L KING JR",
    "MARTIN L KING",
    "MARTIN LUTH KING JR",
    "MARTIN LUTH KING",
    "MARTIN LUTHER KING JR",
    "MARTIN LUTHER KING",
    "MARTIN LUTHER KING",
    "MCGEE CHURCH",
    "MINGO CHURCH",
    "MOSES REGISTER",
    "MOUNT GILEAD CHURCH",
    "MOUNT MORIAH CHURCH",
    "MT OLIVE",
    "NAYLOR SCHOOL",
    "NEW HOPE CHURCH",
    "NEWTON GROVE",
    "OAK GROVE CHURCH",
    "PENNY TEW MILL",
    "PINE RIDGE",
    "PLAIN VIEW",
    "PLEASANT UNION",
    "PREACHER HENRY",
    "REEDA BRANCH",
    "RICHARD PARKER",
    "ROCK HOLLOW",
    "ROSIN HILL",
    "SADDLE CLUB",
    "SAMPSON ACRES",
    "SAVANNAH HILL",
    "SHARE CAKE",
    "SIX RUNS",
    "SOUTH CLINTON",
    "SOUTH RIVER",
    "SPIVEYS CORNER",
    "SPRING BRANCH",
    "STRAW POND SCHOOL",
    "TAYLORS BRIDGE",
    "TAYLORS CHAPEL",
    "TOM BUTLER",
    "TYNDALL BRIDGE",
    "VELNA JACKSON",
    "WALTER K EVANS",
    "WALTER K EVANS",
    "WARREN MILL",
    "WELCOME SCHOOL",
    "WHITE OAK CHURCH",
    "WHITE WOODS",
    "WILLIAM FORTNER",
    "WILLIAM PARKER",
    "WOODY PINE",
    "WRYE BRANCH",

  };

  private static final String[] CITY_LIST = new String[]{
    // City
    "CLINTON",

    // Towns
    "AUTRYVILLE",
    "FAISON",
    "GARLAND",
    "HARRELLS",
    "NEWTON GROVE",
    "ROSEBORO",
    "SALEMBURG",
    "TURKEY",

    // Census-designated places
    "BONNETSVILLE",
    "DELWAY",
    "INGOLD",
    "IVANHOE",
    "KEENER",
    "PLAIN VIEW",
    "SPIVEYS CORNER",
    "VANN CROSSROADS",

    // Unincorporated communities
    "HOBBTON",
    "SUTTONTOWN",
    "WILLARD",

    // Townships
    "BELVOIR TWP",
    "DISMAL TWP",
    "FRANKLIN TWP",
    "HALLS TWP",
    "HERRING TWP",
    "HONEYCUTT TWP",
    "LISBON TWP",
    "LITTLE COHARIE TWP",
    "MCDANIELS TWP",
    "MINGO TWP",
    "NEWTON GROVE TWP",
    "NORTH CLINTON TWP",
    "PINEY GROVE TWP",
    "PLAIN VIEW TWP",
    "SOUTH CLINTON TWP",
    "SOUTH RIVER TWP",
    "TAYLORS BRIDGE TWP",
    "TURKEY TWP",
    "WESTBROOK TWP",
    
    // Cumberland County
    "GODWIN",
    
    // Duplin County
    "MAGNOLIA",
    "ROSE HILL",
    
    // Harnett County
    "DUNN"
  };
}
