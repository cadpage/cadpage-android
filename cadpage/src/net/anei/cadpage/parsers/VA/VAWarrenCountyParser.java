package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Warren County, VA
 */
public class VAWarrenCountyParser extends DispatchSouthernParser {
  
  public VAWarrenCountyParser() {
    super(CITY_LIST, "WARREN COUNTY", "VA", DSFLAG_OPT_DISPATCH_ID | DSFLAG_FOLLOW_CROSS);
  }
  
  @Override
  public String getFilter() {
    return "mailbox@warrencountysheriff.org";
  }

  private static final String[] CITY_LIST = new String[]{
    "FRONT ROYAL",
    "ASHBY",
    "BENTONVILLE",
    "BETHEL",
    "BROWNTOWN",
    "BUCKTON",
    "CEDARVILLE",
    "HAPPY CREEK",
    "HOWELLSVILLE",
    "KARO",
    "LIMETON",
    "LINDEN",
    "MILLDALE",
    "NINEVEH",
    "OVERALL",
    "RELIANCE",
    "RIVERTON",
    "ROCKLAND",
    "WATERLICK",
    
    // Frederick County
    "MIDDLETOWN"
  };
}