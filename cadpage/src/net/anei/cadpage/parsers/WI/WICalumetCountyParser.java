package net.anei.cadpage.parsers.WI;

import net.anei.cadpage.parsers.GroupBestParser;

/*
Calumet County, WI

*/


public class WICalumetCountyParser extends GroupBestParser {
  public WICalumetCountyParser() {
    super(new WICalumetCountyAParser(), new WICalumetCountyBParser());
  }
}
