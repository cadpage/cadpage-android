package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.dispatch.DispatchA25Parser;


public class MOIronCountyParser extends DispatchA25Parser {
  
  public MOIronCountyParser() {
    super("IRON COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "ironcountydisp@centurylink.net";
  }
}
