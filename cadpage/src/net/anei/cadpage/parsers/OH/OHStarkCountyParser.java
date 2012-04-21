package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.GroupBestParser;

/*
 * Stark County, OH
 */

public class OHStarkCountyParser extends GroupBestParser {
  
  public OHStarkCountyParser() {
    super(new OHStarkCountyCencommParser(),
           new OHStarkCountyRedcenterParser());
  }
}
