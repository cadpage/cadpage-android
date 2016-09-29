package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.GroupBestParser;
import net.anei.cadpage.parsers.GroupBlockParser;

/*
 * Marion County, OH
 */

public class OHMahoningCountyParser extends GroupBestParser {
  
  public OHMahoningCountyParser() {
    super(new OHMahoningCountyAParser(), 
        new GroupBlockParser(), new OHMahoningCountyCencommParser());
  }
}
