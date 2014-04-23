package net.anei.cadpage.parsers.ID;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA31Parser;


public class IDGoodingCountyParser extends DispatchA31Parser {
  
  public IDGoodingCountyParser() {
   this("GOODING COUNTY", "ID");
  }
  
  public IDGoodingCountyParser(String defCity, String defState) {
    super("SIRCOMM", CITY_CODES, defCity, defState);
  }
  
  @Override
  public String getFilter() {
    return "PagingService@sircomm.com";
  }

  @Override
  public String getAliasCode() {
    return "IDGoodingCounty";
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "HAZ AREA",  "HAZELTON",
      "KMB AREA",  "KIMBERLY",
      "MURT AREA", "MURTAUGH",
      "WND AREA",  "WENDELL"
  });
}
