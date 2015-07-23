
package net.anei.cadpage.parsers.AR;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernPlusParser;

/**
 * Pulaski County, AL
 */

public class ARPulaskiCountyParser extends DispatchSouthernPlusParser {
  
  public ARPulaskiCountyParser() {
    super(CITY_LIST, "PULASKI COUNTY", "AR", DSFLAG_LEAD_PLACE | DSFLAG_NO_NAME_PHONE);
  }
  
  private static final String[] CITY_LIST = new String[]{
      
      "ALEXANDER",
      "CAMMACK VILLAGE",
      "COLLEGE STATION",
      "CRYSTAL HILL",
      "GIBSON",
      "GRAVEL RIDGE",
      "HENSLEY",
      "IRONTON",
      "JACKSONVILLE",
      "LITTLE ROCK",
      "MCALMONT",
      "MAUMELLE",
      "NATURAL STEPS",
      "NORTH LITTLE ROCK",
      "LANDMARK",
      "SHERWOOD",
      "SWEET HOME",
      "WOODSON",
      "WOODYARDVILLE",
      "WRIGHTSVILLE"
  };
}
