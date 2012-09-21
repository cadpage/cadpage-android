package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.GroupBestParser;

/*
Kent County, DE 

 */


public class DEKentCountyParser extends GroupBestParser {
  
  public DEKentCountyParser() {
    super(new DEKentCountyAParser(), new DEKentCountyBParser(), new DEKentCountyCParser());
  }
}


