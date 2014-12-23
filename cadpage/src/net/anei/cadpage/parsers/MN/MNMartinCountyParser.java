package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

// Martin County, MN
 

public class MNMartinCountyParser extends DispatchA27Parser {
  
  public MNMartinCountyParser() {
    super("MARTIN COUNTY", "MN", "\\d{8}");
  }
  
  @Override
  public String getFilter() {
    return "noreply@cisusa.org";
  }
}
