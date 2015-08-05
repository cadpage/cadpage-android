package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.dispatch.DispatchProphoenixParser;

public class NJGloucesterCountyCParser extends DispatchProphoenixParser {
  
  public NJGloucesterCountyCParser() {
    super(NJGloucesterCountyParser.CITY_CODES, "GLOUCESTER COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "@private.gloucesteralert.com,gccad@co.gloucester.nj.us";
  } 
  
}
