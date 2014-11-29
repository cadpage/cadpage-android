package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchA1Parser;

/**
 * Morrow County, OH
 */
public class OHMadisonCountyParser extends DispatchA1Parser {

  public OHMadisonCountyParser() {
    super("MADISON COUNTY", "OH"); 
  }
  
  @Override
  public String getFilter() {
    return "mcsocad@madisonsheriff.org";
  }
}
