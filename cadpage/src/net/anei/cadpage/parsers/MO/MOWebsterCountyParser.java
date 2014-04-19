package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;


public class MOWebsterCountyParser extends DispatchA27Parser {
  
  public MOWebsterCountyParser() {
    super("WEBSTER COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "noreply@cisusa.org";
  }
}
