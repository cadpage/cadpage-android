package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.dispatch.DispatchProphoenixParser;



public class NJWayneTownshipParser extends DispatchProphoenixParser {
  
  public NJWayneTownshipParser() {
    super("WAYNE TOWNSHIP", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "cad@waynetownship.com,5417047704";
  }
}
