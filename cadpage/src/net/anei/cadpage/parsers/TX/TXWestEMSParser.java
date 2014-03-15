package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;



public class TXWestEMSParser extends DispatchProQAParser {
  
  private static final String DEF_STATE = "TX";
  private static final String DEF_CITY = "WEST";
    
  public TXWestEMSParser() {
    super(DEF_CITY, DEF_STATE, null);
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
