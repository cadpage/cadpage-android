package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class VASmythCountyParser extends DispatchSouthernParser {
  
  public VASmythCountyParser() {
    super(CITY_LIST, "SMYTH COUNTY", "VA", DSFLAG_OPT_DISPATCH_ID | DSFLAG_LEAD_PLACE);
  }

  @Override
  public String getFilter() {
    return "@smythcounty.org";
  }
  
  private static final String[] CITY_LIST = new String[]{
    "CHILHOWIE",
    "MARION",
    "SALTVILLE",
    
    "ADWOLF",
    "ATKINS",
    "SEVEN MILE FORD",
    "SUGAR GROVE"
  }; 
}
