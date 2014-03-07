package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;

public class TXHuntCountyParser extends DispatchProQAParser {
  
  private static final String DEF_STATE = "TX";
  private static final String DEF_COUNTY = "HUNT COUNTY";
    
  public TXHuntCountyParser() {
    super(DEF_COUNTY, DEF_STATE, null);
  }
  
  @Override
  public String getFilter() {
    return "smtppagingntxcad@emsc.net";
  }
  
}
