package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.dispatch.DispatchBCParser;


public class ALCleburneCountyParser extends DispatchBCParser {
  public ALCleburneCountyParser() {
    super("CLEBURNE COUNTY", "AL");
  }
   
  @Override
  public String getFilter() {
    return "911@CLEBURNECOUNTY.US";
  }
}
