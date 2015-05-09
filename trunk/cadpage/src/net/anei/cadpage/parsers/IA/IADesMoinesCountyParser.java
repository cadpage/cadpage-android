package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.dispatch.DispatchA47Parser;


public class IADesMoinesCountyParser extends DispatchA47Parser {
  
  public IADesMoinesCountyParser() {
    super("Dispatch info", CITY_LIST, "DES MOINES COUNTY", "IA");
  }
  
  @Override
  public String getFilter() {
    return "SWMAIL@BURLINGTONIOWA.ORG";
  }
  
  private static final String[] CITY_LIST =new String[]{
    "BURLINGTON",
    "DANVILLE",
    "MEDIAPOLIS",
    "MIDDLETOWN",
    "WAPELLO",
    "WEST BURLINGTON"
  };
}
