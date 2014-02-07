package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.dispatch.DispatchA20Parser;

/**
 * Rocklin, CA
 */
public class CARocklinParser extends DispatchA20Parser {
  
  public CARocklinParser() {
    super("ROCKLIN", "CA");
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
