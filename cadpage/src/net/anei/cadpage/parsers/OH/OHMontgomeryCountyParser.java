package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.GroupBestParser;

/*
 * Montgomery County, OH
 */

public class OHMontgomeryCountyParser extends GroupBestParser {
  
  public OHMontgomeryCountyParser() {
    super(new OHMontgomeryCountyAParser(), new OHMontgomeryCountyBParser());
  }
}
