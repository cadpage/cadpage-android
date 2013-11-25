package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.dispatch.DispatchA25Parser;


public class MOClintonCountyParser extends DispatchA25Parser {
  
  public MOClintonCountyParser() {
    super("CLINTON COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "@clintoncosheriff.org,@plattsburgfire.org" ;  }
  
}
