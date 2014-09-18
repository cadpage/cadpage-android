package net.anei.cadpage.parsers.LA;

import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;



public class LAWestBatonRougeParishParser extends DispatchA13Parser {
  
  public LAWestBatonRougeParishParser() {
    super(CITY_LIST, "WEST BATON ROUGE PARISH", "LA");
  }
  
  @Override
  public String getFilter() {
    return "@wbrcouncil.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("DISPATCHED")) return new SkipField("REQ DISPATCH|DISPATCHED|ENROUTE|ONSCENE", true);
    return super.getField(name);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ADDIS",
    "BRUSLY",
    "PORT ALLEN",
    "ANTONIO",
    "BELMONT",
    "BUECHE",
    "CHAMBERLIN",
    "DEVALLS",
    "ERWINVILLE",
    "ITHRA",
    "KAHNS",
    "LOBDELL",
    "LUKEVILLE"
  };
}
