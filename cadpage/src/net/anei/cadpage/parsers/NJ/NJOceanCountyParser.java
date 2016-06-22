package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.GroupBestParser;


/*
Ocean County, NJ

*/

public class NJOceanCountyParser extends GroupBestParser {
  
  public NJOceanCountyParser() {
    super(new NJOceanCountyAParser(),
          new NJOceanCountyBParser(),
          new NJOceanCountyCParser());
  }
}
