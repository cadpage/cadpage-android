package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.dispatch.DispatchA20Parser;

/**
 * Umatilla County, OR
 */
public class ORUmatillaCountyParser extends DispatchA20Parser {
  
  public ORUmatillaCountyParser() {
    super("UMATILLA COUNTY", "OR");
  }
  
  @Override
  public String getFilter() {
    return "notifier@umatillacounty.net";
  }
}
