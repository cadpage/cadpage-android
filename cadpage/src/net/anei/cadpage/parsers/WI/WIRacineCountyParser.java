package net.anei.cadpage.parsers.WI;

import net.anei.cadpage.parsers.dispatch.DispatchProphoenixParser;

public class WIRacineCountyParser extends DispatchProphoenixParser {
  
  public WIRacineCountyParser() {
    super("RACINE COUNTY", "WI");
  }
  
  @Override
  public String getFilter() {
    return "PhoenixAlert@goracine.org";
  }
}
