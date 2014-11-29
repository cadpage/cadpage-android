package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.GroupBestParser;


public class ALJeffersonCountyParser extends GroupBestParser {
  
  public ALJeffersonCountyParser() {
    super(new ALJeffersonCountyAParser(), new ALJeffersonCountyBParser());
  }
}
