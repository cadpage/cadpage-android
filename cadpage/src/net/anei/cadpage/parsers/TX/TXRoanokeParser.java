package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchA18Parser;


public class TXRoanokeParser extends DispatchA18Parser {
  
  public TXRoanokeParser() {
    super(CITY_LIST, "ROANOKE","TX");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
 
  @Override
  public String getFilter() {
    return "prc@roanokepolice.com";
  }
  
  private static String[] CITY_LIST = new String[]{
    "ROANOKE",
    "FORT WORTH",
    "DENTON"
  };
}
