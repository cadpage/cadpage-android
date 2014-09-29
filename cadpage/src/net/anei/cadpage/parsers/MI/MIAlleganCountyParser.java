package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;


/**
 * Allegan County, MI
 */
public class MIAlleganCountyParser extends DispatchA9Parser {
  
  public MIAlleganCountyParser() {
    super(null, "ALLEGAN COUNTY", "MI");
  }
  
  @Override
  public String getFilter() {
    return "centraldispatch@allegancounty.org";
  }
  
}
