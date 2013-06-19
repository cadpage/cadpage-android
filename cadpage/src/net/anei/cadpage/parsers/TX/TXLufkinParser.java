package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchA18Parser;


public class TXLufkinParser extends DispatchA18Parser {
  
  public TXLufkinParser() {
    super("ANGELINA COUNTY","TX");
  }
  
  @Override
  public String getFilter() {
    return "crimes@cityofkeller.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
}
