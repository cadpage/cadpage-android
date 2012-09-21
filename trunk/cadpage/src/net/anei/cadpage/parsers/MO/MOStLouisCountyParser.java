package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.GroupBestParser;

/*
St Louis County, MO

*/

public class MOStLouisCountyParser extends GroupBestParser {

  public MOStLouisCountyParser() {
    super(new MOStLouisCountyAParser(), new MOStLouisCountyBParser());
  }
}
