package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchA39Parser;

/**
 * Cuyahoga County, OH
 */
public class OHCuyahogaCountyAParser extends DispatchA39Parser {

  public OHCuyahogaCountyAParser() {
    super(OHCuyahogaCountyParser.CITY_CODES, "CUYAHOGA COUNTY", "OH");
    removeWords("RUN", "HTS");   // Lest SQUAD RUN be considered an address :(
  }

  @Override
  public String getFilter() {
    return "dispatch@chagrinfallspd.com,dispatcher@bhpd.org";
  }
}
