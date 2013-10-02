package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.dispatch.DispatchA31Parser;


public class TXBrazoriaCountyAParser extends DispatchA31Parser {
  
  public TXBrazoriaCountyAParser() {
    super("MPD", "BRAZORIA COUNTY", "TX");
  }
  
  @Override
  public String getFilter() {
    return "cadpaging@manvelpd.org";
  }
}
