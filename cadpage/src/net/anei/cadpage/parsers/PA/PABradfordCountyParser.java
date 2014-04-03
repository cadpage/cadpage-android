package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.dispatch.DispatchA4Parser;



public class PABradfordCountyParser extends DispatchA4Parser {
  
  public PABradfordCountyParser() {
    super("BRADFORD COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "911relay@bradfordco.org";
  }

}
