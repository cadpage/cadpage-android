
package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class SCLeeCountyParser extends DispatchSouthernParser {

  public SCLeeCountyParser() {
    super(CITY_LIST, "LEE COUNTY", "SC", DSFLAG_ID_OPTIONAL);
    //DSFLAG_FOLLOW_CROSS
  }


  private static final String[] CITY_LIST = new String[]{

      "BISHOPVILLE",
      "DALZELL",
      "LYNCHBURG"

  };
}
