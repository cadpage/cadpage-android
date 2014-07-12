package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.dispatch.DispatchA25Parser;


public class KSRiceCountyParser extends DispatchA25Parser {
 
  public KSRiceCountyParser() {
    super("RICE COUNTY", "KS");
  }
  
  @Override
  public String getFilter() {
    return "enterpolalerts@rcsoks.org";  
  }
}
