package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.dispatch.DispatchA49Parser;

/*
Anne Arundel County, MD (ADSiCAD)
*/

public class ALWalkerCountyParser extends DispatchA49Parser {

  public ALWalkerCountyParser() {
    super("WALKER COUNTY","AL");
  }
  
  @Override
  public String getFilter() {
    return "cadalert@walker911.org";
  }
}
