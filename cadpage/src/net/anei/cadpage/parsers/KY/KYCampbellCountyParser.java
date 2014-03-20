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
    return "noreply@cisusa.org,do-not-reply@cccdcky.org";
  }
  
  @Override
  public int getMapFlags() {
    
    // We really don't have enough examples to make this determination, but
    // give dispatch the benefit of doubt.
    return MAP_FLG_PREFER_GPS;
  }
}
