package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchA18Parser;


public class TXCrowleyParser extends DispatchA18Parser {
  
  public TXCrowleyParser() {
    super(CITY_LIST, "CROWLEY","TX");
  }
 
  @Override
  public String getFilter() {
    return "crimespaging@ci.crowley.tx.us";
  }

  private static String[] CITY_LIST = new String[]{
    "CROWLEY"
  };
}
