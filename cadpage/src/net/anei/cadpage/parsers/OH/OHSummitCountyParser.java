package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.GroupBestParser;

/*
 * Summit County, OH
 */

public class OHSummitCountyParser extends GroupBestParser {
  
  public OHSummitCountyParser() {
    super(new OHSummitCountyAParser(),
           new OHSummitCountyBParser(),
           new OHSummitCountyCParser(),
           new OHSummitCountyDParser(),
           new OHSummitCountyEParser());
  }
}
