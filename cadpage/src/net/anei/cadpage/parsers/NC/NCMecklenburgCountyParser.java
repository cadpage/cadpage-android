package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.GroupBestParser;

/*
Mecklenburg County, NC
*/

public class NCMecklenburgCountyParser extends GroupBestParser {
  
  public NCMecklenburgCountyParser() {
    super(new NCMecklenburgCountyAParser(), new NCMecklenburgCountyBParser());
  }
}
