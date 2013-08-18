package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * Campbell County, KY
 */
public class KYCampbellCountyParser extends DispatchA27Parser {
  
  public KYCampbellCountyParser() {
    super("CAMPBELL COUNTY", "KY");
  }
  
  @Override
  public String getFilter() {
    return "noreply@cisusa.org";
  }
}
