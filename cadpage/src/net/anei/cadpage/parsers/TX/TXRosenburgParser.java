package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchA19Parser;
/**
 * Rosenburg, TX
 */
public class TXRosenburgParser extends DispatchA19Parser {
  
  public TXRosenburgParser() {
    super("ROSENBURG", "TX");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
 
}
