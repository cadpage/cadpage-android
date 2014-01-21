package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.GroupBestParser;

/*
 * Portage County, OH
 */

public class OHPortageCountyParser extends GroupBestParser {
  
  public OHPortageCountyParser() {
    super(new OHPortageCountyAParser(), new OHPortageCountyBParser());
  }
}
