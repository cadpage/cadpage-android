package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.GroupBestParser;
import net.anei.cadpage.parsers.GroupBlockParser;


public class SCAndersonCountyParser extends GroupBestParser {
  
  public SCAndersonCountyParser() {
    super(new SCAndersonCountyAParser(), new SCAndersonCountyBParser());
  }
}
