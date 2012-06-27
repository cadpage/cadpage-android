package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.GroupBestParser;

/* 
Cabarrus County, NC
*/

public class NCGastonCountyParser extends GroupBestParser {
  
  public NCGastonCountyParser() {
    super(new NCGastonCountyAParser(), new NCGastonCountyBParser());
  }
}
