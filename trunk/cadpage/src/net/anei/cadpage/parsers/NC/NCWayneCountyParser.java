package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.GroupBestParser;
import net.anei.cadpage.parsers.GroupBlockParser;


public class NCWayneCountyParser extends GroupBestParser {
  
  public NCWayneCountyParser() {
    super(new NCWayneCountyAParser(), new NCWayneCountyBParser());
  }
}
