package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.dispatch.DispatchA28Parser;


public class IADesMoinesCountyParser extends DispatchA28Parser {
  
  public IADesMoinesCountyParser() {
    super(CITY_LIST, "DES MOINES COUNTY", "IA");
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
