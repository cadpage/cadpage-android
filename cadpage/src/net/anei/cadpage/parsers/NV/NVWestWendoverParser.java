package net.anei.cadpage.parsers.NV;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * West Wendover, NV
 */

public class NVWestWendoverParser extends DispatchA27Parser {
  
  public NVWestWendoverParser() {
    super("ELKO", "NV");
  }
  
  @Override
  public String getFilter() {
    return "noreply@cisusa.org";
  }
}
