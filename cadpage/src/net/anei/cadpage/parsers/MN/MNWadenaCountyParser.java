package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * Wadena County, MN
 */

public class MNWadenaCountyParser extends DispatchA27Parser {
  
  public MNWadenaCountyParser() {
    super("WADENA COUNTY", "MN");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@co.wadena.mn.us";
  }
}
