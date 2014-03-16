package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;



public class TXWestEMSParser extends DispatchProQAParser {
    
  public TXWestEMSParser() {
    super("WEST", "TX", null);
  }
  
  @Override
  public String getFilter() {
    return "cadpage@etmc.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }

}
