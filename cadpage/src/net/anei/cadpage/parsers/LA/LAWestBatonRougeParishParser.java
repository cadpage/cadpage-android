package net.anei.cadpage.parsers.LA;

import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;



public class LAWestBatonRougeParishParser extends DispatchA13Parser {
  
  public LAWestBatonRougeParishParser() {
    super("WEST BATON ROUGE PARISH", "LA");
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("DISPATCHED")) return new SkipField("DISPATCHED|ENROUTE", true);
    return super.getField(name);
  }
  
}
