package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.GroupBestParser;


public class MOBarryCountyParser extends GroupBestParser {

  public MOBarryCountyParser() {
    super(new MOBarryCountyAParser(), new MOBarryCountyBParser());
  }
}
