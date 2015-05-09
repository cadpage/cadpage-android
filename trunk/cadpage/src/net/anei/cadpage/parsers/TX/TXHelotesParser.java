
package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchA53Parser;


public class TXHelotesParser extends DispatchA53Parser {

  public TXHelotesParser() {
    super("HELOTES", "TX");
  }
  
  @Override
  public String getFilter() {
    return "@Helotes-TX.gov";
  }
  
}
