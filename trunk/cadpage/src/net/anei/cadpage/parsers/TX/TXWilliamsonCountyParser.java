package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.GroupBestParser;

/**
 * Williamson County, TX
 */
public class TXWilliamsonCountyParser extends GroupBestParser {
  
  public TXWilliamsonCountyParser() {
    super(new TXWilliamsonCountyAParser(), new TXWilliamsonCountyBParser());
  }
}
