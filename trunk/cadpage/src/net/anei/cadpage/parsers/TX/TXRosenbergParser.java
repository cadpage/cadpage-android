package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchA19Parser;
/**
 * Rosenberg, TX
 */
public class TXRosenbergParser extends DispatchA19Parser {
  
  public TXRosenbergParser() {
    super("ROSENBERG", "TX");
  }
  
  @Override
  public String getFilter() {
    return "@alert.active911.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
}
