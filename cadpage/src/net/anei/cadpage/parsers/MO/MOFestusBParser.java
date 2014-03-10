package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.dispatch.DispatchA33Parser;


public class MOFestusBParser extends DispatchA33Parser {
    
  public MOFestusBParser() {
    super("FESTUS", "MO", "Closed");
  }
  
  @Override
  public String getFilter() {
    return "JBITTER@CITYOFFESTUS.ORG";
  }
  
}
