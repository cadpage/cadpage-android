package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.dispatch.DispatchA19Parser;
/**
 * Walton County, GA
 */
public class GAWaltonCountyParser extends DispatchA19Parser {
  
  public GAWaltonCountyParser() {
    super("WALTON COUNTY", "GA");
  }
  
  @Override
  public String getFilter() {
    return "@spillman.co.walton.ga.us";
  }
}
