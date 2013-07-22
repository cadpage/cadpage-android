package net.anei.cadpage.parsers.VA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/**
 * Warren County, VA
 */
public class VAWarrenCountyParser extends DispatchDAPROParser {
  
  public VAWarrenCountyParser() {
    super(CITY_CODE_TABLE, "WARREN COUNTY", "VA");
  }
  
  @Override
  public String getFilter() {
    return "mailbox@warrencountysheriff.org";
  }
  
  private static final Properties CITY_CODE_TABLE =
    buildCodeTable(new String[]{
        "BEN", "BENTONVILLE",
        "FRO", "FRONT ROYAL",
        "LIN", "LINDEN"
    });
}