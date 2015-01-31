package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.GroupBestParser;
import net.anei.cadpage.parsers.GroupBlockParser;


public class NCWakeCountyParser extends GroupBestParser {
  
  public NCWakeCountyParser() {
    super(new NCWakeCountyAParser(), new NCWakeCountyBParser());
  }
}
