package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.dispatch.DispatchA19Parser;

public class INRandolphCountyParser extends DispatchA19Parser {
  
  public INRandolphCountyParser() {
    super("RANDOLPH COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "tyler.lyman@active911.com,randolph.hsem@randolph.in.gov,20704-z3XiTRXFTV8DvC6s@alert.active911.com,911@wayneco.us,dispatch@co.wayne.in.us";
  }
}
