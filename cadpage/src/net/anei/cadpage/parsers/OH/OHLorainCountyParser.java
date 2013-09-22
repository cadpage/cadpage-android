package net.anei.cadpage.parsers.OH;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class OHLorainCountyParser extends DispatchOSSIParser {

  public OHLorainCountyParser() {
    super(CITY_CODES, "LORAIN COUNTY", "OH",
           "( CANCEL | FYI CALL ) ADDR! PLACE? CITY");
  }
  
  @Override
  public String getFilter() {
    return "cad@lorainco911.com";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
     "CAR", "CARLISLE TWP" 
  });
}
