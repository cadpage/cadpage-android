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
    "CALLISBURG",
    "GAINESVILLE",
    "LINDSAY",
    "MUENSTER",
    "OAK RIDGE",
    "VALLEY VIEW",
    "WHITESBORO",
    "ERA",
    "HOOD",
    "LAKE KIOWA",
    "BULCHER",
    "BURNS CITY",
    "DEXTER",
    "LEO",
    "LOIS",
    "MARYSVILLE",
    "MOUNTAIN SPRINGS",
    "MOSS LAKE",
    "MYRA",
    "ROSSTON",
    "PIONEER VALLEY",
    "PRAIRIE POINT",
    "SIVELLS BEND",
    "WALNUT BEND",
    "WOODBINE"
  };
}
