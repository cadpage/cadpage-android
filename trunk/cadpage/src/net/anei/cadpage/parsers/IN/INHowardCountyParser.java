package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;

/**
 * Howard County, IN
 */
public class INHowardCountyParser extends DispatchCiscoParser {
  
  public INHowardCountyParser() {
    super("HOWARD COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "cisco.paging@co.howard.in.us";
  }
}
