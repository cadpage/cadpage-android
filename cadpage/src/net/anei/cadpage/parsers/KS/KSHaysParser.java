package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.dispatch.DispatchA25Parser;


public class KSHaysParser extends DispatchA25Parser {
  
  public KSHaysParser() {
    super("HAYS", "KS");
  }
  
  @Override
  public String getFilter() {
    return "1-HPDDispatch@haysusa.com";
  }
}
