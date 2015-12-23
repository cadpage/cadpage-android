package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernPlusParser;

public class VARadfordParser extends DispatchSouthernPlusParser {
    
  public VARadfordParser() {
    super(CITY_LIST, "RADFORD", "VA");
  }

  private static final String[] CITY_LIST = new String[]{
    "RADFORD"
  };
}