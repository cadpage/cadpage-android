package net.anei.cadpage.parsers.OH;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA1Parser;



public class OHLovelandParser extends DispatchA1Parser {
  
  public OHLovelandParser() {
    super(CITY_CODES, "LOVELAND", "OH");
  }
  
  @Override
  public String getFilter() {
    return "dispatcher@safety-center.org";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "LOVELD", "LOVELAND",
      "SYMMTP", "SYMMES TWP"
  });
}
