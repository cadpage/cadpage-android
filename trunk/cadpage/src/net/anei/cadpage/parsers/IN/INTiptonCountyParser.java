package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

public class INTiptonCountyParser extends DispatchOSSIParser {
  
  public INTiptonCountyParser() {
    super("TIPTON COUNTY", "IN",
           "UNIT CALL MAP? ADDR INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@tipco.com";
  }
  
  @Override
  public Field  getField(String name) {
    if (name.equals("MAP")) return new MapField("\\d+|CITY");
    return super.getField(name);
  }
}
