package net.anei.cadpage.parsers.NV;

import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;


/**
 * Elko County, NV
 */
public class NVElkoCountyParser extends DispatchA9Parser {
    
  public NVElkoCountyParser() {
    super(null,"ELKO COUNTY", "NV");
  }
  
  @Override
  public String getFilter() {
    return "ElkoDispatch@ci.elko.nv.us";
  }
  
}
