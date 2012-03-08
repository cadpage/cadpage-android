package net.anei.cadpage.parsers.WI;

import net.anei.cadpage.parsers.GroupBestParser;

/*
Kenosha County, WI

*/


public class WIKenoshaCountyParser extends GroupBestParser {
  
  public WIKenoshaCountyParser() {
    super(new WIKenoshaCountyAParser(), new WIKenoshaCountyBParser());
  }
}
