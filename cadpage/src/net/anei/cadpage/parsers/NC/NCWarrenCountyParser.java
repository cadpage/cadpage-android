
package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCWarrenCountyParser extends DispatchSouthernParser {

  public NCWarrenCountyParser() {
    super(CITY_LIST, "WARREN COUNTY", "NC", DSFLAG_FOLLOW_CALL);
  }
  
  @Override
  public String getFilter() {
    return "@warrencountync.com";
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    "MACON",
    "HENDERSON",
    "NORLINA",
    "WARRENTON",
    "WISE"
  };
}
