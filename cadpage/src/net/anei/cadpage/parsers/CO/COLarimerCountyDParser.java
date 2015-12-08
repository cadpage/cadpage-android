package net.anei.cadpage.parsers.CO;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA41Parser;

public class COLarimerCountyDParser extends DispatchA41Parser {
  
  public   COLarimerCountyDParser() {
    super(CITY_CODES, "LARIMER COUNTY", "CO", "[A-Z]{1,2}FD"); 
  }
  
  @Override
  public String getFilter() {
    return "crisppaging@fcgov.com";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "FTC", "FORT COLLINS"
  });
}
