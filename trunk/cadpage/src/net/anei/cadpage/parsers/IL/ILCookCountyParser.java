package net.anei.cadpage.parsers.IL;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA21Parser;


public class ILCookCountyParser extends DispatchA21Parser {
  
  public ILCookCountyParser() {
    super(CITY_CODES, "COOK COUNTY", "IL");
  }
  
  @Override
  public String getFilter() {
    return "911@NWCDS.org";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "MP", "MT PROSPECT"
  });
}
