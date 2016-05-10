package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.dispatch.DispatchBCParser;

public class KSLabetteCountyBParser extends DispatchBCParser {
  
  public KSLabetteCountyBParser() {
    super("LABETTE COUNTY", "KS");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@LABETTECOUNTY.COM";
  }
}
