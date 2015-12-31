package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

public class MNWasecaCountyParser extends DispatchA27Parser {
  
  public MNWasecaCountyParser() {
    super("WASECA COUNTY", "MN", "[A-Z]{3,4}");
  }
  
  @Override
  public String getFilter() {
    return "noreply@cisusa.org";
  }
}
