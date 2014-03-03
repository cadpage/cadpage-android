package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.GroupBestParser;

/*
Clarion County, PA
 */


public class PAClarionCountyParser extends GroupBestParser {
  
  public PAClarionCountyParser() {
    super(new PAClarionCountyAParser(), new PAClarionCountyBParser());
  }
}
