package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;

/**
 * Jefferson County, AL
 */
public class ALJeffersonCountyBParser extends DispatchA9Parser {
  
  public ALJeffersonCountyBParser() {
    super("JEFFERSON COUNTY", "AL");
  }
  
  @Override
  public String getFilter() {
    return "Brian.Bonner@homewoodal.org";
  }
}


