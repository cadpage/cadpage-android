package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.dispatch.DispatchA28Parser;


public class IAWorthCountyParser extends DispatchA28Parser {
  
  public IAWorthCountyParser() {
    super(CITY_LIST, "WORTH COUNTY", "IA");
  }
  
  @Override
  public String getFilter() {
    return "swmail@worthcounty.org";
  }

  private static final String[] CITY_LIST =new String[]{

    //cities
    
    "FERTILE",
    "GRAFTON",
    "HANLONTOWN",
    "JOICE",
    "KENSETT",
    "MANLY",
    "NORTHWOOD",

    //Unincorporated community

    "BOLAN",

    //Townships

    "BARTON",
    "BRISTOL",
    "BROOKFIELD",
    "DANVILLE",
    "DEER CREEK",
    "FERTILE",
    "GROVE",
    "HARTLAND",
    "KENSETT",
    "LINCOLN",
    "SILVER LAKE",
    "UNION",
    
    // Cero Gorda County
    "PLYMOUNTH",
    
    // Mitchell County
    "SAINT ANSGAR"
  };
}
