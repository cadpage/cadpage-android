package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.GroupBestParser;

/*
 * Wayne County, OH
 */

public class OHSummitCountyParser extends GroupBestParser {
  
  public OHSummitCountyParser() {
    super(new OHSummitCountyAParser(),
           new OHSummitCountyBParser());
  }
}
