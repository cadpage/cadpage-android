package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.dispatch.DispatchA20Parser;

/**
 * Oroville, CA
 */
public class CAOrovilleParser extends DispatchA20Parser {
  
  public CAOrovilleParser() {
    super("OROVILLE", "CA");
  }
  
  @Override
  public String getFilter() {
    return "@OROPD.ORG";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
}
