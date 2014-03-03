package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.GroupBestParser;

public class ILKaneCountyParser extends GroupBestParser {
  
  public ILKaneCountyParser() {
    super(new ILKaneCountyAParser(), new ILKaneCountyBParser());
  }

}
