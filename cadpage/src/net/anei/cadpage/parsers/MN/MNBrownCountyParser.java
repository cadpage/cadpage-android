package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

public class MNBrownCountyParser extends DispatchA27Parser {
  
  public MNBrownCountyParser() {
    super("BROWN COUNTY", "MN", "\\d{8}");
  }
  
  @Override
  public String getFilter() {
    return "noreply@cisusa.org";
  }
}
