package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.GroupBestParser;

public class ILCookCountyParser extends GroupBestParser {
  
  public ILCookCountyParser() {
    super(new ILCookCountyAParser(), new ILCookCountyBParser());

  }
}
