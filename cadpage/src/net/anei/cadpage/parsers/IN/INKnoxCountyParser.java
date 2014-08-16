package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.dispatch.DispatchSPKParser;

public class INKnoxCountyParser extends DispatchSPKParser {
  public INKnoxCountyParser() {
    super(CITY_LIST, "KNOX COUNTY", "IN");
  }

  @Override
  public String getFilter() {
    return "KnoxCoCAD@in.gov";
  }
  
  private static final String[] CITY_LIST = {
//    Cities and towns
    "BICKNELL",
    "BRUCEVILLE",
    "DECKER",
    "EDWARDSPORT",
    "EMISON",
    "FREELANDVILLE",
    "MONROE CITY",
    "OAKTOWN",
    "SANDBORN",
    "VINCENNES",
    "WESTPHALIA",
    "WHEATLAND",
// Townships
    "BUSSERON",
    "DECKER",
    "HARRISON",
    "JOHNSON",
    "PALMYRA",
    "STEEN",
    "VIGO",
    "VINCENNES",
    "WASHINGTON",
    "WIDNER",

  };
}
