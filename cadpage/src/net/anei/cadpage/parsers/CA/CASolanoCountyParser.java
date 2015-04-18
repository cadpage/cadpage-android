package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.dispatch.DispatchA20Parser;

/**
 * Solano County, CA
 */
public class CASolanoCountyParser extends DispatchA20Parser {
  
  public CASolanoCountyParser() {
    super("SOLANO COUNTY", "CA");
  }
  
  @Override
  public String getFilter() {
    return "irimssec@fairfield.ca.gov";
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    addr = stripFieldEnd(addr, " OFF");
    addr = stripFieldEnd(addr, " ON");
    return super.adjustMapAddress(addr);
  }
}
