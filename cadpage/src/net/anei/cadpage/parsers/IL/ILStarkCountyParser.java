package net.anei.cadpage.parsers.IL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA29Parser;

/**
 * Stark County, IL
 */
public class ILStarkCountyParser extends DispatchA29Parser {
  
  private static final Pattern MARKER = Pattern.compile("DISPATCH:([A-Z]+(?: FD)?) - ");
  
  public ILStarkCountyParser() {
    super(CITY_LIST, "STARK COUNTY", "IL");
    setupCallList(CALL_LIST);
    setupMultiWordStreets(
        "BISHOP HILL",
        "NEKOMA EIGHTH",
        "NEKOMA MAIN"
    );
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Stark County")) return false;
    Matcher match = MARKER.matcher(body);
    if (!match.lookingAt()) return false;
    body = "DISPATCH:HCSO:" + match.group(1) + " - " + body.substring(match.end());
    return super.parseMsg(body, data);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = DIR_OF_PTN.matcher(addr).replaceAll(" & ");
    return addr;
  }
  private static final Pattern DIR_OF_PTN = Pattern.compile("[/ ]+((?:N|S|E|W|NO|SO|EA|WE|NORTH|SOUTH|EAST|WEST) OF)[/ ]+");
  
  private static final CodeSet CALL_LIST = new CodeSet(
      "4870 DISTURBANCE - DOMESTIC VIOLENCE",
      "6040 ACCIDENT - TRAFFIC - INJURY",
      "6041 ACCIDENT - TRAFFIC - INJ UNK",
      "6090 AMBULANCE - ASSIST HELICOPTER",
      "6100 AMBULANCE - EMERGENCY",
      "6700 DISTURBANCE - FIGHTS-RIOTS-BRAWLS",
      "6715 DISTURBANCE - OTHER",
      "6800 FIRE CALLS - OTHER",
      "6804 FIRE - ASSIST FIRE DEPT",
      "6940 JUVENILE PROBLEM",
      "7500 SUSPICIOUS PERSON"
  );

  private static final String[] CITY_LIST = new String[]{
    
    // Cities and towns
    "BRADFORD",
    "LA FAYETTE",
    "TOULON",
    "WYOMING",

    // Unincorporated communities
    "CASTLETON",
    "DUNCAN",
    "ELMIRA",
    "LOMBARDVILLE",
    "MODENA",
    "OSCEOLA",
    "SAXTON",
    "SPEER",
    "STARK",
    "WEST JERSEY",

    // Townships
    "ELMIRA TWP",
    "ESSEX TWP",
    "GOSHEN TWP",
    "OSCEOLA TWP",
    "PENN TWP",
    "TOULON TWP",
    "VALLEY TWP",
    "WEST JERSEY TWP",
    
    // Henry County
    "GALVA",
    "WOODHULL",
    
    // Tippecanoe County
    "LAFAYETTE",
    
    "HENRY COUNTY",
    "BISHOP HILL",
    "CAMBRIDGE",
    "KEWANEE"
  };
}
