package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;


public class NCSampsonCountyParser extends DispatchA3Parser {
  
  public NCSampsonCountyParser() {
    super(0, "EMS:", "SAMPSON COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "EMS@sampsonnc.com";
  }
}
