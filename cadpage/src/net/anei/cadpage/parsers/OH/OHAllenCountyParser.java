package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;

/**
 * Allen County, OH
 */
public class OHAllenCountyParser extends DispatchCiscoParser {

  public OHAllenCountyParser() {
    super("ALLEN COUNTY", "OH");
  }

  @Override
  public String getFilter() {
    return "interface@acso-oh.us";
  }
}
  