package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.dispatch.DispatchA33Parser;

public class VAGloucesterCountyParser extends DispatchA33Parser {
  public VAGloucesterCountyParser() {
    super("GLOUCESTER COUNTY", "VA", "X");
  }
  
  @Override
  public String getFilter() {
    return "GCSO@GLOUCESTERVA.INFO";
  }
}
