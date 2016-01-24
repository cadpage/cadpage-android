package net.anei.cadpage.parsers.MI;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA50Parser;


public class MIKalamazooCountyParser extends DispatchA50Parser {
  
  public MIKalamazooCountyParser() {
    super(CITY_CODES, null, "KALAMAZOO COUNTY", "MI");
    }
  
  @Override
  public String getFilter() {
    return "kdpshelpdesk@kalamazoocity.org";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "COMS",  "COMSTOCK",
      "OSHT",  "OSHTEMO CHATER TWP",
      "PORT",  "PORTAGE",
      "TEXA",  "TEXAS CHARTER TWP"

  });
}
