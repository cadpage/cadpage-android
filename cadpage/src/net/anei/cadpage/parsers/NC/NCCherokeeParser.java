package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;


public class NCCherokeeParser extends DispatchB2Parser {

  public NCCherokeeParser() {
    super("CHEROKEE 911:", "CHEROKEE", "NC");
  }
  
  @Override
  public String getFilter() {
    return "CHEROKEE 911@mydomain.com,Cherokee@mydomain.com";
  }
}