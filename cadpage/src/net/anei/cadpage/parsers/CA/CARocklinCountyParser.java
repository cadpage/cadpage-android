package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.dispatch.DispatchA20Parser;

/**
 * Rocklin County, CA
 */
public class CARocklinCountyParser extends DispatchA20Parser {
  
  public CARocklinCountyParser() {
    super("ROCKLIN COUNTY", "CA");
  }
  
  @Override
  public String getFilter() {
    return "@rocklin.ca.us";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
}
