package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.dispatch.DispatchA49Parser;

public class TNDyerCountyParser extends DispatchA49Parser {


  public TNDyerCountyParser() {
    super("DYER COUNTY","TN");
  }
  
  @Override
  public String getFilter() {
    return "cadalerts@dyersburgtn.gov";
  }
}
