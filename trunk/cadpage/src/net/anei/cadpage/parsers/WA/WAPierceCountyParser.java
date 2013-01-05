package net.anei.cadpage.parsers.WA;

import net.anei.cadpage.parsers.GroupBestParser;

/**
 * Pierce County, WA
 */
public class WAPierceCountyParser extends GroupBestParser {
  
  public WAPierceCountyParser() {
    super(new WAPierceCountyAParser(), new WAPierceCountyBParser());
  }
}
