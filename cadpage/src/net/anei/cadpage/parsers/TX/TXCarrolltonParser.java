
package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class TXCarrolltonParser extends DispatchSouthernParser {

  public TXCarrolltonParser() {
    super(CITY_LIST, "COMBINE", "TX", DSFLAG_NO_NAME_PHONE);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "COMBINE",
    "KAUFMAN COUNTY",
    "DALLAS COUNTY"
  };
}
