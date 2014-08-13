package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;


/**
 * Lenawee County, MI
 */
public class MILenaweeCountyBParser extends DispatchA9Parser {
  
  public MILenaweeCountyBParser() {
    super(null, "LENAWEE COUNTY", "MI");
  }
  
  @Override
  public String getFilter() {
    return "paula.boehm@lenawee.mi.us";
  }
  
}
