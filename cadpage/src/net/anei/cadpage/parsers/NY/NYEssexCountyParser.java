package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;



public class NYEssexCountyParser extends DispatchA13Parser {
  
  public NYEssexCountyParser() {
    super("ESSEX COUNTY", "NY");
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("DISPATCHED")) return new SkipField("DISPATCHED", true);
    return super.getField(name);
  }
  
}
