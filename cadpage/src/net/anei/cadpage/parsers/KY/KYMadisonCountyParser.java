package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * Madison County, KY
 */
public class KYMadisonCountyParser extends DispatchA27Parser {
  
  public KYMadisonCountyParser() {
    super("MADISON COUNTY", "KY","[A-Z]+\\d+[A-Z]?|[A-Z]{1,3}FD}");
  }
  
  @Override
  public String getFilter() {
    return "noreply@cisusa.org,noreply@cisusa.org";
  }
 
}
