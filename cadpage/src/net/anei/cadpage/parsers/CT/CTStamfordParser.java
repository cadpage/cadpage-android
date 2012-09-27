package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.dispatch.DispatchVisionAirParser;

/**
 * Stamford, CT
 */
public class CTStamfordParser extends DispatchVisionAirParser {
  
  public CTStamfordParser() {
    super(new String[]{"* ", "911Fire:* "}, "STAMFORD", "CT", 
          "ADDR APT CH CITY EMPTY+? CALL! UNK PLACENAME PHONE UNK+? EXTRA! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "911fire@ci.Stamford.ct.us";
  }
}
