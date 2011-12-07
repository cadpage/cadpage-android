package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.GroupBestParser;


public class NYErieCountyParser extends GroupBestParser {
  
  public NYErieCountyParser() {
    super(new NYErieCountyAParser(), 
          new NYErieCountyBParser(),
          new NYErieCountyRedAlertParser());
  }
}
