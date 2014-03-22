package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

public class KYLawrenceCountyParser extends DispatchB2Parser {
  
  public KYLawrenceCountyParser() {
    super("LAWRENCE_911:",CITY_LIST, "LAWRENCE COUNTY", "KY");
  }
  
  @Override
  public String getFilter() {
    return "LAWRENCE_911@lycomonline.com,Interact@lycomonline.com";
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BLAINE",
    "LOUISA",
    "LOWMANSVILLE",
    "FALLSBURG",
    "WEBBVILLE",
    "KISE",
    "CHERRYVILLE",
    "ULYSSES"

    };


}
