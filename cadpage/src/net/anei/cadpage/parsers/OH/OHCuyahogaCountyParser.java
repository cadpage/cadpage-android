package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.GroupBestParser;

/*
 * Cuyahoga County, OH
 */

public class OHCuyahogaCountyParser extends GroupBestParser {
  
  public OHCuyahogaCountyParser() {
    super(new OHCuyahogaCountyAParser(), new OHCuyahogaCountyBParser());
  }
}
