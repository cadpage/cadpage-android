package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * Jasper County, IN
 */

public class INJasperCountyParser extends DispatchA27Parser {
  
  public INJasperCountyParser() {
    super("JASPER COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "noreply@cisusa.org";
  }
}
