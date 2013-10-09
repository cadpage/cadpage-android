package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchA18Parser;


public class TXKellerParser extends DispatchA18Parser {
  
  public TXKellerParser() {
    super(CITY_LIST, "TARRANT COUNTY","TX");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
 
  @Override
  public String getFilter() {
    return "crimes@cityofkeller.com";
  }
  
  private static String[] CITY_LIST = new String[]{
    "ARLINGTON",
    "AZLE",
    "BEDFORD",
    "BENBROOK",
    "BLUE MOUND",
    "BURLESON",
    "COLLEYVILLE",
    "CROWLEY",
    "DALWORTHINGTON GARDENS",
    "EDGECLIFF VILLAGE",
    "EULESS",
    "EVERMAN",
    "FLOWER MOUND",
    "FOREST HILL",
    "FORT WORTH",
    "GRAPEVINE",
    "GRAND PRAIRIE",
    "HALTOM CITY",
    "HASLET",
    "HURST",
    "KELLER",
    "KENNEDALE",
    "LAKE WORTH",
    "LAKESIDE",
    "MANSFIELD",
    "NEWARK",
    "NORTH RICHLAND HILLS",
    "PANTEGO",
    "PELICAN BAY",
    "RENDON",
    "RICHLAND HILLS",
    "RIVER OAKS",
    "SAGINAW",
    "SANSOM PARK",
    "SOUTHLAKE",
    "TROPHY CLUB",
    "WATAUGA",
    "WESTLAKE",
    "WESTOVER HILLS",
    "WESTWORTH VILLAGE",
    "WHITE SETTLEMENT"
  };
}
