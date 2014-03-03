package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;



public class NCWilkesCountyParser extends DispatchOSSIParser {
  
  public NCWilkesCountyParser() {
    super("WILKES COUNTY", "NC",
           "SRC ID DATETIME CALL ADDR!");
  }
  
  @Override
  public String getFilter() {
    return "CAD@wilkes.nc.local,CAD@wilkescounty.net";
  }
}
