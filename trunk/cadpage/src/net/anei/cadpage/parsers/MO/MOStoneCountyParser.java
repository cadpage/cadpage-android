package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.GroupBestParser;


public class MOStoneCountyParser extends GroupBestParser {

  public MOStoneCountyParser() {
    super(new MOStoneCountyAParser(), new MOStoneCountyBParser(), new MOStoneCountyCParser());
  }
}
