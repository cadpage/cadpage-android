package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.GroupBestParser;

/*
Delaware County, PA

*/

public class PADelawareCountyParser extends GroupBestParser {
  
  public PADelawareCountyParser() {
    super(new PADelawareCountyAParser(), 
          new PADelawareCountyBParser(),
          new PADelawareCountyCParser(),
          new PADelawareCountyDParser(),
          new PADelawareCountyEParser());
  }
}
