package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * Bethal, CT
 */

public class CTBethalParser extends DispatchA27Parser {
  
  public CTBethalParser() {
    super("BETHAL", "CT", "[A-Z]+\\d+");
  }
  
  @Override
  public String getFilter() {
    return "noreply@bethelpd.com";
  }
}
