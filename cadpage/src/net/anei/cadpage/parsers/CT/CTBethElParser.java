package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * Bethal, CT
 */

public class CTBethElParser extends DispatchA27Parser {
  
  public CTBethElParser() {
    super("BETHEL", "CT", "[A-Z]+\\d+|[A-Z]+EMS|[A-Z]+FD|TWR");
  }
  
  @Override
  public String getFilter() {
    return "noreply@bethelpd.com";
  }
}
