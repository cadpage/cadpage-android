package net.anei.cadpage.parsers.WV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/**
 * Hampshire County, WV
 */
public class WVHampshireCountyParser extends DispatchBParser {
  
  private static final Pattern COUNTY_PTN = Pattern.compile("^(HARDY|FRED|FREDERICK|MINERAL|ALLEGANY|MORGAN) ", Pattern.CASE_INSENSITIVE);

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
    if (!super.parseMsg(body, data)) return false;
    
    // SO far, so good
    // Now for some special corrective measures to take if the
    // address parser did not find a city
    if (data.strCity.length() == 0) {
      
      // If there was no name, then see if the address includes
      // a STA word.  If found, this marks what should be the
      // end of the address and everything else goes in the name
      if (data.strName.length() == 0) {
        int pt = data.strAddress.indexOf(" STA ");
        if (pt >= 0) {
          pt += 4;
          data.strName = data.strAddress.substring(pt+1).trim();
          data.strAddress = data.strAddress.substring(0,pt).trim();
        }
      }
      
      // If the name looks like a neighboring county 911 center
      // leave it alone but use it to set the city & possible state
      Matcher match = COUNTY_PTN.matcher(data.strName);
      if (match.find()) {
        String city = match.group(1).toUpperCase();
        if (city.equals("FRED")) city = "FREDERICK";
        data.strCity = city + " COUNTY";
        if (city.equals("FREDERICK")) data.strState = "VA";
        else if (city.equals("ALLEGANY")) data.strState = "MD";
      }
    }
    
    if (data.strCallId.endsWith("`")) {
      data.strCallId = data.strCallId.substring(0,data.strCallId.length()-1).trim();
    }
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CITY ", "CITY ST");
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
    "CAPON SPRING",
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
    
    // Hardy County
    "WARDENSVILLE",
    
    // Mineral County
    "BURLINGTON",
    
    
  };
}
