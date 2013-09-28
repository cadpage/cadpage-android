package net.anei.cadpage.parsers.OR;


import net.anei.cadpage.parsers.dispatch.DispatchA22Parser;



public class ORJeffersonCountyParser extends DispatchA22Parser {
  
  public ORJeffersonCountyParser() {
    super("JEFFERSON COUNTY", "OR");
  }
  
  @Override
  public String getFilter() {
    return "april.steam@tcdispatch.org";
  }
}
