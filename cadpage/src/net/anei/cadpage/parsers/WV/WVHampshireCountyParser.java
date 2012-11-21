package net.anei.cadpage.parsers.WV;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/**
 * Hampshire County, WV
 */
public class WVHampshireCountyParser extends DispatchBParser {

  public WVHampshireCountyParser() {
    super(CITY_LIST, "HAMPSHIRE COUNTY", "WV");
    setupCallList((CodeSet)null);
  }
  
  @Override
  public String getFilter() {
    return "HAMPSHIRE911@frontier.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    if (!body.startsWith("HAMPSHIRE911:")) return false;
    body = subject + " @ " + body.substring(13).trim();
    return super.parseMsg(body, data);
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{

    // Incorporated Communities
    "ROMNEY",
    "CAPON BRIDGE",
    
    // Unincorporated Communities
    "AUGUSTA",
    "BARNES MILL",
    "BLOOMERY",
    "BLUES BEACH",
    "BUBBLING SPRING",
    "CAPON LAKE",
    "CAPON SPRINGS",
    "CAPON SPRINGS STATION",
    "COLD STREAM",
    "CREEKVALE",
    "DAVIS FORD",
    "DELRAY",
    "DILLONS RUN",
    "DONALDSON",
    "FORKS OF CACAPON",
    "FRENCHBURG",
    "GLEBE",
    "GOOD",
    "GRACE",
    "GREEN SPRING",
    "HAINESVILLE",
    "HANGING ROCK",
    "HIGGINSVILLE",
    "HIGH VIEW",
    "HOOKS MILLS",
    "HOY",
    "INTERMONT",
    "JERICHO",
    "JUNCTION",
    "KIRBY",
    "LARGENT",
    "LEHEW",
    "LEVELS",
    "LITTLE CACAPON",
    "LOOM",
    "MECHANICSBURG",
    "MILLBROOK",
    "MILLEN",
    "MILLESONS MILL",
    "NEALS RUN",
    "NERO",
    "NORTH RIVER MILLS",
    "OKONOKO",
    "PANCAKE",
    "PIN OAK",
    "PLEASANT DALE",
    "POINTS",
    "PURGITSVILLE",
    "RADA",
    "RAVEN ROCKS",
    "RIDGEDALE",
    "RIO",
    "RUCKMAN",
    "SECTOR",
    "SEDAN",
    "SHANKS",
    "SHILOH",
    "SLANESVILLE",
    "SOUTH BRANCH DEPOT",
    "SPRINGFIELD",
    "THREE CHURCHES",
    "VANCE",
    "VANDERLIP",
    "WAPPOCOMO",
    "WOODROW",
    "YELLOW SPRING",
    
    // Mineral County
    "BURLINGTON"
  };
}
