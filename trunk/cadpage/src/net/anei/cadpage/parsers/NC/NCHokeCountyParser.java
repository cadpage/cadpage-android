package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchVisionAirParser;

/**
 * Hoke County, NC
 */
public class NCHokeCountyParser extends DispatchVisionAirParser {
  
  public NCHokeCountyParser() {
    super("Hoke Co 911:", "HOKE COUNTY", "NC", 
           "ADDR APT CH CITY EMPTY+? CALL! UNK+? EXTRA! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "Hoke@hokecounty.org";
  }
}
