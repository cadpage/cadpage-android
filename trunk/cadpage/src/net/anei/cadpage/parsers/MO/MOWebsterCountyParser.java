package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.dispatch.DispatchA25Parser;


public class MOWebsterCountyParser extends DispatchA25Parser {
  
  public MOWebsterCountyParser() {
    super("WEBSTER COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "EnterpolAlerts@webster911.org";
  }
}
