package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.GroupBestParser;

public class ILWoodfordCountyParser extends GroupBestParser {
  
  public ILWoodfordCountyParser() {
    super(new ILWoodfordCountyAParser(), new ILWoodfordCountyBParser());

  }
}
