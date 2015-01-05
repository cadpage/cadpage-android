package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * Blue Earth County, MN
 */
public class MNFaribaultCountyParser extends DispatchA27Parser {
  
  public MNFaribaultCountyParser() {
    super("FARIBAULT COUNTY", "MN", "[A-Z]{3}\\d{3}[A-Z]{2}");
  }
  
  @Override
  public String getFilter() {
    return "noreply@cisusa.org";
  }
}
  