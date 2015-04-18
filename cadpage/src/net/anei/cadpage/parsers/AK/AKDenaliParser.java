package net.anei.cadpage.parsers.AK;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * Coffee County, AL
 */

public class AKDenaliParser extends DispatchA27Parser {
  
  public AKDenaliParser() {
    super("", "AK", "[A-Z]+\\d+|[A-Z]");
  }
  
  @Override
  public String getFilter() {
    return "noreply@cisusa.org";
  }
}
