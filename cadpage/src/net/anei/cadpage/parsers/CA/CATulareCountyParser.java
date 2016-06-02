package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.dispatch.DispatchA49Parser;

/*
Walker County, AL
*/

public class CATulareCountyParser extends DispatchA49Parser {

  public CATulareCountyParser() {
    super("TULARE COUNTY","CA");
  }
  
  @Override
  public String getFilter() {
    return "ADSI_CAD@co.tulare.ca.us";
  }
}
