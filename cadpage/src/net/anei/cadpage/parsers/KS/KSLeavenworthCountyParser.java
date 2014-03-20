package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.dispatch.DispatchProphoenixParser;

/**
 * Leavenworth County, KS
 */
public class KSLeavenworthCountyParser extends DispatchProphoenixParser {
    
  public KSLeavenworthCountyParser() {
    super("LEAVENWORTH COUNTY", "KS");
  }
  
  @Override
  public String getFilter() {
    return "FireDispatch@firstcity.org";
  }
  
}
