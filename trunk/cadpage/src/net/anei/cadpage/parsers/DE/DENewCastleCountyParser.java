package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.GroupBestParser;

/*
New Castle County, DE

 */

public class DENewCastleCountyParser extends GroupBestParser {
  
  public DENewCastleCountyParser() {
    super(new DENewCastleCountyAParser(),
           new DENewCastleCountyBParser(),
           new DENewCastleCountyCParser());
  }
}


