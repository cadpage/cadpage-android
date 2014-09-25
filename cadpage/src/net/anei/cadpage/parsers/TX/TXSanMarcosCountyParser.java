package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * San Marcos County, TX
 */

public class TXSanMarcosCountyParser extends DispatchA27Parser {
  
  public TXSanMarcosCountyParser() {
    super("SAN MARCOS COUNTY", "TX", "\\d{8}");
  }
  
  @Override
  public String getFilter() {
    return "noreply@sanmarcostx.gov";
  }
}
