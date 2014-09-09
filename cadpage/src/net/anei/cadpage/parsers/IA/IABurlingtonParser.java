package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.dispatch.DispatchA28Parser;


public class IABurlingtonParser extends DispatchA28Parser {
  
  public IABurlingtonParser() {
    super(CITY_LIST, "BURLINGTON", "IA");
  }
  
  @Override
  public String getFilter() {
    return "SWMAIL@BURLINGTONIOWA.ORG";
  }
  
  private static final String[] CITY_LIST =new String[]{
 
    "WEST BURLINGTON",
    "BURLINGTON"

  };
}
