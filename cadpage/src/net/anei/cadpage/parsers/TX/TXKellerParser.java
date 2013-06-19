package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchA18Parser;


public class TXKellerParser extends DispatchA18Parser {
  
  public TXKellerParser() {
    super("TARRANT COUNTY","TX");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
 
  @Override
  public String getFilter() {
    return "crimes@cityofkeller.com";
  }
}
