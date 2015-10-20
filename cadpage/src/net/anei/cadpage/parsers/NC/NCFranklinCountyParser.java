

package net.anei.cadpage.parsers.NC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Franklin County, NC
 */

public class NCFranklinCountyParser extends DispatchSouthernParser {

  public NCFranklinCountyParser() {
    super(CITY_LIST, "FRANKLIN COUNTY", "NC", DSFLAG_OPT_DISPATCH_ID | DSFLAG_NO_NAME_PHONE | DSFLAG_ID_OPTIONAL);
  }
  
  @Override
  public String getFilter() {
    return "@franklincountync.us";
  }
  
  private static final Pattern DIR_BOUND = Pattern.compile("\\b([NSEW])/B\\b");
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace("//", "/");
    body = DIR_BOUND.matcher(body).replaceAll("$1B");
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.endsWith(" CO")) data.strCity += "UNTY";
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities and Towns
    "BUNN",
    "CENTERVILLE",
    "FRANKLINTON",
    "LOUISBURG",
    "WAKE FOREST", 
    "YOUNGSVILLE",
    
    // Hallifax County
    "HOLLISTER",
    
    // Nash County
    "CASTALIA",
    "SPRING HOPE",
    
    // Vance County
    "VANCE COUNTY",
    "VANCE CO",
    "HENDERSON",
    "KITTRELL",
    
    // Wake County
    "MIDDLESEX",
    "ROLESVILLE",
    "ZEBULON",
    
    // Waren County
    "WARRENTON"
   };
  
}
