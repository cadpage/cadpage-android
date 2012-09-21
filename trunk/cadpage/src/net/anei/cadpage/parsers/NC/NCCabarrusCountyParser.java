package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.GroupBestParser;

/* 
Cabarrus County, NC
*/

public class NCCabarrusCountyParser extends GroupBestParser {
  
  public NCCabarrusCountyParser() {
    super(new NCCabarrusCountyAParser(), new NCCabarrusCountyBParser());
  }
}
