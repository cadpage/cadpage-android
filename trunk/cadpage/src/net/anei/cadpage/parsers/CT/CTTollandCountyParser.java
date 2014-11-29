package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.GroupBestParser;


public class CTTollandCountyParser extends GroupBestParser {
  
  public CTTollandCountyParser() {
    super(new CTTollandCountyAParser(), new CTTollandCountyBParser());
  }
}
