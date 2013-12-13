package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.GroupBestParser;

/**
 * Camden County, GA
 */
public class GABullochCountyParser extends GroupBestParser {
  
  public GABullochCountyParser() {
    super(new GACamdenCountyAParser(), new GACamdenCountyBParser());
  }
}
