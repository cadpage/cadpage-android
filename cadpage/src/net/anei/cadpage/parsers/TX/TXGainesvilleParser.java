package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchA18Parser;


public class TXGainesvilleParser extends DispatchA18Parser {
  
  public TXGainesvilleParser() {
    super(CITY_LIST, "COOKE COUNTY","TX");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
 
  @Override
  public String getFilter() {
    return "active911@gvps.org";
  }
  
  private static String[] CITY_LIST = new String[]{
    "Callisburg",
    "Gainesville",
    "Lindsay",
    "Muenster",
    "Oak Ridge",
    "Valley View",
    "Whitesboro",
    "Era",
    "Hood",
    "Lake Kiowa",
    "Bulcher",
    "Burns City",
    "Dexter",
    "Leo",
    "Lois",
    "Marysville",
    "Mountain Springs",
    "Moss Lake",
    "Myra",
    "Rosston",
    "Pioneer Valley",
    "Prairie Point",
    "Sivells Bend",
    "Walnut Bend",
    "Woodbine"
  };
}
