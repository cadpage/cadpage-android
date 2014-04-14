package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;

public class NCCherokeeParser extends DispatchB2Parser {

  public NCCherokeeParser() {
    super("CHEROKEE 911:", CITY_LIST, "CHEROKEE", "NC");
  }
  
  @Override
  public String getFilter() {
    return "CHEROKEE 911@mydomain.com,Cherokee@mydomain.com";
  }
  private static final String[] CITY_LIST = new String[]{
    
    "BIGWITCH",
    "BIG COVE",
    "BIRDTOWN",
    "BRYSON CITY",
    "CHEROKEE",
    "PAINTTOWN",
    "PAINT TOWN",
    "VERIZON",
    "WHITTIER",
    "WOLFETOWN",   
    "YELLOWHILL",
    
  };
  
}